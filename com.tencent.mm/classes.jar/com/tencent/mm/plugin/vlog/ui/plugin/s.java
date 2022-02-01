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
import com.tencent.mm.ad.c;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.g;
import com.tencent.mm.plugin.vlog.model.m;
import com.tencent.mm.sdk.platformtools.ad;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "updateVideoCrop", "plugin-vlog_release"})
public final class s
  implements c.c, v
{
  final RectF BFA;
  final RectF BFB;
  com.tencent.mm.plugin.vlog.model.v BFd;
  c.e BMG;
  private final View BNN;
  com.tencent.mm.plugin.vlog.model.w BNO;
  private long BNP;
  final Runnable BNQ;
  private final a BNR;
  private final e BNS;
  final w BNT;
  final String TAG;
  private boolean isActive;
  
  public s(w paramw)
  {
    AppMethodBeat.i(196324);
    this.BNT = paramw;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.BNN = new View(this.BNT.etm().getContext());
    this.BFB = new RectF();
    this.BFA = new RectF();
    this.BNQ = ((Runnable)new b(this));
    this.BNR = new a(this);
    this.BNS = new e(this);
    AppMethodBeat.o(196324);
  }
  
  public final void Bq(long paramLong)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(196322);
    if (!this.isActive)
    {
      AppMethodBeat.o(196322);
      return;
    }
    this.BNP = paramLong;
    Object localObject2 = this.BFd;
    Object localObject1 = localIterator;
    int i;
    if (localObject2 != null)
    {
      localObject2 = (List)((com.tencent.mm.plugin.vlog.model.v)localObject2).BGl;
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localIterator = ((Iterable)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label178;
        }
        localObject1 = localIterator.next();
        localObject2 = (com.tencent.mm.plugin.vlog.model.w)localObject1;
        if ((((com.tencent.mm.plugin.vlog.model.w)localObject2).BGw.startTimeMs > paramLong) || (((com.tencent.mm.plugin.vlog.model.w)localObject2).BGw.hiy <= paramLong)) {
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
      if ((p.i(localObject1, this.BNO) ^ true)) {
        c.g((d.g.a.a)new c(this, (com.tencent.mm.plugin.vlog.model.w)localObject1));
      }
      AppMethodBeat.o(196322);
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
    AppMethodBeat.i(196323);
    p.h(paramSize, "size");
    AppMethodBeat.o(196323);
  }
  
  public final void a(com.tencent.mm.plugin.vlog.model.v paramv, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(196319);
    p.h(paramv, "composition");
    ad.i(this.TAG, "onUpdate: playRange:" + paramv.esb() + ", trackList.size:" + ((List)paramv.BGl).size() + ", playAfterUpdate:" + paramBoolean1);
    this.BNT.etn().yM(true);
    this.BNT.etn().setEnableScale(true);
    VideoCompositionPlayView localVideoCompositionPlayView = this.BNT.eth();
    if ((p.i(localVideoCompositionPlayView.getParent(), this.BNT.etm()) ^ true))
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
      ad.i(this.TAG, "videoView size width:" + this.BFB.width() + " height:" + this.BFB.height());
      localObject1 = new RelativeLayout.LayoutParams((int)this.BFB.width(), (int)this.BFB.height());
      ((RelativeLayout.LayoutParams)localObject1).topMargin = ((int)this.BFB.top);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      this.BNT.etm().addView((View)localVideoCompositionPlayView, 0, (ViewGroup.LayoutParams)localObject1);
    }
    this.BNT.etn().getVisibilityRect().set(this.BFA);
    this.BNT.getOperationLayout().getVisibilityRect().set(this.BFA);
    this.BFd = paramv;
    this.BNO = ((com.tencent.mm.plugin.vlog.model.w)j.E((List)paramv.BGl, 0));
    etC();
    if ((paramBoolean1) && (!paramBoolean2) && (paramLong == -1L))
    {
      this.BNT.eth().a(paramv.getComposition());
      this.BNT.getOperationLayout().postDelayed((Runnable)new d(this), 3000L);
      AppMethodBeat.o(196319);
      return;
    }
    Object localObject1 = com.tencent.mm.plugin.vlog.model.report.b.BHP;
    com.tencent.mm.plugin.vlog.model.report.b.report(10L);
    localObject1 = this.BNT.eth();
    paramv = paramv.getComposition();
    p.h(paramv, "composition");
    com.tencent.mm.videocomposition.c.b.i(VideoCompositionPlayView.TAG, "updateComposition, playAfterUpdate:" + paramBoolean1 + ", seekToOriginPosition:" + paramBoolean2 + ", seekTo:" + paramLong, new Object[0]);
    Object localObject2 = ((VideoCompositionPlayView)localObject1).LmY;
    if (localObject2 != null) {
      ((com.tencent.mm.videocomposition.play.a)localObject2).a(paramv, paramBoolean1, paramBoolean2, paramLong);
    }
    ((VideoCompositionPlayView)localObject1).BGk = paramv;
    paramv = this.BNT.getOperationLayout();
    localObject1 = paramv.xIF;
    if (localObject1 != null) {
      ((ValueAnimator)localObject1).cancel();
    }
    paramv.xIo = 0;
    paramv.invalidate();
    AppMethodBeat.o(196319);
  }
  
  public final void a(c.e parame) {}
  
  public final CropLayout.c etA()
  {
    return (CropLayout.c)this.BNR;
  }
  
  public final WxCropOperationLayout.i etB()
  {
    return (WxCropOperationLayout.i)this.BNS;
  }
  
  public final void etC()
  {
    AppMethodBeat.i(196321);
    Object localObject = this.BNO;
    if (localObject == null)
    {
      AppMethodBeat.o(196321);
      return;
    }
    int i = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGr;
    int j = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGs;
    localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGu;
    this.BNT.etn().setMaxScaleValue(((g)localObject).aXE);
    this.BNT.etn().setMinScaleValue(((g)localObject).aXF);
    boolean bool = this.BNT.etn().getContentRect().isEmpty();
    this.BNT.etn().getContentRect().set(((g)localObject).pZj);
    this.BNT.etn().getContentRect().offset(0, (int)this.BFB.top);
    this.BNT.etn().a(this.BNN, i, j, ((g)localObject).gR, CropLayout.e.KVo, (d.g.a.b)new s.f(bool));
    ad.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(196321);
  }
  
  public final Rect eti()
  {
    AppMethodBeat.i(196320);
    Rect localRect = new Rect();
    this.BNT.etn().getVisibilityRect().round(localRect);
    localRect.offset(0, -(int)this.BFB.top);
    AppMethodBeat.o(196320);
    return localRect;
  }
  
  public final void g(RectF paramRectF)
  {
    AppMethodBeat.i(196318);
    p.h(paramRectF, "rect");
    this.BFA.set(paramRectF);
    AppMethodBeat.o(196318);
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(196317);
    p.h(paramRectF, "rect");
    this.BFB.set(paramRectF);
    AppMethodBeat.o(196317);
  }
  
  public final void sU(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.d
  {
    private float BNh = 1.0F;
    
    public final void etp()
    {
      AppMethodBeat.i(196308);
      Object localObject = this.BNU.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      c.e locale = this.BNU.BMG;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ad.i((String)localObject, i);
        this.BNU.BNT.eth().pause();
        localObject = this.BNU.BMG;
        if (localObject != null) {
          ((c.e)localObject).pause();
        }
        localObject = this.BNU.BNO;
        if (localObject == null) {
          break label167;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGu;
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
        this.BNh = f;
        c.B(this.BNU.BNQ);
        this.BNU.BNT.getOperationLayout().dHq();
        AppMethodBeat.o(196308);
        return;
        i = 0;
        break;
      }
    }
    
    public final void etq()
    {
      AppMethodBeat.i(196309);
      Object localObject = this.BNU.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      c.e locale = this.BNU.BMG;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ad.i((String)localObject, i);
        this.BNU.BNT.eto();
        localObject = this.BNU.BNO;
        if (localObject != null)
        {
          if (this.BNh == m.e(((com.tencent.mm.plugin.vlog.model.w)localObject).BGu.gR)) {
            break label136;
          }
          localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGv;
          ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        }
      }
      for (;;)
      {
        c.a(3000L, this.BNU.BNQ);
        AppMethodBeat.o(196309);
        return;
        i = 0;
        break;
        label136:
        localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGv;
        ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      }
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(196307);
      ad.i(this.BNU.TAG, "onChange: " + this.BNU.BNT.etn().getContentRect());
      if (this.BNU.BNT.etn().getContentRect().isEmpty())
      {
        AppMethodBeat.o(196307);
        return;
      }
      com.tencent.mm.plugin.vlog.model.w localw = this.BNU.BNO;
      if (localw != null)
      {
        localw.BGu.pZj.set(this.BNU.BNT.etn().getContentRect());
        localw.BGw.hmm.set(this.BNU.BNT.etn().getContentRect());
        localw.BGu.pZj.offset(0, -(int)this.BNU.BFB.top);
        localw.BGw.hmm.offset(0, -(int)this.BNU.BFB.top);
      }
      if (!this.BNU.BNT.eth().isPlaying()) {
        this.BNU.BNT.eth().boO();
      }
      AppMethodBeat.o(196307);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(196310);
      this.BNU.BNT.getOperationLayout().dHp();
      AppMethodBeat.o(196310);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<z>
  {
    c(s params, com.tencent.mm.plugin.vlog.model.w paramw)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(s params) {}
    
    public final void run()
    {
      AppMethodBeat.i(196312);
      WxCropOperationLayout.a(this.BNU.BNT.getOperationLayout());
      AppMethodBeat.o(196312);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(196313);
      p.h(paramRectF, "rectF");
      this.BNU.BNT.eth().pause();
      this.BNU.BFA.set(paramRectF);
      ad.i(this.BNU.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject = this.BNU.BFd;
      com.tencent.mm.plugin.vlog.model.w localw;
      g localg;
      float f1;
      Matrix localMatrix;
      RectF localRectF;
      float f2;
      if (localObject != null)
      {
        localObject = (List)((com.tencent.mm.plugin.vlog.model.v)localObject).BGl;
        if (localObject != null)
        {
          localObject = ((Iterable)localObject).iterator();
          for (;;)
          {
            if (((Iterator)localObject).hasNext())
            {
              localw = (com.tencent.mm.plugin.vlog.model.w)((Iterator)localObject).next();
              localg = localw.BGu;
              paramRectF.round(localg.hmm);
              localg.hmm.offset(0, -(int)this.BNU.BFB.top);
              if (!p.i(this.BNU.BNO, localw))
              {
                localg.pZj.offset(0, (int)this.BNU.BFB.top);
                f1 = paramRectF.bottom - localg.pZj.bottom;
                float f3 = paramRectF.top - localg.pZj.top;
                if ((f1 > 0.0F) || (f3 < 0.0F))
                {
                  localMatrix = new Matrix();
                  localRectF = new RectF(localg.pZj);
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
        localRectF.round(localg.pZj);
        localRectF.round(localw.BGw.hmm);
        localw.BGu.pZj.offset(0, -(int)this.BNU.BFB.top);
        localw.BGw.hmm.offset(0, -(int)this.BNU.BFB.top);
        localg.gR.postConcat(localMatrix);
        for (;;)
        {
          ad.i(this.BNU.TAG, "operationCallback track info, id:" + localw.id + ", contentRect:" + localw.BGu.pZj);
          break;
          f1 = paramRectF.centerY() - localRectF.centerY();
          break label288;
          localw.BGu.pZj.offset(0, -(int)this.BNU.BFB.top);
        }
        localObject = this.BNU.BNO;
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.plugin.vlog.model.w)localObject).BGu;
          if (localObject == null) {}
        }
        for (localObject = ((g)localObject).pZj;; localObject = null)
        {
          if ((localObject == null) || (!this.BNU.BNT.etn().getContentRect().isEmpty())) {
            this.BNU.BNT.etn().i(paramRectF);
          }
          this.BNU.BNT.eth().resume();
          AppMethodBeat.o(196313);
          return;
        }
      }
    }
    
    public final void mO(boolean paramBoolean)
    {
      AppMethodBeat.i(196314);
      c.B(this.BNU.BNQ);
      this.BNU.BNT.getOperationLayout().dHq();
      AppMethodBeat.o(196314);
    }
    
    public final void mP(boolean paramBoolean)
    {
      AppMethodBeat.i(196315);
      c.a(3000L, this.BNU.BNQ);
      AppMethodBeat.o(196315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.s
 * JD-Core Version:    0.7.0.1
 */