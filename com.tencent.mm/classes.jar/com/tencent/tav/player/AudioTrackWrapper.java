package com.tencent.tav.player;

import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.logger.Logger;

public class AudioTrackWrapper
{
  private static final String TAG = "AudioTrackWrapper";
  private AudioTrack mAudioTrack;
  
  public AudioTrackWrapper(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218538);
    try
    {
      init(paramInt1, paramInt2);
      AppMethodBeat.o(218538);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(218538);
    }
  }
  
  public AudioTrackWrapper(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218537);
    try
    {
      init(paramMediaFormat.getInteger("sample-rate"), paramMediaFormat.getInteger("channel-count"));
      AppMethodBeat.o(218537);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      AppMethodBeat.o(218537);
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218544);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(218544);
      return;
    }
    AudioTrackConfig localAudioTrackConfig = new AudioTrackConfig(paramInt1, paramInt2);
    Logger.d("AudioTrackWrapper", "init:--> ".concat(String.valueOf(this)));
    try
    {
      this.mAudioTrack = new AudioTrack(localAudioTrackConfig.streamType, localAudioTrackConfig.sampleRateInHz, localAudioTrackConfig.channelConfig, localAudioTrackConfig.audioFormat, localAudioTrackConfig.bufferSizeInBytes, localAudioTrackConfig.mode);
      if (this.mAudioTrack != null) {
        this.mAudioTrack.play();
      }
      AppMethodBeat.o(218544);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;)
      {
        this.mAudioTrack = null;
      }
    }
  }
  
  public boolean allow()
  {
    return this.mAudioTrack != null;
  }
  
  public void flush()
  {
    AppMethodBeat.i(218542);
    if (!allow())
    {
      AppMethodBeat.o(218542);
      return;
    }
    try
    {
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      AppMethodBeat.o(218542);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AudioTrackWrapper", "flush: ", localException);
      AppMethodBeat.o(218542);
    }
  }
  
  public void parse()
  {
    AppMethodBeat.i(218540);
    if (!allow())
    {
      AppMethodBeat.o(218540);
      return;
    }
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getPlayState() == 3)) {
      this.mAudioTrack.pause();
    }
    AppMethodBeat.o(218540);
  }
  
  public void release()
  {
    AppMethodBeat.i(218543);
    if (!allow())
    {
      AppMethodBeat.o(218543);
      return;
    }
    stop();
    this.mAudioTrack.release();
    Logger.d("AudioTrackWrapper", "release:--> ".concat(String.valueOf(this)));
    AppMethodBeat.o(218543);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(218545);
    if (!allow())
    {
      AppMethodBeat.o(218545);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mAudioTrack.setVolume(paramFloat);
      AppMethodBeat.o(218545);
      return;
    }
    this.mAudioTrack.setStereoVolume(paramFloat, paramFloat);
    AppMethodBeat.o(218545);
  }
  
  public void stop()
  {
    AppMethodBeat.i(218539);
    if (!allow())
    {
      AppMethodBeat.o(218539);
      return;
    }
    if ((this.mAudioTrack.getState() == 3) || (this.mAudioTrack.getState() == 2)) {
      this.mAudioTrack.stop();
    }
    AppMethodBeat.o(218539);
  }
  
  public void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218541);
    if (!allow())
    {
      AppMethodBeat.o(218541);
      return;
    }
    if (this.mAudioTrack != null) {
      try
      {
        this.mAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2);
        if (this.mAudioTrack.getPlayState() != 3) {
          this.mAudioTrack.play();
        }
        AppMethodBeat.o(218541);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218541);
  }
  
  static class AudioTrackConfig
  {
    int audioFormat;
    int bufferSizeInBytes;
    int channelConfig;
    int mode;
    int sampleRateInHz;
    int streamType;
    
    public AudioTrackConfig(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(218535);
      this.streamType = 3;
      this.channelConfig = 12;
      this.audioFormat = 2;
      this.mode = 1;
      this.sampleRateInHz = getSampleRateInHz(paramInt1, paramInt2);
      this.bufferSizeInBytes = 8192;
      AppMethodBeat.o(218535);
    }
    
    private int getSampleRateInHz(int paramInt1, int paramInt2)
    {
      int i = paramInt1;
      if (paramInt2 == 1) {
        i = paramInt1 / 2;
      }
      return i;
    }
    
    public String toString()
    {
      AppMethodBeat.i(218536);
      String str = "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
      AppMethodBeat.o(218536);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper
 * JD-Core Version:    0.7.0.1
 */