package com.tencent.mm.plugin.mv.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.i.f;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "", "type", "", "create", "", "dispatch", "callback", "(IJJJ)V", "getCallback", "()J", "getCreate", "getDispatch", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mv_release"})
public final class n
{
  private final long UqJ;
  private final long UqK;
  private final long UqL;
  private final int type;
  
  public n(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = paramInt;
    this.UqJ = paramLong1;
    this.UqK = paramLong2;
    this.UqL = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof n))
      {
        paramObject = (n)paramObject;
        if ((this.type != paramObject.type) || (this.UqJ != paramObject.UqJ) || (this.UqK != paramObject.UqK) || (this.UqL != paramObject.UqL)) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    int i = this.type;
    long l = this.UqJ;
    int j = (int)(l ^ l >>> 32);
    l = this.UqK;
    int k = (int)(l ^ l >>> 32);
    l = this.UqL;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(258858);
    String str = this.type + ": cost:" + (this.UqL - this.UqJ) + " dispatchCost:" + (this.UqL - this.UqK) + " time:" + f.formatTime("yyyy-MM-dd HH:mm:ss", this.UqJ / 1000L);
    AppMethodBeat.o(258858);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.a.a.n
 * JD-Core Version:    0.7.0.1
 */