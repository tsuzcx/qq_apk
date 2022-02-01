package com.tencent.mm.plugin.story.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h.a;
import com.tencent.mm.pluginsdk.ui.tools.h.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import d.g.b.k;
import d.l;

@a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"})
public final class StoryPreviewUI
  extends MMActivity
{
  private final String TAG;
  private VideoPlayerTextureView uOi;
  private final b zDt;
  
  public StoryPreviewUI()
  {
    AppMethodBeat.i(119645);
    this.TAG = "MicroMsg.StoryPreviewUI";
    this.zDt = new b(this);
    AppMethodBeat.o(119645);
  }
  
  public final int getLayoutId()
  {
    return 2131495715;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(119643);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    if (d.kZ(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      paramBundle = getIntent().getStringExtra("video_path");
      Object localObject = findViewById(2131305486);
      k.g(localObject, "findViewById(R.id.story_preview_play_view)");
      this.uOi = ((VideoPlayerTextureView)localObject);
      localObject = this.uOi;
      if (localObject == null) {
        k.aVY("videoPlayView");
      }
      ((VideoPlayerTextureView)localObject).setVideoPath(paramBundle);
      paramBundle = this.uOi;
      if (paramBundle == null) {
        k.aVY("videoPlayView");
      }
      paramBundle.setVideoCallback((h.a)this.zDt);
      paramBundle = this.uOi;
      if (paramBundle == null) {
        k.aVY("videoPlayView");
      }
      paramBundle.setAlpha(0.0F);
      findViewById(2131305485).setOnClickListener((View.OnClickListener)new StoryPreviewUI.a(this));
      AppMethodBeat.o(119643);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(119644);
    super.onDestroy();
    VideoPlayerTextureView localVideoPlayerTextureView = this.uOi;
    if (localVideoPlayerTextureView == null) {
      k.aVY("videoPlayView");
    }
    localVideoPlayerTextureView.stop();
    AppMethodBeat.o(119644);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/pluginsdk/ui/tools/IVideoView$IVideoCallback;", "onCompletion", "", "onError", "what", "", "extra", "onGetVideoSize", "width", "height", "onPlayTime", "playTime", "videoTime", "onPrepared", "plugin-story_release"})
  public static final class b
    implements h.a
  {
    public final void dZ(int paramInt1, int paramInt2) {}
    
    public final int eP(int paramInt1, int paramInt2)
    {
      return 0;
    }
    
    public final void onCompletion()
    {
      AppMethodBeat.i(119642);
      StoryPreviewUI.a(this.zDu).d(0.0D, true);
      AppMethodBeat.o(119642);
    }
    
    public final void onError(int paramInt1, int paramInt2) {}
    
    public final void rB()
    {
      AppMethodBeat.i(119641);
      StoryPreviewUI.a(this.zDu).setOneTimeVideoTextureUpdateCallback((h.e)new a(this));
      StoryPreviewUI.a(this.zDu).start();
      AppMethodBeat.o(119641);
    }
    
    @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "onTextureUpdate"})
    static final class a
      implements h.e
    {
      a(StoryPreviewUI.b paramb) {}
      
      public final void bli()
      {
        AppMethodBeat.i(119640);
        StoryPreviewUI.a(this.zDv.zDu).setVisibility(0);
        StoryPreviewUI.a(this.zDv.zDu).setAlpha(1.0F);
        AppMethodBeat.o(119640);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryPreviewUI
 * JD-Core Version:    0.7.0.1
 */