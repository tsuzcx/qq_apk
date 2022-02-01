package com.tencent.mm.plugin.performance.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/performance/thread/ThreadPoolProfiler$BatteryRecord;", "", "threadTime", "", "count", "", "name", "", "(JILjava/lang/String;)V", "getCount", "()I", "setCount", "(I)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getThreadTime", "()J", "setThreadTime", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-performance_release"})
public final class a$a
{
  int count;
  String name;
  long utu;
  
  public a$a(String paramString)
  {
    AppMethodBeat.i(185179);
    this.utu = 0L;
    this.count = 0;
    this.name = paramString;
    AppMethodBeat.o(185179);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(185181);
    if (this != paramObject)
    {
      if ((paramObject instanceof a))
      {
        paramObject = (a)paramObject;
        if ((this.utu != paramObject.utu) || (this.count != paramObject.count) || (!k.g(this.name, paramObject.name))) {}
      }
    }
    else
    {
      AppMethodBeat.o(185181);
      return true;
    }
    AppMethodBeat.o(185181);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(185180);
    long l = this.utu;
    int j = (int)(l ^ l >>> 32);
    int k = this.count;
    String str = this.name;
    if (str != null) {}
    for (int i = str.hashCode();; i = 0)
    {
      AppMethodBeat.o(185180);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(185178);
    String str = "{name=" + this.name + " threadTime=" + this.utu + " count=" + this.count + '}';
    AppMethodBeat.o(185178);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.performance.b.a.a
 * JD-Core Version:    0.7.0.1
 */