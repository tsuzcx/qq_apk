package com.tencent.mm.plugin.radar.ui;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLayoutChanged", "", "()Z", "isOverScroll", "mLastMotionY", "", "mRect", "Landroid/graphics/Rect;", "mRootChildView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "mScrollInterpolator", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "mTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "onFinishInflate", "", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "scaleOverScroll", "", "offset", "startAnimation", "WorkspaceOvershootInterpolator", "plugin-radar_release"})
public class RadarSpecialSmoothScrollView
  extends ScrollView
{
  private float mLastMotionY;
  private final Rect mRect;
  private RadarSpecialTableLayout pRJ;
  private TranslateAnimation pRK;
  private final RadarSpecialSmoothScrollView.a pRL;
  
  public RadarSpecialSmoothScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(103011);
    this.mRect = new Rect();
    this.pRL = new RadarSpecialSmoothScrollView.a();
    AppMethodBeat.o(103011);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(103009);
    if (getChildCount() > 0)
    {
      View localView2 = getChildAt(0);
      View localView1 = localView2;
      if (!(localView2 instanceof RadarSpecialTableLayout)) {
        localView1 = null;
      }
      this.pRJ = ((RadarSpecialTableLayout)localView1);
    }
    AppMethodBeat.o(103009);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(103010);
    j.q(paramMotionEvent, "ev");
    boolean bool;
    if (this.pRJ == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(103010);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label666:
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(103010);
      return bool;
      this.mLastMotionY = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY();
      if (this.mLastMotionY == 0.0F) {
        this.mLastMotionY = f;
      }
      Object localObject = this.pRJ;
      if (localObject == null) {
        j.ebi();
      }
      int k = ((RadarSpecialTableLayout)localObject).getMeasuredHeight();
      int m = getHeight();
      int n = getScrollY();
      i = j;
      label167:
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
          break label426;
        }
        i = (int)(this.mLastMotionY - f);
        scrollBy(0, i);
        if (this.mRect.isEmpty())
        {
          localObject = this.mRect;
          localRadarSpecialTableLayout = this.pRJ;
          if (localRadarSpecialTableLayout == null) {
            j.ebi();
          }
          j = localRadarSpecialTableLayout.getLeft();
          localRadarSpecialTableLayout = this.pRJ;
          if (localRadarSpecialTableLayout == null) {
            j.ebi();
          }
          k = localRadarSpecialTableLayout.getTop();
          localRadarSpecialTableLayout = this.pRJ;
          if (localRadarSpecialTableLayout == null) {
            j.ebi();
          }
          m = localRadarSpecialTableLayout.getRight();
          localRadarSpecialTableLayout = this.pRJ;
          if (localRadarSpecialTableLayout == null) {
            j.ebi();
          }
          ((Rect)localObject).set(j, k, m, localRadarSpecialTableLayout.getBottom());
        }
        localObject = this.pRJ;
        if (localObject == null) {
          j.ebi();
        }
        localRadarSpecialTableLayout = this.pRJ;
        if (localRadarSpecialTableLayout == null) {
          j.ebi();
        }
        j = localRadarSpecialTableLayout.getLeft();
        localRadarSpecialTableLayout = this.pRJ;
        if (localRadarSpecialTableLayout == null) {
          j.ebi();
        }
        k = localRadarSpecialTableLayout.getTop();
        m = i / 2;
        localRadarSpecialTableLayout = this.pRJ;
        if (localRadarSpecialTableLayout == null) {
          j.ebi();
        }
        n = localRadarSpecialTableLayout.getRight();
        localRadarSpecialTableLayout = this.pRJ;
        if (localRadarSpecialTableLayout == null) {
          j.ebi();
        }
        ((RadarSpecialTableLayout)localObject).C(j, k - m, n, localRadarSpecialTableLayout.getBottom() - i / 2);
      }
      for (;;)
      {
        this.mLastMotionY = f;
        break;
        i = 0;
        break label167;
        label426:
        scrollBy(0, (int)(this.mLastMotionY - f) / 2);
      }
      this.mLastMotionY = 0.0F;
      if (!this.mRect.isEmpty()) {}
      for (;;)
      {
        if (i == 0) {
          break label666;
        }
        localObject = this.pRJ;
        if (localObject == null) {
          j.ebi();
        }
        this.pRK = new TranslateAnimation(0.0F, 0.0F, ((RadarSpecialTableLayout)localObject).getTop() - this.mRect.top, 0.0F);
        localObject = this.pRK;
        if (localObject == null) {
          j.ebi();
        }
        ((TranslateAnimation)localObject).setInterpolator((Interpolator)this.pRL);
        localObject = this.pRK;
        if (localObject == null) {
          j.ebi();
        }
        localRadarSpecialTableLayout = this.pRJ;
        if (localRadarSpecialTableLayout == null) {
          j.ebi();
        }
        ((TranslateAnimation)localObject).setDuration(Math.abs(localRadarSpecialTableLayout.getTop() - this.mRect.top));
        localObject = this.pRJ;
        if (localObject == null) {
          j.ebi();
        }
        ((RadarSpecialTableLayout)localObject).startAnimation((Animation)this.pRK);
        localObject = this.pRJ;
        if (localObject == null) {
          j.ebi();
        }
        ((RadarSpecialTableLayout)localObject).C(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
        this.mRect.setEmpty();
        break;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView
 * JD-Core Version:    0.7.0.1
 */