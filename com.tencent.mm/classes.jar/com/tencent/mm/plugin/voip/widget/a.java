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
import com.tencent.mm.plugin.voip.ui.c;
import com.tencent.mm.plugin.voip.ui.e;
import com.tencent.mm.plugin.voip.video.render.VoIPRenderTextureView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.ar;
import java.lang.ref.WeakReference;

public final class a
  extends BaseSmallView
{
  private TextView BgP;
  private boolean ECo;
  VoIPRenderTextureView HpM;
  VoIPRenderTextureView HpN;
  boolean HpO;
  RelativeLayout HpP;
  boolean HpQ;
  private Runnable HpR;
  ImageView gBZ;
  private IListener hvF;
  private MMHandler kAn;
  private int mStatus;
  private float radius;
  TextView zTe;
  
  public a(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(235919);
    this.mStatus = -1;
    this.kAn = new MMHandler(Looper.getMainLooper());
    this.radius = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
    this.HpQ = false;
    this.HpR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235913);
        a locala = a.this;
        if ((!locala.HpO) && (locala.HpQ))
        {
          locala.HpO = true;
          locala.HpQ = false;
          locala.HpM.setVisibility(0);
          locala.HpM.xv(true);
          locala.HpN.xv(false);
          locala.HpN.animate().alpha(0.0F).setDuration(500L).setListener(new a.3(locala)).start();
        }
        AppMethodBeat.o(235913);
      }
    };
    this.hvF = new a.2(this);
    this.ECo = false;
    LayoutInflater.from(paramContext).inflate(2131496868, this);
    setClipToOutline(true);
    setOutlineProvider(new e(this.radius));
    this.BgP = ((TextView)findViewById(2131309163));
    this.HpP = ((RelativeLayout)findViewById(2131310040));
    this.HpP.setVisibility(4);
    this.gBZ = ((ImageView)findViewById(2131310038));
    this.zTe = ((TextView)findViewById(2131310039));
    this.HpM = ((VoIPRenderTextureView)findViewById(2131305591));
    this.BgP = ((TextView)findViewById(2131309163));
    this.HpN = ((VoIPRenderTextureView)findViewById(2131305590));
    this.HpN.xv(true);
    this.HpM.setClipToOutline(true);
    this.HpM.setOutlineProvider(new e(this.radius));
    this.HpN.setClipToOutline(true);
    this.HpN.setOutlineProvider(new e(this.radius));
    this.HpO = false;
    EventCenter.instance.addListener(this.hvF);
    setContentDescription(paramContext.getString(2131757548));
    AppMethodBeat.o(235919);
  }
  
  private void fMg()
  {
    AppMethodBeat.i(235930);
    this.BgP.setVisibility(8);
    AppMethodBeat.o(235930);
  }
  
  public final void aGx(String paramString)
  {
    AppMethodBeat.i(235926);
    this.BgP.setTextSize(1, 12.0F);
    this.BgP.setText(paramString);
    AppMethodBeat.o(235926);
  }
  
  public final void aGy(String paramString) {}
  
  public final void enR()
  {
    AppMethodBeat.i(235931);
    fMg();
    this.HpP.setVisibility(0);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690443, Color.parseColor("#FFFFFF")));
    this.zTe.setText(2131767364);
    this.zTe.requestLayout();
    super.enR();
    AppMethodBeat.o(235931);
  }
  
  public final boolean eoK()
  {
    AppMethodBeat.i(235927);
    super.eoK();
    fMg();
    this.HpP.setVisibility(0);
    this.gBZ.setImageDrawable(ar.m(getContext(), 2131690499, Color.parseColor("#FFFFFF")));
    this.zTe.setVisibility(0);
    this.zTe.setText(2131767321);
    this.zTe.requestLayout();
    AppMethodBeat.o(235927);
    return true;
  }
  
  public final void eoL()
  {
    AppMethodBeat.i(235932);
    this.BgP.setVisibility(8);
    this.HpP.setVisibility(8);
    AppMethodBeat.o(235932);
  }
  
  public final void fJm()
  {
    AppMethodBeat.i(235923);
    this.kAn.post(this.HpR);
    AppMethodBeat.o(235923);
  }
  
  public final void fMf()
  {
    AppMethodBeat.i(235922);
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.HpQ)) {
      this.HpN.xv(false);
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
      AppMethodBeat.o(235922);
      return;
      this.HpN.xv(true);
      this.HpM.xv(false);
    }
  }
  
  public final void onViewAdded(View paramView)
  {
    AppMethodBeat.i(235920);
    super.onViewAdded(paramView);
    if (this.Hen != null)
    {
      Log.i("MicroMsg.Voip.TalkingSmallView", "view added");
      if (this.HpQ) {
        ((c)this.Hen.get()).a(this.HpN, 0);
      }
      paramView = (c)this.Hen.get();
      if ((260 != this.mStatus) && (6 != this.mStatus)) {}
      for (boolean bool = true;; bool = false)
      {
        paramView.aE(false, bool);
        ((c)this.Hen.get()).a(this.HpM, 1);
        this.HpM.fMa();
        this.HpN.fMa();
        AppMethodBeat.o(235920);
        return;
      }
    }
    this.ECo = true;
    AppMethodBeat.o(235920);
  }
  
  public final void setStatus(int paramInt)
  {
    AppMethodBeat.i(235925);
    this.mStatus = paramInt;
    if ((this.mStatus == 2) || (this.mStatus == 256) || (this.mStatus == 0))
    {
      this.HpQ = true;
      this.HpM.xv(true);
      this.HpN.setVisibility(0);
      this.HpN.xv(false);
      this.BgP.setVisibility(0);
    }
    this.czp.postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(235918);
        a.this.findViewById(2131310037).setVisibility(8);
        AppMethodBeat.o(235918);
      }
    }, 3000L);
    if ((this.mStatus != 2) && (this.mStatus != 256) && (this.mStatus == 0))
    {
      this.HpM.setVisibility(0);
      this.HpM.xv(false);
      this.HpN.xv(true);
      this.BgP.setText("");
      this.BgP.setVisibility(8);
    }
    AppMethodBeat.o(235925);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(235928);
    if (this.GUk != paramInt)
    {
      fMg();
      this.GUk = paramInt;
      this.HpP.setVisibility(0);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      this.BgP.setVisibility(8);
      this.zTe.requestLayout();
      super.setVoicePlayDevice(paramInt);
      AppMethodBeat.o(235928);
      return;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690495, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767317);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690708, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767320);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690544, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767318);
      continue;
      this.gBZ.setImageDrawable(ar.m(getContext(), 2131690568, Color.parseColor("#FFFFFF")));
      this.zTe.setText(2131767319);
    }
  }
  
  public final void setVoipUIListener(c paramc)
  {
    AppMethodBeat.i(235921);
    super.setVoipUIListener(paramc);
    if (this.ECo)
    {
      if (this.HpQ) {
        ((c)this.Hen.get()).a(this.HpN, 0);
      }
      paramc = (c)this.Hen.get();
      if ((260 == this.mStatus) || (6 == this.mStatus)) {
        break label131;
      }
    }
    label131:
    for (boolean bool = true;; bool = false)
    {
      paramc.aE(false, bool);
      ((c)this.Hen.get()).a(this.HpM, 1);
      this.ECo = false;
      this.HpM.fMa();
      this.HpN.fMa();
      AppMethodBeat.o(235921);
      return;
    }
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(235924);
    ((c)this.Hen.get()).a(this.HpN);
    ((c)this.Hen.get()).a(this.HpM);
    super.uninit();
    EventCenter.instance.removeListener(this.hvF);
    setVisibility(4);
    AppMethodBeat.o(235924);
  }
  
  public final void xm(boolean paramBoolean)
  {
    AppMethodBeat.i(235929);
    if (paramBoolean)
    {
      this.BgP.setVisibility(0);
      this.BgP.setText(2131767333);
      AppMethodBeat.o(235929);
      return;
    }
    super.xm(false);
    AppMethodBeat.o(235929);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.widget.a
 * JD-Core Version:    0.7.0.1
 */