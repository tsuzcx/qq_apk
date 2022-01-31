package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;

class ly$d
  implements jt
{
  private final r a;
  private String b;
  
  public ly$d(Context paramContext, String paramString)
  {
    if (paramContext != null)
    {
      this.a = r.a(paramContext.getApplicationContext());
      this.b = paramString;
      return;
    }
    this.a = null;
  }
  
  public String a()
  {
    if (this.a != null) {
      return this.a.f();
    }
    return null;
  }
  
  public String b()
  {
    if (this.a != null) {
      return this.a.g();
    }
    return null;
  }
  
  public String c()
  {
    if (this.a != null) {
      return this.a.g(this.b);
    }
    return null;
  }
  
  public String d()
  {
    if (this.a != null) {
      return this.a.h(this.b);
    }
    return null;
  }
  
  public String e()
  {
    if (this.a != null) {
      return this.a.h();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ly.d
 * JD-Core Version:    0.7.0.1
 */