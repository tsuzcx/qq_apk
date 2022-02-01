package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.xlabeffect.k;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.ah;
import kotlin.g.a.b;

public final class a
{
  public static boolean UOW = true;
  public static boolean UOX = true;
  public static float UOY = 180.0F;
  com.tencent.mm.media.j.b.a NQX;
  private int UOZ = -1;
  byte[] UPa;
  ByteBuffer UPb = null;
  int UPc = 0;
  volatile boolean cJu = false;
  private boolean isInit = false;
  d mVc;
  int mVd;
  int mVe;
  k muW;
  d ntz;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.muW != null)
        {
          Log.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.muW.destroy();
        }
        this.muW = new k(0, 0, 1);
        this.muW.Jo(false);
        this.muW.XLr.jFp = 4;
        int i = ((c)h.ax(c.class)).a(c.a.yTf, 0);
        int j = ((c)h.ax(c.class)).a(c.a.yTg, -1);
        int k = ((c)h.ax(c.class)).a(c.a.yTh, -1);
        int m = ((c)h.ax(c.class)).a(c.a.yTi, -1);
        int n = ((c)h.ax(c.class)).a(c.a.yTj, -1);
        int i1 = ((c)h.ax(c.class)).a(c.a.yTk, -1);
        Log.i("MicroMsg.FilterProcessTex", "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        this.muW.q(j, m, i1, k, n);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label490;
          Log.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.muW.iGb();
          }
          if (bool2) {
            this.muW.Jm(true);
          }
          if (bool3)
          {
            this.muW.iGc();
            this.muW.ao(true, i);
          }
          this.ntz = paramd1;
          this.mVc = paramd2;
          this.NQX = new e(this.mVd, this.mVe, this.mVd, this.mVe, 2, 1);
          this.NQX.nDL = new b() {};
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
      break label499;
      boolean bool3 = false;
      continue;
      label490:
      if ((paramInt & 0x2) != 0)
      {
        bool2 = true;
        label499:
        if ((paramInt & 0x4) != 0) {
          bool3 = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */