package com.tencent.mm.plugin.vlog.ui.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.ac;
import com.tencent.mm.view.m;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiPhotoEditContainerPlugin$PhotoEditorViewData;", "", "editor", "Lcom/tencent/mm/api/MMPhotoEditor;", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "(Lcom/tencent/mm/api/MMPhotoEditor;Lcom/tencent/mm/view/PhotoDrawingView;)V", "getDrawingView", "()Lcom/tencent/mm/view/PhotoDrawingView;", "getEditor", "()Lcom/tencent/mm/api/MMPhotoEditor;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
final class s$b
{
  final m NKg;
  final ac UiZ;
  
  public s$b(ac paramac, m paramm)
  {
    AppMethodBeat.i(282603);
    this.UiZ = paramac;
    this.NKg = paramm;
    AppMethodBeat.o(282603);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(282627);
    if (this == paramObject)
    {
      AppMethodBeat.o(282627);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(282627);
      return false;
    }
    paramObject = (b)paramObject;
    if (!s.p(this.UiZ, paramObject.UiZ))
    {
      AppMethodBeat.o(282627);
      return false;
    }
    if (!s.p(this.NKg, paramObject.NKg))
    {
      AppMethodBeat.o(282627);
      return false;
    }
    AppMethodBeat.o(282627);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(282622);
    int i = this.UiZ.hashCode();
    int j = this.NKg.hashCode();
    AppMethodBeat.o(282622);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(282618);
    String str = "PhotoEditorViewData(editor=" + this.UiZ + ", drawingView=" + this.NKg + ')';
    AppMethodBeat.o(282618);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s.b
 * JD-Core Version:    0.7.0.1
 */