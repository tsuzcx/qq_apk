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
import com.tencent.mm.g.a.lk;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  private boolean Atj;
  VoIPRenderTextureView CKV;
  VoIPRenderTextureView CKW;
  boolean CKX;
  RelativeLayout CKY;
  TextView CKZ;
  private float CLa;
  boolean CLb;
  private Runnable CLc;
  ImageView fWT;
  private com.tencent.mm.sdk.b.c gIM;
  private aq jzz;
  private int mStatus;
  private float radius;
  private TextView xiT;
  
  public a(Context paramContext, float paramFloat)
  {
    super(paramContext, null);
    AppMethodBeat.i(210274);
    this.mStatus = -1;
    this.jzz = new aq(Looper.getMainLooper());
    this.radius = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 12);
    this.CLb = false;
    this.CLc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210268);
        a locala = a.this;
        if ((!locala.CKX) && (locala.CLb))
        {
          locala.CKX = true;
          locala.CLb = false;
          locala.CKV.setVisibility(0);
          locala.CKV.tN(true);
          locala.CKW.tN(false);
          locala.CKW.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(210268);
      }
    };
    this.gIM = new com.tencent.mm.sdk.b.c() {};
    this.Atj = false;
    LayoutInflater.from(paramContext).inflate(2131495888, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.xiT = ((TextView)findViewById(2131305880));
    this.CKY = ((RelativeLayout)findViewById(2131306580));
    this.CKY.setVisibility(4);
    this.fWT = ((ImageView)findViewById(2131306578));
    this.CKZ = ((TextView)findViewById(2131306579));
    this.CLa = paramFloat;
    this.CKV = ((VoIPRenderTextureView)findViewById(2131302998));
    this.xiT = ((TextView)findViewById(2131305880));
    this.CKW = ((VoIPRenderTextureView)findViewById(2131302997));
    this.CKW.tN(true);
    this.CKV.setClipToOutline(true);
    this.CKV.setOutlineProvider(new e(this.radius));
    this.CKW.setClipToOutline(true);
    this.CKW.setOutlineProvider(new e(this.radius));
    this.CKX = false;
    com.tencent.mm.sdk.b.a.IvT.c(this.gIM);
    setContentDescription(paramContext.getString(2131757334));
    AppMethodBeat.o(210274);
  }
  
  private void eEY()
  {
    AppMethodBeat.i(210285);
    this.xiT.setVisibility(8);
    AppMethodBeat.o(210285);
  }
  
  public final void aFc(String paramString) {}
  
  public final void aFd(String paramString)
  {
    AppMethodBeat.i(210281);
    this.xiT.setTextSize(1, 12.0F);
    this.xiT.setText(paramString);
    AppMethodBeat.o(210281);
  }
  
  public final void dtu()
  {
    AppMethodBeat.i(210286);
    eEY();
    this.CKY.setVisibility(0);
    this.fWT.setImageDrawable(ao.k(getContext(), 2131690327, Color.parseColor("#FFFFFF")));
    this.CKZ.setText(2131764923);
    this.CKZ.requestLayout();
    super.dtu();
    AppMethodBeat.o(210286);
  }
  
  public final boolean eCQ()
  {
    AppMethodBeat.i(210282);
    super.eCQ();
    eEY();
    this.CKY.setVisibility(0);
    this.fWT.setImageDrawable(ao.k(getContext(), 2131690360, Color.parseColor("#FFFFFF")));
    this.CKZ.setVisibility(0);
    this.CKZ.setText(2131764882);
    this.CKZ.requestLayout();
    AppMethodBeat.o(210282);
    return true;
  }
  
  public final void eCR()
  {
    AppMethodBeat.i(210287);
    this.xiT.setVisibility(8);
    this.CKY.setVisibility(8);
    AppMethodBeat.o(210287);
  }
  
  public final void eCr()
  {
    AppMethodBeat.i(210278);
    this.jzz.post(this.CLc);
    AppMethodBeat.o(210278);
  }
  
  public final void eEX()
  {
    AppMethodBeat.i(210277);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.CLb)) {
      this.CKW.tN(false);
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
      AppMethodBeat.o(210277);
      return;
      this.CKW.tN(true);
      this.CKV.tN(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(210275);
    super.onViewAdded(paramView);
    if (this.CAv != null)
    {
      ae.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.CLb) {
        ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKW, 0);
      }
      paramView = (com.tencent.mm.plugin.voip.ui.c)this.CAv.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.at(false, bool);
        ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKV, 1);
        this.CKV.eEW();
        this.CKW.eEW();
        AppMethodBeat.o(210275);
        return;
      }
    }
    this.Atj = true;
    AppMethodBeat.o(210275);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(210280);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.CLb = true;
      this.CKV.tN(true);
      this.CKW.setVisibility(0);
      this.CKW.tN(false);
      this.xiT.setVisibility(0);
    }
    this.gNm.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210273);
        a.this.findViewById(2131306577).setVisibility(8);
        AppMethodBeat.o(210273);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.CKV.setVisibility(0);
      this.CKV.tN(false);
      this.CKW.tN(true);
      this.xiT.setText("");
      this.xiT.setVisibility(8);
    }
    AppMethodBeat.o(210280);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(210283);
    if (this.Cqn != paramInt)
    {
      eEY();
      this.Cqn = paramInt;
      this.CKY.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.xiT.setVisibility(8);
      this.CKZ.requestLayout();
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(210283);
      return;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690357, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764878);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764881);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690395, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764879);
      continue;
      this.fWT.setImageDrawable(ao.k(getContext(), 2131690411, Color.parseColor("#FFFFFF")));
      this.CKZ.setText(2131764880);
    }
  }
  
  public final void setVoipUIListener(com.tencent.mm.plugin.voip.ui.c paramc)
  {
    AppMethodBeat.i(210276);
    super.setVoipUIListener(paramc);
    if (this.Atj)
    {
      if (this.CLb) {
        ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKW, 0);
      }
      paramc = (com.tencent.mm.plugin.voip.ui.c)this.CAv.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.at(false, bool);
      ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKV, 1);
      this.Atj = false;
      this.CKV.eEW();
      this.CKW.eEW();
      AppMethodBeat.o(210276);
      return;
    }
  }
  
  public final void tC(boolean paramBoolean)
  {
    AppMethodBeat.i(210284);
    if (paramBoolean)
    {
      this.xiT.setVisibility(0);
      this.xiT.setText(2131764894);
      AppMethodBeat.o(210284);
      return;
    }
    super.tC(false);
    AppMethodBeat.o(210284);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(210279);
    ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKW);
    ((com.tencent.mm.plugin.voip.ui.c)this.CAv.get()).a(this.CKV);
    super.uninit();
    com.tencent.mm.sdk.b.a.IvT.d(this.gIM);
    setVisibility(4);
    AppMethodBeat.o(210279);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */