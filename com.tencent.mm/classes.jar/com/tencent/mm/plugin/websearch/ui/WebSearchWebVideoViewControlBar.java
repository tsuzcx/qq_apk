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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;

public class WebSearchWebVideoViewControlBar
  extends WebSearchVideoPlayerSeekBar
{
  private static int uLy = -1;
  private ImageView icZ;
  private ImageView idc;
  private FrameLayout idd;
  private ImageView ide;
  public ap idk;
  public ap idl;
  public boolean idm;
  protected RelativeLayout kRz;
  private ImageView uLw;
  private WebSearchWebVideoViewControlBar.a uLx;
  
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
  
  private void aFl()
  {
    AppMethodBeat.i(73847);
    if (this.idm)
    {
      this.icZ.setImageResource(2131231387);
      this.icZ.setVisibility(8);
      this.uLw.setVisibility(0);
      AppMethodBeat.o(73847);
      return;
    }
    this.uLw.setVisibility(8);
    this.icZ.setVisibility(0);
    this.icZ.setImageResource(2130838938);
    AppMethodBeat.o(73847);
  }
  
  private void aFt()
  {
    AppMethodBeat.i(73853);
    if (this.idm) {}
    for (float f = getResources().getDimensionPixelSize(2131428433);; f = getResources().getDimensionPixelSize(2131428431))
    {
      this.qTG.setTextSize(0, f);
      this.qTH.setTextSize(0, f);
      AppMethodBeat.o(73853);
      return;
    }
  }
  
  private void aFu()
  {
    AppMethodBeat.i(73854);
    ViewGroup.LayoutParams localLayoutParams = this.kRz.getLayoutParams();
    if (this.idm) {}
    for (localLayoutParams.height = getResources().getDimensionPixelSize(2131428432);; localLayoutParams.height = getResources().getDimensionPixelSize(2131428430))
    {
      this.kRz.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(73854);
      return;
    }
  }
  
  private void cZX()
  {
    AppMethodBeat.i(73841);
    if (!this.idm)
    {
      if (this.cvm)
      {
        this.qTF.setImageResource(2130838926);
        AppMethodBeat.o(73841);
        return;
      }
      this.qTF.setImageResource(2130838940);
      AppMethodBeat.o(73841);
      return;
    }
    if (this.cvm)
    {
      this.qTF.setImageResource(2130838926);
      AppMethodBeat.o(73841);
      return;
    }
    this.qTF.setImageResource(2130838940);
    AppMethodBeat.o(73841);
  }
  
  public final void Ef(int paramInt)
  {
    AppMethodBeat.i(73858);
    seek((int)Math.ceil(this.uLx.cZZ() * 1.0D / 1000.0D));
    AppMethodBeat.o(73858);
  }
  
  public final void NK()
  {
    AppMethodBeat.i(73842);
    this.ide.setImageResource(2130838943);
    AppMethodBeat.o(73842);
  }
  
  public final void aDh()
  {
    AppMethodBeat.i(73851);
    this.idm = false;
    aFr();
    AppMethodBeat.o(73851);
  }
  
  public final void aFn()
  {
    AppMethodBeat.i(73849);
    if (this.idk != null)
    {
      this.idk.stopTimer();
      this.idk.ag(2000L, 2000L);
    }
    AppMethodBeat.o(73849);
  }
  
  public final void aFr()
  {
    AppMethodBeat.i(73852);
    aFu();
    aFl();
    cZX();
    aFt();
    AppMethodBeat.o(73852);
  }
  
  public final boolean aFx()
  {
    AppMethodBeat.i(73855);
    if (this.uLx == null)
    {
      ab.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
      AppMethodBeat.o(73855);
      return false;
    }
    int k = this.uLx.aEV();
    int m = this.uLx.aEW();
    if ((k < 0) || (m < 0))
    {
      AppMethodBeat.o(73855);
      return false;
    }
    int j = this.idd.getWidth();
    if (j <= 0)
    {
      AppMethodBeat.o(73855);
      return true;
    }
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.idc.getLayoutParams();
    int i = j;
    if (m != 0) {
      i = (int)(j * (1.0F - k / m));
    }
    if (i > 0) {}
    for (;;)
    {
      localLayoutParams.rightMargin = (i + uLy);
      this.idc.setLayoutParams(localLayoutParams);
      if ((k < m) || (m == 0)) {
        break;
      }
      AppMethodBeat.o(73855);
      return false;
      i = 0;
    }
    AppMethodBeat.o(73855);
    return true;
  }
  
  public final void baj()
  {
    AppMethodBeat.i(73848);
    if (this.idk != null) {
      this.idk.stopTimer();
    }
    AppMethodBeat.o(73848);
  }
  
  public final void cKo()
  {
    AppMethodBeat.i(73856);
    this.qTF.setVisibility(8);
    AppMethodBeat.o(73856);
  }
  
  public final void cKp()
  {
    AppMethodBeat.i(73857);
    this.qTF.setVisibility(0);
    AppMethodBeat.o(73857);
  }
  
  public final void cZY()
  {
    AppMethodBeat.i(73843);
    this.ide.setImageResource(2130838939);
    AppMethodBeat.o(73843);
  }
  
  public int getBarPointWidth()
  {
    AppMethodBeat.i(73840);
    int i = this.qTE.getWidth();
    AppMethodBeat.o(73840);
    return i;
  }
  
  protected ImageView getExitFullscreenIv()
  {
    return this.uLw;
  }
  
  public int getLayoutId()
  {
    return 2130969681;
  }
  
  public final void init()
  {
    AppMethodBeat.i(73838);
    super.init();
    this.icZ = ((ImageView)this.contentView.findViewById(2131821468));
    this.ide = ((ImageView)this.contentView.findViewById(2131824414));
    this.idc = ((ImageView)this.contentView.findViewById(2131821462));
    this.idd = ((FrameLayout)this.contentView.findViewById(2131821460));
    this.kRz = ((RelativeLayout)findViewById(2131821003));
    this.uLw = ((ImageView)this.contentView.findViewById(2131821456));
    if (uLy < 0) {
      uLy = getResources().getDimensionPixelSize(2131428434);
    }
    AppMethodBeat.o(73838);
  }
  
  public final void oj(boolean paramBoolean)
  {
    AppMethodBeat.i(73850);
    if (getVisibility() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      setVisibility(8);
      AppMethodBeat.o(73850);
      return;
    }
    setVisibility(0);
    if (!paramBoolean) {
      cKp();
    }
    for (;;)
    {
      if (this.idk == null) {
        this.idk = new ap(new WebSearchWebVideoViewControlBar.1(this), false);
      }
      this.idk.stopTimer();
      this.idk.ag(2000L, 2000L);
      AppMethodBeat.o(73850);
      return;
      cKo();
    }
  }
  
  public void setEnterFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73845);
    this.icZ.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73845);
  }
  
  public void setExitFullScreenBtnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73846);
    this.uLw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73846);
  }
  
  public void setIsPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(73839);
    this.cvm = paramBoolean;
    cZX();
    AppMethodBeat.o(73839);
  }
  
  public void setMuteBtnOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(73844);
    this.ide.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(73844);
  }
  
  public void setStatePorter(WebSearchWebVideoViewControlBar.a parama)
  {
    this.uLx = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar
 * JD-Core Version:    0.7.0.1
 */