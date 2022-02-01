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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import d.a.j;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "updateVideoCrop", "plugin-vlog_release"})
public final class s
  implements c.c, v
{
  com.tencent.mm.plugin.vlog.model.v BWB;
  final RectF BWY;
  final RectF BWZ;
  c.e Cef;
  private final View Cfm;
  com.tencent.mm.plugin.vlog.model.w Cfn;
  private long Cfo;
  final Runnable Cfp;
  private final a Cfq;
  private final e Cfr;
  final w Cfs;
  final String TAG;
  private boolean isActive;
  
  public s(w paramw)
  {
    AppMethodBeat.i(191783);
    this.Cfs = paramw;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.Cfm = new View(this.Cfs.ewT().getContext());
    this.BWZ = new RectF();
    this.BWY = new RectF();
    this.Cfp = ((Runnable)new b(this));
    this.Cfq = new a(this);
    this.Cfr = new e(this);
    AppMethodBeat.o(191783);
  }
  
  public final void BO(long paramLong)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(191781);
    if (!this.isActive)
    {
      AppMethodBeat.o(191781);
      return;
    }
    this.Cfo = paramLong;
    Object localObject2 = this.BWB;
    Object localObject1 = localIterator;
    int i;
    if (localObject2 != null)
    {
      localObject2 = (List)((com.tencent.mm.plugin.vlog.model.v)localObject2).BXJ;
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localIterator = ((Iterable)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label178;
        }
        localObject1 = localIterator.next();
        localObject2 = (com.tencent.mm.plugin.vlog.model.w)localObject1;
        if ((((com.tencent.mm.plugin.vlog.model.w)localObject2).BXV.startTimeMs > paramLong) || (((com.tencent.mm.plugin.vlog.model.w)localObject2).BXV.hlm <= paramLong)) {
          break label173;
        }
        i = 1;
        label126:
        if (i == 0) {
          break label176;
        }
      }
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.vlog.model.w)localObject1;
      if ((p.i(localObject1, this.Cfn) ^ true)) {
        c.h((d.g.a.a)new c(this, (com.tencent.mm.plugin.vlog.model.w)localObject1));
      }
      AppMethodBeat.o(191781);
      return;
      label173:
      i = 0;
      break label126;
      label176:
      break;
      label178:
      localObject1 = null;
    }
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(191782);
    p.h(paramSize, "size");
    AppMethodBeat.o(191782);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.v paramv, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(191778);
    p.h(paramv, "composition");
    ae.i(this.TAG, "onUpdate: playRange:" + paramv.evI() + ", trackList.size:" + ((List)paramv.BXJ).size() + ", playAfterUpdate:" + paramBoolean1);
    this.Cfs.ewU().za(true);
    this.Cfs.ewU().setEnableScale(true);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Cfs.ewO();
    if ((p.i(localVideoCompositionPlayView.getParent(), this.Cfs.ewT()) ^ true))
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
      ae.i(this.TAG, "videoView size width:" + this.BWZ.width() + " height:" + this.BWZ.height());
      localObject1 = new RelativeLayout.LayoutParams((int)this.BWZ.width(), (int)this.BWZ.height());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.BWZ.top);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      this.Cfs.ewT().addView((View)localVideoCompositionPlayView, 0, (ViewGroup.LayoutParams)localObject1);
    }
    this.Cfs.ewU().getVisibilityRect().set(this.BWY);
    this.Cfs.getOperationLayout().getVisibilityRect().set(this.BWY);
    this.BWB = paramv;
    this.Cfn = ((com.tencent.mm.plugin.vlog.model.w)j.F((List)paramv.BXJ, 0));
    exj();
    if ((paramBoolean1) && (!paramBoolean2) && (paramLong == -1L))
    {
      this.Cfs.ewO().a(paramv.getComposition());
      this.Cfs.getOperationLayout().postDelayed((Runnable)new d(this), 3000L);
      AppMethodBeat.o(191778);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.vlog.model.report.b.BZo;
    com.tencent.mm.plugin.vlog.model.report.b.report(10L);
    localObject1 = this.Cfs.ewO();
    paramv = paramv.getComposition();
    p.h(paramv, "composition");
    com.tencent.mm.videocomposition.c.b.i(VideoCompositionPlayView.TAG, "updateComposition, playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong, new Object[0]);
    Object localObject2 = ((VideoCompositionPlayView)localObject1).LJJ;
    if (localObject2 != null) {
      ((com.tencent.mm.videocomposition.play.a)localObject2).a(paramv, paramBoolean1, paramBoolean2, paramLong);
    }
    ((VideoCompositionPlayView)localObject1).BXI = paramv;
    paramv = this.Cfs.getOperationLayout();
    localObject1 = paramv.xYA;
    if (localObject1 != null) {
      ((ValueAnimator)localObject1).cancel();
    }
    paramv.xYj = 0;
    paramv.invalidate();
    AppMethodBeat.o(191778);
  }
  
  public final void a(c.e parame) {}
  
  public final Rect ewP()
  {
    AppMethodBeat.i(191779);
    Rect localRect = new Rect();
    this.Cfs.ewU().getVisibilityRect().round(localRect);
    localRect.offset(0, -(int)this.BWZ.top);
    AppMethodBeat.o(191779);
    return localRect;
  }
  
  public final CropLayout.c exh()
  {
    return (CropLayout.c)this.Cfq;
  }
  
  public final WxCropOperationLayout.i exi()
  {
    return (WxCropOperationLayout.i)this.Cfr;
  }
  
  public final void exj()
  {
    AppMethodBeat.i(191780);
    Object localObject = this.Cfn;
    if (localObject == null)
    {
      AppMethodBeat.o(191780);
      return;
    }
    int i = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXQ;
    int j = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXR;
    localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXT;
    this.Cfs.ewU().setMaxScaleValue(((g)localObject).aXE);
    this.Cfs.ewU().setMinScaleValue(((g)localObject).aXF);
    boolean bool = this.Cfs.ewU().getContentRect().isEmpty();
    this.Cfs.ewU().getContentRect().set(((g)localObject).qfO);
    this.Cfs.ewU().getContentRect().offset(0, (int)this.BWZ.top);
    this.Cfs.ewU().a(this.Cfm, i, j, ((g)localObject).gR, CropLayout.e.LrM, (d.g.a.b)new s.f(bool));
    ae.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(191780);
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(191777);
    p.h(paramRectF, "rect");
    this.BWY.set(paramRectF);
    AppMethodBeat.o(191777);
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(191776);
    p.h(paramRectF, "rect");
    this.BWZ.set(paramRectF);
    AppMethodBeat.o(191776);
  }
  
  public final void tb(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.d
  {
    private float CeG = 1.0F;
    
    public final void ewW()
    {
      AppMethodBeat.i(191767);
      Object localObject = this.Cft.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      c.e locale = this.Cft.Cef;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ae.i((String)localObject, i);
        this.Cft.Cfs.ewO().pause();
        localObject = this.Cft.Cef;
        if (localObject != null) {
          ((c.e)localObject).pause();
        }
        localObject = this.Cft.Cfn;
        if (localObject == null) {
          break label167;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXT;
        if (localObject == null) {
          break label167;
        }
        localObject = ((g)localObject).gR;
        if (localObject == null) {
          break label167;
        }
      }
      label167:
      for (float f = m.e((Matrix)localObject);; f = 1.0F)
      {
        this.CeG = f;
        c.z(this.Cft.Cfp);
        this.Cft.Cfs.getOperationLayout().dKH();
        AppMethodBeat.o(191767);
        return;
        i = 0;
        break;
      }
    }
    
    public final void ewX()
    {
      AppMethodBeat.i(191768);
      Object localObject = this.Cft.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      c.e locale = this.Cft.Cef;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ae.i((String)localObject, i);
        this.Cft.Cfs.ewV();
        localObject = this.Cft.Cfn;
        if (localObject != null)
        {
          if (this.CeG == m.e(((com.tencent.mm.plugin.vlog.model.w)localObject).BXT.gR)) {
            break label136;
          }
          localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXU;
          ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        }
      }
      for (;;)
      {
        c.a(3000L, this.Cft.Cfp);
        AppMethodBeat.o(191768);
        return;
        i = 0;
        break;
        label136:
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXU;
        ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      }
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(191766);
      ae.i(this.Cft.TAG, "onChange: " + this.Cft.Cfs.ewU().getContentRect());
      if (this.Cft.Cfs.ewU().getContentRect().isEmpty())
      {
        AppMethodBeat.o(191766);
        return;
      }
      com.tencent.mm.plugin.vlog.model.w localw = this.Cft.Cfn;
      if (localw != null)
      {
        localw.BXT.qfO.set(this.Cft.Cfs.ewU().getContentRect());
        localw.BXV.hpa.set(this.Cft.Cfs.ewU().getContentRect());
        localw.BXT.qfO.offset(0, -(int)this.Cft.BWZ.top);
        localw.BXV.hpa.offset(0, -(int)this.Cft.BWZ.top);
      }
      if (!this.Cft.Cfs.ewO().isPlaying()) {
        this.Cft.Cfs.ewO().bpy();
      }
      AppMethodBeat.o(191766);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(191769);
      this.Cft.Cfs.getOperationLayout().dKG();
      AppMethodBeat.o(191769);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(s params, com.tencent.mm.plugin.vlog.model.w paramw)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(191771);
      WxCropOperationLayout.a(this.Cft.Cfs.getOperationLayout());
      AppMethodBeat.o(191771);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191772);
      p.h(paramRectF, "rectF");
      this.Cft.Cfs.ewO().pause();
      this.Cft.BWY.set(paramRectF);
      ae.i(this.Cft.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject = this.Cft.BWB;
      com.tencent.mm.plugin.vlog.model.w localw;
      g localg;
      float f1;
      Matrix localMatrix;
      RectF localRectF;
      float f2;
      if (localObject != null)
      {
        localObject = (List)((com.tencent.mm.plugin.vlog.model.v)localObject).BXJ;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localw = (com.tencent.mm.plugin.vlog.model.w)((Iterator)localObject).next();
              localg = localw.BXT;
              paramRectF.round(localg.hpa);
              localg.hpa.offset(0, -(int)this.Cft.BWZ.top);
              if (!p.i(this.Cft.Cfn, localw))
              {
                localg.qfO.offset(0, (int)this.Cft.BWZ.top);
                f1 = paramRectF.bottom - localg.qfO.bottom;
                float f3 = paramRectF.top - localg.qfO.top;
                if ((f1 > 0.0F) || (f3 < 0.0F))
                {
                  localMatrix = new Matrix();
                  localRectF = new RectF(localg.qfO);
                  f2 = paramRectF.height() / localRectF.height();
                  if (f2 < 1.0F)
                  {
                    if (f3 >= 0.0F) {
                      break label594;
                    }
                    f1 = f3;
                  }
                }
              }
            }
          }
        }
      }
      label288:
      label594:
      for (;;)
      {
        f2 = 1.0F;
        localMatrix.postTranslate(0.0F, f1);
        localMatrix.postScale(f2, f2, paramRectF.centerX(), paramRectF.centerY());
        localMatrix.mapRect(localRectF);
        localRectF.round(localg.qfO);
        localRectF.round(localw.BXV.hpa);
        localw.BXT.qfO.offset(0, -(int)this.Cft.BWZ.top);
        localw.BXV.hpa.offset(0, -(int)this.Cft.BWZ.top);
        localg.gR.postConcat(localMatrix);
        for (;;)
        {
          ae.i(this.Cft.TAG, "operationCallback track info, id:" + localw.id + ", contentRect:" + localw.BXT.qfO);
          break;
          f1 = paramRectF.centerY() - localRectF.centerY();
          break label288;
          localw.BXT.qfO.offset(0, -(int)this.Cft.BWZ.top);
        }
        localObject = this.Cft.Cfn;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BXT;
          if (localObject == null) {}
        }
        for (localObject = ((g)localObject).qfO;; localObject = null)
        {
          if ((localObject == null) || (!this.Cft.Cfs.ewU().getContentRect().isEmpty())) {
            this.Cft.Cfs.ewU().i(paramRectF);
          }
          this.Cft.Cfs.ewO().resume();
          AppMethodBeat.o(191772);
          return;
        }
      }
    }
    
    public final void mS(boolean paramBoolean)
    {
      AppMethodBeat.i(191773);
      c.z(this.Cft.Cfp);
      this.Cft.Cfs.getOperationLayout().dKH();
      AppMethodBeat.o(191773);
    }
    
    public final void mT(boolean paramBoolean)
    {
      AppMethodBeat.i(191774);
      c.a(3000L, this.Cft.Cfp);
      AppMethodBeat.o(191774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s
 * JD-Core Version:    0.7.0.1
 */