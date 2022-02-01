package com.tencent.mm.plugin.scanner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.comm.c.c;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.plugin.comm.c.g;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.pluginsdk.e.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.scanner.ImageQBarDataBean;>;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "CANCEL_VIEW_MARGIN_LEFT", "CANCEL_VIEW_MARGIN_TOP", "CANCEL_VIEW_PADDING", "GREEN_POINT_SIZE", "TIPS_VIEW_MARGIN_BOTTOM", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "greenPointRadius", "mGreenPointViewList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getMGreenPointViewList", "()Ljava/util/ArrayList;", "setMGreenPointViewList", "(Ljava/util/ArrayList;)V", "mMultiCodeMaskViewListener", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "getMMultiCodeMaskViewListener", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "setMMultiCodeMaskViewListener", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;)V", "mSrcDataList", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getMSrcDataList", "setMSrcDataList", "scaleAnimationCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "scaleAnimationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "cancelScaleAnimator", "", "cancelScaleTimer", "dismissAndRestMaskView", "doEnterAnimation", "successView", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getTipsViewFixBottomMargin", "view", "dstPointList", "Landroid/graphics/PointF;", "height", "getTipsViewRect", "Landroid/graphics/Rect;", "getTipsViewText", "", "pointInfoList", "initData", "srcDataList", "dataList", "initScaleAnimation", "isInGreenPointZone", "", "onBackPress", "codeSessionId", "", "fromScanCodeButton", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setCancelView", "setOnMultiCodeMaskViewListener", "listener", "setTipsView", "Companion", "MultiCodeMaskViewListener", "plugin-comm_release"})
public final class MultiCodeMaskView
  extends RelativeLayout
{
  public static final a IAX;
  private final int IAK;
  private final int IAL;
  private final int IAM;
  private final int IAN;
  private final int IAO;
  private final int IAP;
  private ArrayList<View> IAQ;
  private b IAR;
  private ArrayList<ImageQBarDataBean> IAS;
  private final MTimerHandler.CallBack IAT;
  private final MTimerHandler IAU;
  private AccelerateInterpolator IAV;
  private DecelerateInterpolator IAW;
  private ValueAnimator uQS;
  
  static
  {
    AppMethodBeat.i(195110);
    IAX = new a((byte)0);
    AppMethodBeat.o(195110);
  }
  
  public MultiCodeMaskView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(195100);
    setClickable(true);
    this.IAK = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_green_dot_size);
    this.IAL = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.IAM = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.IAN = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.IAO = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.IAP = aw.fromDPToPix(getContext(), 32);
    this.IAQ = new ArrayList();
    this.IAS = new ArrayList();
    this.IAT = ((MTimerHandler.CallBack)new i(this));
    this.IAU = new MTimerHandler(Looper.getMainLooper(), this.IAT, true);
    this.IAV = new AccelerateInterpolator(1.5F);
    this.IAW = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(195100);
  }
  
  public MultiCodeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(195102);
    setClickable(true);
    this.IAK = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_green_dot_size);
    this.IAL = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.IAM = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.IAN = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.IAO = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.IAP = aw.fromDPToPix(getContext(), 32);
    this.IAQ = new ArrayList();
    this.IAS = new ArrayList();
    this.IAT = ((MTimerHandler.CallBack)new i(this));
    this.IAU = new MTimerHandler(Looper.getMainLooper(), this.IAT, true);
    this.IAV = new AccelerateInterpolator(1.5F);
    this.IAW = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(195102);
  }
  
  public MultiCodeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(195107);
    setClickable(true);
    this.IAK = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_green_dot_size);
    this.IAL = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.IAM = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.IAN = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.IAO = com.tencent.mm.ci.a.aY(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.IAP = aw.fromDPToPix(getContext(), 32);
    this.IAQ = new ArrayList();
    this.IAS = new ArrayList();
    this.IAT = ((MTimerHandler.CallBack)new i(this));
    this.IAU = new MTimerHandler(Looper.getMainLooper(), this.IAT, true);
    this.IAV = new AccelerateInterpolator(1.5F);
    this.IAW = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(195107);
  }
  
  private final void a(final float paramFloat1, final float paramFloat2, final Interpolator paramInterpolator, final Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(195062);
    Log.d("MicroMsg.MultiCodeMaskView", "runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    fBI();
    this.uQS = new ValueAnimator();
    ValueAnimator localValueAnimator = this.uQS;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new f(this, paramFloat1, paramFloat2, paramInterpolator, paramAnimatorListener));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
      AppMethodBeat.o(195062);
      return;
    }
    AppMethodBeat.o(195062);
  }
  
  private final boolean a(View paramView, ArrayList<PointF> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(195076);
    paramView = aw(paramView, paramInt);
    paramArrayList = ((Iterable)paramArrayList).iterator();
    boolean bool = false;
    while (paramArrayList.hasNext())
    {
      PointF localPointF = (PointF)paramArrayList.next();
      Log.d("MicroMsg.MultiCodeMaskView", "isInGreenPointZone:" + localPointF + "   r:" + this.IAP);
      if ((paramView.contains((int)(localPointF.x - this.IAP), (int)(localPointF.y - this.IAP))) || (paramView.contains((int)(localPointF.x - this.IAP), (int)(localPointF.y + this.IAP))) || (paramView.contains((int)(localPointF.x + this.IAP), (int)(localPointF.y - this.IAP))) || (paramView.contains((int)(localPointF.x + this.IAP), (int)(localPointF.y + this.IAP))))
      {
        bool = true;
        Log.i("MicroMsg.MultiCodeMaskView", "isInGreenPointZone match point:" + localPointF + "   r:" + this.IAP);
      }
    }
    Log.d("MicroMsg.MultiCodeMaskView", "isInGreenPointZone   viewRect：" + paramView + "  " + bool);
    AppMethodBeat.o(195076);
    return bool;
  }
  
  private final String aY(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(195094);
    Object localObject = "";
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = (ArrayList<ImageQBarDataBean>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (ImageQBarDataBean)localIterator.next();
      if (k.bY(((ImageQBarDataBean)localObject).fys, ((ImageQBarDataBean)localObject).IAH))
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_appbrand_tips);
        p.j(paramArrayList, "context.getString(R.stri…_mask_view_appbrand_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).fys));
      }
      else if (!e.d.apt(((ImageQBarDataBean)localObject).fys))
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_tiao_tips);
        p.j(paramArrayList, "context.getString(R.stri…code_mask_view_tiao_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).fys));
      }
      else
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_two_dimension_tips);
        p.j(paramArrayList, "context.getString(R.stri…_view_two_dimension_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).fys));
      }
    }
    if (localHashSet.size() > 1)
    {
      paramArrayList = getContext().getString(c.h.multi_code_mask_view_multi_tips);
      p.j(paramArrayList, "context.getString(R.stri…ode_mask_view_multi_tips)");
    }
    AppMethodBeat.o(195094);
    return paramArrayList;
  }
  
  private final void adf(final int paramInt)
  {
    AppMethodBeat.i(195056);
    Log.d("MicroMsg.MultiCodeMaskView", "runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new g(this, new h(this, paramInt));
    a(1.0F, 0.8F, (Interpolator)this.IAV, localAnimatorListener);
    AppMethodBeat.o(195056);
  }
  
  private final Rect aw(View paramView, int paramInt)
  {
    AppMethodBeat.i(195070);
    Rect localRect = new Rect();
    View localView = getRootView();
    p.j(localView, "rootView");
    localRect.left = (localView.getWidth() / 2 - paramView.getMeasuredWidth() / 2);
    localRect.top = (paramInt - this.IAO - paramView.getMeasuredHeight());
    localView = getRootView();
    p.j(localView, "rootView");
    localRect.right = (localView.getWidth() / 2 + paramView.getMeasuredWidth() / 2);
    localRect.bottom = (paramInt - this.IAO);
    AppMethodBeat.o(195070);
    return localRect;
  }
  
  private final int b(View paramView, ArrayList<PointF> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(195086);
    int k = this.IAO;
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(195086);
      return k;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll((Collection)paramArrayList);
    kotlin.a.j.a((List)localObject1, (Comparator)new MultiCodeMaskView.c());
    paramView = aw(paramView, paramInt);
    int i2 = paramView.bottom;
    int i3 = paramView.top;
    localObject1 = (Iterable)paramArrayList;
    int n = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    int m = paramInt;
    int i1 = 0;
    if (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (n < 0) {
        kotlin.a.j.iBO();
      }
      localObject2 = (PointF)localObject2;
      i = m;
      int j = k;
      float f;
      if (((PointF)localObject2).y - this.IAP - i1 > paramView.height())
      {
        i = Math.abs(i3 - i1);
        f = Math.abs(i2 - ((PointF)localObject2).y + this.IAP);
        if ((i >= f) || (i >= m)) {
          break label397;
        }
        j = paramInt - paramView.height() - i1;
      }
      for (;;)
      {
        m = i;
        k = j;
        if (n == paramArrayList.size() - 1)
        {
          m = i;
          k = j;
          if (paramInt - ((PointF)localObject2).y - this.IAP > paramView.height())
          {
            f = Math.abs(i3 - (((PointF)localObject2).y + this.IAP));
            m = i;
            k = j;
            if (f < i)
            {
              m = (int)f;
              k = (int)(paramInt - ((PointF)localObject2).y - this.IAP - paramView.height());
            }
          }
        }
        i1 = (int)(((PointF)localObject2).y + this.IAP);
        n += 1;
        break;
        label397:
        i = m;
        j = k;
        if (f < m)
        {
          i = (int)f;
          j = (int)(paramInt - ((PointF)localObject2).y + this.IAP);
        }
      }
    }
    Log.d("MicroMsg.MultiCodeMaskView", "getTipsViewFixBottomMargin:".concat(String.valueOf(k)));
    AppMethodBeat.o(195086);
    return k;
  }
  
  private final void fBI()
  {
    AppMethodBeat.i(195066);
    ValueAnimator localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.uQS;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.uQS = null;
    AppMethodBeat.o(195066);
  }
  
  private final void setCancelView(final ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(195046);
    View localView = LayoutInflater.from(getContext()).inflate(c.f.layout_multi_code_mask_cancel_view, null);
    p.j(localView, "LayoutInflater.from(cont…e_mask_cancel_view, null)");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.IAL;
    localLayoutParams.topMargin = this.IAM;
    localView.setPadding(this.IAN, this.IAN, this.IAN, this.IAN);
    addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
    localView.setOnClickListener((View.OnClickListener)new j(this, paramArrayList));
    AppMethodBeat.o(195046);
  }
  
  public final void F(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(195048);
    j localj = j.IAG;
    j.a(paramLong, 3, this.IAS, null, 0L, paramBoolean);
    fBH();
    AppMethodBeat.o(195048);
  }
  
  public final void a(final ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<PointF> paramArrayList, final ArrayList<ImageQBarDataBean> paramArrayList2, int paramInt)
  {
    AppMethodBeat.i(195041);
    p.k(paramArrayList1, "srcDataList");
    p.k(paramArrayList, "dstPointList");
    p.k(paramArrayList2, "dataList");
    setVisibility(0);
    removeAllViews();
    this.IAQ.clear();
    this.IAS.clear();
    this.IAS.addAll((Collection)paramArrayList1);
    Object localObject1;
    Object localObject2;
    if (paramArrayList.size() > 1)
    {
      setBackgroundColor(Color.parseColor("#B3000000"));
      localObject1 = ((Iterable)paramArrayList).iterator();
      int i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        Object localObject3 = (PointF)localObject2;
        localObject2 = LayoutInflater.from(getContext()).inflate(c.f.layout_scan_code_success_mark_view, null);
        p.j(localObject2, "LayoutInflater.from(cont…_success_mark_view, null)");
        ((View)localObject2).setVisibility(0);
        View localView = ((View)localObject2).findViewById(c.e.scan_success_dot_view);
        if (localView == null)
        {
          paramArrayList1 = new t("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(195041);
          throw paramArrayList1;
        }
        ((ImageView)localView).setImageResource(c.g.scan_success_mark_dot_with_arrow);
        addView((View)localObject2, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.IAK, this.IAK));
        ((View)localObject2).setTranslationX(((PointF)localObject3).x - this.IAP);
        ((View)localObject2).setTranslationY(((PointF)localObject3).y - this.IAP);
        localObject3 = paramArrayList2.get(i);
        p.j(localObject3, "dataList[index]");
        ((View)localObject2).setOnClickListener((View.OnClickListener)new d((ImageQBarDataBean)localObject3, this, paramArrayList2, paramArrayList1));
        this.IAQ.add(localObject2);
        i += 1;
      }
      setCancelView(paramArrayList1);
      paramArrayList1 = LayoutInflater.from(getContext()).inflate(c.f.layout_multi_code_mask_tips_view, null);
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(195041);
        throw paramArrayList1;
      }
      paramArrayList1 = (TextView)paramArrayList1;
      paramArrayList1.setText((CharSequence)aY(paramArrayList2));
      paramArrayList2 = new RelativeLayout.LayoutParams(-2, -2);
      paramArrayList2.addRule(12);
      paramArrayList2.addRule(14);
      paramArrayList2.bottomMargin = this.IAO;
      paramArrayList1.measure(-2, -2);
      if (a((View)paramArrayList1, paramArrayList, paramInt)) {
        paramArrayList2.bottomMargin = b((View)paramArrayList1, paramArrayList, paramInt);
      }
      addView((View)paramArrayList1, (ViewGroup.LayoutParams)paramArrayList2);
      this.IAU.stopTimer();
      Log.d("MicroMsg.MultiCodeMaskView", "initScaleAnimation period: %d", new Object[] { Long.valueOf(3350L) });
      this.IAU.startTimer(0L, 3350L);
      AppMethodBeat.o(195041);
      return;
    }
    if (paramArrayList.size() == 1)
    {
      setBackgroundColor(0);
      paramArrayList = paramArrayList.get(0);
      p.j(paramArrayList, "dstPointList[0]");
      paramArrayList = (PointF)paramArrayList;
      paramArrayList2 = paramArrayList2.get(0);
      p.j(paramArrayList2, "dataList[0]");
      paramArrayList2 = (ImageQBarDataBean)paramArrayList2;
      localObject1 = LayoutInflater.from(getContext()).inflate(c.f.layout_scan_code_success_mark_view, null);
      p.j(localObject1, "LayoutInflater.from(cont…_success_mark_view, null)");
      ((View)localObject1).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(c.e.scan_success_dot_view);
      if (localObject2 == null)
      {
        paramArrayList1 = new t("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(195041);
        throw paramArrayList1;
      }
      ((ImageView)localObject2).setImageResource(c.g.scan_success_mark_dot);
      addView((View)localObject1, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.IAK, this.IAK));
      ((View)localObject1).setTranslationX(paramArrayList.x - this.IAP);
      ((View)localObject1).setTranslationY(paramArrayList.y - this.IAP);
      this.IAQ.add(localObject1);
      a(0.0F, 1.0F, (Interpolator)this.IAW, (Animator.AnimatorListener)new e(this, paramArrayList1, paramArrayList2));
    }
    AppMethodBeat.o(195041);
  }
  
  public final void fBH()
  {
    AppMethodBeat.i(195052);
    fBI();
    this.IAU.stopTimer();
    this.IAQ.clear();
    this.IAS.clear();
    removeAllViews();
    setVisibility(8);
    AppMethodBeat.o(195052);
  }
  
  public final ArrayList<View> getMGreenPointViewList()
  {
    return this.IAQ;
  }
  
  public final b getMMultiCodeMaskViewListener()
  {
    return this.IAR;
  }
  
  public final ArrayList<ImageQBarDataBean> getMSrcDataList()
  {
    return this.IAS;
  }
  
  public final void setMGreenPointViewList(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(195015);
    p.k(paramArrayList, "<set-?>");
    this.IAQ = paramArrayList;
    AppMethodBeat.o(195015);
  }
  
  public final void setMMultiCodeMaskViewListener(b paramb)
  {
    this.IAR = paramb;
  }
  
  public final void setMSrcDataList(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(195022);
    p.k(paramArrayList, "<set-?>");
    this.IAS = paramArrayList;
    AppMethodBeat.o(195022);
  }
  
  public final void setOnMultiCodeMaskViewListener(b paramb)
  {
    AppMethodBeat.i(195024);
    p.k(paramb, "listener");
    this.IAR = paramb;
    AppMethodBeat.o(195024);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$Companion;", "", "()V", "SCALE_ANIMATION_DELAY", "", "SCALE_ANIMATION_DURATION", "SCALE_ANIMATION_FROM_SCALE_FOR_SINGLE_POINT", "", "SCALE_ANIMATION_MAX_SCALE", "SCALE_ANIMATION_MIN_SCALE", "SCALE_ANIMATION_PERIOD", "SCALE_ANIMATION_TO_SCALE_FOR_SINGLE_POINT", "SCAN_LINE_ANIMATION_DURATION", "TAG", "", "plugin-comm_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "", "onCancelSelect", "", "srcDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "onSelectQBarCode", "info", "autoSelect", "", "plugin-comm_release"})
  public static abstract interface b
  {
    public abstract void a(ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, boolean paramBoolean);
    
    public abstract void as(ArrayList<ImageQBarDataBean> paramArrayList);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/scanner/MultiCodeMaskView$initData$1$1"})
  static final class d
    implements View.OnClickListener
  {
    d(ImageQBarDataBean paramImageQBarDataBean, MultiCodeMaskView paramMultiCodeMaskView, ArrayList paramArrayList1, ArrayList paramArrayList2) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(239549);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/MultiCodeMaskView$initData$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = jdField_this.getMMultiCodeMaskViewListener();
      if (paramView != null) {
        paramView.a(paramArrayList1, this.IAY, false);
      }
      jdField_this.fBH();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/MultiCodeMaskView$initData$$inlined$forEachIndexed$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(239549);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$initData$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(ArrayList paramArrayList, ImageQBarDataBean paramImageQBarDataBean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(218698);
      paramAnimator = this.IAZ.getMMultiCodeMaskViewListener();
      if (paramAnimator != null) {
        paramAnimator.a(paramArrayList1, paramArrayList2, true);
      }
      this.IAZ.fBH();
      AppMethodBeat.o(218698);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "animation", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate", "com/tencent/mm/plugin/scanner/MultiCodeMaskView$runZoomAnimation$2$1"})
  static final class f
    implements ValueAnimator.AnimatorUpdateListener
  {
    f(MultiCodeMaskView paramMultiCodeMaskView, float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(242767);
      p.j(paramValueAnimator, "animation");
      paramValueAnimator = paramValueAnimator.getAnimatedValue();
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(242767);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      paramValueAnimator = (Iterable)this.IAZ.getMGreenPointViewList();
      int i = 0;
      paramValueAnimator = paramValueAnimator.iterator();
      while (paramValueAnimator.hasNext())
      {
        Object localObject = paramValueAnimator.next();
        if (i < 0) {
          kotlin.a.j.iBO();
        }
        localObject = (View)localObject;
        ((View)localObject).setScaleX(f);
        ((View)localObject).setScaleY(f);
        i += 1;
      }
      AppMethodBeat.o(242767);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"})
  public static final class g
    implements Animator.AnimatorListener
  {
    g(MultiCodeMaskView.h paramh) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(229308);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(229308);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiCodeMaskView.g paramg) {}
      
      public final void run()
      {
        AppMethodBeat.i(217995);
        MultiCodeMaskView.a(this.IBh.IAZ, (Animator.AnimatorListener)this.IBh.IBg);
        AppMethodBeat.o(217995);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"})
  public static final class h
    implements Animator.AnimatorListener
  {
    h(int paramInt) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(194951);
      MMHandlerThread.postToMainThreadDelayed((Runnable)new a(this), 50L);
      AppMethodBeat.o(194951);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(MultiCodeMaskView.h paramh) {}
      
      public final void run()
      {
        AppMethodBeat.i(233035);
        if (this.IBj.IBi < 2) {
          MultiCodeMaskView.a(this.IBj.IAZ, this.IBj.IBi + 1);
        }
        AppMethodBeat.o(233035);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "onTimerExpired"})
  static final class i
    implements MTimerHandler.CallBack
  {
    i(MultiCodeMaskView paramMultiCodeMaskView) {}
    
    public final boolean onTimerExpired()
    {
      AppMethodBeat.i(205726);
      MultiCodeMaskView.a(this.IAZ);
      AppMethodBeat.o(205726);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class j
    implements View.OnClickListener
  {
    j(MultiCodeMaskView paramMultiCodeMaskView, ArrayList paramArrayList) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(211966);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/MultiCodeMaskView$setCancelView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.IAZ.fBH();
      paramView = this.IAZ.getMMultiCodeMaskViewListener();
      if (paramView != null) {
        paramView.as(paramArrayList);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/MultiCodeMaskView$setCancelView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211966);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.MultiCodeMaskView
 * JD-Core Version:    0.7.0.1
 */