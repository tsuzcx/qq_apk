package com.tencent.tencentmap.mapsdk.a;

import com.qq.sim.Millis100TimeProvider;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class bi
{
  private AtomicBoolean a = new AtomicBoolean();
  private long b = Millis100TimeProvider.INSTANCE.currentTimeMillis();
  private long c = 0L;
  private long d = 0L;
  private long e = 0L;
  private long f = 0L;
  private long g = 0L;
  private boolean h = false;
  private boolean i = true;
  private long j = 0L;
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(bj parambj, bg parambg, int paramInt)
  {
    if (paramInt == 0)
    {
      this.c = 0L;
      this.d = 0L;
      this.a.set(true);
      this.h = false;
      this.g += 1L;
      if (this.b + parambj.c().taf_timeout_interval() < Millis100TimeProvider.INSTANCE.currentTimeMillis())
      {
        this.e = 0L;
        this.f = 0L;
        this.g = 0L;
        this.b = Millis100TimeProvider.INSTANCE.currentTimeMillis();
      }
      if (!this.i) {
        break label378;
      }
      l1 = this.e;
      l2 = this.f;
      l3 = this.g;
      if ((this.e >= parambj.c().taf_min_timeout_invoke()) && (cb.a(this.e, l1 + l2 + l3, 2) > parambj.c().taf_timeout_radio())) {
        this.i = false;
      }
      if ((this.i) && (this.c >= parambj.c().taf_frequence_fail_invoke()) && (this.d + 5000L > Millis100TimeProvider.INSTANCE.currentTimeMillis())) {
        this.i = false;
      }
      if ((this.i) && (this.h)) {
        this.i = false;
      }
    }
    label378:
    while (paramInt != 0)
    {
      long l1;
      long l2;
      long l3;
      return;
      if (paramInt == 2)
      {
        if (!this.a.get()) {
          this.c += 1L;
        }
        for (;;)
        {
          this.h = false;
          this.e += 1L;
          break;
          this.a.set(false);
          this.c = 1L;
          this.d = Millis100TimeProvider.INSTANCE.currentTimeMillis();
        }
      }
      if (paramInt == 1)
      {
        if (!this.a.get()) {
          this.c += 1L;
        }
        for (;;)
        {
          this.h = false;
          this.f += 1L;
          break;
          this.a.set(false);
          this.c = 1L;
          this.d = Millis100TimeProvider.INSTANCE.currentTimeMillis();
        }
      }
      if (paramInt != 3) {
        break;
      }
      this.h = true;
      break;
    }
    this.i = true;
  }
  
  public boolean a()
  {
    return this.i;
  }
  
  public long b()
  {
    return this.j;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("lastCallSucc:").append(this.a.get()).append("|");
    localStringBuilder.append("timeout_startTime:").append(new Date(this.b)).append("|");
    localStringBuilder.append("frequenceFailInvoke:").append(this.c).append("|");
    localStringBuilder.append("timeoutCount:").append(this.e).append("|");
    localStringBuilder.append("failedCount:").append(this.f).append("|");
    localStringBuilder.append("succCount:").append(this.g).append("|");
    localStringBuilder.append("netConnectTimeout:").append(this.h).append("|");
    localStringBuilder.append("active:").append(this.i).append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bi
 * JD-Core Version:    0.7.0.1
 */