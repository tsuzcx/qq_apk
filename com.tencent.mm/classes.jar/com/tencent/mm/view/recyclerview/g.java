package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class g
{
  LinkedList<h> LvG;
  public LinkedList<h> LvH;
  LinkedList<h> LvI;
  public LinkedList<h> LvJ;
  int obN;
  int obO;
  int rRd;
  int rRf;
  private final int state;
  
  public g(int paramInt)
  {
    AppMethodBeat.i(186671);
    this.state = paramInt;
    this.obN = -1;
    this.obO = -1;
    this.rRd = -1;
    this.rRf = -1;
    this.LvG = new LinkedList();
    this.LvH = new LinkedList();
    this.LvI = new LinkedList();
    this.LvJ = new LinkedList();
    AppMethodBeat.o(186671);
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
    AppMethodBeat.i(186672);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(186672);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.g
 * JD-Core Version:    0.7.0.1
 */