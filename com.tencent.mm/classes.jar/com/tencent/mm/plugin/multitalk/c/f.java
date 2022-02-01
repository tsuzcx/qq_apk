package com.tencent.mm.plugin.multitalk.c;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f
{
  c Lir;
  boolean isStart;
  final Object wTX;
  f.a wTZ;
  
  public f()
  {
    AppMethodBeat.i(285127);
    this.wTX = new Object();
    this.isStart = false;
    this.wTZ = new f.a();
    AppMethodBeat.o(285127);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(285137);
    Log.v("MicroMsg.Multitalk.ILinkAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.wTX)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(285137);
        return -1;
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.Lir == null)
      {
        this.Lir = new c();
        this.Lir.ac(paramInt1, paramInt2, paramInt3, 0);
      }
      this.Lir.R(MMApplicationContext.getContext(), false);
      this.Lir.UvX = paramb;
      paramInt1 = this.Lir.hVD();
      if (ac.ggS().LoD != null) {
        ac.ggS().LoD.Lir = this.Lir;
      }
      this.wTZ.lYS = SystemClock.elapsedRealtime();
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlaying cost: " + this.wTZ.aPY());
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "set start play");
      this.isStart = true;
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(285137);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.f
 * JD-Core Version:    0.7.0.1
 */