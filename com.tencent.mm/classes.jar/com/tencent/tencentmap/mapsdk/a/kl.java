package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.DoublePoint;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.map.lib.mapstructure.TappedElement;

public class kl
  implements kj
{
  protected km a;
  protected GLIcon b;
  protected kn c;
  protected DoublePoint d = new DoublePoint();
  private ik e;
  private boolean f;
  private hr g = null;
  
  public kl()
  {
    this.f = true;
  }
  
  public kl(km paramkm)
  {
    this.a = paramkm;
    this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
    this.b.setFixPos(paramkm.n());
    this.b.setFastLoad(paramkm.o());
    this.b.setRotateAngle(paramkm.h());
    this.b.setAvoidAnno(paramkm.j());
    this.b.setAlpha(paramkm.e());
    this.f = true;
  }
  
  public Rect a(iu paramiu)
  {
    if ((this.b == null) || (this.a == null) || (this.a.a() == null)) {
      return null;
    }
    Object localObject1;
    Object localObject2;
    if (e())
    {
      localObject1 = a();
      localObject2 = new DoublePoint(0.0D, 0.0D);
      if (localObject1 != null)
      {
        ((DoublePoint)localObject2).x = ((GeoPoint)localObject1).getLongitudeE6();
        ((DoublePoint)localObject2).y = ((GeoPoint)localObject1).getLatitudeE6();
      }
    }
    for (this.d = ((DoublePoint)localObject2);; this.d = paramiu.b(a()))
    {
      localObject2 = new DoublePoint();
      localObject1 = new DoublePoint();
      Bitmap localBitmap = this.b.getTextureBm(this.b.getState());
      int j = localBitmap.getWidth();
      int i = localBitmap.getHeight();
      ((DoublePoint)localObject2).x = this.d.x;
      ((DoublePoint)localObject1).x = (this.d.x + j);
      ((DoublePoint)localObject2).y = this.d.y;
      ((DoublePoint)localObject1).y = (this.d.y + i);
      float f1 = this.a.f();
      j = (int)(j * f1);
      f1 = this.a.g();
      i = (int)(i * f1);
      ((DoublePoint)localObject2).x -= j;
      ((DoublePoint)localObject1).x -= j;
      ((DoublePoint)localObject2).y -= i;
      ((DoublePoint)localObject1).y -= i;
      i = this.a.k();
      j = this.a.l();
      ((DoublePoint)localObject2).x += i;
      ((DoublePoint)localObject1).x += i;
      ((DoublePoint)localObject2).y += j;
      double d1 = ((DoublePoint)localObject1).y;
      ((DoublePoint)localObject1).y = (j + d1);
      localObject2 = paramiu.a((DoublePoint)localObject2);
      paramiu = paramiu.a((DoublePoint)localObject1);
      return new Rect(((GeoPoint)localObject2).getLongitudeE6(), ((GeoPoint)localObject2).getLatitudeE6(), paramiu.getLongitudeE6(), paramiu.getLatitudeE6());
    }
  }
  
  public GeoPoint a()
  {
    return this.a.a();
  }
  
  public void a(float paramFloat)
  {
    this.a = this.a.a(paramFloat);
    if (this.b != null)
    {
      this.b.setAlpha(paramFloat);
      this.b.setDirty(true);
    }
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.a = this.a.a(paramFloat1, paramFloat2);
    if (this.b != null)
    {
      this.b.setAnchor(paramFloat1, paramFloat2);
      this.b.setDirty(true);
    }
  }
  
  public void a(int paramInt)
  {
    this.a = this.a.a(paramInt);
    if (this.b != null)
    {
      this.b.setRotateAngle(paramInt);
      this.b.setDirty(true);
    }
  }
  
  public void a(GeoPoint paramGeoPoint)
  {
    this.a = this.a.a(paramGeoPoint);
    if (this.b != null)
    {
      this.b.setPosition(paramGeoPoint);
      this.b.setDirty(true);
    }
  }
  
  public void a(km paramkm)
  {
    if (paramkm == null) {
      return;
    }
    if (this.a == null) {
      this.a = paramkm;
    }
    for (;;)
    {
      if (this.b == null) {
        this.b = new GLIcon(this.a.c(), this.a.a(), this.a.f(), this.a.g(), this.a.k(), this.a.l(), this.a.b());
      }
      this.b.setAlpha(this.a.e());
      this.b.setAnchor(this.a.f(), this.a.g());
      this.b.setRotateAngle(paramkm.h());
      this.b.setFixPos(paramkm.n());
      this.b.setFastLoad(paramkm.o());
      this.b.setAvoidAnno(paramkm.j());
      return;
      this.a.a(paramkm.e());
      this.a.a(paramkm.f(), paramkm.g());
      this.a.b(paramkm.d());
      this.a.a(paramkm.h());
      this.a.b(paramkm.m());
      this.a.c(paramkm.j());
    }
  }
  
  public void a(String paramString, Bitmap... paramVarArgs)
  {
    this.a = this.a.a(paramString, paramVarArgs);
    if (this.b != null)
    {
      this.b.update(paramString, paramVarArgs);
      this.b.setDirty(true);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a(iu paramiu, float paramFloat1, float paramFloat2)
  {
    boolean bool2;
    if ((!d()) || (this.a.a() == null) || (this.e == null))
    {
      bool2 = false;
      return bool2;
    }
    paramiu = this.e.f().a(paramFloat1, paramFloat2);
    if ((paramiu != null) && (paramiu.itemId == f())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1) {
        this.b.setState(1);
      }
      for (;;)
      {
        bool2 = bool1;
        if (!bool1) {
          break;
        }
        bool2 = bool1;
        if (this.c == null) {
          break;
        }
        this.c.a(this);
        return bool1;
        this.b.setState(0);
      }
    }
  }
  
  public float b()
  {
    return this.a.f();
  }
  
  public Rect b(iu paramiu)
  {
    if ((this.b == null) || (this.a == null) || (this.a.a() == null)) {
      return null;
    }
    DoublePoint localDoublePoint;
    int j;
    int i;
    if (e())
    {
      paramiu = a();
      localDoublePoint = new DoublePoint(0.0D, 0.0D);
      if (paramiu != null)
      {
        localDoublePoint.x = paramiu.getLongitudeE6();
        localDoublePoint.y = paramiu.getLatitudeE6();
      }
      this.d = localDoublePoint;
      paramiu = new DoublePoint();
      localDoublePoint = new DoublePoint();
      Bitmap localBitmap = this.b.getTextureBm(this.b.getState());
      if (localBitmap == null) {
        break label388;
      }
      j = localBitmap.getWidth();
      i = localBitmap.getHeight();
    }
    for (;;)
    {
      paramiu.x = this.d.x;
      localDoublePoint.x = (this.d.x + j);
      paramiu.y = this.d.y;
      localDoublePoint.y = (this.d.y + i);
      j = (int)(this.a.f() * j);
      float f1 = this.a.g();
      i = (int)(i * f1);
      paramiu.x -= j;
      localDoublePoint.x -= j;
      paramiu.y -= i;
      localDoublePoint.y -= i;
      i = this.a.k();
      j = this.a.l();
      paramiu.x += i;
      localDoublePoint.x += i;
      paramiu.y += j;
      double d1 = localDoublePoint.y;
      localDoublePoint.y = (j + d1);
      return new Rect((int)paramiu.x, (int)paramiu.y, (int)localDoublePoint.x, (int)localDoublePoint.y);
      this.d = paramiu.b(a());
      break;
      label388:
      i = 0;
      j = 0;
    }
  }
  
  public void b(int paramInt)
  {
    this.a = this.a.b(paramInt);
    if (this.b != null) {
      this.b.setDirty(true);
    }
  }
  
  public void b(je paramje, iu paramiu)
  {
    if (!d()) {
      if (this.b != null) {
        this.b.mDisplayId = -1;
      }
    }
    for (;;)
    {
      return;
      this.e = paramje.b();
      if (this.g != null)
      {
        if (this.g.b()) {
          break label113;
        }
        this.g.a();
      }
      while (this.b != null)
      {
        paramje.a(this.a.a(), this.b, this.a.d(), this.a.h(), this.a.i(), this.a.p(), this.a.m());
        return;
        label113:
        this.g = null;
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.b != null)
    {
      this.b.setFixPos(paramBoolean);
      this.b.setDirty(true);
    }
  }
  
  public float c()
  {
    return this.a.g();
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public boolean e()
  {
    if (this.b != null) {
      return this.b.isFixPos();
    }
    return false;
  }
  
  public int f()
  {
    if (this.b != null) {
      return this.b.mDisplayId;
    }
    return -1;
  }
  
  public void g()
  {
    if (this.b != null) {
      this.b.mDisplayId = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.kl
 * JD-Core Version:    0.7.0.1
 */