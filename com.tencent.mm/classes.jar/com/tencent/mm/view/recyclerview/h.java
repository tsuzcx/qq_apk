package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class h
{
  public final a LvK;
  public final long LvL;
  public int rRa;
  f rRb;
  
  private h(a parama, long paramLong)
  {
    AppMethodBeat.i(186673);
    this.LvK = parama;
    this.LvL = paramLong;
    AppMethodBeat.o(186673);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(186677);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.i(this.LvK, paramObject.LvK)) || (this.LvL != paramObject.LvL)) {}
      }
    }
    else
    {
      AppMethodBeat.o(186677);
      return true;
    }
    AppMethodBeat.o(186677);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(186676);
    a locala = this.LvK;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.LvL;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(186676);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(186675);
    String str = "WxRVDataItem(convertData=" + this.LvK + ", exposeTimestamp=" + this.LvL + ")";
    AppMethodBeat.o(186675);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */