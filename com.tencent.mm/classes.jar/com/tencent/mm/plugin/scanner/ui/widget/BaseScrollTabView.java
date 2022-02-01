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
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView
  extends LinearLayout
{
  public static final BaseScrollTabView.a IWz;
  private float BpS;
  private float BpT;
  private float BpU;
  private VelocityTracker BpV;
  private boolean IOP;
  private View IWh;
  private ArrayList<a> IWi;
  private int IWj;
  private int IWk;
  private boolean IWl;
  private boolean IWm;
  private LinearInterpolator IWn;
  private ArrayList<o<Float, Float>> IWo;
  private boolean IWp;
  private e IWq;
  private c IWr;
  private d IWs;
  private float IWt;
  private float IWu;
  private int IWv;
  private boolean IWw;
  private boolean IWx;
  private boolean IWy;
  private int bFP;
  private int bhr;
  private int jBZ;
  private GestureDetector mBn;
  private float rpT;
  private Vibrator rqC;
  private LinearLayout wSF;
  
  static
  {
    AppMethodBeat.i(52371);
    IWz = new BaseScrollTabView.a((byte)0);
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
    this.IOP = true;
    this.IWi = new ArrayList();
    this.bhr = -1;
    this.IWk = -1;
    this.IWl = true;
    this.IWn = new LinearInterpolator();
    this.IWo = new ArrayList();
    this.bFP = 1;
    this.IWv = -1;
    this.mBn = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new f(this));
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.IEb, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(l.f.IDA);
    p.j(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.wSF = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.IDB);
    p.j(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.IWh = paramContext;
    this.IWj = getResources().getDimensionPixelSize(l.d.BasicPaddingSize);
    if (this.rqC == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.rqC = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private final void a(int paramInt, final float paramFloat1, final float paramFloat2, long paramLong, final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(52362);
    if (this.IWm)
    {
      AppMethodBeat.o(52362);
      return;
    }
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.IWm = true;
    Object localObject = this.wSF;
    if (localObject == null) {
      p.bGy("container");
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.IWn);
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
    adR(paramInt1);
    LinearLayout localLinearLayout = this.wSF;
    if (localLinearLayout == null) {
      p.bGy("container");
    }
    float f1 = localLinearLayout.getTranslationX();
    float f2 = adT(paramInt2);
    localLinearLayout = this.wSF;
    if (localLinearLayout == null) {
      p.bGy("container");
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(localLinearLayout.getTranslationX()), Float.valueOf(f2) });
    this.bhr = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (kotlin.g.a.a)new e(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.IWl = false;
    localLinearLayout = this.wSF;
    if (localLinearLayout == null) {
      p.bGy("container");
    }
    localLinearLayout.setTranslationX(f2);
    jk(paramInt2, paramInt3);
    AppMethodBeat.o(52359);
  }
  
  private final void adR(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)j.M((List)this.IWi, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.fEw();
      e locale = this.IWq;
      if (locale != null)
      {
        locale.adP(locala.getTabId());
        AppMethodBeat.o(52361);
        return;
      }
      AppMethodBeat.o(52361);
      return;
    }
    AppMethodBeat.o(52361);
  }
  
  private final void adS(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.bFP != paramInt)
    {
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.bFP = paramInt;
      d locald = this.IWs;
      if (locald != null)
      {
        locald.onScrollStateChanged(paramInt);
        AppMethodBeat.o(52367);
        return;
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float adT(int paramInt)
  {
    AppMethodBeat.i(52368);
    o localo = (o)j.M((List)this.IWo, paramInt);
    if (localo != null)
    {
      float f = ((Number)localo.Mx).floatValue();
      f = (((Number)localo.My).floatValue() + f) / 2.0F;
      AppMethodBeat.o(52368);
      return f;
    }
    AppMethodBeat.o(52368);
    return 0.0F;
  }
  
  private final void cxa()
  {
    AppMethodBeat.i(52349);
    if (this.IWy)
    {
      Vibrator localVibrator = this.rqC;
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
    this.IWy = true;
    float f = adT(this.bhr);
    d locald = this.IWs;
    if (locald != null) {
      locald.v(this.bhr, paramFloat - f);
    }
    if (paramBoolean)
    {
      adS(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      adS(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void jk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)j.M((List)this.IWi, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.fEv();
      e locale = this.IWq;
      if (locale != null) {
        locale.jk(locala.getTabId(), paramInt2);
      }
      cxa();
      AppMethodBeat.o(52360);
      return;
    }
    AppMethodBeat.o(52360);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(52346);
    p.k(parama, "tab");
    AppMethodBeat.o(52346);
  }
  
  protected void a(a parama, int paramInt)
  {
    AppMethodBeat.i(52347);
    p.k(parama, "tab");
    AppMethodBeat.o(52347);
  }
  
  public final void b(final a parama)
  {
    AppMethodBeat.i(52352);
    p.k(parama, "tab");
    if (this.IWi.contains(parama))
    {
      Log.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    parama = (View)parama;
    Log.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.IWi.size()) });
    parama.setOnClickListener((View.OnClickListener)new g(this, this.IWi.size(), parama));
    this.IWi.add((a)parama);
    LinearLayout localLinearLayout = this.wSF;
    if (localLinearLayout == null) {
      p.bGy("container");
    }
    localLinearLayout.addView(parama, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
    a((a)parama);
    AppMethodBeat.o(52352);
  }
  
  protected void b(a parama, int paramInt)
  {
    AppMethodBeat.i(52348);
    p.k(parama, "tab");
    AppMethodBeat.o(52348);
  }
  
  protected final boolean getCanVibrate()
  {
    return this.IWy;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.bhr >= 0) && (this.bhr < this.IWi.size()))
    {
      a locala = (a)this.IWi.get(this.bhr);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public final void jn(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.bhr), Integer.valueOf(paramInt1), Boolean.valueOf(this.IWm), Boolean.valueOf(this.IWp), Integer.valueOf(paramInt2) });
    if ((this.bhr == paramInt1) || (this.IWm))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.bhr == -1) {}
    while (this.IWp)
    {
      a(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.bhr;
    }
    this.IWk = paramInt1;
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
    if (!this.IOP)
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
    if (this.BpV == null) {
      this.BpV = VelocityTracker.obtain();
    }
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.BpV;
    if (localObject == null) {
      p.iCn();
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
      localObject = this.wSF;
      if (localObject == null) {
        p.bGy("container");
      }
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject).getTranslationX()) });
      this.BpT = paramMotionEvent.getRawX();
      this.BpU = paramMotionEvent.getRawY();
      localObject = this.wSF;
      if (localObject == null) {
        p.bGy("container");
      }
      this.IWt = ((LinearLayout)localObject).getTranslationX();
      bool = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.BpT;
      f2 = paramMotionEvent.getRawY() - this.BpU;
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
    this.jBZ = com.tencent.mm.ci.a.kr(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.jBZ)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.jBZ, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.jBZ;
      Object localObject1 = this.IWh;
      if (localObject1 == null) {
        p.bGy("dotView");
      }
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject1 = this.IWh;
      if (localObject1 == null) {
        p.bGy("dotView");
      }
      float f1 = this.jBZ / 2.0F;
      Object localObject2 = this.IWh;
      if (localObject2 == null) {
        p.bGy("dotView");
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.IWo.clear();
      f1 = this.jBZ / 2.0F;
      localObject1 = (Iterable)this.IWi;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          j.iBO();
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
        this.IWo.add(new o(Float.valueOf(f2), Float.valueOf(f3)));
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.IWp = true;
      localObject1 = (a)j.lp((List)this.IWi);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.bhr), Integer.valueOf(this.IWk) });
        if (this.IWk != -1)
        {
          a(this.bhr, this.IWk, false, 0);
          this.IWk = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.bhr == -1) || (this.bhr == 0))
        {
          f1 = adT(0);
          localObject1 = this.wSF;
          if (localObject1 == null) {
            p.bGy("container");
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          a(this.bhr, 0, false, 0);
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
    if (!this.IOP)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    Object localObject1 = this.mBn;
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.a().bm(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0)), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.BpS = paramMotionEvent.getRawX();
      this.rpT = paramMotionEvent.getRawY();
      localObject1 = this.wSF;
      if (localObject1 == null) {
        p.bGy("container");
      }
      this.IWt = ((LinearLayout)localObject1).getTranslationX();
      this.IWv = this.bhr;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.wSF;
      if (paramMotionEvent == null) {
        p.bGy("container");
      }
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
      this.IWx = true;
      AppMethodBeat.o(52365);
      return true;
      this.IWx = true;
      if ((this.BpS == 0.0F) && (this.rpT == 0.0F))
      {
        this.BpS = paramMotionEvent.getRawX();
        this.rpT = paramMotionEvent.getRawY();
        this.IWv = this.bhr;
      }
      else
      {
        f2 = paramMotionEvent.getRawX() - this.BpS;
        paramMotionEvent.getRawY();
        localObject1 = this.wSF;
        if (localObject1 == null) {
          p.bGy("container");
        }
        float f3 = ((LinearLayout)localObject1).getTranslationX();
        localObject1 = (o)j.lp((List)this.IWo);
        float f4;
        label566:
        int i;
        if (localObject1 != null) {
          if ((f3 >= ((Number)((o)localObject1).My).floatValue()) && (f2 > 0.0F))
          {
            f1 = f2 - this.IWu;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((o)localObject1).My).floatValue()) / 30.0F) * 0.5F));
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.IWu), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.IWt);
            f1 += this.IWt;
            this.IWu = f2;
            localObject1 = this.wSF;
            if (localObject1 == null) {
              p.bGy("container");
            }
            ((LinearLayout)localObject1).setTranslationX(f1);
            localObject1 = (o)j.lp((List)this.IWo);
            if ((localObject1 == null) || (f1 < ((Number)((o)localObject1).My).floatValue())) {
              break label1205;
            }
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = this.wSF;
          if (localObject1 == null) {
            p.bGy("container");
          }
          Log.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.bhr), Integer.valueOf(i) });
          if (this.bhr != -1) {
            d(f1, this.IWx);
          }
          if (this.bhr == i) {
            break;
          }
          adR(this.bhr);
          this.bhr = i;
          jk(i, 2);
          break;
          f1 = ((Number)((o)localObject1).Mx).floatValue();
          if ((f3 >= (((Number)((o)localObject1).My).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
          {
            f1 = ((Number)((o)localObject1).Mx).floatValue();
            f4 = (((Number)((o)localObject1).My).floatValue() + f1) / 2.0F - this.IWt;
            f1 = (f2 - f4) * 0.5F + f4;
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label566;
          }
          localObject1 = (o)j.lr((List)this.IWo);
          if (localObject1 != null)
          {
            if ((f3 <= ((Number)((o)localObject1).Mx).floatValue()) && (f2 < 0.0F))
            {
              f1 = f2 - this.IWu;
              f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((o)localObject1).Mx).floatValue() - f3) / 30.0F) * 0.5F));
              Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.IWu), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              f1 = f4 * f1 + (f3 - this.IWt);
              break label566;
            }
            f1 = ((Number)((o)localObject1).Mx).floatValue();
            if ((f3 <= (((Number)((o)localObject1).My).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
            {
              f1 = ((Number)((o)localObject1).Mx).floatValue();
              f4 = (((Number)((o)localObject1).My).floatValue() + f1) / 2.0F - this.IWt;
              f1 = (f2 - f4) * 0.5F + f4;
              Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
              break label566;
            }
          }
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
          f1 = f2;
          break label566;
          label1205:
          localObject1 = (o)j.lr((List)this.IWo);
          if ((localObject1 != null) && (f1 <= ((Number)((o)localObject1).Mx).floatValue()))
          {
            i = Math.max(this.IWo.size() - 1, 0);
          }
          else
          {
            localObject1 = ((Iterable)this.IWo).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1355;
              }
              localObject2 = ((Iterator)localObject1).next();
              if (j < 0) {
                j.iBO();
              }
              localObject2 = (o)localObject2;
              if (f1 >= ((Number)((o)localObject2).Mx).floatValue())
              {
                i = j;
                if (f1 < ((Number)((o)localObject2).My).floatValue()) {
                  break;
                }
              }
              j += 1;
            }
            label1355:
            i = -1;
          }
        }
        this.BpS = 0.0F;
        this.rpT = 0.0F;
        this.IWx = false;
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.bhr), Boolean.valueOf(this.IWw) });
        if (this.IWw)
        {
          this.IWw = false;
        }
        else
        {
          localObject1 = (o)j.M((List)this.IWo, this.bhr);
          if (localObject1 != null)
          {
            f1 = ((Number)((o)localObject1).Mx).floatValue();
            f1 = (((Number)((o)localObject1).My).floatValue() + f1) / 2.0F;
            i = this.bhr;
            localObject1 = this.wSF;
            if (localObject1 == null) {
              p.bGy("container");
            }
            a(this, i, ((LinearLayout)localObject1).getTranslationX(), f1, 75L, null, 16);
          }
        }
      }
    }
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.IWy = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.IOP = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.IWi).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    localObject = this.IWh;
    if (localObject == null) {
      p.bGy("dotView");
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    p.k(parame, "tabOnSelectedListener");
    this.IWq = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    p.k(paramc, "tabOnClickListener");
    this.IWr = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    p.k(paramd, "tabOnScrollListener");
    this.IWs = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    jn(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  public final void xB()
  {
    AppMethodBeat.i(52353);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Object localObject1 = ((Iterable)this.IWi).iterator();
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
      LinearLayout localLinearLayout = this.wSF;
      if (localLinearLayout == null) {
        p.bGy("container");
      }
      localLinearLayout.removeView((View)localObject2);
    }
    this.IWi.clear();
    AppMethodBeat.o(52353);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class c
    implements ValueAnimator.AnimatorUpdateListener
  {
    c(BaseScrollTabView paramBaseScrollTabView, float paramFloat1, float paramFloat2) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(52341);
      p.j(paramValueAnimator, "animation");
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
      BaseScrollTabView.a(this.IWB, f1 * (f3 - f4) + f2, BaseScrollTabView.d(this.IWB));
      AppMethodBeat.o(52341);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(kotlin.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      parama.invoke();
      BaseScrollTabView.e(this.IWB);
      BaseScrollTabView.f(this.IWB);
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(BaseScrollTabView.g(this.IWB).getTranslationX()) });
      BaseScrollTabView.h(this.IWB);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(218603);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(218603);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(218602);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(218602);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.i(this.IWB)), Integer.valueOf(BaseScrollTabView.j(this.IWB)) });
      if (BaseScrollTabView.i(this.IWB) == BaseScrollTabView.j(this.IWB)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.j(this.IWB) + 1;
          if (BaseScrollTabView.a(this.IWB, i))
          {
            BaseScrollTabView.k(this.IWB);
            this.IWB.jn(i, 2);
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
          i = BaseScrollTabView.j(this.IWB) - 1;
          if (BaseScrollTabView.a(this.IWB, i))
          {
            BaseScrollTabView.k(this.IWB);
            this.IWB.jn(i, 2);
          }
        }
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(218601);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(218601);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(218600);
      b localb = new b();
      localb.bn(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(218600);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52345);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!BaseScrollTabView.a(this.IWB))
      {
        Log.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(52345);
        return;
      }
      this.IWB.setCanVibrate(true);
      Log.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(this.nmX) });
      paramView = (a)j.M((List)BaseScrollTabView.b(this.IWB), this.nmX);
      if (paramView != null)
      {
        paramView.getTabId();
        BaseScrollTabView.c(this.IWB);
      }
      this.IWB.jn(this.nmX, 1);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$initTabClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(52345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */