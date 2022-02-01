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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.c;
import com.tencent.mm.view.e;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentType", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "setLayout", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "previewVideoMaxFpsLimit", "getPreviewVideoMaxFpsLimit", "setPreviewVideoMaxFpsLimit", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "videoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "calcOriginRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "", "currentVideoComposition", "flushSurface", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVideoView", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isLockMedia", "", "isPreviewingVideo", "onClick", "v", "Landroid/view/View;", "onDetach", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onPreviewVideo", "muteOrigin", "onUpdateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "pausePreview", "registerCallback", "callback", "release", "releaseVideo", "reset", "resumePreview", "seek", "startMs", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setLoop", "loop", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "showPlayView", "stopPreview", "unregisterCallback", "updateValidArea", "showTab", "videoPause", "videoResume", "Companion", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class c
  implements View.OnClickListener, t
{
  public static final c.a BNc;
  public final RectF BFB;
  public com.tencent.mm.plugin.vlog.model.v BFd;
  public o BKB;
  public final c.e BMF;
  public c.e BMG;
  public VideoCompositionPlayView BMQ;
  private final LinkedList<c.b> BMR;
  public CropLayout.c BMS;
  public int BMT;
  long BMU;
  private long BMV;
  private final w BMW;
  private final s BMX;
  private v BMY;
  public int BMZ;
  public CropLayout BNa;
  public WxCropOperationLayout BNb;
  private final Context context;
  public final ViewGroup gqv;
  private int oDy;
  d sQE;
  private long tKA;
  final RectF tKT;
  private WxCropOperationLayout.j tKV;
  private long tKZ;
  
  static
  {
    AppMethodBeat.i(196196);
    BNc = new c.a((byte)0);
    AppMethodBeat.o(196196);
  }
  
  public c(CropLayout paramCropLayout, WxCropOperationLayout paramWxCropOperationLayout, d paramd)
  {
    AppMethodBeat.i(196195);
    this.BNa = paramCropLayout;
    this.BNb = paramWxCropOperationLayout;
    this.sQE = paramd;
    this.context = this.BNa.getContext();
    paramCropLayout = this.BNa.getParent();
    if (paramCropLayout == null)
    {
      paramCropLayout = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(196195);
      throw paramCropLayout;
    }
    this.gqv = ((ViewGroup)paramCropLayout);
    this.BFB = new RectF();
    this.BMR = new LinkedList();
    this.tKA = -1L;
    this.tKT = new RectF();
    this.tKV = WxCropOperationLayout.j.xIV;
    this.BMF = ((c.e)new l(this));
    this.BMZ = -1;
    paramCropLayout = this.BNa;
    paramCropLayout.setHasBorder(false);
    paramCropLayout.setEnableScale(true);
    paramCropLayout.setEnableFling(true);
    paramCropLayout.setEnableTouch(true);
    paramCropLayout.setEnableOverScroll(false);
    this.BNa.setBackgroundColor(0);
    this.BNb.dHp();
    this.BMW = ((w)new w()
    {
      public final VideoCompositionPlayView eth()
      {
        AppMethodBeat.i(196156);
        c.g(this.BNd);
        VideoCompositionPlayView localVideoCompositionPlayView = c.d(this.BNd);
        if (localVideoCompositionPlayView == null) {
          p.gfZ();
        }
        AppMethodBeat.o(196156);
        return localVideoCompositionPlayView;
      }
      
      public final ViewGroup etm()
      {
        AppMethodBeat.i(196155);
        ViewGroup localViewGroup = c.f(this.BNd);
        AppMethodBeat.o(196155);
        return localViewGroup;
      }
      
      public final CropLayout etn()
      {
        return this.BNd.BNa;
      }
      
      public final void eto()
      {
        AppMethodBeat.i(196157);
        d.b.a(this.BNd.sQE, d.c.xET);
        AppMethodBeat.o(196157);
      }
      
      public final WxCropOperationLayout getOperationLayout()
      {
        return this.BNd.BNb;
      }
    });
    this.BMX = new s(this.BMW);
    a((c.b)this.BMX);
    etg();
    this.BNb.xIu = false;
    this.BNb.setVisibility(8);
    this.BNb.setBlockOutsideTouch(true);
    AppMethodBeat.o(196195);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(196186);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(196186);
    return paramRect1;
  }
  
  private final void etj()
  {
    AppMethodBeat.i(196187);
    if (this.BMQ == null)
    {
      this.BMQ = new VideoCompositionPlayView(this.context);
      VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.setPlayerCallback((a.a.a)new c.f(this));
      }
      localVideoCompositionPlayView = this.BMQ;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.setPlayerProfileCallback((a.a.c)new c.g());
        AppMethodBeat.o(196187);
        return;
      }
    }
    AppMethodBeat.o(196187);
  }
  
  private final boolean xB(long paramLong)
  {
    return (this.tKZ == paramLong) || (this.tKZ == 0L);
  }
  
  public final void Bs(long paramLong)
  {
    this.BMU = paramLong;
  }
  
  public final void a(c.b paramb)
  {
    AppMethodBeat.i(196175);
    p.h(paramb, "callback");
    if (!this.BMR.contains(paramb)) {
      this.BMR.add(paramb);
    }
    AppMethodBeat.o(196175);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    com.tencent.mm.plugin.vlog.model.v localv = null;
    AppMethodBeat.i(196182);
    ad.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + paramBoolean2 + ", seekToOriginPosition:" + paramBoolean3 + ", seekTo:" + paramLong);
    this.oDy = 2;
    etj();
    this.tKA = -1L;
    Object localObject1 = this.BKB;
    if (localObject1 != null)
    {
      localObject1 = ((o)localObject1).BFd;
      this.BFd = ((com.tencent.mm.plugin.vlog.model.v)localObject1);
      localObject1 = this.BFd;
      if (localObject1 != null) {
        if (paramBoolean1) {
          break label195;
        }
      }
    }
    label195:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).sQ(paramBoolean1);
      localObject1 = this.BFd;
      if (localObject1 == null) {
        break label200;
      }
      localObject2 = ((Iterable)this.BMR).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (c.b)((Iterator)localObject2).next();
        if ((localObject3 instanceof d)) {
          ((d)localObject3).a((com.tencent.mm.plugin.vlog.model.v)localObject1, paramLong, paramBoolean3);
        }
      }
      localObject1 = null;
      break;
    }
    label200:
    localObject1 = this.BMY;
    if (localObject1 != null) {
      ((v)localObject1).sU(false);
    }
    this.BMY = ((v)this.BMX);
    localObject1 = this.BKB;
    if (localObject1 != null)
    {
      localObject1 = ((o)localObject1).erS();
      localObject2 = this.BMY;
      if (localObject2 != null) {
        ((v)localObject2).a((Size)localObject1);
      }
    }
    this.BMX.BMG = this.BMG;
    localObject1 = this.BMY;
    if (localObject1 != null) {
      ((v)localObject1).sU(true);
    }
    this.BNb.setOnOperationCallback((WxCropOperationLayout.i)new k(this));
    this.BNa.setClickListener((View.OnClickListener)this);
    Object localObject2 = this.BNa;
    Object localObject3 = this.BMY;
    localObject1 = localv;
    if (localObject3 != null) {
      localObject1 = ((v)localObject3).etA();
    }
    ((CropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
    localObject1 = this.BFd;
    if (localObject1 != null) {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).TA(this.BMZ);
    }
    localObject1 = this.BMY;
    if (localObject1 != null)
    {
      localv = this.BFd;
      if (localv == null) {
        p.gfZ();
      }
      ((v)localObject1).a(localv, paramBoolean2, paramBoolean3, paramLong);
    }
    this.BNb.setVisibility(0);
    if (paramBoolean2)
    {
      localObject1 = this.BMG;
      if (localObject1 != null)
      {
        ((c.e)localObject1).resume();
        AppMethodBeat.o(196182);
        return;
      }
    }
    AppMethodBeat.o(196182);
  }
  
  public final g aDv(String paramString)
  {
    AppMethodBeat.i(196188);
    p.h(paramString, "path");
    Object localObject = this.BKB;
    if (localObject != null)
    {
      localObject = (List)((o)localObject).BFs;
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
        localObject = paramString.BGu;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new g();
      }
      AppMethodBeat.o(196188);
      return paramString;
    }
  }
  
  public final boolean aoB()
  {
    return false;
  }
  
  public final void ar(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(196177);
    VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.ar(paramLong1, paramLong2);
      AppMethodBeat.o(196177);
      return;
    }
    AppMethodBeat.o(196177);
  }
  
  public final void ayX() {}
  
  public final void etf()
  {
    this.BMV = 0L;
  }
  
  public final void etg()
  {
    AppMethodBeat.i(196173);
    int i = com.tencent.mm.cc.a.ip(this.context);
    float f1 = i;
    Object localObject = com.tencent.mm.plugin.vlog.util.a.BVa;
    float f3 = com.tencent.mm.plugin.vlog.util.a.euh() * f1;
    f1 = i;
    int j = com.tencent.mm.cc.a.ax(this.context, 2131165277);
    int k = com.tencent.mm.cc.a.ax(this.context, 2131165283);
    k = com.tencent.mm.cc.a.iq(this.context) - j - k + 0;
    ad.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + f3 + " ,validHeight:" + k);
    float f2 = Math.min(f3, k * 1.0F);
    this.BNb.setLimitMaxHeight(f2);
    this.BNb.setLimitMinHeight(f1 * 0.5625F);
    f1 = 0.0F;
    if (f2 < f3) {
      f1 = (1.0F - f2 / f3) * i / 2.0F;
    }
    f3 = j + (k - f2) / 2.0F;
    this.BFB.set(f1, f3, i - f1, f2 + f3);
    this.BMX.h(this.BFB);
    localObject = this.BKB;
    if (localObject != null)
    {
      ((o)localObject).in(i, (int)this.BFB.height());
      AppMethodBeat.o(196173);
      return;
    }
    AppMethodBeat.o(196173);
  }
  
  public final VideoCompositionPlayView eth()
  {
    AppMethodBeat.i(196176);
    etj();
    VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
    if (localVideoCompositionPlayView == null) {
      p.gfZ();
    }
    AppMethodBeat.o(196176);
    return localVideoCompositionPlayView;
  }
  
  public final Rect eti()
  {
    AppMethodBeat.i(196185);
    Object localObject = this.BMY;
    if (localObject != null) {}
    for (localObject = ((v)localObject).eti(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(196185);
      return localObject;
    }
    localObject = this.BNa.getContentRect();
    RectF localRectF = this.BNa.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.BNa.getContentOriginalRect(), localRect);
    AppMethodBeat.o(196185);
    return localObject;
  }
  
  public final void etk()
  {
    AppMethodBeat.i(196191);
    if (this.BMQ != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.pause();
        AppMethodBeat.o(196191);
        return;
      }
    }
    AppMethodBeat.o(196191);
  }
  
  public final void etl()
  {
    AppMethodBeat.i(196194);
    if (this.BMQ != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.BMQ = null;
    }
    AppMethodBeat.o(196194);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(196174);
    p.h(paramRectF, "rect");
    this.BMX.g(paramRectF);
    this.tKT.set(paramRectF);
    this.BNb.getVisibilityRect().set(paramRectF);
    this.BNb.postInvalidate();
    this.BNb.setVisibility(0);
    AppMethodBeat.o(196174);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(196184);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    d.b.a(this.sQE, d.c.xFQ);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(196184);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(196192);
    View localView = (View)this.BMQ;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(196192);
      return;
    }
    AppMethodBeat.o(196192);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(196197);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(196197);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(196193);
    etl();
    this.BMR.clear();
    AppMethodBeat.o(196193);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(196189);
    this.tKZ = 0L;
    this.BNa.yM(true);
    AppMethodBeat.o(196189);
  }
  
  public final void sT(boolean paramBoolean)
  {
    AppMethodBeat.i(196181);
    a(this, paramBoolean, true, 0L, 12);
    AppMethodBeat.o(196181);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(196190);
    Object localObject = this.BMQ;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).seekTo(paramLong);
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.BHP;
    com.tencent.mm.plugin.vlog.model.report.b.report(0L);
    AppMethodBeat.o(196190);
  }
  
  public final void setMuteOrigin(boolean paramBoolean)
  {
    AppMethodBeat.i(196180);
    VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.zc(paramBoolean);
      AppMethodBeat.o(196180);
      return;
    }
    AppMethodBeat.o(196180);
  }
  
  public final void setVisibility(int paramInt) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(196179);
    VideoCompositionPlayView localVideoCompositionPlayView = this.BMQ;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.stop();
      AppMethodBeat.o(196179);
      return;
    }
    AppMethodBeat.o(196179);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "", "seekToOriginPosition", "", "plugin-vlog_release"})
  public static abstract interface d
    extends c.b
  {
    public abstract void a(com.tencent.mm.plugin.vlog.model.v paramv, long paramLong, boolean paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class i
    implements WxCropOperationLayout.i
  {
    private boolean BNf = true;
    
    i(long paramLong, com.tencent.mm.plugin.vlog.model.w paramw) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(196163);
      p.h(paramRectF, "rectF");
      if (c.a(this.BNd, this.tLj)) {
        this.BNd.tKT.set(paramRectF);
      }
      Object localObject1 = c.a(this.BNd);
      if (localObject1 != null)
      {
        localObject1 = (List)((o)localObject1).BFs;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (com.tencent.mm.plugin.vlog.model.w)((Iterator)localObject1).next();
            g localg = ((com.tencent.mm.plugin.vlog.model.w)localObject2).BGu;
            paramRectF.round(localg.hmm);
            if (!p.i(this.BNg, localObject2))
            {
              int i = localg.hmm.bottom - localg.pZj.bottom;
              int j = localg.hmm.top - localg.pZj.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localg.pZj);
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
                  localRectF.round(localg.pZj);
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
      this.BNd.BNa.i(paramRectF);
      paramRectF = this.BNd.BMS;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.BNf)
      {
        paramRectF = this.BNd;
        paramRectF.BMT += 1;
      }
      this.BNf = true;
      AppMethodBeat.o(196163);
    }
    
    public final void mO(boolean paramBoolean)
    {
      this.BNf = false;
    }
    
    public final void mP(boolean paramBoolean) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class j
    implements CropLayout.d
  {
    private float BNh = 1.0F;
    
    j(com.tencent.mm.plugin.vlog.model.w paramw, e parame) {}
    
    public final void etp()
    {
      AppMethodBeat.i(196165);
      this.BNh = m.e(this.BNg.BGu.gR);
      AppMethodBeat.o(196165);
    }
    
    public final void etq()
    {
      AppMethodBeat.i(196166);
      Object localObject = this.BNg;
      if (this.BNh != m.e(((com.tencent.mm.plugin.vlog.model.w)localObject).BGu.gR))
      {
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGv;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(196166);
        return;
      }
      localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGv;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(196166);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(196164);
      if (this.BNg.BGu.getScale() > 0.0F)
      {
        com.tencent.mm.bu.b localb = this.BNi.getPresenter();
        p.g(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.BNg.BGu.getScale());
      }
      this.BNg.BGu.pZj.set(this.BNd.BNa.getContentRect());
      AppMethodBeat.o(196164);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onUpdateVideo$3", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class k
    implements WxCropOperationLayout.i
  {
    private boolean BNf = true;
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(196167);
      p.h(paramRectF, "rectF");
      Object localObject = c.b(this.BNd);
      if (localObject != null)
      {
        localObject = ((v)localObject).etB();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).e(paramRectF);
        }
      }
      paramRectF = this.BNd.BMS;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.BNf)
      {
        paramRectF = this.BNd;
        paramRectF.BMT += 1;
      }
      this.BNf = true;
      AppMethodBeat.o(196167);
    }
    
    public final void mO(boolean paramBoolean)
    {
      AppMethodBeat.i(196168);
      Object localObject = c.b(this.BNd);
      if (localObject != null)
      {
        localObject = ((v)localObject).etB();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).mO(paramBoolean);
        }
      }
      this.BNf = false;
      AppMethodBeat.o(196168);
    }
    
    public final void mP(boolean paramBoolean)
    {
      AppMethodBeat.i(196169);
      Object localObject = c.b(this.BNd);
      if (localObject != null)
      {
        localObject = ((v)localObject).etB();
        if (localObject != null)
        {
          ((WxCropOperationLayout.i)localObject).mP(paramBoolean);
          AppMethodBeat.o(196169);
          return;
        }
      }
      AppMethodBeat.o(196169);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class l
    implements c.e
  {
    public final void Br(long paramLong)
    {
      AppMethodBeat.i(196170);
      Object localObject = com.tencent.mm.plugin.vlog.model.report.b.BHP;
      com.tencent.mm.plugin.vlog.model.report.b.report(0L);
      localObject = c.d(this.BNd);
      if (localObject != null)
      {
        ((VideoCompositionPlayView)localObject).seekTo(paramLong);
        AppMethodBeat.o(196170);
        return;
      }
      AppMethodBeat.o(196170);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(196171);
      d.b.a(this.BNd.sQE, d.c.xES);
      AppMethodBeat.o(196171);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(196172);
      d.b.a(this.BNd.sQE, d.c.xET);
      AppMethodBeat.o(196172);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */