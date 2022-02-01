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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.rv;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import com.tencent.mm.vfs.o;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.Iterator;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"})
public final class a
  extends TouchEventLayout
  implements com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  public static final a.a xZH;
  private View.OnClickListener cNE;
  private boolean gpa;
  private boolean gpb;
  private float gpe;
  private float gpf;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pZW;
  private final float[] qag;
  private final int rW;
  private final View xZA;
  private final int xZB;
  private final int xZC;
  private long xZD;
  private d.g.a.b<? super View, z> xZE;
  private boolean xZF;
  private final Runnable xZG;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.c xZo;
  private final Rect xZp;
  private final Rect xZq;
  private EditorItemContainer.b xZr;
  private final RectF xZs;
  private final RectF xZt;
  private final Matrix xZu;
  private final int xZv;
  private final f xZw;
  private final f xZx;
  private final f xZy;
  private final f xZz;
  
  static
  {
    AppMethodBeat.i(206789);
    xZH = new a.a((byte)0);
    AppMethodBeat.o(206789);
  }
  
  public a(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(206788);
    this.pZW = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xZp = new Rect(0, 0, com.tencent.mm.ui.ar.ck(ak.getContext()).x, com.tencent.mm.ui.ar.ck(ak.getContext()).y);
    this.xZq = new Rect(0, 0, com.tencent.mm.ui.ar.ck(ak.getContext()).x, com.tencent.mm.ui.ar.ck(ak.getContext()).y);
    this.xZs = new RectF();
    this.xZt = new RectF();
    this.xZu = new Matrix();
    this.xZv = com.tencent.mm.cb.a.fromDPToPix(paramContext, 4);
    Object localObject = ViewConfiguration.get(paramContext);
    p.g(localObject, "ViewConfiguration.get(context)");
    this.rW = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.xZw = d.g.O((d.g.a.a)new e(this));
    this.xZx = d.g.O((d.g.a.a)new c(this));
    this.xZy = d.g.O((d.g.a.a)new b(this));
    this.xZz = d.g.O((d.g.a.a)new d(this, paramContext));
    this.xZB = com.tencent.mm.cb.a.fromDPToPix(getContext(), 32);
    this.xZC = (com.tencent.mm.cb.a.iu(paramContext) - com.tencent.mm.cb.a.ax(paramContext, 2131165281));
    this.qag = new float[2];
    this.xZG = ((Runnable)new g(this));
    setEnableFling(false);
    if (p.i(Looper.myLooper(), Looper.getMainLooper())) {
      getTouchDetector().setIsLongpressEnabled(false);
    }
    LayoutInflater.from(paramContext).inflate(2131496498, (ViewGroup)this, true);
    LayoutInflater.from(paramContext).inflate(2131496497, (ViewGroup)this, true);
    localObject = findViewById(2131308238);
    p.g(localObject, "findViewById(R.id.caption_float_comment)");
    this.xZA = ((View)localObject);
    getCaptionView().setText((CharSequence)com.tencent.mm.cb.a.az(paramContext, 2131767202));
    setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(206788);
  }
  
  private void dKI()
  {
    AppMethodBeat.i(206786);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.xZs.right;
    LinearLayout localLinearLayout = getCaptionContentLayout();
    p.g(localLinearLayout, "captionContentLayout");
    arrayOfFloat[1] = localLinearLayout.getBottom();
    this.xZu.mapPoints(arrayOfFloat);
    float f = this.xZp.bottom - this.xZB - arrayOfFloat[1];
    if (f < 0.0F)
    {
      this.xZu.postTranslate(0.0F, f);
      this.xZA.setVisibility(0);
    }
    AppMethodBeat.o(206786);
  }
  
  private static float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(206782);
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(206782);
    return f;
  }
  
  private final LinearLayout getCaptionContentLayout()
  {
    AppMethodBeat.i(206765);
    LinearLayout localLinearLayout = (LinearLayout)this.xZy.getValue();
    AppMethodBeat.o(206765);
    return localLinearLayout;
  }
  
  private final RelativeLayout getCaptionLayout()
  {
    AppMethodBeat.i(206764);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.xZx.getValue();
    AppMethodBeat.o(206764);
    return localRelativeLayout;
  }
  
  private final LinearLayout getCaptionLoadingLayout()
  {
    AppMethodBeat.i(206766);
    LinearLayout localLinearLayout = (LinearLayout)this.xZz.getValue();
    AppMethodBeat.o(206766);
    return localLinearLayout;
  }
  
  private final PhotoTextView getCaptionView()
  {
    AppMethodBeat.i(206763);
    PhotoTextView localPhotoTextView = (PhotoTextView)this.xZw.getValue();
    AppMethodBeat.o(206763);
    return localPhotoTextView;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(206778);
    p.h(paramRect, "displayRect");
    this.xZq.set(paramRect);
    this.pZW.width = paramRect.width();
    this.xZs.right = paramRect.width();
    measure(0, 0);
    Object localObject = getCaptionLayout();
    p.g(localObject, "captionLayout");
    int i = ((RelativeLayout)localObject).getMeasuredHeight();
    localObject = getCaptionContentLayout();
    p.g(localObject, "captionContentLayout");
    paramFloat = (i + ((LinearLayout)localObject).getMeasuredHeight()) / 2.0F;
    paramFloat = this.xZp.bottom - paramFloat - this.xZB;
    this.pZW.o(new float[] { 0.0F, 0.0F, this.pZW.width, 0.0F, 0.0F, this.pZW.height, this.pZW.width, this.pZW.height });
    this.xZu.postTranslate(0.0F, paramFloat);
    dKJ();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "topMargin:" + paramFloat + " width:" + paramRect.width());
    AppMethodBeat.o(206778);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(206769);
    p.h(paramc, "captionItem");
    this.xZo = paramc;
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    PhotoTextView localPhotoTextView1;
    if (!TextUtils.isEmpty((CharSequence)paramc.ydG)) {
      if (o.fB(paramc.ydG))
      {
        localPhotoTextView1 = getCaptionView();
        p.g(localPhotoTextView1, "captionView");
        localPhotoTextView1.setTypeface(Typeface.createFromFile(paramc.ydG));
      }
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "updateCaptionItem caption:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(206769);
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
    AppMethodBeat.i(206767);
    p.h(paramd, "type");
    Object localObject = this.xZo;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).ydv; localObject == paramd; localObject = null)
    {
      AppMethodBeat.o(206767);
      return true;
    }
    AppMethodBeat.o(206767);
    return false;
  }
  
  public final boolean axd(String paramString)
  {
    AppMethodBeat.i(206790);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(206790);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(206775);
    p.h(paramRect, "safeRect");
    this.pZW.xKi = paramRect;
    this.pZW.yge = com.tencent.mm.cb.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(206775);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a clM()
  {
    AppMethodBeat.i(206774);
    Object localObject1 = this.xZo;
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
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).ydv, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).ydF, (Matrix)localObject2);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).ydG = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).ydG;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).textColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).textColor;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).bgColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).bgColor;
      localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2;
      AppMethodBeat.o(206774);
      return localObject1;
    }
    AppMethodBeat.o(206774);
    return null;
  }
  
  public final void dKJ()
  {
    AppMethodBeat.i(206787);
    this.xZu.mapRect(this.xZt, this.xZs);
    float[] arrayOfFloat = new float[9];
    this.xZu.getValues(arrayOfFloat);
    float f = e(this.xZu);
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
    AppMethodBeat.o(206787);
  }
  
  public final boolean dKK()
  {
    return true;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(206773);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipRect(this.xZp);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(206773);
  }
  
  public final d.g.a.b<View, z> getClearCaptionListener()
  {
    return this.xZE;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(206780);
    float[] arrayOfFloat = (float[])this.pZW.ygj.clone();
    AppMethodBeat.o(206780);
    return arrayOfFloat;
  }
  
  public final rv getCurrentCaption()
  {
    AppMethodBeat.i(206772);
    Object localObject = this.xZo;
    if (localObject != null)
    {
      long l = this.xZD;
      localObject = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).ydF).iterator();
      while (((Iterator)localObject).hasNext())
      {
        rv localrv = (rv)((Iterator)localObject).next();
        if ((localrv.Ggq <= l) && (localrv.Ggr >= l))
        {
          AppMethodBeat.o(206772);
          return localrv;
        }
      }
      AppMethodBeat.o(206772);
      return null;
    }
    AppMethodBeat.o(206772);
    return null;
  }
  
  public final RectF getDrawRect()
  {
    return this.xZt;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData()
  {
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)this.xZo;
  }
  
  public final boolean getEnableEdit()
  {
    return this.xZF;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(206776);
    Rect localRect = this.pZW.xKi;
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
    AppMethodBeat.o(206776);
    return localObject;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pZW;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    AppMethodBeat.i(206781);
    if (a(d.ydO))
    {
      localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygH;
      AppMethodBeat.o(206781);
      return localb;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.view.b localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.ygG;
    AppMethodBeat.o(206781);
    return localb;
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(206784);
    p.h(paramScaleGestureDetector, "detector");
    float f1 = paramScaleGestureDetector.getFocusY();
    float f2 = 1.0F - paramScaleGestureDetector.getScaleFactor();
    this.xZu.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor());
    this.xZu.postTranslate(this.xZs.centerX() * f2, f1 * f2);
    dKI();
    dKJ();
    AppMethodBeat.o(206784);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(206785);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    this.xZu.postTranslate(0.0F, -paramFloat2);
    dKI();
    dKJ();
    AppMethodBeat.o(206785);
    return true;
  }
  
  public final boolean onTouch(View paramView, final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(206783);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.gpa)
    {
      Object localObject1;
      if ((paramMotionEvent.getAction() != 3) || (paramMotionEvent.getAction() != 1))
      {
        bringToFront();
        if (this.xZF) {
          getCaptionView().setBackgroundDrawable(com.tencent.mm.cb.a.l(getContext(), 2131235032));
        }
        localObject1 = this.xZr;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).c((View)this, paramMotionEvent);
        }
        com.tencent.mm.sdk.platformtools.ar.ay(this.xZG);
        com.tencent.mm.sdk.platformtools.ar.o(this.xZG, 1500L);
      }
      boolean bool = super.onTouch(paramView, paramMotionEvent);
      AppMethodBeat.o(206783);
      return bool;
      this.gpe = paramMotionEvent.getX();
      this.gpf = paramMotionEvent.getY();
      if (this.xZt.contains(this.gpe, this.gpf)) {
        this.gpa = true;
      }
      this.gpb = false;
      this.qag[0] = (this.xZs.width() / 2.0F);
      this.qag[1] = (this.xZs.height() / 2.0F);
      this.xZu.mapPoints(this.qag);
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.gpe), Math.abs(paramMotionEvent.getY() - this.gpf));
      if (!this.gpb)
      {
        if (f > this.rW) {}
        for (bool = true;; bool = false)
        {
          this.gpb = bool;
          break;
        }
        this.gpa = false;
        this.xZA.setVisibility(4);
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        Object localObject2 = this.xZp;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXF = 0.5F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXE = 3.0F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.xZs.width() / 2.0F, this.xZs.height() / 2.0F });
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
        localObject2 = new float[2];
        localObject2[0] = (this.xZs.width() / 2.0F);
        localObject2[1] = (this.xZs.height() / 2.0F);
        this.xZu.mapPoints((float[])localObject2);
        if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).yfO.contains(localObject2[0], localObject2[1])) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.qag[0], this.qag[1], this.qag[0], this.qag[1]));
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.xZu, (m)new f(this, paramMotionEvent));
      }
    }
    AppMethodBeat.o(206783);
    return false;
  }
  
  public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(206768);
    p.h(paramc, "captionItem");
    this.xZo = paramc;
    getCaptionLayout().measure(0, 0);
    Object localObject1 = this.pZW;
    Object localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((com.tencent.mm.plugin.recordvideo.ui.editor.c.c)localObject1).height = ((RelativeLayout)localObject2).getMeasuredHeight();
    localObject1 = this.xZs;
    localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((RectF)localObject1).bottom = ((RelativeLayout)localObject2).getMeasuredHeight();
    dKJ();
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.ydG)) {
      if (o.fB(paramc.ydG))
      {
        localObject1 = getCaptionView();
        p.g(localObject1, "captionView");
        ((PhotoTextView)localObject1).setTypeface(Typeface.createFromFile(paramc.ydG));
      }
    }
    for (;;)
    {
      localObject1 = new StringBuilder("height:");
      localObject2 = getCaptionView();
      p.g(localObject2, "captionView");
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", ((PhotoTextView)localObject2).getMeasuredHeight() + " caption:" + paramc);
      AppMethodBeat.o(206768);
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
  
  public final void setClearCaptionListener(d.g.a.b<? super View, z> paramb)
  {
    this.xZE = paramb;
  }
  
  public final void setEnableEdit(boolean paramBoolean)
  {
    this.xZF = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(206779);
    super.setOnClickListener(paramOnClickListener);
    this.cNE = paramOnClickListener;
    AppMethodBeat.o(206779);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(206770);
    p.h(paramb, "stateResolve");
    this.xZr = paramb;
    AppMethodBeat.o(206770);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(206777);
    p.h(paramRect, "validRect");
    this.xZp.set(paramRect);
    dKI();
    dKJ();
    Object localObject = this.xZA.getLayoutParams();
    if (localObject == null)
    {
      paramRect = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(206777);
      throw paramRect;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).topMargin != paramRect.bottom - this.xZB)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (paramRect.bottom - this.xZB);
      this.xZA.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(206777);
  }
  
  public final boolean zi(long paramLong)
  {
    AppMethodBeat.i(206771);
    this.xZD = paramLong;
    Object localObject1 = this.xZo;
    Object localObject2;
    label57:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).zk(paramLong);
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = ((rv)localObject1).Ggp;
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
      getCaptionView().setTextSize(0, com.tencent.mm.cb.a.ax(getContext(), 2131165467));
      getCaptionView().setAutoSizeTextTypeWithDefaults(1);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setVisibility(0);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)localObject2);
      if (localObject1 == null) {
        p.gkB();
      }
      if (((rv)localObject1).Ggs) {
        break label284;
      }
      bool = true;
      label195:
      this.xZF = bool;
      if (this.xZF) {
        break label289;
      }
      getCaptionView().setBackgroundDrawable(null);
      com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set INVISIBLE");
      localObject1 = getCaptionContentLayout();
      p.g(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(4);
      localObject1 = getCaptionLoadingLayout();
      p.g(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(206771);
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
      com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set VISIBLE");
      localObject1 = getCaptionContentLayout();
      p.g(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = getCaptionLoadingLayout();
      p.g(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(4);
    }
    label341:
    com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it empty, set INVISIBLE");
    setVisibility(4);
    AppMethodBeat.o(206771);
    return false;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<LinearLayout>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<RelativeLayout>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<LinearLayout>
  {
    d(a parama, Context paramContext)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(a.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(206758);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.xZJ.xZI.getParent();
        if (paramView == null)
        {
          paramView = new v("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(206758);
          throw paramView;
        }
        ((ViewGroup)paramView).removeView((View)this.xZJ.xZI);
        paramView = this.xZJ.xZI.getClearCaptionListener();
        if (paramView != null) {
          paramView.invoke(this.xZJ.xZI);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(206758);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<PhotoTextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class f
    extends q
    implements m<Matrix, Boolean, z>
  {
    f(a parama, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(206762);
      a.c(this.xZI).setBackgroundDrawable(null);
      AppMethodBeat.o(206762);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */