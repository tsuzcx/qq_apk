package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.tencentmap.mapsdk.maps.a.ie;
import com.tencent.tencentmap.mapsdk.maps.a.kx;

public abstract class aa
  extends FrameLayout
{
  private ah a = null;
  private ie b;
  
  public aa(Context paramContext, ai paramai)
  {
    super(paramContext);
    setClickable(true);
    if (isInEditMode()) {
      return;
    }
    a(paramContext, paramai);
  }
  
  private void a(Context paramContext, ai paramai)
  {
    setBackgroundColor(Color.rgb(222, 215, 214));
    setEnabled(true);
    this.a = new ah(this, paramContext, paramai);
    this.b = this.a.b().b();
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.p();
    }
  }
  
  public void a(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.a(paramObject, paramInt1, paramInt2);
    }
  }
  
  public void b()
  {
    if (this.a != null) {
      this.a.q();
    }
  }
  
  public void c()
  {
    if (this.a != null)
    {
      this.a.s();
      this.a = null;
    }
  }
  
  public void d()
  {
    if (this.a != null) {
      this.a.o();
    }
  }
  
  public void e()
  {
    if (this.a != null) {
      this.a.r();
    }
  }
  
  public void f()
  {
    if (this.a != null) {
      this.a.n();
    }
  }
  
  public final ah getMap()
  {
    return this.a;
  }
  
  public int[] getMapPadding()
  {
    return new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
  }
  
  public abstract int getMapViewType();
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.c() != null) && (this.a.c().k() != null)) {
      return this.a.c().k().a(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    if (this.a != null) {
      this.a.d(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.aa
 * JD-Core Version:    0.7.0.1
 */