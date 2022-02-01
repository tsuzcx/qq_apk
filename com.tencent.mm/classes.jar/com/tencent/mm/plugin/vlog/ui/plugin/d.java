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
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.vlog.a.d;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.i;
import com.tencent.mm.plugin.vlog.model.n;
import com.tencent.mm.plugin.vlog.model.t;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.cropview.CropLayout;
import com.tencent.mm.ui.widget.cropview.CropLayout.c;
import com.tencent.mm.ui.widget.cropview.CropLayout.d;
import com.tencent.mm.ui.widget.cropview.CropLayout.e;
import com.tencent.mm.videocomposition.j;
import com.tencent.mm.videocomposition.play.VideoCompositionPlayView;
import com.tencent.mm.videocomposition.play.a.a.a;
import com.tencent.mm.videocomposition.play.a.a.b;
import com.tencent.mm.videocomposition.play.a.a.c;
import com.tencent.mm.view.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/AutoRegisterPlugin;", "Landroid/view/View$OnClickListener;", "layout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentPreviewPath", "", "currentType", "defaultHalfRect", "Landroid/graphics/Rect;", "fpsCounter", "Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "fpsStart", "isFullscreenMode", "", "()Z", "setFullscreenMode", "(Z)V", "isPreviewHalfScreen", "setPreviewHalfScreen", "getLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "setLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "performance", "Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "getPerformance", "()Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "setPerformance", "(Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;)V", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "previewVideoMaxFpsLimit", "getPreviewVideoMaxFpsLimit", "setPreviewVideoMaxFpsLimit", "sceneDescTextView", "Landroid/widget/TextView;", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "videoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "addSceneDescTv", "", "calcOriginRect", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "currentVideoComposition", "enableFullscreenMode", "enableTouchCropLayout", "enable", "flushSurface", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVideoView", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isHalfRectChanged", "isLockMedia", "isPreviewingVideo", "onClick", "v", "Landroid/view/View;", "onDetach", "onPreviewFullScreen", "onPreviewHalfScreen", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onPreviewVideo", "muteOrigin", "onUpdateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "pausePreview", "registerCallback", "callback", "release", "releaseVideo", "reset", "resumePreview", "seek", "startMs", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setLoop", "loop", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "showPlayView", "showVideoOrImageLabel", "stopPreview", "unregisterCallback", "updateValidArea", "showTab", "showAddImage", "fullscreen", "videoPause", "videoResume", "Companion", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.recordvideo.plugin.a
  implements View.OnClickListener
{
  public static final d.a UhO;
  private long HKY;
  final RectF HLi;
  private WxCropOperationLayout.j HLk;
  private long HLo;
  boolean TMw;
  public ac TYA;
  public final RectF TZO;
  public v Uft;
  public MultiEditCropLayout UhP;
  public MultiEditCropOperationLayout UhQ;
  private VideoCompositionPlayView UhR;
  private final LinkedList<b> UhS;
  public com.tencent.mm.plugin.vlog.ui.report.a UhT;
  public CropLayout.c UhU;
  public int UhV;
  private TextView UhW;
  private String UhX;
  public Rect UhY;
  public boolean UhZ;
  public final e Uia;
  public e Uib;
  public long Uic;
  public long Uid;
  private final y Uie;
  private final u Uif;
  private x Uig;
  public int Uih;
  private final n Uii;
  private long Uij;
  private final Context context;
  public final ViewGroup parent;
  private int wyh;
  
  static
  {
    AppMethodBeat.i(282625);
    UhO = new d.a((byte)0);
    AppMethodBeat.o(282625);
  }
  
  public d(MultiEditCropLayout paramMultiEditCropLayout, MultiEditCropOperationLayout paramMultiEditCropOperationLayout, final com.tencent.mm.plugin.recordvideo.plugin.parent.a parama)
  {
    super(parama);
    AppMethodBeat.i(282464);
    this.UhP = paramMultiEditCropLayout;
    this.UhQ = paramMultiEditCropOperationLayout;
    this.context = this.UhP.getContext();
    paramMultiEditCropLayout = this.UhP.getParent();
    if (paramMultiEditCropLayout == null)
    {
      paramMultiEditCropLayout = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(282464);
      throw paramMultiEditCropLayout;
    }
    this.parent = ((ViewGroup)paramMultiEditCropLayout);
    this.TZO = new RectF();
    this.UhS = new LinkedList();
    this.UhT = new com.tencent.mm.plugin.vlog.ui.report.a();
    this.HKY = -1L;
    this.HLi = new RectF();
    this.UhW = new TextView(this.parent.getContext());
    this.UhX = "";
    this.UhY = new Rect();
    this.HLk = WxCropOperationLayout.j.NTk;
    this.Uia = ((e)new l(this, parama));
    this.Uih = -1;
    this.Uii = new n();
    paramMultiEditCropLayout = this.UhP;
    paramMultiEditCropLayout.setHasBorder(false);
    paramMultiEditCropLayout.setEnableScale(true);
    paramMultiEditCropLayout.setEnableFling(true);
    paramMultiEditCropLayout.setEnableTouch(true);
    paramMultiEditCropLayout.setEnableOverScroll(false);
    this.UhP.setBackgroundColor(0);
    this.Uie = ((y)new y()
    {
      public final WxCropOperationLayout getOperationLayout()
      {
        return (WxCropOperationLayout)this.Uik.UhQ;
      }
      
      public final VideoCompositionPlayView hSJ()
      {
        AppMethodBeat.i(282659);
        d.i(this.Uik);
        VideoCompositionPlayView localVideoCompositionPlayView = d.d(this.Uik);
        s.checkNotNull(localVideoCompositionPlayView);
        AppMethodBeat.o(282659);
        return localVideoCompositionPlayView;
      }
      
      public final ViewGroup hSU()
      {
        AppMethodBeat.i(282636);
        ViewGroup localViewGroup = d.h(this.Uik);
        AppMethodBeat.o(282636);
        return localViewGroup;
      }
      
      public final CropLayout hSV()
      {
        return (CropLayout)this.Uik.UhP;
      }
      
      public final void hSW()
      {
        AppMethodBeat.i(282665);
        a.b.a(parama, a.c.NOM);
        AppMethodBeat.o(282665);
      }
      
      public final TextView hSX()
      {
        AppMethodBeat.i(282669);
        TextView localTextView = d.j(this.Uik);
        AppMethodBeat.o(282669);
        return localTextView;
      }
    });
    this.Uif = new u(this.Uie);
    a((b)this.Uif);
    this.UhQ.NSK = false;
    this.UhQ.setVisibility(8);
    this.UhQ.setBlockOutsideTouch(true);
    AppMethodBeat.o(282464);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(282515);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(282515);
    return paramRect1;
  }
  
  private void hSI()
  {
    this.TMw = true;
    this.UhP.TMw = true;
    this.UhQ.TMw = true;
    this.Uif.TMw = true;
  }
  
  private final void hSN()
  {
    AppMethodBeat.i(282502);
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
    if ((com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.hTR()) && (!s.p(this.UhW.getParent(), this.parent)))
    {
      this.UhW.setTextColor(-65536);
      int i = this.parent.getContext().getResources().getDimensionPixelSize(a.d.Edge_2A);
      this.UhW.setTextSize(i);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.TZO.top + i);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(21);
      this.parent.addView((View)this.UhW, 1, (ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(282502);
  }
  
  private final void hSQ()
  {
    AppMethodBeat.i(282523);
    if (this.UhR == null)
    {
      Object localObject = this.context;
      s.s(localObject, "context");
      this.UhR = new VideoCompositionPlayView((Context)localObject);
      localObject = this.UhR;
      if (localObject != null) {
        ((VideoCompositionPlayView)localObject).setPlayerCallback((a.a.a)new f(this));
      }
      localObject = this.UhR;
      if (localObject != null) {
        ((VideoCompositionPlayView)localObject).setPlayerProfileCallback((a.a.c)new g(this));
      }
    }
    AppMethodBeat.o(282523);
  }
  
  private final boolean rx(long paramLong)
  {
    return (this.HLo == paramLong) || (this.HLo == 0L);
  }
  
  public final void FR(boolean paramBoolean)
  {
    AppMethodBeat.i(282737);
    a(this, paramBoolean, true, 0L, 12);
    AppMethodBeat.o(282737);
  }
  
  public final i a(final m paramm, String paramString)
  {
    AppMethodBeat.i(282688);
    s.u(paramm, "drawingView");
    s.u(paramString, "mediaPath");
    this.Uig = null;
    Object localObject = this.Uft;
    if (localObject == null)
    {
      localObject = null;
      this.UhX = paramString;
      if (localObject != null) {
        break label154;
      }
    }
    label154:
    for (final long l = 0L;; l = ((ad)localObject).id)
    {
      if (localObject != null) {
        break label165;
      }
      paramm = bfp(paramString);
      AppMethodBeat.o(282688);
      return paramm;
      localObject = (List)((v)localObject).TZF;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      Iterator localIterator = ((Iterable)localObject).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = localIterator.next();
      } while (!s.p(((ad)localObject).path, paramString));
      for (;;)
      {
        localObject = (ad)localObject;
        break;
        localObject = null;
      }
    }
    label165:
    this.HKY = l;
    this.wyh = 1;
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
    onPause();
    this.UhP.Nw(true);
    if (!this.TMw) {
      this.UhP.setEnableScale(true);
    }
    WxCropOperationLayout.a((WxCropOperationLayout)this.UhQ);
    int i = ((ad)localObject).UaC;
    int j = ((ad)localObject).UaD;
    this.UhP.getVisibilityRect().set(this.HLi);
    if (!this.TMw) {
      this.UhQ.getVisibilityRect().set(this.HLi);
    }
    if (0L == this.HLo) {
      this.HLo = l;
    }
    if (rx(l)) {
      this.UhQ.setStyle(this.HLk);
    }
    for (;;)
    {
      this.UhP.setMaxScaleValue(((ad)localObject).UaF.maxScale);
      this.UhP.setMinScaleValue(((ad)localObject).UaF.minScale);
      boolean bool = this.UhP.getContentRect().isEmpty();
      this.UhP.a((View)paramm, i, j, ((ad)localObject).UaF.matrix, CropLayout.e.agdt, (kotlin.g.a.b)new d.h(bool));
      if (((ad)localObject).UaF.HLs > 0.0F) {
        paramm.getPresenter().setInitScale(1.0F / ((ad)localObject).UaF.HLs);
      }
      this.UhQ.setOnOperationCallback((WxCropOperationLayout.i)new i(this, l, (ad)localObject));
      this.UhP.setOnChangeListener((CropLayout.c)new j((ad)localObject, paramm, this));
      this.UhP.setClickListener((View.OnClickListener)this);
      if (!this.TMw) {
        this.UhQ.setVisibility(0);
      }
      hSN();
      hSO();
      paramm = ((ad)localObject).UaF;
      AppMethodBeat.o(282688);
      return paramm;
      this.UhQ.setStyle(WxCropOperationLayout.j.NTl);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(282662);
    s.u(paramb, "callback");
    if (!this.UhS.contains(paramb)) {
      this.UhS.add(paramb);
    }
    AppMethodBeat.o(282662);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    ac localac = null;
    AppMethodBeat.i(282754);
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + paramBoolean2 + ", seekToOriginPosition:" + paramBoolean3 + ", seekTo:" + paramLong);
    this.wyh = 2;
    this.UhX = "";
    hSQ();
    this.HKY = -1L;
    Object localObject1 = this.Uft;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.TYA = ((ac)localObject1);
      localObject1 = this.TYA;
      if (localObject1 != null) {
        if (paramBoolean1) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((ac)localObject1).FO(paramBoolean1);
      localObject1 = this.TYA;
      if (localObject1 == null) {
        break label207;
      }
      localObject2 = ((Iterable)this.UhS).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        b localb = (b)((Iterator)localObject2).next();
        if ((localb instanceof d)) {
          ((d)localb).a((ac)localObject1, paramLong, paramBoolean3);
        }
      }
      localObject1 = ((v)localObject1).TYA;
      break;
    }
    label207:
    localObject1 = this.Uig;
    if (localObject1 != null) {
      ((x)localObject1).FU(false);
    }
    this.Uig = ((x)this.Uif);
    localObject1 = this.Uft;
    if (localObject1 != null)
    {
      localObject1 = ((v)localObject1).hQG();
      if (localObject1 != null)
      {
        localObject2 = this.Uig;
        if (localObject2 != null) {
          ((x)localObject2).h((Size)localObject1);
        }
      }
    }
    this.Uif.Uib = this.Uib;
    localObject1 = this.Uig;
    if (localObject1 != null) {
      ((x)localObject1).FU(true);
    }
    this.UhQ.setOnOperationCallback((WxCropOperationLayout.i)new k(this));
    this.UhP.setClickListener((View.OnClickListener)this);
    Object localObject2 = this.UhP;
    localObject1 = this.Uig;
    if (localObject1 == null) {}
    for (localObject1 = localac;; localObject1 = ((x)localObject1).hTu())
    {
      ((MultiEditCropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
      localObject1 = this.TYA;
      if (localObject1 != null) {
        ((ac)localObject1).apz(this.Uih);
      }
      localObject1 = this.Uig;
      if (localObject1 != null)
      {
        localac = this.TYA;
        s.checkNotNull(localac);
        ((x)localObject1).a(localac, paramBoolean2, paramBoolean3, paramLong);
      }
      if (!this.TMw) {
        this.UhQ.setVisibility(0);
      }
      if (paramBoolean2)
      {
        localObject1 = this.Uib;
        if (localObject1 != null) {
          ((e)localObject1).resume();
        }
      }
      hSN();
      AppMethodBeat.o(282754);
      return;
    }
  }
  
  public final void auq()
  {
    AppMethodBeat.i(282696);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.stop();
    }
    AppMethodBeat.o(282696);
  }
  
  public final i bfp(String paramString)
  {
    AppMethodBeat.i(282784);
    s.u(paramString, "path");
    Object localObject = this.Uft;
    if (localObject == null) {
      paramString = null;
    }
    while (paramString == null)
    {
      paramString = new i();
      AppMethodBeat.o(282784);
      return paramString;
      localObject = (List)((v)localObject).TZF;
      if (localObject == null)
      {
        paramString = null;
      }
      else
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!s.p(((ad)localObject).path, paramString));
        for (paramString = (String)localObject;; paramString = null)
        {
          paramString = (ad)paramString;
          if (paramString != null) {
            break label122;
          }
          paramString = null;
          break;
        }
        label122:
        paramString = paramString.UaF;
      }
    }
    AppMethodBeat.o(282784);
    return paramString;
  }
  
  public final void bk(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(282651);
    Object localObject1 = aw.bf(this.context);
    int j = ((Point)localObject1).x;
    int i = ((Point)localObject1).y;
    Object localObject2 = new Size(j, i);
    float f1;
    float f2;
    float f3;
    Object localObject3;
    Bundle localBundle;
    ah localah;
    if ((paramBoolean2) && (this.Uft != null))
    {
      f1 = j / i;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
      f2 = 1.0F / com.tencent.mm.plugin.vlog.util.a.hUL();
      localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
      f3 = 1.0F / com.tencent.mm.plugin.vlog.util.a.hUK();
      paramBoolean1 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).isDisablePostHalfScreen();
      paramBoolean2 = ((cn)com.tencent.mm.kernel.h.az(cn.class)).isAllowEditFillingFullScreen();
      Log.i("MicroMsg.EditMultiPreviewPlugin", "updateValidArea, isDisablePostHalfScreen:" + paramBoolean1 + ", isAllowEditFillingFullScreen:" + paramBoolean2);
      localObject1 = new RectF();
      this.UhQ.setVisibility(8);
      if (f1 <= f1)
      {
        localObject3 = this.Uft;
        s.checkNotNull(localObject3);
        ((v)localObject3).g((Size)localObject2);
        f1 = j / f3;
        f2 = (i - f1) / 2.0F;
        ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
        this.TZO.set(0.0F, 0.0F, j, i);
        this.UhQ.Usj = false;
        localObject2 = this.GrC;
        localObject3 = a.c.NOU;
        localBundle = new Bundle();
        if (paramBoolean1)
        {
          i = 3;
          localBundle.putInt("PARAM_1_INT", i);
          localah = ah.aiuX;
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject2).a((a.c)localObject3, localBundle);
          label297:
          this.UhP.setEnableTouch(true);
          this.UhP.setEnableScale(false);
          this.UhP.setEnableFling(false);
          this.UhP.setEnableScroll(false);
          this.UhQ.setLimitMaxHeight(((RectF)localObject1).height());
          this.UhQ.setLimitMinHeight(((RectF)localObject1).height());
          this.UhQ.getVisibilityRect().set((RectF)localObject1);
          this.UhQ.getMaxVisibilityRect().set(this.TZO);
          this.UhQ.postInvalidate();
          this.UhQ.NSK = true;
          ((RectF)localObject1).round(this.UhY);
          this.UhY.offset(-(int)this.TZO.left, -(int)this.TZO.top);
          localObject2 = this.Uft;
          s.checkNotNull(localObject2);
          ((v)localObject2).h(this.TZO);
          CropLayout.a((CropLayout)this.UhP, (RectF)localObject1);
          hSI();
        }
      }
    }
    for (;;)
    {
      this.Uif.i(this.TZO);
      localObject1 = this.Uft;
      if (localObject1 != null) {
        ((v)localObject1).ms((int)this.TZO.width(), (int)this.TZO.height());
      }
      AppMethodBeat.o(282651);
      return;
      i = 1;
      break;
      if (f1 <= 0.01F + f2)
      {
        if (paramBoolean2)
        {
          localObject3 = this.Uft;
          s.checkNotNull(localObject3);
          ((v)localObject3).a(false, (Size)localObject2);
          label554:
          f1 = j / f3;
          f2 = (i - f1) / 2.0F;
          ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
          if (!paramBoolean2) {
            break label690;
          }
          this.TZO.set(0.0F, 0.0F, j, i);
          label604:
          this.UhQ.Usj = false;
          localObject2 = this.GrC;
          localObject3 = a.c.NOU;
          localBundle = new Bundle();
          if (!paramBoolean1) {
            break label720;
          }
        }
        label690:
        label720:
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          localah = ah.aiuX;
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject2).a((a.c)localObject3, localBundle);
          break;
          localObject3 = this.Uft;
          s.checkNotNull(localObject3);
          ((v)localObject3).a(true, (Size)localObject2);
          break label554;
          localObject2 = this.TZO;
          localObject3 = this.Uft;
          s.checkNotNull(localObject3);
          ((RectF)localObject2).set(((v)localObject3).hQE());
          break label604;
        }
      }
      if (f1 <= f3)
      {
        localObject3 = this.Uft;
        s.checkNotNull(localObject3);
        ((v)localObject3).a(true, (Size)localObject2);
        f1 = j / f3;
        f2 = (i - f1) / 2.0F;
        ((RectF)localObject1).set(0.0F, f2, j, f1 + f2);
        localObject2 = this.TZO;
        localObject3 = this.Uft;
        s.checkNotNull(localObject3);
        ((RectF)localObject2).set(((v)localObject3).hQE());
        this.UhQ.Usj = false;
        localObject2 = this.GrC;
        localObject3 = a.c.NOU;
        localBundle = new Bundle();
        if (paramBoolean1) {}
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          localah = ah.aiuX;
          ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject2).a((a.c)localObject3, localBundle);
          break;
        }
      }
      if (f1 <= 1.777778F)
      {
        localObject3 = this.Uft;
        s.checkNotNull(localObject3);
        ((v)localObject3).a(true, (Size)localObject2);
        localObject2 = this.Uft;
        s.checkNotNull(localObject2);
        ((RectF)localObject1).set(((v)localObject2).hQE());
        localObject2 = this.TZO;
        localObject3 = this.Uft;
        s.checkNotNull(localObject3);
        ((RectF)localObject2).set(((v)localObject3).hQE());
        localObject2 = this.GrC;
        localObject3 = a.c.NOU;
        localBundle = new Bundle();
        localBundle.putInt("PARAM_1_INT", 3);
        localah = ah.aiuX;
        ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject2).a((a.c)localObject3, localBundle);
        break label297;
      }
      localObject3 = this.Uft;
      s.checkNotNull(localObject3);
      ((v)localObject3).a(true, (Size)localObject2);
      localObject2 = this.Uft;
      s.checkNotNull(localObject2);
      ((RectF)localObject1).set(((v)localObject2).hQE());
      localObject2 = this.TZO;
      localObject3 = this.Uft;
      s.checkNotNull(localObject3);
      ((RectF)localObject2).set(((v)localObject3).hQE());
      localObject2 = this.GrC;
      localObject3 = a.c.NOU;
      localBundle = new Bundle();
      localBundle.putInt("PARAM_1_INT", 3);
      localah = ah.aiuX;
      ((com.tencent.mm.plugin.recordvideo.plugin.parent.a)localObject2).a((a.c)localObject3, localBundle);
      break label297;
      f1 = j;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.UsM;
      f3 = com.tencent.mm.plugin.vlog.util.a.hUK() * f1;
      f1 = j;
      int k = com.tencent.mm.cd.a.br(this.context, a.d.Edge_12A);
      i = com.tencent.mm.cd.a.br(this.context, a.d.Edge_18A);
      if (paramBoolean1) {
        i = com.tencent.mm.cd.a.fromDPToPix(this.context, 224) + com.tencent.mm.cd.a.br(this.context, a.d.Edge_3A);
      }
      i = aw.bf(this.context).y - k - i + 0 - bf.bk(this.context);
      Log.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + f3 + " ,validHeight:" + i);
      f2 = Math.min(f3, i * 1.0F);
      this.UhQ.setLimitMaxHeight(f2);
      this.UhQ.setLimitMinHeight(0.5625F * f1);
      this.UhQ.gJN();
      f1 = 0.0F;
      if (f2 < f3) {
        f1 = (1.0F - f2 / f3) * j / 2.0F;
      }
      f3 = k + (i - f2) / 2.0F;
      this.TZO.set(f1, f3, j - f1, f3 + f2);
    }
  }
  
  public final void bs(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(282671);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.bs(paramLong1, paramLong2);
    }
    AppMethodBeat.o(282671);
  }
  
  public final void cxp()
  {
    AppMethodBeat.i(282730);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.cxp();
    }
    AppMethodBeat.o(282730);
  }
  
  public final VideoCompositionPlayView hSJ()
  {
    AppMethodBeat.i(282667);
    hSQ();
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    s.checkNotNull(localVideoCompositionPlayView);
    AppMethodBeat.o(282667);
    return localVideoCompositionPlayView;
  }
  
  public final void hSK()
  {
    AppMethodBeat.i(282704);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.pause();
    }
    AppMethodBeat.o(282704);
  }
  
  public final void hSL()
  {
    AppMethodBeat.i(282713);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.setVisibility(8);
    }
    AppMethodBeat.o(282713);
  }
  
  public final void hSM()
  {
    AppMethodBeat.i(282722);
    VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
    if (localVideoCompositionPlayView != null) {
      localVideoCompositionPlayView.setVisibility(0);
    }
    AppMethodBeat.o(282722);
  }
  
  public final void hSO()
  {
    AppMethodBeat.i(282763);
    Object localObject1 = this.Uig;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = (d)this;
        if (((CharSequence)((d)localObject1).UhX).length() <= 0) {
          break label99;
        }
      }
    }
    label99:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.UbD;
        i = com.tencent.mm.plugin.vlog.model.local.a.bfg(((d)localObject1).UhX);
        localObject1 = ((d)localObject1).UhW;
        localObject2 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.UlR;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.apN(i));
      }
      AppMethodBeat.o(282763);
      return;
      ((x)localObject1).hTx();
      localObject1 = ah.aiuX;
      break;
    }
  }
  
  public final Rect hSP()
  {
    AppMethodBeat.i(282778);
    Object localObject = this.Uig;
    if (localObject == null) {}
    for (localObject = null; localObject != null; localObject = ((x)localObject).hSP())
    {
      AppMethodBeat.o(282778);
      return localObject;
    }
    localObject = this.UhP.getContentRect();
    RectF localRectF = this.UhP.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.UhP.getContentOriginalRect(), localRect);
    AppMethodBeat.o(282778);
    return localObject;
  }
  
  public final void hSR()
  {
    AppMethodBeat.i(282808);
    if (this.UhR != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.resume();
      }
    }
    this.Uii.reset();
    this.Uij = 0L;
    AppMethodBeat.o(282808);
  }
  
  public final void hSS()
  {
    AppMethodBeat.i(282814);
    if (this.UhR != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.pause();
      }
    }
    AppMethodBeat.o(282814);
  }
  
  public final void hST()
  {
    AppMethodBeat.i(282841);
    if (this.UhR != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.UhR;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.UhR = null;
    }
    AppMethodBeat.o(282841);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(282769);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    a.b.a(this.GrC, a.c.NPQ);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(282769);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(282825);
    super.onDetach();
    View localView = (View)this.UhR;
    if (localView != null) {
      localView.setAlpha(0.0F);
    }
    AppMethodBeat.o(282825);
  }
  
  public final void release()
  {
    AppMethodBeat.i(282836);
    super.release();
    hST();
    this.UhS.clear();
    AppMethodBeat.o(282836);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(282791);
    super.reset();
    this.HLo = 0L;
    this.UhP.Nw(true);
    AppMethodBeat.o(282791);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(282798);
    Object localObject = this.UhR;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).seekTo(paramLong);
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
    com.tencent.mm.plugin.vlog.model.report.b.report(0L);
    AppMethodBeat.o(282798);
  }
  
  public final void setVisibleRect(RectF paramRectF)
  {
    AppMethodBeat.i(282658);
    s.u(paramRectF, "rect");
    this.Uif.setVisibleRect(paramRectF);
    this.HLi.set(paramRectF);
    if (!this.TMw)
    {
      this.UhQ.getVisibilityRect().set(paramRectF);
      this.UhQ.postInvalidate();
      this.UhQ.setVisibility(0);
    }
    AppMethodBeat.o(282658);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
    extends d.b
  {
    public abstract void a(d.e parame);
    
    public abstract void qU(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "", "seekToOriginPosition", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
    extends d.b
  {
    public abstract void a(ac paramac, long paramLong, boolean paramBoolean);
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "", "pause", "", "resume", "seek", "timeMs", "", "host", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
  {
    public abstract void pause();
    
    public abstract void resume();
    
    public abstract void wK(long paramLong);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements a.a.b
  {
    f(d paramd) {}
    
    public final void fiA()
    {
      AppMethodBeat.i(282315);
      Object localObject = d.d(this.Uik);
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(282315);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      a.b.a(this.Uik.GrC, a.c.NOR);
      AppMethodBeat.o(282315);
    }
    
    public final void fiB() {}
    
    public final void fiC()
    {
      int i = 1;
      AppMethodBeat.i(282330);
      Object localObject = d.d(this.Uik);
      if ((localObject != null) && (((VideoCompositionPlayView)localObject).isPlaying() == true)) {}
      while (i == 0)
      {
        AppMethodBeat.o(282330);
        return;
        i = 0;
      }
      if (d.f(this.Uik) == 0L) {
        d.b(this.Uik, Util.currentTicks());
      }
      localObject = d.g(this.Uik);
      if (((n)localObject).oTE == 0L)
      {
        ((n)localObject).oTE = Util.currentTicks();
        if (Util.ticksToNow(d.f(this.Uik)) >= 1000L)
        {
          Log.d("MicroMsg.EditMultiPreviewPlugin", s.X("onFrame: fps ", Integer.valueOf(d.g(this.Uik).getFps())));
          localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
          i = d.g(this.Uik).getFps();
          if (i <= 60) {
            break label192;
          }
          com.tencent.mm.plugin.vlog.model.report.b.report(21L);
        }
      }
      for (;;)
      {
        d.b(this.Uik, 0L);
        d.g(this.Uik).reset();
        AppMethodBeat.o(282330);
        return;
        ((n)localObject).frames += 1;
        break;
        label192:
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
    
    public final void fix()
    {
      AppMethodBeat.i(282282);
      Object localObject2 = (Iterable)d.c(this.Uik);
      Object localObject1 = this.Uik;
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        d.b localb = (d.b)((Iterator)localObject2).next();
        if ((localb instanceof d.c)) {
          ((d.c)localb).a(((d)localObject1).Uia);
        }
      }
      localObject1 = d.d(this.Uik);
      if (localObject1 == null)
      {
        localObject1 = null;
        if (localObject1 != null) {
          break label173;
        }
        localObject1 = d.e(this.Uik);
        if (localObject1 != null) {
          break label162;
        }
        l = 0L;
      }
      label110:
      for (long l = 0L - l / 1000L;; l = ((Long)localObject1).longValue())
      {
        localObject1 = this.Uik.Uib;
        if (localObject1 != null) {
          ((d.e)localObject1).wK(l + this.Uik.Uic);
        }
        AppMethodBeat.o(282282);
        return;
        localObject1 = Long.valueOf(((VideoCompositionPlayView)localObject1).getPosition());
        break;
        l = ((ac)localObject1).Uaw.getPlayStart();
        break label110;
      }
    }
    
    public final void fiy() {}
    
    public final void fiz()
    {
      AppMethodBeat.i(282300);
      Iterator localIterator = ((Iterable)d.c(this.Uik)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(282300);
    }
    
    public final void qT(long paramLong)
    {
      AppMethodBeat.i(282307);
      Log.d("MicroMsg.EditMultiPreviewPlugin", s.X("onPlayProgress timeMs:", Long.valueOf(paramLong)));
      Iterator localIterator = ((Iterable)d.c(this.Uik)).iterator();
      while (localIterator.hasNext())
      {
        d.b localb = (d.b)localIterator.next();
        if ((localb instanceof d.c)) {
          ((d.c)localb).qU(paramLong);
        }
      }
      AppMethodBeat.o(282307);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$2", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements a.a.c
  {
    g(d paramd) {}
    
    public final void sK(long paramLong)
    {
      AppMethodBeat.i(282279);
      Log.d("MicroMsg.EditMultiPreviewPlugin", s.X("onSeek: ", Long.valueOf(paramLong)));
      Object localObject = this.Uik.UhT;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoN.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoM) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoN.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
      com.tencent.mm.plugin.vlog.model.report.b.report(1L);
      com.tencent.mm.plugin.report.service.h.OAn.p(1468L, 2L, paramLong);
      if (paramLong <= 30L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(4L);
        AppMethodBeat.o(282279);
        return;
      }
      if (paramLong <= 100L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(5L);
        AppMethodBeat.o(282279);
        return;
      }
      if (paramLong <= 500L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(6L);
        AppMethodBeat.o(282279);
        return;
      }
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(7L);
        AppMethodBeat.o(282279);
        return;
      }
      com.tencent.mm.plugin.vlog.model.report.b.report(8L);
      AppMethodBeat.o(282279);
    }
    
    public final void wN(long paramLong)
    {
      AppMethodBeat.i(282267);
      Log.d("MicroMsg.EditMultiPreviewPlugin", s.X("onUpdateComposition: ", Long.valueOf(paramLong)));
      Object localObject = this.Uik.UhT;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoO.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoM) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).UoO.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
      com.tencent.mm.plugin.vlog.model.report.b.report(11L);
      com.tencent.mm.plugin.report.service.h.OAn.p(1468L, 12L, paramLong);
      AppMethodBeat.o(282267);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements WxCropOperationLayout.i
  {
    private boolean Uim = true;
    
    i(d paramd, long paramLong, ad paramad) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(282286);
      s.u(paramRectF, "rectF");
      if (d.a(this.Uik, l)) {
        this.Uik.HLi.set(paramRectF);
      }
      Object localObject1 = d.a(this.Uik);
      if (localObject1 != null)
      {
        localObject1 = (List)((v)localObject1).TZF;
        if (localObject1 != null)
        {
          Object localObject2 = (Iterable)localObject1;
          localObject1 = this.UbX;
          d locald = this.Uik;
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (ad)((Iterator)localObject2).next();
            i locali = ((ad)localObject3).UaF;
            paramRectF.round(locali.Gl);
            if ((!s.p(localObject1, localObject3)) && (!locald.TMw))
            {
              int i = locali.Gl.bottom - locali.yok.bottom;
              int j = locali.Gl.top - locali.yok.top;
              if ((i > 0) || (j < 0))
              {
                localObject3 = new Matrix();
                RectF localRectF = new RectF(locali.yok);
                float f1 = paramRectF.height() / localRectF.height();
                label246:
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
                  ((Matrix)localObject3).postTranslate(0.0F, f2);
                  ((Matrix)localObject3).postScale(f1, f1, paramRectF.centerX(), paramRectF.centerY());
                  ((Matrix)localObject3).mapRect(localRectF);
                  localRectF.round(locali.yok);
                  locali.matrix.postConcat((Matrix)localObject3);
                  break;
                  f1 = i;
                  break label246;
                  f2 = paramRectF.centerY() - localRectF.centerY();
                }
              }
            }
          }
        }
      }
      this.Uik.UhP.b(paramRectF, false);
      paramRectF = this.Uik.UhU;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.Uim)
      {
        paramRectF = this.Uik;
        paramRectF.UhV += 1;
      }
      this.Uim = true;
      AppMethodBeat.o(282286);
    }
    
    public final void vS(boolean paramBoolean)
    {
      this.Uim = false;
    }
    
    public final void vT(boolean paramBoolean)
    {
      AppMethodBeat.i(282301);
      s.u(this, "this");
      AppMethodBeat.o(282301);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements CropLayout.d
  {
    private float OVa = 1.0F;
    
    j(ad paramad, m paramm, d paramd) {}
    
    public final void hSY()
    {
      AppMethodBeat.i(282314);
      this.OVa = t.g(this.UbX.UaF.matrix);
      AppMethodBeat.o(282314);
    }
    
    public final void hSZ()
    {
      AppMethodBeat.i(282323);
      Object localObject = this.UbX;
      if (this.OVa == t.g(((ad)localObject).UaF.matrix)) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = ((ad)localObject).UaH;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(282323);
        return;
      }
      localObject = ((ad)localObject).UaH;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(282323);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(282308);
      if (this.UbX.UaF.getScale() > 0.0F) {
        paramm.getPresenter().setInitScale(1.0F / this.UbX.UaF.getScale());
      }
      if (!jdField_this.TMw) {
        this.UbX.UaF.yok.set(jdField_this.UhP.getContentRect());
      }
      AppMethodBeat.o(282308);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onUpdateVideo$3", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements WxCropOperationLayout.i
  {
    private boolean Uim = true;
    
    k(d paramd) {}
    
    public final void f(RectF paramRectF)
    {
      AppMethodBeat.i(282509);
      s.u(paramRectF, "rectF");
      x localx = d.b(this.Uik);
      if (localx != null) {
        localx.hTv().f(paramRectF);
      }
      paramRectF = this.Uik.UhU;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.Uim)
      {
        paramRectF = this.Uik;
        paramRectF.UhV += 1;
      }
      this.Uim = true;
      AppMethodBeat.o(282509);
    }
    
    public final void vS(boolean paramBoolean)
    {
      AppMethodBeat.i(282519);
      x localx = d.b(this.Uik);
      if (localx != null) {
        localx.hTv().vS(paramBoolean);
      }
      this.Uim = false;
      AppMethodBeat.o(282519);
    }
    
    public final void vT(boolean paramBoolean)
    {
      AppMethodBeat.i(282529);
      x localx = d.b(this.Uik);
      if (localx != null) {
        localx.hTv().vT(paramBoolean);
      }
      AppMethodBeat.o(282529);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements d.e
  {
    l(d paramd, com.tencent.mm.plugin.recordvideo.plugin.parent.a parama) {}
    
    public final void pause()
    {
      AppMethodBeat.i(282522);
      a.b.a(parama, a.c.NOL);
      AppMethodBeat.o(282522);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(282531);
      a.b.a(parama, a.c.NOM);
      AppMethodBeat.o(282531);
    }
    
    public final void wK(long paramLong)
    {
      AppMethodBeat.i(282512);
      Object localObject = com.tencent.mm.plugin.vlog.model.report.b.Ucm;
      com.tencent.mm.plugin.vlog.model.report.b.report(0L);
      localObject = d.d(this.Uik);
      if (localObject != null) {
        ((VideoCompositionPlayView)localObject).seekTo(paramLong);
      }
      AppMethodBeat.o(282512);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.d
 * JD-Core Version:    0.7.0.1
 */