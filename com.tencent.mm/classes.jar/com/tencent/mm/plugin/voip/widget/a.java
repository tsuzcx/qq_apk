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
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  private boolean AbW;
  VoIPRenderTextureView Ctr;
  VoIPRenderTextureView Cts;
  boolean Ctt;
  RelativeLayout Ctu;
  TextView Ctv;
  private float Ctw;
  boolean Ctx;
  private Runnable Cty;
  ImageView fUN;
  private com.tencent.mm.sdk.b.c gGf;
  private ap jwD;
  private int mStatus;
  private float radius;
  private TextView wTc;
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(216595);
    this.mStatus = -1;
    this.jwD = new ap(Looper.getMainLooper());
    this.radius = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 12);
    this.Ctx = false;
    this.Cty = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(216589);
        a locala = a.this;
        if ((!locala.Ctt) && (locala.Ctx))
        {
          locala.Ctt = true;
          locala.Ctx = false;
          locala.Ctr.setVisibility(0);
          locala.Ctr.tG(true);
          locala.Cts.tG(false);
          locala.Cts.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(216589);
      }
    };
    this.gGf = new a.2(this);
    this.AbW = false;
    LayoutInflater.from(paramContext).inflate(2131495888, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.wTc = ((TextView)findViewById(2131305880));
    this.Ctu = ((RelativeLayout)findViewById(2131306580));
    this.Ctu.setVisibility(4);
    this.fUN = ((ImageView)findViewById(2131306578));
    this.Ctv = ((TextView)findViewById(2131306579));
    this.Ctw = paramFloat;
    this.Ctr = ((VoIPRenderTextureView)findViewById(2131302998));
    this.wTc = ((TextView)findViewById(2131305880));
    this.Cts = ((VoIPRenderTextureView)findViewById(2131302997));
    this.Cts.tG(true);
    this.Ctr.setClipToOutline(true);
    this.Ctr.setOutlineProvider(new e(this.radius));
    this.Cts.setClipToOutline(true);
    this.Cts.setOutlineProvider(new e(this.radius));
    this.Ctt = false;
    com.tencent.mm.sdk.b.a.IbL.c(this.gGf);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(216595);
  }
  
  private void eBq()
  {
    AppMethodBeat.i(216606);
    this.wTc.setVisibility(8);
    AppMethodBeat.o(216606);
  }
  
  public final void aDJ(String paramString) {}
  
  public final void aDK(String paramString)
  {
    AppMethodBeat.i(216602);
    this.wTc.setTextSize(1, 12.0F);
    this.wTc.setText(paramString);
    AppMethodBeat.o(216602);
  }
  
  public final void dqh()
  {
    AppMethodBeat.i(216607);
    eBq();
    this.Ctu.setVisibility(0);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.Ctv.setText(2131764923);
    this.Ctv.requestLayout();
    super.dqh();
    AppMethodBeat.o(216607);
  }
  
  public final void eBp()
  {
    AppMethodBeat.i(216598);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.Ctx)) {
      this.Cts.tG(false);
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
      AppMethodBeat.o(216598);
      return;
      this.Cts.tG(true);
      this.Ctr.tG(false);
    }
  }
  
  public final void eyJ()
  {
    AppMethodBeat.i(216599);
    this.jwD.post(this.Cty);
    AppMethodBeat.o(216599);
  }
  
  public final boolean ezi()
  {
    AppMethodBeat.i(216603);
    super.ezi();
    eBq();
    this.Ctu.setVisibility(0);
    this.fUN.setImageDrawable(ao.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.Ctv.setVisibility(0);
    this.Ctv.setText(2131764882);
    this.Ctv.requestLayout();
    AppMethodBeat.o(216603);
    return true;
  }
  
  public final void ezj()
  {
    AppMethodBeat.i(216608);
    this.wTc.setVisibility(8);
    this.Ctu.setVisibility(8);
    AppMethodBeat.o(216608);
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(216596);
    super.onViewAdded(paramView);
    if (this.CiR != null)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.Ctx) {
        ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Cts, 0);
      }
      paramView = (com.tencent.mm.plugin.voip.ui.c)this.CiR.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.au(false, bool);
        ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Ctr, 1);
        this.Ctr.eBo();
        this.Cts.eBo();
        AppMethodBeat.o(216596);
        return;
      }
    }
    this.AbW = true;
    AppMethodBeat.o(216596);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(216601);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.Ctx = true;
      this.Ctr.tG(true);
      this.Cts.setVisibility(0);
      this.Cts.tG(false);
      this.wTc.setVisibility(0);
    }
    this.gKD.postDelayed(new a.4(this), 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.Ctr.setVisibility(0);
      this.Ctr.tG(false);
      this.Cts.tG(true);
      this.wTc.setText("");
      this.wTc.setVisibility(8);
    }
    AppMethodBeat.o(216601);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(216604);
    if (this.BYM != paramInt)
    {
      eBq();
      this.BYM = paramInt;
      this.Ctu.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.wTc.setVisibility(8);
      this.Ctv.requestLayout();
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(216604);
      return;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764878);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764881);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764879);
      continue;
      this.fUN.setImageDrawable(ao.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.Ctv.setText(2131764880);
    }
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(216597);
    super.setVoipUIListener(paramc);
    if (this.AbW)
    {
      if (this.Ctx) {
        ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Cts, 0);
      }
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.CiR.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.au(false, bool);
      ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Ctr, 1);
      this.AbW = false;
      this.Ctr.eBo();
      this.Cts.eBo();
      AppMethodBeat.o(216597);
      return;
    }
  }
  
  public final void tv(boolean paramBoolean)
  {
    AppMethodBeat.i(216605);
    if (paramBoolean)
    {
      this.wTc.setVisibility(0);
      this.wTc.setText(2131764894);
      AppMethodBeat.o(216605);
      return;
    }
    super.tv(false);
    AppMethodBeat.o(216605);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(216600);
    ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Cts);
    ((com.tencent.mm.plugin.voip.ui.c)this.CiR.get()).a(this.Ctr);
    super.uninit();
    com.tencent.mm.sdk.b.a.IbL.d(this.gGf);
    setVisibility(4);
    AppMethodBeat.o(216600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */