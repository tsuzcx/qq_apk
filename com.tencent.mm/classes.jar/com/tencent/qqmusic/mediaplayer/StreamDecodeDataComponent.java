package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify.WaitListener;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.Iterator;
import java.util.List;
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
  
  StreamDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
    AppMethodBeat.i(76482);
    this.mSeekRecord = new Stack();
    this.mCurrentFrameCount = 0L;
    this.mNeedFlush = false;
    AppMethodBeat.o(76482);
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
        catch (Throwable localThrowable)
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
    Object localObject = this.mAudioTrack;
    if ((localObject == null) || (((AudioTrack)localObject).getState() == 0))
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
    long l1 = getAudioTrackPosition(this.mCurrentFrameCount, (AudioTrack)localObject);
    localObject = this.audioEffects.iterator();
    while (((Iterator)localObject).hasNext()) {
      l1 = ((IAudioListener)((Iterator)localObject).next()).getActualTime(l1);
    }
    long l2 = localAudioInformation.getChannels() * this.mTargetBitDepth * localAudioInformation.getPlaySample();
    if (l2 > 0L)
    {
      l2 = this.mTrackBufferSizeInByte / l2 * 1000L;
      l2 = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, l2);
      if (l2 >= 0L) {
        break label195;
      }
      this.mCurPosition = l1;
    }
    for (;;)
    {
      l1 = this.mCurPosition;
      AppMethodBeat.o(76489);
      return l1;
      l2 = 0L;
      break;
      label195:
      if ((l1 > 0L) && (Math.abs(l1 - l2) < 5000L)) {
        this.mCurPosition = l1;
      } else {
        this.mCurPosition = l2;
      }
    }
  }
  
  void handleDecodeData()
  {
    AppMethodBeat.i(76484);
    int n;
    boolean bool;
    int m;
    int i3;
    int i4;
    int j;
    Object localObject5;
    int k;
    long l1;
    int i1;
    int i;
    label730:
    label988:
    Object localObject4;
    label803:
    label2217:
    if ((this.mInformation != null) && (!this.mCorePlayer.mIsExit))
    {
      try
      {
        if (0L == this.mInformation.getSampleRate())
        {
          Logger.e("StreamDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          AppMethodBeat.o(76484);
          return;
        }
        this.mHasInit = true;
        if (!createAudioTrack())
        {
          Logger.e("StreamDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          AppMethodBeat.o(76484);
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException1)
      {
        Logger.e("StreamDecodeDataComponent", localSoNotFindException1);
        this.mStateRunner.transfer(Integer.valueOf(2));
        initAudioListeners(this.mTargetBitDepth, this.mInformation, getCurPosition());
        postRunnable(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(76723);
            if (StreamDecodeDataComponent.this.getPlayerState() == 8)
            {
              Logger.w("StreamDecodeDataComponent", "[run] state changed to END during postRunnable!");
              AppMethodBeat.o(76723);
              return;
            }
            StreamDecodeDataComponent.this.mCallback.playerPrepared(StreamDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.o(76723);
          }
        }, 0);
        if ((!isPlaying()) && (!this.mCorePlayer.mIsExit))
        {
          Logger.i("StreamDecodeDataComponent", axiliary("prepared. waiting..."));
          this.mSignalControl.doWait(20L, 100, new WaitNotify.WaitListener()
          {
            public boolean keepWaiting()
            {
              AppMethodBeat.i(190298);
              if ((!StreamDecodeDataComponent.this.isPlaying()) && (!StreamDecodeDataComponent.this.mCorePlayer.mIsExit))
              {
                AppMethodBeat.o(190298);
                return true;
              }
              AppMethodBeat.o(190298);
              return false;
            }
          });
          Logger.i("StreamDecodeDataComponent", axiliary("woke after preparing"));
        }
        PlayerConfigManager.getInstance().setCommonPlayerRef(this.mCorePlayer);
        this.mDecodeBufferInfo.setByteBufferCapacity(this.mBuffSize);
        n = 1;
        bool = false;
        m = 0;
        i3 = 0;
        i4 = 1;
        j = 0;
        localObject5 = null;
        Object localObject1 = null;
        k = 0;
        l1 = 0L;
        i1 = 0;
      }
      if (!this.mCorePlayer.mIsExit)
      {
        if ((this.mSpeedToSet != null) && (this.mAudioTrack != null) && (Build.VERSION.SDK_INT >= 23))
        {
          Logger.i("StreamDecodeDataComponent", axiliary("setSpeed:" + this.mSpeedToSet));
          ??? = this.mAudioTrack.getPlaybackParams();
          ((PlaybackParams)???).setSpeed(this.mSpeedToSet.floatValue());
          this.mSpeedToSet = null;
          this.mAudioTrack.setPlaybackParams((PlaybackParams)???);
        }
        i = -1;
      }
    }
    else
    {
      int i2;
      synchronized (this.mSeekRecord)
      {
        if (!this.mSeekRecord.empty())
        {
          i = ((Integer)this.mSeekRecord.pop()).intValue();
          this.mSeekRecord.clear();
          Logger.i("StreamDecodeDataComponent", "execute seek: " + i + ", abandon the others");
        }
        i2 = i;
        if (i < 0)
        {
          i2 = i;
          if (this.mNeedFlush)
          {
            i2 = getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
            Logger.i("StreamDecodeDataComponent", axiliary("[run] flashback to ".concat(String.valueOf(i2))));
            this.mNeedFlush = false;
          }
        }
        i = m;
        if (i2 < 0) {
          break label730;
        }
        i = this.mHandleDecodeDataCallback.seekTo(i2);
        if (i < 0)
        {
          Logger.e("StreamDecodeDataComponent", axiliary("seekTo failed: ".concat(String.valueOf(i))));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(95, 74);
          AppMethodBeat.o(76484);
          return;
          if (!this.mCorePlayer.mIsExit)
          {
            Logger.e("StreamDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(91, 63);
          }
          AppMethodBeat.o(76484);
          return;
        }
      }
      i = m;
      if (this.mAudioTrack != null)
      {
        this.mCurrentFrameCount = Math.round(i2 / 1000.0D * this.mAudioTrack.getSampleRate());
        if (this.mAudioTrack.getPlayState() != 3) {
          break label803;
        }
        this.mAudioTrack.pause();
        this.mAudioTrack.flush();
        this.mAudioTrack.play();
      }
      for (;;)
      {
        i = 0;
        this.mCurPosition = i2;
        notifySeekCompleteForAudioListeners(i2);
        this.mCallback.playerSeekCompletion(this.mCorePlayer, i2);
        if (!isPaused()) {
          break label813;
        }
        if (this.mAudioTrack.getPlayState() != 2) {
          this.mAudioTrack.pause();
        }
        postRunnable(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(190299);
            StreamDecodeDataComponent.this.mCallback.playerPaused(StreamDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.o(190299);
          }
        }, 20);
        Logger.i("StreamDecodeDataComponent", axiliary("paused. waiting..."));
        doWaitForPaused();
        Logger.i("StreamDecodeDataComponent", axiliary("woke after pausing"));
        m = i;
        break;
        this.mAudioTrack.flush();
      }
      label813:
      if ((!isIdle()) && (!isError()) && (!isStopped()))
      {
        if (isCompleted())
        {
          j = i / this.mInformation.getChannels() - i3;
          if (j > 0)
          {
            k = this.mTrackBufferSizeInByte / this.mTargetBitDepth / this.mInformation.getChannels();
            if (j >= k) {
              break label988;
            }
          }
          for (;;)
          {
            j = (int)(j * 1000 / this.mInformation.getSampleRate());
            k = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
            Logger.i("StreamDecodeDataComponent", axiliary("writeShortCount: " + i + ", playFramePosition: " + i3 + ", leftTimeInMs: " + j + ", minAudioTrackWaitTimeMs: " + k));
            if (j <= 0) {
              break label2660;
            }
            try
            {
              wait(Math.max(k, j));
              return;
            }
            finally
            {
              AppMethodBeat.o(76484);
            }
            j = 0;
            break;
            j = k;
          }
        }
        if ((isPlaying()) && (this.mAudioTrack.getPlayState() != 3)) {
          this.mAudioTrack.play();
        }
        long l3 = System.currentTimeMillis();
        if (i4 == 0) {
          break label2678;
        }
        if (j != 0) {}
        long l2;
        for (;;)
        {
          try
          {
            Logger.i("StreamDecodeDataComponent", axiliary("writeFail = true,  mBuffSize = " + this.mBuffSize));
            Logger.i("StreamDecodeDataComponent", axiliary("there is no need to read more pcm data, just use writeFailByteArray"));
            k = 0;
            this.mHasDecode = true;
            m = k;
            l2 = l1;
            i2 = i1;
            if (i1 != 0) {
              break label1539;
            }
            i1 = 10;
            long l4 = getCalcBitMinSize(this.mInformation);
            Logger.i("StreamDecodeDataComponent", axiliary("minSize: " + l4 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
            m = k;
            l2 = l1;
            if (l4 <= 0L) {
              break;
            }
            m = k;
            l2 = l1;
            if (this.mDecodeBufferInfo.bufferSize >= l4) {
              break;
            }
            m = k;
            l2 = l1;
            if (i1 < 0) {
              break;
            }
            this.mDecodeBufferInfo.setTempByteBufferCapacity(this.mBuffSize);
            k = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
            l2 = l1;
            if (k > 0)
            {
              this.mDecodeBufferInfo.appendByte(this.mDecodeBufferInfo.tempByteBuffer, 0, k);
              ??? = this.mDecodeBufferInfo;
              ((BufferInfo)???).bufferSize += k;
              l2 = l1 + k;
            }
            i1 -= 1;
            Logger.d("StreamDecodeDataComponent", axiliary("decode tmpSize: " + k + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
            l1 = l2;
            continue;
            k = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
          }
          catch (SoNotFindException localSoNotFindException2)
          {
            Logger.e("StreamDecodeDataComponent", localSoNotFindException2);
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(92, 62);
            AppMethodBeat.o(76484);
            return;
          }
          this.mDecodeBufferInfo.bufferSize = k;
          l1 = this.mDecodeBufferInfo.bufferSize + l1;
        }
        if (this.mInformation.getBitDepth() == 0)
        {
          this.mTargetBitDepth = AudioRecognition.calcBitDept(l2, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate());
          this.mInformation.setBitDept(this.mTargetBitDepth);
          Logger.w("StreamDecodeDataComponent", axiliary("create audiotrack with wrong bitDepth, there may cause some problem!! " + this.mTargetBitDepth));
        }
        i2 = this.mTargetBitDepth;
        Logger.d("StreamDecodeDataComponent", axiliary("mPlayBitDept: ".concat(String.valueOf(i2))));
        l1 = l2;
        i1 = i2;
        if (this.mNeedChangePlayThreadPriority)
        {
          this.mNeedChangePlayThreadPriority = false;
          PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        }
        if (this.mDecodeBufferInfo.bufferSize > 0)
        {
          if (!this.mHasDecodeSuccess)
          {
            this.mCallback.playerStarted(this.mCorePlayer);
            this.mHasDecodeSuccess = true;
          }
          ??? = localObject5;
          if (j != 0) {
            break label2667;
          }
          ??? = localObject5;
          if (this.mTargetBitDepth != this.mInformation.getBitDepth())
          {
            ??? = localObject5;
            if (!this.isUseFloatForHighDepth)
            {
              ??? = initTempBufferInfoIfNeeded((BufferInfo)localObject5, this.mBuffSize);
              handleHighBitDepth(this.mDecodeBufferInfo, (BufferInfo)???);
              ((BufferInfo)???).fillInto(this.mDecodeBufferInfo);
            }
          }
          localObject5 = ???;
          if (this.mTargetPlaySample != this.mInformation.getSampleRate())
          {
            localObject5 = initTempBufferInfoIfNeeded((BufferInfo)???, this.mBuffSize);
            handleHighSample(this.mDecodeBufferInfo, (BufferInfo)localObject5);
            ((BufferInfo)localObject5).fillInto(this.mDecodeBufferInfo);
          }
          if (this.isUseFloatForHighDepth)
          {
            convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
            ??? = localObject5;
            if (this.audioEffects.isEmpty()) {
              break label2667;
            }
            ??? = initTempFloatBufferInfoIfNeeded(localSoNotFindException2, this.mFloatBufferInfo.bufferSize);
            processAudioListeners(this.mFloatBufferInfo, (FloatBufferInfo)???);
            this.mFloatBufferInfo.fillFloat(((FloatBufferInfo)???).floatBuffer, ((FloatBufferInfo)???).bufferSize);
            localObject4 = localObject5;
            localObject5 = ???;
            if ((this.mAudioTrack == null) || (!isPlaying())) {
              break label2697;
            }
            if (j != 0) {
              break label2692;
            }
            k = this.mTerminalAudioEffectList.size() - 1;
          }
          for (;;)
          {
            if (k < 0) {
              break label2692;
            }
            ??? = (IAudioListener)this.mTerminalAudioEffectList.get(k);
            if (((IAudioListener)???).isEnabled())
            {
              if (this.isUseFloatForHighDepth) {
                ((IAudioListener)???).onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
              }
              for (;;)
              {
                k = 1;
                label1896:
                if (k != 0) {
                  break label2684;
                }
                l3 = System.currentTimeMillis() - l3;
                if ((!this.isUseFloatForHighDepth) || (Build.VERSION.SDK_INT < 21)) {
                  break label2366;
                }
                l2 = calculatePcmPlayTime(this.mFloatBufferInfo.floatBuffer, this.mInformation.getChannels(), this.mTargetPlaySample);
                k = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
                if (k >= 0) {
                  break label2251;
                }
                if (this.mAudioTrack.getPlayState() != 3) {
                  break label2148;
                }
                Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write float failed: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(92, 102);
                AppMethodBeat.o(76484);
                return;
                ??? = localObject5;
                if (this.audioEffects.isEmpty()) {
                  break label2667;
                }
                ??? = initTempBufferInfoIfNeeded((BufferInfo)localObject5, this.mBuffSize);
                processAudioListeners(this.mDecodeBufferInfo, (BufferInfo)???);
                ((BufferInfo)???).fillInto(this.mDecodeBufferInfo);
                localObject5 = localObject4;
                localObject4 = ???;
                break;
                ((IAudioListener)???).onPcm(this.mDecodeBufferInfo, this.mDecodeBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
              }
            }
            k -= 1;
          }
          label2148:
          k = 0;
          Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
          label2162:
          if ((l2 > 0L) && (l3 > l2) && (n == 0)) {
            PlayStuckMonitor.INSTANCE.onPlayStuck(l3, l2, bool);
          }
          for (bool = true;; bool = false)
          {
            i3 = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
            n = j;
            j = 0;
            i4 = k;
            k = n;
            ??? = localObject4;
            n = k;
            k = m;
            i2 = j;
            localObject4 = localObject5;
            localObject5 = ???;
            j = n;
            m = i;
            n = i2;
            break;
            label2251:
            i2 = 1;
            if (k != this.mFloatBufferInfo.bufferSize)
            {
              Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
              if (k == 0)
              {
                Logger.w("StreamDecodeDataComponent", axiliary("save the pcm data that has not written to audiotrack"));
                j = 1;
                if (k <= 0) {
                  break label2361;
                }
              }
            }
            label2361:
            for (k = this.mFloatBufferInfo.bufferSize * 2;; k = 0)
            {
              i += k;
              k = i2;
              break;
              this.mAudioTrack.flush();
              j = 0;
              break label2325;
            }
            label2366:
            l2 = calculatePcmPlayTime(this.mDecodeBufferInfo.byteBuffer, this.mInformation.getChannels(), this.mTargetBitDepth, this.mTargetPlaySample);
            k = this.mAudioTrack.write(this.mDecodeBufferInfo.byteBuffer, 0, this.mDecodeBufferInfo.bufferSize);
            if (k < 0)
            {
              if (this.mAudioTrack.getPlayState() == 3)
              {
                Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes failed: " + k + ", expect: " + this.mDecodeBufferInfo.bufferSize));
                this.mStateRunner.transfer(Integer.valueOf(9));
                callExceptionCallback(92, 102);
                AppMethodBeat.o(76484);
                return;
              }
              k = 0;
              Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
              break label2162;
            }
            i2 = 1;
            if (k != this.mDecodeBufferInfo.bufferSize)
            {
              Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + k + ", expect: " + this.mDecodeBufferInfo.bufferSize));
              if (k == 0)
              {
                Logger.w("StreamDecodeDataComponent", axiliary("save the pcm data that has not written to audiotrack"));
                j = 1;
                if (k <= 0) {
                  break label2627;
                }
              }
            }
            label2627:
            for (k = this.mDecodeBufferInfo.bufferSize;; k = 0)
            {
              i += k;
              k = i2;
              break;
              this.mAudioTrack.flush();
              j = 0;
              break label2593;
            }
          }
        }
        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(m, 92);
      }
    }
    for (;;)
    {
      label1539:
      label1547:
      label1805:
      label2325:
      label2593:
      k = m;
      m = i;
      break;
      label2660:
      AppMethodBeat.o(76484);
      return;
      label2667:
      localObject5 = localObject4;
      localObject4 = ???;
      break label1805;
      label2678:
      m = k;
      break label1547;
      label2684:
      k = j;
      j = n;
      break label2217;
      label2692:
      k = 0;
      break label1896;
      label2697:
      ??? = localObject4;
      localObject4 = localObject5;
      localObject5 = ???;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */