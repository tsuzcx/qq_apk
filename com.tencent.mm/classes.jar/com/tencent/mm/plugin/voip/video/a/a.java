package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.g.d;
import com.tencent.mm.media.j.b.e;
import com.tencent.mm.sdk.platformtools.ad;
import d.z;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class a
{
  public static boolean CoL = true;
  public static boolean CoM = true;
  public static float CoN = 180.0F;
  private int CoO = -1;
  d CoP;
  byte[] CoQ;
  ByteBuffer CoR = null;
  int CoS = 0;
  volatile boolean bgb = false;
  private boolean cAX = false;
  d gKI;
  int gKJ;
  int gKK;
  com.tencent.mm.plugin.xlabeffect.b gtl;
  com.tencent.mm.media.j.b.a xGL;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    boolean bool3 = true;
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.gtl != null)
        {
          ad.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.gtl.destroy();
        }
        this.gtl = new com.tencent.mm.plugin.xlabeffect.b();
        this.gtl.vB(false);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label278;
          ad.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.gtl.eYk();
          }
          if (bool2) {
            this.gtl.eYl();
          }
          if (bool3) {
            this.gtl.vA(true);
          }
          this.CoP = paramd1;
          this.gKI = paramd2;
          this.xGL = new e(this.gKJ, this.gKK, this.gKJ, this.gKK, 2, 1);
          this.xGL.hnA = new d.g.a.b() {};
          ad.d("MicroMsg.FilterProcessTex", "initial end %s", new Object[] { this });
          AppMethodBeat.o(115704);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd1)
      {
        ad.printErrStackTrace("MicroMsg.FilterProcessTex", paramd1, "initial error", new Object[0]);
        AppMethodBeat.o(115704);
        return;
      }
      boolean bool2 = false;
      break label287;
      bool3 = false;
      continue;
      label278:
      if ((paramInt & 0x2) != 0)
      {
        bool2 = true;
        label287:
        if ((paramInt & 0x4) == 0) {}
      }
    }
  }
  
  public final ByteBuffer eAL()
  {
    AppMethodBeat.i(216578);
    if (!this.bgb)
    {
      ad.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(216578);
      return null;
    }
    ByteBuffer localByteBuffer = this.CoR;
    AppMethodBeat.o(216578);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */