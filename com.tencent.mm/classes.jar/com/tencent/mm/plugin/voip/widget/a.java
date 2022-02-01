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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.am;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  VoIPRenderTextureView ATj;
  VoIPRenderTextureView ATk;
  boolean ATl;
  RelativeLayout ATm;
  TextView ATn;
  private float ATo;
  boolean ATp;
  private Runnable ATq;
  ImageView fBA;
  private com.tencent.mm.sdk.b.c gmw;
  private ao jdu;
  private int mStatus;
  private float radius;
  private TextView uhg;
  private TextView vLT;
  private boolean yKB;
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(208547);
    this.mStatus = -1;
    this.jdu = new ao(Looper.getMainLooper());
    this.radius = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 12);
    this.ATp = false;
    this.ATq = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208541);
        a locala = a.this;
        if ((!locala.ATl) && (locala.ATp))
        {
          locala.ATl = true;
          locala.ATp = false;
          locala.ATj.setVisibility(0);
          locala.ATj.sW(true);
          locala.ATk.sW(false);
          locala.ATk.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(208541);
      }
    };
    this.gmw = new a.2(this);
    this.yKB = false;
    LayoutInflater.from(paramContext).inflate(2131495888, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.uhg = ((TextView)findViewById(2131305822));
    this.vLT = ((TextView)findViewById(2131305880));
    this.ATm = ((RelativeLayout)findViewById(2131306580));
    this.ATm.setVisibility(4);
    this.fBA = ((ImageView)findViewById(2131306578));
    this.ATn = ((TextView)findViewById(2131306579));
    this.ATo = paramFloat;
    this.ATj = ((VoIPRenderTextureView)findViewById(2131302998));
    this.uhg = ((TextView)findViewById(2131305822));
    this.vLT = ((TextView)findViewById(2131305880));
    this.ATk = ((VoIPRenderTextureView)findViewById(2131302997));
    this.ATk.sW(true);
    this.ATj.setClipToOutline(true);
    this.ATj.setOutlineProvider(new e(this.radius));
    this.ATk.setClipToOutline(true);
    this.ATk.setOutlineProvider(new e(this.radius));
    this.ATl = false;
    com.tencent.mm.sdk.b.a.GpY.c(this.gmw);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(208547);
  }
  
  private void enr()
  {
    AppMethodBeat.i(208558);
    this.vLT.setVisibility(8);
    this.uhg.setVisibility(8);
    AppMethodBeat.o(208558);
  }
  
  public final void ayB(String paramString) {}
  
  public final void ayC(String paramString)
  {
    AppMethodBeat.i(208554);
    this.uhg.setTextSize(1, 12.0F);
    this.uhg.setText(paramString);
    AppMethodBeat.o(208554);
  }
  
  public final void dgi()
  {
    AppMethodBeat.i(208559);
    enr();
    this.ATm.setVisibility(0);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.ATn.setText(2131764923);
    super.dgi();
    AppMethodBeat.o(208559);
  }
  
  public final void ekY()
  {
    AppMethodBeat.i(208551);
    this.jdu.post(this.ATq);
    AppMethodBeat.o(208551);
  }
  
  public final boolean ely()
  {
    AppMethodBeat.i(208555);
    super.ely();
    enr();
    this.ATm.setVisibility(0);
    this.fBA.setImageDrawable(am.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.ATn.setVisibility(0);
    this.ATn.setText(2131764882);
    AppMethodBeat.o(208555);
    return true;
  }
  
  public final void elz()
  {
    AppMethodBeat.i(208560);
    this.vLT.setVisibility(8);
    this.ATm.setVisibility(8);
    AppMethodBeat.o(208560);
  }
  
  public final void enq()
  {
    AppMethodBeat.i(208550);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.ATp)) {
      this.ATk.sW(false);
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
      AppMethodBeat.o(208550);
      return;
      this.ATk.sW(true);
      this.ATj.sW(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(208548);
    super.onViewAdded(paramView);
    if (this.AJQ != null)
    {
      ac.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.ATp) {
        ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATk, 0);
      }
      paramView = (com.tencent.mm.plugin.voip.ui.c)this.AJQ.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.ap(false, bool);
        ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATj, 1);
        this.ATj.enp();
        this.ATk.enp();
        AppMethodBeat.o(208548);
        return;
      }
    }
    this.yKB = true;
    AppMethodBeat.o(208548);
  }
  
  public final void sM(boolean paramBoolean)
  {
    AppMethodBeat.i(208557);
    if (paramBoolean)
    {
      this.vLT.setVisibility(0);
      this.vLT.setText(2131764894);
      this.uhg.setVisibility(8);
      AppMethodBeat.o(208557);
      return;
    }
    super.sM(false);
    AppMethodBeat.o(208557);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(208553);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.ATp = true;
      this.ATj.sW(true);
      this.ATk.setVisibility(0);
      this.ATk.sW(false);
      this.uhg.setVisibility(0);
    }
    this.gqT.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(208546);
        a.this.findViewById(2131306577).setVisibility(8);
        AppMethodBeat.o(208546);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.ATj.setVisibility(0);
      this.ATj.sW(false);
      this.ATk.sW(true);
      this.uhg.setText("");
      this.uhg.setVisibility(8);
    }
    AppMethodBeat.o(208553);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(208556);
    if (this.AzM != paramInt)
    {
      enr();
      this.AzM = paramInt;
      this.ATm.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.uhg.setVisibility(8);
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(208556);
      return;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764878);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764881);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764879);
      continue;
      this.fBA.setImageDrawable(am.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.ATn.setText(2131764880);
    }
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(208549);
    super.setVoipUIListener(paramc);
    if (this.yKB)
    {
      if (this.ATp) {
        ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATk, 0);
      }
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.AJQ.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.ap(false, bool);
      ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATj, 1);
      this.yKB = false;
      this.ATj.enp();
      this.ATk.enp();
      AppMethodBeat.o(208549);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(208552);
    ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATk);
    ((com.tencent.mm.plugin.voip.ui.c)this.AJQ.get()).a(this.ATj);
    super.uninit();
    com.tencent.mm.sdk.b.a.GpY.d(this.gmw);
    setVisibility(4);
    AppMethodBeat.o(208552);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */