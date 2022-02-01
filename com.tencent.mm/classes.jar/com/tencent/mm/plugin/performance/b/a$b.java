package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$CheckInfo;", "", "time", "", "thread", "Ljava/lang/Thread;", "type", "", "(JLjava/lang/Thread;I)V", "count", "getCount", "()I", "setCount", "(I)V", "getThread", "()Ljava/lang/Thread;", "setThread", "(Ljava/lang/Thread;)V", "getTime", "()J", "setTime", "(J)V", "getType", "setType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-performance_release"})
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
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.time != paramObject.time) || (!k.g(this.thread, paramObject.thread)) || (this.type != paramObject.type)) {}
      }
    }
    else
    {
      AppMethodBeat.o(184652);
      return true;
    }
    AppMethodBeat.o(184652);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(184651);
    long l = this.time;
    int j = (int)(l ^ l >>> 32);
    Thread localThread = this.thread;
    if (localThread != null) {}
    for (int i = localThread.hashCode();; i = 0)
    {
      int k = this.type;
      AppMethodBeat.o(184651);
      return (i + j * 31) * 31 + k;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(184650);
    String str = "CheckInfo(time=" + this.time + ", thread=" + this.thread + ", type=" + this.type + ")";
    AppMethodBeat.o(184650);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.b
 * JD-Core Version:    0.7.0.1
 */