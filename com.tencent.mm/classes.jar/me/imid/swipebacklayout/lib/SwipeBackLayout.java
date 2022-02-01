package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.support.v4.widget.p;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import com.tencent.luggage.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int[] KgD = { 1, 2, 8, 11 };
  private float HBO;
  protected int HBP;
  protected int HBQ;
  protected float HBS;
  private int KgE;
  protected b KgF;
  private CopyOnWriteArrayList<a> KgG;
  private Drawable KgH;
  private int KgI;
  private int QK;
  private float QL;
  private Drawable Rg;
  private Drawable Rh;
  private Rect Rm;
  private View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968594);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140882);
    this.HBO = 0.3F;
    this.mEnable = true;
    this.QK = -1728053248;
    this.Rm = new Rect();
    this.KgF = b.a(this, new c((byte)0));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.SwipeBackLayout, paramInt, 2131821307);
    paramInt = paramContext.getDimensionPixelSize(1, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(KgD[paramContext.getInt(0, 0)]);
    paramInt = paramContext.getResourceId(3, 2131233962);
    int i = paramContext.getResourceId(4, 2131233963);
    int j = paramContext.getResourceId(2, 2131233960);
    kR(paramInt, 1);
    kR(i, 2);
    kR(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.KgF.TJ = f;
    this.KgF.TI = (f * 2.0F);
    AppMethodBeat.o(140882);
  }
  
  private void f(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(140887);
    if ((paramInt & 0x1) != 0) {
      this.Rg = paramDrawable;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(140887);
      return;
      if ((paramInt & 0x2) != 0) {
        this.Rh = paramDrawable;
      } else if ((paramInt & 0x8) != 0) {
        this.KgH = paramDrawable;
      }
    }
  }
  
  private void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140888);
    f(getResources().getDrawable(paramInt1), paramInt2);
    AppMethodBeat.o(140888);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140885);
    if (this.KgG == null) {
      this.KgG = new CopyOnWriteArrayList();
    }
    this.KgG.add(parama);
    AppMethodBeat.o(140885);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(140894);
    this.QL = (1.0F - this.HBS);
    b localb = this.KgF;
    boolean bool;
    int i;
    if (localb.Tz == 2)
    {
      bool = localb.mjD.RH.computeScrollOffset();
      i = localb.mjD.RH.getCurrX();
      int j = localb.mjD.RH.getCurrY();
      int k = i - localb.TN.getLeft();
      int m = j - localb.TN.getTop();
      if (k != 0) {
        localb.TN.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localb.TN.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localb.KgM.o(localb.TN, i, j, k, m);
      }
      if ((!bool) || (i != localb.mjD.RH.getFinalX()) || (j != localb.mjD.RH.getFinalY())) {
        break label253;
      }
      localb.mjD.RH.abortAnimation();
      bool = localb.mjD.RH.isFinished();
    }
    label253:
    for (;;)
    {
      if (!bool) {
        localb.TP.post(localb.TQ);
      }
      if (localb.Tz == 2) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          t.W(this);
        }
        AppMethodBeat.o(140894);
        return;
      }
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140889);
    if (!this.mEnable)
    {
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(140889);
      return bool;
    }
    Object localObject;
    if ((this.KgG != null) && (!this.KgG.isEmpty()))
    {
      localObject = this.KgG.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).m(paramMotionEvent);
      }
    }
    if (this.KgF.Tz == 1)
    {
      this.KgF.h(paramMotionEvent);
      AppMethodBeat.o(140889);
      return true;
    }
    try
    {
      localObject = this.KgF;
      j = paramMotionEvent.getActionMasked();
      i = paramMotionEvent.getActionIndex();
      if (j == 0) {
        ((b)localObject).cancel();
      }
      if (((b)localObject).mVelocityTracker == null) {
        ((b)localObject).mVelocityTracker = VelocityTracker.obtain();
      }
      ((b)localObject).mVelocityTracker.addMovement(paramMotionEvent);
      switch (j)
      {
      }
    }
    catch (NullPointerException paramMotionEvent)
    {
      for (;;)
      {
        AppMethodBeat.o(140889);
        return false;
        int j = paramMotionEvent.getPointerCount();
        i = 0;
        if (i < j)
        {
          k = paramMotionEvent.getPointerId(i);
          f1 = paramMotionEvent.getX(i);
          f2 = paramMotionEvent.getY(i);
          f3 = f1 - localObject.TA[k];
          f4 = f2 - localObject.TB[k];
          ((b)localObject).b(f3, f4, k);
          if (((b)localObject).Tz != 1)
          {
            localView = ((b)localObject).C((int)f1, (int)f2);
            if ((localView == null) || (!((b)localObject).c(localView, f3, f4)) || (!((b)localObject).z(localView, k))) {
              break;
            }
          }
        }
        ((b)localObject).f(paramMotionEvent);
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        AppMethodBeat.o(140889);
        return false;
        ((b)localObject).bc(paramMotionEvent.getPointerId(i));
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      AppMethodBeat.o(140889);
      return false;
    }
    if (((b)localObject).Tz == 1) {}
    for (int i = 1;; i = 0)
    {
      float f1;
      float f2;
      View localView;
      if (i != 0)
      {
        paramMotionEvent.setAction(3);
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(140889);
        return true;
        f1 = paramMotionEvent.getX();
        f2 = paramMotionEvent.getY();
        i = paramMotionEvent.getPointerId(0);
        ((b)localObject).a(f1, f2, i);
        localView = ((b)localObject).C((int)f1, (int)f2);
        if ((localView == ((b)localObject).TN) && (((b)localObject).Tz == 2)) {
          ((b)localObject).z(localView, i);
        }
        if ((localObject.KgL[i] & ((b)localObject).TL) == 0) {
          break;
        }
        break;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        ((b)localObject).a(f1, f2, j);
        if ((((b)localObject).Tz == 0) || (((b)localObject).Tz != 2)) {
          break;
        }
        localView = ((b)localObject).C((int)f1, (int)f2);
        if (localView != ((b)localObject).TN) {
          break;
        }
        ((b)localObject).z(localView, j);
        break;
      }
      for (;;)
      {
        int k;
        float f3;
        float f4;
        ((b)localObject).cancel();
        break;
        super.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(140889);
        return true;
        break;
        i += 1;
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    AppMethodBeat.i(140893);
    int i;
    boolean bool;
    int j;
    if (paramView == this.mContentView)
    {
      i = 1;
      bool = super.drawChild(paramCanvas, paramView, paramLong);
      if ((this.QL > 0.0F) && (i != 0) && (this.KgF.Tz != 0))
      {
        Rect localRect = this.Rm;
        paramView.getHitRect(localRect);
        if ((this.KgE & 0x1) != 0)
        {
          this.Rg.setBounds(localRect.left - this.Rg.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
          this.Rg.setAlpha((int)(this.QL * 255.0F));
          this.Rg.draw(paramCanvas);
        }
        if ((this.KgE & 0x2) != 0)
        {
          this.Rh.setBounds(localRect.right, localRect.top, localRect.right + this.Rh.getIntrinsicWidth(), localRect.bottom);
          this.Rh.setAlpha((int)(this.QL * 255.0F));
          this.Rh.draw(paramCanvas);
        }
        if ((this.KgE & 0x8) != 0)
        {
          this.KgH.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.KgH.getIntrinsicHeight());
          this.KgH.setAlpha((int)(this.QL * 255.0F));
          this.KgH.draw(paramCanvas);
        }
        i = (int)(((this.QK & 0xFF000000) >>> 24) * this.QL);
        j = this.QK;
        if ((this.KgI & 0x1) == 0) {
          break label348;
        }
        paramCanvas.clipRect(0, 0, paramView.getLeft(), getHeight());
      }
    }
    for (;;)
    {
      paramCanvas.drawColor(i << 24 | j & 0xFFFFFF);
      AppMethodBeat.o(140893);
      return bool;
      i = 0;
      break;
      label348:
      if ((this.KgI & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.KgI & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  public View getTargetView()
  {
    return this.mContentView;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140891);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.HBP, this.HBQ, this.HBP + this.mContentView.getMeasuredWidth(), this.HBQ + this.mContentView.getMeasuredHeight());
    }
    this.mInLayout = false;
    AppMethodBeat.o(140891);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(140890);
    if (!this.mEnable)
    {
      AppMethodBeat.o(140890);
      return false;
    }
    this.KgF.h(paramMotionEvent);
    AppMethodBeat.o(140890);
    return true;
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(140892);
    if (!this.mInLayout) {
      super.requestLayout();
    }
    AppMethodBeat.o(140892);
  }
  
  public void setContentView(View paramView)
  {
    this.mContentView = paramView;
  }
  
  public void setEdgeSize(int paramInt)
  {
    this.KgF.TK = paramInt;
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.KgE = paramInt;
    this.KgF.TL = this.KgE;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.KgF.TI = paramFloat;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.KgF.TJ = paramFloat;
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(140883);
    this.QK = paramInt;
    invalidate();
    AppMethodBeat.o(140883);
  }
  
  public void setScrollThresHold(float paramFloat)
  {
    AppMethodBeat.i(140886);
    if ((paramFloat >= 1.0F) || (paramFloat <= 0.0F))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Threshold value should be between 0 and 1.0");
      AppMethodBeat.o(140886);
      throw localIllegalArgumentException;
    }
    this.HBO = paramFloat;
    AppMethodBeat.o(140886);
  }
  
  @Deprecated
  public void setSwipeListener(a parama)
  {
    AppMethodBeat.i(140884);
    a(parama);
    AppMethodBeat.o(140884);
  }
  
  public static abstract interface a
  {
    public abstract void Bp();
    
    public abstract int bq(boolean paramBoolean);
    
    public abstract void h(int paramInt, float paramFloat);
    
    public abstract void m(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends b.a
  {
    private boolean KgJ;
    
    private c() {}
    
    public final void M(int paramInt)
    {
      AppMethodBeat.i(140881);
      super.M(paramInt);
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (localIterator.hasNext()) {
          ((SwipeBackLayout.a)localIterator.next()).h(paramInt, SwipeBackLayout.j(SwipeBackLayout.this));
        }
      }
      AppMethodBeat.o(140881);
    }
    
    public final void a(View paramView, float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(140878);
      int i = paramView.getWidth();
      int j = paramView.getHeight();
      int k = 0;
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x1) != 0) {
        if ((paramFloat1 > 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.j(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this))))
        {
          i = i + SwipeBackLayout.g(SwipeBackLayout.this).getIntrinsicWidth() + 10;
          j = 0;
        }
      }
      for (;;)
      {
        k = i;
        if (SwipeBackLayout.c(SwipeBackLayout.this) != null)
        {
          k = i;
          if (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty())
          {
            paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
            label125:
            do
            {
              k = i;
              if (!paramView.hasNext()) {
                break label356;
              }
              SwipeBackLayout.a locala = (SwipeBackLayout.a)paramView.next();
              if (i != 0) {}
              for (boolean bool = true;; bool = false)
              {
                k = locala.bq(bool);
                if (k != 2) {
                  break label344;
                }
                i = 0;
                break label125;
                i = 0;
                break;
                if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x2) != 0)
                {
                  if ((paramFloat1 < 0.0F) || ((paramFloat1 == 0.0F) && (SwipeBackLayout.j(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this)))) {}
                  for (i = -(i + SwipeBackLayout.g(SwipeBackLayout.this).getIntrinsicWidth() + 10);; i = 0)
                  {
                    j = 0;
                    break;
                  }
                }
                if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) == 0) {
                  break label687;
                }
                if ((paramFloat2 < 0.0F) || ((paramFloat2 == 0.0F) && (SwipeBackLayout.j(SwipeBackLayout.this) > SwipeBackLayout.k(SwipeBackLayout.this)))) {}
                for (i = -(SwipeBackLayout.i(SwipeBackLayout.this).getIntrinsicHeight() + j + 10);; i = 0)
                {
                  j = i;
                  i = k;
                  break;
                }
              }
            } while (k != 3);
            label344:
            AppMethodBeat.o(140878);
            return;
          }
        }
        label356:
        paramView = SwipeBackLayout.b(SwipeBackLayout.this);
        if (!paramView.TO)
        {
          paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
          AppMethodBeat.o(140878);
          throw paramView;
        }
        int n = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
        int i1 = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
        i = paramView.TN.getLeft();
        int m = paramView.TN.getTop();
        k -= i;
        j -= m;
        if ((k == 0) && (j == 0))
        {
          paramView.mjD.RH.abortAnimation();
          paramView.be(0);
          SwipeBackLayout.this.invalidate();
          AppMethodBeat.o(140878);
          return;
        }
        n = b.i(n, (int)paramView.TJ, (int)paramView.TI);
        i1 = b.i(i1, (int)paramView.TJ, (int)paramView.TI);
        int i2 = Math.abs(k);
        int i3 = Math.abs(j);
        int i4 = Math.abs(n);
        int i5 = Math.abs(i1);
        int i6 = i4 + i5;
        int i7 = i2 + i3;
        if (n != 0)
        {
          paramFloat1 = i4 / i6;
          label575:
          if (i1 == 0) {
            break label676;
          }
        }
        label676:
        for (paramFloat2 = i5 / i6;; paramFloat2 = i3 / i7)
        {
          n = paramView.h(k, n, paramView.KgM.fdh());
          i1 = paramView.h(j, i1, paramView.KgM.bH());
          float f = n;
          n = (int)(paramFloat2 * i1 + paramFloat1 * f);
          paramView.mjD.startScroll(i, m, k, j, n);
          paramView.be(2);
          break;
          paramFloat1 = i2 / i7;
          break label575;
        }
        label687:
        j = 0;
        i = k;
      }
    }
    
    public final boolean aaf(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(140874);
      int j = SwipeBackLayout.b(SwipeBackLayout.this).kT(SwipeBackLayout.a(SwipeBackLayout.this), paramInt);
      if (j != 0)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this).kT(1, paramInt)) {
          SwipeBackLayout.a(SwipeBackLayout.this, 1);
        }
        while ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
        {
          Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
          while (localIterator.hasNext())
          {
            SwipeBackLayout.a locala = (SwipeBackLayout.a)localIterator.next();
            SwipeBackLayout.d(SwipeBackLayout.this);
            locala.Bp();
          }
          if (SwipeBackLayout.b(SwipeBackLayout.this).kT(2, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 2);
          } else if (SwipeBackLayout.b(SwipeBackLayout.this).kT(8, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 8);
          }
        }
        this.KgJ = true;
      }
      if ((SwipeBackLayout.a(SwipeBackLayout.this) == 1) || (SwipeBackLayout.a(SwipeBackLayout.this) == 2)) {
        if (!SwipeBackLayout.b(SwipeBackLayout.this).kS(2, paramInt))
        {
          paramInt = 1;
          i = paramInt;
        }
      }
      for (;;)
      {
        boolean bool = SwipeBackLayout.e(SwipeBackLayout.this);
        AppMethodBeat.o(140874);
        return j & i & bool;
        paramInt = 0;
        break;
        if (SwipeBackLayout.a(SwipeBackLayout.this) == 8)
        {
          if (SwipeBackLayout.b(SwipeBackLayout.this).kS(1, paramInt)) {
            i = 0;
          }
        }
        else if (SwipeBackLayout.a(SwipeBackLayout.this) != 11) {
          i = 0;
        }
      }
    }
    
    public final int bH()
    {
      AppMethodBeat.i(140876);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140876);
      return i & 0x8;
    }
    
    public final int d(View paramView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(140880);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) != 0) {
        i = Math.min(0, Math.max(paramInt, -paramView.getHeight()));
      }
      AppMethodBeat.o(140880);
      return i;
    }
    
    public final int e(View paramView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(140879);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x1) != 0) {
        i = Math.min(paramView.getWidth(), Math.max(paramInt, 0));
      }
      for (;;)
      {
        AppMethodBeat.o(140879);
        return i;
        if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x2) != 0) {
          i = Math.min(0, Math.max(paramInt, -paramView.getWidth()));
        }
      }
    }
    
    public final int fdh()
    {
      AppMethodBeat.i(140875);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140875);
      return i & 0x3;
    }
    
    public final void o(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(140877);
      super.o(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x1) != 0) {
        SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.g(SwipeBackLayout.this).getIntrinsicWidth())));
      }
      for (;;)
      {
        SwipeBackLayout.b(SwipeBackLayout.this, paramInt1);
        SwipeBackLayout.c(SwipeBackLayout.this, paramInt2);
        SwipeBackLayout.this.invalidate();
        if ((SwipeBackLayout.j(SwipeBackLayout.this) < SwipeBackLayout.k(SwipeBackLayout.this)) && (!this.KgJ)) {
          this.KgJ = true;
        }
        if ((SwipeBackLayout.c(SwipeBackLayout.this) == null) || (SwipeBackLayout.c(SwipeBackLayout.this).isEmpty())) {
          break;
        }
        paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (paramView.hasNext()) {
          ((SwipeBackLayout.a)paramView.next()).h(SwipeBackLayout.b(SwipeBackLayout.this).Tz, SwipeBackLayout.j(SwipeBackLayout.this));
        }
        if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x2) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.h(SwipeBackLayout.this).getIntrinsicWidth())));
        } else if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt2 / (SwipeBackLayout.f(SwipeBackLayout.this).getHeight() + SwipeBackLayout.i(SwipeBackLayout.this).getIntrinsicHeight())));
        }
      }
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()) && (SwipeBackLayout.b(SwipeBackLayout.this).Tz == 1) && (SwipeBackLayout.j(SwipeBackLayout.this) >= SwipeBackLayout.k(SwipeBackLayout.this)) && (this.KgJ))
      {
        this.KgJ = false;
        paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (paramView.hasNext()) {
          paramView.next();
        }
      }
      if ((SwipeBackLayout.j(SwipeBackLayout.this) >= 1.0F) && (SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
      {
        paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (paramView.hasNext())
        {
          SwipeBackLayout.a locala = (SwipeBackLayout.a)paramView.next();
          if ((locala instanceof SwipeBackLayout.b)) {
            ((SwipeBackLayout.b)locala).bjc();
          }
        }
      }
      AppMethodBeat.o(140877);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */