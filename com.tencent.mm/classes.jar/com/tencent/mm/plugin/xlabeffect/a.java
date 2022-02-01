package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends e
{
  public static final a.a Faf;
  
  static
  {
    AppMethodBeat.i(90504);
    Faf = new a.a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void fbV()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (this.gNt > this.gNs) {
      if (this.gNt > 320)
      {
        k = this.gNs * i / this.gNt;
        j = i;
        i = k;
        if (this.hpY % 180 == 0) {
          break label116;
        }
      }
    }
    label116:
    for (int k = 1;; k = 0)
    {
      if (k == 0) {
        break label121;
      }
      cT(j, i);
      AppMethodBeat.o(90503);
      return;
      i = this.gNt;
      break;
      if (this.gNs > 320) {}
      for (;;)
      {
        j = this.gNt * i / this.gNs;
        break;
        i = this.gNs;
      }
    }
    label121:
    cT(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != this.gNs) || (paramInt2 != this.gNt)) {}
    for (int i = 1;; i = 0)
    {
      super.cU(paramInt1, paramInt2);
      if (i != 0) {
        fbV();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.gOn;
  }
  
  public final int getWidth()
  {
    return this.gOm;
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.hpY) {}
    for (int i = 1;; i = 0)
    {
      super.ng(paramInt);
      if (i != 0) {
        fbV();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */