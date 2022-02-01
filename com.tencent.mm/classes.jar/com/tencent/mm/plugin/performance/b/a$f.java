package com.tencent.mm.plugin.performance.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.f;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$TaskStatusInfo;", "", "startTime", "", "delayTime", "runningTime", "state", "Lcom/tencent/threadpool/State;", "pool", "", "(JJJLcom/tencent/threadpool/State;Ljava/lang/String;)V", "getDelayTime", "()J", "setDelayTime", "(J)V", "getPool", "()Ljava/lang/String;", "setPool", "(Ljava/lang/String;)V", "getRunningTime", "setRunningTime", "getStartTime", "setStartTime", "getState", "()Lcom/tencent/threadpool/State;", "setState", "(Lcom/tencent/threadpool/State;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a$f
{
  f MMA;
  String MMB;
  long MMz;
  long delayTime;
  long startTime;
  
  public a$f(long paramLong1, long paramLong2, f paramf)
  {
    AppMethodBeat.i(300827);
    this.startTime = paramLong1;
    this.delayTime = paramLong2;
    this.MMz = 0L;
    this.MMA = paramf;
    this.MMB = null;
    AppMethodBeat.o(300827);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(300844);
    if (this == paramObject)
    {
      AppMethodBeat.o(300844);
      return true;
    }
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(300844);
      return false;
    }
    paramObject = (f)paramObject;
    if (this.startTime != paramObject.startTime)
    {
      AppMethodBeat.o(300844);
      return false;
    }
    if (this.delayTime != paramObject.delayTime)
    {
      AppMethodBeat.o(300844);
      return false;
    }
    if (this.MMz != paramObject.MMz)
    {
      AppMethodBeat.o(300844);
      return false;
    }
    if (this.MMA != paramObject.MMA)
    {
      AppMethodBeat.o(300844);
      return false;
    }
    if (!s.p(this.MMB, paramObject.MMB))
    {
      AppMethodBeat.o(300844);
      return false;
    }
    AppMethodBeat.o(300844);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(300837);
    int j = q.a..ExternalSyntheticBackport0.m(this.startTime);
    int k = q.a..ExternalSyntheticBackport0.m(this.delayTime);
    int m = q.a..ExternalSyntheticBackport0.m(this.MMz);
    int n = this.MMA.hashCode();
    if (this.MMB == null) {}
    for (int i = 0;; i = this.MMB.hashCode())
    {
      AppMethodBeat.o(300837);
      return i + (((j * 31 + k) * 31 + m) * 31 + n) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(300834);
    String str = "TaskStatusInfo(startTime=" + this.startTime + ", delayTime=" + this.delayTime + ", runningTime=" + this.MMz + ", state=" + this.MMA + ", pool=" + this.MMB + ')';
    AppMethodBeat.o(300834);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.f
 * JD-Core Version:    0.7.0.1
 */