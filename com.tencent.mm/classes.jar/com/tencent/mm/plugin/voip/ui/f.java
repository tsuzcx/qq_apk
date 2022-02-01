package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.ui.ao;

public final class f
  extends BaseSmallView
{
  private ImageView fUN;
  private TextView iCW;
  private TextView timeTv;
  private ImageView xBc;
  
  public f(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(115506);
    LayoutInflater.from(paramContext).inflate(2131495886, this);
    this.xBc = ((ImageView)findViewById(2131306480));
    this.timeTv = ((TextView)findViewById(2131306618));
    this.iCW = ((TextView)findViewById(2131306619));
    this.fUN = ((ImageView)findViewById(2131306617));
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690359, Color.parseColor("#07C160")));
    AppMethodBeat.o(115506);
  }
  
  public final void aDJ(String paramString)
  {
    AppMethodBeat.i(115507);
    this.timeTv.setTextSize(1, 14.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757335) + "," + paramString);
    AppMethodBeat.o(115507);
  }
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(115508);
    this.timeTv.setTextSize(1, 12.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757335) + "," + paramString);
    AppMethodBeat.o(115508);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(184090);
    this.iCW.setVisibility(0);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690327, Color.parseColor("#FA5151")));
    this.iCW.setTextColor(Color.parseColor("#FA5151"));
    this.iCW.setText(2131764923);
    this.timeTv.setVisibility(8);
    super.dqh();
    AppMethodBeat.o(184090);
  }
  
  public final boolean ezi()
  {
    AppMethodBeat.i(184087);
    super.ezi();
    this.timeTv.setVisibility(8);
    this.iCW.setVisibility(0);
    this.iCW.setTextColor(Color.parseColor("#FA5151"));
    this.iCW.setText(2131764882);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690360, Color.parseColor("#FA5151")));
    AppMethodBeat.o(184087);
    return true;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(184088);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690359, Color.parseColor("#07C160")));
    this.iCW.setVisibility(8);
    this.iCW.setTextColor(Color.parseColor("#07C160"));
    this.timeTv.setVisibility(0);
    AppMethodBeat.o(184088);
  }
  
  public final void ezk()
  {
    AppMethodBeat.i(184877);
    super.ezk();
    this.xBc.setBackground(ao.k(getContext(), 2131234576, getResources().getColor(2131099650)));
    AppMethodBeat.o(184877);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return null;
  }
  
  public final void onAnimationEnd() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184089);
    if (this.BYM != paramInt)
    {
      this.BYM = paramInt;
      this.iCW.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.timeTv.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(184089);
      return;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690357, Color.parseColor("#07C160")));
      this.iCW.setText(2131764878);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690499, Color.parseColor("#07C160")));
      this.iCW.setText(2131764881);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690395, Color.parseColor("#07C160")));
      this.iCW.setText(2131764879);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690411, Color.parseColor("#07C160")));
      this.iCW.setText(2131764880);
    }
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(184091);
    if (paramBoolean)
    {
      this.timeTv.setVisibility(8);
      this.iCW.setVisibility(0);
      this.iCW.setText(2131764894);
      AppMethodBeat.o(184091);
      return;
    }
    super.tv(false);
    AppMethodBeat.o(184091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f
 * JD-Core Version:    0.7.0.1
 */