package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.plugin.voip.model.c;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.pb.talkroom.sdk.d;

public final class l
{
  boolean isStart;
  c pcA;
  final Object pcY;
  f.a pda;
  
  public l()
  {
    AppMethodBeat.i(114414);
    this.pcA = null;
    this.pcY = new Object();
    this.isStart = false;
    this.pda = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.pcY)
    {
      if (this.isStart)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.pcA == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = com.tencent.mm.compatible.deviceinfo.ae.geN.fZM;
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qJQ, -1);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.pcA = new c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.pcA.M(paramInt1, 2, paramInt2, 0);
          z.dtJ().wqE.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.pcA.C(ak.getContext(), false);
        this.pcA.Cpm = paramb;
        if (z.dtK().wrl != null)
        {
          z.dtK().wrl.NZ();
          z.dtK().wrl.wlY = this.pcA;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.pda.gfF = SystemClock.elapsedRealtime();
        paramInt1 = this.pcA.eyy();
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.pda.abs());
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.pcA.M(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.l
 * JD-Core Version:    0.7.0.1
 */