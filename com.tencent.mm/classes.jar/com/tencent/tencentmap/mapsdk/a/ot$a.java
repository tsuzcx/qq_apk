package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.DoublePoint;

class ot$a
{
  private pt b;
  private kl c;
  private Bitmap[] d;
  
  private String a(ot.b paramb)
  {
    String str = toString();
    if (paramb == ot.b.a) {
      return "b_lt_" + str;
    }
    if (paramb == ot.b.b) {
      return "b_rt_" + str;
    }
    if (paramb == ot.b.c) {
      return "b_rb_" + str;
    }
    return "b_lb_" + str;
  }
  
  public kl a(iu paramiu, ot.b paramb)
  {
    qf localqf = this.b.a();
    Object localObject2 = this.b.f();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localqf.e();
    }
    if (localObject1 == null) {
      return null;
    }
    localObject1 = paramiu.b(ot.a(this.a, (qc)localObject1));
    int j;
    int i;
    float f1;
    float f2;
    label110:
    double d1;
    double d2;
    if (localqf != null)
    {
      j = localqf.a(ot.a(this.a));
      i = localqf.b(ot.a(this.a));
      if (localqf == null) {
        break label330;
      }
      f1 = localqf.q();
      f2 = localqf.r();
      if ((f1 >= 0.0F) && (f1 <= 1.0F))
      {
        d1 = f1;
        d2 = j;
        ((DoublePoint)localObject1).x -= (d1 - 0.5D) * d2;
      }
      if ((f2 >= 0.0F) && (f2 <= 1.0F))
      {
        d1 = f2;
        d2 = i;
        ((DoublePoint)localObject1).y -= (d1 - 0.5D) * d2;
      }
      localObject2 = this.d[paramb.ordinal()];
      j = ((Bitmap)localObject2).getWidth() / 2;
      i = ((Bitmap)localObject2).getHeight() / 2 + i / 2;
      if (paramb != ot.b.a) {
        break label351;
      }
      d2 = ((DoublePoint)localObject1).x - j;
      d1 = ((DoublePoint)localObject1).y - i;
    }
    for (;;)
    {
      localObject1 = new DoublePoint(d2, d1);
      this.c.a(paramiu.a((DoublePoint)localObject1));
      this.c.a(a(paramb), new Bitmap[] { localObject2 });
      return this.c;
      j = this.b.b();
      i = this.b.c();
      break;
      label330:
      f1 = this.b.d();
      f2 = this.b.e();
      break label110;
      label351:
      if (paramb == ot.b.b)
      {
        d2 = ((DoublePoint)localObject1).x + j;
        d1 = ((DoublePoint)localObject1).y - i;
      }
      else if (paramb == ot.b.c)
      {
        d2 = ((DoublePoint)localObject1).x + j;
        d1 = ((DoublePoint)localObject1).y;
        d1 = i + d1;
      }
      else
      {
        d2 = ((DoublePoint)localObject1).x - j;
        d1 = ((DoublePoint)localObject1).y;
        d1 = i + d1;
      }
    }
  }
  
  public boolean a()
  {
    return this.b.h();
  }
  
  public int b()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.g();
  }
  
  public kl c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ot.a
 * JD-Core Version:    0.7.0.1
 */