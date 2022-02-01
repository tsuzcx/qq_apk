package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends e
{
  public static final a.a XJP;
  
  static
  {
    AppMethodBeat.i(90504);
    XJP = new a.a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void iFH()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (bpU() > bpT()) {
      if (bpU() > 320)
      {
        k = bpT() * i / bpU();
        j = i;
        i = k;
        if (this.nDr % 180 == 0) {
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
      ek(j, i);
      AppMethodBeat.o(90503);
      return;
      i = bpU();
      break;
      if (bpT() > 320) {}
      for (;;)
      {
        j = bpU() * i / bpT();
        break;
        i = bpT();
      }
    }
    label121:
    ek(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != bpT()) || (paramInt2 != bpU())) {}
    for (int i = 1;; i = 0)
    {
      super.el(paramInt1, paramInt2);
      if (i != 0) {
        iFH();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(261666);
    int i = getDrawHeight();
    AppMethodBeat.o(261666);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(261661);
    int i = getDrawWidth();
    AppMethodBeat.o(261661);
    return i;
  }
  
  public final void th(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != this.nDr) {}
    for (int i = 1;; i = 0)
    {
      super.th(paramInt);
      if (i != 0) {
        iFH();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */