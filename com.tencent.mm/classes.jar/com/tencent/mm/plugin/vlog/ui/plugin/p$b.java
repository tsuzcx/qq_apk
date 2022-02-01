package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.y;
import com.tencent.mm.view.e;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
public final class p$b
{
  public final y Cfh;
  public final e xQt;
  
  public p$b(y paramy, e parame)
  {
    AppMethodBeat.i(191732);
    this.Cfh = paramy;
    this.xQt = parame;
    AppMethodBeat.o(191732);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191735);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((!p.i(this.Cfh, paramObject.Cfh)) || (!p.i(this.xQt, paramObject.xQt))) {}
      }
    }
    else
    {
      AppMethodBeat.o(191735);
      return true;
    }
    AppMethodBeat.o(191735);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(191734);
    Object localObject = this.Cfh;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.xQt;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(191734);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191733);
    String str = "PhotoEditorViewData(editor=" + this.Cfh + ", drawingView=" + this.xQt + ")";
    AppMethodBeat.o(191733);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.p.b
 * JD-Core Version:    0.7.0.1
 */