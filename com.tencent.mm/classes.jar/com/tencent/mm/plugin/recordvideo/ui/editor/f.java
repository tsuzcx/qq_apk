package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.agh;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class f
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public static final f.a ycA;
  private boolean fOX;
  public ProgressBar lxB;
  public FakeVideoViewLayer ukv;
  public StoryFakeVideoPlayView ycy;
  private c ycz;
  
  static
  {
    AppMethodBeat.i(76029);
    ycA = new f.a((byte)0);
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
    this.ycy = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131299758);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.ukv = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.lxB = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new agh();
    Object localObject1 = this.ycz;
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
          ae.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject1 = (agh)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((agh)localObject1).Gww;
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
    this.ycz = paramc;
    ae.i(TAG, "LogStory: play fake video");
    paramc = this.ukv;
    if (paramc == null) {
      p.bdF("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.ycz;
    if (paramc != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
      if (localFakeVideoViewLayer == null) {
        p.bdF("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(paramc);
      setAlpha(0.0F);
      paramc = this.ycy;
      if (paramc == null) {
        p.bdF("imageVideoView");
      }
      paramc.setCallback((StoryFakeVideoPlayView.a)new b(this));
      paramc = this.ycy;
      if (paramc == null) {
        p.bdF("imageVideoView");
      }
      paramc.at(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(76024);
    ae.i(TAG, "resume");
    ae.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.ycy;
    if (localStoryFakeVideoPlayView == null) {
      p.bdF("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.ydj)
    {
      localStoryFakeVideoPlayView = this.ycy;
      if (localStoryFakeVideoPlayView == null) {
        p.bdF("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramc = this.ukv;
      if (paramc == null) {
        p.bdF("fakeLayer");
      }
      paramc.qe(this.fOX);
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
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.ycy;
    if (localStoryFakeVideoPlayView == null) {
      p.bdF("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.ukv;
    if (localFakeVideoViewLayer == null) {
      p.bdF("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.ycy;
    if (localStoryFakeVideoPlayView == null) {
      p.bdF("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.lxB;
    if (localProgressBar == null) {
      p.bdF("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.ycy;
    if (localStoryFakeVideoPlayView == null) {
      p.bdF("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.ydf == StoryFakeVideoPlayView.c.ydn)
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
    ae.i(TAG, "onUIResume");
    b(this.ycz);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.ukv = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    p.h(paramStoryFakeVideoPlayView, "<set-?>");
    this.ycy = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    p.h(paramProgressBar, "<set-?>");
    this.lxB = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.fOX = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.ukv;
    if (localObject == null) {
      p.bdF("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dKC();
    localObject = this.ycy;
    if (localObject == null) {
      p.bdF("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void ta()
    {
      AppMethodBeat.i(76014);
      this.ycB.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.ycC.ycB.setAlpha(1.0F);
        this.ycC.ycB.getFakeLayer().qe(f.a(this.ycC.ycB));
        f.a locala = f.ycA;
        ae.i(f.access$getTAG$cp(), "imageVideoView onPrepared");
        AppMethodBeat.o(76013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.f
 * JD-Core Version:    0.7.0.1
 */