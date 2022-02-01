package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "", "()V", "drawingRect", "", "saveCount", "", "transformMatrix", "Landroid/graphics/Matrix;", "validRect", "enableValidRect", "", "handleCanvasAfterDraw", "", "canvas", "Landroid/graphics/Canvas;", "handleCanvasBeforeDraw", "setupTransForm", "Companion", "plugin-recordvideo_release"})
public final class e
{
  public static final e.a CgE;
  float[] BKV;
  float[] BKW;
  int CgC;
  final Matrix CgD;
  
  static
  {
    AppMethodBeat.i(237909);
    CgE = new e.a((byte)0);
    AppMethodBeat.o(237909);
  }
  
  public e()
  {
    AppMethodBeat.i(237908);
    this.BKV = new float[4];
    this.BKW = new float[4];
    this.CgD = new Matrix();
    AppMethodBeat.o(237908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.e
 * JD-Core Version:    0.7.0.1
 */