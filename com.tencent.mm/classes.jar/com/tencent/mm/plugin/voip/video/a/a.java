package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.x;

public final class a
{
  public static boolean Hkk = true;
  public static boolean Hkl = true;
  public static float Hkm = 180.0F;
  com.tencent.mm.media.j.b.a BXr;
  private int Hkn = -1;
  d Hko;
  byte[] Hkp;
  ByteBuffer Hkq = null;
  int Hkr = 0;
  volatile boolean bfY = false;
  d hDm;
  int hDn;
  int hDo;
  com.tencent.mm.plugin.xlabeffect.b hiH;
  private boolean isInit = false;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.hiH != null)
        {
          Log.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.hiH.destroy();
        }
        this.hiH = new com.tencent.mm.plugin.xlabeffect.b(0, 0);
        this.hiH.zG(false);
        int i = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXh, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXi, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXj, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXk, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXl, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rXm, -1);
        Log.i("MicroMsg.FilterProcessTex", "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        this.hiH.l(j, m, i1, k, n);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label477;
          Log.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.hiH.glh();
          }
          if (bool2) {
            this.hiH.glj();
          }
          if (bool3)
          {
            this.hiH.gll();
            this.hiH.aa(true, i);
          }
          this.Hko = paramd1;
          this.hDm = paramd2;
          this.BXr = new e(this.hDn, this.hDo, this.hDn, this.hDo, 2, 1);
          this.BXr.ijJ = new kotlin.g.a.b() {};
          Log.d("MicroMsg.FilterProcessTex", "initial end %s", new Object[] { this });
          AppMethodBeat.o(115704);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd1)
      {
        Log.printErrStackTrace("MicroMsg.FilterProcessTex", paramd1, "initial error", new Object[0]);
        AppMethodBeat.o(115704);
        return;
      }
      boolean bool2 = false;
      break label486;
      boolean bool3 = false;
      continue;
      label477:
      if ((paramInt & 0x2) != 0)
      {
        bool2 = true;
        label486:
        if ((paramInt & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
  
  public final ByteBuffer fLy()
  {
    AppMethodBeat.i(235892);
    if (!this.bfY)
    {
      Log.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(235892);
      return null;
    }
    ByteBuffer localByteBuffer = this.Hkq;
    AppMethodBeat.o(235892);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */