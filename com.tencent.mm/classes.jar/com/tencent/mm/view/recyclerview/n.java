package com.tencent.mm.view.recyclerview;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "", "convertData", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "exposeTimestamp", "", "(Lcom/tencent/mm/view/recyclerview/ConvertData;J)V", "getConvertData", "()Lcom/tencent/mm/view/recyclerview/ConvertData;", "dataPos", "", "getDataPos", "()I", "setDataPos", "(I)V", "getExposeTimestamp", "()J", "showInfo", "Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "getShowInfo", "()Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;", "setShowInfo", "(Lcom/tencent/mm/view/recyclerview/WxItemShowInfo;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
{
  public int AOn;
  l AOo;
  public final long Fzm;
  public final a agOG;
  
  private n(a parama, long paramLong)
  {
    AppMethodBeat.i(234908);
    this.agOG = parama;
    this.Fzm = paramLong;
    AppMethodBeat.o(234908);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(234925);
    if (this == paramObject)
    {
      AppMethodBeat.o(234925);
      return true;
    }
    if (!(paramObject instanceof n))
    {
      AppMethodBeat.o(234925);
      return false;
    }
    paramObject = (n)paramObject;
    if (!s.p(this.agOG, paramObject.agOG))
    {
      AppMethodBeat.o(234925);
      return false;
    }
    if (this.Fzm != paramObject.Fzm)
    {
      AppMethodBeat.o(234925);
      return false;
    }
    AppMethodBeat.o(234925);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(234920);
    int i = this.agOG.hashCode();
    int j = q.a..ExternalSyntheticBackport0.m(this.Fzm);
    AppMethodBeat.o(234920);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234916);
    String str = "WxRVDataItem(convertData=" + this.agOG + ", exposeTimestamp=" + this.Fzm + ')';
    AppMethodBeat.o(234916);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.n
 * JD-Core Version:    0.7.0.1
 */