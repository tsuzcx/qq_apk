package com.tencent.mm.plugin.recordvideo.ui.editor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.recordvideo.background.e;
import com.tencent.mm.plugin.recordvideo.ui.FakeVideoViewLayer;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.Collection;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/recordvideo/ui/FakeVideoViewLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/recordvideo/background/VideoEditData;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-recordvideo_release"})
public final class d
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.ImageFakeVideoView";
  public static final d.a wCe;
  private boolean ftN;
  public ProgressBar kWd;
  public FakeVideoViewLayer tbD;
  public StoryFakeVideoPlayView wCc;
  private e wCd;
  
  static
  {
    AppMethodBeat.i(76029);
    wCe = new d.a((byte)0);
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
    this.wCc = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131299758);
    k.g(paramContext, "findViewById(R.id.fakelayer)");
    this.tbD = ((FakeVideoViewLayer)paramContext);
    paramContext = findViewById(2131306352);
    k.g(paramContext, "findViewById(R.id.video_loading)");
    this.kWd = ((ProgressBar)paramContext);
    AppMethodBeat.o(76028);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(76021);
    ArrayList localArrayList = new ArrayList();
    a locala = (a)new adp();
    Object localObject1 = this.wCd;
    if (localObject1 != null) {}
    for (localObject1 = ((e)localObject1).field_baseItemData;; localObject1 = null)
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
          ac.l("safeParser", "", new Object[] { localException });
          Object localObject2 = null;
        }
      }
      localObject1 = (adp)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((adp)localObject1).Ewp;
        if (localObject1 != null) {
          localArrayList.addAll((Collection)localObject1);
        }
      }
      AppMethodBeat.o(76021);
      return localArrayList;
    }
  }
  
  public final void a(e parame)
  {
    AppMethodBeat.i(76023);
    k.h(parame, "item");
    this.wCd = parame;
    ac.i(TAG, "LogStory: play fake video");
    parame = this.tbD;
    if (parame == null) {
      k.aVY("fakeLayer");
    }
    parame.setVisibility(0);
    parame = this.wCd;
    if (parame != null)
    {
      FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
      if (localFakeVideoViewLayer == null) {
        k.aVY("fakeLayer");
      }
      localFakeVideoViewLayer.setFakeVideoInfo(parame);
      setAlpha(0.0F);
      parame = this.wCc;
      if (parame == null) {
        k.aVY("imageVideoView");
      }
      parame.setCallback((StoryFakeVideoPlayView.a)new b(this));
      parame = this.wCc;
      if (parame == null) {
        k.aVY("imageVideoView");
      }
      parame.au(getImageList());
    }
    AppMethodBeat.o(76023);
  }
  
  public final void b(e parame)
  {
    AppMethodBeat.i(76024);
    ac.i(TAG, "resume");
    ac.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.wCc;
    if (localStoryFakeVideoPlayView == null) {
      k.aVY("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.wCr)
    {
      localStoryFakeVideoPlayView = this.wCc;
      if (localStoryFakeVideoPlayView == null) {
        k.aVY("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      parame = this.tbD;
      if (parame == null) {
        k.aVY("fakeLayer");
      }
      parame.pA(this.ftN);
      AppMethodBeat.o(76024);
      return;
    }
    if (parame != null) {
      a(parame);
    }
    AppMethodBeat.o(76024);
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(76025);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.wCc;
    if (localStoryFakeVideoPlayView == null) {
      k.aVY("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(76025);
    return i;
  }
  
  public final FakeVideoViewLayer getFakeLayer()
  {
    AppMethodBeat.i(76017);
    FakeVideoViewLayer localFakeVideoViewLayer = this.tbD;
    if (localFakeVideoViewLayer == null) {
      k.aVY("fakeLayer");
    }
    AppMethodBeat.o(76017);
    return localFakeVideoViewLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(76015);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.wCc;
    if (localStoryFakeVideoPlayView == null) {
      k.aVY("imageVideoView");
    }
    AppMethodBeat.o(76015);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(76019);
    ProgressBar localProgressBar = this.kWd;
    if (localProgressBar == null) {
      k.aVY("loading");
    }
    AppMethodBeat.o(76019);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(76022);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.wCc;
    if (localStoryFakeVideoPlayView == null) {
      k.aVY("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.wCn == StoryFakeVideoPlayView.c.wCv)
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
    ac.i(TAG, "onUIResume");
    b(this.wCd);
    AppMethodBeat.o(76027);
  }
  
  public final void setFakeLayer(FakeVideoViewLayer paramFakeVideoViewLayer)
  {
    AppMethodBeat.i(76018);
    k.h(paramFakeVideoViewLayer, "<set-?>");
    this.tbD = paramFakeVideoViewLayer;
    AppMethodBeat.o(76018);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(76016);
    k.h(paramStoryFakeVideoPlayView, "<set-?>");
    this.wCc = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(76016);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(76020);
    k.h(paramProgressBar, "<set-?>");
    this.kWd = paramProgressBar;
    AppMethodBeat.o(76020);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.ftN = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(76026);
    Object localObject = this.tbD;
    if (localObject == null) {
      k.aVY("fakeLayer");
    }
    ((FakeVideoViewLayer)localObject).dwz();
    localObject = this.wCc;
    if (localObject == null) {
      k.aVY("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(76026);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/recordvideo/ui/editor/ImageFakeVideoView$play$1", "Lcom/tencent/mm/plugin/recordvideo/ui/editor/StoryFakeVideoPlayView$Callback;", "onPrepared", "", "plugin-recordvideo_release"})
  public static final class b
    implements StoryFakeVideoPlayView.a
  {
    public final void rB()
    {
      AppMethodBeat.i(76014);
      this.wCf.post((Runnable)new a(this));
      AppMethodBeat.o(76014);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(d.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(76013);
        this.wCg.wCf.setAlpha(1.0F);
        this.wCg.wCf.getFakeLayer().pA(d.a(this.wCg.wCf));
        d.a locala = d.wCe;
        ac.i(d.access$getTAG$cp(), "imageVideoView onPrepared");
        AppMethodBeat.o(76013);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.ui.editor.d
 * JD-Core Version:    0.7.0.1
 */