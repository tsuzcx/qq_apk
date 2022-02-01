package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.ezn;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  public static final a NBO;
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  public FakeVideoViewLayer CGO;
  private com.tencent.mm.plugin.recordvideo.background.c HZR;
  public VLogPlayView NBN;
  private boolean iYs;
  public ProgressBar pDL;
  
  static
  {
    AppMethodBeat.i(111182);
    NBO = new a((byte)0);
    TAG = "MicroMsg.Story.VLogFakeVideoView";
    AppMethodBeat.o(111182);
  }
  
  public VLogFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111181);
    Log.i(TAG, "initView");
    LayoutInflater.from(getContext()).inflate(a.g.vlog_fake_video_view, (ViewGroup)this);
    paramContext = findViewById(a.f.vlog_play_view);
    p.j(paramContext, "findViewById(R.id.vlog_play_view)");
    this.NBN = ((VLogPlayView)paramContext);
    paramContext = findViewById(a.f.fakelayer);
    p.j(paramContext, "findViewById(R.id.fakelayer)");
    this.CGO = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(a.f.video_loading);
    p.j(paramContext, "findViewById(R.id.video_loading)");
    this.pDL = ((ProgressBar)paramContext);
    paramContext = this.NBN;
    if (paramContext == null) {
      p.bGy("vlogVideoView");
    }
    paramContext.setPrepareCallback((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(111181);
  }
  
  private final ah getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.cd.a)new ajd();
    Object localObject1 = this.HZR;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.cd.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (ajd)localObject1;
      if (localObject5 != null)
      {
        f1 = ((ajd)localObject5).Stw;
        f2 = ((ajd)localObject5).Sty;
        f3 = ((ajd)localObject5).Stx;
        f4 = ((ajd)localObject5).Stz;
        localObject1 = e.HGz;
        localObject1 = ((ajd)localObject5).Sor;
        p.j(localObject1, "this.baseItemData");
        localObject4 = MMApplicationContext.getContext();
        p.j(localObject4, "MMApplicationContext.getContext()");
        localObject4 = e.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.cd.a)new ezn();
        localObject5 = ((ajd)localObject5).StF.toByteArray();
      }
    }
    catch (Exception localException1)
    {
      try
      {
        for (;;)
        {
          float f1;
          float f2;
          float f3;
          float f4;
          ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject5);
          localObject1 = (ezn)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((ezn)localObject1).UzO;
          long l = ((fbs)localObject1).RQc;
          Object localObject5 = ae.Nno;
          p.j(localObject1, "vlogResp");
          localObject5 = ae.a.a((fbs)localObject1);
          String str = ((fbs)localObject1).UBQ.TIY;
          p.j(str, "vlogResp.music.local_path");
          localObject1 = new ah(l, (List)localObject5, str, (fbs)localObject1);
          ((ah)localObject1).q(new float[] { f1, f2, f3, f4 });
          ((ah)localObject1).bh((ArrayList)localObject4);
          AppMethodBeat.o(111176);
          return localObject1;
          localObject1 = null;
        }
        localException1 = localException1;
        Log.printDebugStack("safeParser", "", new Object[] { localException1 });
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
        }
      }
      AppMethodBeat.o(111176);
    }
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    boolean bool = false;
    AppMethodBeat.i(111177);
    p.k(paramc, "item");
    this.HZR = paramc;
    Object localObject1 = TAG;
    paramc = new StringBuilder("LogStory: play fake video  item ").append(paramc).append(", mute:").append(this.iYs).append(", isBackgroundSilent:");
    Object localObject2 = this.CGO;
    if (localObject2 == null) {
      p.bGy("fakeLayer");
    }
    Log.i((String)localObject1, ((FakeVideoViewLayer)localObject2).HVi);
    paramc = this.CGO;
    if (paramc == null) {
      p.bGy("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.HZR;
    if (paramc != null)
    {
      localObject1 = this.CGO;
      if (localObject1 == null) {
        p.bGy("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(paramc);
    }
    paramc = getScriptModel();
    if (paramc != null)
    {
      localObject1 = this.NBN;
      if (localObject1 == null) {
        p.bGy("vlogVideoView");
      }
      p.k(paramc, "model");
      Log.i("MicroMsg.VLogPlayView", "renderScript model:" + paramc + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).Nqz == null) {
        ((VLogPlayView)localObject1).NBX = paramc;
      }
      for (;;)
      {
        paramc = this.NBN;
        if (paramc == null) {
          p.bGy("vlogVideoView");
        }
        if (!this.iYs)
        {
          localObject1 = this.CGO;
          if (localObject1 == null) {
            p.bGy("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).HVi) {}
        }
        else
        {
          bool = true;
        }
        paramc.setMute(bool);
        paramc = this.CGO;
        if (paramc == null) {
          p.bGy("fakeLayer");
        }
        paramc.wR(this.iYs);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).Nqz;
        if (localObject2 != null)
        {
          Log.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((com.tencent.mm.plugin.vlog.player.c)localObject2).hashCode());
          ((VLogPlayView)localObject1).NBW = true;
          ((com.tencent.mm.plugin.vlog.player.c)localObject2).a(paramc, paramc.getVideoDurationMs(), paramc.Nnx);
          com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject2, null, false, 7);
          paramc = ((VLogPlayView)localObject1).NBY;
          if (paramc != null) {
            paramc.invoke();
          }
        }
      }
    }
    AppMethodBeat.o(111177);
  }
  
  public final void b(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(111178);
    Log.i(TAG, "resume");
    Object localObject = this.NBN;
    if (localObject == null) {
      p.bGy("vlogVideoView");
    }
    if (((VLogPlayView)localObject).IaK)
    {
      localObject = this.NBN;
      if (localObject == null) {
        p.bGy("vlogVideoView");
      }
      Log.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).NBW = true;
      localObject = ((VLogPlayView)localObject).Nqz;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject, null, false, 7);
      }
      localObject = this.CGO;
      if (localObject == null) {
        p.bGy("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).wR(this.iYs);
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
    if (localFakeVideoViewLayer == null) {
      p.bGy("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.pDL;
    if (localProgressBar == null) {
      p.bGy("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.NBN;
    if (localVLogPlayView == null) {
      p.bGy("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.NBN;
    if (localVLogPlayView == null) {
      p.bGy("vlogVideoView");
    }
    boolean bool = localVLogPlayView.NBW;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    Log.i(TAG, "onUIResume");
    b(this.HZR);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    p.k(paramFakeVideoViewLayer, "<set-?>");
    this.CGO = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    p.k(paramProgressBar, "<set-?>");
    this.pDL = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.iYs = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    p.k(paramVLogPlayView, "<set-?>");
    this.NBN = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    Log.i(TAG, "stop");
    Object localObject1 = this.NBN;
    if (localObject1 == null) {
      p.bGy("vlogVideoView");
    }
    Log.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).Nqz;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.c)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).Npb;
    if (localObject2 != null) {
      ((k)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).NBU;
    if (localObject2 != null) {
      ((MMHandler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).NBT;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).Nqz = null;
    ((VLogPlayView)localObject1).NBU = null;
    ((VLogPlayView)localObject1).IaK = false;
    ((VLogPlayView)localObject1).NBW = false;
    ((VLogPlayView)localObject1).NBX = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).NBZ = false;
    localObject1 = this.CGO;
    if (localObject1 == null) {
      p.bGy("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).fxU();
    AppMethodBeat.o(111179);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-vlog_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(VLogFakeVideoView paramVLogFakeVideoView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */