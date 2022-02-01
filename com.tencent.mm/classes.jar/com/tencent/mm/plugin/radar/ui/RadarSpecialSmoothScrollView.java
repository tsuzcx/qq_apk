package com.tencent.mm.plugin.radar.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLayoutChanged", "", "()Z", "isOverScroll", "mLastMotionY", "", "mRect", "Landroid/graphics/Rect;", "mRootChildView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "mScrollInterpolator", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "mTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "onFinishInflate", "", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "scaleOverScroll", "", "offset", "startAnimation", "WorkspaceOvershootInterpolator", "plugin-radar_release"}, k=1, mv={1, 5, 1}, xi=48)
public class RadarSpecialSmoothScrollView
  extends ScrollView
{
  private RadarSpecialTableLayout Ntg;
  private TranslateAnimation Nth;
  private final RadarSpecialSmoothScrollView.a Nti;
  private float mLastMotionY;
  private final Rect mRect;
  
  public RadarSpecialSmoothScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138657);
    this.mRect = new Rect();
    this.Nti = new RadarSpecialSmoothScrollView.a();
    AppMethodBeat.o(138657);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(138655);
    if (getChildCount() > 0)
    {
      localObject = getChildAt(0);
      if (!(localObject instanceof RadarSpecialTableLayout)) {
        break label41;
      }
    }
    label41:
    for (Object localObject = (RadarSpecialTableLayout)localObject;; localObject = null)
    {
      this.Ntg = ((RadarSpecialTableLayout)localObject);
      AppMethodBeat.o(138655);
      return;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(138656);
    s.u(paramMotionEvent, "ev");
    boolean bool;
    if (this.Ntg == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(138656);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label110:
    label629:
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(138656);
      return bool;
      this.mLastMotionY = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY();
      Object localObject;
      RadarSpecialTableLayout localRadarSpecialTableLayout;
      if (this.mLastMotionY == 0.0F)
      {
        i = 1;
        if (i != 0) {
          this.mLastMotionY = f;
        }
        localObject = this.Ntg;
        s.checkNotNull(localObject);
        int k = ((RadarSpecialTableLayout)localObject).getMeasuredHeight();
        int m = getHeight();
        int n = getScrollY();
        i = j;
        if (n != 0)
        {
          if (n != k - m) {
            break label402;
          }
          i = j;
        }
        if (i == 0) {
          break label407;
        }
        i = (int)(this.mLastMotionY - f);
        scrollBy(0, i);
        if (this.mRect.isEmpty())
        {
          localObject = this.mRect;
          localRadarSpecialTableLayout = this.Ntg;
          s.checkNotNull(localRadarSpecialTableLayout);
          j = localRadarSpecialTableLayout.getLeft();
          localRadarSpecialTableLayout = this.Ntg;
          s.checkNotNull(localRadarSpecialTableLayout);
          k = localRadarSpecialTableLayout.getTop();
          localRadarSpecialTableLayout = this.Ntg;
          s.checkNotNull(localRadarSpecialTableLayout);
          m = localRadarSpecialTableLayout.getRight();
          localRadarSpecialTableLayout = this.Ntg;
          s.checkNotNull(localRadarSpecialTableLayout);
          ((Rect)localObject).set(j, k, m, localRadarSpecialTableLayout.getBottom());
        }
        localObject = this.Ntg;
        s.checkNotNull(localObject);
        localRadarSpecialTableLayout = this.Ntg;
        s.checkNotNull(localRadarSpecialTableLayout);
        j = localRadarSpecialTableLayout.getLeft();
        localRadarSpecialTableLayout = this.Ntg;
        s.checkNotNull(localRadarSpecialTableLayout);
        k = localRadarSpecialTableLayout.getTop();
        m = i / 2;
        localRadarSpecialTableLayout = this.Ntg;
        s.checkNotNull(localRadarSpecialTableLayout);
        n = localRadarSpecialTableLayout.getRight();
        localRadarSpecialTableLayout = this.Ntg;
        s.checkNotNull(localRadarSpecialTableLayout);
        ((RadarSpecialTableLayout)localObject).T(j, k - m, n, localRadarSpecialTableLayout.getBottom() - i / 2);
      }
      for (;;)
      {
        this.mLastMotionY = f;
        break;
        i = 0;
        break label110;
        i = 0;
        break label170;
        scrollBy(0, (int)(this.mLastMotionY - f) / 2);
      }
      this.mLastMotionY = 0.0F;
      if (!this.mRect.isEmpty()) {}
      for (;;)
      {
        if (i == 0) {
          break label629;
        }
        localObject = this.Ntg;
        s.checkNotNull(localObject);
        this.Nth = new TranslateAnimation(0.0F, 0.0F, ((RadarSpecialTableLayout)localObject).getTop() - this.mRect.top, 0.0F);
        localObject = this.Nth;
        s.checkNotNull(localObject);
        ((TranslateAnimation)localObject).setInterpolator((Interpolator)this.Nti);
        localObject = this.Nth;
        s.checkNotNull(localObject);
        localRadarSpecialTableLayout = this.Ntg;
        s.checkNotNull(localRadarSpecialTableLayout);
        ((TranslateAnimation)localObject).setDuration(Math.abs(localRadarSpecialTableLayout.getTop() - this.mRect.top));
        localObject = this.Ntg;
        s.checkNotNull(localObject);
        ((RadarSpecialTableLayout)localObject).startAnimation((Animation)this.Nth);
        localObject = this.Ntg;
        s.checkNotNull(localObject);
        ((RadarSpecialTableLayout)localObject).T(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
        this.mRect.setEmpty();
        break;
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView
 * JD-Core Version:    0.7.0.1
 */