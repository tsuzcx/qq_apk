package com.tencent.mm.plugin.multitalk.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/audio/ILinkAudioManager;", "Lcom/tencent/mm/plugin/multitalk/audio/MultiTalkAudioManager;", "()V", "onAudioDeviceStateChanged", "", "status", "", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a.a Lip;
  
  static
  {
    AppMethodBeat.i(284621);
    Lip = new a.a((byte)0);
    AppMethodBeat.o(284621);
  }
  
  public final void nW(int paramInt)
  {
    boolean bool1 = false;
    AppMethodBeat.i(284627);
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
        super.nW(paramInt);
        AppMethodBeat.o(284627);
        return;
        yJ(false);
        continue;
        yJ(true);
      }
    case 9: 
      Log.i("MicroMsg.ILinkAudioManager", "isHeadsetPlugged disconnected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Fa(4)) });
      if (!Fa(4)) {
        break;
      }
    }
    for (;;)
    {
      boolean bool2 = this.wTx;
      this.wTx = (yJ(bool1) & bool2);
      break;
      Log.i("MicroMsg.ILinkAudioManager", " isHeadsetPlug connected, isBluetoothConnected: %s", new Object[] { Boolean.valueOf(Fa(4)) });
      bool1 = this.wTx;
      this.wTx = (yJ(false) & bool1);
      break;
      bool1 = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.a
 * JD-Core Version:    0.7.0.1
 */