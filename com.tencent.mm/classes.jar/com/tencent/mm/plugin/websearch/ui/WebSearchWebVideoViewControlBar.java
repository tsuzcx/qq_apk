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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int IGY = -1;
  private ImageView IGW;
  private a IGX;
  private ImageView mDc;
  private ImageView mDf;
  private FrameLayout mDg;
  private ImageView mDh;
  public MTimerHandler mDn;
  public boolean mDo;
  public MTimerHandler mww;
  protected RelativeLayout qAE;
  
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
  
  private void bKS()
  {
    AppMethodBeat.i(110262);
    if (this.mDo)
    {
      this.mDc.setImageResource(2131690365);
      this.mDc.setVisibility(8);
      this.IGW.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.IGW.setVisibility(8);
    this.mDc.setVisibility(0);
    this.mDc.setImageResource(2131232849);
    AppMethodBeat.o(110262);
  }
  
  private void bKV()
  {
    AppMethodBeat.i(110268);
    if (this.mDo) {}
    for (float f = getResources().getDimensionPixelSize(2131166484);; f = getResources().getDimensionPixelSize(2131166482))
    {
      this.mCQ.setTextSize(0, f);
      this.mCR.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void bKW()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.qAE.getLayoutParams();
    if (this.mDo) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131166483);; localLayoutParams.height = getResources().getDimensionPixelSize(2131166481))
    {
      this.qAE.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void fYM()
  {
    AppMethodBeat.i(110256);
    if (!this.mDo)
    {
      if (this.dLB)
      {
        this.mCP.setImageResource(2131232846);
        AppMethodBeat.o(110256);
        return;
      }
      this.mCP.setImageResource(2131232851);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.dLB)
    {
      this.mCP.setImageResource(2131232846);
      AppMethodBeat.o(110256);
      return;
    }
    this.mCP.setImageResource(2131232851);
    AppMethodBeat.o(110256);
  }
  
  public final void ard()
  {
    AppMethodBeat.i(110257);
    this.mDh.setImageResource(2131232854);
    AppMethodBeat.o(110257);
  }
  
  public final void bGL()
  {
    AppMethodBeat.i(110266);
    this.mDo = false;
    bKT();
    AppMethodBeat.o(110266);
  }
  
  public final void bJB()
  {
    AppMethodBeat.i(110264);
    if (this.mDn != null)
    {
      this.mDn.stopTimer();
      this.mDn.startTimer(2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(110267);
    bKW();
    bKS();
    fYM();
    bKV();
    AppMethodBeat.o(110267);
  }
  
  public final boolean bKX()
  {
    AppMethodBeat.i(110270);
    if (this.IGX == null)
    {
      Log.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.IGX.bJh();
    int m = this.IGX.bJi();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.mDg.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mDf.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + IGY);
      this.mDf.setLayoutParams(localLayoutParams);
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
  
  public final void crH()
  {
    AppMethodBeat.i(110263);
    if (this.mDn != null) {
      this.mDn.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void fYN()
  {
    AppMethodBeat.i(110258);
    this.mDh.setImageResource(2131232850);
    AppMethodBeat.o(110258);
  }
  
  public final void fzM()
  {
    AppMethodBeat.i(110271);
    this.mCP.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void fzN()
  {
    AppMethodBeat.i(110272);
    this.mCP.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.mCO.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.IGW;
  }
  
  public int getLayoutId()
  {
    return 2131494783;
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.mDc = ((ImageView)this.contentView.findViewById(2131301826));
    this.mDh = ((ImageView)this.contentView.findViewById(2131309941));
    this.mDf = ((ImageView)this.contentView.findViewById(2131305976));
    this.mDg = ((FrameLayout)this.contentView.findViewById(2131305979));
    this.qAE = ((RelativeLayout)findViewById(2131307157));
    this.IGW = ((ImageView)this.contentView.findViewById(2131300227));
    if (IGY < 0) {
      IGY = getResources().getDimensionPixelSize(2131166485);
    }
    AppMethodBeat.o(110253);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.mDc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.IGW.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.dLB = paramBoolean;
    fYM();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.mDh.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.IGX = parama;
  }
  
  public final void xv(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.IGX.fYO() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public final void yQ(boolean paramBoolean)
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
      fzN();
    }
    for (;;)
    {
      if (this.mDn == null) {
        this.mDn = new MTimerHandler(new MTimerHandler.CallBack()
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
      this.mDn.stopTimer();
      this.mDn.startTimer(2000L);
      AppMethodBeat.o(110265);
      return;
      fzM();
    }
  }
  
  public static abstract interface a
  {
    public abstract int bJh();
    
    public abstract int bJi();
    
    public abstract int fYO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */