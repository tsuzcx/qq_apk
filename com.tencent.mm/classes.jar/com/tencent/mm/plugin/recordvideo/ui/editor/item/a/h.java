package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/PlaceHolderEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"})
public final class h
  extends a
{
  public h(Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(207029);
    AppMethodBeat.o(207029);
  }
  
  public final long dLx()
  {
    return 0L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(207028);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    AppMethodBeat.o(207028);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h
 * JD-Core Version:    0.7.0.1
 */