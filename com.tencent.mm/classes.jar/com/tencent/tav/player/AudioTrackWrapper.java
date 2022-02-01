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
    AppMethodBeat.i(202089);
    try
    {
      init(paramInt1, paramInt2);
      AppMethodBeat.o(202089);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(202089);
    }
  }
  
  public AudioTrackWrapper(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(202088);
    try
    {
      init(paramMediaFormat.getInteger("sample-rate"), paramMediaFormat.getInteger("channel-count"));
      AppMethodBeat.o(202088);
      return;
    }
    catch (Exception paramMediaFormat)
    {
      AppMethodBeat.o(202088);
    }
  }
  
  private void init(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202095);
    if (paramInt1 <= 0)
    {
      AppMethodBeat.o(202095);
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
      AppMethodBeat.o(202095);
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
    AppMethodBeat.i(202093);
    if (!allow())
    {
      AppMethodBeat.o(202093);
      return;
    }
    try
    {
      if (this.mAudioTrack != null) {
        this.mAudioTrack.flush();
      }
      AppMethodBeat.o(202093);
      return;
    }
    catch (Exception localException)
    {
      Logger.e("AudioTrackWrapper", localException);
      AppMethodBeat.o(202093);
    }
  }
  
  public void parse()
  {
    AppMethodBeat.i(202091);
    if (!allow())
    {
      AppMethodBeat.o(202091);
      return;
    }
    if ((this.mAudioTrack != null) && (this.mAudioTrack.getPlayState() == 3)) {
      this.mAudioTrack.pause();
    }
    AppMethodBeat.o(202091);
  }
  
  public void release()
  {
    AppMethodBeat.i(202094);
    if (!allow())
    {
      AppMethodBeat.o(202094);
      return;
    }
    stop();
    this.mAudioTrack.release();
    new StringBuilder("release:--> ").append(this);
    AppMethodBeat.o(202094);
  }
  
  public void setVolume(float paramFloat)
  {
    AppMethodBeat.i(202096);
    if (!allow())
    {
      AppMethodBeat.o(202096);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.mAudioTrack.setVolume(paramFloat);
      AppMethodBeat.o(202096);
      return;
    }
    this.mAudioTrack.setStereoVolume(paramFloat, paramFloat);
    AppMethodBeat.o(202096);
  }
  
  public void stop()
  {
    AppMethodBeat.i(202090);
    if (!allow())
    {
      AppMethodBeat.o(202090);
      return;
    }
    if ((this.mAudioTrack.getState() == 3) || (this.mAudioTrack.getState() == 2)) {
      this.mAudioTrack.stop();
    }
    AppMethodBeat.o(202090);
  }
  
  public void writeData(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(202092);
    if (!allow())
    {
      AppMethodBeat.o(202092);
      return;
    }
    if (this.mAudioTrack != null) {
      try
      {
        this.mAudioTrack.write(paramArrayOfByte, paramInt1, paramInt2);
        if (this.mAudioTrack.getPlayState() != 3) {
          this.mAudioTrack.play();
        }
        AppMethodBeat.o(202092);
        return;
      }
      catch (Exception paramArrayOfByte) {}
    }
    AppMethodBeat.o(202092);
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
      AppMethodBeat.i(202086);
      this.streamType = 3;
      this.channelConfig = 12;
      this.audioFormat = 2;
      this.mode = 1;
      this.sampleRateInHz = getSampleRateInHz(paramInt1, paramInt2);
      this.bufferSizeInBytes = 8192;
      AppMethodBeat.o(202086);
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
      AppMethodBeat.i(202087);
      String str = "AudioTrackConfig{streamType=" + this.streamType + ", sampleRateInHz=" + this.sampleRateInHz + ", channelConfig=" + this.channelConfig + ", audioFormat=" + this.audioFormat + ", bufferSizeInBytes=" + this.bufferSizeInBytes + ", mode=" + this.mode + '}';
      AppMethodBeat.o(202087);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.AudioTrackWrapper
 * JD-Core Version:    0.7.0.1
 */