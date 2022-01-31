package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$j
  extends TraeAudioManager.k
{
  TraeAudioManager$j(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    AppMethodBeat.i(65649);
    int i = 0;
    if ((!TraeAudioManager.IsMusicScene) && (TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag)) {
      this.a.InternalSetSpeaker(this.a._context, true);
    }
    f();
    if ((TraeAudioManager.IsMusicScene) || (!TraeAudioManager.IsUpdateSceneFlag))
    {
      a.dUd();
      a.iP("TRAE", "connect speakerPhone: do nothing");
      AppMethodBeat.o(65649);
      return;
    }
    if (!TraeAudioManager.enableDeviceSwitchFlag)
    {
      a.dUd();
      a.iP("TRAE", "connect speakerPhone: disableDeviceSwitchFlag");
      AppMethodBeat.o(65649);
      return;
    }
    a.dUd();
    a.iP("TRAE", " _run:" + b() + " _running:" + this.b);
    for (;;)
    {
      long l;
      if (this.b == true)
      {
        if (this.a._am.isSpeakerphoneOn() != true) {
          this.a.InternalSetSpeaker(this.a._context, true);
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
          label188:
          i += 1;
          break;
          l = 4000L;
        }
        AppMethodBeat.o(65649);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label188;
      }
    }
  }
  
  public String b()
  {
    return "DEVICE_SPEAKERPHONE";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.j
 * JD-Core Version:    0.7.0.1
 */