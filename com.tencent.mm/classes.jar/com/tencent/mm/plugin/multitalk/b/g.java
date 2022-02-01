package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.multitalk.b.a.a;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.z;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;

public final class g
{
  boolean isStart;
  final Object pcY;
  f.a pda;
  public a wmq;
  
  public g()
  {
    AppMethodBeat.i(190449);
    this.pcY = new Object();
    this.isStart = false;
    this.pda = new f.a();
    this.wmq = new a();
    AppMethodBeat.o(190449);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(190450);
    ae.v("MicroMsg.Multitalk.ILinkAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.pcY)
    {
      if (this.isStart)
      {
        ae.d("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(190450);
        return -1;
      }
      ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.wmq;
      p.h(paramb, "devCallBack");
      if (locala.pcA == null)
      {
        locala.pcA = new c();
        localc = locala.pcA;
        if (localc != null) {
          localc.M(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.pcA;
      if (localc != null) {
        localc.C(ak.getContext(), false);
      }
      localc = locala.pcA;
      if (localc != null) {
        localc.Cpm = paramb;
      }
      paramb = locala.pcA;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.eyy();
      }
      this.pda.gfF = SystemClock.elapsedRealtime();
      ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlaying cost: " + this.pda.abs());
      ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "set start play");
      this.isStart = true;
      ae.i("MicroMsg.Multitalk.ILinkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(190450);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.g
 * JD-Core Version:    0.7.0.1
 */