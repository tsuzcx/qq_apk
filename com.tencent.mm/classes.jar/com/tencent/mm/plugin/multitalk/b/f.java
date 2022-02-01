package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class f
{
  c Fmm;
  boolean isStart;
  final Object tQH;
  f.a tQJ;
  
  public f()
  {
    AppMethodBeat.i(200721);
    this.tQH = new Object();
    this.isStart = false;
    this.tQJ = new f.a();
    AppMethodBeat.o(200721);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(200727);
    Log.v("MicroMsg.Multitalk.ILinkAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.tQH)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(200727);
        return -1;
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.Fmm == null)
      {
        this.Fmm = new c();
        this.Fmm.S(paramInt1, paramInt2, paramInt3, 0);
      }
      this.Fmm.K(MMApplicationContext.getContext(), false);
      this.Fmm.NJt = paramb;
      paramInt1 = this.Fmm.gxB();
      ad.eYc().Fsp.Fmm = this.Fmm;
      this.tQJ.jvB = SystemClock.elapsedRealtime();
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlaying cost: " + this.tQJ.avE());
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "set start play");
      this.isStart = true;
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(200727);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.f
 * JD-Core Version:    0.7.0.1
 */