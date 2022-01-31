package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class ei
  implements ee
{
  public String a;
  public byte[] b;
  public Map<String, String> c;
  public boolean d = false;
  public boolean e = true;
  public int f = -1;
  public String g = "";
  public ec h;
  public fc i;
  public volatile boolean j = false;
  public int k = 0;
  public boolean l = true;
  public volatile boolean m = false;
  public long n;
  public String o;
  private Object p;
  private int q = 0;
  private fp r;
  private CountDownLatch s = new CountDownLatch(1);
  
  public ei(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.g = hq.d();
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(fp paramfp)
  {
    try
    {
      this.r = paramfp;
      return;
    }
    finally
    {
      paramfp = finally;
      throw paramfp;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.s.await(this.k, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException) {}
    return true;
  }
  
  public final void b()
  {
    this.s.countDown();
  }
  
  public final void b(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.k = paramInt;
  }
  
  public final void b(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final fp c()
  {
    try
    {
      fp localfp = this.r;
      return localfp;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.a);
    localStringBuilder.append(",body:" + hq.b(this.b));
    localStringBuilder.append(",isGet:" + this.d);
    localStringBuilder.append(",timeout:" + this.f);
    localStringBuilder.append(",tag:" + this.p);
    localStringBuilder.append(",httpCallback:" + this.h);
    localStringBuilder.append(",testMode:" + this.q);
    localStringBuilder.append(",httpCallback:" + this.h);
    localStringBuilder.append(",testMode:" + this.q);
    localStringBuilder.append(",followRedirects:" + this.e);
    localStringBuilder.append(",isAbort:" + this.j);
    localStringBuilder.append(",headers:" + this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ei
 * JD-Core Version:    0.7.0.1
 */