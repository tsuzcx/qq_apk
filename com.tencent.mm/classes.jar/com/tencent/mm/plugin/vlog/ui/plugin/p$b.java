package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.view.e;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
public final class p$b
{
  public final y BNI;
  public final e xAx;
  
  public p$b(y paramy, e parame)
  {
    AppMethodBeat.i(196273);
    this.BNI = paramy;
    this.xAx = parame;
    AppMethodBeat.o(196273);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(196276);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.BNI, paramObject.BNI)) || (!p.i(this.xAx, paramObject.xAx))) {}
      }
    }
    else
    {
      AppMethodBeat.o(196276);
      return true;
    }
    AppMethodBeat.o(196276);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(196275);
    Object localObject = this.BNI;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.xAx;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(196275);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196274);
    String str = "PhotoEditorViewData(editor=" + this.BNI + ", drawingView=" + this.xAx + ")";
    AppMethodBeat.o(196274);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p.b
 * JD-Core Version:    0.7.0.1
 */