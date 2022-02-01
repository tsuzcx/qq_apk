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
import com.tencent.mm.sdk.platformtools.ac;

public class VoiceTipInfoView
  extends LinearLayout
{
  boolean AxE;
  private boolean AxF;
  private TextView AxG;
  private boolean AxH;
  private float AxI;
  public ProgressBar iXo;
  TextView lfN;
  TextView vLT;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.AxE = false;
    this.AxF = false;
    this.AxH = false;
    this.AxI = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495874, this, true);
    this.iXo = ((ProgressBar)paramContext.findViewById(2131301489));
    der();
    this.lfN = ((TextView)paramContext.findViewById(2131306514));
    this.vLT = ((TextView)paramContext.findViewById(2131306516));
    this.AxG = ((TextView)paramContext.findViewById(2131306515));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void der()
  {
    AppMethodBeat.i(29913);
    ac.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.iXo.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void egP()
  {
    AppMethodBeat.i(29912);
    ac.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.iXo.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void egQ()
  {
    AppMethodBeat.i(29918);
    ac.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.lfN.getVisibility()), Boolean.valueOf(this.AxE) });
    if (((this.lfN.getVisibility() == 4) || (this.lfN.getVisibility() == 8)) && (!this.AxE))
    {
      this.lfN.clearAnimation();
      this.AxE = true;
      a.b(this.lfN, getContext(), new a.a()
      {
        public final void egG() {}
        
        public final void egH()
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
    ac.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.lfN.clearAnimation();
    this.lfN.setVisibility(0);
    this.lfN.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void egR()
  {
    AppMethodBeat.i(29919);
    this.vLT.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void egS()
  {
    AppMethodBeat.i(29920);
    if ((this.AxG.getVisibility() == 4) && (!this.AxH))
    {
      this.AxG.clearAnimation();
      this.AxH = true;
      TextView localTextView = this.AxG;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void egG() {}
        
        public final void egH()
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
    this.AxG.clearAnimation();
    this.AxG.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void egT()
  {
    AppMethodBeat.i(29921);
    if ((this.AxG.getVisibility() == 0) && (!this.AxH))
    {
      this.AxG.clearAnimation();
      this.AxH = true;
      a.a(this.AxG, getContext(), new a.a()
      {
        public final void egG() {}
        
        public final void egH()
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
    this.AxG.clearAnimation();
    this.AxG.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.vLT.setTextSize(0, getContext().getResources().getDimension(2131166993));
    this.AxI = this.vLT.getTextSize();
    this.vLT.clearAnimation();
    ac.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.AxI) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.AxG.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.AxG.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.vLT.setText(paramInt);
    this.vLT.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.vLT.setText(paramString);
    this.vLT.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.lfN.setText(paramInt);
    this.lfN.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.lfN.setText(paramString);
    this.lfN.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */