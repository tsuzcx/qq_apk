package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class h
{
  public final a LSx;
  public final long LSy;
  public int rZC;
  f rZD;
  
  private h(a parama, long paramLong)
  {
    AppMethodBeat.i(193930);
    this.LSx = parama;
    this.LSy = paramLong;
    AppMethodBeat.o(193930);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(193934);
    if (this != paramObject)
    {
      if ((paramObject instanceof h))
      {
        paramObject = (h)paramObject;
        if ((!p.i(this.LSx, paramObject.LSx)) || (this.LSy != paramObject.LSy)) {}
      }
    }
    else
    {
      AppMethodBeat.o(193934);
      return true;
    }
    AppMethodBeat.o(193934);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(193933);
    a locala = this.LSx;
    if (locala != null) {}
    for (int i = locala.hashCode();; i = 0)
    {
      long l = this.LSy;
      int j = (int)(l ^ l >>> 32);
      AppMethodBeat.o(193933);
      return i * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(193932);
    String str = "WxRVDataItem(convertData=" + this.LSx + ", exposeTimestamp=" + this.LSy + ")";
    AppMethodBeat.o(193932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.h
 * JD-Core Version:    0.7.0.1
 */