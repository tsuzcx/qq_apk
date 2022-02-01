package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstExposeList", "getFirstExposeList", "setFirstExposeList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class k
{
  public LinkedList<l> YSK;
  public LinkedList<l> YSL;
  LinkedList<l> YSM;
  public LinkedList<l> YSN;
  public LinkedList<l> YSO;
  public int sCr;
  public int sCs;
  public final int state;
  public int xrh;
  public int xrj;
  
  public k(int paramInt)
  {
    AppMethodBeat.i(191084);
    this.state = paramInt;
    this.sCr = -1;
    this.sCs = -1;
    this.xrh = -1;
    this.xrj = -1;
    this.YSK = new LinkedList();
    this.YSL = new LinkedList();
    this.YSM = new LinkedList();
    this.YSN = new LinkedList();
    this.YSO = new LinkedList();
    AppMethodBeat.o(191084);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof k))
      {
        paramObject = (k)paramObject;
        if (this.state != paramObject.state) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.state;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191085);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(191085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.k
 * JD-Core Version:    0.7.0.1
 */