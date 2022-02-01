package com.tencent.mm.plugin.performance.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "", "time", "", "thread", "Ljava/lang/Thread;", "type", "", "(JLjava/lang/Thread;I)V", "count", "getCount", "()I", "setCount", "(I)V", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a$b
{
  int count;
  Thread thread;
  long time;
  int type;
  
  public a$b(long paramLong, int paramInt)
  {
    this.time = paramLong;
    this.thread = null;
    this.type = paramInt;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(184652);
    if (this == paramObject)
    {
      AppMethodBeat.o(184652);
      return true;
    }
    if (!(paramObject instanceof b))
    {
      AppMethodBeat.o(184652);
      return false;
    }
    paramObject = (b)paramObject;
    if (this.time != paramObject.time)
    {
      AppMethodBeat.o(184652);
      return false;
    }
    if (!s.p(this.thread, paramObject.thread))
    {
      AppMethodBeat.o(184652);
      return false;
    }
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(184652);
      return false;
    }
    AppMethodBeat.o(184652);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(184651);
    int j = q.a..ExternalSyntheticBackport0.m(this.time);
    if (this.thread == null) {}
    for (int i = 0;; i = this.thread.hashCode())
    {
      int k = this.type;
      AppMethodBeat.o(184651);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(184650);
    String str = "CheckInfo(time=" + this.time + ", thread=" + this.thread + ", type=" + this.type + ')';
    AppMethodBeat.o(184650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.b
 * JD-Core Version:    0.7.0.1
 */