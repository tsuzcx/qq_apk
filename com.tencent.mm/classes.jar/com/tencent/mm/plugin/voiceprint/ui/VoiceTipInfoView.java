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
  boolean BWZ;
  private boolean BXa;
  private TextView BXb;
  private boolean BXc;
  private float BXd;
  public ProgressBar jqx;
  TextView lCL;
  TextView wTc;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.BWZ = false;
    this.BXa = false;
    this.BXc = false;
    this.BXd = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495874, this, true);
    this.jqx = ((ProgressBar)paramContext.findViewById(2131301489));
    dnP();
    this.lCL = ((TextView)paramContext.findViewById(2131306514));
    this.wTc = ((TextView)paramContext.findViewById(2131306516));
    this.BXb = ((TextView)paramContext.findViewById(2131306515));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void dnP()
  {
    AppMethodBeat.i(29913);
    ad.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.jqx.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void euA()
  {
    AppMethodBeat.i(29912);
    ad.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.jqx.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void euB()
  {
    AppMethodBeat.i(29918);
    ad.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.lCL.getVisibility()), Boolean.valueOf(this.BWZ) });
    if (((this.lCL.getVisibility() == 4) || (this.lCL.getVisibility() == 8)) && (!this.BWZ))
    {
      this.lCL.clearAnimation();
      this.BWZ = true;
      a.b(this.lCL, getContext(), new a.a()
      {
        public final void eur() {}
        
        public final void eus()
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
    this.lCL.clearAnimation();
    this.lCL.setVisibility(0);
    this.lCL.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void euC()
  {
    AppMethodBeat.i(29919);
    this.wTc.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void euD()
  {
    AppMethodBeat.i(29920);
    if ((this.BXb.getVisibility() == 4) && (!this.BXc))
    {
      this.BXb.clearAnimation();
      this.BXc = true;
      TextView localTextView = this.BXb;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void eur() {}
        
        public final void eus()
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
    this.BXb.clearAnimation();
    this.BXb.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void euE()
  {
    AppMethodBeat.i(29921);
    if ((this.BXb.getVisibility() == 0) && (!this.BXc))
    {
      this.BXb.clearAnimation();
      this.BXc = true;
      a.a(this.BXb, getContext(), new a.a()
      {
        public final void eur() {}
        
        public final void eus()
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
    this.BXb.clearAnimation();
    this.BXb.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.wTc.setTextSize(0, getContext().getResources().getDimension(2131166993));
    this.BXd = this.wTc.getTextSize();
    this.wTc.clearAnimation();
    ad.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.BXd) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.BXb.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.BXb.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.wTc.setText(paramInt);
    this.wTc.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.wTc.setText(paramString);
    this.wTc.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.lCL.setText(paramInt);
    this.lCL.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.lCL.setText(paramString);
    this.lCL.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */