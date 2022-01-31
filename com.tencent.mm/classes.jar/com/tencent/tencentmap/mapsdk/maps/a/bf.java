package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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

public final class bf
  extends az
{
  private String A;
  private int B;
  private long C;
  private String D;
  private bf.a E;
  private boolean F;
  private bd G;
  long p;
  boolean q;
  int r;
  boolean s;
  private HttpURLConnection t;
  private DataOutputStream u;
  private DataInputStream v;
  private be w;
  private String x;
  private boolean y;
  private boolean z;
  
  public bf(String paramString1, String paramString2, boolean paramBoolean, Map<String, String> paramMap, byte[] paramArrayOfByte, int paramInt, String paramString3)
  {
    AppMethodBeat.i(147280);
    this.A = "";
    this.C = 0L;
    this.E = new bf.a((byte)0);
    this.q = false;
    this.F = false;
    this.r = 0;
    this.s = false;
    this.x = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
    this.d = paramMap;
    this.e = paramArrayOfByte;
    int i;
    if (an.g() == 2)
    {
      i = an.a.a("direct_access_time_out", 1000, 60000, 15000);
      if (paramInt >= i) {
        break label155;
      }
    }
    for (;;)
    {
      this.f = dd.a(paramInt, 200, 60000, 10000);
      this.g = paramString3;
      AppMethodBeat.o(147280);
      return;
      i = an.a.a("direct_access_time_out", 1000, 60000, 10000);
      break;
      label155:
      paramInt = i;
    }
  }
  
  private void a(int paramInt)
  {
    int m = 0;
    AppMethodBeat.i(147284);
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
        BufferedInputStream localBufferedInputStream;
        ByteArrayOutputStream localByteArrayOutputStream;
        byte[] arrayOfByte;
        int i;
        int k;
        int j = 0;
        this.w.a = -306;
        this.w.b = "no-content-length:".concat(String.valueOf(j));
        AppMethodBeat.o(147284);
        return;
      }
      catch (Exception localException2)
      {
        this.w.a = -287;
        this.w.b = "read without content-length error";
        AppMethodBeat.o(147284);
        return;
      }
      try
      {
        k = localBufferedInputStream.read(arrayOfByte);
        if (k == -1) {
          break label238;
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
    try
    {
      localByteArrayOutputStream.close();
      j = i;
      AppMethodBeat.o(147284);
      return;
    }
    catch (Exception localException1)
    {
      AppMethodBeat.o(147284);
      return;
    }
  }
  
  private void b()
  {
    AppMethodBeat.i(147282);
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
            break label219;
          }
          i = 1;
        }
      }
    }
    label219:
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
      AppMethodBeat.o(147282);
      return;
    }
  }
  
  private boolean c()
  {
    AppMethodBeat.i(147283);
    if (this.n)
    {
      this.w.a = -20;
      this.p = (SystemClock.elapsedRealtime() - this.p);
      this.E.a();
      AppMethodBeat.o(147283);
      return true;
    }
    AppMethodBeat.o(147283);
    return false;
  }
  
  private void d()
  {
    AppMethodBeat.i(147285);
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
      AppMethodBeat.o(147285);
      return;
    }
    catch (Throwable localThrowable)
    {
      AppMethodBeat.o(147285);
    }
  }
  
  public final be a()
  {
    int i1 = 1;
    int i = 1;
    int m = 1;
    int j = 1;
    int k = 1;
    int n = 1;
    AppMethodBeat.i(147281);
    this.m = System.currentTimeMillis();
    this.p = SystemClock.elapsedRealtime();
    this.E.a = this.p;
    this.w = new be(0, "", 0);
    label1561:
    label1604:
    label1609:
    label1867:
    for (;;)
    {
      try
      {
        if (c())
        {
          localObject1 = this.w;
          d();
          this.p = (SystemClock.elapsedRealtime() - this.p);
          this.E.a();
          if ((this.w.a != 0) && (an.h()) && (this.w.a != -20))
          {
            if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
              continue;
            }
            i = n;
            if (i != 0) {
              this.D = dd.c(this.x);
            }
          }
          AppMethodBeat.o(147281);
          return localObject1;
          i = 0;
          continue;
        }
        Object localObject1 = new URL(this.b);
        this.y = ((URL)localObject1).getProtocol().toLowerCase().startsWith("https");
        this.z = dd.d(((URL)localObject1).getHost());
        if (this.y)
        {
          if ((this.q) && (an.k() != null))
          {
            localObject1 = (HttpsURLConnection)((URL)localObject1).openConnection(an.k());
            localObject3 = localObject1;
            if (this.z)
            {
              this.G = new bd(this.x);
              ((HttpsURLConnection)localObject1).setSSLSocketFactory(this.G);
              ((HttpsURLConnection)localObject1).setHostnameVerifier(new bc(this.x));
              localObject3 = localObject1;
            }
            this.t = ((HttpURLConnection)localObject3);
            localObject3 = this.t;
            if (!this.c) {
              break label1872;
            }
            localObject1 = "GET";
            ((HttpURLConnection)localObject3).setRequestMethod((String)localObject1);
            this.t.setConnectTimeout(this.f);
            this.t.setReadTimeout(this.f);
            this.t.setUseCaches(false);
            this.t.setDoInput(true);
            this.t.setInstanceFollowRedirects(false);
            b();
            if ((!this.c) && (!dd.a(this.e)))
            {
              this.t.setDoOutput(true);
              this.C = this.e.length;
            }
            this.E.b = SystemClock.elapsedRealtime();
            this.t.connect();
            this.E.c = SystemClock.elapsedRealtime();
            if (c())
            {
              localObject1 = this.w;
              d();
              this.p = (SystemClock.elapsedRealtime() - this.p);
              this.E.a();
              if ((this.w.a != 0) && (an.h()) && (this.w.a != -20))
              {
                if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
                  break label1880;
                }
                i = i1;
                if (i != 0) {
                  this.D = dd.c(this.x);
                }
              }
              AppMethodBeat.o(147281);
              return localObject1;
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
          if ((this.q) && (an.k() != null))
          {
            localObject3 = (HttpURLConnection)((URL)localObject1).openConnection(an.k());
            continue;
          }
          localObject3 = (HttpURLConnection)((URL)localObject1).openConnection();
          continue;
        }
        if ((!this.c) && (!dd.a(this.e)))
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
          be localbe;
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
        if ((this.w.a != 0) && (an.h()) && (this.w.a != -20))
        {
          if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1609;
          }
          if (i != 0) {
            this.D = dd.c(this.x);
          }
        }
        localbe = this.w;
        AppMethodBeat.o(147281);
        return localbe;
        this.w.a(localbe);
        if ((this.w.c < 200) || (this.w.c >= 300)) {
          break label1561;
        }
        this.B = this.t.getContentLength();
        n = an.a.a("app_receive_pack_size", 524288, 10485760, 2097152);
        if (this.B < 0)
        {
          a(n);
          d();
          this.p = (SystemClock.elapsedRealtime() - this.p);
          this.E.a();
          if ((this.w.a == 0) || (!an.h()) || (this.w.a == -20)) {
            continue;
          }
          if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1604;
          }
          i = m;
          if (i == 0) {
            continue;
          }
          this.D = dd.c(this.x);
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
          break label1885;
        }
        if ((!this.y) || (!this.w.b.toLowerCase().contains("not verified"))) {
          break label1614;
        }
        break label1885;
        if (an.h()) {
          break label1619;
        }
        this.w.a = -4;
        d();
        this.p = (SystemClock.elapsedRealtime() - this.p);
        this.E.a();
        if ((this.w.a == 0) || (!an.h()) || (this.w.a == -20)) {
          continue;
        }
        if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
          break label1862;
        }
        i = j;
        if (i == 0) {
          continue;
        }
        this.D = dd.c(this.x);
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
        if ((this.w.a != 0) && (an.h()) && (this.w.a != -20))
        {
          if (an.a.a("direct_fail_to_report_dns_ip", 0, 1, 0) != 1) {
            break label1867;
          }
          i = k;
          if (i != 0) {
            this.D = dd.c(this.x);
          }
        }
        AppMethodBeat.o(147281);
      }
      continue;
      label1614:
      label1872:
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
        label1619:
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
              label1880:
              i = 0;
              continue;
              label1885:
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap1, Map<String, String> paramMap2)
  {
    AppMethodBeat.i(147286);
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
        break label497;
      }
      i = this.w.a;
    }
    for (;;)
    {
      if ((this.s) && (i != -4)) {
        break label526;
      }
      db.b("HLHttpDirect", ac.c(), i, this.w.b, localHashMap, paramMap1, this.i);
      AppMethodBeat.o(147286);
      return;
      localHashMap.put("B96", this.C);
      break;
      label497:
      if (this.w.c == 200) {
        i = 0;
      } else {
        i = this.w.c;
      }
    }
    label526:
    db.a("HLHttpDirect", ac.c(), i, this.w.b, localHashMap, paramMap1, this.i);
    AppMethodBeat.o(147286);
  }
  
  public final void a(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.bf
 * JD-Core Version:    0.7.0.1
 */