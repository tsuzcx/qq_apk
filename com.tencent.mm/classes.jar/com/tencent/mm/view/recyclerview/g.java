package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class g
{
  LinkedList<h> LDQ;
  LinkedList<h> LDR;
  LinkedList<h> LDS;
  public LinkedList<h> LDT;
  int mYh;
  int mYi;
  int qsi;
  int qsj;
  private final int state;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(203982);
    this.state = paramInt;
    this.mYh = -1;
    this.mYi = -1;
    this.qsi = -1;
    this.qsj = -1;
    this.LDQ = new LinkedList();
    this.LDR = new LinkedList();
    this.LDS = new LinkedList();
    this.LDT = new LinkedList();
    AppMethodBeat.o(203982);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof g))
      {
        paramObject = (g)paramObject;
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
    AppMethodBeat.i(203983);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(203983);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */