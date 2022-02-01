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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int AIe = -1;
  private ImageView AIc;
  private a AId;
  public av krU;
  public av ktE;
  public boolean ktF;
  private ImageView ktt;
  private ImageView ktw;
  private FrameLayout ktx;
  private ImageView kty;
  protected RelativeLayout nXS;
  
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
  
  private void bdX()
  {
    AppMethodBeat.i(110262);
    if (this.ktF)
    {
      this.ktt.setImageResource(2131690269);
      this.ktt.setVisibility(8);
      this.AIc.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.AIc.setVisibility(8);
    this.ktt.setVisibility(0);
    this.ktt.setImageResource(2131232467);
    AppMethodBeat.o(110262);
  }
  
  private void bea()
  {
    AppMethodBeat.i(110268);
    if (this.ktF) {}
    for (float f = getResources().getDimensionPixelSize(2131166392);; f = getResources().getDimensionPixelSize(2131166390))
    {
      this.kti.setTextSize(0, f);
      this.ktj.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void beb()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.nXS.getLayoutParams();
    if (this.ktF) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131166391);; localLayoutParams.height = getResources().getDimensionPixelSize(2131166389))
    {
      this.nXS.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void eiu()
  {
    AppMethodBeat.i(110256);
    if (!this.ktF)
    {
      if (this.dkr)
      {
        this.kth.setImageResource(2131232464);
        AppMethodBeat.o(110256);
        return;
      }
      this.kth.setImageResource(2131232469);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.dkr)
    {
      this.kth.setImageResource(2131232464);
      AppMethodBeat.o(110256);
      return;
    }
    this.kth.setImageResource(2131232469);
    AppMethodBeat.o(110256);
  }
  
  public final void Zx()
  {
    AppMethodBeat.i(110257);
    this.kty.setImageResource(2131232472);
    AppMethodBeat.o(110257);
  }
  
  public final void bGT()
  {
    AppMethodBeat.i(110263);
    if (this.ktE != null) {
      this.ktE.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void bah()
  {
    AppMethodBeat.i(110266);
    this.ktF = false;
    bdY();
    AppMethodBeat.o(110266);
  }
  
  public final void bcH()
  {
    AppMethodBeat.i(110264);
    if (this.ktE != null)
    {
      this.ktE.stopTimer();
      this.ktE.av(2000L, 2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void bdY()
  {
    AppMethodBeat.i(110267);
    beb();
    bdX();
    eiu();
    bea();
    AppMethodBeat.o(110267);
  }
  
  public final boolean bec()
  {
    AppMethodBeat.i(110270);
    if (this.AId == null)
    {
      ad.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.AId.bcl();
    int m = this.AId.bcm();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.ktx.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.ktw.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + AIe);
      this.ktw.setLayoutParams(localLayoutParams);
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
  
  public final void dPU()
  {
    AppMethodBeat.i(110271);
    this.kth.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void dPV()
  {
    AppMethodBeat.i(110272);
    this.kth.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public final void eiv()
  {
    AppMethodBeat.i(110258);
    this.kty.setImageResource(2131232468);
    AppMethodBeat.o(110258);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.ktg.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.AIc;
  }
  
  public int getLayoutId()
  {
    return 2131494227;
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.ktt = ((ImageView)this.contentView.findViewById(2131300325));
    this.kty = ((ImageView)this.contentView.findViewById(2131306482));
    this.ktw = ((ImageView)this.contentView.findViewById(2131303303));
    this.ktx = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.nXS = ((RelativeLayout)findViewById(2131304239));
    this.AIc = ((ImageView)this.contentView.findViewById(2131299599));
    if (AIe < 0) {
      AIe = getResources().getDimensionPixelSize(2131166393);
    }
    AppMethodBeat.o(110253);
  }
  
  public final void sa(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.AId.eiw() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.ktt.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.AIc.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.dkr = paramBoolean;
    eiu();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.kty.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.AId = parama;
  }
  
  public final void td(boolean paramBoolean)
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
      dPV();
    }
    for (;;)
    {
      if (this.ktE == null) {
        this.ktE = new av(new av.a()
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
      this.ktE.stopTimer();
      this.ktE.av(2000L, 2000L);
      AppMethodBeat.o(110265);
      return;
      dPU();
    }
  }
  
  public static abstract interface a
  {
    public abstract int bcl();
    
    public abstract int bcm();
    
    public abstract int eiw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */