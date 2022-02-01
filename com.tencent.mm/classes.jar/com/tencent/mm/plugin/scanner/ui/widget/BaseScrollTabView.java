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
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.k;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView
  extends LinearLayout
{
  public static final a vXX;
  private int boX;
  private int fIN;
  private GestureDetector hRv;
  private float lVc;
  private Vibrator mHT;
  private LinearLayout qlu;
  private int sq;
  private float vLY;
  private float vLZ;
  private float vMa;
  private VelocityTracker vMb;
  private boolean vQR;
  private View vXF;
  private ArrayList<a> vXG;
  private int vXH;
  private int vXI;
  private boolean vXJ;
  private boolean vXK;
  private LinearInterpolator vXL;
  private ArrayList<o<Float, Float>> vXM;
  private boolean vXN;
  private e vXO;
  private c vXP;
  private d vXQ;
  private float vXR;
  private float vXS;
  private int vXT;
  private boolean vXU;
  private boolean vXV;
  private boolean vXW;
  
  static
  {
    AppMethodBeat.i(52371);
    vXX = new a((byte)0);
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
    this.vQR = true;
    this.vXG = new ArrayList();
    this.boX = -1;
    this.vXI = -1;
    this.vXJ = true;
    this.vXL = new LinearInterpolator();
    this.vXM = new ArrayList();
    this.sq = 1;
    this.vXT = -1;
    this.hRv = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new f(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494571, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131304372);
    k.g(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.qlu = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304373);
    k.g(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.vXF = paramContext;
    this.vXH = getResources().getDimensionPixelSize(2131165187);
    if (this.mHT == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.mHT = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private final void Lk(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)j.C((List)this.vXG, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.dmN();
      e locale = this.vXO;
      if (locale != null)
      {
        locale.Li(locala.getTabId());
        AppMethodBeat.o(52361);
        return;
      }
      AppMethodBeat.o(52361);
      return;
    }
    AppMethodBeat.o(52361);
  }
  
  private final void Ll(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.sq != paramInt)
    {
      ad.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.sq = paramInt;
      d locald = this.vXQ;
      if (locald != null)
      {
        locald.cq(paramInt);
        AppMethodBeat.o(52367);
        return;
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float Lm(int paramInt)
  {
    AppMethodBeat.i(52368);
    o localo = (o)j.C((List)this.vXM, paramInt);
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
  
  private final void a(int paramInt, final float paramFloat1, final float paramFloat2, long paramLong, final d.g.a.a<y> parama)
  {
    AppMethodBeat.i(52362);
    if (this.vXK)
    {
      AppMethodBeat.o(52362);
      return;
    }
    ad.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.vXK = true;
    Object localObject = this.qlu;
    if (localObject == null) {
      k.aPZ("container");
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.vXL);
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
    Lk(paramInt1);
    LinearLayout localLinearLayout = this.qlu;
    if (localLinearLayout == null) {
      k.aPZ("container");
    }
    float f1 = localLinearLayout.getTranslationX();
    float f2 = Lm(paramInt2);
    localLinearLayout = this.qlu;
    if (localLinearLayout == null) {
      k.aPZ("container");
    }
    ad.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(localLinearLayout.getTranslationX()), Float.valueOf(f2) });
    this.boX = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (d.g.a.a)new e(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.vXJ = false;
    localLinearLayout = this.qlu;
    if (localLinearLayout == null) {
      k.aPZ("container");
    }
    localLinearLayout.setTranslationX(f2);
    gP(paramInt2, paramInt3);
    AppMethodBeat.o(52359);
  }
  
  private final void bAO()
  {
    AppMethodBeat.i(52349);
    if (this.vXW)
    {
      Vibrator localVibrator = this.mHT;
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
    this.vXW = true;
    float f = Lm(this.boX);
    d locald = this.vXQ;
    if (locald != null) {
      locald.s(this.boX, paramFloat - f);
    }
    if (paramBoolean)
    {
      Ll(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      Ll(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)j.C((List)this.vXG, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.dmM();
      e locale = this.vXO;
      if (locale != null) {
        locale.gP(locala.getTabId(), paramInt2);
      }
      bAO();
      AppMethodBeat.o(52360);
      return;
    }
    AppMethodBeat.o(52360);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(52346);
    k.h(parama, "tab");
    AppMethodBeat.o(52346);
  }
  
  protected void a(a parama, int paramInt)
  {
    AppMethodBeat.i(52347);
    k.h(parama, "tab");
    AppMethodBeat.o(52347);
  }
  
  public final void b(final a parama)
  {
    AppMethodBeat.i(52352);
    k.h(parama, "tab");
    if (this.vXG.contains(parama))
    {
      ad.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    parama = (View)parama;
    ad.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.vXG.size()) });
    parama.setOnClickListener((View.OnClickListener)new g(this, this.vXG.size(), parama));
    this.vXG.add((a)parama);
    LinearLayout localLinearLayout = this.qlu;
    if (localLinearLayout == null) {
      k.aPZ("container");
    }
    localLinearLayout.addView(parama, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    a((a)parama);
    AppMethodBeat.o(52352);
  }
  
  protected void b(a parama, int paramInt)
  {
    AppMethodBeat.i(52348);
    k.h(parama, "tab");
    AppMethodBeat.o(52348);
  }
  
  public final void gS(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    ad.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.boX), Integer.valueOf(paramInt1), Boolean.valueOf(this.vXK), Boolean.valueOf(this.vXN), Integer.valueOf(paramInt2) });
    if ((this.boX == paramInt1) || (this.vXK))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.boX == -1) {}
    while (this.vXN)
    {
      b(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.boX;
    }
    this.vXI = paramInt1;
    AppMethodBeat.o(52350);
  }
  
  protected final boolean getCanVibrate()
  {
    return this.vXW;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.boX >= 0) && (this.boX < this.vXG.size()))
    {
      a locala = (a)this.vXG.get(this.boX);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52364);
    if (paramMotionEvent != null) {}
    boolean bool;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ad.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(52364);
      return bool;
    }
    if (!this.vQR)
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
    if (this.vMb == null) {
      this.vMb = VelocityTracker.obtain();
    }
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.vMb;
    if (localObject == null) {
      k.fvU();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      ad.v("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool) });
      AppMethodBeat.o(52364);
      return bool;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.qlu;
      if (localObject == null) {
        k.aPZ("container");
      }
      ad.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject).getTranslationX()) });
      this.vLZ = paramMotionEvent.getRawX();
      this.vMa = paramMotionEvent.getRawY();
      localObject = this.qlu;
      if (localObject == null) {
        k.aPZ("container");
      }
      this.vXR = ((LinearLayout)localObject).getTranslationX();
      bool = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.vLZ;
      f2 = paramMotionEvent.getRawY() - this.vMa;
      ad.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.fIN = com.tencent.mm.cd.a.hV(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.fIN)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.fIN, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.fIN;
      Object localObject1 = this.vXF;
      if (localObject1 == null) {
        k.aPZ("dotView");
      }
      ad.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject1 = this.vXF;
      if (localObject1 == null) {
        k.aPZ("dotView");
      }
      float f1 = this.fIN / 2.0F;
      Object localObject2 = this.vXF;
      if (localObject2 == null) {
        k.aPZ("dotView");
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      ad.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.vXM.clear();
      f1 = this.fIN / 2.0F;
      localObject1 = (Iterable)this.vXG;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          j.fvx();
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
        this.vXM.add(new o(Float.valueOf(f2), Float.valueOf(f3)));
        ad.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.vXN = true;
      localObject1 = (a)j.iz((List)this.vXG);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        ad.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.boX), Integer.valueOf(this.vXI) });
        if (this.vXI != -1)
        {
          b(this.boX, this.vXI, false, 0);
          this.vXI = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.boX == -1) || (this.boX == 0))
        {
          f1 = Lm(0);
          localObject1 = this.qlu;
          if (localObject1 == null) {
            k.aPZ("container");
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          ad.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          b(this.boX, 0, false, 0);
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
    if (!this.vQR)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    ad.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    this.hRv.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.vLY = paramMotionEvent.getRawX();
      this.lVc = paramMotionEvent.getRawY();
      Object localObject1 = this.qlu;
      if (localObject1 == null) {
        k.aPZ("container");
      }
      this.vXR = ((LinearLayout)localObject1).getTranslationX();
      this.vXT = this.boX;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.qlu;
      if (paramMotionEvent == null) {
        k.aPZ("container");
      }
      ad.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
      this.vXV = true;
      AppMethodBeat.o(52365);
      return true;
      this.vXV = true;
      if ((this.vLY == 0.0F) && (this.lVc == 0.0F))
      {
        this.vLY = paramMotionEvent.getRawX();
        this.lVc = paramMotionEvent.getRawY();
        this.vXT = this.boX;
      }
      else
      {
        f2 = paramMotionEvent.getRawX() - this.vLY;
        paramMotionEvent.getRawY();
        localObject1 = this.qlu;
        if (localObject1 == null) {
          k.aPZ("container");
        }
        float f3 = ((LinearLayout)localObject1).getTranslationX();
        localObject1 = (o)j.iz((List)this.vXM);
        float f4;
        label490:
        int i;
        if (localObject1 != null) {
          if ((f3 >= ((Number)((o)localObject1).second).floatValue()) && (f2 > 0.0F))
          {
            f1 = f2 - this.vXS;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((o)localObject1).second).floatValue()) / 30.0F) * 0.5F));
            ad.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.vXS), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.vXR);
            f1 += this.vXR;
            this.vXS = f2;
            localObject1 = this.qlu;
            if (localObject1 == null) {
              k.aPZ("container");
            }
            ((LinearLayout)localObject1).setTranslationX(f1);
            localObject1 = (o)j.iz((List)this.vXM);
            if ((localObject1 == null) || (f1 < ((Number)((o)localObject1).second).floatValue())) {
              break label1129;
            }
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = this.qlu;
          if (localObject1 == null) {
            k.aPZ("container");
          }
          ad.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.boX), Integer.valueOf(i) });
          if (this.boX != -1) {
            d(f1, this.vXV);
          }
          if (this.boX == i) {
            break;
          }
          Lk(this.boX);
          this.boX = i;
          gP(i, 2);
          break;
          f1 = ((Number)((o)localObject1).first).floatValue();
          if ((f3 >= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.vXR;
            f1 = (f2 - f4) * 0.5F + f4;
            ad.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label490;
          }
          localObject1 = (o)j.iB((List)this.vXM);
          if (localObject1 != null)
          {
            if ((f3 <= ((Number)((o)localObject1).first).floatValue()) && (f2 < 0.0F))
            {
              f1 = f2 - this.vXS;
              f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((o)localObject1).first).floatValue() - f3) / 30.0F) * 0.5F));
              ad.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.vXS), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              f1 = f4 * f1 + (f3 - this.vXR);
              break label490;
            }
            f1 = ((Number)((o)localObject1).first).floatValue();
            if ((f3 <= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
            {
              f1 = ((Number)((o)localObject1).first).floatValue();
              f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.vXR;
              f1 = (f2 - f4) * 0.5F + f4;
              ad.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
              break label490;
            }
          }
          ad.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
          f1 = f2;
          break label490;
          label1129:
          localObject1 = (o)j.iB((List)this.vXM);
          if ((localObject1 != null) && (f1 <= ((Number)((o)localObject1).first).floatValue()))
          {
            i = Math.max(this.vXM.size() - 1, 0);
          }
          else
          {
            localObject1 = ((Iterable)this.vXM).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1279;
              }
              Object localObject2 = ((Iterator)localObject1).next();
              if (j < 0) {
                j.fvx();
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
            label1279:
            i = -1;
          }
        }
        this.vLY = 0.0F;
        this.lVc = 0.0F;
        this.vXV = false;
        ad.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.boX), Boolean.valueOf(this.vXU) });
        if (this.vXU)
        {
          this.vXU = false;
        }
        else
        {
          localObject1 = (o)j.C((List)this.vXM, this.boX);
          if (localObject1 != null)
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f1 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F;
            i = this.boX;
            localObject1 = this.qlu;
            if (localObject1 == null) {
              k.aPZ("container");
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
    ad.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Object localObject1 = ((Iterable)this.vXG).iterator();
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
      LinearLayout localLinearLayout = this.qlu;
      if (localLinearLayout == null) {
        k.aPZ("container");
      }
      localLinearLayout.removeView((View)localObject2);
    }
    this.vXG.clear();
    AppMethodBeat.o(52353);
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.vXW = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.vQR = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.vXG).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    localObject = this.vXF;
    if (localObject == null) {
      k.aPZ("dotView");
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    k.h(parame, "tabOnSelectedListener");
    this.vXO = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    k.h(paramc, "tabOnClickListener");
    this.vXP = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    k.h(paramd, "tabOnScrollListener");
    this.vXQ = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    gS(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$Companion;", "", "()V", "DEFAULT_SELECTED_INDEX", "", "MOVE_OFFSET_X_FACTOR", "", "SCROLL_ANIMATION_DURATION", "", "TAB_SELECTED_ACTION_CLICK", "TAB_SELECTED_ACTION_DEFAULT", "TAB_SELECTED_ACTION_EXTERNAL_SCROLL", "TAB_SELECTED_ACTION_SCROLL", "TAG", "", "plugin-scan_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BaseScrollTabView paramBaseScrollTabView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52341);
      k.g(paramValueAnimator, "animation");
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
      BaseScrollTabView.a(this.vXZ, f1 * (f3 - f4) + f2, BaseScrollTabView.d(this.vXZ));
      AppMethodBeat.o(52341);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(d.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      parama.invoke();
      BaseScrollTabView.e(this.vXZ);
      BaseScrollTabView.f(this.vXZ);
      ad.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(BaseScrollTabView.g(this.vXZ).getTranslationX()) });
      BaseScrollTabView.h(this.vXZ);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      ad.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.i(this.vXZ)), Integer.valueOf(BaseScrollTabView.j(this.vXZ)) });
      if (BaseScrollTabView.i(this.vXZ) == BaseScrollTabView.j(this.vXZ)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.j(this.vXZ) + 1;
          if (BaseScrollTabView.a(this.vXZ, i))
          {
            BaseScrollTabView.k(this.vXZ);
            this.vXZ.gS(i, 2);
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
          i = BaseScrollTabView.j(this.vXZ) - 1;
          if (BaseScrollTabView.a(this.vXZ, i))
          {
            BaseScrollTabView.k(this.vXZ);
            this.vXZ.gS(i, 2);
          }
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52345);
      if (!BaseScrollTabView.a(this.vXZ))
      {
        ad.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
        AppMethodBeat.o(52345);
        return;
      }
      this.vXZ.setCanVibrate(true);
      ad.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(this.mYS) });
      paramView = (a)j.C((List)BaseScrollTabView.b(this.vXZ), this.mYS);
      if (paramView != null)
      {
        paramView.getTabId();
        BaseScrollTabView.c(this.vXZ);
      }
      this.vXZ.gS(this.mYS, 1);
      AppMethodBeat.o(52345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */