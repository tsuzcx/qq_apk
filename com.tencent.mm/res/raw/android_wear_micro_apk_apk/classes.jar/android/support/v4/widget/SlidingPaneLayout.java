package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import java.util.ArrayList;

public class SlidingPaneLayout
  extends ViewGroup
{
  static final p pG = new q();
  private float kj;
  private float kk;
  private boolean lI = true;
  boolean lu;
  private final Rect oI = new Rect();
  private float pA;
  int pB;
  private int pC;
  final ac pD;
  boolean pE;
  final ArrayList<n> pF = new ArrayList();
  private int ps = -858993460;
  private int pt;
  private Drawable pu;
  private Drawable pv;
  private final int pw;
  private boolean px;
  View py;
  float pz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      pG = new s();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      pG = new r();
      return;
    }
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SlidingPaneLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    float f = paramContext.getResources().getDisplayMetrics().density;
    this.pw = ((int)(32.0F * f + 0.5F));
    setWillNotDraw(false);
    android.support.v4.view.r.a(this, new m(this));
    android.support.v4.view.r.c(this, 1);
    this.pD = ac.a(this, 0.5F, new o(this));
    this.pD.o(f * 400.0F);
  }
  
  private void a(View paramView, float paramFloat, int paramInt)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    if ((paramFloat > 0.0F) && (paramInt != 0))
    {
      i = (int)(((0xFF000000 & paramInt) >>> 24) * paramFloat);
      if (localLayoutParams.pL == null) {
        localLayoutParams.pL = new Paint();
      }
      localLayoutParams.pL.setColorFilter(new PorterDuffColorFilter(i << 24 | 0xFFFFFF & paramInt, PorterDuff.Mode.SRC_OVER));
      if (paramView.getLayerType() != 2) {
        paramView.setLayerType(2, localLayoutParams.pL);
      }
      Q(paramView);
    }
    while (paramView.getLayerType() == 0)
    {
      int i;
      return;
    }
    if (localLayoutParams.pL != null) {
      localLayoutParams.pL.setColorFilter(null);
    }
    paramView = new n(this, paramView);
    this.pF.add(paramView);
    android.support.v4.view.r.b(this, paramView);
  }
  
  private boolean cp()
  {
    boolean bool = false;
    if ((this.lI) || (h(0.0F)))
    {
      this.pE = false;
      bool = true;
    }
    return bool;
  }
  
  private boolean h(float paramFloat)
  {
    if (!this.px) {
      return false;
    }
    boolean bool = cq();
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.py.getLayoutParams();
    int j;
    int k;
    if (bool)
    {
      i = getPaddingRight();
      j = localLayoutParams.rightMargin;
      k = this.py.getWidth();
    }
    for (int i = (int)(getWidth() - (j + i + this.pB * paramFloat + k)); this.pD.b(this.py, i, this.py.getTop()); i = (int)(localLayoutParams.leftMargin + i + this.pB * paramFloat))
    {
      co();
      android.support.v4.view.r.f(this);
      return true;
      i = getPaddingLeft();
    }
    return false;
  }
  
  private void i(float paramFloat)
  {
    boolean bool = cq();
    Object localObject = (SlidingPaneLayout.LayoutParams)this.py.getLayoutParams();
    int i;
    label43:
    int j;
    if (((SlidingPaneLayout.LayoutParams)localObject).pK) {
      if (bool)
      {
        i = ((SlidingPaneLayout.LayoutParams)localObject).rightMargin;
        if (i > 0) {
          break label177;
        }
        i = 1;
        int n = getChildCount();
        j = 0;
        label52:
        if (j >= n) {
          return;
        }
        localObject = getChildAt(j);
        if (localObject != this.py)
        {
          int k = (int)((1.0F - this.pA) * this.pC);
          this.pA = paramFloat;
          int m = k - (int)((1.0F - paramFloat) * this.pC);
          k = m;
          if (bool) {
            k = -m;
          }
          ((View)localObject).offsetLeftAndRight(k);
          if (i != 0) {
            if (!bool) {
              break label182;
            }
          }
        }
      }
    }
    label177:
    label182:
    for (float f = this.pA - 1.0F;; f = 1.0F - this.pA)
    {
      a((View)localObject, f, this.pt);
      j += 1;
      break label52;
      i = ((SlidingPaneLayout.LayoutParams)localObject).leftMargin;
      break;
      i = 0;
      break label43;
    }
  }
  
  final void P(View paramView)
  {
    boolean bool = cq();
    int i;
    int j;
    label31:
    int k;
    label63:
    int i1;
    int n;
    int m;
    label92:
    int i2;
    label101:
    Object localObject;
    if (bool)
    {
      i = getWidth() - getPaddingRight();
      if (!bool) {
        break label254;
      }
      j = getPaddingLeft();
      int i4 = getPaddingTop();
      int i5 = getHeight();
      int i6 = getPaddingBottom();
      if (paramView == null) {
        break label313;
      }
      if (!paramView.isOpaque()) {
        break label267;
      }
      k = 1;
      if (k == 0) {
        break label313;
      }
      i1 = paramView.getLeft();
      n = paramView.getRight();
      m = paramView.getTop();
      k = paramView.getBottom();
      int i7 = getChildCount();
      i2 = 0;
      if (i2 >= i7) {
        return;
      }
      localObject = getChildAt(i2);
      if (localObject == paramView) {
        return;
      }
      if (((View)localObject).getVisibility() != 8)
      {
        if (!bool) {
          break label328;
        }
        i3 = j;
        label140:
        int i8 = Math.max(i3, ((View)localObject).getLeft());
        int i9 = Math.max(i4, ((View)localObject).getTop());
        if (!bool) {
          break label334;
        }
        i3 = i;
        label172:
        i3 = Math.min(i3, ((View)localObject).getRight());
        int i10 = Math.min(i5 - i6, ((View)localObject).getBottom());
        if ((i8 < i1) || (i9 < m) || (i3 > n) || (i10 > k)) {
          break label340;
        }
      }
    }
    label267:
    label313:
    label328:
    label334:
    label340:
    for (int i3 = 4;; i3 = 0)
    {
      ((View)localObject).setVisibility(i3);
      i2 += 1;
      break label101;
      i = getPaddingLeft();
      break;
      label254:
      j = getWidth() - getPaddingRight();
      break label31;
      if (Build.VERSION.SDK_INT < 18)
      {
        localObject = paramView.getBackground();
        if (localObject != null)
        {
          if (((Drawable)localObject).getOpacity() == -1)
          {
            k = 1;
            break label63;
          }
          k = 0;
          break label63;
        }
      }
      k = 0;
      break label63;
      k = 0;
      m = 0;
      n = 0;
      i1 = 0;
      break label92;
      i3 = i;
      break label140;
      i3 = j;
      break label172;
    }
  }
  
  final void Q(int paramInt)
  {
    if (this.py == null)
    {
      this.pz = 0.0F;
      return;
    }
    boolean bool = cq();
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)this.py.getLayoutParams();
    int j = this.py.getWidth();
    int i = paramInt;
    if (bool) {
      i = getWidth() - paramInt - j;
    }
    if (bool)
    {
      paramInt = getPaddingRight();
      label65:
      if (!bool) {
        break label140;
      }
    }
    label140:
    for (j = localLayoutParams.rightMargin;; j = localLayoutParams.leftMargin)
    {
      this.pz = ((i - (j + paramInt)) / this.pB);
      if (this.pC != 0) {
        i(this.pz);
      }
      if (!localLayoutParams.pK) {
        break;
      }
      a(this.py, this.pz, this.ps);
      return;
      paramInt = getPaddingLeft();
      break label65;
    }
  }
  
  final void Q(View paramView)
  {
    pG.a(this, paramView);
  }
  
  final boolean R(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    return (this.px) && (paramView.pK) && (this.pz > 0.0F);
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof SlidingPaneLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  final void co()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() == 4) {
        localView.setVisibility(0);
      }
      i += 1;
    }
  }
  
  public void computeScroll()
  {
    if (this.pD.cx())
    {
      if (!this.px) {
        this.pD.abort();
      }
    }
    else {
      return;
    }
    android.support.v4.view.r.f(this);
  }
  
  final boolean cq()
  {
    return android.support.v4.view.r.i(this) == 1;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    if (cq())
    {
      localDrawable = this.pv;
      if (getChildCount() <= 1) {
        break label53;
      }
    }
    label53:
    for (View localView = getChildAt(1);; localView = null)
    {
      if ((localView != null) && (localDrawable != null)) {
        break label59;
      }
      return;
      localDrawable = this.pu;
      break;
    }
    label59:
    int k = localView.getTop();
    int m = localView.getBottom();
    int n = localDrawable.getIntrinsicWidth();
    int j;
    int i;
    if (cq())
    {
      j = localView.getRight();
      i = j + n;
    }
    for (;;)
    {
      localDrawable.setBounds(j, k, i, m);
      localDrawable.draw(paramCanvas);
      return;
      i = localView.getLeft();
      j = i - n;
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    SlidingPaneLayout.LayoutParams localLayoutParams = (SlidingPaneLayout.LayoutParams)paramView.getLayoutParams();
    int i = paramCanvas.save(2);
    if ((this.px) && (!localLayoutParams.pJ) && (this.py != null))
    {
      paramCanvas.getClipBounds(this.oI);
      if (!cq()) {
        break label105;
      }
      this.oI.left = Math.max(this.oI.left, this.py.getRight());
    }
    for (;;)
    {
      paramCanvas.clipRect(this.oI);
      boolean bool = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i);
      return bool;
      label105:
      this.oI.right = Math.min(this.oI.right, this.py.getLeft());
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new SlidingPaneLayout.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new SlidingPaneLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new SlidingPaneLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new SlidingPaneLayout.LayoutParams(paramLayoutParams);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.lI = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.lI = true;
    int j = this.pF.size();
    int i = 0;
    while (i < j)
    {
      ((n)this.pF.get(i)).run();
      i += 1;
    }
    this.pF.clear();
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    int i = paramMotionEvent.getActionMasked();
    if ((!this.px) && (i == 0) && (getChildCount() > 1))
    {
      View localView = getChildAt(1);
      if (localView != null) {
        if (ac.c(localView, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
          break label104;
        }
      }
    }
    label104:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.pE = bool1;
      if ((this.px) && ((!this.lu) || (i == 0))) {
        break;
      }
      this.pD.cancel();
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
      return bool1;
    }
    if ((i == 3) || (i == 1))
    {
      this.pD.cancel();
      return false;
    }
    switch (i)
    {
    }
    label160:
    float f1;
    float f2;
    do
    {
      for (i = 0;; i = 1)
      {
        if (!this.pD.c(paramMotionEvent))
        {
          bool1 = bool2;
          if (i == 0) {
            break;
          }
        }
        return true;
        this.lu = false;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        this.kj = f1;
        this.kk = f2;
        if ((!ac.c(this.py, (int)f1, (int)f2)) || (!R(this.py))) {
          break label160;
        }
      }
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      f2 = Math.abs(f2 - this.kj);
      f1 = Math.abs(f1 - this.kk);
    } while ((f2 <= this.pD.getTouchSlop()) || (f1 <= f2));
    this.pD.cancel();
    this.lu = true;
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool = cq();
    label35:
    label46:
    int m;
    float f;
    label82:
    int i;
    label99:
    SlidingPaneLayout.LayoutParams localLayoutParams;
    int i1;
    int j;
    if (bool)
    {
      this.pD.S(2);
      int k = paramInt3 - paramInt1;
      if (!bool) {
        break label358;
      }
      paramInt1 = getPaddingRight();
      if (!bool) {
        break label366;
      }
      paramInt3 = getPaddingLeft();
      int n = getPaddingTop();
      m = getChildCount();
      if (this.lI)
      {
        if ((!this.px) || (!this.pE)) {
          break label375;
        }
        f = 1.0F;
        this.pz = f;
      }
      paramInt4 = 0;
      i = paramInt1;
      paramInt2 = paramInt1;
      paramInt1 = i;
      if (paramInt4 >= m) {
        break label448;
      }
      View localView = getChildAt(paramInt4);
      if (localView.getVisibility() == 8) {
        break label557;
      }
      localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
      i1 = localView.getMeasuredWidth();
      j = 0;
      if (!localLayoutParams.pJ) {
        break label396;
      }
      i = localLayoutParams.leftMargin;
      int i2 = localLayoutParams.rightMargin;
      i2 = Math.min(paramInt1, k - paramInt3 - this.pw) - paramInt2 - (i + i2);
      this.pB = i2;
      if (!bool) {
        break label381;
      }
      i = localLayoutParams.rightMargin;
      label208:
      if (paramInt2 + i + i2 + i1 / 2 <= k - paramInt3) {
        break label391;
      }
      paramBoolean = true;
      label230:
      localLayoutParams.pK = paramBoolean;
      i2 = (int)(i2 * this.pz);
      paramInt2 += i + i2;
      this.pz = (i2 / this.pB);
      i = j;
      if (!bool) {
        break label432;
      }
      j = k - paramInt2 + i;
      i = j - i1;
      label293:
      localView.layout(i, n, j, localView.getMeasuredHeight() + n);
      i = localView.getWidth() + paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = i;
    }
    for (;;)
    {
      i = paramInt4 + 1;
      paramInt4 = paramInt1;
      paramInt1 = paramInt2;
      paramInt2 = paramInt4;
      paramInt4 = i;
      break label99;
      this.pD.S(1);
      break;
      label358:
      paramInt1 = getPaddingLeft();
      break label35;
      label366:
      paramInt3 = getPaddingRight();
      break label46;
      label375:
      f = 0.0F;
      break label82;
      label381:
      i = localLayoutParams.leftMargin;
      break label208;
      label391:
      paramBoolean = false;
      break label230;
      label396:
      if ((this.px) && (this.pC != 0)) {}
      for (paramInt2 = (int)((1.0F - this.pz) * this.pC);; paramInt2 = 0)
      {
        i = paramInt2;
        paramInt2 = paramInt1;
        break;
        label432:
        i = paramInt2 - i;
        j = i + i1;
        break label293;
        label448:
        if (this.lI)
        {
          if (!this.px) {
            break label523;
          }
          if (this.pC != 0) {
            i(this.pz);
          }
          if (((SlidingPaneLayout.LayoutParams)this.py.getLayoutParams()).pK) {
            a(this.py, this.pz, this.ps);
          }
        }
        for (;;)
        {
          P(this.py);
          this.lI = false;
          return;
          label523:
          paramInt1 = 0;
          while (paramInt1 < m)
          {
            a(getChildAt(paramInt1), 0.0F, this.ps);
            paramInt1 += 1;
          }
        }
      }
      label557:
      i = paramInt2;
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int k = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    if (k != 1073741824) {
      if (isInEditMode())
      {
        if ((k == -2147483648) || (k != 0)) {
          break label1046;
        }
        paramInt2 = i;
        i = 300;
        paramInt1 = j;
      }
    }
    for (;;)
    {
      k = 0;
      switch (paramInt2)
      {
      default: 
        j = 0;
        paramInt1 = k;
      }
      float f;
      boolean bool1;
      int i2;
      int i3;
      int i1;
      int m;
      View localView;
      SlidingPaneLayout.LayoutParams localLayoutParams;
      for (;;)
      {
        f = 0.0F;
        bool1 = false;
        i2 = i - getPaddingLeft() - getPaddingRight();
        i3 = getChildCount();
        if (i3 > 2) {
          Log.e("SlidingPaneLayout", "onMeasure: More than two child views are not supported.");
        }
        this.py = null;
        i1 = 0;
        m = i2;
        k = paramInt1;
        paramInt1 = m;
        for (;;)
        {
          if (i1 >= i3) {
            break label569;
          }
          localView = getChildAt(i1);
          localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
          if (localView.getVisibility() != 8) {
            break;
          }
          localLayoutParams.pK = false;
          i1 += 1;
        }
        throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        if (i != 0) {
          break label1046;
        }
        if (isInEditMode())
        {
          if (i != 0) {
            break label1046;
          }
          j = 300;
          paramInt2 = -2147483648;
          i = paramInt1;
          paramInt1 = j;
          break;
        }
        throw new IllegalStateException("Height must not be UNSPECIFIED");
        paramInt1 = paramInt1 - getPaddingTop() - getPaddingBottom();
        j = paramInt1;
        continue;
        j = paramInt1 - getPaddingTop() - getPaddingBottom();
        paramInt1 = k;
      }
      if (localLayoutParams.weight > 0.0F)
      {
        f = localLayoutParams.weight + f;
        if (localLayoutParams.width == 0) {}
      }
      for (;;)
      {
        m = localLayoutParams.leftMargin + localLayoutParams.rightMargin;
        label363:
        int n;
        label383:
        int i4;
        if (localLayoutParams.width == -2)
        {
          m = View.MeasureSpec.makeMeasureSpec(i2 - m, -2147483648);
          if (localLayoutParams.height != -2) {
            break label525;
          }
          n = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
          localView.measure(m, n);
          n = localView.getMeasuredWidth();
          i4 = localView.getMeasuredHeight();
          m = k;
          if (paramInt2 == -2147483648)
          {
            m = k;
            if (i4 > k) {
              m = Math.min(i4, j);
            }
          }
          paramInt1 -= n;
          if (paramInt1 >= 0) {
            break label563;
          }
        }
        label525:
        label563:
        for (boolean bool2 = true;; bool2 = false)
        {
          localLayoutParams.pJ = bool2;
          if (localLayoutParams.pJ) {
            this.py = localView;
          }
          bool1 = bool2 | bool1;
          k = m;
          break;
          if (localLayoutParams.width == -1)
          {
            m = View.MeasureSpec.makeMeasureSpec(i2 - m, 1073741824);
            break label363;
          }
          m = View.MeasureSpec.makeMeasureSpec(localLayoutParams.width, 1073741824);
          break label363;
          if (localLayoutParams.height == -1)
          {
            n = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
            break label383;
          }
          n = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
          break label383;
        }
        label569:
        if ((bool1) || (f > 0.0F))
        {
          i1 = i2 - this.pw;
          m = 0;
          if (m < i3)
          {
            localView = getChildAt(m);
            if (localView.getVisibility() != 8)
            {
              localLayoutParams = (SlidingPaneLayout.LayoutParams)localView.getLayoutParams();
              if (localView.getVisibility() != 8)
              {
                if ((localLayoutParams.width != 0) || (localLayoutParams.weight <= 0.0F)) {
                  break label749;
                }
                paramInt2 = 1;
                if (paramInt2 == 0) {
                  break label754;
                }
                n = 0;
                if ((!bool1) || (localView == this.py)) {
                  break label815;
                }
                if ((localLayoutParams.width < 0) && ((n > i1) || (localLayoutParams.weight > 0.0F)))
                {
                  if (paramInt2 == 0) {
                    break label800;
                  }
                  if (localLayoutParams.height != -2) {
                    break label764;
                  }
                  paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  label726:
                  localView.measure(View.MeasureSpec.makeMeasureSpec(i1, 1073741824), paramInt2);
                }
              }
            }
            for (;;)
            {
              m += 1;
              break;
              label749:
              paramInt2 = 0;
              break label657;
              label754:
              n = localView.getMeasuredWidth();
              break label664;
              label764:
              if (localLayoutParams.height == -1)
              {
                paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                break label726;
              }
              paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
              break label726;
              paramInt2 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
              break label726;
              if (localLayoutParams.weight > 0.0F)
              {
                if (localLayoutParams.width == 0) {
                  if (localLayoutParams.height == -2) {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, -2147483648);
                  }
                }
                for (;;)
                {
                  if (!bool1) {
                    break label956;
                  }
                  i4 = localLayoutParams.leftMargin;
                  i4 = i2 - (localLayoutParams.rightMargin + i4);
                  int i5 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                  if (n == i4) {
                    break;
                  }
                  localView.measure(i5, paramInt2);
                  break;
                  if (localLayoutParams.height == -1)
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(j, 1073741824);
                  }
                  else
                  {
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(localLayoutParams.height, 1073741824);
                    continue;
                    paramInt2 = View.MeasureSpec.makeMeasureSpec(localView.getMeasuredHeight(), 1073741824);
                  }
                }
                label956:
                i4 = Math.max(0, paramInt1);
                localView.measure(View.MeasureSpec.makeMeasureSpec((int)(localLayoutParams.weight * i4 / f) + n, 1073741824), paramInt2);
              }
            }
          }
        }
        label657:
        label664:
        label800:
        label815:
        setMeasuredDimension(i, getPaddingTop() + k + getPaddingBottom());
        this.px = bool1;
        if ((this.pD.cu() != 0) && (!bool1)) {
          this.pD.abort();
        }
        return;
        break;
      }
      label1046:
      paramInt2 = i;
      i = paramInt1;
      paramInt1 = j;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SlidingPaneLayout.SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SlidingPaneLayout.SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.getSuperState());
    if (paramParcelable.pM) {
      if ((this.lI) || (h(1.0F))) {
        this.pE = true;
      }
    }
    for (;;)
    {
      this.pE = paramParcelable.pM;
      return;
      cp();
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SlidingPaneLayout.SavedState localSavedState = new SlidingPaneLayout.SavedState(super.onSaveInstanceState());
    boolean bool;
    if (this.px) {
      if ((!this.px) || (this.pz == 1.0F)) {
        bool = true;
      }
    }
    for (;;)
    {
      localSavedState.pM = bool;
      return localSavedState;
      bool = false;
      continue;
      bool = this.pE;
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramInt1 != paramInt3) {
      this.lI = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.px) {
      return super.onTouchEvent(paramMotionEvent);
    }
    this.pD.d(paramMotionEvent);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return true;
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.kj = f1;
      this.kk = f2;
      continue;
      if (R(this.py))
      {
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        float f3 = f1 - this.kj;
        float f4 = f2 - this.kk;
        int i = this.pD.getTouchSlop();
        if ((f3 * f3 + f4 * f4 < i * i) && (ac.c(this.py, (int)f1, (int)f2))) {
          cp();
        }
      }
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    super.requestChildFocus(paramView1, paramView2);
    if ((!isInTouchMode()) && (!this.px)) {
      if (paramView1 != this.py) {
        break label36;
      }
    }
    label36:
    for (boolean bool = true;; bool = false)
    {
      this.pE = bool;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.SlidingPaneLayout
 * JD-Core Version:    0.7.0.1
 */