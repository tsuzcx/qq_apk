package com.tencent.tencentmap.mapsdk.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.View;
import java.util.List;
import java.util.Vector;

public final class tj
  extends View
{
  private tn a;
  private tk b;
  private boolean c = false;
  private volatile boolean d = false;
  private List<Runnable> e = new Vector();
  private su f;
  private sw g = null;
  private PointF h = null;
  private vb.f i;
  private final Handler j = new tj.1(this);
  private sp k;
  private so l;
  
  public tj(tn paramtn)
  {
    super(tn.a());
    this.a = paramtn;
    this.b = paramtn.b();
    this.f = new su(10.0D);
    if ((paramtn.f().a() >= 3) && (paramtn.f().b() > 1.0F)) {
      this.f.a(1.3D);
    }
    this.g = sx.a(new ry(39.916690000000003D, 116.39716D));
    this.h = new PointF(getWidth() / 2, getHeight() / 2);
    if ((Build.VERSION.SDK_INT > 11) && (paramtn.c() != null)) {
      paramtn.c().setLayerType(2, null);
    }
  }
  
  private sw a(int paramInt1, int paramInt2)
  {
    return new sw(this.g.b() + paramInt1 * this.f.d(), this.g.a() - paramInt2 * this.f.d());
  }
  
  private void a(su paramsu, PointF paramPointF)
  {
    double d1 = getWidth() / 2.0D;
    double d2 = getHeight() / 2.0D;
    double d3 = this.g.b();
    double d4 = paramPointF.x;
    double d5 = this.f.d();
    double d6 = paramPointF.x;
    double d7 = paramsu.d();
    double d8 = this.g.a();
    double d9 = paramPointF.y;
    double d10 = this.f.d();
    double d11 = paramPointF.y;
    double d12 = paramsu.d();
    this.g.b(d3 + ((d4 - d1) * d5 + (d1 - d6) * d7));
    this.g.a(d8 - ((d9 - d2) * d10 + (d2 - d11) * d12));
    this.h.x = ((int)d1);
    this.h.y = ((int)d2);
    this.f.b(paramsu.c());
    this.b.a(this.g);
    this.a.a(false, false);
  }
  
  private void b(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, uv paramuv)
  {
    a(paramDouble, paramPointF, paramBoolean, paramLong, sn.a.c, paramuv);
  }
  
  private PointF e()
  {
    return new PointF(getWidth() / 2, getHeight() / 2);
  }
  
  public final PointF a()
  {
    return this.h;
  }
  
  public final void a(double paramDouble, PointF paramPointF)
  {
    double d1 = this.f.b();
    a(this.b.a(new su(this.f.a(), d1 * paramDouble)), paramPointF);
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, sn.a parama, uv paramuv)
  {
    if (paramBoolean)
    {
      if (this.k != null) {
        this.k.b();
      }
      this.k = new sp(this.a, paramDouble, paramPointF, paramLong, paramuv);
      this.k.a(parama);
      this.k.a();
    }
    do
    {
      return;
      a(this.b.a(new su(paramDouble)), paramPointF);
    } while (paramuv == null);
    paramuv.a();
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, long paramLong, uv paramuv)
  {
    b(paramDouble, paramPointF, false, 0L, null);
  }
  
  public final void a(double paramDouble, PointF paramPointF, boolean paramBoolean, uv paramuv)
  {
    b(this.f.c() + paramDouble, paramPointF, paramBoolean, 500L, paramuv);
  }
  
  public final void a(double paramDouble, boolean paramBoolean, uv paramuv)
  {
    b(this.f.c() + paramDouble, e(), paramBoolean, 500L, paramuv);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, uv paramuv)
  {
    a(a(paramInt1, paramInt2), paramLong, paramuv);
  }
  
  public final void a(PointF paramPointF, boolean paramBoolean, uv paramuv)
  {
    b(1.0D + this.f.c(), paramPointF, true, 500L, null);
  }
  
  public final void a(sw paramsw)
  {
    this.g = paramsw;
    this.b.a(this.g);
    this.a.a(false, false);
  }
  
  public final void a(sw paramsw, long paramLong, uv paramuv)
  {
    if (this.l != null) {
      this.l.b();
    }
    this.l = new so(this.a, paramsw, paramLong, paramuv);
    this.l.a();
  }
  
  public final void a(sy paramsy)
  {
    if ((!this.d) && (paramsy.a()))
    {
      this.e.add(new tj.2(this, paramsy));
      return;
    }
    paramsy.a(this.a);
  }
  
  public final void a(vb.f paramf)
  {
    this.i = paramf;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = true;
  }
  
  public final void a(boolean paramBoolean, uv paramuv)
  {
    b(1.0D + this.f.c(), e(), paramBoolean, 500L, paramuv);
  }
  
  public final sw b()
  {
    return this.g;
  }
  
  public final void b(double paramDouble, boolean paramBoolean, uv paramuv)
  {
    b(paramDouble, e(), paramBoolean, 500L, paramuv);
  }
  
  public final void b(sw paramsw)
  {
    a(paramsw);
  }
  
  public final void b(boolean paramBoolean, uv paramuv)
  {
    b(this.f.c() - 1.0D, e(), paramBoolean, 500L, paramuv);
  }
  
  public final double c()
  {
    return this.f.c();
  }
  
  public final void clearAnimation()
  {
    super.clearAnimation();
    if (this.l != null) {
      this.l.b();
    }
    if (this.k != null) {
      this.k.b();
    }
  }
  
  public final su d()
  {
    return this.f;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (!this.d)
    {
      this.j.sendEmptyMessage(11);
      this.d = true;
    }
    if (Build.VERSION.SDK_INT > 10) {
      paramCanvas.isHardwareAccelerated();
    }
    boolean bool = this.a.g().a(paramCanvas);
    this.a.e().a(paramCanvas);
    if (!tn.p())
    {
      Paint localPaint = new Paint();
      localPaint.setColor(-65536);
      localPaint.setTextSize(50.0F);
      Rect localRect = new Rect();
      int m = getWidth();
      int n = getHeight();
      localPaint.getTextBounds("鉴权失败，请到腾讯", 0, "鉴权失败，请到腾讯".length(), localRect);
      paramCanvas.drawText("鉴权失败，请到腾讯", m / 2 - localRect.width() / 2, n / 2 - localRect.height(), localPaint);
      localPaint.getTextBounds("地图官网申请密钥", 0, "地图官网申请密钥".length(), localRect);
      paramCanvas.drawText("地图官网申请密钥", m / 2 - localRect.width() / 2, n / 2 + 2, localPaint);
    }
    this.a.d(bool);
    if ((this.c) && (bool))
    {
      this.c = false;
      this.j.sendEmptyMessage(16);
    }
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.b.g() != 0.0D) && (this.b.h() != 0.0D))
    {
      this.b.b(this.b.g(), this.b.h());
      this.b.a(0);
      this.b.b(0);
    }
    this.h = new PointF(getWidth() / 2, getHeight() / 2);
    paramInt1 = su.a;
    paramInt2 = Math.max(getWidth(), getHeight());
    while (256.0D * Math.pow(2.0D, paramInt1) < paramInt2) {
      paramInt1 += 1;
    }
    su.a = paramInt1;
    if (this.b.j().a() < su.a) {
      this.b.c(su.a);
    }
    this.a.a(false, false);
  }
  
  public final void scrollBy(int paramInt1, int paramInt2)
  {
    a(a(paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.tj
 * JD-Core Version:    0.7.0.1
 */