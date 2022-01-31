package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.ah.a;

public class kk
  extends hv
{
  float A;
  private final Runnable B;
  private final Runnable C;
  private kk.a D;
  private boolean E;
  private Interpolator F;
  private ah.a G;
  private boolean H;
  private boolean I;
  private boolean J;
  private int K;
  private int L;
  private int M;
  private int N;
  private int O;
  private int P;
  private boolean Q;
  private boolean R;
  private boolean S;
  private boolean T;
  private float U;
  private float V;
  private double W;
  private double X;
  private double Y;
  private double Z;
  private double aa;
  private boolean ab;
  private int ac;
  private int ad;
  private boolean ae;
  private boolean af;
  private boolean ag;
  protected long j;
  protected long k;
  int l;
  int m;
  int n;
  int o;
  int p;
  int q;
  int r;
  int s;
  float t;
  float u;
  float v;
  float w;
  float x;
  float y;
  float z;
  
  public kk(int paramInt)
  {
    super(paramInt, null);
    AppMethodBeat.i(148959);
    this.B = new kk.1(this);
    this.C = new kk.2(this);
    this.D = null;
    this.j = 500L;
    this.E = false;
    this.k = 0L;
    this.F = new LinearInterpolator();
    this.G = null;
    this.H = false;
    this.I = false;
    this.J = false;
    this.K = 0;
    this.L = 0;
    this.M = 0;
    this.N = 0;
    this.O = 0;
    this.P = 0;
    this.Q = false;
    this.R = false;
    this.S = false;
    this.T = false;
    this.U = 0.0F;
    this.V = 0.0F;
    this.W = 0.0D;
    this.X = 0.0D;
    this.Y = 0.0D;
    this.Z = 0.0D;
    this.aa = 1.0D;
    this.ab = false;
    this.ac = 0;
    this.ad = 0;
    this.ae = false;
    this.l = 0;
    this.m = 0;
    this.n = 0;
    this.o = 0;
    this.p = 0;
    this.q = 0;
    this.r = 0;
    this.s = 0;
    this.af = false;
    this.t = 0.0F;
    this.u = 0.0F;
    this.v = 0.0F;
    this.w = 0.0F;
    this.ag = false;
    this.x = 0.0F;
    this.y = 0.0F;
    this.z = 0.0F;
    this.A = 0.0F;
    AppMethodBeat.o(148959);
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
  
  public void a(kk.a parama)
  {
    this.D = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    this.H = paramBoolean;
  }
  
  protected boolean a()
  {
    AppMethodBeat.i(148960);
    int i;
    int i1;
    label207:
    GeoPoint localGeoPoint;
    label241:
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
      if (!this.Q) {
        break label821;
      }
      if (this.D.g())
      {
        i = 22;
        i1 = i;
        if (this.D != null) {
          i1 = Math.min(this.D.b(), i);
        }
        if (this.U >= i1) {
          this.U = i1;
        }
        if (this.D != null)
        {
          f1 = this.D.a();
          if (Math.abs(this.U - f1) < 0.001D) {
            this.T = true;
          }
        }
        this.W = (1.0D / Math.pow(2.0D, 20.0F - this.U));
        if ((this.ae == true) && (this.D != null))
        {
          if (this.H != true) {
            break label882;
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
            break label896;
          }
          this.v -= 360.0F;
        }
        label352:
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
        break label928;
      }
      f2 = (float)(d() - this.k) / (float)this.j;
      f1 = f2;
      if (f2 <= 1.0F) {}
    }
    label896:
    label928:
    for (float f1 = 1.0F;; f1 = 1.0F)
    {
      f2 = this.F.getInterpolation(f1);
      this.I = true;
      if (this.J == true)
      {
        this.M = ((int)(this.K * f2));
        this.O = ((int)(this.L * f2));
        i = this.M;
        i1 = this.N;
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
        AppMethodBeat.o(148960);
        return true;
        i = 20;
        break;
        label821:
        if (this.R != true) {
          break label207;
        }
        if (Math.abs(this.V) < 0.001D) {
          this.T = true;
        }
        this.W = (1.0D / Math.pow(2.0D, 20.0F - (this.D.a() + this.V)));
        break label207;
        label882:
        localGeoPoint = this.D.c();
        break label241;
        if (this.v >= -180.0F) {
          break label352;
        }
        this.v += 360.0F;
        break label352;
      }
      AppMethodBeat.o(148960);
      return false;
    }
  }
  
  public void b()
  {
    AppMethodBeat.i(148964);
    super.b();
    this.I = true;
    if ((this.G != null) && (this.D != null)) {
      this.D.a(this.C);
    }
    AppMethodBeat.o(148964);
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
    AppMethodBeat.i(148962);
    this.t = e(paramFloat);
    this.af = true;
    AppMethodBeat.o(148962);
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.l = paramInt1;
    this.m = paramInt2;
    this.ae = true;
  }
  
  protected long d()
  {
    AppMethodBeat.i(148961);
    long l1 = SystemClock.uptimeMillis();
    AppMethodBeat.o(148961);
    return l1;
  }
  
  public void d(float paramFloat)
  {
    AppMethodBeat.i(148963);
    this.x = f(paramFloat);
    this.ag = true;
    AppMethodBeat.o(148963);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.kk
 * JD-Core Version:    0.7.0.1
 */