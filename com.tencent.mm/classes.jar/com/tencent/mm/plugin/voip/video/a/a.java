package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import d.z;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class a
{
  public static boolean CGp = true;
  public static boolean CGq = true;
  public static float CGr = 180.0F;
  private int CGs = -1;
  d CGt;
  byte[] CGu;
  ByteBuffer CGv = null;
  int CGw = 0;
  volatile boolean bgb = false;
  private boolean cBE = false;
  d gNr;
  int gNs;
  int gNt;
  com.tencent.mm.plugin.xlabeffect.b gvS;
  com.tencent.mm.media.j.b.a xWG;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        ae.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.gvS != null)
        {
          ae.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.gvS.destroy();
        }
        this.gvS = new com.tencent.mm.plugin.xlabeffect.b();
        this.gvS.vJ(false);
        int i = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEd, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEe, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEf, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEg, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEh, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEi, -1);
        ae.i("MicroMsg.FilterProcessTex", "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        this.gvS.k(j, m, i1, k, n);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label475;
          ae.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.gvS.fbW();
          }
          if (bool2) {
            this.gvS.fbX();
          }
          if (bool3)
          {
            this.gvS.fbY();
            this.gvS.Y(true, i);
          }
          this.CGt = paramd1;
          this.gNr = paramd2;
          this.xWG = new e(this.gNs, this.gNt, this.gNs, this.gNt, 2, 1);
          this.xWG.hqo = new d.g.a.b() {};
          ae.d("MicroMsg.FilterProcessTex", "initial end %s", new Object[] { this });
          AppMethodBeat.o(115704);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd1)
      {
        ae.printErrStackTrace("MicroMsg.FilterProcessTex", paramd1, "initial error", new Object[0]);
        AppMethodBeat.o(115704);
        return;
      }
      boolean bool2 = false;
      break label484;
      boolean bool3 = false;
      continue;
      label475:
      if ((paramInt & 0x2) != 0)
      {
        bool2 = true;
        label484:
        if ((paramInt & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
  
  public final ByteBuffer eEt()
  {
    AppMethodBeat.i(210257);
    if (!this.bgb)
    {
      ae.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(210257);
      return null;
    }
    ByteBuffer localByteBuffer = this.CGv;
    AppMethodBeat.o(210257);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */