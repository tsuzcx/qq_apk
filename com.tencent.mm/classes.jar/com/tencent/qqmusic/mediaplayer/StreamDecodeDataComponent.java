package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
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
    long l2;
    long l5;
    int k;
    int m;
    int n;
    int j;
    Object localObject3;
    int i2;
    long l1;
    int i1;
    int i;
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
        }, 20);
        if ((!isPlaying()) && (!this.mCorePlayer.mIsExit))
        {
          Logger.i("StreamDecodeDataComponent", axiliary("prepared. waiting..."));
          this.mSignalControl.doWait();
          Logger.i("StreamDecodeDataComponent", axiliary("woke after preparing"));
        }
        PlayerConfigManager.getInstance().setCommonPlayerRef(this.mCorePlayer);
        this.mDecodeBufferInfo.setByteBufferCapacity(this.mBuffSize);
        l2 = 0L;
        l5 = System.currentTimeMillis();
        k = 0;
        m = 0;
        n = 1;
        j = 0;
        localObject3 = null;
        Object localObject1 = null;
        i2 = 0;
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
      int i3;
      synchronized (this.mSeekRecord)
      {
        if (!this.mSeekRecord.empty())
        {
          i = ((Integer)this.mSeekRecord.pop()).intValue();
          this.mSeekRecord.clear();
          Logger.i("StreamDecodeDataComponent", "execute seek: " + i + ", abandon the others");
        }
        i3 = i;
        if (i < 0)
        {
          i3 = i;
          if (this.mNeedFlush)
          {
            i3 = getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
            Logger.i("StreamDecodeDataComponent", axiliary("[run] flashback to ".concat(String.valueOf(i3))));
            this.mNeedFlush = false;
          }
        }
        i = k;
        if (i3 < 0) {
          break label718;
        }
        i = this.mHandleDecodeDataCallback.seekTo(i3);
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
      i = k;
      if (this.mAudioTrack != null)
      {
        this.mCurrentFrameCount = Math.round(i3 / 1000.0D * this.mAudioTrack.getSampleRate());
        if (this.mAudioTrack.getPlayState() != 3) {
          break label790;
        }
        this.mAudioTrack.pause();
        this.mAudioTrack.flush();
        this.mAudioTrack.play();
      }
      for (;;)
      {
        i = 0;
        this.mCurPosition = i3;
        notifySeekCompleteForAudioListeners(i3);
        this.mCallback.playerSeekCompletion(this.mCorePlayer, i3);
        label718:
        if (!isPaused()) {
          break label800;
        }
        if (this.mAudioTrack.getPlayState() != 2) {
          this.mAudioTrack.pause();
        }
        postRunnable(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(76570);
            StreamDecodeDataComponent.this.mCallback.playerPaused(StreamDecodeDataComponent.this.mCorePlayer);
            AppMethodBeat.o(76570);
          }
        }, 20);
        Logger.i("StreamDecodeDataComponent", axiliary("paused. waiting..."));
        doWaitForPaused();
        Logger.i("StreamDecodeDataComponent", axiliary("woke after pausing"));
        k = i;
        break;
        label790:
        this.mAudioTrack.flush();
      }
      label800:
      if ((!isIdle()) && (!isError()) && (!isStopped()))
      {
        if (isCompleted())
        {
          j = i / this.mInformation.getChannels() - m;
          if (j > 0)
          {
            k = this.mTrackBufferSizeInByte / this.mTargetBitDepth / this.mInformation.getChannels();
            if (j >= k) {
              break label975;
            }
          }
          for (;;)
          {
            j = (int)(j * 1000 / this.mInformation.getSampleRate());
            k = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
            Logger.i("StreamDecodeDataComponent", axiliary("writeShortCount: " + i + ", playFramePosition: " + m + ", leftTimeInMs: " + j + ", minAudioTrackWaitTimeMs: " + k));
            if (j <= 0) {
              break label2607;
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
            label975:
            j = k;
          }
        }
        if ((isPlaying()) && (this.mAudioTrack.getPlayState() != 3)) {
          this.mAudioTrack.play();
        }
        if (n == 0) {
          break label2643;
        }
        if (j == 0) {}
      }
    }
    for (;;)
    {
      long l3;
      long l4;
      try
      {
        Logger.i("StreamDecodeDataComponent", axiliary("writeFail = true,  mBuffSize = " + this.mBuffSize));
        Logger.i("StreamDecodeDataComponent", axiliary("there is no need to read more pcm data, just use writeFailByteArray"));
        k = 0;
        l3 = l2;
        l2 = l1;
        l1 = l3;
        this.mHasDecode = true;
        if (i1 != 0) {
          break label2630;
        }
        i2 = 10;
        long l6 = getCalcBitMinSize(this.mInformation);
        Logger.i("StreamDecodeDataComponent", axiliary("minSize: " + l6 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
        if (l6 <= 0L) {
          break label2678;
        }
        l3 = l1;
        l1 = l3;
        i1 = k;
        l4 = l2;
        if (this.mDecodeBufferInfo.bufferSize < l6)
        {
          l1 = l3;
          i1 = k;
          l4 = l2;
          if (i2 >= 0)
          {
            this.mDecodeBufferInfo.setTempByteBufferCapacity(this.mBuffSize);
            k = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
            l4 = l3;
            l1 = l2;
            if (k > 0)
            {
              this.mDecodeBufferInfo.appendByte(this.mDecodeBufferInfo.tempByteBuffer, 0, k);
              ??? = this.mDecodeBufferInfo;
              ((BufferInfo)???).bufferSize += k;
              l4 = l3 + k;
              l1 = l2 + k;
            }
            Logger.d("StreamDecodeDataComponent", axiliary("decode tmpSize: " + k + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
            i2 -= 1;
            l3 = l4;
            l2 = l1;
            continue;
            k = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
            this.mDecodeBufferInfo.bufferSize = k;
            l2 = this.mDecodeBufferInfo.bufferSize + l2;
            l3 = this.mDecodeBufferInfo.bufferSize + l1;
            l1 = l2;
            l2 = l3;
            continue;
          }
        }
        if (this.mInformation.getBitDepth() == 0)
        {
          this.mTargetBitDepth = AudioRecognition.calcBitDept(l1, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate());
          this.mInformation.setBitDept(this.mTargetBitDepth);
          Logger.w("StreamDecodeDataComponent", axiliary("create audiotrack with wrong bitDepth, there may cause some problem!! " + this.mTargetBitDepth));
        }
        k = this.mTargetBitDepth;
        Logger.d("StreamDecodeDataComponent", axiliary("mPlayBitDept: ".concat(String.valueOf(k))));
        l2 = l4;
        label1528:
        i2 = i1;
        l3 = l1;
        i1 = k;
        l1 = l2;
        label1543:
        if (this.mNeedChangePlayThreadPriority)
        {
          this.mNeedChangePlayThreadPriority = false;
          PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        }
        l2 = System.currentTimeMillis();
        l4 = l2 - l5;
        if (l4 <= 1000L) {
          break label2627;
        }
        PlayerConfigManager.getInstance().updateDecodeSpeed(((float)l1 * 1.0F / (float)l4));
        l1 = 0L;
        l5 = l2;
        label1605:
        if (this.mDecodeBufferInfo.bufferSize <= 0) {
          break label2585;
        }
        if (!this.mHasDecodeSuccess)
        {
          this.mCallback.playerStarted(this.mCorePlayer);
          this.mHasDecodeSuccess = true;
        }
        if (j != 0) {
          break label2624;
        }
        ??? = localObject3;
        if (this.mTargetBitDepth != this.mInformation.getBitDepth())
        {
          ??? = localObject3;
          if (!this.isUseFloatForHighDepth)
          {
            ??? = initTempBufferInfoIfNeeded((BufferInfo)localObject3, this.mBuffSize);
            handleHighBitDepth(this.mDecodeBufferInfo, (BufferInfo)???);
            ((BufferInfo)???).fillInto(this.mDecodeBufferInfo);
          }
        }
        if (this.mTargetPlaySample == this.mInformation.getSampleRate()) {
          break label2617;
        }
        localObject3 = initTempBufferInfoIfNeeded((BufferInfo)???, this.mBuffSize);
        handleHighSample(this.mDecodeBufferInfo, (BufferInfo)localObject3);
        ((BufferInfo)localObject3).fillInto(this.mDecodeBufferInfo);
        label1752:
        if (this.isUseFloatForHighDepth)
        {
          convertBytePcmToFloatPcm(this.mDecodeBufferInfo, this.mFloatBufferInfo);
          if (this.audioEffects.isEmpty()) {
            break label2614;
          }
          FloatBufferInfo localFloatBufferInfo2 = initTempFloatBufferInfoIfNeeded(localFloatBufferInfo1, this.mFloatBufferInfo.bufferSize);
          processAudioListeners(this.mFloatBufferInfo, localFloatBufferInfo2);
          this.mFloatBufferInfo.fillFloat(localFloatBufferInfo2.floatBuffer, localFloatBufferInfo2.bufferSize);
          if ((this.mAudioTrack == null) || (!isPlaying())) {
            break label2669;
          }
          if (j != 0) {
            break label2664;
          }
          k = this.mTerminalAudioEffectList.size() - 1;
          if (k < 0) {
            break label2664;
          }
          ??? = (IAudioListener)this.mTerminalAudioEffectList.get(k);
          if (!((IAudioListener)???).isEnabled()) {
            break label2154;
          }
          if (!this.isUseFloatForHighDepth) {
            break label2128;
          }
          ((IAudioListener)???).onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
          k = 1;
          if (k != 0) {
            break label2650;
          }
          if ((!this.isUseFloatForHighDepth) || (Build.VERSION.SDK_INT < 21)) {
            break label2337;
          }
          k = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
          if (k >= 0) {
            break label2220;
          }
          if (this.mAudioTrack.getPlayState() != 3) {
            break label2161;
          }
          Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write float failed: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(92, 102);
          AppMethodBeat.o(76484);
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException2)
      {
        label1825:
        Logger.e("StreamDecodeDataComponent", localSoNotFindException2);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(92, 62);
        AppMethodBeat.o(76484);
        return;
      }
      if (!this.audioEffects.isEmpty())
      {
        localObject3 = initTempBufferInfoIfNeeded((BufferInfo)localObject3, this.mBuffSize);
        processAudioListeners(this.mDecodeBufferInfo, (BufferInfo)localObject3);
        ((BufferInfo)localObject3).fillInto(this.mDecodeBufferInfo);
        continue;
        label2128:
        ((IAudioListener)???).onPcm(this.mDecodeBufferInfo, this.mDecodeBufferInfo, this.mCorePlayer.getCurPositionByDecoder());
        continue;
        label2154:
        k -= 1;
        continue;
        label2161:
        Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
        m = j;
        j = 0;
        k = i;
        i = m;
        label2183:
        n = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);
        m = j;
        j = n;
      }
      else
      {
        for (;;)
        {
          n = i;
          i = j;
          j = n;
          n = m;
          m = i;
          l2 = l3;
          break;
          label2220:
          m = 1;
          if (k != this.mFloatBufferInfo.bufferSize)
          {
            Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
            if (k == 0)
            {
              Logger.w("StreamDecodeDataComponent", axiliary("save the pcm data that has not written to audiotrack"));
              j = 1;
              label2294:
              if (k <= 0) {
                break label2332;
              }
            }
          }
          label2332:
          for (k = this.mFloatBufferInfo.bufferSize * 2;; k = 0)
          {
            k = i + k;
            i = j;
            j = m;
            break;
            this.mAudioTrack.flush();
            j = 0;
            break label2294;
          }
          label2337:
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
            Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
            m = 0;
            k = i;
            i = j;
            j = m;
            break label2183;
          }
          m = 1;
          if (k != this.mDecodeBufferInfo.bufferSize)
          {
            Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + k + ", expect: " + this.mDecodeBufferInfo.bufferSize));
            if (k == 0)
            {
              Logger.w("StreamDecodeDataComponent", axiliary("save the pcm data that has not written to audiotrack"));
              j = 1;
              label2544:
              if (k <= 0) {
                break label2580;
              }
            }
          }
          label2580:
          for (k = this.mDecodeBufferInfo.bufferSize;; k = 0)
          {
            k = i + k;
            i = j;
            j = m;
            break;
            this.mAudioTrack.flush();
            j = 0;
            break label2544;
          }
          label2585:
          this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i2, 92);
          k = i;
          l2 = l3;
          break;
          label2607:
          AppMethodBeat.o(76484);
          return;
          label2614:
          break label1825;
          label2617:
          localObject3 = ???;
          break label1752;
          label2624:
          break label1825;
          label2627:
          break label1605;
          label2630:
          i2 = i1;
          i1 = k;
          k = i2;
          break label1528;
          label2643:
          l3 = l2;
          break label1543;
          label2650:
          k = i;
          i = j;
          j = m;
          m = n;
        }
        label2664:
        k = 0;
        continue;
        label2669:
        k = i;
        l2 = l3;
        break;
        label2678:
        i1 = k;
        l4 = l2;
      }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */