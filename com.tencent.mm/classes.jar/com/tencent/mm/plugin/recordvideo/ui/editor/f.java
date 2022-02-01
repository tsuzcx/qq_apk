package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.ajd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class f
  extends RelativeLayout
{
  public static final a HZS;
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public FakeVideoViewLayer CGO;
  public StoryFakeVideoPlayView HZQ;
  private c HZR;
  private boolean iYs;
  public ProgressBar pDL;
  
  static
  {
    AppMethodBeat.i(76029);
    HZS = new a((byte)0);
    TAG = "MicroMsg.Story.ImageFakeVideoView";
    AppMethodBeat.o(76029);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76028);
    LayoutInflater.from(getContext()).inflate(b.f.story_image_video_view, (ViewGroup)this);
    paramContext = findViewById(b.e.imagevideoview);
    p.j(paramContext, "findViewById(R.id.imagevideoview)");
    this.HZQ = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(b.e.fakelayer);
    p.j(paramContext, "findViewById(R.id.fakelayer)");
    this.CGO = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(b.e.video_loading);
    p.j(paramContext, "findViewById(R.id.video_loading)");
    this.pDL = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new ajd();
    Object localObject1 = this.HZR;
    if (localObject1 != null) {}
    for (localObject1 = ((c)localObject1).field_baseItemData;; localObject1 = null)
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
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject1 = (ajd)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((ajd)localObject1).StE;
        if (localObject1 != null) {
          localArrayList.addAll((Collection)localObject1);
        }
      }
      AppMethodBeat.o(76021);
      return localArrayList;
    }
  }
  
  public final void a(c paramc)
  {
    AppMethodBeat.i(76023);
    p.k(paramc, "item");
    this.HZR = paramc;
    Log.i(TAG, "LogStory: play fake video");
    paramc = this.CGO;
    if (paramc == null) {
      p.bGy("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.HZR;
    if (paramc != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
      if (localFakeVideoViewLayer == null) {
        p.bGy("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(paramc);
      setAlpha(0.0F);
      paramc = this.HZQ;
      if (paramc == null) {
        p.bGy("imageVideoView");
      }
      paramc.setCallback((StoryFakeVideoPlayView.a)new b(this));
      paramc = this.HZQ;
      if (paramc == null) {
        p.bGy("imageVideoView");
      }
      paramc.aR(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(76024);
    Log.i(TAG, "resume");
    Log.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.HZQ;
    if (localStoryFakeVideoPlayView == null) {
      p.bGy("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.IaK)
    {
      localStoryFakeVideoPlayView = this.HZQ;
      if (localStoryFakeVideoPlayView == null) {
        p.bGy("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramc = this.CGO;
      if (paramc == null) {
        p.bGy("fakeLayer");
      }
      paramc.wR(this.iYs);
      AppMethodBeat.o(76024);
      return;
    }
    if (paramc != null) {
      a(paramc);
    }
    AppMethodBeat.o(76024);
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(76025);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.HZQ;
    if (localStoryFakeVideoPlayView == null) {
      p.bGy("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.CGO;
    if (localFakeVideoViewLayer == null) {
      p.bGy("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.HZQ;
    if (localStoryFakeVideoPlayView == null) {
      p.bGy("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.pDL;
    if (localProgressBar == null) {
      p.bGy("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.HZQ;
    if (localStoryFakeVideoPlayView == null) {
      p.bGy("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.IaG == StoryFakeVideoPlayView.c.IaO)
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
    Log.i(TAG, "onUIResume");
    b(this.HZR);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    p.k(paramFakeVideoViewLayer, "<set-?>");
    this.CGO = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    p.k(paramStoryFakeVideoPlayView, "<set-?>");
    this.HZQ = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    p.k(paramProgressBar, "<set-?>");
    this.pDL = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.iYs = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.CGO;
    if (localObject == null) {
      p.bGy("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).fxU();
    localObject = this.HZQ;
    if (localObject == null) {
      p.bGy("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void qX()
    {
      AppMethodBeat.i(76014);
      this.HZT.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.HZU.HZT.setAlpha(1.0F);
        this.HZU.HZT.getFakeLayer().wR(f.a(this.HZU.HZT));
        f.a locala = f.HZS;
        Log.i(f.access$getTAG$cp(), "imageVideoView onPrepared");
        AppMethodBeat.o(76013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.f
 * JD-Core Version:    0.7.0.1
 */