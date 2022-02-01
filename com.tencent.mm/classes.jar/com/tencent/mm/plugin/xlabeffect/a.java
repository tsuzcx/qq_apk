package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends e
{
  public static final a.a EHJ;
  
  static
  {
    AppMethodBeat.i(90504);
    EHJ = new a.a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void eYj()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (this.gKK > this.gKJ) {
      if (this.gKK > 320)
      {
        k = this.gKJ * i / this.gKK;
        j = i;
        i = k;
        if (this.hnk % 180 == 0) {
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
      i = this.gKK;
      break;
      if (this.gKJ > 320) {}
      for (;;)
      {
        j = this.gKK * i / this.gKJ;
        break;
        i = this.gKJ;
      }
    }
    label121:
    cT(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void cU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != this.gKJ) || (paramInt2 != this.gKK)) {}
    for (int i = 1;; i = 0)
    {
      super.cU(paramInt1, paramInt2);
      if (i != 0) {
        eYj();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.gLE;
  }
  
  public final int getWidth()
  {
    return this.gLD;
  }
  
  public final void nd(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.hnk) {}
    for (int i = 1;; i = 0)
    {
      super.nd(paramInt);
      if (i != 0) {
        eYj();
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