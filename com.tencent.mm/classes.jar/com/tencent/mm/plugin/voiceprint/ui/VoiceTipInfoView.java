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
import com.tencent.mm.sdk.platformtools.ad;

public class VoiceTipInfoView
  extends LinearLayout
{
  public ProgressBar ixl;
  TextView kEu;
  TextView uDc;
  boolean zeY;
  private boolean zeZ;
  private TextView zfa;
  private boolean zfb;
  private float zfc;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.zeY = false;
    this.zeZ = false;
    this.zfb = false;
    this.zfc = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495874, this, true);
    this.ixl = ((ProgressBar)paramContext.findViewById(2131301489));
    cQI();
    this.kEu = ((TextView)paramContext.findViewById(2131306514));
    this.uDc = ((TextView)paramContext.findViewById(2131306516));
    this.zfa = ((TextView)paramContext.findViewById(2131306515));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void cQH()
  {
    AppMethodBeat.i(29912);
    ad.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.ixl.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void cQI()
  {
    AppMethodBeat.i(29913);
    ad.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.ixl.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void dRF()
  {
    AppMethodBeat.i(29918);
    ad.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.kEu.getVisibility()), Boolean.valueOf(this.zeY) });
    if (((this.kEu.getVisibility() == 4) || (this.kEu.getVisibility() == 8)) && (!this.zeY))
    {
      this.kEu.clearAnimation();
      this.zeY = true;
      a.b(this.kEu, getContext(), new a.a()
      {
        public final void dRw() {}
        
        public final void dRx()
        {
          AppMethodBeat.i(29906);
          VoiceTipInfoView.a(VoiceTipInfoView.this).setVisibility(0);
          VoiceTipInfoView.b(VoiceTipInfoView.this);
          AppMethodBeat.o(29906);
        }
      });
      AppMethodBeat.o(29918);
      return;
    }
    ad.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.kEu.clearAnimation();
    this.kEu.setVisibility(0);
    this.kEu.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void dRG()
  {
    AppMethodBeat.i(29919);
    this.uDc.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void dRH()
  {
    AppMethodBeat.i(29920);
    if ((this.zfa.getVisibility() == 4) && (!this.zfb))
    {
      this.zfa.clearAnimation();
      this.zfb = true;
      TextView localTextView = this.zfa;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void dRw() {}
        
        public final void dRx()
        {
          AppMethodBeat.i(29908);
          VoiceTipInfoView.c(VoiceTipInfoView.this).setVisibility(0);
          VoiceTipInfoView.d(VoiceTipInfoView.this);
          AppMethodBeat.o(29908);
        }
      });
      AppMethodBeat.o(29920);
      return;
    }
    this.zfa.clearAnimation();
    this.zfa.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void dRI()
  {
    AppMethodBeat.i(29921);
    if ((this.zfa.getVisibility() == 0) && (!this.zfb))
    {
      this.zfa.clearAnimation();
      this.zfb = true;
      a.a(this.zfa, getContext(), new a.a()
      {
        public final void dRw() {}
        
        public final void dRx()
        {
          AppMethodBeat.i(29909);
          VoiceTipInfoView.c(VoiceTipInfoView.this).setVisibility(4);
          VoiceTipInfoView.d(VoiceTipInfoView.this);
          AppMethodBeat.o(29909);
        }
      });
      AppMethodBeat.o(29921);
      return;
    }
    this.zfa.clearAnimation();
    this.zfa.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.uDc.setTextSize(0, getContext().getResources().getDimension(2131166993));
    this.zfc = this.uDc.getTextSize();
    this.uDc.clearAnimation();
    ad.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.zfc) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.zfa.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.zfa.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.uDc.setText(paramInt);
    this.uDc.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.uDc.setText(paramString);
    this.uDc.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.kEu.setText(paramInt);
    this.kEu.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.kEu.setText(paramString);
    this.kEu.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */