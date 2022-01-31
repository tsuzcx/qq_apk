package com.tencent.mm.plugin.radar.ui;

import a.d.b.g;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

public class RadarSpecialSmoothScrollView
  extends ScrollView
{
  private float GT;
  private final Rect mRect = new Rect();
  private RadarSpecialTableLayout nmu;
  private TranslateAnimation nmv;
  private final RadarSpecialSmoothScrollView.a nmw = new RadarSpecialSmoothScrollView.a();
  
  public RadarSpecialSmoothScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    if (getChildCount() > 0)
    {
      View localView2 = getChildAt(0);
      View localView1 = localView2;
      if (!(localView2 instanceof RadarSpecialTableLayout)) {
        localView1 = null;
      }
      this.nmu = ((RadarSpecialTableLayout)localView1);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 1;
    g.k(paramMotionEvent, "ev");
    if (this.nmu == null) {
      return super.onTouchEvent(paramMotionEvent);
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label645:
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      this.GT = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY();
      if (this.GT == 0.0F) {
        this.GT = f;
      }
      Object localObject = this.nmu;
      if (localObject == null) {
        g.cUk();
      }
      int k = ((RadarSpecialTableLayout)localObject).getMeasuredHeight();
      int m = getHeight();
      int n = getScrollY();
      i = j;
      label146:
      RadarSpecialTableLayout localRadarSpecialTableLayout;
      if (n != 0)
      {
        if (n == k - m) {
          i = j;
        }
      }
      else
      {
        if (i == 0) {
          break label405;
        }
        i = (int)(this.GT - f);
        scrollBy(0, i);
        if (this.mRect.isEmpty())
        {
          localObject = this.mRect;
          localRadarSpecialTableLayout = this.nmu;
          if (localRadarSpecialTableLayout == null) {
            g.cUk();
          }
          j = localRadarSpecialTableLayout.getLeft();
          localRadarSpecialTableLayout = this.nmu;
          if (localRadarSpecialTableLayout == null) {
            g.cUk();
          }
          k = localRadarSpecialTableLayout.getTop();
          localRadarSpecialTableLayout = this.nmu;
          if (localRadarSpecialTableLayout == null) {
            g.cUk();
          }
          m = localRadarSpecialTableLayout.getRight();
          localRadarSpecialTableLayout = this.nmu;
          if (localRadarSpecialTableLayout == null) {
            g.cUk();
          }
          ((Rect)localObject).set(j, k, m, localRadarSpecialTableLayout.getBottom());
        }
        localObject = this.nmu;
        if (localObject == null) {
          g.cUk();
        }
        localRadarSpecialTableLayout = this.nmu;
        if (localRadarSpecialTableLayout == null) {
          g.cUk();
        }
        j = localRadarSpecialTableLayout.getLeft();
        localRadarSpecialTableLayout = this.nmu;
        if (localRadarSpecialTableLayout == null) {
          g.cUk();
        }
        k = localRadarSpecialTableLayout.getTop();
        m = i / 2;
        localRadarSpecialTableLayout = this.nmu;
        if (localRadarSpecialTableLayout == null) {
          g.cUk();
        }
        n = localRadarSpecialTableLayout.getRight();
        localRadarSpecialTableLayout = this.nmu;
        if (localRadarSpecialTableLayout == null) {
          g.cUk();
        }
        ((RadarSpecialTableLayout)localObject).w(j, k - m, n, localRadarSpecialTableLayout.getBottom() - i / 2);
      }
      for (;;)
      {
        this.GT = f;
        break;
        i = 0;
        break label146;
        label405:
        scrollBy(0, (int)(this.GT - f) / 2);
      }
      this.GT = 0.0F;
      if (!this.mRect.isEmpty()) {}
      for (;;)
      {
        if (i == 0) {
          break label645;
        }
        localObject = this.nmu;
        if (localObject == null) {
          g.cUk();
        }
        this.nmv = new TranslateAnimation(0.0F, 0.0F, ((RadarSpecialTableLayout)localObject).getTop() - this.mRect.top, 0.0F);
        localObject = this.nmv;
        if (localObject == null) {
          g.cUk();
        }
        ((TranslateAnimation)localObject).setInterpolator((Interpolator)this.nmw);
        localObject = this.nmv;
        if (localObject == null) {
          g.cUk();
        }
        localRadarSpecialTableLayout = this.nmu;
        if (localRadarSpecialTableLayout == null) {
          g.cUk();
        }
        ((TranslateAnimation)localObject).setDuration(Math.abs(localRadarSpecialTableLayout.getTop() - this.mRect.top));
        localObject = this.nmu;
        if (localObject == null) {
          g.cUk();
        }
        ((RadarSpecialTableLayout)localObject).startAnimation((Animation)this.nmv);
        localObject = this.nmu;
        if (localObject == null) {
          g.cUk();
        }
        ((RadarSpecialTableLayout)localObject).w(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
        this.mRect.setEmpty();
        break;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView
 * JD-Core Version:    0.7.0.1
 */