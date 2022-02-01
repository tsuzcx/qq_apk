package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class d
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public static final a vsd;
  private boolean fqj;
  public ProgressBar kuP;
  public FakeVideoViewLayer rTL;
  public StoryFakeVideoPlayView vsb;
  private com.tencent.mm.plugin.recordvideo.background.d vsc;
  
  static
  {
    AppMethodBeat.i(76029);
    vsd = new a((byte)0);
    TAG = "MicroMsg.Story.ImageFakeVideoView";
    AppMethodBeat.o(76029);
  }
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76028);
    LayoutInflater.from(getContext()).inflate(2131495700, (ViewGroup)this);
    paramContext = findViewById(2131300971);
    k.g(paramContext, "findViewById(R.id.imagevideoview)");
    this.vsb = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131299758);
    k.g(paramContext, "findViewById(R.id.fakelayer)");
    this.rTL = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    k.g(paramContext, "findViewById(R.id.video_loading)");
    this.kuP = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new acq();
    Object localObject1 = this.vsc;
    if (localObject1 != null) {}
    for (localObject1 = ((com.tencent.mm.plugin.recordvideo.background.d)localObject1).field_baseItemData;; localObject1 = null)
    {
      try
      {
        locala.parseFrom((byte[])localObject1);
        localObject1 = locala;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject1 = (acq)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((acq)localObject1).Ddj;
        if (localObject1 != null) {
          localArrayList.addAll((Collection)localObject1);
        }
      }
      AppMethodBeat.o(76021);
      return localArrayList;
    }
  }
  
  public final void a(com.tencent.mm.plugin.recordvideo.background.d paramd)
  {
    AppMethodBeat.i(76023);
    k.h(paramd, "item");
    this.vsc = paramd;
    ad.i(TAG, "LogStory: play fake video");
    paramd = this.rTL;
    if (paramd == null) {
      k.aPZ("fakeLayer");
    }
    paramd.setVisibility(0);
    paramd = this.vsc;
    if (paramd != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
      if (localFakeVideoViewLayer == null) {
        k.aPZ("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(paramd);
      setAlpha(0.0F);
      paramd = this.vsb;
      if (paramd == null) {
        k.aPZ("imageVideoView");
      }
      paramd.setCallback((StoryFakeVideoPlayView.a)new b(this));
      paramd = this.vsb;
      if (paramd == null) {
        k.aPZ("imageVideoView");
      }
      paramd.ai(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(com.tencent.mm.plugin.recordvideo.background.d paramd)
  {
    AppMethodBeat.i(76024);
    ad.i(TAG, "resume");
    ad.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.vsb;
    if (localStoryFakeVideoPlayView == null) {
      k.aPZ("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.vsr)
    {
      localStoryFakeVideoPlayView = this.vsb;
      if (localStoryFakeVideoPlayView == null) {
        k.aPZ("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramd = this.rTL;
      if (paramd == null) {
        k.aPZ("fakeLayer");
      }
      paramd.oC(this.fqj);
      AppMethodBeat.o(76024);
      return;
    }
    if (paramd != null) {
      a(paramd);
    }
    AppMethodBeat.o(76024);
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(76025);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.vsb;
    if (localStoryFakeVideoPlayView == null) {
      k.aPZ("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.rTL;
    if (localFakeVideoViewLayer == null) {
      k.aPZ("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.vsb;
    if (localStoryFakeVideoPlayView == null) {
      k.aPZ("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.kuP;
    if (localProgressBar == null) {
      k.aPZ("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.vsb;
    if (localStoryFakeVideoPlayView == null) {
      k.aPZ("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.vsn == StoryFakeVideoPlayView.c.vsv)
    {
      AppMethodBeat.o(76022);
      return true;
    }
    AppMethodBeat.o(76022);
    return false;
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(76027);
    ad.i(TAG, "onUIResume");
    b(this.vsc);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    k.h(paramFakeVideoViewLayer, "<set-?>");
    this.rTL = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    k.h(paramStoryFakeVideoPlayView, "<set-?>");
    this.vsb = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    k.h(paramProgressBar, "<set-?>");
    this.kuP = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fqj = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.rTL;
    if (localObject == null) {
      k.aPZ("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).diG();
    localObject = this.vsb;
    if (localObject == null) {
      k.aPZ("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void rq()
    {
      AppMethodBeat.i(76014);
      this.vse.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.vsf.vse.setAlpha(1.0F);
        this.vsf.vse.getFakeLayer().oC(d.a(this.vsf.vse));
        d.a locala = d.vsd;
        ad.i(d.access$getTAG$cp(), "imageVideoView onPrepared");
        AppMethodBeat.o(76013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.d
 * JD-Core Version:    0.7.0.1
 */