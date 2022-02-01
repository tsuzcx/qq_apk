package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.o;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.videocomposition.play.a.a.c;
import com.tencent.mm.view.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "layout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentPreviewPath", "", "currentType", "defaultHalfRect", "Landroid/graphics/Rect;", "fpsCounter", "Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "fpsStart", "isFullscreenMode", "", "()Z", "setFullscreenMode", "(Z)V", "isPreviewHalfScreen", "setPreviewHalfScreen", "getLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "setLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "performance", "Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "getPerformance", "()Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "setPerformance", "(Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;)V", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "previewVideoMaxFpsLimit", "getPreviewVideoMaxFpsLimit", "setPreviewVideoMaxFpsLimit", "sceneDescTextView", "Landroid/widget/TextView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "videoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "addSceneDescTv", "", "calcOriginRect", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "currentVideoComposition", "enableFullscreenMode", "enableTouchCropLayout", "enable", "flushSurface", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVideoView", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isHalfRectChanged", "isLockMedia", "isPreviewingVideo", "onClick", "v", "Landroid/view/View;", "onDetach", "onPreviewFullScreen", "onPreviewHalfScreen", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onPreviewVideo", "muteOrigin", "onUpdateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "pausePreview", "registerCallback", "callback", "release", "releaseVideo", "reset", "resumePreview", "seek", "startMs", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setLoop", "loop", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "showPlayView", "showVideoOrImageLabel", "stopPreview", "unregisterCallback", "updateValidArea", "showTab", "showAddImage", "fullscreen", "videoPause", "videoResume", "Companion", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class d
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  public static final a NuS;
  com.tencent.mm.plugin.recordvideo.plugin.parent.d APl;
  private long BYV;
  final RectF BZm;
  private WxCropOperationLayout.j BZo;
  private long BZs;
  boolean MZN;
  public ac Nlb;
  public final RectF Nmi;
  public com.tencent.mm.plugin.vlog.model.v NrK;
  public CropLayout.c NuA;
  public int NuB;
  private TextView NuC;
  private String NuD;
  public Rect NuE;
  public boolean NuF;
  public final e NuG;
  public e NuH;
  public long NuI;
  public long NuJ;
  private final z NuK;
  private final v NuL;
  private y NuM;
  public int NuN;
  private final o NuO;
  private long NuP;
  public MultiEditCropLayout NuQ;
  public MultiEditCropOperationLayout NuR;
  private VideoCompositionPlayView Nux;
  private final LinkedList<b> Nuy;
  public com.tencent.mm.plugin.vlog.ui.report.a Nuz;
  private final Context context;
  public final ViewGroup parent;
  private int ttK;
  
  static
  {
    AppMethodBeat.i(225469);
    NuS = new a((byte)0);
    AppMethodBeat.o(225469);
  }
  
  public d(MultiEditCropLayout paramMultiEditCropLayout, MultiEditCropOperationLayout paramMultiEditCropOperationLayout, com.tencent.mm.plugin.recordvideo.plugin.parent.d paramd)
  {
    super(paramd, (byte)0);
    AppMethodBeat.i(225468);
    this.NuQ = paramMultiEditCropLayout;
    this.NuR = paramMultiEditCropOperationLayout;
    this.APl = paramd;
    this.context = this.NuQ.getContext();
    paramMultiEditCropLayout = this.NuQ.getParent();
    if (paramMultiEditCropLayout == null)
    {
      paramMultiEditCropLayout = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(225468);
      throw paramMultiEditCropLayout;
    }
    this.parent = ((ViewGroup)paramMultiEditCropLayout);
    this.Nmi = new RectF();
    this.Nuy = new LinkedList();
    this.Nuz = new com.tencent.mm.plugin.vlog.ui.report.a();
    this.BYV = -1L;
    this.BZm = new RectF();
    this.NuC = new TextView(this.parent.getContext());
    this.NuD = "";
    this.NuE = new Rect();
    this.BZo = WxCropOperationLayout.j.HWx;
    this.NuG = ((e)new l(this));
    this.NuN = -1;
    this.NuO = new o();
    paramMultiEditCropLayout = this.NuQ;
    paramMultiEditCropLayout.setHasBorder(false);
    paramMultiEditCropLayout.setEnableScale(true);
    paramMultiEditCropLayout.setEnableFling(true);
    paramMultiEditCropLayout.setEnableTouch(true);
    paramMultiEditCropLayout.setEnableOverScroll(false);
    this.NuQ.setBackgroundColor(0);
    this.NuK = ((z)new z()
    {
      public final WxCropOperationLayout getOperationLayout()
      {
        return (WxCropOperationLayout)this.NuT.NuR;
      }
      
      public final VideoCompositionPlayView guT()
      {
        AppMethodBeat.i(227577);
        d.i(this.NuT);
        VideoCompositionPlayView localVideoCompositionPlayView = d.d(this.NuT);
        if (localVideoCompositionPlayView == null) {
          p.iCn();
        }
        AppMethodBeat.o(227577);
        return localVideoCompositionPlayView;
      }
      
      public final ViewGroup gve()
      {
        AppMethodBeat.i(227576);
        ViewGroup localViewGroup = d.h(this.NuT);
        AppMethodBeat.o(227576);
        return localViewGroup;
      }
      
      public final CropLayout gvf()
      {
        return (CropLayout)this.NuT.NuQ;
      }
      
      public final void gvg()
      {
        AppMethodBeat.i(227579);
        com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NuT.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSg);
        AppMethodBeat.o(227579);
      }
      
      public final TextView gvh()
      {
        AppMethodBeat.i(227580);
        TextView localTextView = d.j(this.NuT);
        AppMethodBeat.o(227580);
        return localTextView;
      }
    });
    this.NuL = new v(this.NuK);
    a((b)this.NuL);
    this.NuR.HVW = false;
    this.NuR.setVisibility(8);
    this.NuR.setBlockOutsideTouch(true);
    AppMethodBeat.o(225468);
  }
  
  private final boolean NJ(long paramLong)
  {
    return (this.BZs == paramLong) || (this.BZs == 0L);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(225446);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(225446);
    return paramRect1;
  }
  
  private void guS()
  {
    this.MZN = true;
    this.NuQ.MZN = true;
    this.NuR.MZN = true;
    this.NuL.MZN = true;
  }
  
  private final void guX()
  {
    AppMethodBeat.i(225430);
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf;
    if ((com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.gwc()) && ((p.h(this.NuC.getParent(), this.parent) ^ true)))
    {
      this.NuC.setTextColor(-65536);
      localObject = this.parent.getContext();
      p.j(localObject, "parent.context");
      int i = ((Context)localObject).getResources().getDimensionPixelSize(a.d.Edge_2A);
      this.NuC.setTextSize(i);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.Nmi.top + i);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(21);
      this.parent.addView((View)this.NuC, 1, (ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(225430);
  }
  
  private final void gva()
  {
    AppMethodBeat.i(225449);
    if (this.Nux == null)
    {
      this.Nux = new VideoCompositionPlayView(this.context);
      VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.setPlayerCallback((a.a.a)new f(this));
      }
      localVideoCompositionPlayView = this.Nux;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.setPlayerProfileCallback((a.a.c)new g(this));
        AppMethodBeat.o(225449);
        return;
      }
    }
    AppMethodBeat.o(225449);
  }
  
  public final void As(boolean paramBoolean)
  {
    AppMethodBeat.i(225421);
    a(this, paramBoolean, true, 0L, 12);
    AppMethodBeat.o(225421);
  }
  
  public final void TL()
  {
    AppMethodBeat.i(225414);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.stop();
      AppMethodBeat.o(225414);
      return;
    }
    AppMethodBeat.o(225414);
  }
  
  public final com.tencent.mm.plugin.vlog.model.j a(final m paramm, String paramString)
  {
    AppMethodBeat.i(225412);
    p.k(paramm, "drawingView");
    p.k(paramString, "mediaPath");
    this.NuM = null;
    Object localObject = this.NrK;
    if (localObject != null)
    {
      localObject = (List)((com.tencent.mm.plugin.vlog.model.v)localObject).NlZ;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (p.h(((ad)localObject).path, paramString))
          {
            localObject = (ad)localObject;
            label104:
            this.NuD = paramString;
            if (localObject == null) {
              break label153;
            }
          }
        }
      }
    }
    label153:
    for (final long l = ((ad)localObject).id;; l = 0L)
    {
      if (localObject != null) {
        break label159;
      }
      paramm = bfJ(paramString);
      AppMethodBeat.o(225412);
      return paramm;
      localObject = null;
      break;
      localObject = null;
      break label104;
    }
    label159:
    this.BYV = l;
    this.ttK = 1;
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
    onPause();
    this.NuQ.HA(true);
    if (!this.MZN) {
      this.NuQ.setEnableScale(true);
    }
    WxCropOperationLayout.a(this.NuR);
    int i = ((ad)localObject).Nna;
    int j = ((ad)localObject).Nnb;
    this.NuQ.getVisibilityRect().set(this.BZm);
    if (!this.MZN) {
      this.NuR.getVisibilityRect().set(this.BZm);
    }
    if (0L == this.BZs) {
      this.BZs = l;
    }
    if (NJ(l)) {
      this.NuR.setStyle(this.BZo);
    }
    for (;;)
    {
      this.NuQ.setMaxScaleValue(((ad)localObject).Nnd.aGN);
      this.NuQ.setMinScaleValue(((ad)localObject).Nnd.aGO);
      boolean bool = this.NuQ.getContentRect().isEmpty();
      this.NuQ.a((View)paramm, i, j, ((ad)localObject).Nnd.aHZ, CropLayout.e.Ylv, (kotlin.g.a.b)new h(bool));
      if (((ad)localObject).Nnd.BZx > 0.0F)
      {
        paramString = paramm.getPresenter();
        p.j(paramString, "drawingView.presenter");
        paramString.setInitScale(1.0F / ((ad)localObject).Nnd.BZx);
      }
      this.NuR.setOnOperationCallback((WxCropOperationLayout.i)new i(this, l, (ad)localObject));
      this.NuQ.setOnChangeListener((CropLayout.c)new j(this, (ad)localObject, paramm));
      this.NuQ.setClickListener((View.OnClickListener)this);
      if (!this.MZN) {
        this.NuR.setVisibility(0);
      }
      guX();
      guY();
      paramm = ((ad)localObject).Nnd;
      AppMethodBeat.o(225412);
      return paramm;
      this.NuR.setStyle(WxCropOperationLayout.j.HWy);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(225396);
    p.k(paramb, "callback");
    if (!this.Nuy.contains(paramb)) {
      this.Nuy.add(paramb);
    }
    AppMethodBeat.o(225396);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    ac localac = null;
    AppMethodBeat.i(225425);
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + paramBoolean2 + ", seekToOriginPosition:" + paramBoolean3 + ", seekTo:" + paramLong);
    this.ttK = 2;
    this.NuD = "";
    gva();
    this.BYV = -1L;
    Object localObject1 = this.NrK;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.model.v)localObject1).Nlb;
      this.Nlb = ((ac)localObject1);
      localObject1 = this.Nlb;
      if (localObject1 != null) {
        if (paramBoolean1) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((ac)localObject1).Ap(paramBoolean1);
      localObject1 = this.Nlb;
      if (localObject1 == null) {
        break label207;
      }
      localObject2 = ((Iterable)this.Nuy).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (b)((Iterator)localObject2).next();
        if ((localObject3 instanceof d)) {
          ((d)localObject3).a((ac)localObject1, paramLong, paramBoolean3);
        }
      }
      localObject1 = null;
      break;
    }
    label207:
    localObject1 = this.NuM;
    if (localObject1 != null) {
      ((y)localObject1).Av(false);
    }
    this.NuM = ((y)this.NuL);
    localObject1 = this.NrK;
    if (localObject1 != null)
    {
      localObject1 = ((com.tencent.mm.plugin.vlog.model.v)localObject1).gtj();
      localObject2 = this.NuM;
      if (localObject2 != null) {
        ((y)localObject2).b((Size)localObject1);
      }
    }
    this.NuL.NuH = this.NuH;
    localObject1 = this.NuM;
    if (localObject1 != null) {
      ((y)localObject1).Av(true);
    }
    this.NuR.setOnOperationCallback((WxCropOperationLayout.i)new k(this));
    this.NuQ.setClickListener((View.OnClickListener)this);
    Object localObject2 = this.NuQ;
    Object localObject3 = this.NuM;
    localObject1 = localac;
    if (localObject3 != null) {
      localObject1 = ((y)localObject3).gvF();
    }
    ((MultiEditCropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
    localObject1 = this.Nlb;
    if (localObject1 != null) {
      ((ac)localObject1).akf(this.NuN);
    }
    localObject1 = this.NuM;
    if (localObject1 != null)
    {
      localac = this.Nlb;
      if (localac == null) {
        p.iCn();
      }
      ((y)localObject1).a(localac, paramBoolean2, paramBoolean3, paramLong);
    }
    if (!this.MZN) {
      this.NuR.setVisibility(0);
    }
    if (paramBoolean2)
    {
      localObject1 = this.NuH;
      if (localObject1 != null) {
        ((e)localObject1).resume();
      }
    }
    guX();
    AppMethodBeat.o(225425);
  }
  
  public final void aG(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(225401);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.aG(paramLong1, paramLong2);
      AppMethodBeat.o(225401);
      return;
    }
    AppMethodBeat.o(225401);
  }
  
  public final void aN(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(225388);
    Object localObject1 = ar.au(this.context);
    int j = ((Point)localObject1).x;
    int i = ((Point)localObject1).y;
    Object localObject2 = new Size(j, i);
    float f1;
    float f2;
    float f3;
    float f4;
    Object localObject3;
    Bundle localBundle;
    if ((paramBoolean2) && (this.NrK != null))
    {
      localObject1 = this.NrK;
      if (localObject1 == null) {
        p.iCn();
      }
      f1 = ((com.tencent.mm.plugin.vlog.model.v)localObject1).gtg();
      f2 = j / i;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      f3 = 1.0F / com.tencent.mm.plugin.vlog.util.a.gwO();
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      f4 = 1.0F / com.tencent.mm.plugin.vlog.util.a.gwN();
      localObject1 = com.tencent.mm.kernel.h.ag(ak.class);
      p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramBoolean1 = ((ak)localObject1).isDisablePostHalfScreen();
      localObject1 = com.tencent.mm.kernel.h.ag(ak.class);
      p.j(localObject1, "MMKernel.plugin(IPluginFinder::class.java)");
      paramBoolean2 = ((ak)localObject1).isAllowEditFillingFullScreen();
      Log.i("MicroMsg.EditMultiPreviewPlugin", "updateValidArea, isDisablePostHalfScreen:" + paramBoolean1 + ", isAllowEditFillingFullScreen:" + paramBoolean2);
      localObject1 = new RectF();
      this.NuR.setVisibility(8);
      if (f1 <= f2)
      {
        localObject3 = this.NrK;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(true, (Size)localObject2);
        f1 = j / f4;
        f2 = (i - f1) / 2.0F;
        ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
        this.Nmi.set(0.0F, 0.0F, j, i);
        this.NuR.NGc = false;
        localObject2 = this.APl;
        localObject3 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSo;
        localBundle = new Bundle();
        if (paramBoolean1)
        {
          i = 3;
          localBundle.putInt("PARAM_1_INT", i);
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject2).a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject3, localBundle);
          label342:
          this.NuQ.setEnableTouch(true);
          this.NuQ.setEnableScale(false);
          this.NuQ.setEnableFling(false);
          this.NuQ.setEnableScroll(false);
          this.NuR.setLimitMaxHeight(((RectF)localObject1).height());
          this.NuR.setLimitMinHeight(((RectF)localObject1).height());
          this.NuR.getVisibilityRect().set((RectF)localObject1);
          this.NuR.getMaxVisibilityRect().set(this.Nmi);
          this.NuR.postInvalidate();
          this.NuR.HVW = true;
          ((RectF)localObject1).round(this.NuE);
          this.NuE.offset(-(int)this.Nmi.left, -(int)this.Nmi.top);
          localObject2 = this.NrK;
          if (localObject2 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.vlog.model.v)localObject2).g(this.Nmi);
          CropLayout.a(this.NuQ, (RectF)localObject1);
          guS();
        }
      }
    }
    for (;;)
    {
      this.NuL.i(this.Nmi);
      localObject1 = this.NrK;
      if (localObject1 == null) {
        break label1411;
      }
      ((com.tencent.mm.plugin.vlog.model.v)localObject1).kF((int)this.Nmi.width(), (int)this.Nmi.height());
      AppMethodBeat.o(225388);
      return;
      i = 1;
      break;
      if (f1 <= 0.01F + f3)
      {
        if (paramBoolean2)
        {
          localObject3 = this.NrK;
          if (localObject3 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(false, (Size)localObject2);
          label602:
          f1 = j / f4;
          f2 = (i - f1) / 2.0F;
          ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
          if (!paramBoolean2) {
            break label736;
          }
          this.Nmi.set(0.0F, 0.0F, j, i);
          label652:
          this.NuR.NGc = false;
          localObject2 = this.APl;
          localObject3 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSo;
          localBundle = new Bundle();
          if (!paramBoolean1) {
            break label769;
          }
        }
        label769:
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject2).a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject3, localBundle);
          break;
          localObject3 = this.NrK;
          if (localObject3 == null) {
            p.iCn();
          }
          ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(true, (Size)localObject2);
          break label602;
          label736:
          localObject2 = this.Nmi;
          localObject3 = this.NrK;
          if (localObject3 == null) {
            p.iCn();
          }
          ((RectF)localObject2).set(((com.tencent.mm.plugin.vlog.model.v)localObject3).gth());
          break label652;
        }
      }
      if (f1 <= f4)
      {
        localObject3 = this.NrK;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(true, (Size)localObject2);
        f1 = j / f4;
        f2 = (i - f1) / 2.0F;
        ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
        localObject2 = this.Nmi;
        localObject3 = this.NrK;
        if (localObject3 == null) {
          p.iCn();
        }
        ((RectF)localObject2).set(((com.tencent.mm.plugin.vlog.model.v)localObject3).gth());
        this.NuR.NGc = false;
        localObject2 = this.APl;
        localObject3 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSo;
        localBundle = new Bundle();
        if (paramBoolean1) {}
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject2).a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject3, localBundle);
          break;
        }
      }
      if (f1 <= 1.777778F)
      {
        localObject3 = this.NrK;
        if (localObject3 == null) {
          p.iCn();
        }
        ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(true, (Size)localObject2);
        localObject2 = this.NrK;
        if (localObject2 == null) {
          p.iCn();
        }
        ((RectF)localObject1).set(((com.tencent.mm.plugin.vlog.model.v)localObject2).gth());
        localObject2 = this.Nmi;
        localObject3 = this.NrK;
        if (localObject3 == null) {
          p.iCn();
        }
        ((RectF)localObject2).set(((com.tencent.mm.plugin.vlog.model.v)localObject3).gth());
        localObject2 = this.APl;
        localObject3 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSo;
        localBundle = new Bundle();
        localBundle.putInt("PARAM_1_INT", 3);
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject2).a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject3, localBundle);
        break label342;
      }
      localObject3 = this.NrK;
      if (localObject3 == null) {
        p.iCn();
      }
      ((com.tencent.mm.plugin.vlog.model.v)localObject3).a(true, (Size)localObject2);
      localObject2 = this.NrK;
      if (localObject2 == null) {
        p.iCn();
      }
      ((RectF)localObject1).set(((com.tencent.mm.plugin.vlog.model.v)localObject2).gth());
      localObject2 = this.Nmi;
      localObject3 = this.NrK;
      if (localObject3 == null) {
        p.iCn();
      }
      ((RectF)localObject2).set(((com.tencent.mm.plugin.vlog.model.v)localObject3).gth());
      localObject2 = this.APl;
      localObject3 = com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSo;
      localBundle = new Bundle();
      localBundle.putInt("PARAM_1_INT", 3);
      ((com.tencent.mm.plugin.recordvideo.plugin.parent.d)localObject2).a((com.tencent.mm.plugin.recordvideo.plugin.parent.d.c)localObject3, localBundle);
      break label342;
      f1 = j;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.NGN;
      f3 = com.tencent.mm.plugin.vlog.util.a.gwN() * f1;
      f1 = j;
      int k = com.tencent.mm.ci.a.aY(this.context, a.d.Edge_12A);
      i = com.tencent.mm.ci.a.aY(this.context, a.d.Edge_18A);
      if (paramBoolean1) {
        i = com.tencent.mm.ci.a.fromDPToPix(this.context, 224) + com.tencent.mm.ci.a.aY(this.context, a.d.Edge_3A);
      }
      i = ar.au(this.context).y - k - i + 0 - ax.aB(this.context);
      Log.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + f3 + " ,validHeight:" + i);
      f2 = Math.min(f3, i * 1.0F);
      this.NuR.setLimitMaxHeight(f2);
      this.NuR.setLimitMinHeight(0.5625F * f1);
      this.NuR.fya();
      f1 = 0.0F;
      if (f2 < f3) {
        f1 = (1.0F - f2 / f3) * j / 2.0F;
      }
      f3 = k + (i - f2) / 2.0F;
      this.Nmi.set(f1, f3, j - f1, f3 + f2);
    }
    label1411:
    AppMethodBeat.o(225388);
  }
  
  public final void bXe()
  {
    AppMethodBeat.i(225419);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.bXe();
      AppMethodBeat.o(225419);
      return;
    }
    AppMethodBeat.o(225419);
  }
  
  public final com.tencent.mm.plugin.vlog.model.j bfJ(String paramString)
  {
    AppMethodBeat.i(225452);
    p.k(paramString, "path");
    Object localObject = this.NrK;
    if (localObject != null)
    {
      localObject = (List)((com.tencent.mm.plugin.vlog.model.v)localObject).NlZ;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.h(((ad)localObject).path, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (ad)paramString;
      if (paramString != null)
      {
        localObject = paramString.Nnd;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new com.tencent.mm.plugin.vlog.model.j();
      }
      AppMethodBeat.o(225452);
      return paramString;
    }
  }
  
  public final VideoCompositionPlayView guT()
  {
    AppMethodBeat.i(225398);
    gva();
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView == null) {
      p.iCn();
    }
    AppMethodBeat.o(225398);
    return localVideoCompositionPlayView;
  }
  
  public final void guU()
  {
    AppMethodBeat.i(225415);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.pause();
      AppMethodBeat.o(225415);
      return;
    }
    AppMethodBeat.o(225415);
  }
  
  public final void guV()
  {
    AppMethodBeat.i(225416);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.setVisibility(8);
      AppMethodBeat.o(225416);
      return;
    }
    AppMethodBeat.o(225416);
  }
  
  public final void guW()
  {
    AppMethodBeat.i(225417);
    VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.setVisibility(0);
      AppMethodBeat.o(225417);
      return;
    }
    AppMethodBeat.o(225417);
  }
  
  public final void guY()
  {
    AppMethodBeat.i(225432);
    Object localObject1 = this.NuM;
    if (localObject1 != null)
    {
      ((y)localObject1).gvI();
      AppMethodBeat.o(225432);
      return;
    }
    localObject1 = (d)this;
    if (((CharSequence)((d)localObject1).NuD).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.Nol;
        i = com.tencent.mm.plugin.vlog.model.local.a.bfz(((d)localObject1).NuD);
        localObject1 = ((d)localObject1).NuC;
        localObject2 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.Nzf;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.aks(i));
      }
      AppMethodBeat.o(225432);
      return;
    }
  }
  
  public final Rect guZ()
  {
    AppMethodBeat.i(225442);
    Object localObject = this.NuM;
    if (localObject != null) {}
    for (localObject = ((y)localObject).guZ(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(225442);
      return localObject;
    }
    localObject = this.NuQ.getContentRect();
    RectF localRectF = this.NuQ.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.NuQ.getContentOriginalRect(), localRect);
    AppMethodBeat.o(225442);
    return localObject;
  }
  
  public final void gvb()
  {
    AppMethodBeat.i(225456);
    if (this.Nux != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.resume();
      }
    }
    this.NuO.reset();
    this.NuP = 0L;
    AppMethodBeat.o(225456);
  }
  
  public final void gvc()
  {
    AppMethodBeat.i(225457);
    if (this.Nux != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.pause();
        AppMethodBeat.o(225457);
        return;
      }
    }
    AppMethodBeat.o(225457);
  }
  
  public final void gvd()
  {
    AppMethodBeat.i(225463);
    if (this.Nux != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.Nux;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.Nux = null;
    }
    AppMethodBeat.o(225463);
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(225395);
    p.k(paramRectF, "rect");
    this.NuL.h(paramRectF);
    this.BZm.set(paramRectF);
    if (!this.MZN)
    {
      this.NuR.getVisibilityRect().set(paramRectF);
      this.NuR.postInvalidate();
      this.NuR.setVisibility(0);
    }
    AppMethodBeat.o(225395);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(225435);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HTk);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(225435);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(225461);
    super.onDetach();
    View localView = (View)this.Nux;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(225461);
      return;
    }
    AppMethodBeat.o(225461);
  }
  
  public final void release()
  {
    AppMethodBeat.i(225462);
    super.release();
    gvd();
    this.Nuy.clear();
    AppMethodBeat.o(225462);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(225453);
    super.reset();
    this.BZs = 0L;
    this.NuQ.HA(true);
    AppMethodBeat.o(225453);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(225454);
    Object localObject = this.Nux;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).seekTo(paramLong);
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
    com.tencent.mm.plugin.vlog.model.report.b.report(0L);
    AppMethodBeat.o(225454);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Companion;", "", "()V", "TAG", "", "TYPE_IMAGE", "", "TYPE_VIDEO", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "", "plugin-vlog_release"})
  public static abstract interface b {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"})
  public static abstract interface c
    extends d.b
  {
    public abstract void LX(long paramLong);
    
    public abstract void a(d.e parame);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "", "seekToOriginPosition", "", "plugin-vlog_release"})
  public static abstract interface d
    extends d.b
  {
    public abstract void a(ac paramac, long paramLong, boolean paramBoolean);
    
    @l(iBK={1, 1, 16})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "", "pause", "", "resume", "seek", "timeMs", "", "host", "plugin-vlog_release"})
  public static abstract interface e
  {
    public abstract void Sw(long paramLong);
    
    public abstract void pause();
    
    public abstract void resume();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class f
    implements a.a.b
  {
    public final void Np(long paramLong)
    {
      AppMethodBeat.i(228273);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onPlayProgress timeMs:".concat(String.valueOf(paramLong)));
      Iterator localIterator = ((Iterable)d.c(this.NuT)).iterator();
      while (localIterator.hasNext())
      {
        d.b localb = (d.b)localIterator.next();
        if ((localb instanceof d.c)) {
          ((d.c)localb).LX(paramLong);
        }
      }
      AppMethodBeat.o(228273);
    }
    
    public final void egA()
    {
      AppMethodBeat.i(228266);
      Object localObject = ((Iterable)d.c(this.NuT)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        d.b localb = (d.b)((Iterator)localObject).next();
        if ((localb instanceof d.c)) {
          ((d.c)localb).a(this.NuT.NuG);
        }
      }
      localObject = d.d(this.NuT);
      long l;
      if (localObject != null)
      {
        l = ((VideoCompositionPlayView)localObject).getPosition();
        localObject = this.NuT.NuH;
        if (localObject != null)
        {
          ((d.e)localObject).Sw(l + this.NuT.NuI);
          AppMethodBeat.o(228266);
        }
      }
      else
      {
        localObject = d.e(this.NuT);
        if (localObject != null) {}
        for (l = ((ac)localObject).NmT.getPlayStart();; l = 0L)
        {
          l = 0L - l / 1000L;
          break;
        }
      }
      AppMethodBeat.o(228266);
    }
    
    public final void egB() {}
    
    public final void egC()
    {
      AppMethodBeat.i(228270);
      Iterator localIterator = ((Iterable)d.c(this.NuT)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(228270);
    }
    
    public final void egD()
    {
      AppMethodBeat.i(228278);
      Object localObject = d.d(this.NuT);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(228278);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NuT.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSl);
      AppMethodBeat.o(228278);
    }
    
    public final void egE() {}
    
    public final void egF()
    {
      AppMethodBeat.i(228280);
      Object localObject = d.d(this.NuT);
      if (localObject != null)
      {
        if (((VideoCompositionPlayView)localObject).isPlaying() != true) {
          AppMethodBeat.o(228280);
        }
      }
      else
      {
        AppMethodBeat.o(228280);
        return;
      }
      if (d.f(this.NuT) == 0L) {
        d.b(this.NuT, Util.currentTicks());
      }
      localObject = d.g(this.NuT);
      int i;
      if (((o)localObject).maN == 0L)
      {
        ((o)localObject).maN = Util.currentTicks();
        if (Util.ticksToNow(d.f(this.NuT)) >= 1000L)
        {
          Log.d("MicroMsg.EditMultiPreviewPlugin", "onFrame: fps " + d.g(this.NuT).getFps());
          localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
          i = d.g(this.NuT).getFps();
          if (i <= 60) {
            break label194;
          }
          com.tencent.mm.plugin.vlog.model.report.b.report(21L);
        }
      }
      for (;;)
      {
        d.b(this.NuT, 0L);
        d.g(this.NuT).reset();
        AppMethodBeat.o(228280);
        return;
        ((o)localObject).frames += 1;
        break;
        label194:
        if (i > 40) {
          com.tencent.mm.plugin.vlog.model.report.b.report(22L);
        } else if (i > 30) {
          com.tencent.mm.plugin.vlog.model.report.b.report(23L);
        } else if (i > 20) {
          com.tencent.mm.plugin.vlog.model.report.b.report(24L);
        } else if (i > 10) {
          com.tencent.mm.plugin.vlog.model.report.b.report(25L);
        } else {
          com.tencent.mm.plugin.vlog.model.report.b.report(26L);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$2", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "plugin-vlog_release"})
  public static final class g
    implements a.a.c
  {
    public final void OM(long paramLong)
    {
      AppMethodBeat.i(235447);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onSeek: ".concat(String.valueOf(paramLong)));
      Object localObject = this.NuT.Nuz;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCh.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCg) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCh.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
      com.tencent.mm.plugin.vlog.model.report.b.report(1L);
      com.tencent.mm.plugin.report.service.h.IzE.p(1468L, 2L, paramLong);
      if (paramLong <= 30L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(4L);
        AppMethodBeat.o(235447);
        return;
      }
      if (paramLong <= 100L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(5L);
        AppMethodBeat.o(235447);
        return;
      }
      if (paramLong <= 500L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(6L);
        AppMethodBeat.o(235447);
        return;
      }
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(7L);
        AppMethodBeat.o(235447);
        return;
      }
      com.tencent.mm.plugin.vlog.model.report.b.report(8L);
      AppMethodBeat.o(235447);
    }
    
    public final void Sz(long paramLong)
    {
      AppMethodBeat.i(235445);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onUpdateComposition: ".concat(String.valueOf(paramLong)));
      Object localObject = this.NuT.Nuz;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCi.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCg) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).NCi.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
      com.tencent.mm.plugin.vlog.model.report.b.report(11L);
      com.tencent.mm.plugin.report.service.h.IzE.p(1468L, 12L, paramLong);
      AppMethodBeat.o(235445);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/graphics/Matrix;", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.b<Matrix, Boolean>
  {
    h(boolean paramBoolean)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class i
    implements WxCropOperationLayout.i
  {
    private boolean NuV = true;
    
    i(long paramLong, ad paramad) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(223958);
      p.k(paramRectF, "rectF");
      if (d.a(this.NuT, l)) {
        this.NuT.BZm.set(paramRectF);
      }
      Object localObject1 = d.a(this.NuT);
      if (localObject1 != null)
      {
        localObject1 = (List)((com.tencent.mm.plugin.vlog.model.v)localObject1).NlZ;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ad)((Iterator)localObject1).next();
            com.tencent.mm.plugin.vlog.model.j localj = ((ad)localObject2).Nnd;
            paramRectF.round(localj.kXj);
            if ((!p.h(this.Not, localObject2)) && (!this.NuT.MZN))
            {
              int i = localj.kXj.bottom - localj.vcr.bottom;
              int j = localj.kXj.top - localj.vcr.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localj.vcr);
                float f1 = paramRectF.height() / localRectF.height();
                label234:
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
                  localRectF.round(localj.vcr);
                  localj.aHZ.postConcat((Matrix)localObject2);
                  break;
                  f1 = i;
                  break label234;
                  f2 = paramRectF.centerY() - localRectF.centerY();
                }
              }
            }
          }
        }
      }
      this.NuT.NuQ.b(paramRectF, false);
      paramRectF = this.NuT.NuA;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.NuV)
      {
        paramRectF = this.NuT;
        paramRectF.NuB += 1;
      }
      this.NuV = true;
      AppMethodBeat.o(223958);
    }
    
    public final void rU(boolean paramBoolean)
    {
      this.NuV = false;
    }
    
    public final void rV(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class j
    implements CropLayout.d
  {
    private float INY = 1.0F;
    
    j(ad paramad, m paramm) {}
    
    public final void gvi()
    {
      AppMethodBeat.i(244409);
      this.INY = com.tencent.mm.plugin.vlog.model.t.e(this.Not.Nnd.aHZ);
      AppMethodBeat.o(244409);
    }
    
    public final void gvj()
    {
      AppMethodBeat.i(244410);
      Object localObject = this.Not;
      if (this.INY != com.tencent.mm.plugin.vlog.model.t.e(((ad)localObject).Nnd.aHZ))
      {
        localObject = ((ad)localObject).Nnf;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(244410);
        return;
      }
      localObject = ((ad)localObject).Nnf;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(244410);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(244408);
      if (this.Not.Nnd.getScale() > 0.0F)
      {
        com.tencent.mm.ca.b localb = paramm.getPresenter();
        p.j(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.Not.Nnd.getScale());
      }
      if (!this.NuT.MZN) {
        this.Not.Nnd.vcr.set(this.NuT.NuQ.getContentRect());
      }
      AppMethodBeat.o(244408);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onUpdateVideo$3", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class k
    implements WxCropOperationLayout.i
  {
    private boolean NuV = true;
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(246028);
      p.k(paramRectF, "rectF");
      Object localObject = d.b(this.NuT);
      if (localObject != null)
      {
        localObject = ((y)localObject).gvG();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).e(paramRectF);
        }
      }
      paramRectF = this.NuT.NuA;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.NuV)
      {
        paramRectF = this.NuT;
        paramRectF.NuB += 1;
      }
      this.NuV = true;
      AppMethodBeat.o(246028);
    }
    
    public final void rU(boolean paramBoolean)
    {
      AppMethodBeat.i(246029);
      Object localObject = d.b(this.NuT);
      if (localObject != null)
      {
        localObject = ((y)localObject).gvG();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).rU(paramBoolean);
        }
      }
      this.NuV = false;
      AppMethodBeat.o(246029);
    }
    
    public final void rV(boolean paramBoolean)
    {
      AppMethodBeat.i(246030);
      Object localObject = d.b(this.NuT);
      if (localObject != null)
      {
        localObject = ((y)localObject).gvG();
        if (localObject != null)
        {
          ((WxCropOperationLayout.i)localObject).rV(paramBoolean);
          AppMethodBeat.o(246030);
          return;
        }
      }
      AppMethodBeat.o(246030);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class l
    implements d.e
  {
    public final void Sw(long paramLong)
    {
      AppMethodBeat.i(234419);
      Object localObject = com.tencent.mm.plugin.vlog.model.report.b.NoK;
      com.tencent.mm.plugin.vlog.model.report.b.report(0L);
      localObject = d.d(this.NuT);
      if (localObject != null)
      {
        ((VideoCompositionPlayView)localObject).seekTo(paramLong);
        AppMethodBeat.o(234419);
        return;
      }
      AppMethodBeat.o(234419);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(234421);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NuT.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSf);
      AppMethodBeat.o(234421);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(234422);
      com.tencent.mm.plugin.recordvideo.plugin.parent.d.b.a(this.NuT.APl, com.tencent.mm.plugin.recordvideo.plugin.parent.d.c.HSg);
      AppMethodBeat.o(234422);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */