package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class g
{
  LinkedList<h> LSt;
  public LinkedList<h> LSu;
  LinkedList<h> LSv;
  public LinkedList<h> LSw;
  int ohB;
  int ohC;
  int rZF;
  int rZH;
  private final int state;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(193928);
    this.state = paramInt;
    this.ohB = -1;
    this.ohC = -1;
    this.rZF = -1;
    this.rZH = -1;
    this.LSt = new LinkedList();
    this.LSu = new LinkedList();
    this.LSv = new LinkedList();
    this.LSw = new LinkedList();
    AppMethodBeat.o(193928);
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
    AppMethodBeat.i(193929);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(193929);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */