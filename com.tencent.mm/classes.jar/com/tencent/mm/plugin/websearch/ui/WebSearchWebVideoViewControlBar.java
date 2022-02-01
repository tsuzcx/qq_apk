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
  private static int DDt = -1;
  private ImageView DDr;
  private a DDs;
  public av llt;
  private ImageView lrG;
  private ImageView lrJ;
  private FrameLayout lrK;
  private ImageView lrL;
  public av lrR;
  public boolean lrS;
  protected RelativeLayout peI;
  
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
  
  private void boC()
  {
    AppMethodBeat.i(110262);
    if (this.lrS)
    {
      this.lrG.setImageResource(2131690269);
      this.lrG.setVisibility(8);
      this.DDr.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.DDr.setVisibility(8);
    this.lrG.setVisibility(0);
    this.lrG.setImageResource(2131232467);
    AppMethodBeat.o(110262);
  }
  
  private void boF()
  {
    AppMethodBeat.i(110268);
    if (this.lrS) {}
    for (float f = getResources().getDimensionPixelSize(2131166392);; f = getResources().getDimensionPixelSize(2131166390))
    {
      this.lrv.setTextSize(0, f);
      this.lrw.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void boG()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.peI.getLayoutParams();
    if (this.lrS) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131166391);; localLayoutParams.height = getResources().getDimensionPixelSize(2131166389))
    {
      this.peI.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void eMF()
  {
    AppMethodBeat.i(110256);
    if (!this.lrS)
    {
      if (this.dtk)
      {
        this.lru.setImageResource(2131232464);
        AppMethodBeat.o(110256);
        return;
      }
      this.lru.setImageResource(2131232469);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.dtk)
    {
      this.lru.setImageResource(2131232464);
      AppMethodBeat.o(110256);
      return;
    }
    this.lru.setImageResource(2131232469);
    AppMethodBeat.o(110256);
  }
  
  public final void acU()
  {
    AppMethodBeat.i(110257);
    this.lrL.setImageResource(2131232472);
    AppMethodBeat.o(110257);
  }
  
  public final void bSH()
  {
    AppMethodBeat.i(110263);
    if (this.lrR != null) {
      this.lrR.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void bkF()
  {
    AppMethodBeat.i(110266);
    this.lrS = false;
    boD();
    AppMethodBeat.o(110266);
  }
  
  public final void bno()
  {
    AppMethodBeat.i(110264);
    if (this.lrR != null)
    {
      this.lrR.stopTimer();
      this.lrR.az(2000L, 2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void boD()
  {
    AppMethodBeat.i(110267);
    boG();
    boC();
    eMF();
    boF();
    AppMethodBeat.o(110267);
  }
  
  public final boolean boH()
  {
    AppMethodBeat.i(110270);
    if (this.DDs == null)
    {
      ad.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.DDs.bmT();
    int m = this.DDs.bmU();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.lrK.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lrJ.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + DDt);
      this.lrJ.setLayoutParams(localLayoutParams);
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
  
  public final void eMG()
  {
    AppMethodBeat.i(110258);
    this.lrL.setImageResource(2131232468);
    AppMethodBeat.o(110258);
  }
  
  public final void eqK()
  {
    AppMethodBeat.i(110271);
    this.lru.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void eqL()
  {
    AppMethodBeat.i(110272);
    this.lru.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.lrt.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.DDr;
  }
  
  public int getLayoutId()
  {
    return 2131494227;
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.lrG = ((ImageView)this.contentView.findViewById(2131300325));
    this.lrL = ((ImageView)this.contentView.findViewById(2131306482));
    this.lrJ = ((ImageView)this.contentView.findViewById(2131303303));
    this.lrK = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.peI = ((RelativeLayout)findViewById(2131304239));
    this.DDr = ((ImageView)this.contentView.findViewById(2131299599));
    if (DDt < 0) {
      DDt = getResources().getDimensionPixelSize(2131166393);
    }
    AppMethodBeat.o(110253);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.lrG.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.DDr.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.dtk = paramBoolean;
    eMF();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.lrL.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.DDs = parama;
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.DDs.eMH() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public final void uS(boolean paramBoolean)
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
      eqL();
    }
    for (;;)
    {
      if (this.lrR == null) {
        this.lrR = new av(new av.a()
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
      this.lrR.stopTimer();
      this.lrR.az(2000L, 2000L);
      AppMethodBeat.o(110265);
      return;
      eqK();
    }
  }
  
  public static abstract interface a
  {
    public abstract int bmT();
    
    public abstract int bmU();
    
    public abstract int eMH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */