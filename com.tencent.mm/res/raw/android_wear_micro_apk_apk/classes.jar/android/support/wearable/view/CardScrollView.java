package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

@TargetApi(20)
public class CardScrollView
  extends FrameLayout
{
  private CardFrame CC;
  private final int CD = (int)(8.0F * getResources().getDisplayMetrics().density);
  private boolean Ct;
  
  public CardScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((getChildCount() > 0) || (!(paramView instanceof CardFrame))) {
      throw new IllegalStateException("CardScrollView may contain only a single CardFrame.");
    }
    super.addView(paramView, paramInt, paramLayoutParams);
    this.CC = ((CardFrame)paramView);
  }
  
  public final int bk(int paramInt)
  {
    int i;
    if (this.CC == null)
    {
      Log.w("CardScrollView", "No CardFrame has been added.");
      i = 0;
      if (i != 0) {
        break label28;
      }
    }
    label28:
    do
    {
      return 0;
      i = 1;
      break;
      i = getPaddingTop();
      j = getPaddingBottom();
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.CC.getLayoutParams();
      int k = localLayoutParams.topMargin;
      i = localLayoutParams.bottomMargin + k + (j + i + this.CC.getMeasuredHeight());
    } while (i <= getMeasuredHeight());
    i -= getMeasuredHeight();
    int j = getScrollY();
    if (this.CC.fa() == 1)
    {
      if (j < 0) {
        break label209;
      }
      if (paramInt < 0) {
        paramInt = -j;
      }
    }
    for (;;)
    {
      if (Log.isLoggable("CardScrollView", 3)) {
        Log.d("CardScrollView", "getVerticalScrollableDistance: " + Math.max(0, paramInt));
      }
      return paramInt;
      if (paramInt > 0)
      {
        paramInt = Math.max(0, i - j);
        continue;
        if ((this.CC.fa() == -1) && (j <= 0))
        {
          if (paramInt > 0)
          {
            paramInt = -j;
            continue;
          }
          if (paramInt < 0)
          {
            paramInt = -(i + j);
            continue;
          }
        }
      }
      label209:
      paramInt = 0;
    }
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    return false;
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    boolean bool = paramWindowInsets.isRound();
    Object localObject;
    if (this.Ct != bool)
    {
      this.Ct = bool;
      localObject = (FrameLayout.LayoutParams)this.CC.getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).leftMargin = (-this.CD);
      ((FrameLayout.LayoutParams)localObject).rightMargin = (-this.CD);
      ((FrameLayout.LayoutParams)localObject).bottomMargin = (-this.CD);
      this.CC.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    if (paramWindowInsets.getSystemWindowInsetBottom() > 0)
    {
      int i = paramWindowInsets.getSystemWindowInsetBottom();
      localObject = getLayoutParams();
      if ((localObject instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = i;
      }
    }
    if ((this.Ct) && (this.CC != null)) {
      this.CC.onApplyWindowInsets(paramWindowInsets);
    }
    requestLayout();
    return paramWindowInsets;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    requestApplyInsets();
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    if ((getChildCount() == 0) || (!(getChildAt(0) instanceof CardFrame))) {
      Log.w("CardScrollView", "No CardFrame has been added!");
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt1 = 1;
    int i;
    if (this.CC != null)
    {
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.CC.getLayoutParams();
      i = this.CC.getMeasuredHeight();
      paramInt3 = this.CC.getMeasuredWidth();
      int j = paramInt4 - paramInt2;
      if (getPaddingTop() + i + localLayoutParams.topMargin > j) {
        break label148;
      }
      if ((localLayoutParams.gravity & 0x70) != 80) {
        break label143;
      }
      paramInt4 = getPaddingLeft() + localLayoutParams.leftMargin;
      paramInt2 = getPaddingTop();
      paramInt2 = localLayoutParams.topMargin + paramInt2;
      if (paramInt1 == 0) {
        break label164;
      }
      paramInt1 = getPaddingBottom();
      paramInt1 = j - (localLayoutParams.bottomMargin + paramInt1);
      paramInt2 = paramInt1 - i;
    }
    for (;;)
    {
      this.CC.layout(paramInt4, paramInt2, paramInt3 + paramInt4, paramInt1);
      return;
      label143:
      paramInt1 = 0;
      break;
      label148:
      if (this.CC.fa() == -1) {
        break;
      }
      paramInt1 = 0;
      break;
      label164:
      paramInt1 = paramInt2 + i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.CC != null)
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.CC.getLayoutParams();
      int i1 = getPaddingLeft();
      int i2 = getPaddingRight();
      int i = getPaddingTop();
      int j = getPaddingBottom();
      int k = View.MeasureSpec.getSize(paramInt2);
      int i3 = View.MeasureSpec.getSize(paramInt1);
      int i4 = localMarginLayoutParams.leftMargin;
      int i5 = localMarginLayoutParams.rightMargin;
      int m = localMarginLayoutParams.topMargin;
      int n = localMarginLayoutParams.bottomMargin;
      i1 = View.MeasureSpec.makeMeasureSpec(i3 - (i1 + i2) - (i4 + i5), 1073741824);
      i = View.MeasureSpec.makeMeasureSpec(k - (i + j) - (n + m), -2147483648);
      this.CC.measure(i1, i);
    }
    setMeasuredDimension(getDefaultSize(getSuggestedMinimumWidth(), paramInt1), getDefaultSize(getSuggestedMinimumWidth(), paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.CardScrollView
 * JD-Core Version:    0.7.0.1
 */