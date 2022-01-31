package com.tencent.tencentmap.mapsdk.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;

public class lx
  extends iv
{
  float A = 0.0F;
  private final Runnable B = new lx.1(this);
  private final Runnable C = new lx.2(this);
  private lx.a D = null;
  private boolean E = false;
  private Interpolator F = new LinearInterpolator();
  private ah.a G = null;
  private boolean H = false;
  private boolean I = false;
  private boolean J = false;
  private int K = 0;
  private int L = 0;
  private int M = 0;
  private int N = 0;
  private int O = 0;
  private int P = 0;
  private boolean Q = false;
  private boolean R = false;
  private boolean S = false;
  private boolean T = false;
  private float U = 0.0F;
  private float V = 0.0F;
  private double W = 0.0D;
  private double X = 0.0D;
  private double Y = 0.0D;
  private double Z = 0.0D;
  private double aa = 1.0D;
  private boolean ab = false;
  private int ac = 0;
  private int ad = 0;
  private boolean ae = false;
  private boolean af = false;
  private boolean ag = false;
  protected long j = 500L;
  protected long k = 0L;
  int l = 0;
  int m = 0;
  int n = 0;
  int o = 0;
  int p = 0;
  int q = 0;
  int r = 0;
  int s = 0;
  float t = 0.0F;
  float u = 0.0F;
  float v = 0.0F;
  float w = 0.0F;
  float x = 0.0F;
  float y = 0.0F;
  float z = 0.0F;
  
  public lx(int paramInt)
  {
    super(paramInt, null);
  }
  
  private float e(float paramFloat)
  {
    return (paramFloat % 360.0F + 360.0F) % 360.0F;
  }
  
  private float f(float paramFloat)
  {
    paramFloat = (paramFloat % 360.0F + 360.0F) % 360.0F;
    if (paramFloat > 45.0F) {
      return 45.0F;
    }
    return paramFloat;
  }
  
  public void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    this.U = paramFloat;
    this.Q = true;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      this.J = false;
    }
    this.K = paramInt1;
    this.L = paramInt2;
    this.J = true;
  }
  
  public void a(long paramLong)
  {
    this.j = paramLong;
  }
  
  public void a(ah.a parama)
  {
    this.G = parama;
  }
  
  public void a(lx.a parama)
  {
    this.D = parama;
  }
  
  protected boolean a()
  {
    int i;
    GeoPoint localGeoPoint;
    label216:
    float f2;
    if (!this.E)
    {
      this.E = true;
      if (this.J)
      {
        this.N = 0;
        this.P = 0;
      }
      if ((this.Q) || (this.R) || (this.S)) {
        this.X = (1.0D / Math.pow(2.0D, 20.0F - this.D.a()));
      }
      if (this.Q)
      {
        i = 20;
        if (this.D != null) {
          i = this.D.b();
        }
        if (this.U >= i) {
          this.U = i;
        }
        if (this.D != null)
        {
          f1 = this.D.a();
          if (Math.abs(this.U - f1) < 0.001D) {
            this.T = true;
          }
        }
        this.W = (1.0D / Math.pow(2.0D, i - this.U));
        if ((this.ae == true) && (this.D != null))
        {
          if (this.H != true) {
            break label845;
          }
          localGeoPoint = this.D.f();
          if (localGeoPoint != null)
          {
            this.n = localGeoPoint.getLatitudeE6();
            this.o = localGeoPoint.getLongitudeE6();
            this.p = (this.l - this.n);
            this.q = (this.m - this.o);
          }
        }
        if (this.af == true)
        {
          if (this.D != null) {
            this.u = this.D.d();
          }
          this.v = (this.t - this.u);
          if (this.v <= 180.0F) {
            break label859;
          }
          this.v -= 360.0F;
        }
        label327:
        if ((this.ag == true) && (this.D != null))
        {
          this.y = this.D.e();
          this.z = (this.x - this.y);
        }
        this.k = d();
      }
    }
    else
    {
      if (this.I) {
        break label885;
      }
      f2 = (float)(d() - this.k) / (float)this.j;
      f1 = f2;
      if (f2 <= 1.0F) {}
    }
    label845:
    label859:
    label885:
    for (float f1 = 1.0F;; f1 = 1.0F)
    {
      f2 = this.F.getInterpolation(f1);
      this.I = true;
      if (this.J == true)
      {
        this.M = ((int)(this.K * f2));
        this.O = ((int)(this.L * f2));
        i = this.M;
        int i1 = this.N;
        int i2 = this.O;
        int i3 = this.P;
        this.N = this.M;
        this.P = this.O;
        this.M = (i - i1);
        this.O = (i2 - i3);
        if ((Math.abs(this.K) > 0) || (Math.abs(this.L) > 0)) {
          this.I = false;
        }
      }
      if ((this.Q == true) || (this.R == true) || (this.S == true))
      {
        this.Y = (this.X + (this.W - this.X) * f2);
        if (!this.T) {
          this.I = false;
        }
      }
      if (this.ae == true)
      {
        this.r = (this.n + (int)(this.p * f2));
        this.s = (this.o + (int)(this.q * f2));
        if ((Math.abs(this.p) > 1) || (Math.abs(this.q) > 1)) {
          this.I = false;
        }
      }
      if (this.af == true)
      {
        this.w = (this.u + this.v * f2);
        if (Math.abs(this.v) > 1.0F) {
          this.I = false;
        }
      }
      if (this.ag == true)
      {
        float f3 = this.y;
        this.A = (f2 * this.z + f3);
        if (Math.abs(this.z) > 1.0F) {
          this.I = false;
        }
      }
      if (f1 >= 1.0F)
      {
        if ((this.G != null) && (this.D != null)) {
          this.D.a(this.B);
        }
        return true;
        if (this.R != true) {
          break;
        }
        if (Math.abs(this.V) < 0.001D) {
          this.T = true;
        }
        this.W = (1.0D / Math.pow(2.0D, 20.0F - (this.D.a() + this.V)));
        break;
        localGeoPoint = this.D.c();
        break label216;
        if (this.v >= -180.0F) {
          break label327;
        }
        this.v += 360.0F;
        break label327;
      }
      return false;
    }
  }
  
  public void b()
  {
    super.b();
    this.I = true;
    if ((this.G != null) && (this.D != null)) {
      this.D.a(this.C);
    }
  }
  
  public void b(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return;
    }
    this.V = paramFloat;
    this.R = true;
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.ac = paramInt1;
    this.ad = paramInt2;
    this.ab = true;
  }
  
  public void c(float paramFloat)
  {
    this.t = e(paramFloat);
    this.af = true;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.ae = true;
  }
  
  protected long d()
  {
    return SystemClock.uptimeMillis();
  }
  
  public void d(float paramFloat)
  {
    this.x = f(paramFloat);
    this.ag = true;
  }
  
  public boolean e()
  {
    return this.J;
  }
  
  public int f()
  {
    return this.M;
  }
  
  public int g()
  {
    return this.O;
  }
  
  public boolean h()
  {
    return (this.R) || (this.Q) || (this.S);
  }
  
  public float i()
  {
    return (float)this.Y;
  }
  
  public boolean j()
  {
    return this.ab;
  }
  
  public int k()
  {
    return this.ac;
  }
  
  public int l()
  {
    return this.ad;
  }
  
  public boolean m()
  {
    return this.ae;
  }
  
  public int n()
  {
    return this.r;
  }
  
  public int o()
  {
    return this.s;
  }
  
  public float p()
  {
    return this.w;
  }
  
  public boolean q()
  {
    return this.af;
  }
  
  public boolean r()
  {
    return this.ag;
  }
  
  public float s()
  {
    return this.A;
  }
  
  public boolean t()
  {
    return this.H;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.lx
 * JD-Core Version:    0.7.0.1
 */