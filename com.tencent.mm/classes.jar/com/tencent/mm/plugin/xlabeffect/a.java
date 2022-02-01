package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends e
{
  public static final a.a JQX;
  
  static
  {
    AppMethodBeat.i(90504);
    JQX = new a.a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void glf()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (this.hDo > this.hDn) {
      if (this.hDo > 320)
      {
        k = this.hDn * i / this.hDo;
        j = i;
        i = k;
        if (this.ijt % 180 == 0) {
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
      cY(j, i);
      AppMethodBeat.o(90503);
      return;
      i = this.hDo;
      break;
      if (this.hDn > 320) {}
      for (;;)
      {
        j = this.hDo * i / this.hDn;
        break;
        i = this.hDn;
      }
    }
    label121:
    cY(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void cZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != this.hDn) || (paramInt2 != this.hDo)) {}
    for (int i = 1;; i = 0)
    {
      super.cZ(paramInt1, paramInt2);
      if (i != 0) {
        glf();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    return this.hEq;
  }
  
  public final int getWidth()
  {
    return this.hEp;
  }
  
  public final void qx(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.ijt) {}
    for (int i = 1;; i = 0)
    {
      super.qx(paramInt);
      if (i != 0) {
        glf();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */