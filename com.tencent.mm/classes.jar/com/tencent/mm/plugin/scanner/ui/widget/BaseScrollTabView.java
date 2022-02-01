package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.o;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView
  extends LinearLayout
{
  public static final BaseScrollTabView.a yNg;
  private int bxN;
  private int gil;
  private GestureDetector iNw;
  private Vibrator nQa;
  private float ncP;
  private LinearLayout rMv;
  private int vi;
  private boolean yFA;
  private View yMO;
  private ArrayList<a> yMP;
  private int yMQ;
  private int yMR;
  private boolean yMS;
  private boolean yMT;
  private LinearInterpolator yMU;
  private ArrayList<o<Float, Float>> yMV;
  private boolean yMW;
  private e yMX;
  private c yMY;
  private d yMZ;
  private float yNa;
  private float yNb;
  private int yNc;
  private boolean yNd;
  private boolean yNe;
  private boolean yNf;
  private float yzV;
  private float yzW;
  private float yzX;
  private VelocityTracker yzY;
  
  static
  {
    AppMethodBeat.i(52371);
    yNg = new BaseScrollTabView.a((byte)0);
    AppMethodBeat.o(52371);
  }
  
  public BaseScrollTabView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(52369);
    AppMethodBeat.o(52369);
  }
  
  public BaseScrollTabView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(52370);
    this.yFA = true;
    this.yMP = new ArrayList();
    this.bxN = -1;
    this.yMR = -1;
    this.yMS = true;
    this.yMU = new LinearInterpolator();
    this.yMV = new ArrayList();
    this.vi = 1;
    this.yNc = -1;
    this.iNw = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new f(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494571, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131304372);
    p.g(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.rMv = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304373);
    p.g(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.yMO = paramContext;
    this.yMQ = getResources().getDimensionPixelSize(2131165187);
    if (this.nQa == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.nQa = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private final void Pt(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)j.F((List)this.yMP, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.dPM();
      e locale = this.yMX;
      if (locale != null)
      {
        locale.Pr(locala.getTabId());
        AppMethodBeat.o(52361);
        return;
      }
      AppMethodBeat.o(52361);
      return;
    }
    AppMethodBeat.o(52361);
  }
  
  private final void Pu(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.vi != paramInt)
    {
      ae.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.vi = paramInt;
      d locald = this.yMZ;
      if (locald != null)
      {
        locald.cp(paramInt);
        AppMethodBeat.o(52367);
        return;
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float Pv(int paramInt)
  {
    AppMethodBeat.i(52368);
    o localo = (o)j.F((List)this.yMV, paramInt);
    if (localo != null)
    {
      float f = ((Number)localo.first).floatValue();
      f = (((Number)localo.second).floatValue() + f) / 2.0F;
      AppMethodBeat.o(52368);
      return f;
    }
    AppMethodBeat.o(52368);
    return 0.0F;
  }
  
  private final void a(int paramInt, final float paramFloat1, final float paramFloat2, long paramLong, final d.g.a.a<z> parama)
  {
    AppMethodBeat.i(52362);
    if (this.yMT)
    {
      AppMethodBeat.o(52362);
      return;
    }
    ae.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.yMT = true;
    Object localObject = this.rMv;
    if (localObject == null) {
      p.bdF("container");
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.yMU);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationX(paramFloat2);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setUpdateListener((ValueAnimator.AnimatorUpdateListener)new c(this, paramFloat1, paramFloat2));
          if (localObject != null)
          {
            parama = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new d(this, parama));
            if (parama != null)
            {
              parama = parama.setDuration(paramLong);
              if (parama != null)
              {
                parama.start();
                AppMethodBeat.o(52362);
                return;
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(52362);
  }
  
  private final void b(int paramInt1, final int paramInt2, boolean paramBoolean, final int paramInt3)
  {
    AppMethodBeat.i(52359);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(52359);
      return;
    }
    Pt(paramInt1);
    LinearLayout localLinearLayout = this.rMv;
    if (localLinearLayout == null) {
      p.bdF("container");
    }
    float f1 = localLinearLayout.getTranslationX();
    float f2 = Pv(paramInt2);
    localLinearLayout = this.rMv;
    if (localLinearLayout == null) {
      p.bdF("container");
    }
    ae.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(localLinearLayout.getTranslationX()), Float.valueOf(f2) });
    this.bxN = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (d.g.a.a)new e(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.yMS = false;
    localLinearLayout = this.rMv;
    if (localLinearLayout == null) {
      p.bdF("container");
    }
    localLinearLayout.setTranslationX(f2);
    hr(paramInt2, paramInt3);
    AppMethodBeat.o(52359);
  }
  
  private final void bMT()
  {
    AppMethodBeat.i(52349);
    if (this.yNf)
    {
      Vibrator localVibrator = this.nQa;
      if (localVibrator != null)
      {
        localVibrator.vibrate(10L);
        AppMethodBeat.o(52349);
        return;
      }
    }
    AppMethodBeat.o(52349);
  }
  
  private final void d(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52366);
    this.yNf = true;
    float f = Pv(this.bxN);
    d locald = this.yMZ;
    if (locald != null) {
      locald.t(this.bxN, paramFloat - f);
    }
    if (paramBoolean)
    {
      Pu(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      Pu(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void hr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)j.F((List)this.yMP, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.dPL();
      e locale = this.yMX;
      if (locale != null) {
        locale.hr(locala.getTabId(), paramInt2);
      }
      bMT();
      AppMethodBeat.o(52360);
      return;
    }
    AppMethodBeat.o(52360);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(52346);
    p.h(parama, "tab");
    AppMethodBeat.o(52346);
  }
  
  protected void a(a parama, int paramInt)
  {
    AppMethodBeat.i(52347);
    p.h(parama, "tab");
    AppMethodBeat.o(52347);
  }
  
  public final void b(final a parama)
  {
    AppMethodBeat.i(52352);
    p.h(parama, "tab");
    if (this.yMP.contains(parama))
    {
      ae.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    parama = (View)parama;
    ae.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.yMP.size()) });
    parama.setOnClickListener((View.OnClickListener)new g(this, this.yMP.size(), parama));
    this.yMP.add((a)parama);
    LinearLayout localLinearLayout = this.rMv;
    if (localLinearLayout == null) {
      p.bdF("container");
    }
    localLinearLayout.addView(parama, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    a((a)parama);
    AppMethodBeat.o(52352);
  }
  
  protected void b(a parama, int paramInt)
  {
    AppMethodBeat.i(52348);
    p.h(parama, "tab");
    AppMethodBeat.o(52348);
  }
  
  protected final boolean getCanVibrate()
  {
    return this.yNf;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.bxN >= 0) && (this.bxN < this.yMP.size()))
    {
      a locala = (a)this.yMP.get(this.bxN);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public final void hu(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    ae.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.bxN), Integer.valueOf(paramInt1), Boolean.valueOf(this.yMT), Boolean.valueOf(this.yMW), Integer.valueOf(paramInt2) });
    if ((this.bxN == paramInt1) || (this.yMT))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.bxN == -1) {}
    while (this.yMW)
    {
      b(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.bxN;
    }
    this.yMR = paramInt1;
    AppMethodBeat.o(52350);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52364);
    if (paramMotionEvent != null) {}
    boolean bool;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ae.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(52364);
      return bool;
    }
    if (!this.yFA)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52364);
      return bool;
    }
    if (paramMotionEvent == null)
    {
      AppMethodBeat.o(52364);
      return false;
    }
    if (this.yzY == null) {
      this.yzY = VelocityTracker.obtain();
    }
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.yzY;
    if (localObject == null) {
      p.gkB();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      ae.v("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool) });
      AppMethodBeat.o(52364);
      return bool;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.rMv;
      if (localObject == null) {
        p.bdF("container");
      }
      ae.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject).getTranslationX()) });
      this.yzW = paramMotionEvent.getRawX();
      this.yzX = paramMotionEvent.getRawY();
      localObject = this.rMv;
      if (localObject == null) {
        p.bdF("container");
      }
      this.yNa = ((LinearLayout)localObject).getTranslationX();
      bool = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.yzW;
      f2 = paramMotionEvent.getRawY() - this.yzX;
      ae.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((Math.abs(i) <= Math.abs(j)) || (Math.abs(f1) <= Math.abs(f2)) || (Math.abs(f1) < 5.0F)) {
        break;
      }
      bool = true;
      continue;
      bool = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52358);
    this.gil = com.tencent.mm.cb.a.iu(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.gil)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.gil, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.gil;
      Object localObject1 = this.yMO;
      if (localObject1 == null) {
        p.bdF("dotView");
      }
      ae.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject1 = this.yMO;
      if (localObject1 == null) {
        p.bdF("dotView");
      }
      float f1 = this.gil / 2.0F;
      Object localObject2 = this.yMO;
      if (localObject2 == null) {
        p.bdF("dotView");
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      ae.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.yMV.clear();
      f1 = this.gil / 2.0F;
      localObject1 = (Iterable)this.yMP;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          j.gkd();
        }
        localObject2 = (a)localObject2;
        if (localObject2 == null)
        {
          localObject1 = new v("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(52358);
          throw ((Throwable)localObject1);
        }
        localObject2 = (View)localObject2;
        float f2 = f1 - paramInt2 - ((View)localObject2).getMeasuredWidth();
        float f3 = f1 - paramInt2;
        paramInt2 += ((View)localObject2).getMeasuredWidth();
        this.yMV.add(new o(Float.valueOf(f2), Float.valueOf(f3)));
        ae.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.yMW = true;
      localObject1 = (a)j.jm((List)this.yMP);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        ae.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.bxN), Integer.valueOf(this.yMR) });
        if (this.yMR != -1)
        {
          b(this.bxN, this.yMR, false, 0);
          this.yMR = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.bxN == -1) || (this.bxN == 0))
        {
          f1 = Pv(0);
          localObject1 = this.rMv;
          if (localObject1 == null) {
            p.bdF("container");
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          ae.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          b(this.bxN, 0, false, 0);
        }
      }
    }
    AppMethodBeat.o(52358);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52365);
    boolean bool;
    if (paramMotionEvent == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    if (!this.yFA)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    ae.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    Object localObject1 = this.iNw;
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).ahE(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).mt(0)), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.yzV = paramMotionEvent.getRawX();
      this.ncP = paramMotionEvent.getRawY();
      localObject1 = this.rMv;
      if (localObject1 == null) {
        p.bdF("container");
      }
      this.yNa = ((LinearLayout)localObject1).getTranslationX();
      this.yNc = this.bxN;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.rMv;
      if (paramMotionEvent == null) {
        p.bdF("container");
      }
      ae.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
      this.yNe = true;
      AppMethodBeat.o(52365);
      return true;
      this.yNe = true;
      if ((this.yzV == 0.0F) && (this.ncP == 0.0F))
      {
        this.yzV = paramMotionEvent.getRawX();
        this.ncP = paramMotionEvent.getRawY();
        this.yNc = this.bxN;
      }
      else
      {
        f2 = paramMotionEvent.getRawX() - this.yzV;
        paramMotionEvent.getRawY();
        localObject1 = this.rMv;
        if (localObject1 == null) {
          p.bdF("container");
        }
        float f3 = ((LinearLayout)localObject1).getTranslationX();
        localObject1 = (o)j.jm((List)this.yMV);
        float f4;
        label566:
        int i;
        if (localObject1 != null) {
          if ((f3 >= ((Number)((o)localObject1).second).floatValue()) && (f2 > 0.0F))
          {
            f1 = f2 - this.yNb;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((o)localObject1).second).floatValue()) / 30.0F) * 0.5F));
            ae.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.yNb), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.yNa);
            f1 += this.yNa;
            this.yNb = f2;
            localObject1 = this.rMv;
            if (localObject1 == null) {
              p.bdF("container");
            }
            ((LinearLayout)localObject1).setTranslationX(f1);
            localObject1 = (o)j.jm((List)this.yMV);
            if ((localObject1 == null) || (f1 < ((Number)((o)localObject1).second).floatValue())) {
              break label1205;
            }
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = this.rMv;
          if (localObject1 == null) {
            p.bdF("container");
          }
          ae.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.bxN), Integer.valueOf(i) });
          if (this.bxN != -1) {
            d(f1, this.yNe);
          }
          if (this.bxN == i) {
            break;
          }
          Pt(this.bxN);
          this.bxN = i;
          hr(i, 2);
          break;
          f1 = ((Number)((o)localObject1).first).floatValue();
          if ((f3 >= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.yNa;
            f1 = (f2 - f4) * 0.5F + f4;
            ae.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label566;
          }
          localObject1 = (o)j.jo((List)this.yMV);
          if (localObject1 != null)
          {
            if ((f3 <= ((Number)((o)localObject1).first).floatValue()) && (f2 < 0.0F))
            {
              f1 = f2 - this.yNb;
              f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((o)localObject1).first).floatValue() - f3) / 30.0F) * 0.5F));
              ae.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.yNb), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              f1 = f4 * f1 + (f3 - this.yNa);
              break label566;
            }
            f1 = ((Number)((o)localObject1).first).floatValue();
            if ((f3 <= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
            {
              f1 = ((Number)((o)localObject1).first).floatValue();
              f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.yNa;
              f1 = (f2 - f4) * 0.5F + f4;
              ae.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
              break label566;
            }
          }
          ae.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
          f1 = f2;
          break label566;
          label1205:
          localObject1 = (o)j.jo((List)this.yMV);
          if ((localObject1 != null) && (f1 <= ((Number)((o)localObject1).first).floatValue()))
          {
            i = Math.max(this.yMV.size() - 1, 0);
          }
          else
          {
            localObject1 = ((Iterable)this.yMV).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1355;
              }
              localObject2 = ((Iterator)localObject1).next();
              if (j < 0) {
                j.gkd();
              }
              localObject2 = (o)localObject2;
              if (f1 >= ((Number)((o)localObject2).first).floatValue())
              {
                i = j;
                if (f1 < ((Number)((o)localObject2).second).floatValue()) {
                  break;
                }
              }
              j += 1;
            }
            label1355:
            i = -1;
          }
        }
        this.yzV = 0.0F;
        this.ncP = 0.0F;
        this.yNe = false;
        ae.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.bxN), Boolean.valueOf(this.yNd) });
        if (this.yNd)
        {
          this.yNd = false;
        }
        else
        {
          localObject1 = (o)j.F((List)this.yMV, this.bxN);
          if (localObject1 != null)
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f1 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F;
            i = this.bxN;
            localObject1 = this.rMv;
            if (localObject1 == null) {
              p.bdF("container");
            }
            a(this, i, ((LinearLayout)localObject1).getTranslationX(), f1, 150L, null, 16);
          }
        }
      }
    }
  }
  
  public final void removeAllTabs()
  {
    AppMethodBeat.i(52353);
    ae.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Object localObject1 = ((Iterable)this.yMP).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (a)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(52353);
        throw ((Throwable)localObject1);
      }
      localObject2 = (View)localObject2;
      LinearLayout localLinearLayout = this.rMv;
      if (localLinearLayout == null) {
        p.bdF("container");
      }
      localLinearLayout.removeView((View)localObject2);
    }
    this.yMP.clear();
    AppMethodBeat.o(52353);
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.yNf = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.yFA = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.yMP).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    localObject = this.yMO;
    if (localObject == null) {
      p.bdF("dotView");
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    p.h(parame, "tabOnSelectedListener");
    this.yMX = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    p.h(paramc, "tabOnClickListener");
    this.yMY = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    p.h(paramd, "tabOnScrollListener");
    this.yMZ = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    hu(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BaseScrollTabView paramBaseScrollTabView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52341);
      p.g(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52341);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = paramFloat1;
      float f3 = paramFloat2;
      float f4 = paramFloat1;
      BaseScrollTabView.a(this.yNi, f1 * (f3 - f4) + f2, BaseScrollTabView.d(this.yNi));
      AppMethodBeat.o(52341);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(d.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      parama.invoke();
      BaseScrollTabView.e(this.yNi);
      BaseScrollTabView.f(this.yNi);
      ae.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(BaseScrollTabView.g(this.yNi).getTranslationX()) });
      BaseScrollTabView.h(this.yNi);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(189687);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(189687);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(189686);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(189686);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      ae.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.i(this.yNi)), Integer.valueOf(BaseScrollTabView.j(this.yNi)) });
      if (BaseScrollTabView.i(this.yNi) == BaseScrollTabView.j(this.yNi)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.j(this.yNi) + 1;
          if (BaseScrollTabView.a(this.yNi, i))
          {
            BaseScrollTabView.k(this.yNi);
            this.yNi.hu(i, 2);
          }
        }
      }
      for (;;)
      {
        boolean bool = super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
        AppMethodBeat.o(52344);
        return bool;
        i = 0;
        break;
        label167:
        if (paramFloat1 >= 100.0F)
        {
          i = BaseScrollTabView.j(this.yNi) - 1;
          if (BaseScrollTabView.a(this.yNi, i))
          {
            BaseScrollTabView.k(this.yNi);
            this.yNi.hu(i, 2);
          }
        }
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(189685);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(189685);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(189684);
      b localb = new b();
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(189684);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52345);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      if (!BaseScrollTabView.a(this.yNi))
      {
        ae.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(52345);
        return;
      }
      this.yNi.setCanVibrate(true);
      ae.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(this.ojd) });
      paramView = (a)j.F((List)BaseScrollTabView.b(this.yNi), this.ojd);
      if (paramView != null)
      {
        paramView.getTabId();
        BaseScrollTabView.c(this.yNi);
      }
      this.yNi.hu(this.ojd, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(52345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */