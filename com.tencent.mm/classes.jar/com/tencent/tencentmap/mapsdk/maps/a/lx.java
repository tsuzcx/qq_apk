package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class lx
{
  private final int a;
  private final int b;
  private final int c;
  private DoublePoint d;
  private DoublePoint e;
  private float f;
  private kc g;
  private kd.b h;
  private volatile boolean i;
  private boolean j;
  private Bitmap k;
  
  public lx(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(149254);
    this.f = 0.0F;
    this.h = new kd.b()
    {
      public void a(float paramAnonymousFloat)
      {
        AppMethodBeat.i(149253);
        lx.a(lx.this, paramAnonymousFloat);
        AppMethodBeat.o(149253);
      }
      
      public void a(float paramAnonymousFloat1, float paramAnonymousFloat2) {}
      
      public void a(float paramAnonymousFloat1, float paramAnonymousFloat2, float paramAnonymousFloat3, float paramAnonymousFloat4) {}
      
      public void a(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public void b(float paramAnonymousFloat) {}
    };
    this.i = false;
    this.j = true;
    this.k = null;
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    AppMethodBeat.o(149254);
  }
  
  public void a()
  {
    AppMethodBeat.i(149255);
    if (this.k != null)
    {
      if (this.g != null)
      {
        this.g.b();
        this.g = null;
      }
      this.k.recycle();
      this.k = null;
    }
    AppMethodBeat.o(149255);
  }
  
  public void a(float paramFloat)
  {
    AppMethodBeat.i(149257);
    this.i = true;
    this.f = paramFloat;
    this.g = new kc(paramFloat, 1.0F);
    this.g.a(this.h);
    this.g.a(250L);
    this.g.a(null, null);
    AppMethodBeat.o(149257);
  }
  
  public void a(Bitmap paramBitmap)
  {
    AppMethodBeat.i(149258);
    if (paramBitmap == null)
    {
      AppMethodBeat.o(149258);
      return;
    }
    this.k = paramBitmap;
    a(0.0F);
    AppMethodBeat.o(149258);
  }
  
  public void a(DoublePoint paramDoublePoint)
  {
    this.d = paramDoublePoint;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public void b(DoublePoint paramDoublePoint)
  {
    this.e = paramDoublePoint;
  }
  
  public DoublePoint c()
  {
    return this.d;
  }
  
  public DoublePoint d()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof lx)) {
        return false;
      }
      paramObject = (lx)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c));
    return false;
  }
  
  public int hashCode()
  {
    return this.a * 7 + this.b * 11 + this.c * 13;
  }
  
  public String toString()
  {
    AppMethodBeat.i(149256);
    Object localObject = new StringBuilder(24);
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("-");
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149256);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.lx
 * JD-Core Version:    0.7.0.1
 */