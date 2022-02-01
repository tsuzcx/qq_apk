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
import com.tencent.mm.ui.am;

public final class f
  extends BaseSmallView
{
  private ImageView fBA;
  private TextView ijF;
  private TextView timeTv;
  private ImageView wtc;
  
  public f(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(115506);
    LayoutInflater.from(paramContext).inflate(2131495886, this);
    this.wtc = ((ImageView)findViewById(2131306480));
    this.timeTv = ((TextView)findViewById(2131306618));
    this.ijF = ((TextView)findViewById(2131306619));
    this.fBA = ((ImageView)findViewById(2131306617));
    this.fBA.setImageDrawable(am.k(getContext(), 2131690359, Color.parseColor("#07C160")));
    AppMethodBeat.o(115506);
  }
  
  public final void ayB(String paramString)
  {
    AppMethodBeat.i(115507);
    this.timeTv.setTextSize(1, 14.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757335) + "," + paramString);
    AppMethodBeat.o(115507);
  }
  
  public final void ayC(String paramString)
  {
    AppMethodBeat.i(115508);
    this.timeTv.setTextSize(1, 12.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757335) + "," + paramString);
    AppMethodBeat.o(115508);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(184090);
    this.ijF.setVisibility(0);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690327, Color.parseColor("#FA5151")));
    this.ijF.setTextColor(Color.parseColor("#FA5151"));
    this.ijF.setText(2131764923);
    this.timeTv.setVisibility(8);
    super.dgi();
    AppMethodBeat.o(184090);
  }
  
  public final void elA()
  {
    AppMethodBeat.i(184877);
    super.elA();
    this.wtc.setBackground(am.k(getContext(), 2131234576, getResources().getColor(2131099650)));
    AppMethodBeat.o(184877);
  }
  
  public final boolean ely()
  {
    AppMethodBeat.i(184087);
    super.ely();
    this.timeTv.setVisibility(8);
    this.ijF.setVisibility(0);
    this.ijF.setTextColor(Color.parseColor("#FA5151"));
    this.ijF.setText(2131764882);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690360, Color.parseColor("#FA5151")));
    AppMethodBeat.o(184087);
    return true;
  }
  
  public final void elz()
  {
    AppMethodBeat.i(184088);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690359, Color.parseColor("#07C160")));
    this.ijF.setVisibility(8);
    this.ijF.setTextColor(Color.parseColor("#07C160"));
    this.timeTv.setVisibility(0);
    AppMethodBeat.o(184088);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return null;
  }
  
  public final void onAnimationEnd() {}
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(184091);
    if (paramBoolean)
    {
      this.timeTv.setVisibility(8);
      this.ijF.setVisibility(0);
      this.ijF.setText(2131764894);
      AppMethodBeat.o(184091);
      return;
    }
    super.sM(false);
    AppMethodBeat.o(184091);
  }
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184089);
    if (this.AzM != paramInt)
    {
      this.AzM = paramInt;
      this.ijF.setVisibility(0);
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
      this.fBA.setImageDrawable(am.k(getContext(), 2131690357, Color.parseColor("#07C160")));
      this.ijF.setText(2131764878);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690499, Color.parseColor("#07C160")));
      this.ijF.setText(2131764881);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690395, Color.parseColor("#07C160")));
      this.ijF.setText(2131764879);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690411, Color.parseColor("#07C160")));
      this.ijF.setText(2131764880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f
 * JD-Core Version:    0.7.0.1
 */