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
import com.tencent.mm.plugin.recordvideo.background.g;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.model.v;
import com.tencent.mm.plugin.vlog.model.v.a;
import com.tencent.mm.plugin.vlog.model.y;
import com.tencent.mm.plugin.vlog.player.d;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.bxe;
import com.tencent.mm.protocal.protobuf.don;
import com.tencent.mm.protocal.protobuf.dqm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import d.g.b.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  public static final VLogFakeVideoView.a Auv;
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  public VLogPlayView Auu;
  private boolean ftN;
  public ProgressBar kWd;
  public FakeVideoViewLayer tbD;
  private e wCd;
  
  static
  {
    AppMethodBeat.i(111182);
    Auv = new VLogFakeVideoView.a((byte)0);
    TAG = "MicroMsg.Story.VLogFakeVideoView";
    AppMethodBeat.o(111182);
  }
  
  public VLogFakeVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111181);
    ac.i(TAG, "initView");
    LayoutInflater.from(getContext()).inflate(2131495854, (ViewGroup)this);
    paramContext = findViewById(2131306460);
    k.g(paramContext, "findViewById(R.id.vlog_play_view)");
    this.Auu = ((VLogPlayView)paramContext);
    paramContext = findViewById(2131299758);
    k.g(paramContext, "findViewById(R.id.fakelayer)");
    this.tbD = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    k.g(paramContext, "findViewById(R.id.video_loading)");
    this.kWd = ((ProgressBar)paramContext);
    paramContext = this.Auu;
    if (paramContext == null) {
      k.aVY("vlogVideoView");
    }
    paramContext.setPrepareCallback((d.g.a.a)new VLogFakeVideoView.b(this));
    AppMethodBeat.o(111181);
  }
  
  private final y getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bw.a)new adp();
    Object localObject1 = this.wCd;
    if (localObject1 != null) {
      localObject1 = ((e)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.bw.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (adp)localObject1;
      if (localObject5 != null)
      {
        f1 = ((adp)localObject5).Ewh;
        f2 = ((adp)localObject5).Ewj;
        f3 = ((adp)localObject5).Ewi;
        f4 = ((adp)localObject5).Ewk;
        localObject1 = g.wmx;
        localObject1 = ((adp)localObject5).Esi;
        k.g(localObject1, "this.baseItemData");
        localObject4 = ai.getContext();
        k.g(localObject4, "MMApplicationContext.getContext()");
        localObject4 = g.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bw.a)new don();
        localObject5 = ((adp)localObject5).Ewq.toByteArray();
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
          localObject1 = (don)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((don)localObject1).FWi;
          long l = ((dqm)localObject1).DXC;
          Object localObject5 = v.AoN;
          k.g(localObject1, "vlogResp");
          localObject5 = v.a.a((dqm)localObject1);
          String str = ((dqm)localObject1).FXO.FlY;
          k.g(str, "vlogResp.music.local_path");
          localObject1 = new y(l, (List)localObject5, str, (dqm)localObject1);
          ((y)localObject1).p(new float[] { f1, f2, f3, f4 });
          ((y)localObject1).aF((ArrayList)localObject4);
          AppMethodBeat.o(111176);
          return localObject1;
          localObject1 = null;
        }
        localException1 = localException1;
        ac.l("safeParser", "", new Object[] { localException1 });
        Object localObject2 = null;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ac.l("safeParser", "", new Object[] { localException2 });
          Object localObject3 = null;
        }
      }
      AppMethodBeat.o(111176);
    }
    return null;
  }
  
  public final void a(e parame)
  {
    boolean bool = false;
    AppMethodBeat.i(111177);
    k.h(parame, "item");
    this.wCd = parame;
    Object localObject1 = TAG;
    parame = new StringBuilder("LogStory: play fake video  item ").append(parame).append(", mute:").append(this.ftN).append(", isBackgroundSilent:");
    Object localObject2 = this.tbD;
    if (localObject2 == null) {
      k.aVY("fakeLayer");
    }
    ac.i((String)localObject1, ((FakeVideoViewLayer)localObject2).wyv);
    parame = this.tbD;
    if (parame == null) {
      k.aVY("fakeLayer");
    }
    parame.setVisibility(0);
    parame = this.wCd;
    if (parame != null)
    {
      localObject1 = this.tbD;
      if (localObject1 == null) {
        k.aVY("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(parame);
    }
    parame = getScriptModel();
    if (parame != null)
    {
      localObject1 = this.Auu;
      if (localObject1 == null) {
        k.aVY("vlogVideoView");
      }
      k.h(parame, "model");
      ac.i("MicroMsg.VLogPlayView", "renderScript model:" + parame + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).ArL == null) {
        ((VLogPlayView)localObject1).AuD = parame;
      }
      for (;;)
      {
        parame = this.Auu;
        if (parame == null) {
          k.aVY("vlogVideoView");
        }
        if (!this.ftN)
        {
          localObject1 = this.tbD;
          if (localObject1 == null) {
            k.aVY("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).wyv) {}
        }
        else
        {
          bool = true;
        }
        parame.setMute(bool);
        parame = this.tbD;
        if (parame == null) {
          k.aVY("fakeLayer");
        }
        parame.pA(this.ftN);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).ArL;
        if (localObject2 != null)
        {
          ac.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((d)localObject2).hashCode());
          ((VLogPlayView)localObject1).AuC = true;
          ((d)localObject2).a(parame, parame.getVideoDurationMs(), parame.AoW);
          d.a((d)localObject2, null, false, 7);
          parame = ((VLogPlayView)localObject1).AuE;
          if (parame != null) {
            parame.invoke();
          }
        }
      }
    }
    AppMethodBeat.o(111177);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(111178);
    ac.i(TAG, "resume");
    Object localObject = this.Auu;
    if (localObject == null) {
      k.aVY("vlogVideoView");
    }
    if (((VLogPlayView)localObject).wCr)
    {
      localObject = this.Auu;
      if (localObject == null) {
        k.aVY("vlogVideoView");
      }
      ac.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).AuC = true;
      localObject = ((VLogPlayView)localObject).ArL;
      if (localObject != null) {
        d.a((d)localObject, null, false, 7);
      }
      localObject = this.tbD;
      if (localObject == null) {
        k.aVY("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).pA(this.ftN);
    }
    if (parame != null) {
      a(parame);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
    if (localFakeVideoViewLayer == null) {
      k.aVY("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.kWd;
    if (localProgressBar == null) {
      k.aVY("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.Auu;
    if (localVLogPlayView == null) {
      k.aVY("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.Auu;
    if (localVLogPlayView == null) {
      k.aVY("vlogVideoView");
    }
    boolean bool = localVLogPlayView.AuC;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    ac.i(TAG, "onUIResume");
    b(this.wCd);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    k.h(paramFakeVideoViewLayer, "<set-?>");
    this.tbD = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    k.h(paramProgressBar, "<set-?>");
    this.kWd = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.ftN = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    k.h(paramVLogPlayView, "<set-?>");
    this.Auu = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    ac.i(TAG, "stop");
    Object localObject1 = this.Auu;
    if (localObject1 == null) {
      k.aVY("vlogVideoView");
    }
    ac.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).ArL;
    if (localObject2 != null) {
      ((d)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).ApF;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.l)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).AuB;
    if (localObject2 != null) {
      ((ao)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).AuA;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).ArL = null;
    ((VLogPlayView)localObject1).AuB = null;
    ((VLogPlayView)localObject1).wCr = false;
    ((VLogPlayView)localObject1).AuC = false;
    ((VLogPlayView)localObject1).AuD = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).AuF = false;
    localObject1 = this.tbD;
    if (localObject1 == null) {
      k.aVY("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).dwz();
    AppMethodBeat.o(111179);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.preview.VLogFakeVideoView
 * JD-Core Version:    0.7.0.1
 */