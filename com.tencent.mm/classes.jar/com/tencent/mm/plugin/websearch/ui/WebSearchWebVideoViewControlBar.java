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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int Cav = -1;
  private ImageView Cat;
  private a Cau;
  public au kOQ;
  private ImageView kUI;
  private ImageView kUL;
  private FrameLayout kUM;
  private ImageView kUN;
  public au kUT;
  public boolean kUU;
  protected RelativeLayout oBn;
  
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
  
  private void bkR()
  {
    AppMethodBeat.i(110262);
    if (this.kUU)
    {
      this.kUI.setImageResource(2131690269);
      this.kUI.setVisibility(8);
      this.Cat.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.Cat.setVisibility(8);
    this.kUI.setVisibility(0);
    this.kUI.setImageResource(2131232467);
    AppMethodBeat.o(110262);
  }
  
  private void bkU()
  {
    AppMethodBeat.i(110268);
    if (this.kUU) {}
    for (float f = getResources().getDimensionPixelSize(2131166392);; f = getResources().getDimensionPixelSize(2131166390))
    {
      this.kUx.setTextSize(0, f);
      this.kUy.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void bkV()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.oBn.getLayoutParams();
    if (this.kUU) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131166391);; localLayoutParams.height = getResources().getDimensionPixelSize(2131166389))
    {
      this.oBn.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void exO()
  {
    AppMethodBeat.i(110256);
    if (!this.kUU)
    {
      if (this.dhM)
      {
        this.kUw.setImageResource(2131232464);
        AppMethodBeat.o(110256);
        return;
      }
      this.kUw.setImageResource(2131232469);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.dhM)
    {
      this.kUw.setImageResource(2131232464);
      AppMethodBeat.o(110256);
      return;
    }
    this.kUw.setImageResource(2131232469);
    AppMethodBeat.o(110256);
  }
  
  public final void aas()
  {
    AppMethodBeat.i(110257);
    this.kUN.setImageResource(2131232472);
    AppMethodBeat.o(110257);
  }
  
  public final void bOg()
  {
    AppMethodBeat.i(110263);
    if (this.kUT != null) {
      this.kUT.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void bha()
  {
    AppMethodBeat.i(110266);
    this.kUU = false;
    bkS();
    AppMethodBeat.o(110266);
  }
  
  public final void bjC()
  {
    AppMethodBeat.i(110264);
    if (this.kUT != null)
    {
      this.kUT.stopTimer();
      this.kUT.au(2000L, 2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void bkS()
  {
    AppMethodBeat.i(110267);
    bkV();
    bkR();
    exO();
    bkU();
    AppMethodBeat.o(110267);
  }
  
  public final boolean bkW()
  {
    AppMethodBeat.i(110270);
    if (this.Cau == null)
    {
      ac.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.Cau.bjh();
    int m = this.Cau.bji();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.kUM.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kUL.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + Cav);
      this.kUL.setLayoutParams(localLayoutParams);
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
  
  public final void eet()
  {
    AppMethodBeat.i(110271);
    this.kUw.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void eeu()
  {
    AppMethodBeat.i(110272);
    this.kUw.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public final void exP()
  {
    AppMethodBeat.i(110258);
    this.kUN.setImageResource(2131232468);
    AppMethodBeat.o(110258);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.kUv.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.Cat;
  }
  
  public int getLayoutId()
  {
    return 2131494227;
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.kUI = ((ImageView)this.contentView.findViewById(2131300325));
    this.kUN = ((ImageView)this.contentView.findViewById(2131306482));
    this.kUL = ((ImageView)this.contentView.findViewById(2131303303));
    this.kUM = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.oBn = ((RelativeLayout)findViewById(2131304239));
    this.Cat = ((ImageView)this.contentView.findViewById(2131299599));
    if (Cav < 0) {
      Cav = getResources().getDimensionPixelSize(2131166393);
    }
    AppMethodBeat.o(110253);
  }
  
  public final void sQ(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.Cau.exQ() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.kUI.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.Cat.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.dhM = paramBoolean;
    exO();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.kUN.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.Cau = parama;
  }
  
  public final void ue(boolean paramBoolean)
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
      eeu();
    }
    for (;;)
    {
      if (this.kUT == null) {
        this.kUT = new au(new au.a()
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
      this.kUT.stopTimer();
      this.kUT.au(2000L, 2000L);
      AppMethodBeat.o(110265);
      return;
      eet();
    }
  }
  
  public static abstract interface a
  {
    public abstract int bjh();
    
    public abstract int bji();
    
    public abstract int exQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */