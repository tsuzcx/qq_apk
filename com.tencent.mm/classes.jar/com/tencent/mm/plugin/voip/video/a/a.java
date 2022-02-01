package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.f.d;
import com.tencent.mm.media.i.b.e;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.b;
import d.y;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class a
{
  public static boolean APq = true;
  public static boolean APr = true;
  public static float APs = 180.0F;
  private int APt = -1;
  d APu;
  byte[] APv;
  ByteBuffer APw = null;
  int APx = 0;
  volatile boolean aVG = false;
  private boolean cqf = false;
  XLabEffect fZP;
  d gqY;
  int gqZ;
  int gra;
  com.tencent.mm.media.i.b.a wxR;
  
  public final void a(d paramd1, d paramd2, int paramInt)
  {
    boolean bool3 = true;
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.fZP != null)
        {
          ac.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.fZP.destroy();
        }
        this.fZP = new XLabEffect();
        this.fZP.uQ(false);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label278;
          ac.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.fZP.eJq();
          }
          if (bool2) {
            this.fZP.eJr();
          }
          if (bool3) {
            this.fZP.uP(true);
          }
          this.APu = paramd1;
          this.gqY = paramd2;
          this.wxR = new e(this.gqZ, this.gra, this.gqZ, this.gra, 2, 1);
          this.wxR.gVx = new b() {};
          ac.d("MicroMsg.FilterProcessTex", "initial end %s", new Object[] { this });
          AppMethodBeat.o(115704);
        }
        else
        {
          bool1 = false;
        }
      }
      catch (Exception paramd1)
      {
        ac.printErrStackTrace("MicroMsg.FilterProcessTex", paramd1, "initial error", new Object[0]);
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
  
  public final ByteBuffer emN()
  {
    AppMethodBeat.i(208530);
    if (!this.aVG)
    {
      ac.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(208530);
      return null;
    }
    ByteBuffer localByteBuffer = this.APw;
    AppMethodBeat.o(208530);
    return localByteBuffer;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */