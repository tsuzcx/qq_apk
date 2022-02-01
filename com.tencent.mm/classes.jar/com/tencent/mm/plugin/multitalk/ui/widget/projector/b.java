package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.a.d;
import com.tencent.xweb.h.b;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "value", "", "currentPageIndex", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "editorPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "getEditorPlugin", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "setEditorPlugin", "(Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;)V", "isShowEditContainer", "", "mCurrentPageHeight", "getMCurrentPageHeight", "setMCurrentPageHeight", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "", "mCurrentScale", "setMCurrentScale", "(F)V", "mCurrentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFilePath", "", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "mStrokeLayout", "Landroid/widget/FrameLayout;", "getMStrokeLayout", "()Landroid/widget/FrameLayout;", "setMStrokeLayout", "(Landroid/widget/FrameLayout;)V", "mToken", "getMToken", "setMToken", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "onSwitchReaderPageCallback", "Lkotlin/Function1;", "", "getOnSwitchReaderPageCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchReaderPageCallback", "(Lkotlin/jvm/functions/Function1;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "doEnterDoodle", "getScreenBitmap", "canvas", "Landroid/graphics/Canvas;", "loadDoodle", "onViewStatusChange", "zoom", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "setView", "newScale", "left", "top", "needCorrect", "setXWeb", "show", "Companion", "plugin-multitalk_release"})
public final class b
{
  public static final a FBB;
  boolean FBA;
  FrameLayout FBs;
  float FBt;
  int FBu;
  int FBv;
  h.b FBw;
  int FBx;
  com.tencent.mm.plugin.multitalk.ui.a.b FBy;
  kotlin.g.a.b<? super Integer, x> FBz;
  private e FvZ;
  private a Fwg;
  private Context context;
  String mFilePath;
  String mToken;
  int zXe;
  
  static
  {
    AppMethodBeat.i(196015);
    FBB = new a((byte)0);
    AppMethodBeat.o(196015);
  }
  
  public b(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(196013);
    this.context = paramContext;
    this.Fwg = parama;
    this.FvZ = parame;
    this.FBt = 1.0F;
    this.FBu = -1;
    this.FBv = -1;
    this.FBs = new FrameLayout(this.context);
    this.FBy = new com.tencent.mm.plugin.multitalk.ui.a.b(this.context, this.Fwg, this.FvZ);
    paramContext = this.FBy;
    if (paramContext != null) {
      paramContext.setDrawingEnable(false);
    }
    paramContext = this.FBs;
    if (paramContext != null) {
      paramContext.addView((View)this.FBy);
    }
    paramContext = this.FBs;
    if (paramContext != null)
    {
      paramContext.setVisibility(8);
      AppMethodBeat.o(196013);
      return;
    }
    AppMethodBeat.o(196013);
  }
  
  public final void eYZ()
  {
    AppMethodBeat.i(195988);
    com.tencent.mm.plugin.multitalk.ui.a.b localb = this.FBy;
    if (localb != null)
    {
      localb.Fwe.onClick(null);
      AppMethodBeat.o(195988);
      return;
    }
    AppMethodBeat.o(195988);
  }
  
  public final void eZa()
  {
    AppMethodBeat.i(195993);
    Object localObject = this.FBy;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).Fwf;
      ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).FvT = null;
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).FvR;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
        if (localObject != null)
        {
          ((com.tencent.mm.view.b.b)localObject).getPresenter().hox();
          ((com.tencent.mm.view.b.b)localObject).postInvalidate();
          AppMethodBeat.o(195993);
          return;
        }
      }
      AppMethodBeat.o(195993);
      return;
    }
    AppMethodBeat.o(195993);
  }
  
  public final void v(Canvas paramCanvas)
  {
    AppMethodBeat.i(196005);
    p.k(paramCanvas, "canvas");
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    paramCanvas.setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
    Object localObject1 = this.FBy;
    int i;
    int j;
    label101:
    float f;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getHeight();
      localObject1 = this.FBy;
      if (localObject1 == null) {
        break label218;
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getMultiTalkEditPhotoWrapper();
      if (localObject1 == null) {
        break label218;
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject1).FvR;
      if (localObject1 == null) {
        break label218;
      }
      j = ((com.tencent.mm.view.l)localObject1).getHeight();
      f = i - j;
      localObject1 = this.FBy;
      if (localObject1 == null) {
        break label385;
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Fwf.FvR;
      if (localObject2 == null) {
        break label224;
      }
      i = ((com.tencent.mm.view.l)localObject2).getWidth();
      label139:
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Fwf.FvR;
      if (localObject2 == null) {
        break label229;
      }
      j = ((com.tencent.mm.view.l)localObject2).getHeight();
      label161:
      if ((i > 0) && (j > 0)) {
        break label235;
      }
    }
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap)
    {
      if (localObject1 == null) {
        break label385;
      }
      localObject2 = new Matrix();
      ((Matrix)localObject2).postTranslate(0.0F, f / 2.0F);
      paramCanvas.drawBitmap((Bitmap)localObject1, (Matrix)localObject2, localPaint);
      AppMethodBeat.o(196005);
      return;
      i = 0;
      break;
      label218:
      j = 0;
      break label101;
      label224:
      i = 0;
      break label139;
      label229:
      j = 0;
      break label161;
      label235:
      if ((((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap == null) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth != i) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight != j))
      {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth = i;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight = j;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject2 = new Canvas((Bitmap)localObject2);
      ((Canvas)localObject2).drawPaint(new Paint());
      ((Canvas)localObject2).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
      ((Canvas)localObject2).drawColor(0, PorterDuff.Mode.CLEAR);
      com.tencent.mm.view.l locall = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Fwf.FvR;
      if (locall != null) {
        locall.draw((Canvas)localObject2);
      }
    }
    label385:
    AppMethodBeat.o(196005);
  }
  
  public final void ve(boolean paramBoolean)
  {
    AppMethodBeat.i(196007);
    Object localObject1 = this.FBy;
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Fwe;
      localObject1 = ((d)localObject2).Fwj;
      ((RelativeLayout)localObject1).removeAllViews();
      localObject2 = ((d)localObject2).Fwi;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.doodle.b)localObject2).a(paramBoolean, (RelativeLayout)localObject1);
        AppMethodBeat.o(196007);
        return;
      }
      AppMethodBeat.o(196007);
      return;
    }
    AppMethodBeat.o(196007);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout$Companion;", "", "()V", "TAG", "", "plugin-multitalk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.b
 * JD-Core Version:    0.7.0.1
 */