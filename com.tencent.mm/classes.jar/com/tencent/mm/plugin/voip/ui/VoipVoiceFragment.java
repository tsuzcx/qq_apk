package com.tencent.mm.plugin.voip.ui;

import android.graphics.Point;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.e.a.c;
import com.tencent.mm.plugin.voip.f.k;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.widget.VoIPControlIconLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import java.lang.ref.WeakReference;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private TextView UIm;
  private final MTimerHandler.CallBack UKO;
  private TextView UKU;
  private TextView UKV;
  private TextView UKW;
  private boolean UKX;
  private boolean UKY;
  private MTimerHandler eln;
  private boolean wXz;
  private Runnable ykR;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.wXz = false;
    this.UKX = false;
    this.UKY = false;
    this.UKO = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(292482);
        String str = VoipVoiceFragment.iY(Util.secondsToNow(VoipVoiceFragment.this.UJc));
        VoipVoiceFragment.a(VoipVoiceFragment.this).setText(str);
        VoipVoiceFragment.a(VoipVoiceFragment.this).setContentDescription(VoipVoiceFragment.this.iaO());
        VoipVoiceFragment.b(VoipVoiceFragment.this);
        AppMethodBeat.o(292482);
        return true;
      }
    };
    this.ykR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(292494);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(292494);
          return;
        }
        VoipVoiceFragment.c(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(292494);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void aqY(int paramInt)
  {
    AppMethodBeat.i(115480);
    if (this.UKl != null) {
      this.UKl.iav();
    }
    this.UKU.setVisibility(8);
    if (this.UKp != null) {
      this.UKp.iaz();
    }
    if ((this.UKp != null) && (paramInt != 4097) && (this.UKp.aqR(2))) {
      mE(b.g.voip_audio_talking_hint, 10000);
    }
    iaM();
    this.UKW.setVisibility(8);
    if (SubCoreVoip.hVp().Uxv != null)
    {
      this.UKW.setVisibility(0);
      this.UKW.setText(SubCoreVoip.hVp().Uxv);
    }
    if (UKe == 2) {
      this.UKY = true;
    }
    AppMethodBeat.o(115480);
  }
  
  private void bYv()
  {
    AppMethodBeat.i(115491);
    if ((this.eln == null) || (this.wXz))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.UJc) {
      this.UJc = Util.nowSecond();
    }
    this.wXz = true;
    this.eln.startTimer(50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void iaR()
  {
    AppMethodBeat.i(115482);
    if (this.UKp != null) {
      this.UKp.iaB();
    }
    AppMethodBeat.o(115482);
  }
  
  private void iaS()
  {
    AppMethodBeat.i(115483);
    if (this.UKl != null) {
      this.UKl.GD(false);
    }
    if (this.UKp != null) {
      this.UKp.GD(false);
    }
    if (UKe == 256)
    {
      this.UKY = true;
      mE(b.g.voip_audio_talking_hint_from, 10000);
    }
    iaM();
    this.UKW.setVisibility(8);
    if (SubCoreVoip.hVp().Uxv != null)
    {
      this.UKW.setVisibility(0);
      this.UKW.setText(SubCoreVoip.hVp().Uxv);
    }
    AppMethodBeat.o(115483);
  }
  
  private void ial()
  {
    AppMethodBeat.i(115479);
    if (this.UKl != null) {
      this.UKl.ial();
    }
    this.UKU.setVisibility(8);
    if (this.UKp != null) {
      this.UKp.GE(false);
    }
    this.UKW.setVisibility(8);
    if (SubCoreVoip.hVp().Uxv != null)
    {
      this.UKW.setVisibility(0);
      this.UKW.setText(SubCoreVoip.hVp().Uxv);
    }
    if ((this.UKp != null) && (this.UKp.aqR(2))) {
      mE(b.g.voip_audio_talking_hint, 10000);
    }
    iaM();
    AppMethodBeat.o(115479);
  }
  
  private void iaw()
  {
    AppMethodBeat.i(115481);
    if (this.UKl != null) {
      this.UKl.iaw();
    }
    if (this.UKp != null) {
      this.UKp.GF(false);
    }
    AppMethodBeat.o(115481);
  }
  
  private void iax()
  {
    AppMethodBeat.i(115484);
    if (this.UKl != null) {
      this.UKl.iax();
    }
    if (this.UKp != null) {
      this.UKp.GG(false);
    }
    mE(b.g.voip_audio_talking_hint, 10000);
    iaM();
    AppMethodBeat.o(115484);
  }
  
  private void iay()
  {
    AppMethodBeat.i(115485);
    this.UKU.setVisibility(0);
    if ((this.UKm != null) && (this.UKl != null))
    {
      this.UKm.removeAllViews();
      this.UKl.a(getContext(), this.UKm, this.luk, false);
      iaK();
    }
    if (this.UKl != null) {
      this.UKl.iay();
    }
    if (this.UKn != null) {
      this.UKn.iay();
    }
    if (this.UKp != null) {
      this.UKp.iaA();
    }
    if (!this.UKY) {
      mE(b.g.voip_accept_invite_normal, 10000);
    }
    for (;;)
    {
      if (z.pCZ) {
        this.UIm.setVisibility(0);
      }
      iaM();
      bYv();
      this.UKW.setVisibility(8);
      if (SubCoreVoip.hVp().Uxv != null)
      {
        this.UKW.setVisibility(0);
        this.UKW.setText(SubCoreVoip.hVp().Uxv);
      }
      AppMethodBeat.o(115485);
      return;
      if ((this.UKp != null) && (this.UKp.aqR(2))) {
        mE(b.g.voip_accept_invite_video_to_audio_without_headset, 10000);
      } else if ((this.UKp != null) && (this.UKp.aqR(3))) {
        mE(b.g.voip_accept_invite_video_to_audio_with_headset, 10000);
      }
    }
  }
  
  protected final void GA(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.LvT)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.JQB != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.JQB.setText(b.g.voip_net_status_self_warning_hint);
    }
    for (;;)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.JQB.setText(b.g.voip_net_status_other_warning_hint);
    }
  }
  
  public final void a(a.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(292788);
    super.a(paramc, paramBundle);
    switch (3.UIW[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(292788);
      return;
      h.OAn.b(11619, new Object[] { Integer.valueOf(3) });
      AppMethodBeat.o(292788);
      return;
      if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVO()) && (this.UKp != null))
      {
        mE(b.g.voip_cancel_call, -1);
        this.UKp.iaC();
        AppMethodBeat.o(292788);
        return;
        h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(2) });
        if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVM()))
        {
          if (this.UKl != null) {
            this.UKl.iau();
          }
          this.UKU.setVisibility(8);
          if (this.UKp != null)
          {
            this.UKp.iaD();
            AppMethodBeat.o(292788);
            return;
            h.OAn.a(11526, true, true, new Object[] { Integer.valueOf(SubCoreVoip.hVp().hYr()), Long.valueOf(SubCoreVoip.hVp().hVw()), Long.valueOf(SubCoreVoip.hVp().hWC()), Integer.valueOf(5) });
            if ((this.UJb != null) && (this.UJb.get() != null) && (((c)this.UJb.get()).hVL()))
            {
              if (this.UKp != null) {
                this.UKp.iaE();
              }
              mE(b.g.voip_reject_call, -1);
              if (this.UKh != null) {
                this.UKh.aq(true, false);
              }
            }
          }
        }
      }
    }
  }
  
  protected final void aDJ(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.UKW != null)
    {
      this.UKW.setVisibility(0);
      this.UKW.setText(paramString);
      this.UKW.sendAccessibilityEvent(128);
    }
    AppMethodBeat.o(115486);
  }
  
  protected final int getLayoutId()
  {
    return b.e.voip_voice_fragment;
  }
  
  public final void iU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.iU(paramInt1, paramInt2);
    Log.i("MicroMsg.VoipVoiceFragment", "newState: " + k.arg(paramInt2) + ", action: " + k.arg(paramInt1) + ", lastStatus: " + k.arg(UKe) + ", isSwitchFromVideo: " + this.UKY);
    if (this.thl == null)
    {
      Log.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
      AppMethodBeat.o(115477);
      return;
    }
    switch (paramInt2)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(115477);
      return;
      ial();
      AppMethodBeat.o(115477);
      return;
      aqY(paramInt1);
      AppMethodBeat.o(115477);
      return;
      iaw();
      AppMethodBeat.o(115477);
      return;
      iay();
      AppMethodBeat.o(115477);
      return;
      iaR();
      AppMethodBeat.o(115477);
      return;
      iaS();
      AppMethodBeat.o(115477);
      return;
      iax();
    }
  }
  
  protected final boolean iah()
  {
    return false;
  }
  
  protected final void iaj()
  {
    AppMethodBeat.i(115489);
    if (this.JQB != null)
    {
      this.JQB.clearAnimation();
      this.JQB.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  protected final void mE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.UKV == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.UKV.setText(paramInt1);
    this.UKV.setVisibility(0);
    this.UKV.sendAccessibilityEvent(128);
    this.UKV.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.UKV.setBackgroundResource(b.c.voip_toast_bg);
    this.UKV.setCompoundDrawables(null, null, null, null);
    this.UKV.setCompoundDrawablePadding(0);
    this.qse.removeCallbacks(this.ykR);
    if (-1 != paramInt2) {
      this.qse.postDelayed(this.ykR, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public final void n(Point paramPoint) {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(292623);
    super.onCreate(paramBundle);
    AppMethodBeat.o(292623);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.UKb = ((ImageView)this.thl.findViewById(b.d.voip_blur_avatar));
    this.UKU = ((TextView)this.thl.findViewById(b.d.voip_voice_time));
    this.UKV = ((TextView)this.thl.findViewById(b.d.voip_voice_call_hint));
    this.UKW = ((TextView)this.thl.findViewById(b.d.voip_voice_risk_call_hint));
    this.JQB = ((TextView)this.thl.findViewById(b.d.voip_net_status_hint));
    this.Ltg = ((ImageView)this.thl.findViewById(b.d.link_arrow));
    this.Ltg.setImageDrawable(bb.m(MMApplicationContext.getContext(), b.f.icons_filled_arrow, -1));
    this.UKU.setImportantForAccessibility(1);
    if (z.pCZ) {
      this.UIm = ((TextView)this.thl.findViewById(b.d.engineInfo));
    }
    int i = aa.be(getActivity());
    if (this.UKn != null) {
      this.UKn.aqV(i);
    }
    if (this.UKl != null)
    {
      paramLayoutInflater = this.UKl.UJv;
      if (paramLayoutInflater != null)
      {
        paramViewGroup = paramLayoutInflater.getLayoutParams();
        if (paramViewGroup == null)
        {
          paramLayoutInflater = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
          AppMethodBeat.o(115476);
          throw paramLayoutInflater;
        }
        paramViewGroup = (RelativeLayout.LayoutParams)paramViewGroup;
        paramViewGroup.topMargin = (i + paramViewGroup.topMargin);
        paramLayoutInflater.setLayoutParams((ViewGroup.LayoutParams)paramViewGroup);
      }
    }
    if ((this.UKp != null) && (this.Uxb) && (this.UKp.aqR(2))) {
      mE(b.g.voip_audio_talking_hint, 10000);
    }
    this.eln = new MTimerHandler(Looper.myLooper(), this.UKO, true);
    iU(this.UKd, this.mStatus);
    paramLayoutInflater = this.thl;
    AppMethodBeat.o(115476);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.wXz = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(115490);
    Log.printInfoStack("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    if (this.UKp != null)
    {
      localObject = this.UKp;
      if (((g)localObject).mIsMute != paramBoolean)
      {
        ((g)localObject).mIsMute = paramBoolean;
        localObject = ((g)localObject).UJI;
        if (localObject != null) {
          if (paramBoolean) {
            break label79;
          }
        }
      }
    }
    label79:
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((VoIPControlIconLayout)localObject).setChecked(paramBoolean);
      AppMethodBeat.o(115490);
      return;
    }
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if ((paramInt != -1) && (this.UKp != null))
    {
      g localg = this.UKp;
      if (localg.Uxg != paramInt)
      {
        localg.Uxg = paramInt;
        localg.iaH();
      }
    }
    AppMethodBeat.o(115492);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115478);
    if (this.eln != null)
    {
      this.eln.stopTimer();
      this.eln = null;
    }
    super.uninit();
    AppMethodBeat.o(115478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */