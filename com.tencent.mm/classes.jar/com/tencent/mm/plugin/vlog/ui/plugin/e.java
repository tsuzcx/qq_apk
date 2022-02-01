package com.tencent.mm.plugin.vlog.ui.plugin;

import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.recordvideo.jumper.MediaEditReportInfo.EditItem;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.d.c;
import com.tencent.mm.plugin.recordvideo.plugin.t.a;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.i;
import com.tencent.mm.plugin.recordvideo.ui.WxCropOperationLayout.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.vlog.model.ac;
import com.tencent.mm.plugin.vlog.model.ad;
import com.tencent.mm.plugin.vlog.model.j;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.ui.widget.CropOperationContainer;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropLayout;
import com.tencent.mm.plugin.vlog.ui.widget.MultiEditCropOperationLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
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
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "layout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "operationLayout", "Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "audioPlayRangeOffset", "", "getAudioPlayRangeOffset", "()J", "setAudioPlayRangeOffset", "(J)V", "audioSeekTimeOffset", "getAudioSeekTimeOffset", "setAudioSeekTimeOffset", "audioSeekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "getAudioSeekable", "()Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "setAudioSeekable", "(Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;)V", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "cropSizeCount", "", "getCropSizeCount", "()I", "setCropSizeCount", "(I)V", "currentPreviewImpl", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewImpl;", "currentPreviewMediaId", "currentPreviewPath", "", "currentType", "defaultHalfRect", "Landroid/graphics/Rect;", "fpsCounter", "Lcom/tencent/mm/plugin/vlog/model/FpsCounter;", "fpsStart", "isFullscreenMode", "", "()Z", "setFullscreenMode", "(Z)V", "isPreviewHalfScreen", "setPreviewHalfScreen", "getLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;", "setLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropLayout;)V", "lockCropMediaId", "lockCropRect", "Landroid/graphics/RectF;", "getLockCropRect", "()Landroid/graphics/RectF;", "maxVisibleRect", "multiMedia", "Lcom/tencent/mm/plugin/vlog/model/MultiMediaModel;", "multiVideoPreview", "Lcom/tencent/mm/plugin/vlog/ui/plugin/MultiVideoPreviewImpl;", "onChangeListener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "getOnChangeListener", "()Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;", "setOnChangeListener", "(Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeListener;)V", "getOperationLayout", "()Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;", "setOperationLayout", "(Lcom/tencent/mm/plugin/vlog/ui/widget/MultiEditCropOperationLayout;)V", "parent", "Landroid/view/ViewGroup;", "performance", "Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "getPerformance", "()Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;", "setPerformance", "(Lcom/tencent/mm/plugin/vlog/ui/report/MultiVideoPerformance;)V", "previewCallbacks", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "previewProvider", "Lcom/tencent/mm/plugin/vlog/ui/plugin/PreviewProvider;", "previewVideoMaxFpsLimit", "getPreviewVideoMaxFpsLimit", "setPreviewVideoMaxFpsLimit", "sceneDescTextView", "Landroid/widget/TextView;", "getStatus", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;", "setStatus", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus;)V", "value", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;", "style", "setStyle", "(Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$Style;)V", "videoSeekable", "getVideoSeekable", "videoView", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayView;", "addSceneDescTv", "", "calcOriginRect", "contentRect", "viewRect", "clipRect", "checkInitVideoView", "currentPlayingTrack", "Lcom/tencent/mm/plugin/vlog/model/VLogCompositionTrack;", "currentVideoComposition", "enableFullscreenMode", "enableTouchCropLayout", "enable", "flushSurface", "getCropInView", "getCropInfo", "Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "path", "getCropLayoutIndex", "getCurrentCropInfo", "mediaId", "(Ljava/lang/Long;)Lcom/tencent/mm/plugin/vlog/model/CropInfo;", "getDefaultVisibilityRect", "getMaxVisibleRect", "getVideoView", "getVisibilityRect", "getVisibleRect", "hidePlayView", "isHalfRectChanged", "isLockMedia", "isPreviewingVideo", "onClick", "v", "Landroid/view/View;", "onDetach", "onPreviewFullScreen", "onPreviewHalfScreen", "onPreviewImage", "drawingView", "Lcom/tencent/mm/view/PhotoDrawingView;", "mediaPath", "isHard", "onPreviewVideo", "muteOrigin", "onUpdateVideo", "playAfterUpdate", "seekToOriginPosition", "seekTo", "pausePreview", "registerCallback", "callback", "release", "releaseVideo", "reset", "resumePreview", "seek", "startMs", "setContentMovable", "movable", "setCropLayoutTouchListener", "listener", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$CropLayoutTouchListener;", "setLoop", "loop", "setMultiMedia", "multiMediaModel", "setMuteOrigin", "mute", "setPlayRange", "start", "end", "setVisibleRect", "rect", "showPlayView", "showVideoOrImageLabel", "stopPreview", "unregisterCallback", "updateValidArea", "showTab", "showAddImage", "fullscreen", "videoPause", "videoResume", "Companion", "PreviewCallback", "PreviewSeekCallback", "PreviewUpdateCallback", "Seekable", "plugin-vlog_release"})
public final class e
  implements View.OnClickListener, com.tencent.mm.plugin.recordvideo.plugin.t
{
  public static final e.a GHf;
  public v GDT;
  private VideoCompositionPlayView GGK;
  private final LinkedList<b> GGL;
  public com.tencent.mm.plugin.vlog.ui.report.a GGM;
  public CropLayout.c GGN;
  public int GGO;
  private TextView GGP;
  private String GGQ;
  public Rect GGR;
  public boolean GGS;
  public final e GGT;
  public e GGU;
  public long GGV;
  public long GGW;
  private final aa GGX;
  private final w GGY;
  private z GGZ;
  public int GHa;
  private final com.tencent.mm.plugin.vlog.model.n GHb;
  private long GHc;
  public MultiEditCropLayout GHd;
  public MultiEditCropOperationLayout GHe;
  boolean Gna;
  public ac GxA;
  public final RectF GyG;
  private final Context context;
  private int pXO;
  public final ViewGroup parent;
  d wgr;
  private long xmD;
  final RectF xmU;
  private WxCropOperationLayout.j xmW;
  private long xna;
  
  static
  {
    AppMethodBeat.i(191272);
    GHf = new e.a((byte)0);
    AppMethodBeat.o(191272);
  }
  
  public e(MultiEditCropLayout paramMultiEditCropLayout, MultiEditCropOperationLayout paramMultiEditCropOperationLayout, d paramd)
  {
    AppMethodBeat.i(191271);
    this.GHd = paramMultiEditCropLayout;
    this.GHe = paramMultiEditCropOperationLayout;
    this.wgr = paramd;
    this.context = this.GHd.getContext();
    paramMultiEditCropLayout = this.GHd.getParent();
    if (paramMultiEditCropLayout == null)
    {
      paramMultiEditCropLayout = new kotlin.t("null cannot be cast to non-null type android.view.ViewGroup");
      AppMethodBeat.o(191271);
      throw paramMultiEditCropLayout;
    }
    this.parent = ((ViewGroup)paramMultiEditCropLayout);
    this.GyG = new RectF();
    this.GGL = new LinkedList();
    this.GGM = new com.tencent.mm.plugin.vlog.ui.report.a();
    this.xmD = -1L;
    this.xmU = new RectF();
    this.GGP = new TextView(this.parent.getContext());
    this.GGQ = "";
    this.GGR = new Rect();
    this.xmW = WxCropOperationLayout.j.BZI;
    this.GGT = ((e)new l(this));
    this.GHa = -1;
    this.GHb = new com.tencent.mm.plugin.vlog.model.n();
    paramMultiEditCropLayout = this.GHd;
    paramMultiEditCropLayout.setHasBorder(false);
    paramMultiEditCropLayout.setEnableScale(true);
    paramMultiEditCropLayout.setEnableFling(true);
    paramMultiEditCropLayout.setEnableTouch(true);
    paramMultiEditCropLayout.setEnableOverScroll(false);
    this.GHd.setBackgroundColor(0);
    this.GGX = ((aa)new aa()
    {
      public final VideoCompositionPlayView fCU()
      {
        AppMethodBeat.i(191220);
        e.i(this.GHg);
        VideoCompositionPlayView localVideoCompositionPlayView = e.d(this.GHg);
        if (localVideoCompositionPlayView == null) {
          p.hyc();
        }
        AppMethodBeat.o(191220);
        return localVideoCompositionPlayView;
      }
      
      public final ViewGroup fDf()
      {
        AppMethodBeat.i(191219);
        ViewGroup localViewGroup = e.h(this.GHg);
        AppMethodBeat.o(191219);
        return localViewGroup;
      }
      
      public final CropLayout fDg()
      {
        return (CropLayout)this.GHg.GHd;
      }
      
      public final void fDh()
      {
        AppMethodBeat.i(191221);
        d.b.a(this.GHg.wgr, d.c.BVs);
        AppMethodBeat.o(191221);
      }
      
      public final TextView fDi()
      {
        AppMethodBeat.i(191222);
        TextView localTextView = e.j(this.GHg);
        AppMethodBeat.o(191222);
        return localTextView;
      }
      
      public final WxCropOperationLayout getOperationLayout()
      {
        return (WxCropOperationLayout)this.GHg.GHe;
      }
    });
    this.GGY = new w(this.GGX);
    a((b)this.GGY);
    this.GHe.BZh = false;
    this.GHe.setVisibility(8);
    this.GHe.setBlockOutsideTouch(true);
    AppMethodBeat.o(191271);
  }
  
  private final boolean GF(long paramLong)
  {
    return (this.xna == paramLong) || (this.xna == 0L);
  }
  
  private static Rect a(Rect paramRect1, Rect paramRect2, Rect paramRect3)
  {
    AppMethodBeat.i(191261);
    float f = 1.0F * paramRect1.width() / paramRect2.width();
    int i = paramRect3.left - paramRect1.left;
    int j = paramRect3.top - paramRect1.top;
    int k = paramRect3.width();
    int m = paramRect3.height();
    paramRect1 = new Rect((int)(i / f), (int)(j / f), (int)((k + i) / f), (int)((m + j) / f));
    AppMethodBeat.o(191261);
    return paramRect1;
  }
  
  private void fCT()
  {
    this.Gna = true;
    this.GHd.Gna = true;
    this.GHe.Gna = true;
    this.GGY.Gna = true;
  }
  
  private final void fCY()
  {
    AppMethodBeat.i(191257);
    Object localObject = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
    if ((com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.fEc()) && ((p.j(this.GGP.getParent(), this.parent) ^ true)))
    {
      this.GGP.setTextColor(-65536);
      localObject = this.parent.getContext();
      p.g(localObject, "parent.context");
      int i = ((Context)localObject).getResources().getDimensionPixelSize(2131165296);
      this.GGP.setTextSize(i);
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)this.GyG.top + i);
      ((RelativeLayout.LayoutParams)localObject).rightMargin = i;
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(21);
      this.parent.addView((View)this.GGP, 1, (ViewGroup.LayoutParams)localObject);
    }
    AppMethodBeat.o(191257);
  }
  
  private final void fDb()
  {
    AppMethodBeat.i(191262);
    if (this.GGK == null)
    {
      this.GGK = new VideoCompositionPlayView(this.context);
      VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.setPlayerCallback((a.a.a)new f(this));
      }
      localVideoCompositionPlayView = this.GGK;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.setPlayerProfileCallback((a.a.c)new g(this));
        AppMethodBeat.o(191262);
        return;
      }
    }
    AppMethodBeat.o(191262);
  }
  
  public final j a(final m paramm, String paramString)
  {
    AppMethodBeat.i(191247);
    p.h(paramm, "drawingView");
    p.h(paramString, "mediaPath");
    this.GGZ = null;
    Object localObject = this.GDT;
    if (localObject != null)
    {
      localObject = (List)((v)localObject).Gyx;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = localIterator.next();
          if (p.j(((ad)localObject).path, paramString))
          {
            localObject = (ad)localObject;
            label104:
            this.GGQ = paramString;
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
      paramm = aUk(paramString);
      AppMethodBeat.o(191247);
      return paramm;
      localObject = null;
      break;
      localObject = null;
      break label104;
    }
    label159:
    this.xmD = l;
    this.pXO = 1;
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onPreviewImage");
    this.GHd.De(true);
    if (!this.Gna) {
      this.GHd.setEnableScale(true);
    }
    WxCropOperationLayout.a(this.GHe);
    int i = ((ad)localObject).Gzu;
    int j = ((ad)localObject).Gzv;
    this.GHd.getVisibilityRect().set(this.xmU);
    if (!this.Gna) {
      this.GHe.getVisibilityRect().set(this.xmU);
    }
    if (0L == this.xna) {
      this.xna = l;
    }
    if (GF(l)) {
      this.GHe.setStyle(this.xmW);
    }
    for (;;)
    {
      this.GHd.setMaxScaleValue(((ad)localObject).Gzx.aXt);
      this.GHd.setMinScaleValue(((ad)localObject).Gzx.aXu);
      boolean bool = this.GHd.getContentRect().isEmpty();
      this.GHd.a((View)paramm, i, j, ((ad)localObject).Gzx.gT, CropLayout.e.QMD, (kotlin.g.a.b)new e.h(bool));
      if (((ad)localObject).Gzx.xnf > 0.0F)
      {
        paramString = paramm.getPresenter();
        p.g(paramString, "drawingView.presenter");
        paramString.setInitScale(1.0F / ((ad)localObject).Gzx.xnf);
      }
      this.GHe.setOnOperationCallback((WxCropOperationLayout.i)new i(this, l, (ad)localObject));
      this.GHd.setOnChangeListener((CropLayout.c)new j(this, (ad)localObject, paramm));
      this.GHd.setClickListener((View.OnClickListener)this);
      if (!this.Gna) {
        this.GHe.setVisibility(0);
      }
      fCY();
      fCZ();
      paramm = ((ad)localObject).Gzx;
      AppMethodBeat.o(191247);
      return paramm;
      this.GHe.setStyle(WxCropOperationLayout.j.BZJ);
    }
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(191244);
    p.h(paramb, "callback");
    if (!this.GGL.contains(paramb)) {
      this.GGL.add(paramb);
    }
    AppMethodBeat.o(191244);
  }
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong)
  {
    ac localac = null;
    AppMethodBeat.i(191255);
    Log.i("MicroMsg.EditMultiPreviewPlugin", "onUpdateVideo, playAfterUpdate:" + paramBoolean2 + ", seekToOriginPosition:" + paramBoolean3 + ", seekTo:" + paramLong);
    this.pXO = 2;
    this.GGQ = "";
    fDb();
    this.xmD = -1L;
    Object localObject1 = this.GDT;
    if (localObject1 != null)
    {
      localObject1 = ((v)localObject1).GxA;
      this.GxA = ((ac)localObject1);
      localObject1 = this.GxA;
      if (localObject1 != null) {
        if (paramBoolean1) {
          break label202;
        }
      }
    }
    label202:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      ((ac)localObject1).wB(paramBoolean1);
      localObject1 = this.GxA;
      if (localObject1 == null) {
        break label207;
      }
      localObject2 = ((Iterable)this.GGL).iterator();
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
    localObject1 = this.GGZ;
    if (localObject1 != null) {
      ((z)localObject1).wH(false);
    }
    this.GGZ = ((z)this.GGY);
    localObject1 = this.GDT;
    if (localObject1 != null)
    {
      localObject1 = ((v)localObject1).fBn();
      localObject2 = this.GGZ;
      if (localObject2 != null) {
        ((z)localObject2).a((Size)localObject1);
      }
    }
    this.GGY.GGU = this.GGU;
    localObject1 = this.GGZ;
    if (localObject1 != null) {
      ((z)localObject1).wH(true);
    }
    this.GHe.setOnOperationCallback((WxCropOperationLayout.i)new k(this));
    this.GHd.setClickListener((View.OnClickListener)this);
    Object localObject2 = this.GHd;
    Object localObject3 = this.GGZ;
    localObject1 = localac;
    if (localObject3 != null) {
      localObject1 = ((z)localObject3).fDH();
    }
    ((MultiEditCropLayout)localObject2).setOnChangeListener((CropLayout.c)localObject1);
    localObject1 = this.GxA;
    if (localObject1 != null) {
      ((ac)localObject1).acz(this.GHa);
    }
    localObject1 = this.GGZ;
    if (localObject1 != null)
    {
      localac = this.GxA;
      if (localac == null) {
        p.hyc();
      }
      ((z)localObject1).a(localac, paramBoolean2, paramBoolean3, paramLong);
    }
    if (!this.Gna) {
      this.GHe.setVisibility(0);
    }
    if (paramBoolean2)
    {
      localObject1 = this.GGU;
      if (localObject1 != null) {
        ((e)localObject1).resume();
      }
    }
    fCY();
    AppMethodBeat.o(191255);
  }
  
  public final void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(191241);
    Object localObject1 = ao.az(this.context);
    int j = ((Point)localObject1).x;
    int i = ((Point)localObject1).y;
    localObject1 = new Size(j, i);
    Object localObject2;
    float f1;
    float f2;
    float f3;
    float f4;
    RectF localRectF;
    Bundle localBundle;
    if ((paramBoolean2) && (this.GDT != null))
    {
      localObject2 = this.GDT;
      if (localObject2 == null) {
        p.hyc();
      }
      f1 = ((v)localObject2).fBk();
      f2 = j / i;
      localObject2 = com.tencent.mm.plugin.vlog.util.a.GQC;
      f3 = 1.0F / com.tencent.mm.plugin.vlog.util.a.fEB();
      localObject2 = com.tencent.mm.plugin.vlog.util.a.GQC;
      f4 = 1.0F / com.tencent.mm.plugin.vlog.util.a.fEA();
      localObject2 = g.ah(aj.class);
      p.g(localObject2, "MMKernel.plugin(IPluginFinder::class.java)");
      paramBoolean1 = ((aj)localObject2).isDisablePostHalfScreen();
      localRectF = new RectF();
      this.GHe.setVisibility(8);
      if (f1 <= f2)
      {
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((v)localObject2).a(true, (Size)localObject1);
        f1 = j / f4;
        f2 = (i - f1) / 2.0F;
        localRectF.set(0.0F, f2, j, f1 + f2);
        this.GyG.set(0.0F, 0.0F, j, i);
        this.GHe.GQm = false;
        localObject1 = this.wgr;
        localObject2 = d.c.BVA;
        localBundle = new Bundle();
        if (paramBoolean1)
        {
          i = 3;
          localBundle.putInt("PARAM_1_INT", i);
          ((d)localObject1).a((d.c)localObject2, localBundle);
          label282:
          this.GHd.setEnableTouch(true);
          this.GHd.setEnableScale(false);
          this.GHd.setEnableFling(false);
          this.GHd.setEnableScroll(false);
          this.GHe.setLimitMaxHeight(localRectF.height());
          this.GHe.setLimitMinHeight(localRectF.height());
          this.GHe.getVisibilityRect().set(localRectF);
          this.GHe.getMaxVisibilityRect().set(this.GyG);
          this.GHe.postInvalidate();
          this.GHe.BZh = true;
          localRectF.round(this.GGR);
          this.GGR.offset(0, -(int)this.GyG.top);
          localObject1 = this.GDT;
          if (localObject1 == null) {
            p.hyc();
          }
          ((v)localObject1).g(this.GyG);
          CropLayout.a(this.GHd, localRectF);
          fCT();
        }
      }
    }
    for (;;)
    {
      this.GGY.i(this.GyG);
      localObject1 = this.GDT;
      if (localObject1 == null) {
        break label1356;
      }
      ((v)localObject1).jr(j, (int)this.GyG.height());
      AppMethodBeat.o(191241);
      return;
      i = 1;
      break;
      if (f1 <= 0.01F + f3)
      {
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((v)localObject2).a(false, (Size)localObject1);
        f1 = j / f4;
        f2 = (i - f1) / 2.0F;
        localRectF.set(0.0F, f2, j, f1 + f2);
        this.GyG.set(0.0F, 0.0F, j, i);
        this.GHe.GQm = false;
        localObject1 = this.wgr;
        localObject2 = d.c.BVA;
        localBundle = new Bundle();
        if (paramBoolean1) {}
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          ((d)localObject1).a((d.c)localObject2, localBundle);
          break;
        }
      }
      if (f1 <= f4)
      {
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((v)localObject2).a(true, (Size)localObject1);
        f1 = j / f4;
        f2 = (i - f1) / 2.0F;
        localRectF.set(0.0F, f2, j, f1 + f2);
        localObject1 = this.GyG;
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((RectF)localObject1).set(((v)localObject2).fBl());
        this.GHe.GQm = false;
        localObject1 = this.wgr;
        localObject2 = d.c.BVA;
        localBundle = new Bundle();
        if (paramBoolean1) {}
        for (i = 3;; i = 1)
        {
          localBundle.putInt("PARAM_1_INT", i);
          ((d)localObject1).a((d.c)localObject2, localBundle);
          break;
        }
      }
      if (f1 <= 1.777778F)
      {
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((v)localObject2).a(true, (Size)localObject1);
        localObject1 = this.GDT;
        if (localObject1 == null) {
          p.hyc();
        }
        localRectF.set(((v)localObject1).fBl());
        localObject1 = this.GyG;
        localObject2 = this.GDT;
        if (localObject2 == null) {
          p.hyc();
        }
        ((RectF)localObject1).set(((v)localObject2).fBl());
        localObject1 = this.wgr;
        localObject2 = d.c.BVA;
        localBundle = new Bundle();
        localBundle.putInt("PARAM_1_INT", 3);
        ((d)localObject1).a((d.c)localObject2, localBundle);
        break label282;
      }
      localObject2 = this.GDT;
      if (localObject2 == null) {
        p.hyc();
      }
      ((v)localObject2).a(true, (Size)localObject1);
      localObject1 = this.GDT;
      if (localObject1 == null) {
        p.hyc();
      }
      localObject1 = ((v)localObject1).fBl();
      f1 = ((Rect)localObject1).height() * 1.777778F;
      i = ((Rect)localObject1).top;
      int k = ((Rect)localObject1).bottom;
      f2 = ((Rect)localObject1).centerX() - f1 / 2.0F;
      localRectF.set(f2, i, f1 + f2, k);
      this.GyG.set((Rect)localObject1);
      localObject2 = this.parent;
      localObject1 = localObject2;
      if (!(localObject2 instanceof CropOperationContainer)) {
        localObject1 = null;
      }
      localObject1 = (CropOperationContainer)localObject1;
      if (localObject1 != null) {
        ((CropOperationContainer)localObject1).setEditorItemFirstTouch(true);
      }
      this.GHe.setVisibility(0);
      this.GHe.GQm = true;
      localObject1 = this.wgr;
      localObject2 = d.c.BVA;
      localBundle = new Bundle();
      localBundle.putInt("PARAM_1_INT", 4);
      ((d)localObject1).a((d.c)localObject2, localBundle);
      break label282;
      f1 = j;
      localObject1 = com.tencent.mm.plugin.vlog.util.a.GQC;
      f3 = com.tencent.mm.plugin.vlog.util.a.fEA() * f1;
      f1 = j;
      k = com.tencent.mm.cb.a.aG(this.context, 2131165281);
      i = com.tencent.mm.cb.a.aG(this.context, 2131165288);
      if (paramBoolean1) {
        i = com.tencent.mm.cb.a.fromDPToPix(this.context, 224) + com.tencent.mm.cb.a.aG(this.context, 2131165299);
      }
      i = ao.az(this.context).y - k - i + 0 - au.aD(this.context);
      Log.i("MicroMsg.EditMultiPreviewPlugin", "maxVisibleHeight:" + f3 + " ,validHeight:" + i);
      f2 = Math.min(f3, i * 1.0F);
      this.GHe.setLimitMaxHeight(f2);
      this.GHe.setLimitMinHeight(0.5625F * f1);
      this.GHe.eLF();
      f1 = 0.0F;
      if (f2 < f3) {
        f1 = (1.0F - f2 / f3) * j / 2.0F;
      }
      f3 = k + (i - f2) / 2.0F;
      this.GyG.set(f1, f3, j - f1, f3 + f2);
    }
    label1356:
    AppMethodBeat.o(191241);
  }
  
  public final void aSs() {}
  
  public final j aUk(String paramString)
  {
    AppMethodBeat.i(191263);
    p.h(paramString, "path");
    Object localObject = this.GDT;
    if (localObject != null)
    {
      localObject = (List)((v)localObject).Gyx;
      if (localObject != null)
      {
        Iterator localIterator = ((Iterable)localObject).iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = localIterator.next();
        } while (!p.j(((ad)localObject).path, paramString));
      }
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      paramString = (ad)paramString;
      if (paramString != null)
      {
        localObject = paramString.Gzx;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = new j();
      }
      AppMethodBeat.o(191263);
      return paramString;
    }
  }
  
  public final void at(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(191246);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.at(paramLong1, paramLong2);
      AppMethodBeat.o(191246);
      return;
    }
    AppMethodBeat.o(191246);
  }
  
  public final void bLe()
  {
    AppMethodBeat.i(191253);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.bLe();
      AppMethodBeat.o(191253);
      return;
    }
    AppMethodBeat.o(191253);
  }
  
  public final VideoCompositionPlayView fCU()
  {
    AppMethodBeat.i(191245);
    fDb();
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView == null) {
      p.hyc();
    }
    AppMethodBeat.o(191245);
    return localVideoCompositionPlayView;
  }
  
  public final void fCV()
  {
    AppMethodBeat.i(191249);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.pause();
      AppMethodBeat.o(191249);
      return;
    }
    AppMethodBeat.o(191249);
  }
  
  public final void fCW()
  {
    AppMethodBeat.i(191250);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.setVisibility(8);
      AppMethodBeat.o(191250);
      return;
    }
    AppMethodBeat.o(191250);
  }
  
  public final void fCX()
  {
    AppMethodBeat.i(191251);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.setVisibility(0);
      AppMethodBeat.o(191251);
      return;
    }
    AppMethodBeat.o(191251);
  }
  
  public final void fCZ()
  {
    AppMethodBeat.i(191258);
    Object localObject1 = this.GGZ;
    if (localObject1 != null)
    {
      ((z)localObject1).fDK();
      AppMethodBeat.o(191258);
      return;
    }
    localObject1 = (e)this;
    if (((CharSequence)((e)localObject1).GGQ).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        Object localObject2 = com.tencent.mm.plugin.vlog.model.local.a.GAD;
        i = com.tencent.mm.plugin.vlog.model.local.a.aUc(((e)localObject1).GGQ);
        localObject1 = ((e)localObject1).GGP;
        localObject2 = com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.GLF;
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.vlog.ui.plugin.imageenhancement.b.acJ(i));
      }
      AppMethodBeat.o(191258);
      return;
    }
  }
  
  public final Rect fDa()
  {
    AppMethodBeat.i(191260);
    Object localObject = this.GGZ;
    if (localObject != null) {}
    for (localObject = ((z)localObject).fDa(); localObject != null; localObject = null)
    {
      AppMethodBeat.o(191260);
      return localObject;
    }
    localObject = this.GHd.getContentRect();
    RectF localRectF = this.GHd.getVisibilityRect();
    Rect localRect = new Rect();
    localRectF.round(localRect);
    localObject = a((Rect)localObject, this.GHd.getContentOriginalRect(), localRect);
    AppMethodBeat.o(191260);
    return localObject;
  }
  
  public final void fDc()
  {
    AppMethodBeat.i(191266);
    if (this.GGK != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.resume();
      }
    }
    this.GHb.reset();
    this.GHc = 0L;
    AppMethodBeat.o(191266);
  }
  
  public final void fDd()
  {
    AppMethodBeat.i(191267);
    if (this.GGK != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
      if (localVideoCompositionPlayView != null)
      {
        localVideoCompositionPlayView.pause();
        AppMethodBeat.o(191267);
        return;
      }
    }
    AppMethodBeat.o(191267);
  }
  
  public final void fDe()
  {
    AppMethodBeat.i(191270);
    if (this.GGK != null)
    {
      VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
      if (localVideoCompositionPlayView != null) {
        localVideoCompositionPlayView.release();
      }
      this.GGK = null;
    }
    AppMethodBeat.o(191270);
  }
  
  public final void h(RectF paramRectF)
  {
    AppMethodBeat.i(191243);
    p.h(paramRectF, "rect");
    this.GGY.h(paramRectF);
    this.xmU.set(paramRectF);
    if (!this.Gna)
    {
      this.GHe.getVisibilityRect().set(paramRectF);
      this.GHe.postInvalidate();
      this.GHe.setVisibility(0);
    }
    AppMethodBeat.o(191243);
  }
  
  public final String name()
  {
    return null;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public final boolean onBackPress()
  {
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191259);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    d.b.a(this.wgr, d.c.BWv);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(191259);
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(191268);
    View localView = (View)this.GGK;
    if (localView != null)
    {
      localView.setAlpha(0.0F);
      AppMethodBeat.o(191268);
      return;
    }
    AppMethodBeat.o(191268);
  }
  
  public final void onPause() {}
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(191273);
    p.h(paramArrayOfString, "permissions");
    p.h(paramArrayOfInt, "grantResults");
    t.a.a(paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(191273);
  }
  
  public final void onResume() {}
  
  public final void release()
  {
    AppMethodBeat.i(191269);
    fDe();
    this.GGL.clear();
    AppMethodBeat.o(191269);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(191264);
    this.xna = 0L;
    this.GHd.De(true);
    AppMethodBeat.o(191264);
  }
  
  public final void seek(long paramLong)
  {
    AppMethodBeat.i(191265);
    Object localObject = this.GGK;
    if (localObject != null) {
      ((VideoCompositionPlayView)localObject).seekTo(paramLong);
    }
    localObject = com.tencent.mm.plugin.vlog.model.report.b.GBb;
    com.tencent.mm.plugin.vlog.model.report.b.report(0L);
    AppMethodBeat.o(191265);
  }
  
  public final void setMuteOrigin(boolean paramBoolean)
  {
    AppMethodBeat.i(191252);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.DB(paramBoolean);
      AppMethodBeat.o(191252);
      return;
    }
    AppMethodBeat.o(191252);
  }
  
  public final void setVisibility(int paramInt) {}
  
  public final void stopPreview()
  {
    AppMethodBeat.i(191248);
    VideoCompositionPlayView localVideoCompositionPlayView = this.GGK;
    if (localVideoCompositionPlayView != null)
    {
      localVideoCompositionPlayView.stop();
      AppMethodBeat.o(191248);
      return;
    }
    AppMethodBeat.o(191248);
  }
  
  public final void wE(boolean paramBoolean)
  {
    AppMethodBeat.i(191254);
    a(this, paramBoolean, true, 0L, 12);
    AppMethodBeat.o(191254);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "", "plugin-vlog_release"})
  public static abstract interface b {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewSeekCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onFinish", "", "onProgress", "timeMs", "", "onStart", "seekable", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "plugin-vlog_release"})
  public static abstract interface c
    extends e.b
  {
    public abstract void a(e.e parame);
    
    public abstract void onProgress(long paramLong);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewUpdateCallback;", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$PreviewCallback;", "onUpdate", "", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "seekTo", "", "seekToOriginPosition", "", "plugin-vlog_release"})
  public static abstract interface d
    extends e.b
  {
    public abstract void a(ac paramac, long paramLong, boolean paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "", "pause", "", "resume", "seek", "timeMs", "", "host", "plugin-vlog_release"})
  public static abstract interface e
  {
    public abstract void Lb(long paramLong);
    
    public abstract void pause();
    
    public abstract void resume();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$1", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerFrameCallback;", "onFrame", "", "onPlayCompleted", "onPlayError", "onPlayFirstFrame", "onPlayProgress", "timeMs", "", "onPlayStarted", "onPlayStop", "plugin-vlog_release"})
  public static final class f
    implements a.a.b
  {
    public final void Go(long paramLong)
    {
      AppMethodBeat.i(191225);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onPlayProgress timeMs:".concat(String.valueOf(paramLong)));
      Iterator localIterator = ((Iterable)e.c(this.GHg)).iterator();
      while (localIterator.hasNext())
      {
        e.b localb = (e.b)localIterator.next();
        if ((localb instanceof e.c)) {
          ((e.c)localb).onProgress(paramLong);
        }
      }
      AppMethodBeat.o(191225);
    }
    
    public final void dER()
    {
      AppMethodBeat.i(191223);
      Object localObject = ((Iterable)e.c(this.GHg)).iterator();
      while (((Iterator)localObject).hasNext())
      {
        e.b localb = (e.b)((Iterator)localObject).next();
        if ((localb instanceof e.c)) {
          ((e.c)localb).a(this.GHg.GGT);
        }
      }
      localObject = e.d(this.GHg);
      long l;
      if (localObject != null)
      {
        l = ((VideoCompositionPlayView)localObject).getPosition();
        localObject = this.GHg.GGU;
        if (localObject != null)
        {
          ((e.e)localObject).Lb(l + this.GHg.GGV);
          AppMethodBeat.o(191223);
        }
      }
      else
      {
        localObject = e.e(this.GHg);
        if (localObject != null) {}
        for (l = ((ac)localObject).Gez.getPlayStart();; l = 0L)
        {
          l = 0L - l / 1000L;
          break;
        }
      }
      AppMethodBeat.o(191223);
    }
    
    public final void dES() {}
    
    public final void dET()
    {
      AppMethodBeat.i(191224);
      Iterator localIterator = ((Iterable)e.c(this.GHg)).iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
      AppMethodBeat.o(191224);
    }
    
    public final void dEU()
    {
      AppMethodBeat.i(191226);
      Object localObject = e.d(this.GHg);
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type android.view.View");
        AppMethodBeat.o(191226);
        throw ((Throwable)localObject);
      }
      ((View)localObject).setAlpha(1.0F);
      d.b.a(this.GHg.wgr, d.c.BVx);
      AppMethodBeat.o(191226);
    }
    
    public final void dEV() {}
    
    public final void dEW()
    {
      AppMethodBeat.i(191227);
      Object localObject = e.d(this.GHg);
      if (localObject != null)
      {
        if (((VideoCompositionPlayView)localObject).isPlaying() != true) {
          AppMethodBeat.o(191227);
        }
      }
      else
      {
        AppMethodBeat.o(191227);
        return;
      }
      if (e.f(this.GHg) == 0L) {
        e.b(this.GHg, Util.currentTicks());
      }
      localObject = e.g(this.GHg);
      int i;
      if (((com.tencent.mm.plugin.vlog.model.n)localObject).jkM == 0L)
      {
        ((com.tencent.mm.plugin.vlog.model.n)localObject).jkM = Util.currentTicks();
        if (Util.ticksToNow(e.f(this.GHg)) >= 1000L)
        {
          Log.d("MicroMsg.EditMultiPreviewPlugin", "onFrame: fps " + e.g(this.GHg).getFps());
          localObject = com.tencent.mm.plugin.vlog.model.report.b.GBb;
          i = e.g(this.GHg).getFps();
          if (i <= 60) {
            break label194;
          }
          com.tencent.mm.plugin.vlog.model.report.b.report(21L);
        }
      }
      for (;;)
      {
        e.b(this.GHg, 0L);
        e.g(this.GHg).reset();
        AppMethodBeat.o(191227);
        return;
        ((com.tencent.mm.plugin.vlog.model.n)localObject).frames += 1;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$checkInitVideoView$2", "Lcom/tencent/mm/videocomposition/play/VideoCompositionPlayer$Companion$PlayerProfileCallback;", "onSeek", "", "cost", "", "onUpdateComposition", "plugin-vlog_release"})
  public static final class g
    implements a.a.c
  {
    public final void Lc(long paramLong)
    {
      AppMethodBeat.i(191228);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onUpdateComposition: ".concat(String.valueOf(paramLong)));
      Object localObject = this.GHg.GGM;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOC.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOA) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOC.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.GBb;
      com.tencent.mm.plugin.vlog.model.report.b.report(11L);
      h.CyF.n(1468L, 12L, paramLong);
      AppMethodBeat.o(191228);
    }
    
    public final void Ld(long paramLong)
    {
      AppMethodBeat.i(191229);
      Log.d("MicroMsg.EditMultiPreviewPlugin", "onSeek: ".concat(String.valueOf(paramLong)));
      Object localObject = this.GHg.GGM;
      if (((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOB.size() < ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOA) {
        ((com.tencent.mm.plugin.vlog.ui.report.a)localObject).GOB.add(Long.valueOf(paramLong));
      }
      localObject = com.tencent.mm.plugin.vlog.model.report.b.GBb;
      com.tencent.mm.plugin.vlog.model.report.b.report(1L);
      h.CyF.n(1468L, 2L, paramLong);
      if (paramLong <= 30L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(4L);
        AppMethodBeat.o(191229);
        return;
      }
      if (paramLong <= 100L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(5L);
        AppMethodBeat.o(191229);
        return;
      }
      if (paramLong <= 500L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(6L);
        AppMethodBeat.o(191229);
        return;
      }
      if (paramLong <= 1000L)
      {
        com.tencent.mm.plugin.vlog.model.report.b.report(7L);
        AppMethodBeat.o(191229);
        return;
      }
      com.tencent.mm.plugin.vlog.model.report.b.report(8L);
      AppMethodBeat.o(191229);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$2", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class i
    implements WxCropOperationLayout.i
  {
    private boolean GHi = true;
    
    i(long paramLong, ad paramad) {}
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191231);
      p.h(paramRectF, "rectF");
      if (e.a(this.GHg, l)) {
        this.GHg.xmU.set(paramRectF);
      }
      Object localObject1 = e.a(this.GHg);
      if (localObject1 != null)
      {
        localObject1 = (List)((v)localObject1).Gyx;
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = (ad)((Iterator)localObject1).next();
            j localj = ((ad)localObject2).Gzx;
            paramRectF.round(localj.iiw);
            if ((!p.j(this.GAL, localObject2)) && (!this.GHg.Gna))
            {
              int i = localj.iiw.bottom - localj.rwL.bottom;
              int j = localj.iiw.top - localj.rwL.top;
              if ((i > 0) || (j < 0))
              {
                localObject2 = new Matrix();
                RectF localRectF = new RectF(localj.rwL);
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
                  localRectF.round(localj.rwL);
                  localj.gT.postConcat((Matrix)localObject2);
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
      this.GHg.GHd.b(paramRectF, false);
      paramRectF = this.GHg.GGN;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.GHi)
      {
        paramRectF = this.GHg;
        paramRectF.GGO += 1;
      }
      this.GHi = true;
      AppMethodBeat.o(191231);
    }
    
    public final void pA(boolean paramBoolean) {}
    
    public final void pz(boolean paramBoolean)
    {
      this.GHi = false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onPreviewImage$3", "Lcom/tencent/mm/ui/widget/cropview/CropLayout$OnChangeStartEndListener;", "startScale", "", "onChange", "", "onChangeEnd", "onChangeStart", "plugin-vlog_release"})
  public static final class j
    implements CropLayout.d
  {
    private float CIE = 1.0F;
    
    j(ad paramad, m paramm) {}
    
    public final void fDj()
    {
      AppMethodBeat.i(191233);
      this.CIE = com.tencent.mm.plugin.vlog.model.t.e(this.GAL.Gzx.gT);
      AppMethodBeat.o(191233);
    }
    
    public final void fDk()
    {
      AppMethodBeat.i(191234);
      Object localObject = this.GAL;
      if (this.CIE != com.tencent.mm.plugin.vlog.model.t.e(((ad)localObject).Gzx.gT))
      {
        localObject = ((ad)localObject).Gzz;
        ((MediaEditReportInfo.EditItem)localObject).scaleCount += 1;
        AppMethodBeat.o(191234);
        return;
      }
      localObject = ((ad)localObject).Gzz;
      ((MediaEditReportInfo.EditItem)localObject).dragCount += 1;
      AppMethodBeat.o(191234);
    }
    
    public final void onChange()
    {
      AppMethodBeat.i(191232);
      if (this.GAL.Gzx.getScale() > 0.0F)
      {
        com.tencent.mm.bt.b localb = paramm.getPresenter();
        p.g(localb, "drawingView.presenter");
        localb.setInitScale(1.0F / this.GAL.Gzx.getScale());
      }
      if (!this.GHg.Gna) {
        this.GAL.Gzx.rwL.set(this.GHg.GHd.getContentRect());
      }
      AppMethodBeat.o(191232);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$onUpdateVideo$3", "Lcom/tencent/mm/plugin/recordvideo/ui/WxCropOperationLayout$OnOperationCallback;", "blockChanged", "", "onBlockDownClick", "", "isTopBlock", "onBlockTouchUp", "onChange", "rectF", "Landroid/graphics/RectF;", "plugin-vlog_release"})
  public static final class k
    implements WxCropOperationLayout.i
  {
    private boolean GHi = true;
    
    public final void e(RectF paramRectF)
    {
      AppMethodBeat.i(191235);
      p.h(paramRectF, "rectF");
      Object localObject = e.b(this.GHg);
      if (localObject != null)
      {
        localObject = ((z)localObject).fDI();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).e(paramRectF);
        }
      }
      paramRectF = this.GHg.GGN;
      if (paramRectF != null) {
        paramRectF.onChange();
      }
      if (!this.GHi)
      {
        paramRectF = this.GHg;
        paramRectF.GGO += 1;
      }
      this.GHi = true;
      AppMethodBeat.o(191235);
    }
    
    public final void pA(boolean paramBoolean)
    {
      AppMethodBeat.i(191237);
      Object localObject = e.b(this.GHg);
      if (localObject != null)
      {
        localObject = ((z)localObject).fDI();
        if (localObject != null)
        {
          ((WxCropOperationLayout.i)localObject).pA(paramBoolean);
          AppMethodBeat.o(191237);
          return;
        }
      }
      AppMethodBeat.o(191237);
    }
    
    public final void pz(boolean paramBoolean)
    {
      AppMethodBeat.i(191236);
      Object localObject = e.b(this.GHg);
      if (localObject != null)
      {
        localObject = ((z)localObject).fDI();
        if (localObject != null) {
          ((WxCropOperationLayout.i)localObject).pz(paramBoolean);
        }
      }
      this.GHi = false;
      AppMethodBeat.o(191236);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$videoSeekable$1", "Lcom/tencent/mm/plugin/vlog/ui/plugin/EditMultiPreviewPlugin$Seekable;", "pause", "", "resume", "seek", "timeMs", "", "host", "", "plugin-vlog_release"})
  public static final class l
    implements e.e
  {
    public final void Lb(long paramLong)
    {
      AppMethodBeat.i(191238);
      Object localObject = com.tencent.mm.plugin.vlog.model.report.b.GBb;
      com.tencent.mm.plugin.vlog.model.report.b.report(0L);
      localObject = e.d(this.GHg);
      if (localObject != null)
      {
        ((VideoCompositionPlayView)localObject).seekTo(paramLong);
        AppMethodBeat.o(191238);
        return;
      }
      AppMethodBeat.o(191238);
    }
    
    public final void pause()
    {
      AppMethodBeat.i(191239);
      d.b.a(this.GHg.wgr, d.c.BVr);
      AppMethodBeat.o(191239);
    }
    
    public final void resume()
    {
      AppMethodBeat.i(191240);
      d.b.a(this.GHg.wgr, d.c.BVs);
      AppMethodBeat.o(191240);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.plugin.e
 * JD-Core Version:    0.7.0.1
 */