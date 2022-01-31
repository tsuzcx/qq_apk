package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import java.io.File;

public final class tw
{
  private static int h = 0;
  private tn a;
  private final String b;
  private boolean c = true;
  private float d = (1.0F / -1.0F);
  private boolean e = true;
  private sj f;
  private String g;
  
  public tw(tn paramtn, si paramsi)
  {
    StringBuilder localStringBuilder = new StringBuilder("TileOverlay_");
    int i = h;
    h = i + 1;
    this.b = i;
    this.a = paramtn;
    this.g = (tn.a().getPackageName() + File.separator + this.b);
    this.e = paramsi.d();
    if (!this.e) {
      this.g = null;
    }
    this.f = paramsi.a();
    this.d = paramsi.b();
    this.c = paramsi.c();
  }
  
  public final float a()
  {
    return this.d;
  }
  
  public final void b()
  {
    this.a.g().a(this);
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final sj d()
  {
    return this.f;
  }
  
  public final String e()
  {
    return this.g;
  }
  
  public final boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if ((paramObject instanceof tw))
      {
        paramObject = (tw)paramObject;
        bool1 = bool2;
        if (this.b.equals(paramObject.b)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final boolean f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tw
 * JD-Core Version:    0.7.0.1
 */