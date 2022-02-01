package com.tencent.mm.plugin.mv.model;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/OnlineUserObj;", "", "pcu", "", "fcu", "mcu", "(JJJ)V", "getFcu", "()J", "setFcu", "(J)V", "getMcu", "setMcu", "getPcu", "setPcu", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class p
{
  long LYm;
  long LYn;
  long LYo;
  
  public p(long paramLong1, long paramLong2, long paramLong3)
  {
    this.LYm = paramLong1;
    this.LYn = paramLong2;
    this.LYo = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof p)) {
        return false;
      }
      paramObject = (p)paramObject;
      if (this.LYm != paramObject.LYm) {
        return false;
      }
      if (this.LYn != paramObject.LYn) {
        return false;
      }
    } while (this.LYo == paramObject.LYo);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286143);
    int i = q.a..ExternalSyntheticBackport0.m(this.LYm);
    int j = q.a..ExternalSyntheticBackport0.m(this.LYn);
    int k = q.a..ExternalSyntheticBackport0.m(this.LYo);
    AppMethodBeat.o(286143);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286136);
    String str = "OnlineUserObj(pcu=" + this.LYm + ", fcu=" + this.LYn + ", mcu=" + this.LYo + ')';
    AppMethodBeat.o(286136);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.p
 * JD-Core Version:    0.7.0.1
 */