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
import com.tencent.mm.protocal.protobuf.aio;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class f
  extends RelativeLayout
{
  public static final a CdC;
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public StoryFakeVideoPlayView CdA;
  private c CdB;
  private boolean guh;
  public ProgressBar mEz;
  public FakeVideoViewLayer xCO;
  
  static
  {
    AppMethodBeat.i(76029);
    CdC = new a((byte)0);
    TAG = "MicroMsg.Story.ImageFakeVideoView";
    AppMethodBeat.o(76029);
  }
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76028);
    LayoutInflater.from(getContext()).inflate(2131496605, (ViewGroup)this);
    paramContext = findViewById(2131302607);
    p.g(paramContext, "findViewById(R.id.imagevideoview)");
    this.CdA = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131300427);
    p.g(paramContext, "findViewById(R.id.fakelayer)");
    this.xCO = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131309778);
    p.g(paramContext, "findViewById(R.id.video_loading)");
    this.mEz = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new aio();
    Object localObject1 = this.CdB;
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
      localObject1 = (aio)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((aio)localObject1).Lsc;
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
    this.CdB = paramc;
    Log.i(TAG, "LogStory: play fake video");
    paramc = this.xCO;
    if (paramc == null) {
      p.btv("fakeLayer");
    }
    paramc.setVisibility(0);
    paramc = this.CdB;
    if (paramc != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
      if (localFakeVideoViewLayer == null) {
        p.btv("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(paramc);
      setAlpha(0.0F);
      paramc = this.CdA;
      if (paramc == null) {
        p.btv("imageVideoView");
      }
      paramc.setCallback((StoryFakeVideoPlayView.a)new b(this));
      paramc = this.CdA;
      if (paramc == null) {
        p.btv("imageVideoView");
      }
      paramc.aK(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(76024);
    Log.i(TAG, "resume");
    Log.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.CdA;
    if (localStoryFakeVideoPlayView == null) {
      p.btv("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.Cel)
    {
      localStoryFakeVideoPlayView = this.CdA;
      if (localStoryFakeVideoPlayView == null) {
        p.btv("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      paramc = this.xCO;
      if (paramc == null) {
        p.btv("fakeLayer");
      }
      paramc.tv(this.guh);
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
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.CdA;
    if (localStoryFakeVideoPlayView == null) {
      p.btv("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.xCO;
    if (localFakeVideoViewLayer == null) {
      p.btv("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.CdA;
    if (localStoryFakeVideoPlayView == null) {
      p.btv("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.mEz;
    if (localProgressBar == null) {
      p.btv("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.CdA;
    if (localStoryFakeVideoPlayView == null) {
      p.btv("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.Ceh == StoryFakeVideoPlayView.c.Cep)
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
    b(this.CdB);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    p.h(paramFakeVideoViewLayer, "<set-?>");
    this.xCO = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    p.h(paramStoryFakeVideoPlayView, "<set-?>");
    this.CdA = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    p.h(paramProgressBar, "<set-?>");
    this.mEz = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.guh = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.xCO;
    if (localObject == null) {
      p.btv("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).eLB();
    localObject = this.CdA;
    if (localObject == null) {
      p.btv("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "plugin-recordvideo_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void tf()
    {
      AppMethodBeat.i(76014);
      this.CdD.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(f.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.CdE.CdD.setAlpha(1.0F);
        this.CdE.CdD.getFakeLayer().tv(f.a(this.CdE.CdD));
        f.a locala = f.CdC;
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