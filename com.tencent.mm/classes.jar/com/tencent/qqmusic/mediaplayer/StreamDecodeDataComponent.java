package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;
import java.util.Stack;

class StreamDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
  private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
  private static final String TAG = "StreamDecodeDataComponent";
  private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 5000;
  private long mCurrentFrameCount;
  private boolean mNeedFlush;
  private final Stack<Integer> mSeekRecord;
  private int mTrackBufferSizeInByte;
  
  StreamDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt, IAudioListener paramIAudioListener1, IAudioListener paramIAudioListener2)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt, paramIAudioListener1, paramIAudioListener2);
    AppMethodBeat.i(212358);
    this.mSeekRecord = new Stack();
    this.mCurrentFrameCount = 0L;
    this.mNeedFlush = false;
    AppMethodBeat.o(212358);
  }
  
  private void addSeekRecord(int paramInt)
  {
    AppMethodBeat.i(76486);
    synchronized (this.mSeekRecord)
    {
      Logger.i("StreamDecodeDataComponent", "add seek: ".concat(String.valueOf(paramInt)));
      this.mSeekRecord.push(Integer.valueOf(paramInt));
      AppMethodBeat.o(76486);
      return;
    }
  }
  
  private boolean createAudioTrack()
  {
    AppMethodBeat.i(76485);
    Logger.d("StreamDecodeDataComponent", axiliary("createAudioTrack"));
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StreamDecodeDataComponent", "mState is not preparing");
      callExceptionCallback(91, 54);
      AppMethodBeat.o(76485);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StreamDecodeDataComponent", "mInformation.getSampleRate() failed");
      callExceptionCallback(91, 64);
      AppMethodBeat.o(76485);
      return false;
    }
    int i = 12;
    int i2 = this.mInformation.getChannels();
    if (i2 == 1) {
      i = 4;
    }
    for (;;)
    {
      Logger.d("StreamDecodeDataComponent", axiliary(this.mInformation.toString()));
      for (this.mTargetPlaySample = this.mInformation.getSampleRate(); this.mTargetPlaySample > getMaxSupportSampleRate(); this.mTargetPlaySample /= 2L) {}
      if (i2 == 2) {
        i = 12;
      } else if (i2 == 6) {
        i = 252;
      } else if (i2 == 8) {
        i = 1020;
      }
    }
    int j = this.mInformation.getBitDepth();
    int m = j;
    if (j == 0) {
      m = 2;
    }
    label338:
    int i1;
    int n;
    int k;
    if ((isSupportHighBitDepth()) && (this.mInformation.getBitDepth() >= 3))
    {
      this.mTargetBitDepth = m;
      this.isUseFloatForHighDepth = true;
      if (this.mTargetPlaySample != this.mInformation.getSampleRate())
      {
        Logger.i("StreamDecodeDataComponent", axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
        j = 2;
        if (m != 1) {
          break label1019;
        }
        j = 3;
        i1 = (int)this.mHandleDecodeDataCallback.getMinPcmBufferSize();
        n = getMinBufferSize(this.mTargetPlaySample, i, j, i2, m);
        Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] playback_bufsize:" + n + " decoderBufsizeInByte:" + i1));
        k = n;
        if (this.mLeastCommonMultiple > 1) {
          k = getLcm(this.mLeastCommonMultiple, n);
        }
        n = i1;
        if (k > i1) {
          n = k;
        }
        this.mBuffSize = n;
        Logger.i("StreamDecodeDataComponent", axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mTargetPlaySample: %d, playChannel: %d, pcmEncoding: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mTargetPlaySample), Integer.valueOf(i2), Integer.valueOf(j) })));
        n = Math.max((int)(Math.floor(1L * this.mTargetPlaySample * i2 * 2L / k) + 1.0D), 1);
        Logger.d("StreamDecodeDataComponent", axiliary("times: " + n + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
      }
    }
    for (;;)
    {
      for (;;)
      {
        if (n > 0) {}
        try
        {
          this.mTrackBufferSizeInByte = (k * n);
          setAudioTrack(instantiateAudioTrackCompat(this.mAudioStreamType, (int)this.mTargetPlaySample, i, j, this.mTrackBufferSizeInByte, 1));
          Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] new AudioTrack, sampleRate: " + this.mTargetPlaySample + ", channels: " + i + ", bitDepth: " + m + ", buffer: " + this.mTrackBufferSizeInByte));
          i1 = this.mAudioTrack.getState();
          if (i1 == 1)
          {
            Logger.i("StreamDecodeDataComponent", axiliary("new AudioTrack succeed"));
            if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() != 1)) {
              break label1090;
            }
            Logger.d("StreamDecodeDataComponent", axiliary("create audioTrack success times = ".concat(String.valueOf(n))));
            this.mStateRunner.setAudioTrack(this.mAudioTrack);
            AppMethodBeat.o(76485);
            return true;
            Logger.i("StreamDecodeDataComponent", axiliary("will use float pcm for Hi-Res, bitDept: " + this.mInformation.getBitDepth() + ", sample rate: " + this.mTargetPlaySample));
            break;
            if ((!isSupportHighBitDepth()) && (this.mInformation.getBitDepth() >= 3))
            {
              this.mTargetBitDepth = 2;
              if (this.mTargetPlaySample != this.mInformation.getSampleRate())
              {
                Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
                break;
              }
              Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mInformation.getBitDepth() + ", target bitDept: " + this.mTargetBitDepth));
              break;
            }
            this.mTargetBitDepth = m;
            Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm resampled, bitDept: " + this.mInformation.getBitDepth() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mTargetPlaySample));
            break;
            label1019:
            if (m == 2)
            {
              j = 2;
              break label338;
            }
            if (!this.isUseFloatForHighDepth) {
              break label338;
            }
            j = 4;
            break label338;
          }
          Logger.e("StreamDecodeDataComponent", axiliary("audioTrack create fail!!! state = ".concat(String.valueOf(i1))));
          this.mAudioTrack.release();
        }
        finally
        {
          for (;;)
          {
            Logger.e("StreamDecodeDataComponent", localThrowable);
          }
          this.mCreateAudioTrackFail = true;
          Logger.e("StreamDecodeDataComponent", axiliary("create audioTrack fail mCreateAudioTrackFail = true"));
          setAudioTrack(null);
          callExceptionCallback(92, 66);
          AppMethodBeat.o(76485);
        }
      }
      n -= 2;
    }
    label1090:
    return false;
  }
  
  private long getCalcBitMinSize(AudioInformation paramAudioInformation)
  {
    AppMethodBeat.i(76487);
    if (paramAudioInformation != null)
    {
      long l = ((float)(paramAudioInformation.getSampleRate() * paramAudioInformation.getChannels() * paramAudioInformation.getBitDepth()) * 5.0F / 1000.0F);
      AppMethodBeat.o(76487);
      return l;
    }
    AppMethodBeat.o(76487);
    return 0L;
  }
  
  private int getGcd(int paramInt1, int paramInt2)
  {
    int i;
    for (;;)
    {
      i = paramInt1;
      if (paramInt2 <= 0) {
        break;
      }
      paramInt1 = paramInt2;
      paramInt2 = i % paramInt2;
    }
    return i;
  }
  
  private int getLcm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175619);
    paramInt1 = paramInt1 * paramInt2 / getGcd(paramInt1, paramInt2);
    AppMethodBeat.o(175619);
    return paramInt1;
  }
  
  private BufferInfo initTempBufferInfoIfNeeded(BufferInfo paramBufferInfo, int paramInt)
  {
    AppMethodBeat.i(175617);
    BufferInfo localBufferInfo = paramBufferInfo;
    if (paramBufferInfo == null)
    {
      localBufferInfo = new BufferInfo();
      localBufferInfo.setByteBufferCapacity(paramInt);
    }
    AppMethodBeat.o(175617);
    return localBufferInfo;
  }
  
  private FloatBufferInfo initTempFloatBufferInfoIfNeeded(FloatBufferInfo paramFloatBufferInfo, int paramInt)
  {
    AppMethodBeat.i(175618);
    FloatBufferInfo localFloatBufferInfo = paramFloatBufferInfo;
    if (paramFloatBufferInfo == null)
    {
      localFloatBufferInfo = new FloatBufferInfo();
      localFloatBufferInfo.setFloatBufferCapacity(paramInt);
    }
    AppMethodBeat.o(175618);
    return localFloatBufferInfo;
  }
  
  void flush()
  {
    this.mNeedFlush = true;
  }
  
  int getAudioStreamType()
  {
    return 3;
  }
  
  long getCurPosition()
  {
    AppMethodBeat.i(76489);
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack == null) || (localAudioTrack.getState() == 0))
    {
      l1 = this.mCurPosition;
      AppMethodBeat.o(76489);
      return l1;
    }
    AudioInformation localAudioInformation = this.mInformation;
    if (localAudioInformation == null)
    {
      l1 = this.mCurPosition;
      AppMethodBeat.o(76489);
      return l1;
    }
    long l1 = getAudioTrackPosition(this.mCurrentFrameCount, localAudioTrack);
    long l2 = this.mAudioEffectListener.getActualTime(l1);
    l1 = localAudioInformation.getChannels() * this.mTargetBitDepth;
    l1 = localAudioInformation.getPlaySample() * l1;
    if (l1 > 0L)
    {
      l1 = this.mTrackBufferSizeInByte / l1 * 1000L;
      l1 = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, l1);
      if (l1 >= 0L) {
        break label167;
      }
      this.mCurPosition = l2;
    }
    for (;;)
    {
      l1 = this.mCurPosition;
      AppMethodBeat.o(76489);
      return l1;
      l1 = 0L;
      break;
      label167:
      if ((l2 > 0L) && (Math.abs(l2 - l1) < 5000L)) {
        this.mCurPosition = l2;
      } else {
        this.mCurPosition = l1;
      }
    }
  }
  
  /* Error */
  void handleDecodeData()
  {
    // Byte code:
    //   0: ldc_w 354
    //   3: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   10: ifnull +609 -> 619
    //   13: aload_0
    //   14: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   17: getfield 363	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   20: ifne +599 -> 619
    //   23: lconst_0
    //   24: aload_0
    //   25: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   28: invokevirtual 121	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   31: lcmp
    //   32: iflt +39 -> 71
    //   35: ldc 18
    //   37: ldc_w 365
    //   40: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: aload_0
    //   44: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   47: bipush 9
    //   49: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   52: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   55: pop
    //   56: aload_0
    //   57: bipush 91
    //   59: bipush 63
    //   61: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   64: ldc_w 354
    //   67: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   70: return
    //   71: aload_0
    //   72: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   75: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   78: ifgt +39 -> 117
    //   81: ldc 18
    //   83: ldc_w 371
    //   86: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   93: bipush 9
    //   95: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   101: pop
    //   102: aload_0
    //   103: bipush 91
    //   105: bipush 63
    //   107: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   110: ldc_w 354
    //   113: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   116: return
    //   117: aload_0
    //   118: iconst_1
    //   119: putfield 374	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHasInit	Z
    //   122: aload_0
    //   123: invokespecial 376	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:createAudioTrack	()Z
    //   126: ifne +31 -> 157
    //   129: ldc 18
    //   131: ldc_w 378
    //   134: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: aload_0
    //   138: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   141: bipush 9
    //   143: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   146: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   149: pop
    //   150: ldc_w 354
    //   153: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   162: aload_0
    //   163: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   166: aload_0
    //   167: invokevirtual 380	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:getCurPosition	()J
    //   170: invokevirtual 384	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:initAudioListeners	(ILcom/tencent/qqmusic/mediaplayer/AudioInformation;J)V
    //   173: aload_0
    //   174: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   177: iconst_2
    //   178: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   181: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   184: pop
    //   185: aload_0
    //   186: new 6	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$1
    //   189: dup
    //   190: aload_0
    //   191: invokespecial 387	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$1:<init>	(Lcom/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent;)V
    //   194: iconst_0
    //   195: invokevirtual 391	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:postRunnable	(Ljava/lang/Runnable;I)V
    //   198: aload_0
    //   199: invokevirtual 394	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isPlaying	()Z
    //   202: ifne +57 -> 259
    //   205: aload_0
    //   206: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   209: getfield 363	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   212: ifne +47 -> 259
    //   215: ldc 18
    //   217: aload_0
    //   218: ldc_w 396
    //   221: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   224: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   227: aload_0
    //   228: getfield 400	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSignalControl	Lcom/tencent/qqmusic/mediaplayer/util/WaitNotify;
    //   231: ldc2_w 401
    //   234: bipush 100
    //   236: new 8	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$2
    //   239: dup
    //   240: aload_0
    //   241: invokespecial 403	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$2:<init>	(Lcom/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent;)V
    //   244: invokevirtual 409	com/tencent/qqmusic/mediaplayer/util/WaitNotify:doWait	(JILcom/tencent/qqmusic/mediaplayer/util/WaitNotify$WaitListener;)V
    //   247: ldc 18
    //   249: aload_0
    //   250: ldc_w 411
    //   253: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   256: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: invokestatic 417	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   262: aload_0
    //   263: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   266: invokevirtual 421	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:setCommonPlayerRef	(Lcom/tencent/qqmusic/mediaplayer/CorePlayer;)V
    //   269: aload_0
    //   270: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   273: aload_0
    //   274: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   277: invokevirtual 304	com/tencent/qqmusic/mediaplayer/BufferInfo:setByteBufferCapacity	(I)V
    //   280: iconst_1
    //   281: istore 5
    //   283: iconst_0
    //   284: istore 10
    //   286: iconst_0
    //   287: istore 4
    //   289: iconst_0
    //   290: istore 8
    //   292: iconst_1
    //   293: istore 9
    //   295: iconst_0
    //   296: istore_2
    //   297: aconst_null
    //   298: astore 20
    //   300: aconst_null
    //   301: astore 19
    //   303: iconst_0
    //   304: istore_3
    //   305: lconst_0
    //   306: lstore 11
    //   308: iconst_0
    //   309: istore 6
    //   311: aload_0
    //   312: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   315: getfield 363	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   318: ifne +2394 -> 2712
    //   321: aload_0
    //   322: getfield 429	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSpeedToSet	Ljava/lang/Float;
    //   325: ifnull +83 -> 408
    //   328: aload_0
    //   329: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   332: ifnull +76 -> 408
    //   335: getstatic 434	android/os/Build$VERSION:SDK_INT	I
    //   338: bipush 23
    //   340: if_icmplt +68 -> 408
    //   343: ldc 18
    //   345: aload_0
    //   346: new 153	java/lang/StringBuilder
    //   349: dup
    //   350: ldc_w 436
    //   353: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   356: aload_0
    //   357: getfield 429	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSpeedToSet	Ljava/lang/Float;
    //   360: invokevirtual 439	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   369: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   372: aload_0
    //   373: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   376: invokevirtual 443	android/media/AudioTrack:getPlaybackParams	()Landroid/media/PlaybackParams;
    //   379: astore 21
    //   381: aload 21
    //   383: aload_0
    //   384: getfield 429	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSpeedToSet	Ljava/lang/Float;
    //   387: invokevirtual 449	java/lang/Float:floatValue	()F
    //   390: invokevirtual 455	android/media/PlaybackParams:setSpeed	(F)Landroid/media/PlaybackParams;
    //   393: pop
    //   394: aload_0
    //   395: aconst_null
    //   396: putfield 429	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSpeedToSet	Ljava/lang/Float;
    //   399: aload_0
    //   400: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   403: aload 21
    //   405: invokevirtual 459	android/media/AudioTrack:setPlaybackParams	(Landroid/media/PlaybackParams;)V
    //   408: iconst_m1
    //   409: istore_1
    //   410: aload_0
    //   411: getfield 46	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSeekRecord	Ljava/util/Stack;
    //   414: astore 21
    //   416: aload 21
    //   418: monitorenter
    //   419: aload_0
    //   420: getfield 46	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSeekRecord	Ljava/util/Stack;
    //   423: invokevirtual 462	java/util/Stack:empty	()Z
    //   426: ifne +52 -> 478
    //   429: aload_0
    //   430: getfield 46	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSeekRecord	Ljava/util/Stack;
    //   433: invokevirtual 466	java/util/Stack:pop	()Ljava/lang/Object;
    //   436: checkcast 75	java/lang/Integer
    //   439: invokevirtual 469	java/lang/Integer:intValue	()I
    //   442: istore_1
    //   443: aload_0
    //   444: getfield 46	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mSeekRecord	Ljava/util/Stack;
    //   447: invokevirtual 472	java/util/Stack:clear	()V
    //   450: ldc 18
    //   452: new 153	java/lang/StringBuilder
    //   455: dup
    //   456: ldc_w 474
    //   459: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   462: iload_1
    //   463: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   466: ldc_w 476
    //   469: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   478: aload 21
    //   480: monitorexit
    //   481: iload_1
    //   482: istore 7
    //   484: iload_1
    //   485: ifge +51 -> 536
    //   488: iload_1
    //   489: istore 7
    //   491: aload_0
    //   492: getfield 50	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mNeedFlush	Z
    //   495: ifeq +41 -> 536
    //   498: aload_0
    //   499: getfield 48	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCurrentFrameCount	J
    //   502: aload_0
    //   503: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   506: invokestatic 324	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:getAudioTrackPosition	(JLandroid/media/AudioTrack;)I
    //   509: istore 7
    //   511: ldc 18
    //   513: aload_0
    //   514: ldc_w 478
    //   517: iload 7
    //   519: invokestatic 64	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   522: invokevirtual 68	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   525: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   528: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   531: aload_0
    //   532: iconst_0
    //   533: putfield 50	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mNeedFlush	Z
    //   536: iload 4
    //   538: istore_1
    //   539: iload 7
    //   541: iflt +238 -> 779
    //   544: aload_0
    //   545: getfield 177	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHandleDecodeDataCallback	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;
    //   548: iload 7
    //   550: invokeinterface 482 2 0
    //   555: istore_1
    //   556: iload_1
    //   557: ifge +126 -> 683
    //   560: ldc 18
    //   562: aload_0
    //   563: ldc_w 484
    //   566: iload_1
    //   567: invokestatic 64	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   570: invokevirtual 68	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   573: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   576: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   579: aload_0
    //   580: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   583: bipush 9
    //   585: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   588: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   591: pop
    //   592: aload_0
    //   593: bipush 95
    //   595: bipush 74
    //   597: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   600: ldc_w 354
    //   603: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: return
    //   607: astore 19
    //   609: ldc 18
    //   611: aload 19
    //   613: invokestatic 281	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   616: goto -443 -> 173
    //   619: aload_0
    //   620: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   623: getfield 363	com/tencent/qqmusic/mediaplayer/CorePlayer:mIsExit	Z
    //   626: ifne +36 -> 662
    //   629: ldc 18
    //   631: aload_0
    //   632: ldc_w 486
    //   635: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   638: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   641: aload_0
    //   642: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   645: bipush 9
    //   647: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   650: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   653: pop
    //   654: aload_0
    //   655: bipush 91
    //   657: bipush 63
    //   659: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   662: ldc_w 354
    //   665: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   668: return
    //   669: astore 19
    //   671: aload 21
    //   673: monitorexit
    //   674: ldc_w 354
    //   677: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   680: aload 19
    //   682: athrow
    //   683: iload 4
    //   685: istore_1
    //   686: aload_0
    //   687: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   690: ifnull +60 -> 750
    //   693: aload_0
    //   694: iload 7
    //   696: i2d
    //   697: ldc2_w 487
    //   700: ddiv
    //   701: aload_0
    //   702: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   705: invokevirtual 490	android/media/AudioTrack:getSampleRate	()I
    //   708: i2d
    //   709: dmul
    //   710: invokestatic 494	java/lang/Math:round	(D)J
    //   713: putfield 48	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCurrentFrameCount	J
    //   716: aload_0
    //   717: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   720: invokevirtual 497	android/media/AudioTrack:getPlayState	()I
    //   723: iconst_3
    //   724: if_icmpne +128 -> 852
    //   727: aload_0
    //   728: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   731: invokevirtual 500	android/media/AudioTrack:pause	()V
    //   734: aload_0
    //   735: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   738: invokevirtual 502	android/media/AudioTrack:flush	()V
    //   741: aload_0
    //   742: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   745: invokevirtual 505	android/media/AudioTrack:play	()V
    //   748: iconst_0
    //   749: istore_1
    //   750: aload_0
    //   751: iload 7
    //   753: i2l
    //   754: putfield 320	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCurPosition	J
    //   757: aload_0
    //   758: iload 7
    //   760: i2l
    //   761: invokevirtual 509	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:notifySeekCompleteForAudioListeners	(J)V
    //   764: aload_0
    //   765: getfield 513	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   768: aload_0
    //   769: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   772: iload 7
    //   774: invokeinterface 519 3 0
    //   779: aload_0
    //   780: invokevirtual 522	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isPaused	()Z
    //   783: ifeq +79 -> 862
    //   786: aload_0
    //   787: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   790: invokevirtual 497	android/media/AudioTrack:getPlayState	()I
    //   793: iconst_2
    //   794: if_icmpeq +10 -> 804
    //   797: aload_0
    //   798: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   801: invokevirtual 500	android/media/AudioTrack:pause	()V
    //   804: aload_0
    //   805: new 10	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$3
    //   808: dup
    //   809: aload_0
    //   810: invokespecial 523	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent$3:<init>	(Lcom/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent;)V
    //   813: bipush 20
    //   815: invokevirtual 391	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:postRunnable	(Ljava/lang/Runnable;I)V
    //   818: ldc 18
    //   820: aload_0
    //   821: ldc_w 525
    //   824: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   827: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   830: aload_0
    //   831: invokevirtual 528	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:doWaitForPaused	()V
    //   834: ldc 18
    //   836: aload_0
    //   837: ldc_w 530
    //   840: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   843: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   846: iload_1
    //   847: istore 4
    //   849: goto -538 -> 311
    //   852: aload_0
    //   853: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   856: invokevirtual 502	android/media/AudioTrack:flush	()V
    //   859: goto -111 -> 748
    //   862: aload_0
    //   863: invokevirtual 533	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isIdle	()Z
    //   866: ifne +1846 -> 2712
    //   869: aload_0
    //   870: invokevirtual 536	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isError	()Z
    //   873: ifne +1839 -> 2712
    //   876: aload_0
    //   877: invokevirtual 539	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isStopped	()Z
    //   880: ifne +1832 -> 2712
    //   883: aload_0
    //   884: invokevirtual 542	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isCompleted	()Z
    //   887: ifeq +168 -> 1055
    //   890: iload_1
    //   891: aload_0
    //   892: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   895: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   898: idiv
    //   899: iload 8
    //   901: isub
    //   902: istore_2
    //   903: iload_2
    //   904: ifle +128 -> 1032
    //   907: aload_0
    //   908: getfield 228	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTrackBufferSizeInByte	I
    //   911: aload_0
    //   912: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   915: idiv
    //   916: aload_0
    //   917: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   920: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   923: idiv
    //   924: istore_3
    //   925: iload_2
    //   926: iload_3
    //   927: if_icmpge +110 -> 1037
    //   930: iload_2
    //   931: sipush 1000
    //   934: imul
    //   935: i2l
    //   936: aload_0
    //   937: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   940: invokevirtual 121	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   943: ldiv
    //   944: l2i
    //   945: istore_2
    //   946: getstatic 547	com/tencent/qqmusic/mediaplayer/AudioPlayerConfigure:minAudioTrackWaitTimeMs	I
    //   949: istore_3
    //   950: ldc 18
    //   952: aload_0
    //   953: new 153	java/lang/StringBuilder
    //   956: dup
    //   957: ldc_w 549
    //   960: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   963: iload_1
    //   964: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   967: ldc_w 551
    //   970: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   973: iload 8
    //   975: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   978: ldc_w 553
    //   981: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   984: iload_2
    //   985: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   988: ldc_w 555
    //   991: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   994: iload_3
    //   995: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   998: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1001: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1004: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1007: iload_2
    //   1008: ifle +1704 -> 2712
    //   1011: aload_0
    //   1012: monitorenter
    //   1013: aload_0
    //   1014: iload_3
    //   1015: iload_2
    //   1016: invokestatic 222	java/lang/Math:max	(II)I
    //   1019: i2l
    //   1020: invokevirtual 558	java/lang/Object:wait	(J)V
    //   1023: aload_0
    //   1024: monitorexit
    //   1025: ldc_w 354
    //   1028: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1031: return
    //   1032: iconst_0
    //   1033: istore_2
    //   1034: goto -127 -> 907
    //   1037: iload_3
    //   1038: istore_2
    //   1039: goto -109 -> 930
    //   1042: astore 19
    //   1044: aload_0
    //   1045: monitorexit
    //   1046: ldc_w 354
    //   1049: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1052: aload 19
    //   1054: athrow
    //   1055: aload_0
    //   1056: invokevirtual 394	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isPlaying	()Z
    //   1059: ifeq +21 -> 1080
    //   1062: aload_0
    //   1063: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   1066: invokevirtual 497	android/media/AudioTrack:getPlayState	()I
    //   1069: iconst_3
    //   1070: if_icmpeq +10 -> 1080
    //   1073: aload_0
    //   1074: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   1077: invokevirtual 505	android/media/AudioTrack:play	()V
    //   1080: invokestatic 563	java/lang/System:currentTimeMillis	()J
    //   1083: lstore 15
    //   1085: iload 9
    //   1087: ifeq +1643 -> 2730
    //   1090: iload_2
    //   1091: ifeq +344 -> 1435
    //   1094: ldc 18
    //   1096: aload_0
    //   1097: new 153	java/lang/StringBuilder
    //   1100: dup
    //   1101: ldc_w 565
    //   1104: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1107: aload_0
    //   1108: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1111: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1114: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1117: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1120: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: ldc 18
    //   1125: aload_0
    //   1126: ldc_w 567
    //   1129: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1132: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1135: iconst_0
    //   1136: istore_3
    //   1137: aload_0
    //   1138: iconst_1
    //   1139: putfield 570	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHasDecode	Z
    //   1142: iload_3
    //   1143: istore 4
    //   1145: lload 11
    //   1147: lstore 13
    //   1149: iload 6
    //   1151: istore 7
    //   1153: iload 6
    //   1155: ifne +433 -> 1588
    //   1158: bipush 10
    //   1160: istore 6
    //   1162: aload_0
    //   1163: aload_0
    //   1164: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1167: invokespecial 572	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:getCalcBitMinSize	(Lcom/tencent/qqmusic/mediaplayer/AudioInformation;)J
    //   1170: lstore 17
    //   1172: ldc 18
    //   1174: aload_0
    //   1175: new 153	java/lang/StringBuilder
    //   1178: dup
    //   1179: ldc_w 574
    //   1182: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1185: lload 17
    //   1187: invokevirtual 170	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1190: ldc_w 576
    //   1193: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1196: aload_0
    //   1197: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1200: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1203: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1206: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1209: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1212: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1215: iload_3
    //   1216: istore 4
    //   1218: lload 11
    //   1220: lstore 13
    //   1222: lload 17
    //   1224: lconst_0
    //   1225: lcmp
    //   1226: ifle +254 -> 1480
    //   1229: iload_3
    //   1230: istore 4
    //   1232: lload 11
    //   1234: lstore 13
    //   1236: aload_0
    //   1237: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1240: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1243: i2l
    //   1244: lload 17
    //   1246: lcmp
    //   1247: ifge +233 -> 1480
    //   1250: iload_3
    //   1251: istore 4
    //   1253: lload 11
    //   1255: lstore 13
    //   1257: iload 6
    //   1259: iflt +221 -> 1480
    //   1262: aload_0
    //   1263: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1266: aload_0
    //   1267: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1270: invokevirtual 582	com/tencent/qqmusic/mediaplayer/BufferInfo:setTempByteBufferCapacity	(I)V
    //   1273: aload_0
    //   1274: getfield 177	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHandleDecodeDataCallback	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;
    //   1277: aload_0
    //   1278: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1281: aload_0
    //   1282: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1285: getfield 586	com/tencent/qqmusic/mediaplayer/BufferInfo:tempByteBuffer	[B
    //   1288: invokeinterface 590 3 0
    //   1293: istore_3
    //   1294: lload 11
    //   1296: lstore 13
    //   1298: iload_3
    //   1299: ifle +44 -> 1343
    //   1302: aload_0
    //   1303: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1306: aload_0
    //   1307: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1310: getfield 586	com/tencent/qqmusic/mediaplayer/BufferInfo:tempByteBuffer	[B
    //   1313: iconst_0
    //   1314: iload_3
    //   1315: invokevirtual 594	com/tencent/qqmusic/mediaplayer/BufferInfo:appendByte	([BII)V
    //   1318: aload_0
    //   1319: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1322: astore 21
    //   1324: aload 21
    //   1326: aload 21
    //   1328: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1331: iload_3
    //   1332: iadd
    //   1333: putfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1336: lload 11
    //   1338: iload_3
    //   1339: i2l
    //   1340: ladd
    //   1341: lstore 13
    //   1343: iload 6
    //   1345: iconst_1
    //   1346: isub
    //   1347: istore 6
    //   1349: ldc 18
    //   1351: aload_0
    //   1352: new 153	java/lang/StringBuilder
    //   1355: dup
    //   1356: ldc_w 596
    //   1359: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1362: iload_3
    //   1363: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1366: ldc_w 576
    //   1369: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: aload_0
    //   1373: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1376: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1379: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1382: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1385: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1388: invokestatic 92	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1391: lload 13
    //   1393: lstore 11
    //   1395: goto -166 -> 1229
    //   1398: astore 19
    //   1400: ldc 18
    //   1402: aload 19
    //   1404: invokestatic 281	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   1407: aload_0
    //   1408: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   1411: bipush 9
    //   1413: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1416: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   1419: pop
    //   1420: aload_0
    //   1421: bipush 92
    //   1423: bipush 62
    //   1425: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   1428: ldc_w 354
    //   1431: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1434: return
    //   1435: aload_0
    //   1436: getfield 177	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHandleDecodeDataCallback	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;
    //   1439: aload_0
    //   1440: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1443: aload_0
    //   1444: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1447: getfield 599	com/tencent/qqmusic/mediaplayer/BufferInfo:byteBuffer	[B
    //   1450: invokeinterface 590 3 0
    //   1455: istore_3
    //   1456: aload_0
    //   1457: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1460: iload_3
    //   1461: putfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1464: aload_0
    //   1465: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1468: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1471: i2l
    //   1472: lload 11
    //   1474: ladd
    //   1475: lstore 11
    //   1477: goto -340 -> 1137
    //   1480: aload_0
    //   1481: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1484: invokevirtual 142	com/tencent/qqmusic/mediaplayer/AudioInformation:getBitDepth	()I
    //   1487: ifne +75 -> 1562
    //   1490: aload_0
    //   1491: lload 13
    //   1493: aload_0
    //   1494: getfield 177	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHandleDecodeDataCallback	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;
    //   1497: invokeinterface 342 1 0
    //   1502: aload_0
    //   1503: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1506: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   1509: aload_0
    //   1510: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1513: invokevirtual 121	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   1516: invokestatic 605	com/tencent/qqmusic/mediaplayer/AudioRecognition:calcBitDept	(JJIJ)I
    //   1519: putfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   1522: aload_0
    //   1523: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1526: aload_0
    //   1527: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   1530: invokevirtual 608	com/tencent/qqmusic/mediaplayer/AudioInformation:setBitDept	(I)V
    //   1533: ldc 18
    //   1535: aload_0
    //   1536: new 153	java/lang/StringBuilder
    //   1539: dup
    //   1540: ldc_w 610
    //   1543: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1546: aload_0
    //   1547: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   1550: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1553: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1556: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1559: invokestatic 613	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   1562: aload_0
    //   1563: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   1566: istore 7
    //   1568: ldc 18
    //   1570: aload_0
    //   1571: ldc_w 615
    //   1574: iload 7
    //   1576: invokestatic 64	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1579: invokevirtual 68	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1582: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   1585: invokestatic 92	com/tencent/qqmusic/mediaplayer/util/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1588: lload 13
    //   1590: lstore 11
    //   1592: iload 7
    //   1594: istore 6
    //   1596: aload_0
    //   1597: getfield 618	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mNeedChangePlayThreadPriority	Z
    //   1600: ifeq +14 -> 1614
    //   1603: aload_0
    //   1604: iconst_0
    //   1605: putfield 618	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mNeedChangePlayThreadPriority	Z
    //   1608: invokestatic 417	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:getInstance	()Lcom/tencent/qqmusic/mediaplayer/PlayerConfigManager;
    //   1611: invokevirtual 621	com/tencent/qqmusic/mediaplayer/PlayerConfigManager:changeDecodeThreadPriorityIfNeed	()V
    //   1614: aload_0
    //   1615: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1618: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   1621: ifle +1069 -> 2690
    //   1624: aload_0
    //   1625: getfield 624	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHasDecodeSuccess	Z
    //   1628: ifne +21 -> 1649
    //   1631: aload_0
    //   1632: getfield 513	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCallback	Lcom/tencent/qqmusic/mediaplayer/PlayerCallback;
    //   1635: aload_0
    //   1636: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   1639: invokeinterface 627 2 0
    //   1644: aload_0
    //   1645: iconst_1
    //   1646: putfield 624	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHasDecodeSuccess	Z
    //   1649: aload 20
    //   1651: astore 21
    //   1653: iload_2
    //   1654: ifne +1065 -> 2719
    //   1657: aload 20
    //   1659: astore 21
    //   1661: aload_0
    //   1662: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   1665: aload_0
    //   1666: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1669: invokevirtual 142	com/tencent/qqmusic/mediaplayer/AudioInformation:getBitDepth	()I
    //   1672: if_icmpeq +46 -> 1718
    //   1675: aload 20
    //   1677: astore 21
    //   1679: aload_0
    //   1680: getfield 151	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isUseFloatForHighDepth	Z
    //   1683: ifne +35 -> 1718
    //   1686: aload_0
    //   1687: aload 20
    //   1689: aload_0
    //   1690: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1693: invokespecial 629	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:initTempBufferInfoIfNeeded	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;I)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1696: astore 21
    //   1698: aload_0
    //   1699: aload_0
    //   1700: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1703: aload 21
    //   1705: invokevirtual 633	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:handleHighBitDepth	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)V
    //   1708: aload 21
    //   1710: aload_0
    //   1711: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1714: invokevirtual 637	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1717: pop
    //   1718: aload 21
    //   1720: astore 20
    //   1722: aload_0
    //   1723: getfield 134	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetPlaySample	J
    //   1726: aload_0
    //   1727: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1730: invokevirtual 121	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   1733: lcmp
    //   1734: ifeq +35 -> 1769
    //   1737: aload_0
    //   1738: aload 21
    //   1740: aload_0
    //   1741: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   1744: invokespecial 629	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:initTempBufferInfoIfNeeded	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;I)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1747: astore 20
    //   1749: aload_0
    //   1750: aload_0
    //   1751: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1754: aload 20
    //   1756: invokevirtual 640	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:handleHighSample	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)V
    //   1759: aload 20
    //   1761: aload_0
    //   1762: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1765: invokevirtual 637	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1768: pop
    //   1769: aload_0
    //   1770: getfield 151	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isUseFloatForHighDepth	Z
    //   1773: ifeq +327 -> 2100
    //   1776: aload_0
    //   1777: aload_0
    //   1778: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   1781: aload_0
    //   1782: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1785: invokevirtual 648	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:convertBytePcmToFloatPcm	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;)V
    //   1788: aload 20
    //   1790: astore 21
    //   1792: aload_0
    //   1793: getfield 328	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   1796: invokeinterface 651 1 0
    //   1801: ifeq +918 -> 2719
    //   1804: aload_0
    //   1805: aload 19
    //   1807: aload_0
    //   1808: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1811: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   1814: invokespecial 654	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:initTempFloatBufferInfoIfNeeded	(Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;I)Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1817: astore 21
    //   1819: aload_0
    //   1820: getfield 328	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   1823: aload_0
    //   1824: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1827: aload 21
    //   1829: aload_0
    //   1830: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   1833: invokevirtual 655	com/tencent/qqmusic/mediaplayer/CorePlayer:getCurPositionByDecoder	()J
    //   1836: invokeinterface 659 5 0
    //   1841: pop
    //   1842: aload_0
    //   1843: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1846: aload 21
    //   1848: getfield 663	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:floatBuffer	[F
    //   1851: aload 21
    //   1853: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   1856: invokevirtual 667	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:fillFloat	([FI)V
    //   1859: aload 20
    //   1861: astore 19
    //   1863: aload 21
    //   1865: astore 20
    //   1867: aload_0
    //   1868: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   1871: ifnull +873 -> 2744
    //   1874: aload_0
    //   1875: invokevirtual 394	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isPlaying	()Z
    //   1878: ifeq +866 -> 2744
    //   1881: iconst_0
    //   1882: istore 7
    //   1884: iload 7
    //   1886: istore_3
    //   1887: iload_2
    //   1888: ifne +52 -> 1940
    //   1891: iload 7
    //   1893: istore_3
    //   1894: aload_0
    //   1895: getfield 670	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTerminalAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   1898: invokeinterface 651 1 0
    //   1903: ifeq +37 -> 1940
    //   1906: aload_0
    //   1907: getfield 151	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isUseFloatForHighDepth	Z
    //   1910: ifeq +262 -> 2172
    //   1913: aload_0
    //   1914: getfield 670	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTerminalAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   1917: aload_0
    //   1918: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1921: aload_0
    //   1922: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1925: aload_0
    //   1926: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   1929: invokevirtual 655	com/tencent/qqmusic/mediaplayer/CorePlayer:getCurPositionByDecoder	()J
    //   1932: invokeinterface 659 5 0
    //   1937: pop
    //   1938: iconst_1
    //   1939: istore_3
    //   1940: iload_3
    //   1941: ifne +795 -> 2736
    //   1944: invokestatic 563	java/lang/System:currentTimeMillis	()J
    //   1947: lload 15
    //   1949: lsub
    //   1950: lstore 15
    //   1952: aload_0
    //   1953: getfield 151	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:isUseFloatForHighDepth	Z
    //   1956: ifeq +462 -> 2418
    //   1959: getstatic 434	android/os/Build$VERSION:SDK_INT	I
    //   1962: bipush 21
    //   1964: if_icmplt +454 -> 2418
    //   1967: aload_0
    //   1968: aload_0
    //   1969: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1972: getfield 663	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:floatBuffer	[F
    //   1975: aload_0
    //   1976: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   1979: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   1982: aload_0
    //   1983: getfield 134	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetPlaySample	J
    //   1986: invokevirtual 674	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:calculatePcmPlayTime	([FIJ)J
    //   1989: lstore 13
    //   1991: aload_0
    //   1992: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   1995: aload_0
    //   1996: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   1999: getfield 663	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:floatBuffer	[F
    //   2002: iconst_0
    //   2003: aload_0
    //   2004: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   2007: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   2010: iconst_0
    //   2011: invokevirtual 678	android/media/AudioTrack:write	([FIII)I
    //   2014: istore_3
    //   2015: iload_3
    //   2016: ifge +287 -> 2303
    //   2019: aload_0
    //   2020: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2023: invokevirtual 497	android/media/AudioTrack:getPlayState	()I
    //   2026: iconst_3
    //   2027: if_icmpne +173 -> 2200
    //   2030: ldc 18
    //   2032: aload_0
    //   2033: new 153	java/lang/StringBuilder
    //   2036: dup
    //   2037: ldc_w 680
    //   2040: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2043: iload_3
    //   2044: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2047: ldc_w 682
    //   2050: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: aload_0
    //   2054: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   2057: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   2060: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2063: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2066: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2069: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2072: aload_0
    //   2073: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   2076: bipush 9
    //   2078: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2081: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   2084: pop
    //   2085: aload_0
    //   2086: bipush 92
    //   2088: bipush 102
    //   2090: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   2093: ldc_w 354
    //   2096: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2099: return
    //   2100: aload 20
    //   2102: astore 21
    //   2104: aload_0
    //   2105: getfield 328	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   2108: invokeinterface 651 1 0
    //   2113: ifeq +606 -> 2719
    //   2116: aload_0
    //   2117: aload 20
    //   2119: aload_0
    //   2120: getfield 200	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mBuffSize	I
    //   2123: invokespecial 629	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:initTempBufferInfoIfNeeded	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;I)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2126: astore 21
    //   2128: aload_0
    //   2129: getfield 328	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   2132: aload_0
    //   2133: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2136: aload 21
    //   2138: aload_0
    //   2139: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   2142: invokevirtual 655	com/tencent/qqmusic/mediaplayer/CorePlayer:getCurPositionByDecoder	()J
    //   2145: invokeinterface 685 5 0
    //   2150: pop
    //   2151: aload 21
    //   2153: aload_0
    //   2154: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2157: invokevirtual 637	com/tencent/qqmusic/mediaplayer/BufferInfo:fillInto	(Lcom/tencent/qqmusic/mediaplayer/BufferInfo;)Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2160: pop
    //   2161: aload 19
    //   2163: astore 20
    //   2165: aload 21
    //   2167: astore 19
    //   2169: goto -302 -> 1867
    //   2172: aload_0
    //   2173: getfield 670	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTerminalAudioEffectListener	Lcom/tencent/qqmusic/mediaplayer/audiofx/IAudioListener;
    //   2176: aload_0
    //   2177: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2180: aload_0
    //   2181: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2184: aload_0
    //   2185: getfield 358	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mCorePlayer	Lcom/tencent/qqmusic/mediaplayer/CorePlayer;
    //   2188: invokevirtual 655	com/tencent/qqmusic/mediaplayer/CorePlayer:getCurPositionByDecoder	()J
    //   2191: invokeinterface 685 5 0
    //   2196: pop
    //   2197: goto -259 -> 1938
    //   2200: iconst_0
    //   2201: istore_3
    //   2202: ldc 18
    //   2204: aload_0
    //   2205: ldc_w 687
    //   2208: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2211: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2214: lload 13
    //   2216: lconst_0
    //   2217: lcmp
    //   2218: ifle +466 -> 2684
    //   2221: lload 15
    //   2223: lload 13
    //   2225: lcmp
    //   2226: ifle +458 -> 2684
    //   2229: iload 5
    //   2231: ifne +453 -> 2684
    //   2234: getstatic 693	com/tencent/qqmusic/mediaplayer/PlayStuckMonitor:INSTANCE	Lcom/tencent/qqmusic/mediaplayer/PlayStuckMonitor;
    //   2237: lload 15
    //   2239: lload 13
    //   2241: iload 10
    //   2243: invokevirtual 697	com/tencent/qqmusic/mediaplayer/PlayStuckMonitor:onPlayStuck	(JJZ)V
    //   2246: iconst_1
    //   2247: istore 10
    //   2249: aload_0
    //   2250: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2253: invokestatic 703	com/tencent/qqmusic/mediaplayer/utils/AudioUtil:getPlaybackHeadPositionSafely	(Landroid/media/AudioTrack;)I
    //   2256: istore 8
    //   2258: iload_2
    //   2259: istore 5
    //   2261: iconst_0
    //   2262: istore_2
    //   2263: iload_3
    //   2264: istore 9
    //   2266: iload 5
    //   2268: istore_3
    //   2269: aload 19
    //   2271: astore 21
    //   2273: iload_3
    //   2274: istore 5
    //   2276: iload 4
    //   2278: istore_3
    //   2279: iload_2
    //   2280: istore 7
    //   2282: aload 20
    //   2284: astore 19
    //   2286: aload 21
    //   2288: astore 20
    //   2290: iload 5
    //   2292: istore_2
    //   2293: iload_1
    //   2294: istore 4
    //   2296: iload 7
    //   2298: istore 5
    //   2300: goto -1989 -> 311
    //   2303: iconst_1
    //   2304: istore 7
    //   2306: iload_3
    //   2307: aload_0
    //   2308: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   2311: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   2314: if_icmpeq +94 -> 2408
    //   2317: ldc 18
    //   2319: aload_0
    //   2320: new 153	java/lang/StringBuilder
    //   2323: dup
    //   2324: ldc_w 705
    //   2327: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2330: iload_3
    //   2331: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2334: ldc_w 682
    //   2337: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2340: aload_0
    //   2341: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   2344: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   2347: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2350: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2356: invokestatic 613	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2359: iload_3
    //   2360: ifne +41 -> 2401
    //   2363: ldc 18
    //   2365: aload_0
    //   2366: ldc_w 707
    //   2369: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2372: invokestatic 613	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2375: iconst_1
    //   2376: istore_2
    //   2377: iload_3
    //   2378: ifle +35 -> 2413
    //   2381: aload_0
    //   2382: getfield 644	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mFloatBufferInfo	Lcom/tencent/qqmusic/mediaplayer/FloatBufferInfo;
    //   2385: getfield 652	com/tencent/qqmusic/mediaplayer/FloatBufferInfo:bufferSize	I
    //   2388: iconst_2
    //   2389: imul
    //   2390: istore_3
    //   2391: iload_1
    //   2392: iload_3
    //   2393: iadd
    //   2394: istore_1
    //   2395: iload 7
    //   2397: istore_3
    //   2398: goto -184 -> 2214
    //   2401: aload_0
    //   2402: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2405: invokevirtual 502	android/media/AudioTrack:flush	()V
    //   2408: iconst_0
    //   2409: istore_2
    //   2410: goto -33 -> 2377
    //   2413: iconst_0
    //   2414: istore_3
    //   2415: goto -24 -> 2391
    //   2418: aload_0
    //   2419: aload_0
    //   2420: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2423: getfield 599	com/tencent/qqmusic/mediaplayer/BufferInfo:byteBuffer	[B
    //   2426: aload_0
    //   2427: getfield 115	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mInformation	Lcom/tencent/qqmusic/mediaplayer/AudioInformation;
    //   2430: invokevirtual 127	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   2433: aload_0
    //   2434: getfield 148	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetBitDepth	I
    //   2437: aload_0
    //   2438: getfield 134	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mTargetPlaySample	J
    //   2441: invokevirtual 710	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:calculatePcmPlayTime	([BIIJ)J
    //   2444: lstore 13
    //   2446: aload_0
    //   2447: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2450: aload_0
    //   2451: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2454: getfield 599	com/tencent/qqmusic/mediaplayer/BufferInfo:byteBuffer	[B
    //   2457: iconst_0
    //   2458: aload_0
    //   2459: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2462: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   2465: invokevirtual 713	android/media/AudioTrack:write	([BII)I
    //   2468: istore_3
    //   2469: iload_3
    //   2470: ifge +101 -> 2571
    //   2473: aload_0
    //   2474: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2477: invokevirtual 497	android/media/AudioTrack:getPlayState	()I
    //   2480: iconst_3
    //   2481: if_icmpne +73 -> 2554
    //   2484: ldc 18
    //   2486: aload_0
    //   2487: new 153	java/lang/StringBuilder
    //   2490: dup
    //   2491: ldc_w 715
    //   2494: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2497: iload_3
    //   2498: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2501: ldc_w 682
    //   2504: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2507: aload_0
    //   2508: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2511: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   2514: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2517: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2520: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2523: invokestatic 107	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2526: aload_0
    //   2527: getfield 96	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mStateRunner	Lcom/tencent/qqmusic/mediaplayer/PlayerStateRunner;
    //   2530: bipush 9
    //   2532: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2535: invokevirtual 369	com/tencent/qqmusic/mediaplayer/PlayerStateRunner:transfer	(Ljava/lang/Integer;)Ljava/lang/Integer;
    //   2538: pop
    //   2539: aload_0
    //   2540: bipush 92
    //   2542: bipush 102
    //   2544: invokevirtual 111	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:callExceptionCallback	(II)V
    //   2547: ldc_w 354
    //   2550: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2553: return
    //   2554: iconst_0
    //   2555: istore_3
    //   2556: ldc 18
    //   2558: aload_0
    //   2559: ldc_w 687
    //   2562: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2565: invokestatic 73	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2568: goto -354 -> 2214
    //   2571: iconst_1
    //   2572: istore 7
    //   2574: iload_3
    //   2575: aload_0
    //   2576: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2579: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   2582: if_icmpeq +92 -> 2674
    //   2585: ldc 18
    //   2587: aload_0
    //   2588: new 153	java/lang/StringBuilder
    //   2591: dup
    //   2592: ldc_w 717
    //   2595: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2598: iload_3
    //   2599: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2602: ldc_w 682
    //   2605: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2608: aload_0
    //   2609: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2612: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   2615: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2618: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2621: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2624: invokestatic 613	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2627: iload_3
    //   2628: ifne +39 -> 2667
    //   2631: ldc 18
    //   2633: aload_0
    //   2634: ldc_w 707
    //   2637: invokevirtual 89	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:axiliary	(Ljava/lang/String;)Ljava/lang/String;
    //   2640: invokestatic 613	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   2643: iconst_1
    //   2644: istore_2
    //   2645: iload_3
    //   2646: ifle +33 -> 2679
    //   2649: aload_0
    //   2650: getfield 425	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mDecodeBufferInfo	Lcom/tencent/qqmusic/mediaplayer/BufferInfo;
    //   2653: getfield 579	com/tencent/qqmusic/mediaplayer/BufferInfo:bufferSize	I
    //   2656: istore_3
    //   2657: iload_1
    //   2658: iload_3
    //   2659: iadd
    //   2660: istore_1
    //   2661: iload 7
    //   2663: istore_3
    //   2664: goto -450 -> 2214
    //   2667: aload_0
    //   2668: getfield 251	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mAudioTrack	Landroid/media/AudioTrack;
    //   2671: invokevirtual 502	android/media/AudioTrack:flush	()V
    //   2674: iconst_0
    //   2675: istore_2
    //   2676: goto -31 -> 2645
    //   2679: iconst_0
    //   2680: istore_3
    //   2681: goto -24 -> 2657
    //   2684: iconst_0
    //   2685: istore 10
    //   2687: goto -438 -> 2249
    //   2690: aload_0
    //   2691: getfield 177	com/tencent/qqmusic/mediaplayer/StreamDecodeDataComponent:mHandleDecodeDataCallback	Lcom/tencent/qqmusic/mediaplayer/BaseDecodeDataComponent$HandleDecodeDataCallback;
    //   2694: iload 4
    //   2696: bipush 92
    //   2698: invokeinterface 720 3 0
    //   2703: iload 4
    //   2705: istore_3
    //   2706: iload_1
    //   2707: istore 4
    //   2709: goto -2398 -> 311
    //   2712: ldc_w 354
    //   2715: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2718: return
    //   2719: aload 19
    //   2721: astore 20
    //   2723: aload 21
    //   2725: astore 19
    //   2727: goto -860 -> 1867
    //   2730: iload_3
    //   2731: istore 4
    //   2733: goto -1137 -> 1596
    //   2736: iload_2
    //   2737: istore_3
    //   2738: iload 5
    //   2740: istore_2
    //   2741: goto -472 -> 2269
    //   2744: aload 19
    //   2746: astore 21
    //   2748: aload 20
    //   2750: astore 19
    //   2752: aload 21
    //   2754: astore 20
    //   2756: goto -53 -> 2703
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2759	0	this	StreamDecodeDataComponent
    //   409	2298	1	i	int
    //   296	2445	2	j	int
    //   304	2434	3	k	int
    //   287	2445	4	m	int
    //   281	2458	5	n	int
    //   309	1286	6	i1	int
    //   482	2180	7	i2	int
    //   290	1967	8	i3	int
    //   293	1972	9	i4	int
    //   284	2402	10	bool	boolean
    //   306	1285	11	l1	long
    //   1147	1298	13	l2	long
    //   1083	1155	15	l3	long
    //   1170	75	17	l4	long
    //   301	1	19	localObject1	Object
    //   607	5	19	localSoNotFindException1	SoNotFindException
    //   669	12	19	localObject2	Object
    //   1042	11	19	localObject3	Object
    //   1398	408	19	localSoNotFindException2	SoNotFindException
    //   1861	890	19	localObject4	Object
    //   298	2457	20	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   23	64	607	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   71	110	607	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   117	150	607	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   157	173	607	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   419	478	669	finally
    //   478	481	669	finally
    //   1013	1025	1042	finally
    //   1094	1135	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1137	1142	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1162	1215	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1236	1250	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1262	1294	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1302	1336	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1349	1391	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1435	1477	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1480	1562	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   1562	1588	1398	com/tencent/qqmusic/mediaplayer/SoNotFindException
  }
  
  void pause(boolean paramBoolean)
  {
    AppMethodBeat.i(76483);
    super.pause(paramBoolean);
    if (paramBoolean)
    {
      AudioTrack localAudioTrack = this.mAudioTrack;
      if (localAudioTrack != null) {}
      try
      {
        if ((localAudioTrack.getState() == 1) && (localAudioTrack.getPlayState() != 2)) {
          localAudioTrack.pause();
        }
        AppMethodBeat.o(76483);
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}
    }
    AppMethodBeat.o(76483);
  }
  
  void release()
  {
    AppMethodBeat.i(76491);
    super.release();
    this.mCurrentFrameCount = 0L;
    AppMethodBeat.o(76491);
  }
  
  void seek(int paramInt)
  {
    AppMethodBeat.i(76490);
    addSeekRecord(paramInt);
    refreshTimeAndNotify(paramInt);
    AppMethodBeat.o(76490);
  }
  
  void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(76488);
    if (paramInt == this.mAudioStreamType)
    {
      AppMethodBeat.o(76488);
      return;
    }
    try
    {
      this.mAudioStreamType = paramInt;
      if (this.mAudioTrack != null)
      {
        AudioTrack localAudioTrack = instantiateAudioTrackCompat(paramInt, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
        Logger.i("StreamDecodeDataComponent", axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
        int i = this.mAudioTrack.getPlayState();
        if (i == 3) {
          pause(false);
        }
        this.mAudioTrack.release();
        setAudioTrack(localAudioTrack);
        this.mStateRunner.setAudioTrack(this.mAudioTrack);
        if (i == 3) {
          play();
        }
      }
      AppMethodBeat.o(76488);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logger.e("StreamDecodeDataComponent", "failed in setting audio stream type to :".concat(String.valueOf(paramInt)), localIllegalStateException);
      AppMethodBeat.o(76488);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label196:
      break label196;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */