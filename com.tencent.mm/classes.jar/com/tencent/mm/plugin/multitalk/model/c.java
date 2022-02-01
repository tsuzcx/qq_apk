package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;

public final class c
{
  boolean isStart;
  final Object nPU;
  f.a nPW;
  com.tencent.mm.plugin.voip.model.c nPx;
  
  public c()
  {
    AppMethodBeat.i(114414);
    this.nPx = null;
    this.nPU = new Object();
    this.isStart = false;
    this.nPW = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.nPU)
    {
      if (this.isStart)
      {
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.nPx == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = ae.fFx.fAA;
        int j = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.psZ, -1);
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.nPx = new com.tencent.mm.plugin.voip.model.c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.nPx.K(paramInt1, 2, paramInt2, 0);
          p.cSN().tOr.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.nPx.z(aj.getContext(), false);
        this.nPx.zfJ = paramb;
        if (p.cSO().tPb != null)
        {
          p.cSO().tPb.Mu();
          p.cSO().tPb.tOj = this.nPx;
        }
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.nPW.fGp = SystemClock.elapsedRealtime();
        paramInt1 = this.nPx.dRU();
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.nPW.XK());
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.nPx.K(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.c
 * JD-Core Version:    0.7.0.1
 */