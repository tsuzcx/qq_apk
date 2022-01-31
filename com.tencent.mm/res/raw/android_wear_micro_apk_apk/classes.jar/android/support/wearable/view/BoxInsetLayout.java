package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;

@TargetApi(20)
public class BoxInsetLayout
  extends FrameLayout
{
  private static float Ar = 0.146467F;
  private Rect As;
  private boolean At;
  private Rect Au;
  
  public BoxInsetLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BoxInsetLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (this.As == null) {
      this.As = new Rect();
    }
    if (this.Au == null) {
      this.Au = new Rect();
    }
  }
  
  private BoxInsetLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new BoxInsetLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof BoxInsetLayout.LayoutParams;
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new BoxInsetLayout.LayoutParams(paramLayoutParams);
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    paramWindowInsets = super.onApplyWindowInsets(paramWindowInsets);
    if (Build.VERSION.SDK_INT < 23)
    {
      boolean bool = paramWindowInsets.isRound();
      if (bool != this.At)
      {
        this.At = bool;
        requestLayout();
      }
      this.Au.set(paramWindowInsets.getSystemWindowInsetLeft(), paramWindowInsets.getSystemWindowInsetTop(), paramWindowInsets.getSystemWindowInsetRight(), paramWindowInsets.getSystemWindowInsetBottom());
    }
    return paramWindowInsets;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (Build.VERSION.SDK_INT < 23)
    {
      requestApplyInsets();
      return;
    }
    this.At = getResources().getConfiguration().isScreenRound();
    WindowInsets localWindowInsets = getRootWindowInsets();
    this.Au.set(localWindowInsets.getSystemWindowInsetLeft(), localWindowInsets.getSystemWindowInsetTop(), localWindowInsets.getSystemWindowInsetRight(), localWindowInsets.getSystemWindowInsetBottom());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = getPaddingLeft() + this.As.left;
    int k = paramInt3 - paramInt1 - getPaddingRight() - this.As.right;
    int m = getPaddingTop() + this.As.top;
    paramInt4 = paramInt4 - paramInt2 - getPaddingBottom() - this.As.bottom;
    paramInt3 = 0;
    if (paramInt3 < i)
    {
      View localView = getChildAt(paramInt3);
      BoxInsetLayout.LayoutParams localLayoutParams;
      int n;
      int i1;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (BoxInsetLayout.LayoutParams)localView.getLayoutParams();
        n = localView.getMeasuredWidth();
        i1 = localView.getMeasuredHeight();
        paramInt1 = localLayoutParams.gravity;
        paramInt2 = paramInt1;
        if (paramInt1 == -1) {
          paramInt2 = 8388659;
        }
        paramInt1 = Gravity.getAbsoluteGravity(paramInt2, getLayoutDirection());
        if (localLayoutParams.width != -1) {}
        switch (paramInt1 & 0x7)
        {
        default: 
          paramInt1 = localLayoutParams.leftMargin + j;
          label197:
          if (localLayoutParams.height != -1) {}
          switch (paramInt2 & 0x70)
          {
          default: 
            paramInt2 = localLayoutParams.topMargin + m;
          }
          break;
        }
      }
      for (;;)
      {
        localView.layout(paramInt1, paramInt2, n + paramInt1, i1 + paramInt2);
        paramInt3 += 1;
        break;
        paramInt1 = (k - j - n) / 2 + j + localLayoutParams.leftMargin - localLayoutParams.rightMargin;
        break label197;
        paramInt1 = k - n - localLayoutParams.rightMargin;
        break label197;
        paramInt2 = (paramInt4 - m - i1) / 2 + m + localLayoutParams.topMargin - localLayoutParams.bottomMargin;
        continue;
        paramInt2 = paramInt4 - i1 - localLayoutParams.bottomMargin;
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i6 = getChildCount();
    int n = 0;
    int i1 = 0;
    int m = 0;
    int i3 = 0;
    Object localObject;
    BoxInsetLayout.LayoutParams localLayoutParams;
    int i;
    int j;
    int k;
    int i5;
    int i4;
    int i2;
    if (i3 < i6)
    {
      localObject = getChildAt(i3);
      if (((View)localObject).getVisibility() == 8) {
        break label943;
      }
      localLayoutParams = (BoxInsetLayout.LayoutParams)((View)localObject).getLayoutParams();
      i = 0;
      j = 0;
      k = 0;
      if (this.At)
      {
        if ((localLayoutParams.Av & 0x1) == 0) {
          i = localLayoutParams.leftMargin;
        }
        if ((localLayoutParams.Av & 0x4) == 0) {
          j = localLayoutParams.rightMargin;
        }
        if ((localLayoutParams.Av & 0x2) == 0) {
          k = localLayoutParams.topMargin;
        }
        if ((localLayoutParams.Av & 0x8) != 0) {
          break label915;
        }
        i5 = localLayoutParams.bottomMargin;
        i4 = k;
        i2 = i;
        k = j;
        j = i4;
        i = i5;
        label154:
        measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
        k = Math.max(n, ((View)localObject).getMeasuredWidth() + i2 + k);
        j = Math.max(i1, ((View)localObject).getMeasuredHeight() + j + i);
        m = combineMeasuredStates(m, ((View)localObject).getMeasuredState());
        i = k;
        k = m;
      }
    }
    for (;;)
    {
      i3 += 1;
      m = k;
      i1 = j;
      n = i;
      break;
      i2 = localLayoutParams.leftMargin;
      j = localLayoutParams.topMargin;
      k = localLayoutParams.rightMargin;
      i = localLayoutParams.bottomMargin;
      break label154;
      i = getPaddingLeft();
      j = this.As.left;
      i2 = getPaddingRight();
      i3 = this.As.right;
      k = Math.max(getPaddingTop() + this.As.top + getPaddingBottom() + this.As.bottom + i1, getSuggestedMinimumHeight());
      n = Math.max(n + (i + j + i2 + i3), getSuggestedMinimumWidth());
      localObject = getForeground();
      j = k;
      i = n;
      if (localObject != null)
      {
        j = Math.max(k, ((Drawable)localObject).getMinimumHeight());
        i = Math.max(n, ((Drawable)localObject).getMinimumWidth());
      }
      setMeasuredDimension(resolveSizeAndState(i, paramInt1, m), resolveSizeAndState(j, paramInt2, m << 16));
      i2 = (int)(Ar * Math.max(getMeasuredWidth(), getMeasuredHeight()));
      i = 0;
      while (i < i6)
      {
        localObject = getChildAt(i);
        localLayoutParams = (BoxInsetLayout.LayoutParams)((View)localObject).getLayoutParams();
        k = localLayoutParams.gravity;
        j = k;
        if (k == -1) {
          j = 8388659;
        }
        i3 = j & 0x70;
        int i9 = j & 0x7;
        int i7 = localLayoutParams.leftMargin + getPaddingLeft() + this.As.left;
        int i8 = localLayoutParams.rightMargin + getPaddingRight() + this.As.right;
        i4 = localLayoutParams.topMargin + getPaddingTop() + this.As.top;
        i5 = localLayoutParams.bottomMargin + getPaddingBottom() + this.As.bottom;
        k = ((View)localObject).getPaddingLeft();
        m = ((View)localObject).getPaddingRight();
        i1 = ((View)localObject).getPaddingBottom();
        n = ((View)localObject).getPaddingTop();
        j = k;
        if (this.At)
        {
          j = k;
          if ((localLayoutParams.Av & 0x1) != 0) {
            if (localLayoutParams.width != -1)
            {
              j = k;
              if (i9 != 3) {}
            }
            else
            {
              j = Math.max(Math.max(0, i2 - i7), k);
            }
          }
        }
        k = m;
        if (this.At)
        {
          k = m;
          if ((localLayoutParams.Av & 0x4) != 0) {
            if (localLayoutParams.width != -1)
            {
              k = m;
              if (i9 != 5) {}
            }
            else
            {
              k = Math.max(Math.max(0, i2 - i8), m);
            }
          }
        }
        i7 = getChildMeasureSpec(paramInt1, i7 + 0 + i8, localLayoutParams.width);
        m = n;
        if (this.At)
        {
          m = n;
          if ((localLayoutParams.Av & 0x2) != 0) {
            if (localLayoutParams.height != -1)
            {
              m = n;
              if (i3 != 48) {}
            }
            else
            {
              m = Math.max(Math.max(0, i2 - i4), n);
            }
          }
        }
        n = i1;
        if (this.At)
        {
          n = i1;
          if ((localLayoutParams.Av & 0x8) != 0) {
            if (localLayoutParams.height != -1)
            {
              n = i1;
              if (i3 != 80) {}
            }
            else
            {
              n = Math.max(Math.max(0, i2 - i5), i1);
            }
          }
        }
        i1 = getChildMeasureSpec(paramInt2, i4 + 0 + i5, localLayoutParams.height);
        ((View)localObject).setPadding(j, m, k, n);
        ((View)localObject).measure(i7, i1);
        i += 1;
      }
      return;
      label915:
      i5 = 0;
      i2 = j;
      i4 = i;
      i = i5;
      j = k;
      k = i2;
      i2 = i4;
      break label154;
      label943:
      k = m;
      j = i1;
      i = n;
    }
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    super.setForeground(paramDrawable);
    if (this.As == null) {
      this.As = new Rect();
    }
    paramDrawable.getPadding(this.As);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.BoxInsetLayout
 * JD-Core Version:    0.7.0.1
 */