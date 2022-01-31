package com.tencent.rtmp.sharp.jni;

import android.media.AudioManager;
import com.tencent.d.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

class TraeAudioManager$h
  extends TraeAudioManager.k
{
  TraeAudioManager$h(TraeAudioManager paramTraeAudioManager)
  {
    super(paramTraeAudioManager);
  }
  
  public void a()
  {
    AppMethodBeat.i(65798);
    if ((TraeAudioManager.IsUpdateSceneFlag) && (TraeAudioManager.enableDeviceSwitchFlag)) {
      this.a.InternalSetSpeaker(this.a._context, false);
    }
    f();
    if (!TraeAudioManager.IsUpdateSceneFlag)
    {
      a.dUd();
      a.iP("TRAE", "connect earphone: do nothing");
      AppMethodBeat.o(65798);
      return;
    }
    if (!TraeAudioManager.enableDeviceSwitchFlag)
    {
      a.dUd();
      a.iP("TRAE", "connect earphone: disableDeviceSwitchFlag");
      AppMethodBeat.o(65798);
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
          label133:
          i += 1;
          break;
          l = 4000L;
        }
        AppMethodBeat.o(65798);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label133;
      }
      int i = 0;
    }
  }
  
  public String b()
  {
    return "DEVICE_EARPHONE";
  }
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.rtmp.sharp.jni.TraeAudioManager.h
 * JD-Core Version:    0.7.0.1
 */