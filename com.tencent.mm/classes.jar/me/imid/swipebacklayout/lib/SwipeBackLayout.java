package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.g.z;
import androidx.core.widget.i;
import com.tencent.luggage.a.a;
import com.tencent.luggage.a.d;
import com.tencent.luggage.a.h;
import com.tencent.luggage.a.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class SwipeBackLayout
  extends FrameLayout
{
  private static final int[] ajFh = { 1, 2, 8, 11 };
  private CopyOnWriteArrayList<a> ahMX;
  private int ajFi;
  private b ajFj;
  private Drawable ajFk;
  private int ajFl;
  private int bxX;
  private float bxY;
  private Drawable bys;
  private Drawable byt;
  private Rect byy;
  private View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  private float mqp;
  private int mqq;
  private int mqr;
  private float mqt;
  
  public SwipeBackLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.a.SwipeBackLayoutStyle);
  }
  
  public SwipeBackLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(140882);
    this.mqp = 0.3F;
    this.mEnable = true;
    this.bxX = -1728053248;
    this.byy = new Rect();
    this.ajFj = b.a(this, new c((byte)0));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.SwipeBackLayout, paramInt, a.h.SwipeBackLayout);
    paramInt = paramContext.getDimensionPixelSize(a.i.SwipeBackLayout_edge_size, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(ajFh[paramContext.getInt(a.i.SwipeBackLayout_edge_flag, 0)]);
    paramInt = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_left, a.d.shadow_left);
    int i = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_right, a.d.shadow_right);
    int j = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_bottom, a.d.shadow_bottom);
    qz(paramInt, 1);
    qz(i, 2);
    qz(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.ajFj.bxI = f;
    this.ajFj.bxH = (f * 2.0F);
    AppMethodBeat.o(140882);
  }
  
  private void g(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(140887);
    if ((paramInt & 0x1) != 0) {
      this.bys = paramDrawable;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(140887);
      return;
      if ((paramInt & 0x2) != 0) {
        this.byt = paramDrawable;
      } else if ((paramInt & 0x8) != 0) {
        this.ajFk = paramDrawable;
      }
    }
  }
  
  private void qz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140888);
    g(getResources().getDrawable(paramInt1), paramInt2);
    AppMethodBeat.o(140888);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140885);
    if (this.ahMX == null) {
      this.ahMX = new CopyOnWriteArrayList();
    }
    this.ahMX.add(parama);
    AppMethodBeat.o(140885);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(140894);
    this.bxY = (1.0F - this.mqt);
    b localb = this.ajFj;
    boolean bool;
    int i;
    if (localb.bxy == 2)
    {
      bool = localb.mri.bwz.computeScrollOffset();
      i = localb.mri.bwz.getCurrX();
      int j = localb.mri.bwz.getCurrY();
      int k = i - localb.bxM.getLeft();
      int m = j - localb.bxM.getTop();
      if (k != 0) {
        localb.bxM.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localb.bxM.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localb.ajFp.m(localb.bxM, i, j, k, m);
      }
      if ((!bool) || (i != localb.mri.bwz.getFinalX()) || (j != localb.mri.bwz.getFinalY())) {
        break label253;
      }
      localb.mri.bwz.abortAnimation();
      bool = localb.mri.bwz.isFinished();
    }
    label253:
    for (;;)
    {
      if (!bool) {
        localb.bxO.post(localb.bxP);
      }
      if (localb.bxy == 2) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          z.Q(this);
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
    if ((this.ahMX != null) && (!this.ahMX.isEmpty()))
    {
      localObject = this.ahMX.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).n(paramMotionEvent);
      }
    }
    if (this.ajFj.bxy == 1)
    {
      this.ajFj.j(paramMotionEvent);
      AppMethodBeat.o(140889);
      return true;
    }
    try
    {
      localObject = this.ajFj;
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
          f3 = f1 - localObject.bxz[k];
          f4 = f2 - localObject.bxA[k];
          ((b)localObject).b(f3, f4, k);
          if (((b)localObject).bxy != 1)
          {
            localView = ((b)localObject).aF((int)f1, (int)f2);
            if ((localView == null) || (!((b)localObject).c(localView, f3, f4)) || (!((b)localObject).C(localView, k))) {
              break;
            }
          }
        }
        ((b)localObject).h(paramMotionEvent);
      }
    }
    catch (IllegalArgumentException paramMotionEvent)
    {
      for (;;)
      {
        AppMethodBeat.o(140889);
        return false;
        ((b)localObject).eK(paramMotionEvent.getPointerId(i));
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      AppMethodBeat.o(140889);
      return false;
    }
    if (((b)localObject).bxy == 1) {}
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
        localView = ((b)localObject).aF((int)f1, (int)f2);
        if ((localView == ((b)localObject).bxM) && (((b)localObject).bxy == 2)) {
          ((b)localObject).C(localView, i);
        }
        if ((localObject.ajFo[i] & ((b)localObject).bxK) == 0) {
          break;
        }
        break;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        ((b)localObject).a(f1, f2, j);
        if ((((b)localObject).bxy == 0) || (((b)localObject).bxy != 2)) {
          break;
        }
        localView = ((b)localObject).aF((int)f1, (int)f2);
        if (localView != ((b)localObject).bxM) {
          break;
        }
        ((b)localObject).C(localView, j);
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
      if ((this.bxY > 0.0F) && (i != 0) && (this.ajFj.bxy != 0))
      {
        Rect localRect = this.byy;
        paramView.getHitRect(localRect);
        if ((this.ajFi & 0x1) != 0)
        {
          this.bys.setBounds(localRect.left - this.bys.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
          this.bys.setAlpha((int)(this.bxY * 255.0F));
          this.bys.draw(paramCanvas);
        }
        if ((this.ajFi & 0x2) != 0)
        {
          this.byt.setBounds(localRect.right, localRect.top, localRect.right + this.byt.getIntrinsicWidth(), localRect.bottom);
          this.byt.setAlpha((int)(this.bxY * 255.0F));
          this.byt.draw(paramCanvas);
        }
        if ((this.ajFi & 0x8) != 0)
        {
          this.ajFk.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.ajFk.getIntrinsicHeight());
          this.ajFk.setAlpha((int)(this.bxY * 255.0F));
          this.ajFk.draw(paramCanvas);
        }
        i = (int)(((this.bxX & 0xFF000000) >>> 24) * this.bxY);
        j = this.bxX;
        if ((this.ajFl & 0x1) == 0) {
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
      if ((this.ajFl & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.ajFl & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  public View getTargetView()
  {
    return this.mContentView;
  }
  
  public final void kFQ()
  {
    AppMethodBeat.i(186534);
    this.mqt = 0.0F;
    this.ajFj.cancel();
    this.ajFj.eM(0);
    if ((this.mqq != 0) || (this.mqr != 0))
    {
      this.mqr = 0;
      this.mqq = 0;
      requestLayout();
    }
    AppMethodBeat.o(186534);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140891);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.mqq, this.mqr, this.mqq + this.mContentView.getMeasuredWidth(), this.mqr + this.mContentView.getMeasuredHeight());
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
    this.ajFj.j(paramMotionEvent);
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
    this.ajFj.bxJ = paramInt;
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.ajFi = paramInt;
    this.ajFj.bxK = this.ajFi;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.ajFj.bxH = paramFloat;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.ajFj.bxI = paramFloat;
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(140883);
    this.bxX = paramInt;
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
    this.mqp = paramFloat;
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
    public abstract void aoM();
    
    public abstract int cI(boolean paramBoolean);
    
    public abstract void n(int paramInt, float paramFloat);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends b.a
  {
    private boolean ajFm;
    
    private c() {}
    
    public final void F(int paramInt)
    {
      AppMethodBeat.i(140881);
      super.F(paramInt);
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (localIterator.hasNext()) {
          ((SwipeBackLayout.a)localIterator.next()).n(paramInt, SwipeBackLayout.j(SwipeBackLayout.this));
        }
      }
      AppMethodBeat.o(140881);
    }
    
    public final int aM()
    {
      AppMethodBeat.i(140876);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140876);
      return i & 0x8;
    }
    
    public final int aXi()
    {
      AppMethodBeat.i(140875);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140875);
      return i & 0x3;
    }
    
    public final void b(View paramView, float paramFloat1, float paramFloat2)
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
                k = locala.cI(bool);
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
        if (!paramView.bxN)
        {
          paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
          AppMethodBeat.o(140878);
          throw paramView;
        }
        int n = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
        int i1 = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
        i = paramView.bxM.getLeft();
        int m = paramView.bxM.getTop();
        k -= i;
        j -= m;
        if ((k == 0) && (j == 0))
        {
          paramView.mri.bwz.abortAnimation();
          paramView.eM(0);
          SwipeBackLayout.this.invalidate();
          AppMethodBeat.o(140878);
          return;
        }
        n = b.t(n, (int)paramView.bxI, (int)paramView.bxH);
        i1 = b.t(i1, (int)paramView.bxI, (int)paramView.bxH);
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
          n = paramView.s(k, n, paramView.ajFp.aXi());
          i1 = paramView.s(j, i1, paramView.ajFp.aM());
          float f = n;
          n = (int)(paramFloat2 * i1 + paramFloat1 * f);
          paramView.mri.startScroll(i, m, k, j, n);
          paramView.eM(2);
          break;
          paramFloat1 = i2 / i7;
          break label575;
        }
        label687:
        j = 0;
        i = k;
      }
    }
    
    public final int c(View paramView, int paramInt)
    {
      int i = 0;
      AppMethodBeat.i(140880);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) != 0) {
        i = Math.min(0, Math.max(paramInt, -paramView.getHeight()));
      }
      AppMethodBeat.o(140880);
      return i;
    }
    
    public final int d(View paramView, int paramInt)
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
    
    public final void m(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(140877);
      super.m(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x1) != 0) {
        SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.g(SwipeBackLayout.this).getIntrinsicWidth())));
      }
      for (;;)
      {
        SwipeBackLayout.b(SwipeBackLayout.this, paramInt1);
        SwipeBackLayout.c(SwipeBackLayout.this, paramInt2);
        SwipeBackLayout.this.invalidate();
        if ((SwipeBackLayout.j(SwipeBackLayout.this) < SwipeBackLayout.k(SwipeBackLayout.this)) && (!this.ajFm)) {
          this.ajFm = true;
        }
        if ((SwipeBackLayout.c(SwipeBackLayout.this) == null) || (SwipeBackLayout.c(SwipeBackLayout.this).isEmpty())) {
          break;
        }
        paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (paramView.hasNext()) {
          ((SwipeBackLayout.a)paramView.next()).n(SwipeBackLayout.b(SwipeBackLayout.this).bxy, SwipeBackLayout.j(SwipeBackLayout.this));
        }
        if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x2) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.h(SwipeBackLayout.this).getIntrinsicWidth())));
        } else if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt2 / (SwipeBackLayout.f(SwipeBackLayout.this).getHeight() + SwipeBackLayout.i(SwipeBackLayout.this).getIntrinsicHeight())));
        }
      }
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()) && (SwipeBackLayout.b(SwipeBackLayout.this).bxy == 1) && (SwipeBackLayout.j(SwipeBackLayout.this) >= SwipeBackLayout.k(SwipeBackLayout.this)) && (this.ajFm))
      {
        this.ajFm = false;
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
            ((SwipeBackLayout.b)locala).cDW();
          }
        }
      }
      AppMethodBeat.o(140877);
    }
    
    public final boolean rT(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(140874);
      int j = SwipeBackLayout.b(SwipeBackLayout.this).qA(SwipeBackLayout.a(SwipeBackLayout.this), paramInt);
      if (j != 0)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this).qA(1, paramInt)) {
          SwipeBackLayout.a(SwipeBackLayout.this, 1);
        }
        while ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
        {
          Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
          while (localIterator.hasNext())
          {
            SwipeBackLayout.a locala = (SwipeBackLayout.a)localIterator.next();
            SwipeBackLayout.d(SwipeBackLayout.this);
            locala.aoM();
          }
          if (SwipeBackLayout.b(SwipeBackLayout.this).qA(2, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 2);
          } else if (SwipeBackLayout.b(SwipeBackLayout.this).qA(8, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 8);
          }
        }
        this.ajFm = true;
      }
      if ((SwipeBackLayout.a(SwipeBackLayout.this) == 1) || (SwipeBackLayout.a(SwipeBackLayout.this) == 2)) {
        if (!SwipeBackLayout.b(SwipeBackLayout.this).jU(2, paramInt))
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
          if (SwipeBackLayout.b(SwipeBackLayout.this).jU(1, paramInt)) {
            i = 0;
          }
        }
        else if (SwipeBackLayout.a(SwipeBackLayout.this) != 11) {
          i = 0;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     me.imid.swipebacklayout.lib.SwipeBackLayout
 * JD-Core Version:    0.7.0.1
 */