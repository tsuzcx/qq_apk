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
import com.tencent.mm.plugin.websearch.a.c;
import com.tencent.mm.plugin.websearch.a.d;
import com.tencent.mm.plugin.websearch.a.e;
import com.tencent.mm.plugin.websearch.a.f;
import com.tencent.mm.plugin.websearch.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int Wrx = -1;
  private ImageView Wrv;
  private a Wrw;
  public MTimerHandler sAc;
  private ImageView sHA;
  private ImageView sHD;
  private FrameLayout sHE;
  private ImageView sHF;
  public MTimerHandler sHL;
  public boolean sHM;
  protected RelativeLayout xcV;
  
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
  
  private void cxf()
  {
    AppMethodBeat.i(110262);
    if (this.sHM)
    {
      this.sHA.setImageResource(a.g.fts_web_video_fullscreen_op_fullscreen_btn);
      this.sHA.setVisibility(8);
      this.Wrv.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.Wrv.setVisibility(8);
    this.sHA.setVisibility(0);
    this.sHA.setImageResource(a.d.fts_video_fullscreen_op_btn);
    AppMethodBeat.o(110262);
  }
  
  private void cxi()
  {
    AppMethodBeat.i(110268);
    if (this.sHM) {}
    for (float f = getResources().getDimensionPixelSize(a.c.fts_web_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.c.fts_web_video_control_bar_time_textsize))
    {
      this.sHq.setTextSize(0, f);
      this.sHr.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void cxj()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.xcV.getLayoutParams();
    if (this.sHM) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(a.c.fts_web_video_fullscreen_control_bar_height);; localLayoutParams.height = getResources().getDimensionPixelSize(a.c.fts_web_video_control_bar_height))
    {
      this.xcV.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void iqL()
  {
    AppMethodBeat.i(110256);
    if (!this.sHM)
    {
      if (this.hJg)
      {
        this.sHp.setImageResource(a.d.fts_pause_btn);
        AppMethodBeat.o(110256);
        return;
      }
      this.sHp.setImageResource(a.d.fts_video_play_btn);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.hJg)
    {
      this.sHp.setImageResource(a.d.fts_pause_btn);
      AppMethodBeat.o(110256);
      return;
    }
    this.sHp.setImageResource(a.d.fts_video_play_btn);
    AppMethodBeat.o(110256);
  }
  
  public final void Bh(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.Wrw.iqN() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public final void Iq(boolean paramBoolean)
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
      hOP();
    }
    for (;;)
    {
      if (this.sHL == null) {
        this.sHL = new MTimerHandler(new MTimerHandler.CallBack()
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
      this.sHL.stopTimer();
      this.sHL.startTimer(2000L);
      AppMethodBeat.o(110265);
      return;
      hOO();
    }
  }
  
  public final void aSd()
  {
    AppMethodBeat.i(110257);
    this.sHF.setImageResource(a.d.fts_video_unmute_op_btn);
    AppMethodBeat.o(110257);
  }
  
  public final void csz()
  {
    AppMethodBeat.i(110266);
    this.sHM = false;
    cxg();
    AppMethodBeat.o(110266);
  }
  
  public final void cvy()
  {
    AppMethodBeat.i(110264);
    if (this.sHL != null)
    {
      this.sHL.stopTimer();
      this.sHL.startTimer(2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void cxg()
  {
    AppMethodBeat.i(110267);
    cxj();
    cxf();
    iqL();
    cxi();
    AppMethodBeat.o(110267);
  }
  
  public final boolean cxk()
  {
    AppMethodBeat.i(110270);
    if (this.Wrw == null)
    {
      Log.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.Wrw.cvf();
    int m = this.Wrw.cvg();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.sHE.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.sHD.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + Wrx);
      this.sHD.setLayoutParams(localLayoutParams);
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
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.sHo.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.Wrv;
  }
  
  public int getLayoutId()
  {
    return a.f.fts_web_videoview_control_bar;
  }
  
  public final void hON()
  {
    AppMethodBeat.i(110263);
    if (this.sHL != null) {
      this.sHL.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void hOO()
  {
    AppMethodBeat.i(110271);
    this.sHp.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void hOP()
  {
    AppMethodBeat.i(110272);
    this.sHp.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.sHA = ((ImageView)this.contentView.findViewById(a.e.full_screen_btn));
    this.sHF = ((ImageView)this.contentView.findViewById(a.e.voice_btn));
    this.sHD = ((ImageView)this.contentView.findViewById(a.e.player_progress_bar_middle));
    this.sHE = ((FrameLayout)this.contentView.findViewById(a.e.player_progress_root));
    this.xcV = ((RelativeLayout)findViewById(a.e.root));
    this.Wrv = ((ImageView)this.contentView.findViewById(a.e.exit_fullscreen_btn));
    if (Wrx < 0) {
      Wrx = getResources().getDimensionPixelSize(a.c.fts_web_video_progress_bar_margin_right);
    }
    AppMethodBeat.o(110253);
  }
  
  public final void iqM()
  {
    AppMethodBeat.i(110258);
    this.sHF.setImageResource(a.d.fts_video_mute_op_btn);
    AppMethodBeat.o(110258);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.sHA.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.Wrv.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.hJg = paramBoolean;
    iqL();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.sHF.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.Wrw = parama;
  }
  
  public static abstract interface a
  {
    public abstract int cvf();
    
    public abstract int cvg();
    
    public abstract int iqN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */