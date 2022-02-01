package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class k
{
  public final a Rrp;
  public final long Rrq;
  public int tIv;
  i tIw;
  
  private k(a parama, long paramLong)
  {
    AppMethodBeat.i(205051);
    this.Rrp = parama;
    this.Rrq = paramLong;
    AppMethodBeat.o(205051);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(205055);
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if ((!p.j(this.Rrp, paramObject.Rrp)) || (this.Rrq != paramObject.Rrq)) {}
      }
    }
    else
    {
      AppMethodBeat.o(205055);
      return true;
    }
    AppMethodBeat.o(205055);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(205054);
    a locala = this.Rrp;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.Rrq;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(205054);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(205053);
    String str = "WxRVDataItem(convertData=" + this.Rrp + ", exposeTimestamp=" + this.Rrq + ")";
    AppMethodBeat.o(205053);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.k
 * JD-Core Version:    0.7.0.1
 */