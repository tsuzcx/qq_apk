package com.tencent.mm.plugin.sysvideo.ui.video;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.AnimationHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI
  extends MMActivity
{
  private VideoView SLM;
  private String SLN;
  private final int SLO;
  private MMHandler SLP;
  private long duration;
  
  public VideoRecorderPreviewUI()
  {
    AppMethodBeat.i(29325);
    this.SLN = null;
    this.duration = -1L;
    this.SLO = 3000;
    this.SLP = new MMHandler()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(29320);
        VideoRecorderPreviewUI.this.getWindow().setFlags(1024, 1024);
        VideoRecorderPreviewUI.this.hideTitleView();
        AppMethodBeat.o(29320);
      }
    };
    AppMethodBeat.o(29325);
  }
  
  public void dealContentView(View paramView)
  {
    AppMethodBeat.i(29330);
    aw.y(aw.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29330);
  }
  
  public int getLayoutId()
  {
    return R.i.goO;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29328);
    this.SLM = ((VideoView)findViewById(R.h.gbJ));
    this.SLM.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(29321);
        VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this).jEx();
        k.s(VideoRecorderPreviewUI.this, R.l.video_play_faile, R.l.video_play_err);
        AppMethodBeat.o(29321);
        return false;
      }
    });
    this.SLM.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29322);
        Log.d("MicroMsg.VideoRecorderPreviewUI", f.aPW() + " onPrepared");
        Log.d("MicroMsg.VideoRecorderPreviewUI", f.aPW() + " onPrepared");
        paramAnonymousMediaPlayer = VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this);
        if ((paramAnonymousMediaPlayer.sFf != null) && (paramAnonymousMediaPlayer.sIt)) {
          paramAnonymousMediaPlayer.sFf.start();
        }
        for (paramAnonymousMediaPlayer.eDv = false;; paramAnonymousMediaPlayer.eDv = true)
        {
          VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).sendEmptyMessageDelayed(0, 3000L);
          AppMethodBeat.o(29322);
          return;
        }
      }
    });
    findViewById(R.h.gbI).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29323);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).removeMessages(0);
        if (VideoRecorderPreviewUI.this.isTitleShowing())
        {
          VideoRecorderPreviewUI.this.getWindow().setFlags(1024, 1024);
          VideoRecorderPreviewUI.this.hideTitleView();
        }
        for (;;)
        {
          a.a(this, "com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(29323);
          return;
          VideoRecorderPreviewUI.this.getWindow().clearFlags(1024);
          VideoRecorderPreviewUI.this.showTitleView();
          VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).removeMessages(0);
          VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).sendEmptyMessageDelayed(0, 3000L);
        }
      }
    });
    this.SLM.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29324);
        VideoRecorderPreviewUI.this.finish();
        BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderPreviewUI.this, 0, 0);
        AppMethodBeat.o(29324);
      }
    });
    if (this.SLN != null)
    {
      this.SLM.jEx();
      this.SLM.setVideoURI(this.SLN);
    }
    AppMethodBeat.o(29328);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29326);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.SLN = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    setMMTitle(R.l.video_preview_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29319);
        VideoRecorderPreviewUI.this.finish();
        BackwardSupportUtil.AnimationHelper.overridePendingTransition(VideoRecorderPreviewUI.this, 0, 0);
        AppMethodBeat.o(29319);
        return true;
      }
    });
    initView();
    AppMethodBeat.o(29326);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(29329);
    super.onPause();
    if (this.SLM.isPlaying())
    {
      VideoView localVideoView = this.SLM;
      if ((localVideoView.sFf != null) && (localVideoView.sIt) && (localVideoView.sFf.isPlaying())) {
        localVideoView.sFf.pause();
      }
      localVideoView.eDv = false;
    }
    finish();
    BackwardSupportUtil.AnimationHelper.overridePendingTransition(this, 0, 0);
    this.SLP.removeMessages(0);
    AppMethodBeat.o(29329);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(29327);
    super.onStart();
    AppMethodBeat.o(29327);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI
 * JD-Core Version:    0.7.0.1
 */