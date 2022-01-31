package com.tencent.mm.plugin.voiceprint.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class VoiceTipInfoView
  extends LinearLayout
{
  public ProgressBar gJE;
  TextView iJG;
  TextView pBu;
  boolean tsO;
  private boolean tsP;
  private TextView tsQ;
  private boolean tsR;
  private float tsS;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(26227);
    this.tsO = false;
    this.tsP = false;
    this.tsR = false;
    this.tsS = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2130971104, this, true);
    this.gJE = ((ProgressBar)paramContext.findViewById(2131824014));
    bRO();
    this.iJG = ((TextView)paramContext.findViewById(2131828763));
    this.pBu = ((TextView)paramContext.findViewById(2131823889));
    this.tsQ = ((TextView)paramContext.findViewById(2131828806));
    reset();
    AppMethodBeat.o(26227);
  }
  
  public final void bRN()
  {
    AppMethodBeat.i(26229);
    ab.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.gJE.setVisibility(0);
    AppMethodBeat.o(26229);
  }
  
  public final void bRO()
  {
    AppMethodBeat.i(26230);
    ab.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.gJE.setVisibility(8);
    AppMethodBeat.o(26230);
  }
  
  public final void cLA()
  {
    AppMethodBeat.i(26238);
    if ((this.tsQ.getVisibility() == 0) && (!this.tsR))
    {
      this.tsQ.clearAnimation();
      this.tsR = true;
      a.a(this.tsQ, getContext(), new a.a()
      {
        public final void cLo() {}
        
        public final void cLp()
        {
          AppMethodBeat.i(26226);
          VoiceTipInfoView.c(VoiceTipInfoView.this).setVisibility(4);
          VoiceTipInfoView.d(VoiceTipInfoView.this);
          AppMethodBeat.o(26226);
        }
      });
      AppMethodBeat.o(26238);
      return;
    }
    this.tsQ.clearAnimation();
    this.tsQ.setVisibility(4);
    AppMethodBeat.o(26238);
  }
  
  public final void cLx()
  {
    AppMethodBeat.i(26235);
    ab.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.iJG.getVisibility()), Boolean.valueOf(this.tsO) });
    if (((this.iJG.getVisibility() == 4) || (this.iJG.getVisibility() == 8)) && (!this.tsO))
    {
      this.iJG.clearAnimation();
      this.tsO = true;
      a.b(this.iJG, getContext(), new VoiceTipInfoView.2(this));
      AppMethodBeat.o(26235);
      return;
    }
    ab.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.iJG.clearAnimation();
    this.iJG.setVisibility(0);
    this.iJG.invalidate();
    AppMethodBeat.o(26235);
  }
  
  public final void cLy()
  {
    AppMethodBeat.i(26236);
    this.pBu.setVisibility(8);
    AppMethodBeat.o(26236);
  }
  
  public final void cLz()
  {
    AppMethodBeat.i(26237);
    if ((this.tsQ.getVisibility() == 4) && (!this.tsR))
    {
      this.tsQ.clearAnimation();
      this.tsR = true;
      TextView localTextView = this.tsQ;
      getContext();
      a.b(localTextView, new VoiceTipInfoView.4(this));
      AppMethodBeat.o(26237);
      return;
    }
    this.tsQ.clearAnimation();
    this.tsQ.setVisibility(0);
    AppMethodBeat.o(26237);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(26228);
    this.pBu.setTextSize(0, getContext().getResources().getDimension(2131428816));
    this.tsS = this.pBu.getTextSize();
    this.pBu.clearAnimation();
    ab.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.tsS) });
    AppMethodBeat.o(26228);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(26240);
    this.tsQ.setText(paramInt);
    AppMethodBeat.o(26240);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(26239);
    this.tsQ.setText(paramString);
    AppMethodBeat.o(26239);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(26232);
    this.pBu.setText(paramInt);
    this.pBu.setVisibility(0);
    AppMethodBeat.o(26232);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(26231);
    this.pBu.setText(paramString);
    this.pBu.setVisibility(0);
    AppMethodBeat.o(26231);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(26234);
    this.iJG.setText(paramInt);
    this.iJG.setVisibility(0);
    AppMethodBeat.o(26234);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(26233);
    this.iJG.setText(paramString);
    this.iJG.setVisibility(0);
    AppMethodBeat.o(26233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */