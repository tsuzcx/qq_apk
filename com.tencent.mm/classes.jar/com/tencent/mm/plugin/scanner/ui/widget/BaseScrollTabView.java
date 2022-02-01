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
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"})
public class BaseScrollTabView
  extends LinearLayout
{
  public static final BaseScrollTabView.a xje;
  private int bns;
  private int fMt;
  private GestureDetector irA;
  private float mxe;
  private Vibrator njY;
  private LinearLayout qTW;
  private int tp;
  private float wWl;
  private float wWm;
  private float wWn;
  private VelocityTracker wWo;
  private boolean xbz;
  private View xiM;
  private ArrayList<a> xiN;
  private int xiO;
  private int xiP;
  private boolean xiQ;
  private boolean xiR;
  private LinearInterpolator xiS;
  private ArrayList<o<Float, Float>> xiT;
  private boolean xiU;
  private e xiV;
  private c xiW;
  private d xiX;
  private float xiY;
  private float xiZ;
  private int xja;
  private boolean xjb;
  private boolean xjc;
  private boolean xjd;
  
  static
  {
    AppMethodBeat.i(52371);
    xje = new BaseScrollTabView.a((byte)0);
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
    this.xbz = true;
    this.xiN = new ArrayList();
    this.bns = -1;
    this.xiP = -1;
    this.xiQ = true;
    this.xiS = new LinearInterpolator();
    this.xiT = new ArrayList();
    this.tp = 1;
    this.xja = -1;
    this.irA = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new f(this));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494571, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(2131304372);
    k.g(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.qTW = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(2131304373);
    k.g(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.xiM = paramContext;
    this.xiO = getResources().getDimensionPixelSize(2131165187);
    if (this.njY == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.njY = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private final void Nk(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)j.C((List)this.xiN, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.dAV();
      e locale = this.xiV;
      if (locale != null)
      {
        locale.Ni(locala.getTabId());
        AppMethodBeat.o(52361);
        return;
      }
      AppMethodBeat.o(52361);
      return;
    }
    AppMethodBeat.o(52361);
  }
  
  private final void Nl(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.tp != paramInt)
    {
      ac.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.tp = paramInt;
      d locald = this.xiX;
      if (locald != null)
      {
        locald.cp(paramInt);
        AppMethodBeat.o(52367);
        return;
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float Nm(int paramInt)
  {
    AppMethodBeat.i(52368);
    o localo = (o)j.C((List)this.xiT, paramInt);
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
    if (this.xiR)
    {
      AppMethodBeat.o(52362);
      return;
    }
    ac.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.xiR = true;
    Object localObject = this.qTW;
    if (localObject == null) {
      k.aVY("container");
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.xiS);
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
    Nk(paramInt1);
    LinearLayout localLinearLayout = this.qTW;
    if (localLinearLayout == null) {
      k.aVY("container");
    }
    float f1 = localLinearLayout.getTranslationX();
    float f2 = Nm(paramInt2);
    localLinearLayout = this.qTW;
    if (localLinearLayout == null) {
      k.aVY("container");
    }
    ac.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(localLinearLayout.getTranslationX()), Float.valueOf(f2) });
    this.bns = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (d.g.a.a)new e(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.xiQ = false;
    localLinearLayout = this.qTW;
    if (localLinearLayout == null) {
      k.aVY("container");
    }
    localLinearLayout.setTranslationX(f2);
    gY(paramInt2, paramInt3);
    AppMethodBeat.o(52359);
  }
  
  private final void bHK()
  {
    AppMethodBeat.i(52349);
    if (this.xjd)
    {
      Vibrator localVibrator = this.njY;
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
    this.xjd = true;
    float f = Nm(this.bns);
    d locald = this.xiX;
    if (locald != null) {
      locald.s(this.bns, paramFloat - f);
    }
    if (paramBoolean)
    {
      Nl(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      Nl(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void gY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)j.C((List)this.xiN, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.dAU();
      e locale = this.xiV;
      if (locale != null) {
        locale.gY(locala.getTabId(), paramInt2);
      }
      bHK();
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
    if (this.xiN.contains(parama))
    {
      ac.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    parama = (View)parama;
    ac.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.xiN.size()) });
    parama.setOnClickListener((View.OnClickListener)new g(this, this.xiN.size(), parama));
    this.xiN.add((a)parama);
    LinearLayout localLinearLayout = this.qTW;
    if (localLinearLayout == null) {
      k.aVY("container");
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
  
  protected final boolean getCanVibrate()
  {
    return this.xjd;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.bns >= 0) && (this.bns < this.xiN.size()))
    {
      a locala = (a)this.xiN.get(this.bns);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public final void hb(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    ac.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.bns), Integer.valueOf(paramInt1), Boolean.valueOf(this.xiR), Boolean.valueOf(this.xiU), Integer.valueOf(paramInt2) });
    if ((this.bns == paramInt1) || (this.xiR))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.bns == -1) {}
    while (this.xiU)
    {
      b(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.bns;
    }
    this.xiP = paramInt1;
    AppMethodBeat.o(52350);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(52364);
    if (paramMotionEvent != null) {}
    boolean bool;
    for (Object localObject = Integer.valueOf(paramMotionEvent.getAction());; localObject = null)
    {
      ac.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject });
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(52364);
      return bool;
    }
    if (!this.xbz)
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
    if (this.wWo == null) {
      this.wWo = VelocityTracker.obtain();
    }
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    ((VelocityTracker)localObject).computeCurrentVelocity(1000);
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    int i = (int)((VelocityTracker)localObject).getXVelocity();
    localObject = this.wWo;
    if (localObject == null) {
      k.fOy();
    }
    int j = (int)((VelocityTracker)localObject).getYVelocity();
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
      bool = false;
    }
    for (;;)
    {
      ac.v("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action: %s, isIntercept: %b", new Object[] { Integer.valueOf(paramMotionEvent.getAction()), Boolean.valueOf(bool) });
      AppMethodBeat.o(52364);
      return bool;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      localObject = this.qTW;
      if (localObject == null) {
        k.aVY("container");
      }
      ac.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject).getTranslationX()) });
      this.wWm = paramMotionEvent.getRawX();
      this.wWn = paramMotionEvent.getRawY();
      localObject = this.qTW;
      if (localObject == null) {
        k.aVY("container");
      }
      this.xiY = ((LinearLayout)localObject).getTranslationX();
      bool = false;
      continue;
      f1 = paramMotionEvent.getRawX() - this.wWm;
      f2 = paramMotionEvent.getRawY() - this.wWn;
      ac.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent action_move tx: %f, ty: %f, velocityX: %d, velocityY: %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
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
    this.fMt = com.tencent.mm.cc.a.ig(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.fMt)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.fMt, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.fMt;
      Object localObject1 = this.xiM;
      if (localObject1 == null) {
        k.aVY("dotView");
      }
      ac.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject1 = this.xiM;
      if (localObject1 == null) {
        k.aVY("dotView");
      }
      float f1 = this.fMt / 2.0F;
      Object localObject2 = this.xiM;
      if (localObject2 == null) {
        k.aVY("dotView");
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      ac.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.xiT.clear();
      f1 = this.fMt / 2.0F;
      localObject1 = (Iterable)this.xiN;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          j.fOc();
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
        this.xiT.add(new o(Float.valueOf(f2), Float.valueOf(f3)));
        ac.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.xiU = true;
      localObject1 = (a)j.iP((List)this.xiN);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        ac.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.bns), Integer.valueOf(this.xiP) });
        if (this.xiP != -1)
        {
          b(this.bns, this.xiP, false, 0);
          this.xiP = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.bns == -1) || (this.bns == 0))
        {
          f1 = Nm(0);
          localObject1 = this.qTW;
          if (localObject1 == null) {
            k.aVY("container");
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          ac.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          b(this.bns, 0, false, 0);
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
    if (!this.xbz)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    ac.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    this.irA.onTouchEvent(paramMotionEvent);
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.wWl = paramMotionEvent.getRawX();
      this.mxe = paramMotionEvent.getRawY();
      Object localObject1 = this.qTW;
      if (localObject1 == null) {
        k.aVY("container");
      }
      this.xiY = ((LinearLayout)localObject1).getTranslationX();
      this.xja = this.bns;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.qTW;
      if (paramMotionEvent == null) {
        k.aVY("container");
      }
      ac.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
      this.xjc = true;
      AppMethodBeat.o(52365);
      return true;
      this.xjc = true;
      if ((this.wWl == 0.0F) && (this.mxe == 0.0F))
      {
        this.wWl = paramMotionEvent.getRawX();
        this.mxe = paramMotionEvent.getRawY();
        this.xja = this.bns;
      }
      else
      {
        f2 = paramMotionEvent.getRawX() - this.wWl;
        paramMotionEvent.getRawY();
        localObject1 = this.qTW;
        if (localObject1 == null) {
          k.aVY("container");
        }
        float f3 = ((LinearLayout)localObject1).getTranslationX();
        localObject1 = (o)j.iP((List)this.xiT);
        float f4;
        label490:
        int i;
        if (localObject1 != null) {
          if ((f3 >= ((Number)((o)localObject1).second).floatValue()) && (f2 > 0.0F))
          {
            f1 = f2 - this.xiZ;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((o)localObject1).second).floatValue()) / 30.0F) * 0.5F));
            ac.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.xiZ), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.xiY);
            f1 += this.xiY;
            this.xiZ = f2;
            localObject1 = this.qTW;
            if (localObject1 == null) {
              k.aVY("container");
            }
            ((LinearLayout)localObject1).setTranslationX(f1);
            localObject1 = (o)j.iP((List)this.xiT);
            if ((localObject1 == null) || (f1 < ((Number)((o)localObject1).second).floatValue())) {
              break label1129;
            }
            i = 0;
          }
        }
        for (;;)
        {
          localObject1 = this.qTW;
          if (localObject1 == null) {
            k.aVY("container");
          }
          ac.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.bns), Integer.valueOf(i) });
          if (this.bns != -1) {
            d(f1, this.xjc);
          }
          if (this.bns == i) {
            break;
          }
          Nk(this.bns);
          this.bns = i;
          gY(i, 2);
          break;
          f1 = ((Number)((o)localObject1).first).floatValue();
          if ((f3 >= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.xiY;
            f1 = (f2 - f4) * 0.5F + f4;
            ac.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label490;
          }
          localObject1 = (o)j.iR((List)this.xiT);
          if (localObject1 != null)
          {
            if ((f3 <= ((Number)((o)localObject1).first).floatValue()) && (f2 < 0.0F))
            {
              f1 = f2 - this.xiZ;
              f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((o)localObject1).first).floatValue() - f3) / 30.0F) * 0.5F));
              ac.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.xiZ), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
              f1 = f4 * f1 + (f3 - this.xiY);
              break label490;
            }
            f1 = ((Number)((o)localObject1).first).floatValue();
            if ((f3 <= (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
            {
              f1 = ((Number)((o)localObject1).first).floatValue();
              f4 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F - this.xiY;
              f1 = (f2 - f4) * 0.5F + f4;
              ac.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
              break label490;
            }
          }
          ac.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
          f1 = f2;
          break label490;
          label1129:
          localObject1 = (o)j.iR((List)this.xiT);
          if ((localObject1 != null) && (f1 <= ((Number)((o)localObject1).first).floatValue()))
          {
            i = Math.max(this.xiT.size() - 1, 0);
          }
          else
          {
            localObject1 = ((Iterable)this.xiT).iterator();
            int j = 0;
            for (;;)
            {
              if (!((Iterator)localObject1).hasNext()) {
                break label1279;
              }
              Object localObject2 = ((Iterator)localObject1).next();
              if (j < 0) {
                j.fOc();
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
        this.wWl = 0.0F;
        this.mxe = 0.0F;
        this.xjc = false;
        ac.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.bns), Boolean.valueOf(this.xjb) });
        if (this.xjb)
        {
          this.xjb = false;
        }
        else
        {
          localObject1 = (o)j.C((List)this.xiT, this.bns);
          if (localObject1 != null)
          {
            f1 = ((Number)((o)localObject1).first).floatValue();
            f1 = (((Number)((o)localObject1).second).floatValue() + f1) / 2.0F;
            i = this.bns;
            localObject1 = this.qTW;
            if (localObject1 == null) {
              k.aVY("container");
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
    ac.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Object localObject1 = ((Iterable)this.xiN).iterator();
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
      LinearLayout localLinearLayout = this.qTW;
      if (localLinearLayout == null) {
        k.aVY("container");
      }
      localLinearLayout.removeView((View)localObject2);
    }
    this.xiN.clear();
    AppMethodBeat.o(52353);
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.xjd = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.xbz = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.xiN).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    localObject = this.xiM;
    if (localObject == null) {
      k.aVY("dotView");
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    k.h(parame, "tabOnSelectedListener");
    this.xiV = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    k.h(paramc, "tabOnClickListener");
    this.xiW = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    k.h(paramd, "tabOnScrollListener");
    this.xiX = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    hb(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      BaseScrollTabView.a(this.xjg, f1 * (f3 - f4) + f2, BaseScrollTabView.d(this.xjg));
      AppMethodBeat.o(52341);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(d.g.a.a parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      parama.invoke();
      BaseScrollTabView.e(this.xjg);
      BaseScrollTabView.f(this.xjg);
      ac.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(BaseScrollTabView.g(this.xjg).getTranslationX()) });
      BaseScrollTabView.h(this.xjg);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"})
  public static final class f
    extends GestureDetector.SimpleOnGestureListener
  {
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      ac.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.i(this.xjg)), Integer.valueOf(BaseScrollTabView.j(this.xjg)) });
      if (BaseScrollTabView.i(this.xjg) == BaseScrollTabView.j(this.xjg)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.j(this.xjg) + 1;
          if (BaseScrollTabView.a(this.xjg, i))
          {
            BaseScrollTabView.k(this.xjg);
            this.xjg.hb(i, 2);
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
          i = BaseScrollTabView.j(this.xjg) - 1;
          if (BaseScrollTabView.a(this.xjg, i))
          {
            BaseScrollTabView.k(this.xjg);
            this.xjg.hb(i, 2);
          }
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(52345);
      if (!BaseScrollTabView.a(this.xjg))
      {
        ac.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
        AppMethodBeat.o(52345);
        return;
      }
      this.xjg.setCanVibrate(true);
      ac.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(this.nBr) });
      paramView = (a)j.C((List)BaseScrollTabView.b(this.xjg), this.nBr);
      if (paramView != null)
      {
        paramView.getTabId();
        BaseScrollTabView.c(this.xjg);
      }
      this.xjg.hb(this.nBr, 1);
      AppMethodBeat.o(52345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */