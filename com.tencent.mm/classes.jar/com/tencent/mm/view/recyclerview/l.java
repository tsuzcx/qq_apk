package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class l
{
  public final long BQj;
  public final a YSP;
  public int xre;
  j xrf;
  
  private l(a parama, long paramLong)
  {
    AppMethodBeat.i(191132);
    this.YSP = parama;
    this.BQj = paramLong;
    AppMethodBeat.o(191132);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(191144);
    if (this != paramObject)
    {
      if ((paramObject instanceof l))
      {
        paramObject = (l)paramObject;
        if ((!p.h(this.YSP, paramObject.YSP)) || (this.BQj != paramObject.BQj)) {}
      }
    }
    else
    {
      AppMethodBeat.o(191144);
      return true;
    }
    AppMethodBeat.o(191144);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(191139);
    a locala = this.YSP;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.BQj;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(191139);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191138);
    String str = "WxRVDataItem(convertData=" + this.YSP + ", exposeTimestamp=" + this.BQj + ")";
    AppMethodBeat.o(191138);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.l
 * JD-Core Version:    0.7.0.1
 */