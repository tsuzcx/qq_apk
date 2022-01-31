package com.tencent.tencentmap.mapsdk.a;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class fm
  extends fk
{
  private static boolean q = false;
  private String A;
  private en B;
  private String C;
  private String D;
  public boolean p = true;
  private boolean r = false;
  private boolean s = false;
  private int t;
  private int u = -1;
  private fr v;
  private fp w;
  private fl x;
  private fj y = fj.a();
  private boolean z;
  
  public fm(String paramString1, boolean paramBoolean1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt1, String paramString2, boolean paramBoolean2, int paramInt2, boolean paramBoolean3, ex paramex, String paramString3)
  {
    this.b = paramString1;
    this.c = paramBoolean1;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    this.f = paramInt1;
    this.g = paramString2;
    this.r = false;
    this.t = 0;
    this.z = paramBoolean3;
    this.C = paramString3;
  }
  
  public static fm a(String paramString1, boolean paramBoolean1, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString2, boolean paramBoolean2, ex paramex)
  {
    return new fm(paramString1, false, paramMap, paramArrayOfByte, paramInt, paramString2, false, 0, false, paramex, "");
  }
  
  public final fp a()
  {
    if (!q) {
      q = true;
    }
    try
    {
      if ((Build.VERSION.SDK != null) && (Build.VERSION.SDK_INT < 8)) {
        System.setProperty("http.keepAlive", "false");
      }
      label32:
      this.w = new fp(0, "", 0);
      for (;;)
      {
        int i;
        long l2;
        try
        {
          Object localObject = new URL(this.b);
          String str = ((URL)localObject).getHost();
          this.x = new fl((URL)localObject, this.b);
          boolean bool = ((URL)localObject).getProtocol().toLowerCase().startsWith("https");
          localObject = this.x.a(this.y, this.z, bool);
          int n = ((List)localObject).size();
          long l1 = SystemClock.elapsedRealtime();
          i = this.f;
          int j = 0;
          if (j >= n) {
            break;
          }
          this.o.incrementAndGet();
          this.B = ((en)((List)localObject).get(j));
          if (this.B.b() < 3) {
            this.s = true;
          }
          this.D = this.x.a(this.B);
          this.v = new fr(str, this.D, this.c, this.d, this.e, i, this.g);
          if ((j != 0) || (this.r)) {
            this.v.s = true;
          }
          if ((ey.i()) && (j != 0)) {
            this.v.q = true;
          }
          this.v.r = this.o.get();
          this.w = this.v.a();
          if (((this.v.i) || (this.w.c >= 500)) && (ey.h()) && (this.s)) {
            fj.a(str, this.B, this.w.a);
          }
          int m = (int)(this.f - (SystemClock.elapsedRealtime() - l1));
          if (((this.w.a == 0) && (this.w.c >= 200) && (this.w.c < 400)) || (this.w.a == -20) || (this.w.a == -300) || (this.w.a == -306) || (j == n - 1) || (m <= 200))
          {
            i = 1;
            k = i;
            if (i == 0)
            {
              k = i;
              if (this.w.a == -4)
              {
                k = ey.a.a("direct_nonet_retry_gap", 0, 10000, 3000);
                l2 = this.v.p;
                if (l2 < k) {
                  break label547;
                }
                k = 1;
              }
            }
            if (k != 0) {
              break;
            }
            a(true);
            j += 1;
            i = m;
            continue;
          }
          i = 0;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          this.w.a = -300;
          return this.w;
        }
        continue;
        label547:
        SystemClock.sleep(hq.a((int)(k - l2), 200, k, 200));
        int k = i;
      }
      return this.w;
    }
    catch (Exception localException)
    {
      break label32;
    }
  }
  
  public final void a(int paramInt)
  {
    this.u = paramInt;
  }
  
  public final void a(String paramString)
  {
    this.A = paramString;
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 1;
    HashMap localHashMap1;
    HashMap localHashMap2;
    StringBuilder localStringBuilder;
    if (this.v != null)
    {
      if (this.i) {
        this.v.i = true;
      }
      localHashMap1 = new HashMap();
      if (paramBoolean) {
        break label577;
      }
      localHashMap1.put("B22", this.k);
      if (!hq.a(this.A)) {
        localHashMap1.put("B15", this.A);
      }
      if (!hq.a(this.C)) {
        localHashMap1.put("B54", this.C);
      }
      localHashMap2 = new HashMap();
      localHashMap2.put("B82", this.g);
      if (this.r)
      {
        localHashMap1.put("B52", "1");
        localHashMap1.put("B58", this.t);
      }
      if (this.l != 0L) {
        localHashMap2.put("B83", this.l);
      }
      localHashMap2.put("B44", this.a);
      if ((!TextUtils.isEmpty(this.a)) && (!this.a.equals(this.D))) {
        localHashMap2.put("B49", this.D);
      }
      if (this.B != null)
      {
        if (!this.B.e()) {
          localHashMap2.put("B10", this.B.d());
        }
        if (this.B.a != -1) {
          localHashMap2.put("B45", this.B.a);
        }
        localHashMap2.put("B202", this.B.b());
        localHashMap2.put("B204", this.B.b);
        localStringBuilder = new StringBuilder();
        if (!this.s) {
          break label593;
        }
      }
    }
    for (;;)
    {
      localHashMap2.put("B203", i);
      localHashMap2.put("B53", this.o.get());
      if (!TextUtils.isEmpty(this.x.a)) {
        localHashMap2.put("B26", this.x.a);
      }
      if (this.j) {
        localHashMap2.put("B97", "1");
      }
      if (this.u != -1) {
        localHashMap2.put("B211", this.u);
      }
      this.v.a(localHashMap1, localHashMap2);
      return;
      label577:
      localHashMap1.put("B46", "1");
      break;
      label593:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fm
 * JD-Core Version:    0.7.0.1
 */