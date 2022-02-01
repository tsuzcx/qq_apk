package com.tencent.mm.plugin.voip.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.graphics.Color;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.au;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  TextView FyG;
  private TextView Haz;
  private boolean KQf;
  VoIPRenderTextureView OgF;
  VoIPRenderTextureView OgG;
  boolean OgH;
  RelativeLayout OgI;
  boolean OgJ;
  private Runnable OgK;
  ImageView jmf;
  private IListener khI;
  private int mStatus;
  private MMHandler ntw;
  private float radius;
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(234133);
    this.mStatus = -1;
    this.ntw = new MMHandler(Looper.getMainLooper());
    this.radius = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.OgJ = false;
    this.OgK = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234875);
        a locala = a.this;
        if ((!locala.OgH) && (locala.OgJ))
        {
          locala.OgH = true;
          locala.OgJ = false;
          locala.OgF.setVisibility(0);
          locala.OgF.Bn(true);
          locala.OgG.Bn(false);
          locala.OgG.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(234875);
      }
    };
    this.khI = new a.2(this);
    this.KQf = false;
    LayoutInflater.from(paramContext).inflate(b.e.voip_widget_video_talking2, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.Haz = ((TextView)findViewById(b.d.tip_tv));
    this.OgI = ((RelativeLayout)findViewById(b.d.voip_mini_windows_layout));
    this.OgI.setVisibility(4);
    this.jmf = ((ImageView)findViewById(b.d.voip_mini_full_icon));
    this.FyG = ((TextView)findViewById(b.d.voip_mini_full_tv));
    this.OgF = ((VoIPRenderTextureView)findViewById(b.d.ogv_talking));
    this.Haz = ((TextView)findViewById(b.d.tip_tv));
    this.OgG = ((VoIPRenderTextureView)findViewById(b.d.ogv_local_video));
    this.OgG.Bn(true);
    this.OgF.setClipToOutline(true);
    this.OgF.setOutlineProvider(new e(this.radius));
    this.OgG.setClipToOutline(true);
    this.OgG.setOutlineProvider(new e(this.radius));
    this.OgH = false;
    EventCenter.instance.addListener(this.khI);
    setContentDescription(paramContext.getString(b.g.chatting_voip_video));
    AppMethodBeat.o(234133);
  }
  
  private void gEK()
  {
    AppMethodBeat.i(234157);
    this.Haz.setVisibility(8);
    AppMethodBeat.o(234157);
  }
  
  public final void Be(boolean paramBoolean)
  {
    AppMethodBeat.i(234155);
    if (paramBoolean)
    {
      this.Haz.setVisibility(0);
      this.Haz.setText(b.g.voip_net_status_warning_hint_mini);
      AppMethodBeat.o(234155);
      return;
    }
    super.Be(false);
    AppMethodBeat.o(234155);
  }
  
  public final void aQM(String paramString)
  {
    AppMethodBeat.i(234149);
    this.Haz.setTextSize(1, 12.0F);
    this.Haz.setText(paramString);
    AppMethodBeat.o(234149);
  }
  
  public final void aQN(String paramString) {}
  
  public final void eXH()
  {
    AppMethodBeat.i(234160);
    gEK();
    this.OgI.setVisibility(0);
    this.jmf.setImageDrawable(au.o(getContext(), b.f.icon_filled_mike_off, Color.parseColor("#FFFFFF")));
    this.FyG.setText(b.g.voip_start_record_failed);
    this.FyG.requestLayout();
    super.eXH();
    AppMethodBeat.o(234160);
  }
  
  public final boolean eYB()
  {
    AppMethodBeat.i(234151);
    super.eYB();
    gEK();
    this.OgI.setVisibility(0);
    this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_call_end, Color.parseColor("#FFFFFF")));
    this.FyG.setVisibility(0);
    this.FyG.setText(b.g.voip_miniwindow_end_wording);
    this.FyG.requestLayout();
    AppMethodBeat.o(234151);
    return true;
  }
  
  public final void eYC()
  {
    AppMethodBeat.i(234163);
    this.Haz.setVisibility(8);
    this.OgI.setVisibility(8);
    AppMethodBeat.o(234163);
  }
  
  public final void gBJ()
  {
    AppMethodBeat.i(234141);
    this.ntw.post(this.OgK);
    AppMethodBeat.o(234141);
  }
  
  public final void gEJ()
  {
    AppMethodBeat.i(234140);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.OgJ)) {
      this.OgG.Bn(false);
    }
    for (;;)
    {
      FrameLayout.LayoutParams localLayoutParams2 = (FrameLayout.LayoutParams)getLayoutParams();
      FrameLayout.LayoutParams localLayoutParams1 = localLayoutParams2;
      if (localLayoutParams2 == null) {
        localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
      }
      localLayoutParams1.width = -1;
      localLayoutParams1.height = -1;
      setLayoutParams(localLayoutParams1);
      AppMethodBeat.o(234140);
      return;
      this.OgG.Bn(true);
      this.OgF.Bn(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(234136);
    super.onViewAdded(paramView);
    if (this.NVe != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.OgJ) {
        ((c)this.NVe.get()).a(this.OgG, 0);
      }
      paramView = (c)this.NVe.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.aQ(false, bool);
        ((c)this.NVe.get()).a(this.OgF, 1);
        this.OgF.gEB();
        this.OgG.gEB();
        AppMethodBeat.o(234136);
        return;
      }
    }
    this.KQf = true;
    AppMethodBeat.o(234136);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(234146);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.OgJ = true;
      this.OgF.Bn(true);
      this.OgG.setVisibility(0);
      this.OgG.Bn(false);
      this.Haz.setVisibility(0);
    }
    this.cyl.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243694);
        a.this.findViewById(b.d.voip_maximize).setVisibility(8);
        AppMethodBeat.o(243694);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.OgF.setVisibility(0);
      this.OgF.Bn(false);
      this.OgG.Bn(true);
      this.Haz.setText("");
      this.Haz.setVisibility(8);
    }
    AppMethodBeat.o(234146);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(234153);
    if (this.NKw != paramInt)
    {
      gEK();
      this.NKw = paramInt;
      this.OgI.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.Haz.setVisibility(8);
      this.FyG.requestLayout();
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(234153);
      return;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_bluetooth);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_mike);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_ear, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_earpiece);
      continue;
      this.jmf.setImageDrawable(au.o(getContext(), b.f.icons_filled_headset, Color.parseColor("#FFFFFF")));
      this.FyG.setText(b.g.voip_mini_headset);
    }
  }
  
  public final void setVoipUIListener(c paramc)
  {
    AppMethodBeat.i(234138);
    super.setVoipUIListener(paramc);
    if (this.KQf)
    {
      if (this.OgJ) {
        ((c)this.NVe.get()).a(this.OgG, 0);
      }
      paramc = (c)this.NVe.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.aQ(false, bool);
      ((c)this.NVe.get()).a(this.OgF, 1);
      this.KQf = false;
      this.OgF.gEB();
      this.OgG.gEB();
      AppMethodBeat.o(234138);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(234143);
    ((c)this.NVe.get()).a(this.OgG);
    ((c)this.NVe.get()).a(this.OgF);
    super.uninit();
    EventCenter.instance.removeListener(this.khI);
    setVisibility(4);
    AppMethodBeat.o(234143);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */