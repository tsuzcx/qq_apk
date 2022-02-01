package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.i.b.d;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends d
{
  public static final a BLB;
  
  static
  {
    AppMethodBeat.i(90504);
    BLB = new a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void etW()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (this.guJ > this.guI) {
      if (this.guJ > 320)
      {
        k = this.guI * i / this.guJ;
        j = i;
        i = k;
        if (this.guD % 180 == 0) {
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
      i = this.guJ;
      break;
      if (this.guI > 320) {}
      for (;;)
      {
        j = this.guJ * i / this.guI;
        break;
        i = this.guI;
      }
    }
    label121:
    cT(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void cS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != this.guI) || (paramInt2 != this.guJ)) {}
    for (int i = 1;; i = 0)
    {
      super.cS(paramInt1, paramInt2);
      if (i != 0) {
        etW();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.guL;
  }
  
  public final int getWidth()
  {
    return this.guK;
  }
  
  public final void mz(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.guD) {}
    for (int i = 1;; i = 0)
    {
      super.mz(paramInt);
      if (i != 0) {
        etW();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc$Companion;", "", "()V", "FACE_TRACK_SIZE", "", "plugin-xlabeffect_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */