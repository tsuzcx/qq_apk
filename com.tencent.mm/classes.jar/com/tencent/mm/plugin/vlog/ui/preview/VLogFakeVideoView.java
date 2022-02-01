package com.tencent.mm.plugin.vlog.ui.preview;

import android.content.Context;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.model.ae;
import com.tencent.mm.plugin.vlog.model.ae.a;
import com.tencent.mm.plugin.vlog.model.ah;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.epc;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  public static final VLogFakeVideoView.a GOi;
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  private com.tencent.mm.plugin.recordvideo.background.c CdB;
  public VLogPlayView GOh;
  private boolean guh;
  public ProgressBar mEz;
  public FakeVideoViewLayer xCO;
  
  static
  {
    AppMethodBeat.i(111182);
    GOi = new VLogFakeVideoView.a((byte)0);
    TAG = "MicroMsg.Story.VLogFakeVideoView";
    AppMethodBeat.o(111182);
  }
  
  public VLogFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111181);
    Log.i(TAG, "initView");
    LayoutInflater.from(getContext()).inflate(2131496826, (ViewGroup)this);
    paramContext = findViewById(2131309910);
    p.g(paramContext, "findViewById(R.id.vlog_play_view)");
    this.GOh = ((VLogPlayView)paramContext);
    paramContext = findViewById(2131300427);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.xCO = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131309778);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.mEz = ((ProgressBar)paramContext);
    paramContext = this.GOh;
    if (paramContext == null) {
      p.btv("vlogVideoView");
    }
    paramContext.setPrepareCallback((kotlin.g.a.a)new VLogFakeVideoView.b(this));
    AppMethodBeat.o(111181);
  }
  
  private final ah getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bw.a)new aio();
    Object localObject1 = this.CdB;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (aio)localObject1;
      if (localObject5 != null)
      {
        f1 = ((aio)localObject5).LrU;
        f2 = ((aio)localObject5).LrW;
        f3 = ((aio)localObject5).LrV;
        f4 = ((aio)localObject5).LrX;
        localObject1 = e.BKp;
        localObject1 = ((aio)localObject5).Lna;
        p.g(localObject1, "this.baseItemData");
        localObject4 = MMApplicationContext.getContext();
        p.g(localObject4, "MMApplicationContext.getContext()");
        localObject4 = e.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bw.a)new epc();
        localObject5 = ((aio)localObject5).Lsd.toByteArray();
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
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject5);
          localObject1 = (epc)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((epc)localObject1).NmX;
          long l = ((erh)localObject1).KPe;
          Object localObject5 = ae.GzI;
          p.g(localObject1, "vlogResp");
          localObject5 = ae.a.a((erh)localObject1);
          String str = ((erh)localObject1).NoU.MxH;
          p.g(str, "vlogResp.music.local_path");
          localObject1 = new ah(l, (List)localObject5, str, (erh)localObject1);
          ((ah)localObject1).p(new float[] { f1, f2, f3, f4 });
          ((ah)localObject1).aT((ArrayList)localObject4);
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
    p.h(paramc, "item");
    this.CdB = paramc;
    Object localObject1 = TAG;
    paramc = new StringBuilder("LogStory: play fake video  item ").append(paramc).append(", mute:").append(this.guh).append(", isBackgroundSilent:");
    Object localObject2 = this.xCO;
    if (localObject2 == null) {
      p.btv("fakeLayer");
    }
    Log.i((String)localObject1, ((FakeVideoViewLayer)localObject2).BYt);
    paramc = this.xCO;
    if (paramc == null) {
      p.btv("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.CdB;
    if (paramc != null)
    {
      localObject1 = this.xCO;
      if (localObject1 == null) {
        p.btv("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(paramc);
    }
    paramc = getScriptModel();
    if (paramc != null)
    {
      localObject1 = this.GOh;
      if (localObject1 == null) {
        p.btv("vlogVideoView");
      }
      p.h(paramc, "model");
      Log.i("MicroMsg.VLogPlayView", "renderScript model:" + paramc + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).GCP == null) {
        ((VLogPlayView)localObject1).GOr = paramc;
      }
      for (;;)
      {
        paramc = this.GOh;
        if (paramc == null) {
          p.btv("vlogVideoView");
        }
        if (!this.guh)
        {
          localObject1 = this.xCO;
          if (localObject1 == null) {
            p.btv("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).BYt) {}
        }
        else
        {
          bool = true;
        }
        paramc.setMute(bool);
        paramc = this.xCO;
        if (paramc == null) {
          p.btv("fakeLayer");
        }
        paramc.tv(this.guh);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).GCP;
        if (localObject2 != null)
        {
          Log.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((com.tencent.mm.plugin.vlog.player.c)localObject2).hashCode());
          ((VLogPlayView)localObject1).GOq = true;
          ((com.tencent.mm.plugin.vlog.player.c)localObject2).a(paramc, paramc.getVideoDurationMs(), paramc.GzR);
          com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject2, null, false, 7);
          paramc = ((VLogPlayView)localObject1).GOs;
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
    Object localObject = this.GOh;
    if (localObject == null) {
      p.btv("vlogVideoView");
    }
    if (((VLogPlayView)localObject).Cel)
    {
      localObject = this.GOh;
      if (localObject == null) {
        p.btv("vlogVideoView");
      }
      Log.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).GOq = true;
      localObject = ((VLogPlayView)localObject).GCP;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject, null, false, 7);
      }
      localObject = this.xCO;
      if (localObject == null) {
        p.btv("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).tv(this.guh);
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
    if (localFakeVideoViewLayer == null) {
      p.btv("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.mEz;
    if (localProgressBar == null) {
      p.btv("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.GOh;
    if (localVLogPlayView == null) {
      p.btv("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.GOh;
    if (localVLogPlayView == null) {
      p.btv("vlogVideoView");
    }
    boolean bool = localVLogPlayView.GOq;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    Log.i(TAG, "onUIResume");
    b(this.CdB);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.xCO = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    p.h(paramProgressBar, "<set-?>");
    this.mEz = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.guh = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    p.h(paramVLogPlayView, "<set-?>");
    this.GOh = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    Log.i(TAG, "stop");
    Object localObject1 = this.GOh;
    if (localObject1 == null) {
      p.btv("vlogVideoView");
    }
    Log.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).GCP;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.c)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).GBp;
    if (localObject2 != null) {
      ((k)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).GOo;
    if (localObject2 != null) {
      ((MMHandler)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).GOn;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).GCP = null;
    ((VLogPlayView)localObject1).GOo = null;
    ((VLogPlayView)localObject1).Cel = false;
    ((VLogPlayView)localObject1).GOq = false;
    ((VLogPlayView)localObject1).GOr = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).GOt = false;
    localObject1 = this.xCO;
    if (localObject1 == null) {
      p.btv("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).eLB();
    AppMethodBeat.o(111179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */