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
import com.tencent.mm.plugin.recordvideo.b.c;
import com.tencent.mm.plugin.recordvideo.b.d;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.b.h;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.EditorItemContainer.b;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.d;
import com.tencent.mm.plugin.recordvideo.ui.editor.item.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.c.a;
import com.tencent.mm.protocal.protobuf.ta;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import kotlin.f;
import kotlin.g;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"})
public final class a
  extends TouchEventLayout
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.c
{
  public static final a HXu;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.c HXc;
  private final Rect HXd;
  private final Rect HXe;
  private EditorItemContainer.b HXf;
  private final RectF HXg;
  private final RectF HXh;
  private final Matrix HXi;
  private final int HXj;
  private final f HXk;
  private final f HXl;
  private final f HXm;
  private final f HXn;
  private final View HXo;
  private final int HXp;
  private long HXq;
  private kotlin.g.a.b<? super View, x> HXr;
  private boolean HXs;
  private final Runnable HXt;
  private final int bvH;
  private View.OnClickListener dig;
  private boolean jKU;
  private boolean jKV;
  private float jKY;
  private float jKZ;
  private final int minLength;
  private final float[] uWJ;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c uWz;
  
  static
  {
    AppMethodBeat.i(226267);
    HXu = new a((byte)0);
    AppMethodBeat.o(226267);
  }
  
  public a(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(226266);
    this.uWz = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.HXd = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.HXe = new Rect(0, 0, ax.au(MMApplicationContext.getContext()).x, ax.au(MMApplicationContext.getContext()).y);
    this.HXg = new RectF();
    this.HXh = new RectF();
    this.HXi = new Matrix();
    this.HXj = com.tencent.mm.ci.a.fromDPToPix(paramContext, 4);
    Object localObject = ViewConfiguration.get(paramContext);
    p.j(localObject, "ViewConfiguration.get(context)");
    this.bvH = ((ViewConfiguration)localObject).getScaledTouchSlop();
    this.HXk = g.ar((kotlin.g.a.a)new e(this));
    this.HXl = g.ar((kotlin.g.a.a)new c(this));
    this.HXm = g.ar((kotlin.g.a.a)new b(this));
    this.HXn = g.ar((kotlin.g.a.a)new d(this, paramContext));
    this.HXp = com.tencent.mm.ci.a.fromDPToPix(getContext(), 32);
    this.minLength = (com.tencent.mm.ci.a.kr(paramContext) - com.tencent.mm.ci.a.aY(paramContext, b.c.Edge_16A));
    this.uWJ = new float[2];
    this.HXt = ((Runnable)new g(this));
    setEnableFling(false);
    if (p.h(Looper.myLooper(), Looper.getMainLooper())) {
      getTouchDetector().setIsLongpressEnabled(false);
    }
    LayoutInflater.from(paramContext).inflate(b.f.video_editor_caption_view, (ViewGroup)this, true);
    LayoutInflater.from(paramContext).inflate(b.f.video_editor_caption_comment_hint, (ViewGroup)this, true);
    localObject = findViewById(b.e.caption_float_comment);
    p.j(localObject, "findViewById(R.id.caption_float_comment)");
    this.HXo = ((View)localObject);
    getCaptionView().setText((CharSequence)com.tencent.mm.ci.a.ba(paramContext, b.h.video_caption_hint));
    setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(226266);
  }
  
  private static float e(Matrix paramMatrix)
  {
    AppMethodBeat.i(226234);
    p.k(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(226234);
    return f;
  }
  
  private void fyd()
  {
    AppMethodBeat.i(226255);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.HXg.right;
    LinearLayout localLinearLayout = getCaptionContentLayout();
    p.j(localLinearLayout, "captionContentLayout");
    arrayOfFloat[1] = localLinearLayout.getBottom();
    this.HXi.mapPoints(arrayOfFloat);
    float f = this.HXd.bottom - this.HXp - arrayOfFloat[1];
    if (f < 0.0F)
    {
      this.HXi.postTranslate(0.0F, f);
      this.HXo.setVisibility(0);
    }
    AppMethodBeat.o(226255);
  }
  
  private final LinearLayout getCaptionContentLayout()
  {
    AppMethodBeat.i(226172);
    LinearLayout localLinearLayout = (LinearLayout)this.HXm.getValue();
    AppMethodBeat.o(226172);
    return localLinearLayout;
  }
  
  private final RelativeLayout getCaptionLayout()
  {
    AppMethodBeat.i(226171);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.HXl.getValue();
    AppMethodBeat.o(226171);
    return localRelativeLayout;
  }
  
  private final LinearLayout getCaptionLoadingLayout()
  {
    AppMethodBeat.i(226174);
    LinearLayout localLinearLayout = (LinearLayout)this.HXn.getValue();
    AppMethodBeat.o(226174);
    return localLinearLayout;
  }
  
  private final PhotoTextView getCaptionView()
  {
    AppMethodBeat.i(226169);
    PhotoTextView localPhotoTextView = (PhotoTextView)this.HXk.getValue();
    AppMethodBeat.o(226169);
    return localPhotoTextView;
  }
  
  public final boolean PA(long paramLong)
  {
    AppMethodBeat.i(226194);
    this.HXq = paramLong;
    Object localObject1 = this.HXc;
    Object localObject2;
    label57:
    boolean bool;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).PB(paramLong);
      if (localObject1 == null) {
        break label278;
      }
      localObject2 = ((ta)localObject1).Sce;
      if (localObject2 == null) {
        break label278;
      }
      localObject2 = ((com.tencent.mm.cd.b)localObject2).toString("UTF-8");
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        break label341;
      }
      setVisibility(0);
      getCaptionView().setAutoSizeTextTypeWithDefaults(0);
      PhotoTextView localPhotoTextView = getCaptionView();
      p.j(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)"");
      getCaptionView().setTextSize(0, com.tencent.mm.ci.a.aY(getContext(), b.c.HugeTextSize));
      getCaptionView().setAutoSizeTextTypeWithDefaults(1);
      localPhotoTextView = getCaptionView();
      p.j(localPhotoTextView, "captionView");
      localPhotoTextView.setVisibility(0);
      localPhotoTextView = getCaptionView();
      p.j(localPhotoTextView, "captionView");
      localPhotoTextView.setText((CharSequence)localObject2);
      if (localObject1 == null) {
        p.iCn();
      }
      if (((ta)localObject1).Sch) {
        break label284;
      }
      bool = true;
      label195:
      this.HXs = bool;
      if (this.HXs) {
        break label289;
      }
      getCaptionView().setBackgroundDrawable(null);
      com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set INVISIBLE");
      localObject1 = getCaptionContentLayout();
      p.j(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(4);
      localObject1 = getCaptionLoadingLayout();
      p.j(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(226194);
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
      p.j(localObject1, "captionContentLayout");
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = getCaptionLoadingLayout();
      p.j(localObject1, "captionLoadingLayout");
      ((LinearLayout)localObject1).setVisibility(4);
    }
    label341:
    com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it empty, set INVISIBLE");
    setVisibility(4);
    AppMethodBeat.o(226194);
    return false;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(226227);
    p.k(paramRect, "displayRect");
    this.HXe.set(paramRect);
    this.uWz.width = paramRect.width();
    this.HXg.right = paramRect.width();
    measure(0, 0);
    Object localObject = getCaptionLayout();
    p.j(localObject, "captionLayout");
    int i = ((RelativeLayout)localObject).getMeasuredHeight();
    localObject = getCaptionContentLayout();
    p.j(localObject, "captionContentLayout");
    paramFloat = (i + ((LinearLayout)localObject).getMeasuredHeight()) / 2.0F;
    localObject = e.HGz;
    paramFloat = e.getVisibleRect().bottom - paramFloat - this.HXp;
    this.uWz.p(new float[] { 0.0F, 0.0F, this.uWz.width, 0.0F, 0.0F, this.uWz.height, this.uWz.width, this.uWz.height });
    this.HXi.postTranslate(0.0F, paramFloat);
    fye();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "topMargin:" + paramFloat + " width:" + paramRect.width());
    AppMethodBeat.o(226227);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(226185);
    p.k(paramc, "captionItem");
    this.HXc = paramc;
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    PhotoTextView localPhotoTextView1;
    if (!TextUtils.isEmpty((CharSequence)paramc.IbE)) {
      if (u.agG(paramc.IbE))
      {
        localPhotoTextView1 = getCaptionView();
        p.j(localPhotoTextView1, "captionView");
        localPhotoTextView1.setTypeface(Typeface.createFromFile(paramc.IbE));
      }
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "updateCaptionItem caption:".concat(String.valueOf(paramc)));
      AppMethodBeat.o(226185);
      return;
      localPhotoTextView1 = getCaptionView();
      p.j(localPhotoTextView1, "captionView");
      localPhotoTextView1.setTypeface(Typeface.DEFAULT);
      continue;
      localPhotoTextView1 = getCaptionView();
      PhotoTextView localPhotoTextView2 = getCaptionView();
      p.j(localPhotoTextView2, "captionView");
      localPhotoTextView1.setTypeface(localPhotoTextView2.getTypeface(), 1);
    }
  }
  
  public final boolean a(d paramd)
  {
    AppMethodBeat.i(226177);
    p.k(paramd, "type");
    Object localObject = this.HXc;
    if (localObject != null) {}
    for (localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).Ibt; localObject == paramd; localObject = null)
    {
      AppMethodBeat.o(226177);
      return true;
    }
    AppMethodBeat.o(226177);
    return false;
  }
  
  public final boolean aWf(String paramString)
  {
    AppMethodBeat.i(226268);
    p.k(paramString, "objID");
    boolean bool = c.a.a(this, paramString);
    AppMethodBeat.o(226268);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(226201);
    p.k(paramRect, "safeRect");
    this.uWz.HGw = paramRect;
    this.uWz.IdR = com.tencent.mm.ci.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(226201);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a c(Matrix paramMatrix)
  {
    return null;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a cYy()
  {
    AppMethodBeat.i(226200);
    Object localObject1 = this.HXc;
    if (localObject1 != null)
    {
      Object localObject2 = new Matrix();
      Object localObject3 = getCaptionLayout();
      p.j(localObject3, "captionLayout");
      float f = ((RelativeLayout)localObject3).getScaleX();
      localObject3 = getCaptionLayout();
      p.j(localObject3, "captionLayout");
      ((Matrix)localObject2).postScale(f, ((RelativeLayout)localObject3).getScaleY());
      localObject3 = new int[2];
      getCaptionLayout().getLocationOnScreen((int[])localObject3);
      ((Matrix)localObject2).postTranslate(0.0F, localObject3[1]);
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).Ibt, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).IbD, (Matrix)localObject2);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).IbE = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).IbE;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).textColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).textColor;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).bgColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).bgColor;
      localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2;
      AppMethodBeat.o(226200);
      return localObject1;
    }
    AppMethodBeat.o(226200);
    return null;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(226197);
    p.k(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipRect(this.HXd);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(226197);
  }
  
  public final void fye()
  {
    AppMethodBeat.i(226259);
    this.HXi.mapRect(this.HXh, this.HXg);
    float[] arrayOfFloat = new float[9];
    this.HXi.getValues(arrayOfFloat);
    float f = e(this.HXi);
    RelativeLayout localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setPivotX(0.0F);
    localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setPivotY(0.0F);
    localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setScaleX(f);
    localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setScaleY(f);
    localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setTranslationX(arrayOfFloat[2]);
    localRelativeLayout = getCaptionLayout();
    p.j(localRelativeLayout, "captionLayout");
    localRelativeLayout.setTranslationY(arrayOfFloat[5]);
    AppMethodBeat.o(226259);
  }
  
  public final boolean fyf()
  {
    return true;
  }
  
  public final kotlin.g.a.b<View, x> getClearCaptionListener()
  {
    return this.HXr;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(226230);
    float[] arrayOfFloat = (float[])this.uWz.IdW.clone();
    AppMethodBeat.o(226230);
    return arrayOfFloat;
  }
  
  public final ta getCurrentCaption()
  {
    AppMethodBeat.i(226196);
    Object localObject = this.HXc;
    if (localObject != null)
    {
      long l = this.HXq;
      localObject = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).IbD).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ta localta = (ta)((Iterator)localObject).next();
        if ((localta.Scf <= l) && (localta.Scg >= l))
        {
          AppMethodBeat.o(226196);
          return localta;
        }
      }
      AppMethodBeat.o(226196);
      return null;
    }
    AppMethodBeat.o(226196);
    return null;
  }
  
  public final RectF getDrawRect()
  {
    return this.HXh;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData()
  {
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)this.HXc;
  }
  
  public final boolean getEnableEdit()
  {
    return this.HXs;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(226203);
    Rect localRect = this.uWz.HGw;
    Object localObject = localRect;
    if (localRect == null)
    {
      localObject = getResources();
      p.j(localObject, "resources");
      int i = ((Resources)localObject).getDisplayMetrics().widthPixels;
      localObject = getResources();
      p.j(localObject, "resources");
      localObject = new Rect(0, 0, i, ((Resources)localObject).getDisplayMetrics().heightPixels);
    }
    AppMethodBeat.o(226203);
    return localObject;
  }
  
  public final int getTouchSlop()
  {
    return this.bvH;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.uWz;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    AppMethodBeat.i(226232);
    if (a(d.IbM))
    {
      localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Ieu;
      AppMethodBeat.o(226232);
      return localb;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.view.b localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.Iet;
    AppMethodBeat.o(226232);
    return localb;
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(226250);
    p.k(paramScaleGestureDetector, "detector");
    float f1 = paramScaleGestureDetector.getFocusY();
    float f2 = 1.0F - paramScaleGestureDetector.getScaleFactor();
    this.HXi.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor());
    this.HXi.postTranslate(this.HXg.centerX() * f2, f1 * f2);
    fyd();
    fye();
    AppMethodBeat.o(226250);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(226252);
    p.k(paramMotionEvent1, "e1");
    p.k(paramMotionEvent2, "e2");
    this.HXi.postTranslate(0.0F, -paramFloat2);
    fyd();
    fye();
    AppMethodBeat.o(226252);
    return true;
  }
  
  public final boolean onTouch(View paramView, final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(226248);
    p.k(paramView, "v");
    p.k(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.jKU)
    {
      Object localObject1;
      if ((paramMotionEvent.getAction() != 3) || (paramMotionEvent.getAction() != 1))
      {
        bringToFront();
        if (this.HXs) {
          getCaptionView().setBackgroundDrawable(com.tencent.mm.ci.a.m(getContext(), b.d.bg_edit_white_line));
        }
        localObject1 = this.HXf;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).e((View)this, paramMotionEvent);
        }
        MMHandlerThread.removeRunnable(this.HXt);
        MMHandlerThread.postToMainThreadDelayed(this.HXt, 1500L);
      }
      boolean bool = super.onTouch(paramView, paramMotionEvent);
      AppMethodBeat.o(226248);
      return bool;
      this.jKY = paramMotionEvent.getX();
      this.jKZ = paramMotionEvent.getY();
      if (this.HXh.contains(this.jKY, this.jKZ)) {
        this.jKU = true;
      }
      this.jKV = false;
      this.uWJ[0] = (this.HXg.width() / 2.0F);
      this.uWJ[1] = (this.HXg.height() / 2.0F);
      this.HXi.mapPoints(this.uWJ);
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.jKY), Math.abs(paramMotionEvent.getY() - this.jKZ));
      if (!this.jKV)
      {
        if (f > this.bvH) {}
        for (bool = true;; bool = false)
        {
          this.jKV = bool;
          break;
        }
        this.jKU = false;
        this.HXo.setVisibility(4);
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        Object localObject2 = this.HXd;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGO = 0.5F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).aGN = 3.0F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).o(new float[] { this.HXg.width() / 2.0F, this.HXg.height() / 2.0F });
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
        localObject2 = new float[2];
        localObject2[0] = (this.HXg.width() / 2.0F);
        localObject2[1] = (this.HXg.height() / 2.0F);
        this.HXi.mapPoints((float[])localObject2);
        if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).IdC.contains(localObject2[0], localObject2[1])) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).f(new RectF(this.uWJ[0], this.uWJ[1], this.uWJ[0], this.uWJ[1]));
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.HXi, (m)new f(this, paramMotionEvent));
      }
    }
    AppMethodBeat.o(226248);
    return false;
  }
  
  public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(226182);
    p.k(paramc, "captionItem");
    this.HXc = paramc;
    getCaptionLayout().measure(0, 0);
    Object localObject1 = this.uWz;
    Object localObject2 = getCaptionLayout();
    p.j(localObject2, "captionLayout");
    ((com.tencent.mm.plugin.recordvideo.ui.editor.c.c)localObject1).height = ((RelativeLayout)localObject2).getMeasuredHeight();
    localObject1 = this.HXg;
    localObject2 = getCaptionLayout();
    p.j(localObject2, "captionLayout");
    ((RectF)localObject1).bottom = ((RelativeLayout)localObject2).getMeasuredHeight();
    fye();
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.IbE)) {
      if (u.agG(paramc.IbE))
      {
        localObject1 = getCaptionView();
        p.j(localObject1, "captionView");
        ((PhotoTextView)localObject1).setTypeface(Typeface.createFromFile(paramc.IbE));
      }
    }
    for (;;)
    {
      localObject1 = new StringBuilder("height:");
      localObject2 = getCaptionView();
      p.j(localObject2, "captionView");
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", ((PhotoTextView)localObject2).getMeasuredHeight() + " caption:" + paramc);
      AppMethodBeat.o(226182);
      return;
      localObject1 = getCaptionView();
      p.j(localObject1, "captionView");
      ((PhotoTextView)localObject1).setTypeface(Typeface.DEFAULT);
      continue;
      localObject1 = getCaptionView();
      localObject2 = getCaptionView();
      p.j(localObject2, "captionView");
      ((PhotoTextView)localObject1).setTypeface(((PhotoTextView)localObject2).getTypeface(), 1);
    }
  }
  
  public final void setClearCaptionListener(kotlin.g.a.b<? super View, x> paramb)
  {
    this.HXr = paramb;
  }
  
  public final void setEnableEdit(boolean paramBoolean)
  {
    this.HXs = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(226229);
    super.setOnClickListener(paramOnClickListener);
    this.dig = paramOnClickListener;
    AppMethodBeat.o(226229);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(226187);
    p.k(paramb, "stateResolve");
    this.HXf = paramb;
    AppMethodBeat.o(226187);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(226211);
    p.k(paramRect, "validRect");
    this.HXd.set(paramRect);
    fyd();
    fye();
    Object localObject = this.HXo.getLayoutParams();
    if (localObject == null)
    {
      paramRect = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(226211);
      throw paramRect;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).topMargin != paramRect.bottom - this.HXp)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (paramRect.bottom - this.HXp);
      this.HXo.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(226211);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$Companion;", "", "()V", "TAG", "", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<LinearLayout>
  {
    d(a parama, Context paramContext)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$1$1"})
    static final class a
      implements View.OnClickListener
    {
      a(a.d paramd) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(219205);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.HXw.HXv.getParent();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(219205);
          throw paramView;
        }
        ((ViewGroup)paramView).removeView((View)this.HXw.HXv);
        paramView = this.HXw.HXv.getClearCaptionListener();
        if (paramView != null) {
          paramView.invoke(this.HXw.HXv);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2$$special$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(219205);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<PhotoTextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", "", "invoke"})
  static final class f
    extends q
    implements m<Matrix, Boolean, x>
  {
    f(a parama, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(223575);
      a.c(this.HXv).setBackgroundDrawable(null);
      AppMethodBeat.o(223575);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */