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
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.tav.player.Player;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "provider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;)V", "TAG", "", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "cropChangeListener", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1;", "isActive", "", "operationCallback", "com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1;", "playingTime", "", "playingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "getProvider", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "videoCropView", "Landroid/view/View;", "visibleRect", "Landroid/graphics/RectF;", "getCropChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getCropInView", "Landroid/graphics/Rect;", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getOperationCallback", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onActiveChange", "", "active", "onFinish", "onPreview", "onProgress", "timeMs", "onStart", "seekable", "setVideoSize", "size", "Landroid/util/Size;", "setVisibleRect", "rect", "updateVideoCrop", "plugin-vlog_release"})
public final class b
  implements a.c, c
{
  r AmR;
  public final RectF Ann;
  a.e AsO;
  private final View Ate;
  u Atf;
  private long Atg;
  private final a Ath;
  private final e Ati;
  final d Atj;
  final String TAG;
  private boolean isActive;
  
  public b(d paramd)
  {
    AppMethodBeat.i(207809);
    this.Atj = paramd;
    this.TAG = "MicroMsg.MultiVideoPreview";
    this.Ate = new View(this.Atj.egg().getContext());
    this.Ann = new RectF();
    this.Ath = new a(this);
    this.Ati = new e(this);
    AppMethodBeat.o(207809);
  }
  
  public final void a(Size paramSize)
  {
    AppMethodBeat.i(207808);
    k.h(paramSize, "size");
    AppMethodBeat.o(207808);
  }
  
  public final void a(a.e parame) {}
  
  public final Rect ege()
  {
    AppMethodBeat.i(207805);
    Rect localRect = new Rect();
    this.Atj.egh().getVisibilityRect().round(localRect);
    AppMethodBeat.o(207805);
    return localRect;
  }
  
  public final CropLayout.c egl()
  {
    return (CropLayout.c)this.Ath;
  }
  
  public final WxCropOperationLayout.i egm()
  {
    return (WxCropOperationLayout.i)this.Ati;
  }
  
  public final void egn()
  {
    AppMethodBeat.i(207806);
    Object localObject = this.Atf;
    if (localObject == null)
    {
      AppMethodBeat.o(207806);
      return;
    }
    int i = ((u)localObject).AoA;
    int j = ((u)localObject).AoB;
    localObject = ((u)localObject).AoD;
    this.Atj.egh().setMaxScaleValue(((com.tencent.mm.plugin.vlog.model.d)localObject).aNk);
    this.Atj.egh().setMinScaleValue(((com.tencent.mm.plugin.vlog.model.d)localObject).aNl);
    boolean bool = this.Atj.egh().getContentRect().isEmpty();
    this.Atj.egh().getContentRect().set(((com.tencent.mm.plugin.vlog.model.d)localObject).pvE);
    this.Atj.egh().a(this.Ate, i, j, ((com.tencent.mm.plugin.vlog.model.d)localObject).eY, CropLayout.e.Jef, (d.g.a.b)new b.f(bool));
    ac.i(this.TAG, "updateVideoCrop, viewWidth:" + i + ", viewHeight:" + j);
    AppMethodBeat.o(207806);
  }
  
  public final void h(final r paramr)
  {
    AppMethodBeat.i(207804);
    k.h(paramr, "composition");
    ac.i(this.TAG, "onPreview: ");
    this.Atj.egh().ya(true);
    this.Atj.egh().setEnableScale(true);
    VLogCompositionPlayView localVLogCompositionPlayView = this.Atj.egi();
    if ((k.g(localVLogCompositionPlayView.getParent(), this.Atj.egg()) ^ true))
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
      this.Atj.egg().addView((View)localVLogCompositionPlayView, 0, new ViewGroup.LayoutParams(-1, -1));
    }
    this.Atj.egh().getVisibilityRect().set(this.Ann);
    this.Atj.getOperationLayout().getVisibilityRect().set(this.Ann);
    this.AmR = paramr;
    this.Atf = ((u)d.a.j.C((List)paramr.AnT, 0));
    this.Atj.egg().post((Runnable)new b(this, paramr));
    egn();
    this.Atj.egi().a(paramr);
    this.Atj.getOperationLayout().postDelayed((Runnable)new c(this), 3000L);
    AppMethodBeat.o(207804);
  }
  
  public final void sn(boolean paramBoolean)
  {
    this.isActive = paramBoolean;
  }
  
  public final void yN(long paramLong)
  {
    Iterator localIterator = null;
    AppMethodBeat.i(207807);
    if (!this.isActive)
    {
      AppMethodBeat.o(207807);
      return;
    }
    this.Atg = paramLong;
    Object localObject2 = this.AmR;
    Object localObject1 = localIterator;
    int i;
    if (localObject2 != null)
    {
      localObject2 = (List)((r)localObject2).AnT;
      localObject1 = localIterator;
      if (localObject2 != null)
      {
        localIterator = ((Iterable)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label175;
        }
        localObject1 = localIterator.next();
        localObject2 = (u)localObject1;
        if ((((u)localObject2).bvf > paramLong) || (((u)localObject2).gOz <= paramLong)) {
          break label170;
        }
        i = 1;
        label122:
        if (i == 0) {
          break label173;
        }
      }
    }
    for (;;)
    {
      localObject1 = (u)localObject1;
      if ((k.g(localObject1, this.Atf) ^ true)) {
        com.tencent.mm.ac.c.g((a)new d(this, (u)localObject1));
      }
      AppMethodBeat.o(207807);
      return;
      label170:
      i = 0;
      break label122;
      label173:
      break;
      label175:
      localObject1 = null;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$cropChangeListener$1", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class a
    implements CropLayout.d
  {
    private float Atc = 1.0F;
    
    public final void egj()
    {
      AppMethodBeat.i(207797);
      Object localObject = this.Atk.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeStart: audioSeekable:");
      a.e locale = this.Atk.AsO;
      int i;
      if (locale != null)
      {
        i = locale.hashCode();
        ac.i((String)localObject, i);
        this.Atk.Atj.egi().pause();
        localObject = this.Atk.AsO;
        if (localObject != null) {
          ((a.e)localObject).pause();
        }
        localObject = this.Atk.Atf;
        if (localObject == null) {
          break label142;
        }
        localObject = ((u)localObject).AoD;
        if (localObject == null) {
          break label142;
        }
        localObject = ((com.tencent.mm.plugin.vlog.model.d)localObject).eY;
        if (localObject == null) {
          break label142;
        }
      }
      label142:
      for (float f = com.tencent.mm.plugin.vlog.model.j.e((Matrix)localObject);; f = 1.0F)
      {
        this.Atc = f;
        AppMethodBeat.o(207797);
        return;
        i = 0;
        break;
      }
    }
    
    public final void egk()
    {
      AppMethodBeat.i(207798);
      Object localObject = this.Atk.TAG;
      StringBuilder localStringBuilder = new StringBuilder("onChangeEnd: audioSeekable:");
      a.e locale = this.Atk.AsO;
      if (locale != null) {}
      for (int i = locale.hashCode();; i = 0)
      {
        ac.i((String)localObject, i);
        this.Atk.Atj.egi().resume();
        localObject = this.Atk.AsO;
        if (localObject != null) {
          ((a.e)localObject).resume();
        }
        localObject = this.Atk.Atf;
        if (localObject == null) {
          break label165;
        }
        if (this.Atc == com.tencent.mm.plugin.vlog.model.j.e(((u)localObject).AoD.eY)) {
          break;
        }
        localObject = ((u)localObject).AoE;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(207798);
        return;
      }
      localObject = ((u)localObject).AoE;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(207798);
      return;
      label165:
      AppMethodBeat.o(207798);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(207796);
      ac.i(this.Atk.TAG, "onChange: " + this.Atk.Atj.egh().getContentRect());
      if (this.Atk.Atj.egh().getContentRect().isEmpty())
      {
        AppMethodBeat.o(207796);
        return;
      }
      Object localObject2 = this.Atk.Atf;
      Object localObject1;
      if (localObject2 != null)
      {
        ((u)localObject2).AoD.pvE.set(this.Atk.Atj.egh().getContentRect());
        localObject1 = ((u)localObject2).AoD.gUl;
        localObject2 = ((u)localObject2).AoD.pvE;
        ac.d(this.Atk.TAG, "onChange, cropRect:" + localObject1 + ", contentRect:" + localObject2);
      }
      if (!this.Atk.Atj.egi().isPlaying())
      {
        localObject1 = this.Atk.Atj.egi().Apu;
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.vlog.player.c)localObject1).Apz = bs.Gn();
          localObject1 = ((com.tencent.mm.plugin.vlog.player.c)localObject1).player;
          if (localObject1 != null)
          {
            ((Player)localObject1).refreshSurface(null);
            AppMethodBeat.o(207796);
            return;
          }
          AppMethodBeat.o(207796);
          return;
        }
      }
      AppMethodBeat.o(207796);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(b paramb, r paramr) {}
    
    public final void run()
    {
      AppMethodBeat.i(207799);
      Object localObject = aj.cl(this.Atk.Atj.egg().getContext());
      int i = this.Atk.Atj.egg().getWidth();
      int j = this.Atk.Atj.egg().getHeight();
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
          localObject = ((Iterable)paramr.AnT).iterator();
          while (((Iterator)localObject).hasNext()) {
            ((u)((Iterator)localObject).next()).AoD.viewRect.set(0, 0, i, j);
          }
          AppMethodBeat.o(207799);
          return;
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(207800);
      WxCropOperationLayout.a(this.Atk.Atj.getOperationLayout());
      AppMethodBeat.o(207800);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<y>
  {
    d(b paramb, u paramu)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl$operationCallback$1", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "onBlockDownClick", "", "isTopBlock", "", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class e
    implements WxCropOperationLayout.i
  {
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(207802);
      k.h(paramRectF, "rectF");
      this.Atk.Atj.egi().pause();
      this.Atk.Ann.set(paramRectF);
      ac.i(this.Atk.TAG, "operationCallback onChange:".concat(String.valueOf(paramRectF)));
      Object localObject1 = this.Atk.AmR;
      if (localObject1 != null)
      {
        localObject1 = (List)((r)localObject1).AnT;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (u)((Iterator)localObject1).next();
            com.tencent.mm.plugin.vlog.model.d locald = ((u)localObject2).AoD;
            paramRectF.round(locald.gUl);
            if (!k.g(this.Atk.Atf, localObject2))
            {
              int i = locald.gUl.bottom - locald.pvE.bottom;
              int j = locald.gUl.top - locald.pvE.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(locald.pvE);
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
                  localRectF.round(locald.pvE);
                  locald.eY.postConcat((Matrix)localObject2);
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
      localObject1 = this.Atk.Atf;
      if (localObject1 != null)
      {
        localObject1 = ((u)localObject1).AoD;
        if (localObject1 == null) {}
      }
      for (localObject1 = ((com.tencent.mm.plugin.vlog.model.d)localObject1).pvE;; localObject1 = null)
      {
        if ((localObject1 == null) || (!this.Atk.Atj.egh().getContentRect().isEmpty())) {
          this.Atk.Atj.egh().g(paramRectF);
        }
        this.Atk.Atj.egi().resume();
        AppMethodBeat.o(207802);
        return;
      }
    }
    
    public final void mx(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */