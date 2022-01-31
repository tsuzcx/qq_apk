package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class aa
  implements ar
{
  protected y a;
  public String b;
  public String c;
  protected AtomicInteger d = new AtomicInteger(0);
  protected az e;
  private int f;
  private int g = 5000;
  private long h;
  private int i = 0;
  
  public aa(y paramy)
  {
    this.a = paramy;
    this.b = paramy.a;
    this.c = paramy.a;
    this.f = paramy.f;
    this.h = SystemClock.elapsedRealtime();
  }
  
  public be a()
  {
    for (;;)
    {
      try
      {
        this.g = an.a.a("app_http_proxy_timeout", 0, 20000, 5000);
        if (this.f <= 0) {
          this.f = an.a.a("app_req_timeout", 1000, 1000000, 15000);
        }
        if ((this.a.k > 0) && (this.a.k < this.f)) {
          this.f = this.a.k;
        }
        int j = this.f;
        be localbe = a(j);
        j = dd.a((int)(this.f - (SystemClock.elapsedRealtime() - this.h)), 0, this.f);
        String str;
        if ((localbe.a == 0) && (localbe.c >= 300) && (localbe.c < 400) && (this.a.e) && (j > 200))
        {
          str = localbe.a("location");
          if (TextUtils.isEmpty(str)) {
            localbe.a = -6;
          }
        }
        else
        {
          if (this.a.j)
          {
            localbe.a = -20;
            localbe.b = "";
          }
          if (!this.a.m) {
            break label305;
          }
          this.e.j = true;
          this.e.i = true;
          this.e.k = this.a.k;
          this.e.a(false);
          return localbe;
        }
        this.c = str;
        this.i += 1;
        if (this.i > 5)
        {
          localbe.a = -5;
          continue;
        }
        this.e.a(true);
      }
      catch (Throwable localThrowable)
      {
        return new be(-1, dd.a(localThrowable), 0);
      }
      continue;
      label305:
      this.e.k = (SystemClock.elapsedRealtime() - this.h);
    }
  }
  
  protected abstract be a(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.aa
 * JD-Core Version:    0.7.0.1
 */