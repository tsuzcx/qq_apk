package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.map.lib.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.de;

public class jw
{
  private kx a;
  private de b;
  private int c = 0;
  private jw.a d;
  private boolean e = false;
  
  public jw(kx paramkx, de paramde)
  {
    this.a = paramkx;
    this.b = paramde;
  }
  
  private void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(148849);
    if (this.a == null)
    {
      AppMethodBeat.o(148849);
      return;
    }
    if (this.c <= 0) {
      a((int)(paramFloat1 * 255.0F), (int)(paramFloat2 * 255.0F), (int)(paramFloat3 * 255.0F), 0);
    }
    this.a.b().b(this.c, (int)(paramFloat4 * 255.0F));
    this.a.b().a();
    AppMethodBeat.o(148849);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(148848);
    if ((this.a != null) && (this.b != null))
    {
      this.c = this.a.b().a(paramInt1, paramInt2, paramInt3, paramInt4, -1, this.b.c());
      this.a.h();
    }
    AppMethodBeat.o(148848);
  }
  
  private int c(int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  private int d(int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  private void d()
  {
    AppMethodBeat.i(148850);
    if (this.a != null)
    {
      this.a.b().e(this.c);
      this.a.b().a();
      this.c = -1;
    }
    AppMethodBeat.o(148850);
  }
  
  private int e(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public void a(int paramInt) {}
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(148846);
    if ((paramLong > 0L) && (this.d != null))
    {
      this.d.b(paramLong);
      AppMethodBeat.o(148846);
      return;
    }
    if (this.d != null) {
      this.d.a();
    }
    d();
    b();
    AppMethodBeat.o(148846);
  }
  
  public void a(boolean paramBoolean)
  {
    AppMethodBeat.i(148847);
    this.e = paramBoolean;
    if (paramBoolean)
    {
      a();
      AppMethodBeat.o(148847);
      return;
    }
    d();
    AppMethodBeat.o(148847);
  }
  
  public boolean a()
  {
    AppMethodBeat.i(148845);
    if (this.b == null)
    {
      AppMethodBeat.o(148845);
      return false;
    }
    int i = this.b.a();
    if (this.d == null) {
      this.d = new jw.a(this, b(i), c(i), d(i), e(i), -1);
    }
    this.d.a(this.b.b());
    AppMethodBeat.o(148845);
    return true;
  }
  
  public int b(int paramInt)
  {
    return paramInt >> 16 & 0xFF;
  }
  
  public void b()
  {
    this.d = null;
    this.a = null;
    this.b = null;
  }
  
  public boolean c()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.jw
 * JD-Core Version:    0.7.0.1
 */