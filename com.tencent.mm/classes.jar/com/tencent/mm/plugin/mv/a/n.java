package com.tencent.mm.plugin.mv.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "", "pcu", "", "fcu", "mcu", "(JJJ)V", "getFcu", "()J", "setFcu", "(J)V", "getMcu", "setMcu", "getPcu", "setPcu", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"})
public final class n
{
  public long UqB;
  public long UqC;
  public long UqD;
  
  public n(long paramLong1, long paramLong2, long paramLong3)
  {
    this.UqB = paramLong1;
    this.UqC = paramLong2;
    this.UqD = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((this.UqB != paramObject.UqB) || (this.UqC != paramObject.UqC) || (this.UqD != paramObject.UqD)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    long l = this.UqB;
    int i = (int)(l ^ l >>> 32);
    l = this.UqC;
    int j = (int)(l ^ l >>> 32);
    l = this.UqD;
    return (i * 31 + j) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258857);
    String str = "OnlineUserObj(pcu=" + this.UqB + ", fcu=" + this.UqC + ", mcu=" + this.UqD + ")";
    AppMethodBeat.o(258857);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.n
 * JD-Core Version:    0.7.0.1
 */