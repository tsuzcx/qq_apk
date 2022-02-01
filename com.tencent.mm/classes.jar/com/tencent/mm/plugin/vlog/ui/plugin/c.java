package com.tencent.mm.plugin.vlog.ui.plugin;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.q;
import com.tencent.tav.player.Player;
import d.a.j;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "isActive", "", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "Landroid/graphics/RectF;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "rect", "updateVideoCrop", "plugin-vlog_release"})
public final class c
  implements b.c, d
{
  v Lqf;
  public final RectF Lqo;
  private final View LtM;
  com.tencent.mm.plugin.vlog.model.y LtN;
  private long LtO;
  private final a LtP;
  private final e LtQ;
  final e LtR;
  b.e Ltw;
  final String TAG;
  private boolean isActive;
  
  public c(e parame)
  {
    AppMethodBeat.i(201126);
    this.LtR = parame;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.LtM = new View(this.LtR.fZg().getContext());
    this.Lqo = new RectF();
    this.LtP = new a(this);
    this.LtQ = new e(this);
    AppMethodBeat.o(201126);
  }
  
  public final void Ch(long paramLong)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(201124);
    if (!this.isActive)
    {
      AppMethodBeat.o(201124);
      return;
    }
    this.LtO = paramLong;
    Object localObject2 = this.Lqf;
    Object localObject1 = localIterator;
    int i;
    if (localObject2 != null)
    {
      localObject2 = (List)((v)localObject2).LqL;
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localIterator = ((Iterable)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label172;
        }
        localObject1 = localIterator.next();
        localObject2 = (com.tencent.mm.plugin.vlog.model.y)localObject1;
        if ((((com.tencent.mm.plugin.vlog.model.y)localObject2).bxw > paramLong) || (((com.tencent.mm.plugin.vlog.model.y)localObject2).gnO <= paramLong)) {
          break label167;
        }
        i = 1;
        label120:
        if (i == 0) {
          break label170;
        }
      }
    }
    for (;;)
    {
      localObject1 = (com.tencent.mm.plugin.vlog.model.y)localObject1;
      if ((k.g(localObject1, this.LtN) ^ true)) {
        com.tencent.mm.ad.c.g((a)new d(this, (com.tencent.mm.plugin.vlog.model.y)localObject1));
      }
      AppMethodBeat.o(201124);
      return;
      label167:
      i = 0;
      break label120;
      label170:
      break;
      label172:
      localObject1 = null;
    }
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(201125);
    k.h(paramSize, "size");
    AppMethodBeat.o(201125);
  }
  
  public final void a(b.e parame) {}
  
  public final Rect fZe()
  {
    AppMethodBeat.i(201122);
    Rect localRect = new Rect();
    this.LtR.fZh().getVisibilityRect().round(localRect);
    AppMethodBeat.o(201122);
    return localRect;
  }
  
  public final CropLayout.b fZl()
  {
    return (CropLayout.b)this.LtP;
  }
  
  public final WxCropOperationLayout.i fZm()
  {
    return (WxCropOperationLayout.i)this.LtQ;
  }
  
  public final void fZn()
  {
    AppMethodBeat.i(201123);
    Object localObject = this.LtN;
    if (localObject == null)
    {
      AppMethodBeat.o(201123);
      return;
    }
    int i = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lrr;
    int j = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lrs;
    localObject = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lru;
    this.LtR.fZh().setMaxScaleValue(((n)localObject).aMu);
    this.LtR.fZh().setMinScaleValue(((n)localObject).aMv);
    boolean bool = this.LtR.fZh().getContentRect().isEmpty();
    this.LtR.fZh().getContentRect().set(((n)localObject).oSt);
    this.LtR.fZh().a(this.LtM, i, j, ((n)localObject).dY, CropLayout.c.HDI, (b)new f(bool));
    ad.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(201123);
  }
  
  public final void h(final v paramv)
  {
    AppMethodBeat.i(201121);
    k.h(paramv, "composition");
    ad.i(this.TAG, "onPreview: ");
    this.LtR.fZh().wS(true);
    this.LtR.fZh().setEnableScale(true);
    VLogCompositionPlayView localVLogCompositionPlayView = this.LtR.fZi();
    if ((k.g(localVLogCompositionPlayView.getParent(), this.LtR.fZg()) ^ true))
    {
      ViewParent localViewParent = localVLogCompositionPlayView.getParent();
      Object localObject = localViewParent;
      if (!(localViewParent instanceof ViewGroup)) {
        localObject = null;
      }
      localObject = (ViewGroup)localObject;
      if (localObject != null) {
        ((ViewGroup)localObject).removeView((View)localVLogCompositionPlayView);
      }
      localVLogCompositionPlayView.setScaleX(1.0F);
      localVLogCompositionPlayView.setScaleY(1.0F);
      localVLogCompositionPlayView.setTranslationX(0.0F);
      localVLogCompositionPlayView.setTranslationY(0.0F);
      this.LtR.fZg().addView((View)localVLogCompositionPlayView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
    this.LtR.fZh().getVisibilityRect().set(this.Lqo);
    this.LtR.getOperationLayout().getVisibilityRect().set(this.Lqo);
    this.Lqf = paramv;
    this.LtN = ((com.tencent.mm.plugin.vlog.model.y)j.C((List)paramv.LqL, 0));
    this.LtR.fZg().post((Runnable)new b(this, paramv));
    fZn();
    this.LtR.fZi().a(paramv);
    this.LtR.getOperationLayout().postDelayed((Runnable)new c(this), 3000L);
    AppMethodBeat.o(201121);
  }
  
  public final void zg(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.q
  {
    private float LtK = 1.0F;
    
    public final void fZj()
    {
      AppMethodBeat.i(201114);
      Object localObject = this.LtS.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      b.e locale = this.LtS.Ltw;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ad.i((String)localObject, i);
        this.LtS.LtR.fZi().pause();
        localObject = this.LtS.Ltw;
        if (localObject != null) {
          ((b.e)localObject).pause();
        }
        localObject = this.LtS.LtN;
        if (localObject == null) {
          break label142;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lru;
        if (localObject == null) {
          break label142;
        }
        localObject = ((n)localObject).dY;
        if (localObject == null) {
          break label142;
        }
      }
      label142:
      for (float f = p.f((Matrix)localObject);; f = 1.0F)
      {
        this.LtK = f;
        AppMethodBeat.o(201114);
        return;
        i = 0;
        break;
      }
    }
    
    public final void fZk()
    {
      AppMethodBeat.i(201115);
      Object localObject = this.LtS.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      b.e locale = this.LtS.Ltw;
      if (locale != null) {}
      for (int i = locale.hashCode();; i = 0)
      {
        ad.i((String)localObject, i);
        this.LtS.LtR.fZi().resume();
        localObject = this.LtS.Ltw;
        if (localObject != null) {
          ((b.e)localObject).resume();
        }
        localObject = this.LtS.LtN;
        if (localObject == null) {
          break label165;
        }
        if (this.LtK == p.f(((com.tencent.mm.plugin.vlog.model.y)localObject).Lru.dY)) {
          break;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lrv;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(201115);
        return;
      }
      localObject = ((com.tencent.mm.plugin.vlog.model.y)localObject).Lrv;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(201115);
      return;
      label165:
      AppMethodBeat.o(201115);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(201113);
      ad.i(this.LtS.TAG, "onChange: " + this.LtS.LtR.fZh().getContentRect());
      if (this.LtS.LtR.fZh().getContentRect().isEmpty())
      {
        AppMethodBeat.o(201113);
        return;
      }
      Object localObject2 = this.LtS.LtN;
      Object localObject1;
      if (localObject2 != null)
      {
        ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.oSt.set(this.LtS.LtR.fZh().getContentRect());
        localObject1 = ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.gtE;
        localObject2 = ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru.oSt;
        ad.d(this.LtS.TAG, "onChange, cropRect:" + localObject1 + ", contentRect:" + localObject2);
      }
      if (!this.LtS.LtR.fZi().isPlaying())
      {
        localObject1 = this.LtS.LtR.fZi().LrJ;
        if (localObject1 != null)
        {
          ((g)localObject1).LrN = bt.GC();
          localObject1 = ((g)localObject1).player;
          if (localObject1 != null)
          {
            ((Player)localObject1).refreshSurface(null);
            AppMethodBeat.o(201113);
            return;
          }
          AppMethodBeat.o(201113);
          return;
        }
      }
      AppMethodBeat.o(201113);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(c paramc, v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(201116);
      Object localObject = ai.cf(this.LtS.LtR.fZg().getContext());
      int i = this.LtS.LtR.fZg().getWidth();
      int j = this.LtS.LtR.fZg().getHeight();
      if (i <= 0) {
        i = ((Point)localObject).x;
      }
      for (;;)
      {
        if (j <= 0) {
          j = ((Point)localObject).y;
        }
        for (;;)
        {
          localObject = ((Iterable)paramv.LqL).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((com.tencent.mm.plugin.vlog.model.y)((Iterator)localObject).next()).Lru.viewRect.set(0, 0, i, j);
          }
          AppMethodBeat.o(201116);
          return;
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(201117);
      WxCropOperationLayout.a(this.LtS.LtR.getOperationLayout());
      AppMethodBeat.o(201117);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<d.y>
  {
    d(c paramc, com.tencent.mm.plugin.vlog.model.y paramy)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(201119);
      k.h(paramRectF, "rectF");
      this.LtS.LtR.fZi().pause();
      this.LtS.Lqo.set(paramRectF);
      ad.i(this.LtS.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject1 = this.LtS.Lqf;
      if (localObject1 != null)
      {
        localObject1 = (List)((v)localObject1).LqL;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (com.tencent.mm.plugin.vlog.model.y)((Iterator)localObject1).next();
            n localn = ((com.tencent.mm.plugin.vlog.model.y)localObject2).Lru;
            paramRectF.round(localn.gtE);
            if (!k.g(this.LtS.LtN, localObject2))
            {
              int i = localn.gtE.bottom - localn.oSt.bottom;
              int j = localn.gtE.top - localn.oSt.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localn.oSt);
                float f1 = paramRectF.height() / localRectF.height();
                label248:
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
                  localRectF.round(localn.oSt);
                  localn.dY.postConcat((Matrix)localObject2);
                  break;
                  f1 = i;
                  break label248;
                  f2 = paramRectF.centerY() - localRectF.centerY();
                }
              }
            }
          }
        }
      }
      localObject1 = this.LtS.LtN;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.vlog.model.y)localObject1).Lru;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((n)localObject1).oSt;; localObject1 = null)
      {
        if ((localObject1 == null) || (!this.LtS.LtR.fZh().getContentRect().isEmpty())) {
          this.LtS.LtR.fZh().g(paramRectF);
        }
        this.LtS.LtR.fZi().resume();
        AppMethodBeat.o(201119);
        return;
      }
    }
    
    public final void yV(boolean paramBoolean) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class f
    extends d.g.b.l
    implements b<Matrix, Boolean>
  {
    f(boolean paramBoolean)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.c
 * JD-Core Version:    0.7.0.1
 */