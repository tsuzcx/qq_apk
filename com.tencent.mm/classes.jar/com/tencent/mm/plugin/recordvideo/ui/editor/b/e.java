package com.tencent.mm.plugin.recordvideo.ui.editor.b;

import android.graphics.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform;", "", "()V", "drawingRect", "", "saveCount", "", "transformMatrix", "Landroid/graphics/Matrix;", "validRect", "enableValidRect", "", "handleCanvasAfterDraw", "", "canvas", "Landroid/graphics/Canvas;", "handleCanvasBeforeDraw", "setupTransForm", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final a NZO;
  float[] NEA;
  float[] NEB;
  int NZP;
  final Matrix NZQ;
  
  static
  {
    AppMethodBeat.i(279964);
    NZO = new a((byte)0);
    AppMethodBeat.o(279964);
  }
  
  public e()
  {
    AppMethodBeat.i(279960);
    this.NEA = new float[4];
    this.NEB = new float[4];
    this.NZQ = new Matrix();
    AppMethodBeat.o(279960);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/retriever/RetrieverTransform$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b.e
 * JD-Core Version:    0.7.0.1
 */