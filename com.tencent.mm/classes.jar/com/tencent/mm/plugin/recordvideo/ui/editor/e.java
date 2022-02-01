package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.recordvideo.b.e;
import com.tencent.mm.plugin.recordvideo.b.f;
import com.tencent.mm.plugin.recordvideo.background.c;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.ami;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends RelativeLayout
{
  public static final e.a NWt;
  private static final String TAG;
  public FakeVideoViewLayer IAY;
  public StoryFakeVideoPlayView NWu;
  private c NWv;
  private boolean lAj;
  public ProgressBar sIX;
  
  static
  {
    AppMethodBeat.i(76029);
    NWt = new e.a((byte)0);
    TAG = "MicroMsg.Story.ImageFakeVideoView";
    AppMethodBeat.o(76029);
  }
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76028);
    LayoutInflater.from(getContext()).inflate(b.f.story_image_video_view, (ViewGroup)this);
    paramContext = findViewById(b.e.imagevideoview);
    s.s(paramContext, "findViewById(R.id.imagevideoview)");
    setImageVideoView((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(b.e.fakelayer);
    s.s(paramContext, "findViewById(R.id.fakelayer)");
    setFakeLayer((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(b.e.video_loading);
    s.s(paramContext, "findViewById(R.id.video_loading)");
    setLoading((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new ami();
    Object localObject1 = this.NWv;
    if (localObject1 == null) {}
    for (localObject1 = null;; localObject1 = ((c)localObject1).field_baseItemData)
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
      localObject1 = (ami)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((ami)localObject1).Zto;
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
    s.u(paramc, "item");
    this.NWv = paramc;
    Log.i(TAG, "LogStory: play fake video");
    getFakeLayer().setVisibility(0);
    paramc = this.NWv;
    if (paramc != null)
    {
      getFakeLayer().setFakeVideoInfo(paramc);
      setAlpha(0.0F);
      getImageVideoView().setCallback((StoryFakeVideoPlayView.a)new b(this));
      getImageVideoView().bm(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(c paramc)
  {
    AppMethodBeat.i(76024);
    Log.i(TAG, "resume");
    Log.i(TAG, "checkResumeLocalVideo");
    if (getImageVideoView().NXm) {
      getImageVideoView().resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      getFakeLayer().Br(this.lAj);
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
    int i = getImageVideoView().getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.IAY;
    if (localFakeVideoViewLayer != null)
    {
      AppMethodBeat.o(76017);
      return localFakeVideoViewLayer;
    }
    s.bIx("fakeLayer");
    AppMethodBeat.o(76017);
    return null;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.NWu;
    if (localStoryFakeVideoPlayView != null)
    {
      AppMethodBeat.o(76015);
      return localStoryFakeVideoPlayView;
    }
    s.bIx("imageVideoView");
    AppMethodBeat.o(76015);
    return null;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.sIX;
    if (localProgressBar != null)
    {
      AppMethodBeat.o(76019);
      return localProgressBar;
    }
    s.bIx("loading");
    AppMethodBeat.o(76019);
    return null;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    if (getImageVideoView().NXi == StoryFakeVideoPlayView.c.NXp)
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
    b(this.NWv);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    s.u(paramFakeVideoViewLayer, "<set-?>");
    this.IAY = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    s.u(paramStoryFakeVideoPlayView, "<set-?>");
    this.NWu = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    s.u(paramProgressBar, "<set-?>");
    this.sIX = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.lAj = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    getFakeLayer().gJH();
    getImageVideoView().stop();
    AppMethodBeat.o(76026);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    b(e parame) {}
    
    private static final void b(e parame)
    {
      AppMethodBeat.i(279899);
      s.u(parame, "this$0");
      parame.setAlpha(1.0F);
      parame.getFakeLayer().Br(e.a(parame));
      parame = e.NWt;
      Log.i(e.access$getTAG$cp(), "imageVideoView onPrepared");
      AppMethodBeat.o(279899);
    }
    
    public final void Qz()
    {
      AppMethodBeat.i(76014);
      this.NWw.post(new e.b..ExternalSyntheticLambda0(this.NWw));
      AppMethodBeat.o(76014);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.e
 * JD-Core Version:    0.7.0.1
 */