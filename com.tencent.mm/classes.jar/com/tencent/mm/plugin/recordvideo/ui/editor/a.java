package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.sy;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import kotlin.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"})
public final class a
  extends TouchEventLayout
  implements com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  public static final a.a CaG;
  private final int CaA;
  private final int CaB;
  private long CaC;
  private kotlin.g.a.b<? super View, x> CaD;
  private boolean CaE;
  private final Runnable CaF;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.c Can;
  private final Rect Cao;
  private final Rect Cap;
  private EditorItemContainer.b Caq;
  private final RectF Car;
  private final RectF Cas;
  private final Matrix Cat;
  private final int Cau;
  private final f Cav;
  private final f Caw;
  private final f Cax;
  private final f Cay;
  private final View Caz;
  private View.OnClickListener dec;
  private boolean gZT;
  private boolean gZU;
  private float gZX;
  private float gZY;
  private final int rZ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c rqT;
  private final float[] rrd;
  
  static
  {
    AppMethodBeat.i(237610);
    CaG = new a.a((byte)0);
    AppMethodBeat.o(237610);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(237609);
    this.rqT = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.Cao = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.Cap = new Rect(0, 0, au.az(MMApplicationContext.getContext()).x, au.az(MMApplicationContext.getContext()).y);
    this.Car = new RectF();
    this.Cas = new RectF();
    this.Cat = new Matrix();
    this.Cau = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    Object localObject = ViewConfiguration.get(paramContext);
    p.g(localObject, "ViewConfiguration.get(context)");
    this.rZ = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.Cav = kotlin.g.ah((kotlin.g.a.a)new a.e(this));
    this.Caw = kotlin.g.ah((kotlin.g.a.a)new a.c(this));
    this.Cax = kotlin.g.ah((kotlin.g.a.a)new a.b(this));
    this.Cay = kotlin.g.ah((kotlin.g.a.a)new a.d(this, paramContext));
    this.CaA = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
    this.CaB = (com.tencent.mm.cb.a.jn(paramContext) - com.tencent.mm.cb.a.aG(paramContext, 2131165286));
    this.rrd = new float[2];
    this.CaF = ((Runnable)new a.g(this));
    setEnableFling(false);
    if (p.j(Looper.myLooper(), Looper.getMainLooper())) {
      getTouchDetector().setIsLongpressEnabled(false);
    }
    LayoutInflater.from(paramContext).inflate(2131496797, (ViewGroup)this, true);
    LayoutInflater.from(paramContext).inflate(2131496796, (ViewGroup)this, true);
    localObject = findViewById(2131297979);
    p.g(localObject, "findViewById(R.id.caption_float_comment)");
    this.Caz = ((View)localObject);
    getCaptionView().setText((CharSequence)com.tencent.mm.cb.a.aI(paramContext, 2131767047));
    setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(237609);
  }
  
  private static float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(237603);
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(237603);
    return f;
  }
  
  private void eLI()
  {
    AppMethodBeat.i(237607);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.Car.right;
    LinearLayout localLinearLayout = getCaptionContentLayout();
    p.g(localLinearLayout, "captionContentLayout");
    arrayOfFloat[1] = localLinearLayout.getBottom();
    this.Cat.mapPoints(arrayOfFloat);
    float f = this.Cao.bottom - this.CaA - arrayOfFloat[1];
    if (f < 0.0F)
    {
      this.Cat.postTranslate(0.0F, f);
      this.Caz.setVisibility(0);
    }
    AppMethodBeat.o(237607);
  }
  
  private final LinearLayout getCaptionContentLayout()
  {
    AppMethodBeat.i(237586);
    LinearLayout localLinearLayout = (LinearLayout)this.Cax.getValue();
    AppMethodBeat.o(237586);
    return localLinearLayout;
  }
  
  private final RelativeLayout getCaptionLayout()
  {
    AppMethodBeat.i(237585);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Caw.getValue();
    AppMethodBeat.o(237585);
    return localRelativeLayout;
  }
  
  private final LinearLayout getCaptionLoadingLayout()
  {
    AppMethodBeat.i(237587);
    LinearLayout localLinearLayout = (LinearLayout)this.Cay.getValue();
    AppMethodBeat.o(237587);
    return localLinearLayout;
  }
  
  private final PhotoTextView getCaptionView()
  {
    AppMethodBeat.i(237584);
    PhotoTextView localPhotoTextView = (PhotoTextView)this.Cav.getValue();
    AppMethodBeat.o(237584);
    return localPhotoTextView;
  }
  
  public final boolean Ig(long paramLong)
  {
    AppMethodBeat.i(237592);
    this.CaC = paramLong;
    Object localObject1 = this.Can;
    Object localObject2;
    label57:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).Ii(paramLong);
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = ((sy)localObject1).LaS;
      if (localObject2 == null) {
        break label278;
      }
      localObject2 = ((com.tencent.mm.bw.b)localObject2).toString("UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label341;
      }
      setVisibility(0);
      getCaptionView().setAutoSizeTextTypeWithDefaults(0);
      PhotoTextView localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)"");
      getCaptionView().setTextSize(0, com.tencent.mm.cb.a.aG(getContext(), 2131165483));
      getCaptionView().setAutoSizeTextTypeWithDefaults(1);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setVisibility(0);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)localObject2);
      if (localObject1 == null) {
        p.hyc();
      }
      if (((sy)localObject1).LaV) {
        break label284;
      }
      bool = true;
      label195:
      this.CaE = bool;
      if (this.CaE) {
        break label289;
      }
      getCaptionView().setBackgroundDrawable(null);
      com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set INVISIBLE");
      localObject1 = getCaptionContentLayout();
      p.g(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(4);
      localObject1 = getCaptionLoadingLayout();
      p.g(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(237592);
      return true;
      localObject1 = null;
      break;
      label278:
      localObject2 = null;
      break label57;
      label284:
      bool = false;
      break label195;
      label289:
      com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set VISIBLE");
      localObject1 = getCaptionContentLayout();
      p.g(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = getCaptionLoadingLayout();
      p.g(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(4);
    }
    label341:
    com.tencent.mm.audio.mix.i.b.d("MicroMsg.CaptionItemView", "text it empty, set INVISIBLE");
    setVisibility(4);
    AppMethodBeat.o(237592);
    return false;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(237599);
    p.h(paramRect, "displayRect");
    this.Cap.set(paramRect);
    this.rqT.width = paramRect.width();
    this.Car.right = paramRect.width();
    measure(0, 0);
    Object localObject = getCaptionLayout();
    p.g(localObject, "captionLayout");
    int i = ((RelativeLayout)localObject).getMeasuredHeight();
    localObject = getCaptionContentLayout();
    p.g(localObject, "captionContentLayout");
    paramFloat = (i + ((LinearLayout)localObject).getMeasuredHeight()) / 2.0F;
    localObject = e.BKp;
    paramFloat = e.getVisibleRect().bottom - paramFloat - this.CaA;
    this.rqT.o(new float[] { 0.0F, 0.0F, this.rqT.width, 0.0F, 0.0F, this.rqT.height, this.rqT.width, this.rqT.height });
    this.Cat.postTranslate(0.0F, paramFloat);
    eLJ();
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", "topMargin:" + paramFloat + " width:" + paramRect.width());
    AppMethodBeat.o(237599);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(237590);
    p.h(paramc, "captionItem");
    this.Can = paramc;
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    PhotoTextView localPhotoTextView1;
    if (!TextUtils.isEmpty((CharSequence)paramc.CeI)) {
      if (s.YS(paramc.CeI))
      {
        localPhotoTextView1 = getCaptionView();
        p.g(localPhotoTextView1, "captionView");
        localPhotoTextView1.setTypeface(Typeface.createFromFile(paramc.CeI));
      }
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", "updateCaptionItem caption:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(237590);
      return;
      localPhotoTextView1 = getCaptionView();
      p.g(localPhotoTextView1, "captionView");
      localPhotoTextView1.setTypeface(Typeface.DEFAULT);
      continue;
      localPhotoTextView1 = getCaptionView();
      PhotoTextView localPhotoTextView2 = getCaptionView();
      p.g(localPhotoTextView2, "captionView");
      localPhotoTextView1.setTypeface(localPhotoTextView2.getTypeface(), 1);
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(237588);
    p.h(paramd, "type");
    Object localObject = this.Can;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).Cex; localObject == paramd; localObject = null)
    {
      AppMethodBeat.o(237588);
      return true;
    }
    AppMethodBeat.o(237588);
    return false;
  }
  
  public final boolean aLB(String paramString)
  {
    AppMethodBeat.i(237611);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(237611);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(237596);
    p.h(paramRect, "safeRect");
    this.rqT.BKm = paramRect;
    this.rqT.Chb = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(237596);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cJO()
  {
    AppMethodBeat.i(237595);
    Object localObject1 = this.Can;
    if (localObject1 != null)
    {
      Object localObject2 = new Matrix();
      Object localObject3 = getCaptionLayout();
      p.g(localObject3, "captionLayout");
      float f = ((RelativeLayout)localObject3).getScaleX();
      localObject3 = getCaptionLayout();
      p.g(localObject3, "captionLayout");
      ((Matrix)localObject2).postScale(f, ((RelativeLayout)localObject3).getScaleY());
      localObject3 = new int[2];
      getCaptionLayout().getLocationOnScreen((int[])localObject3);
      ((Matrix)localObject2).postTranslate(0.0F, localObject3[1]);
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Cex, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).CeH, (Matrix)localObject2);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).CeI = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).CeI;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).textColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).textColor;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).bgColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).bgColor;
      localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2;
      AppMethodBeat.o(237595);
      return localObject1;
    }
    AppMethodBeat.o(237595);
    return null;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(237594);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipRect(this.Cao);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(237594);
  }
  
  public final void eLJ()
  {
    AppMethodBeat.i(237608);
    this.Cat.mapRect(this.Cas, this.Car);
    float[] arrayOfFloat = new float[9];
    this.Cat.getValues(arrayOfFloat);
    float f = e(this.Cat);
    RelativeLayout localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setPivotX(0.0F);
    localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setPivotY(0.0F);
    localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setScaleX(f);
    localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setScaleY(f);
    localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setTranslationX(arrayOfFloat[2]);
    localRelativeLayout = getCaptionLayout();
    p.g(localRelativeLayout, "captionLayout");
    localRelativeLayout.setTranslationY(arrayOfFloat[5]);
    AppMethodBeat.o(237608);
  }
  
  public final boolean eLK()
  {
    return true;
  }
  
  public final kotlin.g.a.b<View, x> getClearCaptionListener()
  {
    return this.CaD;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(237601);
    float[] arrayOfFloat = (float[])this.rqT.Chg.clone();
    AppMethodBeat.o(237601);
    return arrayOfFloat;
  }
  
  public final sy getCurrentCaption()
  {
    AppMethodBeat.i(237593);
    Object localObject = this.Can;
    if (localObject != null)
    {
      long l = this.CaC;
      localObject = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).CeH).iterator();
      while (((Iterator)localObject).hasNext())
      {
        sy localsy = (sy)((Iterator)localObject).next();
        if ((localsy.LaT <= l) && (localsy.LaU >= l))
        {
          AppMethodBeat.o(237593);
          return localsy;
        }
      }
      AppMethodBeat.o(237593);
      return null;
    }
    AppMethodBeat.o(237593);
    return null;
  }
  
  public final RectF getDrawRect()
  {
    return this.Cas;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData()
  {
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)this.Can;
  }
  
  public final boolean getEnableEdit()
  {
    return this.CaE;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(237597);
    Rect localRect = this.rqT.BKm;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.g(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.g(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(237597);
    return localObject;
  }
  
  public final int getTouchSlop()
  {
    return this.rZ;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.rqT;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    AppMethodBeat.i(237602);
    if (a(d.CeQ))
    {
      localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ChE;
      AppMethodBeat.o(237602);
      return localb;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.view.b localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ChD;
    AppMethodBeat.o(237602);
    return localb;
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(237605);
    p.h(paramScaleGestureDetector, "detector");
    float f1 = paramScaleGestureDetector.getFocusY();
    float f2 = 1.0F - paramScaleGestureDetector.getScaleFactor();
    this.Cat.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor());
    this.Cat.postTranslate(this.Car.centerX() * f2, f1 * f2);
    eLI();
    eLJ();
    AppMethodBeat.o(237605);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(237606);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    this.Cat.postTranslate(0.0F, -paramFloat2);
    eLI();
    eLJ();
    AppMethodBeat.o(237606);
    return true;
  }
  
  public final boolean onTouch(View paramView, final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237604);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.gZT)
    {
      Object localObject1;
      if ((paramMotionEvent.getAction() != 3) || (paramMotionEvent.getAction() != 1))
      {
        bringToFront();
        if (this.CaE) {
          getCaptionView().setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), 2131231177));
        }
        localObject1 = this.Caq;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).d((View)this, paramMotionEvent);
        }
        MMHandlerThread.removeRunnable(this.CaF);
        MMHandlerThread.postToMainThreadDelayed(this.CaF, 1500L);
      }
      boolean bool = super.onTouch(paramView, paramMotionEvent);
      AppMethodBeat.o(237604);
      return bool;
      this.gZX = paramMotionEvent.getX();
      this.gZY = paramMotionEvent.getY();
      if (this.Cas.contains(this.gZX, this.gZY)) {
        this.gZT = true;
      }
      this.gZU = false;
      this.rrd[0] = (this.Car.width() / 2.0F);
      this.rrd[1] = (this.Car.height() / 2.0F);
      this.Cat.mapPoints(this.rrd);
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.gZX), Math.abs(paramMotionEvent.getY() - this.gZY));
      if (!this.gZU)
      {
        if (f > this.rZ) {}
        for (bool = true;; bool = false)
        {
          this.gZU = bool;
          break;
        }
        this.gZT = false;
        this.Caz.setVisibility(4);
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        Object localObject2 = this.Cao;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXu = 0.5F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXt = 3.0F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.Car.width() / 2.0F, this.Car.height() / 2.0F });
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
        localObject2 = new float[2];
        localObject2[0] = (this.Car.width() / 2.0F);
        localObject2[1] = (this.Car.height() / 2.0F);
        this.Cat.mapPoints((float[])localObject2);
        if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).CgM.contains(localObject2[0], localObject2[1])) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.rrd[0], this.rrd[1], this.rrd[0], this.rrd[1]));
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.Cat, (m)new f(this, paramMotionEvent));
      }
    }
    AppMethodBeat.o(237604);
    return false;
  }
  
  public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(237589);
    p.h(paramc, "captionItem");
    this.Can = paramc;
    getCaptionLayout().measure(0, 0);
    Object localObject1 = this.rqT;
    Object localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((com.tencent.mm.plugin.recordvideo.ui.editor.c.c)localObject1).height = ((RelativeLayout)localObject2).getMeasuredHeight();
    localObject1 = this.Car;
    localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((RectF)localObject1).bottom = ((RelativeLayout)localObject2).getMeasuredHeight();
    eLJ();
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.CeI)) {
      if (s.YS(paramc.CeI))
      {
        localObject1 = getCaptionView();
        p.g(localObject1, "captionView");
        ((PhotoTextView)localObject1).setTypeface(Typeface.createFromFile(paramc.CeI));
      }
    }
    for (;;)
    {
      localObject1 = new StringBuilder("height:");
      localObject2 = getCaptionView();
      p.g(localObject2, "captionView");
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.CaptionItemView", ((PhotoTextView)localObject2).getMeasuredHeight() + " caption:" + paramc);
      AppMethodBeat.o(237589);
      return;
      localObject1 = getCaptionView();
      p.g(localObject1, "captionView");
      ((PhotoTextView)localObject1).setTypeface(Typeface.DEFAULT);
      continue;
      localObject1 = getCaptionView();
      localObject2 = getCaptionView();
      p.g(localObject2, "captionView");
      ((PhotoTextView)localObject1).setTypeface(((PhotoTextView)localObject2).getTypeface(), 1);
    }
  }
  
  public final void setClearCaptionListener(kotlin.g.a.b<? super View, x> paramb)
  {
    this.CaD = paramb;
  }
  
  public final void setEnableEdit(boolean paramBoolean)
  {
    this.CaE = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(237600);
    super.setOnClickListener(paramOnClickListener);
    this.dec = paramOnClickListener;
    AppMethodBeat.o(237600);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(237591);
    p.h(paramb, "stateResolve");
    this.Caq = paramb;
    AppMethodBeat.o(237591);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(237598);
    p.h(paramRect, "validRect");
    this.Cao.set(paramRect);
    eLI();
    eLJ();
    Object localObject = this.Caz.getLayoutParams();
    if (localObject == null)
    {
      paramRect = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(237598);
      throw paramRect;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).topMargin != paramRect.bottom - this.CaA)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (paramRect.bottom - this.CaA);
      this.Caz.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(237598);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class f
    extends q
    implements m<Matrix, Boolean, x>
  {
    f(a parama, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */