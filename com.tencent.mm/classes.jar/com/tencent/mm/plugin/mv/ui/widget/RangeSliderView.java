package com.tencent.mm.plugin.mv.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Range;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mv.b.g;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "borders", "Landroid/graphics/Rect;", "callback", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;)V", "clipPath", "Landroid/graphics/Path;", "clipRadius", "", "clipRect", "Landroid/graphics/RectF;", "downEnd", "downStart", "downX", "dragRange", "Landroid/util/Range;", "kotlin.jvm.PlatformType", "edge", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Edge;", "value", "end", "getEnd", "()I", "setEnd", "(I)V", "hasNoticed", "", "isActive", "()Z", "setActive", "(Z)V", "keepSizeOnStartChanged", "getKeepSizeOnStartChanged", "setKeepSizeOnStartChanged", "lastX", "leftThumb", "Landroid/graphics/drawable/Drawable;", "location", "", "maxEnd", "getMaxEnd", "setMaxEnd", "minWidth", "getMinWidth", "setMinWidth", "outOfRangeOffset", "progress", "getProgress", "setProgress", "progressPaint", "progressWidth", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "repeatJob", "Lkotlinx/coroutines/Job;", "rightThumb", "start", "getStart", "setStart", "dp", "getDp", "(F)F", "(I)I", "clearRepeat", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "findRecyclerView", "getSvg", "resId", "handleDrag", "offsetX", "outOfRange", "log", "message", "Lkotlin/Function0;", "", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "repeatDrag", "scrollOutOfRange", "dx", "shouldKeepSize", "Callback", "Companion", "Edge", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RangeSliderView
  extends FrameLayout
{
  public static final RangeSliderView.b MlB;
  private int DWv;
  private int MkP;
  private int MlC;
  private final Drawable MlD;
  private final Drawable MlE;
  private final Rect MlF;
  private int MlG;
  private RangeSliderView.c MlH;
  private boolean MlI;
  private final RectF MlJ;
  private final float MlK;
  private Range<Float> MlL;
  private int MlM;
  private boolean MlN;
  private a MlO;
  private cb MlP;
  private final int[] bfh;
  private float cxM;
  private int end;
  private float fif;
  private boolean isActive;
  private RecyclerView mkw;
  private int progress;
  private final int progressWidth;
  private final Paint rsU;
  private int start;
  private final Paint uMn;
  private final Path yjb;
  
  static
  {
    AppMethodBeat.i(286763);
    MlB = new RangeSliderView.b((byte)0);
    AppMethodBeat.o(286763);
  }
  
  public RangeSliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
    AppMethodBeat.i(286740);
    AppMethodBeat.o(286740);
  }
  
  public RangeSliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286677);
    this.MlD = aeu(b.g.music_mv_slider_left_bar);
    this.MlE = aeu(b.g.music_mv_slider_right_bar);
    paramContext = new Paint(1);
    paramContext.setColor(-1);
    paramContext.setStyle(Paint.Style.FILL);
    paramAttributeSet = ah.aiuX;
    this.uMn = paramContext;
    paramContext = new Paint(1);
    paramContext.setColor(-1761607681);
    paramContext.setStyle(Paint.Style.FILL);
    paramAttributeSet = ah.aiuX;
    this.rsU = paramContext;
    this.progressWidth = gsp();
    this.MlF = new Rect(gsp(), gsp(), gsp(), gsp());
    this.fif = -1.0F;
    this.MlH = RangeSliderView.c.MlQ;
    this.yjb = new Path();
    this.MlJ = new RectF();
    this.MlK = cO(4.0F);
    this.MlL = new Range((Comparable)Float.valueOf(0.0F), (Comparable)Float.valueOf(0.0F));
    this.bfh = new int[2];
    setClipToPadding(false);
    setClipChildren(false);
    AppMethodBeat.o(286677);
  }
  
  private final Drawable aeu(int paramInt)
  {
    AppMethodBeat.i(286688);
    Drawable localDrawable = (Drawable)new BitmapDrawable(getResources(), BitmapUtil.getBitmapNative(paramInt, getResources().getDisplayMetrics().density));
    AppMethodBeat.o(286688);
    return localDrawable;
  }
  
  private final void aev(int paramInt)
  {
    AppMethodBeat.i(286714);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null)
    {
      if (paramInt >= 0) {
        break label100;
      }
      if (this.MlH != RangeSliderView.c.MlR) {
        break label75;
      }
      localRecyclerView.setTranslationX(localRecyclerView.getTranslationX() + -paramInt);
      Log.d("MicroMsg.RangeSliderView", s.X("1 translateX ", Integer.valueOf(-paramInt)));
    }
    for (;;)
    {
      this.MlM += paramInt;
      AppMethodBeat.o(286714);
      return;
      label75:
      localRecyclerView.scrollBy(paramInt, 0);
      Log.d("MicroMsg.RangeSliderView", s.X("2 scrollBy ", Integer.valueOf(paramInt)));
      continue;
      label100:
      if (localRecyclerView.getTranslationX() > 0.0F)
      {
        localRecyclerView.setTranslationX(localRecyclerView.getTranslationX() + -paramInt);
        Log.d("MicroMsg.RangeSliderView", s.X("3 translateX ", Integer.valueOf(-paramInt)));
      }
      else
      {
        localRecyclerView.scrollBy(paramInt, 0);
        Log.d("MicroMsg.RangeSliderView", s.X("4 translateX ", Integer.valueOf(-paramInt)));
      }
    }
  }
  
  private final boolean br(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(286706);
    Log.d("MicroMsg.RangeSliderView", "handle drag: offsetX=" + paramInt + ", outOfRange=" + paramBoolean);
    int i;
    Object localObject;
    if (this.MlH == RangeSliderView.c.MlR)
    {
      paramInt = kotlin.k.k.bQ(this.MkP + paramInt, 0, this.end - this.DWv);
      if (paramInt != this.start)
      {
        i = this.start;
        setStart(paramInt);
        localObject = this.MlO;
        if (localObject != null) {
          ((a)localObject).aer(paramInt);
        }
        this.MlI = false;
        if (paramBoolean) {
          aev(paramInt - i);
        }
        for (;;)
        {
          AppMethodBeat.o(286706);
          return true;
          if (!this.MlN)
          {
            localObject = this.mkw;
            if (localObject != null) {
              ((RecyclerView)localObject).scrollBy(-(paramInt - i), 0);
            }
            Log.d("MicroMsg.RangeSliderView", s.X("scrollBy not outOfRange: ", Integer.valueOf(-(paramInt - i))));
          }
        }
      }
      if ((!this.MlI) && ((this.start == 0) || (this.end - this.start <= this.DWv)))
      {
        performHapticFeedback(0, 2);
        this.MlI = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(286706);
      return false;
      if (this.MlH == RangeSliderView.c.MlS)
      {
        paramInt = kotlin.k.k.bQ(this.MlG + paramInt, this.start + this.DWv, this.MlC);
        if (paramInt != this.end)
        {
          i = this.end;
          setEnd(paramInt);
          localObject = this.MlO;
          if (localObject != null) {
            ((a)localObject).aes(paramInt);
          }
          this.MlI = false;
          if (paramBoolean) {
            aev(paramInt - i);
          }
          AppMethodBeat.o(286706);
          return true;
        }
        if ((!this.MlI) && ((this.end >= this.MlC) || (this.end - this.start <= this.DWv)))
        {
          performHapticFeedback(0, 2);
          this.MlI = true;
        }
      }
    }
  }
  
  private final float cO(float paramFloat)
  {
    AppMethodBeat.i(286736);
    float f = getResources().getDisplayMetrics().density;
    AppMethodBeat.o(286736);
    return f * paramFloat;
  }
  
  private final int gsp()
  {
    AppMethodBeat.i(286729);
    int i = (int)(getResources().getDisplayMetrics().density * 2.0F);
    AppMethodBeat.o(286729);
    return i;
  }
  
  private final void gsq()
  {
    AppMethodBeat.i(286695);
    cb localcb = this.MlP;
    if (localcb != null) {
      localcb.a(null);
    }
    this.MlP = null;
    AppMethodBeat.o(286695);
  }
  
  private final boolean gsr()
  {
    return (this.MlH == RangeSliderView.c.MlR) && (this.MlN);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(286891);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipPath(this.yjb);
    if (gsr()) {
      paramCanvas.translate(-this.MkP, 0.0F);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      if (this.isActive)
      {
        if (this.MlH == RangeSliderView.c.MlQ) {
          paramCanvas.drawRect(this.progress - this.start, 0.0F, this.progress - this.start + this.progressWidth, paramCanvas.getHeight(), this.rsU);
        }
        paramCanvas.drawRect(this.MlD.getBounds().right, -this.MlF.top, this.MlE.getBounds().left, 0.0F, this.uMn);
        float f1 = this.MlD.getBounds().right;
        float f2 = paramCanvas.getHeight();
        float f3 = this.MlE.getBounds().left;
        float f4 = paramCanvas.getHeight();
        paramCanvas.drawRect(f1, f2, f3, this.MlF.bottom + f4, this.uMn);
        this.MlD.draw(paramCanvas);
        this.MlE.draw(paramCanvas);
      }
      AppMethodBeat.o(286891);
      return;
      paramCanvas.translate(-this.start, 0.0F);
    }
  }
  
  public final a getCallback()
  {
    return this.MlO;
  }
  
  public final int getEnd()
  {
    return this.end;
  }
  
  public final boolean getKeepSizeOnStartChanged()
  {
    return this.MlN;
  }
  
  public final int getMaxEnd()
  {
    return this.MlC;
  }
  
  public final int getMinWidth()
  {
    return this.DWv;
  }
  
  public final int getProgress()
  {
    return this.progress;
  }
  
  public final int getStart()
  {
    return this.start;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(286868);
    super.onAttachedToWindow();
    Object localObject = getParent();
    if ((localObject instanceof ViewGroup)) {
      localObject = (ViewGroup)localObject;
    }
    while (localObject != null) {
      if ((localObject instanceof RecyclerView))
      {
        this.mkw = ((RecyclerView)localObject);
        AppMethodBeat.o(286868);
        return;
        localObject = null;
      }
      else
      {
        localObject = ((ViewGroup)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          localObject = (ViewGroup)localObject;
        } else {
          localObject = null;
        }
      }
    }
    localObject = new IllegalStateException("RangeSliderView should be used inside a RecyclerView");
    AppMethodBeat.o(286868);
    throw ((Throwable)localObject);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(286851);
    super.onDetachedFromWindow();
    gsq();
    AppMethodBeat.o(286851);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286887);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt4 - paramInt2;
    if (gsr())
    {
      this.MlJ.left = (this.start - this.MkP);
      this.MlJ.right = (this.end - this.MkP);
      this.MlJ.top = 0.0F;
      this.MlJ.bottom = paramInt1;
      this.yjb.reset();
      localObject = this.yjb;
      RectF localRectF = this.MlJ;
      float f1 = this.MlK;
      float f2 = this.MlK;
      float f3 = this.MlK;
      float f4 = this.MlK;
      float f5 = this.MlK;
      float f6 = this.MlK;
      float f7 = this.MlK;
      float f8 = this.MlK;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject).addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
      paramInt2 = this.MlF.top + paramInt1 + this.MlF.bottom;
      paramInt3 = (int)(paramInt2 / this.MlD.getIntrinsicHeight() * this.MlD.getIntrinsicWidth());
      if (!gsr()) {
        break label450;
      }
      this.MlD.setBounds(this.start - this.MkP - this.MlF.left, -this.MlF.top, paramInt3 + (this.start - this.MkP), this.MlF.bottom + paramInt1);
      label308:
      paramInt2 = (int)(paramInt2 / this.MlE.getIntrinsicHeight() * this.MlE.getIntrinsicWidth());
      if (!gsr()) {
        break label487;
      }
      this.MlE.setBounds(this.end - this.MkP - paramInt2, -this.MlF.top, this.end - this.MkP + this.MlF.right, paramInt1 + this.MlF.bottom);
    }
    for (;;)
    {
      localObject = getChildAt(0);
      if (localObject != null) {
        break label542;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.mv.ui.widget.MvFrameListView");
      AppMethodBeat.o(286887);
      throw ((Throwable)localObject);
      this.MlJ.left = 0.0F;
      this.MlJ.right = (this.end - this.start);
      break;
      label450:
      this.MlD.setBounds(-this.MlF.left, -this.MlF.top, paramInt3, this.MlF.bottom + paramInt1);
      break label308;
      label487:
      this.MlE.setBounds(this.end - this.start - paramInt2, -this.MlF.top, this.end - this.start + this.MlF.right, paramInt1 + this.MlF.bottom);
    }
    label542:
    Object localObject = (MvFrameListView)localObject;
    ((MvFrameListView)localObject).setDrawStart(this.start);
    ((MvFrameListView)localObject).setDrawEnd(this.end);
    AppMethodBeat.o(286887);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(286859);
    if (gsr())
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.end - this.MkP, 1073741824), paramInt2);
      AppMethodBeat.o(286859);
      return;
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.end - this.start, 1073741824), paramInt2);
    AppMethodBeat.o(286859);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(286876);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    RecyclerView localRecyclerView = this.mkw;
    if (localRecyclerView != null)
    {
      localRecyclerView.getLocationOnScreen(this.bfh);
      Comparable localComparable = (Comparable)Float.valueOf(this.bfh[0] + cO(40.0F));
      paramInt1 = this.bfh[0];
      this.MlL = new Range(localComparable, (Comparable)Float.valueOf(localRecyclerView.getWidth() + paramInt1 - cO(40.0F)));
    }
    AppMethodBeat.o(286876);
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(286844);
    s.u(paramMotionEvent, "event");
    if (!this.isActive)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(286844);
      return bool;
    }
    int i;
    label70:
    Object localObject;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      i = 0;
      this.cxM = paramMotionEvent.getRawX();
      if ((i != 0) || (super.onTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(286844);
        return true;
      }
      break;
    case 0: 
      this.fif = paramMotionEvent.getRawX();
      this.MkP = this.start;
      this.MlG = this.end;
      if (paramMotionEvent.getX() <= this.MlD.getBounds().right)
      {
        this.MlH = RangeSliderView.c.MlR;
        getParent().requestDisallowInterceptTouchEvent(true);
        localObject = this.MlO;
        if (localObject == null) {
          break label264;
        }
        ((a)localObject).a(this.MlH, this.start, this.end);
        i = 1;
      }
      break;
    }
    for (;;)
    {
      this.MlI = false;
      break label70;
      if (paramMotionEvent.getX() >= this.MlE.getBounds().left)
      {
        this.MlH = RangeSliderView.c.MlS;
        getParent().requestDisallowInterceptTouchEvent(true);
        localObject = this.MlO;
        if (localObject != null) {
          ((a)localObject).a(this.MlH, this.start, this.end);
        }
        label264:
        i = 1;
        continue;
        if (this.MlH == RangeSliderView.c.MlQ) {
          break;
        }
        if (!this.MlL.contains((Comparable)Float.valueOf(paramMotionEvent.getRawX())))
        {
          localObject = this.MlP;
          if ((localObject != null) && (((cb)localObject).isActive() == true))
          {
            i = 1;
            label323:
            if (i != 0) {
              break label562;
            }
            localObject = this.MlP;
            if (localObject != null) {
              ((cb)localObject).a(null);
            }
            localObject = new ah.d();
            if (this.MlH != RangeSliderView.c.MlR) {
              break label426;
            }
          }
          label426:
          for (i = this.start - this.MkP;; i = this.end - this.MlG)
          {
            ((ah.d)localObject).aixb = i;
            this.MlP = j.a((aq)bu.ajwo, (f)bg.kCh(), null, (m)new d(this, (ah.d)localObject, null), 2);
            i = 1;
            break;
            i = 0;
            break label323;
          }
        }
        else
        {
          if (br(kotlin.h.a.eH(paramMotionEvent.getRawX() - this.fif) + this.MlM, false)) {}
          for (i = 1;; i = 0)
          {
            gsq();
            break label70;
            if (this.MlH != RangeSliderView.c.MlQ)
            {
              localObject = this.MlO;
              if (localObject != null) {
                ((a)localObject).b(this.MlH, this.start, this.end);
              }
              this.MlH = RangeSliderView.c.MlQ;
              localObject = this.mkw;
              if (localObject != null) {
                ((RecyclerView)localObject).setTranslationX(0.0F);
              }
              this.MlM = 0;
            }
            gsq();
            break;
            AppMethodBeat.o(286844);
            return false;
          }
        }
        label562:
        i = 1;
        break label70;
      }
      i = 0;
    }
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(286811);
    this.isActive = paramBoolean;
    invalidate();
    AppMethodBeat.o(286811);
  }
  
  public final void setCallback(a parama)
  {
    this.MlO = parama;
  }
  
  public final void setEnd(int paramInt)
  {
    AppMethodBeat.i(286783);
    if (paramInt < 0) {}
    for (this.end = 0;; this.end = paramInt)
    {
      requestLayout();
      AppMethodBeat.o(286783);
      return;
    }
  }
  
  public final void setKeepSizeOnStartChanged(boolean paramBoolean)
  {
    this.MlN = paramBoolean;
  }
  
  public final void setMaxEnd(int paramInt)
  {
    this.MlC = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.DWv = paramInt;
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(286792);
    this.progress = kotlin.k.k.bQ(paramInt, this.start, this.end);
    postInvalidate();
    AppMethodBeat.o(286792);
  }
  
  public final void setStart(int paramInt)
  {
    AppMethodBeat.i(286772);
    if (paramInt < 0) {}
    for (this.start = 0;; this.start = paramInt)
    {
      requestLayout();
      AppMethodBeat.o(286772);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "", "onRangeEndChanged", "", "oldValue", "", "newValue", "onRangeStartChanged", "onSlidingStarted", "edge", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Edge;", "start", "end", "onSlidingStopped", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void a(RangeSliderView.c paramc, int paramInt1, int paramInt2);
    
    public abstract void aer(int paramInt);
    
    public abstract void aes(int paramInt);
    
    public abstract void b(RangeSliderView.c paramc, int paramInt1, int paramInt2);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    d(RangeSliderView paramRangeSliderView, ah.d paramd, d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(286727);
      paramObject = (d)new d(this.MlU, this.MlV, paramd);
      AppMethodBeat.o(286727);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(286712);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(286712);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        float f = RangeSliderView.a(this.MlU);
        paramObject = RangeSliderView.b(this.MlU).getUpper();
        s.s(paramObject, "dragRange.upper");
        if (f > ((Number)paramObject).floatValue())
        {
          f = RangeSliderView.a(this.MlU);
          paramObject = RangeSliderView.b(this.MlU).getUpper();
          s.s(paramObject, "dragRange.upper");
        }
        for (int i = kotlin.h.a.eH(f - ((Number)paramObject).floatValue());; i = kotlin.h.a.eH(f - ((Number)paramObject).floatValue()))
        {
          RangeSliderView.a(this.MlU, this.MlV.aixb + i);
          this.MlV.aixb = (i + this.MlV.aixb);
          paramObject = (d)this;
          this.label = 1;
          if (bb.e(100L, paramObject) != locala) {
            break;
          }
          AppMethodBeat.o(286712);
          return locala;
          f = RangeSliderView.a(this.MlU);
          paramObject = RangeSliderView.b(this.MlU).getLower();
          s.s(paramObject, "dragRange.lower");
        }
        ResultKt.throwOnFailure(paramObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.RangeSliderView
 * JD-Core Version:    0.7.0.1
 */