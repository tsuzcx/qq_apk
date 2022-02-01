package com.tencent.mm.plugin.multitalk.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/audio/ILinkAudioManager;", "Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "()V", "onAudioDeviceStateChanged", "", "status", "", "Companion", "plugin-multitalk_release"})
public final class a
  extends b
{
  public static final a.a Fml;
  
  static
  {
    AppMethodBeat.i(207225);
    Fml = new a.a((byte)0);
    AppMethodBeat.o(207225);
  }
  
  public final void ko(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(207224);
    switch (paramInt)
    {
    case 4: 
    case 5: 
    default: 
    case 2: 
    case 1: 
    case 3: 
    case 6: 
    case 7: 
      for (;;)
      {
        super.ko(paramInt);
        AppMethodBeat.o(207224);
        return;
        uw(false);
        continue;
        uw(true);
      }
    case 9: 
      Log.i("MicroMsg.ILinkAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Ez(4)) });
      if (!Ez(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.tQg;
      this.tQg = (uw(bool1) & bool2);
      break;
      Log.i("MicroMsg.ILinkAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Ez(4)) });
      bool1 = this.tQg;
      this.tQg = (uw(false) & bool1);
      break;
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.a
 * JD-Core Version:    0.7.0.1
 */