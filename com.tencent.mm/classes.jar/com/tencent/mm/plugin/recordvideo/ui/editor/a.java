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
import com.tencent.mm.protocal.protobuf.rt;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.Iterator;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"})
public final class a
  extends TouchEventLayout
  implements com.tencent.mm.plugin.recordvideo.ui.editor.item.g, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  public static final a.a xJM;
  private View.OnClickListener cMV;
  private boolean gmE;
  private boolean gmF;
  private float gmI;
  private float gmJ;
  private final float[] pTB;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c pTr;
  private final int rW;
  private final int xJA;
  private final f xJB;
  private final f xJC;
  private final f xJD;
  private final f xJE;
  private final View xJF;
  private final int xJG;
  private final int xJH;
  private long xJI;
  private d.g.a.b<? super View, z> xJJ;
  private boolean xJK;
  private final Runnable xJL;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.c xJt;
  private final Rect xJu;
  private final Rect xJv;
  private EditorItemContainer.b xJw;
  private final RectF xJx;
  private final RectF xJy;
  private final Matrix xJz;
  
  static
  {
    AppMethodBeat.i(200528);
    xJM = new a.a((byte)0);
    AppMethodBeat.o(200528);
  }
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(200527);
    this.pTr = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.xJu = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xJv = new Rect(0, 0, ar.ci(aj.getContext()).x, ar.ci(aj.getContext()).y);
    this.xJx = new RectF();
    this.xJy = new RectF();
    this.xJz = new Matrix();
    this.xJA = com.tencent.mm.cc.a.fromDPToPix(paramContext, 4);
    Object localObject = ViewConfiguration.get(paramContext);
    p.g(localObject, "ViewConfiguration.get(context)");
    this.rW = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.xJB = d.g.O((d.g.a.a)new a.e(this));
    this.xJC = d.g.O((d.g.a.a)new a.c(this));
    this.xJD = d.g.O((d.g.a.a)new a.b(this));
    this.xJE = d.g.O((d.g.a.a)new a.d(this, paramContext));
    this.xJG = com.tencent.mm.cc.a.fromDPToPix(getContext(), 32);
    this.xJH = (com.tencent.mm.cc.a.ip(paramContext) - com.tencent.mm.cc.a.ax(paramContext, 2131165281));
    this.pTB = new float[2];
    this.xJL = ((Runnable)new a.g(this));
    setEnableFling(false);
    if (p.i(Looper.myLooper(), Looper.getMainLooper())) {
      getTouchDetector().setIsLongpressEnabled(false);
    }
    LayoutInflater.from(paramContext).inflate(2131496498, (ViewGroup)this, true);
    LayoutInflater.from(paramContext).inflate(2131496497, (ViewGroup)this, true);
    localObject = findViewById(2131308238);
    p.g(localObject, "findViewById(R.id.caption_float_comment)");
    this.xJF = ((View)localObject);
    getCaptionView().setText((CharSequence)com.tencent.mm.cc.a.az(paramContext, 2131767202));
    setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(200527);
  }
  
  private void dHr()
  {
    AppMethodBeat.i(200525);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.xJx.right;
    LinearLayout localLinearLayout = getCaptionContentLayout();
    p.g(localLinearLayout, "captionContentLayout");
    arrayOfFloat[1] = localLinearLayout.getBottom();
    this.xJz.mapPoints(arrayOfFloat);
    float f = this.xJu.bottom - this.xJG - arrayOfFloat[1];
    if (f < 0.0F)
    {
      this.xJz.postTranslate(0.0F, f);
      this.xJF.setVisibility(0);
    }
    AppMethodBeat.o(200525);
  }
  
  private static float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(200521);
    p.h(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(200521);
    return f;
  }
  
  private final LinearLayout getCaptionContentLayout()
  {
    AppMethodBeat.i(200504);
    LinearLayout localLinearLayout = (LinearLayout)this.xJD.getValue();
    AppMethodBeat.o(200504);
    return localLinearLayout;
  }
  
  private final RelativeLayout getCaptionLayout()
  {
    AppMethodBeat.i(200503);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.xJC.getValue();
    AppMethodBeat.o(200503);
    return localRelativeLayout;
  }
  
  private final LinearLayout getCaptionLoadingLayout()
  {
    AppMethodBeat.i(200505);
    LinearLayout localLinearLayout = (LinearLayout)this.xJE.getValue();
    AppMethodBeat.o(200505);
    return localLinearLayout;
  }
  
  private final PhotoTextView getCaptionView()
  {
    AppMethodBeat.i(200502);
    PhotoTextView localPhotoTextView = (PhotoTextView)this.xJB.getValue();
    AppMethodBeat.o(200502);
    return localPhotoTextView;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(200517);
    p.h(paramRect, "displayRect");
    this.xJv.set(paramRect);
    this.pTr.width = paramRect.width();
    this.xJx.right = paramRect.width();
    measure(0, 0);
    Object localObject = getCaptionLayout();
    p.g(localObject, "captionLayout");
    int i = ((RelativeLayout)localObject).getMeasuredHeight();
    localObject = getCaptionContentLayout();
    p.g(localObject, "captionContentLayout");
    paramFloat = (i + ((LinearLayout)localObject).getMeasuredHeight()) / 2.0F;
    paramFloat = this.xJu.bottom - paramFloat - this.xJG;
    this.pTr.o(new float[] { 0.0F, 0.0F, this.pTr.width, 0.0F, 0.0F, this.pTr.height, this.pTr.width, this.pTr.height });
    this.xJz.postTranslate(0.0F, paramFloat);
    dHs();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "topMargin:" + paramFloat + " width:" + paramRect.width());
    AppMethodBeat.o(200517);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(200508);
    p.h(paramc, "captionItem");
    this.xJt = paramc;
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    PhotoTextView localPhotoTextView1;
    if (!TextUtils.isEmpty((CharSequence)paramc.xNN))
    {
      localPhotoTextView1 = getCaptionView();
      p.g(localPhotoTextView1, "captionView");
      localPhotoTextView1.setTypeface(Typeface.createFromFile(paramc.xNN));
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "updateCaptionItem caption:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(200508);
      return;
      localPhotoTextView1 = getCaptionView();
      PhotoTextView localPhotoTextView2 = getCaptionView();
      p.g(localPhotoTextView2, "captionView");
      localPhotoTextView1.setTypeface(localPhotoTextView2.getTypeface(), 1);
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(200506);
    p.h(paramd, "type");
    Object localObject = this.xJt;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).xNC; localObject == paramd; localObject = null)
    {
      AppMethodBeat.o(200506);
      return true;
    }
    AppMethodBeat.o(200506);
    return false;
  }
  
  public final boolean avO(String paramString)
  {
    AppMethodBeat.i(200529);
    p.h(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(200529);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(200514);
    p.h(paramRect, "safeRect");
    this.pTr.xul = paramRect;
    this.pTr.xQl = com.tencent.mm.cc.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(200514);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a ckw()
  {
    AppMethodBeat.i(200513);
    Object localObject1 = this.xJt;
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
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).xNC, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).xNM, (Matrix)localObject2);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).xNN = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).xNN;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).textColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).textColor;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).bgColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).bgColor;
      localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2;
      AppMethodBeat.o(200513);
      return localObject1;
    }
    AppMethodBeat.o(200513);
    return null;
  }
  
  public final void dHs()
  {
    AppMethodBeat.i(200526);
    this.xJz.mapRect(this.xJy, this.xJx);
    float[] arrayOfFloat = new float[9];
    this.xJz.getValues(arrayOfFloat);
    float f = e(this.xJz);
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
    AppMethodBeat.o(200526);
  }
  
  public final boolean dHt()
  {
    return true;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(200512);
    p.h(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipRect(this.xJu);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(200512);
  }
  
  public final d.g.a.b<View, z> getClearCaptionListener()
  {
    return this.xJJ;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(200519);
    float[] arrayOfFloat = (float[])this.pTr.xQq.clone();
    AppMethodBeat.o(200519);
    return arrayOfFloat;
  }
  
  public final rt getCurrentCaption()
  {
    AppMethodBeat.i(200511);
    Object localObject = this.xJt;
    if (localObject != null)
    {
      long l = this.xJI;
      localObject = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).xNM).iterator();
      while (((Iterator)localObject).hasNext())
      {
        rt localrt = (rt)((Iterator)localObject).next();
        if ((localrt.FNR <= l) && (localrt.FNS >= l))
        {
          AppMethodBeat.o(200511);
          return localrt;
        }
      }
      AppMethodBeat.o(200511);
      return null;
    }
    AppMethodBeat.o(200511);
    return null;
  }
  
  public final RectF getDrawRect()
  {
    return this.xJy;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData()
  {
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)this.xJt;
  }
  
  public final boolean getEnableEdit()
  {
    return this.xJK;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(200515);
    Rect localRect = this.pTr.xul;
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
    AppMethodBeat.o(200515);
    return localObject;
  }
  
  public final int getTouchSlop()
  {
    return this.rW;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.pTr;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    AppMethodBeat.i(200520);
    if (a(d.xNV))
    {
      localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.xQO;
      AppMethodBeat.o(200520);
      return localb;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.view.b localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.xQN;
    AppMethodBeat.o(200520);
    return localb;
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(200523);
    p.h(paramScaleGestureDetector, "detector");
    float f1 = paramScaleGestureDetector.getFocusY();
    float f2 = 1.0F - paramScaleGestureDetector.getScaleFactor();
    this.xJz.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor());
    this.xJz.postTranslate(this.xJx.centerX() * f2, f1 * f2);
    dHr();
    dHs();
    AppMethodBeat.o(200523);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(200524);
    p.h(paramMotionEvent1, "e1");
    p.h(paramMotionEvent2, "e2");
    this.xJz.postTranslate(0.0F, -paramFloat2);
    dHr();
    dHs();
    AppMethodBeat.o(200524);
    return true;
  }
  
  public final boolean onTouch(View paramView, final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(200522);
    p.h(paramView, "v");
    p.h(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.gmE)
    {
      Object localObject1;
      if ((paramMotionEvent.getAction() != 3) || (paramMotionEvent.getAction() != 1))
      {
        bringToFront();
        if (this.xJK) {
          getCaptionView().setBackgroundDrawable(com.tencent.mm.cc.a.l(getContext(), 2131235032));
        }
        localObject1 = this.xJw;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).c((View)this, paramMotionEvent);
        }
        aq.aA(this.xJL);
        aq.o(this.xJL, 1500L);
      }
      boolean bool = super.onTouch(paramView, paramMotionEvent);
      AppMethodBeat.o(200522);
      return bool;
      this.gmI = paramMotionEvent.getX();
      this.gmJ = paramMotionEvent.getY();
      if (this.xJy.contains(this.gmI, this.gmJ)) {
        this.gmE = true;
      }
      this.gmF = false;
      this.pTB[0] = (this.xJx.width() / 2.0F);
      this.pTB[1] = (this.xJx.height() / 2.0F);
      this.xJz.mapPoints(this.pTB);
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.gmI), Math.abs(paramMotionEvent.getY() - this.gmJ));
      if (!this.gmF)
      {
        if (f > this.rW) {}
        for (bool = true;; bool = false)
        {
          this.gmF = bool;
          break;
        }
        this.gmE = false;
        this.xJF.setVisibility(4);
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        Object localObject2 = this.xJu;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXF = 0.5F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aXE = 3.0F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).n(new float[] { this.xJx.width() / 2.0F, this.xJx.height() / 2.0F });
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
        localObject2 = new float[2];
        localObject2[0] = (this.xJx.width() / 2.0F);
        localObject2[1] = (this.xJx.height() / 2.0F);
        this.xJz.mapPoints((float[])localObject2);
        if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).xPV.contains(localObject2[0], localObject2[1])) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.pTB[0], this.pTB[1], this.pTB[0], this.pTB[1]));
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.xJz, (m)new f(this, paramMotionEvent));
      }
    }
    AppMethodBeat.o(200522);
    return false;
  }
  
  public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(200507);
    p.h(paramc, "captionItem");
    this.xJt = paramc;
    getCaptionLayout().measure(0, 0);
    Object localObject1 = this.pTr;
    Object localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((com.tencent.mm.plugin.recordvideo.ui.editor.c.c)localObject1).height = ((RelativeLayout)localObject2).getMeasuredHeight();
    localObject1 = this.xJx;
    localObject2 = getCaptionLayout();
    p.g(localObject2, "captionLayout");
    ((RectF)localObject1).bottom = ((RelativeLayout)localObject2).getMeasuredHeight();
    dHs();
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.xNN))
    {
      localObject1 = getCaptionView();
      p.g(localObject1, "captionView");
      ((PhotoTextView)localObject1).setTypeface(Typeface.createFromFile(paramc.xNN));
    }
    for (;;)
    {
      localObject1 = new StringBuilder("height:");
      localObject2 = getCaptionView();
      p.g(localObject2, "captionView");
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", ((PhotoTextView)localObject2).getMeasuredHeight() + " caption:" + paramc);
      AppMethodBeat.o(200507);
      return;
      localObject1 = getCaptionView();
      localObject2 = getCaptionView();
      p.g(localObject2, "captionView");
      ((PhotoTextView)localObject1).setTypeface(((PhotoTextView)localObject2).getTypeface(), 1);
    }
  }
  
  public final void setClearCaptionListener(d.g.a.b<? super View, z> paramb)
  {
    this.xJJ = paramb;
  }
  
  public final void setEnableEdit(boolean paramBoolean)
  {
    this.xJK = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(200518);
    super.setOnClickListener(paramOnClickListener);
    this.cMV = paramOnClickListener;
    AppMethodBeat.o(200518);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(200509);
    p.h(paramb, "stateResolve");
    this.xJw = paramb;
    AppMethodBeat.o(200509);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(200516);
    p.h(paramRect, "validRect");
    this.xJu.set(paramRect);
    dHr();
    dHs();
    Object localObject = this.xJF.getLayoutParams();
    if (localObject == null)
    {
      paramRect = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(200516);
      throw paramRect;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).topMargin != paramRect.bottom - this.xJG)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (paramRect.bottom - this.xJG);
      this.xJF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(200516);
  }
  
  public final boolean yJ(long paramLong)
  {
    AppMethodBeat.i(200510);
    this.xJI = paramLong;
    Object localObject1 = this.xJt;
    Object localObject2;
    label57:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).yM(paramLong);
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = ((rt)localObject1).FNQ;
      if (localObject2 == null) {
        break label278;
      }
      localObject2 = ((com.tencent.mm.bx.b)localObject2).toString("UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label341;
      }
      setVisibility(0);
      getCaptionView().setAutoSizeTextTypeWithDefaults(0);
      PhotoTextView localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)"");
      getCaptionView().setTextSize(0, com.tencent.mm.cc.a.ax(getContext(), 2131165467));
      getCaptionView().setAutoSizeTextTypeWithDefaults(1);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setVisibility(0);
      localPhotoTextView = getCaptionView();
      p.g(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)localObject2);
      if (localObject1 == null) {
        p.gfZ();
      }
      if (((rt)localObject1).FNT) {
        break label284;
      }
      bool = true;
      label195:
      this.xJK = bool;
      if (this.xJK) {
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
      AppMethodBeat.o(200510);
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
    AppMethodBeat.o(200510);
    return false;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class f
    extends q
    implements m<Matrix, Boolean, z>
  {
    f(a parama, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */