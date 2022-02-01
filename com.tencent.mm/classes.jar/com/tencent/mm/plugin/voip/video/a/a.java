package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.g.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import kotlin.x;

public final class a
{
  public static boolean OaZ = true;
  public static boolean Oba = true;
  public static float Obb = 180.0F;
  com.tencent.mm.media.j.b.a HUf;
  private int Obc = -1;
  d Obd;
  byte[] Obe;
  ByteBuffer Obf = null;
  int Obg = 0;
  volatile boolean aPy = false;
  private boolean isInit = false;
  com.tencent.mm.plugin.xlabeffect.e jUF;
  d krf;
  int krg;
  int krh;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.jUF != null)
        {
          Log.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.jUF.destroy();
        }
        this.jUF = new com.tencent.mm.plugin.xlabeffect.e(0, 0, 1);
        this.jUF.DH(false);
        this.jUF.QPZ.hjw = 4;
        int i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDY, 0);
        int j = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vDZ, -1);
        int k = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEa, -1);
        int m = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEb, -1);
        int n = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEc, -1);
        int i1 = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vEd, -1);
        Log.i("MicroMsg.FilterProcessTex", "Face beauty config: lutWeight: %d, skinSmooth: %d, skinBright: %d, eyeMorph: %d, eyeBright: %d, faceMorph: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1) });
        this.jUF.o(j, m, i1, k, n);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label490;
          Log.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.jUF.hfa();
          }
          if (bool2) {
            this.jUF.DF(true);
          }
          if (bool3)
          {
            this.jUF.hfb();
            this.jUF.an(true, i);
          }
          this.Obd = paramd1;
          this.krf = paramd2;
          this.HUf = new com.tencent.mm.media.j.b.e(this.krg, this.krh, this.krg, this.krh, 2, 1);
          this.HUf.kYD = new kotlin.g.a.b() {};
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
  
  public final ByteBuffer gDY()
  {
    AppMethodBeat.i(239796);
    if (!this.aPy)
    {
      Log.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(239796);
      return null;
    }
    ByteBuffer localByteBuffer = this.Obf;
    AppMethodBeat.o(239796);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */