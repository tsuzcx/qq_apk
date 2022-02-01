package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "", "()V", "drawingRect", "", "saveCount", "", "transformMatrix", "Landroid/graphics/Matrix;", "validRect", "enableValidRect", "", "handleCanvasAfterDraw", "", "canvas", "Landroid/graphics/Canvas;", "handleCanvasBeforeDraw", "setupTransForm", "Companion", "plugin-recordvideo_release"})
public final class e
{
  public static final e.a xPM;
  int xPK;
  final Matrix xPL;
  float[] xuU;
  float[] xuV;
  
  static
  {
    AppMethodBeat.i(200810);
    xPM = new e.a((byte)0);
    AppMethodBeat.o(200810);
  }
  
  public e()
  {
    AppMethodBeat.i(200809);
    this.xuU = new float[4];
    this.xuV = new float[4];
    this.xPL = new Matrix();
    AppMethodBeat.o(200809);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.e
 * JD-Core Version:    0.7.0.1
 */