package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class h
{
  public int KMi;
  f KMj;
  public final a LDU;
  public final long LDV;
  
  private h(a parama, long paramLong)
  {
    AppMethodBeat.i(203984);
    this.LDU = parama;
    this.LDV = paramLong;
    AppMethodBeat.o(203984);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203988);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!k.g(this.LDU, paramObject.LDU)) || (this.LDV != paramObject.LDV)) {}
      }
    }
    else
    {
      AppMethodBeat.o(203988);
      return true;
    }
    AppMethodBeat.o(203988);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203987);
    a locala = this.LDU;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.LDV;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(203987);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203986);
    String str = "WxRVDataItem(convertData=" + this.LDU + ", exposeTimestamp=" + this.LDV + ")";
    AppMethodBeat.o(203986);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */