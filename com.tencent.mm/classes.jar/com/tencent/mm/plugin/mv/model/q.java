package com.tencent.mm.plugin.mv.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/StatRecord;", "", "index", "", "(I)V", "createTimeStamp", "", "getCreateTimeStamp", "()J", "setCreateTimeStamp", "(J)V", "getIndex", "()I", "setIndex", "isAutoPlay", "", "()Z", "setAutoPlay", "(Z)V", "lastPlayTime", "getLastPlayTime", "setLastPlayTime", "maxPlayLength", "getMaxPlayLength", "setMaxPlayLength", "maxPlayPercent", "getMaxPlayPercent", "setMaxPlayPercent", "retryPlayTimes", "getRetryPlayTimes", "setRetryPlayTimes", "vidPlayLen", "getVidPlayLen", "setVidPlayLen", "component1", "copy", "equals", "other", "hashCode", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
{
  public int FsL;
  public int FsM;
  public long FsW;
  public int Gwt;
  int index;
  public boolean isAutoPlay;
  long rmn;
  
  public q(int paramInt)
  {
    AppMethodBeat.i(286119);
    this.index = paramInt;
    this.rmn = cn.bDw();
    this.isAutoPlay = true;
    AppMethodBeat.o(286119);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        return false;
      }
      paramObject = (q)paramObject;
    } while (this.index == paramObject.index);
    return false;
  }
  
  public final int hashCode()
  {
    return this.index;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(286127);
    String str = "StatRecord(index=" + this.index + ')';
    AppMethodBeat.o(286127);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.q
 * JD-Core Version:    0.7.0.1
 */