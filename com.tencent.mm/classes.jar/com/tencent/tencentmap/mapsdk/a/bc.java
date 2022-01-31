package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class bc
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  private Bitmap e = null;
  private cy f;
  private BitmapFactory.Options g;
  
  public bc(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public bc(int paramInt1, int paramInt2, int paramInt3, int paramInt4, cy paramcy)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.f = paramcy;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
  }
  
  public void a(BitmapFactory.Options paramOptions)
  {
    this.g = paramOptions;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public cy e()
  {
    return this.f;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof bc)) {
        return false;
      }
      paramObject = (bc)paramObject;
    } while ((this.a == paramObject.a) && (this.b == paramObject.b) && (this.c == paramObject.c));
    return false;
  }
  
  public BitmapFactory.Options f()
  {
    return this.g;
  }
  
  public int hashCode()
  {
    return this.a * 7 + this.b * 11 + this.c * 13;
  }
  
  public String toString()
  {
    AppMethodBeat.i(149815);
    Object localObject = new StringBuilder(24);
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.c);
    ((StringBuilder)localObject).append("-");
    ((StringBuilder)localObject).append(this.d);
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(149815);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bc
 * JD-Core Version:    0.7.0.1
 */