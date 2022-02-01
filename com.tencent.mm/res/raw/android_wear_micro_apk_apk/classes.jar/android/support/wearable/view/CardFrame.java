package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.support.wearable.f;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

@TargetApi(20)
public class CardFrame
  extends ViewGroup
{
  private static float Cl = 0.146467F;
  private boolean Cm;
  private boolean Cn = true;
  private float Co = 1.0F;
  private int Cp = 1;
  private final int Cq;
  private final Rect Cr = new Rect();
  private int Cs;
  private boolean Ct;
  private int Cu;
  private final Rect Cv = new Rect();
  private final Rect Cw = new Rect();
  private boolean Cx;
  private final d Cy = new d();
  
  public CardFrame(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CardFrame(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.Cq = ((int)(40.0F * f));
    setBackgroundResource(f.yi);
    paramInt = (int)(12.0F * f);
    int i = (int)(f * 8.0F);
    this.Cw.set(paramInt, i, paramInt, paramInt);
    requestLayout();
  }
  
  private static int b(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    switch (i)
    {
    case 0: 
    default: 
    case -2147483648: 
      do
      {
        return paramInt1;
      } while (!paramBoolean);
      return paramInt2;
    }
    return paramInt2;
  }
  
  public void addView(View paramView)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("CardFrame can host only one direct child");
    }
    super.addView(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("CardFrame can host only one direct child");
    }
    super.addView(paramView, paramInt);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("CardFrame can host only one direct child");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (getChildCount() > 0) {
      throw new IllegalStateException("CardFrame can host only one direct child");
    }
    super.addView(paramView, paramLayoutParams);
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int m = this.Cq;
    int j = 0;
    this.Cr.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
    int k = getPaddingTop() + getPaddingBottom();
    int n = paramView.getHeight();
    int i = j;
    if (this.Cm) {
      if ((this.Cp == -1) && (n + k > getHeight()))
      {
        this.Cr.top = getPaddingTop();
        i = 1;
        j = 0;
      }
    }
    for (;;)
    {
      k = paramCanvas.getSaveCount();
      paramCanvas.clipRect(this.Cr);
      if (i != 0) {
        paramCanvas.saveLayer(this.Cr.left, this.Cr.top, this.Cr.right, this.Cr.top + m, null, 4);
      }
      if (j != 0) {
        paramCanvas.saveLayer(this.Cr.left, this.Cr.bottom - m, this.Cr.right, this.Cr.bottom, null, 4);
      }
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      if (i != 0)
      {
        d.a(this.Cy).reset();
        d.a(this.Cy).setScale(1.0F, m);
        d.a(this.Cy).postTranslate(this.Cr.left, this.Cr.top);
        d.b(this.Cy).setLocalMatrix(d.a(this.Cy));
        d.c(this.Cy).setShader(d.b(this.Cy));
        paramCanvas.drawRect(this.Cr.left, this.Cr.top, this.Cr.right, this.Cr.top + m, d.c(this.Cy));
      }
      if (j != 0)
      {
        d.a(this.Cy).reset();
        d.a(this.Cy).setScale(1.0F, m);
        d.a(this.Cy).postRotate(180.0F);
        d.a(this.Cy).postTranslate(this.Cr.left, this.Cr.bottom);
        d.b(this.Cy).setLocalMatrix(d.a(this.Cy));
        d.c(this.Cy).setShader(d.b(this.Cy));
        paramCanvas.drawRect(this.Cr.left, this.Cr.bottom - m, this.Cr.right, this.Cr.bottom, d.c(this.Cy));
      }
      paramCanvas.restoreToCount(k);
      return bool;
      i = j;
      if (this.Cp == 1)
      {
        i = j;
        if (k + n > getHeight())
        {
          i = 1;
          this.Cr.bottom = (getHeight() - getPaddingBottom());
        }
      }
      k = 0;
      j = i;
      i = k;
    }
  }
  
  public final int fa()
  {
    return this.Cp;
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    boolean bool = paramWindowInsets.isRound();
    if (bool != this.Ct)
    {
      this.Ct = bool;
      requestLayout();
    }
    if (paramWindowInsets.getSystemWindowInsetBottom() > 0) {}
    for (bool = true;; bool = false)
    {
      if (bool != this.Cx)
      {
        this.Cx = bool;
        requestLayout();
      }
      return paramWindowInsets.consumeSystemWindowInsets();
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    requestApplyInsets();
  }
  
  public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    super.onInitializeAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(CardFrame.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(CardFrame.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (getChildCount() == 0) {
      return;
    }
    View localView = getChildAt(0);
    paramInt1 = paramInt4 - paramInt2;
    paramInt2 = getPaddingLeft();
    paramInt3 = this.Cv.left;
    paramInt3 = this.Cw.left + (paramInt2 + paramInt3);
    paramInt4 = localView.getMeasuredWidth();
    if (this.Cp == -1) {
      paramInt2 = paramInt1 - (localView.getMeasuredHeight() + getPaddingBottom() + this.Cv.bottom + this.Cw.bottom);
    }
    for (;;)
    {
      localView.layout(paramInt3, paramInt2, paramInt3 + paramInt4, paramInt1);
      return;
      paramInt1 = getPaddingTop();
      paramInt2 = this.Cv.top;
      paramInt2 = this.Cw.top + (paramInt1 + paramInt2);
      paramInt1 = localView.getMeasuredHeight() + paramInt2;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = 1;
    int i = View.MeasureSpec.getSize(paramInt1);
    int n = View.MeasureSpec.getSize(paramInt2);
    Object localObject;
    int j;
    if (this.Ct)
    {
      localObject = (ViewGroup.MarginLayoutParams)getLayoutParams();
      this.Cv.setEmpty();
      if (((ViewGroup.MarginLayoutParams)localObject).leftMargin >= 0) {
        break label636;
      }
      j = -((ViewGroup.MarginLayoutParams)localObject).leftMargin;
      i -= j;
    }
    for (;;)
    {
      int k;
      if (((ViewGroup.MarginLayoutParams)localObject).rightMargin < 0)
      {
        k = -((ViewGroup.MarginLayoutParams)localObject).rightMargin;
        i -= k;
      }
      for (;;)
      {
        int m;
        if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin < 0)
        {
          m = -((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
          n -= m;
        }
        for (;;)
        {
          float f = Cl;
          this.Cu = ((int)(Math.max(i, n) * f));
          this.Cv.left = (this.Cu - (getPaddingLeft() - j));
          this.Cv.right = (this.Cu - (getPaddingRight() - k));
          if (!this.Cx) {
            this.Cv.bottom = (this.Cu - (getPaddingBottom() - m));
          }
          k = b(getSuggestedMinimumWidth(), paramInt1, true);
          paramInt1 = b(getSuggestedMinimumHeight(), paramInt2, false);
          if (getChildCount() == 0)
          {
            setMeasuredDimension(k, paramInt1);
            return;
          }
          localObject = getChildAt(0);
          paramInt1 = View.MeasureSpec.getSize(paramInt2);
          paramInt2 = View.MeasureSpec.getMode(paramInt2);
          this.Cm = this.Cn;
          if ((paramInt2 == 0) || (paramInt1 == 0))
          {
            Log.w("CardFrame", "height measure spec passed with mode UNSPECIFIED, or zero height.");
            this.Cm = false;
            this.Cs = 0;
            j = 0;
            paramInt1 = 1;
            paramInt2 = 0;
            i = 0;
          }
          for (;;)
          {
            n = getPaddingLeft();
            int i2 = getPaddingRight();
            int i3 = this.Cw.left;
            int i4 = this.Cw.right;
            int i5 = this.Cv.left;
            int i6 = this.Cv.right;
            m = getPaddingTop() + getPaddingBottom() + this.Cw.top + this.Cw.bottom + this.Cv.top + this.Cv.bottom;
            n = View.MeasureSpec.makeMeasureSpec(k - (n + i2 + i3 + i4 + i5 + i6), 1073741824);
            paramInt2 = View.MeasureSpec.makeMeasureSpec(i - m, paramInt2);
            ((View)localObject).measure(getChildMeasureSpec(n, 0, ((View)localObject).getLayoutParams().width), paramInt2);
            if (paramInt1 == 0) {
              break;
            }
            paramInt1 = ((View)localObject).getMeasuredHeight() + m;
            setMeasuredDimension(k, paramInt1);
            return;
            if (paramInt2 == 1073741824)
            {
              Log.w("CardFrame", "height measure spec passed with mode EXACT");
              this.Cm = false;
              this.Cs = paramInt1;
              i = this.Cs;
              j = i;
              paramInt1 = 0;
              paramInt2 = 1073741824;
            }
            else
            {
              this.Cs = paramInt1;
              paramInt1 = this.Cs;
              j = paramInt1;
              if (this.Cm) {
                j = (int)(paramInt1 * this.Co);
              }
              if (this.Cp == -1)
              {
                paramInt1 = 0;
                paramInt2 = 0;
                i = 0;
              }
              else
              {
                i = j + getPaddingBottom();
                paramInt1 = 0;
                paramInt2 = -2147483648;
              }
            }
          }
          paramInt2 = Math.min(j, ((View)localObject).getMeasuredHeight() + m);
          int i7 = this.Cm;
          if (((View)localObject).getMeasuredHeight() > paramInt2 - m) {}
          for (paramInt1 = i1;; paramInt1 = 0)
          {
            this.Cm = (i7 & paramInt1);
            paramInt1 = paramInt2;
            break;
          }
          m = 0;
        }
        k = 0;
      }
      label636:
      j = 0;
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.CardFrame
 * JD-Core Version:    0.7.0.1
 */