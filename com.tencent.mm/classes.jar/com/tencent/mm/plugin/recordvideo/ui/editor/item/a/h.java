package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/PlaceHolderEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"})
public final class h
  extends a
{
  public h(Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(200771);
    AppMethodBeat.o(200771);
  }
  
  public final long dIg()
  {
    return 0L;
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200770);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    AppMethodBeat.o(200770);
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.h
 * JD-Core Version:    0.7.0.1
 */