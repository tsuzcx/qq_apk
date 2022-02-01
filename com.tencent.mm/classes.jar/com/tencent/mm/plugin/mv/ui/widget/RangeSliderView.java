package com.tencent.mm.plugin.mv.ui.widget;

import android.annotation.SuppressLint;
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
import kotlin.ResultKt;
import kotlin.d.b.a.j;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderPaint", "Landroid/graphics/Paint;", "borders", "Landroid/graphics/Rect;", "callback", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "getCallback", "()Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "setCallback", "(Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;)V", "clipPath", "Landroid/graphics/Path;", "clipRadius", "", "clipRect", "Landroid/graphics/RectF;", "downEnd", "downStart", "downX", "dragRange", "Landroid/util/Range;", "kotlin.jvm.PlatformType", "edge", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Edge;", "value", "end", "getEnd", "()I", "setEnd", "(I)V", "hasNoticed", "", "isActive", "()Z", "setActive", "(Z)V", "keepSizeOnStartChanged", "getKeepSizeOnStartChanged", "setKeepSizeOnStartChanged", "lastX", "leftThumb", "Landroid/graphics/drawable/Drawable;", "location", "", "maxEnd", "getMaxEnd", "setMaxEnd", "minWidth", "getMinWidth", "setMinWidth", "outOfRangeOffset", "progress", "getProgress", "setProgress", "progressPaint", "progressWidth", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "repeatJob", "Lkotlinx/coroutines/Job;", "rightThumb", "start", "getStart", "setStart", "dp", "getDp", "(F)F", "(I)I", "clearRepeat", "", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "findRecyclerView", "getSvg", "resId", "handleDrag", "offsetX", "outOfRange", "log", "message", "Lkotlin/Function0;", "", "onAttachedToWindow", "onDetachedFromWindow", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "repeatDrag", "scrollOutOfRange", "dx", "shouldKeepSize", "Callback", "Companion", "Edge", "plugin-mv_release"})
public final class RangeSliderView
  extends FrameLayout
{
  public static final RangeSliderView.b GrN;
  private final int[] BdE;
  private int GqN;
  private final Drawable GrA;
  private final Drawable GrB;
  private final Rect GrC;
  private int GrD;
  private RangeSliderView.c GrE;
  private boolean GrF;
  private final RectF GrG;
  private final float GrH;
  private Range<Float> GrI;
  private int GrJ;
  private boolean GrK;
  private a GrL;
  private by GrM;
  private int Gry;
  private int Grz;
  private float aCa;
  private final Paint borderPaint;
  private float dit;
  private int end;
  private boolean isActive;
  private RecyclerView jLl;
  private final Paint opm;
  private int progress;
  private final int progressWidth;
  private int start;
  private final Path uWB;
  
  static
  {
    AppMethodBeat.i(230454);
    GrN = new RangeSliderView.b((byte)0);
    AppMethodBeat.o(230454);
  }
  
  public RangeSliderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, (byte)0);
  }
  
  public RangeSliderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(230447);
    this.GrA = aab(b.g.music_mv_slider_left_bar);
    this.GrB = aab(b.g.music_mv_slider_right_bar);
    paramContext = new Paint(1);
    paramContext.setColor(-1);
    paramContext.setStyle(Paint.Style.FILL);
    this.borderPaint = paramContext;
    paramContext = new Paint(1);
    paramContext.setColor(-1761607681);
    paramContext.setStyle(Paint.Style.FILL);
    this.opm = paramContext;
    this.progressWidth = fim();
    this.GrC = new Rect(fim(), fim(), fim(), fim());
    this.dit = -1.0F;
    this.GrE = RangeSliderView.c.GrO;
    this.uWB = new Path();
    this.GrG = new RectF();
    this.GrH = bK(4.0F);
    this.GrI = new Range((Comparable)Float.valueOf(0.0F), (Comparable)Float.valueOf(0.0F));
    this.BdE = new int[2];
    setClipToPadding(false);
    setClipChildren(false);
    AppMethodBeat.o(230447);
  }
  
  private final boolean aQ(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(230424);
    Log.d("MicroMsg.RangeSliderView", "handle drag: offsetX=" + paramInt + ", outOfRange=" + paramBoolean);
    int i;
    Object localObject;
    if (this.GrE == RangeSliderView.c.GrP)
    {
      paramInt = i.bm(this.GqN + paramInt, 0, this.end - this.Gry);
      if (paramInt != this.start)
      {
        i = this.start;
        setStart(paramInt);
        localObject = this.GrL;
        if (localObject != null) {
          ((a)localObject).ZY(paramInt);
        }
        this.GrF = false;
        if (paramBoolean) {
          aac(paramInt - i);
        }
        for (;;)
        {
          AppMethodBeat.o(230424);
          return true;
          if (!this.GrK)
          {
            localObject = this.jLl;
            if (localObject != null) {
              ((RecyclerView)localObject).scrollBy(-(paramInt - i), 0);
            }
            Log.d("MicroMsg.RangeSliderView", "scrollBy not outOfRange: " + -(paramInt - i));
          }
        }
      }
      if ((!this.GrF) && ((this.start == 0) || (this.end - this.start <= this.Gry)))
      {
        performHapticFeedback(0, 2);
        this.GrF = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(230424);
      return false;
      if (this.GrE == RangeSliderView.c.GrQ)
      {
        paramInt = i.bm(this.GrD + paramInt, this.start + this.Gry, this.Grz);
        if (paramInt != this.end)
        {
          i = this.end;
          setEnd(paramInt);
          localObject = this.GrL;
          if (localObject != null) {
            ((a)localObject).ZZ(paramInt);
          }
          this.GrF = false;
          if (paramBoolean) {
            aac(paramInt - i);
          }
          AppMethodBeat.o(230424);
          return true;
        }
        if ((!this.GrF) && ((this.end >= this.Grz) || (this.end - this.start <= this.Gry)))
        {
          performHapticFeedback(0, 2);
          this.GrF = true;
        }
      }
    }
  }
  
  private final Drawable aab(int paramInt)
  {
    AppMethodBeat.i(230412);
    Object localObject = getResources();
    Resources localResources = getResources();
    p.j(localResources, "resources");
    localObject = (Drawable)new BitmapDrawable((Resources)localObject, BitmapUtil.getBitmapNative(paramInt, localResources.getDisplayMetrics().density));
    AppMethodBeat.o(230412);
    return localObject;
  }
  
  private final void aac(int paramInt)
  {
    AppMethodBeat.i(230426);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null)
    {
      if (paramInt < 0) {
        if (this.GrE == RangeSliderView.c.GrP)
        {
          localRecyclerView.setTranslationX(localRecyclerView.getTranslationX() + -paramInt);
          Log.d("MicroMsg.RangeSliderView", "1 translateX " + -paramInt);
        }
      }
      for (;;)
      {
        this.GrJ += paramInt;
        AppMethodBeat.o(230426);
        return;
        localRecyclerView.scrollBy(paramInt, 0);
        Log.d("MicroMsg.RangeSliderView", "2 scrollBy ".concat(String.valueOf(paramInt)));
        continue;
        if (localRecyclerView.getTranslationX() > 0.0F)
        {
          localRecyclerView.setTranslationX(localRecyclerView.getTranslationX() + -paramInt);
          Log.d("MicroMsg.RangeSliderView", "3 translateX " + -paramInt);
        }
        else
        {
          localRecyclerView.scrollBy(paramInt, 0);
          Log.d("MicroMsg.RangeSliderView", "4 translateX " + -paramInt);
        }
      }
    }
    AppMethodBeat.o(230426);
  }
  
  private final float bK(float paramFloat)
  {
    AppMethodBeat.i(230444);
    Resources localResources = getResources();
    p.j(localResources, "resources");
    float f = localResources.getDisplayMetrics().density;
    AppMethodBeat.o(230444);
    return f * paramFloat;
  }
  
  private final int fim()
  {
    AppMethodBeat.i(230442);
    Resources localResources = getResources();
    p.j(localResources, "resources");
    int i = (int)(localResources.getDisplayMetrics().density * 2.0F);
    AppMethodBeat.o(230442);
    return i;
  }
  
  private final void fin()
  {
    AppMethodBeat.i(230417);
    by localby = this.GrM;
    if (localby != null) {
      localby.a(null);
    }
    this.GrM = null;
    AppMethodBeat.o(230417);
  }
  
  private final boolean fio()
  {
    return (this.GrE == RangeSliderView.c.GrP) && (this.GrK);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(230441);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipPath(this.uWB);
    if (fio()) {
      paramCanvas.translate(-this.GqN, 0.0F);
    }
    for (;;)
    {
      super.dispatchDraw(paramCanvas);
      paramCanvas.restore();
      if (this.isActive)
      {
        if (this.GrE == RangeSliderView.c.GrO) {
          paramCanvas.drawRect(this.progress - this.start, 0.0F, this.progress - this.start + this.progressWidth, paramCanvas.getHeight(), this.opm);
        }
        paramCanvas.drawRect(this.GrA.getBounds().right, -this.GrC.top, this.GrB.getBounds().left, 0.0F, this.borderPaint);
        float f1 = this.GrA.getBounds().right;
        float f2 = paramCanvas.getHeight();
        float f3 = this.GrB.getBounds().left;
        float f4 = paramCanvas.getHeight();
        paramCanvas.drawRect(f1, f2, f3, this.GrC.bottom + f4, this.borderPaint);
        this.GrA.draw(paramCanvas);
        this.GrB.draw(paramCanvas);
      }
      AppMethodBeat.o(230441);
      return;
      paramCanvas.translate(-this.start, 0.0F);
    }
  }
  
  public final a getCallback()
  {
    return this.GrL;
  }
  
  public final int getEnd()
  {
    return this.end;
  }
  
  public final boolean getKeepSizeOnStartChanged()
  {
    return this.GrK;
  }
  
  public final int getMaxEnd()
  {
    return this.Grz;
  }
  
  public final int getMinWidth()
  {
    return this.Gry;
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
    AppMethodBeat.i(230432);
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    Object localObject = localViewParent;
    if (!(localViewParent instanceof ViewGroup)) {
      localObject = null;
    }
    for (localObject = (ViewGroup)localObject; localObject != null; localObject = (ViewGroup)localObject)
    {
      if ((localObject instanceof RecyclerView))
      {
        this.jLl = ((RecyclerView)localObject);
        AppMethodBeat.o(230432);
        return;
      }
      localViewParent = ((ViewGroup)localObject).getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
    }
    localObject = (Throwable)new IllegalStateException("RangeSliderView should be used inside a RecyclerView");
    AppMethodBeat.o(230432);
    throw ((Throwable)localObject);
  }
  
  protected final void onDetachedFromWindow()
  {
    AppMethodBeat.i(230420);
    super.onDetachedFromWindow();
    fin();
    AppMethodBeat.o(230420);
  }
  
  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230438);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = paramInt4 - paramInt2;
    if (fio())
    {
      this.GrG.left = (this.start - this.GqN);
      this.GrG.right = (this.end - this.GqN);
      this.GrG.top = 0.0F;
      this.GrG.bottom = paramInt1;
      this.uWB.reset();
      localObject = this.uWB;
      RectF localRectF = this.GrG;
      float f1 = this.GrH;
      float f2 = this.GrH;
      float f3 = this.GrH;
      float f4 = this.GrH;
      float f5 = this.GrH;
      float f6 = this.GrH;
      float f7 = this.GrH;
      float f8 = this.GrH;
      Path.Direction localDirection = Path.Direction.CW;
      ((Path)localObject).addRoundRect(localRectF, new float[] { f1, f2, f3, f4, f5, f6, f7, f8 }, localDirection);
      paramInt2 = this.GrC.top + paramInt1 + this.GrC.bottom;
      paramInt3 = (int)(paramInt2 / this.GrA.getIntrinsicHeight() * this.GrA.getIntrinsicWidth());
      if (!fio()) {
        break label450;
      }
      this.GrA.setBounds(this.start - this.GqN - this.GrC.left, -this.GrC.top, paramInt3 + (this.start - this.GqN), this.GrC.bottom + paramInt1);
      label308:
      paramInt2 = (int)(paramInt2 / this.GrB.getIntrinsicHeight() * this.GrB.getIntrinsicWidth());
      if (!fio()) {
        break label487;
      }
      this.GrB.setBounds(this.end - this.GqN - paramInt2, -this.GrC.top, this.end - this.GqN + this.GrC.right, paramInt1 + this.GrC.bottom);
    }
    for (;;)
    {
      localObject = getChildAt(0);
      if (localObject != null) {
        break label542;
      }
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.plugin.mv.ui.widget.MvFrameListView");
      AppMethodBeat.o(230438);
      throw ((Throwable)localObject);
      this.GrG.left = 0.0F;
      this.GrG.right = (this.end - this.start);
      break;
      label450:
      this.GrA.setBounds(-this.GrC.left, -this.GrC.top, paramInt3, this.GrC.bottom + paramInt1);
      break label308;
      label487:
      this.GrB.setBounds(this.end - this.start - paramInt2, -this.GrC.top, this.end - this.start + this.GrC.right, paramInt1 + this.GrC.bottom);
    }
    label542:
    Object localObject = (MvFrameListView)localObject;
    ((MvFrameListView)localObject).setDrawStart(this.start);
    ((MvFrameListView)localObject).setDrawEnd(this.end);
    AppMethodBeat.o(230438);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230430);
    if (fio())
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.end - this.GqN, 1073741824), paramInt2);
      AppMethodBeat.o(230430);
      return;
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.end - this.start, 1073741824), paramInt2);
    AppMethodBeat.o(230430);
  }
  
  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(230435);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    RecyclerView localRecyclerView = this.jLl;
    if (localRecyclerView != null)
    {
      localRecyclerView.getLocationOnScreen(this.BdE);
      Comparable localComparable = (Comparable)Float.valueOf(this.BdE[0] + bK(40.0F));
      paramInt1 = this.BdE[0];
      this.GrI = new Range(localComparable, (Comparable)Float.valueOf(localRecyclerView.getWidth() + paramInt1 - bK(40.0F)));
      AppMethodBeat.o(230435);
      return;
    }
    AppMethodBeat.o(230435);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(230414);
    p.k(paramMotionEvent, "event");
    if (!this.isActive)
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(230414);
      return bool;
    }
    int i;
    label70:
    Object localObject;
    switch (paramMotionEvent.getActionMasked())
    {
    default: 
      i = 0;
      this.aCa = paramMotionEvent.getRawX();
      if ((i != 0) || (super.onTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(230414);
        return true;
      }
      break;
    case 0: 
      this.dit = paramMotionEvent.getRawX();
      this.GqN = this.start;
      this.GrD = this.end;
      if (paramMotionEvent.getX() <= this.GrA.getBounds().right)
      {
        this.GrE = RangeSliderView.c.GrP;
        getParent().requestDisallowInterceptTouchEvent(true);
        localObject = this.GrL;
        if (localObject != null)
        {
          ((a)localObject).a(this.GrE, this.start, this.end);
          i = 1;
        }
      }
      break;
    }
    for (;;)
    {
      this.GrF = false;
      break label70;
      i = 1;
      continue;
      if (paramMotionEvent.getX() >= this.GrB.getBounds().left)
      {
        this.GrE = RangeSliderView.c.GrQ;
        getParent().requestDisallowInterceptTouchEvent(true);
        localObject = this.GrL;
        if (localObject != null)
        {
          ((a)localObject).a(this.GrE, this.start, this.end);
          i = 1;
          continue;
        }
        i = 1;
        continue;
        if (this.GrE == RangeSliderView.c.GrO) {
          break;
        }
        if (!this.GrI.contains((Comparable)Float.valueOf(paramMotionEvent.getRawX())))
        {
          localObject = this.GrM;
          if ((localObject == null) || (((by)localObject).isActive() != true))
          {
            localObject = this.GrM;
            if (localObject != null) {
              ((by)localObject).a(null);
            }
            localObject = new aa.d();
            if (this.GrE == RangeSliderView.c.GrP) {}
            for (i = this.start - this.GqN;; i = this.end - this.GrD)
            {
              ((aa.d)localObject).aaBA = i;
              this.GrM = g.b((ak)br.abxo, (f)bc.iRr(), (m)new d(this, (aa.d)localObject, null), 2);
              i = 1;
              break;
            }
          }
        }
        else
        {
          if (aQ(kotlin.h.a.dm(paramMotionEvent.getRawX() - this.dit) + this.GrJ, false)) {}
          for (i = 1;; i = 0)
          {
            fin();
            break label70;
            if (this.GrE != RangeSliderView.c.GrO)
            {
              localObject = this.GrL;
              if (localObject != null) {
                ((a)localObject).b(this.GrE, this.start, this.end);
              }
              this.GrE = RangeSliderView.c.GrO;
              localObject = this.jLl;
              if (localObject != null) {
                ((RecyclerView)localObject).setTranslationX(0.0F);
              }
              this.GrJ = 0;
            }
            fin();
            break;
            AppMethodBeat.o(230414);
            return false;
          }
        }
        i = 1;
        break label70;
      }
      i = 0;
    }
  }
  
  public final void setActive(boolean paramBoolean)
  {
    AppMethodBeat.i(230408);
    this.isActive = paramBoolean;
    invalidate();
    AppMethodBeat.o(230408);
  }
  
  public final void setCallback(a parama)
  {
    this.GrL = parama;
  }
  
  public final void setEnd(int paramInt)
  {
    AppMethodBeat.i(230402);
    if (paramInt < 0) {}
    for (this.end = 0;; this.end = paramInt)
    {
      requestLayout();
      AppMethodBeat.o(230402);
      return;
    }
  }
  
  public final void setKeepSizeOnStartChanged(boolean paramBoolean)
  {
    this.GrK = paramBoolean;
  }
  
  public final void setMaxEnd(int paramInt)
  {
    this.Grz = paramInt;
  }
  
  public final void setMinWidth(int paramInt)
  {
    this.Gry = paramInt;
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(230404);
    this.progress = i.bm(paramInt, this.start, this.end);
    postInvalidate();
    AppMethodBeat.o(230404);
  }
  
  public final void setStart(int paramInt)
  {
    AppMethodBeat.i(230401);
    if (paramInt < 0) {}
    for (this.start = 0;; this.start = paramInt)
    {
      requestLayout();
      AppMethodBeat.o(230401);
      return;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Callback;", "", "onRangeEndChanged", "", "oldValue", "", "newValue", "onRangeStartChanged", "onSlidingStarted", "edge", "Lcom/tencent/mm/plugin/mv/ui/widget/RangeSliderView$Edge;", "start", "end", "onSlidingStopped", "plugin-mv_release"})
  public static abstract interface a
  {
    public abstract void ZY(int paramInt);
    
    public abstract void ZZ(int paramInt);
    
    public abstract void a(RangeSliderView.c paramc, int paramInt1, int paramInt2);
    
    public abstract void b(RangeSliderView.c paramc, int paramInt1, int paramInt2);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class d
    extends j
    implements m<ak, d<? super x>, Object>
  {
    Object L$0;
    int label;
    private ak p$;
    int rdc;
    
    d(RangeSliderView paramRangeSliderView, aa.d paramd, d paramd1)
    {
      super(paramd1);
    }
    
    public final d<x> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(228142);
      p.k(paramd, "completion");
      paramd = new d(this.GrS, this.GrT, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(228142);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(228143);
      paramObject1 = ((d)create(paramObject1, (d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(228143);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(228140);
      kotlin.d.a.a locala = kotlin.d.a.a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(228140);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.p$;
        float f = RangeSliderView.a(this.GrS);
        localObject = RangeSliderView.b(this.GrS).getUpper();
        p.j(localObject, "dragRange.upper");
        if (f > ((Number)localObject).floatValue())
        {
          f = RangeSliderView.a(this.GrS);
          localObject = RangeSliderView.b(this.GrS).getUpper();
          p.j(localObject, "dragRange.upper");
        }
        for (int i = kotlin.h.a.dm(f - ((Number)localObject).floatValue());; i = kotlin.h.a.dm(f - ((Number)localObject).floatValue()))
        {
          RangeSliderView.a(this.GrS, this.GrT.aaBA + i);
          localObject = this.GrT;
          ((aa.d)localObject).aaBA += i;
          this.L$0 = paramObject;
          this.rdc = i;
          this.label = 1;
          if (aw.a(100L, this) != locala) {
            break;
          }
          AppMethodBeat.o(228140);
          return locala;
          f = RangeSliderView.a(this.GrS);
          localObject = RangeSliderView.b(this.GrS).getLower();
          p.j(localObject, "dragRange.lower");
        }
      }
      Object localObject = (ak)this.L$0;
      ResultKt.throwOnFailure(paramObject);
      paramObject = localObject;
      for (;;)
      {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.widget.RangeSliderView
 * JD-Core Version:    0.7.0.1
 */