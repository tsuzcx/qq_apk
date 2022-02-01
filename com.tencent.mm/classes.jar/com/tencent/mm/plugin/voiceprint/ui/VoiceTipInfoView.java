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
import com.tencent.mm.sdk.platformtools.ae;

public class VoiceTipInfoView
  extends LinearLayout
{
  boolean CoA;
  private boolean CoB;
  private TextView CoC;
  private boolean CoD;
  private float CoE;
  public ProgressBar jtq;
  TextView lHk;
  TextView xiT;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.CoA = false;
    this.CoB = false;
    this.CoD = false;
    this.CoE = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495874, this, true);
    this.jtq = ((ProgressBar)paramContext.findViewById(2131301489));
    dqN();
    this.lHk = ((TextView)paramContext.findViewById(2131306514));
    this.xiT = ((TextView)paramContext.findViewById(2131306516));
    this.CoC = ((TextView)paramContext.findViewById(2131306515));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void dqN()
  {
    AppMethodBeat.i(29913);
    ae.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.jtq.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void eyg()
  {
    AppMethodBeat.i(29912);
    ae.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.jtq.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void eyh()
  {
    AppMethodBeat.i(29918);
    ae.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.lHk.getVisibility()), Boolean.valueOf(this.CoA) });
    if (((this.lHk.getVisibility() == 4) || (this.lHk.getVisibility() == 8)) && (!this.CoA))
    {
      this.lHk.clearAnimation();
      this.CoA = true;
      a.b(this.lHk, getContext(), new a.a()
      {
        public final void exX() {}
        
        public final void exY()
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
    ae.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.lHk.clearAnimation();
    this.lHk.setVisibility(0);
    this.lHk.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void eyi()
  {
    AppMethodBeat.i(29919);
    this.xiT.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void eyj()
  {
    AppMethodBeat.i(29920);
    if ((this.CoC.getVisibility() == 4) && (!this.CoD))
    {
      this.CoC.clearAnimation();
      this.CoD = true;
      TextView localTextView = this.CoC;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void exX() {}
        
        public final void exY()
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
    this.CoC.clearAnimation();
    this.CoC.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void eyk()
  {
    AppMethodBeat.i(29921);
    if ((this.CoC.getVisibility() == 0) && (!this.CoD))
    {
      this.CoC.clearAnimation();
      this.CoD = true;
      a.a(this.CoC, getContext(), new a.a()
      {
        public final void exX() {}
        
        public final void exY()
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
    this.CoC.clearAnimation();
    this.CoC.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.xiT.setTextSize(0, getContext().getResources().getDimension(2131166993));
    this.CoE = this.xiT.getTextSize();
    this.xiT.clearAnimation();
    ae.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.CoE) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.CoC.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.CoC.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.xiT.setText(paramInt);
    this.xiT.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.xiT.setText(paramString);
    this.xiT.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.lHk.setText(paramInt);
    this.lHk.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.lHk.setText(paramString);
    this.lHk.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */