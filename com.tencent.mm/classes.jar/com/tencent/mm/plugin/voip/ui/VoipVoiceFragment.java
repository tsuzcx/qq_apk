package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.voip.b.c;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.plugin.voip.b.e;
import com.tencent.mm.plugin.voip.b.f;
import com.tencent.mm.plugin.voip.b.g;
import com.tencent.mm.plugin.voip.c.k;
import com.tencent.mm.plugin.voip.c.m;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.az;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private WeImageView FzS;
  private int NKw;
  private Button NTR;
  private View.OnClickListener NUS;
  private View.OnClickListener NUT;
  private TextView NUg;
  private boolean NUz;
  private TextView NWA;
  private View NWB;
  private RelativeLayout NWC;
  private MMCheckBox NWD;
  private TextView NWE;
  private RelativeLayout NWF;
  private MMCheckBox NWG;
  private TextView NWH;
  private TextView NWI;
  private TextView NWJ;
  private VoipBigIconButton NWK;
  private VoipBigIconButton NWL;
  private VoipBigIconButton NWM;
  private VoipBigIconButton NWN;
  private VoipSmallIconButton NWO;
  private boolean NWP;
  private View.OnClickListener NWQ;
  private View.OnClickListener NWR;
  private View.OnClickListener NWS;
  private View.OnClickListener NWT;
  private View.OnClickListener NWU;
  private View.OnClickListener NWV;
  private final MTimerHandler.CallBack NWl;
  private View NWu;
  private ImageView NWv;
  private TextView NWw;
  private TextView NWx;
  private TextView NWy;
  private TextView NWz;
  private MTimerHandler cts;
  private boolean mIsMute;
  private boolean tUj;
  private Runnable uYG;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.NKw = 1;
    this.mIsMute = false;
    this.tUj = false;
    this.NUz = false;
    this.NWP = false;
    this.NWl = new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(244418);
        String str = VoipVoiceFragment.GN(Util.secondsToNow(VoipVoiceFragment.this.NVf));
        VoipVoiceFragment.a(VoipVoiceFragment.this).setText(str);
        VoipVoiceFragment.b(VoipVoiceFragment.this);
        AppMethodBeat.o(244418);
        return true;
      }
    };
    this.NUS = new VoipVoiceFragment.5(this);
    this.NUT = new VoipVoiceFragment.6(this);
    this.NWQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        boolean bool = VoipVoiceFragment.d(VoipVoiceFragment.this).isChecked();
        Log.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.d(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null)) {
          ((c)VoipVoiceFragment.this.NVe.get()).AM(bool);
        }
        paramAnonymousView = VoipVoiceFragment.this;
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          VoipVoiceFragment.a(paramAnonymousView, i);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setEnabled(true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115469);
          return;
        }
      }
    };
    this.NWR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        boolean bool = VoipVoiceFragment.e(VoipVoiceFragment.this).isChecked();
        Log.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.e(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null)) {
          ((c)VoipVoiceFragment.this.NVe.get()).uy(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.e(VoipVoiceFragment.this).setEnabled(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115470);
      }
    };
    this.NWS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115471);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAn()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAo()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gyI()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null) && (((c)VoipVoiceFragment.this.NVe.get()).gxL()))
        {
          VoipVoiceFragment.f(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setText(b.g.voip_waitting);
          VoipVoiceFragment.this.NVy.a(VoipVoiceFragment.h(VoipVoiceFragment.this), VoipBaseFragment.NVs);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.a(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.j(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.k(VoipVoiceFragment.this).setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115471);
      }
    };
    this.NWT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115472);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        com.tencent.mm.plugin.report.service.h.IzE.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAn()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gAo()), Long.valueOf(com.tencent.mm.plugin.voip.c.gxs().gyI()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null) && (((c)VoipVoiceFragment.this.NVe.get()).gxK()))
        {
          VoipVoiceFragment.j(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.kS(b.g.voip_reject_call, -1);
          if (VoipVoiceFragment.this.NVx != null) {
            VoipVoiceFragment.this.NVx.aU(true, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115472);
      }
    };
    this.NWU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(240844);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null) && (((c)VoipVoiceFragment.this.NVe.get()).gxG())) {
          VoipVoiceFragment.this.kS(b.g.voip_finish_call, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(240844);
      }
    };
    this.NWV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(236386);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
        if ((VoipVoiceFragment.this.NVe != null) && (VoipVoiceFragment.this.NVe.get() != null) && (((c)VoipVoiceFragment.this.NVe.get()).gxN()))
        {
          VoipVoiceFragment.this.kS(b.g.voip_cancel_call, -1);
          VoipVoiceFragment.l(VoipVoiceFragment.this).setEnabled(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(236386);
      }
    };
    this.uYG = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(236219);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(236219);
          return;
        }
        VoipVoiceFragment.m(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(236219);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void alp(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.NWu.setVisibility(0);
    this.NWy.setVisibility(8);
    this.NWz.setText(b.g.voip_invite_waiting_tip);
    this.NVy.a(this.NWA, NVs);
    this.NWB.setVisibility(0);
    if (this.NWx != null)
    {
      if ((!as.bvK(this.iSn)) || (Util.isNullOrNil(this.NWx.getText()))) {
        break label280;
      }
      this.NWx.setVisibility(0);
    }
    for (;;)
    {
      this.NWK.setVisibility(8);
      this.NWL.setVisibility(8);
      this.NWM.setVisibility(8);
      this.NWN.setVisibility(0);
      this.NWO.setVisibility(8);
      this.NWF.setVisibility(0);
      this.NWG.setEnabled(false);
      this.NWG.setBackgroundResource(b.c.voip_voiceoff_disable);
      this.NWH.setTextColor(1728053247);
      gCg();
      this.NWG.setChecked(this.mIsMute);
      this.NWC.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.NKw)) {
        kS(b.g.voip_audio_talking_hint, 10000);
      }
      gBV();
      this.NWJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
      {
        this.NWJ.setVisibility(0);
        this.NWJ.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
      }
      if (NVw == 2) {
        this.NWP = true;
      }
      AppMethodBeat.o(115480);
      return;
      label280:
      this.NWx.setVisibility(8);
    }
  }
  
  private void bzG()
  {
    AppMethodBeat.i(115491);
    if ((this.cts == null) || (this.tUj))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.NVf) {
      this.NVf = Util.nowSecond();
    }
    this.tUj = true;
    this.cts.startTimer(50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void gBO()
  {
    AppMethodBeat.i(115479);
    this.NWu.setVisibility(0);
    this.NWy.setVisibility(8);
    this.NWz.setText(b.g.voip_outcalling);
    this.NVy.a(this.NWA, NVs);
    this.NWB.setVisibility(0);
    this.NWK.setVisibility(8);
    this.NWL.setVisibility(8);
    this.NWM.setVisibility(8);
    this.NWN.setVisibility(0);
    this.NWO.setVisibility(8);
    this.NWF.setVisibility(0);
    this.NWG.setEnabled(false);
    this.NWG.setBackgroundResource(b.c.voip_voiceoff_disable);
    this.NWH.setTextColor(1728053247);
    this.NWJ.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
    {
      this.NWJ.setVisibility(0);
      this.NWJ.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
    }
    gCg();
    this.NWG.setChecked(this.mIsMute);
    this.NWC.setVisibility(0);
    if (2 == this.NKw) {
      kS(b.g.voip_audio_talking_hint, 10000);
    }
    gBV();
    AppMethodBeat.o(115479);
  }
  
  private void gCb()
  {
    AppMethodBeat.i(115481);
    this.NWz.setText(b.g.voip_waitting);
    this.NVy.a(this.NWA, NVs);
    this.NWK.setVisibility(8);
    this.NWL.setVisibility(8);
    this.NWM.setVisibility(0);
    this.NWN.setVisibility(8);
    this.NWO.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void gCc()
  {
    AppMethodBeat.i(115482);
    this.NVy.gBX();
    this.NWM.setEnabled(false);
    this.NWN.setEnabled(false);
    this.NWK.setEnabled(false);
    this.NWL.setEnabled(false);
    this.NWO.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void gCd()
  {
    AppMethodBeat.i(115483);
    this.NWu.setVisibility(0);
    this.NWB.setVisibility(0);
    this.NWz.setText(b.g.voip_invited_audio_tip);
    this.NVy.a(this.NWA, NVs);
    if (this.NWx != null)
    {
      if ((!as.bvK(this.iSn)) || (Util.isNullOrNil(this.NWx.getText()))) {
        break label211;
      }
      this.NWx.setVisibility(0);
    }
    for (;;)
    {
      gCg();
      this.NWK.setVisibility(0);
      this.NWL.setVisibility(0);
      this.NWM.setVisibility(8);
      this.NWN.setVisibility(8);
      if (this.NUz) {
        this.NWO.setVisibility(0);
      }
      if (NVw == 256)
      {
        this.NWP = true;
        kS(b.g.voip_audio_talking_hint_from, 10000);
      }
      gBV();
      this.NWJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
      {
        this.NWJ.setVisibility(0);
        this.NWJ.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.NWx.setVisibility(8);
    }
  }
  
  private void gCe()
  {
    AppMethodBeat.i(115484);
    this.NWu.setVisibility(0);
    this.NWB.setVisibility(0);
    this.NWz.setText(b.g.voip_waitting);
    this.NVy.a(this.NWA, NVs);
    this.NWK.setVisibility(8);
    this.NWL.setVisibility(8);
    this.NWM.setVisibility(0);
    this.NWN.setVisibility(8);
    this.NWO.setVisibility(8);
    kS(b.g.voip_audio_talking_hint, 10000);
    gBV();
    AppMethodBeat.o(115484);
  }
  
  private void gCf()
  {
    AppMethodBeat.i(115485);
    this.NWN.setVisibility(8);
    this.NWK.setVisibility(8);
    this.NWL.setVisibility(8);
    this.NWO.setVisibility(8);
    this.NWB.setVisibility(8);
    this.NVy.gBX();
    this.NWM.setVisibility(0);
    this.NWy.setVisibility(0);
    this.NWF.setVisibility(0);
    this.NWC.setVisibility(0);
    this.NWu.setVisibility(0);
    this.NTR.setVisibility(0);
    this.NWG.setEnabled(true);
    this.NWG.setBackgroundResource(b.c.voip_switch_audio_btn);
    this.NWH.setTextColor(-1);
    gCg();
    this.NWG.setChecked(this.mIsMute);
    if (!this.NWP) {
      kS(b.g.voip_accept_invite_normal, 10000);
    }
    for (;;)
    {
      if (ac.mGz) {
        this.NUg.setVisibility(0);
      }
      gBV();
      bzG();
      this.NWJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.gxs().NKK != null)
      {
        this.NWJ.setVisibility(0);
        this.NWJ.setText(com.tencent.mm.plugin.voip.c.gxs().NKK);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.NKw) {
        kS(b.g.voip_accept_invite_video_to_audio_without_headset, 10000);
      } else if (3 == this.NKw) {
        kS(b.g.voip_accept_invite_video_to_audio_with_headset, 10000);
      }
    }
  }
  
  private void gCg()
  {
    AppMethodBeat.i(115493);
    if ((this.NWD == null) || (this.NWE == null))
    {
      Log.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.NKw) || (3 == this.NKw))
    {
      this.NWD.setEnabled(false);
      this.NWE.setTextColor(1728053247);
      this.NWD.setBackgroundResource(b.c.voip_speaker_disable);
      Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.NKw == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.NWD.setBackgroundResource(b.c.voip_switch_speaker_btn);
      this.NWD.setEnabled(true);
      this.NWE.setTextColor(-1);
      this.NWD.setChecked(bool);
      Log.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  protected final void Bc(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.FzP)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.DZt != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.DZt.setText(b.g.voip_net_status_self_warning_hint);
    }
    for (;;)
    {
      this.DZt.clearAnimation();
      this.DZt.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.DZt.setText(b.g.voip_net_status_other_warning_hint);
    }
  }
  
  protected final void bgj(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.NWJ != null)
    {
      this.NWJ.setVisibility(0);
      this.NWJ.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  protected final void gBM()
  {
    AppMethodBeat.i(115489);
    if (this.DZt != null)
    {
      this.DZt.clearAnimation();
      this.DZt.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void kR(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.kR(paramInt1, paramInt2);
    Log.i("MicroMsg.VoipVoiceFragment", "newState: " + k.alz(paramInt2) + ", action: " + k.alz(paramInt1) + ", lastStatus: " + k.alz(NVw) + ", isSwitchFromVideo: " + this.NWP);
    if (this.qcr == null)
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
      gBO();
      AppMethodBeat.o(115477);
      return;
      alp(paramInt1);
      AppMethodBeat.o(115477);
      return;
      gCb();
      AppMethodBeat.o(115477);
      return;
      gCf();
      AppMethodBeat.o(115477);
      return;
      gCc();
      AppMethodBeat.o(115477);
      return;
      gCd();
      AppMethodBeat.o(115477);
      return;
      gCe();
    }
  }
  
  protected final void kS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.NWI == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.NWI.setText(paramInt1);
    this.NWI.setVisibility(0);
    this.NWI.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.NWI.setBackgroundResource(b.c.voip_toast_bg);
    this.NWI.setCompoundDrawables(null, null, null, null);
    this.NWI.setCompoundDrawablePadding(0);
    this.ntw.removeCallbacks(this.uYG);
    if (-1 != paramInt2) {
      this.ntw.postDelayed(this.uYG, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public final void l(Point paramPoint) {}
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    Log.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    boolean bool;
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.qcr = ((RelativeLayout)paramLayoutInflater.inflate(b.e.voip_voice_fragment_for_small_screen, paramViewGroup, false));
      this.NVt = ((ImageView)this.qcr.findViewById(b.d.voip_blur_avatar));
      this.NWu = this.qcr.findViewById(b.d.voip_voice_avatar_and_status_ctn);
      this.NWv = ((ImageView)this.qcr.findViewById(b.d.voip_voice_remote_talker_avatar));
      a.b.a(this.NWv, this.iSn, 0.0375F, true);
      this.NWw = ((TextView)this.qcr.findViewById(b.d.voip_voice_remote_talker_name));
      this.NWw.setText(l.b(getActivity(), aa.PJ(this.iSn), this.NWw.getTextSize()));
      this.NWx = ((TextView)this.qcr.findViewById(b.d.voip_voice_remote_talker_name_sub_detail));
      this.NWy = ((TextView)this.qcr.findViewById(b.d.voip_voice_time));
      this.NWz = ((TextView)this.qcr.findViewById(b.d.voip_voice_invite_tips));
      this.NWA = ((TextView)this.qcr.findViewById(b.d.voip_voice_invite_tips_dot));
      this.NWB = this.qcr.findViewById(b.d.voip_voice_invite_tips_ctn);
      this.NWI = ((TextView)this.qcr.findViewById(b.d.voip_voice_call_hint));
      this.NWJ = ((TextView)this.qcr.findViewById(b.d.voip_voice_risk_call_hint));
      this.DZt = ((TextView)this.qcr.findViewById(b.d.voip_net_status_hint));
      this.FwW = ((ImageView)this.qcr.findViewById(b.d.link_arrow));
      this.FwW.setImageDrawable(au.o(MMApplicationContext.getContext(), b.f.icons_filled_arrow, -1));
      o(this.NWA, b.g.voip_three_dot);
      if (ac.mGz) {
        this.NUg = ((TextView)this.qcr.findViewById(b.d.engineInfo));
      }
      this.NWF = ((RelativeLayout)this.qcr.findViewById(b.d.voip_voice_mic_switcher_container));
      this.NWG = ((MMCheckBox)this.qcr.findViewById(b.d.voip_voice_mic_switcher));
      this.NWG.setChecked(this.mIsMute);
      this.NWH = ((TextView)this.qcr.findViewById(b.d.voip_voice_mic_switcher_text));
      this.NWH.setText(b.g.voip_mute_on);
      this.NWC = ((RelativeLayout)this.qcr.findViewById(b.d.voip_voice_speaker_switcher_container));
      this.NWD = ((MMCheckBox)this.qcr.findViewById(b.d.voip_voice_speaker_switcher));
      this.NWE = ((TextView)this.qcr.findViewById(b.d.voip_voice_speaker_switcher_text));
      this.NWE.setText(b.g.voip_speaker_on);
      gCg();
      this.NWK = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_voice_accept_invite));
      this.NWK.setOnClickListener(this.NWS);
      this.NWL = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_voice_reject_invite));
      this.NWL.setOnClickListener(this.NWT);
      this.NWM = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_voice_hangup_talking));
      this.NWM.setOnClickListener(this.NWU);
      this.NWN = ((VoipBigIconButton)this.qcr.findViewById(b.d.voip_voice_cancel_inviting));
      this.NWN.setOnClickListener(this.NWV);
      if (m.ZG("VOIPBlockIgnoreButton") != 0) {
        break label1059;
      }
      bool = true;
      label671:
      this.NUz = bool;
      this.NWO = ((VoipSmallIconButton)this.qcr.findViewById(b.d.voip_ignore_voice_invite));
      this.NWO.setOnClickListener(this.NUT);
      if (!this.NUz) {
        this.NWO.setVisibility(8);
      }
      this.NWD.setOnClickListener(this.NWQ);
      this.NWG.setOnClickListener(this.NWR);
      this.NTR = ((Button)this.qcr.findViewById(b.d.btn_minimize_voip));
      this.NTR.setOnClickListener(this.NUS);
      this.FzS = ((WeImageView)this.qcr.findViewById(b.d.btn_split));
      if ((ar.hIO()) && (this.FzS != null))
      {
        az.kK(getActivity());
        if (!ar.hIH()) {
          break label1065;
        }
        this.FzS.setVisibility(0);
      }
    }
    for (;;)
    {
      this.FzS.setOnClickListener(new VoipVoiceFragment.4(this));
      int i = w.at(getActivity());
      Log.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      aF(this.NTR, i);
      aF(this.FzS, i);
      if ((this.NKr) && (2 == this.NKw)) {
        kS(b.g.voip_audio_talking_hint, 10000);
      }
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.V(((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(this.iSn));
      if ((!Util.isNullOrNil(paramLayoutInflater)) && (this.NWx != null)) {
        this.NWx.setText(paramLayoutInflater);
      }
      this.cts = new MTimerHandler(Looper.myLooper(), this.NWl, true);
      kR(this.NVv, this.mStatus);
      paramLayoutInflater = this.qcr;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.qcr = ((RelativeLayout)paramLayoutInflater.inflate(b.e.voip_voice_fragment, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.qcr.findViewById(b.d.rl_voice_controllers)).setPadding(0, 0, 0, BackwardSupportUtil.BitmapFactory.fromDPToPix(getActivity(), 40.0F));
      break;
      label1059:
      bool = false;
      break label671;
      label1065:
      this.FzS.setVisibility(8);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.tUj = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    Log.printInfoStack("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.NWG != null) && (this.NWH != null)) {
      this.NWG.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.NKw = paramInt;
      gCg();
    }
    AppMethodBeat.o(115492);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115478);
    if (this.cts != null)
    {
      this.cts.stopTimer();
      this.cts = null;
    }
    super.uninit();
    AppMethodBeat.o(115478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */