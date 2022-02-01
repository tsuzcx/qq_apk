package com.tencent.threadpool.h;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d.a;
import com.tencent.threadpool.i.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class e
{
  public final b ahCf;
  public final c ahCg;
  public final f ahCh;
  
  public e(com.tencent.threadpool.a parama)
  {
    AppMethodBeat.i(183363);
    this.ahCf = new b(parama.ahzO, parama.ahzN);
    this.ahCg = new c(parama.ahzP);
    this.ahCh = new f();
    AppMethodBeat.o(183363);
  }
  
  private static <V> com.tencent.threadpool.i.d<V> a(k<V> paramk, boolean paramBoolean, d paramd)
  {
    AppMethodBeat.i(183365);
    paramk.a(paramd);
    long l;
    if ((paramk instanceof com.tencent.threadpool.j.e))
    {
      paramd = (com.tencent.threadpool.j.e)paramk;
      com.tencent.threadpool.j.d locald = paramd.serial.ahCy;
      if (paramBoolean)
      {
        l = -2147483648L;
        locald.a(l, paramd);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(183365);
      return paramk;
      l = paramk.getDelay(TimeUnit.MILLISECONDS);
      break;
      paramk.ahCr.g(paramk);
    }
  }
  
  private d l(k<?> paramk)
  {
    AppMethodBeat.i(183367);
    if (com.tencent.threadpool.c.b.ahBl != null)
    {
      if (com.tencent.threadpool.c.b.ahBl.gL(paramk.getKey()))
      {
        paramk = this.ahCf;
        AppMethodBeat.o(183367);
        return paramk;
      }
      paramk = this.ahCg;
      AppMethodBeat.o(183367);
      return paramk;
    }
    if (this.ahCg.isBusy())
    {
      paramk = this.ahCf;
      AppMethodBeat.o(183367);
      return paramk;
    }
    paramk = this.ahCg;
    AppMethodBeat.o(183367);
    return paramk;
  }
  
  public final <V> com.tencent.threadpool.i.d<V> a(k<V> paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(226905);
    paramk.a(this.ahCh);
    if (paramBoolean)
    {
      this.ahCh.m(paramk);
      AppMethodBeat.o(226905);
      return paramk;
    }
    paramk = this.ahCh.f(paramk);
    AppMethodBeat.o(226905);
    return paramk;
  }
  
  public final <V> com.tencent.threadpool.i.d<V> b(k<V> paramk, boolean paramBoolean)
  {
    AppMethodBeat.i(183364);
    paramk = a(paramk, paramBoolean, l(paramk));
    AppMethodBeat.o(183364);
    return paramk;
  }
  
  public final <V> com.tencent.threadpool.i.d<V> j(k<V> paramk)
  {
    AppMethodBeat.i(226906);
    paramk = a(paramk, false, this.ahCf);
    AppMethodBeat.o(226906);
    return paramk;
  }
  
  public final Map<String, List<String>> jYT()
  {
    AppMethodBeat.i(183366);
    localLinkedHashMap = new LinkedHashMap();
    try
    {
      Object localObject1 = this.ahCh.ahCi;
      Object localObject2 = new LinkedList();
      ((f.a)localObject1).mainHandler.dump(new f.a.2((f.a)localObject1, (List)localObject2), "");
      localLinkedHashMap.put("UIPool", localObject2);
      localLinkedHashMap.put("HotPool", this.ahCg.jZs());
      localLinkedHashMap.put("ColdPool", this.ahCf.jZs());
      localObject1 = com.tencent.threadpool.j.a.jZC().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (com.tencent.threadpool.j.a)((Iterator)localObject1).next();
        List localList = ((com.tencent.threadpool.j.a)localObject2).ahCy.jZD();
        if (localList.size() > 0) {
          localLinkedHashMap.put(((com.tencent.threadpool.j.a)localObject2).tag, localList);
        }
      }
      return localLinkedHashMap;
    }
    catch (NullPointerException localNullPointerException)
    {
      com.tencent.threadpool.d.ahAq.e("PoolAdapter", "[dumpWaitingTask] e=%s", new Object[] { localNullPointerException });
      AppMethodBeat.o(183366);
    }
  }
  
  public final <V> com.tencent.threadpool.i.d<V> k(k<V> paramk)
  {
    AppMethodBeat.i(226908);
    paramk = a(paramk, false, this.ahCg);
    AppMethodBeat.o(226908);
    return paramk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.h.e
 * JD-Core Version:    0.7.0.1
 */