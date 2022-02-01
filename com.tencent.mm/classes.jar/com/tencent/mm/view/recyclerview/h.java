package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class h
{
  public final a JCE;
  public final long JCF;
  public int rdE;
  f rdF;
  
  private h(a parama, long paramLong)
  {
    AppMethodBeat.i(197340);
    this.JCE = parama;
    this.JCF = paramLong;
    AppMethodBeat.o(197340);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(197344);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!k.g(this.JCE, paramObject.JCE)) || (this.JCF != paramObject.JCF)) {}
      }
    }
    else
    {
      AppMethodBeat.o(197344);
      return true;
    }
    AppMethodBeat.o(197344);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(197343);
    a locala = this.JCE;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.JCF;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(197343);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(197342);
    String str = "WxRVDataItem(convertData=" + this.JCE + ", exposeTimestamp=" + this.JCF + ")";
    AppMethodBeat.o(197342);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */