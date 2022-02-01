package com.tencent.mm.plugin.performance.b;

import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "", "threadTime", "", "count", "", "name", "", "(JILjava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getThreadTime", "()J", "setThreadTime", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-performance_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
{
  long MMg;
  int count;
  String name;
  
  public a$a(String paramString)
  {
    AppMethodBeat.i(185179);
    this.MMg = 0L;
    this.count = 0;
    this.name = paramString;
    AppMethodBeat.o(185179);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(185181);
    if (this == paramObject)
    {
      AppMethodBeat.o(185181);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(185181);
      return false;
    }
    paramObject = (a)paramObject;
    if (this.MMg != paramObject.MMg)
    {
      AppMethodBeat.o(185181);
      return false;
    }
    if (this.count != paramObject.count)
    {
      AppMethodBeat.o(185181);
      return false;
    }
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(185181);
      return false;
    }
    AppMethodBeat.o(185181);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(185180);
    int i = q.a..ExternalSyntheticBackport0.m(this.MMg);
    int j = this.count;
    int k = this.name.hashCode();
    AppMethodBeat.o(185180);
    return (i * 31 + j) * 31 + k;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(185178);
    String str = "{name=" + this.name + " threadTime=" + this.MMg + " count=" + this.count + '}';
    AppMethodBeat.o(185178);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.a
 * JD-Core Version:    0.7.0.1
 */