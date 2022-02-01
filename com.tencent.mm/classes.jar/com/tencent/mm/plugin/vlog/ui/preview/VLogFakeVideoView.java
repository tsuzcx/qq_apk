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
import com.tencent.mm.plugin.recordvideo.background.d;
import com.tencent.mm.plugin.recordvideo.background.f;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.plugin.vlog.model.z;
import com.tencent.mm.plugin.vlog.model.z.a;
import com.tencent.mm.plugin.vlog.player.m;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.bsn;
import com.tencent.mm.protocal.protobuf.diy;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attr", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "vlogVideoView", "Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "getVlogVideoView", "()Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;", "setVlogVideoView", "(Lcom/tencent/mm/plugin/vlog/ui/preview/VLogPlayView;)V", "canResume", "getScriptModel", "Lcom/tencent/mm/plugin/vlog/model/VLogScriptModel;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "", "release", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-vlog_release"})
public final class VLogFakeVideoView
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.VLogFakeVideoView";
  public static final a zcJ;
  private boolean fqj;
  public ProgressBar kuP;
  public FakeVideoViewLayer rTL;
  private d vsc;
  public VLogPlayView zcI;
  
  static
  {
    AppMethodBeat.i(111182);
    zcJ = new a((byte)0);
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
    k.g(paramContext, "findViewById(R.id.vlog_play_view)");
    this.zcI = ((VLogPlayView)paramContext);
    paramContext = findViewById(2131299758);
    k.g(paramContext, "findViewById(R.id.fakelayer)");
    this.rTL = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    k.g(paramContext, "findViewById(R.id.video_loading)");
    this.kuP = ((ProgressBar)paramContext);
    paramContext = this.zcI;
    if (paramContext == null) {
      k.aPZ("vlogVideoView");
    }
    paramContext.setPrepareCallback((d.g.a.a)new b(this));
    AppMethodBeat.o(111181);
  }
  
  private final com.tencent.mm.plugin.vlog.model.h getScriptModel()
  {
    AppMethodBeat.i(111176);
    Object localObject4 = (com.tencent.mm.bx.a)new acq();
    Object localObject1 = this.vsc;
    if (localObject1 != null) {
      localObject1 = ((d)localObject1).field_baseItemData;
    }
    try
    {
      ((com.tencent.mm.bx.a)localObject4).parseFrom((byte[])localObject1);
      localObject1 = localObject4;
      localObject5 = (acq)localObject1;
      if (localObject5 != null)
      {
        f1 = ((acq)localObject5).Dda;
        f2 = ((acq)localObject5).Ddc;
        f3 = ((acq)localObject5).Ddb;
        f4 = ((acq)localObject5).Ddd;
        localObject1 = f.vdH;
        localObject1 = ((acq)localObject5).Dde;
        k.g(localObject1, "this.baseItemData");
        localObject4 = aj.getContext();
        k.g(localObject4, "MMApplicationContext.getContext()");
        localObject4 = f.a((LinkedList)localObject1, (Context)localObject4);
        localObject1 = (com.tencent.mm.bx.a)new diy();
        localObject5 = ((acq)localObject5).Ddk.toByteArray();
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
          localObject1 = (diy)localObject1;
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((diy)localObject1).Ezg;
          long l = ((dkv)localObject1).CFc;
          Object localObject5 = z.LrD;
          k.g(localObject1, "vlogResp");
          localObject5 = z.a.a((dkv)localObject1);
          String str = ((dkv)localObject1).EAA.DPH;
          k.g(str, "vlogResp.music.local_path");
          localObject1 = new com.tencent.mm.plugin.vlog.model.h(l, (List)localObject5, str, (dkv)localObject1);
          ((com.tencent.mm.plugin.vlog.model.h)localObject1).p(new float[] { f1, f2, f3, f4 });
          ((com.tencent.mm.plugin.vlog.model.h)localObject1).at((ArrayList)localObject4);
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
  
  public final void a(d paramd)
  {
    boolean bool = false;
    AppMethodBeat.i(111177);
    k.h(paramd, "item");
    this.vsc = paramd;
    Object localObject1 = TAG;
    paramd = new StringBuilder("LogStory: play fake video  item ").append(paramd).append(", mute:").append(this.fqj).append(", isBackgroundSilent:");
    Object localObject2 = this.rTL;
    if (localObject2 == null) {
      k.aPZ("fakeLayer");
    }
    ad.i((String)localObject1, ((FakeVideoViewLayer)localObject2).vpE);
    paramd = this.rTL;
    if (paramd == null) {
      k.aPZ("fakeLayer");
    }
    paramd.setVisibility(0);
    paramd = this.vsc;
    if (paramd != null)
    {
      localObject1 = this.rTL;
      if (localObject1 == null) {
        k.aPZ("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject1).setFakeVideoInfo(paramd);
    }
    paramd = getScriptModel();
    if (paramd != null)
    {
      localObject1 = this.zcI;
      if (localObject1 == null) {
        k.aPZ("vlogVideoView");
      }
      k.h(paramd, "model");
      ad.i("MicroMsg.VLogPlayView", "renderScript model:" + paramd + "  " + ((VLogPlayView)localObject1).hashCode());
      if (((VLogPlayView)localObject1).Lti == null) {
        ((VLogPlayView)localObject1).zcS = paramd;
      }
      for (;;)
      {
        paramd = this.zcI;
        if (paramd == null) {
          k.aPZ("vlogVideoView");
        }
        if (!this.fqj)
        {
          localObject1 = this.rTL;
          if (localObject1 == null) {
            k.aPZ("fakeLayer");
          }
          if (!((FakeVideoViewLayer)localObject1).vpE) {}
        }
        else
        {
          bool = true;
        }
        paramd.setMute(bool);
        paramd = this.rTL;
        if (paramd == null) {
          k.aPZ("fakeLayer");
        }
        paramd.oC(this.fqj);
        AppMethodBeat.o(111177);
        return;
        localObject2 = ((VLogPlayView)localObject1).Lti;
        if (localObject2 != null)
        {
          ad.i("MicroMsg.VLogPlayView", "play in renderScript   " + ((com.tencent.mm.plugin.vlog.player.h)localObject2).hashCode());
          ((VLogPlayView)localObject1).zcR = true;
          ((com.tencent.mm.plugin.vlog.player.h)localObject2).a(paramd, paramd.getVideoDurationMs(), paramd.yZt);
          com.tencent.mm.plugin.vlog.player.h.a((com.tencent.mm.plugin.vlog.player.h)localObject2, null, false, 7);
          paramd = ((VLogPlayView)localObject1).zcT;
          if (paramd != null) {
            paramd.invoke();
          }
        }
      }
    }
    AppMethodBeat.o(111177);
  }
  
  public final void b(d paramd)
  {
    AppMethodBeat.i(111178);
    ad.i(TAG, "resume");
    Object localObject = this.zcI;
    if (localObject == null) {
      k.aPZ("vlogVideoView");
    }
    if (((VLogPlayView)localObject).vsr)
    {
      localObject = this.zcI;
      if (localObject == null) {
        k.aPZ("vlogVideoView");
      }
      ad.i("MicroMsg.VLogPlayView", "resume");
      ((VLogPlayView)localObject).zcR = true;
      localObject = ((VLogPlayView)localObject).Lti;
      if (localObject != null) {
        com.tencent.mm.plugin.vlog.player.h.a((com.tencent.mm.plugin.vlog.player.h)localObject, null, false, 7);
      }
      localObject = this.rTL;
      if (localObject == null) {
        k.aPZ("fakeLayer");
      }
      ((FakeVideoViewLayer)localObject).oC(this.fqj);
    }
    if (paramd != null) {
      a(paramd);
    }
    AppMethodBeat.o(111178);
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(111171);
    FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
    if (localFakeVideoViewLayer == null) {
      k.aPZ("fakeLayer");
    }
    AppMethodBeat.o(111171);
    return localFakeVideoViewLayer;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(111173);
    ProgressBar localProgressBar = this.kuP;
    if (localProgressBar == null) {
      k.aPZ("loading");
    }
    AppMethodBeat.o(111173);
    return localProgressBar;
  }
  
  public final VLogPlayView getVlogVideoView()
  {
    AppMethodBeat.i(111169);
    VLogPlayView localVLogPlayView = this.zcI;
    if (localVLogPlayView == null) {
      k.aPZ("vlogVideoView");
    }
    AppMethodBeat.o(111169);
    return localVLogPlayView;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(111175);
    VLogPlayView localVLogPlayView = this.zcI;
    if (localVLogPlayView == null) {
      k.aPZ("vlogVideoView");
    }
    boolean bool = localVLogPlayView.zcR;
    AppMethodBeat.o(111175);
    return bool;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(111180);
    ad.i(TAG, "onUIResume");
    b(this.vsc);
    AppMethodBeat.o(111180);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(111172);
    k.h(paramFakeVideoViewLayer, "<set-?>");
    this.rTL = paramFakeVideoViewLayer;
    AppMethodBeat.o(111172);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(111174);
    k.h(paramProgressBar, "<set-?>");
    this.kuP = paramProgressBar;
    AppMethodBeat.o(111174);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fqj = paramBoolean;
  }
  
  public final void setVlogVideoView(VLogPlayView paramVLogPlayView)
  {
    AppMethodBeat.i(111170);
    k.h(paramVLogPlayView, "<set-?>");
    this.zcI = paramVLogPlayView;
    AppMethodBeat.o(111170);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(111179);
    ad.i(TAG, "stop");
    Object localObject1 = this.zcI;
    if (localObject1 == null) {
      k.aPZ("vlogVideoView");
    }
    ad.i("MicroMsg.VLogPlayView", "stop");
    Object localObject2 = ((VLogPlayView)localObject1).Lti;
    if (localObject2 != null) {
      ((com.tencent.mm.plugin.vlog.player.h)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).LrT;
    if (localObject2 != null) {
      ((m)localObject2).release();
    }
    localObject2 = ((VLogPlayView)localObject1).zcP;
    if (localObject2 != null) {
      ((ap)localObject2).removeCallbacksAndMessages(null);
    }
    localObject2 = ((VLogPlayView)localObject1).zcO;
    if (localObject2 != null) {
      ((HandlerThread)localObject2).quitSafely();
    }
    ((VLogPlayView)localObject1).Lti = null;
    ((VLogPlayView)localObject1).zcP = null;
    ((VLogPlayView)localObject1).vsr = false;
    ((VLogPlayView)localObject1).zcR = false;
    ((VLogPlayView)localObject1).zcS = null;
    ((VLogPlayView)localObject1).frameCount = 0;
    ((VLogPlayView)localObject1).zcU = false;
    localObject1 = this.rTL;
    if (localObject1 == null) {
      k.aPZ("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject1).diG();
    AppMethodBeat.o(111179);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/vlog/ui/preview/VLogFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-vlog_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
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