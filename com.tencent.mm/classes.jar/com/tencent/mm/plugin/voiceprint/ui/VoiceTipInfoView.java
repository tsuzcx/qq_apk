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
  TextView Haz;
  boolean NII;
  private boolean NIJ;
  private TextView NIK;
  private boolean NIL;
  private float NIM;
  public ProgressBar njo;
  TextView pPT;
  
  public VoiceTipInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(29910);
    this.NII = false;
    this.NIJ = false;
    this.NIL = false;
    this.NIM = 0.0F;
    paramContext = LayoutInflater.from(paramContext).inflate(R.i.elW, this, true);
    this.njo = ((ProgressBar)paramContext.findViewById(R.h.load_progress));
    eUn();
    this.pPT = ((TextView)paramContext.findViewById(R.h.eag));
    this.Haz = ((TextView)paramContext.findViewById(R.h.voice_print_title_tip));
    this.NIK = ((TextView)paramContext.findViewById(R.h.eah));
    reset();
    AppMethodBeat.o(29910);
  }
  
  public final void dBa()
  {
    AppMethodBeat.i(29912);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar show");
    this.njo.setVisibility(0);
    AppMethodBeat.o(29912);
  }
  
  public final void eUn()
  {
    AppMethodBeat.i(29913);
    Log.d("MicroMsg.VoiceTipInfoView", "mProgressBar hide");
    this.njo.setVisibility(8);
    AppMethodBeat.o(29913);
  }
  
  public final void gxh()
  {
    AppMethodBeat.i(29918);
    Log.d("MicroMsg.VoiceTipInfoView", "showTitle, titleTv.getVisibility:%d, mAnimingTitle:%b", new Object[] { Integer.valueOf(this.pPT.getVisibility()), Boolean.valueOf(this.NII) });
    if (((this.pPT.getVisibility() == 4) || (this.pPT.getVisibility() == 8)) && (!this.NII))
    {
      this.pPT.clearAnimation();
      this.NII = true;
      a.b(this.pPT, getContext(), new a.a()
      {
        public final void gwY() {}
        
        public final void gwZ()
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
    this.pPT.clearAnimation();
    this.pPT.setVisibility(0);
    this.pPT.invalidate();
    AppMethodBeat.o(29918);
  }
  
  public final void gxi()
  {
    AppMethodBeat.i(29919);
    this.Haz.setVisibility(8);
    AppMethodBeat.o(29919);
  }
  
  public final void gxj()
  {
    AppMethodBeat.i(29920);
    if ((this.NIK.getVisibility() == 4) && (!this.NIL))
    {
      this.NIK.clearAnimation();
      this.NIL = true;
      TextView localTextView = this.NIK;
      getContext();
      a.b(localTextView, new a.a()
      {
        public final void gwY() {}
        
        public final void gwZ()
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
    this.NIK.clearAnimation();
    this.NIK.setVisibility(0);
    AppMethodBeat.o(29920);
  }
  
  public final void gxk()
  {
    AppMethodBeat.i(29921);
    if ((this.NIK.getVisibility() == 0) && (!this.NIL))
    {
      this.NIK.clearAnimation();
      this.NIL = true;
      a.a(this.NIK, getContext(), new a.a()
      {
        public final void gwY() {}
        
        public final void gwZ()
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
    this.NIK.clearAnimation();
    this.NIK.setVisibility(4);
    AppMethodBeat.o(29921);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(29911);
    this.Haz.setTextSize(0, getContext().getResources().getDimension(R.f.voice_print_tip_normal_size));
    this.NIM = this.Haz.getTextSize();
    this.Haz.clearAnimation();
    Log.d("MicroMsg.VoiceTipInfoView", "mTipSize %f", new Object[] { Float.valueOf(this.NIM) });
    AppMethodBeat.o(29911);
  }
  
  public void setErr(int paramInt)
  {
    AppMethodBeat.i(29923);
    this.NIK.setText(paramInt);
    AppMethodBeat.o(29923);
  }
  
  public void setErr(String paramString)
  {
    AppMethodBeat.i(29922);
    this.NIK.setText(paramString);
    AppMethodBeat.o(29922);
  }
  
  public void setTipText(int paramInt)
  {
    AppMethodBeat.i(29915);
    this.Haz.setText(paramInt);
    this.Haz.setVisibility(0);
    AppMethodBeat.o(29915);
  }
  
  public void setTipText(String paramString)
  {
    AppMethodBeat.i(29914);
    this.Haz.setText(paramString);
    this.Haz.setVisibility(0);
    AppMethodBeat.o(29914);
  }
  
  public void setTitleText(int paramInt)
  {
    AppMethodBeat.i(29917);
    this.pPT.setText(paramInt);
    this.pPT.setVisibility(0);
    AppMethodBeat.o(29917);
  }
  
  public void setTitleText(String paramString)
  {
    AppMethodBeat.i(29916);
    this.pPT.setText(paramString);
    this.pPT.setVisibility(0);
    AppMethodBeat.o(29916);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voiceprint.ui.VoiceTipInfoView
 * JD-Core Version:    0.7.0.1
 */