package com.tencent.mm.plugin.story.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.story.a.d;
import com.tencent.mm.plugin.story.a.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class StoryPreviewUI
  extends MMActivity
{
  private VideoPlayerTextureView KZh;
  private final a StP;
  private final String TAG;
  
  public StoryPreviewUI()
  {
    AppMethodBeat.i(119645);
    this.TAG = "MicroMsg.StoryPreviewUI";
    this.StP = new a(this);
    AppMethodBeat.o(119645);
  }
  
  private static final void a(StoryPreviewUI paramStoryPreviewUI, View paramView)
  {
    AppMethodBeat.i(367218);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramStoryPreviewUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/story/ui/StoryPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramStoryPreviewUI, "this$0");
    paramStoryPreviewUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/story/ui/StoryPreviewUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(367218);
  }
  
  public final int getLayoutId()
  {
    return a.e.SgW;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject = null;
    AppMethodBeat.i(119643);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    if (d.rb(19))
    {
      getWindow().setFlags(201327616, 201327616);
      String str = getIntent().getStringExtra("video_path");
      paramBundle = findViewById(a.d.SfX);
      s.s(paramBundle, "findViewById(R.id.story_preview_play_view)");
      this.KZh = ((VideoPlayerTextureView)paramBundle);
      VideoPlayerTextureView localVideoPlayerTextureView = this.KZh;
      paramBundle = localVideoPlayerTextureView;
      if (localVideoPlayerTextureView == null)
      {
        s.bIx("videoPlayView");
        paramBundle = null;
      }
      paramBundle.setVideoPath(str);
      paramBundle = this.KZh;
      if (paramBundle != null) {
        break label197;
      }
      s.bIx("videoPlayView");
      paramBundle = null;
      label125:
      paramBundle.setVideoCallback((i.a)this.StP);
      paramBundle = this.KZh;
      if (paramBundle != null) {
        break label200;
      }
      s.bIx("videoPlayView");
      paramBundle = localObject;
    }
    label197:
    label200:
    for (;;)
    {
      paramBundle.setAlpha(0.0F);
      findViewById(a.d.SfW).setOnClickListener(new StoryPreviewUI..ExternalSyntheticLambda0(this));
      AppMethodBeat.o(119643);
      return;
      getWindow().setFlags(1024, 1024);
      break;
      break label125;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119644);
    super.onDestroy();
    VideoPlayerTextureView localVideoPlayerTextureView2 = this.KZh;
    VideoPlayerTextureView localVideoPlayerTextureView1 = localVideoPlayerTextureView2;
    if (localVideoPlayerTextureView2 == null)
    {
      s.bIx("videoPlayView");
      localVideoPlayerTextureView1 = null;
    }
    localVideoPlayerTextureView1.stop();
    AppMethodBeat.o(119644);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements i.a
  {
    a(StoryPreviewUI paramStoryPreviewUI) {}
    
    private static final void b(StoryPreviewUI paramStoryPreviewUI)
    {
      Object localObject = null;
      AppMethodBeat.i(367255);
      s.u(paramStoryPreviewUI, "this$0");
      VideoPlayerTextureView localVideoPlayerTextureView2 = StoryPreviewUI.a(paramStoryPreviewUI);
      VideoPlayerTextureView localVideoPlayerTextureView1 = localVideoPlayerTextureView2;
      if (localVideoPlayerTextureView2 == null)
      {
        s.bIx("videoPlayView");
        localVideoPlayerTextureView1 = null;
      }
      localVideoPlayerTextureView1.setVisibility(0);
      paramStoryPreviewUI = StoryPreviewUI.a(paramStoryPreviewUI);
      if (paramStoryPreviewUI == null)
      {
        s.bIx("videoPlayView");
        paramStoryPreviewUI = localObject;
      }
      for (;;)
      {
        paramStoryPreviewUI.setAlpha(1.0F);
        AppMethodBeat.o(367255);
        return;
      }
    }
    
    public final void Qz()
    {
      Object localObject2 = null;
      AppMethodBeat.i(119641);
      VideoPlayerTextureView localVideoPlayerTextureView = StoryPreviewUI.a(this.StQ);
      Object localObject1 = localVideoPlayerTextureView;
      if (localVideoPlayerTextureView == null)
      {
        s.bIx("videoPlayView");
        localObject1 = null;
      }
      ((VideoPlayerTextureView)localObject1).setOneTimeVideoTextureUpdateCallback(new StoryPreviewUI.a..ExternalSyntheticLambda0(this.StQ));
      localObject1 = StoryPreviewUI.a(this.StQ);
      if (localObject1 == null)
      {
        s.bIx("videoPlayView");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((VideoPlayerTextureView)localObject1).start();
        AppMethodBeat.o(119641);
        return;
      }
    }
    
    public final void fG(int paramInt1, int paramInt2) {}
    
    public final int gw(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(119642);
      VideoPlayerTextureView localVideoPlayerTextureView2 = StoryPreviewUI.a(this.StQ);
      VideoPlayerTextureView localVideoPlayerTextureView1 = localVideoPlayerTextureView2;
      if (localVideoPlayerTextureView2 == null)
      {
        s.bIx("videoPlayView");
        localVideoPlayerTextureView1 = null;
      }
      localVideoPlayerTextureView1.c(0.0D, true);
      AppMethodBeat.o(119642);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryPreviewUI
 * JD-Core Version:    0.7.0.1
 */