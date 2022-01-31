package com.tencent.tencentmap.mapsdk.a;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class fs
{
  private static int c = 20;
  protected AtomicInteger a = new AtomicInteger(0);
  private long b;
  private Handler d;
  private fz e;
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
  private fz.a p = new fv(this);
  private final Runnable q = new fx(this);
  private final Runnable r = new fy(this);
  
  public fs()
  {
    ga.a(em.a());
    this.d = ey.a.a("ReportAction", 10);
    this.e = new ft();
    a(true);
    b(true, false);
    this.k = a();
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.d.postDelayed(new fw(this), 5000L);
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
          new fs.d(this, paramBoolean1, paramBoolean2).a(true);
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
      fg.a().a(this.q, ey.a.a("report_real_timer_interval", 1, 60, 5) * 1000);
      return;
      if (paramBoolean1)
      {
        fg.a().a(this.r, 10000L);
        return;
      }
    } while (this.o);
    fg.a().a(this.r, ey.a.a("report_timer_interval", 30000, 600000, 300000));
  }
  
  private void d()
  {
    this.b = SystemClock.elapsedRealtime();
    int i1 = hn.b("report_missing_event", 0, false);
    int i2 = hn.b("report_using_traffic", 0, false);
    int i3 = ey.a.a("report_using_traffic_limit", 1, 10240, 32);
    if ((i1 == 0) && (i2 < i3 << 10)) {
      return;
    }
    long l1 = hn.b("report_traffic_last_time", 0L, false);
    if (l1 == 0L)
    {
      hn.a("report_traffic_last_time", System.currentTimeMillis(), false);
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
      er.a("HLReportEvent", em.c(), 0, "", localHashMap, null, false);
    }
    for (;;)
    {
      hn.a("report_using_traffic", 0, false);
      return;
      str = String.valueOf(l1);
      break;
      label165:
      localHashMap.put("B111", String.valueOf(i1));
      er.a("HLReportEvent", em.c(), -500, "", localHashMap, null, false);
      hn.a("report_missing_event", 0, false);
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
    extends fs.a
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
      fs.b(fs.this).decrementAndGet();
      if (TextUtils.isEmpty(this.a)) {}
      label130:
      do
      {
        int i;
        do
        {
          return;
          i = ey.a.a("report_new_record_num", 1, 50, 10);
          if (this.b) {
            break label130;
          }
          if (gc.a(fs.this.b()).b(this.a) == -1L) {
            break;
          }
          if (fs.c(fs.this))
          {
            fs.a(fs.this, false);
            fs.a(fs.this, false, false);
          }
        } while (fs.d(fs.this).incrementAndGet() < i);
        fs.b(fs.this, this.b, this.c);
        return;
        fs.e(fs.this);
        return;
        fs.f(fs.this).add(this.a);
        if (!this.c) {
          break;
        }
        if (fs.f(fs.this).size() >= i)
        {
          fs.g(fs.this).set(1);
          fs.b(fs.this, this.b, this.c);
          return;
        }
      } while (fs.g(fs.this).get() != 0);
      fs.g(fs.this).set(1);
      fs.a(fs.this, false, true);
      return;
      fs.b(fs.this, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fs
 * JD-Core Version:    0.7.0.1
 */