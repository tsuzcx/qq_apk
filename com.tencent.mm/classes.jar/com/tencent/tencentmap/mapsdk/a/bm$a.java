package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.element.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.hu;

class bm$a
{
  private cm b;
  private l c;
  private Bitmap[] d;
  
  private String a(bm.b paramb)
  {
    AppMethodBeat.i(149880);
    String str = toString();
    if (paramb == bm.b.a)
    {
      paramb = "b_lt_".concat(String.valueOf(str));
      AppMethodBeat.o(149880);
      return paramb;
    }
    if (paramb == bm.b.b)
    {
      paramb = "b_rt_".concat(String.valueOf(str));
      AppMethodBeat.o(149880);
      return paramb;
    }
    if (paramb == bm.b.c)
    {
      paramb = "b_rb_".concat(String.valueOf(str));
      AppMethodBeat.o(149880);
      return paramb;
    }
    paramb = "b_lb_".concat(String.valueOf(str));
    AppMethodBeat.o(149880);
    return paramb;
  }
  
  public l a(hu paramhu, bm.b paramb)
  {
    AppMethodBeat.i(149879);
    dc localdc = this.b.a();
    Object localObject2 = this.b.f();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localdc.e();
    }
    if (localObject1 == null)
    {
      AppMethodBeat.o(149879);
      return null;
    }
    localObject1 = paramhu.b(bm.a(this.a, (cz)localObject1));
    int j;
    int i;
    float f1;
    float f2;
    label120:
    double d1;
    double d2;
    if (localdc != null)
    {
      j = localdc.a(bm.a(this.a));
      i = localdc.b(bm.a(this.a));
      if (localdc == null) {
        break label347;
      }
      f1 = localdc.q();
      f2 = localdc.r();
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
      if (paramb != bm.b.a) {
        break label368;
      }
      d2 = ((DoublePoint)localObject1).x - j;
      d1 = ((DoublePoint)localObject1).y - i;
    }
    for (;;)
    {
      localObject1 = new DoublePoint(d2, d1);
      this.c.a(paramhu.a((DoublePoint)localObject1));
      this.c.a(a(paramb), new Bitmap[] { localObject2 });
      paramhu = this.c;
      AppMethodBeat.o(149879);
      return paramhu;
      j = this.b.b();
      i = this.b.c();
      break;
      label347:
      f1 = this.b.d();
      f2 = this.b.e();
      break label120;
      label368:
      if (paramb == bm.b.b)
      {
        d2 = ((DoublePoint)localObject1).x + j;
        d1 = ((DoublePoint)localObject1).y - i;
      }
      else if (paramb == bm.b.c)
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
    AppMethodBeat.i(149877);
    boolean bool = this.b.h();
    AppMethodBeat.o(149877);
    return bool;
  }
  
  public int b()
  {
    AppMethodBeat.i(149878);
    if (this.b == null)
    {
      AppMethodBeat.o(149878);
      return 0;
    }
    int i = this.b.g();
    AppMethodBeat.o(149878);
    return i;
  }
  
  public l c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.bm.a
 * JD-Core Version:    0.7.0.1
 */