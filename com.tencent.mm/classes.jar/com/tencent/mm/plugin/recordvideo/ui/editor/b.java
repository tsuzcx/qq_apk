package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/EditorFrameDrawer;", "", "editorItems", "", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "(Ljava/util/List;)V", "currFrameTime", "", "drawFrame", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "plugin-recordvideo_release"})
public final class b
{
  private final List<a> pRU;
  private long pRV;
  
  public b(List<a> paramList)
  {
    AppMethodBeat.i(200621);
    this.pRU = paramList;
    AppMethodBeat.o(200621);
  }
  
  public final long a(Canvas paramCanvas, Paint paramPaint)
  {
    AppMethodBeat.i(200620);
    p.h(paramCanvas, "canvas");
    p.h(paramPaint, "paint");
    if (this.pRU.size() <= 0)
    {
      AppMethodBeat.o(200620);
      return 0L;
    }
    Iterator localIterator = this.pRU.iterator();
    long l1 = 9223372036854775807L;
    if (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      long l2 = locala.yO(this.pRV);
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
      this.pRV = l1;
      l1 = this.pRV;
      AppMethodBeat.o(200620);
      return l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.b
 * JD-Core Version:    0.7.0.1
 */