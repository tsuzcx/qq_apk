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
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "darkDelayRunnable", "Ljava/lang/Runnable;", "isActive", "", "isFullscreenMode", "maxVisibleRect", "Landroid/graphics/RectF;", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "currentPlayingTrack", "enableFullscreenMode", "", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "onUpdate", "playAfterUpdate", "seekToOriginPosition", "seekTo", "setMaxVisibleRect", "rect", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "showVideoLabel", "updateVideoCrop", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  implements d.c, x
{
  final String TAG;
  boolean TMw;
  ac TYA;
  final RectF TZN;
  final RectF TZO;
  d.e Uib;
  final y Uje;
  private final View Ujf;
  ad Ujg;
  private long Ujh;
  final Runnable Uji;
  private final a Ujj;
  private final c Ujk;
  private boolean isActive;
  
  public u(y paramy)
  {
    AppMethodBeat.i(282498);
    this.Uje = paramy;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.Ujf = new View(this.Uje.hSU().getContext());
    this.TZO = new RectF();
    this.TZN = new RectF();
    this.Uji = new u..ExternalSyntheticLambda0(this);
    this.Ujj = new a(this);
    this.Ujk = new c(this);
    AppMethodBeat.o(282498);
  }
  
  private static final void a(u paramu)
  {
    AppMethodBeat.i(282510);
    s.u(paramu, "this$0");
    if (!paramu.TMw) {
      paramu.Uje.getOperationLayout().gJN();
    }
    AppMethodBeat.o(282510);
  }
  
  private static final void b(u paramu)
  {
    AppMethodBeat.i(282520);
    s.u(paramu, "this$0");
    WxCropOperationLayout.a(paramu.Uje.getOperationLayout());
    AppMethodBeat.o(282520);
  }
  
  public final void FU(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final void a(ac paramac, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    AppMethodBeat.i(282574);
    s.u(paramac, "composition");
    Log.i(this.TAG, "onUpdate: playRange:" + paramac.Uaw.jLV() + ", trackList.size:" + ((List)paramac.TDz).size() + ", playAfterUpdate:" + paramBoolean1);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Uje.hSJ();
    if (!s.p(localVideoCompositionPlayView.getParent(), this.Uje.hSU()))
    {
      localObject = localVideoCompositionPlayView.getParent();
      if (!(localObject instanceof ViewGroup)) {
        break label411;
      }
    }
    label411:
    for (Object localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)localVideoCompositionPlayView);
      }
      localVideoCompositionPlayView.setScaleX(1.0F);
      localVideoCompositionPlayView.setScaleY(1.0F);
      localVideoCompositionPlayView.setTranslationX(0.0F);
      localVideoCompositionPlayView.setTranslationY(0.0F);
      Log.i(this.TAG, "videoView size width:" + this.TZO.width() + " height:" + this.TZO.height());
      localObject = new RelativeLayout.LayoutParams((int)this.TZO.width(), (int)this.TZO.height());
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.TZO.top);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.Uje.hSU().addView((View)localVideoCompositionPlayView, 0, (ViewGroup.LayoutParams)localObject);
      if (!this.TMw)
      {
        this.Uje.hSV().getVisibilityRect().set(this.TZN);
        this.Uje.getOperationLayout().getVisibilityRect().set(this.TZN);
      }
      this.TYA = paramac;
      this.Ujg = ((ad)p.ae((List)paramac.TDz, 0));
      hTw();
      if ((!paramBoolean1) || (paramBoolean2) || (paramLong != -1L)) {
        break;
      }
      this.Uje.hSJ().a(paramac.getComposition());
      this.Uje.getOperationLayout().postDelayed(new u..ExternalSyntheticLambda1(this), 3000L);
      AppMethodBeat.o(282574);
      return;
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
    com.tencent.mm.plugin.vlog.model.report.b.report(10L);
    this.Uje.hSJ().a(paramac.getComposition(), paramBoolean1, paramBoolean2, paramLong);
    paramac = this.Uje.getOperationLayout();
    localObject = paramac.NSV;
    if (localObject != null) {
      ((ValueAnimator)localObject).cancel();
    }
    paramac.NSE = 0;
    paramac.invalidate();
    AppMethodBeat.o(282574);
  }
  
  public final void a(d.e parame) {}
  
  public final void h(Size paramSize)
  {
    AppMethodBeat.i(282632);
    s.u(paramSize, "size");
    AppMethodBeat.o(282632);
  }
  
  public final Rect hSP()
  {
    AppMethodBeat.i(282593);
    Rect localRect = new Rect();
    this.Uje.hSV().getVisibilityRect().round(localRect);
    localRect.offset(-(int)this.TZO.left, -(int)this.TZO.top);
    AppMethodBeat.o(282593);
    return localRect;
  }
  
  public final CropLayout.c hTu()
  {
    return (CropLayout.c)this.Ujj;
  }
  
  public final WxCropOperationLayout.i hTv()
  {
    return (WxCropOperationLayout.i)this.Ujk;
  }
  
  public final void hTw()
  {
    AppMethodBeat.i(282602);
    Object localObject = this.Ujg;
    if (localObject == null)
    {
      AppMethodBeat.o(282602);
      return;
    }
    int i = ((ad)localObject).UaC;
    int j = ((ad)localObject).UaD;
    localObject = ((ad)localObject).UaF;
    this.Uje.hSV().setMaxScaleValue(((i)localObject).maxScale);
    this.Uje.hSV().setMinScaleValue(((i)localObject).minScale);
    boolean bool = this.Uje.hSV().getContentRect().isEmpty();
    this.Uje.hSV().getContentRect().set(((i)localObject).yok);
    this.Uje.hSV().getContentRect().offset(0, (int)this.TZO.top);
    this.Uje.hSV().a(this.Ujf, i, j, ((i)localObject).matrix, CropLayout.e.agdu, (kotlin.g.a.b)new u.d(bool));
    Log.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(282602);
  }
  
  public final void hTx()
  {
    AppMethodBeat.i(282628);
    Object localObject = com.tencent.mm.plugin.vlog.model.local.a.UbD;
    localObject = this.Ujg;
    if (localObject == null) {}
    for (localObject = null;; localObject = ((ad)localObject).path)
    {
      int i = com.tencent.mm.plugin.vlog.model.local.a.bfg((String)localObject);
      localObject = this.Uje.hSX();
      com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b localb = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.apN(i));
      AppMethodBeat.o(282628);
      return;
    }
  }
  
  public final void i(RectF paramRectF)
  {
    AppMethodBeat.i(282544);
    s.u(paramRectF, "rect");
    this.TZO.set(paramRectF);
    AppMethodBeat.o(282544);
  }
  
  public final void qU(long paramLong)
  {
    Object localObject2 = null;
    AppMethodBeat.i(282624);
    if (!this.isActive)
    {
      AppMethodBeat.o(282624);
      return;
    }
    this.Ujh = paramLong;
    Object localObject1 = this.TYA;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!s.p(localObject1, this.Ujg))
      {
        localObject3 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
        if (com.tencent.mm.plugin.vlog.model.local.a.hRB())
        {
          localObject3 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
          if (localObject1 != null) {
            break label244;
          }
        }
      }
    }
    for (;;)
    {
      int i = com.tencent.mm.plugin.vlog.model.local.a.bfg((String)localObject2);
      localObject2 = this.Uje.hSX();
      localObject3 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
      ((TextView)localObject2).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.apN(i));
      d.uiThread((kotlin.g.a.a)new b(this, (ad)localObject1));
      AppMethodBeat.o(282624);
      return;
      localObject1 = (List)((ac)localObject1).TDz;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject3 = ((Iterable)localObject1).iterator();
      label165:
      if (((Iterator)localObject3).hasNext())
      {
        localObject1 = ((Iterator)localObject3).next();
        ad localad = (ad)localObject1;
        if ((localad.UaI.startTimeMs <= paramLong) && (localad.UaI.endTimeMs > paramLong))
        {
          i = 1;
          label219:
          if (i == 0) {
            break label236;
          }
        }
      }
      for (;;)
      {
        localObject1 = (ad)localObject1;
        break;
        i = 0;
        break label219;
        label236:
        break label165;
        localObject1 = null;
      }
      label244:
      localObject2 = ((ad)localObject1).path;
    }
  }
  
  public final void setVisibleRect(RectF paramRectF)
  {
    AppMethodBeat.i(282553);
    s.u(paramRectF, "rect");
    this.TZN.set(paramRectF);
    AppMethodBeat.o(282553);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements CropLayout.d
  {
    private float OVa = 1.0F;
    
    a(u paramu) {}
    
    public final void hSY()
    {
      AppMethodBeat.i(282611);
      Object localObject = this.Ujl.TAG;
      d.e locale = this.Ujl.Uib;
      int i;
      float f;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, s.X("onChangeStart: audioSeekable:", Integer.valueOf(i)));
        this.Ujl.Uje.hSJ().pause();
        localObject = this.Ujl.Uib;
        if (localObject != null) {
          ((d.e)localObject).pause();
        }
        localObject = this.Ujl.Ujg;
        if (localObject != null) {
          break label135;
        }
        f = 1.0F;
      }
      for (;;)
      {
        this.OVa = f;
        d.H(this.Ujl.Uji);
        this.Ujl.Uje.getOperationLayout().gJO();
        AppMethodBeat.o(282611);
        return;
        i = 0;
        break;
        label135:
        localObject = ((ad)localObject).UaF;
        if (localObject == null)
        {
          f = 1.0F;
        }
        else
        {
          localObject = ((i)localObject).matrix;
          if (localObject == null) {
            f = 1.0F;
          } else {
            f = t.g((Matrix)localObject);
          }
        }
      }
    }
    
    public final void hSZ()
    {
      int j = 0;
      AppMethodBeat.i(282623);
      Object localObject = this.Ujl.TAG;
      d.e locale = this.Ujl.Uib;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        Log.i((String)localObject, s.X("onChangeEnd: audioSeekable:", Integer.valueOf(i)));
        this.Ujl.Uje.hSW();
        localObject = this.Ujl.Ujg;
        if (localObject != null)
        {
          i = j;
          if (this.OVa == t.g(((ad)localObject).UaF.matrix)) {
            i = 1;
          }
          if (i != 0) {
            break label137;
          }
          localObject = ((ad)localObject).UaH;
          ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        }
      }
      for (;;)
      {
        d.a(3000L, this.Ujl.Uji);
        AppMethodBeat.o(282623);
        return;
        i = 0;
        break;
        label137:
        localObject = ((ad)localObject).UaH;
        ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      }
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(282597);
      Log.i(this.Ujl.TAG, s.X("onChange: ", this.Ujl.Uje.hSV().getContentRect()));
      if (this.Ujl.Uje.hSV().getContentRect().isEmpty())
      {
        AppMethodBeat.o(282597);
        return;
      }
      ad localad = this.Ujl.Ujg;
      if (localad != null)
      {
        u localu = this.Ujl;
        localad.UaF.yok.set(localu.Uje.hSV().getContentRect());
        localad.UaI.Gl.set(localu.Uje.hSV().getContentRect());
        localad.UaF.yok.offset(-(int)localu.TZO.left, -(int)localu.TZO.top);
        localad.UaI.Gl.offset(-(int)localu.TZO.left, -(int)localu.TZO.top);
        localad.UaF.Gl.set(localad.UaF.yok);
      }
      if (!this.Ujl.Uje.hSJ().isPlaying()) {
        this.Ujl.Uje.hSJ().cxp();
      }
      AppMethodBeat.o(282597);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(u paramu, ad paramad)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements WxCropOperationLayout.i
  {
    c(u paramu) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(282598);
      s.u(paramRectF, "rectF");
      this.Ujl.TZN.set(paramRectF);
      Log.i(this.Ujl.TAG, s.X("operationCallback onChange:", paramRectF));
      Object localObject1 = this.Ujl.TYA;
      ad localad;
      i locali;
      float f1;
      Matrix localMatrix;
      RectF localRectF;
      float f2;
      if (localObject1 != null)
      {
        localObject1 = (List)((ac)localObject1).TDz;
        if (localObject1 != null)
        {
          Object localObject2 = (Iterable)localObject1;
          localObject1 = this.Ujl;
          localObject2 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localad = (ad)((Iterator)localObject2).next();
              locali = localad.UaF;
              paramRectF.round(locali.Gl);
              locali.Gl.offset(-(int)((u)localObject1).TZO.left, -(int)((u)localObject1).TZO.top);
              if ((!s.p(((u)localObject1).Ujg, localad)) && (!((u)localObject1).TMw))
              {
                locali.yok.offset(0, (int)((u)localObject1).TZO.top);
                f1 = paramRectF.bottom - locali.yok.bottom;
                float f3 = paramRectF.top - locali.yok.top;
                if ((f1 > 0.0F) || (f3 < 0.0F))
                {
                  localMatrix = new Matrix();
                  localRectF = new RectF(locali.yok);
                  f2 = paramRectF.height() / localRectF.height();
                  if (f2 < 1.0F)
                  {
                    if (f3 >= 0.0F) {
                      break label607;
                    }
                    f1 = f3;
                  }
                }
              }
            }
          }
        }
      }
      label290:
      label607:
      for (;;)
      {
        f2 = 1.0F;
        localMatrix.postTranslate(0.0F, f1);
        localMatrix.postScale(f2, f2, paramRectF.centerX(), paramRectF.centerY());
        localMatrix.mapRect(localRectF);
        localRectF.round(locali.yok);
        localRectF.round(localad.UaI.Gl);
        localad.UaF.yok.offset(-(int)((u)localObject1).TZO.left, -(int)((u)localObject1).TZO.top);
        localad.UaI.Gl.offset(-(int)((u)localObject1).TZO.left, -(int)((u)localObject1).TZO.top);
        locali.matrix.postConcat(localMatrix);
        for (;;)
        {
          Log.i(((u)localObject1).TAG, "operationCallback track info, id:" + localad.id + ", contentRect:" + localad.UaF.yok);
          break;
          f1 = paramRectF.centerY() - localRectF.centerY();
          break label290;
          localad.UaF.yok.offset(-(int)((u)localObject1).TZO.left, -(int)((u)localObject1).TZO.top);
        }
        localObject1 = this.Ujl.Ujg;
        if (localObject1 == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if ((localObject1 == null) || (!this.Ujl.Uje.hSV().getContentRect().isEmpty())) {
            this.Ujl.Uje.hSV().b(paramRectF, false);
          }
          AppMethodBeat.o(282598);
          return;
          localObject1 = ((ad)localObject1).UaF;
          if (localObject1 == null) {
            localObject1 = null;
          } else {
            localObject1 = ((i)localObject1).yok;
          }
        }
      }
    }
    
    public final void vS(boolean paramBoolean)
    {
      AppMethodBeat.i(282605);
      d.H(this.Ujl.Uji);
      this.Ujl.Uje.getOperationLayout().gJO();
      AppMethodBeat.o(282605);
    }
    
    public final void vT(boolean paramBoolean)
    {
      AppMethodBeat.i(282619);
      d.a(3000L, this.Ujl.Uji);
      AppMethodBeat.o(282619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.u
 * JD-Core Version:    0.7.0.1
 */