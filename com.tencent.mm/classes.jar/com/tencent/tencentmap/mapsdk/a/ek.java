package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ek
  implements fc
{
  protected ei a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected fk e;
  private int f;
  private int g = 5000;
  private long h;
  private int i = 0;
  
  public ek(ei paramei)
  {
    this.a = paramei;
    this.b = paramei.a;
    this.c = paramei.a;
    this.f = paramei.f;
    this.h = SystemClock.elapsedRealtime();
  }
  
  public fp a()
  {
    for (;;)
    {
      try
      {
        this.g = ey.a.a("app_http_proxy_timeout", 0, 20000, 5000);
        if (this.f <= 0) {
          this.f = ey.a.a("app_req_timeout", 1000, 1000000, 15000);
        }
        if ((this.a.k > 0) && (this.a.k < this.f)) {
          this.f = this.a.k;
        }
        int j = this.f;
        fp localfp = a(j);
        j = hq.a((int)(this.f - (SystemClock.elapsedRealtime() - this.h)), 0, this.f);
        String str;
        if ((localfp.a == 0) && (localfp.c >= 300) && (localfp.c < 400) && (this.a.e) && (j > 200))
        {
          str = localfp.a("location");
          if (TextUtils.isEmpty(str)) {
            localfp.a = -6;
          }
        }
        else
        {
          if (this.a.j)
          {
            localfp.a = -20;
            localfp.b = "";
          }
          if (!this.a.m) {
            break label305;
          }
          this.e.j = true;
          this.e.i = true;
          this.e.k = this.a.k;
          this.e.a(false);
          return localfp;
        }
        this.c = str;
        this.i += 1;
        if (this.i > 5)
        {
          localfp.a = -5;
          continue;
        }
        this.e.a(true);
      }
      catch (Throwable localThrowable)
      {
        return new fp(-1, hq.a(localThrowable), 0);
      }
      continue;
      label305:
      this.e.k = (SystemClock.elapsedRealtime() - this.h);
    }
  }
  
  protected abstract fp a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ek
 * JD-Core Version:    0.7.0.1
 */