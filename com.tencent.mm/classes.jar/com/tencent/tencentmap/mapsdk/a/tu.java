package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class tu
  implements tz
{
  private float a = 90.0F;
  private List<ry> b = new ArrayList();
  private List<ry> c = new ArrayList();
  private tn d;
  private th e;
  private boolean f = false;
  private rz g = null;
  private boolean h = false;
  private boolean i = true;
  private int j = -16777216;
  private float k = 10.0F;
  private float l = 0.0F;
  private rs m;
  private float n = 0.0F;
  private int o = -983041;
  private String p;
  
  public tu(tn paramtn, sf paramsf)
  {
    this.d = paramtn;
    this.e = paramtn.e();
    this.p = j();
    this.j = paramsf.g();
    this.f = paramsf.j();
    this.h = paramsf.k();
    if ((this.h) || (this.f)) {
      this.b = paramsf.e();
    }
    b(paramsf.e());
    this.i = paramsf.i();
    this.k = paramsf.f();
    this.l = paramsf.h();
    this.m = paramsf.a();
    this.n = paramsf.b();
    this.o = paramsf.c();
    this.a = paramsf.d();
  }
  
  private void a(Canvas paramCanvas, List<PointF> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      break label13;
    }
    label13:
    while ((this.m == null) || (this.m.b() == null)) {
      return;
    }
    int i2 = this.m.c();
    int i3 = this.m.d();
    double d7 = this.k / i3;
    double d8 = i2 * this.k / (i3 * this.a);
    double d1 = -(i2 * d7 / 2.0D);
    int i1 = 0;
    label95:
    PointF localPointF1;
    PointF localPointF2;
    if (i1 < paramList.size() - 1)
    {
      localPointF1 = (PointF)paramList.get(i1);
      localPointF2 = (PointF)paramList.get(i1 + 1);
      if ((localPointF1 != null) && (localPointF2 != null)) {
        break label176;
      }
    }
    label167:
    label176:
    for (double d2 = 0.0D;; d2 = Math.sqrt(Math.pow(localPointF1.x - localPointF2.x, 2.0D) + Math.pow(localPointF1.y - localPointF2.y, 2.0D)))
    {
      if (d2 + d1 >= this.a) {
        break label221;
      }
      d1 += d2;
      i1 += 1;
      break label95;
      break;
    }
    label221:
    double d9 = d2 / this.a;
    double d5 = (this.a - d1) / this.a;
    double d6 = Math.acos((localPointF2.x - localPointF1.x) / d2) * 180.0D / 3.141592653589793D;
    double d4;
    double d3;
    if ((localPointF2.x <= localPointF1.x) && (localPointF2.y >= localPointF1.y))
    {
      d2 = 180.0D - d6 + 180.0D;
      d4 = d5;
      d3 = d1;
    }
    for (;;)
    {
      d1 = d3;
      if (d4 > d9) {
        break label167;
      }
      if ((i1 == paramList.size() - 2) && (d4 + d8 > d9)) {
        break;
      }
      paramCanvas.save();
      paramCanvas.translate((float)(localPointF1.x + (localPointF2.x - localPointF1.x) * d4 / d9), (float)(localPointF1.y + (localPointF2.y - localPointF1.y) * d4 / d9));
      paramCanvas.scale((float)d7, (float)d7);
      paramCanvas.rotate((float)-d2);
      paramCanvas.drawBitmap(this.m.b(), -i2 / 2, -i3 / 2, null);
      paramCanvas.restore();
      if (1.0D + d4 > d9) {
        d3 = (d9 - d4) * this.a;
      }
      d4 += 1.0D;
      continue;
      d3 = d1;
      d2 = d6;
      d4 = d5;
      if (localPointF2.x >= localPointF1.x)
      {
        d3 = d1;
        d2 = d6;
        d4 = d5;
        if (localPointF2.y >= localPointF1.y)
        {
          d2 = 360.0D - d6;
          d3 = d1;
          d4 = d5;
        }
      }
    }
  }
  
  private static void a(List<ry> paramList1, List<ry> paramList2, double paramDouble)
  {
    if (paramList1.size() != 3) {}
    for (;;)
    {
      return;
      for (int i1 = 0; i1 <= 10; i1 = (int)(i1 + 1.0F))
      {
        float f1 = i1 / 10.0F;
        double d1 = f1;
        double d2 = f1;
        double d3 = ((ry)paramList1.get(0)).c();
        double d4 = 2.0F * f1;
        double d5 = f1;
        double d6 = ((ry)paramList1.get(1)).c();
        double d7 = f1 * f1;
        double d8 = ((ry)paramList1.get(2)).c();
        double d9 = f1;
        double d10 = f1;
        double d11 = ((ry)paramList1.get(0)).b();
        double d12 = 2.0F * f1;
        double d13 = f1;
        double d14 = ((ry)paramList1.get(1)).b();
        double d15 = f1 * f1;
        double d16 = ((ry)paramList1.get(2)).b();
        double d17 = f1;
        double d18 = f1;
        double d19 = 2.0F * f1;
        double d20 = f1;
        double d21 = f1 * f1;
        double d22 = f1;
        double d23 = f1;
        double d24 = 2.0F * f1;
        double d25 = f1;
        paramList2.add(new ry(((1.0D - d9) * (1.0D - d10) * d11 + d12 * (1.0D - d13) * d14 * paramDouble + d15 * d16) / (f1 * f1 + ((1.0D - d22) * (1.0D - d23) + d24 * (1.0D - d25) * paramDouble)), ((1.0D - d1) * (1.0D - d2) * d3 + d4 * (1.0D - d5) * d6 * paramDouble + d7 * d8) / ((1.0D - d17) * (1.0D - d18) + d19 * (1.0D - d20) * paramDouble + d21)));
      }
    }
  }
  
  private void b(List<ry> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    rz.a locala = rz.a();
    this.c.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        ry localry1 = (ry)localIterator.next();
        if ((localry1 != null) && (!localry1.equals(paramList)))
        {
          if (!this.h)
          {
            this.c.add(localry1);
            locala.a(localry1);
          }
          for (;;)
          {
            paramList = localry1;
            break;
            if (paramList != null)
            {
              if (Math.abs(localry1.c() - paramList.c()) >= 0.01D) {
                break label176;
              }
              this.c.add(paramList);
              locala.a(paramList);
              this.c.add(localry1);
              locala.a(localry1);
            }
          }
          label176:
          List localList = this.c;
          double d3 = Math.abs(paramList.c() - localry1.c()) * 3.141592653589793D / 180.0D;
          ry localry2 = new ry((localry1.b() + paramList.b()) / 2.0D, (localry1.c() + paramList.c()) / 2.0D);
          locala.a(paramList).a(localry2).a(localry1);
          if (localry2.b() > 0.0D) {}
          for (int i1 = 1;; i1 = -1)
          {
            double d1 = Math.cos(0.5D * d3);
            double d2 = Math.hypot(paramList.c() - localry1.c(), paramList.b() - localry1.b());
            double d5 = Math.tan(d3 * 0.5D);
            d3 = localry1.c() - paramList.c();
            double d4 = localry1.b() - paramList.b();
            double d6 = d4 * d4 / (d3 * d3);
            d2 = (int)(d5 * (d2 * 0.5D) * i1 / Math.sqrt(d6 + 1.0D) + localry2.b());
            d3 = d4 * (localry2.b() - d2) / d3;
            localry2 = new ry(d2, (int)(localry2.c() + d3));
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(paramList);
            localArrayList.add(localry2);
            localArrayList.add(localry1);
            a(localArrayList, localList, d1);
            break;
          }
        }
      }
    }
    this.g = locala.a();
  }
  
  public final List<ry> a()
  {
    if ((this.h) || (this.f)) {
      return this.b;
    }
    return this.c;
  }
  
  public final void a(float paramFloat)
  {
    this.k = paramFloat;
    this.d.a(false, false);
  }
  
  public final void a(int paramInt)
  {
    this.j = paramInt;
    this.d.a(false, false);
  }
  
  public final void a(Canvas paramCanvas)
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.c == null) || (this.c.size() == 0) || (this.k <= 0.0F)) {
      return;
    }
    Path localPath = new Path();
    Object localObject = (ry)this.c.get(0);
    localObject = this.d.b().a((ry)localObject);
    localArrayList.add(localObject);
    localPath.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
    int i1 = 1;
    while (i1 < this.c.size())
    {
      localObject = (ry)this.c.get(i1);
      localObject = this.d.b().a((ry)localObject);
      localArrayList.add(localObject);
      localPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
      i1 += 1;
    }
    localObject = new Paint();
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    if (this.f)
    {
      i1 = (int)this.k;
      ((Paint)localObject).setPathEffect(new DashPathEffect(new float[] { i1 * 3, i1, i1 * 3, i1 }, 1.0F));
    }
    for (;;)
    {
      ((Paint)localObject).setAntiAlias(true);
      if (this.n > 0.0F)
      {
        ((Paint)localObject).setColor(this.o);
        ((Paint)localObject).setStrokeWidth(this.k + 2.0F * this.n);
        paramCanvas.drawPath(localPath, (Paint)localObject);
      }
      ((Paint)localObject).setColor(this.j);
      ((Paint)localObject).setStrokeWidth(this.k);
      paramCanvas.drawPath(localPath, (Paint)localObject);
      if (this.m != null) {
        a(paramCanvas, localArrayList);
      }
      localArrayList.clear();
      return;
      ((Paint)localObject).setStrokeJoin(Paint.Join.ROUND);
      ((Paint)localObject).setStrokeCap(Paint.Cap.ROUND);
    }
  }
  
  public final void a(List<ry> paramList)
  {
    if ((this.h) || (this.f)) {
      this.b = paramList;
    }
    b(paramList);
    this.d.a(false, false);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    this.d.a(false, false);
  }
  
  public final boolean a(tx paramtx)
  {
    return (equals(paramtx)) || (paramtx.j().equals(j()));
  }
  
  public final float b()
  {
    return this.k;
  }
  
  public final void b(float paramFloat)
  {
    this.l = paramFloat;
    this.e.c();
    this.d.a(false, false);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.i = paramBoolean;
    this.e.c();
    this.d.a(false, false);
  }
  
  public final void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.d.a(false, false);
  }
  
  public final boolean c()
  {
    return this.f;
  }
  
  public final boolean d()
  {
    return this.h;
  }
  
  public final int e()
  {
    return this.j;
  }
  
  public final boolean h()
  {
    if (this.g == null) {}
    rz localrz;
    do
    {
      return false;
      localrz = this.d.b().c();
      if (localrz == null) {
        return true;
      }
    } while ((!localrz.a(this.g)) && (!this.g.b(localrz)));
    return true;
  }
  
  public final void i()
  {
    this.e.b(j());
  }
  
  public final String j()
  {
    if (this.p == null) {
      this.p = th.a("Polyline");
    }
    return this.p;
  }
  
  public final float k()
  {
    return this.l;
  }
  
  public final boolean l()
  {
    return this.i;
  }
  
  public final int m()
  {
    return super.hashCode();
  }
  
  public final void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tu
 * JD-Core Version:    0.7.0.1
 */