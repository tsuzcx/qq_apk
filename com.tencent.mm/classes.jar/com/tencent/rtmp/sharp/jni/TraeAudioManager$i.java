package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$i
  extends TraeAudioManager.k
{
  TraeAudioManager$i(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    AppMethodBeat.i(65658);
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag))
    {
      this.a.InternalSetSpeaker(this.a._context, false);
      this.a._am.setWiredHeadsetOn(true);
    }
    f();
    if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
    {
      a.dUd();
      a.iP("TRAE", "connect headset: do nothing");
      AppMethodBeat.o(65658);
      return;
    }
    if (!TraeAudioManager.enableDeviceSwitchFlag)
    {
      a.dUd();
      a.iP("TRAE", "connect headset: disableDeviceSwitchFlag");
      AppMethodBeat.o(65658);
      return;
    }
    for (;;)
    {
      long l;
      if (this.b == true)
      {
        if (this.a._am.isSpeakerphoneOn()) {
          this.a.InternalSetSpeaker(this.a._context, false);
        }
        if (i < 5) {
          l = 1000L;
        }
      }
      try
      {
        for (;;)
        {
          Thread.sleep(l);
          label156:
          i += 1;
          break;
          l = 4000L;
        }
        AppMethodBeat.o(65658);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label156;
      }
      int i = 0;
    }
  }
  
  public String b()
  {
    return "DEVICE_WIREDHEADSET";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.i
 * JD-Core Version:    0.7.0.1
 */