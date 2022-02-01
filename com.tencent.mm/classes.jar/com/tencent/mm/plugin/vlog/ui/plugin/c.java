package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.plugin.vlog.model.o;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.videocomposition.h;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.videocomposition.play.a.a.c;
import com.tencent.mm.view.e;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentType", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "setLayout", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "previewVideoMaxFpsLimit", "getPreviewVideoMaxFpsLimit", "setPreviewVideoMaxFpsLimit", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "videoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "calcOriginRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "", "currentVideoComposition", "flushSurface", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVideoView", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isLockMedia", "", "isPreviewingVideo", "onClick", "v", "Landroid/view/View;", "onDetach", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onPreviewVideo", "muteOrigin", "onUpdateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "pausePreview", "registerCallback", "callback", "release", "releaseVideo", "reset", "resumePreview", "seek", "startMs", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setLoop", "loop", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "showPlayView", "stopPreview", "unregisterCallback", "updateValidArea", "showTab", "videoPause", "videoResume", "Companion", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class c
  implements View.OnClickListener, t
{
  public static final c.a CeB;
  public com.tencent.mm.plugin.vlog.model.v BWB;
  public final RectF BWZ;
  public o Cca;
  public WxCropOperationLayout CeA;
  public final e Cee;
  public e Cef;
  public VideoCompositionPlayView Cep;
  private final LinkedList<b> Ceq;
  public CropLayout.c Cer;
  public int Ces;
  public long Cet;
  private long Ceu;
  private final w Cev;
  private final s Cew;
  private v Cex;
  public int Cey;
  public CropLayout Cez;
  private final Context context;
  public final ViewGroup gsV;
  private int oKa;
  final RectF tVK;
  private WxCropOperationLayout.j tVM;
  private long tVQ;
  private long tVr;
  d tbP;
  
  static
  {
    AppMethodBeat.i(191655);
    CeB = new c.a((byte)0);
    AppMethodBeat.o(191655);
  }
  
  public c(CropLayout paramCropLayout, WxCropOperationLayout paramWxCropOperationLayout, d paramd)
  {
    AppMethodBeat.i(191654);
    this.Cez = paramCropLayout;
    this.CeA = paramWxCropOperationLayout;
    this.tbP = paramd;
    this.context = this.Cez.getContext();
    paramCropLayout = this.Cez.getParent();
    if (paramCropLayout == null)
    {
      paramCropLayout = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(191654);
      throw paramCropLayout;
    }
    this.gsV = ((ViewGroup)paramCropLayout);
    this.BWZ = new RectF();
    this.Ceq = new LinkedList();
    this.tVr = -1L;
    this.tVK = new RectF();
    this.tVM = WxCropOperationLayout.j.xYQ;
    this.Cee = ((e)new l(this));
    this.Cey = -1;
    paramCropLayout = this.Cez;
    paramCropLayout.setHasBorder(false);
    paramCropLayout.setEnableScale(true);
    paramCropLayout.setEnableFling(true);
    paramCropLayout.setEnableTouch(true);
    paramCropLayout.setEnableOverScroll(false);
    this.Cez.setBackgroundColor(0);
    this.CeA.dKG();
    this.Cev = ((w)new w()
    {
      public final VideoCompositionPlayView ewO()
      {
        AppMethodBeat.i(191615);
        c.g(this.CeC);
        VideoCompositionPlayView localVideoCompositionPlayView = c.d(this.CeC);
        if (localVideoCompositionPlayView == null) {
          p.gkB();
        }
        AppMethodBeat.o(191615);
        return localVideoCompositionPlayView;
      }
      
      public final ViewGroup ewT()
      {
        AppMethodBeat.i(191614);
        ViewGroup localViewGroup = c.f(this.CeC);
        AppMethodBeat.o(191614);
        return localViewGroup;
      }
      
      public final CropLayout ewU()
      {
        return this.CeC.Cez;
      }
      
      public final void ewV()
      {
        AppMethodBeat.i(191616);
        d.b.a(this.CeC.tbP, d.c.xUO);
        AppMethodBeat.o(191616);
      }
      
      public final WxCropOperationLayout getOperationLayout()
      {
        return this.CeC.CeA;
      }
    });
    this.Cew = new s(this.Cev);
    a((b)this.Cew);
    ewN();
    this.CeA.xYp = false;
    this.CeA.setVisibility(8);
    this.CeA.setBlockOutsideTouch(true);
    AppMethodBeat.o(191654);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(191645);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(191645);
    return paramRect1;
  }
  
  private final void ewQ()
  {
    AppMethodBeat.i(191646);
    if (this.Cep == null)
    {
      this.Cep = new VideoCompositionPlayView(this.context);
      VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.setPlayerCallback((a.a.a)new f(this));
      }
      localVideoCompositionPlayView = this.Cep;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.setPlayerProfileCallback((a.a.c)new g());
        AppMethodBeat.o(191646);
        return;
      }
    }
    AppMethodBeat.o(191646);
  }
  
  private final boolean xV(long paramLong)
  {
    return (this.tVQ == paramLong) || (this.tVQ == 0L);
  }
  
  public final void BQ(long paramLong)
  {
    this.Cet = paramLong;
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(191634);
    p.h(paramb, "callback");
    if (!this.Ceq.contains(paramb)) {
      this.Ceq.add(paramb);
    }
    AppMethodBeat.o(191634);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    com.tencent.mm.plugin.vlog.model.v localv = null;
    AppMethodBeat.i(191641);
    ae.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + paramBoolean2 + ", seekToOriginPosition:" + paramBoolean3 + ", seekTo:" + paramLong);
    this.oKa = 2;
    ewQ();
    this.tVr = -1L;
    Object localObject1 = this.Cca;
    if (localObject1 != null)
    {
      localObject1 = ((o)localObject1).BWB;
      this.BWB = ((com.tencent.mm.plugin.vlog.model.v)localObject1);
      localObject1 = this.BWB;
      if (localObject1 != null) {
        if (paramBoolean1) {
          break label195;
        }
      }
    }
    label195:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).sX(paramBoolean1);
      localObject1 = this.BWB;
      if (localObject1 == null) {
        break label200;
      }
      localObject2 = ((Iterable)this.Ceq).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if ((localObject3 instanceof d)) {
          ((d)localObject3).a((com.tencent.mm.plugin.vlog.model.v)localObject1, paramLong, paramBoolean3);
        }
      }
      localObject1 = null;
      break;
    }
    label200:
    localObject1 = this.Cex;
    if (localObject1 != null) {
      ((v)localObject1).tb(false);
    }
    this.Cex = ((v)this.Cew);
    localObject1 = this.Cca;
    if (localObject1 != null)
    {
      localObject1 = ((o)localObject1).evz();
      localObject2 = this.Cex;
      if (localObject2 != null) {
        ((v)localObject2).a((Size)localObject1);
      }
    }
    this.Cew.Cef = this.Cef;
    localObject1 = this.Cex;
    if (localObject1 != null) {
      ((v)localObject1).tb(true);
    }
    this.CeA.setOnOperationCallback((WxCropOperationLayout.i)new k(this));
    this.Cez.setClickListener((View.OnClickListener)this);
    Object localObject2 = this.Cez;
    Object localObject3 = this.Cex;
    localObject1 = localv;
    if (localObject3 != null) {
      localObject1 = ((v)localObject3).exh();
    }
    ((CropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
    localObject1 = this.BWB;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).Uh(this.Cey);
    }
    localObject1 = this.Cex;
    if (localObject1 != null)
    {
      localv = this.BWB;
      if (localv == null) {
        p.gkB();
      }
      ((v)localObject1).a(localv, paramBoolean2, paramBoolean3, paramLong);
    }
    this.CeA.setVisibility(0);
    if (paramBoolean2)
    {
      localObject1 = this.Cef;
      if (localObject1 != null)
      {
        ((e)localObject1).resume();
        AppMethodBeat.o(191641);
        return;
      }
    }
    AppMethodBeat.o(191641);
  }
  
  public final g aEO(String paramString)
  {
    AppMethodBeat.i(191647);
    p.h(paramString, "path");
    Object localObject = this.Cca;
    if (localObject != null)
    {
      localObject = (List)((o)localObject).BWQ;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.i(((com.tencent.mm.plugin.vlog.model.w)localObject).path, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (com.tencent.mm.plugin.vlog.model.w)paramString;
      if (paramString != null)
      {
        localObject = paramString.BXT;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new g();
      }
      AppMethodBeat.o(191647);
      return paramString;
    }
  }
  
  public final boolean aoQ()
  {
    return false;
  }
  
  public final void aq(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191636);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.aq(paramLong1, paramLong2);
      AppMethodBeat.o(191636);
      return;
    }
    AppMethodBeat.o(191636);
  }
  
  public final void azm() {}
  
  public final void ewM()
  {
    this.Ceu = 0L;
  }
  
  public final void ewN()
  {
    AppMethodBeat.i(191632);
    int i = com.tencent.mm.cb.a.iu(this.context);
    float f1 = i;
    Object localObject = com.tencent.mm.plugin.vlog.util.a.CmB;
    float f3 = com.tencent.mm.plugin.vlog.util.a.exN() * f1;
    f1 = i;
    int j = com.tencent.mm.cb.a.ax(this.context, 2131165277);
    int k = com.tencent.mm.cb.a.ax(this.context, 2131165283);
    k = com.tencent.mm.cb.a.iv(this.context) - j - k + 0;
    ae.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + f3 + " ,validHeight:" + k);
    float f2 = Math.min(f3, k * 1.0F);
    this.CeA.setLimitMaxHeight(f2);
    this.CeA.setLimitMinHeight(f1 * 0.5625F);
    f1 = 0.0F;
    if (f2 < f3) {
      f1 = (1.0F - f2 / f3) * i / 2.0F;
    }
    f3 = j + (k - f2) / 2.0F;
    this.BWZ.set(f1, f3, i - f1, f2 + f3);
    this.Cew.h(this.BWZ);
    localObject = this.Cca;
    if (localObject != null)
    {
      ((o)localObject).iq(i, (int)this.BWZ.height());
      AppMethodBeat.o(191632);
      return;
    }
    AppMethodBeat.o(191632);
  }
  
  public final VideoCompositionPlayView ewO()
  {
    AppMethodBeat.i(191635);
    ewQ();
    VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
    if (localVideoCompositionPlayView == null) {
      p.gkB();
    }
    AppMethodBeat.o(191635);
    return localVideoCompositionPlayView;
  }
  
  public final Rect ewP()
  {
    AppMethodBeat.i(191644);
    Object localObject = this.Cex;
    if (localObject != null) {}
    for (localObject = ((v)localObject).ewP(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(191644);
      return localObject;
    }
    localObject = this.Cez.getContentRect();
    RectF localRectF = this.Cez.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.Cez.getContentOriginalRect(), localRect);
    AppMethodBeat.o(191644);
    return localObject;
  }
  
  public final void ewR()
  {
    AppMethodBeat.i(191650);
    if (this.Cep != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.pause();
        AppMethodBeat.o(191650);
        return;
      }
    }
    AppMethodBeat.o(191650);
  }
  
  public final void ewS()
  {
    AppMethodBeat.i(191653);
    if (this.Cep != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.Cep = null;
    }
    AppMethodBeat.o(191653);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(191633);
    p.h(paramRectF, "rect");
    this.Cew.g(paramRectF);
    this.tVK.set(paramRectF);
    this.CeA.getVisibilityRect().set(paramRectF);
    this.CeA.postInvalidate();
    this.CeA.setVisibility(0);
    AppMethodBeat.o(191633);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191643);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    d.b.a(this.tbP, d.c.xVL);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(191643);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(191651);
    View localView = (View)this.Cep;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(191651);
      return;
    }
    AppMethodBeat.o(191651);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191656);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191656);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(191652);
    ewS();
    this.Ceq.clear();
    AppMethodBeat.o(191652);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191648);
    this.tVQ = 0L;
    this.Cez.za(true);
    AppMethodBeat.o(191648);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(191649);
    Object localObject = this.Cep;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).seekTo(paramLong);
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.BZo;
    com.tencent.mm.plugin.vlog.model.report.b.report(0L);
    AppMethodBeat.o(191649);
  }
  
  public final void setMuteOrigin(boolean paramBoolean)
  {
    AppMethodBeat.i(191639);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.zq(paramBoolean);
      AppMethodBeat.o(191639);
      return;
    }
    AppMethodBeat.o(191639);
  }
  
  public final void setVisibility(int paramInt) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(191638);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Cep;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.stop();
      AppMethodBeat.o(191638);
      return;
    }
    AppMethodBeat.o(191638);
  }
  
  public final void ta(boolean paramBoolean)
  {
    AppMethodBeat.i(191640);
    a(this, paramBoolean, true, 0L, 12);
    AppMethodBeat.o(191640);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "", "plugin-vlog_release"})
  public static abstract interface b {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"})
  public static abstract interface c
    extends c.b
  {
    public abstract void BO(long paramLong);
    
    public abstract void a(c.e parame);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "", "seekToOriginPosition", "", "plugin-vlog_release"})
  public static abstract interface d
    extends c.b
  {
    public abstract void a(com.tencent.mm.plugin.vlog.model.v paramv, long paramLong, boolean paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "", "pause", "", "resume", "seek", "timeMs", "", "host", "plugin-vlog_release"})
  public static abstract interface e
  {
    public abstract void BP(long paramLong);
    
    public abstract void pause();
    
    public abstract void resume();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class f
    implements a.a.b
  {
    public final void cOE()
    {
      AppMethodBeat.i(191617);
      Object localObject = ((Iterable)c.c(this.CeC)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        c.b localb = (c.b)((Iterator)localObject).next();
        if ((localb instanceof c.c)) {
          ((c.c)localb).a(this.CeC.Cee);
        }
      }
      localObject = c.d(this.CeC);
      long l;
      if (localObject != null)
      {
        l = ((VideoCompositionPlayView)localObject).getPosition();
        localObject = this.CeC.Cef;
        if (localObject != null)
        {
          ((c.e)localObject).BP(l + this.CeC.Cet);
          AppMethodBeat.o(191617);
        }
      }
      else
      {
        localObject = c.e(this.CeC);
        if (localObject != null) {}
        for (l = ((com.tencent.mm.plugin.vlog.model.v)localObject).BXI.getPlayStart();; l = 0L)
        {
          l = 0L - l / 1000L;
          break;
        }
      }
      AppMethodBeat.o(191617);
    }
    
    public final void cOF() {}
    
    public final void cOG()
    {
      AppMethodBeat.i(191618);
      Iterator localIterator = ((Iterable)c.c(this.CeC)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(191618);
    }
    
    public final void cOH()
    {
      AppMethodBeat.i(191620);
      Object localObject = c.d(this.CeC);
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(191620);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      d.b.a(this.CeC.tbP, d.c.xUS);
      AppMethodBeat.o(191620);
    }
    
    public final void cOI() {}
    
    public final void cOJ() {}
    
    public final void xH(long paramLong)
    {
      AppMethodBeat.i(191619);
      ae.d("MicroMsg.EditMultiPreviewPlugin", "onPlayProgress timeMs:".concat(String.valueOf(paramLong)));
      Iterator localIterator = ((Iterable)c.c(this.CeC)).iterator();
      while (localIterator.hasNext())
      {
        c.b localb = (c.b)localIterator.next();
        if ((localb instanceof c.c)) {
          ((c.c)localb).BO(paramLong);
        }
      }
      AppMethodBeat.o(191619);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$2", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "plugin-vlog_release"})
  public static final class g
    implements a.a.c
  {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class i
    implements WxCropOperationLayout.i
  {
    private boolean CeE = true;
    
    i(long paramLong, com.tencent.mm.plugin.vlog.model.w paramw) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191622);
      p.h(paramRectF, "rectF");
      if (c.a(this.CeC, this.tWa)) {
        this.CeC.tVK.set(paramRectF);
      }
      Object localObject1 = c.a(this.CeC);
      if (localObject1 != null)
      {
        localObject1 = (List)((o)localObject1).BWQ;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (com.tencent.mm.plugin.vlog.model.w)((Iterator)localObject1).next();
            g localg = ((com.tencent.mm.plugin.vlog.model.w)localObject2).BXT;
            paramRectF.round(localg.hpa);
            if (!p.i(this.CeF, localObject2))
            {
              int i = localg.hpa.bottom - localg.qfO.bottom;
              int j = localg.hpa.top - localg.qfO.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localg.qfO);
                float f1 = paramRectF.height() / localRectF.height();
                label224:
                float f2;
                if (f1 < 1.0F) {
                  if (j < 0)
                  {
                    f1 = j;
                    float f3 = 1.0F;
                    f2 = f1;
                    f1 = f3;
                  }
                }
                for (;;)
                {
                  ((Matrix)localObject2).postTranslate(0.0F, f2);
                  ((Matrix)localObject2).postScale(f1, f1, paramRectF.centerX(), paramRectF.centerY());
                  ((Matrix)localObject2).mapRect(localRectF);
                  localRectF.round(localg.qfO);
                  localg.gR.postConcat((Matrix)localObject2);
                  break;
                  f1 = i;
                  break label224;
                  f2 = paramRectF.centerY() - localRectF.centerY();
                }
              }
            }
          }
        }
      }
      this.CeC.Cez.i(paramRectF);
      paramRectF = this.CeC.Cer;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.CeE)
      {
        paramRectF = this.CeC;
        paramRectF.Ces += 1;
      }
      this.CeE = true;
      AppMethodBeat.o(191622);
    }
    
    public final void mS(boolean paramBoolean)
    {
      this.CeE = false;
    }
    
    public final void mT(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class j
    implements CropLayout.d
  {
    private float CeG = 1.0F;
    
    j(com.tencent.mm.plugin.vlog.model.w paramw, e parame) {}
    
    public final void ewW()
    {
      AppMethodBeat.i(191624);
      this.CeG = m.e(this.CeF.BXT.gR);
      AppMethodBeat.o(191624);
    }
    
    public final void ewX()
    {
      AppMethodBeat.i(191625);
      Object localObject = this.CeF;
      if (this.CeG != m.e(((com.tencent.mm.plugin.vlog.model.w)localObject).BXT.gR))
      {
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXU;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(191625);
        return;
      }
      localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXU;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(191625);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(191623);
      if (this.CeF.BXT.getScale() > 0.0F)
      {
        com.tencent.mm.bt.b localb = this.CeH.getPresenter();
        p.g(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.CeF.BXT.getScale());
      }
      this.CeF.BXT.qfO.set(this.CeC.Cez.getContentRect());
      AppMethodBeat.o(191623);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onUpdateVideo$3", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class k
    implements WxCropOperationLayout.i
  {
    private boolean CeE = true;
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191626);
      p.h(paramRectF, "rectF");
      Object localObject = c.b(this.CeC);
      if (localObject != null)
      {
        localObject = ((v)localObject).exi();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).e(paramRectF);
        }
      }
      paramRectF = this.CeC.Cer;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.CeE)
      {
        paramRectF = this.CeC;
        paramRectF.Ces += 1;
      }
      this.CeE = true;
      AppMethodBeat.o(191626);
    }
    
    public final void mS(boolean paramBoolean)
    {
      AppMethodBeat.i(191627);
      Object localObject = c.b(this.CeC);
      if (localObject != null)
      {
        localObject = ((v)localObject).exi();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).mS(paramBoolean);
        }
      }
      this.CeE = false;
      AppMethodBeat.o(191627);
    }
    
    public final void mT(boolean paramBoolean)
    {
      AppMethodBeat.i(191628);
      Object localObject = c.b(this.CeC);
      if (localObject != null)
      {
        localObject = ((v)localObject).exi();
        if (localObject != null)
        {
          ((WxCropOperationLayout.i)localObject).mT(paramBoolean);
          AppMethodBeat.o(191628);
          return;
        }
      }
      AppMethodBeat.o(191628);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class l
    implements c.e
  {
    public final void BP(long paramLong)
    {
      AppMethodBeat.i(191629);
      Object localObject = com.tencent.mm.plugin.vlog.model.report.b.BZo;
      com.tencent.mm.plugin.vlog.model.report.b.report(0L);
      localObject = c.d(this.CeC);
      if (localObject != null)
      {
        ((VideoCompositionPlayView)localObject).seekTo(paramLong);
        AppMethodBeat.o(191629);
        return;
      }
      AppMethodBeat.o(191629);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191630);
      d.b.a(this.CeC.tbP, d.c.xUN);
      AppMethodBeat.o(191630);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(191631);
      d.b.a(this.CeC.tbP, d.c.xUO);
      AppMethodBeat.o(191631);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */