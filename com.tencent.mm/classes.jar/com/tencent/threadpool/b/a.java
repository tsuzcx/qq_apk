package com.tencent.threadpool.b;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.threadpool.d.a;
import com.tencent.threadpool.i;
import com.tencent.threadpool.i.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class a
  implements c
{
  private ConcurrentHashMap<String, a> BvD;
  AtomicLong ahAV;
  private final d ahAW;
  volatile long ahAX;
  private com.tencent.threadpool.a ahzW;
  
  public a(Context paramContext, com.tencent.threadpool.a parama)
  {
    AppMethodBeat.i(183202);
    this.BvD = null;
    this.ahAV = new AtomicLong(0L);
    this.ahAX = 0L;
    if (parama.ahzS == null) {}
    for (paramContext = new b(paramContext);; paramContext = parama.ahzS)
    {
      this.ahAW = paramContext;
      this.ahzW = parama;
      jZd();
      AppMethodBeat.o(183202);
      return;
    }
  }
  
  private void jZd()
  {
    AppMethodBeat.i(183211);
    long l = SystemClock.uptimeMillis();
    this.ahAW.delete(this.ahzW.KSt);
    StringBuilder localStringBuilder1 = new StringBuilder("[buildCache] successfully! \n");
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = this.ahAW.jZf().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a)((Map.Entry)localObject).getValue();
      localStringBuilder2.append("# ").append(str).append('-').append(((a)localObject).jZe()).append('\n');
      jZc().put(str, localObject);
      i += 1;
    }
    localStringBuilder1.append("# size:").append(i).append(" cost:").append(SystemClock.uptimeMillis() - l).append("ms\n");
    localStringBuilder1.append(localStringBuilder2);
    com.tencent.threadpool.d.ahAq.i("Experience", localStringBuilder1.toString(), new Object[0]);
    AppMethodBeat.o(183211);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(183206);
    paramk = paramk.jZx();
    k.jZw().d(paramk);
    AppMethodBeat.o(183206);
  }
  
  public final void a(k paramk, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(226927);
    k.jZw().a(paramk.jZx());
    Object localObject = paramk.jZy();
    b localb = new b(paramk.getKey(), localObject[0], localObject[1], paramk.ahCr.getName());
    localObject = (a)jZc().get(localb.name);
    paramk = (k)localObject;
    if (localObject == null)
    {
      paramk = new a(localb.name);
      jZc().put(localb.name, paramk);
    }
    paramk.ahBg.add(localb);
    paramk.ahBc += (float)localb.MMg;
    paramk.ahBd += (float)localb.time;
    int j = paramk.ahBg.size();
    int i = 1;
    if (paramk.ahBe > localb.rate)
    {
      if (j <= 5000)
      {
        i = 1;
        if (i == 0) {
          paramk.ahAZ += paramk.ahBe;
        }
        paramk.ahBe = localb.rate;
      }
    }
    else
    {
      if (paramk.ahBf < localb.rate)
      {
        if (j > 5000) {
          break label396;
        }
        i = 1;
        label232:
        if (i == 0) {
          paramk.ahAZ += paramk.ahBf;
        }
        paramk.ahBf = localb.rate;
      }
      if (i != 0)
      {
        float f = paramk.ahAZ;
        paramk.ahAZ = (localb.rate + f);
      }
      if (j > 5000) {
        break label402;
      }
    }
    label396:
    label402:
    for (i = 0;; i = 2)
    {
      paramk.ahBa = (paramk.ahAZ / (j - i));
      paramk.ahBb = ((1.0F * paramk.ahBc / j));
      paramk.hto = ((1.0F * paramk.ahBd / j));
      if ((this.ahAV.incrementAndGet() >= 5000L) && (System.currentTimeMillis() - this.ahAX >= 600000L)) {
        com.tencent.threadpool.h.ahAA.bn(new com.tencent.threadpool.i.h()
        {
          public final String getKey()
          {
            return "Experience#persistCache";
          }
          
          public final void run()
          {
            AppMethodBeat.i(183194);
            a.this.a(a.this.jZc());
            a.this.ahAV.set(0L);
            a.this.ahAX = System.currentTimeMillis();
            AppMethodBeat.o(183194);
          }
        });
      }
      AppMethodBeat.o(226927);
      return;
      i = 0;
      break;
      i = 0;
      break label232;
    }
  }
  
  final void a(ConcurrentHashMap<String, a> paramConcurrentHashMap)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(183212);
        if (paramConcurrentHashMap.size() <= 0)
        {
          AppMethodBeat.o(183212);
          return;
        }
        l = SystemClock.uptimeMillis();
      }
      finally
      {
        try
        {
          long l;
          this.ahAW.E(paramConcurrentHashMap.values());
          com.tencent.threadpool.d.ahAq.i("Experience", "[persistCache] successfully! size=" + paramConcurrentHashMap.size() + " cost:" + (SystemClock.uptimeMillis() - l), new Object[0]);
          paramConcurrentHashMap.clear();
          AppMethodBeat.o(183212);
        }
        catch (Exception paramConcurrentHashMap)
        {
          com.tencent.threadpool.d.ahAq.e("Experience", "%s", new Object[] { paramConcurrentHashMap.toString() });
          AppMethodBeat.o(183212);
        }
        paramConcurrentHashMap = finally;
      }
    }
  }
  
  public final void ayG()
  {
    AppMethodBeat.i(183213);
    a(jZc());
    AppMethodBeat.o(183213);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(183204);
    k.jZw().a(paramk.jZx());
    AppMethodBeat.o(183204);
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(183207);
    k.jZw().a(paramk.jZx());
    AppMethodBeat.o(183207);
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(183203);
    k.jZw().b(paramk.jZx());
    AppMethodBeat.o(183203);
  }
  
  public final void e(k paramk)
  {
    AppMethodBeat.i(183208);
    k.jZw().a(paramk.jZx());
    AppMethodBeat.o(183208);
  }
  
  public final boolean gL(String paramString)
  {
    AppMethodBeat.i(183209);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    paramString = (a)jZc().get(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(183209);
      return true;
    }
    if (!paramString.jZe())
    {
      AppMethodBeat.o(183209);
      return true;
    }
    AppMethodBeat.o(183209);
    return false;
  }
  
  final ConcurrentHashMap<String, a> jZc()
  {
    AppMethodBeat.i(183210);
    if (this.BvD == null) {}
    try
    {
      if (this.BvD == null) {
        this.BvD = new ConcurrentHashMap();
      }
      ConcurrentHashMap localConcurrentHashMap = this.BvD;
      AppMethodBeat.o(183210);
      return localConcurrentHashMap;
    }
    finally
    {
      AppMethodBeat.o(183210);
    }
  }
  
  public static final class a
  {
    float ahAZ;
    float ahBa;
    long ahBb;
    float ahBc;
    float ahBd;
    float ahBe;
    float ahBf;
    ConcurrentLinkedQueue<a.b> ahBg;
    long hto;
    String name;
    
    public a(String paramString)
    {
      AppMethodBeat.i(183195);
      this.ahAZ = 0.0F;
      this.ahBa = 0.0F;
      this.ahBb = 0L;
      this.hto = 0L;
      this.ahBc = 0.0F;
      this.ahBd = 0.0F;
      this.ahBe = 1.0F;
      this.ahBf = 0.0F;
      this.ahBg = new ConcurrentLinkedQueue();
      this.name = paramString;
      AppMethodBeat.o(183195);
    }
    
    public a(String paramString, float paramFloat, long paramLong)
    {
      AppMethodBeat.i(183196);
      this.ahAZ = 0.0F;
      this.ahBa = 0.0F;
      this.ahBb = 0L;
      this.hto = 0L;
      this.ahBc = 0.0F;
      this.ahBd = 0.0F;
      this.ahBe = 1.0F;
      this.ahBf = 0.0F;
      this.ahBg = new ConcurrentLinkedQueue();
      this.name = paramString;
      this.ahBa = paramFloat;
      this.ahBb = paramLong;
      AppMethodBeat.o(183196);
    }
    
    final boolean jZe()
    {
      return (this.ahBb >= 5000L) || (this.ahBa >= 0.5F);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183197);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.name).append(" ");
      ((StringBuilder)localObject).append(this.ahBa).append(" ");
      ((StringBuilder)localObject).append(jZe()).append(" ");
      ((StringBuilder)localObject).append(this.ahBg.size());
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(183197);
      return localObject;
    }
  }
  
  public static final class b
  {
    long MMg;
    String ahBh;
    public String name;
    float rate;
    long time;
    long timestamp;
    
    public b(String paramString1, long paramLong1, long paramLong2, String paramString2)
    {
      AppMethodBeat.i(183198);
      this.name = paramString1;
      this.MMg = paramLong1;
      this.time = paramLong2;
      this.ahBh = paramString2;
      if (paramLong2 <= 1L) {}
      for (;;)
      {
        this.rate = f;
        this.timestamp = System.currentTimeMillis();
        AppMethodBeat.o(183198);
        return;
        f = 1.0F * (float)paramLong1 / (float)paramLong2;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(183200);
      boolean bool = this.name.equals(paramObject);
      AppMethodBeat.o(183200);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(183199);
      int i = this.name.hashCode();
      AppMethodBeat.o(183199);
      return i;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(183201);
      String str = this.name + " " + this.MMg + " " + this.time;
      AppMethodBeat.o(183201);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.threadpool.b.a
 * JD-Core Version:    0.7.0.1
 */