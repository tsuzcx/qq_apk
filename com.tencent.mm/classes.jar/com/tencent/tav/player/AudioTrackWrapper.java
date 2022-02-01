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
    AppMethodBeat.i(218547);
    try
    {
      init(paramInt1, paramInt2);
      AppMethodBeat.o(218547);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(218547);
    }
  }
  
  public AudioTrackWrapper(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(218546);
    try
    {
      init(paramMediaFormat.getInteger("sample-rate"), paramMediaFormat.getInteger("channel-count"));
      AppMethodBeat.o(218546);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      AppMethodBeat.o(218546);
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218553);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(218553);
      return;
    }
    AudioTrackConfig localAudioTrackConfig = new AudioTrackConfig(paramInt1, paramInt2);
    new StringBuilder("init:--> ").append(this);
    try
    {
      this.mAudioTrack = new AudioTrack(localAudioTrackConfig.streamType, localAudioTrackConfig.sampleRateInHz, localAudioTrackConfig.channelConfig, localAudioTrackConfig.audioFormat, localAudioTrackConfig.bufferSizeInBytes, localAudioTrackConfig.mode);
      if (this.mAudioTrack != null) {
        this.mAudioTrack.play();
      }
      AppMethodBeat.o(218553);
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
    AppMethodBeat.i(218551);
    if (!allow())
    {
      AppMethodBeat.o(218551);
      return;
    }
    try
    {
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      AppMethodBeat.o(218551);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AudioTrackWrapper", "flush: ", localException);
      AppMethodBeat.o(218551);
    }
  }
  
  public void parse()
  {
    AppMethodBeat.i(218549);
    if (!allow())
    {
      AppMethodBeat.o(218549);
      return;
    }
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getPlayState() == 3)) {
      this.mAudioTrack.pause();
    }
    AppMethodBeat.o(218549);
  }
  
  public void release()
  {
    AppMethodBeat.i(218552);
    if (!allow())
    {
      AppMethodBeat.o(218552);
      return;
    }
    stop();
    this.mAudioTrack.release();
    new StringBuilder("release:--> ").append(this);
    AppMethodBeat.o(218552);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(218554);
    if (!allow())
    {
      AppMethodBeat.o(218554);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mAudioTrack.setVolume(paramFloat);
      AppMethodBeat.o(218554);
      return;
    }
    this.mAudioTrack.setStereoVolume(paramFloat, paramFloat);
    AppMethodBeat.o(218554);
  }
  
  public void stop()
  {
    AppMethodBeat.i(218548);
    if (!allow())
    {
      AppMethodBeat.o(218548);
      return;
    }
    if ((this.mAudioTrack.getState() == 3) || (this.mAudioTrack.getState() == 2)) {
      this.mAudioTrack.stop();
    }
    AppMethodBeat.o(218548);
  }
  
  public void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(218550);
    if (!allow())
    {
      AppMethodBeat.o(218550);
      return;
    }
    if (this.mAudioTrack != null) {
      try
      {
        this.mAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2);
        if (this.mAudioTrack.getPlayState() != 3) {
          this.mAudioTrack.play();
        }
        AppMethodBeat.o(218550);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(218550);
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
      AppMethodBeat.i(218544);
      this.streamType = 3;
      this.channelConfig = 12;
      this.audioFormat = 2;
      this.mode = 1;
      this.sampleRateInHz = getSampleRateInHz(paramInt1, paramInt2);
      this.bufferSizeInBytes = 8192;
      AppMethodBeat.o(218544);
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
      AppMethodBeat.i(218545);
      String str = "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
      AppMethodBeat.o(218545);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper
 * JD-Core Version:    0.7.0.1
 */