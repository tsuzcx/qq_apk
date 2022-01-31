package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI
  extends MMActivity
{
  private long duration;
  private VideoView taQ;
  private String taR;
  private final int taS;
  private ak taT;
  
  public VideoRecorderPreviewUI()
  {
    AppMethodBeat.i(25636);
    this.taR = null;
    this.duration = -1L;
    this.taS = 3000;
    this.taT = new VideoRecorderPreviewUI.2(this);
    AppMethodBeat.o(25636);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(25641);
    af.h(af.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(25641);
  }
  
  public int getLayoutId()
  {
    return 2130971073;
  }
  
  public void initView()
  {
    AppMethodBeat.i(138617);
    this.taQ = ((VideoView)findViewById(2131828724));
    this.taQ.setOnErrorListener(new VideoRecorderPreviewUI.3(this));
    this.taQ.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(25633);
        ab.d("MicroMsg.VideoRecorderPreviewUI", g.Mk() + " onPrepared");
        ab.d("MicroMsg.VideoRecorderPreviewUI", g.Mk() + " onPrepared");
        paramAnonymousMediaPlayer = VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this);
        if ((paramAnonymousMediaPlayer.bIo != null) && (paramAnonymousMediaPlayer.wfQ)) {
          paramAnonymousMediaPlayer.bIo.start();
        }
        for (paramAnonymousMediaPlayer.bHF = false;; paramAnonymousMediaPlayer.bHF = true)
        {
          VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).sendEmptyMessageDelayed(0, 3000L);
          AppMethodBeat.o(25633);
          return;
        }
      }
    });
    findViewById(2131828723).setOnClickListener(new VideoRecorderPreviewUI.5(this));
    this.taQ.setOnCompletionListener(new VideoRecorderPreviewUI.6(this));
    if (this.taR != null)
    {
      this.taQ.stopPlayback();
      this.taQ.setVideoURI(this.taR);
    }
    AppMethodBeat.o(138617);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(25637);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.taR = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    setMMTitle(2131304531);
    setBackBtn(new VideoRecorderPreviewUI.1(this));
    initView();
    AppMethodBeat.o(25637);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(25640);
    super.onPause();
    if (this.taQ.isPlaying())
    {
      VideoView localVideoView = this.taQ;
      if ((localVideoView.bIo != null) && (localVideoView.wfQ) && (localVideoView.bIo.isPlaying())) {
        localVideoView.bIo.pause();
      }
      localVideoView.bHF = false;
    }
    finish();
    overridePendingTransition(0, 0);
    this.taT.removeMessages(0);
    AppMethodBeat.o(25640);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(25638);
    super.onStart();
    AppMethodBeat.o(25638);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI
 * JD-Core Version:    0.7.0.1
 */