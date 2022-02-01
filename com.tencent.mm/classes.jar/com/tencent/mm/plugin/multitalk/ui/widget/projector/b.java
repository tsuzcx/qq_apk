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
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.ui.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.xweb.h.b;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "", "context", "Landroid/content/Context;", "statusManager", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "config", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "(Landroid/content/Context;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "value", "", "currentPageIndex", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "editorPlugin", "Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "getEditorPlugin", "()Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;", "setEditorPlugin", "(Lcom/tencent/mm/plugin/multitalk/ui/editor/MultiTalkScreenEditContainerPlugin;)V", "isShowEditContainer", "", "mCurrentPageHeight", "getMCurrentPageHeight", "setMCurrentPageHeight", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "", "mCurrentScale", "setMCurrentScale", "(F)V", "mCurrentViewStatus", "Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "getMCurrentViewStatus", "()Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;", "setMCurrentViewStatus", "(Lcom/tencent/xweb/FileReaderXWeb$ViewStatus;)V", "mFilePath", "", "getMFilePath", "()Ljava/lang/String;", "setMFilePath", "(Ljava/lang/String;)V", "mStrokeLayout", "Landroid/widget/FrameLayout;", "getMStrokeLayout", "()Landroid/widget/FrameLayout;", "setMStrokeLayout", "(Landroid/widget/FrameLayout;)V", "mToken", "getMToken", "setMToken", "maxPageIndex", "getMaxPageIndex", "setMaxPageIndex", "onSwitchReaderPageCallback", "Lkotlin/Function1;", "", "getOnSwitchReaderPageCallback", "()Lkotlin/jvm/functions/Function1;", "setOnSwitchReaderPageCallback", "(Lkotlin/jvm/functions/Function1;)V", "getStatusManager", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "setStatusManager", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;)V", "clearScreen", "doEnterDoodle", "getScreenBitmap", "canvas", "Landroid/graphics/Canvas;", "loadDoodle", "onViewStatusChange", "zoom", "transX", "transY", "refreshDoodleLayout", "isLand", "refreshEditLayout", "Lcom/tencent/mm/media/widget/camerarecordview/data/MediaCaptureInfo;", "callback", "Lkotlin/Function0;", "setDrawingEnable", "enable", "setView", "newScale", "left", "top", "needCorrect", "setXWeb", "show", "Companion", "plugin-multitalk_release"})
public final class b
{
  public static final b.a zVR;
  private Context context;
  String mFilePath;
  String mToken;
  int vfW;
  private a zQD;
  private e zQw;
  FrameLayout zVI;
  float zVJ;
  int zVK;
  int zVL;
  h.b zVM;
  int zVN;
  com.tencent.mm.plugin.multitalk.ui.a.b zVO;
  kotlin.g.a.b<? super Integer, x> zVP;
  boolean zVQ;
  
  static
  {
    AppMethodBeat.i(239908);
    zVR = new b.a((byte)0);
    AppMethodBeat.o(239908);
  }
  
  public b(Context paramContext, a parama, e parame)
  {
    AppMethodBeat.i(239907);
    this.context = paramContext;
    this.zQD = parama;
    this.zQw = parame;
    this.zVJ = 1.0F;
    this.zVK = -1;
    this.zVL = -1;
    this.zVI = new FrameLayout(this.context);
    this.zVO = new com.tencent.mm.plugin.multitalk.ui.a.b(this.context, this.zQD, this.zQw);
    paramContext = this.zVO;
    if (paramContext != null) {
      paramContext.setDrawingEnable(false);
    }
    paramContext = this.zVI;
    if (paramContext != null) {
      paramContext.addView((View)this.zVO);
    }
    paramContext = this.zVI;
    if (paramContext != null)
    {
      paramContext.setVisibility(8);
      AppMethodBeat.o(239907);
      return;
    }
    AppMethodBeat.o(239907);
  }
  
  public final void a(com.tencent.mm.media.widget.camerarecordview.b.b paramb, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(239901);
    p.h(paramb, "config");
    com.tencent.mm.plugin.multitalk.ui.a.b localb = this.zVO;
    if (localb != null)
    {
      p.h(paramb, "config");
      com.tencent.mm.plugin.multitalk.ui.a.a locala = localb.zQC;
      localb.zQD.epf();
      p.h(paramb, "config");
      if (!locala.zQs)
      {
        locala.b(paramb);
        paramb = locala.zQo;
        if (paramb != null)
        {
          paramb = (com.tencent.mm.view.b.b)paramb.getBaseBoardView();
          if (paramb != null)
          {
            paramb.hgd();
            paramb.invalidate();
            paramb.uGD = parama;
            paramb.RnM = true;
            AppMethodBeat.o(239901);
          }
        }
      }
      else
      {
        paramb = paramb.rect;
        if (paramb != null) {}
        for (paramb = paramb.toShortString();; paramb = null)
        {
          Log.printInfoStack("MicroMsg.MultiTalkEditPhotoContainerPlugin", "config is %s", new Object[] { paramb });
          break;
        }
      }
      AppMethodBeat.o(239901);
      return;
    }
    AppMethodBeat.o(239901);
  }
  
