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
import com.tencent.mm.plugin.recordvideo.ui.editor.item.h;
import com.tencent.mm.plugin.recordvideo.ui.editor.view.d.a;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.cropview.TouchEventLayout;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView;", "Lcom/tencent/mm/ui/widget/cropview/TouchEventLayout;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/IEditable;", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/IEditView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alignDiff", "", "captionContentLayout", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "getCaptionContentLayout", "()Landroid/widget/LinearLayout;", "captionContentLayout$delegate", "Lkotlin/Lazy;", "captionFloatCommentHint", "Landroid/view/View;", "captionItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/CaptionItem;", "captionLayout", "Landroid/widget/RelativeLayout;", "getCaptionLayout", "()Landroid/widget/RelativeLayout;", "captionLayout$delegate", "captionLoadingLayout", "getCaptionLoadingLayout", "captionLoadingLayout$delegate", "captionView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "getCaptionView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "captionView$delegate", "clearCaptionListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "", "getClearCaptionListener", "()Lkotlin/jvm/functions/Function1;", "setClearCaptionListener", "(Lkotlin/jvm/functions/Function1;)V", "clickListener", "Landroid/view/View$OnClickListener;", "commentHintHeight", "currentTimeMs", "", "displayRect", "Landroid/graphics/Rect;", "drawMatrix", "Landroid/graphics/Matrix;", "drawRect", "Landroid/graphics/RectF;", "enableEdit", "", "getEnableEdit", "()Z", "setEnableEdit", "(Z)V", "minLength", "originPivot", "", "selectChecker", "Ljava/lang/Runnable;", "stateResolve", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorItemContainer$ItemStateResolve;", "touchAligned", "touchDownX", "", "touchDownY", "touchMoved", "touchSlop", "getTouchSlop", "()I", "touchTracker", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "getTouchTracker", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/touch/TouchTracker;", "touched", "validRect", "viewRect", "applyMatrix", "checkMatrix", "contentValid", "currentMs", "createEditorData", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/BaseEditorData;", "createEditorItem", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/draw/BaseEditorItem;", "matrix", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "editMode", "getContentBoundary", "getCurrentCaption", "Lcom/tencent/mm/protocal/protobuf/CCTransResult;", "getDrawRect", "getEditorData", "getSafeArea", "getScale", "getType", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/view/EditItemType;", "isCaptionType", "type", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/item/EditorDataType;", "onScale", "detector", "Landroid/view/ScaleGestureDetector;", "onScroll", "e1", "Landroid/view/MotionEvent;", "e2", "distanceX", "distanceY", "onTouch", "v", "event", "setCaptionItem", "setDefaultLocation", "heightPercent", "setOnClickListener", "l", "setSafeArea", "safeRect", "damp", "setStateResolve", "setValidArea", "showAtTime", "updateCaptionItem", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends TouchEventLayout
  implements h, com.tencent.mm.plugin.recordvideo.ui.editor.view.d
{
  public static final a.a NTM;
  public com.tencent.mm.plugin.recordvideo.ui.editor.item.c NTN;
  private final Rect NTO;
  private final Rect NTP;
  private EditorItemContainer.b NTQ;
  private final RectF NTR;
  private final RectF NTS;
  private final Matrix NTT;
  private final int NTU;
  private final j NTV;
  private final j NTW;
  private final j NTX;
  private final j NTY;
  private final View NTZ;
  private final int NUa;
  private long NUb;
  private kotlin.g.a.b<? super View, ah> NUc;
  private boolean NUd;
  private final Runnable NUe;
  private final int doK;
  private View.OnClickListener fhU;
  private final int minLength;
  private boolean mkg;
  private boolean mkh;
  private float mkk;
  private float mkl;
  private final com.tencent.mm.plugin.recordvideo.ui.editor.c.c yiZ;
  private final float[] yji;
  
  static
  {
    AppMethodBeat.i(279937);
    NTM = new a.a((byte)0);
    AppMethodBeat.o(279937);
  }
  
  public a(final Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(279896);
    this.yiZ = new com.tencent.mm.plugin.recordvideo.ui.editor.c.c();
    this.NTO = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NTP = new Rect(0, 0, bf.bf(MMApplicationContext.getContext()).x, bf.bf(MMApplicationContext.getContext()).y);
    this.NTR = new RectF();
    this.NTS = new RectF();
    this.NTT = new Matrix();
    this.NTU = com.tencent.mm.cd.a.fromDPToPix(paramContext, 4);
    this.doK = ViewConfiguration.get(paramContext).getScaledTouchSlop();
    this.NTV = k.cm((kotlin.g.a.a)new e(this));
    this.NTW = k.cm((kotlin.g.a.a)new c(this));
    this.NTX = k.cm((kotlin.g.a.a)new b(this));
    this.NTY = k.cm((kotlin.g.a.a)new d(this, paramContext));
    this.NUa = com.tencent.mm.cd.a.fromDPToPix(getContext(), 32);
    this.minLength = (com.tencent.mm.cd.a.ms(paramContext) - com.tencent.mm.cd.a.br(paramContext, b.c.Edge_16A));
    this.yji = new float[2];
    this.NUe = new a..ExternalSyntheticLambda0(this);
    setEnableFling(false);
    if (s.p(Looper.myLooper(), Looper.getMainLooper())) {
      getTouchDetector().setIsLongpressEnabled(false);
    }
    LayoutInflater.from(paramContext).inflate(b.f.video_editor_caption_view, (ViewGroup)this, true);
    LayoutInflater.from(paramContext).inflate(b.f.video_editor_caption_comment_hint, (ViewGroup)this, true);
    View localView = findViewById(b.e.caption_float_comment);
    s.s(localView, "findViewById(R.id.caption_float_comment)");
    this.NTZ = localView;
    getCaptionView().setText((CharSequence)com.tencent.mm.cd.a.bt(paramContext, b.h.video_caption_hint));
    setOnTouchListener((View.OnTouchListener)this);
    AppMethodBeat.o(279896);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(279925);
    s.u(parama, "this$0");
    parama.getCaptionView().setBackgroundDrawable(null);
    AppMethodBeat.o(279925);
  }
  
  private static float g(Matrix paramMatrix)
  {
    AppMethodBeat.i(279916);
    s.u(paramMatrix, "matrix");
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    double d1 = arrayOfFloat[0];
    double d2 = arrayOfFloat[3];
    float f = (float)Math.sqrt(d2 * d2 + d1 * d1);
    AppMethodBeat.o(279916);
    return f;
  }
  
  private void gJQ()
  {
    AppMethodBeat.i(279920);
    float[] arrayOfFloat = new float[2];
    arrayOfFloat[0] = this.NTR.right;
    arrayOfFloat[1] = getCaptionContentLayout().getBottom();
    this.NTT.mapPoints(arrayOfFloat);
    float f = this.NTO.bottom - this.NUa - arrayOfFloat[1];
    if (f < 0.0F)
    {
      this.NTT.postTranslate(0.0F, f);
      this.NTZ.setVisibility(0);
    }
    AppMethodBeat.o(279920);
  }
  
  private final LinearLayout getCaptionContentLayout()
  {
    AppMethodBeat.i(279905);
    LinearLayout localLinearLayout = (LinearLayout)this.NTX.getValue();
    AppMethodBeat.o(279905);
    return localLinearLayout;
  }
  
  private final RelativeLayout getCaptionLayout()
  {
    AppMethodBeat.i(279900);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.NTW.getValue();
    AppMethodBeat.o(279900);
    return localRelativeLayout;
  }
  
  private final LinearLayout getCaptionLoadingLayout()
  {
    AppMethodBeat.i(279908);
    LinearLayout localLinearLayout = (LinearLayout)this.NTY.getValue();
    AppMethodBeat.o(279908);
    return localLinearLayout;
  }
  
  private final PhotoTextView getCaptionView()
  {
    AppMethodBeat.i(279898);
    PhotoTextView localPhotoTextView = (PhotoTextView)this.NTV.getValue();
    AppMethodBeat.o(279898);
    return localPhotoTextView;
  }
  
  public final void a(Rect paramRect, float paramFloat)
  {
    AppMethodBeat.i(280036);
    s.u(paramRect, "displayRect");
    this.NTP.set(paramRect);
    this.yiZ.width = paramRect.width();
    this.NTR.right = paramRect.width();
    measure(0, 0);
    paramFloat = (getCaptionLayout().getMeasuredHeight() + getCaptionContentLayout().getMeasuredHeight()) / 2.0F;
    e locale = e.NDU;
    paramFloat = e.getVisibleRect().bottom - paramFloat - this.NUa;
    this.yiZ.x(new float[] { 0.0F, 0.0F, this.yiZ.width, 0.0F, 0.0F, this.yiZ.height, this.yiZ.width, this.yiZ.height });
    this.NTT.postTranslate(0.0F, paramFloat);
    gJR();
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "topMargin:" + paramFloat + " width:" + paramRect.width());
    AppMethodBeat.o(280036);
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(279986);
    s.u(paramc, "captionItem");
    this.NTN = paramc;
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.mAD)) {
      if (y.ZC(paramc.mAD)) {
        getCaptionView().setTypeface(Typeface.createFromFile(paramc.mAD));
      }
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", s.X("updateCaptionItem caption:", paramc));
      AppMethodBeat.o(279986);
      return;
      getCaptionView().setTypeface(Typeface.DEFAULT);
      continue;
      getCaptionView().setTypeface(getCaptionView().getTypeface(), 1);
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.recordvideo.ui.editor.item.d paramd)
  {
    AppMethodBeat.i(279972);
    s.u(paramd, "type");
    Object localObject = this.NTN;
    if (localObject == null) {}
    for (localObject = null; localObject == paramd; localObject = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject).NXP)
    {
      AppMethodBeat.o(279972);
      return true;
    }
    AppMethodBeat.o(279972);
    return false;
  }
  
  public final boolean aTn(String paramString)
  {
    AppMethodBeat.i(280108);
    boolean bool = d.a.a(this, paramString);
    AppMethodBeat.o(280108);
    return bool;
  }
  
  public final void b(Rect paramRect, int paramInt)
  {
    AppMethodBeat.i(280027);
    s.u(paramRect, "safeRect");
    this.yiZ.NDV = paramRect;
    this.yiZ.Oah = com.tencent.mm.cd.a.fromDPToPix(getContext(), paramInt);
    AppMethodBeat.o(280027);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a dEP()
  {
    AppMethodBeat.i(280024);
    Object localObject1 = this.NTN;
    if (localObject1 != null)
    {
      Object localObject2 = new Matrix();
      ((Matrix)localObject2).postScale(getCaptionLayout().getScaleX(), getCaptionLayout().getScaleY());
      int[] arrayOfInt = new int[2];
      getCaptionLayout().getLocationOnScreen(arrayOfInt);
      ((Matrix)localObject2).postTranslate(0.0F, arrayOfInt[1]);
      localObject2 = new com.tencent.mm.plugin.recordvideo.ui.editor.item.c(((com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject1).NXP, ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).NYc, (Matrix)localObject2);
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).mAD = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).mAD;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).textColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).textColor;
      ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject2).bgColor = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).bgColor;
      localObject1 = (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)localObject2;
      AppMethodBeat.o(280024);
      return localObject1;
    }
    AppMethodBeat.o(280024);
    return null;
  }
  
  protected final void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(280011);
    s.u(paramCanvas, "canvas");
    paramCanvas.save();
    paramCanvas.clipRect(this.NTO);
    super.dispatchDraw(paramCanvas);
    paramCanvas.restore();
    AppMethodBeat.o(280011);
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a.a e(Matrix paramMatrix)
  {
    return null;
  }
  
  public final void gJR()
  {
    AppMethodBeat.i(280084);
    this.NTT.mapRect(this.NTS, this.NTR);
    float[] arrayOfFloat = new float[9];
    this.NTT.getValues(arrayOfFloat);
    float f = g(this.NTT);
    getCaptionLayout().setPivotX(0.0F);
    getCaptionLayout().setPivotY(0.0F);
    getCaptionLayout().setScaleX(f);
    getCaptionLayout().setScaleY(f);
    getCaptionLayout().setTranslationX(arrayOfFloat[2]);
    getCaptionLayout().setTranslationY(arrayOfFloat[5]);
    AppMethodBeat.o(280084);
  }
  
  public final boolean gJS()
  {
    AppMethodBeat.i(280102);
    s.u(this, "this");
    AppMethodBeat.o(280102);
    return true;
  }
  
  public final kotlin.g.a.b<View, ah> getClearCaptionListener()
  {
    return this.NUc;
  }
  
  public final float[] getContentBoundary()
  {
    AppMethodBeat.i(280044);
    float[] arrayOfFloat = (float[])this.yiZ.Oam.clone();
    AppMethodBeat.o(280044);
    return arrayOfFloat;
  }
  
  public final uq getCurrentCaption()
  {
    AppMethodBeat.i(280005);
    Object localObject = this.NTN;
    if (localObject != null)
    {
      long l = this.NUb;
      localObject = ((Iterable)((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject).NYc).iterator();
      while (((Iterator)localObject).hasNext())
      {
        uq localuq = (uq)((Iterator)localObject).next();
        if ((localuq.YZX <= l) && (localuq.YZY >= l))
        {
          AppMethodBeat.o(280005);
          return localuq;
        }
      }
    }
    AppMethodBeat.o(280005);
    return null;
  }
  
  public final RectF getDrawRect()
  {
    return this.NTS;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.item.a getEditorData()
  {
    return (com.tencent.mm.plugin.recordvideo.ui.editor.item.a)this.NTN;
  }
  
  public final boolean getEnableEdit()
  {
    return this.NUd;
  }
  
  public final Rect getSafeArea()
  {
    AppMethodBeat.i(280030);
    Rect localRect = this.yiZ.NDV;
    if (localRect == null)
    {
      localRect = new Rect(0, 0, getResources().getDisplayMetrics().widthPixels, getResources().getDisplayMetrics().heightPixels);
      AppMethodBeat.o(280030);
      return localRect;
    }
    AppMethodBeat.o(280030);
    return localRect;
  }
  
  public final int getTouchSlop()
  {
    return this.doK;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.c.c getTouchTracker()
  {
    return this.yiZ;
  }
  
  public final com.tencent.mm.plugin.recordvideo.ui.editor.view.b getType()
  {
    AppMethodBeat.i(280047);
    if (a(com.tencent.mm.plugin.recordvideo.ui.editor.item.d.NYj))
    {
      localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaK;
      AppMethodBeat.o(280047);
      return localb;
    }
    com.tencent.mm.plugin.recordvideo.ui.editor.view.b localb = com.tencent.mm.plugin.recordvideo.ui.editor.view.b.OaJ;
    AppMethodBeat.o(280047);
    return localb;
  }
  
  public final boolean onScale(ScaleGestureDetector paramScaleGestureDetector)
  {
    AppMethodBeat.i(280066);
    s.u(paramScaleGestureDetector, "detector");
    float f1 = paramScaleGestureDetector.getFocusY();
    float f2 = 1.0F - paramScaleGestureDetector.getScaleFactor();
    this.NTT.postScale(paramScaleGestureDetector.getScaleFactor(), paramScaleGestureDetector.getScaleFactor());
    this.NTT.postTranslate(this.NTR.centerX() * f2, f1 * f2);
    gJQ();
    gJR();
    AppMethodBeat.o(280066);
    return true;
  }
  
  public final boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(280075);
    s.u(paramMotionEvent1, "e1");
    s.u(paramMotionEvent2, "e2");
    this.NTT.postTranslate(0.0F, -paramFloat2);
    gJQ();
    gJR();
    AppMethodBeat.o(280075);
    return true;
  }
  
  public final boolean onTouch(View paramView, final MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(280061);
    s.u(paramView, "v");
    s.u(paramMotionEvent, "event");
    switch (paramMotionEvent.getActionMasked())
    {
    }
    while (this.mkg)
    {
      Object localObject1;
      if ((paramMotionEvent.getAction() != 3) || (paramMotionEvent.getAction() != 1))
      {
        bringToFront();
        if (this.NUd) {
          getCaptionView().setBackgroundDrawable(com.tencent.mm.cd.a.m(getContext(), b.d.bg_edit_white_line));
        }
        localObject1 = this.NTQ;
        if (localObject1 != null) {
          ((EditorItemContainer.b)localObject1).l((View)this, paramMotionEvent);
        }
        MMHandlerThread.removeRunnable(this.NUe);
        MMHandlerThread.postToMainThreadDelayed(this.NUe, 1500L);
      }
      boolean bool = super.onTouch(paramView, paramMotionEvent);
      AppMethodBeat.o(280061);
      return bool;
      this.mkk = paramMotionEvent.getX();
      this.mkl = paramMotionEvent.getY();
      if (this.NTS.contains(this.mkk, this.mkl)) {
        this.mkg = true;
      }
      this.mkh = false;
      this.yji[0] = (this.NTR.width() / 2.0F);
      this.yji[1] = (this.NTR.height() / 2.0F);
      this.NTT.mapPoints(this.yji);
      continue;
      float f = Math.max(Math.abs(paramMotionEvent.getX() - this.mkk), Math.abs(paramMotionEvent.getY() - this.mkl));
      if (!this.mkh)
      {
        if (f > this.doK) {}
        for (bool = true;; bool = false)
        {
          this.mkh = bool;
          break;
        }
        this.mkg = false;
        this.NTZ.setVisibility(4);
        localObject1 = new com.tencent.mm.plugin.recordvideo.ui.editor.c.a();
        Object localObject2 = this.NTO;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).minScale = 0.5F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).maxScale = 3.0F;
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).w(new float[] { this.NTR.width() / 2.0F, this.NTR.height() / 2.0F });
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(((Rect)localObject2).left, ((Rect)localObject2).top, ((Rect)localObject2).right, ((Rect)localObject2).bottom));
        localObject2 = new float[2];
        localObject2[0] = (this.NTR.width() / 2.0F);
        localObject2[1] = (this.NTR.height() / 2.0F);
        this.NTT.mapPoints((float[])localObject2);
        if (!((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).NZY.contains(localObject2[0], localObject2[1])) {
          ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).g(new RectF(this.yji[0], this.yji[1], this.yji[0], this.yji[1]));
        }
        ((com.tencent.mm.plugin.recordvideo.ui.editor.c.a)localObject1).a(this.NTT, (m)new f(this, paramMotionEvent));
      }
    }
    AppMethodBeat.o(280061);
    return false;
  }
  
  public final void setCaptionItem(com.tencent.mm.plugin.recordvideo.ui.editor.item.c paramc)
  {
    AppMethodBeat.i(279980);
    s.u(paramc, "captionItem");
    this.NTN = paramc;
    getCaptionLayout().measure(0, 0);
    this.yiZ.height = getCaptionLayout().getMeasuredHeight();
    this.NTR.bottom = getCaptionLayout().getMeasuredHeight();
    gJR();
    if (paramc.textColor != 0) {
      getCaptionView().setTextColor(paramc.textColor);
    }
    getCaptionView().setTextBackground(paramc.bgColor);
    if (!TextUtils.isEmpty((CharSequence)paramc.mAD)) {
      if (y.ZC(paramc.mAD)) {
        getCaptionView().setTypeface(Typeface.createFromFile(paramc.mAD));
      }
    }
    for (;;)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.CaptionItemView", "height:" + getCaptionView().getMeasuredHeight() + " caption:" + paramc);
      AppMethodBeat.o(279980);
      return;
      getCaptionView().setTypeface(Typeface.DEFAULT);
      continue;
      getCaptionView().setTypeface(getCaptionView().getTypeface(), 1);
    }
  }
  
  public final void setClearCaptionListener(kotlin.g.a.b<? super View, ah> paramb)
  {
    this.NUc = paramb;
  }
  
  public final void setEnableEdit(boolean paramBoolean)
  {
    this.NUd = paramBoolean;
  }
  
  public final void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(280041);
    super.setOnClickListener(paramOnClickListener);
    this.fhU = paramOnClickListener;
    AppMethodBeat.o(280041);
  }
  
  public final void setStateResolve(EditorItemContainer.b paramb)
  {
    AppMethodBeat.i(279994);
    s.u(paramb, "stateResolve");
    this.NTQ = paramb;
    AppMethodBeat.o(279994);
  }
  
  public final void setValidArea(Rect paramRect)
  {
    AppMethodBeat.i(280033);
    s.u(paramRect, "validRect");
    this.NTO.set(paramRect);
    gJQ();
    gJR();
    Object localObject = this.NTZ.getLayoutParams();
    if (localObject == null)
    {
      paramRect = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(280033);
      throw paramRect;
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    if (((ViewGroup.MarginLayoutParams)localObject).topMargin != paramRect.bottom - this.NUa)
    {
      ((ViewGroup.MarginLayoutParams)localObject).topMargin = (paramRect.bottom - this.NUa);
      this.NTZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(280033);
  }
  
  public final boolean tA(long paramLong)
  {
    AppMethodBeat.i(280001);
    this.NUb = paramLong;
    Object localObject1 = this.NTN;
    Object localObject2;
    label33:
    boolean bool;
    if (localObject1 == null)
    {
      localObject2 = null;
      if (localObject2 != null) {
        break label196;
      }
      localObject1 = null;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label260;
      }
      setVisibility(0);
      getCaptionView().setAutoSizeTextTypeWithDefaults(0);
      getCaptionView().setText((CharSequence)"");
      getCaptionView().setTextSize(0, com.tencent.mm.cd.a.br(getContext(), b.c.HugeTextSize));
      getCaptionView().setAutoSizeTextTypeWithDefaults(1);
      getCaptionView().setVisibility(0);
      getCaptionView().setText((CharSequence)localObject1);
      s.checkNotNull(localObject2);
      if (((uq)localObject2).YZZ) {
        break label227;
      }
      bool = true;
      label132:
      this.NUd = bool;
      if (this.NUd) {
        break label232;
      }
      getCaptionView().setBackgroundDrawable(null);
      com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set INVISIBLE");
      getCaptionContentLayout().setVisibility(4);
      getCaptionLoadingLayout().setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(280001);
      return true;
      localObject2 = ((com.tencent.mm.plugin.recordvideo.ui.editor.item.c)localObject1).tB(paramLong);
      break;
      label196:
      localObject1 = ((uq)localObject2).YZW;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label33;
      }
      localObject1 = ((com.tencent.mm.bx.b)localObject1).toString("UTF-8");
      break label33;
      label227:
      bool = false;
      break label132;
      label232:
      com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it not empty, not enableEdit, set VISIBLE");
      getCaptionContentLayout().setVisibility(0);
      getCaptionLoadingLayout().setVisibility(4);
    }
    label260:
    com.tencent.mm.audio.mix.h.b.d("MicroMsg.CaptionItemView", "text it empty, set INVISIBLE");
    setVisibility(4);
    AppMethodBeat.o(280001);
    return false;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    b(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<LinearLayout>
  {
    d(a parama, Context paramContext)
    {
      super();
    }
    
    private static final void a(a parama, View paramView)
    {
      AppMethodBeat.i(280183);
      Object localObject = new Object();
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(parama);
      localb.cH(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
      s.u(parama, "this$0");
      paramView = parama.getParent();
      if (paramView == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(280183);
        throw parama;
      }
      ((ViewGroup)paramView).removeView((View)parama);
      paramView = parama.getClearCaptionListener();
      if (paramView != null) {
        paramView.invoke(parama);
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/recordvideo/ui/editor/CaptionItemView$captionLoadingLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(280183);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/PhotoTextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<PhotoTextView>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "m", "Landroid/graphics/Matrix;", "animateFinish", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements m<Matrix, Boolean, ah>
  {
    f(a parama, MotionEvent paramMotionEvent)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.a
 * JD-Core Version:    0.7.0.1
 */