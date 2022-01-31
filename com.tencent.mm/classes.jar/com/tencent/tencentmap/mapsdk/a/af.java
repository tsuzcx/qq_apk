package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class af
  extends FrameLayout
{
  private ah a = null;
  
  public af(Context paramContext, ai paramai)
  {
    super(paramContext);
    setClickable(true);
    if (isInEditMode()) {
      return;
    }
    a(paramContext.getApplicationContext(), paramai);
  }
  
  private void a(Context paramContext, ai paramai)
  {
    setBackgroundColor(Color.rgb(222, 215, 214));
    setEnabled(true);
    this.a = new ah(this, paramContext, paramai);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.p();
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
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.c() != null) && (this.a.c().l() != null)) {
      return this.a.c().l().onTouchEvent(paramMotionEvent);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.a.af
 * JD-Core Version:    0.7.0.1
 */