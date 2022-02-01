package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class g
{
  LinkedList<h> JCA;
  public LinkedList<h> JCB;
  LinkedList<h> JCC;
  public LinkedList<h> JCD;
  int nAG;
  int nAH;
  int rdH;
  int rdJ;
  private final int state;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(197338);
    this.state = paramInt;
    this.nAG = -1;
    this.nAH = -1;
    this.rdH = -1;
    this.rdJ = -1;
    this.JCA = new LinkedList();
    this.JCB = new LinkedList();
    this.JCC = new LinkedList();
    this.JCD = new LinkedList();
    AppMethodBeat.o(197338);
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
    AppMethodBeat.i(197339);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(197339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */