package com.tencent.mm.plugin.multitalk.b;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.plugin.multitalk.b.a.a;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.o;
import com.tencent.mm.plugin.multitalk.model.q;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;

public final class g
{
  boolean isStart;
  final Object qrY;
  f.a qsa;
  public a zHu;
  
  public g()
  {
    AppMethodBeat.i(239022);
    this.qrY = new Object();
    this.isStart = false;
    this.qsa = new f.a();
    this.zHu = new a();
    AppMethodBeat.o(239022);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(239023);
    Log.v("MicroMsg.Multitalk.ILinkAudioPlayer", "hy: start play with %d, %d, %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    synchronized (this.qrY)
    {
      if (this.isStart)
      {
        Log.d("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(239023);
        return -1;
      }
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      a locala = this.zHu;
      p.h(paramb, "devCallBack");
      if (locala.qrz == null)
      {
        locala.qrz = new c();
        localc = locala.qrz;
        if (localc != null) {
          localc.N(paramInt1, paramInt2, paramInt3, 0);
        }
      }
      c localc = locala.qrz;
      if (localc != null) {
        localc.F(MMApplicationContext.getContext(), false);
      }
      localc = locala.qrz;
      if (localc != null) {
        localc.GTi = paramb;
      }
      paramb = locala.qrz;
      paramInt1 = i;
      if (paramb != null) {
        paramInt1 = paramb.fFp();
      }
      this.qsa.gLm = SystemClock.elapsedRealtime();
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "startPlaying cost: " + this.qsa.apr());
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "set start play");
      this.isStart = true;
      Log.i("MicroMsg.Multitalk.ILinkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(239023);
      return paramInt1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.g
 * JD-Core Version:    0.7.0.1
 */