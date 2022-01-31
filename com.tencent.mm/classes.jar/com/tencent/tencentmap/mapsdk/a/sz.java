package com.tencent.tencentmap.mapsdk.a;

public final class sz
  extends sy
{
  private int d;
  private int e;
  private rz f;
  private int g;
  
  public final void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public final void a(rz paramrz)
  {
    this.f = paramrz;
  }
  
  public final void a(tn paramtn)
  {
    tj localtj = paramtn.c();
    if (this.e == 0)
    {
      i = localtj.getHeight() - this.g * 2;
      this.e = i;
      if (this.d != 0) {
        break label91;
      }
    }
    label91:
    for (int i = localtj.getWidth() - this.g * 2;; i = this.d - this.g * 2)
    {
      this.d = i;
      if ((this.e != 0) && (this.d != 0)) {
        break label107;
      }
      return;
      i = this.e - this.g * 2;
      break;
    }
    label107:
    Object localObject2 = this.f.c();
    Object localObject1 = this.f.b();
    localObject2 = sx.a((ry)localObject2);
    localObject1 = sx.a((ry)localObject1);
    double d1 = ((sw)localObject2).a() - ((sw)localObject1).a();
    double d3 = ((sw)localObject2).b() - ((sw)localObject1).b();
    float f1;
    if (this.e * 1.0F / this.d < (float)(d1 / d3))
    {
      f1 = (float)(this.e * 156543.03390000001D / d1);
      paramtn = paramtn.b().a(new su(0, f1));
      double d2 = ((sw)localObject1).b();
      d3 /= 2.0D;
      double d4 = ((sw)localObject1).a();
      localObject1 = new sw(d3 + d2, d1 / 2.0D + d4);
      if (!this.a) {
        break label321;
      }
      localtj.a((sw)localObject1, this.b, this.c);
    }
    for (;;)
    {
      localtj.b(paramtn.c(), this.a, this.c);
      return;
      f1 = (float)(this.d * 156543.03390000001D / d3);
      break;
      label321:
      localtj.b((sw)localObject1);
    }
  }
  
  public final void b(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void c(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.sz
 * JD-Core Version:    0.7.0.1
 */