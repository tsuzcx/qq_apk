package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstExposeList", "getFirstExposeList", "setFirstExposeList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"})
public final class j
{
  public LinkedList<k> Rrk;
  public LinkedList<k> Rrl;
  LinkedList<k> Rrm;
  public LinkedList<k> Rrn;
  public LinkedList<k> Rro;
  public int ptb;
  public int ptc;
  public final int state;
  public int tIA;
  public int tIy;
  
  public j(int paramInt)
  {
    AppMethodBeat.i(205049);
    this.state = paramInt;
    this.ptb = -1;
    this.ptc = -1;
    this.tIy = -1;
    this.tIA = -1;
    this.Rrk = new LinkedList();
    this.Rrl = new LinkedList();
    this.Rrm = new LinkedList();
    this.Rrn = new LinkedList();
    this.Rro = new LinkedList();
    AppMethodBeat.o(205049);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof j))
      {
        paramObject = (j)paramObject;
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
    AppMethodBeat.i(205050);
    String str = "WxRVData(state=" + this.state + ")";
    AppMethodBeat.o(205050);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.j
 * JD-Core Version:    0.7.0.1
 */