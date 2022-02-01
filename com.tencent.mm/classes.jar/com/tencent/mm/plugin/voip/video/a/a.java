package com.tencent.mm.plugin.voip.video.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.xlabeffect.XLabEffect;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.a.b;
import d.y;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public final class a
{
  public static boolean zwA = true;
  public static float zwB = 180.0F;
  public static boolean zwz = true;
  volatile boolean aUT = false;
  private boolean csX = false;
  XLabEffect fVU;
  int guI;
  int guJ;
  com.tencent.mm.media.i.b.a vpe;
  private int zwC = -1;
  com.tencent.mm.media.f.d zwD;
  com.tencent.mm.media.f.d zwE;
  byte[] zwF;
  ByteBuffer zwG = null;
  int zwH = 0;
  
  public final void a(com.tencent.mm.media.f.d paramd1, com.tencent.mm.media.f.d paramd2, int paramInt)
  {
    boolean bool3 = true;
    AppMethodBeat.i(115704);
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.FilterProcessTex", "initial %s, %d, beauytParams:%s", new Object[] { this, Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(paramInt) });
        if (this.fVU != null)
        {
          ad.w("MicroMsg.FilterProcessTex", "initial xLabEffect: again");
          this.fVU.destroy();
        }
        this.fVU = new XLabEffect();
        this.fVU.tP(false);
        boolean bool1;
        if ((paramInt & 0x1) != 0)
        {
          bool1 = true;
          break label278;
          ad.i("MicroMsg.FilterProcessTex", "initial, needSkin:%s, needShape:%s, needFilter:%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if (bool1) {
            this.fVU.etX();
          }
          if (bool2) {
            this.fVU.etY();
          }
          if (bool3) {
            this.fVU.tO(true);
          }
          this.zwD = paramd1;
          this.zwE = paramd2;
          this.vpe = new com.tencent.mm.media.i.b.d(this.guI, this.guJ, this.guI, this.guJ, 2, 1);
          this.vpe.gva = new b() {};
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
  
  public final byte[] dXs()
  {
    AppMethodBeat.i(115705);
    if (!this.aUT)
    {
      ad.i("MicroMsg.FilterProcessTex", "still not have data");
      AppMethodBeat.o(115705);
      return null;
    }
    byte[] arrayOfByte = this.zwF;
    AppMethodBeat.o(115705);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.video.a.a
 * JD-Core Version:    0.7.0.1
 */