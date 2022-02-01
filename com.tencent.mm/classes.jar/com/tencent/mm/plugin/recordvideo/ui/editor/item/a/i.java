package com.tencent.mm.plugin.recordvideo.ui.editor.item.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/PlaceHolderEditorItem;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "Landroid/graphics/Matrix;", "(Landroid/graphics/Matrix;)V", "destroy", "", "draw", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "init", "prepareNext", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends a
{
  public i(Matrix paramMatrix)
  {
    super(paramMatrix);
    AppMethodBeat.i(280373);
    AppMethodBeat.o(280373);
  }
  
  public final void destroy() {}
  
  public final void draw(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(280387);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    AppMethodBeat.o(280387);
  }
  
  public final long gKI()
  {
    return 0L;
  }
  
  public final void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.item.a.i
 * JD-Core Version:    0.7.0.1
 */