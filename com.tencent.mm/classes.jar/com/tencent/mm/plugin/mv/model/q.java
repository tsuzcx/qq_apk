package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cm;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/model/StatRecord;", "", "index", "", "(I)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "getIndex", "()I", "setIndex", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "retryPlayTimes", "getRetryPlayTimes", "setRetryPlayTimes", "vidPlayLen", "getVidPlayLen", "setVidPlayLen", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-mv_release"})
public final class q
{
  public int AUa;
  int index;
  public boolean isAutoPlay;
  long oiL;
  public int zXf;
  public int zXg;
  public long zXq;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(243568);
    this.index = paramInt;
    this.oiL = cm.bfE();
    this.isAutoPlay = true;
    AppMethodBeat.o(243568);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof q))
      {
        paramObject = (q)paramObject;
        if (this.index != paramObject.index) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  public final int hashCode()
  {
    return this.index;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(243569);
    String str = "StatRecord(index=" + this.index + ")";
    AppMethodBeat.o(243569);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.q
 * JD-Core Version:    0.7.0.1
 */