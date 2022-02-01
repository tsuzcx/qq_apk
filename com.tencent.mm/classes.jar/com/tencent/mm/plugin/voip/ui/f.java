package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.ui.ar;

public final class f
  extends BaseSmallView
{
  private ImageView BQU;
  private ImageView gBZ;
  private TextView jBS;
  private TextView timeTv;
  
  public f(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(115506);
    LayoutInflater.from(paramContext).inflate(2131496866, this);
    this.BQU = ((ImageView)findViewById(2131309939));
    this.timeTv = ((TextView)findViewById(2131310078));
    this.jBS = ((TextView)findViewById(2131310079));
    this.gBZ = ((ImageView)findViewById(2131310077));
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690498, Color.parseColor("#07C160")));
    AppMethodBeat.o(115506);
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(115508);
    this.timeTv.setTextSize(1, 12.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757549) + "," + paramString);
    AppMethodBeat.o(115508);
  }
  
  public final void aGy(String paramString)
  {
    AppMethodBeat.i(115507);
    this.timeTv.setTextSize(1, 14.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(2131757549) + "," + paramString);
    AppMethodBeat.o(115507);
  }
  
  public final void enR()
  {
    AppMethodBeat.i(184090);
    this.jBS.setVisibility(0);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690443, Color.parseColor("#FA5151")));
    this.jBS.setTextColor(Color.parseColor("#FA5151"));
    this.jBS.setText(2131767364);
    this.timeTv.setVisibility(8);
    super.enR();
    AppMethodBeat.o(184090);
  }
  
  public final boolean eoK()
  {
    AppMethodBeat.i(184087);
    super.eoK();
    this.timeTv.setVisibility(8);
    this.jBS.setVisibility(0);
    this.jBS.setTextColor(Color.parseColor("#FA5151"));
    this.jBS.setText(2131767321);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690499, Color.parseColor("#FA5151")));
    AppMethodBeat.o(184087);
    return true;
  }
  
  public final void eoL()
  {
    AppMethodBeat.i(184088);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690498, Color.parseColor("#07C160")));
    this.jBS.setVisibility(8);
    this.jBS.setTextColor(Color.parseColor("#07C160"));
    this.timeTv.setVisibility(0);
    AppMethodBeat.o(184088);
  }
  
  public final void eoM()
  {
    AppMethodBeat.i(184877);
    super.eoM();
    this.BQU.setBackground(ar.m(getContext(), 2131235538, getResources().getColor(2131099650)));
    AppMethodBeat.o(184877);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return null;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    return null;
  }
  
  public final void onAnimationEnd() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184089);
    if (this.GUk != paramInt)
    {
      this.GUk = paramInt;
      this.jBS.setVisibility(0);
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
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690495, Color.parseColor("#07C160")));
      this.jBS.setText(2131767317);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690708, Color.parseColor("#07C160")));
      this.jBS.setText(2131767320);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690544, Color.parseColor("#07C160")));
      this.jBS.setText(2131767318);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690568, Color.parseColor("#07C160")));
      this.jBS.setText(2131767319);
    }
  }
  
  public final void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(184091);
    if (paramBoolean)
    {
      this.timeTv.setVisibility(8);
      this.jBS.setVisibility(0);
      this.jBS.setText(2131767333);
      AppMethodBeat.o(184091);
      return;
    }
    super.xm(false);
    AppMethodBeat.o(184091);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.f
 * JD-Core Version:    0.7.0.1
 */