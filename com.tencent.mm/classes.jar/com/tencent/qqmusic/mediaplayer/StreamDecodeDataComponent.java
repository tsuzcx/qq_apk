package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.qqmusic.mediaplayer.audiofx.IAudioListener;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.qqmusic.mediaplayer.util.ReferenceTimer;
import com.tencent.qqmusic.mediaplayer.util.WaitNotify;
import com.tencent.qqmusic.mediaplayer.utils.AudioUtil;
import java.util.List;
import java.util.Stack;

public class StreamDecodeDataComponent
  extends BaseDecodeDataComponent
{
  private static final int DTS_OPTIMAL_FRAME_BYTE = 2048;
  private static final int MAX_AUDIO_TRACK_BUFFER_TIME = 1;
  private static final int MIN_AUDIO_TRACK_BUFFER_TIMES = 1;
  private static final String TAG = "StreamDecodeDataComponent";
  private static final int USE_AUDIO_TRACK_TIME_THRESHOLD = 1000;
  private long mCurrentFrameCount = 0L;
  private boolean mNeedFlush = false;
  private final Stack<Integer> mSeekRecord = new Stack();
  private int mTrackBufferSizeInByte;
  
  StreamDecodeDataComponent(CorePlayer paramCorePlayer, StateRunner<Integer> paramStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
  }
  
  private void addSeekRecord(int paramInt)
  {
    synchronized (this.mSeekRecord)
    {
      Logger.i("StreamDecodeDataComponent", "add seek: " + paramInt);
      this.mSeekRecord.push(Integer.valueOf(paramInt));
      return;
    }
  }
  
  private boolean createAudioTrack()
  {
    Logger.d("StreamDecodeDataComponent", axiliary("createAudioTrack"));
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StreamDecodeDataComponent", "mState is not preparing");
      callExceptionCallback(91, 54);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StreamDecodeDataComponent", "mInformation.getSampleRate() failed");
      callExceptionCallback(91, 64);
      return false;
    }
    int i = 12;
    int i2 = this.mInformation.getChannels();
    if (i2 == 1) {
      i = 4;
    }
    int n;
    for (;;)
    {
      n = (int)this.mHandleDecodeDataCallback.getMinPcmBufferSize();
      Logger.d("StreamDecodeDataComponent", axiliary(this.mInformation.toString()));
      for (this.mPlaySample = this.mInformation.getSampleRate(); this.mPlaySample > MAX_PLAY_SAMPLE_RATE; this.mPlaySample /= 2L) {}
      if (i2 == 2) {
        i = 12;
      } else if (i2 == 6) {
        i = 252;
      } else if (i2 == 8) {
        i = 1020;
      }
    }
    this.mInformation.setPlaySample(this.mPlaySample);
    int m = getBytesPerSampleInPlay(this.mInformation.getBitDept());
    if (m == 0) {
      m = 2;
    }
    label722:
    label745:
    label1141:
    for (;;)
    {
      int j;
      if ((CAN_USE_FLOAT_IN_HI_RES) && (this.mInformation.getBitDept() >= 3) && (this.mInformation.getSampleRate() > 48000L))
      {
        this.mPlayBitDepth = m;
        this.isUseFloatInHiRes = true;
        if (this.mPlaySample != this.mInformation.getSampleRate())
        {
          Logger.i("StreamDecodeDataComponent", axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDept() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
          j = 2;
          if (m != 1) {
            break label722;
          }
          j = 3;
        }
      }
      int i1;
      for (;;)
      {
        i1 = AudioTrack.getMinBufferSize((int)this.mPlaySample, i, j);
        if (i1 >= 0) {
          break label745;
        }
        callExceptionCallback(92, 66);
        return false;
        Logger.i("StreamDecodeDataComponent", axiliary("will use float pcm for Hi-Res, bitDept: " + this.mInformation.getBitDept() + ", sample rate: " + this.mPlaySample));
        break;
        if ((!CAN_USE_FLOAT_IN_HI_RES) && (this.mInformation.getBitDept() >= 3))
        {
          this.mPlayBitDepth = 2;
          if (this.mPlaySample != this.mInformation.getSampleRate())
          {
            Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm resampled and bitDept converted, origin bitDept: " + this.mInformation.getBitDept() + ", target bitDept: " + this.mPlayBitDepth + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
            break;
          }
          Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm with bitDept converted, origin bitDept: " + this.mInformation.getBitDept() + ", target bitDept: " + this.mPlayBitDepth));
          break;
        }
        if (this.mPlaySample != this.mInformation.getSampleRate())
        {
          this.mPlayBitDepth = m;
          Logger.i("StreamDecodeDataComponent", axiliary("will use byte pcm resampled, bitDept: " + this.mInformation.getBitDept() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
          break;
        }
        this.mPlayBitDepth = 2;
        Logger.i("StreamDecodeDataComponent", axiliary("will use normal byte pcm, bitDept: " + this.mInformation.getBitDept() + ", sample rate: " + this.mPlaySample));
        break;
        if (m == 2) {
          j = 2;
        } else if (this.isUseFloatInHiRes) {
          j = 4;
        }
      }
      Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] playback_bufsize:" + i1 + " decoderBufsizeInByte:" + n));
      int k = i1;
      if (i1 % 2048 != 0) {
        k = (i1 / 2048 + 1) * 2048;
      }
      if (k > n)
      {
        n = k;
        this.mBuffSize = n;
        Logger.i("StreamDecodeDataComponent", axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mPlaySample: %d, playChannel: %d, pcmEncoding: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mPlaySample), Integer.valueOf(i2), Integer.valueOf(j) })));
        n = Math.max((int)(Math.floor(1L * this.mPlaySample * i2 * 2L / k) + 1.0D), 1);
        Logger.d("StreamDecodeDataComponent", axiliary("times: " + n + ", MIN_AUDIO_TRACK_BUFFER_TIMES: 1"));
      }
      for (;;)
      {
        for (;;)
        {
          if (n > 0) {}
          try
          {
            this.mTrackBufferSizeInByte = (k * n);
            this.mAudioTrack = new AudioTrack(this.mAudioStreamType, (int)this.mPlaySample, i, j, this.mTrackBufferSizeInByte, 1);
            Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] new AudioTrack, sampleRate: " + this.mPlaySample + ", channels: " + i + ", bitDepth: " + m + ", buffer: " + this.mTrackBufferSizeInByte));
            if (this.mAudioTrack.getState() == 1)
            {
              Logger.i("StreamDecodeDataComponent", axiliary("new AudioTrack succeed"));
              if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() != 1)) {
                break label1141;
              }
              Logger.d("StreamDecodeDataComponent", axiliary("create audioTrack success times = " + n));
              return true;
              break;
            }
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
            this.mAudioTrack = null;
            callExceptionCallback(92, 66);
            return false;
          }
        }
        n -= 2;
      }
    }
  }
  
  private long getCalcBitMinSize(AudioInformation paramAudioInformation)
  {
    if (paramAudioInformation != null) {
      return ((float)(paramAudioInformation.getSampleRate() * paramAudioInformation.getChannels() * paramAudioInformation.getBitDept()) * 5.0F / 1000.0F);
    }
    return 0L;
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
    if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() == 0)) {
      return this.mCurPosition;
    }
    AudioInformation localAudioInformation = this.mInformation;
    if (localAudioInformation == null) {
      return this.mCurPosition;
    }
    AudioTrack localAudioTrack = this.mAudioTrack;
    int i;
    long l;
    if (localAudioTrack == null)
    {
      i = 0;
      l = localAudioInformation.getChannels() * getBytesPerSampleInPlay(localAudioInformation.getBitDept()) * localAudioInformation.getPlaySample();
      if (l <= 0L) {
        break label138;
      }
      l = this.mTrackBufferSizeInByte / l * 1000L;
      label92:
      l = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, l);
      if (l >= 0L) {
        break label143;
      }
      this.mCurPosition = i;
    }
    for (;;)
    {
      return this.mCurPosition;
      i = getAudioTrackPosition(this.mCurrentFrameCount, localAudioTrack);
      break;
      label138:
      l = 0L;
      break label92;
      label143:
      if ((i > 0) && (Math.abs(i - l) < 1000L)) {
        this.mCurPosition = i;
      } else {
        this.mCurPosition = l;
      }
    }
  }
  
  void handleDecodeData()
  {
    int m;
    long l1;
    long l3;
    int i;
    int k;
    long l2;
    int j;
    int n;
    if ((this.mInformation != null) && (!this.mCorePlayer.mIsExit))
    {
      try
      {
        if (0L == this.mInformation.getSampleRate())
        {
          Logger.e("StreamDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          return;
        }
        this.mHasInit = true;
        if (!createAudioTrack())
        {
          Logger.e("StreamDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException1)
      {
        Logger.e("StreamDecodeDataComponent", localSoNotFindException1);
        this.mStateRunner.transfer(Integer.valueOf(2));
        initAudioListeners(this.mInformation.getPlaySample(), this.mPlayBitDepth, this.mInformation.getChannels());
        postRunnable(new StreamDecodeDataComponent.1(this), 20);
        if ((!isPlaying()) && (!this.mCorePlayer.mIsExit))
        {
          Logger.i("StreamDecodeDataComponent", axiliary("prepared. waiting..."));
          this.mSignalControl.doWait();
          Logger.i("StreamDecodeDataComponent", axiliary("woke after preparing"));
        }
        PlayerConfigManager.getInstance().setCommonPlayerRef(this.mCorePlayer);
        this.mDecodeBufferInfo.setByteBufferCapacity(this.mBuffSize);
        m = 0;
        l1 = System.currentTimeMillis();
        l3 = 0L;
        i = 0;
        k = 0;
        l2 = 0L;
      }
      if (!this.mCorePlayer.mIsExit) {
        j = -1;
      }
    }
    else
    {
      synchronized (this.mSeekRecord)
      {
        if (!this.mSeekRecord.empty())
        {
          j = ((Integer)this.mSeekRecord.pop()).intValue();
          this.mSeekRecord.clear();
          Logger.i("StreamDecodeDataComponent", "execute seek: " + j + ", abandon the others");
        }
        n = j;
        if (j < 0)
        {
          n = j;
          if (this.mNeedFlush)
          {
            n = getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
            Logger.i("StreamDecodeDataComponent", axiliary("[run] flashback to " + n));
            this.mNeedFlush = false;
          }
        }
        j = i;
        if (n < 0) {
          break label610;
        }
        j = this.mHandleDecodeDataCallback.seekTo(n);
        if (j < 0)
        {
          Logger.e("StreamDecodeDataComponent", axiliary("seekTo failed: " + j));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(95, 74);
          return;
          if (this.mCorePlayer.mIsExit) {
            break label2094;
          }
          Logger.e("StreamDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          return;
        }
      }
      if (this.mAudioTrack != null)
      {
        this.mCurrentFrameCount = Math.round(n / 1000.0D * this.mAudioTrack.getSampleRate());
        if (this.mAudioTrack.getPlayState() != 3) {
          break label685;
        }
        this.mAudioTrack.pause();
        this.mAudioTrack.flush();
        this.mAudioTrack.play();
      }
      for (;;)
      {
        i = 0;
        this.mCurPosition = n;
        this.mTimer.refreshTimeInMs(n);
        notifySeekCompleteForAudioListeners(n);
        this.mCallback.playerSeekCompletion(this.mCorePlayer, n);
        j = i;
        label610:
        if (!isPaused()) {
          break label695;
        }
        if (this.mAudioTrack.getPlayState() != 2) {
          this.mAudioTrack.pause();
        }
        postRunnable(new StreamDecodeDataComponent.2(this), 20);
        Logger.i("StreamDecodeDataComponent", axiliary("paused. waiting..."));
        this.mSignalControl.doWait();
        Logger.i("StreamDecodeDataComponent", axiliary("woke after pausing"));
        i = j;
        break;
        label685:
        this.mAudioTrack.flush();
      }
      label695:
      if ((!isIdle()) && (!isError()) && (!isStopped()))
      {
        if (isCompleted())
        {
          i = j / this.mInformation.getChannels() - k;
          if (i > 0)
          {
            m = this.mTrackBufferSizeInByte / getBytesPerSampleInPlay(this.mInformation.getBitDept()) / this.mInformation.getChannels();
            if (i >= m) {
              break label881;
            }
          }
          for (;;)
          {
            i = (int)(i * 1000 / this.mInformation.getSampleRate());
            m = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
            Logger.i("StreamDecodeDataComponent", axiliary("writeShortCount: " + j + ", playFramePosition: " + k + ", leftTimeInMs: " + i + ", minAudioTrackWaitTimeMs: " + m));
            if (i <= 0) {
              break label2094;
            }
            try
            {
              wait(Math.max(m, i));
              return;
            }
            finally {}
            i = 0;
            break;
            label881:
            i = m;
          }
        }
        if ((isPlaying()) && (this.mAudioTrack.getPlayState() != 3)) {
          this.mAudioTrack.play();
        }
      }
    }
    for (;;)
    {
      try
      {
        i = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
        this.mDecodeBufferInfo.bufferSize = i;
        l2 += this.mDecodeBufferInfo.bufferSize;
        l3 += this.mDecodeBufferInfo.bufferSize;
        this.mHasDecode = true;
        if (m != 0) {
          break label2091;
        }
        n = 10;
        long l6 = getCalcBitMinSize(this.mInformation);
        Logger.i("StreamDecodeDataComponent", axiliary("minSize: " + l6 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
        if (l6 <= 0L) {
          break label2095;
        }
        l4 = l2;
        l2 = l3;
        m = i;
        l3 = l4;
        l4 = l3;
        i = m;
        l5 = l2;
        Object localObject2;
        if (this.mDecodeBufferInfo.bufferSize < l6)
        {
          l4 = l3;
          i = m;
          l5 = l2;
          if (n >= 0)
          {
            this.mDecodeBufferInfo.setTempByteBufferCapacity(this.mBuffSize);
            m = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
            l5 = l3;
            l4 = l2;
            if (m > 0)
            {
              this.mDecodeBufferInfo.appendByte(this.mDecodeBufferInfo.tempByteBuffer, 0, m);
              localObject2 = this.mDecodeBufferInfo;
              ((BufferInfo)localObject2).bufferSize += m;
              l5 = l3 + m;
              l4 = l2 + m;
            }
            Logger.d("StreamDecodeDataComponent", axiliary("decode tmpSize: " + m + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
            n -= 1;
            l3 = l5;
            l2 = l4;
            continue;
          }
        }
        if (this.mInformation.getBitDept() == 0) {
          this.mInformation.setBitDept(AudioRecognition.calcBitDept(l4, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate()));
        }
        n = this.mInformation.getBitDept();
        if ((this.isUseFloatInHiRes) || (n < 3)) {
          break label2106;
        }
        Logger.w("StreamDecodeDataComponent", "mPlayBitDept is set with 2, old value: " + n);
        m = 2;
        Logger.d("StreamDecodeDataComponent", axiliary("mPlayBitDept: " + m));
        l3 = l5;
        l2 = l4;
        if (this.mNeedChangePlayThreadPriority)
        {
          this.mNeedChangePlayThreadPriority = false;
          PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        }
        l4 = System.currentTimeMillis();
        l5 = l4 - l1;
        if (l5 <= 1000L) {
          break label2088;
        }
        PlayerConfigManager.getInstance().updateDecodeSpeed(((float)l3 * 1.0F / (float)l5));
        l3 = 0L;
        l1 = l4;
        if (this.mDecodeBufferInfo.bufferSize <= 0) {
          break label2059;
        }
        if (!this.mHasDecodeSuccess)
        {
          this.mCallback.playerStarted(this.mCorePlayer);
          this.mHasDecodeSuccess = true;
        }
        handleHighBitDept(this.mDecodeBufferInfo, this.mNewBitDepthBufferInfo);
        handleHighSample(this.mNewBitDepthBufferInfo, this.mReSampleBufferInfo);
        if (this.isUseFloatInHiRes)
        {
          convertBytePcmToFloatPcm(this.mReSampleBufferInfo, this.mFloatBufferInfo);
          processAudioListeners(this.mFloatBufferInfo, this.mFloatBufferInfo);
          if ((this.mAudioTrack == null) || (!isPlaying())) {
            break label2071;
          }
          i = this.mTerminalAudioEffectList.size() - 1;
          if (i < 0) {
            break label2083;
          }
          localObject2 = (IAudioListener)this.mTerminalAudioEffectList.get(i);
          if (!((IAudioListener)localObject2).isEnabled()) {
            break label1817;
          }
          if (!this.isUseFloatInHiRes) {
            break label1798;
          }
          ((IAudioListener)localObject2).onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo);
          i = 1;
          if (i != 0) {
            break label2076;
          }
          if (!this.isUseFloatInHiRes) {
            break label1902;
          }
          i = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
          if (i >= 0) {
            break label1824;
          }
          Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write float failed: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(92, 102);
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException2)
      {
        Logger.e("StreamDecodeDataComponent", localSoNotFindException2);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(92, 62);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("StreamDecodeDataComponent", localThrowable);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(92, 67);
        return;
      }
      processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
      continue;
      label1798:
      localThrowable.onPcm(this.mDTSBufferInfo, this.mDTSBufferInfo);
      continue;
      label1817:
      i -= 1;
      continue;
      label1824:
      if (i != this.mFloatBufferInfo.bufferSize) {
        Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + i + ", expect: " + this.mFloatBufferInfo.bufferSize));
      }
      i = this.mFloatBufferInfo.bufferSize * 2 + j;
      label1889:
      for (j = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);; j = k)
      {
        k = j;
        break;
        label1902:
        i = this.mAudioTrack.write(this.mDTSBufferInfo.byteBuffer, 0, this.mDTSBufferInfo.bufferSize);
        if (i < 0)
        {
          Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes failed: " + i + ", expect: " + this.mDTSBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(92, 102);
          return;
        }
        if (i != this.mDTSBufferInfo.bufferSize) {
          Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + i + ", expect: " + this.mDTSBufferInfo.bufferSize));
        }
        i = this.mDTSBufferInfo.bufferSize + j;
        break label1889;
        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(i, 92);
        i = j;
        break;
        i = j;
      }
      label2059:
      label2071:
      label2076:
      label2083:
      i = 0;
      continue;
      label2088:
      continue;
      label2091:
      continue;
      label2094:
      return;
      label2095:
      long l4 = l2;
      long l5 = l3;
      continue;
      label2106:
      m = n;
      if (n > 0) {}
    }
  }
  
  void release()
  {
    super.release();
    this.mCurrentFrameCount = 0L;
  }
  
  void seek(int paramInt)
  {
    addSeekRecord(paramInt);
    refreshTimeAndNotify(paramInt);
  }
  
  void setAudioStreamType(int paramInt)
  {
    if (paramInt == this.mAudioStreamType) {}
    for (;;)
    {
      return;
      try
      {
        this.mAudioStreamType = paramInt;
        if (this.mAudioTrack == null) {
          continue;
        }
        AudioTrack localAudioTrack = new AudioTrack(paramInt, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
        Logger.i("StreamDecodeDataComponent", axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
        int i = this.mAudioTrack.getPlayState();
        if (i == 3) {
          pause();
        }
        this.mAudioTrack.release();
        this.mAudioTrack = localAudioTrack;
        if (i != 3) {
          continue;
        }
        play();
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        Logger.e("StreamDecodeDataComponent", "failed in setting audio stream type to :" + paramInt, localIllegalArgumentException);
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        label170:
        break label170;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */