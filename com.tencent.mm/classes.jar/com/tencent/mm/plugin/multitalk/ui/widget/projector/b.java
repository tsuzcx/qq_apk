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
import com.tencent.mm.plugin.multitalk.ui.a.c;
import com.tencent.mm.view.l;
import com.tencent.xweb.j.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "value", "", "currentPageIndex", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "editorPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "getEditorPlugin", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "setEditorPlugin", "(Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;)V", "isShowEditContainer", "", "mCurrentPageHeight", "getMCurrentPageHeight", "setMCurrentPageHeight", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "", "mCurrentScale", "setMCurrentScale", "(F)V", "mCurrentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFilePath", "", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "mStrokeLayout", "Landroid/widget/FrameLayout;", "getMStrokeLayout", "()Landroid/widget/FrameLayout;", "setMStrokeLayout", "(Landroid/widget/FrameLayout;)V", "mToken", "getMToken", "setMToken", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "onSwitchReaderPageCallback", "Lkotlin/Function1;", "", "getOnSwitchReaderPageCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchReaderPageCallback", "(Lkotlin/jvm/functions/Function1;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "doEnterDoodle", "getScreenBitmap", "canvas", "Landroid/graphics/Canvas;", "loadDoodle", "onViewStatusChange", "zoom", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "setView", "newScale", "left", "top", "needCorrect", "setXWeb", "show", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a Lxv;
  int FsK;
  private e Lsc;
  private a Lsq;
  j.b LxA;
  com.tencent.mm.plugin.multitalk.ui.a.b LxB;
  kotlin.g.a.b<? super Integer, ah> LxC;
  boolean LxD;
  FrameLayout Lxw;
  float Lxx;
  int Lxy;
  int Lxz;
  private Context context;
  String mFilePath;
  String mToken;
  int yag;
  
  static
  {
    AppMethodBeat.i(285682);
    Lxv = new b.a((byte)0);
    AppMethodBeat.o(285682);
  }
  
  public b(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(285676);
    this.context = paramContext;
    this.Lsq = parama;
    this.Lsc = parame;
    this.Lxx = 1.0F;
    this.Lxy = -1;
    this.Lxz = -1;
    this.Lxw = new FrameLayout(this.context);
    this.LxB = new com.tencent.mm.plugin.multitalk.ui.a.b(this.context, this.Lsq, this.Lsc);
    paramContext = this.LxB;
    if (paramContext != null) {
      paramContext.setDrawingEnable(false);
    }
    paramContext = this.Lxw;
    if (paramContext != null) {
      paramContext.addView((View)this.LxB);
    }
    paramContext = this.Lxw;
    if (paramContext != null) {
      paramContext.setVisibility(8);
    }
    AppMethodBeat.o(285676);
  }
  
  public final void ghY()
  {
    AppMethodBeat.i(285688);
    com.tencent.mm.plugin.multitalk.ui.a.b localb = this.LxB;
    if (localb != null) {
      localb.Lsr.onClick(null);
    }
    AppMethodBeat.o(285688);
  }
  
  public final void ghZ()
  {
    AppMethodBeat.i(285700);
    Object localObject = this.LxB;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).Lss;
      ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).Lsh = null;
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).Lsf;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.view.b.b)((l)localObject).getBaseBoardView();
        if (localObject != null)
        {
          ((com.tencent.mm.view.b.b)localObject).getPresenter().iPr();
          ((com.tencent.mm.view.b.b)localObject).postInvalidate();
        }
      }
    }
    AppMethodBeat.o(285700);
  }
  
  public final void q(Canvas paramCanvas)
  {
    AppMethodBeat.i(285714);
    s.u(paramCanvas, "canvas");
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    paramCanvas.setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
    Object localObject1 = this.LxB;
    int j;
    int i;
    label69:
    float f;
    Object localObject2;
    if (localObject1 == null)
    {
      j = 0;
      localObject1 = this.LxB;
      if (localObject1 != null) {
        break label183;
      }
      i = 0;
      f = j - i;
      localObject1 = this.LxB;
      if (localObject1 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Lss.Lsf;
        if (localObject2 != null) {
          break label226;
        }
        i = 0;
        label103:
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Lss.Lsf;
        if (localObject2 != null) {
          break label235;
        }
        j = 0;
        label121:
        if ((i > 0) && (j > 0)) {
          break label245;
        }
      }
    }
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap)
    {
      if (localObject1 != null)
      {
        localObject2 = new Matrix();
        ((Matrix)localObject2).postTranslate(0.0F, f / 2.0F);
        paramCanvas.drawBitmap((Bitmap)localObject1, (Matrix)localObject2, localPaint);
      }
      AppMethodBeat.o(285714);
      return;
      j = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getHeight();
      break;
      label183:
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getMultiTalkEditPhotoWrapper();
      if (localObject1 == null)
      {
        i = 0;
        break label69;
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject1).Lsf;
      if (localObject1 == null)
      {
        i = 0;
        break label69;
      }
      i = ((l)localObject1).getHeight();
      break label69;
      label226:
      i = ((l)localObject2).getWidth();
      break label103;
      label235:
      j = ((l)localObject2).getHeight();
      break label121;
      label245:
      if ((((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap == null) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth != i) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight != j))
      {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth = i;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight = j;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap;
      s.checkNotNull(localObject2);
      localObject2 = new Canvas((Bitmap)localObject2);
      ((Canvas)localObject2).drawPaint(new Paint());
      ((Canvas)localObject2).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
      ((Canvas)localObject2).drawColor(0, PorterDuff.Mode.CLEAR);
      l locall = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Lss.Lsf;
      if (locall != null) {
        locall.draw((Canvas)localObject2);
      }
    }
  }
  
  public final void zs(boolean paramBoolean)
  {
    AppMethodBeat.i(285724);
    Object localObject1 = this.LxB;
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).Lsr;
      localObject1 = ((c)localObject2).Lsv;
      ((RelativeLayout)localObject1).removeAllViews();
      localObject2 = ((c)localObject2).Lsu;
      if (localObject2 != null) {
        ((com.tencent.mm.plugin.recordvideo.plugin.doodle.b)localObject2).a(paramBoolean, (RelativeLayout)localObject1);
      }
    }
    AppMethodBeat.o(285724);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.b
 * JD-Core Version:    0.7.0.1
 */