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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView
  extends LinearLayout
{
  public static final BaseScrollTabView.a CQY;
  private float CBd;
  private float CBe;
  private float CBf;
  private VelocityTracker CBg;
  private boolean CJp;
  private View CQG;
  private ArrayList<a> CQH;
  private int CQI;
  private int CQJ;
  private boolean CQK;
  private boolean CQL;
  private LinearInterpolator CQM;
  private ArrayList<o<Float, Float>> CQN;
  private boolean CQO;
  private e CQP;
  private c CQQ;
  private d CQR;
  private float CQS;
  private float CQT;
  private int CQU;
  private boolean CQV;
  private boolean CQW;
  private boolean CQX;
  private int bxP;
  private int gRD;
  private GestureDetector jKk;
  private float onW;
  private Vibrator paT;
  private LinearLayout tmh;
  private int vp;
  
  static
  {
    AppMethodBeat.i(52371);
    CQY = new BaseScrollTabView.a((byte)0);
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
    this.CJp = true;
    this.CQH = new ArrayList();
    this.bxP = -1;
    this.CQJ = -1;
    this.CQK = true;
    this.CQM = new LinearInterpolator();
    this.CQN = new ArrayList();
    this.vp = 1;
    this.CQU = -1;
    this.jKk = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new f(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131495194, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131307335);
    p.g(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.tmh = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(2131307336);
    p.g(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.CQG = paramContext;
    this.CQI = getResources().getDimensionPixelSize(2131165190);
    if (this.paT == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.paT = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private final void WS(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)j.L((List)this.CQH, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.eRv();
      e locale = this.CQP;
      if (locale != null)
      {
        locale.WQ(locala.getTabId());
        AppMethodBeat.o(52361);
        return;
      }
      AppMethodBeat.o(52361);
      return;
    }
    AppMethodBeat.o(52361);
  }
  
  private final void WT(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.vp != paramInt)
    {
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.vp = paramInt;
      d locald = this.CQR;
      if (locald != null)
      {
        locald.onScrollStateChanged(paramInt);
        AppMethodBeat.o(52367);
        return;
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float WU(int paramInt)
  {
    AppMethodBeat.i(52368);
    o localo = (o)j.L((List)this.CQN, paramInt);
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
  
  private final void a(int paramInt, final float paramFloat1, final float paramFloat2, long paramLong, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(52362);
    if (this.CQL)
    {
      AppMethodBeat.o(52362);
      return;
    }
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.CQL = true;
    Object localObject = this.tmh;
    if (localObject == null) {
      p.btv("container");
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.CQM);
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
  
  private final void a(int paramInt1, final int paramInt2, boolean paramBoolean, final int paramInt3)
  {
    AppMethodBeat.i(52359);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(52359);
      return;
    }
    WS(paramInt1);
    LinearLayout localLinearLayout = this.tmh;
    if (localLinearLayout == null) {
      p.btv("container");
    }
    float f1 = localLinearLayout.getTranslationX();
    float f2 = WU(paramInt2);
    localLinearLayout = this.tmh;
    if (localLinearLayout == null) {
      p.btv("container");
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(localLinearLayout.getTranslationX()), Float.valueOf(f2) });
    this.bxP = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (kotlin.g.a.a)new e(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.CQK = false;
    localLinearLayout = this.tmh;
    if (localLinearLayout == null) {
      p.btv("container");
    }
    localLinearLayout.setTranslationX(f2);
    jdMethod_if(paramInt2, paramInt3);
    AppMethodBeat.o(52359);
  }
  
  private final void cjJ()
  {
    AppMethodBeat.i(52349);
    if (this.CQX)
    {
      Vibrator localVibrator = this.paT;
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
    this.CQX = true;
    float f = WU(this.bxP);
    d locald = this.CQR;
    if (locald != null) {
      locald.u(this.bxP, paramFloat - f);
    }
    if (paramBoolean)
    {
      WT(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      WT(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void jdMethod_if(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)j.L((List)this.CQH, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.eRu();
      e locale = this.CQP;
      if (locale != null) {
        locale.jdMethod_if(locala.getTabId(), paramInt2);
      }
      cjJ();
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
    if (this.CQH.contains(parama))
    {
      Log.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    parama = (View)parama;
    Log.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.CQH.size()) });
    parama.setOnClickListener((View.OnClickListener)new g(this, this.CQH.size(), parama));
    this.CQH.add((a)parama);
    LinearLayout localLinearLayout = this.tmh;
    if (localLinearLayout == null) {
      p.btv("container");
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
    return this.CQX;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.bxP >= 0) && (this.bxP < this.CQH.size()))
    {
      a locala = (a)this.CQH.get(this.bxP);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public final void ii(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.bxP), Integer.valueOf(paramInt1), Boolean.valueOf(this.CQL), Boolean.valueOf(this.CQO), Integer.valueOf(paramInt2) });
    if ((this.bxP == paramInt1) || (this.CQL))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.bxP == -1) {}
    while (this.CQO)
    {
      a(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.bxP;
    }
    this.CQJ = paramInt1;
    AppMethodBeat.o(52350);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52364);
    if (paramMotionEvent != null) {}
    boolean bool;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(52364);
      return bool;
    }
    if (!this.CJp)
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
    if (this.CBg == null) {
      this.CBg = VelocityTracker.obtain();
    }
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.CBg;
    if (localObject == null) {
      p.hyc();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool) });
      AppMethodBeat.o(52364);
      return bool;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.tmh;
      if (localObject == null) {
        p.btv("container");
      }
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject).getTranslationX()) });
      this.CBe = paramMotionEvent.getRawX();
      this.CBf = paramMotionEvent.getRawY();
      localObject = this.tmh;
      if (localObject == null) {
        p.btv("container");
      }
      this.CQS = ((LinearLayout)localObject).getTranslationX();
      bool = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.CBe;
      f2 = paramMotionEvent.getRawY() - this.CBf;
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.gRD = com.tencent.mm.cb.a.jn(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.gRD)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.gRD, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.gRD;
      Object localObject1 = this.CQG;
      if (localObject1 == null) {
        p.btv("dotView");
      }
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject1 = this.CQG;
      if (localObject1 == null) {
        p.btv("dotView");
      }
      float f1 = this.gRD / 2.0F;
      Object localObject2 = this.CQG;
      if (localObject2 == null) {
        p.btv("dotView");
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.CQN.clear();
      f1 = this.gRD / 2.0F;
      localObject1 = (Iterable)this.CQH;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          j.hxH();
        }
        localObject2 = (a)localObject2;
        if (localObject2 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.view.View");
          AppMethodBeat.o(52358);
          throw ((Throwable)localObject1);
        }
        localObject2 = (View)localObject2;
        float f2 = f1 - paramInt2 - ((View)localObject2).getMeasuredWidth();
        float f3 = f1 - paramInt2;
        paramInt2 += ((View)localObject2).getMeasuredWidth();
        this.CQN.add(new o(Float.valueOf(f2), Float.valueOf(f3)));
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.CQO = true;
      localObject1 = (a)j.kt((List)this.CQH);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.bxP), Integer.valueOf(this.CQJ) });
        if (this.CQJ != -1)
        {
          a(this.bxP, this.CQJ, false, 0);
          this.CQJ = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.bxP == -1) || (this.bxP == 0))
        {
          f1 = WU(0);
          localObject1 = this.tmh;
          if (localObject1 == null) {
            p.btv("container");
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          a(this.bxP, 0, false, 0);
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
    if (!this.CJp)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    Object localObject1 = this.jKk;
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0)), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.CBd = paramMotionEvent.getRawX();
      this.onW = paramMotionEvent.getRawY();
      localObject1 = this.tmh;
      if (localObject1 == null) {
        p.btv("container");
      }
      this.CQS = ((LinearLayout)localObject1).getTranslationX();
      this.CQU = this.bxP;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.tmh;
      if (paramMotionEvent == null) {
        p.btv("container");
      }
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
      this.CQW = true;
      AppMethodBeat.o(52365);
      return true;
      this.CQW = true;
      if ((this.CBd == 0.0F) && (this.onW == 0.0F))
      {
        this.CBd = paramMotionEvent.getRawX();
        this.onW = paramMotionEvent.getRawY();
        this.CQU = this.bxP;
      }
      else
      {
        f2 = paramMotionEvent.getRawX() - this.CBd;
        paramMotionEvent.getRawY();
        localObject1 = this.tmh;
        if (localObject1 == null) {
          p.btv("container");
        }
        float f3 = ((LinearLayout)localObject1).getTranslationX();
        localObject1 = (o)j.kt((List)this.CQN);
        float f4;
        label566:
        int i;
        if (localObject1 != null) {
          if ((f3 >= ((Number)((o)localObject1).second).floatValue()) && (f2 > 0.0F))
          {
            f1 = f2 - this.CQT;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((o)localObject1).second).floatValue()) / 30.0F) * 0.5F));
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.CQT), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.CQS);
            f1 += this.CQS;
            this.CQT = f2;
            localObject1 = this.tmh;
            if (localObject1 == null) {
              p.btv("container");
            }
            ((LinearLayout)localObject1).setTranslationX(f1);
            localObject1 = (o)j.kt((List)this.CQN);
            if ((localObject1 == null) || (f1 < ((Number)((o)localObject1).second).floatValue())) {
              break label1205;
            }
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = this.tmh;
          if (localObject1 == null) {
            p.btv("container");
          }
          Log.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.bxP), Integer.valueOf(i) });
          if (this.bxP != -1) {
            d(f1, this.CQW);
          }
          if (this.bxP == i) {
            break;
          }
          WS(this.bxP);
          this.bxP = i;
          jdMethod_if(i, 2);
          break;
          f1 = ((Number)((o)localObject1).first).floatValue();
          if ((f3 >= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.CQS;
            f1 = (f2 - f4) * 0.5F + f4;
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label566;
          }
          localObject1 = (o)j.kv((List)this.CQN);
          if (localObject1 != null)
          {
            if ((f3 <= ((Number)((o)localObject1).first).floatValue()) && (f2 < 0.0F))
            {
              f1 = f2 - this.CQT;
              f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((o)localObject1).first).floatValue() - f3) / 30.0F) * 0.5F));
              Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.CQT), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              f1 = f4 * f1 + (f3 - this.CQS);
              break label566;
            }
            f1 = ((Number)((o)localObject1).first).floatValue();
            if ((f3 <= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
            {
              f1 = ((Number)((o)localObject1).first).floatValue();
              f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.CQS;
              f1 = (f2 - f4) * 0.5F + f4;
              Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
              break label566;
            }
          }
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
          f1 = f2;
          break label566;
          label1205:
          localObject1 = (o)j.kv((List)this.CQN);
          if ((localObject1 != null) && (f1 <= ((Number)((o)localObject1).first).floatValue()))
          {
            i = Math.max(this.CQN.size() - 1, 0);
          }
          else
          {
            localObject1 = ((Iterable)this.CQN).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1355;
              }
              localObject2 = ((Iterator)localObject1).next();
              if (j < 0) {
                j.hxH();
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
        this.CBd = 0.0F;
        this.onW = 0.0F;
        this.CQW = false;
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.bxP), Boolean.valueOf(this.CQV) });
        if (this.CQV)
        {
          this.CQV = false;
        }
        else
        {
          localObject1 = (o)j.L((List)this.CQN, this.bxP);
          if (localObject1 != null)
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f1 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F;
            i = this.bxP;
            localObject1 = this.tmh;
            if (localObject1 == null) {
              p.btv("container");
            }
            a(this, i, ((LinearLayout)localObject1).getTranslationX(), f1, 75L, null, 16);
          }
        }
      }
    }
  }
  
  public final void removeAllTabs()
  {
    AppMethodBeat.i(52353);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Object localObject1 = ((Iterable)this.CQH).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (a)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(52353);
        throw ((Throwable)localObject1);
      }
      localObject2 = (View)localObject2;
      LinearLayout localLinearLayout = this.tmh;
      if (localLinearLayout == null) {
        p.btv("container");
      }
      localLinearLayout.removeView((View)localObject2);
    }
    this.CQH.clear();
    AppMethodBeat.o(52353);
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.CQX = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.CJp = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.CQH).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    localObject = this.CQG;
    if (localObject == null) {
      p.btv("dotView");
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    p.h(parame, "tabOnSelectedListener");
    this.CQP = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    p.h(paramc, "tabOnClickListener");
    this.CQQ = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    p.h(paramd, "tabOnScrollListener");
    this.CQR = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    ii(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(52341);
        throw paramValueAnimator;
      }
      float f1 = ((Float)paramValueAnimator).floatValue();
      float f2 = paramFloat1;
      float f3 = paramFloat2;
      float f4 = paramFloat1;
      BaseScrollTabView.a(this.CRa, f1 * (f3 - f4) + f2, BaseScrollTabView.d(this.CRa));
      AppMethodBeat.o(52341);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(kotlin.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      parama.invoke();
      BaseScrollTabView.e(this.CRa);
      BaseScrollTabView.f(this.CRa);
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(BaseScrollTabView.g(this.CRa).getTranslationX()) });
      BaseScrollTabView.h(this.CRa);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(240634);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(240634);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(240633);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(240633);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.i(this.CRa)), Integer.valueOf(BaseScrollTabView.j(this.CRa)) });
      if (BaseScrollTabView.i(this.CRa) == BaseScrollTabView.j(this.CRa)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.j(this.CRa) + 1;
          if (BaseScrollTabView.a(this.CRa, i))
          {
            BaseScrollTabView.k(this.CRa);
            this.CRa.ii(i, 2);
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
          i = BaseScrollTabView.j(this.CRa) - 1;
          if (BaseScrollTabView.a(this.CRa, i))
          {
            BaseScrollTabView.k(this.CRa);
            this.CRa.ii(i, 2);
          }
        }
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(240632);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(240632);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(240631);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(240631);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52345);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!BaseScrollTabView.a(this.CRa))
      {
        Log.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(52345);
        return;
      }
      this.CRa.setCanVibrate(true);
      Log.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(this.puW) });
      paramView = (a)j.L((List)BaseScrollTabView.b(this.CRa), this.puW);
      if (paramView != null)
      {
        paramView.getTabId();
        BaseScrollTabView.c(this.CRa);
      }
      this.CRa.ii(this.puW, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(52345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */