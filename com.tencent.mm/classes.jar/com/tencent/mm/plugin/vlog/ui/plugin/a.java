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
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.plugin.vlog.model.r;
import com.tencent.mm.plugin.vlog.model.u;
import com.tencent.mm.plugin.vlog.player.VLogCompositionPlayView;
import com.tencent.mm.plugin.vlog.player.c.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.view.e;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "layout", "Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentType", "isPreviewVLog", "", "getLayout", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout;", "setLayout", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "vlogPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/VLogPreviewImpl;", "vlogView", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayView;", "calcOriginRect", "Landroid/graphics/Rect;", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "", "currentVideoComposition", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isLockMedia", "onDetach", "onPause", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onCalculateVisibilityRect", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$OnCalculateVisibilityRect;", "onPreviewVideo", "isVlog", "muteOrigin", "onResume", "registerCallback", "callback", "release", "reset", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "stopPreview", "unregisterCallback", "Companion", "OnCalculateVisibilityRect", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class a
  implements t
{
  public static final a.a AsX;
  public r AmR;
  public final RectF AsI;
  private final LinkedList<a.b> AsJ;
  public CropLayout.c AsK;
  public boolean AsL;
  public int AsM;
  public final a.e AsN;
  public a.e AsO;
  public long AsP;
  public long AsQ;
  private final d AsR;
  public final b AsS;
  public final f AsT;
  private c AsU;
  public CropLayout AsV;
  public WxCropOperationLayout AsW;
  private final Context context;
  public final ViewGroup fWU;
  private int oae;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d rTT;
  private long sNS;
  public VLogCompositionPlayView sOk;
  public final RectF sOm;
  private WxCropOperationLayout.j sOp;
  private long sOt;
  public com.tencent.mm.plugin.vlog.model.k sgN;
  
  static
  {
    AppMethodBeat.i(207793);
    AsX = new a.a((byte)0);
    AppMethodBeat.o(207793);
  }
  
  public a(CropLayout paramCropLayout, WxCropOperationLayout paramWxCropOperationLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    AppMethodBeat.i(207792);
    this.AsV = paramCropLayout;
    this.AsW = paramWxCropOperationLayout;
    this.rTT = paramd;
    this.context = this.AsV.getContext();
    paramCropLayout = this.AsV.getParent();
    if (paramCropLayout == null)
    {
      paramCropLayout = new v("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(207792);
      throw paramCropLayout;
    }
    this.fWU = ((ViewGroup)paramCropLayout);
    this.AsI = new RectF();
    this.AsJ = new LinkedList();
    this.sNS = -1L;
    this.sOm = new RectF();
    this.sOp = WxCropOperationLayout.j.wzH;
    this.AsN = ((a.e)new k(this));
    paramCropLayout = this.AsV;
    paramCropLayout.setHasBorder(false);
    paramCropLayout.setEnableScale(true);
    paramCropLayout.setEnableFling(true);
    paramCropLayout.setEnableTouch(true);
    paramCropLayout.setEnableOverScroll(false);
    this.AsV.setBackgroundColor(0);
    this.AsR = ((d)new d()
    {
      public final ViewGroup egg()
      {
        AppMethodBeat.i(207761);
        ViewGroup localViewGroup = a.e(this.AsY);
        AppMethodBeat.o(207761);
        return localViewGroup;
      }
      
      public final CropLayout egh()
      {
        return this.AsY.AsV;
      }
      
      public final VLogCompositionPlayView egi()
      {
        AppMethodBeat.i(207762);
        a.f(this.AsY);
        VLogCompositionPlayView localVLogCompositionPlayView = a.d(this.AsY);
        if (localVLogCompositionPlayView == null) {
          d.g.b.k.fOy();
        }
        AppMethodBeat.o(207762);
        return localVLogCompositionPlayView;
      }
      
      public final WxCropOperationLayout getOperationLayout()
      {
        return this.AsY.AsW;
      }
    });
    this.AsS = new b(this.AsR);
    a((a.b)this.AsS);
    this.AsT = new f(this.AsR);
    int i = com.tencent.mm.cc.a.ig(this.context);
    float f1 = i * 3.5F / 3.0F;
    float f2 = i * 9.0F / 16.0F;
    this.AsW.setLimitMaxHeight(f1);
    this.AsW.setLimitMinHeight(f2);
    int j = com.tencent.mm.cc.a.au(this.context, 2131165275);
    this.AsI.set(0.0F, j, i, f1 + j);
    this.AsW.wzh = false;
    this.AsW.setVisibility(8);
    AppMethodBeat.o(207792);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(207784);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(207784);
    return paramRect1;
  }
  
  private com.tencent.mm.plugin.vlog.model.d a(final e parame, String paramString)
  {
    AppMethodBeat.i(207778);
    d.g.b.k.h(parame, "drawingView");
    d.g.b.k.h(paramString, "mediaPath");
    this.AsU = null;
    Object localObject = this.sgN;
    if (localObject != null)
    {
      localObject = (List)((com.tencent.mm.plugin.vlog.model.k)localObject).Anf;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (d.g.b.k.g(((u)localObject).path, paramString))
          {
            localObject = (u)localObject;
            label104:
            if (localObject == null) {
              break label153;
            }
          }
        }
      }
    }
    label153:
    for (final long l = ((u)localObject).id;; l = 0L)
    {
      if (l != this.sNS) {
        break label159;
      }
      parame = ayp(paramString);
      AppMethodBeat.o(207778);
      return parame;
      localObject = null;
      break;
      localObject = null;
      break label104;
    }
    label159:
    if (localObject == null)
    {
      parame = ayp(paramString);
      AppMethodBeat.o(207778);
      return parame;
    }
    this.sNS = l;
    this.oae = 1;
    ac.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
    onPause();
    this.AsV.ya(true);
    this.AsV.setEnableScale(true);
    WxCropOperationLayout.a(this.AsW);
    int i = ((u)localObject).AoA;
    int j = ((u)localObject).AoB;
    this.AsV.getVisibilityRect().set(this.sOm);
    this.AsW.getVisibilityRect().set(this.sOm);
    if (0L == this.sOt) {
      this.sOt = l;
    }
    if (vv(l)) {
      this.AsW.setStyle(this.sOp);
    }
    for (;;)
    {
      this.AsV.setMaxScaleValue(((u)localObject).AoD.aNk);
      this.AsV.setMinScaleValue(((u)localObject).AoD.aNl);
      boolean bool = this.AsV.getContentRect().isEmpty();
      this.AsV.a((View)parame, i, j, ((u)localObject).AoD.eY, CropLayout.e.Jef, (d.g.a.b)new a.g(bool));
      if (((u)localObject).AoD.sOy > 0.0F)
      {
        paramString = parame.getPresenter();
        d.g.b.k.g(paramString, "drawingView.presenter");
        paramString.setInitScale(1.0F / ((u)localObject).AoD.sOy);
      }
      this.AsW.setOnOperationCallback((WxCropOperationLayout.i)new h(this, l, (u)localObject));
      this.AsV.setOnChangeListener((CropLayout.c)new i(this, (u)localObject, parame));
      this.AsW.setVisibility(0);
      parame = ((u)localObject).AoD;
      AppMethodBeat.o(207778);
      return parame;
      this.AsW.setStyle(WxCropOperationLayout.j.wzI);
    }
  }
  
  private final void egf()
  {
    AppMethodBeat.i(207785);
    if (this.sOk == null)
    {
      this.sOk = new VLogCompositionPlayView(this.context);
      VLogCompositionPlayView localVLogCompositionPlayView = this.sOk;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.setPlayerCallback((c.a.a)new f(this));
        AppMethodBeat.o(207785);
        return;
      }
    }
    AppMethodBeat.o(207785);
  }
  
  private final boolean vv(long paramLong)
  {
    return (this.sOt == paramLong) || (this.sOt == 0L);
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(207777);
    d.g.b.k.h(paramb, "callback");
    if (!this.AsJ.contains(paramb)) {
      this.AsJ.add(paramb);
    }
    AppMethodBeat.o(207777);
  }
  
  public final boolean alO()
  {
    return false;
  }
  
  public final void ao(boolean paramBoolean1, boolean paramBoolean2)
  {
    r localr = null;
    AppMethodBeat.i(207781);
    this.oae = 2;
    this.AsL = paramBoolean1;
    ac.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewVideo, isVLog:" + paramBoolean1 + ", muteOrigin:" + paramBoolean2);
    egf();
    this.sNS = -1L;
    Object localObject1 = this.sgN;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.model.k)localObject1).AmR;
      this.AmR = ((r)localObject1);
      localObject1 = this.AmR;
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
      ((r)localObject1).sj(paramBoolean2);
      localObject1 = this.AmR;
      if (localObject1 == null) {
        break label179;
      }
      localObject2 = ((Iterable)this.AsJ).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (a.b)((Iterator)localObject2).next();
        if ((localObject3 instanceof d)) {
          ((d)localObject3).g((r)localObject1);
        }
      }
      localObject1 = null;
      break;
    }
    label179:
    localObject1 = this.AsU;
    if (localObject1 != null) {
      ((c)localObject1).sn(false);
    }
    if (paramBoolean1)
    {
      this.AsU = ((c)this.AsT);
      localObject1 = this.sgN;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.vlog.model.k)localObject1).efu();
        localObject2 = this.AsU;
        if (localObject2 != null) {
          ((c)localObject2).a((Size)localObject1);
        }
      }
      localObject1 = this.sOk;
      if (localObject1 != null) {
        ((VLogCompositionPlayView)localObject1).setVisibility(0);
      }
    }
    for (;;)
    {
      localObject1 = this.AsU;
      if (localObject1 != null) {
        ((c)localObject1).sn(true);
      }
      this.AsW.setOnOperationCallback((WxCropOperationLayout.i)new j(this));
      localObject2 = this.AsV;
      localObject3 = this.AsU;
      localObject1 = localr;
      if (localObject3 != null) {
        localObject1 = ((c)localObject3).egl();
      }
      ((CropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
      localObject1 = this.AsU;
      if (localObject1 != null)
      {
        localr = this.AmR;
        if (localr == null) {
          d.g.b.k.fOy();
        }
        ((c)localObject1).h(localr);
      }
      this.AsW.setVisibility(0);
      AppMethodBeat.o(207781);
      return;
      this.AsU = ((c)this.AsS);
      localObject1 = this.sgN;
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.vlog.model.k)localObject1).efv();
        localObject2 = this.AsU;
        if (localObject2 != null) {
          ((c)localObject2).a((Size)localObject1);
        }
      }
      this.AsS.AsO = this.AsO;
    }
  }
  
  public final void awk() {}
  
  public final com.tencent.mm.plugin.vlog.model.d ayp(String paramString)
  {
    AppMethodBeat.i(207786);
    d.g.b.k.h(paramString, "path");
    Object localObject = this.sgN;
    if (localObject != null)
    {
      localObject = (List)((com.tencent.mm.plugin.vlog.model.k)localObject).Anf;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!d.g.b.k.g(((u)localObject).path, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (u)paramString;
      if (paramString != null)
      {
        localObject = paramString.AoD;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new com.tencent.mm.plugin.vlog.model.d();
      }
      AppMethodBeat.o(207786);
      return paramString;
    }
  }
  
  public final Rect ege()
  {
    AppMethodBeat.i(207783);
    Object localObject = this.AsU;
    if (localObject != null) {}
    for (localObject = ((c)localObject).ege(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(207783);
      return localObject;
    }
    localObject = this.AsV.getContentRect();
    RectF localRectF = this.AsV.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.AsV.getContentOriginalRect(), localRect);
    AppMethodBeat.o(207783);
    return localObject;
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final void onDetach()
  {
    AppMethodBeat.i(207790);
    View localView = (View)this.sOk;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(207790);
      return;
    }
    AppMethodBeat.o(207790);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(207789);
    if (this.sOk != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.sOk;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.pause();
        AppMethodBeat.o(207789);
        return;
      }
    }
    AppMethodBeat.o(207789);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(207788);
    if (this.sOk != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.sOk;
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.resume();
        AppMethodBeat.o(207788);
        return;
      }
    }
    AppMethodBeat.o(207788);
  }
  
  public final void release()
  {
    AppMethodBeat.i(207791);
    if (this.sOk != null)
    {
      VLogCompositionPlayView localVLogCompositionPlayView = this.sOk;
      if (localVLogCompositionPlayView != null) {
        localVLogCompositionPlayView.release();
      }
      this.sOk = null;
    }
    this.AsJ.clear();
    AppMethodBeat.o(207791);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(207787);
    this.sOt = 0L;
    this.AsV.ya(true);
    AppMethodBeat.o(207787);
  }
  
  public final void setVisibility(int paramInt) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(207780);
    VLogCompositionPlayView localVLogCompositionPlayView = this.sOk;
    if (localVLogCompositionPlayView != null)
    {
      localVLogCompositionPlayView.stop();
      AppMethodBeat.o(207780);
      return;
    }
    AppMethodBeat.o(207780);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"})
  public static abstract interface c
    extends a.b
  {
    public abstract void a(a.e parame);
    
    public abstract void yN(long paramLong);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "plugin-vlog_release"})
  public static abstract interface d
    extends a.b
  {
    public abstract void g(r paramr);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/plugin/vlog/player/VLogCompositionPlayer$Companion$PlayerCallback;", "onPlayCompleted", "", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class f
    implements c.a.a
  {
    public final void cDC()
    {
      AppMethodBeat.i(207763);
      Object localObject = ((Iterable)a.c(this.AsY)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        a.b localb = (a.b)((Iterator)localObject).next();
        if ((localb instanceof a.c)) {
          ((a.c)localb).a(this.AsY.AsN);
        }
      }
      localObject = this.AsY.AsO;
      if (localObject != null)
      {
        ((a.e)localObject).vr(this.AsY.AsP);
        AppMethodBeat.o(207763);
        return;
      }
      AppMethodBeat.o(207763);
    }
    
    public final void cDD() {}
    
    public final void cDE()
    {
      AppMethodBeat.i(207764);
      Iterator localIterator = ((Iterable)a.c(this.AsY)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(207764);
    }
    
    public final void cDF()
    {
      AppMethodBeat.i(207766);
      Object localObject = a.d(this.AsY);
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(207766);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      d.b.a(this.AsY.rTT, d.c.wwO);
      AppMethodBeat.o(207766);
    }
    
    public final void cDG() {}
    
    public final void vm(long paramLong)
    {
      AppMethodBeat.i(207765);
      Iterator localIterator = ((Iterable)a.c(this.AsY)).iterator();
      while (localIterator.hasNext())
      {
        a.b localb = (a.b)localIterator.next();
        if ((localb instanceof a.c)) {
          ((a.c)localb).yN(paramLong);
        }
      }
      AppMethodBeat.o(207765);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class h
    implements WxCropOperationLayout.i
  {
    private boolean Ata = true;
    
    h(long paramLong, u paramu) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(207768);
      d.g.b.k.h(paramRectF, "rectF");
      if (a.a(this.AsY, l)) {
        this.AsY.sOm.set(paramRectF);
      }
      Object localObject1 = a.a(this.AsY);
      if (localObject1 != null)
      {
        localObject1 = (List)((com.tencent.mm.plugin.vlog.model.k)localObject1).Anf;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (u)((Iterator)localObject1).next();
            com.tencent.mm.plugin.vlog.model.d locald = ((u)localObject2).AoD;
            paramRectF.round(locald.gUl);
            if (!d.g.b.k.g(this.Atb, localObject2))
            {
              int i = locald.gUl.bottom - locald.pvE.bottom;
              int j = locald.gUl.top - locald.pvE.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(locald.pvE);
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
                  localRectF.round(locald.pvE);
                  locald.eY.postConcat((Matrix)localObject2);
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
      this.AsY.AsV.g(paramRectF);
      paramRectF = this.AsY.AsK;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.Ata)
      {
        paramRectF = this.AsY;
        paramRectF.AsM += 1;
      }
      this.Ata = true;
      AppMethodBeat.o(207768);
    }
    
    public final void mx(boolean paramBoolean)
    {
      this.Ata = false;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class i
    implements CropLayout.d
  {
    private float Atc = 1.0F;
    
    i(u paramu, e parame) {}
    
    public final void egj()
    {
      AppMethodBeat.i(207770);
      this.Atc = j.e(this.Atb.AoD.eY);
      AppMethodBeat.o(207770);
    }
    
    public final void egk()
    {
      AppMethodBeat.i(207771);
      Object localObject = this.Atb;
      if (this.Atc != j.e(((u)localObject).AoD.eY))
      {
        localObject = ((u)localObject).AoE;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(207771);
        return;
      }
      localObject = ((u)localObject).AoE;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(207771);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(207769);
      if (this.Atb.AoD.getScale() > 0.0F)
      {
        com.tencent.mm.bt.b localb = parame.getPresenter();
        d.g.b.k.g(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.Atb.AoD.getScale());
      }
      this.Atb.AoD.pvE.set(this.AsY.AsV.getContentRect());
      AppMethodBeat.o(207769);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewVideo$4", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class j
    implements WxCropOperationLayout.i
  {
    private boolean Ata = true;
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(207772);
      d.g.b.k.h(paramRectF, "rectF");
      Object localObject = a.b(this.AsY);
      if (localObject != null)
      {
        localObject = ((c)localObject).egm();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).f(paramRectF);
        }
      }
      paramRectF = this.AsY.AsK;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.Ata)
      {
        paramRectF = this.AsY;
        paramRectF.AsM += 1;
      }
      this.Ata = true;
      AppMethodBeat.o(207772);
    }
    
    public final void mx(boolean paramBoolean)
    {
      AppMethodBeat.i(207773);
      Object localObject = a.b(this.AsY);
      if (localObject != null)
      {
        localObject = ((c)localObject).egm();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).mx(paramBoolean);
        }
      }
      this.Ata = false;
      AppMethodBeat.o(207773);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class k
    implements a.e
  {
    public final void pause()
    {
      AppMethodBeat.i(207775);
      VLogCompositionPlayView localVLogCompositionPlayView = a.d(this.AsY);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.pause();
        AppMethodBeat.o(207775);
        return;
      }
      AppMethodBeat.o(207775);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(207776);
      VLogCompositionPlayView localVLogCompositionPlayView = a.d(this.AsY);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.resume();
        AppMethodBeat.o(207776);
        return;
      }
      AppMethodBeat.o(207776);
    }
    
    public final void vr(long paramLong)
    {
      AppMethodBeat.i(207774);
      VLogCompositionPlayView localVLogCompositionPlayView = a.d(this.AsY);
      if (localVLogCompositionPlayView != null)
      {
        localVLogCompositionPlayView.seekTo(paramLong);
        AppMethodBeat.o(207774);
        return;
      }
      AppMethodBeat.o(207774);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.a
 * JD-Core Version:    0.7.0.1
 */