package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.e;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends e
{
  public static final a.a DdJ;
  
  static
  {
    AppMethodBeat.i(90504);
    DdJ = new a.a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void eJp()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (this.gra > this.gqZ) {
      if (this.gra > 320)
      {
        k = this.gqZ * i / this.gra;
        j = i;
        i = k;
        if (this.gVh % 180 == 0) {
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
      cR(j, i);
      AppMethodBeat.o(90503);
      return;
      i = this.gra;
      break;
      if (this.gqZ > 320) {}
      for (;;)
      {
        j = this.gra * i / this.gqZ;
        break;
        i = this.gqZ;
      }
    }
    label121:
    cR(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != this.gqZ) || (paramInt2 != this.gra)) {}
    for (int i = 1;; i = 0)
    {
      super.cS(paramInt1, paramInt2);
      if (i != 0) {
        eJp();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.grW;
  }
  
  public final int getWidth()
  {
    return this.grV;
  }
  
  public final void mE(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.gVh) {}
    for (int i = 1;; i = 0)
    {
      super.mE(paramInt);
      if (i != 0) {
        eJp();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */