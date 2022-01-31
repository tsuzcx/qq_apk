package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.cn;
import com.tencent.tencentmap.mapsdk.a.dn;

public class kt
  implements id
{
  private kx a;
  
  public kt(kx paramkx)
  {
    this.a = paramkx;
  }
  
  public void a() {}
  
  public boolean a(float paramFloat)
  {
    return false;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148981);
    if (this.a == null)
    {
      AppMethodBeat.o(148981);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148981);
      return false;
    }
    if ((this.a.k != null) && (this.a.H))
    {
      boolean bool = this.a.k.a(paramFloat1, paramFloat2);
      AppMethodBeat.o(148981);
      return bool;
    }
    AppMethodBeat.o(148981);
    return false;
  }
  
  public boolean a(PointF paramPointF1, PointF paramPointF2, double paramDouble1, double paramDouble2)
  {
    return false;
  }
  
  public boolean a(PointF paramPointF1, PointF paramPointF2, float paramFloat)
  {
    return false;
  }
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148982);
    if (this.a == null)
    {
      AppMethodBeat.o(148982);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148982);
      return false;
    }
    if (!this.a.d(paramFloat1, paramFloat2)) {
      this.a.b(paramFloat1, paramFloat2);
    }
    if ((this.a.k != null) && (this.a.H))
    {
      boolean bool = this.a.k.b(paramFloat1, paramFloat2);
      AppMethodBeat.o(148982);
      return bool;
    }
    AppMethodBeat.o(148982);
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148983);
    if (this.a == null)
    {
      AppMethodBeat.o(148983);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148983);
      return false;
    }
    if (this.a.k != null)
    {
      boolean bool = this.a.k.c(paramFloat1, paramFloat2);
      AppMethodBeat.o(148983);
      return bool;
    }
    AppMethodBeat.o(148983);
    return false;
  }
  
  public boolean d()
  {
    return false;
  }
  
  public boolean d(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148984);
    if (this.a == null)
    {
      AppMethodBeat.o(148984);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148984);
      return false;
    }
    if (this.a.k != null)
    {
      boolean bool = this.a.k.d(paramFloat1, paramFloat2);
      AppMethodBeat.o(148984);
      return bool;
    }
    AppMethodBeat.o(148984);
    return false;
  }
  
  public boolean e(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148985);
    if (this.a == null)
    {
      AppMethodBeat.o(148985);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148985);
      return false;
    }
    this.a.a(paramFloat1, paramFloat2);
    if (this.a.k != null)
    {
      boolean bool = this.a.k.e(paramFloat1, paramFloat2);
      AppMethodBeat.o(148985);
      return bool;
    }
    AppMethodBeat.o(148985);
    return false;
  }
  
  public boolean f(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean g(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean h(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean i(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148986);
    if (this.a == null)
    {
      AppMethodBeat.o(148986);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148986);
      return false;
    }
    kx localkx = this.a;
    localkx.L += 1;
    if (this.a.k != null)
    {
      boolean bool = this.a.k.f(paramFloat1, paramFloat2);
      AppMethodBeat.o(148986);
      return bool;
    }
    AppMethodBeat.o(148986);
    return false;
  }
  
  public boolean j(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(148987);
    if (this.a == null)
    {
      AppMethodBeat.o(148987);
      return false;
    }
    if (!this.a.H)
    {
      AppMethodBeat.o(148987);
      return false;
    }
    Object localObject = this.a;
    int i;
    if (this.a.L > 0)
    {
      kx localkx = this.a;
      i = localkx.L - 1;
      localkx.L = i;
    }
    for (;;)
    {
      ((kx)localObject).L = i;
      if ((!this.a.K) || (!this.a.J) || (this.a.L != 0)) {
        break label143;
      }
      localObject = this.a.s();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(148987);
      return false;
      i = 0;
    }
    this.a.onCameraChangeFinished((cn)localObject);
    label143:
    if (this.a.k != null)
    {
      boolean bool = this.a.k.g(paramFloat1, paramFloat2);
      AppMethodBeat.o(148987);
      return bool;
    }
    AppMethodBeat.o(148987);
    return false;
  }
  
  public boolean k(float paramFloat1, float paramFloat2)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kt
 * JD-Core Version:    0.7.0.1
 */