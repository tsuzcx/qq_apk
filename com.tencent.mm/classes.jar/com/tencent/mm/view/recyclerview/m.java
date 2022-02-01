package com.tencent.mm.view.recyclerview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/view/recyclerview/WxRVData;", "", "state", "", "(I)V", "acrossDataList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/view/recyclerview/WxRVDataItem;", "getAcrossDataList", "()Ljava/util/LinkedList;", "setAcrossDataList", "(Ljava/util/LinkedList;)V", "diffInvisibleDataList", "getDiffInvisibleDataList", "setDiffInvisibleDataList", "diffVisibleDataList", "getDiffVisibleDataList", "setDiffVisibleDataList", "firstExposeList", "getFirstExposeList", "setFirstExposeList", "firstVisibleItemPosition", "getFirstVisibleItemPosition", "()I", "setFirstVisibleItemPosition", "lastFirstVisibleItemPosition", "getLastFirstVisibleItemPosition", "setLastFirstVisibleItemPosition", "lastLastVisibleItemPosition", "getLastLastVisibleItemPosition", "setLastLastVisibleItemPosition", "lastVisibleItemPosition", "getLastVisibleItemPosition", "setLastVisibleItemPosition", "getState", "visibleDataList", "getVisibleDataList", "setVisibleDataList", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
{
  public int AOr;
  public int AOt;
  public LinkedList<n> agOB;
  public LinkedList<n> agOC;
  LinkedList<n> agOD;
  public LinkedList<n> agOE;
  public LinkedList<n> agOF;
  public final int state;
  public int vIj;
  public int vIk;
  
  public m(int paramInt)
  {
    AppMethodBeat.i(234905);
    this.state = paramInt;
    this.vIj = -1;
    this.vIk = -1;
    this.AOr = -1;
    this.AOt = -1;
    this.agOB = new LinkedList();
    this.agOC = new LinkedList();
    this.agOD = new LinkedList();
    this.agOE = new LinkedList();
    this.agOF = new LinkedList();
    AppMethodBeat.o(234905);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof m)) {
        return false;
      }
      paramObject = (m)paramObject;
    } while (this.state == paramObject.state);
    return false;
  }
  
  public final int hashCode()
  {
    return this.state;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(234907);
    String str = "WxRVData(state=" + this.state + ')';
    AppMethodBeat.o(234907);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.view.recyclerview.m
 * JD-Core Version:    0.7.0.1
 */