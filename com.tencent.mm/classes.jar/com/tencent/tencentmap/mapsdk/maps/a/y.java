package com.tencent.tencentmap.mapsdk.maps.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class y
  implements u
{
  public String a;
  public byte[] b;
  public Map<String, String> c;
  public boolean d;
  public boolean e;
  public int f;
  public String g;
  public s h;
  public ar i;
  public volatile boolean j;
  public int k;
  public boolean l;
  public volatile boolean m;
  public long n;
  public String o;
  private Object p;
  private int q;
  private be r;
  private CountDownLatch s;
  
  public y(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(149623);
    this.d = false;
    this.e = true;
    this.f = -1;
    this.g = "";
    this.j = false;
    this.q = 0;
    this.k = 0;
    this.l = true;
    this.s = new CountDownLatch(1);
    this.m = false;
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.g = dd.d();
    AppMethodBeat.o(149623);
  }
  
  public final void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final void a(be parambe)
  {
    try
    {
      this.r = parambe;
      return;
    }
    finally
    {
      parambe = finally;
      throw parambe;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(149624);
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
    AppMethodBeat.o(149624);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(149621);
    try
    {
      boolean bool = this.s.await(this.k, TimeUnit.MILLISECONDS);
      AppMethodBeat.o(149621);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      AppMethodBeat.o(149621);
    }
    return true;
  }
  
  public final void b()
  {
    AppMethodBeat.i(149622);
    this.s.countDown();
    AppMethodBeat.o(149622);
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
  
  public final be c()
  {
    try
    {
      be localbe = this.r;
      return localbe;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(149625);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("url:" + this.a);
    ((StringBuilder)localObject).append(",body:" + dd.b(this.b));
    ((StringBuilder)localObject).append(",isGet:" + this.d);
    ((StringBuilder)localObject).append(",timeout:" + this.f);
    ((StringBuilder)localObject).append(",tag:" + this.p);
    ((StringBuilder)localObject).append(",httpCallback:" + this.h);
    ((StringBuilder)localObject).append(",testMode:" + this.q);
    ((StringBuilder)localObject).append(",httpCallback:" + this.h);
    ((StringBuilder)localObject).append(",testMode:" + this.q);
    ((StringBuilder)localObject).append(",followRedirects:" + this.e);
    ((StringBuilder)localObject).append(",isAbort:" + this.j);
    ((StringBuilder)localObject).append(",headers:" + this.c);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149625);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.y
 * JD-Core Version:    0.7.0.1
 */