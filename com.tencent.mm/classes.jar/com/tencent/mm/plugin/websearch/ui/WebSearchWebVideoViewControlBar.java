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
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int qWn = -1;
  private ImageView gDU;
  private ImageView gDX;
  private FrameLayout gDY;
  private ImageView gDZ;
  public am gEf;
  public am gEg;
  public boolean gEh;
  protected RelativeLayout qWk;
  private ImageView qWl;
  private WebSearchWebVideoViewControlBar.a qWm;
  
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
  
  private void caa()
  {
    if (!this.gEh)
    {
      if (this.bNU)
      {
        this.ofr.setImageResource(a.b.fts_pause_btn);
        return;
      }
      this.ofr.setImageResource(a.b.fts_video_play_btn);
      return;
    }
    if (this.bNU)
    {
      this.ofr.setImageResource(a.b.fts_pause_btn);
      return;
    }
    this.ofr.setImageResource(a.b.fts_video_play_btn);
  }
  
  public final void AU()
  {
    this.gDZ.setImageResource(a.b.fts_video_unmute_op_btn);
  }
  
  public final void aiZ()
  {
    this.gEh = false;
    akL();
  }
  
  public final void akG()
  {
    if (this.gEf != null)
    {
      this.gEf.stopTimer();
      this.gEf.S(2000L, 2000L);
    }
  }
  
  public final void akL()
  {
    ViewGroup.LayoutParams localLayoutParams = this.qWk.getLayoutParams();
    if (this.gEh)
    {
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.fts_web_video_fullscreen_control_bar_height);
      this.qWk.setLayoutParams(localLayoutParams);
      if (!this.gEh) {
        break label130;
      }
      this.gDU.setImageResource(a.e.fts_web_video_fullscreen_op_fullscreen_btn);
      this.gDU.setVisibility(8);
      this.qWl.setVisibility(0);
      label71:
      caa();
      if (!this.gEh) {
        break label160;
      }
    }
    label130:
    label160:
    for (float f = getResources().getDimensionPixelSize(a.a.fts_web_video_fullscreen_control_bar_time_textsize);; f = getResources().getDimensionPixelSize(a.a.fts_web_video_control_bar_time_textsize))
    {
      this.ofs.setTextSize(0, f);
      this.oft.setTextSize(0, f);
      return;
      localLayoutParams.height = getResources().getDimensionPixelSize(a.a.fts_web_video_control_bar_height);
      break;
      this.qWl.setVisibility(8);
      this.gDU.setVisibility(0);
      this.gDU.setImageResource(a.b.fts_video_fullscreen_op_btn);
      break label71;
    }
  }
  
  public final boolean akO()
  {
    if (this.qWm == null) {
      y.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
    }
    int k;
    int m;
    do
    {
      return false;
      k = this.qWm.akj();
      m = this.qWm.akk();
    } while ((k < 0) || (m < 0));
    int j = this.gDY.getWidth();
    if (j <= 0) {
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.gDX.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + qWn);
      this.gDX.setLayoutParams(localLayoutParams);
      if ((k >= m) && (m != 0)) {
        break;
      }
      return true;
      i = 0;
    }
  }
  
  public final void bOy()
  {
    if (this.gEf != null) {
      this.gEf.stopTimer();
    }
  }
  
  public final void bOz()
  {
    this.ofr.setVisibility(0);
  }
  
  public final void cab()
  {
    this.gDZ.setImageResource(a.b.fts_video_mute_op_btn);
  }
  
  public final void cac()
  {
    this.ofr.setVisibility(8);
  }
  
  protected int getBarPointWidth()
  {
    return this.ofq.getWidth();
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.qWl;
  }
  
  protected int getLayoutId()
  {
    return a.d.fts_web_videoview_control_bar;
  }
  
  protected final void init()
  {
    super.init();
    this.gDU = ((ImageView)this.contentView.findViewById(a.c.full_screen_btn));
    this.gDZ = ((ImageView)this.contentView.findViewById(a.c.voice_btn));
    this.gDX = ((ImageView)this.contentView.findViewById(a.c.player_progress_bar_middle));
    this.gDY = ((FrameLayout)this.contentView.findViewById(a.c.player_progress_root));
    this.qWk = ((RelativeLayout)findViewById(a.c.root));
    this.qWl = ((ImageView)this.contentView.findViewById(a.c.exit_fullscreen_btn));
    if (qWn < 0) {
      qWn = getResources().getDimensionPixelSize(a.a.fts_web_video_progress_bar_margin_right);
    }
  }
  
  public final void la(boolean paramBoolean)
  {
    if (getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      setVisibility(8);
      return;
    }
    setVisibility(0);
    if (!paramBoolean) {
      bOz();
    }
    for (;;)
    {
      if (this.gEf == null) {
        this.gEf = new am(new WebSearchWebVideoViewControlBar.1(this), false);
      }
      this.gEf.stopTimer();
      this.gEf.S(2000L, 2000L);
      return;
      cac();
    }
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gDU.setOnClickListener(paramOnClickListener);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.qWl.setOnClickListener(paramOnClickListener);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    this.bNU = paramBoolean;
    caa();
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gDZ.setOnClickListener(paramOnClickListener);
  }
  
  public void setStatePorter(WebSearchWebVideoViewControlBar.a parama)
  {
    this.qWm = parama;
  }
  
  public final void yg(int paramInt)
  {
    seek((int)Math.ceil(this.qWm.cad() * 1.0D / 1000.0D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */