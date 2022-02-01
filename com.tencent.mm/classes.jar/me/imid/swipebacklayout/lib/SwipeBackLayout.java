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
import androidx.core.g.w;
import androidx.core.widget.h;
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
  private static final int[] abEe = { 1, 2, 8, 11 };
  private int RG;
  private float RH;
  private Drawable Sc;
  private Drawable Sd;
  private Rect Si;
  private CopyOnWriteArrayList<a> ZHU;
  private int abEf;
  private b abEg;
  private Drawable abEh;
  private int abEi;
  private float jRf;
  private int jRg;
  private int jRh;
  private float jRj;
  private View mContentView;
  private boolean mEnable;
  private boolean mInLayout;
  
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
    this.jRf = 0.3F;
    this.mEnable = true;
    this.RG = -1728053248;
    this.Si = new Rect();
    this.abEg = b.a(this, new c((byte)0));
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.i.SwipeBackLayout, paramInt, a.h.SwipeBackLayout);
    paramInt = paramContext.getDimensionPixelSize(a.i.SwipeBackLayout_edge_size, -1);
    if (paramInt > 0) {
      setEdgeSize(paramInt);
    }
    setEdgeTrackingEnabled(abEe[paramContext.getInt(a.i.SwipeBackLayout_edge_flag, 0)]);
    paramInt = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_left, a.d.shadow_left);
    int i = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_right, a.d.shadow_right);
    int j = paramContext.getResourceId(a.i.SwipeBackLayout_shadow_bottom, a.d.shadow_bottom);
    oA(paramInt, 1);
    oA(i, 2);
    oA(j, 8);
    paramContext.recycle();
    float f = getResources().getDisplayMetrics().density * 400.0F;
    this.abEg.Rr = f;
    this.abEg.Rq = (f * 2.0F);
    AppMethodBeat.o(140882);
  }
  
  private void g(Drawable paramDrawable, int paramInt)
  {
    AppMethodBeat.i(140887);
    if ((paramInt & 0x1) != 0) {
      this.Sc = paramDrawable;
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(140887);
      return;
      if ((paramInt & 0x2) != 0) {
        this.Sd = paramDrawable;
      } else if ((paramInt & 0x8) != 0) {
        this.abEh = paramDrawable;
      }
    }
  }
  
  private void oA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(140888);
    g(getResources().getDrawable(paramInt1), paramInt2);
    AppMethodBeat.o(140888);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(140885);
    if (this.ZHU == null) {
      this.ZHU = new CopyOnWriteArrayList();
    }
    this.ZHU.add(parama);
    AppMethodBeat.o(140885);
  }
  
  public void computeScroll()
  {
    AppMethodBeat.i(140894);
    this.RH = (1.0F - this.jRj);
    b localb = this.abEg;
    boolean bool;
    int i;
    if (localb.Rh == 2)
    {
      bool = localb.jRY.Qi.computeScrollOffset();
      i = localb.jRY.Qi.getCurrX();
      int j = localb.jRY.Qi.getCurrY();
      int k = i - localb.Rv.getLeft();
      int m = j - localb.Rv.getTop();
      if (k != 0) {
        localb.Rv.offsetLeftAndRight(k);
      }
      if (m != 0) {
        localb.Rv.offsetTopAndBottom(m);
      }
      if ((k != 0) || (m != 0)) {
        localb.abEm.l(localb.Rv, i, j, k, m);
      }
      if ((!bool) || (i != localb.jRY.Qi.getFinalX()) || (j != localb.jRY.Qi.getFinalY())) {
        break label253;
      }
      localb.jRY.Qi.abortAnimation();
      bool = localb.jRY.Qi.isFinished();
    }
    label253:
    for (;;)
    {
      if (!bool) {
        localb.Rx.post(localb.Ry);
      }
      if (localb.Rh == 2) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          w.G(this);
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
    if ((this.ZHU != null) && (!this.ZHU.isEmpty()))
    {
      localObject = this.ZHU.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((a)((Iterator)localObject).next()).n(paramMotionEvent);
      }
    }
    if (this.abEg.Rh == 1)
    {
      this.abEg.j(paramMotionEvent);
      AppMethodBeat.o(140889);
      return true;
    }
    try
    {
      localObject = this.abEg;
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
          f3 = f1 - localObject.Ri[k];
          f4 = f2 - localObject.Rj[k];
          ((b)localObject).b(f3, f4, k);
          if (((b)localObject).Rh != 1)
          {
            localView = ((b)localObject).K((int)f1, (int)f2);
            if ((localView == null) || (!((b)localObject).b(localView, f3, f4)) || (!((b)localObject).y(localView, k))) {
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
        ((b)localObject).bP(paramMotionEvent.getPointerId(i));
      }
    }
    catch (ArrayIndexOutOfBoundsException paramMotionEvent)
    {
      AppMethodBeat.o(140889);
      return false;
    }
    if (((b)localObject).Rh == 1) {}
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
        localView = ((b)localObject).K((int)f1, (int)f2);
        if ((localView == ((b)localObject).Rv) && (((b)localObject).Rh == 2)) {
          ((b)localObject).y(localView, i);
        }
        if ((localObject.abEl[i] & ((b)localObject).Rt) == 0) {
          break;
        }
        break;
        j = paramMotionEvent.getPointerId(i);
        f1 = paramMotionEvent.getX(i);
        f2 = paramMotionEvent.getY(i);
        ((b)localObject).a(f1, f2, j);
        if ((((b)localObject).Rh == 0) || (((b)localObject).Rh != 2)) {
          break;
        }
        localView = ((b)localObject).K((int)f1, (int)f2);
        if (localView != ((b)localObject).Rv) {
          break;
        }
        ((b)localObject).y(localView, j);
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
      if ((this.RH > 0.0F) && (i != 0) && (this.abEg.Rh != 0))
      {
        Rect localRect = this.Si;
        paramView.getHitRect(localRect);
        if ((this.abEf & 0x1) != 0)
        {
          this.Sc.setBounds(localRect.left - this.Sc.getIntrinsicWidth(), localRect.top, localRect.left, localRect.bottom);
          this.Sc.setAlpha((int)(this.RH * 255.0F));
          this.Sc.draw(paramCanvas);
        }
        if ((this.abEf & 0x2) != 0)
        {
          this.Sd.setBounds(localRect.right, localRect.top, localRect.right + this.Sd.getIntrinsicWidth(), localRect.bottom);
          this.Sd.setAlpha((int)(this.RH * 255.0F));
          this.Sd.draw(paramCanvas);
        }
        if ((this.abEf & 0x8) != 0)
        {
          this.abEh.setBounds(localRect.left, localRect.bottom, localRect.right, localRect.bottom + this.abEh.getIntrinsicHeight());
          this.abEh.setAlpha((int)(this.RH * 255.0F));
          this.abEh.draw(paramCanvas);
        }
        i = (int)(((this.RG & 0xFF000000) >>> 24) * this.RH);
        j = this.RG;
        if ((this.abEi & 0x1) == 0) {
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
      if ((this.abEi & 0x2) != 0) {
        paramCanvas.clipRect(paramView.getRight(), 0, getRight(), getHeight());
      } else if ((this.abEi & 0x8) != 0) {
        paramCanvas.clipRect(paramView.getLeft(), paramView.getBottom(), getRight(), getHeight());
      }
    }
  }
  
  public View getTargetView()
  {
    return this.mContentView;
  }
  
  public final void iUp()
  {
    AppMethodBeat.i(209644);
    this.jRj = 0.0F;
    this.abEg.cancel();
    this.abEg.bR(0);
    if ((this.jRg != 0) || (this.jRh != 0))
    {
      this.jRh = 0;
      this.jRg = 0;
      requestLayout();
    }
    AppMethodBeat.o(209644);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140891);
    this.mInLayout = true;
    if (this.mContentView != null) {
      this.mContentView.layout(this.jRg, this.jRh, this.jRg + this.mContentView.getMeasuredWidth(), this.jRh + this.mContentView.getMeasuredHeight());
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
    this.abEg.j(paramMotionEvent);
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
    this.abEg.Rs = paramInt;
  }
  
  public void setEdgeTrackingEnabled(int paramInt)
  {
    this.abEf = paramInt;
    this.abEg.Rt = this.abEf;
  }
  
  public void setEnableGesture(boolean paramBoolean)
  {
    this.mEnable = paramBoolean;
  }
  
  public void setMaxVelocity(float paramFloat)
  {
    this.abEg.Rq = paramFloat;
  }
  
  public void setMinVelocity(float paramFloat)
  {
    this.abEg.Rr = paramFloat;
  }
  
  public void setScrimColor(int paramInt)
  {
    AppMethodBeat.i(140883);
    this.RG = paramInt;
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
    this.jRf = paramFloat;
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
    public abstract void OE();
    
    public abstract int cc(boolean paramBoolean);
    
    public abstract void j(int paramInt, float paramFloat);
    
    public abstract void n(MotionEvent paramMotionEvent);
  }
  
  final class c
    extends b.a
  {
    private boolean abEj;
    
    private c() {}
    
    public final void G(int paramInt)
    {
      AppMethodBeat.i(140881);
      super.G(paramInt);
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
      {
        Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (localIterator.hasNext()) {
          ((SwipeBackLayout.a)localIterator.next()).j(paramInt, SwipeBackLayout.j(SwipeBackLayout.this));
        }
      }
      AppMethodBeat.o(140881);
    }
    
    public final int U()
    {
      AppMethodBeat.i(140876);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140876);
      return i & 0x8;
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
                k = locala.cc(bool);
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
        if (!paramView.Rw)
        {
          paramView = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
          AppMethodBeat.o(140878);
          throw paramView;
        }
        int n = (int)paramView.mVelocityTracker.getXVelocity(paramView.mActivePointerId);
        int i1 = (int)paramView.mVelocityTracker.getYVelocity(paramView.mActivePointerId);
        i = paramView.Rv.getLeft();
        int m = paramView.Rv.getTop();
        k -= i;
        j -= m;
        if ((k == 0) && (j == 0))
        {
          paramView.jRY.Qi.abortAnimation();
          paramView.bR(0);
          SwipeBackLayout.this.invalidate();
          AppMethodBeat.o(140878);
          return;
        }
        n = b.f(n, (int)paramView.Rr, (int)paramView.Rq);
        i1 = b.f(i1, (int)paramView.Rr, (int)paramView.Rq);
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
          n = paramView.e(k, n, paramView.abEm.aEe());
          i1 = paramView.e(j, i1, paramView.abEm.U());
          float f = n;
          n = (int)(paramFloat2 * i1 + paramFloat1 * f);
          paramView.jRY.startScroll(i, m, k, j, n);
          paramView.bR(2);
          break;
          paramFloat1 = i2 / i7;
          break label575;
        }
        label687:
        j = 0;
        i = k;
      }
    }
    
    public final int aEe()
    {
      AppMethodBeat.i(140875);
      int i = SwipeBackLayout.a(SwipeBackLayout.this);
      AppMethodBeat.o(140875);
      return i & 0x3;
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
    
    public final void l(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(140877);
      super.l(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
      if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x1) != 0) {
        SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.g(SwipeBackLayout.this).getIntrinsicWidth())));
      }
      for (;;)
      {
        SwipeBackLayout.b(SwipeBackLayout.this, paramInt1);
        SwipeBackLayout.c(SwipeBackLayout.this, paramInt2);
        SwipeBackLayout.this.invalidate();
        if ((SwipeBackLayout.j(SwipeBackLayout.this) < SwipeBackLayout.k(SwipeBackLayout.this)) && (!this.abEj)) {
          this.abEj = true;
        }
        if ((SwipeBackLayout.c(SwipeBackLayout.this) == null) || (SwipeBackLayout.c(SwipeBackLayout.this).isEmpty())) {
          break;
        }
        paramView = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
        while (paramView.hasNext()) {
          ((SwipeBackLayout.a)paramView.next()).j(SwipeBackLayout.b(SwipeBackLayout.this).Rh, SwipeBackLayout.j(SwipeBackLayout.this));
        }
        if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x2) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt1 / (SwipeBackLayout.f(SwipeBackLayout.this).getWidth() + SwipeBackLayout.h(SwipeBackLayout.this).getIntrinsicWidth())));
        } else if ((SwipeBackLayout.d(SwipeBackLayout.this) & 0x8) != 0) {
          SwipeBackLayout.a(SwipeBackLayout.this, Math.abs(paramInt2 / (SwipeBackLayout.f(SwipeBackLayout.this).getHeight() + SwipeBackLayout.i(SwipeBackLayout.this).getIntrinsicHeight())));
        }
      }
      if ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()) && (SwipeBackLayout.b(SwipeBackLayout.this).Rh == 1) && (SwipeBackLayout.j(SwipeBackLayout.this) >= SwipeBackLayout.k(SwipeBackLayout.this)) && (this.abEj))
      {
        this.abEj = false;
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
            ((SwipeBackLayout.b)locala).cdv();
          }
        }
      }
      AppMethodBeat.o(140877);
    }
    
    public final boolean rS(int paramInt)
    {
      int i = 1;
      AppMethodBeat.i(140874);
      int j = SwipeBackLayout.b(SwipeBackLayout.this).oB(SwipeBackLayout.a(SwipeBackLayout.this), paramInt);
      if (j != 0)
      {
        if (SwipeBackLayout.b(SwipeBackLayout.this).oB(1, paramInt)) {
          SwipeBackLayout.a(SwipeBackLayout.this, 1);
        }
        while ((SwipeBackLayout.c(SwipeBackLayout.this) != null) && (!SwipeBackLayout.c(SwipeBackLayout.this).isEmpty()))
        {
          Iterator localIterator = SwipeBackLayout.c(SwipeBackLayout.this).iterator();
          while (localIterator.hasNext())
          {
            SwipeBackLayout.a locala = (SwipeBackLayout.a)localIterator.next();
            SwipeBackLayout.d(SwipeBackLayout.this);
            locala.OE();
          }
          if (SwipeBackLayout.b(SwipeBackLayout.this).oB(2, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 2);
          } else if (SwipeBackLayout.b(SwipeBackLayout.this).oB(8, paramInt)) {
            SwipeBackLayout.a(SwipeBackLayout.this, 8);
          }
        }
        this.abEj = true;
      }
      if ((SwipeBackLayout.a(SwipeBackLayout.this) == 1) || (SwipeBackLayout.a(SwipeBackLayout.this) == 2)) {
        if (!SwipeBackLayout.b(SwipeBackLayout.this).iq(2, paramInt))
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
          if (SwipeBackLayout.b(SwipeBackLayout.this).iq(1, paramInt)) {
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