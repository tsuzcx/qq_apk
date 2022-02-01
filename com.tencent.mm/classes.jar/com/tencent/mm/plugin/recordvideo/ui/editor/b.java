package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-recordvideo_release"})
public final class b
{
  private final List<a> uVd;
  private long uVe;
  
  public b(List<a> paramList)
  {
    AppMethodBeat.i(224387);
    this.uVd = paramList;
    AppMethodBeat.o(224387);
  }
  
  public final long a(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(224386);
    p.k(paramCanvas, "canvas");
    p.k(paramPaint, "paint");
    if (this.uVd.size() <= 0)
    {
      AppMethodBeat.o(224386);
      return 0L;
    }
    Iterator localIterator = this.uVd.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      long l2 = locala.PE(this.uVe);
      locala.draw(paramCanvas, paramPaint);
      if (l2 >= l1) {
        break label121;
      }
      l1 = l2;
    }
    label121:
    for (;;)
    {
      break;
      this.uVe = l1;
      l1 = this.uVe;
      AppMethodBeat.o(224386);
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b
 * JD-Core Version:    0.7.0.1
 */