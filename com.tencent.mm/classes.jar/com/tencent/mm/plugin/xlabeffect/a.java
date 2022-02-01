package com.tencent.mm.plugin.xlabeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.e;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc;", "Lcom/tencent/mm/media/render/proc/GLTextureRenderProcTexture;", "textureWidth", "", "textureHeight", "(II)V", "getHeight", "getWidth", "refreshDrawSize", "", "setRotate", "degree", "updateTextureSize", "width", "height", "Companion", "plugin-xlabeffect_release"})
public final class a
  extends e
{
  public static final a QPo;
  
  static
  {
    AppMethodBeat.i(90504);
    QPo = new a((byte)0);
    AppMethodBeat.o(90504);
  }
  
  private a()
  {
    super(0, 0, 0, 0, 2, 1);
  }
  
  private final void heV()
  {
    int i = 320;
    AppMethodBeat.i(90503);
    int j;
    if (aVy() > aVx()) {
      if (aVy() > 320)
      {
        k = aVx() * i / aVy();
        j = i;
        i = k;
        if (aVp() % 180 == 0) {
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
      du(j, i);
      AppMethodBeat.o(90503);
      return;
      i = aVy();
      break;
      if (aVx() > 320) {}
      for (;;)
      {
        j = aVy() * i / aVx();
        break;
        i = aVx();
      }
    }
    label121:
    du(i, j);
    AppMethodBeat.o(90503);
  }
  
  public final void dv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90501);
    if ((paramInt1 != aVx()) || (paramInt2 != aVy())) {}
    for (int i = 1;; i = 0)
    {
      super.dv(paramInt1, paramInt2);
      if (i != 0) {
        heV();
      }
      AppMethodBeat.o(90501);
      return;
    }
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(187270);
    int i = getDrawHeight();
    AppMethodBeat.o(187270);
    return i;
  }
  
  public final int getWidth()
  {
    AppMethodBeat.i(187269);
    int i = getDrawWidth();
    AppMethodBeat.o(187269);
    return i;
  }
  
  public final void tm(int paramInt)
  {
    AppMethodBeat.i(90502);
    if (paramInt != aVp()) {}
    for (int i = 1;; i = 0)
    {
      super.tm(paramInt);
      if (i != 0) {
        heV();
      }
      AppMethodBeat.o(90502);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/xlabeffect/FaceTrackProc$Companion;", "", "()V", "FACE_TRACK_SIZE", "", "plugin-xlabeffect_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.xlabeffect.a
 * JD-Core Version:    0.7.0.1
 */