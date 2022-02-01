package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.a.f;
import com.tencent.mm.plugin.vlog.a.g;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.j;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.protocal.protobuf.dtg;
import com.tencent.mm.protocal.protobuf.fvr;
import com.tencent.mm.protocal.protobuf.fyd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class VLogFakeVideoView
  extends RelativeLayout
{
  private static final String TAG;
  public static final VLogFakeVideoView.a Uou;
  public FakeVideoViewLayer IAY;
  private com.tencent.mm.plugin.recordvideo.background.c NWv;
  public VLogPlayView Uov;
  private boolean lAj;
  public ProgressBar sIX;
  
  static
  {
    AppMethodBeat.i(111182);
    Uou = new VLogFakeVideoView.a((byte)0);
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
    s.s(paramContext, "findViewById(R.id.vlog_play_view)");
    setVlogVideoView((VLogPlayView)paramContext);
    paramContext = findViewById(a.f.fakelayer);
    s.s(paramContext, "findViewById(R.id.fakelayer)");
    setFakeLayer((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(a.f.video_loading);
    s.s(paramContext, "findViewById(R.id.video_loading)");
    setLoading((ProgressBar)paramContext);
    getVlogVideoView().setPrepareCallback((kotlin.g.a.a)new VLogFakeVideoView.b(this));
    AppMethodBeat.o(111181);
  }
  
  private final ah getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bx.a)new ami();
    Object localObject1 = this.NWv;
    if (localObject1 == null) {
      localObject1 = null;
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (ami)localObject1;
      if (localObject5 != null)
      {
        f1 = ((ami)localObject5).Ztg;
        f2 = ((ami)localObject5).Zti;
        f3 = ((ami)localObject5).Zth;
        f4 = ((ami)localObject5).Ztj;
        localObject1 = e.NDU;
        localObject1 = ((ami)localObject5).Znd;
        s.s(localObject1, "this.baseItemData");
        localObject4 = MMApplicationContext.getContext();
        s.s(localObject4, "getContext()");
        localObject4 = e.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bx.a)new fvr();
        localObject5 = ((ami)localObject5).Ztp.toByteArray();
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
          ((com.tencent.mm.bx.a)localObject1).parseFrom((byte[])localObject5);
          localObject1 = (fvr)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((fvr)localObject1).abTR;
          long l = ((fyd)localObject1).YNt;
          Object localObject5 = ae.UaJ;
          s.s(localObject1, "vlogResp");
          localObject5 = ae.a.a((fyd)localObject1);
          String str = ((fyd)localObject1).abVZ.aaYN;
          s.s(str, "vlogResp.music.local_path");
          localObject1 = new ah(l, (List)localObject5, str, (fyd)localObject1);
          ((ah)localObject1).A(new float[] { f1, f2, f3, f4 });
          ((ah)localObject1).bI((ArrayList)localObject4);
          AppMethodBeat.o(111176);
          return localObject1;
          localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;
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
    s.u(paramc, "item");
    this.NWv = paramc;
    Log.i(TAG, "LogStory: play fake video  item " + paramc + ", mute:" + this.lAj + ", isBackgroundSilent:" + getFakeLayer().NRY);
    getFakeLayer().setVisibility(0);
    paramc = this.NWv;
    if (paramc != null) {
      getFakeLayer().setFakeVideoInfo(paramc);
    }
    paramc = getScriptModel();
    VLogPlayView localVLogPlayView;
    if (paramc != null)
    {
      localVLogPlayView = getVlogVideoView();
      s.u(paramc, "model");
      Log.i("MicroMsg.VLogPlayView", "renderScript model:" + paramc + "  " + localVLogPlayView.hashCode());
      if (localVLogPlayView.Uep != null) {
        break label213;
      }
      localVLogPlayView.UoF = paramc;
    }
    for (;;)
    {
      paramc = getVlogVideoView();
      if ((this.lAj) || (getFakeLayer().NRY)) {
        bool = true;
      }
      paramc.setMute(bool);
      getFakeLayer().Br(this.lAj);
      AppMethodBeat.o(111177);
      return;
      label213:
      com.tencent.mm.plugin.vlog.player.c localc = localVLogPlayView.Uep;
      if (localc != null)
      {
        Log.i("MicroMsg.VLogPlayView", s.X("play in renderScript   ", Integer.valueOf(localc.hashCode())));
        localVLogPlayView.UoE = true;
        localc.a(paramc, paramc.getVideoDurationMs(), paramc.UaZ);
        com.tencent.mm.plugin.vlog.player.c.a(localc, null, false, 7);
        paramc = localVLogPlayView.UoG;
        if (paramc != null) {
          paramc.invoke();
        }
      }
    }
  }
  
  public final void b(com.tencent.mm.plugin.recordvideo.background.c paramc)
  {
    AppMethodBeat.i(111178);
    Log.i(TAG, "resume");
    if (getVlogVideoView().NXm)
    {
      Object localObject = getVlogVideoView();
      Log.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).UoE = true;
      localObject = ((VLogPlayView)localObject).Uep;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject, null, false, 7);
      }
      getFakeLayer().Br(this.lAj);
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.IAY;
    if (localFakeVideoViewLayer != null)
    {
      AppMethodBeat.o(111171);
      return localFakeVideoViewLayer;
    }
    s.bIx("fakeLayer");
    AppMethodBeat.o(111171);
    return null;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.sIX;
    if (localProgressBar != null)
    {
      AppMethodBeat.o(111173);
      return localProgressBar;
    }
    s.bIx("loading");
    AppMethodBeat.o(111173);
    return null;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.Uov;
    if (localVLogPlayView != null)
    {
      AppMethodBeat.o(111169);
      return localVLogPlayView;
    }
    s.bIx("vlogVideoView");
    AppMethodBeat.o(111169);
    return null;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    Log.i(TAG, "onUIResume");
    b(this.NWv);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    s.u(paramFakeVideoViewLayer, "<set-?>");
    this.IAY = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    s.u(paramProgressBar, "<set-?>");
    this.sIX = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.lAj = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    s.u(paramVLogPlayView, "<set-?>");
    this.Uov = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    Log.i(TAG, "stop");
    VLogPlayView localVLogPlayView = getVlogVideoView();
    Log.i("MicroMsg.VLogPlayView", "stop");
    Object localObject = localVLogPlayView.Uep;
    if (localObject != null) {
      ((com.tencent.mm.plugin.vlog.player.c)localObject).release();
    }
    localObject = localVLogPlayView.UcX;
    if (localObject != null) {
      ((j)localObject).release();
    }
    localObject = localVLogPlayView.UoC;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = localVLogPlayView.UoB;
    if (localObject != null) {
      ((HandlerThread)localObject).quitSafely();
    }
    localVLogPlayView.Uep = null;
    localVLogPlayView.UoC = null;
    localVLogPlayView.NXm = false;
    localVLogPlayView.UoE = false;
    localVLogPlayView.UoF = null;
    localVLogPlayView.frameCount = 0;
    localVLogPlayView.UoH = false;
    getFakeLayer().gJH();
    AppMethodBeat.o(111179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */