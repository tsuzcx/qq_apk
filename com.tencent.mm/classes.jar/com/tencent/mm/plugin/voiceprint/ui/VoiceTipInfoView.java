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
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.sdk.platformtools.Log;

public class VoiceTipInfoView
  extends LinearLayout
{
  TextView MYG;
  boolean UuK;
  private boolean UuL;
  private TextView UuM;
  private boolean UuN;
  private float UuO;
  public ProgressBar qgC;
  TextView sUt;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.UuK = false;
    this.UuL = false;
    this.UuN = false;
    this.UuO = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.gpa, this, true);
    this.qgC = ((ProgressBar)paramContext.findViewById(R.h.load_progress));
    gdb();
    this.sUt = ((TextView)paramContext.findViewById(R.h.gcV));
    this.MYG = ((TextView)paramContext.findViewById(R.h.gcX));
    this.UuM = ((TextView)paramContext.findViewById(R.h.gcW));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void eAg()
  {
    AppMethodBeat.i(29912);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.qgC.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void gdb()
  {
    AppMethodBeat.i(29913);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.qgC.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void hFl()
  {
    AppMethodBeat.i(29921);
    if ((this.UuM.getVisibility() == 0) && (!this.UuN))
    {
      this.UuM.clearAnimation();
      this.UuN = true;
      a.a(this.UuM, getContext(), new a.a()
      {
        public final void hUV() {}
        
        public final void hUW()
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
    this.UuM.clearAnimation();
    this.UuM.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void hVe()
  {
    AppMethodBeat.i(29918);
    Log.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.sUt.getVisibility()), Boolean.valueOf(this.UuK) });
    if (((this.sUt.getVisibility() == 4) || (this.sUt.getVisibility() == 8)) && (!this.UuK))
    {
      this.sUt.clearAnimation();
      this.UuK = true;
      a.b(this.sUt, getContext(), new a.a()
      {
        public final void hUV() {}
        
        public final void hUW()
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
    this.sUt.clearAnimation();
    this.sUt.setVisibility(0);
    this.sUt.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void hVf()
  {
    AppMethodBeat.i(29919);
    this.MYG.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void hVg()
  {
    AppMethodBeat.i(29920);
    if ((this.UuM.getVisibility() == 4) && (!this.UuN))
    {
      this.UuM.clearAnimation();
      this.UuN = true;
      TextView localTextView = this.UuM;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void hUV() {}
        
        public final void hUW()
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
    this.UuM.clearAnimation();
    this.UuM.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.MYG.setTextSize(0, getContext().getResources().getDimension(R.f.voice_print_tip_normal_size));
    this.UuO = this.MYG.getTextSize();
    this.MYG.clearAnimation();
    Log.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.UuO) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.UuM.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.UuM.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.MYG.setText(paramInt);
    this.MYG.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.MYG.setText(paramString);
    this.MYG.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.sUt.setText(paramInt);
    this.sUt.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.sUt.setText(paramString);
    this.sUt.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */