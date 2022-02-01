package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "", "start", "", "end", "(JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getStart", "setStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
public final class q
{
  long bpc = 0L;
  long start = 0L;
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if ((this.start != paramObject.start) || (this.bpc != paramObject.bpc)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.start;
    int i = (int)(l ^ l >>> 32);
    l = this.bpc;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(191205);
    String str = "PlayRange(start=" + this.start + ", end=" + this.bpc + ")";
    AppMethodBeat.o(191205);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.q
 * JD-Core Version:    0.7.0.1
 */