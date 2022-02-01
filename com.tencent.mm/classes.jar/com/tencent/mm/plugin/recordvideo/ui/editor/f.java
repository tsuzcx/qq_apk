package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class f
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public static final f.a xMG;
  private boolean fMP;
  public ProgressBar ltc;
  public FakeVideoViewLayer tZt;
  public StoryFakeVideoPlayView xME;
  private c xMF;
  
  static
  {
    AppMethodBeat.i(76029);
    xMG = new f.a((byte)0);
    TAG = "MicroMsg.Story.ImageFakeVideoView";
    AppMethodBeat.o(76029);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76028);
    LayoutInflater.from(getContext()).inflate(2131495700, (ViewGroup)this);
    paramContext = findViewById(2131300971);
    p.g(paramContext, "findViewById(R.id.imagevideoview)");
    this.xME = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131299758);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.tZt = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.ltc = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new afy();
    Object localObject1 = this.xMF;
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
          ad.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject1 = (afy)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((afy)localObject1).GdP;
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
    p.h(paramc, "item");
    this.xMF = paramc;
    ad.i(TAG, "LogStory: play fake video");
    paramc = this.tZt;
    if (paramc == null) {
      p.bcb("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.xMF;
    if (paramc != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
      if (localFakeVideoViewLayer == null) {
        p.bcb("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(paramc);
      setAlpha(0.0F);
      paramc = this.xME;
      if (paramc == null) {
        p.bcb("imageVideoView");
      }
      paramc.setCallback((StoryFakeVideoPlayView.a)new b(this));
      paramc = this.xME;
      if (paramc == null) {
        p.bcb("imageVideoView");
      }
      paramc.as(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(76024);
    ad.i(TAG, "resume");
    ad.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xME;
    if (localStoryFakeVideoPlayView == null) {
      p.bcb("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.xNq)
    {
      localStoryFakeVideoPlayView = this.xME;
      if (localStoryFakeVideoPlayView == null) {
        p.bcb("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramc = this.tZt;
      if (paramc == null) {
        p.bcb("fakeLayer");
      }
      paramc.pW(this.fMP);
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
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xME;
    if (localStoryFakeVideoPlayView == null) {
      p.bcb("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tZt;
    if (localFakeVideoViewLayer == null) {
      p.bcb("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xME;
    if (localStoryFakeVideoPlayView == null) {
      p.bcb("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.ltc;
    if (localProgressBar == null) {
      p.bcb("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.xME;
    if (localStoryFakeVideoPlayView == null) {
      p.bcb("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.xNm == StoryFakeVideoPlayView.c.xNu)
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
    b(this.xMF);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.tZt = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    p.h(paramStoryFakeVideoPlayView, "<set-?>");
    this.xME = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    p.h(paramProgressBar, "<set-?>");
    this.ltc = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fMP = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.tZt;
    if (localObject == null) {
      p.bcb("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dHl();
    localObject = this.xME;
    if (localObject == null) {
      p.bcb("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void ta()
    {
      AppMethodBeat.i(76014);
      this.xMH.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.xMI.xMH.setAlpha(1.0F);
        this.xMI.xMH.getFakeLayer().pW(f.a(this.xMI.xMH));
        f.a locala = f.xMG;
        ad.i(f.access$getTAG$cp(), "imageVideoView onPrepared");
        AppMethodBeat.o(76013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.f
 * JD-Core Version:    0.7.0.1
 */