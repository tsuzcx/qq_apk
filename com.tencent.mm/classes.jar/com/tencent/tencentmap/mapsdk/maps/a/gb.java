package com.tencent.tencentmap.mapsdk.maps.a;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class gb<T>
  implements Comparable<gb<T>>
{
  private final gj.a a;
  private final int b;
  private final String c;
  private final int d;
  private final gd.a e;
  private Integer f;
  private gc g;
  private boolean h;
  private boolean i;
  private boolean j;
  private gf k;
  
  public gb(int paramInt, String paramString, gd.a parama)
  {
    if (gj.a.a) {}
    for (gj.a locala = new gj.a();; locala = null)
    {
      this.a = locala;
      this.h = false;
      this.i = false;
      this.j = false;
      this.b = paramInt;
      this.c = paramString;
      this.e = parama;
      a(new fu());
      this.d = c(paramString);
      return;
    }
  }
  
  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
        localStringBuilder.append('=');
        localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
        localStringBuilder.append('&');
      }
      paramMap = localStringBuilder.toString().getBytes(paramString);
    }
    catch (UnsupportedEncodingException paramMap)
    {
      throw new RuntimeException("Encoding not supported: ".concat(String.valueOf(paramString)), paramMap);
    }
    return paramMap;
  }
  
  private static int c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      if (paramString != null)
      {
        paramString = paramString.getHost();
        if (paramString != null) {
          return paramString.hashCode();
        }
      }
    }
    return 0;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int a(gb<T> paramgb)
  {
    gb.a locala1 = o();
    gb.a locala2 = paramgb.o();
    if (locala1 == locala2) {
      return this.f.intValue() - paramgb.f.intValue();
    }
    return locala2.ordinal() - locala1.ordinal();
  }
  
  public final gb<?> a(int paramInt)
  {
    this.f = Integer.valueOf(paramInt);
    return this;
  }
  
  public gb<?> a(gc paramgc)
  {
    this.g = paramgc;
    return this;
  }
  
  public gb<?> a(gf paramgf)
  {
    this.k = paramgf;
    return this;
  }
  
  protected abstract gd<T> a(fz paramfz);
  
  protected gi a(gi paramgi)
  {
    return paramgi;
  }
  
  protected abstract void a(T paramT);
  
  public void a(String paramString)
  {
    if (gj.a.a) {
      this.a.a(paramString, Thread.currentThread().getId());
    }
  }
  
  public int b()
  {
    return this.d;
  }
  
  public void b(gi paramgi)
  {
    if (this.e != null) {
      this.e.a(paramgi);
    }
  }
  
  void b(String paramString)
  {
    if (this.g != null) {
      this.g.b(this);
    }
    long l;
    if (gj.a.a)
    {
      l = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper()) {
        new Handler(Looper.getMainLooper()).post(new gb.1(this, paramString, l));
      }
    }
    else
    {
      return;
    }
    this.a.a(paramString, l);
    this.a.a(toString());
  }
  
  public String c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public Map<String, String> e()
  {
    return Collections.emptyMap();
  }
  
  @Deprecated
  protected Map<String, String> f()
  {
    return j();
  }
  
  @Deprecated
  protected String g()
  {
    return k();
  }
  
  @Deprecated
  public String h()
  {
    return l();
  }
  
  @Deprecated
  public byte[] i()
  {
    Map localMap = f();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, g());
    }
    return null;
  }
  
  protected Map<String, String> j()
  {
    return null;
  }
  
  protected String k()
  {
    return "UTF-8";
  }
  
  public String l()
  {
    return "application/x-www-form-urlencoded; charset=" + k();
  }
  
  public byte[] m()
  {
    Map localMap = j();
    if ((localMap != null) && (localMap.size() > 0)) {
      return a(localMap, k());
    }
    return null;
  }
  
  public final boolean n()
  {
    return this.j;
  }
  
  public gb.a o()
  {
    return gb.a.b;
  }
  
  public final int p()
  {
    return this.k.a();
  }
  
  public gf q()
  {
    return this.k;
  }
  
  public void r()
  {
    this.i = true;
  }
  
  public boolean s()
  {
    return this.i;
  }
  
  public String toString()
  {
    String str2 = "0x" + Integer.toHexString(b());
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.h) {}
    for (String str1 = "[X] ";; str1 = "[ ] ") {
      return str1 + c() + " " + str2 + " " + o() + " " + this.f;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.gb
 * JD-Core Version:    0.7.0.1
 */