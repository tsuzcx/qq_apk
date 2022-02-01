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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int DVr = -1;
  private ImageView DVp;
  private a DVq;
  public aw lpR;
  private ImageView lwg;
  private ImageView lwj;
  private FrameLayout lwk;
  private ImageView lwl;
  public aw lwr;
  public boolean lws;
  protected RelativeLayout plo;
  
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
  
  private void bpm()
  {
    AppMethodBeat.i(110262);
    if (this.lws)
    {
      this.lwg.setImageResource(2131690269);
      this.lwg.setVisibility(8);
      this.DVp.setVisibility(0);
      AppMethodBeat.o(110262);
      return;
    }
    this.DVp.setVisibility(8);
    this.lwg.setVisibility(0);
    this.lwg.setImageResource(2131232467);
    AppMethodBeat.o(110262);
  }
  
  private void bpp()
  {
    AppMethodBeat.i(110268);
    if (this.lws) {}
    for (float f = getResources().getDimensionPixelSize(2131166392);; f = getResources().getDimensionPixelSize(2131166390))
    {
      this.lvV.setTextSize(0, f);
      this.lvW.setTextSize(0, f);
      AppMethodBeat.o(110268);
      return;
    }
  }
  
  private void bpq()
  {
    AppMethodBeat.i(110269);
    ViewGroup.LayoutParams localLayoutParams = this.plo.getLayoutParams();
    if (this.lws) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131166391);; localLayoutParams.height = getResources().getDimensionPixelSize(2131166389))
    {
      this.plo.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(110269);
      return;
    }
  }
  
  private void eQq()
  {
    AppMethodBeat.i(110256);
    if (!this.lws)
    {
      if (this.duq)
      {
        this.lvU.setImageResource(2131232464);
        AppMethodBeat.o(110256);
        return;
      }
      this.lvU.setImageResource(2131232469);
      AppMethodBeat.o(110256);
      return;
    }
    if (this.duq)
    {
      this.lvU.setImageResource(2131232464);
      AppMethodBeat.o(110256);
      return;
    }
    this.lvU.setImageResource(2131232469);
    AppMethodBeat.o(110256);
  }
  
  public final void adg()
  {
    AppMethodBeat.i(110257);
    this.lwl.setImageResource(2131232472);
    AppMethodBeat.o(110257);
  }
  
  public final void bTU()
  {
    AppMethodBeat.i(110263);
    if (this.lwr != null) {
      this.lwr.stopTimer();
    }
    AppMethodBeat.o(110263);
  }
  
  public final void blp()
  {
    AppMethodBeat.i(110266);
    this.lws = false;
    bpn();
    AppMethodBeat.o(110266);
  }
  
  public final void bnY()
  {
    AppMethodBeat.i(110264);
    if (this.lwr != null)
    {
      this.lwr.stopTimer();
      this.lwr.ay(2000L, 2000L);
    }
    AppMethodBeat.o(110264);
  }
  
  public final void bpn()
  {
    AppMethodBeat.i(110267);
    bpq();
    bpm();
    eQq();
    bpp();
    AppMethodBeat.o(110267);
  }
  
  public final boolean bpr()
  {
    AppMethodBeat.i(110270);
    if (this.DVq == null)
    {
      ae.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(110270);
      return false;
    }
    int k = this.DVq.bnD();
    int m = this.DVq.bnE();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(110270);
      return false;
    }
    int j = this.lwk.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(110270);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lwj.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + DVr);
      this.lwj.setLayoutParams(localLayoutParams);
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
  
  public final void eQr()
  {
    AppMethodBeat.i(110258);
    this.lwl.setImageResource(2131232468);
    AppMethodBeat.o(110258);
  }
  
  public final void eur()
  {
    AppMethodBeat.i(110271);
    this.lvU.setVisibility(8);
    AppMethodBeat.o(110271);
  }
  
  public final void eus()
  {
    AppMethodBeat.i(110272);
    this.lvU.setVisibility(0);
    AppMethodBeat.o(110272);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(110255);
    int i = this.lvT.getWidth();
    AppMethodBeat.o(110255);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.DVp;
  }
  
  public int getLayoutId()
  {
    return 2131494227;
  }
  
  public final void init()
  {
    AppMethodBeat.i(110253);
    super.init();
    this.lwg = ((ImageView)this.contentView.findViewById(2131300325));
    this.lwl = ((ImageView)this.contentView.findViewById(2131306482));
    this.lwj = ((ImageView)this.contentView.findViewById(2131303303));
    this.lwk = ((FrameLayout)this.contentView.findViewById(2131303306));
    this.plo = ((RelativeLayout)findViewById(2131304239));
    this.DVp = ((ImageView)this.contentView.findViewById(2131299599));
    if (DVr < 0) {
      DVr = getResources().getDimensionPixelSize(2131166393);
    }
    AppMethodBeat.o(110253);
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110260);
    this.lwg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110260);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110261);
    this.DVp.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110261);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(110254);
    this.duq = paramBoolean;
    eQq();
    AppMethodBeat.o(110254);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(110259);
    this.lwl.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(110259);
  }
  
  public void setStatePorter(a parama)
  {
    this.DVq = parama;
  }
  
  public final void tx(int paramInt)
  {
    AppMethodBeat.i(110273);
    seek((int)Math.ceil(this.DVq.eQs() * 1.0D / 1000.0D));
    AppMethodBeat.o(110273);
  }
  
  public final void va(boolean paramBoolean)
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
      eus();
    }
    for (;;)
    {
      if (this.lwr == null) {
        this.lwr = new aw(new aw.a()
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
      this.lwr.stopTimer();
      this.lwr.ay(2000L, 2000L);
      AppMethodBeat.o(110265);
      return;
      eur();
    }
  }
  
  public static abstract interface a
  {
    public abstract int bnD();
    
    public abstract int bnE();
    
    public abstract int eQs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */