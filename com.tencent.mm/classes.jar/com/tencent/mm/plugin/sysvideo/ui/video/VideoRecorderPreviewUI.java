package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI
  extends MMActivity
{
  private long duration = -1L;
  private VideoView pzd;
  private String pze = null;
  private final int pzf = 3000;
  private ah pzg = new VideoRecorderPreviewUI.2(this);
  
  protected final void dealContentView(View paramView)
  {
    ak.g(ak.a(getWindow(), null), this.mController.uMz);
    ((ViewGroup)this.mController.uMz.getParent()).removeView(this.mController.uMz);
    ((ViewGroup)getWindow().getDecorView()).addView(this.mController.uMz, 0);
  }
  
  protected final int getLayoutId()
  {
    return R.i.video_recorder_preview;
  }
  
  protected final void initView()
  {
    this.pzd = ((VideoView)findViewById(R.h.video_recorder_play_view));
    this.pzd.setOnErrorListener(new VideoRecorderPreviewUI.3(this));
    this.pzd.setOnPreparedListener(new VideoRecorderPreviewUI.4(this));
    findViewById(R.h.video_recorder_play_area).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).removeMessages(0);
        if (VideoRecorderPreviewUI.this.mController.isTitleShowing())
        {
          VideoRecorderPreviewUI.this.getWindow().setFlags(1024, 1024);
          VideoRecorderPreviewUI.this.mController.hideTitleView();
          return;
        }
        VideoRecorderPreviewUI.this.getWindow().clearFlags(1024);
        VideoRecorderPreviewUI.this.mController.showTitleView();
        VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).removeMessages(0);
        VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).sendEmptyMessageDelayed(0, 3000L);
      }
    });
    this.pzd.setOnCompletionListener(new VideoRecorderPreviewUI.6(this));
    if (this.pze != null)
    {
      this.pzd.stopPlayback();
      this.pzd.setVideoURI(this.pze);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    this.mController.hideTitleView();
    this.pze = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    setMMTitle(R.l.video_preview_title);
    setBackBtn(new VideoRecorderPreviewUI.1(this));
    initView();
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.pzd.isPlaying())
    {
      VideoView localVideoView = this.pzd;
      if ((localVideoView.gHZ != null) && (localVideoView.snv) && (localVideoView.gHZ.isPlaying())) {
        localVideoView.gHZ.pause();
      }
      localVideoView.gHF = false;
    }
    finish();
    overridePendingTransition(0, 0);
    this.pzg.removeMessages(0);
  }
  
  public void onStart()
  {
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI
 * JD-Core Version:    0.7.0.1
 */