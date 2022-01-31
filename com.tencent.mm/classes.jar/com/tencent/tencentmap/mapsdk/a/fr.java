package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

public final class fr
  extends fk
{
  private String A = "";
  private int B;
  private long C = 0L;
  private String D;
  private a E = new a((byte)0);
  private boolean F = false;
  private fo G;
  long p;
  boolean q = false;
  int r = 0;
  boolean s = false;
  private HttpURLConnection t;
  private DataOutputStream u;
  private DataInputStream v;
  private fp w;
  private String x;
  private boolean y;
  private boolean z;
  
  public fr(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    this.x = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (ey.g() == 2)
    {
      i = ey.a.a("direct_access_time_out", 1000, 60000, 15000);
      if (paramInt >= i) {
        break label145;
      }
    }
    for (;;)
    {
      this.f = hq.a(paramInt, 200, 60000, 10000);
      this.g = paramString3;
      return;
      i = ey.a.a("direct_access_time_out", 1000, 60000, 10000);
      break;
      label145:
      paramInt = i;
    }
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    for (;;)
    {
      try
      {
        localBufferedInputStream = new BufferedInputStream(this.t.getInputStream());
        localByteArrayOutputStream = new ByteArrayOutputStream();
        arrayOfByte = new byte[4096];
        i = 0;
        j = i;
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        try
        {
          BufferedInputStream localBufferedInputStream;
          ByteArrayOutputStream localByteArrayOutputStream;
          byte[] arrayOfByte;
          int i;
          int k;
          localByteArrayOutputStream.close();
          return;
        }
        catch (Exception localException2)
        {
          int j;
          return;
        }
        localOutOfMemoryError1 = localOutOfMemoryError1;
        j = 0;
        this.w.a = -306;
        this.w.b = ("no-content-length:" + j);
        return;
      }
      catch (Exception localException1)
      {
        this.w.a = -287;
        this.w.b = "read without content-length error";
        return;
      }
      try
      {
        k = localBufferedInputStream.read(arrayOfByte);
        if (k == -1) {
          break label218;
        }
        j = i;
        localByteArrayOutputStream.write(arrayOfByte, 0, k);
        k = i + k;
        i = k;
        if (k > paramInt)
        {
          j = k;
          this.w.a = -303;
          j = k;
          this.w.b = "no-content-length";
          paramInt = m;
          i = k;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError2)
      {
        continue;
        paramInt = 1;
      }
    }
    if (paramInt != 0)
    {
      j = i;
      this.w.d = localByteArrayOutputStream.toByteArray();
      j = i;
      this.E.f = SystemClock.elapsedRealtime();
    }
    j = i;
  }
  
  private void b()
  {
    int j = 0;
    int i = j;
    if (this.d != null)
    {
      i = j;
      if (this.d.size() > 0)
      {
        Iterator localIterator = this.d.keySet().iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          String str2 = (String)this.d.get(str1);
          this.t.addRequestProperty(str1, str2);
          if (!str1.toLowerCase().contains("host")) {
            break label207;
          }
          i = 1;
        }
      }
    }
    label207:
    for (;;)
    {
      break;
      if (i == 0) {
        this.t.setRequestProperty("Host", this.x);
      }
      this.t.setRequestProperty("Halley", this.g + "-" + this.r + "-" + System.currentTimeMillis());
      if (this.q)
      {
        this.t.setRequestProperty("X-Online-Host", this.x);
        this.t.setRequestProperty("x-tx-host", this.x);
      }
      return;
    }
  }
  
  private boolean c()
  {
    if (this.n)
    {
      this.w.a = -20;
      this.p = (SystemClock.elapsedRealtime() - this.p);
      this.E.a();
      return true;
    }
    return false;
  }
  
  private void d()
  {
    try
    {
      if (this.t != null) {
        this.t.disconnect();
      }
      if (this.u != null) {
        this.u.close();
      }
      if (this.v != null) {
        this.v.close();
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public final fp a()
  {
    int i1 = 1;
    int i = 1;
    int m = 1;
    int j = 1;
    int k = 1;
    int n = 1;
    this.m = System.currentTimeMillis();
    this.p = SystemClock.elapsedRealtime();
    this.E.a = this.p;
    this.w = new fp(0, "", 0);
    label1563:
    label1606:
    label1611:
    label1869:
    for (;;)
    {
      try
      {
        if (c())
        {
          localObject3 = this.w;
          d();
          this.p = (SystemClock.elapsedRealtime() - this.p);
          this.E.a();
          localObject1 = localObject3;
          if (this.w.a != 0)
          {
            localObject1 = localObject3;
            if (ey.h())
            {
              localObject1 = localObject3;
              if (this.w.a != -20)
              {
                if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                  continue;
                }
                i = n;
                localObject1 = localObject3;
                if (i != 0)
                {
                  this.D = hq.c(this.x);
                  localObject1 = localObject3;
                }
              }
            }
          }
          return localObject1;
          i = 0;
          continue;
        }
        Object localObject1 = new URL(this.b);
        this.y = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.z = hq.d(((URL)localObject1).getHost());
        if (this.y)
        {
          if ((this.q) && (ey.k() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(ey.k());
            localObject3 = localObject1;
            if (this.z)
            {
              this.G = new fo(this.x);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.G);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new fn(this.x));
              localObject3 = localObject1;
            }
            this.t = ((HttpURLConnection)localObject3);
            localObject3 = this.t;
            if (!this.c) {
              break label1874;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.t.setConnectTimeout(this.f);
            this.t.setReadTimeout(this.f);
            this.t.setUseCaches(false);
            this.t.setDoInput(true);
            this.t.setInstanceFollowRedirects(false);
            b();
            if ((!this.c) && (!hq.a(this.e)))
            {
              this.t.setDoOutput(true);
              this.C = this.e.length;
            }
            this.E.b = SystemClock.elapsedRealtime();
            this.t.connect();
            this.E.c = SystemClock.elapsedRealtime();
            if (c())
            {
              localObject3 = this.w;
              d();
              this.p = (SystemClock.elapsedRealtime() - this.p);
              this.E.a();
              localObject1 = localObject3;
              if (this.w.a == 0) {
                continue;
              }
              localObject1 = localObject3;
              if (!ey.h()) {
                continue;
              }
              localObject1 = localObject3;
              if (this.w.a == -20) {
                continue;
              }
              if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                break label1882;
              }
              i = i1;
              localObject1 = localObject3;
              if (i == 0) {
                continue;
              }
              this.D = hq.c(this.x);
              return localObject3;
            }
          }
          else
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection();
            continue;
          }
        }
        else
        {
          if ((this.q) && (ey.k() != null))
          {
            localObject3 = (HttpURLConnection)((URL)localObject1).openConnection(ey.k());
            continue;
          }
          localObject3 = (HttpURLConnection)((URL)localObject1).openConnection();
          continue;
        }
        if ((!this.c) && (!hq.a(this.e)))
        {
          this.u = new DataOutputStream(this.t.getOutputStream());
          this.u.write(this.e);
          this.u.flush();
        }
        this.E.d = SystemClock.elapsedRealtime();
        n = this.t.getResponseCode();
        this.E.e = SystemClock.elapsedRealtime();
        this.w.c = n;
        this.A = this.t.getContentType();
        localObject1 = new HashMap();
        Object localObject3 = this.t.getHeaderFields().entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject3).next();
          if (localEntry.getKey() == null) {
            continue;
          }
          ((Map)localObject1).put(localEntry.getKey(), ((List)localEntry.getValue()).get(0));
          continue;
        }
        try
        {
          byte[] arrayOfByte = new byte[this.B];
          this.v = new DataInputStream(this.t.getInputStream());
          this.v.readFully(arrayOfByte);
          this.w.d = arrayOfByte;
          this.E.f = SystemClock.elapsedRealtime();
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          this.w.a = -306;
          this.w.b = this.B;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        this.w.a = -300;
        d();
        this.p = (SystemClock.elapsedRealtime() - this.p);
        this.E.a();
        if ((this.w.a != 0) && (ey.h()) && (this.w.a != -20))
        {
          if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1611;
          }
          if (i != 0) {
            this.D = hq.c(this.x);
          }
        }
        return this.w;
        this.w.a(localMalformedURLException);
        if ((this.w.c < 200) || (this.w.c >= 300)) {
          break label1563;
        }
        this.B = this.t.getContentLength();
        n = ey.a.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.B < 0)
        {
          a(n);
          d();
          this.p = (SystemClock.elapsedRealtime() - this.p);
          this.E.a();
          if ((this.w.a == 0) || (!ey.h()) || (this.w.a == -20)) {
            continue;
          }
          if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1606;
          }
          i = m;
          if (i == 0) {
            continue;
          }
          this.D = hq.c(this.x);
          continue;
        }
        if (this.B == 0)
        {
          this.w.d = new byte[0];
          this.E.f = SystemClock.elapsedRealtime();
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        this.w.a = -287;
        this.w.b = (localThrowable.getClass().getSimpleName() + "(" + localThrowable.getLocalizedMessage() + ")");
        if (((this.G != null) && (this.G.a)) || ((this.y) && (this.w.b.toLowerCase().contains("cannot verify hostname")))) {
          break label1887;
        }
        if ((!this.y) || (!this.w.b.toLowerCase().contains("not verified"))) {
          break label1616;
        }
        break label1887;
        if (ey.h()) {
          break label1621;
        }
        this.w.a = -4;
        d();
        this.p = (SystemClock.elapsedRealtime() - this.p);
        this.E.a();
        if ((this.w.a == 0) || (!ey.h()) || (this.w.a == -20)) {
          continue;
        }
        if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
          break label1864;
        }
        i = j;
        if (i == 0) {
          continue;
        }
        this.D = hq.c(this.x);
        continue;
        if (this.B > n)
        {
          this.w.a = -303;
          this.w.b = this.B;
          continue;
        }
      }
      finally
      {
        d();
        this.p = (SystemClock.elapsedRealtime() - this.p);
        this.E.a();
        if ((this.w.a != 0) && (ey.h()) && (this.w.a != -20))
        {
          if (ey.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1869;
          }
          i = k;
          if (i != 0) {
            this.D = hq.c(this.x);
          }
        }
      }
      continue;
      label1616:
      label1874:
      if ((this.w.c >= 300) && (this.w.c < 400))
      {
        this.h = this.w.a("location");
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        i = 0;
        continue;
        label1621:
        if (this.n)
        {
          this.w.a = -20;
        }
        else if (i != 0)
        {
          this.w.a = -289;
        }
        else
        {
          this.i = true;
          if ((localOutOfMemoryError.getMessage() != null) && (localOutOfMemoryError.getMessage().toLowerCase().contains("permission")))
          {
            this.w.a = -281;
            this.w.b = "no permission";
          }
          else if ((localOutOfMemoryError instanceof UnknownHostException))
          {
            this.w.a = -284;
          }
          else if ((localOutOfMemoryError instanceof ConnectException))
          {
            this.w.a = -42;
          }
          else
          {
            String str;
            if ((localOutOfMemoryError instanceof SocketTimeoutException))
            {
              str = localOutOfMemoryError.getLocalizedMessage();
              if ((str != null) && ((str.toLowerCase().contains("connect")) || (str.toLowerCase().contains("connection")))) {
                this.w.a = -10;
              } else {
                this.w.a = -13;
              }
            }
            else if ((str instanceof SocketException))
            {
              this.w.a = -41;
            }
            else if ((str instanceof IOException))
            {
              this.w.a = -286;
              continue;
              i = 0;
              continue;
              i = 0;
              continue;
              str = "POST";
              continue;
              label1882:
              i = 0;
              continue;
              label1887:
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.putAll(paramMap1);
    localHashMap.put("B59", this.p);
    if (this.y) {
      localHashMap.put("B85", "1");
    }
    int i;
    if (this.c)
    {
      localHashMap.put("B95", "1");
      if (!this.z) {
        localHashMap.put("B23", "1");
      }
      paramMap1 = new HashMap();
      paramMap1.putAll(paramMap2);
      if (this.m != 0L) {
        paramMap1.put("B84", this.m);
      }
      paramMap1.put("B87", this.A);
      paramMap1.put("B88", this.B);
      paramMap1.put("B90", this.E.g);
      paramMap1.put("B91", this.E.h);
      paramMap1.put("B92", this.E.i);
      paramMap1.put("B93", this.E.j);
      paramMap1.put("B94", this.E.k);
      if (!TextUtils.isEmpty(this.h)) {
        paramMap1.put("B47", this.h);
      }
      if (!TextUtils.isEmpty(this.D)) {
        paramMap1.put("B41", this.D);
      }
      if (this.w.a == 0) {
        break label485;
      }
      i = this.w.a;
    }
    for (;;)
    {
      if ((this.s) && (i != -4)) {
        break label514;
      }
      ho.b("HLHttpDirect", em.c(), i, this.w.b, localHashMap, paramMap1, this.i);
      return;
      localHashMap.put("B96", this.C);
      break;
      label485:
      if (this.w.c == 200) {
        i = 0;
      } else {
        i = this.w.c;
      }
    }
    label514:
    ho.a("HLHttpDirect", em.c(), i, this.w.b, localHashMap, paramMap1, this.i);
  }
  
  public final void a(boolean paramBoolean) {}
  
  static final class a
  {
    long a;
    long b;
    long c;
    long d;
    long e;
    long f;
    long g = -1L;
    long h = -1L;
    long i = -1L;
    long j = -1L;
    long k = -1L;
    
    public final void a()
    {
      long l2 = -1L;
      this.g = (this.b - this.a);
      this.h = (this.c - this.b);
      this.i = (this.d - this.c);
      this.j = (this.e - this.d);
      this.k = (this.f - this.e);
      long l1 = this.g;
      if (l1 >= 0L)
      {
        this.g = l1;
        l1 = this.h;
        if (l1 < 0L) {
          break label164;
        }
        label96:
        this.h = l1;
        l1 = this.i;
        if (l1 < 0L) {
          break label171;
        }
        label112:
        this.i = l1;
        l1 = this.j;
        if (l1 < 0L) {
          break label178;
        }
      }
      for (;;)
      {
        this.j = l1;
        long l3 = this.k;
        l1 = l2;
        if (l3 >= 0L) {
          l1 = l3;
        }
        this.k = l1;
        return;
        l1 = -1L;
        break;
        label164:
        l1 = -1L;
        break label96;
        label171:
        l1 = -1L;
        break label112;
        label178:
        l1 = -1L;
      }
    }
    
    public final String toString()
    {
      return "Stat{startToTryConnect=" + this.g + ", connectCost=" + this.h + ", connectToPost=" + this.i + ", postToRsp=" + this.j + ", rspToRead=" + this.k + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.fr
 * JD-Core Version:    0.7.0.1
 */