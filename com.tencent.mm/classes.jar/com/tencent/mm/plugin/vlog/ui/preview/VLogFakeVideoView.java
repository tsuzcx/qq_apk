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
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.model.x.a;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.cbu;
import com.tencent.mm.protocal.protobuf.due;
import com.tencent.mm.protocal.protobuf.dwg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  public static final VLogFakeVideoView.a BTF;
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  public VLogPlayView BTE;
  private boolean fMP;
  public ProgressBar ltc;
  public FakeVideoViewLayer tZt;
  private com.tencent.mm.plugin.recordvideo.background.c xMF;
  
  static
  {
    AppMethodBeat.i(111182);
    BTF = new VLogFakeVideoView.a((byte)0);
    TAG = "MicroMsg.Story.VLogFakeVideoView";
    AppMethodBeat.o(111182);
  }
  
  public VLogFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111181);
    ad.i(TAG, "initView");
    LayoutInflater.from(getContext()).inflate(2131495854, (ViewGroup)this);
    paramContext = findViewById(2131306460);
    p.g(paramContext, "findViewById(R.id.vlog_play_view)");
    this.BTE = ((VLogPlayView)paramContext);
    paramContext = findViewById(2131299758);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.tZt = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.ltc = ((ProgressBar)paramContext);
    paramContext = this.BTE;
    if (paramContext == null) {
      p.bcb("vlogVideoView");
    }
    paramContext.setPrepareCallback((d.g.a.a)new b(this));
    AppMethodBeat.o(111181);
  }
  
  private final aa getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bx.a)new afy();
    Object localObject1 = this.xMF;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (afy)localObject1;
      if (localObject5 != null)
      {
        f1 = ((afy)localObject5).GdH;
        f2 = ((afy)localObject5).GdJ;
        f3 = ((afy)localObject5).GdI;
        f4 = ((afy)localObject5).GdK;
        localObject1 = e.xuo;
        localObject1 = ((afy)localObject5).FZr;
        p.g(localObject1, "this.baseItemData");
        localObject4 = aj.getContext();
        p.g(localObject4, "MMApplicationContext.getContext()");
        localObject4 = e.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bx.a)new due();
        localObject5 = ((afy)localObject5).GdQ.toByteArray();
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
          localObject1 = (due)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((due)localObject1).HGY;
          long l = ((dwg)localObject1).FCY;
          Object localObject5 = x.BGE;
          p.g(localObject1, "vlogResp");
          localObject5 = x.a.a((dwg)localObject1);
          String str = ((dwg)localObject1).HIK.GVH;
          p.g(str, "vlogResp.music.local_path");
          localObject1 = new aa(l, (List)localObject5, str, (dwg)localObject1);
          ((aa)localObject1).p(new float[] { f1, f2, f3, f4 });
          ((aa)localObject1).aB((ArrayList)localObject4);
          AppMethodBeat.o(111176);
          return localObject1;
          localObject1 = null;
        }
        localException1 = localException1;
        ad.l("safeParser", "", new Object[] { localException1 });
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException2 });
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
    this.xMF = paramc;
    Object localObject1 = TAG;
    paramc = new StringBuilder("LogStory: play fake video  item ").append(paramc).append(", mute:").append(this.fMP).append(", isBackgroundSilent:");
    Object localObject2 = this.tZt;
    if (localObject2 == null) {
      p.bcb("fakeLayer");
    }
    ad.i((String)localObject1, ((FakeVideoViewLayer)localObject2).xHG);
    paramc = this.tZt;
    if (paramc == null) {
      p.bcb("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.xMF;
    if (paramc != null)
    {
      localObject1 = this.tZt;
      if (localObject1 == null) {
        p.bcb("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(paramc);
    }
    paramc = getScriptModel();
    if (paramc != null)
    {
      localObject1 = this.BTE;
      if (localObject1 == null) {
        p.bcb("vlogVideoView");
      }
      p.h(paramc, "model");
      ad.i("MicroMsg.VLogPlayView", "renderScript model:" + paramc + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).BJC == null) {
        ((VLogPlayView)localObject1).BTO = paramc;
      }
      for (;;)
      {
        paramc = this.BTE;
        if (paramc == null) {
          p.bcb("vlogVideoView");
        }
        if (!this.fMP)
        {
          localObject1 = this.tZt;
          if (localObject1 == null) {
            p.bcb("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).xHG) {}
        }
        else
        {
          bool = true;
        }
        paramc.setMute(bool);
        paramc = this.tZt;
        if (paramc == null) {
          p.bcb("fakeLayer");
        }
        paramc.pW(this.fMP);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).BJC;
        if (localObject2 != null)
        {
          ad.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((com.tencent.mm.plugin.vlog.player.c)localObject2).hashCode());
          ((VLogPlayView)localObject1).BTN = true;
          ((com.tencent.mm.plugin.vlog.player.c)localObject2).a(paramc, paramc.getVideoDurationMs(), paramc.BGN);
          com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject2, null, false, 7);
          paramc = ((VLogPlayView)localObject1).BTP;
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
    ad.i(TAG, "resume");
    Object localObject = this.BTE;
    if (localObject == null) {
      p.bcb("vlogVideoView");
    }
    if (((VLogPlayView)localObject).xNq)
    {
      localObject = this.BTE;
      if (localObject == null) {
        p.bcb("vlogVideoView");
      }
      ad.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).BTN = true;
      localObject = ((VLogPlayView)localObject).BJC;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject, null, false, 7);
      }
      localObject = this.tZt;
      if (localObject == null) {
        p.bcb("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).pW(this.fMP);
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
    if (localFakeVideoViewLayer == null) {
      p.bcb("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.ltc;
    if (localProgressBar == null) {
      p.bcb("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.BTE;
    if (localVLogPlayView == null) {
      p.bcb("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.BTE;
    if (localVLogPlayView == null) {
      p.bcb("vlogVideoView");
    }
    boolean bool = localVLogPlayView.BTN;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    ad.i(TAG, "onUIResume");
    b(this.xMF);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.tZt = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    p.h(paramProgressBar, "<set-?>");
    this.ltc = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fMP = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    p.h(paramVLogPlayView, "<set-?>");
    this.BTE = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    ad.i(TAG, "stop");
    Object localObject1 = this.BTE;
    if (localObject1 == null) {
      p.bcb("vlogVideoView");
    }
    ad.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).BJC;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.c)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).BId;
    if (localObject2 != null) {
      ((k)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).BTL;
    if (localObject2 != null) {
      ((ap)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).BTK;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).BJC = null;
    ((VLogPlayView)localObject1).BTL = null;
    ((VLogPlayView)localObject1).xNq = false;
    ((VLogPlayView)localObject1).BTN = false;
    ((VLogPlayView)localObject1).BTO = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).BTQ = false;
    localObject1 = this.tZt;
    if (localObject1 == null) {
      p.bcb("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).dHl();
    AppMethodBeat.o(111179);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(VLogFakeVideoView paramVLogFakeVideoView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */