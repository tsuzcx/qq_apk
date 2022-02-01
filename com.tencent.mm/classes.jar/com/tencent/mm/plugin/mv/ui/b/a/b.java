package com.tencent.mm.plugin.mv.ui.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.livebase.redux.a;
import com.tencent.mm.protocal.protobuf.doi;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/redux/album/InitAction;", "Lcom/tencent/mm/plugin/livebase/redux/IReduxAction;", "previewDataObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "(Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;)V", "getPreviewDataObj", "()Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class b
  implements a
{
  public final doi Ghi;
  
  public b(doi paramdoi)
  {
    AppMethodBeat.i(230778);
    this.Ghi = paramdoi;
    AppMethodBeat.o(230778);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(230785);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if (!p.h(this.Ghi, paramObject.Ghi)) {}
      }
    }
    else
    {
      AppMethodBeat.o(230785);
      return true;
    }
    AppMethodBeat.o(230785);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(230782);
    doi localdoi = this.Ghi;
    if (localdoi != null)
    {
      int i = localdoi.hashCode();
      AppMethodBeat.o(230782);
      return i;
    }
    AppMethodBeat.o(230782);
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(230780);
    String str = "InitAction(previewDataObj=" + this.Ghi + ")";
    AppMethodBeat.o(230780);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.b.a.b
 * JD-Core Version:    0.7.0.1
 */