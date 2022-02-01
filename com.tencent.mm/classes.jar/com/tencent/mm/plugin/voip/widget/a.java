package com.tencent.mm.plugin.voip.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.k;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.bb;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  TextView LuS;
  private TextView MYG;
  private boolean RpQ;
  VoIPRenderTextureView UUY;
  VoIPRenderTextureView UUZ;
  boolean UVa;
  RelativeLayout UVb;
  boolean UVc;
  private Runnable UVd;
  ImageView lPb;
  private IListener mIj;
  private int mStatus;
  private MMHandler qse;
  private float radius;
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(293422);
    this.mStatus = -1;
    this.qse = new MMHandler(Looper.getMainLooper());
    this.radius = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.UVc = false;
    this.UVd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293423);
        a locala = a.this;
        if ((!locala.UVa) && (locala.UVc))
        {
          locala.UVa = true;
          locala.UVc = false;
          locala.UUY.setVisibility(0);
          locala.UUY.GR(true);
          locala.UUZ.GR(false);
          locala.UUZ.animate().alpha(0.0F).setDuration(500L).setListener(new a.2(locala)).start();
        }
        AppMethodBeat.o(293423);
      }
    };
    this.mIj = new NewVideoTalkingSmallView.2(this, f.hfK);
    this.RpQ = false;
    LayoutInflater.from(paramContext).inflate(b.e.voip_widget_video_talking2, this);
    setClipToOutline(true);
    setOutlineProvider(new k(this.radius));
    this.MYG = ((TextView)findViewById(b.d.tip_tv));
    this.UVb = ((RelativeLayout)findViewById(b.d.voip_mini_windows_layout));
    this.UVb.setVisibility(4);
    this.lPb = ((ImageView)findViewById(b.d.voip_mini_full_icon));
    this.LuS = ((TextView)findViewById(b.d.voip_mini_full_tv));
    this.UUY = ((VoIPRenderTextureView)findViewById(b.d.ogv_talking));
    this.MYG = ((TextView)findViewById(b.d.tip_tv));
    this.UUZ = ((VoIPRenderTextureView)findViewById(b.d.ogv_local_video));
    this.UUZ.GR(true);
    this.UUY.setClipToOutline(true);
    this.UUY.setOutlineProvider(new k(this.radius));
    this.UUZ.setClipToOutline(true);
    this.UUZ.setOutlineProvider(new k(this.radius));
    this.UVa = false;
    this.mIj.alive();
    AppMethodBeat.o(293422);
  }
  
  private void idL()
  {
    AppMethodBeat.i(293428);
    this.MYG.setVisibility(8);
    AppMethodBeat.o(293428);
  }
  
  public final void GH(boolean paramBoolean)
  {
    AppMethodBeat.i(293478);
    if (paramBoolean)
    {
      this.MYG.setVisibility(0);
      this.MYG.setText(b.g.voip_net_status_warning_hint_mini);
      setContentDescription(getResources().getString(b.g.talkback_video_talk_net_bad));
      AppMethodBeat.o(293478);
      return;
    }
    super.GH(false);
    AppMethodBeat.o(293478);
  }
  
  public final void aNF(String paramString)
  {
    AppMethodBeat.i(293461);
    setContentDescription(getResources().getString(b.g.talkback_video_talk_talking_no_time));
    AppMethodBeat.o(293461);
  }
  
  public final void fwi()
  {
    AppMethodBeat.i(293485);
    idL();
    this.UVb.setVisibility(0);
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icon_filled_mike_off, Color.parseColor("#FFFFFF")));
    this.LuS.setText(b.g.voip_start_record_failed);
    this.LuS.requestLayout();
    super.fwi();
    AppMethodBeat.o(293485);
  }
  
  public final void fwq()
  {
    AppMethodBeat.i(293447);
    this.qse.post(this.UVd);
    AppMethodBeat.o(293447);
  }
  
  public final boolean ghw()
  {
    AppMethodBeat.i(293472);
    super.ghw();
    idL();
    this.UVb.setVisibility(0);
    this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_call_end, Color.parseColor("#FFFFFF")));
    this.LuS.setVisibility(0);
    this.LuS.setText(b.g.voip_miniwindow_end_wording);
    this.LuS.requestLayout();
    setContentDescription("");
    AppMethodBeat.o(293472);
    return true;
  }
  
  public final void ghx()
  {
    AppMethodBeat.i(293490);
    this.MYG.setVisibility(8);
    this.UVb.setVisibility(8);
    AppMethodBeat.o(293490);
  }
  
  public final void idK()
  {
    AppMethodBeat.i(293442);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.UVc)) {
      this.UUZ.GR(false);
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
      AppMethodBeat.o(293442);
      return;
      this.UUZ.GR(true);
      this.UUY.GR(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(293435);
    super.onViewAdded(paramView);
    if (this.UJb != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.UVc) {
        ((c)this.UJb.get()).a(this.UUZ, 0);
      }
      paramView = (c)this.UJb.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.bn(false, bool);
        ((c)this.UJb.get()).a(this.UUY, 1);
        this.UUY.idA();
        this.UUZ.idA();
        AppMethodBeat.o(293435);
        return;
      }
    }
    this.RpQ = true;
    AppMethodBeat.o(293435);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(293456);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.UVc = true;
      this.UUY.GR(true);
      this.UUZ.setVisibility(0);
      this.UUZ.GR(false);
      this.MYG.setVisibility(0);
    }
    this.eqE.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(293430);
        a.this.findViewById(b.d.voip_maximize).setVisibility(8);
        AppMethodBeat.o(293430);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.UUY.setVisibility(0);
      this.UUY.GR(false);
      this.UUZ.GR(true);
      this.MYG.setText("");
      this.MYG.setVisibility(8);
    }
    AppMethodBeat.o(293456);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(293476);
    if (this.Uxg != paramInt)
    {
      idL();
      this.Uxg = paramInt;
      this.UVb.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.MYG.setVisibility(8);
      this.LuS.requestLayout();
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(293476);
      return;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_bluetooth, Color.parseColor("#FFFFFF")));
      this.LuS.setText(b.g.voip_mini_bluetooth);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_volume_up, Color.parseColor("#FFFFFF")));
      this.LuS.setText(b.g.voip_mini_mike);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_ear, Color.parseColor("#FFFFFF")));
      this.LuS.setText(b.g.voip_mini_earpiece);
      continue;
      this.lPb.setImageDrawable(bb.m(getContext(), b.f.icons_filled_headset, Color.parseColor("#FFFFFF")));
      this.LuS.setText(b.g.voip_mini_headset);
    }
  }
  
  public final void setVoipUIListener(c paramc)
  {
    AppMethodBeat.i(293439);
    super.setVoipUIListener(paramc);
    if (this.RpQ)
    {
      if (this.UVc) {
        ((c)this.UJb.get()).a(this.UUZ, 0);
      }
      paramc = (c)this.UJb.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.bn(false, bool);
      ((c)this.UJb.get()).a(this.UUY, 1);
      this.RpQ = false;
      this.UUY.idA();
      this.UUZ.idA();
      AppMethodBeat.o(293439);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(293451);
    ((c)this.UJb.get()).a(this.UUZ);
    ((c)this.UJb.get()).a(this.UUY);
    super.uninit();
    this.mIj.dead();
    setVisibility(4);
    AppMethodBeat.o(293451);
  }
  
  public final void updateText(String paramString)
  {
    AppMethodBeat.i(293467);
    this.MYG.setTextSize(1, 12.0F);
    this.MYG.setText(paramString);
    setContentDescription(getResources().getString(b.g.talkback_video_talk_waiting));
    AppMethodBeat.o(293467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */