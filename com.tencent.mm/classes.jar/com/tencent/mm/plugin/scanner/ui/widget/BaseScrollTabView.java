package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
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
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTabView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "canScrollDefaultTab", "", "canVibrate", "getCanVibrate", "()Z", "setCanVibrate", "(Z)V", "container", "currentTranslationX", "", "dotView", "Landroid/view/View;", "dotViewWidth", "enableSwitchTab", "gestureDetector", "Landroid/view/GestureDetector;", "hasScrolledDefaultTab", "isFlingSwitchTab", "isScrollingX", "lastOffsetX", "mDownX", "mDownY", "mInterceptTracker", "Landroid/view/VelocityTracker;", "mInterceptXDown", "mInterceptYDown", "mTouchDownSelectedIndex", "mTouching", "onTabClickListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnClickListener;", "onTabScrollListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnScrollListener;", "onTabSelectedListener", "Lcom/tencent/mm/plugin/scanner/ui/widget/ScrollTabOnSelectedListener;", "pendingSelectedIndex", "scrollInterpolator", "Landroid/view/animation/LinearInterpolator;", "scrollState", "selectedIndex", "tabTranslationInited", "tabTranslationXAreaList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "tabViewList", "Lcom/tencent/mm/plugin/scanner/ui/widget/IScrollTab;", "vibrator", "Landroid/os/Vibrator;", "viewWidth", "addTab", "", "tab", "addTabInternal", "animateScrollX", "targetIndex", "fromTransX", "toTransX", "duration", "", "onScrollEnd", "Lkotlin/Function0;", "changeScrollState", "state", "changeTab", "fromIndex", "toIndex", "needScrollAnimation", "tabSelectedAction", "computeTabTranslationXArea", "getIndexByTransX", "transX", "getMoveOffsetX", "offsetX", "getSelectedTab", "getTargetTransXByIndex", "handleScroll", "offsetY", "init", "initDotView", "initTabClickListener", "index", "initVibrator", "isIndexValid", "onAddTab", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onRemoveTab", "onScrollX", "currentTransX", "isTouching", "onTabSelected", "onTabUnselected", "onTouchEvent", "onTouchUp", "removeAllTabs", "removeTab", "removeTabInternal", "scrollDefaultTab", "setEnableSwitchTab", "enable", "setEnabled", "enabled", "setOnTabChangedListener", "tabOnSelectedListener", "setOnTabClickListener", "tabOnClickListener", "setOnTabScrollListener", "tabOnScrollListener", "setSelectedTab", "vibrate", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public class BaseScrollTabView
  extends LinearLayout
{
  public static final BaseScrollTabView.a PeP;
  private LinearLayout Api;
  private boolean OXr;
  private View PeQ;
  private ArrayList<a> PeR;
  private int PeS;
  private int PeT;
  private boolean PeU;
  private boolean PeV;
  private LinearInterpolator PeW;
  private ArrayList<r<Float, Float>> PeX;
  private boolean PeY;
  private e PeZ;
  private c Pfa;
  private d Pfb;
  private float Pfc;
  private float Pfd;
  private int Pfe;
  private boolean Pff;
  private boolean Pfg;
  private boolean Pfh;
  private int dbk;
  private int dyP;
  private int mbM;
  private GestureDetector nwZ;
  private float puO;
  private float puP;
  private float puQ;
  private float puR;
  private VelocityTracker puS;
  private Vibrator uAL;
  
  static
  {
    AppMethodBeat.i(52371);
    PeP = new BaseScrollTabView.a((byte)0);
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
    this.OXr = true;
    this.PeR = new ArrayList();
    this.dbk = -1;
    this.PeT = -1;
    this.PeU = true;
    this.PeW = new LinearInterpolator();
    this.PeX = new ArrayList();
    this.dyP = 1;
    this.Pfe = -1;
    this.nwZ = new GestureDetector(getContext(), (GestureDetector.OnGestureListener)new e(this));
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.OKe, (ViewGroup)this, true);
    paramAttributeSet = paramContext.findViewById(l.f.OJC);
    s.s(paramAttributeSet, "view.findViewById(R.id.scroll_tab_container)");
    this.Api = ((LinearLayout)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.OJD);
    s.s(paramContext, "view.findViewById(R.id.scroll_tab_dot)");
    this.PeQ = paramContext;
    this.PeS = getResources().getDimensionPixelSize(l.d.BasicPaddingSize);
    if (this.uAL == null)
    {
      paramContext = getContext().getSystemService("vibrator");
      if (paramContext != null) {
        this.uAL = ((Vibrator)paramContext);
      }
    }
    AppMethodBeat.o(52370);
  }
  
  private static final void a(float paramFloat1, float paramFloat2, BaseScrollTabView paramBaseScrollTabView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(314806);
    s.u(paramBaseScrollTabView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramBaseScrollTabView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314806);
      throw paramBaseScrollTabView;
    }
    paramBaseScrollTabView.f(((Float)paramValueAnimator).floatValue() * (paramFloat2 - paramFloat1) + paramFloat1, paramBaseScrollTabView.Pfg);
    AppMethodBeat.o(314806);
  }
  
  private final void a(int paramInt, float paramFloat1, float paramFloat2, long paramLong, kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(52362);
    if (this.PeV)
    {
      AppMethodBeat.o(52362);
      return;
    }
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX targetIndex: %d, fromTransX: %f, toTransX: %f", new Object[] { Integer.valueOf(paramInt), Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    this.PeV = true;
    LinearLayout localLinearLayout = this.Api;
    Object localObject = localLinearLayout;
    if (localLinearLayout == null)
    {
      s.bIx("container");
      localObject = null;
    }
    localObject = ((LinearLayout)localObject).animate();
    if (localObject != null)
    {
      localObject = ((ViewPropertyAnimator)localObject).setInterpolator((TimeInterpolator)this.PeW);
      if (localObject != null)
      {
        localObject = ((ViewPropertyAnimator)localObject).translationX(paramFloat2);
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setUpdateListener(new BaseScrollTabView..ExternalSyntheticLambda0(paramFloat1, paramFloat2, this));
          if (localObject != null)
          {
            parama = ((ViewPropertyAnimator)localObject).setListener((Animator.AnimatorListener)new c(parama, this));
            if (parama != null)
            {
              parama = parama.setDuration(paramLong);
              if (parama != null) {
                parama.start();
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(52362);
  }
  
  private static final void a(BaseScrollTabView paramBaseScrollTabView, int paramInt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(314799);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBaseScrollTabView);
    localb.sc(paramInt);
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBaseScrollTabView, "this$0");
    s.u(paramView1, "$tab");
    if (!paramBaseScrollTabView.OXr)
    {
      Log.w("MicroMsg.BaseScrollTabView", "alvinluo onTabClick not enableSwitchTab");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(314799);
      return;
    }
    paramBaseScrollTabView.setCanVibrate(true);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo onTabClick index: %d", new Object[] { Integer.valueOf(paramInt) });
    paramView1 = (a)p.ae((List)paramBaseScrollTabView.PeR, paramInt);
    if (paramView1 != null) {
      paramView1.getTabId();
    }
    paramBaseScrollTabView.kU(paramInt, 1);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(314799);
  }
  
  private final void ait(int paramInt)
  {
    AppMethodBeat.i(52361);
    a locala = (a)p.ae((List)this.PeR, paramInt);
    if (locala != null)
    {
      b(locala, paramInt);
      locala.gTj();
      e locale = this.PeZ;
      if (locale != null) {
        locale.aiq(locala.getTabId());
      }
    }
    AppMethodBeat.o(52361);
  }
  
  private final void aiu(int paramInt)
  {
    AppMethodBeat.i(52367);
    if (this.dyP != paramInt)
    {
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeScrollState state: %d", new Object[] { Integer.valueOf(paramInt) });
      this.dyP = paramInt;
      d locald = this.Pfb;
      if (locald != null) {
        locald.onScrollStateChanged(paramInt);
      }
    }
    AppMethodBeat.o(52367);
  }
  
  private final float aiv(int paramInt)
  {
    AppMethodBeat.i(52368);
    r localr = (r)p.ae((List)this.PeX, paramInt);
    if (localr != null)
    {
      float f = ((Number)localr.bsC).floatValue();
      f = (((Number)localr.bsD).floatValue() + f) / 2.0F;
      AppMethodBeat.o(52368);
      return f;
    }
    AppMethodBeat.o(52368);
    return 0.0F;
  }
  
  private final void cZL()
  {
    AppMethodBeat.i(52349);
    if (this.Pfh)
    {
      Vibrator localVibrator = this.uAL;
      if (localVibrator != null) {
        localVibrator.vibrate(10L);
      }
    }
    AppMethodBeat.o(52349);
  }
  
  private final void d(int paramInt1, final int paramInt2, boolean paramBoolean, final int paramInt3)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52359);
    if (paramInt1 == paramInt2)
    {
      AppMethodBeat.o(52359);
      return;
    }
    ait(paramInt1);
    LinearLayout localLinearLayout = this.Api;
    Object localObject1 = localLinearLayout;
    if (localLinearLayout == null)
    {
      s.bIx("container");
      localObject1 = null;
    }
    float f1 = ((LinearLayout)localObject1).getTranslationX();
    float f2 = aiv(paramInt2);
    localLinearLayout = this.Api;
    localObject1 = localLinearLayout;
    if (localLinearLayout == null)
    {
      s.bIx("container");
      localObject1 = null;
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo changeTab from: %d, to: %d, currentTransX: %f, targetTransX: %f", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Float.valueOf(f2) });
    this.dbk = paramInt2;
    if (paramBoolean)
    {
      a(this, paramInt2, f1, f2, 0L, (kotlin.g.a.a)new d(this, paramInt2, paramInt3), 8);
      AppMethodBeat.o(52359);
      return;
    }
    this.PeU = false;
    localObject1 = this.Api;
    if (localObject1 == null)
    {
      s.bIx("container");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((LinearLayout)localObject1).setTranslationX(f2);
      kR(paramInt2, paramInt3);
      AppMethodBeat.o(52359);
      return;
    }
  }
  
  private final void f(float paramFloat, boolean paramBoolean)
  {
    AppMethodBeat.i(52366);
    this.Pfh = true;
    float f = aiv(this.dbk);
    d locald = this.Pfb;
    if (locald != null) {
      locald.y(this.dbk, paramFloat - f);
    }
    if (paramBoolean)
    {
      aiu(2);
      AppMethodBeat.o(52366);
      return;
    }
    if (!paramBoolean) {
      aiu(3);
    }
    AppMethodBeat.o(52366);
  }
  
  private final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(52360);
    a locala = (a)p.ae((List)this.PeR, paramInt1);
    if (locala != null)
    {
      a(locala, paramInt1);
      locala.gTi();
      e locale = this.PeZ;
      if (locale != null) {
        locale.kR(locala.getTabId(), paramInt2);
      }
      cZL();
    }
    AppMethodBeat.o(52360);
  }
  
  public final void WY()
  {
    AppMethodBeat.i(52353);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo removeAllTabs");
    Iterator localIterator = ((Iterable)this.PeR).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      LinearLayout localLinearLayout2 = this.Api;
      LinearLayout localLinearLayout1 = localLinearLayout2;
      if (localLinearLayout2 == null)
      {
        s.bIx("container");
        localLinearLayout1 = null;
      }
      localLinearLayout1.removeView(localView);
    }
    this.PeR.clear();
    AppMethodBeat.o(52353);
  }
  
  protected void a(a parama)
  {
    AppMethodBeat.i(52346);
    s.u(parama, "tab");
    AppMethodBeat.o(52346);
  }
  
  protected void a(a parama, int paramInt)
  {
    AppMethodBeat.i(52347);
    s.u(parama, "tab");
    AppMethodBeat.o(52347);
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(52352);
    s.u(parama, "tab");
    if (this.PeR.contains(parama))
    {
      Log.w("MicroMsg.BaseScrollTabView", "alvinluo addTab tab has been added and ignore, hashCode: %d", new Object[] { Integer.valueOf(parama.hashCode()) });
      AppMethodBeat.o(52352);
      return;
    }
    View localView = (View)parama;
    Log.v("MicroMsg.BaseScrollTabView", "alvinluo addTabInternal size: %d", new Object[] { Integer.valueOf(this.PeR.size()) });
    localView.setOnClickListener(new BaseScrollTabView..ExternalSyntheticLambda1(this, this.PeR.size(), localView));
    this.PeR.add((a)localView);
    parama = this.Api;
    if (parama == null)
    {
      s.bIx("container");
      parama = null;
    }
    for (;;)
    {
      parama.addView(localView, (ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-2, -2));
      a((a)localView);
      AppMethodBeat.o(52352);
      return;
    }
  }
  
  protected void b(a parama, int paramInt)
  {
    AppMethodBeat.i(52348);
    s.u(parama, "tab");
    AppMethodBeat.o(52348);
  }
  
  protected final boolean getCanVibrate()
  {
    return this.Pfh;
  }
  
  public a getSelectedTab()
  {
    AppMethodBeat.i(52357);
    if ((this.dbk >= 0) && (this.dbk < this.PeR.size()))
    {
      a locala = (a)this.PeR.get(this.dbk);
      AppMethodBeat.o(52357);
      return locala;
    }
    AppMethodBeat.o(52357);
    return null;
  }
  
  public final void kU(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(52350);
    Log.i("MicroMsg.BaseScrollTabView", "alvinluo setSelectedTab last: %d, selected: %d, isScrollingX: %b, tabTranslationInited: %b, tabSelectedAction: %d", new Object[] { Integer.valueOf(this.dbk), Integer.valueOf(paramInt1), Boolean.valueOf(this.PeV), Boolean.valueOf(this.PeY), Integer.valueOf(paramInt2) });
    if ((this.dbk == paramInt1) || (this.PeV))
    {
      AppMethodBeat.o(52350);
      return;
    }
    if (this.dbk == -1) {}
    while (this.PeY)
    {
      d(i, paramInt1, true, paramInt2);
      AppMethodBeat.o(52350);
      return;
      i = this.dbk;
    }
    this.PeT = paramInt1;
    AppMethodBeat.o(52350);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(52364);
    if (paramMotionEvent == null) {}
    boolean bool;
    for (Object localObject1 = null;; localObject1 = Integer.valueOf(paramMotionEvent.getAction()))
    {
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent %s", new Object[] { localObject1 });
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      if (!bool) {
        break;
      }
      AppMethodBeat.o(52364);
      return bool;
    }
    if (!this.OXr)
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
    if (this.puS == null) {
      this.puS = VelocityTracker.obtain();
    }
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).addMovement(paramMotionEvent);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    ((VelocityTracker)localObject1).computeCurrentVelocity(1000);
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int i = (int)((VelocityTracker)localObject1).getXVelocity();
    localObject1 = this.puS;
    s.checkNotNull(localObject1);
    int j = (int)((VelocityTracker)localObject1).getYVelocity();
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
      LinearLayout localLinearLayout = this.Api;
      localObject1 = localLinearLayout;
      if (localLinearLayout == null)
      {
        s.bIx("container");
        localObject1 = null;
      }
      Log.d("MicroMsg.BaseScrollTabView", "alvinluo onInterceptTouchEvent down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(((LinearLayout)localObject1).getTranslationX()) });
      this.puQ = paramMotionEvent.getRawX();
      this.puR = paramMotionEvent.getRawY();
      localObject1 = this.Api;
      if (localObject1 == null)
      {
        s.bIx("container");
        localObject1 = localObject2;
      }
      for (;;)
      {
        this.Pfc = ((LinearLayout)localObject1).getTranslationX();
        bool = false;
        break;
      }
      f1 = paramMotionEvent.getRawX() - this.puQ;
      f2 = paramMotionEvent.getRawY() - this.puR;
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
    this.mbM = com.tencent.mm.cd.a.ms(getContext());
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(536870911, -2147483648), paramInt2);
    if ((getMeasuredWidth() != 0) && (getMeasuredWidth() < this.mbM)) {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mbM, 1073741824), paramInt2);
    }
    if (getMeasuredWidth() != 0)
    {
      paramInt1 = this.mbM;
      Object localObject2 = this.PeQ;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dotView");
        localObject1 = null;
      }
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo initDotView viewWidth: %d, dotView width: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(((View)localObject1).getMeasuredWidth()) });
      localObject2 = this.PeQ;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("dotView");
        localObject1 = null;
      }
      float f1 = this.mbM / 2.0F;
      View localView = this.PeQ;
      localObject2 = localView;
      if (localView == null)
      {
        s.bIx("dotView");
        localObject2 = null;
      }
      ((View)localObject1).setTranslationX(f1 - ((View)localObject2).getMeasuredWidth());
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea");
      this.PeX.clear();
      f1 = this.mbM / 2.0F;
      localObject1 = (Iterable)this.PeR;
      paramInt1 = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      paramInt2 = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (paramInt1 < 0) {
          p.kkW();
        }
        localObject2 = (View)localObject2;
        float f2 = f1 - paramInt2 - ((View)localObject2).getMeasuredWidth();
        float f3 = f1 - paramInt2;
        paramInt2 += ((View)localObject2).getMeasuredWidth();
        this.PeX.add(new r(Float.valueOf(f2), Float.valueOf(f3)));
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo computeTabTranslationXArea index: %d, start: %f, end: %f, tabWidth: %d, accumulativeWidth: %d", new Object[] { Integer.valueOf(paramInt1), Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(((View)localObject2).getMeasuredWidth()), Integer.valueOf(paramInt2) });
        paramInt1 += 1;
      }
      this.PeY = true;
      localObject1 = (a)p.oL((List)this.PeR);
      if ((localObject1 != null) && (((View)localObject1).getMeasuredWidth() != 0))
      {
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab selectedIndex: %d, pendingSelectedIndex: %d", new Object[] { Integer.valueOf(this.dbk), Integer.valueOf(this.PeT) });
        if (this.PeT != -1)
        {
          d(this.dbk, this.PeT, false, 0);
          this.PeT = -1;
          AppMethodBeat.o(52358);
          return;
        }
        if ((this.dbk == -1) || (this.dbk == 0))
        {
          f1 = aiv(0);
          localObject2 = this.Api;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("container");
            localObject1 = null;
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo scrollDefaultTab set default tab %f", new Object[] { Float.valueOf(f1) });
          d(this.dbk, 0, false, 0);
        }
      }
    }
    AppMethodBeat.o(52358);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LinearLayout localLinearLayout = null;
    Object localObject2 = null;
    AppMethodBeat.i(52365);
    boolean bool;
    if (paramMotionEvent == null)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    if (!this.OXr)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
    }
    Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouchEvent %s", new Object[] { Integer.valueOf(paramMotionEvent.getAction()) });
    Object localObject1 = this.nwZ;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, locala.aYi(), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((GestureDetector)localObject1).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    }
    for (;;)
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(52365);
      return bool;
      this.puO = paramMotionEvent.getRawX();
      this.puP = paramMotionEvent.getRawY();
      localLinearLayout = this.Api;
      localObject1 = localLinearLayout;
      if (localLinearLayout == null)
      {
        s.bIx("container");
        localObject1 = null;
      }
      this.Pfc = ((LinearLayout)localObject1).getTranslationX();
      this.Pfe = this.dbk;
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = this.Api;
      if (paramMotionEvent == null)
      {
        s.bIx("container");
        paramMotionEvent = (MotionEvent)localObject2;
      }
      for (;;)
      {
        Log.d("MicroMsg.BaseScrollTabView", "alvinluo onTouch down: %f, %f, currentTranslationX: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(paramMotionEvent.getTranslationX()) });
        this.Pfg = true;
        AppMethodBeat.o(52365);
        return true;
      }
      this.Pfg = true;
      if (this.puO == 0.0F)
      {
        i = 1;
        label367:
        if (i == 0) {
          break label428;
        }
        if (this.puP != 0.0F) {
          break label422;
        }
      }
      label422:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label428;
        }
        this.puO = paramMotionEvent.getRawX();
        this.puP = paramMotionEvent.getRawY();
        this.Pfe = this.dbk;
        break;
        i = 0;
        break label367;
      }
      label428:
      f2 = paramMotionEvent.getRawX() - this.puO;
      paramMotionEvent.getRawY();
      localObject2 = this.Api;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("container");
        localObject1 = null;
      }
      float f3 = ((LinearLayout)localObject1).getTranslationX();
      localObject1 = (r)p.oL((List)this.PeX);
      float f4;
      if (localObject1 != null) {
        if ((f3 >= ((Number)((r)localObject1).bsD).floatValue()) && (f2 > 0.0F))
        {
          f1 = f2 - this.Pfd;
          f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (f3 - ((Number)((r)localObject1).bsD).floatValue()) / 30.0F) * 0.5F));
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.Pfd), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
          f1 = f4 * f1 + (f3 - this.Pfc);
          label618:
          f1 += this.Pfc;
          this.Pfd = f2;
          localObject2 = this.Api;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("container");
            localObject1 = null;
          }
          ((LinearLayout)localObject1).setTranslationX(f1);
          localObject1 = (r)p.oL((List)this.PeX);
          if ((localObject1 == null) || (f1 < ((Number)((r)localObject1).bsD).floatValue())) {
            break label1268;
          }
          i = 0;
          label699:
          localObject1 = this.Api;
          if (localObject1 != null) {
            break label1424;
          }
          s.bIx("container");
          localObject1 = localLinearLayout;
        }
      }
      label1418:
      label1424:
      for (;;)
      {
        Log.i("MicroMsg.BaseScrollTabView", "alvinluo handleScroll offsetX: %f, targetTansX: %f, currentTransX: %f, lastScrollIndex: %d, index: %d", new Object[] { Float.valueOf(f2), Float.valueOf(f1), Float.valueOf(((LinearLayout)localObject1).getTranslationX()), Integer.valueOf(this.dbk), Integer.valueOf(i) });
        if (this.dbk != -1) {
          f(f1, this.Pfg);
        }
        if (this.dbk == i) {
          break;
        }
        ait(this.dbk);
        this.dbk = i;
        kR(i, 2);
        break;
        f1 = ((Number)((r)localObject1).bsC).floatValue();
        if ((f3 >= (((Number)((r)localObject1).bsD).floatValue() + f1) / 2.0F) && (f2 > 0.0F))
        {
          f1 = ((Number)((r)localObject1).bsC).floatValue();
          f4 = (((Number)((r)localObject1).bsD).floatValue() + f1) / 2.0F - this.Pfc;
          f1 = (f2 - f4) * 0.5F + f4;
          Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
          break label618;
        }
        localObject1 = (r)p.oN((List)this.PeX);
        if (localObject1 != null)
        {
          if ((f3 <= ((Number)((r)localObject1).bsC).floatValue()) && (f2 < 0.0F))
          {
            f1 = f2 - this.Pfd;
            f4 = Math.max(0.0F, Math.min(0.5F, (1.0F - (((Number)((r)localObject1).bsC).floatValue() - f3) / 30.0F) * 0.5F));
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo lastOffsetX: %f, addOffsetX: %f, factor: %f, offsetX: %f", new Object[] { Float.valueOf(this.Pfd), Float.valueOf(f1), Float.valueOf(f4), Float.valueOf(f2) });
            f1 = f4 * f1 + (f3 - this.Pfc);
            break label618;
          }
          f1 = ((Number)((r)localObject1).bsC).floatValue();
          if ((f3 <= (((Number)((r)localObject1).bsD).floatValue() + f1) / 2.0F) && (f2 < 0.0F))
          {
            f1 = ((Number)((r)localObject1).bsC).floatValue();
            f4 = (((Number)((r)localObject1).bsD).floatValue() + f1) / 2.0F - this.Pfc;
            f1 = (f2 - f4) * 0.5F + f4;
            Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, maxOffset: %f, currentTransX: %f, moveOffset: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f4), Float.valueOf(f3), Float.valueOf(f1) });
            break label618;
          }
        }
        Log.v("MicroMsg.BaseScrollTabView", "alvinluo getMoveOffsetX %f, currentTransX: %f", new Object[] { Float.valueOf(f2), Float.valueOf(f3) });
        f1 = f2;
        break label618;
        label1268:
        localObject1 = (r)p.oN((List)this.PeX);
        if ((localObject1 != null) && (f1 <= ((Number)((r)localObject1).bsC).floatValue()))
        {
          i = Math.max(this.PeX.size() - 1, 0);
          break label699;
        }
        localObject1 = ((Iterable)this.PeX).iterator();
        int j = 0;
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label1418;
          }
          localObject2 = ((Iterator)localObject1).next();
          if (j < 0) {
            p.kkW();
          }
          localObject2 = (r)localObject2;
          if (f1 >= ((Number)((r)localObject2).bsC).floatValue())
          {
            i = j;
            if (f1 < ((Number)((r)localObject2).bsD).floatValue()) {
              break;
            }
          }
          j += 1;
        }
        i = -1;
        break label699;
      }
      this.puO = 0.0F;
      this.puP = 0.0F;
      this.Pfg = false;
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo onTouchUp selectedIndex: %d, isFlingSwitchTab: %b", new Object[] { Integer.valueOf(this.dbk), Boolean.valueOf(this.Pff) });
      if (this.Pff)
      {
        this.Pff = false;
      }
      else
      {
        localObject1 = (r)p.ae((List)this.PeX, this.dbk);
        if (localObject1 != null)
        {
          f1 = ((Number)((r)localObject1).bsC).floatValue();
          f1 = (((Number)((r)localObject1).bsD).floatValue() + f1) / 2.0F;
          i = this.dbk;
          localLinearLayout = this.Api;
          localObject1 = localLinearLayout;
          if (localLinearLayout == null)
          {
            s.bIx("container");
            localObject1 = null;
          }
          a(this, i, ((LinearLayout)localObject1).getTranslationX(), f1, 75L, null, 16);
        }
      }
    }
  }
  
  protected final void setCanVibrate(boolean paramBoolean)
  {
    this.Pfh = paramBoolean;
  }
  
  public void setEnableSwitchTab(boolean paramBoolean)
  {
    this.OXr = paramBoolean;
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(170043);
    super.setEnabled(paramBoolean);
    Object localObject = ((Iterable)this.PeR).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).setTabEnabled(paramBoolean);
    }
    View localView = this.PeQ;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("dotView");
      localObject = null;
    }
    ((View)localObject).setEnabled(paramBoolean);
    AppMethodBeat.o(170043);
  }
  
  public void setOnTabChangedListener(e parame)
  {
    AppMethodBeat.i(52354);
    s.u(parame, "tabOnSelectedListener");
    this.PeZ = parame;
    AppMethodBeat.o(52354);
  }
  
  public void setOnTabClickListener(c paramc)
  {
    AppMethodBeat.i(52355);
    s.u(paramc, "tabOnClickListener");
    this.Pfa = paramc;
    AppMethodBeat.o(52355);
  }
  
  public void setOnTabScrollListener(d paramd)
  {
    AppMethodBeat.i(52356);
    s.u(paramd, "tabOnScrollListener");
    this.Pfb = paramd;
    AppMethodBeat.o(52356);
  }
  
  public void setSelectedTab(int paramInt)
  {
    AppMethodBeat.i(52351);
    kU(paramInt, 0);
    AppMethodBeat.o(52351);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$animateScrollX$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(kotlin.g.a.a<ah> parama, BaseScrollTabView paramBaseScrollTabView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(52342);
      this.Pfj.invoke();
      BaseScrollTabView.a(jdField_this);
      BaseScrollTabView.b(jdField_this);
      LinearLayout localLinearLayout = BaseScrollTabView.c(jdField_this);
      paramAnimator = localLinearLayout;
      if (localLinearLayout == null)
      {
        s.bIx("container");
        paramAnimator = null;
      }
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo animateScrollX onAnimationEnd %f", new Object[] { Float.valueOf(paramAnimator.getTranslationX()) });
      BaseScrollTabView.d(jdField_this);
      AppMethodBeat.o(52342);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(BaseScrollTabView paramBaseScrollTabView, int paramInt1, int paramInt2)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "", "velocityY", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends GestureDetector.SimpleOnGestureListener
  {
    e(BaseScrollTabView paramBaseScrollTabView) {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(314928);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(314928);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(314924);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onDoubleTap(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(314924);
      return bool;
    }
    
    public final boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
    {
      int i = 1;
      AppMethodBeat.i(52344);
      Log.v("MicroMsg.BaseScrollTabView", "alvinluo onFling velocityX: %f, velocityY: %f, touchDownSelectedIndex: %d, selectedIndex: %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(BaseScrollTabView.e(this.Pfk)), Integer.valueOf(BaseScrollTabView.f(this.Pfk)) });
      if (BaseScrollTabView.e(this.Pfk) == BaseScrollTabView.f(this.Pfk)) {
        if ((Math.abs(paramFloat1) > Math.abs(paramFloat2)) && (i != 0))
        {
          if (paramFloat1 > -100.0F) {
            break label167;
          }
          i = BaseScrollTabView.f(this.Pfk) + 1;
          if (BaseScrollTabView.a(this.Pfk, i))
          {
            BaseScrollTabView.g(this.Pfk);
            this.Pfk.kU(i, 2);
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
          i = BaseScrollTabView.f(this.Pfk) - 1;
          if (BaseScrollTabView.a(this.Pfk, i))
          {
            BaseScrollTabView.g(this.Pfk);
            this.Pfk.kU(i, 2);
          }
        }
      }
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(314919);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(314919);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(314912);
      b localb = new b();
      localb.cH(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/widget/BaseScrollTabView$gestureDetector$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(314912);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.BaseScrollTabView
 * JD-Core Version:    0.7.0.1
 */