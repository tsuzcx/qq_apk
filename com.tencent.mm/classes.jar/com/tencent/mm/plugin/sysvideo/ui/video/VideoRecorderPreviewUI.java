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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.video.VideoView;

public class VideoRecorderPreviewUI
  extends MMActivity
{
  private VideoView BDD;
  private String BDE;
  private final int BDF;
  private aq BDG;
  private long duration;
  
  public VideoRecorderPreviewUI()
  {
    AppMethodBeat.i(29325);
    this.BDE = null;
    this.duration = -1L;
    this.BDF = 3000;
    this.BDG = new aq()
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
    this.BDD = ((VideoView)findViewById(2131306383));
    this.BDD.setOnErrorListener(new MediaPlayer.OnErrorListener()
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
    this.BDD.setOnPreparedListener(new MediaPlayer.OnPreparedListener()
    {
      public final void onPrepared(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29322);
        ae.d("MicroMsg.VideoRecorderPreviewUI", f.abq() + " onPrepared");
        ae.d("MicroMsg.VideoRecorderPreviewUI", f.abq() + " onPrepared");
        paramAnonymousMediaPlayer = VideoRecorderPreviewUI.a(VideoRecorderPreviewUI.this);
        if ((paramAnonymousMediaPlayer.luF != null) && (paramAnonymousMediaPlayer.lwZ)) {
          paramAnonymousMediaPlayer.luF.start();
        }
        for (paramAnonymousMediaPlayer.cvk = false;; paramAnonymousMediaPlayer.cvk = true)
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
        a.b("com/tencent/mm/plugin/sysvideo/ui/video/VideoRecorderPreviewUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.BDD.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(29324);
        VideoRecorderPreviewUI.this.finish();
        VideoRecorderPreviewUI.this.overridePendingTransition(0, 0);
        AppMethodBeat.o(29324);
      }
    });
    if (this.BDE != null)
    {
      this.BDD.stopPlayback();
      this.BDD.setVideoURI(this.BDE);
    }
    AppMethodBeat.o(29328);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(29326);
    super.onCreate(paramBundle);
    getWindow().setFlags(1024, 1024);
    hideTitleView();
    this.BDE = getIntent().getStringExtra("VideoRecorder_VideoFullPath");
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
    if (this.BDD.isPlaying())
    {
      VideoView localVideoView = this.BDD;
      if ((localVideoView.luF != null) && (localVideoView.lwZ) && (localVideoView.luF.isPlaying())) {
        localVideoView.luF.pause();
      }
      localVideoView.cvk = false;
    }
    finish();
    overridePendingTransition(0, 0);
    this.BDG.removeMessages(0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sysvideo.ui.video.VideoRecorderPreviewUI
 * JD-Core Version:    0.7.0.1
 */