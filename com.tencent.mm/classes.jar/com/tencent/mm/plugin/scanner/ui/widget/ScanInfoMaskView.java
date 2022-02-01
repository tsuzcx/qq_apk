package com.tencent.mm.plugin.scanner.ui.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.l.f;
import com.tencent.mm.plugin.scanner.l.g;
import com.tencent.mm.plugin.scanner.view.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.c;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasGetInfoIconLocation", "", "hasGetLoadingIconLocation", "infoIcon", "Landroid/widget/ImageView;", "infoIconLocation", "", "infoLayout", "Landroid/view/View;", "isInfoLayoutShowing", "isLoadingShow", "loadingAnimation", "Landroid/view/animation/Animation;", "loadingIcon", "loadingIconLocation", "loadingIconTranslating", "loadingLayout", "needTranslateInfoIcon", "opButton", "Landroid/widget/TextView;", "pendingShowInfoLayout", "pendingShowLoading", "pendingShowLoadingWithAnimation", "root", "successMark", "animateSwitch", "", "animationListener", "Landroid/animation/AnimatorListenerAdapter;", "animateViewAlpha", "view", "show", "duration", "", "cancelLoadingAnimation", "dismissInfoView", "withAnimation", "getInfoLayout", "init", "isShowLoadingView", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setAnchorView", "showInfoView", "viewParams", "Lcom/tencent/mm/plugin/scanner/view/IScanInfoView$ScanInfoViewParams;", "showInfoViewInternal", "showInfoViewWithAnimation", "showLoadingView", "showLoadingViewInternal", "updateInfoLayout", "updateOpButton", "Companion", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ScanInfoMaskView
  extends LinearLayout
  implements com.tencent.mm.plugin.scanner.view.a
{
  public static final ScanInfoMaskView.a PfS;
  public View HxV;
  public View Nwy;
  private boolean OSR;
  private View PfT;
  private View PfU;
  private TextView PfV;
  private int[] PfW;
  private Animation PfX;
  private boolean PfY;
  private boolean PfZ;
  private int[] Pga;
  private boolean Pgb;
  private boolean Pgc;
  private boolean Pgd;
  private boolean Pge;
  private boolean Pgf;
  public boolean Pgg;
  private View lBX;
  private ImageView pli;
  
  static
  {
    AppMethodBeat.i(314947);
    PfS = new ScanInfoMaskView.a((byte)0);
    AppMethodBeat.o(314947);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(314839);
    AppMethodBeat.o(314839);
  }
  
  public ScanInfoMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(314845);
    this.PfW = new int[2];
    this.Pga = new int[2];
    this.Pgg = true;
    paramContext = LayoutInflater.from(paramContext).inflate(l.g.OKc, (ViewGroup)this);
    paramAttributeSet = paramContext.findViewById(l.f.root_container);
    s.s(paramAttributeSet, "view.findViewById(R.id.root_container)");
    this.lBX = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.OJp);
    s.s(paramAttributeSet, "view.findViewById(R.id.scan_loading_layout)");
    this.HxV = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.OJo);
    s.s(paramAttributeSet, "view.findViewById(R.id.scan_loading_icon)");
    this.PfU = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.OJu);
    s.s(paramAttributeSet, "view.findViewById(R.id.scan_result_info_layout)");
    this.Nwy = paramAttributeSet;
    paramAttributeSet = paramContext.findViewById(l.f.OJt);
    s.s(paramAttributeSet, "view.findViewById(R.id.scan_result_info_icon)");
    this.pli = ((ImageView)paramAttributeSet);
    paramContext = paramContext.findViewById(l.f.OJv);
    s.s(paramContext, "view.findViewById(R.id.scan_result_info_op_button)");
    this.PfV = ((TextView)paramContext);
    paramAttributeSet = this.lBX;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("root");
      paramContext = null;
    }
    paramContext.setOnTouchListener(ScanInfoMaskView..ExternalSyntheticLambda2.INSTANCE);
    paramAttributeSet = this.Nwy;
    paramContext = paramAttributeSet;
    if (paramAttributeSet == null)
    {
      s.bIx("infoLayout");
      paramContext = null;
    }
    paramContext = (TextView)paramContext.findViewById(l.f.OJx);
    if (paramContext != null) {
      aw.a((Paint)paramContext.getPaint(), 0.8F);
    }
    paramContext = this.PfV;
    if (paramContext == null)
    {
      s.bIx("opButton");
      paramContext = localObject;
    }
    for (;;)
    {
      aw.a((Paint)paramContext.getPaint(), 0.8F);
      AppMethodBeat.o(314845);
      return;
    }
  }
  
  private final void Cp(boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314854);
    this.Pgc = false;
    this.Pgd = true;
    setVisibility(0);
    View localView = this.Nwy;
    Object localObject1 = localView;
    if (localView == null)
    {
      s.bIx("infoLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localView = this.HxV;
    localObject1 = localView;
    if (localView == null)
    {
      s.bIx("loadingLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject1 = this.PfT;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(8);
    }
    if (!paramBoolean)
    {
      setVisibility(0);
      localObject1 = this.Nwy;
      if (localObject1 == null)
      {
        s.bIx("infoLayout");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((View)localObject1).setAlpha(1.0F);
        AppMethodBeat.o(314854);
        return;
      }
    }
    gTq();
    AppMethodBeat.o(314854);
  }
  
  private final void Cq(final boolean paramBoolean)
  {
    Object localObject2 = null;
    View localView = null;
    AppMethodBeat.i(314876);
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Pge = false;
    this.Pgf = false;
    this.OSR = true;
    this.Pgg = false;
    final kotlin.g.a.a locala = (kotlin.g.a.a)new d(this);
    setVisibility(0);
    Object localObject3 = this.Nwy;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("infoLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject3 = this.HxV;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("loadingLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(0);
    localObject1 = this.PfX;
    if (localObject1 != null) {
      ((Animation)localObject1).cancel();
    }
    if (!paramBoolean)
    {
      localObject1 = this.HxV;
      if (localObject1 == null)
      {
        s.bIx("loadingLayout");
        localObject1 = localView;
      }
      for (;;)
      {
        ((View)localObject1).setAlpha(1.0F);
        if (!this.PfZ) {
          locala.invoke();
        }
        AppMethodBeat.o(314876);
        return;
      }
    }
    localView = this.HxV;
    localObject1 = localView;
    if (localView == null)
    {
      s.bIx("loadingLayout");
      localObject1 = null;
    }
    ((View)localObject1).setAlpha(0.0F);
    ah.c localc;
    float f1;
    if (this.PfT != null)
    {
      localObject1 = this.PfT;
      s.checkNotNull(localObject1);
      if (((View)localObject1).getVisibility() == 0)
      {
        paramBoolean = true;
        localObject3 = new ah.c();
        localc = new ah.c();
        if (!paramBoolean) {
          break label731;
        }
        localObject1 = this.PfT;
        s.checkNotNull(localObject1);
        f1 = ((View)localObject1).getTranslationX();
        float f2 = this.PfW[0];
        localObject1 = this.PfT;
        s.checkNotNull(localObject1);
        ((ah.c)localObject3).aixa = (f1 - f2 + ((View)localObject1).getPaddingLeft());
        localObject1 = this.PfT;
        s.checkNotNull(localObject1);
        f1 = ((View)localObject1).getTranslationY();
        f2 = this.PfW[1];
        localObject1 = this.PfT;
        s.checkNotNull(localObject1);
        localc.aixa = (f1 - f2 + ((View)localObject1).getPaddingTop());
        localView = this.PfU;
        localObject1 = localView;
        if (localView == null)
        {
          s.bIx("loadingIcon");
          localObject1 = null;
        }
        ((View)localObject1).setTranslationX(((ah.c)localObject3).aixa);
        localObject1 = this.PfU;
        if (localObject1 != null) {
          break label728;
        }
        s.bIx("loadingIcon");
        localObject1 = localObject2;
        label440:
        ((View)localObject1).setTranslationY(localc.aixa);
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingViewInternal needDoTranslation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      localObject1 = this.PfT;
      if (localObject1 != null)
      {
        ((View)localObject1).setVisibility(0);
        ((View)localObject1).setAlpha(1.0F);
        ((View)localObject1).setScaleX(1.0F);
        ((View)localObject1).setScaleY(1.0F);
      }
      localObject1 = this.PfT;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null) {
          ((ViewPropertyAnimator)localObject1).cancel();
        }
      }
      localObject1 = this.PfT;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).animate();
        if (localObject1 != null)
        {
          if (paramBoolean)
          {
            f1 = this.PfW[1];
            localObject2 = this.PfT;
            s.checkNotNull(localObject2);
            localObject2 = ((ViewPropertyAnimator)localObject1).translationY(f1 - ((View)localObject2).getPaddingTop());
            if (localObject2 != null)
            {
              f1 = this.PfW[0];
              localView = this.PfT;
              s.checkNotNull(localView);
              ((ViewPropertyAnimator)localObject2).translationX(f1 - localView.getPaddingLeft());
            }
          }
          localObject1 = ((ViewPropertyAnimator)localObject1).alpha(0.0F);
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setListener((Animator.AnimatorListener)new c(this, paramBoolean, locala));
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener(new ScanInfoMaskView..ExternalSyntheticLambda1(this, paramBoolean, (ah.c)localObject3, localc));
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(314876);
      return;
      paramBoolean = false;
      break;
      label728:
      break label440;
      label731:
      locala.invoke();
    }
  }
  
  public static void a(View paramView, AnimatorListenerAdapter paramAnimatorListenerAdapter)
  {
    AppMethodBeat.i(314850);
    paramView.setAlpha(1.0F);
    Log.i("MicroMsg.ScanInfoMaskView", "alvinluo animateViewAlpha view: %s, show: %b", new Object[] { paramView, Boolean.FALSE });
    ViewPropertyAnimator localViewPropertyAnimator = paramView.animate();
    if (localViewPropertyAnimator != null)
    {
      localViewPropertyAnimator = localViewPropertyAnimator.alpha(0.0F);
      if (localViewPropertyAnimator != null)
      {
        localViewPropertyAnimator = localViewPropertyAnimator.setDuration(150L);
        if (localViewPropertyAnimator != null)
        {
          paramView = localViewPropertyAnimator.setListener((Animator.AnimatorListener)new ScanInfoMaskView.b(paramView, paramAnimatorListenerAdapter));
          if (paramView != null) {
            paramView.start();
          }
        }
      }
    }
    AppMethodBeat.o(314850);
  }
  
  private static final void a(ScanInfoMaskView paramScanInfoMaskView)
  {
    AppMethodBeat.i(314887);
    s.u(paramScanInfoMaskView, "this$0");
    paramScanInfoMaskView.requestLayout();
    AppMethodBeat.o(314887);
  }
  
  private static final void a(ScanInfoMaskView paramScanInfoMaskView, float paramFloat1, float paramFloat2, ValueAnimator paramValueAnimator)
  {
    Object localObject1 = null;
    AppMethodBeat.i(314894);
    s.u(paramScanInfoMaskView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanInfoMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314894);
      throw paramScanInfoMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Object localObject2 = paramScanInfoMaskView.Nwy;
    paramValueAnimator = (ValueAnimator)localObject2;
    if (localObject2 == null)
    {
      s.bIx("infoLayout");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(f);
    localObject2 = paramScanInfoMaskView.PfV;
    paramValueAnimator = (ValueAnimator)localObject2;
    if (localObject2 == null)
    {
      s.bIx("opButton");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(f);
    localObject2 = paramScanInfoMaskView.pli;
    paramValueAnimator = (ValueAnimator)localObject2;
    if (localObject2 == null)
    {
      s.bIx("infoIcon");
      paramValueAnimator = null;
    }
    paramValueAnimator.setTranslationX(paramFloat1 + (0.0F - paramFloat1) * f);
    paramScanInfoMaskView = paramScanInfoMaskView.pli;
    if (paramScanInfoMaskView == null)
    {
      s.bIx("infoIcon");
      paramScanInfoMaskView = localObject1;
    }
    for (;;)
    {
      paramScanInfoMaskView.setTranslationY(paramFloat2 + (0.0F - paramFloat2) * f);
      AppMethodBeat.o(314894);
      return;
    }
  }
  
  private static final void a(ScanInfoMaskView paramScanInfoMaskView, boolean paramBoolean, ah.c paramc1, ah.c paramc2, ValueAnimator paramValueAnimator)
  {
    Object localObject = null;
    AppMethodBeat.i(314906);
    s.u(paramScanInfoMaskView, "this$0");
    s.u(paramc1, "$startTransX");
    s.u(paramc2, "$startTransY");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramScanInfoMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(314906);
      throw paramScanInfoMaskView;
    }
    float f1 = ((Float)paramValueAnimator).floatValue();
    View localView = paramScanInfoMaskView.HxV;
    paramValueAnimator = localView;
    if (localView == null)
    {
      s.bIx("loadingLayout");
      paramValueAnimator = null;
    }
    paramValueAnimator.setAlpha(f1);
    paramValueAnimator = paramScanInfoMaskView.PfT;
    if (paramValueAnimator != null) {
      paramValueAnimator.setVisibility(0);
    }
    float f4;
    float f5;
    if (paramBoolean)
    {
      paramScanInfoMaskView.PfZ = true;
      float f2 = paramc1.aixa;
      float f3 = paramc1.aixa;
      f4 = paramc2.aixa;
      f5 = paramc2.aixa;
      paramc2 = paramScanInfoMaskView.PfU;
      paramc1 = paramc2;
      if (paramc2 == null)
      {
        s.bIx("loadingIcon");
        paramc1 = null;
      }
      paramc1.setTranslationX((0.0F - f3) * f1 + f2);
      paramScanInfoMaskView = paramScanInfoMaskView.PfU;
      if (paramScanInfoMaskView != null) {
        break label224;
      }
      s.bIx("loadingIcon");
      paramScanInfoMaskView = localObject;
    }
    label224:
    for (;;)
    {
      paramScanInfoMaskView.setTranslationY(f1 * (0.0F - f5) + f4);
      AppMethodBeat.o(314906);
      return;
    }
  }
  
  private static final void b(ScanInfoMaskView paramScanInfoMaskView)
  {
    AppMethodBeat.i(314898);
    s.u(paramScanInfoMaskView, "this$0");
    paramScanInfoMaskView.requestLayout();
    AppMethodBeat.o(314898);
  }
  
  private final void gTq()
  {
    AppMethodBeat.i(314862);
    Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showInfoViewWithAnimation");
    if (this.PfT == null)
    {
      AppMethodBeat.o(314862);
      return;
    }
    Object localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    float f1 = ((View)localObject1).getTranslationX();
    float f2 = this.Pga[0];
    localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    f1 = ((View)localObject1).getPaddingLeft() + (f1 - f2);
    localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    f2 = ((View)localObject1).getTranslationY();
    float f3 = this.Pga[1];
    localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    f2 = ((View)localObject1).getPaddingTop() + (f2 - f3);
    Object localObject2 = this.pli;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("infoIcon");
      localObject1 = null;
    }
    ((ImageView)localObject1).setTranslationX(f1);
    localObject2 = this.pli;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("infoIcon");
      localObject1 = null;
    }
    ((ImageView)localObject1).setTranslationY(f2);
    localObject2 = this.Nwy;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("infoLayout");
      localObject1 = null;
    }
    ((View)localObject1).setAlpha(0.0F);
    localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    ((View)localObject1).setVisibility(0);
    ((View)localObject1).setAlpha(1.0F);
    ((View)localObject1).setScaleX(1.0F);
    ((View)localObject1).setScaleY(1.0F);
    localObject1 = this.PfT;
    s.checkNotNull(localObject1);
    localObject1 = ((View)localObject1).animate();
    if (localObject1 != null)
    {
      localObject1 = ((ViewPropertyAnimator)localObject1).alpha(0.0F);
      if (localObject1 != null)
      {
        f3 = this.Pga[1];
        localObject2 = this.PfT;
        s.checkNotNull(localObject2);
        localObject1 = ((ViewPropertyAnimator)localObject1).translationY(f3 - ((View)localObject2).getPaddingTop());
        if (localObject1 != null)
        {
          f3 = this.Pga[0];
          localObject2 = this.PfT;
          s.checkNotNull(localObject2);
          localObject1 = ((ViewPropertyAnimator)localObject1).translationX(f3 - ((View)localObject2).getPaddingLeft());
          if (localObject1 != null)
          {
            localObject1 = ((ViewPropertyAnimator)localObject1).setDuration(300L);
            if (localObject1 != null)
            {
              localObject1 = ((ViewPropertyAnimator)localObject1).setListener(null);
              if (localObject1 != null)
              {
                localObject1 = ((ViewPropertyAnimator)localObject1).setUpdateListener(new ScanInfoMaskView..ExternalSyntheticLambda0(this, f1, f2));
                if (localObject1 != null) {
                  ((ViewPropertyAnimator)localObject1).start();
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(314862);
  }
  
  private final void gTr()
  {
    AppMethodBeat.i(314867);
    Object localObject = this.PfX;
    if (localObject != null) {
      ((Animation)localObject).cancel();
    }
    View localView = this.PfU;
    localObject = localView;
    if (localView == null)
    {
      s.bIx("loadingIcon");
      localObject = null;
    }
    ((View)localObject).clearAnimation();
    AppMethodBeat.o(314867);
  }
  
  private static final boolean m(View paramView, MotionEvent paramMotionEvent)
  {
    return true;
  }
  
  public final void a(a.a parama)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314986);
    s.u(parama, "viewParams");
    boolean bool = parama.Pko;
    Log.i("MicroMsg.ScanInfoMaskView", "alvinluo showInfoView needTranslateInfoIcon: %b, showTips: %b, title: %s, subTitle: %s", new Object[] { Boolean.valueOf(this.Pgg), Boolean.valueOf(bool), parama.title, parama.lym });
    Object localObject1 = this.Nwy;
    Object localObject3;
    if (localObject1 == null)
    {
      s.bIx("infoLayout");
      localObject1 = null;
      localObject3 = (TextView)((View)localObject1).findViewById(l.f.OJx);
      if (localObject3 != null) {
        ((TextView)localObject3).setText((CharSequence)parama.title);
      }
      localObject1 = (TextView)((View)localObject1).findViewById(l.f.OJw);
      if (localObject1 != null)
      {
        ((TextView)localObject1).setText((CharSequence)parama.lym);
        if (!parama.Pko) {
          break label320;
        }
        i = 0;
        label154:
        ((TextView)localObject1).setVisibility(i);
      }
      localObject3 = this.pli;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("infoIcon");
        localObject1 = null;
      }
      ((ImageView)localObject1).setImageResource(parama.Pkp);
      localObject3 = this.PfV;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("opButton");
        localObject1 = null;
      }
      if (!parama.Pkq) {
        break label326;
      }
    }
    label320:
    label326:
    for (int i = 0;; i = 8)
    {
      ((TextView)localObject1).setVisibility(i);
      localObject3 = this.PfV;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("opButton");
        localObject1 = null;
      }
      ((TextView)localObject1).setOnClickListener(parama.Pkr);
      localObject1 = this.HxV;
      parama = (a.a)localObject1;
      if (localObject1 == null)
      {
        s.bIx("loadingLayout");
        parama = null;
      }
      parama.setVisibility(8);
      if (this.Pgg) {
        break label332;
      }
      this.Pgg = false;
      Cp(false);
      AppMethodBeat.o(314986);
      return;
      break;
      i = 8;
      break label154;
    }
    label332:
    this.Pgb = false;
    this.Pgc = true;
    parama = this.Nwy;
    if (parama == null)
    {
      s.bIx("infoLayout");
      parama = localObject2;
    }
    for (;;)
    {
      parama.setVisibility(0);
      setVisibility(4);
      post(new ScanInfoMaskView..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(314986);
      return;
    }
  }
  
  public final void aL(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(314992);
    Log.v("MicroMsg.ScanInfoMaskView", "alvinluo showLoadingView show: %b, withAnimation: %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    Object localObject4 = this.Nwy;
    Object localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("infoLayout");
      localObject1 = null;
    }
    ((View)localObject1).setVisibility(8);
    localObject4 = this.PfV;
    localObject1 = localObject4;
    if (localObject4 == null)
    {
      s.bIx("opButton");
      localObject1 = null;
    }
    ((TextView)localObject1).setVisibility(8);
    if (paramBoolean1)
    {
      if (!paramBoolean2)
      {
        Cq(false);
        AppMethodBeat.o(314992);
        return;
      }
      this.PfY = false;
      this.Pge = true;
      this.Pgf = paramBoolean2;
      localObject1 = this.HxV;
      if (localObject1 == null)
      {
        s.bIx("loadingLayout");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((View)localObject1).setVisibility(0);
        setVisibility(4);
        post(new ScanInfoMaskView..ExternalSyntheticLambda3(this));
        AppMethodBeat.o(314992);
        return;
      }
    }
    setVisibility(8);
    this.OSR = false;
    localObject1 = this.HxV;
    if (localObject1 == null)
    {
      s.bIx("loadingLayout");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      gTr();
      AppMethodBeat.o(314992);
      return;
    }
  }
  
  public final View getInfoLayout()
  {
    AppMethodBeat.i(314994);
    View localView = this.Nwy;
    if (localView == null)
    {
      s.bIx("infoLayout");
      AppMethodBeat.o(314994);
      return null;
    }
    AppMethodBeat.o(314994);
    return localView;
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    Object localObject2 = null;
    AppMethodBeat.i(314978);
    super.onMeasure(paramInt1, paramInt2);
    Object localObject3;
    Object localObject1;
    if (!this.Pgb)
    {
      localObject3 = this.pli;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("infoIcon");
        localObject1 = null;
      }
      ((ImageView)localObject1).getLocationInWindow(this.Pga);
    }
    if (!this.PfY)
    {
      localObject3 = this.PfU;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("loadingIcon");
        localObject1 = null;
      }
      ((View)localObject1).getLocationInWindow(this.PfW);
    }
    Log.d("MicroMsg.ScanInfoMaskView", "alvinluo onMeasure infoIcon location: %d, %d, loadingIcon location: %d, %d, pendingShowInfoLayout: %b, pendingShowLoading: %b, hasGetInfoIconLocation: %b, hasGetLoadingIconLocation: %b", new Object[] { Integer.valueOf(this.Pga[0]), Integer.valueOf(this.Pga[1]), Integer.valueOf(this.PfW[0]), Integer.valueOf(this.PfW[1]), Boolean.valueOf(this.Pgc), Boolean.valueOf(this.Pge), Boolean.valueOf(this.Pgb), Boolean.valueOf(this.PfY) });
    if ((this.Pga[0] != 0) || (this.Pga[1] != 0))
    {
      this.Pgb = true;
      if (!this.Pgc) {
        break label273;
      }
      Cp(true);
    }
    while ((this.PfW[0] != 0) || (this.PfW[1] != 0))
    {
      this.PfY = true;
      if (this.Pge)
      {
        Cq(this.Pgf);
        AppMethodBeat.o(314978);
        return;
        label273:
        if (!this.Pgd)
        {
          localObject3 = this.Nwy;
          localObject1 = localObject3;
          if (localObject3 == null)
          {
            s.bIx("infoLayout");
            localObject1 = null;
          }
          ((View)localObject1).setVisibility(8);
        }
      }
      else if (!this.OSR)
      {
        localObject1 = this.HxV;
        if (localObject1 != null) {
          break label349;
        }
        s.bIx("loadingLayout");
        localObject1 = localObject2;
      }
    }
    label349:
    for (;;)
    {
      ((View)localObject1).setVisibility(8);
      AppMethodBeat.o(314978);
      return;
    }
  }
  
  public final void setAnchorView(View paramView)
  {
    this.PfT = paramView;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/ui/widget/ScanInfoMaskView$showLoadingViewInternal$3", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends AnimatorListenerAdapter
  {
    c(ScanInfoMaskView paramScanInfoMaskView, boolean paramBoolean, kotlin.g.a.a<ah> parama) {}
    
    public final void onAnimationCancel(Animator paramAnimator)
    {
      AppMethodBeat.i(314718);
      super.onAnimationCancel(paramAnimator);
      ScanInfoMaskView.g(this.Pgi);
      AppMethodBeat.o(314718);
    }
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(314715);
      paramAnimator = ScanInfoMaskView.f(this.Pgi);
      if (paramAnimator != null) {
        paramAnimator.setVisibility(8);
      }
      paramAnimator = ScanInfoMaskView.f(this.Pgi);
      if (paramAnimator != null)
      {
        paramAnimator = paramAnimator.animate();
        if (paramAnimator != null) {
          paramAnimator.setListener(null);
        }
      }
      ScanInfoMaskView.g(this.Pgi);
      if (paramBoolean) {
        locala.invoke();
      }
      AppMethodBeat.o(314715);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(ScanInfoMaskView paramScanInfoMaskView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.widget.ScanInfoMaskView
 * JD-Core Version:    0.7.0.1
 */