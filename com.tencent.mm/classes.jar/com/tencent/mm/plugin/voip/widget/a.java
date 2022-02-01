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
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  ImageView fxT;
  private ap iDu;
  private int mStatus;
  private float radius;
  private TextView sYS;
  private TextView uDc;
  private boolean xxL;
  VoIPRenderTextureView zAV;
  VoIPRenderTextureView zAW;
  boolean zAX;
  RelativeLayout zAY;
  TextView zAZ;
  private float zBa;
  boolean zBb;
  private Runnable zBc;
  private com.tencent.mm.sdk.b.c zrl;
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(192209);
    this.mStatus = -1;
    this.iDu = new ap(Looper.getMainLooper());
    this.radius = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 12);
    this.zBb = false;
    this.zBc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(192203);
        a locala = a.this;
        if ((!locala.zAX) && (locala.zBb))
        {
          locala.zAX = true;
          locala.zBb = false;
          locala.zAV.setVisibility(0);
          locala.zAV.rV(true);
          locala.zAW.rV(false);
          locala.zAW.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(192203);
      }
    };
    this.zrl = new a.2(this);
    this.xxL = false;
    LayoutInflater.from(paramContext).inflate(2131495888, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.sYS = ((TextView)findViewById(2131305822));
    this.uDc = ((TextView)findViewById(2131305880));
    this.zAY = ((RelativeLayout)findViewById(2131306580));
    this.zAY.setVisibility(4);
    this.fxT = ((ImageView)findViewById(2131306578));
    this.zAZ = ((TextView)findViewById(2131306579));
    this.zBa = paramFloat;
    this.zAV = ((VoIPRenderTextureView)findViewById(2131302998));
    this.sYS = ((TextView)findViewById(2131305822));
    this.uDc = ((TextView)findViewById(2131305880));
    this.zAW = ((VoIPRenderTextureView)findViewById(2131302997));
    this.zAW.rV(true);
    this.zAV.setClipToOutline(true);
    this.zAV.setOutlineProvider(new e(this.radius));
    this.zAW.setClipToOutline(true);
    this.zAW.setOutlineProvider(new e(this.radius));
    this.zAX = false;
    com.tencent.mm.sdk.b.a.ESL.c(this.zrl);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(192209);
  }
  
  private void dXV()
  {
    AppMethodBeat.i(192220);
    this.uDc.setVisibility(8);
    this.sYS.setVisibility(8);
    AppMethodBeat.o(192220);
  }
  
  public final void atk(String paramString) {}
  
  public final void atl(String paramString)
  {
    AppMethodBeat.i(192216);
    this.sYS.setTextSize(1, 12.0F);
    this.sYS.setText(paramString);
    AppMethodBeat.o(192216);
  }
  
  public final void cSz()
  {
    AppMethodBeat.i(192221);
    dXV();
    this.zAY.setVisibility(0);
    this.fxT.setImageDrawable(am.i(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.zAZ.setText(2131764923);
    super.cSz();
    AppMethodBeat.o(192221);
  }
  
  public final void dVN()
  {
    AppMethodBeat.i(192213);
    this.iDu.post(this.zBc);
    AppMethodBeat.o(192213);
  }
  
  public final boolean dWm()
  {
    AppMethodBeat.i(192217);
    super.dWm();
    dXV();
    this.zAY.setVisibility(0);
    this.fxT.setImageDrawable(am.i(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.zAZ.setVisibility(0);
    this.zAZ.setText(2131764882);
    AppMethodBeat.o(192217);
    return true;
  }
  
  public final void dWn()
  {
    AppMethodBeat.i(192222);
    this.uDc.setVisibility(8);
    this.zAY.setVisibility(8);
    AppMethodBeat.o(192222);
  }
  
  public final void dXU()
  {
    AppMethodBeat.i(192212);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.zBb)) {
      this.zAW.rV(false);
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
      AppMethodBeat.o(192212);
      return;
      this.zAW.rV(true);
      this.zAV.rV(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(192210);
    super.onViewAdded(paramView);
    if (this.zrd != null)
    {
      ad.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.zBb) {
        ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAW, 0);
      }
      paramView = (com.tencent.mm.plugin.voip.ui.c)this.zrd.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.al(false, bool);
        ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAV, 1);
        this.zAV.dXT();
        this.zAW.dXT();
        AppMethodBeat.o(192210);
        return;
      }
    }
    this.xxL = true;
    AppMethodBeat.o(192210);
  }
  
  public final void rL(boolean paramBoolean)
  {
    AppMethodBeat.i(192219);
    if (paramBoolean)
    {
      this.uDc.setVisibility(0);
      this.uDc.setText(2131764894);
      this.sYS.setVisibility(8);
      AppMethodBeat.o(192219);
      return;
    }
    super.rL(false);
    AppMethodBeat.o(192219);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(192215);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.zBb = true;
      this.zAV.rV(true);
      this.zAW.setVisibility(0);
      this.zAW.rV(false);
      this.sYS.setVisibility(0);
    }
    this.oFl.postDelayed(new a.4(this), 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.zAV.setVisibility(0);
      this.zAV.rV(false);
      this.zAW.rV(true);
      this.sYS.setText("");
      this.sYS.setVisibility(8);
    }
    AppMethodBeat.o(192215);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(192218);
    if (this.zhd != paramInt)
    {
      dXV();
      this.zhd = paramInt;
      this.zAY.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.sYS.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(192218);
      return;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764878);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764881);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764879);
      continue;
      this.fxT.setImageDrawable(am.i(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.zAZ.setText(2131764880);
    }
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(192211);
    super.setVoipUIListener(paramc);
    if (this.xxL)
    {
      if (this.zBb) {
        ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAW, 0);
      }
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.zrd.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.al(false, bool);
      ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAV, 1);
      this.xxL = false;
      this.zAV.dXT();
      this.zAW.dXT();
      AppMethodBeat.o(192211);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(192214);
    ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAW);
    ((com.tencent.mm.plugin.voip.ui.c)this.zrd.get()).a(this.zAV);
    super.uninit();
    com.tencent.mm.sdk.b.a.ESL.d(this.zrl);
    setVisibility(4);
    AppMethodBeat.o(192214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */