package com.tencent.mm.plugin.mv.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.j.f;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "", "type", "", "create", "", "dispatch", "callback", "(IJJJ)V", "getCallback", "()J", "getCreate", "getDispatch", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mv_release"})
public final class b
{
  private final long GcZ;
  private final long Gda;
  private final long Gdb;
  private final int type;
  
  public b(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = paramInt;
    this.GcZ = paramLong1;
    this.Gda = paramLong2;
    this.Gdb = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.type != paramObject.type) || (this.GcZ != paramObject.GcZ) || (this.Gda != paramObject.Gda) || (this.Gdb != paramObject.Gdb)) {}
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
    long l = this.GcZ;
    int j = (int)(l ^ l >>> 32);
    l = this.Gda;
    int k = (int)(l ^ l >>> 32);
    l = this.Gdb;
    return ((i * 31 + j) * 31 + k) * 31 + (int)(l ^ l >>> 32);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(239542);
    String str = this.type + ": cost:" + (this.Gdb - this.GcZ) + " dispatchCost:" + (this.Gdb - this.Gda) + " time:" + f.formatTime("yyyy-MM-dd HH:mm:ss", this.GcZ / 1000L);
    AppMethodBeat.o(239542);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.b
 * JD-Core Version:    0.7.0.1
 */