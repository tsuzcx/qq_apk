package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.a.b;
import com.tencent.mm.plugin.websearch.a.c;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int PBm = -1;
  private ImageView PBk;
  private a PBl;
  public boolean pCA;
  private ImageView pCo;
  private ImageView pCr;
  private FrameLayout pCs;
  private ImageView pCt;
  public MTimerHandler pCz;
  public MTimerHandler puW;
  protected RelativeLayout tZE;
  
  public WebSearchWebVideoViewControlBar(Context paramContext)
  {
    super(paramContext);
  }
  
  public WebSearchWebVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WebSearchWebVideoViewControlBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void bWS()
  {
    AppMethodBeat.i(110262);
    if (this.pCA)
    {
      this.pCo.setImageResource(a.f.fts_web_video_fullscreen_op_fullscreen_btn);
      this.pCo.setVisibility(8);
      this.PBk.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.PBk.setVisibility(8);
    this.pCo.setVisibility(0);
    this.pCo.setImageResource(a.c.fts_video_fullscreen_op_btn);
    AppMethodBeat.o(110262);
  }
  
  private void bWV()
  {
    AppMethodBeat.i(110268);
    if (this.pCA) {}
    for (float f = getResources().getDimensionPixelSize(a.b.fts_web_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.b.fts_web_video_control_bar_time_textsize))
    {
      this.pCd.setTextSize(0, f);
      this.pCe.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void bWW()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.tZE.getLayoutParams();
    if (this.pCA) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(a.b.fts_web_video_fullscreen_control_bar_height);; localLayoutParams.height = getResources().getDimensionPixelSize(a.b.fts_web_video_control_bar_height))
    {
      this.tZE.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void gRx()
  {
    AppMethodBeat.i(110256);
    if (!this.pCA)
    {
      if (this.fEq)
      {
        this.pCc.setImageResource(a.c.fts_pause_btn);
        AppMethodBeat.o(110256);
        return;
      }
      this.pCc.setImageResource(a.c.fts_video_play_btn);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.fEq)
    {
      this.pCc.setImageResource(a.c.fts_pause_btn);
      AppMethodBeat.o(110256);
      return;
    }
    this.pCc.setImageResource(a.c.fts_video_play_btn);
    AppMethodBeat.o(110256);
  }
  
  public final void AS(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.PBl.gRz() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public final void CL(boolean paramBoolean)
  {
    AppMethodBeat.i(110265);
    if (getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      setVisibility(8);
      AppMethodBeat.o(110265);
      return;
    }
    setVisibility(0);
    if (!paramBoolean) {
      grO();
    }
    for (;;)
    {
      if (this.pCz == null) {
        this.pCz = new MTimerHandler(new MTimerHandler.CallBack()
        {
          public final boolean onTimerExpired()
          {
            AppMethodBeat.i(110251);
            WebSearchWebVideoViewControlBar.this.setVisibility(8);
            WebSearchWebVideoViewControlBar.a(WebSearchWebVideoViewControlBar.this).stopTimer();
            AppMethodBeat.o(110251);
            return false;
          }
        }, false);
      }
      this.pCz.stopTimer();
      this.pCz.startTimer(2000L);
      AppMethodBeat.o(110265);
      return;
      grN();
    }
  }
  
  public final void axB()
  {
    AppMethodBeat.i(110257);
    this.pCt.setImageResource(a.c.fts_video_unmute_op_btn);
    AppMethodBeat.o(110257);
  }
  
  public final void bSs()
  {
    AppMethodBeat.i(110266);
    this.pCA = false;
    bWT();
    AppMethodBeat.o(110266);
  }
  
  public final void bVi()
  {
    AppMethodBeat.i(110264);
    if (this.pCz != null)
    {
      this.pCz.stopTimer();
      this.pCz.startTimer(2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void bWT()
  {
    AppMethodBeat.i(110267);
    bWW();
    bWS();
    gRx();
    bWV();
    AppMethodBeat.o(110267);
  }
  
  public final boolean bWX()
  {
    AppMethodBeat.i(110270);
    if (this.PBl == null)
    {
      Log.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.PBl.bUQ();
    int m = this.PBl.bUR();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.pCs.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.pCr.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + PBm);
      this.pCr.setLayoutParams(localLayoutParams);
      if ((k < m) || (m == 0)) {
        break;
      }
      AppMethodBeat.o(110270);
      return false;
      i = 0;
    }
    AppMethodBeat.o(110270);
    return true;
  }
  
  public final void cEO()
  {
    AppMethodBeat.i(110263);
    if (this.pCz != null) {
      this.pCz.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void gRy()
  {
    AppMethodBeat.i(110258);
    this.pCt.setImageResource(a.c.fts_video_mute_op_btn);
    AppMethodBeat.o(110258);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.pCb.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.PBk;
  }
  
  public int getLayoutId()
  {
    return a.e.fts_web_videoview_control_bar;
  }
  
  public final void grN()
  {
    AppMethodBeat.i(110271);
    this.pCc.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void grO()
  {
    AppMethodBeat.i(110272);
    this.pCc.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.pCo = ((ImageView)this.contentView.findViewById(a.d.full_screen_btn));
    this.pCt = ((ImageView)this.contentView.findViewById(a.d.voice_btn));
    this.pCr = ((ImageView)this.contentView.findViewById(a.d.player_progress_bar_middle));
    this.pCs = ((FrameLayout)this.contentView.findViewById(a.d.player_progress_root));
    this.tZE = ((RelativeLayout)findViewById(a.d.root));
    this.PBk = ((ImageView)this.contentView.findViewById(a.d.exit_fullscreen_btn));
    if (PBm < 0) {
      PBm = getResources().getDimensionPixelSize(a.b.fts_web_video_progress_bar_margin_right);
    }
    AppMethodBeat.o(110253);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.pCo.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.PBk.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.fEq = paramBoolean;
    gRx();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.pCt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.PBl = parama;
  }
  
  public static abstract interface a
  {
    public abstract int bUQ();
    
    public abstract int bUR();
    
    public abstract int gRz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */