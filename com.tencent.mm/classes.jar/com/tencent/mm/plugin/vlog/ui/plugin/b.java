package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.p;
import com.tencent.mm.plugin.vlog.model.q;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.g.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.b;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.q;
import d.g.b.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentType", "isPreviewVLog", "", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "setLayout", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1;", "vlogPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl;", "vlogView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "calcOriginRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "", "currentVideoComposition", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isLockMedia", "onDetach", "onPause", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$OnCalculateVisibilityRect;", "onPreviewVideo", "isVlog", "muteOrigin", "onResume", "registerCallback", "callback", "release", "reset", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setVisibleRect", "rect", "stopPreview", "unregisterCallback", "Companion", "OnCalculateVisibilityRect", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class b
  implements t
{
  public static final a LtF;
  public CropLayout.b HDf;
  public q LkO;
  public VLogCompositionPlayView Lmo;
  private WxCropOperationLayout.j Lmq;
  public com.tencent.mm.plugin.vlog.model.v Lqf;
  public final c LtA;
  public final g LtB;
  private d LtC;
  public CropLayout LtD;
  public WxCropOperationLayout LtE;
  public final RectF Ltr;
  private final LinkedList<b> Lts;
  public boolean Ltt;
  public int Ltu;
  private final k Ltv;
  public e Ltw;
  public long Ltx;
  public long Lty;
  private final e Ltz;
  private final Context context;
  public final ViewGroup fSZ;
  private int nxe;
  private long rFa;
  public final RectF rGB;
  private long rGG;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d vjo;
  
  static
  {
    AppMethodBeat.i(201110);
    LtF = new a((byte)0);
    AppMethodBeat.o(201110);
  }
  
  public b(CropLayout paramCropLayout, WxCropOperationLayout paramWxCropOperationLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(201109);
    this.LtD = paramCropLayout;
    this.LtE = paramWxCropOperationLayout;
    this.vjo = paramd;
    this.context = this.LtD.getContext();
    paramCropLayout = this.LtD.getParent();
    if (paramCropLayout == null)
    {
      paramCropLayout = new d.v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(201109);
      throw paramCropLayout;
    }
    this.fSZ = ((ViewGroup)paramCropLayout);
    this.Ltr = new RectF();
    this.Lts = new LinkedList();
    this.rFa = -1L;
    this.rGB = new RectF();
    this.Lmq = WxCropOperationLayout.j.LpK;
    this.Ltv = new k(this);
    paramCropLayout = this.LtD;
    paramCropLayout.setHasBorder(false);
    paramCropLayout.setEnableScale(true);
    paramCropLayout.setEnableFling(true);
    paramCropLayout.setEnableTouch(true);
    paramCropLayout.setEnableOverScroll(false);
    this.LtD.setBackgroundColor(0);
    this.Ltz = ((e)new e()
    {
      public final ViewGroup fZg()
      {
        AppMethodBeat.i(201078);
        ViewGroup localViewGroup = b.f(this.LtG);
        AppMethodBeat.o(201078);
        return localViewGroup;
      }
      
      public final CropLayout fZh()
      {
        return this.LtG.LtD;
      }
      
      public final VLogCompositionPlayView fZi()
      {
        AppMethodBeat.i(201079);
        b.g(this.LtG);
        VLogCompositionPlayView localVLogCompositionPlayView = b.e(this.LtG);
        if (localVLogCompositionPlayView == null) {
          k.fvU();
        }
        AppMethodBeat.o(201079);
        return localVLogCompositionPlayView;
      }
      
      public final WxCropOperationLayout getOperationLayout()
      {
        return this.LtG.LtE;
      }
    });
    this.LtA = new c(this.Ltz);
    a((b)this.LtA);
    this.LtB = new g(this.Ltz);
    int i = a.hV(this.context);
    float f1 = i * 3.5F / 3.0F;
    float f2 = i * 9.0F / 16.0F;
    this.LtE.setLimitMaxHeight(f1);
    this.LtE.setLimitMinHeight(f2);
    int j = a.ao(this.context, 2131165275);
    this.Ltr.set(0.0F, j, i, f1 + j);
    this.LtE.Lpm = false;
    this.LtE.setVisibility(8);
    AppMethodBeat.o(201109);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(201101);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(201101);
    return paramRect1;
  }
  
  private n a(final com.tencent.mm.view.e parame, String paramString)
  {
    AppMethodBeat.i(201095);
    k.h(parame, "drawingView");
    k.h(paramString, "mediaPath");
    this.LtC = null;
    Object localObject = this.LkO;
    if (localObject != null)
    {
      localObject = (List)((q)localObject).Lqi;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (k.g(((y)localObject).path, paramString))
          {
            localObject = (y)localObject;
            label104:
            if (localObject == null) {
              break label153;
            }
          }
        }
      }
    }
    label153:
    for (final long l = ((y)localObject).id;; l = 0L)
    {
      if (l != this.rFa) {
        break label159;
      }
      parame = aVW(paramString);
      AppMethodBeat.o(201095);
      return parame;
      localObject = null;
      break;
      localObject = null;
      break label104;
    }
    label159:
    if (localObject == null)
    {
      parame = aVW(paramString);
      AppMethodBeat.o(201095);
      return parame;
    }
    this.rFa = l;
    this.nxe = 1;
    ad.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
    onPause();
    this.LtD.wS(true);
    this.LtD.setEnableScale(true);
    WxCropOperationLayout.a(this.LtE);
    int i = ((y)localObject).Lrr;
    int j = ((y)localObject).Lrs;
    this.LtD.getVisibilityRect().set(this.rGB);
    this.LtE.getVisibilityRect().set(this.rGB);
    if (0L == this.rGG) {
      this.rGG = l;
    }
    if (qS(l)) {
      this.LtE.setStyle(this.Lmq);
    }
    for (;;)
    {
      this.LtD.setMaxScaleValue(((y)localObject).Lru.aMu);
      this.LtD.setMinScaleValue(((y)localObject).Lru.aMv);
      boolean bool = this.LtD.getContentRect().isEmpty();
      this.LtD.a((View)parame, i, j, ((y)localObject).Lru.dY, CropLayout.c.HDI, (d.g.a.b)new g(bool));
      if (((y)localObject).Lru.rGL > 0.0F)
      {
        paramString = parame.getPresenter();
        k.g(paramString, "drawingView.presenter");
        paramString.setInitScale(1.0F / ((y)localObject).Lru.rGL);
      }
      this.LtE.setOnOperationCallback((WxCropOperationLayout.i)new h(this, l, (y)localObject));
      this.LtD.setOnChangeListener((CropLayout.b)new i(this, (y)localObject, parame));
      this.LtE.setVisibility(0);
      parame = ((y)localObject).Lru;
      AppMethodBeat.o(201095);
      return parame;
      this.LtE.setStyle(WxCropOperationLayout.j.LpL);
    }
  }
  
  private final void fZf()
  {
    AppMethodBeat.i(201102);
    if (this.Lmo == null)
    {
      this.Lmo = new VLogCompositionPlayView(this.context);
      VLogCompositionPlayView localVLogCompositionPlayView = this.Lmo;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.setPlayerCallback((g.a.a)new f(this));
        AppMethodBeat.o(201102);
        return;
      }
    }
    AppMethodBeat.o(201102);
  }
  
  private final boolean qS(long paramLong)
  {
    return (this.rGG == paramLong) || (this.rGG == 0L);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(201094);
    k.h(paramb, "callback");
    if (!this.Lts.contains(paramb)) {
      this.Lts.add(paramb);
    }
    AppMethodBeat.o(201094);
  }
  
  public final n aVW(String paramString)
  {
    AppMethodBeat.i(201103);
    k.h(paramString, "path");
    Object localObject = this.LkO;
    if (localObject != null)
    {
      localObject = (List)((q)localObject).Lqi;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!k.g(((y)localObject).path, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (y)paramString;
      if (paramString != null)
      {
        localObject = paramString.Lru;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new n();
      }
      AppMethodBeat.o(201103);
      return paramString;
    }
  }
  
  public final void aW(boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.mm.plugin.vlog.model.v localv = null;
    AppMethodBeat.i(201098);
    this.nxe = 2;
    this.Ltt = paramBoolean1;
    ad.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewVideo, isVLog:" + paramBoolean1 + ", muteOrigin:" + paramBoolean2);
    fZf();
    this.rFa = -1L;
    Object localObject1 = this.LkO;
    if (localObject1 != null)
    {
      localObject1 = ((q)localObject1).Lqf;
      this.Lqf = ((com.tencent.mm.plugin.vlog.model.v)localObject1);
      localObject1 = this.Lqf;
      if (localObject1 != null) {
        if (paramBoolean2) {
          break label174;
        }
      }
    }
    Object localObject2;
    Object localObject3;
    label174:
    for (paramBoolean2 = true;; paramBoolean2 = false)
    {
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).zd(paramBoolean2);
      localObject1 = this.Lqf;
      if (localObject1 == null) {
        break label179;
      }
      localObject2 = ((Iterable)this.Lts).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if ((localObject3 instanceof d)) {
          ((d)localObject3).g((com.tencent.mm.plugin.vlog.model.v)localObject1);
        }
      }
      localObject1 = null;
      break;
    }
    label179:
    localObject1 = this.LtC;
    if (localObject1 != null) {
      ((d)localObject1).zg(false);
    }
    if (paramBoolean1)
    {
      this.LtC = ((d)this.LtB);
      localObject1 = this.LkO;
      if (localObject1 != null)
      {
        localObject1 = ((q)localObject1).fYC();
        localObject2 = this.LtC;
        if (localObject2 != null) {
          ((d)localObject2).a((Size)localObject1);
        }
      }
      localObject1 = this.Lmo;
      if (localObject1 != null) {
        ((VLogCompositionPlayView)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = this.LtC;
      if (localObject1 != null) {
        ((d)localObject1).zg(true);
      }
      this.LtE.setOnOperationCallback((WxCropOperationLayout.i)new j(this));
      localObject2 = this.LtD;
      localObject3 = this.LtC;
      localObject1 = localv;
      if (localObject3 != null) {
        localObject1 = ((d)localObject3).fZl();
      }
      ((CropLayout)localObject2).setOnChangeListener((CropLayout.b)localObject1);
      localObject1 = this.LtC;
      if (localObject1 != null)
      {
        localv = this.Lqf;
        if (localv == null) {
          k.fvU();
        }
        ((d)localObject1).h(localv);
      }
      this.LtE.setVisibility(0);
      AppMethodBeat.o(201098);
      return;
      this.LtC = ((d)this.LtA);
      localObject1 = this.LkO;
      if (localObject1 != null)
      {
        localObject1 = ((q)localObject1).fYD();
        localObject2 = this.LtC;
        if (localObject2 != null) {
          ((d)localObject2).a((Size)localObject1);
        }
      }
      this.LtA.Ltw = this.Ltw;
    }
  }
  
  public final void apt() {}
  
  public final boolean dia()
  {
    return false;
  }
  
  public final Rect fZe()
  {
    AppMethodBeat.i(201100);
    Object localObject = this.LtC;
    if (localObject != null) {}
    for (localObject = ((d)localObject).fZe(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(201100);
      return localObject;
    }
    localObject = this.LtD.getContentRect();
    RectF localRectF = this.LtD.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.LtD.getContentOriginalRect(), localRect);
    AppMethodBeat.o(201100);
    return localObject;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(201107);
    View localView = (View)this.Lmo;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(201107);
      return;
    }
    AppMethodBeat.o(201107);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(201106);
    if (this.Lmo != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.Lmo;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.pause();
        AppMethodBeat.o(201106);
        return;
      }
    }
    AppMethodBeat.o(201106);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(201105);
    if (this.Lmo != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.Lmo;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.resume();
        AppMethodBeat.o(201105);
        return;
      }
    }
    AppMethodBeat.o(201105);
  }
  
  public final void release()
  {
    AppMethodBeat.i(201108);
    if (this.Lmo != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.Lmo;
      if (localVLogCompositionPlayView != null) {
        localVLogCompositionPlayView.release();
      }
      this.Lmo = null;
    }
    this.Lts.clear();
    AppMethodBeat.o(201108);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(201104);
    this.rGG = 0L;
    this.LtD.wS(true);
    AppMethodBeat.o(201104);
  }
  
  public final void setVisibility(int paramInt) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(201097);
    VLogCompositionPlayView localVLogCompositionPlayView = this.Lmo;
    if (localVLogCompositionPlayView != null)
    {
      localVLogCompositionPlayView.stop();
      AppMethodBeat.o(201097);
      return;
    }
    AppMethodBeat.o(201097);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Companion;", "", "()V", "TAG", "", "TYPE_IMAGE", "", "TYPE_VIDEO", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "", "plugin-vlog_release"})
  public static abstract interface b {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"})
  public static abstract interface c
    extends b.b
  {
    public abstract void Ch(long paramLong);
    
    public abstract void a(b.e parame);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "plugin-vlog_release"})
  public static abstract interface d
    extends b.b
  {
    public abstract void g(com.tencent.mm.plugin.vlog.model.v paramv);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "", "pause", "", "resume", "seek", "timeMs", "", "host", "plugin-vlog_release"})
  public static abstract interface e
  {
    public abstract void Cf(long paramLong);
    
    public abstract void pause();
    
    public abstract void resume();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class f
    implements g.a.a
  {
    public final void Ca(long paramLong)
    {
      AppMethodBeat.i(201082);
      Iterator localIterator = ((Iterable)b.c(this.LtG)).iterator();
      while (localIterator.hasNext())
      {
        b.b localb = (b.b)localIterator.next();
        if ((localb instanceof b.c)) {
          ((b.c)localb).Ch(paramLong);
        }
      }
      AppMethodBeat.o(201082);
    }
    
    public final void fWi()
    {
      AppMethodBeat.i(201080);
      Object localObject1 = ((Iterable)b.c(this.LtG)).iterator();
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (b.b)((Iterator)localObject1).next();
        if ((localObject2 instanceof b.c)) {
          ((b.c)localObject2).a((b.e)b.d(this.LtG));
        }
      }
      localObject1 = this.LtG.Ltw;
      if (localObject1 != null)
      {
        localObject2 = b.e(this.LtG);
        if (localObject2 != null) {}
        for (long l = ((VLogCompositionPlayView)localObject2).getPosition();; l = 0L)
        {
          ((b.e)localObject1).Cf(l + this.LtG.Ltx - this.LtG.Lty);
          AppMethodBeat.o(201080);
          return;
        }
      }
      AppMethodBeat.o(201080);
    }
    
    public final void fWj() {}
    
    public final void fWk()
    {
      AppMethodBeat.i(201081);
      Iterator localIterator = ((Iterable)b.c(this.LtG)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(201081);
    }
    
    public final void fWl()
    {
      AppMethodBeat.i(201083);
      Object localObject = b.e(this.LtG);
      if (localObject == null)
      {
        localObject = new d.v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(201083);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      d.b.a(this.LtG.vjo, d.c.voh);
      AppMethodBeat.o(201083);
    }
    
    public final void fWm() {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Matrix, Boolean>
  {
    g(boolean paramBoolean)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class h
    implements WxCropOperationLayout.i
  {
    private boolean LtI = true;
    
    h(long paramLong, y paramy) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(201085);
      k.h(paramRectF, "rectF");
      if (b.a(this.LtG, l)) {
        this.LtG.rGB.set(paramRectF);
      }
      Object localObject1 = b.a(this.LtG);
      if (localObject1 != null)
      {
        localObject1 = (List)((q)localObject1).Lqi;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (y)((Iterator)localObject1).next();
            n localn = ((y)localObject2).Lru;
            paramRectF.round(localn.gtE);
            if (!k.g(this.LtJ, localObject2))
            {
              int i = localn.gtE.bottom - localn.oSt.bottom;
              int j = localn.gtE.top - localn.oSt.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localn.oSt);
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
                  localRectF.round(localn.oSt);
                  localn.dY.postConcat((Matrix)localObject2);
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
      this.LtG.LtD.g(paramRectF);
      paramRectF = this.LtG.HDf;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.LtI)
      {
        paramRectF = this.LtG;
        paramRectF.Ltu += 1;
      }
      this.LtI = true;
      AppMethodBeat.o(201085);
    }
    
    public final void yV(boolean paramBoolean)
    {
      this.LtI = false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class i
    implements CropLayout.q
  {
    private float LtK = 1.0F;
    
    i(y paramy, com.tencent.mm.view.e parame) {}
    
    public final void fZj()
    {
      AppMethodBeat.i(201087);
      this.LtK = p.f(this.LtJ.Lru.dY);
      AppMethodBeat.o(201087);
    }
    
    public final void fZk()
    {
      AppMethodBeat.i(201088);
      Object localObject = this.LtJ;
      if (this.LtK != p.f(((y)localObject).Lru.dY))
      {
        localObject = ((y)localObject).Lrv;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(201088);
        return;
      }
      localObject = ((y)localObject).Lrv;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(201088);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(201086);
      if (this.LtJ.Lru.getScale() > 0.0F)
      {
        com.tencent.mm.bu.b localb = parame.getPresenter();
        k.g(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.LtJ.Lru.getScale());
      }
      this.LtJ.Lru.oSt.set(this.LtG.LtD.getContentRect());
      AppMethodBeat.o(201086);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewVideo$4", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    private boolean LtI = true;
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(201089);
      k.h(paramRectF, "rectF");
      Object localObject = b.b(this.LtG);
      if (localObject != null)
      {
        localObject = ((d)localObject).fZm();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).f(paramRectF);
        }
      }
      paramRectF = this.LtG.HDf;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.LtI)
      {
        paramRectF = this.LtG;
        paramRectF.Ltu += 1;
      }
      this.LtI = true;
      AppMethodBeat.o(201089);
    }
    
    public final void yV(boolean paramBoolean)
    {
      AppMethodBeat.i(201090);
      Object localObject = b.b(this.LtG);
      if (localObject != null)
      {
        localObject = ((d)localObject).fZm();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).yV(paramBoolean);
        }
      }
      this.LtI = false;
      AppMethodBeat.o(201090);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class k
    implements b.e
  {
    public final void Cf(long paramLong)
    {
      AppMethodBeat.i(201091);
      VLogCompositionPlayView localVLogCompositionPlayView = b.e(this.LtG);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.seekTo(paramLong);
        AppMethodBeat.o(201091);
        return;
      }
      AppMethodBeat.o(201091);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(201092);
      VLogCompositionPlayView localVLogCompositionPlayView = b.e(this.LtG);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.pause();
        AppMethodBeat.o(201092);
        return;
      }
      AppMethodBeat.o(201092);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(201093);
      VLogCompositionPlayView localVLogCompositionPlayView = b.e(this.LtG);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.resume();
        AppMethodBeat.o(201093);
        return;
      }
      AppMethodBeat.o(201093);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.b
 * JD-Core Version:    0.7.0.1
 */