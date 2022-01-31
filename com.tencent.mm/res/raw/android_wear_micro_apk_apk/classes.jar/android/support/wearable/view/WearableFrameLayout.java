package android.support.wearable.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.wearable.k;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RemoteViews.RemoteView;
import java.util.ArrayList;

@RemoteViews.RemoteView
@TargetApi(21)
public class WearableFrameLayout
  extends ViewGroup
{
  private boolean EA = false;
  @ViewDebug.ExportedProperty(category="measurement")
  boolean Ek = false;
  @ViewDebug.ExportedProperty(category="drawing")
  private Drawable El;
  private ColorStateList Em = null;
  private PorterDuff.Mode En = null;
  private boolean Eo = false;
  private boolean Ep = false;
  @ViewDebug.ExportedProperty(category="padding")
  private int Eq = 0;
  @ViewDebug.ExportedProperty(category="padding")
  private int Er = 0;
  @ViewDebug.ExportedProperty(category="padding")
  private int Es = 0;
  @ViewDebug.ExportedProperty(category="padding")
  private int Et = 0;
  private final Rect Eu = new Rect();
  private final Rect Ev = new Rect();
  @ViewDebug.ExportedProperty(category="drawing")
  private int Ew = 119;
  @ViewDebug.ExportedProperty(category="drawing")
  private boolean Ex = true;
  boolean Ey = false;
  private final ArrayList<View> Ez = new ArrayList(1);
  
  public WearableFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WearableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private WearableFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, k.yi, paramInt, 0);
    this.Ew = paramContext.getInt(k.yl, this.Ew);
    paramAttributeSet = paramContext.getDrawable(k.yj);
    if (paramAttributeSet != null) {
      setForeground(paramAttributeSet);
    }
    if (paramContext.getBoolean(k.yk, false)) {
      this.Ek = true;
    }
    if (paramContext.hasValue(k.ym))
    {
      this.Em = paramContext.getColorStateList(k.ym);
      this.Eo = true;
    }
    paramContext.recycle();
    fz();
  }
  
  private int a(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.EC;
    }
    return paramLayoutParams.width;
  }
  
  private int b(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.ED;
    }
    return paramLayoutParams.height;
  }
  
  private int c(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.EE;
    }
    return paramLayoutParams.leftMargin;
  }
  
  private int d(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.EF;
    }
    return paramLayoutParams.topMargin;
  }
  
  private int e(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.EG;
    }
    return paramLayoutParams.rightMargin;
  }
  
  private int f(WearableFrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.EA) {
      return paramLayoutParams.EH;
    }
    return paramLayoutParams.bottomMargin;
  }
  
  private int fA()
  {
    if (this.Ex) {
      return Math.max(getPaddingLeft(), this.Eq);
    }
    return getPaddingLeft() + this.Eq;
  }
  
  private int fB()
  {
    if (this.Ex) {
      return Math.max(getPaddingRight(), this.Es);
    }
    return getPaddingRight() + this.Es;
  }
  
  private int fC()
  {
    if (this.Ex) {
      return Math.max(getPaddingTop(), this.Er);
    }
    return getPaddingTop() + this.Er;
  }
  
  private int fD()
  {
    if (this.Ex) {
      return Math.max(getPaddingBottom(), this.Et);
    }
    return getPaddingBottom() + this.Et;
  }
  
  private void fz()
  {
    if ((this.El != null) && ((this.Eo) || (this.Ep)))
    {
      this.El = this.El.mutate();
      if (this.Eo) {
        this.El.setTintList(this.Em);
      }
      if (this.Ep) {
        this.El.setTintMode(this.En);
      }
      if (this.El.isStateful()) {
        this.El.setState(getDrawableState());
      }
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof WearableFrameLayout.LayoutParams;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (this.El != null)
    {
      localDrawable = this.El;
      if (this.Ey)
      {
        this.Ey = false;
        localRect1 = this.Eu;
        localRect2 = this.Ev;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.Ex) {
          break label119;
        }
        localRect1.set(0, 0, i, j);
      }
    }
    for (;;)
    {
      i = getLayoutDirection();
      Gravity.apply(this.Ew, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2, i);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label119:
      localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }
  
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.El != null) {
      this.El.setHotspot(paramFloat1, paramFloat2);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.El != null) && (this.El.isStateful())) {
      this.El.setState(getDrawableState());
    }
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new WearableFrameLayout.LayoutParams((WearableFrameLayout.LayoutParams)paramLayoutParams);
  }
  
  public Drawable getForeground()
  {
    return this.El;
  }
  
  public int getForegroundGravity()
  {
    return this.Ew;
  }
  
  public ColorStateList getForegroundTintList()
  {
    return this.Em;
  }
  
  public PorterDuff.Mode getForegroundTintMode()
  {
    return this.En;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.El != null) {
      this.El.jumpToCurrentState();
    }
  }
  
  protected void measureChildWithMargins(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    WearableFrameLayout.LayoutParams localLayoutParams = (WearableFrameLayout.LayoutParams)paramView.getLayoutParams();
    paramView.measure(getChildMeasureSpec(paramInt1, getPaddingLeft() + getPaddingRight() + c(localLayoutParams) + e(localLayoutParams) + paramInt2, a(localLayoutParams)), getChildMeasureSpec(paramInt3, getPaddingTop() + getPaddingBottom() + d(localLayoutParams) + f(localLayoutParams) + paramInt4, b(localLayoutParams)));
  }
  
  public WindowInsets onApplyWindowInsets(WindowInsets paramWindowInsets)
  {
    if (this.EA != paramWindowInsets.isRound()) {}
    for (int i = 1;; i = 0)
    {
      this.EA = paramWindowInsets.isRound();
      if (i != 0) {
        requestLayout();
      }
      return super.onApplyWindowInsets(paramWindowInsets);
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
    paramAccessibilityEvent.setClassName(WearableFrameLayout.class.getName());
  }
  
  public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    paramAccessibilityNodeInfo.setClassName(WearableFrameLayout.class.getName());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = fA();
    int k = paramInt3 - paramInt1 - fB();
    int m = fC();
    int n = paramInt4 - paramInt2 - fD();
    this.Ey = true;
    paramInt3 = 0;
    if (paramInt3 < i)
    {
      View localView = getChildAt(paramInt3);
      WearableFrameLayout.LayoutParams localLayoutParams;
      int i1;
      int i2;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (WearableFrameLayout.LayoutParams)localView.getLayoutParams();
        i1 = localView.getMeasuredWidth();
        i2 = localView.getMeasuredHeight();
        if (!this.EA) {
          break label242;
        }
        paramInt1 = localLayoutParams.EB;
        label110:
        paramInt4 = paramInt1;
        if (paramInt1 == -1) {
          paramInt4 = 8388659;
        }
        switch (Gravity.getAbsoluteGravity(paramInt4, getLayoutDirection()) & 0x7)
        {
        default: 
          paramInt2 = c(localLayoutParams) + j;
          label170:
          switch (paramInt4 & 0x70)
          {
          default: 
            paramInt1 = d(localLayoutParams) + m;
          }
          break;
        }
      }
      for (;;)
      {
        localView.layout(paramInt2, paramInt1, i1 + paramInt2, i2 + paramInt1);
        paramInt3 += 1;
        break;
        label242:
        paramInt1 = localLayoutParams.gravity;
        break label110;
        paramInt2 = (k - j - i1) / 2 + j + c(localLayoutParams) - e(localLayoutParams);
        break label170;
        paramInt2 = k - i1 - e(localLayoutParams);
        break label170;
        paramInt1 = d(localLayoutParams) + m;
        continue;
        paramInt1 = (n - m - i2) / 2 + m + d(localLayoutParams) - f(localLayoutParams);
        continue;
        paramInt1 = n - i2 - f(localLayoutParams);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = getChildCount();
    int m;
    int j;
    int k;
    int n;
    label47:
    Object localObject;
    WearableFrameLayout.LayoutParams localLayoutParams;
    int i1;
    int i2;
    if ((View.MeasureSpec.getMode(paramInt1) != 1073741824) || (View.MeasureSpec.getMode(paramInt2) != 1073741824))
    {
      m = 1;
      this.Ez.clear();
      j = 0;
      k = 0;
      i = 0;
      n = 0;
      if (n >= i3) {
        break label237;
      }
      localObject = getChildAt(n);
      if ((!this.Ek) && (((View)localObject).getVisibility() == 8)) {
        break label582;
      }
      measureChildWithMargins((View)localObject, paramInt1, 0, paramInt2, 0);
      localLayoutParams = (WearableFrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      i1 = Math.max(k, ((View)localObject).getMeasuredWidth() + c(localLayoutParams) + e(localLayoutParams));
      i2 = Math.max(j, ((View)localObject).getMeasuredHeight() + d(localLayoutParams) + f(localLayoutParams));
      k = combineMeasuredStates(i, ((View)localObject).getMeasuredState());
      if ((m != 0) && ((a(localLayoutParams) == -1) || (b(localLayoutParams) == -1))) {
        this.Ez.add(localObject);
      }
      j = i1;
    }
    for (int i = i2;; i = i2)
    {
      i1 = n + 1;
      n = i;
      i = k;
      k = j;
      j = n;
      n = i1;
      break label47;
      m = 0;
      break;
      label237:
      n = fA();
      i1 = fB();
      m = Math.max(fC() + fD() + j, getSuggestedMinimumHeight());
      n = Math.max(n + i1 + k, getSuggestedMinimumWidth());
      localObject = getForeground();
      k = n;
      j = m;
      if (localObject != null)
      {
        j = Math.max(m, ((Drawable)localObject).getMinimumHeight());
        k = Math.max(n, ((Drawable)localObject).getMinimumWidth());
      }
      setMeasuredDimension(resolveSizeAndState(k, paramInt1, i), resolveSizeAndState(j, paramInt2, i << 16));
      m = this.Ez.size();
      if (m > 1)
      {
        i = 0;
        if (i < m)
        {
          localObject = (View)this.Ez.get(i);
          localLayoutParams = (WearableFrameLayout.LayoutParams)((View)localObject).getLayoutParams();
          if (a(localLayoutParams) == -1)
          {
            j = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth() - fA() - fB() - c(localLayoutParams) - e(localLayoutParams), 1073741824);
            label443:
            if (b(localLayoutParams) != -1) {
              break label543;
            }
          }
          label543:
          for (k = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() - fC() - fD() - d(localLayoutParams) - f(localLayoutParams), 1073741824);; k = getChildMeasureSpec(paramInt2, fC() + fD() + d(localLayoutParams) + f(localLayoutParams), b(localLayoutParams)))
          {
            ((View)localObject).measure(j, k);
            i += 1;
            break;
            j = getChildMeasureSpec(paramInt1, fA() + fB() + c(localLayoutParams) + e(localLayoutParams), a(localLayoutParams));
            break label443;
          }
        }
      }
      return;
      label582:
      i1 = k;
      i2 = j;
      k = i;
      j = i1;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.Ey = true;
  }
  
  public void setForeground(Drawable paramDrawable)
  {
    if (this.El != paramDrawable)
    {
      if (this.El != null)
      {
        this.El.setCallback(null);
        unscheduleDrawable(this.El);
      }
      this.El = paramDrawable;
      this.Eq = 0;
      this.Er = 0;
      this.Es = 0;
      this.Et = 0;
      if (paramDrawable == null) {
        break label156;
      }
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful()) {
        paramDrawable.setState(getDrawableState());
      }
      fz();
      if (this.Ew == 119)
      {
        Rect localRect = new Rect();
        if (paramDrawable.getPadding(localRect))
        {
          this.Eq = localRect.left;
          this.Er = localRect.top;
          this.Es = localRect.right;
          this.Et = localRect.bottom;
        }
      }
    }
    for (;;)
    {
      requestLayout();
      invalidate();
      return;
      label156:
      setWillNotDraw(true);
    }
  }
  
  public void setForegroundGravity(int paramInt)
  {
    if (this.Ew != paramInt)
    {
      if ((0x800007 & paramInt) != 0) {
        break label136;
      }
      paramInt = 0x800003 | paramInt;
    }
    label136:
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      this.Ew = i;
      Rect localRect;
      if ((this.Ew == 119) && (this.El != null))
      {
        localRect = new Rect();
        if (this.El.getPadding(localRect))
        {
          this.Eq = localRect.left;
          this.Er = localRect.top;
          this.Es = localRect.right;
        }
      }
      for (this.Et = localRect.bottom;; this.Et = 0)
      {
        requestLayout();
        return;
        this.Eq = 0;
        this.Er = 0;
        this.Es = 0;
      }
    }
  }
  
  public void setForegroundTintList(ColorStateList paramColorStateList)
  {
    this.Em = paramColorStateList;
    this.Eo = true;
    fz();
  }
  
  public void setForegroundTintMode(PorterDuff.Mode paramMode)
  {
    this.En = paramMode;
    this.Ep = true;
    fz();
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    Drawable localDrawable;
    if (this.El != null)
    {
      localDrawable = this.El;
      if (paramInt != 0) {
        break label31;
      }
    }
    label31:
    for (boolean bool = true;; bool = false)
    {
      localDrawable.setVisible(bool, false);
      return;
    }
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return false;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.El);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.wearable.view.WearableFrameLayout
 * JD-Core Version:    0.7.0.1
 */