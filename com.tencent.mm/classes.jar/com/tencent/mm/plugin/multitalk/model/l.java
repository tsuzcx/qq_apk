package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.pb.talkroom.sdk.d;

public final class l
{
  boolean isStart;
  c oVX;
  final Object oWv;
  f.a oWx;
  
  public l()
  {
    AppMethodBeat.i(114414);
    this.oVX = null;
    this.oWv = new Object();
    this.isStart = false;
    this.oWx = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.oWv)
    {
      if (this.isStart)
      {
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.oVX == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = ae.gcF.fXG;
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qCo, -1);
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        ad.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.oVX = new c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.oVX.M(paramInt1, 2, paramInt2, 0);
          z.dqw().wbf.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.oVX.C(aj.getContext(), false);
        this.oVX.BXL = paramb;
        if (z.dqx().wbN != null)
        {
          z.dqx().wbN.Ob();
          z.dqx().wbN.vZU = this.oVX;
        }
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.oWx.gdx = SystemClock.elapsedRealtime();
        paramInt1 = this.oVX.euS();
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.oWx.abj());
        ad.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.oVX.M(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */