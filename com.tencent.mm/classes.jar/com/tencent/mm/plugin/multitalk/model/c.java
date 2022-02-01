package com.tencent.mm.plugin.multitalk.model;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.util.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.multitalk.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;

public final class c
{
  boolean isStart;
  com.tencent.mm.plugin.voip.model.c osB;
  final Object osZ;
  f.a otb;
  
  public c()
  {
    AppMethodBeat.i(114414);
    this.osB = null;
    this.osZ = new Object();
    this.isStart = false;
    this.otb = new f.a();
    AppMethodBeat.o(114414);
  }
  
  public final int a(com.tencent.mm.plugin.voip.model.b paramb, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(114415);
    synchronized (this.osZ)
    {
      if (this.isStart)
      {
        ac.d("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay, already start");
        AppMethodBeat.o(114415);
        return -1;
      }
      ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlay %s", new Object[] { Integer.valueOf(hashCode()) });
      if (this.osB == null)
      {
        byte[] arrayOfByte = new byte[1];
        int i = ae.fJe.fEh;
        int j = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pXk, -1);
        ac.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_s = %d", new Object[] { Integer.valueOf(i) });
        ac.d("MicroMsg.MT.MultiTalkAudioPlayer", "MT3D, startPlay, mt3d_flag_x = %d", new Object[] { Integer.valueOf(j) });
        this.osB = new com.tencent.mm.plugin.voip.model.c();
        arrayOfByte[0] = 0;
        if ((i > 0) && (j > 0))
        {
          arrayOfByte[0] = 1;
          this.osB.M(paramInt1, 2, paramInt2, 0);
          p.dgw().uWU.setAppCmd(448, arrayOfByte, 1);
        }
      }
      else
      {
        this.osB.A(ai.getContext(), false);
        this.osB.Ayq = paramb;
        if (p.dgx().uXD != null)
        {
          p.dgx().uXD.Ms();
          p.dgx().uXD.uWM = this.osB;
        }
        ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "set start play");
        this.isStart = true;
        this.otb.fJW = SystemClock.elapsedRealtime();
        paramInt1 = this.osB.ehg();
        ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "startPlaying cost: " + this.otb.YH());
        ac.i("MicroMsg.MT.MultiTalkAudioPlayer", "finish start play: %s", new Object[] { Integer.valueOf(paramInt1) });
        AppMethodBeat.o(114415);
        return paramInt1;
      }
      this.osB.M(paramInt1, 1, paramInt2, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.model.c
 * JD-Core Version:    0.7.0.1
 */