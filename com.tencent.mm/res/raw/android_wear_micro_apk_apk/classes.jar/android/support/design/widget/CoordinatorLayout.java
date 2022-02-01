package android.support.design.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.b.o;
import android.support.v4.b.q;
import android.support.v4.view.av;
import android.support.v4.view.l;
import android.support.v4.view.m;
import android.support.v4.view.n;
import android.support.v4.view.r;
import android.support.v4.widget.af;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CoordinatorLayout
  extends ViewGroup
  implements l
{
  static final String aG;
  static final Class<?>[] aH;
  static final ThreadLocal<Map<String, Constructor<CoordinatorLayout.Behavior>>> aI;
  static final Comparator<View> aJ;
  private static final o<Rect> aK;
  private final List<View> aL = new ArrayList();
  private final android.support.v4.widget.e<View> aM = new android.support.v4.widget.e();
  private final List<View> aN = new ArrayList();
  private final List<View> aO = new ArrayList();
  private final int[] aP = new int[2];
  private boolean aQ;
  private boolean aR;
  private int[] aS;
  private View aT;
  private View aU;
  private e aV;
  private boolean aW;
  private av aX;
  private boolean aY;
  private Drawable aZ;
  ViewGroup.OnHierarchyChangeListener ba;
  private n bb;
  private final m bc = new m(this);
  
  static
  {
    Object localObject = CoordinatorLayout.class.getPackage();
    if (localObject != null)
    {
      localObject = ((Package)localObject).getName();
      aG = (String)localObject;
      if (Build.VERSION.SDK_INT < 21) {
        break label80;
      }
    }
    label80:
    for (aJ = new f();; aJ = null)
    {
      aH = new Class[] { Context.class, AttributeSet.class };
      aI = new ThreadLocal();
      aK = new q();
      return;
      localObject = null;
      break;
    }
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, android.support.b.b.ar);
  }
  
  public CoordinatorLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramInt == 0) {}
    for (paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.b.d.at, 0, android.support.b.c.as);; paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, android.support.b.d.at, paramInt, 0))
    {
      paramInt = paramAttributeSet.getResourceId(android.support.b.d.au, 0);
      if (paramInt == 0) {
        break;
      }
      paramContext = paramContext.getResources();
      this.aS = paramContext.getIntArray(paramInt);
      float f = paramContext.getDisplayMetrics().density;
      int j = this.aS.length;
      paramInt = i;
      while (paramInt < j)
      {
        paramContext = this.aS;
        paramContext[paramInt] = ((int)(paramContext[paramInt] * f));
        paramInt += 1;
      }
    }
    this.aZ = paramAttributeSet.getDrawable(android.support.b.d.av);
    paramAttributeSet.recycle();
    t();
    super.setOnHierarchyChangeListener(new c(this));
  }
  
  private int a(int paramInt)
  {
    if (this.aS == null)
    {
      Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + paramInt);
      return 0;
    }
    if ((paramInt < 0) || (paramInt >= this.aS.length))
    {
      Log.e("CoordinatorLayout", "Keyline index " + paramInt + " out of range for " + this);
      return 0;
    }
    return this.aS[paramInt];
  }
  
  static CoordinatorLayout.Behavior a(Context paramContext, AttributeSet paramAttributeSet, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    String str;
    if (paramString.startsWith(".")) {
      str = paramContext.getPackageName() + paramString;
    }
    label216:
    for (;;)
    {
      try
      {
        paramString = (Map)aI.get();
        if (paramString != null) {
          break label216;
        }
        paramString = new HashMap();
        aI.set(paramString);
        Constructor localConstructor2 = (Constructor)paramString.get(str);
        Constructor localConstructor1 = localConstructor2;
        if (localConstructor2 == null)
        {
          localConstructor1 = paramContext.getClassLoader().loadClass(str).getConstructor(aH);
          localConstructor1.setAccessible(true);
          paramString.put(str, localConstructor1);
        }
        paramContext = (CoordinatorLayout.Behavior)localConstructor1.newInstance(new Object[] { paramContext, paramAttributeSet });
        return paramContext;
      }
      catch (Exception paramContext)
      {
        throw new RuntimeException("Could not inflate Behavior subclass ".concat(String.valueOf(str)), paramContext);
      }
      str = paramString;
      if (paramString.indexOf('.') < 0)
      {
        str = paramString;
        if (!TextUtils.isEmpty(aG)) {
          str = aG + '.' + paramString;
        }
      }
    }
  }
  
  private static d a(View paramView)
  {
    d locald = (d)paramView.getLayoutParams();
    if (!locald.bf)
    {
      if ((paramView instanceof a))
      {
        paramView = ((a)paramView).u();
        if (paramView == null) {
          Log.e("CoordinatorLayout", "Attached behavior class is null");
        }
        locald.a(paramView);
        locald.bf = true;
      }
    }
    else {
      return locald;
    }
    Class localClass = paramView.getClass();
    paramView = null;
    View localView;
    for (;;)
    {
      localView = paramView;
      if (localClass == null) {
        break;
      }
      paramView = (b)localClass.getAnnotation(b.class);
      localView = paramView;
      if (paramView != null) {
        break;
      }
      localClass = localClass.getSuperclass();
    }
    if (localView != null) {}
    try
    {
      locald.a((CoordinatorLayout.Behavior)localView.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
      locald.bf = true;
      return locald;
    }
    catch (Exception paramView)
    {
      for (;;)
      {
        Log.e("CoordinatorLayout", "Default behavior class " + localView.value().getName() + " could not be instantiated. Did you forget a default constructor?", paramView);
      }
    }
  }
  
  private static void a(int paramInt1, Rect paramRect1, Rect paramRect2, d paramd, int paramInt2, int paramInt3)
  {
    int k = android.support.v4.view.d.getAbsoluteGravity(d(paramd.gravity), paramInt1);
    int i = android.support.v4.view.d.getAbsoluteGravity(b(paramd.bg), paramInt1);
    label98:
    int j;
    switch (i & 0x7)
    {
    default: 
      paramInt1 = paramRect1.left;
      switch (i & 0x70)
      {
      default: 
        i = paramRect1.top;
        j = paramInt1;
        switch (k & 0x7)
        {
        default: 
          j = paramInt1 - paramInt2;
        case 5: 
          label138:
          paramInt1 = i;
          switch (k & 0x70)
          {
          }
          break;
        }
        break;
      }
      break;
    }
    for (paramInt1 = i - paramInt3;; paramInt1 = i - paramInt3 / 2)
    {
      paramRect2.set(j, paramInt1, j + paramInt2, paramInt1 + paramInt3);
      return;
      paramInt1 = paramRect1.right;
      break;
      paramInt1 = paramRect1.left;
      paramInt1 = paramRect1.width() / 2 + paramInt1;
      break;
      i = paramRect1.bottom;
      break label98;
      i = paramRect1.top + paramRect1.height() / 2;
      break label98;
      j = paramInt1 - paramInt2 / 2;
      break label138;
    }
  }
  
  private static void a(Rect paramRect)
  {
    paramRect.setEmpty();
    aK.t(paramRect);
  }
  
  private void a(d paramd, Rect paramRect, int paramInt1, int paramInt2)
  {
    int j = getWidth();
    int i = getHeight();
    j = Math.max(getPaddingLeft() + paramd.leftMargin, Math.min(paramRect.left, j - getPaddingRight() - paramInt1 - paramd.rightMargin));
    i = Math.max(getPaddingTop() + paramd.topMargin, Math.min(paramRect.top, i - getPaddingBottom() - paramInt2 - paramd.bottomMargin));
    paramRect.set(j, i, j + paramInt1, i + paramInt2);
  }
  
  private static void a(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.bl != paramInt)
    {
      r.h(paramView, paramInt - locald.bl);
      locald.bl = paramInt;
    }
  }
  
  private void a(View paramView, boolean paramBoolean, Rect paramRect)
  {
    if ((paramView.isLayoutRequested()) || (paramView.getVisibility() == 8))
    {
      paramRect.setEmpty();
      return;
    }
    if (paramBoolean)
    {
      af.a(this, paramView, paramRect);
      return;
    }
    paramRect.set(paramView.getLeft(), paramView.getTop(), paramView.getRight(), paramView.getBottom());
  }
  
  private boolean a(MotionEvent paramMotionEvent)
  {
    View localView = null;
    int k = paramMotionEvent.getActionMasked();
    List localList = this.aN;
    localList.clear();
    boolean bool1 = isChildrenDrawingOrderEnabled();
    int m = getChildCount();
    int i = m - 1;
    if (i >= 0)
    {
      if (bool1) {}
      for (j = getChildDrawingOrder(m, i);; j = i)
      {
        localList.add(getChildAt(j));
        i -= 1;
        break;
      }
    }
    if (aJ != null) {
      Collections.sort(localList, aJ);
    }
    m = localList.size();
    int j = 0;
    i = 0;
    paramMotionEvent = localView;
    d locald;
    if (j < m)
    {
      localView = (View)localList.get(j);
      locald = (d)localView.getLayoutParams();
      CoordinatorLayout.Behavior localBehavior = locald.be;
      if ((i != 0) && (k != 0))
      {
        if (localBehavior == null) {
          break label247;
        }
        if (paramMotionEvent != null) {
          break label244;
        }
        long l = SystemClock.uptimeMillis();
        paramMotionEvent = MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0);
      }
    }
    label235:
    label244:
    label247:
    for (;;)
    {
      j += 1;
      break;
      bool1 = locald.w();
      boolean bool2 = locald.a(this, localView);
      if ((bool2) && (!bool1)) {}
      for (i = 1;; i = 0)
      {
        if ((bool2) && (i == 0)) {
          break label235;
        }
        break;
      }
      localList.clear();
      return false;
    }
  }
  
  private static int b(int paramInt)
  {
    if ((paramInt & 0x7) == 0) {
      paramInt = 0x800003 | paramInt;
    }
    for (;;)
    {
      int i = paramInt;
      if ((paramInt & 0x70) == 0) {
        i = paramInt | 0x30;
      }
      return i;
    }
  }
  
  private static void b(View paramView, int paramInt)
  {
    d locald = (d)paramView.getLayoutParams();
    if (locald.bm != paramInt)
    {
      r.g(paramView, paramInt - locald.bm);
      locald.bm = paramInt;
    }
  }
  
  private static int c(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388661;
    }
    return i;
  }
  
  private static int d(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 17;
    }
    return i;
  }
  
  private static Rect r()
  {
    Rect localRect2 = (Rect)aK.bC();
    Rect localRect1 = localRect2;
    if (localRect2 == null) {
      localRect1 = new Rect();
    }
    return localRect1;
  }
  
  private void s()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((d)getChildAt(i).getLayoutParams()).be != null)
      {
        long l = SystemClock.uptimeMillis();
        MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0).recycle();
      }
      i += 1;
    }
    i = 0;
    while (i < j)
    {
      ((d)getChildAt(i).getLayoutParams()).x();
      i += 1;
    }
    this.aT = null;
    this.aQ = false;
  }
  
  private void t()
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (r.t(this))
    {
      if (this.bb == null) {
        this.bb = new n()
        {
          public final av a(View paramAnonymousView, av paramAnonymousav)
          {
            return CoordinatorLayout.this.a(paramAnonymousav);
          }
        };
      }
      r.a(this, this.bb);
      setSystemUiVisibility(1280);
      return;
    }
    r.a(this, null);
  }
  
  final av a(av paramav)
  {
    boolean bool2 = true;
    int i = 0;
    Object localObject = this.aX;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = Objects.equals(localObject, paramav);
      if (bool1) {
        return paramav;
      }
      this.aX = paramav;
      if ((paramav == null) || (paramav.getSystemWindowInsetTop() <= 0)) {
        break label186;
      }
      bool1 = true;
      label51:
      this.aY = bool1;
      if ((this.aY) || (getBackground() != null)) {
        break label192;
      }
    }
    label186:
    label192:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      setWillNotDraw(bool1);
      if (paramav.isConsumed()) {
        break label207;
      }
      int j = getChildCount();
      while (i < j)
      {
        localObject = getChildAt(i);
        if ((!r.t((View)localObject)) || (((d)((View)localObject).getLayoutParams()).be == null)) {
          break label204;
        }
        localObject = CoordinatorLayout.Behavior.b(paramav);
        paramav = (av)localObject;
        if (((av)localObject).isConsumed()) {
          break;
        }
        paramav = (av)localObject;
        i += 1;
      }
      if ((localObject == paramav) || ((localObject != null) && (localObject.equals(paramav))))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label51;
    }
    label204:
    label207:
    for (;;)
    {
      requestLayout();
      return paramav;
      break;
    }
    return paramav;
  }
  
  public final void a(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int n = getChildCount();
    int k = 0;
    int m = 0;
    int i = 0;
    int j = 0;
    if (k < n)
    {
      Object localObject = getChildAt(k);
      if (((View)localObject).getVisibility() == 8) {
        break label188;
      }
      localObject = (d)((View)localObject).getLayoutParams();
      if ((!((d)localObject).i(paramInt3)) || (((d)localObject).be == null)) {
        break label188;
      }
      localObject = this.aP;
      this.aP[1] = 0;
      localObject[0] = 0;
      if (paramInt1 > 0)
      {
        j = Math.max(j, this.aP[0]);
        label106:
        if (paramInt2 <= 0) {
          break label151;
        }
        i = Math.max(i, this.aP[1]);
        label123:
        m = 1;
      }
    }
    label151:
    label188:
    for (;;)
    {
      k += 1;
      break;
      j = Math.min(j, this.aP[0]);
      break label106;
      i = Math.min(i, this.aP[1]);
      break label123;
      paramArrayOfInt[0] = j;
      paramArrayOfInt[1] = i;
      if (m != 0) {
        e(1);
      }
      return;
    }
  }
  
  public final boolean a(View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    int i = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < i)
    {
      paramView1 = getChildAt(paramInt1);
      if (paramView1.getVisibility() != 8)
      {
        paramView1 = (d)paramView1.getLayoutParams();
        paramView2 = paramView1.be;
        paramView1.a(paramInt2, false);
      }
      paramInt1 += 1;
    }
    return false;
  }
  
  public final void c(View paramView, int paramInt)
  {
    this.bc.H(paramInt);
    this.aU = paramView;
    int i = getChildCount();
    paramInt = 0;
    while (paramInt < i)
    {
      getChildAt(paramInt).getLayoutParams();
      paramInt += 1;
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof d)) && (super.checkLayoutParams(paramLayoutParams));
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    paramView.getLayoutParams();
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    boolean bool2 = false;
    Drawable localDrawable = this.aZ;
    boolean bool1 = bool2;
    if (localDrawable != null)
    {
      bool1 = bool2;
      if (localDrawable.isStateful()) {
        bool1 = localDrawable.setState(arrayOfInt) | false;
      }
    }
    if (bool1) {
      invalidate();
    }
  }
  
  final void e(int paramInt)
  {
    int m = r.j(this);
    int n = this.aL.size();
    Rect localRect1 = r();
    Rect localRect2 = r();
    Rect localRect3 = r();
    int j = 0;
    View localView;
    int i;
    Object localObject;
    if (j < n)
    {
      localView = (View)this.aL.get(j);
      d locald = (d)localView.getLayoutParams();
      if ((paramInt != 0) || (localView.getVisibility() != 8))
      {
        i = 0;
        int k;
        int i1;
        int i2;
        while (i < j)
        {
          localObject = (View)this.aL.get(i);
          if (locald.bo == localObject)
          {
            localObject = (d)localView.getLayoutParams();
            if (((d)localObject).bn != null)
            {
              localRect4 = r();
              Rect localRect5 = r();
              Rect localRect6 = r();
              af.a(this, ((d)localObject).bn, localRect4);
              a(localView, false, localRect5);
              k = localView.getMeasuredWidth();
              i1 = localView.getMeasuredHeight();
              a(m, localRect4, localRect6, (d)localObject, k, i1);
              if (localRect6.left == localRect5.left)
              {
                i2 = localRect6.top;
                i2 = localRect5.top;
              }
              a((d)localObject, localRect6, k, i1);
              k = localRect6.left - localRect5.left;
              i1 = localRect6.top - localRect5.top;
              if (k != 0) {
                r.h(localView, k);
              }
              if (i1 != 0) {
                r.g(localView, i1);
              }
              a(localRect4);
              a(localRect5);
              a(localRect6);
            }
          }
          i += 1;
        }
        a(localView, true, localRect2);
        if ((locald.bj != 0) && (!localRect2.isEmpty()))
        {
          i = android.support.v4.view.d.getAbsoluteGravity(locald.bj, m);
          switch (i & 0x70)
          {
          default: 
            switch (i & 0x7)
            {
            }
            break;
          }
        }
        for (;;)
        {
          if ((locald.bk != 0) && (localView.getVisibility() == 0) && (r.x(localView)) && (localView.getWidth() > 0) && (localView.getHeight() > 0)) {
            break label619;
          }
          label444:
          if (paramInt != 2)
          {
            localRect3.set(((d)localView.getLayoutParams()).bt);
            if (localRect3.equals(localRect2)) {
              break label984;
            }
            ((d)localView.getLayoutParams()).bt.set(localRect2);
          }
          i = j + 1;
          while (i < n)
          {
            ((View)this.aL.get(i)).getLayoutParams();
            i += 1;
          }
          localRect1.top = Math.max(localRect1.top, localRect2.bottom);
          break;
          localRect1.bottom = Math.max(localRect1.bottom, getHeight() - localRect2.top);
          break;
          localRect1.left = Math.max(localRect1.left, localRect2.right);
          continue;
          localRect1.right = Math.max(localRect1.right, getWidth() - localRect2.left);
        }
        label619:
        locald = (d)localView.getLayoutParams();
        localObject = r();
        Rect localRect4 = r();
        localRect4.set(localView.getLeft(), localView.getTop(), localView.getRight(), localView.getBottom());
        ((Rect)localObject).set(localRect4);
        a(localRect4);
        if (!((Rect)localObject).isEmpty())
        {
          i1 = android.support.v4.view.d.getAbsoluteGravity(locald.bk, m);
          k = 0;
          i = k;
          if ((i1 & 0x30) == 48)
          {
            i2 = ((Rect)localObject).top - locald.topMargin - locald.bm;
            i = k;
            if (i2 < localRect1.top)
            {
              b(localView, localRect1.top - i2);
              i = 1;
            }
          }
          k = i;
          if ((i1 & 0x50) == 80)
          {
            i2 = getHeight() - ((Rect)localObject).bottom - locald.bottomMargin + locald.bm;
            k = i;
            if (i2 < localRect1.bottom)
            {
              b(localView, i2 - localRect1.bottom);
              k = 1;
            }
          }
          if (k == 0) {
            b(localView, 0);
          }
          k = 0;
          i = k;
          if ((i1 & 0x3) == 3)
          {
            i2 = ((Rect)localObject).left - locald.leftMargin - locald.bl;
            i = k;
            if (i2 < localRect1.left)
            {
              a(localView, localRect1.left - i2);
              i = 1;
            }
          }
          if ((i1 & 0x5) != 5) {
            break label1007;
          }
          k = getWidth();
          i1 = ((Rect)localObject).right;
          i2 = locald.rightMargin;
          k = locald.bl + (k - i1 - i2);
          if (k >= localRect1.right) {
            break label1007;
          }
          a(localView, k - localRect1.right);
          i = 1;
        }
      }
    }
    label984:
    label1007:
    for (;;)
    {
      if (i == 0) {
        a(localView, 0);
      }
      a((Rect)localObject);
      break label444;
      j += 1;
      break;
      a(localRect1);
      a(localRect2);
      a(localRect3);
      return;
    }
  }
  
  public final void f(int paramInt)
  {
    this.bc.bF();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      d locald = (d)getChildAt(i).getLayoutParams();
      if (locald.i(paramInt))
      {
        locald.h(paramInt);
        locald.y();
      }
      i += 1;
    }
    this.aU = null;
  }
  
  public final void g(int paramInt)
  {
    int k = getChildCount();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      Object localObject = getChildAt(j);
      if (((View)localObject).getVisibility() == 8) {
        break label79;
      }
      localObject = (d)((View)localObject).getLayoutParams();
      if ((!((d)localObject).i(paramInt)) || (((d)localObject).be == null)) {
        break label79;
      }
      i = 1;
    }
    label79:
    for (;;)
    {
      j += 1;
      break;
      if (i != 0) {
        e(1);
      }
      return;
    }
  }
  
  public int getNestedScrollAxes()
  {
    return this.bc.getNestedScrollAxes();
  }
  
  protected int getSuggestedMinimumHeight()
  {
    return Math.max(super.getSuggestedMinimumHeight(), getPaddingTop() + getPaddingBottom());
  }
  
  protected int getSuggestedMinimumWidth()
  {
    return Math.max(super.getSuggestedMinimumWidth(), getPaddingLeft() + getPaddingRight());
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    s();
    if (this.aW)
    {
      if (this.aV == null) {
        this.aV = new e(this);
      }
      getViewTreeObserver().addOnPreDrawListener(this.aV);
    }
    if ((this.aX == null) && (r.t(this))) {
      r.s(this);
    }
    this.aR = true;
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    s();
    if ((this.aW) && (this.aV != null)) {
      getViewTreeObserver().removeOnPreDrawListener(this.aV);
    }
    if (this.aU != null) {
      onStopNestedScroll(this.aU);
    }
    this.aR = false;
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.aY) && (this.aZ != null)) {
      if (this.aX == null) {
        break label61;
      }
    }
    label61:
    for (int i = this.aX.getSystemWindowInsetTop();; i = 0)
    {
      if (i > 0)
      {
        this.aZ.setBounds(0, 0, getWidth(), i);
        this.aZ.draw(paramCanvas);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (i == 0) {
      s();
    }
    a(paramMotionEvent);
    if ((i == 1) || (i == 3)) {
      s();
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 = r.j(this);
    int i = this.aL.size();
    paramInt3 = 0;
    for (;;)
    {
      if (paramInt3 >= i) {
        return;
      }
      View localView1 = (View)this.aL.get(paramInt3);
      if (localView1.getVisibility() != 8)
      {
        localView1.getLayoutParams();
        localObject1 = (d)localView1.getLayoutParams();
        if ((((d)localObject1).bn == null) && (((d)localObject1).bi != -1)) {}
        for (paramInt1 = 1; paramInt1 != 0; paramInt1 = 0) {
          throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        if (((d)localObject1).bn == null) {
          break label251;
        }
        localObject2 = ((d)localObject1).bn;
        localView1.getLayoutParams();
        localObject1 = r();
        localRect = r();
      }
      label251:
      try
      {
        af.a(this, (View)localObject2, (Rect)localObject1);
        localObject2 = (d)localView1.getLayoutParams();
        paramInt1 = localView1.getMeasuredWidth();
        paramInt2 = localView1.getMeasuredHeight();
        a(paramInt4, (Rect)localObject1, localRect, (d)localObject2, paramInt1, paramInt2);
        a((d)localObject2, localRect, paramInt1, paramInt2);
        localView1.layout(localRect.left, localRect.top, localRect.right, localRect.bottom);
        a((Rect)localObject1);
        a(localRect);
        paramInt3 += 1;
      }
      finally
      {
        a((Rect)localObject1);
        a(localRect);
      }
    }
    Object localObject1 = (d)localView2.getLayoutParams();
    int i1 = android.support.v4.view.d.getAbsoluteGravity(c(((d)localObject1).gravity), paramInt4);
    int n = getWidth();
    int m = getHeight();
    int j = localView2.getMeasuredWidth();
    int k = localView2.getMeasuredHeight();
    paramInt1 = paramInt2;
    if (paramInt4 == 1) {
      paramInt1 = n - paramInt2;
    }
    paramInt1 = a(paramInt1) - j;
    paramInt2 = 0;
    switch (i1 & 0x7)
    {
    default: 
      label372:
      switch (i1 & 0x70)
      {
      }
      break;
    }
    for (;;)
    {
      paramInt1 = Math.max(getPaddingLeft() + ((d)localObject1).leftMargin, Math.min(paramInt1, n - getPaddingRight() - j - ((d)localObject1).rightMargin));
      paramInt2 = Math.max(getPaddingTop() + ((d)localObject1).topMargin, Math.min(paramInt2, m - getPaddingBottom() - k - ((d)localObject1).bottomMargin));
      localView2.layout(paramInt1, paramInt2, paramInt1 + j, paramInt2 + k);
      break;
      paramInt1 += j;
      break label372;
      paramInt1 += j / 2;
      break label372;
      paramInt2 = k + 0;
      continue;
      paramInt2 = k / 2 + 0;
    }
    localObject1 = (d)localView2.getLayoutParams();
    Rect localRect = r();
    localRect.set(getPaddingLeft() + ((d)localObject1).leftMargin, getPaddingTop() + ((d)localObject1).topMargin, getWidth() - getPaddingRight() - ((d)localObject1).rightMargin, getHeight() - getPaddingBottom() - ((d)localObject1).bottomMargin);
    if ((this.aX != null) && (r.t(this)) && (!r.t(localView2)))
    {
      localRect.left += this.aX.getSystemWindowInsetLeft();
      localRect.top += this.aX.getSystemWindowInsetTop();
      localRect.right -= this.aX.getSystemWindowInsetRight();
      localRect.bottom -= this.aX.getSystemWindowInsetBottom();
    }
    Object localObject2 = r();
    paramInt1 = b(((d)localObject1).gravity);
    paramInt2 = localView2.getMeasuredWidth();
    j = localView2.getMeasuredHeight();
    if (Build.VERSION.SDK_INT >= 17) {
      Gravity.apply(paramInt1, paramInt2, j, localRect, (Rect)localObject2, paramInt4);
    }
    for (;;)
    {
      localView2.layout(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom);
      a(localRect);
      a((Rect)localObject2);
      break;
      Gravity.apply(paramInt1, paramInt2, j, localRect, (Rect)localObject2);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    this.aL.clear();
    this.aM.clear();
    int m = getChildCount();
    int j = 0;
    label79:
    Object localObject1;
    int k;
    int n;
    label158:
    label244:
    Object localObject2;
    label387:
    label399:
    label537:
    while (j < m)
    {
      View localView = getChildAt(j);
      d locald = a(localView);
      if (locald.bi == -1)
      {
        locald.bo = null;
        locald.bn = null;
        this.aM.x(localView);
        i = 0;
        if (i >= m) {
          break label596;
        }
        if (i != j)
        {
          localObject1 = getChildAt(i);
          if (localObject1 == locald.bo) {
            break label590;
          }
          k = r.j(this);
          n = android.support.v4.view.d.getAbsoluteGravity(((d)((View)localObject1).getLayoutParams()).bj, k);
          if ((n == 0) || ((android.support.v4.view.d.getAbsoluteGravity(locald.bk, k) & n) != n)) {
            break label584;
          }
          k = 1;
          if (k != 0) {
            break label590;
          }
          if (locald.be == null) {}
        }
      }
      label308:
      label584:
      label590:
      for (k = 0;; k = 1)
      {
        if (k != 0)
        {
          if (!this.aM.contains(localObject1)) {
            this.aM.x(localObject1);
          }
          this.aM.f(localObject1, localView);
        }
        i += 1;
        break label79;
        if (locald.bn != null)
        {
          if (locald.bn.getId() == locald.bi) {
            break label308;
          }
          i = 0;
          if (i != 0) {}
        }
        else
        {
          locald.bn = findViewById(locald.bi);
          if (locald.bn == null) {
            break label515;
          }
          if (locald.bn != this) {
            break label410;
          }
          if (!isInEditMode()) {
            break label399;
          }
          locald.bo = null;
          locald.bn = null;
        }
        for (;;)
        {
          localObject1 = locald.bn;
          break;
          localObject2 = locald.bn;
          for (localObject1 = locald.bn.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
          {
            if (localObject1 == this) {
              break label387;
            }
            if ((localObject1 == null) || (localObject1 == localView))
            {
              locald.bo = null;
              locald.bn = null;
              i = 0;
              break;
            }
            if ((localObject1 instanceof View)) {
              localObject2 = (View)localObject1;
            }
          }
          locald.bo = ((View)localObject2);
          i = 1;
          break label244;
          throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
          localObject2 = locald.bn;
          for (localObject1 = locald.bn.getParent();; localObject1 = ((ViewParent)localObject1).getParent())
          {
            if ((localObject1 == this) || (localObject1 == null)) {
              break label505;
            }
            if (localObject1 == localView)
            {
              if (isInEditMode())
              {
                locald.bo = null;
                locald.bn = null;
                break;
              }
              throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
            }
            if ((localObject1 instanceof View)) {
              localObject2 = (View)localObject1;
            }
          }
          label505:
          locald.bo = ((View)localObject2);
          continue;
          if (!isInEditMode()) {
            break label537;
          }
          locald.bo = null;
          locald.bn = null;
        }
        throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(locald.bi) + " to anchor view " + localView);
        k = 0;
        break label158;
      }
      label410:
      label596:
      j += 1;
    }
    label515:
    this.aL.addAll(this.aM.cg());
    Collections.reverse(this.aL);
    int i18 = 0;
    j = getChildCount();
    int i = 0;
    int i17 = i18;
    label728:
    int i5;
    label767:
    int i1;
    label822:
    int i2;
    label836:
    int i3;
    int i4;
    int i15;
    if (i < j)
    {
      localObject1 = getChildAt(i);
      if (this.aM.y(localObject1)) {
        i17 = 1;
      }
    }
    else
    {
      if (i17 != this.aW)
      {
        if (i17 == 0) {
          break label1164;
        }
        if (this.aR)
        {
          if (this.aV == null) {
            this.aV = new e(this);
          }
          getViewTreeObserver().addOnPreDrawListener(this.aV);
        }
        this.aW = true;
      }
      i5 = getPaddingLeft();
      int i6 = getPaddingTop();
      int i7 = getPaddingRight();
      int i8 = getPaddingBottom();
      int i9 = r.j(this);
      if (i9 != 1) {
        break label1197;
      }
      n = 1;
      int i10 = View.MeasureSpec.getMode(paramInt1);
      int i11 = View.MeasureSpec.getSize(paramInt1);
      int i12 = View.MeasureSpec.getMode(paramInt2);
      int i13 = View.MeasureSpec.getSize(paramInt2);
      k = getSuggestedMinimumWidth();
      j = getSuggestedMinimumHeight();
      i = 0;
      if ((this.aX == null) || (!r.t(this))) {
        break label1203;
      }
      i1 = 1;
      int i14 = this.aL.size();
      i2 = 0;
      if (i2 >= i14) {
        break label1253;
      }
      localObject1 = (View)this.aL.get(i2);
      if (((View)localObject1).getVisibility() == 8) {
        break label1288;
      }
      localObject2 = (d)((View)localObject1).getLayoutParams();
      i3 = 0;
      m = i3;
      if (((d)localObject2).bh >= 0)
      {
        m = i3;
        if (i10 != 0)
        {
          i4 = a(((d)localObject2).bh);
          i15 = android.support.v4.view.d.getAbsoluteGravity(c(((d)localObject2).gravity), i9) & 0x7;
          if (((i15 != 3) || (n != 0)) && ((i15 != 5) || (n == 0))) {
            break label1209;
          }
          m = Math.max(0, i11 - i7 - i4);
        }
      }
      label968:
      if ((i1 == 0) || (r.t((View)localObject1))) {
        break label1279;
      }
      i3 = this.aX.getSystemWindowInsetLeft();
      int i16 = this.aX.getSystemWindowInsetRight();
      i4 = this.aX.getSystemWindowInsetTop();
      i15 = this.aX.getSystemWindowInsetBottom();
      i3 = View.MeasureSpec.makeMeasureSpec(i11 - (i3 + i16), i10);
      i4 = View.MeasureSpec.makeMeasureSpec(i13 - (i15 + i4), i12);
      label1047:
      measureChildWithMargins((View)localObject1, i3, m, i4, 0);
      k = Math.max(k, ((View)localObject1).getMeasuredWidth() + (i5 + i7) + ((d)localObject2).leftMargin + ((d)localObject2).rightMargin);
      j = Math.max(j, ((View)localObject1).getMeasuredHeight() + (i6 + i8) + ((d)localObject2).topMargin + ((d)localObject2).bottomMargin);
      m = View.combineMeasuredStates(i, ((View)localObject1).getMeasuredState());
      i = k;
      k = m;
    }
    for (;;)
    {
      i2 += 1;
      m = i;
      i = k;
      k = m;
      break label836;
      i += 1;
      break;
      label1164:
      if ((this.aR) && (this.aV != null)) {
        getViewTreeObserver().removeOnPreDrawListener(this.aV);
      }
      this.aW = false;
      break label728;
      label1197:
      n = 0;
      break label767;
      label1203:
      i1 = 0;
      break label822;
      label1209:
      if ((i15 != 5) || (n != 0))
      {
        m = i3;
        if (i15 != 3) {
          break label968;
        }
        m = i3;
        if (n == 0) {
          break label968;
        }
      }
      m = Math.max(0, i4 - i5);
      break label968;
      label1253:
      setMeasuredDimension(View.resolveSizeAndState(k, paramInt1, 0xFF000000 & i), View.resolveSizeAndState(j, paramInt2, i << 16));
      return;
      label1279:
      i4 = paramInt2;
      i3 = paramInt1;
      break label1047;
      label1288:
      m = k;
      k = i;
      i = m;
    }
  }
  
  public boolean onNestedFling(View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = getChildAt(i);
      if (paramView.getVisibility() != 8) {
        paramView.getLayoutParams();
      }
      i += 1;
    }
    return false;
  }
  
  public boolean onNestedPreFling(View paramView, float paramFloat1, float paramFloat2)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      paramView = getChildAt(i);
      if (paramView.getVisibility() != 8) {
        paramView.getLayoutParams();
      }
      i += 1;
    }
    return false;
  }
  
  public void onNestedPreScroll(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    a(paramInt1, paramInt2, paramArrayOfInt, 0);
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    g(0);
  }
  
  public void onNestedScrollAccepted(View paramView1, View paramView2, int paramInt)
  {
    c(paramView2, paramInt);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof CoordinatorLayout.SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (CoordinatorLayout.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramParcelable.getSuperState());
      paramParcelable = paramParcelable.bv;
      int i = 0;
      int j = getChildCount();
      while (i < j)
      {
        Object localObject = getChildAt(i);
        int k = ((View)localObject).getId();
        localObject = a((View)localObject).be;
        if ((k != -1) && (localObject != null)) {
          paramParcelable.get(k);
        }
        i += 1;
      }
    }
  }
  
  protected Parcelable onSaveInstanceState()
  {
    CoordinatorLayout.SavedState localSavedState = new CoordinatorLayout.SavedState(super.onSaveInstanceState());
    SparseArray localSparseArray = new SparseArray();
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      Object localObject = getChildAt(i);
      int k = ((View)localObject).getId();
      localObject = ((d)((View)localObject).getLayoutParams()).be;
      if ((k != -1) && (localObject != null))
      {
        localObject = CoordinatorLayout.Behavior.v();
        if (localObject != null) {
          localSparseArray.append(k, localObject);
        }
      }
      i += 1;
    }
    localSavedState.bv = localSparseArray;
    return localSavedState;
  }
  
  public boolean onStartNestedScroll(View paramView1, View paramView2, int paramInt)
  {
    return a(paramView1, paramView2, paramInt, 0);
  }
  
  public void onStopNestedScroll(View paramView)
  {
    f(0);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (this.aT == null)
    {
      a(paramMotionEvent);
      if (this.aT != null) {
        break label68;
      }
    }
    label68:
    for (boolean bool = super.onTouchEvent(paramMotionEvent) | false;; bool = false)
    {
      if ((i == 1) || (i == 3)) {
        s();
      }
      return bool;
      if (((d)this.aT.getLayoutParams()).be == null) {
        break;
      }
      break;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    paramView.getLayoutParams();
    return super.requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    super.requestDisallowInterceptTouchEvent(paramBoolean);
    if ((paramBoolean) && (!this.aQ))
    {
      s();
      this.aQ = true;
    }
  }
  
  public void setFitsSystemWindows(boolean paramBoolean)
  {
    super.setFitsSystemWindows(paramBoolean);
    t();
  }
  
  public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener paramOnHierarchyChangeListener)
  {
    this.ba = paramOnHierarchyChangeListener;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false)
    {
      if ((this.aZ != null) && (this.aZ.isVisible() != bool)) {
        this.aZ.setVisible(bool, false);
      }
      return;
    }
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.aZ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     android.support.design.widget.CoordinatorLayout
 * JD-Core Version:    0.7.0.1
 */