package com.tencent.mm.plugin.vlog.ui.plugin;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.mm.videocomposition.n;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "isFullscreenMode", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "currentPlayingTrack", "enableFullscreenMode", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "updateVideoCrop", "plugin-vlog_release"})
public final class w
  implements e.c, z
{
  e.e GGU;
  private final View GId;
  ad GIe;
  private long GIf;
  final Runnable GIg;
  private final a GIh;
  private final e GIi;
  final aa GIj;
  boolean Gna;
  ac GxA;
  final RectF GyF;
  final RectF GyG;
  final String TAG;
  private boolean isActive;
  
  public w(aa paramaa)
  {
    AppMethodBeat.i(191449);
    this.GIj = paramaa;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.GId = new View(this.GIj.fDf().getContext());
    this.GyG = new RectF();
    this.GyF = new RectF();
    this.GIg = ((Runnable)new b(this));
    this.GIh = new a(this);
    this.GIi = new e(this);
    AppMethodBeat.o(191449);
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(191448);
    p.h(paramSize, "size");
    AppMethodBeat.o(191448);
  }
  
  public final void a(ac paramac, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(191443);
    p.h(paramac, "composition");
    Log.i(this.TAG, "onUpdate: playRange:" + paramac.Gez.hfo() + ", trackList.size:" + ((List)paramac.Gzn).size() + ", playAfterUpdate:" + paramBoolean1);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GIj.fCU();
    if ((p.j(localVideoCompositionPlayView.getParent(), this.GIj.fDf()) ^ true))
    {
      localObject2 = localVideoCompositionPlayView.getParent();
      localObject1 = localObject2;
      if (!(localObject2 instanceof ViewGroup)) {
        localObject1 = null;
      }
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null) {
        ((ViewGroup)localObject1).removeView((View)localVideoCompositionPlayView);
      }
      localVideoCompositionPlayView.setScaleX(1.0F);
      localVideoCompositionPlayView.setScaleY(1.0F);
      localVideoCompositionPlayView.setTranslationX(0.0F);
      localVideoCompositionPlayView.setTranslationY(0.0F);
      Log.i(this.TAG, "videoView size width:" + this.GyG.width() + " height:" + this.GyG.height());
      localObject1 = new RelativeLayout.LayoutParams((int)this.GyG.width(), (int)this.GyG.height());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.GyG.top);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      this.GIj.fDf().addView((View)localVideoCompositionPlayView, 0, (ViewGroup.LayoutParams)localObject1);
    }
    if (!this.Gna)
    {
      this.GIj.fDg().getVisibilityRect().set(this.GyF);
      this.GIj.getOperationLayout().getVisibilityRect().set(this.GyF);
    }
    this.GxA = paramac;
    this.GIe = ((ad)kotlin.a.j.L((List)paramac.Gzn, 0));
    fDJ();
    if ((paramBoolean1) && (!paramBoolean2) && (paramLong == -1L))
    {
      this.GIj.fCU().a(paramac.getComposition());
      this.GIj.getOperationLayout().postDelayed((Runnable)new d(this), 3000L);
      AppMethodBeat.o(191443);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.vlog.model.report.b.GBb;
    com.tencent.mm.plugin.vlog.model.report.b.report(10L);
    localObject1 = this.GIj.fCU();
    paramac = paramac.getComposition();
    p.h(paramac, "composition");
    com.tencent.mm.videocomposition.c.b.i(VideoCompositionPlayView.TAG, "updateComposition, playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong, new Object[0]);
    Object localObject2 = ((VideoCompositionPlayView)localObject1).RhC;
    if (localObject2 != null) {
      ((com.tencent.mm.videocomposition.play.a)localObject2).a(paramac, paramBoolean1, paramBoolean2, paramLong);
    }
    ((VideoCompositionPlayView)localObject1).Gez = paramac;
    paramac = this.GIj.getOperationLayout();
    localObject1 = paramac.BZs;
    if (localObject1 != null) {
      ((ValueAnimator)localObject1).cancel();
    }
    paramac.BZb = 0;
    paramac.invalidate();
    AppMethodBeat.o(191443);
  }
  
  public final void a(e.e parame) {}
  
  public final CropLayout.c fDH()
  {
    return (CropLayout.c)this.GIh;
  }
  
  public final WxCropOperationLayout.i fDI()
  {
    return (WxCropOperationLayout.i)this.GIi;
  }
  
  public final void fDJ()
  {
    AppMethodBeat.i(191445);
    Object localObject = this.GIe;
    if (localObject == null)
    {
      AppMethodBeat.o(191445);
      return;
    }
    int i = ((ad)localObject).Gzu;
    int j = ((ad)localObject).Gzv;
    localObject = ((ad)localObject).Gzx;
    this.GIj.fDg().setMaxScaleValue(((com.tencent.mm.plugin.vlog.model.j)localObject).aXt);
    this.GIj.fDg().setMinScaleValue(((com.tencent.mm.plugin.vlog.model.j)localObject).aXu);
    boolean bool = this.GIj.fDg().getContentRect().isEmpty();
    this.GIj.fDg().getContentRect().set(((com.tencent.mm.plugin.vlog.model.j)localObject).rwL);
    this.GIj.fDg().getContentRect().offset(0, (int)this.GyG.top);
    this.GIj.fDg().a(this.GId, i, j, ((com.tencent.mm.plugin.vlog.model.j)localObject).gT, CropLayout.e.QME, (kotlin.g.a.b)new w.f(bool));
    Log.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(191445);
  }
  
  public final void fDK()
  {
    AppMethodBeat.i(191447);
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.GAD;
    localObject = this.GIe;
    if (localObject != null) {}
    for (localObject = ((ad)localObject).path;; localObject = null)
    {
      int i = com.tencent.mm.plugin.vlog.model.local.a.aUc((String)localObject);
      localObject = this.GIj.fDi();
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b localb = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(i));
      AppMethodBeat.o(191447);
      return;
    }
  }
  
  public final Rect fDa()
  {
    AppMethodBeat.i(191444);
    Rect localRect = new Rect();
    this.GIj.fDg().getVisibilityRect().round(localRect);
    localRect.offset(0, -(int)this.GyG.top);
    AppMethodBeat.o(191444);
    return localRect;
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(191442);
    p.h(paramRectF, "rect");
    this.GyF.set(paramRectF);
    AppMethodBeat.o(191442);
  }
  
  public final void i(RectF paramRectF)
  {
    AppMethodBeat.i(191441);
    p.h(paramRectF, "rect");
    this.GyG.set(paramRectF);
    AppMethodBeat.o(191441);
  }
  
  public final void onProgress(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191446);
    if (!this.isActive)
    {
      AppMethodBeat.o(191446);
      return;
    }
    this.GIf = paramLong;
    Object localObject1 = this.GxA;
    Object localObject3;
    int i;
    if (localObject1 != null)
    {
      localObject1 = (List)((ac)localObject1).Gzn;
      if (localObject1 != null)
      {
        localObject3 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          ad localad = (ad)localObject1;
          if ((localad.GzA.startTimeMs <= paramLong) && (localad.GzA.endTimeMs > paramLong))
          {
            i = 1;
            label120:
            if (i == 0) {
              break label233;
            }
          }
        }
      }
    }
    label124:
    for (localObject1 = (ad)localObject1;; localObject1 = null)
    {
      if ((p.j(localObject1, this.GIe) ^ true))
      {
        localObject3 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        if (com.tencent.mm.plugin.vlog.model.local.a.fBV())
        {
          localObject3 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
          if (localObject1 != null) {
            localObject2 = ((ad)localObject1).path;
          }
          i = com.tencent.mm.plugin.vlog.model.local.a.aUc((String)localObject2);
          localObject2 = this.GIj.fDi();
          localObject3 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
          ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(i));
        }
        com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this, (ad)localObject1));
      }
      AppMethodBeat.o(191446);
      return;
      i = 0;
      break label120;
      break;
      localObject1 = null;
      break label124;
    }
  }
  
  public final void wH(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.d
  {
    private float CIE = 1.0F;
    
    public final void fDj()
    {
      AppMethodBeat.i(191432);
      Object localObject = this.GIk.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      e.e locale = this.GIk.GGU;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, i);
        this.GIk.GIj.fCU().pause();
        localObject = this.GIk.GGU;
        if (localObject != null) {
          ((e.e)localObject).pause();
        }
        localObject = this.GIk.GIe;
        if (localObject == null) {
          break label167;
        }
        localObject = ((ad)localObject).Gzx;
        if (localObject == null) {
          break label167;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.j)localObject).gT;
        if (localObject == null) {
          break label167;
        }
      }
      label167:
      for (float f = t.e((Matrix)localObject);; f = 1.0F)
      {
        this.CIE = f;
        com.tencent.mm.ac.d.C(this.GIk.GIg);
        this.GIk.GIj.getOperationLayout().eLG();
        AppMethodBeat.o(191432);
        return;
        i = 0;
        break;
      }
    }
    
    public final void fDk()
    {
      AppMethodBeat.i(191433);
      Object localObject = this.GIk.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      e.e locale = this.GIk.GGU;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, i);
        this.GIk.GIj.fDh();
        localObject = this.GIk.GIe;
        if (localObject != null)
        {
          if (this.CIE == t.e(((ad)localObject).Gzx.gT)) {
            break label136;
          }
          localObject = ((ad)localObject).Gzz;
          ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        }
      }
      for (;;)
      {
        com.tencent.mm.ac.d.a(3000L, this.GIk.GIg);
        AppMethodBeat.o(191433);
        return;
        i = 0;
        break;
        label136:
        localObject = ((ad)localObject).Gzz;
        ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      }
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(191431);
      Log.i(this.GIk.TAG, "onChange: " + this.GIk.GIj.fDg().getContentRect());
      if (this.GIk.GIj.fDg().getContentRect().isEmpty())
      {
        AppMethodBeat.o(191431);
        return;
      }
      ad localad = this.GIk.GIe;
      if (localad != null)
      {
        localad.Gzx.rwL.set(this.GIk.GIj.fDg().getContentRect());
        localad.GzA.iiw.set(this.GIk.GIj.fDg().getContentRect());
        localad.Gzx.rwL.offset(0, -(int)this.GIk.GyG.top);
        localad.GzA.iiw.offset(0, -(int)this.GIk.GyG.top);
        localad.Gzx.iiw.set(localad.Gzx.rwL);
      }
      if (!this.GIk.GIj.fCU().isPlaying()) {
        this.GIk.GIj.fCU().bLe();
      }
      AppMethodBeat.o(191431);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(191434);
      if (!this.GIk.Gna) {
        this.GIk.GIj.getOperationLayout().eLF();
      }
      AppMethodBeat.o(191434);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(w paramw, ad paramad)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(w paramw) {}
    
    public final void run()
    {
      AppMethodBeat.i(191436);
      WxCropOperationLayout.a(this.GIk.GIj.getOperationLayout());
      AppMethodBeat.o(191436);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191437);
      p.h(paramRectF, "rectF");
      this.GIk.GyF.set(paramRectF);
      Log.i(this.GIk.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject = this.GIk.GxA;
      ad localad;
      com.tencent.mm.plugin.vlog.model.j localj;
      float f1;
      Matrix localMatrix;
      RectF localRectF;
      float f2;
      if (localObject != null)
      {
        localObject = (List)((ac)localObject).Gzn;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localad = (ad)((Iterator)localObject).next();
              localj = localad.Gzx;
              paramRectF.round(localj.iiw);
              localj.iiw.offset(0, -(int)this.GIk.GyG.top);
              if ((!p.j(this.GIk.GIe, localad)) && (!this.GIk.Gna))
              {
                localj.rwL.offset(0, (int)this.GIk.GyG.top);
                f1 = paramRectF.bottom - localj.rwL.bottom;
                float f3 = paramRectF.top - localj.rwL.top;
                if ((f1 > 0.0F) || (f3 < 0.0F))
                {
                  localMatrix = new Matrix();
                  localRectF = new RectF(localj.rwL);
                  f2 = paramRectF.height() / localRectF.height();
                  if (f2 < 1.0F)
                  {
                    if (f3 >= 0.0F) {
                      break label574;
                    }
                    f1 = f3;
                  }
                }
              }
            }
          }
        }
      }
      label282:
      label574:
      for (;;)
      {
        f2 = 1.0F;
        localMatrix.postTranslate(0.0F, f1);
        localMatrix.postScale(f2, f2, paramRectF.centerX(), paramRectF.centerY());
        localMatrix.mapRect(localRectF);
        localRectF.round(localj.rwL);
        localRectF.round(localad.GzA.iiw);
        localad.Gzx.rwL.offset(0, -(int)this.GIk.GyG.top);
        localad.GzA.iiw.offset(0, -(int)this.GIk.GyG.top);
        localj.gT.postConcat(localMatrix);
        for (;;)
        {
          Log.i(this.GIk.TAG, "operationCallback track info, id:" + localad.id + ", contentRect:" + localad.Gzx.rwL);
          break;
          f1 = paramRectF.centerY() - localRectF.centerY();
          break label282;
          localad.Gzx.rwL.offset(0, -(int)this.GIk.GyG.top);
        }
        localObject = this.GIk.GIe;
        if (localObject != null)
        {
          localObject = ((ad)localObject).Gzx;
          if (localObject == null) {}
        }
        for (localObject = ((com.tencent.mm.plugin.vlog.model.j)localObject).rwL;; localObject = null)
        {
          if ((localObject == null) || (!this.GIk.GIj.fDg().getContentRect().isEmpty())) {
            this.GIk.GIj.fDg().b(paramRectF, false);
          }
          AppMethodBeat.o(191437);
          return;
        }
      }
    }
    
    public final void pA(boolean paramBoolean)
    {
      AppMethodBeat.i(191439);
      com.tencent.mm.ac.d.a(3000L, this.GIk.GIg);
      AppMethodBeat.o(191439);
    }
    
    public final void pz(boolean paramBoolean)
    {
      AppMethodBeat.i(191438);
      com.tencent.mm.ac.d.C(this.GIk.GIg);
      this.GIk.GIj.getOperationLayout().eLG();
      AppMethodBeat.o(191438);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.w
 * JD-Core Version:    0.7.0.1
 */