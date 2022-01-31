package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ty
  implements tx
{
  private List<ry> a = new ArrayList();
  private int b;
  private int c;
  private rz d = null;
  private boolean e = true;
  private float f;
  private float g = 0.0F;
  private String h;
  private tn i;
  private th j;
  
  public ty(tn paramtn, sd paramsd)
  {
    this.i = paramtn;
    this.j = paramtn.e();
    this.h = j();
    this.b = paramsd.d();
    b(paramsd.a());
    this.e = paramsd.f();
    this.f = paramsd.b();
    this.g = paramsd.e();
    this.c = paramsd.c();
  }
  
  private void b(List<ry> paramList)
  {
    rz.a locala = rz.a();
    this.a.clear();
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      paramList = null;
      while (localIterator.hasNext())
      {
        ry localry = (ry)localIterator.next();
        if (!localry.equals(paramList))
        {
          this.a.add(localry);
          locala.a(localry);
          paramList = localry;
        }
      }
      int k = this.a.size();
      if ((k > 1) && (((ry)this.a.get(0)).equals((ry)this.a.get(k - 1)))) {
        this.a.remove(k - 1);
      }
    }
    this.d = locala.a();
  }
  
  public float a()
  {
    return this.f;
  }
  
  public void a(float paramFloat)
  {
    this.f = paramFloat;
    this.i.a(false, false);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    this.i.a(false, false);
  }
  
  public void a(Canvas paramCanvas)
  {
    if ((this.a == null) || (this.a.size() == 0)) {}
    Path localPath;
    Object localObject;
    do
    {
      return;
      localPath = new Path();
      localObject = (ry)this.a.get(0);
      new PointF();
      localObject = this.i.b().a((ry)localObject);
      localPath.moveTo(((PointF)localObject).x, ((PointF)localObject).y);
      int k = 1;
      while (k < this.a.size())
      {
        localObject = (ry)this.a.get(k);
        new PointF();
        localObject = this.i.b().a((ry)localObject);
        localPath.lineTo(((PointF)localObject).x, ((PointF)localObject).y);
        k += 1;
      }
      localObject = new Paint();
      ((Paint)localObject).setColor(b());
      ((Paint)localObject).setAntiAlias(true);
      ((Paint)localObject).setStyle(Paint.Style.FILL);
      localPath.close();
      paramCanvas.drawPath(localPath, (Paint)localObject);
    } while (ub.a(a(), 0.0F));
    ((Paint)localObject).setStyle(Paint.Style.STROKE);
    ((Paint)localObject).setColor(d());
    ((Paint)localObject).setStrokeWidth(a());
    paramCanvas.drawPath(localPath, (Paint)localObject);
  }
  
  public void a(List<ry> paramList)
  {
    b(paramList);
    this.i.a(false, false);
  }
  
  public boolean a(ry paramry)
  {
    return ub.a(paramry, c());
  }
  
  public boolean a(tx paramtx)
  {
    return (equals(paramtx)) || (paramtx.j().equals(j()));
  }
  
  public int b()
  {
    return this.b;
  }
  
  public void b(float paramFloat)
  {
    this.g = paramFloat;
    this.j.c();
    this.i.a(false, false);
  }
  
  public void b(int paramInt)
  {
    this.c = paramInt;
    this.i.a(false, false);
  }
  
  public void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
    this.i.a(false, false);
  }
  
  public List<ry> c()
  {
    return this.a;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public boolean h()
  {
    if (this.d == null) {}
    rz localrz;
    do
    {
      return false;
      localrz = this.i.b().c();
      if (localrz == null) {
        return true;
      }
    } while ((!this.d.a(localrz)) && (!this.d.b(localrz)));
    return true;
  }
  
  public void i()
  {
    this.j.b(j());
  }
  
  public String j()
  {
    if (this.h == null) {
      this.h = th.a("Polygon");
    }
    return this.h;
  }
  
  public float k()
  {
    return this.g;
  }
  
  public boolean l()
  {
    return this.e;
  }
  
  public int m()
  {
    return super.hashCode();
  }
  
  public void n() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.ty
 * JD-Core Version:    0.7.0.1
 */