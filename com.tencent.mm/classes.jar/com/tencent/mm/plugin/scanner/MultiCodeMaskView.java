package com.tencent.mm.plugin.scanner;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
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
import com.tencent.mm.pluginsdk.e.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mm.plugin.scanner.ImageQBarDataBean;>;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "CANCEL_VIEW_MARGIN_LEFT", "CANCEL_VIEW_MARGIN_TOP", "CANCEL_VIEW_PADDING", "GREEN_POINT_SIZE", "TIPS_VIEW_MARGIN_BOTTOM", "accelerateInterpolator", "Landroid/view/animation/AccelerateInterpolator;", "decelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "greenPointRadius", "mGreenPointViewList", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "getMGreenPointViewList", "()Ljava/util/ArrayList;", "setMGreenPointViewList", "(Ljava/util/ArrayList;)V", "mMultiCodeMaskViewListener", "Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "getMMultiCodeMaskViewListener", "()Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "setMMultiCodeMaskViewListener", "(Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;)V", "mSrcDataList", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "getMSrcDataList", "setMSrcDataList", "scaleAnimationCallback", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler$CallBack;", "scaleAnimationHandler", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "scaleAnimator", "Landroid/animation/ValueAnimator;", "cancelScaleAnimator", "", "cancelScaleTimer", "dismissAndRestMaskView", "doEnterAnimation", "successView", "transX", "", "transY", "listenerAdapter", "Landroid/animation/AnimatorListenerAdapter;", "getTipsViewFixBottomMargin", "view", "dstPointList", "Landroid/graphics/PointF;", "height", "getTipsViewRect", "Landroid/graphics/Rect;", "getTipsViewText", "", "pointInfoList", "initData", "srcDataList", "dataList", "initScaleAnimation", "isInGreenPointZone", "", "onBackPress", "codeSessionId", "", "fromScanCodeButton", "runScaleAnimation", "runZoomAnimation", "fromScale", "toScale", "animationInterpolator", "Landroid/view/animation/Interpolator;", "animatorListener", "Landroid/animation/Animator$AnimatorListener;", "animationCount", "runZoomInAnimation", "runZoomOutAnimation", "setCancelView", "setOnMultiCodeMaskViewListener", "listener", "setTipsView", "Companion", "MultiCodeMaskViewListener", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MultiCodeMaskView
  extends RelativeLayout
{
  public static final MultiCodeMaskView.a OGT;
  private final int OGU;
  private final int OGV;
  private final int OGW;
  private final int OGX;
  private final int OGY;
  private final int OGZ;
  private ArrayList<View> OHa;
  private b OHb;
  private ArrayList<ImageQBarDataBean> OHc;
  private final MTimerHandler.CallBack OHd;
  private final MTimerHandler OHe;
  private AccelerateInterpolator OHf;
  private DecelerateInterpolator OHg;
  private ValueAnimator ydD;
  
  static
  {
    AppMethodBeat.i(313428);
    OGT = new MultiCodeMaskView.a((byte)0);
    AppMethodBeat.o(313428);
  }
  
  public MultiCodeMaskView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(313370);
    setClickable(true);
    this.OGU = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_green_dot_size);
    this.OGV = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.OGW = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.OGX = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.OGY = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.OGZ = bd.fromDPToPix(getContext(), 32);
    this.OHa = new ArrayList();
    this.OHc = new ArrayList();
    this.OHd = new MultiCodeMaskView..ExternalSyntheticLambda3(this);
    this.OHe = new MTimerHandler(Looper.getMainLooper(), this.OHd, true);
    this.OHf = new AccelerateInterpolator(1.5F);
    this.OHg = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(313370);
  }
  
  public MultiCodeMaskView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(313371);
    setClickable(true);
    this.OGU = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_green_dot_size);
    this.OGV = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.OGW = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.OGX = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.OGY = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.OGZ = bd.fromDPToPix(getContext(), 32);
    this.OHa = new ArrayList();
    this.OHc = new ArrayList();
    this.OHd = new MultiCodeMaskView..ExternalSyntheticLambda3(this);
    this.OHe = new MTimerHandler(Looper.getMainLooper(), this.OHd, true);
    this.OHf = new AccelerateInterpolator(1.5F);
    this.OHg = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(313371);
  }
  
  public MultiCodeMaskView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(313373);
    setClickable(true);
    this.OGU = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_green_dot_size);
    this.OGV = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_left);
    this.OGW = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_margin_top);
    this.OGX = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_cancel_padding);
    this.OGY = com.tencent.mm.cd.a.br(getContext(), c.c.multi_code_mask_view_tips_margin_bottom);
    this.OGZ = bd.fromDPToPix(getContext(), 32);
    this.OHa = new ArrayList();
    this.OHc = new ArrayList();
    this.OHd = new MultiCodeMaskView..ExternalSyntheticLambda3(this);
    this.OHe = new MTimerHandler(Looper.getMainLooper(), this.OHd, true);
    this.OHf = new AccelerateInterpolator(1.5F);
    this.OHg = new DecelerateInterpolator(1.5F);
    AppMethodBeat.o(313373);
  }
  
  private final void a(float paramFloat1, float paramFloat2, Interpolator paramInterpolator, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(313387);
    Log.d("MicroMsg.MultiCodeMaskView", "runZoomAnimation from: %f, to: %f", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2) });
    gPl();
    this.ydD = new ValueAnimator();
    ValueAnimator localValueAnimator = this.ydD;
    if (localValueAnimator != null)
    {
      localValueAnimator.setFloatValues(new float[] { paramFloat1, paramFloat2 });
      localValueAnimator.setInterpolator((TimeInterpolator)paramInterpolator);
      localValueAnimator.setDuration(300L);
      localValueAnimator.addUpdateListener(new MultiCodeMaskView..ExternalSyntheticLambda0(this));
      localValueAnimator.addListener(paramAnimatorListener);
      localValueAnimator.start();
    }
    AppMethodBeat.o(313387);
  }
  
  private static final void a(MultiCodeMaskView paramMultiCodeMaskView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(313420);
    s.u(paramMultiCodeMaskView, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      paramMultiCodeMaskView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(313420);
      throw paramMultiCodeMaskView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    paramMultiCodeMaskView = (Iterable)paramMultiCodeMaskView.getMGreenPointViewList();
    int i = 0;
    paramMultiCodeMaskView = paramMultiCodeMaskView.iterator();
    while (paramMultiCodeMaskView.hasNext())
    {
      paramValueAnimator = paramMultiCodeMaskView.next();
      if (i < 0) {
        p.kkW();
      }
      paramValueAnimator = (View)paramValueAnimator;
      paramValueAnimator.setScaleX(f);
      paramValueAnimator.setScaleY(f);
      i += 1;
    }
    AppMethodBeat.o(313420);
  }
  
  private static final void a(MultiCodeMaskView paramMultiCodeMaskView, ArrayList paramArrayList, View paramView)
  {
    AppMethodBeat.i(313413);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMultiCodeMaskView);
    localb.cH(paramArrayList);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/MultiCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMultiCodeMaskView, "this$0");
    s.u(paramArrayList, "$srcDataList");
    paramMultiCodeMaskView.gPk();
    paramMultiCodeMaskView = paramMultiCodeMaskView.getMMultiCodeMaskViewListener();
    if (paramMultiCodeMaskView != null) {
      paramMultiCodeMaskView.aF(paramArrayList);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/MultiCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(313413);
  }
  
  private static final void a(MultiCodeMaskView paramMultiCodeMaskView, ArrayList paramArrayList, ImageQBarDataBean paramImageQBarDataBean, View paramView)
  {
    AppMethodBeat.i(313409);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMultiCodeMaskView);
    localb.cH(paramArrayList);
    localb.cH(paramImageQBarDataBean);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/MultiCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMultiCodeMaskView, "this$0");
    s.u(paramArrayList, "$srcDataList");
    s.u(paramImageQBarDataBean, "$info");
    paramView = paramMultiCodeMaskView.getMMultiCodeMaskViewListener();
    if (paramView != null) {
      paramView.a(paramArrayList, paramImageQBarDataBean, false);
    }
    paramMultiCodeMaskView.gPk();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/scanner/MultiCodeMaskView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(313409);
  }
  
  private final boolean a(View paramView, ArrayList<PointF> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(313397);
    paramView = aR(paramView, paramInt);
    paramArrayList = ((Iterable)paramArrayList).iterator();
    boolean bool = false;
    while (paramArrayList.hasNext())
    {
      PointF localPointF = (PointF)paramArrayList.next();
      Log.d("MicroMsg.MultiCodeMaskView", "isInGreenPointZone:" + localPointF + "   r:" + this.OGZ);
      if ((paramView.contains((int)(localPointF.x - this.OGZ), (int)(localPointF.y - this.OGZ))) || (paramView.contains((int)(localPointF.x - this.OGZ), (int)(localPointF.y + this.OGZ))) || (paramView.contains((int)(localPointF.x + this.OGZ), (int)(localPointF.y - this.OGZ))) || (paramView.contains((int)(localPointF.x + this.OGZ), (int)(localPointF.y + this.OGZ))))
      {
        bool = true;
        Log.i("MicroMsg.MultiCodeMaskView", "isInGreenPointZone match point:" + localPointF + "   r:" + this.OGZ);
      }
    }
    Log.d("MicroMsg.MultiCodeMaskView", "isInGreenPointZone   viewRect：" + paramView + "  " + bool);
    AppMethodBeat.o(313397);
    return bool;
  }
  
  private static final boolean a(MultiCodeMaskView paramMultiCodeMaskView)
  {
    AppMethodBeat.i(313416);
    s.u(paramMultiCodeMaskView, "this$0");
    Log.d("MicroMsg.MultiCodeMaskView", "runScaleAnimation");
    paramMultiCodeMaskView.ahC(1);
    AppMethodBeat.o(313416);
    return true;
  }
  
  private final Rect aR(View paramView, int paramInt)
  {
    AppMethodBeat.i(313393);
    Rect localRect = new Rect();
    localRect.left = (getRootView().getWidth() / 2 - paramView.getMeasuredWidth() / 2);
    localRect.top = (paramInt - this.OGY - paramView.getMeasuredHeight());
    localRect.right = (getRootView().getWidth() / 2 + paramView.getMeasuredWidth() / 2);
    localRect.bottom = (paramInt - this.OGY);
    AppMethodBeat.o(313393);
    return localRect;
  }
  
  private final void ahC(int paramInt)
  {
    AppMethodBeat.i(313383);
    Log.d("MicroMsg.MultiCodeMaskView", "runZoomAnimation %d", new Object[] { Integer.valueOf(paramInt) });
    Animator.AnimatorListener localAnimatorListener = (Animator.AnimatorListener)new e(this, new f(paramInt, this));
    a(1.0F, 0.8F, (Interpolator)this.OHf, localAnimatorListener);
    AppMethodBeat.o(313383);
  }
  
  private final int b(View paramView, ArrayList<PointF> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(313400);
    int k = this.OGY;
    Object localObject1 = (Collection)paramArrayList;
    if ((localObject1 == null) || (((Collection)localObject1).isEmpty())) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(313400);
      return k;
    }
    localObject1 = new ArrayList();
    ((ArrayList)localObject1).addAll((Collection)paramArrayList);
    p.a((List)localObject1, (Comparator)new MultiCodeMaskView.c());
    paramView = aR(paramView, paramInt);
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
        p.kkW();
      }
      localObject2 = (PointF)localObject2;
      i = m;
      int j = k;
      float f;
      if (((PointF)localObject2).y - this.OGZ - i1 > paramView.height())
      {
        i = Math.abs(i3 - i1);
        f = Math.abs(i2 - ((PointF)localObject2).y + this.OGZ);
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
          if (paramInt - ((PointF)localObject2).y - this.OGZ > paramView.height())
          {
            f = Math.abs(i3 - (((PointF)localObject2).y + this.OGZ));
            m = i;
            k = j;
            if (f < i)
            {
              m = (int)f;
              k = (int)(paramInt - ((PointF)localObject2).y - this.OGZ - paramView.height());
            }
          }
        }
        i1 = (int)(((PointF)localObject2).y + this.OGZ);
        n += 1;
        break;
        label397:
        i = m;
        j = k;
        if (f < m)
        {
          i = (int)f;
          j = (int)(paramInt - ((PointF)localObject2).y + this.OGZ);
        }
      }
    }
    Log.d("MicroMsg.MultiCodeMaskView", s.X("getTipsViewFixBottomMargin:", Integer.valueOf(k)));
    AppMethodBeat.o(313400);
    return k;
  }
  
  private final String bw(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(313403);
    Object localObject = "";
    HashSet localHashSet = new HashSet();
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    paramArrayList = (ArrayList<ImageQBarDataBean>)localObject;
    while (localIterator.hasNext())
    {
      localObject = (ImageQBarDataBean)localIterator.next();
      if (k.cK(((ImageQBarDataBean)localObject).hDb, ((ImageQBarDataBean)localObject).OGQ))
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_appbrand_tips);
        s.s(paramArrayList, "context.getString(R.stri…_mask_view_appbrand_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).hDb));
      }
      else if (!e.e.avx(((ImageQBarDataBean)localObject).hDb))
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_tiao_tips);
        s.s(paramArrayList, "context.getString(R.stri…code_mask_view_tiao_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).hDb));
      }
      else
      {
        paramArrayList = getContext().getString(c.h.multi_code_mask_view_two_dimension_tips);
        s.s(paramArrayList, "context.getString(R.stri…_view_two_dimension_tips)");
        localHashSet.add(Integer.valueOf(((ImageQBarDataBean)localObject).hDb));
      }
    }
    if (localHashSet.size() > 1)
    {
      paramArrayList = getContext().getString(c.h.multi_code_mask_view_multi_tips);
      s.s(paramArrayList, "context.getString(R.stri…ode_mask_view_multi_tips)");
    }
    AppMethodBeat.o(313403);
    return paramArrayList;
  }
  
  private final void gPl()
  {
    AppMethodBeat.i(313389);
    ValueAnimator localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllListeners();
    }
    localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.removeAllUpdateListeners();
    }
    localValueAnimator = this.ydD;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.ydD = null;
    AppMethodBeat.o(313389);
  }
  
  private final void setCancelView(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(313378);
    View localView = LayoutInflater.from(getContext()).inflate(c.f.layout_multi_code_mask_cancel_view, null);
    s.s(localView, "from(context).inflate(R.…e_mask_cancel_view, null)");
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.leftMargin = this.OGV;
    localLayoutParams.topMargin = this.OGW;
    localView.setPadding(this.OGX, this.OGX, this.OGX, this.OGX);
    addView(localView, (ViewGroup.LayoutParams)localLayoutParams);
    localView.setOnClickListener(new MultiCodeMaskView..ExternalSyntheticLambda1(this, paramArrayList));
    AppMethodBeat.o(313378);
  }
  
  public final void P(long paramLong, boolean paramBoolean)
  {
    AppMethodBeat.i(313475);
    j localj = j.OGP;
    j.a(paramLong, 3, this.OHc, null, 0L, paramBoolean);
    gPk();
    AppMethodBeat.o(313475);
  }
  
  public final void a(final ArrayList<ImageQBarDataBean> paramArrayList1, ArrayList<PointF> paramArrayList, final ArrayList<ImageQBarDataBean> paramArrayList2, int paramInt)
  {
    AppMethodBeat.i(313466);
    s.u(paramArrayList1, "srcDataList");
    s.u(paramArrayList, "dstPointList");
    s.u(paramArrayList2, "dataList");
    setVisibility(0);
    removeAllViews();
    this.OHa.clear();
    this.OHc.clear();
    this.OHc.addAll((Collection)paramArrayList1);
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
          p.kkW();
        }
        Object localObject3 = (PointF)localObject2;
        localObject2 = LayoutInflater.from(getContext()).inflate(c.f.layout_scan_code_success_mark_view, null);
        s.s(localObject2, "from(context).inflate(R.…_success_mark_view, null)");
        ((View)localObject2).setVisibility(0);
        View localView = ((View)localObject2).findViewById(c.e.scan_success_dot_view);
        if (localView == null)
        {
          paramArrayList1 = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
          AppMethodBeat.o(313466);
          throw paramArrayList1;
        }
        ((ImageView)localView).setImageResource(c.g.scan_success_mark_dot_with_arrow);
        addView((View)localObject2, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.OGU, this.OGU));
        ((View)localObject2).setTranslationX(((PointF)localObject3).x - this.OGZ);
        ((View)localObject2).setTranslationY(((PointF)localObject3).y - this.OGZ);
        localObject3 = paramArrayList2.get(i);
        s.s(localObject3, "dataList[index]");
        ((View)localObject2).setOnClickListener(new MultiCodeMaskView..ExternalSyntheticLambda2(this, paramArrayList1, (ImageQBarDataBean)localObject3));
        getMGreenPointViewList().add(localObject2);
        i += 1;
      }
      setCancelView(paramArrayList1);
      paramArrayList1 = LayoutInflater.from(getContext()).inflate(c.f.layout_multi_code_mask_tips_view, null);
      if (paramArrayList1 == null)
      {
        paramArrayList1 = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(313466);
        throw paramArrayList1;
      }
      paramArrayList1 = (TextView)paramArrayList1;
      paramArrayList1.setText((CharSequence)bw(paramArrayList2));
      paramArrayList2 = new RelativeLayout.LayoutParams(-2, -2);
      paramArrayList2.addRule(12);
      paramArrayList2.addRule(14);
      paramArrayList2.bottomMargin = this.OGY;
      paramArrayList1.measure(-2, -2);
      if (a((View)paramArrayList1, paramArrayList, paramInt)) {
        paramArrayList2.bottomMargin = b((View)paramArrayList1, paramArrayList, paramInt);
      }
      addView((View)paramArrayList1, (ViewGroup.LayoutParams)paramArrayList2);
      this.OHe.stopTimer();
      Log.d("MicroMsg.MultiCodeMaskView", "initScaleAnimation period: %d", new Object[] { Long.valueOf(3350L) });
      this.OHe.startTimer(0L, 3350L);
      AppMethodBeat.o(313466);
      return;
    }
    if (paramArrayList.size() == 1)
    {
      setBackgroundColor(0);
      paramArrayList = paramArrayList.get(0);
      s.s(paramArrayList, "dstPointList[0]");
      paramArrayList = (PointF)paramArrayList;
      paramArrayList2 = paramArrayList2.get(0);
      s.s(paramArrayList2, "dataList[0]");
      paramArrayList2 = (ImageQBarDataBean)paramArrayList2;
      localObject1 = LayoutInflater.from(getContext()).inflate(c.f.layout_scan_code_success_mark_view, null);
      s.s(localObject1, "from(context).inflate(R.…_success_mark_view, null)");
      ((View)localObject1).setVisibility(0);
      localObject2 = ((View)localObject1).findViewById(c.e.scan_success_dot_view);
      if (localObject2 == null)
      {
        paramArrayList1 = new NullPointerException("null cannot be cast to non-null type android.widget.ImageView");
        AppMethodBeat.o(313466);
        throw paramArrayList1;
      }
      ((ImageView)localObject2).setImageResource(c.g.scan_success_mark_dot);
      addView((View)localObject1, (ViewGroup.LayoutParams)new RelativeLayout.LayoutParams(this.OGU, this.OGU));
      ((View)localObject1).setTranslationX(paramArrayList.x - this.OGZ);
      ((View)localObject1).setTranslationY(paramArrayList.y - this.OGZ);
      this.OHa.add(localObject1);
      a(0.0F, 1.0F, (Interpolator)this.OHg, (Animator.AnimatorListener)new d(this, paramArrayList1, paramArrayList2));
    }
    AppMethodBeat.o(313466);
  }
  
  public final void gPk()
  {
    AppMethodBeat.i(313482);
    gPl();
    this.OHe.stopTimer();
    this.OHa.clear();
    this.OHc.clear();
    removeAllViews();
    setVisibility(8);
    AppMethodBeat.o(313482);
  }
  
  public final ArrayList<View> getMGreenPointViewList()
  {
    return this.OHa;
  }
  
  public final b getMMultiCodeMaskViewListener()
  {
    return this.OHb;
  }
  
  public final ArrayList<ImageQBarDataBean> getMSrcDataList()
  {
    return this.OHc;
  }
  
  public final void setMGreenPointViewList(ArrayList<View> paramArrayList)
  {
    AppMethodBeat.i(313445);
    s.u(paramArrayList, "<set-?>");
    this.OHa = paramArrayList;
    AppMethodBeat.o(313445);
  }
  
  public final void setMMultiCodeMaskViewListener(b paramb)
  {
    this.OHb = paramb;
  }
  
  public final void setMSrcDataList(ArrayList<ImageQBarDataBean> paramArrayList)
  {
    AppMethodBeat.i(313455);
    s.u(paramArrayList, "<set-?>");
    this.OHc = paramArrayList;
    AppMethodBeat.o(313455);
  }
  
  public final void setOnMultiCodeMaskViewListener(b paramb)
  {
    AppMethodBeat.i(313459);
    s.u(paramb, "listener");
    this.OHb = paramb;
    AppMethodBeat.o(313459);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/MultiCodeMaskView$MultiCodeMaskViewListener;", "", "onCancelSelect", "", "srcDataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/scanner/ImageQBarDataBean;", "Lkotlin/collections/ArrayList;", "onSelectQBarCode", "info", "autoSelect", "", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean, boolean paramBoolean);
    
    public abstract void aF(ArrayList<ImageQBarDataBean> paramArrayList);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$initData$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animator.AnimatorListener
  {
    d(MultiCodeMaskView paramMultiCodeMaskView, ArrayList<ImageQBarDataBean> paramArrayList, ImageQBarDataBean paramImageQBarDataBean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313261);
      paramAnimator = this.OHh.getMMultiCodeMaskViewListener();
      if (paramAnimator != null) {
        paramAnimator.a(paramArrayList1, paramArrayList2, true);
      }
      this.OHh.gPk();
      AppMethodBeat.o(313261);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$runZoomAnimation$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animator.AnimatorListener
  {
    e(MultiCodeMaskView paramMultiCodeMaskView, MultiCodeMaskView.f paramf) {}
    
    private static final void a(MultiCodeMaskView paramMultiCodeMaskView, MultiCodeMaskView.f paramf)
    {
      AppMethodBeat.i(313252);
      s.u(paramMultiCodeMaskView, "this$0");
      s.u(paramf, "$animatorListener");
      MultiCodeMaskView.a(paramMultiCodeMaskView, (Animator.AnimatorListener)paramf);
      AppMethodBeat.o(313252);
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313267);
      MMHandlerThread.postToMainThreadDelayed(new MultiCodeMaskView.e..ExternalSyntheticLambda0(this.OHh, this.OHk), 50L);
      AppMethodBeat.o(313267);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/scanner/MultiCodeMaskView$runZoomAnimation$animatorListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animator.AnimatorListener
  {
    f(int paramInt, MultiCodeMaskView paramMultiCodeMaskView) {}
    
    private static final void a(int paramInt, MultiCodeMaskView paramMultiCodeMaskView)
    {
      AppMethodBeat.i(313249);
      s.u(paramMultiCodeMaskView, "this$0");
      if (paramInt < 2) {
        MultiCodeMaskView.a(paramMultiCodeMaskView, paramInt + 1);
      }
      AppMethodBeat.o(313249);
    }
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(313264);
      MMHandlerThread.postToMainThreadDelayed(new MultiCodeMaskView.f..ExternalSyntheticLambda0(this.OHl, jdField_this), 50L);
      AppMethodBeat.o(313264);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.MultiCodeMaskView
 * JD-Core Version:    0.7.0.1
 */