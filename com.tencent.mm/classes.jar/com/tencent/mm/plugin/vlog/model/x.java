package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/PlayRange;", "", "start", "", "end", "(JJ)V", "getEnd", "()J", "setEnd", "(J)V", "getStart", "setStart", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-vlog_release"})
public final class x
{
  long boX = 0L;
  long start = 0L;
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof x))
      {
        paramObject = (x)paramObject;
        if ((this.start != paramObject.start) || (this.boX != paramObject.boX)) {}
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
    l = this.boX;
    return i * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190635);
    String str = "PlayRange(start=" + this.start + ", end=" + this.boX + ")";
    AppMethodBeat.o(190635);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.x
 * JD-Core Version:    0.7.0.1
 */