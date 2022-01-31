package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class bg
{
  private static int c = 20;
  protected AtomicInteger a = new AtomicInteger(0);
  private long b;
  private Handler d;
  private bn e;
  private AtomicInteger f = new AtomicInteger(0);
  private List<String> g = new ArrayList();
  private volatile boolean h = false;
  private volatile boolean i = false;
  private AtomicInteger j = new AtomicInteger(0);
  private int k;
  private int l = 0;
  private long m = 0L;
  private AtomicInteger n = new AtomicInteger(0);
  private volatile boolean o = false;
  private bn.a p = new bj(this);
  private final Runnable q = new bl(this);
  private final Runnable r = new bm(this);
  
  public bg()
  {
    bo.a(ac.a());
    this.d = an.a.a("ReportAction", 10);
    this.e = new bh();
    a(true);
    b(true, false);
    this.k = a();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.postDelayed(new bk(this), 5000L);
    }
    while ((this.b == 0L) || (SystemClock.elapsedRealtime() - this.b <= 1800000L)) {
      return;
    }
    d();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    for (;;)
    {
      try
      {
        a(false);
        if ((paramBoolean1) && (paramBoolean2))
        {
          b(false, true);
          if (this.h) {
            if (paramBoolean1) {
              this.i = true;
            }
          }
        }
        else
        {
          b(false, false);
          continue;
        }
        if (paramBoolean1) {
          break label66;
        }
      }
      finally {}
      this.f.set(0);
      label66:
      if ((this.m == 0L) || (SystemClock.elapsedRealtime() - this.m >= this.l * 60 * 1000))
      {
        this.h = true;
        try
        {
          new bg.d(this, paramBoolean1, paramBoolean2).a(true);
        }
        catch (Throwable localThrowable)
        {
          this.h = false;
        }
      }
    }
  }
  
  private void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {
      if (this.n.get() > 3) {
        this.n.set(0);
      }
    }
    do
    {
      return;
      av.a().a(this.q, an.a.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        av.a().a(this.r, 10000L);
        return;
      }
    } while (this.o);
    av.a().a(this.r, an.a.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  private void d()
  {
    this.b = SystemClock.elapsedRealtime();
    int i1 = da.b("report_missing_event", 0, false);
    int i2 = da.b("report_using_traffic", 0, false);
    int i3 = an.a.a("report_using_traffic_limit", 1, 10240, 32);
    if ((i1 == 0) && (i2 < i3 << 10)) {
      return;
    }
    long l1 = da.b("report_traffic_last_time", 0L, false);
    if (l1 == 0L)
    {
      da.a("report_traffic_last_time", System.currentTimeMillis(), false);
      return;
    }
    l1 = System.currentTimeMillis() - l1;
    HashMap localHashMap = new HashMap();
    localHashMap.put("B110", String.valueOf(i2));
    String str;
    if (l1 < 0L)
    {
      str = "0";
      localHashMap.put("B112", str);
      if (i1 != 0) {
        break label165;
      }
      ag.a("HLReportEvent", ac.c(), 0, "", localHashMap, null, false);
    }
    for (;;)
    {
      da.a("report_using_traffic", 0, false);
      return;
      str = String.valueOf(l1);
      break;
      label165:
      localHashMap.put("B111", String.valueOf(i1));
      ag.a("HLReportEvent", ac.c(), -500, "", localHashMap, null, false);
      da.a("report_missing_event", 0, false);
    }
  }
  
  public abstract int a();
  
  public final void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (this.j.getAndIncrement() > this.k)
      {
        this.j.decrementAndGet();
        return;
      }
      new b(paramString, paramBoolean1, paramBoolean2).a(false);
      return;
    }
    catch (Throwable paramString) {}
  }
  
  public abstract String b();
  
  final class b
    extends bg.a
  {
    private String a;
    private boolean b;
    private boolean c;
    
    public b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      super((byte)0);
      this.a = paramString;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    public final void run()
    {
      AppMethodBeat.i(147287);
      bg.b(bg.this).decrementAndGet();
      if (TextUtils.isEmpty(this.a))
      {
        AppMethodBeat.o(147287);
        return;
      }
      int i = an.a.a("report_new_record_num", 1, 50, 10);
      if (!this.b)
      {
        if (bq.a(bg.this.b()).b(this.a) != -1L)
        {
          if (bg.c(bg.this))
          {
            bg.a(bg.this, false);
            bg.a(bg.this, false, false);
          }
          if (bg.d(bg.this).incrementAndGet() >= i) {
            bg.b(bg.this, this.b, this.c);
          }
          AppMethodBeat.o(147287);
          return;
        }
        bg.e(bg.this);
        AppMethodBeat.o(147287);
        return;
      }
      bg.f(bg.this).add(this.a);
      if (this.c)
      {
        if (bg.f(bg.this).size() >= i)
        {
          bg.g(bg.this).set(1);
          bg.b(bg.this, this.b, this.c);
          AppMethodBeat.o(147287);
          return;
        }
        if (bg.g(bg.this).get() == 0)
        {
          bg.g(bg.this).set(1);
          bg.a(bg.this, false, true);
          AppMethodBeat.o(147287);
        }
      }
      else
      {
        bg.b(bg.this, this.b, this.c);
      }
      AppMethodBeat.o(147287);
    }
  }
  
  final class c
    extends bg.a
  {
    private bg.d a;
    
    public c(bg.d paramd)
    {
      super((byte)0);
      this.a = paramd;
    }
    
    public final void run()
    {
      int i = 0;
      AppMethodBeat.i(147288);
      bg.b(bg.this, false);
      bg.a(bg.this, SystemClock.elapsedRealtime());
      int j;
      if (this.a.d)
      {
        if (bg.j(bg.this) > 0) {
          bg.b(bg.this, 10);
        }
        bg.this.a.addAndGet(bg.d.a(this.a));
        if (!this.a.b)
        {
          j = this.a.e.size();
          ArrayList localArrayList = new ArrayList();
          i = 0;
          while (i < j)
          {
            localArrayList.add(Long.valueOf(((bq.a)this.a.e.get(i)).a));
            i += 1;
          }
          bq.a(bg.this.b()).a(localArrayList);
          if (bg.k(bg.this))
          {
            bg.c(bg.this, false);
            bg.b(bg.this, true, this.a.c);
            AppMethodBeat.o(147288);
            return;
          }
        }
        if (!this.a.a)
        {
          SystemClock.sleep(200L);
          bg.b(bg.this, this.a.b, this.a.c);
          AppMethodBeat.o(147288);
          return;
        }
        bg.a(bg.this, true);
        AppMethodBeat.o(147288);
        return;
      }
      if (an.h())
      {
        if (bg.j(bg.this) <= 0) {
          break label388;
        }
        j = an.a.a("report_interval_forbid_limit", 30, 1440, 60);
        if (bg.j(bg.this) < j) {
          bg.c(bg.this, 2);
        }
      }
      while ((this.a.c) && (this.a.b))
      {
        j = this.a.e.size();
        while (i < j)
        {
          bq.a(bg.this.b()).b(((bq.a)this.a.e.get(i)).b);
          i += 1;
        }
        label388:
        bg.d(bg.this, 5);
      }
      AppMethodBeat.o(147288);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bg
 * JD-Core Version:    0.7.0.1
 */