package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.ui.bb;

public final class l
  extends BaseSmallView
{
  private ImageView Esh;
  private ImageView lPb;
  private TextView pls;
  private TextView timeTv;
  
  public l(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(115506);
    LayoutInflater.from(paramContext).inflate(b.e.voip_voice_mini_widget_view, this);
    this.Esh = ((ImageView)findViewById(b.d.voice_bg));
    this.timeTv = ((TextView)findViewById(b.d.voip_voice_mini_time_tv));
    this.pls = ((TextView)findViewById(b.d.voip_voice_mini_tip_tv));
    this.lPb = ((ImageView)findViewById(b.d.voip_voice_mini_icon_iv));
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_call, Color.parseColor("#07C160")));
    AppMethodBeat.o(115506);
  }
  
  public final void GH(boolean paramBoolean)
  {
    AppMethodBeat.i(184091);
    if (paramBoolean)
    {
      this.timeTv.setVisibility(8);
      this.pls.setVisibility(0);
      this.pls.setText(b.g.voip_net_status_warning_hint_mini);
      this.pls.setContentDescription(getResources().getString(b.g.talkback_voip_net_bad));
      AppMethodBeat.o(184091);
      return;
    }
    super.GH(false);
    AppMethodBeat.o(184091);
  }
  
  public final void aNF(String paramString)
  {
    AppMethodBeat.i(115507);
    this.timeTv.setTextSize(1, 14.0F);
    this.timeTv.setText(paramString);
    setContentDescription(String.format(getContext().getString(b.g.talkback_voip_talking), new Object[] { paramString }));
    AppMethodBeat.o(115507);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(184090);
    this.pls.setVisibility(0);
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icon_filled_mike_off, Color.parseColor("#FA5151")));
    this.pls.setTextColor(Color.parseColor("#FA5151"));
    this.pls.setText(b.g.voip_start_record_failed);
    this.timeTv.setVisibility(8);
    super.fwi();
    AppMethodBeat.o(184090);
  }
  
  public final OpenGlRender getBeautyData()
  {
    return null;
  }
  
  public final OpenGlRender getSpatioTemporalFilterData()
  {
    return null;
  }
  
  public final boolean ghw()
  {
    AppMethodBeat.i(184087);
    super.ghw();
    this.timeTv.setVisibility(8);
    this.pls.setVisibility(0);
    this.pls.setTextColor(Color.parseColor("#FA5151"));
    this.pls.setText(b.g.voip_miniwindow_end_wording);
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_call_end, Color.parseColor("#FA5151")));
    setContentDescription("");
    AppMethodBeat.o(184087);
    return true;
  }
  
  public final void ghx()
  {
    AppMethodBeat.i(184088);
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_call, Color.parseColor("#07C160")));
    this.pls.setVisibility(8);
    this.pls.setTextColor(Color.parseColor("#07C160"));
    this.timeTv.setVisibility(0);
    AppMethodBeat.o(184088);
  }
  
  public final void ghy()
  {
    AppMethodBeat.i(184877);
    super.ghy();
    this.Esh.setBackground(bb.m(getContext(), b.c.voip_mini_voice_rectangle, getResources().getColor(b.a.BG_2)));
    AppMethodBeat.o(184877);
  }
  
  public final void onAnimationEnd() {}
  
  public final void setCaptureView(CaptureView paramCaptureView) {}
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(184089);
    if (this.Uxg != paramInt)
    {
      this.Uxg = paramInt;
      this.pls.setVisibility(0);
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
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_bluetooth, Color.parseColor("#07C160")));
      this.pls.setText(b.g.voip_mini_bluetooth);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_volume_up, Color.parseColor("#07C160")));
      this.pls.setText(b.g.voip_mini_mike);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_ear, Color.parseColor("#07C160")));
      this.pls.setText(b.g.voip_mini_earpiece);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_headset, Color.parseColor("#07C160")));
      this.pls.setText(b.g.voip_mini_headset);
    }
  }
  
  public final void updateText(String paramString)
  {
    AppMethodBeat.i(115508);
    this.timeTv.setTextSize(1, 12.0F);
    this.timeTv.setText(paramString);
    setContentDescription(getContext().getString(b.g.talkback_voip_waiting));
    AppMethodBeat.o(115508);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.l
 * JD-Core Version:    0.7.0.1
 */