package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView;
import com.tencent.mm.plugin.story.image2video.StoryFakeVideoPlayView.a;
import com.tencent.mm.plugin.story.model.d.i;
import com.tencent.mm.protocal.protobuf.chf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.Collection;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryImageVideoView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "fakeLayer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "getFakeLayer", "()Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;", "setFakeLayer", "(Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewFakeLayer;)V", "imageVideoView", "Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;", "getImageVideoView", "()Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;", "setImageVideoView", "(Lcom/tencent/mm/plugin/story/image2video/StoryFakeVideoPlayView;)V", "isMute", "", "loading", "Landroid/widget/ProgressBar;", "getLoading", "()Landroid/widget/ProgressBar;", "setLoading", "(Landroid/widget/ProgressBar;)V", "videoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "checkResumeLocalVideo", "getCurPos", "", "getImageList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "hideLoading", "", "initView", "isPlaying", "isShowLoading", "onUIResume", "pause", "play", "item", "sessionId", "resume", "storyVideoItem", "setMute", "mute", "showLoading", "stop", "Companion", "plugin-story_release"})
public final class n
  extends RelativeLayout
{
  private static final String TAG = "MicroMsg.Story.StoryImageVideoView";
  public static final n.a sUi;
  private boolean efg;
  public ProgressBar mEy;
  public StoryFakeVideoPlayView sUg;
  public StoryVideoViewFakeLayer sUh;
  private i syr;
  
  static
  {
    AppMethodBeat.i(151331);
    sUi = new n.a((byte)0);
    TAG = "MicroMsg.Story.StoryImageVideoView";
    AppMethodBeat.o(151331);
  }
  
  public n(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(151330);
    LayoutInflater.from(getContext()).inflate(2130970960, (ViewGroup)this);
    paramContext = findViewById(2131828424);
    j.p(paramContext, "findViewById(R.id.imagevideoview)");
    this.sUg = ((StoryFakeVideoPlayView)paramContext);
    paramContext = findViewById(2131828425);
    j.p(paramContext, "findViewById(R.id.fakelayer)");
    this.sUh = ((StoryVideoViewFakeLayer)paramContext);
    paramContext = findViewById(2131821842);
    j.p(paramContext, "findViewById(R.id.video_loading)");
    this.mEy = ((ProgressBar)paramContext);
    AppMethodBeat.o(151330);
  }
  
  private final ArrayList<String> getImageList()
  {
    AppMethodBeat.i(151323);
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.syr;
    if (localObject != null)
    {
      localObject = ((i)localObject).syD;
      if (localObject != null)
      {
        localObject = ((chf)localObject).xSi;
        if (localObject != null) {
          localArrayList.addAll((Collection)localObject);
        }
      }
    }
    AppMethodBeat.o(151323);
    return localArrayList;
  }
  
  public final void alp()
  {
    AppMethodBeat.i(151329);
    ab.i(TAG, "onUIResume");
    g(this.syr);
    AppMethodBeat.o(151329);
  }
  
  public final void f(i parami)
  {
    AppMethodBeat.i(151325);
    j.q(parami, "item");
    this.syr = parami;
    ab.i(TAG, "LogStory: play fake video");
    StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
    if (localStoryVideoViewFakeLayer == null) {
      j.ays("fakeLayer");
    }
    localStoryVideoViewFakeLayer.setVisibility(0);
    parami = parami.syD;
    if (parami != null)
    {
      localStoryVideoViewFakeLayer = this.sUh;
      if (localStoryVideoViewFakeLayer == null) {
        j.ays("fakeLayer");
      }
      localStoryVideoViewFakeLayer.setFakeVideoInfo(parami);
      setAlpha(0.0F);
      parami = this.sUg;
      if (parami == null) {
        j.ays("imageVideoView");
      }
      parami.setCallback((StoryFakeVideoPlayView.a)new n.b(this));
      parami = this.sUg;
      if (parami == null) {
        j.ays("imageVideoView");
      }
      parami.T(getImageList());
    }
    AppMethodBeat.o(151325);
  }
  
  public final void g(i parami)
  {
    AppMethodBeat.i(151326);
    ab.i(TAG, "resume");
    ab.i(TAG, "checkResumeLocalVideo");
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.sUg;
    if (localStoryFakeVideoPlayView == null) {
      j.ays("imageVideoView");
    }
    if (localStoryFakeVideoPlayView.sty)
    {
      localStoryFakeVideoPlayView = this.sUg;
      if (localStoryFakeVideoPlayView == null) {
        j.ays("imageVideoView");
      }
      localStoryFakeVideoPlayView.resume();
    }
    for (int i = 1; i != 0; i = 0)
    {
      parami = this.sUh;
      if (parami == null) {
        j.ays("fakeLayer");
      }
      parami.mu(this.efg);
      AppMethodBeat.o(151326);
      return;
    }
    if (parami != null) {
      f(parami);
    }
    AppMethodBeat.o(151326);
  }
  
  public final int getCurPos()
  {
    AppMethodBeat.i(151327);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.sUg;
    if (localStoryFakeVideoPlayView == null) {
      j.ays("imageVideoView");
    }
    int i = localStoryFakeVideoPlayView.getCurPos();
    AppMethodBeat.o(151327);
    return i;
  }
  
  public final StoryVideoViewFakeLayer getFakeLayer()
  {
    AppMethodBeat.i(151319);
    StoryVideoViewFakeLayer localStoryVideoViewFakeLayer = this.sUh;
    if (localStoryVideoViewFakeLayer == null) {
      j.ays("fakeLayer");
    }
    AppMethodBeat.o(151319);
    return localStoryVideoViewFakeLayer;
  }
  
  public final StoryFakeVideoPlayView getImageVideoView()
  {
    AppMethodBeat.i(151317);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.sUg;
    if (localStoryFakeVideoPlayView == null) {
      j.ays("imageVideoView");
    }
    AppMethodBeat.o(151317);
    return localStoryFakeVideoPlayView;
  }
  
  public final ProgressBar getLoading()
  {
    AppMethodBeat.i(151321);
    ProgressBar localProgressBar = this.mEy;
    if (localProgressBar == null) {
      j.ays("loading");
    }
    AppMethodBeat.o(151321);
    return localProgressBar;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(151324);
    StoryFakeVideoPlayView localStoryFakeVideoPlayView = this.sUg;
    if (localStoryFakeVideoPlayView == null) {
      j.ays("imageVideoView");
    }
    boolean bool = localStoryFakeVideoPlayView.isPlaying();
    AppMethodBeat.o(151324);
    return bool;
  }
  
  public final void setFakeLayer(StoryVideoViewFakeLayer paramStoryVideoViewFakeLayer)
  {
    AppMethodBeat.i(151320);
    j.q(paramStoryVideoViewFakeLayer, "<set-?>");
    this.sUh = paramStoryVideoViewFakeLayer;
    AppMethodBeat.o(151320);
  }
  
  public final void setImageVideoView(StoryFakeVideoPlayView paramStoryFakeVideoPlayView)
  {
    AppMethodBeat.i(151318);
    j.q(paramStoryFakeVideoPlayView, "<set-?>");
    this.sUg = paramStoryFakeVideoPlayView;
    AppMethodBeat.o(151318);
  }
  
  public final void setLoading(ProgressBar paramProgressBar)
  {
    AppMethodBeat.i(151322);
    j.q(paramProgressBar, "<set-?>");
    this.mEy = paramProgressBar;
    AppMethodBeat.o(151322);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    this.efg = paramBoolean;
  }
  
  public final void stop()
  {
    AppMethodBeat.i(151328);
    Object localObject = this.sUh;
    if (localObject == null) {
      j.ays("fakeLayer");
    }
    ((StoryVideoViewFakeLayer)localObject).cGx();
    localObject = this.sUg;
    if (localObject == null) {
      j.ays("imageVideoView");
    }
    ((StoryFakeVideoPlayView)localObject).stop();
    AppMethodBeat.o(151328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.view.gallery.n
 * JD-Core Version:    0.7.0.1
 */