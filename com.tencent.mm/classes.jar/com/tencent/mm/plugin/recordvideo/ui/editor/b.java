package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private final List<a> yhJ;
  private long yhK;
  
  public b(List<a> paramList)
  {
    AppMethodBeat.i(279877);
    this.yhJ = paramList;
    AppMethodBeat.o(279877);
  }
  
  public final long a(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(279882);
    s.u(paramCanvas, "canvas");
    s.u(paramPaint, "paint");
    if (this.yhJ.size() <= 0)
    {
      AppMethodBeat.o(279882);
      return 0L;
    }
    Iterator localIterator = this.yhJ.iterator();
    long l1 = 9223372036854775807L;
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      long l2 = locala.tE(this.yhK);
      locala.draw(paramCanvas, paramPaint);
      if (l2 < l1) {
        l1 = l2;
      }
    }
    this.yhK = l1;
    l1 = this.yhK;
    AppMethodBeat.o(279882);
    return l1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b
 * JD-Core Version:    0.7.0.1
 */