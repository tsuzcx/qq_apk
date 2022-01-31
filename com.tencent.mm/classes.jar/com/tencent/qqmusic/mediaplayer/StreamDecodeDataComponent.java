package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private long mCurrentFrameCount;
  private boolean mNeedFlush;
  private final Stack<Integer> mSeekRecord;
  private int mTrackBufferSizeInByte;
  
  StreamDecodeDataComponent(CorePlayer paramCorePlayer, PlayerStateRunner paramPlayerStateRunner, AudioInformation paramAudioInformation, PlayerCallback paramPlayerCallback, BaseDecodeDataComponent.HandleDecodeDataCallback paramHandleDecodeDataCallback, Handler paramHandler, int paramInt)
  {
    super(paramCorePlayer, paramPlayerStateRunner, paramAudioInformation, paramPlayerCallback, paramHandleDecodeDataCallback, paramHandler, paramInt);
    AppMethodBeat.i(104488);
    this.mSeekRecord = new Stack();
    this.mCurrentFrameCount = 0L;
    this.mNeedFlush = false;
    AppMethodBeat.o(104488);
  }
  
  private void addSeekRecord(int paramInt)
  {
    AppMethodBeat.i(104494);
    synchronized (this.mSeekRecord)
    {
      Logger.i("StreamDecodeDataComponent", "add seek: ".concat(String.valueOf(paramInt)));
      this.mSeekRecord.push(Integer.valueOf(paramInt));
      AppMethodBeat.o(104494);
      return;
    }
  }
  
  private boolean createAudioTrack()
  {
    AppMethodBeat.i(104492);
    Logger.d("StreamDecodeDataComponent", axiliary("createAudioTrack"));
    if (!this.mStateRunner.isEqual(new Integer[] { Integer.valueOf(3) }))
    {
      Logger.e("StreamDecodeDataComponent", "mState is not preparing");
      callExceptionCallback(91, 54);
      AppMethodBeat.o(104492);
      return false;
    }
    if (this.mInformation.getSampleRate() <= 0L)
    {
      Logger.e("StreamDecodeDataComponent", "mInformation.getSampleRate() failed");
      callExceptionCallback(91, 64);
      AppMethodBeat.o(104492);
      return false;
    }
    int i = 12;
    int i2 = this.mInformation.getChannels();
    if (i2 == 1) {
      i = 4;
    }
    int i1;
    for (;;)
    {
      i1 = (int)this.mHandleDecodeDataCallback.getMinPcmBufferSize();
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
    int j = getBytesPerSampleInPlay(this.mInformation.getBitDept());
    int m = j;
    if (j == 0) {
      m = 2;
    }
    label376:
    int n;
    int k;
    if ((CAN_USE_FLOAT_IN_HI_RES) && (this.mInformation.getBitDept() >= 3) && (this.mInformation.getSampleRate() > 48000L))
    {
      this.mPlayBitDepth = m;
      this.isUseFloatInHiRes = true;
      if (this.mPlaySample != this.mInformation.getSampleRate())
      {
        Logger.i("StreamDecodeDataComponent", axiliary("will use float resampled pcm for Hi-Res, bitDept: " + this.mInformation.getBitDept() + ", origin sample rate: " + this.mInformation.getSampleRate() + ", target sample rate: " + this.mPlaySample));
        j = 2;
        if (m != 1) {
          break label1118;
        }
        j = 3;
        n = getMinBufferSize(this.mPlaySample, i, j, i2, m);
        Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] playback_bufsize:" + n + " decoderBufsizeInByte:" + i1));
        k = n;
        if (n % 2048 != 0) {
          k = (n / 2048 + 1) * 2048;
        }
        n = i1;
        if (k > i1) {
          n = k;
        }
        this.mBuffSize = n;
        Logger.i("StreamDecodeDataComponent", axiliary(String.format("playback_bufsize: %d, mBuffSize: %d, mPlaySample: %d, playChannel: %d, pcmEncoding: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mBuffSize), Long.valueOf(this.mPlaySample), Integer.valueOf(i2), Integer.valueOf(j) })));
        n = Math.max((int)(Math.floor(1L * this.mPlaySample * i2 * 2L / k) + 1.0D), 1);
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
          this.mAudioTrack = new AudioTrack(this.mAudioStreamType, (int)this.mPlaySample, i, j, this.mTrackBufferSizeInByte, 1);
          Logger.i("StreamDecodeDataComponent", axiliary("[createAudioTrack] new AudioTrack, sampleRate: " + this.mPlaySample + ", channels: " + i + ", bitDepth: " + m + ", buffer: " + this.mTrackBufferSizeInByte));
          i1 = this.mAudioTrack.getState();
          if (i1 == 1)
          {
            Logger.i("StreamDecodeDataComponent", axiliary("new AudioTrack succeed"));
            if ((this.mAudioTrack == null) || (this.mAudioTrack.getState() != 1)) {
              break label1189;
            }
            Logger.d("StreamDecodeDataComponent", axiliary("create audioTrack success times = ".concat(String.valueOf(n))));
            this.mStateRunner.setAudioTrack(this.mAudioTrack);
            AppMethodBeat.o(104492);
            return true;
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
            label1118:
            if (m == 2)
            {
              j = 2;
              break label376;
            }
            if (!this.isUseFloatInHiRes) {
              break label376;
            }
            j = 4;
            break label376;
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
          this.mAudioTrack = null;
          callExceptionCallback(92, 66);
          AppMethodBeat.o(104492);
        }
      }
      n -= 2;
    }
    label1189:
    return false;
  }
  
  private long getCalcBitMinSize(AudioInformation paramAudioInformation)
  {
    AppMethodBeat.i(104495);
    if (paramAudioInformation != null)
    {
      long l = ((float)(paramAudioInformation.getSampleRate() * paramAudioInformation.getChannels() * paramAudioInformation.getBitDept()) * 5.0F / 1000.0F);
      AppMethodBeat.o(104495);
      return l;
    }
    AppMethodBeat.o(104495);
    return 0L;
  }
  
  private int getMinBufferSize(long paramLong, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(104493);
    int j = AudioTrack.getMinBufferSize((int)paramLong, paramInt1, paramInt2);
    int i = j;
    if (j < 0)
    {
      Logger.i("StreamDecodeDataComponent", axiliary("minBufferSize = " + j + " mPlaySample = " + paramLong + "  channelConfiguration = " + paramInt1 + "   pcmEncoding = " + paramInt2));
      i = paramInt3 * 3536 * paramInt4;
    }
    AppMethodBeat.o(104493);
    return i;
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
    AppMethodBeat.i(104497);
    AudioTrack localAudioTrack = this.mAudioTrack;
    if ((localAudioTrack == null) || (localAudioTrack.getState() == 0))
    {
      l = this.mCurPosition;
      AppMethodBeat.o(104497);
      return l;
    }
    AudioInformation localAudioInformation = this.mInformation;
    if (localAudioInformation == null)
    {
      l = this.mCurPosition;
      AppMethodBeat.o(104497);
      return l;
    }
    int i = getAudioTrackPosition(this.mCurrentFrameCount, localAudioTrack);
    long l = localAudioInformation.getChannels() * getBytesPerSampleInPlay(localAudioInformation.getBitDept());
    l = localAudioInformation.getPlaySample() * l;
    if (l > 0L)
    {
      l = this.mTrackBufferSizeInByte / l * 1000L;
      l = this.mHandleDecodeDataCallback.getCurPositionByDecoder() - Math.max(0L, l);
      if (l >= 0L) {
        break label161;
      }
      this.mCurPosition = i;
    }
    for (;;)
    {
      l = this.mCurPosition;
      AppMethodBeat.o(104497);
      return l;
      l = 0L;
      break;
      label161:
      if ((i > 0) && (Math.abs(i - l) < 1000L)) {
        this.mCurPosition = i;
      } else {
        this.mCurPosition = l;
      }
    }
  }
  
  void handleDecodeData()
  {
    AppMethodBeat.i(104491);
    int m;
    long l2;
    long l5;
    long l1;
    int i;
    int i2;
    int k;
    int j;
    int i1;
    int n;
    label952:
    if ((this.mInformation != null) && (!this.mCorePlayer.mIsExit))
    {
      try
      {
        if (0L == this.mInformation.getSampleRate())
        {
          Logger.e("StreamDecodeDataComponent", "failed to getSampleRate");
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(91, 63);
          AppMethodBeat.o(104491);
          return;
        }
        this.mHasInit = true;
        if (!createAudioTrack())
        {
          Logger.e("StreamDecodeDataComponent", "failed to createAudioTrack");
          this.mStateRunner.transfer(Integer.valueOf(9));
          AppMethodBeat.o(104491);
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
        l2 = 0L;
        l5 = System.currentTimeMillis();
        l1 = 0L;
        i = 0;
        i2 = 0;
        k = 1;
        j = 0;
      }
      if (!this.mCorePlayer.mIsExit) {
        i1 = -1;
      }
    }
    else
    {
      synchronized (this.mSeekRecord)
      {
        if (!this.mSeekRecord.empty())
        {
          i1 = ((Integer)this.mSeekRecord.pop()).intValue();
          this.mSeekRecord.clear();
          Logger.i("StreamDecodeDataComponent", "execute seek: " + i1 + ", abandon the others");
        }
        n = i1;
        if (i1 < 0)
        {
          n = i1;
          if (this.mNeedFlush)
          {
            n = getAudioTrackPosition(this.mCurrentFrameCount, this.mAudioTrack);
            Logger.i("StreamDecodeDataComponent", axiliary("[run] flashback to ".concat(String.valueOf(n))));
            this.mNeedFlush = false;
          }
        }
        i1 = i;
        if (n < 0) {
          break label702;
        }
        i1 = n;
        if (n > this.mInformation.getDuration() - 1000L)
        {
          i1 = n;
          if (this.mInformation.getDuration() > 1000L) {
            i1 = (int)(this.mInformation.getDuration() - 1000L);
          }
        }
        n = this.mHandleDecodeDataCallback.seekTo(i1);
        if (n < 0)
        {
          Logger.e("StreamDecodeDataComponent", axiliary("seekTo failed: ".concat(String.valueOf(n))));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(95, 74);
          AppMethodBeat.o(104491);
          return;
          if (!this.mCorePlayer.mIsExit)
          {
            Logger.e("StreamDecodeDataComponent", axiliary("不留痕迹的退出 时机：获取Information时 step = 3"));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(91, 63);
          }
          AppMethodBeat.o(104491);
          return;
        }
      }
      if (this.mAudioTrack != null)
      {
        this.mCurrentFrameCount = Math.round(i1 / 1000.0D * this.mAudioTrack.getSampleRate());
        if (this.mAudioTrack.getPlayState() != 3) {
          break label757;
        }
        this.mAudioTrack.pause();
        this.mAudioTrack.flush();
        this.mAudioTrack.play();
      }
      for (;;)
      {
        i = 0;
        this.mCurPosition = i1;
        this.mTimer.refreshTimeInMs(i1);
        notifySeekCompleteForAudioListeners(i1);
        this.mCallback.playerSeekCompletion(this.mCorePlayer, i1);
        i1 = i;
        label702:
        i = i1;
        if (!isPaused()) {
          break label767;
        }
        postRunnable(new StreamDecodeDataComponent.2(this), 20);
        Logger.i("StreamDecodeDataComponent", axiliary("paused. waiting..."));
        doWaitForPaused();
        Logger.i("StreamDecodeDataComponent", axiliary("woke after pausing"));
        break;
        label757:
        this.mAudioTrack.flush();
      }
      label767:
      if ((!isIdle()) && (!isError()) && (!isStopped()))
      {
        if (isCompleted())
        {
          k = i / this.mInformation.getChannels() - j;
          if (k > 0)
          {
            m = this.mTrackBufferSizeInByte / getBytesPerSampleInPlay(this.mInformation.getBitDept()) / this.mInformation.getChannels();
            if (k >= m) {
              break label952;
            }
          }
          for (;;)
          {
            k = (int)(k * 1000 / this.mInformation.getSampleRate());
            m = AudioPlayerConfigure.minAudioTrackWaitTimeMs;
            Logger.i("StreamDecodeDataComponent", axiliary("writeShortCount: " + i + ", playFramePosition: " + j + ", leftTimeInMs: " + k + ", minAudioTrackWaitTimeMs: " + m));
            if (k <= 0) {
              break label2230;
            }
            try
            {
              wait(Math.max(m, k));
              return;
            }
            finally
            {
              AppMethodBeat.o(104491);
            }
            k = 0;
            break;
            k = m;
          }
        }
        if (k == 0) {
          break label2260;
        }
      }
    }
    for (;;)
    {
      try
      {
        n = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.byteBuffer);
        this.mDecodeBufferInfo.bufferSize = n;
        l2 = this.mDecodeBufferInfo.bufferSize + l2;
        l1 = this.mDecodeBufferInfo.bufferSize + l1;
        this.mHasDecode = true;
        if (m != 0) {
          break label2257;
        }
        i1 = 10;
        long l6 = getCalcBitMinSize(this.mInformation);
        Logger.i("StreamDecodeDataComponent", axiliary("minSize: " + l6 + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
        if (l6 <= 0L) {
          break label2267;
        }
        l3 = l2;
        m = n;
        l4 = l1;
        Object localObject2;
        if (this.mDecodeBufferInfo.bufferSize < l6)
        {
          l3 = l2;
          m = n;
          l4 = l1;
          if (i1 >= 0)
          {
            this.mDecodeBufferInfo.setTempByteBufferCapacity(this.mBuffSize);
            n = this.mHandleDecodeDataCallback.pullDecodeData(this.mBuffSize, this.mDecodeBufferInfo.tempByteBuffer);
            l4 = l2;
            l3 = l1;
            if (n > 0)
            {
              this.mDecodeBufferInfo.appendByte(this.mDecodeBufferInfo.tempByteBuffer, 0, n);
              localObject2 = this.mDecodeBufferInfo;
              ((BufferInfo)localObject2).bufferSize += n;
              l4 = l2 + n;
              l3 = l1 + n;
            }
            Logger.d("StreamDecodeDataComponent", axiliary("decode tmpSize: " + n + ", mDecodeBufferInfo.bufferSize: " + this.mDecodeBufferInfo.bufferSize));
            i1 -= 1;
            l2 = l4;
            l1 = l3;
            continue;
          }
        }
        if (this.mInformation.getBitDept() == 0) {
          this.mInformation.setBitDept(AudioRecognition.calcBitDept(l3, this.mHandleDecodeDataCallback.getCurPositionByDecoder(), this.mInformation.getChannels(), this.mInformation.getSampleRate()));
        }
        i1 = this.mInformation.getBitDept();
        if ((this.isUseFloatInHiRes) || (i1 < 3)) {
          break label2282;
        }
        Logger.w("StreamDecodeDataComponent", "mPlayBitDept is set with 2, old value: ".concat(String.valueOf(i1)));
        n = 2;
        Logger.d("StreamDecodeDataComponent", axiliary("mPlayBitDept: ".concat(String.valueOf(n))));
        i1 = m;
        l1 = l4;
        l2 = l3;
        m = n;
        n = i1;
        if (this.mNeedChangePlayThreadPriority)
        {
          this.mNeedChangePlayThreadPriority = false;
          PlayerConfigManager.getInstance().changeDecodeThreadPriorityIfNeed();
        }
        l3 = System.currentTimeMillis();
        l4 = l3 - l5;
        if (l4 <= 1000L) {
          break label2254;
        }
        PlayerConfigManager.getInstance().updateDecodeSpeed((1.0F * (float)l1 / (float)l4));
        l1 = 0L;
        l5 = l3;
        if (this.mDecodeBufferInfo.bufferSize <= 0) {
          break label2210;
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
            break label2223;
          }
          i1 = this.mTerminalAudioEffectList.size() - 1;
          if (i1 < 0) {
            break label2248;
          }
          localObject2 = (IAudioListener)this.mTerminalAudioEffectList.get(i1);
          if (!((IAudioListener)localObject2).isEnabled()) {
            break label1901;
          }
          if (!this.isUseFloatInHiRes) {
            break label1882;
          }
          ((IAudioListener)localObject2).onPcm(this.mFloatBufferInfo, this.mFloatBufferInfo);
          i1 = 1;
          if (i1 != 0) {
            break label2237;
          }
          if (!this.isUseFloatInHiRes) {
            break label2017;
          }
          k = this.mAudioTrack.write(this.mFloatBufferInfo.floatBuffer, 0, this.mFloatBufferInfo.bufferSize, 0);
          if (k >= 0) {
            break label1947;
          }
          if (this.mAudioTrack.getPlayState() != 3) {
            break label1910;
          }
          Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write float failed: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
          this.mStateRunner.transfer(Integer.valueOf(9));
          callExceptionCallback(92, 102);
          AppMethodBeat.o(104491);
          return;
        }
      }
      catch (SoNotFindException localSoNotFindException2)
      {
        Logger.e("StreamDecodeDataComponent", localSoNotFindException2);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(92, 62);
        AppMethodBeat.o(104491);
        return;
      }
      catch (Throwable localThrowable)
      {
        Logger.e("StreamDecodeDataComponent", localThrowable);
        this.mStateRunner.transfer(Integer.valueOf(9));
        callExceptionCallback(92, 67);
        AppMethodBeat.o(104491);
        return;
      }
      processAudioListeners(this.mReSampleBufferInfo, this.mDTSBufferInfo);
      continue;
      label1882:
      localThrowable.onPcm(this.mDTSBufferInfo, this.mDTSBufferInfo);
      continue;
      label1901:
      i1 -= 1;
      continue;
      label1910:
      j = 0;
      Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
      label1924:
      for (k = AudioUtil.getPlaybackHeadPositionSafely(this.mAudioTrack);; k = i1)
      {
        i1 = k;
        i2 = n;
        k = j;
        j = i1;
        break;
        label1947:
        j = 1;
        if (k != this.mFloatBufferInfo.bufferSize) {
          Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write float not equal: " + k + ", expect: " + this.mFloatBufferInfo.bufferSize));
        }
        i += this.mFloatBufferInfo.bufferSize * 2;
        break label1924;
        label2017:
        k = this.mAudioTrack.write(this.mDTSBufferInfo.byteBuffer, 0, this.mDTSBufferInfo.bufferSize);
        if (k < 0)
        {
          if (this.mAudioTrack.getPlayState() == 3)
          {
            Logger.e("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes failed: " + k + ", expect: " + this.mDTSBufferInfo.bufferSize));
            this.mStateRunner.transfer(Integer.valueOf(9));
            callExceptionCallback(92, 102);
            AppMethodBeat.o(104491);
            return;
          }
          j = 0;
          Logger.i("StreamDecodeDataComponent", axiliary("write data to audiotrack failed, but it's OK"));
          break label1924;
        }
        j = 1;
        if (k != this.mDTSBufferInfo.bufferSize) {
          Logger.w("StreamDecodeDataComponent", axiliary("mAudioTrack write bytes not equal: " + k + ", expect: " + this.mDTSBufferInfo.bufferSize));
        }
        i += this.mDTSBufferInfo.bufferSize;
        break label1924;
        label2210:
        this.mHandleDecodeDataCallback.onPullDecodeDataEndOrFailed(n, 92);
        label2223:
        i2 = n;
        break;
        label2230:
        AppMethodBeat.o(104491);
        return;
        label2237:
        i1 = j;
        j = k;
      }
      label2248:
      i1 = 0;
      continue;
      label2254:
      continue;
      label2257:
      continue;
      label2260:
      n = i2;
      continue;
      label2267:
      m = n;
      long l3 = l2;
      long l4 = l1;
      continue;
      label2282:
      n = i1;
      if (i1 > 0) {}
    }
  }
  
  void pause()
  {
    AppMethodBeat.i(104490);
    super.pause();
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 1) && (this.mAudioTrack.getPlayState() != 2)) {
      try
      {
        this.mAudioTrack.pause();
        AppMethodBeat.o(104490);
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}
    }
    AppMethodBeat.o(104490);
  }
  
  void play()
  {
    AppMethodBeat.i(104489);
    super.play();
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getState() == 1) && (this.mAudioTrack.getPlayState() != 3)) {
      try
      {
        this.mAudioTrack.play();
        AppMethodBeat.o(104489);
        return;
      }
      catch (IllegalStateException localIllegalStateException) {}
    }
    AppMethodBeat.o(104489);
  }
  
  void release()
  {
    AppMethodBeat.i(104499);
    super.release();
    this.mCurrentFrameCount = 0L;
    AppMethodBeat.o(104499);
  }
  
  void seek(int paramInt)
  {
    AppMethodBeat.i(104498);
    addSeekRecord(paramInt);
    refreshTimeAndNotify(paramInt);
    AppMethodBeat.o(104498);
  }
  
  void setAudioStreamType(int paramInt)
  {
    AppMethodBeat.i(104496);
    if (paramInt == this.mAudioStreamType)
    {
      AppMethodBeat.o(104496);
      return;
    }
    try
    {
      this.mAudioStreamType = paramInt;
      if (this.mAudioTrack != null)
      {
        AudioTrack localAudioTrack = new AudioTrack(paramInt, this.mAudioTrack.getSampleRate(), this.mAudioTrack.getChannelConfiguration(), this.mAudioTrack.getAudioFormat(), this.mTrackBufferSizeInByte, 1);
        Logger.i("StreamDecodeDataComponent", axiliary("[setAudioStreamType] new AudioTrack, sampleRate: " + this.mAudioTrack.getSampleRate() + ", channels: " + this.mAudioTrack.getChannelConfiguration() + ", bitDepth: " + this.mAudioTrack.getAudioFormat() + ", buffer: " + this.mTrackBufferSizeInByte));
        int i = this.mAudioTrack.getPlayState();
        if (i == 3) {
          pause();
        }
        this.mAudioTrack.release();
        this.mAudioTrack = localAudioTrack;
        this.mStateRunner.setAudioTrack(this.mAudioTrack);
        if (i == 3) {
          play();
        }
      }
      AppMethodBeat.o(104496);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      Logger.e("StreamDecodeDataComponent", "failed in setting audio stream type to :".concat(String.valueOf(paramInt)), localIllegalStateException);
      AppMethodBeat.o(104496);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      label199:
      break label199;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.StreamDecodeDataComponent
 * JD-Core Version:    0.7.0.1
 */