package com.tencent.mm.plugin.sysvideo.ui.video;

import android.app.Activity;
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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI
  extends MMActivity
{
  private VideoView Bme;
  private String Bmf;
  private final int Bmg;
  private ap Bmh;
  private long duration;
  
  public VideoRecorderPreviewUI()
  {
    AppMethodBeat.i(29325);
    this.Bmf = null;
    this.duration = -1L;
    this.Bmg = 3000;
    this.Bmh = new ap()
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
    al.n(al.a(getWindow(), null), getBodyView());
    ((ViewGroup)getBodyView().getParent()).removeView(getBodyView());
    ((ViewGroup)getWindow().getDecorView()).addView(getBodyView(), 0);
    AppMethodBeat.o(29330);
  }
  
  public int getLayoutId()
  {
    return 2131495839;
  }
  
  public void initView()
  {
    AppMethodBeat.i(29328);
    this.Bme = ((VideoView)findViewById(2131306383));
    this.Bme.setOnErrorListener(new MediaPlayer.OnErrorListener()
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(29321);
        VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this).stopPlayback();
        h.l(VideoRecorderPreviewUI.this, 2131764692, 2131764690);
        AppMethodBeat.o(29321);
        return false;
      }
    });
    this.Bme.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29322);
        ad.d("MicroMsg.VideoRecorderPreviewUI", f.abh() + " onPrepared");
        ad.d("MicroMsg.VideoRecorderPreviewUI", f.abh() + " onPrepared");
        paramAnonymousMediaPlayer = VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this);
        if ((paramAnonymousMediaPlayer.lqh != null) && (paramAnonymousMediaPlayer.lsA)) {
          paramAnonymousMediaPlayer.lqh.start();
        }
        for (paramAnonymousMediaPlayer.cuH = false;; paramAnonymousMediaPlayer.cuH = true)
        {
          VideoRecorderPreviewUI.b(VideoRecorderPreviewUI.this).sendEmptyMessageDelayed(0, 3000L);
          AppMethodBeat.o(29322);
          return;
        }
      }
    });
    findViewById(2131306382).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(29323);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.Bme.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29324);
        VideoRecorderPreviewUI.this.finish();
        VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
        AppMethodBeat.o(29324);
      }
    });
    if (this.Bmf != null)
    {
      this.Bme.stopPlayback();
      this.Bme.setVideoURI(this.Bmf);
    }
    AppMethodBeat.o(29328);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29326);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.Bmf = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
    setMMTitle(2131764693);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(29319);
        VideoRecorderPreviewUI.this.finish();
        VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
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
    if (this.Bme.isPlaying())
    {
      VideoView localVideoView = this.Bme;
      if ((localVideoView.lqh != null) && (localVideoView.lsA) && (localVideoView.lqh.isPlaying())) {
        localVideoView.lqh.pause();
      }
      localVideoView.cuH = false;
    }
    finish();
    overridePendingTransition(0, 0);
    this.Bmh.removeMessages(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI
 * JD-Core Version:    0.7.0.1
 */