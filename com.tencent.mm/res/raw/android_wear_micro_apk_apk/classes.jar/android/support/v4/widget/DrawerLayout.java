package android.support.v4.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.a.a.a;
import android.support.v4.view.d;
import android.support.v4.view.r;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowInsets;
import java.util.ArrayList;
import java.util.List;

public class DrawerLayout
  extends ViewGroup
{
  static final int[] mR;
  private static final int[] pS;
  static final boolean pT;
  private static final boolean pU;
  private boolean aY;
  private Drawable aZ;
  private boolean cE;
  private float mg;
  private float mh;
  private boolean nE = true;
  private final g pV = new g();
  private float pW;
  private int pX;
  private int pY = -1728053248;
  private float pZ;
  private Paint qa = new Paint();
  private final ad qb;
  private final ad qc;
  private final h qd;
  private final h qe;
  private int qf;
  private int qg = 3;
  private int qh = 3;
  private int qi = 3;
  private int qj = 3;
  private boolean qk;
  private boolean ql;
  private List<Object> qm;
  private Drawable qn;
  private Drawable qo;
  private CharSequence qp;
  private CharSequence qq;
  private Object qr;
  private Drawable qs = null;
  private Drawable qt = null;
  private Drawable qu = null;
  private Drawable qv = null;
  private final ArrayList<View> qw;
  
  static
  {
    boolean bool2 = true;
    pS = new int[] { 16843828 };
    mR = new int[] { 16842931 };
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = true;
      pT = bool1;
      if (Build.VERSION.SDK_INT < 21) {
        break label58;
      }
    }
    label58:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      pU = bool1;
      return;
      bool1 = false;
      break;
    }
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DrawerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setDescendantFocusability(262144);
    float f1 = getResources().getDisplayMetrics().density;
    this.pX = ((int)(64.0F * f1 + 0.5F));
    float f2 = 400.0F * f1;
    this.qd = new h(this, 3);
    this.qe = new h(this, 5);
    this.qb = ad.a(this, 1.0F, this.qd);
    this.qb.ad(1);
    this.qb.p(f2);
    this.qd.a(this.qb);
    this.qc = ad.a(this, 1.0F, this.qe);
    this.qc.ad(2);
    this.qc.p(f2);
    this.qe.a(this.qc);
    setFocusableInTouchMode(true);
    r.f(this, 1);
    r.a(this, new f(this));
    setMotionEventSplittingEnabled(false);
    if (r.t(this))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label336;
      }
      setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
      {
        @TargetApi(21)
        public final WindowInsets onApplyWindowInsets(View paramAnonymousView, WindowInsets paramAnonymousWindowInsets)
        {
          paramAnonymousView = (DrawerLayout)paramAnonymousView;
          if (paramAnonymousWindowInsets.getSystemWindowInsetTop() > 0) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.a(paramAnonymousWindowInsets, bool);
            return paramAnonymousWindowInsets.consumeSystemWindowInsets();
          }
        }
      });
      setSystemUiVisibility(1280);
      paramContext = paramContext.obtainStyledAttributes(pS);
    }
    for (;;)
    {
      try
      {
        this.aZ = paramContext.getDrawable(0);
        paramContext.recycle();
        this.pW = (f1 * 10.0F);
        this.qw = new ArrayList();
        return;
      }
      finally
      {
        paramContext.recycle();
      }
      label336:
      this.aZ = null;
    }
  }
  
  static float H(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).qz;
  }
  
  private static boolean J(View paramView)
  {
    return ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity == 0;
  }
  
  static boolean K(View paramView)
  {
    int i = d.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, r.j(paramView));
    if ((i & 0x3) != 0) {
      return true;
    }
    return (i & 0x5) != 0;
  }
  
  private void L(View paramView)
  {
    if (!K(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (this.nE)
    {
      localLayoutParams.qz = 1.0F;
      localLayoutParams.qB = 1;
      a(paramView, true);
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.qB |= 0x2;
      if (i(paramView, 3)) {
        this.qb.b(paramView, 0, paramView.getTop());
      } else {
        this.qc.b(paramView, getWidth() - paramView.getWidth(), paramView.getTop());
      }
    }
  }
  
  private void N(View paramView)
  {
    if (!K(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a sliding drawer");
    }
    DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (this.nE)
    {
      localLayoutParams.qz = 0.0F;
      localLayoutParams.qB = 0;
    }
    for (;;)
    {
      invalidate();
      return;
      localLayoutParams.qB |= 0x4;
      if (i(paramView, 3)) {
        this.qb.b(paramView, -paramView.getWidth(), paramView.getTop());
      } else {
        this.qc.b(paramView, getWidth(), paramView.getTop());
      }
    }
  }
  
  static boolean O(View paramView)
  {
    return (r.h(paramView) != 4) && (r.h(paramView) != 2);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      if (((!paramBoolean) && (!K(localView))) || ((paramBoolean) && (localView == paramView))) {
        r.f(localView, 1);
      }
      for (;;)
      {
        i += 1;
        break;
        r.f(localView, 4);
      }
    }
  }
  
  private static boolean b(Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable != null) {
      if (Build.VERSION.SDK_INT < 19) {
        break label23;
      }
    }
    label23:
    for (boolean bool = paramDrawable.isAutoMirrored(); !bool; bool = false) {
      return false;
    }
    a.a(paramDrawable, paramInt);
    return true;
  }
  
  private View ch()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      if ((((DrawerLayout.LayoutParams)localView.getLayoutParams()).qB & 0x1) == 1) {
        return localView;
      }
      i += 1;
    }
    return null;
  }
  
  private void e(int paramInt1, int paramInt2)
  {
    int i = d.getAbsoluteGravity(paramInt2, r.j(this));
    Object localObject;
    switch (paramInt2)
    {
    default: 
      if (paramInt1 != 0)
      {
        if (i == 3)
        {
          localObject = this.qb;
          label67:
          ((ad)localObject).cancel();
        }
      }
      else {
        switch (paramInt1)
        {
        }
      }
      break;
    }
    do
    {
      do
      {
        return;
        this.qg = paramInt1;
        break;
        this.qh = paramInt1;
        break;
        this.qi = paramInt1;
        break;
        this.qj = paramInt1;
        break;
        localObject = this.qc;
        break label67;
        localObject = U(i);
      } while (localObject == null);
      L((View)localObject);
      return;
      localObject = U(i);
    } while (localObject == null);
    N((View)localObject);
  }
  
  private void o(boolean paramBoolean)
  {
    int m = getChildCount();
    int j = 0;
    int i = 0;
    if (j < m)
    {
      View localView = getChildAt(j);
      DrawerLayout.LayoutParams localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
      boolean bool = i;
      int k;
      if (K(localView)) {
        if (paramBoolean)
        {
          bool = i;
          if (!localLayoutParams.qA) {}
        }
        else
        {
          k = localView.getWidth();
          if (!i(localView, 3)) {
            break label115;
          }
          i |= this.qb.b(localView, -k, localView.getTop());
        }
      }
      for (;;)
      {
        localLayoutParams.qA = false;
        k = i;
        j += 1;
        i = k;
        break;
        label115:
        i |= this.qc.b(localView, getWidth(), localView.getTop());
      }
    }
    this.qd.cf();
    this.qe.cf();
    if (i != 0) {
      invalidate();
    }
  }
  
  public final int G(View paramView)
  {
    if (!K(paramView)) {
      throw new IllegalArgumentException("View " + paramView + " is not a drawer");
    }
    int i = ((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity;
    int j = r.j(this);
    switch (i)
    {
    }
    for (;;)
    {
      return 0;
      if (this.qg != 3) {
        return this.qg;
      }
      if (j == 0) {}
      for (i = this.qi; i != 3; i = this.qj) {
        return i;
      }
      if (this.qh != 3) {
        return this.qh;
      }
      if (j == 0) {}
      for (i = this.qj; i != 3; i = this.qi) {
        return i;
      }
      if (this.qi != 3) {
        return this.qi;
      }
      if (j == 0) {}
      for (i = this.qg; i != 3; i = this.qh) {
        return i;
      }
      if (this.qj != 3) {
        return this.qj;
      }
      if (j == 0) {}
      for (i = this.qh; i != 3; i = this.qg) {
        return i;
      }
    }
  }
  
  final int I(View paramView)
  {
    return d.getAbsoluteGravity(((DrawerLayout.LayoutParams)paramView.getLayoutParams()).gravity, r.j(this));
  }
  
  public final void M(View paramView)
  {
    N(paramView);
  }
  
  public final CharSequence T(int paramInt)
  {
    paramInt = d.getAbsoluteGravity(paramInt, r.j(this));
    if (paramInt == 3) {
      return this.qp;
    }
    if (paramInt == 5) {
      return this.qq;
    }
    return null;
  }
  
  final View U(int paramInt)
  {
    int i = d.getAbsoluteGravity(paramInt, r.j(this));
    int j = getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = getChildAt(paramInt);
      if ((I(localView) & 0x7) == (i & 0x7)) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  final void a(int paramInt, View paramView)
  {
    int i = this.qb.cB();
    int j = this.qc.cB();
    if ((i == 1) || (j == 1)) {
      i = 1;
    }
    DrawerLayout.LayoutParams localLayoutParams;
    while ((paramView != null) && (paramInt == 0))
    {
      localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.qz != 0.0F) {
        break label227;
      }
      localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
      if ((localLayoutParams.qB & 0x1) == 1)
      {
        localLayoutParams.qB = 0;
        if (this.qm != null)
        {
          paramInt = this.qm.size() - 1;
          for (;;)
          {
            if (paramInt >= 0)
            {
              this.qm.get(paramInt);
              paramInt -= 1;
              continue;
              if ((i == 2) || (j == 2))
              {
                i = 2;
                break;
              }
              i = 0;
              break;
            }
          }
        }
        a(paramView, false);
        if (hasWindowFocus())
        {
          paramView = getRootView();
          if (paramView != null) {
            paramView.sendAccessibilityEvent(32);
          }
        }
      }
    }
    while (i != this.qf)
    {
      this.qf = i;
      if (this.qm == null) {
        break;
      }
      paramInt = this.qm.size() - 1;
      while (paramInt >= 0)
      {
        this.qm.get(paramInt);
        paramInt -= 1;
      }
      label227:
      if (localLayoutParams.qz == 1.0F)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
        if ((localLayoutParams.qB & 0x1) == 0)
        {
          localLayoutParams.qB = 1;
          if (this.qm != null)
          {
            paramInt = this.qm.size() - 1;
            while (paramInt >= 0)
            {
              this.qm.get(paramInt);
              paramInt -= 1;
            }
          }
          a(paramView, true);
          if (hasWindowFocus()) {
            sendAccessibilityEvent(32);
          }
        }
      }
    }
  }
  
  public final void a(Object paramObject, boolean paramBoolean)
  {
    this.qr = paramObject;
    this.aY = paramBoolean;
    if ((!paramBoolean) && (getBackground() == null)) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      setWillNotDraw(paramBoolean);
      requestLayout();
      return;
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    if (getDescendantFocusability() == 393216) {
      return;
    }
    int m = getChildCount();
    int j = 0;
    int i = 0;
    View localView;
    if (j < m)
    {
      localView = getChildAt(j);
      int k;
      if (K(localView))
      {
        if (!K(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if ((((DrawerLayout.LayoutParams)localView.getLayoutParams()).qB & 0x1) == 1)
        {
          k = 1;
          label106:
          if (k == 0) {
            break label147;
          }
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        j += 1;
        break;
        k = 0;
        break label106;
        this.qw.add(localView);
      }
    }
    if (i == 0)
    {
      j = this.qw.size();
      i = 0;
      while (i < j)
      {
        localView = (View)this.qw.get(i);
        if (localView.getVisibility() == 0) {
          localView.addFocusables(paramArrayList, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
    this.qw.clear();
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    super.addView(paramView, paramInt, paramLayoutParams);
    if ((ch() != null) || (K(paramView))) {
      r.f(paramView, 4);
    }
    for (;;)
    {
      if (!pT) {
        r.a(paramView, this.pV);
      }
      return;
      r.f(paramView, 1);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  final View ci()
  {
    int k = getChildCount();
    int i = 0;
    while (i < k)
    {
      View localView = getChildAt(i);
      if (K(localView))
      {
        if (!K(localView)) {
          throw new IllegalArgumentException("View " + localView + " is not a drawer");
        }
        if (((DrawerLayout.LayoutParams)localView.getLayoutParams()).qz > 0.0F) {}
        for (int j = 1; j != 0; j = 0) {
          return localView;
        }
      }
      i += 1;
    }
    return null;
  }
  
  final void cj()
  {
    int i = 0;
    if (!this.ql)
    {
      long l = SystemClock.uptimeMillis();
      MotionEvent localMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      int j = getChildCount();
      while (i < j)
      {
        getChildAt(i).dispatchTouchEvent(localMotionEvent);
        i += 1;
      }
      localMotionEvent.recycle();
      this.ql = true;
    }
  }
  
  public void computeScroll()
  {
    int j = getChildCount();
    float f = 0.0F;
    int i = 0;
    while (i < j)
    {
      f = Math.max(f, ((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).qz);
      i += 1;
    }
    this.pZ = f;
    boolean bool1 = this.qb.cE();
    boolean bool2 = this.qc.cE();
    if ((bool1) || (bool2)) {
      r.g(this);
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    int i2 = getHeight();
    boolean bool1 = J(paramView);
    int i = 0;
    int n = 0;
    int j = getWidth();
    int i3 = paramCanvas.save();
    int k = j;
    int m;
    View localView;
    int i1;
    if (bool1)
    {
      int i4 = getChildCount();
      m = 0;
      i = n;
      if (m < i4)
      {
        localView = getChildAt(m);
        n = i;
        i1 = j;
        if (localView != paramView)
        {
          n = i;
          i1 = j;
          if (localView.getVisibility() == 0)
          {
            Drawable localDrawable = localView.getBackground();
            if (localDrawable == null) {
              break label227;
            }
            if (localDrawable.getOpacity() != -1) {
              break label221;
            }
            k = 1;
            label121:
            n = i;
            i1 = j;
            if (k != 0)
            {
              n = i;
              i1 = j;
              if (K(localView))
              {
                n = i;
                i1 = j;
                if (localView.getHeight() >= i2)
                {
                  if (!i(localView, 3)) {
                    break label233;
                  }
                  k = localView.getRight();
                  if (k <= i) {
                    break label598;
                  }
                  i = k;
                }
              }
            }
          }
        }
      }
    }
    label598:
    for (;;)
    {
      i1 = j;
      n = i;
      for (;;)
      {
        m += 1;
        i = n;
        j = i1;
        break;
        label221:
        k = 0;
        break label121;
        label227:
        k = 0;
        break label121;
        label233:
        k = localView.getLeft();
        n = i;
        i1 = j;
        if (k < j)
        {
          i1 = k;
          n = i;
        }
      }
      paramCanvas.clipRect(i, 0, j, getHeight());
      k = j;
      boolean bool2 = super.drawChild(paramCanvas, paramView, paramLong);
      paramCanvas.restoreToCount(i3);
      if ((this.pZ > 0.0F) && (bool1))
      {
        j = (int)(((this.pY & 0xFF000000) >>> 24) * this.pZ);
        m = this.pY;
        this.qa.setColor(j << 24 | m & 0xFFFFFF);
        paramCanvas.drawRect(i, 0.0F, k, getHeight(), this.qa);
      }
      do
      {
        return bool2;
        if ((this.qn != null) && (i(paramView, 3)))
        {
          i = this.qn.getIntrinsicWidth();
          j = paramView.getRight();
          k = this.qb.cC();
          f = Math.max(0.0F, Math.min(j / k, 1.0F));
          this.qn.setBounds(j, paramView.getTop(), i + j, paramView.getBottom());
          this.qn.setAlpha((int)(255.0F * f));
          this.qn.draw(paramCanvas);
          return bool2;
        }
      } while ((this.qo == null) || (!i(paramView, 5)));
      i = this.qo.getIntrinsicWidth();
      j = paramView.getLeft();
      k = getWidth();
      m = this.qc.cC();
      float f = Math.max(0.0F, Math.min((k - j) / m, 1.0F));
      this.qo.setBounds(j - i, paramView.getTop(), j, paramView.getBottom());
      this.qo.setAlpha((int)(255.0F * f));
      this.qo.draw(paramCanvas);
      return bool2;
    }
  }
  
  final void e(View paramView, float paramFloat)
  {
    paramView = (DrawerLayout.LayoutParams)paramView.getLayoutParams();
    if (paramFloat == paramView.qz) {}
    for (;;)
    {
      return;
      paramView.qz = paramFloat;
      if (this.qm != null)
      {
        int i = this.qm.size() - 1;
        while (i >= 0)
        {
          this.qm.get(i);
          i -= 1;
        }
      }
    }
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    return new DrawerLayout.LayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new DrawerLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((paramLayoutParams instanceof DrawerLayout.LayoutParams)) {
      return new DrawerLayout.LayoutParams((DrawerLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new DrawerLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new DrawerLayout.LayoutParams(paramLayoutParams);
  }
  
  final boolean i(View paramView, int paramInt)
  {
    return (I(paramView) & paramInt) == paramInt;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.nE = true;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.nE = true;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i;
    if ((this.aY) && (this.aZ != null))
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label77;
      }
      if (this.qr == null) {
        break label72;
      }
      i = ((WindowInsets)this.qr).getSystemWindowInsetTop();
    }
    for (;;)
    {
      if (i > 0)
      {
        this.aZ.setBounds(0, 0, getWidth(), i);
        this.aZ.draw(paramCanvas);
      }
      return;
      label72:
      i = 0;
      continue;
      label77:
      i = 0;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = this.qb.d(paramMotionEvent);
    boolean bool3 = this.qc.d(paramMotionEvent);
    switch (i)
    {
    default: 
      i = 0;
      if ((!(bool2 | bool3)) && (i == 0))
      {
        int j = getChildCount();
        i = 0;
        if (i >= j) {
          break label256;
        }
        if (!((DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams()).qA) {
          break;
        }
        i = 1;
        if ((i == 0) && (!this.ql)) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    case 0: 
      label63:
      label85:
      label113:
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.mg = f1;
      this.mh = f2;
      if (this.pZ > 0.0F)
      {
        paramMotionEvent = this.qb.k((int)f1, (int)f2);
        if ((paramMotionEvent == null) || (!J(paramMotionEvent))) {}
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      this.qk = false;
      this.ql = false;
      break label63;
      if (!this.qb.cF()) {
        break;
      }
      this.qd.cf();
      this.qe.cf();
      i = 0;
      break label63;
      o(true);
      this.qk = false;
      this.ql = false;
      break;
      i += 1;
      break label85;
      label256:
      i = 0;
      break label113;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (ci() != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        paramKeyEvent.startTracking();
        return true;
      }
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    if (paramInt == 4)
    {
      paramKeyEvent = ci();
      if ((paramKeyEvent != null) && (G(paramKeyEvent) == 0)) {
        o(false);
      }
      if (paramKeyEvent != null) {
        bool = true;
      }
      return bool;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cE = true;
    int m = paramInt3 - paramInt1;
    int n = getChildCount();
    paramInt3 = 0;
    while (paramInt3 < n)
    {
      View localView = getChildAt(paramInt3);
      DrawerLayout.LayoutParams localLayoutParams;
      if (localView.getVisibility() != 8)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
        if (J(localView)) {
          localView.layout(localLayoutParams.leftMargin, localLayoutParams.topMargin, localLayoutParams.leftMargin + localView.getMeasuredWidth(), localLayoutParams.topMargin + localView.getMeasuredHeight());
        }
      }
      else
      {
        paramInt3 += 1;
        continue;
      }
      int i1 = localView.getMeasuredWidth();
      int i2 = localView.getMeasuredHeight();
      int i;
      float f;
      label163:
      int j;
      if (i(localView, 3))
      {
        paramInt1 = -i1;
        i = (int)(i1 * localLayoutParams.qz) + paramInt1;
        f = (i1 + i) / i1;
        if (f == localLayoutParams.qz) {
          break label310;
        }
        j = 1;
        label177:
        switch (localLayoutParams.gravity & 0x70)
        {
        default: 
          localView.layout(i, localLayoutParams.topMargin, i1 + i, i2 + localLayoutParams.topMargin);
          label237:
          if (j != 0) {
            e(localView, f);
          }
          if (localLayoutParams.qz <= 0.0F) {
            break;
          }
        }
      }
      for (paramInt1 = 0; localView.getVisibility() != paramInt1; paramInt1 = 4)
      {
        localView.setVisibility(paramInt1);
        break;
        i = m - (int)(i1 * localLayoutParams.qz);
        f = (m - i) / i1;
        break label163;
        label310:
        j = 0;
        break label177;
        paramInt1 = paramInt4 - paramInt2;
        localView.layout(i, paramInt1 - localLayoutParams.bottomMargin - localView.getMeasuredHeight(), i1 + i, paramInt1 - localLayoutParams.bottomMargin);
        break label237;
        int i3 = paramInt4 - paramInt2;
        int k = (i3 - i2) / 2;
        if (k < localLayoutParams.topMargin) {
          paramInt1 = localLayoutParams.topMargin;
        }
        for (;;)
        {
          localView.layout(i, paramInt1, i1 + i, i2 + paramInt1);
          break;
          paramInt1 = k;
          if (k + i2 > i3 - localLayoutParams.bottomMargin) {
            paramInt1 = i3 - localLayoutParams.bottomMargin - i2;
          }
        }
      }
    }
    this.cE = false;
    this.nE = false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    int k = View.MeasureSpec.getSize(paramInt1);
    int m = View.MeasureSpec.getSize(paramInt2);
    int j;
    int i;
    if (i1 == 1073741824)
    {
      j = k;
      if (n == 1073741824) {}
    }
    else if (isInEditMode())
    {
      i = k;
      if (i1 != -2147483648)
      {
        i = k;
        if (i1 == 0) {
          i = 300;
        }
      }
      j = i;
      if (n == -2147483648) {
        break label794;
      }
      j = i;
      if (n != 0) {
        break label794;
      }
      k = 300;
    }
    for (m = i;; m = j)
    {
      setMeasuredDimension(m, k);
      label146:
      View localView;
      int i2;
      int i3;
      DrawerLayout.LayoutParams localLayoutParams;
      Object localObject2;
      Object localObject1;
      if ((this.qr != null) && (r.t(this)))
      {
        n = 1;
        int i4 = r.j(this);
        i = 0;
        j = 0;
        int i5 = getChildCount();
        i1 = 0;
        if (i1 >= i5) {
          break label793;
        }
        localView = getChildAt(i1);
        i2 = j;
        i3 = i;
        if (localView.getVisibility() != 8)
        {
          localLayoutParams = (DrawerLayout.LayoutParams)localView.getLayoutParams();
          if (n != 0)
          {
            i2 = d.getAbsoluteGravity(localLayoutParams.gravity, i4);
            if (!r.t(localView)) {
              break label396;
            }
            if (Build.VERSION.SDK_INT >= 21)
            {
              localObject2 = (WindowInsets)this.qr;
              if (i2 != 3) {
                break label360;
              }
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              label259:
              localView.dispatchApplyWindowInsets((WindowInsets)localObject1);
            }
          }
        }
      }
      for (;;)
      {
        if (J(localView))
        {
          localView.measure(View.MeasureSpec.makeMeasureSpec(m - localLayoutParams.leftMargin - localLayoutParams.rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec(k - localLayoutParams.topMargin - localLayoutParams.bottomMargin, 1073741824));
          i3 = i;
          i2 = j;
          i1 += 1;
          j = i2;
          i = i3;
          break label146;
          throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
          n = 0;
          break;
          label360:
          localObject1 = localObject2;
          if (i2 != 5) {
            break label259;
          }
          localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
          break label259;
          label396:
          if (Build.VERSION.SDK_INT >= 21)
          {
            localObject2 = (WindowInsets)this.qr;
            if (i2 == 3) {
              localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(((WindowInsets)localObject2).getSystemWindowInsetLeft(), ((WindowInsets)localObject2).getSystemWindowInsetTop(), 0, ((WindowInsets)localObject2).getSystemWindowInsetBottom());
            }
            for (;;)
            {
              localLayoutParams.leftMargin = ((WindowInsets)localObject1).getSystemWindowInsetLeft();
              localLayoutParams.topMargin = ((WindowInsets)localObject1).getSystemWindowInsetTop();
              localLayoutParams.rightMargin = ((WindowInsets)localObject1).getSystemWindowInsetRight();
              localLayoutParams.bottomMargin = ((WindowInsets)localObject1).getSystemWindowInsetBottom();
              break;
              localObject1 = localObject2;
              if (i2 == 5) {
                localObject1 = ((WindowInsets)localObject2).replaceSystemWindowInsets(0, ((WindowInsets)localObject2).getSystemWindowInsetTop(), ((WindowInsets)localObject2).getSystemWindowInsetRight(), ((WindowInsets)localObject2).getSystemWindowInsetBottom());
              }
            }
          }
        }
      }
      if (K(localView))
      {
        if ((pU) && (r.q(localView) != this.pW)) {
          r.d(localView, this.pW);
        }
        i3 = I(localView) & 0x7;
        if (i3 == 3)
        {
          i2 = 1;
          if (((i2 == 0) || (i == 0)) && ((i2 != 0) || (j == 0))) {
            break label677;
          }
          localObject2 = new StringBuilder("Child drawer has absolute gravity ");
          if ((i3 & 0x3) != 3) {
            break label651;
          }
          localObject1 = "LEFT";
        }
        for (;;)
        {
          throw new IllegalStateException((String)localObject1 + " but this DrawerLayout already has a drawer view along that edge");
          i2 = 0;
          break;
          label651:
          if ((i3 & 0x5) == 5) {
            localObject1 = "RIGHT";
          } else {
            localObject1 = Integer.toHexString(i3);
          }
        }
        label677:
        if (i2 != 0) {
          i = 1;
        }
        for (;;)
        {
          localView.measure(getChildMeasureSpec(paramInt1, this.pX + localLayoutParams.leftMargin + localLayoutParams.rightMargin, localLayoutParams.width), getChildMeasureSpec(paramInt2, localLayoutParams.topMargin + localLayoutParams.bottomMargin, localLayoutParams.height));
          i2 = j;
          i3 = i;
          break;
          j = 1;
        }
      }
      throw new IllegalStateException("Child " + localView + " at index " + i1 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
      label793:
      return;
      label794:
      k = m;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof DrawerLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      paramParcelable = (DrawerLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      if (paramParcelable.qC != 0)
      {
        View localView = U(paramParcelable.qC);
        if (localView != null) {
          L(localView);
        }
      }
      if (paramParcelable.qD != 3) {
        e(paramParcelable.qD, 3);
      }
      if (paramParcelable.qE != 3) {
        e(paramParcelable.qE, 5);
      }
      if (paramParcelable.qF != 3) {
        e(paramParcelable.qF, 8388611);
      }
    } while (paramParcelable.qG == 3);
    e(paramParcelable.qG, 8388613);
  }
  
  public void onRtlPropertiesChanged(int paramInt)
  {
    Drawable localDrawable;
    if (!pU)
    {
      paramInt = r.j(this);
      if (paramInt != 0) {
        break label77;
      }
      if (this.qs == null) {
        break label101;
      }
      b(this.qs, paramInt);
      localDrawable = this.qs;
      this.qn = localDrawable;
      paramInt = r.j(this);
      if (paramInt != 0) {
        break label109;
      }
      if (this.qt == null) {
        break label133;
      }
      b(this.qt, paramInt);
      localDrawable = this.qt;
    }
    label133:
    for (;;)
    {
      this.qo = localDrawable;
      return;
      label77:
      if (this.qt != null)
      {
        b(this.qt, paramInt);
        localDrawable = this.qt;
        break;
      }
      label101:
      localDrawable = this.qu;
      break;
      label109:
      if (this.qs != null)
      {
        b(this.qs, paramInt);
        localDrawable = this.qs;
      }
      else
      {
        localDrawable = this.qv;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    DrawerLayout.SavedState localSavedState = new DrawerLayout.SavedState(super.onSaveInstanceState());
    int m = getChildCount();
    int i = 0;
    for (;;)
    {
      DrawerLayout.LayoutParams localLayoutParams;
      int j;
      if (i < m)
      {
        localLayoutParams = (DrawerLayout.LayoutParams)getChildAt(i).getLayoutParams();
        if (localLayoutParams.qB != 1) {
          break label119;
        }
        j = 1;
        if (localLayoutParams.qB != 2) {
          break label124;
        }
      }
      label119:
      label124:
      for (int k = 1;; k = 0)
      {
        if ((j == 0) && (k == 0)) {
          break label129;
        }
        localSavedState.qC = localLayoutParams.gravity;
        localSavedState.qD = this.qg;
        localSavedState.qE = this.qh;
        localSavedState.qF = this.qi;
        localSavedState.qG = this.qj;
        return localSavedState;
        j = 0;
        break;
      }
      label129:
      i += 1;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    this.qb.e(paramMotionEvent);
    this.qc.e(paramMotionEvent);
    float f1;
    float f2;
    boolean bool;
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    case 2: 
    default: 
      return true;
    case 0: 
      f1 = paramMotionEvent.getX();
      f2 = paramMotionEvent.getY();
      this.mg = f1;
      this.mh = f2;
      this.qk = false;
      this.ql = false;
      return true;
    case 1: 
      f2 = paramMotionEvent.getX();
      f1 = paramMotionEvent.getY();
      paramMotionEvent = this.qb.k((int)f2, (int)f1);
      if ((paramMotionEvent != null) && (J(paramMotionEvent)))
      {
        f2 -= this.mg;
        f1 -= this.mh;
        int i = this.qb.getTouchSlop();
        if (f2 * f2 + f1 * f1 < i * i)
        {
          paramMotionEvent = ch();
          if (paramMotionEvent != null) {
            if (G(paramMotionEvent) == 2) {
              bool = true;
            }
          }
        }
      }
      break;
    }
    for (;;)
    {
      o(bool);
      this.qk = false;
      return true;
      bool = false;
      continue;
      o(true);
      this.qk = false;
      this.ql = false;
      return true;
      bool = true;
    }
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    this.qk = paramBoolean;
    if (paramBoolean) {
      o(true);
    }
  }
  
  public void requestLayout()
  {
    if (!this.cE) {
      super.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.v4.widget.DrawerLayout
 * JD-Core Version:    0.7.0.1
 */