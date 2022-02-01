package com.tencent.mm.plugin.mv.model.a;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.platformtools.f;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/netscene/NetSceneCostObj;", "", "type", "", "create", "", "dispatch", "callback", "(IJJJ)V", "getCallback", "()J", "getCreate", "getDispatch", "getType", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  private final long LYJ;
  private final long LYK;
  private final long LYL;
  private final int type;
  
  public c(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    this.type = paramInt;
    this.LYJ = paramLong1;
    this.LYK = paramLong2;
    this.LYL = paramLong3;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
      if (this.type != paramObject.type) {
        return false;
      }
      if (this.LYJ != paramObject.LYJ) {
        return false;
      }
      if (this.LYK != paramObject.LYK) {
        return false;
      }
    } while (this.LYL == paramObject.LYL);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(286295);
    int i = this.type;
    int j = q.a..ExternalSyntheticBackport0.m(this.LYJ);
    int k = q.a..ExternalSyntheticBackport0.m(this.LYK);
    int m = q.a..ExternalSyntheticBackport0.m(this.LYL);
    AppMethodBeat.o(286295);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286280);
    String str = this.type + ": cost:" + (this.LYL - this.LYJ) + " dispatchCost:" + (this.LYL - this.LYK) + " time:" + f.formatTime("yyyy-MM-dd HH:mm:ss", this.LYJ / 1000L);
    AppMethodBeat.o(286280);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.a.c
 * JD-Core Version:    0.7.0.1
 */