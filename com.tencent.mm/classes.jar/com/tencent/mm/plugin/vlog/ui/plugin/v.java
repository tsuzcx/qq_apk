package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "isFullscreenMode", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "currentPlayingTrack", "enableFullscreenMode", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "updateVideoCrop", "plugin-vlog_release"})
public final class v
  implements d.c, y
{
  boolean MZN;
  ac Nlb;
  final RectF Nmh;
  final RectF Nmi;
  d.e NuH;
  private final View NvR;
  ad NvS;
  private long NvT;
  final Runnable NvU;
  private final a NvV;
  private final e NvW;
  final z NvX;
  final String TAG;
  private boolean isActive;
  
  public v(z paramz)
  {
    AppMethodBeat.i(226158);
    this.NvX = paramz;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.NvR = new View(this.NvX.gve().getContext());
    this.Nmi = new RectF();
    this.Nmh = new RectF();
    this.NvU = ((Runnable)new b(this));
    this.NvV = new a(this);
    this.NvW = new e(this);
    AppMethodBeat.o(226158);
  }
  
  public final void Av(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final void LX(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(226151);
    if (!this.isActive)
    {
      AppMethodBeat.o(226151);
      return;
    }
    this.NvT = paramLong;
    Object localObject1 = this.Nlb;
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject1 = (List)((ac)localObject1).MQY;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          ad localad = (ad)localObject1;
          if ((localad.Nng.startTimeMs <= paramLong) && (localad.Nng.endTimeMs > paramLong))
          {
            i = 1;
            label118:
            if (i == 0) {
              break label230;
            }
          }
        }
      }
    }
    label122:
    for (localObject1 = (ad)localObject1;; localObject1 = null)
    {
      if ((p.h(localObject1, this.NvS) ^ true))
      {
        localObject3 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
        if (com.tencent.mm.plugin.vlog.model.local.a.gtT())
        {
          localObject3 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
          if (localObject1 != null) {
            localObject2 = ((ad)localObject1).path;
          }
          i = com.tencent.mm.plugin.vlog.model.local.a.bfz((String)localObject2);
          localObject2 = this.NvX.gvh();
          localObject3 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf;
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.aks(i));
        }
        d.uiThread((kotlin.g.a.a)new c(this, (ad)localObject1));
      }
      AppMethodBeat.o(226151);
      return;
      i = 0;
      break label118;
      break;
      localObject1 = null;
      break label122;
    }
  }
  
  public final void a(ac paramac, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(226142);
    p.k(paramac, "composition");
    Log.i(this.TAG, "onUpdate: playRange:" + paramac.NmT.igH() + ", trackList.size:" + ((List)paramac.MQY).size() + ", playAfterUpdate:" + paramBoolean1);
    VideoCompositionPlayView localVideoCompositionPlayView = this.NvX.guT();
    if ((p.h(localVideoCompositionPlayView.getParent(), this.NvX.gve()) ^ true))
    {
      ViewParent localViewParent = localVideoCompositionPlayView.getParent();
      localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)localVideoCompositionPlayView);
      }
      localVideoCompositionPlayView.setScaleX(1.0F);
      localVideoCompositionPlayView.setScaleY(1.0F);
      localVideoCompositionPlayView.setTranslationX(0.0F);
      localVideoCompositionPlayView.setTranslationY(0.0F);
      Log.i(this.TAG, "videoView size width:" + this.Nmi.width() + " height:" + this.Nmi.height());
      localObject = new RelativeLayout.LayoutParams((int)this.Nmi.width(), (int)this.Nmi.height());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.Nmi.top);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.NvX.gve().addView((View)localVideoCompositionPlayView, 0, (ViewGroup.LayoutParams)localObject);
    }
    if (!this.MZN)
    {
      this.NvX.gvf().getVisibilityRect().set(this.Nmh);
      this.NvX.getOperationLayout().getVisibilityRect().set(this.Nmh);
    }
    this.Nlb = paramac;
    this.NvS = ((ad)kotlin.a.j.M((List)paramac.MQY, 0));
    gvH();
    if ((paramBoolean1) && (!paramBoolean2) && (paramLong == -1L))
    {
      this.NvX.guT().a(paramac.getComposition());
      this.NvX.getOperationLayout().postDelayed((Runnable)new d(this), 3000L);
      AppMethodBeat.o(226142);
      return;
    }
    Object localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
    com.tencent.mm.plugin.vlog.model.report.b.report(10L);
    this.NvX.guT().a(paramac.getComposition(), paramBoolean1, paramBoolean2, paramLong);
    paramac = this.NvX.getOperationLayout();
    localObject = paramac.HWh;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    paramac.HVQ = 0;
    paramac.invalidate();
    AppMethodBeat.o(226142);
  }
  
  public final void a(d.e parame) {}
  
  public final void b(Size paramSize)
  {
    AppMethodBeat.i(226154);
    p.k(paramSize, "size");
    AppMethodBeat.o(226154);
  }
  
  public final Rect guZ()
  {
    AppMethodBeat.i(226145);
    Rect localRect = new Rect();
    this.NvX.gvf().getVisibilityRect().round(localRect);
    localRect.offset(-(int)this.Nmi.left, -(int)this.Nmi.top);
    AppMethodBeat.o(226145);
    return localRect;
  }
  
  public final CropLayout.c gvF()
  {
    return (CropLayout.c)this.NvV;
  }
  
  public final WxCropOperationLayout.i gvG()
  {
    return (WxCropOperationLayout.i)this.NvW;
  }
  
  public final void gvH()
  {
    AppMethodBeat.i(226147);
    Object localObject = this.NvS;
    if (localObject == null)
    {
      AppMethodBeat.o(226147);
      return;
    }
    int i = ((ad)localObject).Nna;
    int j = ((ad)localObject).Nnb;
    localObject = ((ad)localObject).Nnd;
    this.NvX.gvf().setMaxScaleValue(((com.tencent.mm.plugin.vlog.model.j)localObject).aGN);
    this.NvX.gvf().setMinScaleValue(((com.tencent.mm.plugin.vlog.model.j)localObject).aGO);
    boolean bool = this.NvX.gvf().getContentRect().isEmpty();
    this.NvX.gvf().getContentRect().set(((com.tencent.mm.plugin.vlog.model.j)localObject).vcr);
    this.NvX.gvf().getContentRect().offset(0, (int)this.Nmi.top);
    this.NvX.gvf().a(this.NvR, i, j, ((com.tencent.mm.plugin.vlog.model.j)localObject).aHZ, CropLayout.e.Ylw, (kotlin.g.a.b)new f(bool));
    Log.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(226147);
  }
  
  public final void gvI()
  {
    AppMethodBeat.i(226153);
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.Nol;
    localObject = this.NvS;
    if (localObject != null) {}
    for (localObject = ((ad)localObject).path;; localObject = null)
    {
      int i = com.tencent.mm.plugin.vlog.model.local.a.bfz((String)localObject);
      localObject = this.NvX.gvh();
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b localb = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.aks(i));
      AppMethodBeat.o(226153);
      return;
    }
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(226135);
    p.k(paramRectF, "rect");
    this.Nmh.set(paramRectF);
    AppMethodBeat.o(226135);
  }
  
  public final void i(RectF paramRectF)
  {
    AppMethodBeat.i(226134);
    p.k(paramRectF, "rect");
    this.Nmi.set(paramRectF);
    AppMethodBeat.o(226134);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.d
  {
    private float INY = 1.0F;
    
    public final void gvi()
    {
      AppMethodBeat.i(232035);
      Object localObject = this.NvY.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      d.e locale = this.NvY.NuH;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, i);
        this.NvY.NvX.guT().pause();
        localObject = this.NvY.NuH;
        if (localObject != null) {
          ((d.e)localObject).pause();
        }
        localObject = this.NvY.NvS;
        if (localObject == null) {
          break label167;
        }
        localObject = ((ad)localObject).Nnd;
        if (localObject == null) {
          break label167;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.j)localObject).aHZ;
        if (localObject == null) {
          break label167;
        }
      }
      label167:
      for (float f = t.e((Matrix)localObject);; f = 1.0F)
      {
        this.INY = f;
        d.C(this.NvY.NvU);
        this.NvY.NvX.getOperationLayout().fyb();
        AppMethodBeat.o(232035);
        return;
        i = 0;
        break;
      }
    }
    
    public final void gvj()
    {
      AppMethodBeat.i(232037);
      Object localObject = this.NvY.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      d.e locale = this.NvY.NuH;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, i);
        this.NvY.NvX.gvg();
        localObject = this.NvY.NvS;
        if (localObject != null)
        {
          if (this.INY == t.e(((ad)localObject).Nnd.aHZ)) {
            break label136;
          }
          localObject = ((ad)localObject).Nnf;
          ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        }
      }
      for (;;)
      {
        d.a(3000L, this.NvY.NvU);
        AppMethodBeat.o(232037);
        return;
        i = 0;
        break;
        label136:
        localObject = ((ad)localObject).Nnf;
        ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      }
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(232033);
      Log.i(this.NvY.TAG, "onChange: " + this.NvY.NvX.gvf().getContentRect());
      if (this.NvY.NvX.gvf().getContentRect().isEmpty())
      {
        AppMethodBeat.o(232033);
        return;
      }
      ad localad = this.NvY.NvS;
      if (localad != null)
      {
        localad.Nnd.vcr.set(this.NvY.NvX.gvf().getContentRect());
        localad.Nng.kXj.set(this.NvY.NvX.gvf().getContentRect());
        localad.Nnd.vcr.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
        localad.Nng.kXj.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
        localad.Nnd.kXj.set(localad.Nnd.vcr);
      }
      if (!this.NvY.NvX.guT().isPlaying()) {
        this.NvY.NvX.guT().bXe();
      }
      AppMethodBeat.o(232033);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(227920);
      if (!this.NvY.MZN) {
        this.NvY.NvX.getOperationLayout().fya();
      }
      AppMethodBeat.o(227920);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(v paramv, ad paramad)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(246523);
      WxCropOperationLayout.a(this.NvY.NvX.getOperationLayout());
      AppMethodBeat.o(246523);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(246379);
      p.k(paramRectF, "rectF");
      this.NvY.Nmh.set(paramRectF);
      Log.i(this.NvY.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject = this.NvY.Nlb;
      ad localad;
      com.tencent.mm.plugin.vlog.model.j localj;
      float f1;
      Matrix localMatrix;
      RectF localRectF;
      float f2;
      if (localObject != null)
      {
        localObject = (List)((ac)localObject).MQY;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localad = (ad)((Iterator)localObject).next();
              localj = localad.Nnd;
              paramRectF.round(localj.kXj);
              localj.kXj.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
              if ((!p.h(this.NvY.NvS, localad)) && (!this.NvY.MZN))
              {
                localj.vcr.offset(0, (int)this.NvY.Nmi.top);
                f1 = paramRectF.bottom - localj.vcr.bottom;
                float f3 = paramRectF.top - localj.vcr.top;
                if ((f1 > 0.0F) || (f3 < 0.0F))
                {
                  localMatrix = new Matrix();
                  localRectF = new RectF(localj.vcr);
                  f2 = paramRectF.height() / localRectF.height();
                  if (f2 < 1.0F)
                  {
                    if (f3 >= 0.0F) {
                      break label618;
                    }
                    f1 = f3;
                  }
                }
              }
            }
          }
        }
      }
      label293:
      label618:
      for (;;)
      {
        f2 = 1.0F;
        localMatrix.postTranslate(0.0F, f1);
        localMatrix.postScale(f2, f2, paramRectF.centerX(), paramRectF.centerY());
        localMatrix.mapRect(localRectF);
        localRectF.round(localj.vcr);
        localRectF.round(localad.Nng.kXj);
        localad.Nnd.vcr.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
        localad.Nng.kXj.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
        localj.aHZ.postConcat(localMatrix);
        for (;;)
        {
          Log.i(this.NvY.TAG, "operationCallback track info, id:" + localad.id + ", contentRect:" + localad.Nnd.vcr);
          break;
          f1 = paramRectF.centerY() - localRectF.centerY();
          break label293;
          localad.Nnd.vcr.offset(-(int)this.NvY.Nmi.left, -(int)this.NvY.Nmi.top);
        }
        localObject = this.NvY.NvS;
        if (localObject != null)
        {
          localObject = ((ad)localObject).Nnd;
          if (localObject == null) {}
        }
        for (localObject = ((com.tencent.mm.plugin.vlog.model.j)localObject).vcr;; localObject = null)
        {
          if ((localObject == null) || (!this.NvY.NvX.gvf().getContentRect().isEmpty())) {
            this.NvY.NvX.gvf().b(paramRectF, false);
          }
          AppMethodBeat.o(246379);
          return;
        }
      }
    }
    
    public final void rU(boolean paramBoolean)
    {
      AppMethodBeat.i(246380);
      d.C(this.NvY.NvU);
      this.NvY.NvX.getOperationLayout().fyb();
      AppMethodBeat.o(246380);
    }
    
    public final void rV(boolean paramBoolean)
    {
      AppMethodBeat.i(246382);
      d.a(3000L, this.NvY.NvU);
      AppMethodBeat.o(246382);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    f(boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.v
 * JD-Core Version:    0.7.0.1
 */