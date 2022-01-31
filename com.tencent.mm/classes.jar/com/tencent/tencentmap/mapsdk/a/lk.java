package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.f;
import java.util.concurrent.atomic.AtomicInteger;
import javax.microedition.khronos.opengles.GL10;

public class lk
  extends ln
{
  private static AtomicInteger R = new AtomicInteger(0);
  protected lt A = null;
  protected boolean B = false;
  protected int C = 0;
  protected int D = 0;
  protected float E = 0.5F;
  protected float F = 0.5F;
  public int G = 0;
  public int H = 0;
  private boolean Q = false;
  private Runnable S = new lk.1(this);
  private Runnable T = new lk.2(this);
  private lt.a U = new lk.3(this);
  private lt.b V = new lt.b()
  {
    public void a(float paramAnonymousFloat)
    {
      lk.this.q = paramAnonymousFloat;
      if (lk.this.a != null) {
        lk.this.a.a(lk.this.q);
      }
    }
    
    public void b(float paramAnonymousFloat) {}
  };
  protected kl a;
  protected Bitmap b = null;
  boolean c = false;
  protected byte[] d = new byte[0];
  protected float e = 0.0F;
  protected boolean f = false;
  protected float g = 0.0F;
  protected float h = 0.0F;
  protected float i = -1.0F;
  protected String j = null;
  String k = null;
  public int l = 0;
  public int m = 0;
  protected GeoPoint n = null;
  protected GeoPoint o = null;
  protected GeoPoint p = null;
  protected float q = 1.0F;
  protected float r = 1.0F;
  protected float s = 1.0F;
  public boolean t = false;
  public boolean u = false;
  public boolean v = true;
  protected ma w = null;
  public qf x = null;
  public qg y = null;
  protected pq z = null;
  
  public lk(ma paramma)
  {
    this.w = paramma;
    i();
  }
  
  private void b(qg paramqg)
  {
    if ((paramqg == null) || (this.a != null)) {}
    do
    {
      return;
      paramqg = d(paramqg);
    } while (paramqg == null);
    this.a = new kl(paramqg);
  }
  
  private void c(qg paramqg)
  {
    if (paramqg == null) {}
    do
    {
      return;
      paramqg = d(paramqg);
    } while (paramqg == null);
    if (this.a == null)
    {
      this.a = new kl(paramqg);
      return;
    }
    this.a.a(paramqg);
  }
  
  private km d(qg paramqg)
  {
    if (paramqg == null) {
      return null;
    }
    int i1 = paramqg.s();
    int i2 = paramqg.t();
    float f1 = this.E;
    float f2 = i1 * 1.0F / this.l;
    float f3 = this.F;
    float f4 = i2 * 1.0F / this.m;
    return new km().a(paramqg.k()).a(f1 - f2, f3 - f4).a(paramqg.s(), paramqg.t()).b(false).b((int)paramqg.l()).d(this.B).a(true);
  }
  
  private void i()
  {
    km localkm = new km();
    if (this.a == null)
    {
      this.a = new kl(localkm);
      return;
    }
    this.a.a(localkm);
  }
  
  public void a(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.C = paramInt1;
    this.D = paramInt2;
    if (this.a != null)
    {
      b(true);
      GeoPoint localGeoPoint = new GeoPoint(this.D, this.C);
      this.a.a(localGeoPoint);
    }
  }
  
  protected void a(Bitmap paramBitmap)
  {
    synchronized (this.d)
    {
      this.j = (paramBitmap.hashCode() + R.getAndIncrement());
      if (this.j == null) {
        this.j = "";
      }
      if (this.a != null) {
        this.a.a(this.j, new Bitmap[] { paramBitmap });
      }
      this.l = paramBitmap.getWidth();
      this.m = paramBitmap.getHeight();
      return;
    }
  }
  
  public void a(lt paramlt)
  {
    this.A = paramlt;
    if (this.A != null)
    {
      this.A.a(this.U);
      this.A.a(this.V);
    }
  }
  
  public void a(qg paramqg)
  {
    if (paramqg == null) {
      return;
    }
    this.y = paramqg;
    a_(paramqg.i());
    a(paramqg.o());
    b(paramqg.k());
    c(paramqg);
  }
  
  public void a(GL10 paramGL10)
  {
    if (!a()) {}
    do
    {
      return;
      b(this.y);
      b(paramGL10);
      paramGL10 = this.w.getMap().B();
    } while ((paramGL10 == null) || (this.a == null));
    this.a.b(paramGL10, this.w.getMap().t());
  }
  
  public boolean a()
  {
    return this.O;
  }
  
  public boolean a(float paramFloat1, float paramFloat2)
  {
    if ((!this.v) || (this.a == null)) {}
    while (this.a == null) {
      return false;
    }
    boolean bool = this.a.a(this.w.getMap().t(), paramFloat1, paramFloat2);
    Rect localRect = this.a.b(this.w.getMap().t());
    if ((bool == true) && (localRect != null))
    {
      this.G = ((int)paramFloat1 - localRect.left);
      this.H = ((int)paramFloat2 - localRect.top);
      return bool;
    }
    this.G = -1;
    this.H = -1;
    return bool;
  }
  
  public void a_(boolean paramBoolean)
  {
    this.O = paramBoolean;
  }
  
  public void b() {}
  
  public void b(float paramFloat)
  {
    this.q = paramFloat;
  }
  
  public void b(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return;
    }
    a(paramBitmap);
    e();
  }
  
  public void b(boolean paramBoolean)
  {
    this.B = paramBoolean;
  }
  
  protected boolean b(GL10 paramGL10)
  {
    if (this.A != null)
    {
      this.A.c();
      if (this.A.b() == true) {
        this.w.getMap().a();
      }
      return true;
    }
    return false;
  }
  
  public void c() {}
  
  public void d()
  {
    this.w = null;
    this.n = null;
  }
  
  public void e()
  {
    synchronized (this.d)
    {
      if ((this.b != null) && (!this.b.isRecycled())) {
        this.c = true;
      }
      return;
    }
  }
  
  public void f()
  {
    if (this.o != null) {
      this.Q = true;
    }
  }
  
  public boolean g()
  {
    if (this.A == null) {
      return false;
    }
    return this.A.a(this.n, this.p);
  }
  
  protected void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lk
 * JD-Core Version:    0.7.0.1
 */