package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ListView;

public class uy
  extends FrameLayout
{
  private tn a;
  private to b;
  private va c;
  private vb d;
  private vd e;
  private Surface f;
  @Deprecated
  private ux g;
  
  public uy(Context paramContext, vc paramvc)
  {
    super(paramContext);
    a(paramvc);
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    int i = paramInt3 & 0x7;
    paramInt3 &= 0x70;
    float f1;
    if (i == 5)
    {
      f1 = paramFloat1 - paramInt1;
      if (paramInt3 != 80) {
        break label94;
      }
      paramFloat1 = paramFloat2 - paramInt2;
    }
    for (;;)
    {
      paramInt3 = Math.round(f1);
      i = Math.round(paramFloat1);
      paramView.layout(paramInt3, i, paramInt3 + paramInt1, i + paramInt2);
      return;
      f1 = paramFloat1;
      if (i != 1) {
        break;
      }
      f1 = paramFloat1 - paramInt1 / 2;
      break;
      label94:
      paramFloat1 = paramFloat2;
      if (paramInt3 == 16) {
        paramFloat1 = paramFloat2 - paramInt2 / 2;
      }
    }
  }
  
  private void a(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramView instanceof ListView))
    {
      View localView = (View)paramView.getParent();
      if (localView != null)
      {
        paramArrayOfInt[0] = localView.getWidth();
        paramArrayOfInt[1] = localView.getHeight();
      }
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramView.measure(0, 0);
    }
    if (paramInt1 == -2) {
      paramArrayOfInt[0] = paramView.getMeasuredWidth();
    }
    while (paramInt2 == -2)
    {
      paramArrayOfInt[1] = paramView.getMeasuredHeight();
      return;
      if (paramInt1 == -1) {
        paramArrayOfInt[0] = getMeasuredWidth();
      } else {
        paramArrayOfInt[0] = paramInt1;
      }
    }
    if (paramInt2 == -1)
    {
      paramArrayOfInt[1] = getMeasuredHeight();
      return;
    }
    paramArrayOfInt[1] = paramInt2;
  }
  
  private void a(View paramView, uy.a parama)
  {
    int[] arrayOfInt = new int[2];
    a(paramView, parama.width, parama.height, arrayOfInt);
    a(paramView, arrayOfInt[0], arrayOfInt[1], uy.a.a(parama), uy.a.b(parama), uy.a.c(parama));
  }
  
  private void a(vc paramvc)
  {
    h();
    Context localContext = getContext();
    this.a = new tn(this);
    if (paramvc != null) {
      this.f = paramvc.a();
    }
    this.b = this.a.h();
    setOnKeyListener(this.b);
    this.c = new va(this.a);
    this.e = new vd(this.a.f());
    this.d = new vb(this.a);
    this.g = new ux(this);
    if (paramvc != null) {
      this.a.g(paramvc.b());
    }
    if ((localContext instanceof uw)) {
      ((uw)localContext).a(this);
    }
    setBackgroundColor(-657936);
  }
  
  private void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView != null) {
        a(localView);
      }
      paramInt1 += 1;
    }
  }
  
  private void b(View paramView, uy.a parama)
  {
    int[] arrayOfInt = new int[2];
    a(paramView, parama.width, parama.height, arrayOfInt);
    PointF localPointF;
    if (parama.a() != null)
    {
      localPointF = this.a.b().a(parama.a());
      if (localPointF != null) {}
    }
    else
    {
      return;
    }
    localPointF.x += uy.a.a(parama);
    localPointF.y += uy.a.b(parama);
    a(paramView, arrayOfInt[0], arrayOfInt[1], localPointF.x, localPointF.y, uy.a.c(parama));
  }
  
  private void h()
  {
    SharedPreferences.Editor localEditor = getContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("4e7cb4aa49", "1.2.6");
    localEditor.commit();
  }
  
  public void a() {}
  
  public void a(Bundle paramBundle)
  {
    this.a.a(paramBundle);
  }
  
  public void a(View paramView)
  {
    uy.a locala;
    if (this == paramView.getParent())
    {
      if (!(paramView.getLayoutParams() instanceof uy.a)) {
        break label47;
      }
      locala = (uy.a)paramView.getLayoutParams();
      if (locala.a == 0) {
        b(paramView, locala);
      }
    }
    else
    {
      return;
    }
    a(paramView, locala);
    return;
    label47:
    a(paramView, new uy.a(paramView.getLayoutParams()));
  }
  
  public void b() {}
  
  public void b(Bundle paramBundle)
  {
    this.a.b(paramBundle);
  }
  
  public void c() {}
  
  public void computeScroll()
  {
    super.computeScroll();
    this.b.a();
  }
  
  public void d() {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    setClickable(false);
    this.b.b(MotionEvent.obtain(paramMotionEvent));
    getParent().requestDisallowInterceptTouchEvent(true);
    if ((super.dispatchTouchEvent(paramMotionEvent)) || (this.b.a(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.f != null)
    {
      paramCanvas = this.f.lockCanvas(null);
      super.draw(paramCanvas);
      this.f.unlockCanvasAndPost(paramCanvas);
      return;
    }
    super.draw(paramCanvas);
  }
  
  public void e()
  {
    this.a.m();
  }
  
  public void f()
  {
    a(false, 0, 0, 0, 0);
  }
  
  public void g()
  {
    clearAnimation();
    this.a.c().clearAnimation();
    this.b.b();
  }
  
  public ux getController()
  {
    return this.g;
  }
  
  public int getLatitudeSpan()
  {
    return this.c.b();
  }
  
  public int getLongitudeSpan()
  {
    return this.c.c();
  }
  
  public vb getMap()
  {
    return this.d;
  }
  
  public ry getMapCenter()
  {
    return this.d.c();
  }
  
  protected tn getMapContext()
  {
    return this.a;
  }
  
  public ux getMapController()
  {
    return this.g;
  }
  
  public int getMaxZoomLevel()
  {
    return this.d.e();
  }
  
  public int getMinZoomLevel()
  {
    return this.d.f();
  }
  
  public va getProjection()
  {
    return this.c;
  }
  
  public float getScalePerPixel()
  {
    return this.c.d();
  }
  
  public vd getUiSettings()
  {
    return this.e;
  }
  
  public final String getVersion()
  {
    return this.d.g();
  }
  
  public int getZoomLevel()
  {
    return this.d.d();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setLogoPosition(int paramInt)
  {
    this.e.a(paramInt);
  }
  
  public void setPinchEnabeled(boolean paramBoolean)
  {
    this.e.d(paramBoolean);
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    this.d.a(paramBoolean);
  }
  
  public void setScalControlsEnable(boolean paramBoolean)
  {
    this.e.b(paramBoolean);
  }
  
  public void setScaleControlsEnable(boolean paramBoolean)
  {
    this.e.b(paramBoolean);
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    this.e.b(paramInt);
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.e.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.uy
 * JD-Core Version:    0.7.0.1
 */