package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "", "pcu", "", "fcu", "mcu", "(JJJ)V", "getFcu", "()J", "setFcu", "(J)V", "getMcu", "setMcu", "getPcu", "setPcu", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class p
{
  public long GcD;
  public long GcE;
  public long GcF;
  
  public p(long paramLong1, long paramLong2, long paramLong3)
  {
    this.GcD = paramLong1;
    this.GcE = paramLong2;
    this.GcF = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof p))
      {
        paramObject = (p)paramObject;
        if ((this.GcD != paramObject.GcD) || (this.GcE != paramObject.GcE) || (this.GcF != paramObject.GcF)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.GcD;
    int i = (int)(l ^ l >>> 32);
    l = this.GcE;
    int j = (int)(l ^ l >>> 32);
    l = this.GcF;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(227261);
    String str = "OnlineUserObj(pcu=" + this.GcD + ", fcu=" + this.GcE + ", mcu=" + this.GcF + ")";
    AppMethodBeat.o(227261);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.p
 * JD-Core Version:    0.7.0.1
 */