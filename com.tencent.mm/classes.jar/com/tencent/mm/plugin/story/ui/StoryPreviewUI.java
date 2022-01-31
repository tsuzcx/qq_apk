package com.tencent.mm.plugin.story.ui;

import a.f.b.j;
import a.l;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.story.proxy.StoryAudioManagerProxy;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.e.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "videoCallBack", "com/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1", "Lcom/tencent/mm/plugin/story/ui/StoryPreviewUI$videoCallBack$1;", "videoPlayView", "Lcom/tencent/mm/pluginsdk/ui/tools/VideoPlayerTextureView;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-story_release"})
@a(3)
public final class StoryPreviewUI
  extends MMActivity
{
  private final String TAG;
  private VideoPlayerTextureView oKC;
  private final StoryPreviewUI.b sHJ;
  
  public StoryPreviewUI()
  {
    AppMethodBeat.i(110038);
    this.TAG = "MicroMsg.StoryPreviewUI";
    this.sHJ = new StoryPreviewUI.b(this);
    AppMethodBeat.o(110038);
  }
  
  public final int getLayoutId()
  {
    return 2130970970;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110036);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    if (d.fv(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      paramBundle = getIntent().getStringExtra("video_path");
      Object localObject = findViewById(2131828449);
      j.p(localObject, "findViewById(R.id.story_preview_play_view)");
      this.oKC = ((VideoPlayerTextureView)localObject);
      localObject = this.oKC;
      if (localObject == null) {
        j.ays("videoPlayView");
      }
      ((VideoPlayerTextureView)localObject).setVideoPath(paramBundle);
      paramBundle = this.oKC;
      if (paramBundle == null) {
        j.ays("videoPlayView");
      }
      paramBundle.setVideoCallback((e.a)this.sHJ);
      paramBundle = this.oKC;
      if (paramBundle == null) {
        j.ays("videoPlayView");
      }
      paramBundle.setAlpha(0.0F);
      findViewById(2131828450).setOnClickListener((View.OnClickListener)new StoryPreviewUI.a(this));
      AppMethodBeat.o(110036);
      return;
      getWindow().setFlags(1024, 1024);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(110037);
    super.onDestroy();
    Object localObject = this.oKC;
    if (localObject == null) {
      j.ays("videoPlayView");
    }
    ((VideoPlayerTextureView)localObject).stop();
    localObject = StoryAudioManagerProxy.sCO;
    StoryAudioManagerProxy.access$getInstance$cp().cancelAll();
    AppMethodBeat.o(110037);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.story.ui.StoryPreviewUI
 * JD-Core Version:    0.7.0.1
 */