package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import androidx.core.g.d;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/MMOverScrollView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "dispatchCancel", "", "enableGesture", "flingToZero", "gesture", "Landroidx/core/view/GestureDetectorCompat;", "gestureListener", "Landroid/view/GestureDetector$OnGestureListener;", "interceptGestureOnce", "isAtBottom", "isAtBottomCallBack", "Lcom/tencent/mm/ui/base/MMPullDownView$IsAtBottomCallBack;", "isAtTop", "isAtTopCallBack", "Lcom/tencent/mm/ui/base/MMPullDownView$IsAtTopCallBack;", "isFlinging", "isScrolling", "isTouching", "scrollConsumer", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "getScrollConsumer", "()Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "setScrollConsumer", "(Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;)V", "scroller", "Landroid/widget/OverScroller;", "touchConsumed", "touchMoved", "viewProvider", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "getViewProvider", "()Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "computeScroll", "", "dispatchToClip", "child", "Landroid/view/View;", "ev", "Landroid/view/MotionEvent;", "offsetTouchPoint", "Landroid/graphics/PointF;", "dispatchTouchEvent", "findAcceptChild", "parent", "Landroid/view/ViewGroup;", "point", "onTouchEvent", "event", "scrollTo", "x", "y", "setAtBottomCallBack", "callBack", "setAtTopCallBack", "setEnableGesture", "IScrollConsumer", "IScrollViewProvider", "PullDownScroller", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMOverScrollView
  extends FrameLayout
{
  private boolean CIK;
  private boolean LPf;
  private boolean OXq;
  private boolean SAm;
  private final String TAG;
  private boolean XQs;
  private MMPullDownView.c adSg;
  private MMPullDownView.d adSh;
  public boolean adSi;
  private final GestureDetector.OnGestureListener adSj;
  private final d adSk;
  private boolean adSl;
  private boolean adSm;
  private boolean adSn;
  private final b adSo;
  private a adSp;
  private final OverScroller doG;
  private boolean mkh;
  private boolean mkj;
  
  public MMOverScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(251438);
    AppMethodBeat.o(251438);
  }
  
  public MMOverScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(251430);
    this.TAG = "MicroMsg.MMOverScrollView";
    this.CIK = true;
    this.doG = new OverScroller(paramContext, (Interpolator)new androidx.g.a.a.b());
    this.adSo = ((b)new e(this));
    this.adSp = ((a)new c(this.adSo));
    this.adSj = ((GestureDetector.OnGestureListener)new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251383);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251383);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251380);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251380);
        return bool;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(251370);
        s.u(paramAnonymousMotionEvent1, "e1");
        s.u(paramAnonymousMotionEvent2, "e2");
        paramAnonymousMotionEvent1 = this.adSq.getScrollConsumer();
        if (paramAnonymousMotionEvent1 == null)
        {
          AppMethodBeat.o(251370);
          return false;
        }
        if (this.adSq.getScrollY() < 0)
        {
          MMOverScrollView.b(this.adSq, paramAnonymousMotionEvent1.du(paramAnonymousFloat2));
          AppMethodBeat.o(251370);
          return true;
        }
        AppMethodBeat.o(251370);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251377);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(251377);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(251364);
        s.u(paramAnonymousMotionEvent1, "e1");
        s.u(paramAnonymousMotionEvent2, "e2");
        paramAnonymousMotionEvent1 = this.adSq.getScrollConsumer();
        if (paramAnonymousMotionEvent1 == null)
        {
          AppMethodBeat.o(251364);
          return false;
        }
        boolean bool = paramAnonymousMotionEvent1.dt(paramAnonymousFloat2);
        AppMethodBeat.o(251364);
        return bool;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251375);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/ui/base/MMOverScrollView$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(251375);
        return bool;
      }
    });
    this.adSk = new d(paramContext, this.adSj);
    setClipChildren(false);
    setClipToPadding(false);
    AppMethodBeat.o(251430);
  }
  
  private final View a(ViewGroup paramViewGroup, PointF paramPointF)
  {
    AppMethodBeat.i(251435);
    int k = paramViewGroup.getChildCount();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      View localView = paramViewGroup.getChildAt(i);
      float f1 = localView.getLeft() - paramViewGroup.getScrollX();
      f1 = localView.getTranslationX() + f1;
      float f5 = localView.getRight() - paramViewGroup.getScrollY();
      float f6 = localView.getTranslationX();
      float f2 = localView.getTop() - paramViewGroup.getScrollY() + localView.getTranslationY();
      float f3 = localView.getBottom() - paramViewGroup.getScrollY();
      float f4 = localView.getTranslationY();
      float f7 = paramPointF.x;
      if (f1 <= f7) {
        if (f7 <= f5 + f6)
        {
          i = 1;
          if (i == 0) {
            break label218;
          }
          f5 = paramPointF.y;
          if (f2 > f5) {
            break label212;
          }
          if (f5 > f3 + f4) {
            break label206;
          }
          i = 1;
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label218;
        }
        paramPointF.offset(-f1, -f2);
        AppMethodBeat.o(251435);
        return localView;
        i = 0;
        break;
        i = 0;
        break;
        label206:
        i = 0;
        continue;
        label212:
        i = 0;
      }
      label218:
      if (((localView instanceof ViewGroup)) && (!((ViewGroup)localView).getClipChildren()))
      {
        paramPointF.offset(-f1, -f2);
        localView = a((ViewGroup)localView, paramPointF);
        if (localView != null)
        {
          AppMethodBeat.o(251435);
          return localView;
        }
        paramPointF.offset(f1, f2);
      }
      if (j >= k)
      {
        AppMethodBeat.o(251435);
        return null;
      }
    }
  }
  
  private static boolean a(View paramView, MotionEvent paramMotionEvent, PointF paramPointF)
  {
    AppMethodBeat.i(251431);
    float f1 = paramPointF.x - paramMotionEvent.getX();
    float f2 = paramPointF.y - paramMotionEvent.getY();
    paramMotionEvent.offsetLocation(f1, f2);
    boolean bool = paramView.dispatchTouchEvent(paramMotionEvent);
    paramMotionEvent.offsetLocation(-f1, -f2);
    if ((paramMotionEvent.getAction() == 1) && (bool))
    {
      AppMethodBeat.o(251431);
      return true;
    }
    AppMethodBeat.o(251431);
    return false;
  }
  
  public final void computeScroll()
  {
    AppMethodBeat.i(251470);
    if (this.doG.computeScrollOffset())
    {
      int j = this.doG.getCurrY();
      int i = j;
      if (this.adSl)
      {
        i = j;
        if (j == 1) {
          i = 0;
        }
      }
      scrollTo(0, i);
      z.Q((View)this);
      AppMethodBeat.o(251470);
      return;
    }
    this.adSl = false;
    if ((this.OXq) && (!this.LPf))
    {
      this.OXq = false;
      this.XQs = false;
      a locala = this.adSp;
      if (locala != null) {
        locala.fYb();
      }
    }
    AppMethodBeat.o(251470);
  }
  
  public final boolean dispatchTouchEvent(final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251465);
    s.u(paramMotionEvent, "ev");
    boolean bool;
    if (!this.CIK)
    {
      this.LPf = false;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(251465);
      return bool;
    }
    if ((this.adSi) && (paramMotionEvent.getAction() == 2))
    {
      this.LPf = false;
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(251465);
      return bool;
    }
    this.adSi = false;
    final PointF localPointF = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
    Object localObject1;
    Object localObject2;
    if (paramMotionEvent.getY() < -getScrollY())
    {
      localObject1 = a((ViewGroup)this, localPointF);
      localObject2 = this.adSh;
      if (localObject2 != null) {
        break label250;
      }
      bool = false;
      label133:
      this.adSm = bool;
      localObject2 = this.adSg;
      if (localObject2 != null) {
        break label261;
      }
      bool = false;
      label151:
      this.adSn = bool;
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      localObject2 = (kotlin.g.a.a)new d(this, paramMotionEvent, (View)localObject1, localPointF);
      if ((localObject1 == null) || (this.mkh) || (this.SAm) || (!a((View)localObject1, paramMotionEvent, localPointF))) {
        break label345;
      }
      AppMethodBeat.o(251465);
      return true;
      localObject1 = null;
      break;
      label250:
      bool = ((MMPullDownView.d)localObject2).dsp();
      break label133;
      label261:
      bool = ((MMPullDownView.c)localObject2).dsq();
      break label151;
      this.LPf = true;
      this.SAm = false;
      this.mkh = false;
      this.mkj = false;
      this.XQs = false;
      this.adSl = false;
      this.OXq = false;
      this.doG.forceFinished(true);
      localObject2 = this.adSp;
      if (localObject2 != null)
      {
        ((a)localObject2).hsG();
        continue;
        this.LPf = false;
      }
    }
    label345:
    this.SAm = this.adSk.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction())
    {
    }
    while ((this.SAm) || (this.mkh) || (super.dispatchTouchEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(251465);
      return true;
      if (this.SAm)
      {
        this.mkh = true;
        ((kotlin.g.a.a)localObject2).invoke();
        continue;
        localObject1 = this.adSp;
        if (localObject1 != null) {
          ((a)localObject1).aZ(this.XQs, this.mkh);
        }
        if (this.SAm) {
          ((kotlin.g.a.a)localObject2).invoke();
        }
      }
    }
    AppMethodBeat.o(251465);
    return false;
  }
  
  public final a getScrollConsumer()
  {
    return this.adSp;
  }
  
  public final b getViewProvider()
  {
    return this.adSo;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(251468);
    super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(251468);
    return true;
  }
  
  public final void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251472);
    int i = getScrollY();
    super.scrollTo(paramInt1, paramInt2);
    a locala = this.adSp;
    if (locala != null) {
      locala.amL(paramInt2 - i);
    }
    AppMethodBeat.o(251472);
  }
  
  public final void setAtBottomCallBack(MMPullDownView.c paramc)
  {
    AppMethodBeat.i(251462);
    s.u(paramc, "callBack");
    this.adSg = paramc;
    AppMethodBeat.o(251462);
  }
  
  public final void setAtTopCallBack(MMPullDownView.d paramd)
  {
    AppMethodBeat.i(251461);
    s.u(paramd, "callBack");
    this.adSh = paramd;
    AppMethodBeat.o(251461);
  }
  
  public final void setEnableGesture(boolean paramBoolean)
  {
    this.CIK = paramBoolean;
  }
  
  public final void setScrollConsumer(a parama)
  {
    this.adSp = parama;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "", "onFling", "", "velocityY", "", "onScroll", "distanceY", "onScrollEnd", "", "onScrolled", "dy", "", "onTouchEnd", "isFlinging", "touchMoved", "onTouchStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract boolean aZ(boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void amL(int paramInt);
    
    public abstract boolean dt(float paramFloat);
    
    public abstract boolean du(float paramFloat);
    
    public abstract void fYb();
    
    public abstract boolean hsG();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "", "isAtBottom", "", "()Z", "isAtTop", "scrollY", "", "getScrollY", "()I", "scroller", "Landroid/widget/OverScroller;", "getScroller", "()Landroid/widget/OverScroller;", "flingTo", "", "velocityY", "", "targetY", "scrollBy", "y", "scrollTo", "smoothScrollBy", "dy", "duration", "smoothScrollTo", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void Yn(int paramInt);
    
    public abstract void aAX(int paramInt);
    
    public abstract void aAY(int paramInt);
    
    public abstract void br(int paramInt1, int paramInt2);
    
    public abstract void dX(float paramFloat);
    
    public abstract boolean dsp();
    
    public abstract boolean dsq();
    
    public abstract int getScrollY();
    
    public abstract OverScroller jmx();
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/base/MMOverScrollView$PullDownScroller;", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollConsumer;", "provider", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "(Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;)V", "getProvider", "()Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "onFling", "", "velocityY", "", "onScroll", "distanceY", "onTouchEnd", "isFlinging", "touchMoved", "onTouchStart", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements MMOverScrollView.a
  {
    private final MMOverScrollView.b RVz;
    
    public c(MMOverScrollView.b paramb)
    {
      AppMethodBeat.i(251318);
      this.RVz = paramb;
      AppMethodBeat.o(251318);
    }
    
    public final boolean aZ(boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(251326);
      if (!paramBoolean2)
      {
        AppMethodBeat.o(251326);
        return false;
      }
      if (paramBoolean1)
      {
        AppMethodBeat.o(251326);
        return true;
      }
      this.RVz.br(-this.RVz.getScrollY(), 150);
      AppMethodBeat.o(251326);
      return true;
    }
    
    public final void amL(int paramInt)
    {
      AppMethodBeat.i(251330);
      s.u(this, "this");
      AppMethodBeat.o(251330);
    }
    
    public final boolean dt(float paramFloat)
    {
      AppMethodBeat.i(251319);
      int i = (int)paramFloat + this.RVz.getScrollY();
      if (this.RVz.dsp())
      {
        if (i <= 0)
        {
          this.RVz.Yn((int)paramFloat / 2);
          AppMethodBeat.o(251319);
          return true;
        }
        if (this.RVz.getScrollY() < 0)
        {
          this.RVz.Yn(-this.RVz.getScrollY());
          AppMethodBeat.o(251319);
          return true;
        }
      }
      else if (this.RVz.dsq())
      {
        if (i >= 0)
        {
          this.RVz.Yn((int)paramFloat / 2);
          AppMethodBeat.o(251319);
          return true;
        }
        if (this.RVz.getScrollY() > 0)
        {
          this.RVz.Yn(-this.RVz.getScrollY());
          AppMethodBeat.o(251319);
          return true;
        }
      }
      AppMethodBeat.o(251319);
      return false;
    }
    
    public final boolean du(float paramFloat)
    {
      AppMethodBeat.i(251322);
      if (paramFloat < -4000.0F) {
        this.RVz.dX(paramFloat);
      }
      for (;;)
      {
        AppMethodBeat.o(251322);
        return true;
        MMOverScrollView.b.a.a(this.RVz, -this.RVz.getScrollY());
      }
    }
    
    public final void fYb()
    {
      AppMethodBeat.i(251328);
      s.u(this, "this");
      AppMethodBeat.o(251328);
    }
    
    public final boolean hsG()
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(MMOverScrollView paramMMOverScrollView, MotionEvent paramMotionEvent, View paramView, PointF paramPointF)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/base/MMOverScrollView$viewProvider$1", "Lcom/tencent/mm/ui/base/MMOverScrollView$IScrollViewProvider;", "isAtBottom", "", "()Z", "isAtTop", "scrollY", "", "getScrollY", "()I", "scroller", "Landroid/widget/OverScroller;", "getScroller", "()Landroid/widget/OverScroller;", "flingTo", "", "velocityY", "", "targetY", "scrollBy", "y", "scrollTo", "smoothScrollBy", "dy", "duration", "smoothScrollTo", "libmmui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements MMOverScrollView.b
  {
    e(MMOverScrollView paramMMOverScrollView) {}
    
    public final void Yn(int paramInt)
    {
      AppMethodBeat.i(251329);
      this.adSq.scrollBy(0, paramInt);
      AppMethodBeat.o(251329);
    }
    
    public final void aAX(int paramInt)
    {
      AppMethodBeat.i(251332);
      this.adSq.scrollTo(0, paramInt);
      AppMethodBeat.o(251332);
    }
    
    public final void aAY(int paramInt)
    {
      AppMethodBeat.i(251334);
      br(paramInt - this.adSq.getScrollY(), -1);
      AppMethodBeat.o(251334);
    }
    
    public final void br(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251333);
      MMOverScrollView.a(this.adSq, false);
      if (paramInt2 < 0) {
        MMOverScrollView.c(this.adSq).startScroll(0, this.adSq.getScrollY(), 0, paramInt1, 350);
      }
      for (;;)
      {
        MMOverScrollView.f(this.adSq);
        this.adSq.postInvalidate();
        AppMethodBeat.o(251333);
        return;
        MMOverScrollView.c(this.adSq).startScroll(0, this.adSq.getScrollY(), 0, paramInt1, paramInt2);
      }
    }
    
    public final void dX(float paramFloat)
    {
      AppMethodBeat.i(251336);
      MMOverScrollView.a(this.adSq, false);
      MMOverScrollView.a(this.adSq, true);
      MMOverScrollView.c(this.adSq).fling(0, this.adSq.getScrollY(), 0, -(int)paramFloat, 0, 0, 0, 1);
      MMOverScrollView.f(this.adSq);
      this.adSq.postInvalidate();
      AppMethodBeat.o(251336);
    }
    
    public final boolean dsp()
    {
      AppMethodBeat.i(251325);
      boolean bool = MMOverScrollView.d(this.adSq);
      AppMethodBeat.o(251325);
      return bool;
    }
    
    public final boolean dsq()
    {
      AppMethodBeat.i(251327);
      boolean bool = MMOverScrollView.e(this.adSq);
      AppMethodBeat.o(251327);
      return bool;
    }
    
    public final int getScrollY()
    {
      AppMethodBeat.i(251321);
      int i = this.adSq.getScrollY();
      AppMethodBeat.o(251321);
      return i;
    }
    
    public final OverScroller jmx()
    {
      AppMethodBeat.i(251323);
      OverScroller localOverScroller = MMOverScrollView.c(this.adSq);
      AppMethodBeat.o(251323);
      return localOverScroller;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMOverScrollView
 * JD-Core Version:    0.7.0.1
 */