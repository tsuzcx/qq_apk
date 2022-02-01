package com.tencent.mm.plugin.radar.ui;

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
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView;", "Landroid/widget/ScrollView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "isLayoutChanged", "", "()Z", "isOverScroll", "mLastMotionY", "", "mRect", "Landroid/graphics/Rect;", "mRootChildView", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialTableLayout;", "mScrollInterpolator", "Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "mTranslateAnimation", "Landroid/view/animation/TranslateAnimation;", "onFinishInflate", "", "onTouchEvent", "ev", "Landroid/view/MotionEvent;", "scaleOverScroll", "", "offset", "startAnimation", "WorkspaceOvershootInterpolator", "plugin-radar_release"})
public class RadarSpecialSmoothScrollView
  extends ScrollView
{
  private float mLastMotionY;
  private final Rect mRect;
  private RadarSpecialTableLayout uTF;
  private TranslateAnimation uTG;
  private final a uTH;
  
  public RadarSpecialSmoothScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(138657);
    this.mRect = new Rect();
    this.uTH = new a();
    AppMethodBeat.o(138657);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(138655);
    if (getChildCount() > 0)
    {
      View localView2 = getChildAt(0);
      View localView1 = localView2;
      if (!(localView2 instanceof RadarSpecialTableLayout)) {
        localView1 = null;
      }
      this.uTF = ((RadarSpecialTableLayout)localView1);
    }
    AppMethodBeat.o(138655);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    int j = 1;
    AppMethodBeat.i(138656);
    k.h(paramMotionEvent, "ev");
    boolean bool;
    if (this.uTF == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(138656);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    label666:
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(138656);
      return bool;
      this.mLastMotionY = paramMotionEvent.getY();
      continue;
      float f = paramMotionEvent.getY();
      if (this.mLastMotionY == 0.0F) {
        this.mLastMotionY = f;
      }
      Object localObject = this.uTF;
      if (localObject == null) {
        k.fvU();
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
          localRadarSpecialTableLayout = this.uTF;
          if (localRadarSpecialTableLayout == null) {
            k.fvU();
          }
          j = localRadarSpecialTableLayout.getLeft();
          localRadarSpecialTableLayout = this.uTF;
          if (localRadarSpecialTableLayout == null) {
            k.fvU();
          }
          k = localRadarSpecialTableLayout.getTop();
          localRadarSpecialTableLayout = this.uTF;
          if (localRadarSpecialTableLayout == null) {
            k.fvU();
          }
          m = localRadarSpecialTableLayout.getRight();
          localRadarSpecialTableLayout = this.uTF;
          if (localRadarSpecialTableLayout == null) {
            k.fvU();
          }
          ((Rect)localObject).set(j, k, m, localRadarSpecialTableLayout.getBottom());
        }
        localObject = this.uTF;
        if (localObject == null) {
          k.fvU();
        }
        localRadarSpecialTableLayout = this.uTF;
        if (localRadarSpecialTableLayout == null) {
          k.fvU();
        }
        j = localRadarSpecialTableLayout.getLeft();
        localRadarSpecialTableLayout = this.uTF;
        if (localRadarSpecialTableLayout == null) {
          k.fvU();
        }
        k = localRadarSpecialTableLayout.getTop();
        m = i / 2;
        localRadarSpecialTableLayout = this.uTF;
        if (localRadarSpecialTableLayout == null) {
          k.fvU();
        }
        n = localRadarSpecialTableLayout.getRight();
        localRadarSpecialTableLayout = this.uTF;
        if (localRadarSpecialTableLayout == null) {
          k.fvU();
        }
        ((RadarSpecialTableLayout)localObject).F(j, k - m, n, localRadarSpecialTableLayout.getBottom() - i / 2);
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
        localObject = this.uTF;
        if (localObject == null) {
          k.fvU();
        }
        this.uTG = new TranslateAnimation(0.0F, 0.0F, ((RadarSpecialTableLayout)localObject).getTop() - this.mRect.top, 0.0F);
        localObject = this.uTG;
        if (localObject == null) {
          k.fvU();
        }
        ((TranslateAnimation)localObject).setInterpolator((Interpolator)this.uTH);
        localObject = this.uTG;
        if (localObject == null) {
          k.fvU();
        }
        localRadarSpecialTableLayout = this.uTF;
        if (localRadarSpecialTableLayout == null) {
          k.fvU();
        }
        ((TranslateAnimation)localObject).setDuration(Math.abs(localRadarSpecialTableLayout.getTop() - this.mRect.top));
        localObject = this.uTF;
        if (localObject == null) {
          k.fvU();
        }
        ((RadarSpecialTableLayout)localObject).startAnimation((Animation)this.uTG);
        localObject = this.uTF;
        if (localObject == null) {
          k.fvU();
        }
        ((RadarSpecialTableLayout)localObject).F(this.mRect.left, this.mRect.top, this.mRect.right, this.mRect.bottom);
        this.mRect.setEmpty();
        break;
        i = 0;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator;", "Landroid/view/animation/Interpolator;", "()V", "mTension", "", "getInterpolation", "t", "Companion", "plugin-radar_release"})
  static final class a
    implements Interpolator
  {
    private static final float uTJ = 1.3F;
    public static final a uTK;
    private final float uTI = uTJ;
    
    static
    {
      AppMethodBeat.i(138654);
      uTK = new a((byte)0);
      uTJ = 1.3F;
      AppMethodBeat.o(138654);
    }
    
    public final float getInterpolation(float paramFloat)
    {
      paramFloat -= 1.0F;
      return (paramFloat * (this.uTI + 1.0F) + this.uTI) * (paramFloat * paramFloat) + 1.0F;
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/radar/ui/RadarSpecialSmoothScrollView$WorkspaceOvershootInterpolator$Companion;", "", "()V", "DEFAULT_TENSION", "", "plugin-radar_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.ui.RadarSpecialSmoothScrollView
 * JD-Core Version:    0.7.0.1
 */