  public final void epj()
  {
    AppMethodBeat.i(239903);
    com.tencent.mm.plugin.multitalk.ui.a.b localb = this.zVO;
    if (localb != null)
    {
      localb.zQB.onClick(null);
      AppMethodBeat.o(239903);
      return;
    }
    AppMethodBeat.o(239903);
  }
  
  public final void epk()
  {
    AppMethodBeat.i(239904);
    Object localObject = this.zVO;
    if (localObject != null)
    {
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).zQC;
      ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).zQq = null;
      localObject = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject).zQo;
      if (localObject != null)
      {
        localObject = (com.tencent.mm.view.b.b)((com.tencent.mm.view.l)localObject).getBaseBoardView();
        if (localObject != null)
        {
          ((com.tencent.mm.view.b.b)localObject).getPresenter().gtl();
          ((com.tencent.mm.view.b.b)localObject).postInvalidate();
          AppMethodBeat.o(239904);
          return;
        }
      }
      AppMethodBeat.o(239904);
      return;
    }
    AppMethodBeat.o(239904);
  }
  
  public final void sc(boolean paramBoolean)
  {
    AppMethodBeat.i(239906);
    Object localObject1 = this.zVO;
    if (localObject1 != null)
    {
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).zQB;
      localObject1 = ((d)localObject2).zQG;
      ((RelativeLayout)localObject1).removeAllViews();
      localObject2 = ((d)localObject2).zQF;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.recordvideo.plugin.doodle.b)localObject2).a(paramBoolean, (RelativeLayout)localObject1);
        AppMethodBeat.o(239906);
        return;
      }
      AppMethodBeat.o(239906);
      return;
    }
    AppMethodBeat.o(239906);
  }
  
  public final void show()
  {
    AppMethodBeat.i(239900);
    FrameLayout localFrameLayout = this.zVI;
    if (localFrameLayout != null)
    {
      localFrameLayout.setVisibility(0);
      AppMethodBeat.o(239900);
      return;
    }
    AppMethodBeat.o(239900);
  }
  
  public final void t(Canvas paramCanvas)
  {
    AppMethodBeat.i(239905);
    p.h(paramCanvas, "canvas");
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    paramCanvas.setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
    Object localObject1 = this.zVO;
    int i;
    int j;
    label103:
    float f;
    Object localObject2;
    if (localObject1 != null)
    {
      i = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getHeight();
      localObject1 = this.zVO;
      if (localObject1 == null) {
        break label221;
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).getMultiTalkEditPhotoWrapper();
      if (localObject1 == null) {
        break label221;
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.a)localObject1).zQo;
      if (localObject1 == null) {
        break label221;
      }
      j = ((com.tencent.mm.view.l)localObject1).getHeight();
      f = i - j;
      localObject1 = this.zVO;
      if (localObject1 == null) {
        break label388;
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).zQC.zQo;
      if (localObject2 == null) {
        break label227;
      }
      i = ((com.tencent.mm.view.l)localObject2).getWidth();
      label141:
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).zQC.zQo;
      if (localObject2 == null) {
        break label232;
      }
      j = ((com.tencent.mm.view.l)localObject2).getHeight();
      label163:
      if ((i > 0) && (j > 0)) {
        break label238;
      }
    }
    for (localObject1 = null;; localObject1 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap)
    {
      if (localObject1 == null) {
        break label388;
      }
      localObject2 = new Matrix();
      ((Matrix)localObject2).postTranslate(0.0F, f / 2.0F);
      paramCanvas.drawBitmap((Bitmap)localObject1, (Matrix)localObject2, localPaint);
      AppMethodBeat.o(239905);
      return;
      i = 0;
      break;
      label221:
      j = 0;
      break label103;
      label227:
      i = 0;
      break label141;
      label232:
      j = 0;
      break label163;
      label238:
      if ((((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap == null) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth != i) || (((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight != j))
      {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mWidth = i;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).mHeight = j;
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).bitmap;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = new Canvas((Bitmap)localObject2);
      ((Canvas)localObject2).drawPaint(new Paint());
      ((Canvas)localObject2).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
      ((Canvas)localObject2).drawColor(0, PorterDuff.Mode.CLEAR);
      com.tencent.mm.view.l locall = ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject1).zQC.zQo;
      if (locall != null) {
        locall.draw((Canvas)localObject2);
      }
    }
    label388:
    AppMethodBeat.o(239905);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.b
 * JD-Core Version:    0.7.0.1
 */