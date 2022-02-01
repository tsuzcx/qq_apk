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
import com.tencent.mm.plugin.vlog.model.aa;
import com.tencent.mm.plugin.vlog.model.x;
import com.tencent.mm.plugin.vlog.model.x.a;
import com.tencent.mm.plugin.vlog.player.k;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.dvb;
import com.tencent.mm.protocal.protobuf.dxb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  public static final VLogFakeVideoView.a Clg;
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  public VLogPlayView Clf;
  private boolean fOX;
  public ProgressBar lxB;
  public FakeVideoViewLayer ukv;
  private com.tencent.mm.plugin.recordvideo.background.c ycz;
  
  static
  {
    AppMethodBeat.i(111182);
    Clg = new VLogFakeVideoView.a((byte)0);
    TAG = "MicroMsg.Story.VLogFakeVideoView";
    AppMethodBeat.o(111182);
  }
  
  public VLogFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111181);
    ae.i(TAG, "initView");
    LayoutInflater.from(getContext()).inflate(2131495854, (ViewGroup)this);
    paramContext = findViewById(2131306460);
    p.g(paramContext, "findViewById(R.id.vlog_play_view)");
    this.Clf = ((VLogPlayView)paramContext);
    paramContext = findViewById(2131299758);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.ukv = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.lxB = ((ProgressBar)paramContext);
    paramContext = this.Clf;
    if (paramContext == null) {
      p.bdF("vlogVideoView");
    }
    paramContext.setPrepareCallback((d.g.a.a)new b(this));
    AppMethodBeat.o(111181);
  }
  
  private final aa getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bw.a)new agh();
    Object localObject1 = this.ycz;
    if (localObject1 != null) {
      localObject1 = ((com.tencent.mm.plugin.recordvideo.background.c)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (agh)localObject1;
      if (localObject5 != null)
      {
        f1 = ((agh)localObject5).Gwo;
        f2 = ((agh)localObject5).Gwq;
        f3 = ((agh)localObject5).Gwp;
        f4 = ((agh)localObject5).Gwr;
        localObject1 = e.xKl;
        localObject1 = ((agh)localObject5).GrR;
        p.g(localObject1, "this.baseItemData");
        localObject4 = ak.getContext();
        p.g(localObject4, "MMApplicationContext.getContext()");
        localObject4 = e.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bw.a)new dvb();
        localObject5 = ((agh)localObject5).Gwx.toByteArray();
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
          localObject1 = (dvb)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((dvb)localObject1).IaL;
          long l = ((dxb)localObject1).FVt;
          Object localObject5 = x.BYd;
          p.g(localObject1, "vlogResp");
          localObject5 = x.a.a((dxb)localObject1);
          String str = ((dxb)localObject1).Icw.Hpi;
          p.g(str, "vlogResp.music.local_path");
          localObject1 = new aa(l, (List)localObject5, str, (dxb)localObject1);
          ((aa)localObject1).p(new float[] { f1, f2, f3, f4 });
          ((aa)localObject1).aC((ArrayList)localObject4);
          AppMethodBeat.o(111176);
          return localObject1;
          localObject1 = null;
        }
        localException1 = localException1;
        ae.l("safeParser", "", new Object[] { localException1 });
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { localException2 });
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
    this.ycz = paramc;
    Object localObject1 = TAG;
    paramc = new StringBuilder("LogStory: play fake video  item ").append(paramc).append(", mute:").append(this.fOX).append(", isBackgroundSilent:");
    Object localObject2 = this.ukv;
    if (localObject2 == null) {
      p.bdF("fakeLayer");
    }
    ae.i((String)localObject1, ((FakeVideoViewLayer)localObject2).xXB);
    paramc = this.ukv;
    if (paramc == null) {
      p.bdF("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.ycz;
    if (paramc != null)
    {
      localObject1 = this.ukv;
      if (localObject1 == null) {
        p.bdF("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(paramc);
    }
    paramc = getScriptModel();
    if (paramc != null)
    {
      localObject1 = this.Clf;
      if (localObject1 == null) {
        p.bdF("vlogVideoView");
      }
      p.h(paramc, "model");
      ae.i("MicroMsg.VLogPlayView", "renderScript model:" + paramc + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).Cbb == null) {
        ((VLogPlayView)localObject1).Clp = paramc;
      }
      for (;;)
      {
        paramc = this.Clf;
        if (paramc == null) {
          p.bdF("vlogVideoView");
        }
        if (!this.fOX)
        {
          localObject1 = this.ukv;
          if (localObject1 == null) {
            p.bdF("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).xXB) {}
        }
        else
        {
          bool = true;
        }
        paramc.setMute(bool);
        paramc = this.ukv;
        if (paramc == null) {
          p.bdF("fakeLayer");
        }
        paramc.qe(this.fOX);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).Cbb;
        if (localObject2 != null)
        {
          ae.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((com.tencent.mm.plugin.vlog.player.c)localObject2).hashCode());
          ((VLogPlayView)localObject1).Clo = true;
          ((com.tencent.mm.plugin.vlog.player.c)localObject2).a(paramc, paramc.getVideoDurationMs(), paramc.BYm);
          com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject2, null, false, 7);
          paramc = ((VLogPlayView)localObject1).Clq;
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
    ae.i(TAG, "resume");
    Object localObject = this.Clf;
    if (localObject == null) {
      p.bdF("vlogVideoView");
    }
    if (((VLogPlayView)localObject).ydj)
    {
      localObject = this.Clf;
      if (localObject == null) {
        p.bdF("vlogVideoView");
      }
      ae.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).Clo = true;
      localObject = ((VLogPlayView)localObject).Cbb;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.c.a((com.tencent.mm.plugin.vlog.player.c)localObject, null, false, 7);
      }
      localObject = this.ukv;
      if (localObject == null) {
        p.bdF("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).qe(this.fOX);
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
    if (localFakeVideoViewLayer == null) {
      p.bdF("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.lxB;
    if (localProgressBar == null) {
      p.bdF("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.Clf;
    if (localVLogPlayView == null) {
      p.bdF("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.Clf;
    if (localVLogPlayView == null) {
      p.bdF("vlogVideoView");
    }
    boolean bool = localVLogPlayView.Clo;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    ae.i(TAG, "onUIResume");
    b(this.ycz);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.ukv = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    p.h(paramProgressBar, "<set-?>");
    this.lxB = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fOX = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    p.h(paramVLogPlayView, "<set-?>");
    this.Clf = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    ae.i(TAG, "stop");
    Object localObject1 = this.Clf;
    if (localObject1 == null) {
      p.bdF("vlogVideoView");
    }
    ae.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).Cbb;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.c)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).BZC;
    if (localObject2 != null) {
      ((k)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).Clm;
    if (localObject2 != null) {
      ((aq)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).Cll;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).Cbb = null;
    ((VLogPlayView)localObject1).Clm = null;
    ((VLogPlayView)localObject1).ydj = false;
    ((VLogPlayView)localObject1).Clo = false;
    ((VLogPlayView)localObject1).Clp = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).Clr = false;
    localObject1 = this.ukv;
    if (localObject1 == null) {
      p.bdF("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).dKC();
    AppMethodBeat.o(111179);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */