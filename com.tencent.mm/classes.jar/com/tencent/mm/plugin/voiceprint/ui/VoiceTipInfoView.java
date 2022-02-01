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
import com.tencent.mm.sdk.platformtools.Log;

public class VoiceTipInfoView
  extends LinearLayout
{
  TextView BgP;
  private boolean GSA;
  private float GSB;
  boolean GSx;
  private boolean GSy;
  private TextView GSz;
  public ProgressBar krF;
  TextView mPa;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.GSx = false;
    this.GSy = false;
    this.GSA = false;
    this.GSB = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496854, this, true);
    this.krF = ((ProgressBar)paramContext.findViewById(2131303688));
    ekF();
    this.mPa = ((TextView)paramContext.findViewById(2131309974));
    this.BgP = ((TextView)paramContext.findViewById(2131309976));
    this.GSz = ((TextView)paramContext.findViewById(2131309975));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void ekF()
  {
    AppMethodBeat.i(29913);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.krF.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void fEU()
  {
    AppMethodBeat.i(29912);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.krF.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void fEV()
  {
    AppMethodBeat.i(29918);
    Log.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.mPa.getVisibility()), Boolean.valueOf(this.GSx) });
    if (((this.mPa.getVisibility() == 4) || (this.mPa.getVisibility() == 8)) && (!this.GSx))
    {
      this.mPa.clearAnimation();
      this.GSx = true;
      a.b(this.mPa, getContext(), new a.a()
      {
        public final void fEL() {}
        
        public final void fEM()
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
    Log.d("MicroMsg.VoiceTipInfoView", "showTitle, directly set to VISIBLE");
    this.mPa.clearAnimation();
    this.mPa.setVisibility(0);
    this.mPa.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void fEW()
  {
    AppMethodBeat.i(29919);
    this.BgP.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void fEX()
  {
    AppMethodBeat.i(29920);
    if ((this.GSz.getVisibility() == 4) && (!this.GSA))
    {
      this.GSz.clearAnimation();
      this.GSA = true;
      TextView localTextView = this.GSz;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void fEL() {}
        
        public final void fEM()
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
    this.GSz.clearAnimation();
    this.GSz.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void fEY()
  {
    AppMethodBeat.i(29921);
    if ((this.GSz.getVisibility() == 0) && (!this.GSA))
    {
      this.GSz.clearAnimation();
      this.GSA = true;
      a.a(this.GSz, getContext(), new a.a()
      {
        public final void fEL() {}
        
        public final void fEM()
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
    this.GSz.clearAnimation();
    this.GSz.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.BgP.setTextSize(0, getContext().getResources().getDimension(2131167128));
    this.GSB = this.BgP.getTextSize();
    this.BgP.clearAnimation();
    Log.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.GSB) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.GSz.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.GSz.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.BgP.setText(paramInt);
    this.BgP.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.BgP.setText(paramString);
    this.BgP.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.mPa.setText(paramInt);
    this.mPa.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.mPa.setText(paramString);
    this.mPa.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */