package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.openim.room.a.a;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.voip.b.i;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private boolean mIsMute;
  private Timer mTimer;
  private boolean nSO;
  private Runnable oOz;
  private TextView sKW;
  private int zhd;
  private Button zpV;
  private View.OnClickListener zqP;
  private View.OnClickListener zqQ;
  private TextView zqk;
  private boolean zqw;
  private TextView zsA;
  private View zsB;
  private RelativeLayout zsC;
  private MMCheckBox zsD;
  private TextView zsE;
  private RelativeLayout zsF;
  private MMCheckBox zsG;
  private TextView zsH;
  private TextView zsI;
  private TextView zsJ;
  private VoipBigIconButton zsK;
  private VoipBigIconButton zsL;
  private VoipBigIconButton zsM;
  private VoipBigIconButton zsN;
  private VoipSmallIconButton zsO;
  private boolean zsP;
  private View.OnClickListener zsQ;
  private View.OnClickListener zsR;
  private View.OnClickListener zsS;
  private View.OnClickListener zsT;
  private View.OnClickListener zsU;
  private View.OnClickListener zsV;
  private View zsu;
  private ImageView zsv;
  private TextView zsw;
  private TextView zsx;
  private TextView zsy;
  private TextView zsz;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.zhd = 1;
    this.mIsMute = false;
    this.nSO = false;
    this.zqw = false;
    this.zsP = false;
    this.zqP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115463);
        h.vKh.f(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null)) {
          ((c)VoipVoiceFragment.this.zrd.get()).rv(true);
        }
        if (VoipVoiceFragment.this.zrw != null) {
          VoipVoiceFragment.this.zrw.ao(false, true);
        }
        AppMethodBeat.o(115463);
      }
    };
    this.zqQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115466);
        h.vKh.f(11619, new Object[] { Integer.valueOf(3) });
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null)) {
          ((c)VoipVoiceFragment.this.zrd.get()).dSF();
        }
        AppMethodBeat.o(115466);
      }
    };
    this.zsQ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115467);
        boolean bool = VoipVoiceFragment.a(VoipVoiceFragment.this).isChecked();
        ad.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null)) {
          ((c)VoipVoiceFragment.this.zrd.get()).rt(bool);
        }
        paramAnonymousView = VoipVoiceFragment.this;
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          VoipVoiceFragment.a(paramAnonymousView, i);
          VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(true);
          AppMethodBeat.o(115467);
          return;
        }
      }
    };
    this.zsR = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115468);
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        ad.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null)) {
          ((c)VoipVoiceFragment.this.zrd.get()).ns(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
        AppMethodBeat.o(115468);
      }
    };
    this.zsS = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        ad.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        h.vKh.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null) && (((c)VoipVoiceFragment.this.zrd.get()).dSg()))
        {
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setText(2131764949);
          VoipVoiceFragment.this.zrx.a(VoipVoiceFragment.e(VoipVoiceFragment.this), VoipBaseFragment.zrr);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.h(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(0);
        }
        AppMethodBeat.o(115469);
      }
    };
    this.zsT = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        ad.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        h.vKh.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUz()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dUA()), Long.valueOf(com.tencent.mm.plugin.voip.c.dRQ().dTa()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null) && (((c)VoipVoiceFragment.this.zrd.get()).dSf()))
        {
          VoipVoiceFragment.h(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.hT(2131764909, -1);
          if (VoipVoiceFragment.this.zrw != null) {
            VoipVoiceFragment.this.zrw.ao(true, false);
          }
        }
        AppMethodBeat.o(115470);
      }
    };
    this.zsU = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115471);
        ad.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null) && (((c)VoipVoiceFragment.this.zrd.get()).dSa())) {
          VoipVoiceFragment.this.hT(2131764857, -1);
        }
        AppMethodBeat.o(115471);
      }
    };
    this.zsV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115472);
        ad.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
        if ((VoipVoiceFragment.this.zrd != null) && (VoipVoiceFragment.this.zrd.get() != null) && (((c)VoipVoiceFragment.this.zrd.get()).dSi()))
        {
          VoipVoiceFragment.this.hT(2131764813, -1);
          VoipVoiceFragment.j(VoipVoiceFragment.this).setEnabled(false);
        }
        AppMethodBeat.o(115472);
      }
    };
    this.oOz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115473);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(115473);
          return;
        }
        VoipVoiceFragment.k(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(115473);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void Qy(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.zsu.setVisibility(0);
    this.zsy.setVisibility(8);
    this.zsz.setText(2131764874);
    this.zrx.a(this.zsA, zrr);
    this.zsB.setVisibility(0);
    if (this.zsx != null)
    {
      if ((!af.aHH(this.flk)) || (bt.ai(this.zsx.getText()))) {
        break label277;
      }
      this.zsx.setVisibility(0);
    }
    for (;;)
    {
      this.zsK.setVisibility(8);
      this.zsL.setVisibility(8);
      this.zsM.setVisibility(8);
      this.zsN.setVisibility(0);
      this.zsO.setVisibility(8);
      this.zsF.setVisibility(0);
      this.zsG.setEnabled(false);
      this.zsG.setBackgroundResource(2131234600);
      this.zsH.setTextColor(1728053247);
      dWl();
      this.zsG.setChecked(this.mIsMute);
      this.zsC.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.zhd)) {
        hT(2131764790, 10000);
      }
      dWa();
      this.zsJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
      {
        this.zsJ.setVisibility(0);
        this.zsJ.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
      }
      if (zrv == 2) {
        this.zsP = true;
      }
      AppMethodBeat.o(115480);
      return;
      label277:
      this.zsx.setVisibility(8);
    }
  }
  
  private void aKf()
  {
    AppMethodBeat.i(115491);
    if ((this.mTimer == null) || (this.nSO))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.zre) {
      this.zre = bt.aGK();
    }
    this.nSO = true;
    TimerTask local2 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(115465);
        VoipVoiceFragment.this.iDu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(115464);
            String str = VoipVoiceFragment.mz(bt.lZ(VoipVoiceFragment.this.zre));
            VoipVoiceFragment.g(VoipVoiceFragment.this).setText(str);
            VoipVoiceFragment.l(VoipVoiceFragment.this);
            AppMethodBeat.o(115464);
          }
        });
        AppMethodBeat.o(115465);
      }
    };
    this.mTimer.schedule(local2, 50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void dVT()
  {
    AppMethodBeat.i(115479);
    this.zsu.setVisibility(0);
    this.zsy.setVisibility(8);
    this.zsz.setText(2131764902);
    this.zrx.a(this.zsA, zrr);
    this.zsB.setVisibility(0);
    this.zsK.setVisibility(8);
    this.zsL.setVisibility(8);
    this.zsM.setVisibility(8);
    this.zsN.setVisibility(0);
    this.zsO.setVisibility(8);
    this.zsF.setVisibility(0);
    this.zsG.setEnabled(false);
    this.zsG.setBackgroundResource(2131234600);
    this.zsH.setTextColor(1728053247);
    this.zsJ.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
    {
      this.zsJ.setVisibility(0);
      this.zsJ.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
    }
    dWl();
    this.zsG.setChecked(this.mIsMute);
    this.zsC.setVisibility(0);
    if (2 == this.zhd) {
      hT(2131764790, 10000);
    }
    dWa();
    AppMethodBeat.o(115479);
  }
  
  private void dWg()
  {
    AppMethodBeat.i(115481);
    this.zsz.setText(2131764949);
    this.zrx.a(this.zsA, zrr);
    this.zsK.setVisibility(8);
    this.zsL.setVisibility(8);
    this.zsM.setVisibility(0);
    this.zsN.setVisibility(8);
    this.zsO.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void dWh()
  {
    AppMethodBeat.i(115482);
    this.zrx.dWc();
    this.zsM.setEnabled(false);
    this.zsN.setEnabled(false);
    this.zsK.setEnabled(false);
    this.zsL.setEnabled(false);
    this.zsO.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void dWi()
  {
    AppMethodBeat.i(115483);
    this.zsu.setVisibility(0);
    this.zsB.setVisibility(0);
    this.zsz.setText(2131764875);
    this.zrx.a(this.zsA, zrr);
    if (this.zsx != null)
    {
      if ((!af.aHH(this.flk)) || (bt.ai(this.zsx.getText()))) {
        break label211;
      }
      this.zsx.setVisibility(0);
    }
    for (;;)
    {
      dWl();
      this.zsK.setVisibility(0);
      this.zsL.setVisibility(0);
      this.zsM.setVisibility(8);
      this.zsN.setVisibility(8);
      if (this.zqw) {
        this.zsO.setVisibility(0);
      }
      if (zrv == 256)
      {
        this.zsP = true;
        hT(2131764791, 10000);
      }
      dWa();
      this.zsJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
      {
        this.zsJ.setVisibility(0);
        this.zsJ.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.zsx.setVisibility(8);
    }
  }
  
  private void dWj()
  {
    AppMethodBeat.i(115484);
    this.zsu.setVisibility(0);
    this.zsB.setVisibility(0);
    this.zsz.setText(2131764949);
    this.zrx.a(this.zsA, zrr);
    this.zsK.setVisibility(8);
    this.zsL.setVisibility(8);
    this.zsM.setVisibility(0);
    this.zsN.setVisibility(8);
    this.zsO.setVisibility(8);
    hT(2131764790, 10000);
    dWa();
    AppMethodBeat.o(115484);
  }
  
  private void dWk()
  {
    AppMethodBeat.i(115485);
    this.zsN.setVisibility(8);
    this.zsK.setVisibility(8);
    this.zsL.setVisibility(8);
    this.zsO.setVisibility(8);
    this.zsB.setVisibility(8);
    this.zrx.dWc();
    this.zsM.setVisibility(0);
    this.zsy.setVisibility(0);
    this.zsF.setVisibility(0);
    this.zsC.setVisibility(0);
    this.zsu.setVisibility(0);
    this.zpV.setVisibility(0);
    this.zsG.setEnabled(true);
    this.zsG.setBackgroundResource(2131234589);
    this.zsH.setTextColor(-1);
    dWl();
    this.zsG.setChecked(this.mIsMute);
    if (!this.zsP) {
      hT(2131764783, 10000);
    }
    for (;;)
    {
      if (ab.hWp) {
        this.zqk.setVisibility(0);
      }
      dWa();
      aKf();
      this.zsJ.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.dRQ().zhw != null)
      {
        this.zsJ.setVisibility(0);
        this.zsJ.setText(com.tencent.mm.plugin.voip.c.dRQ().zhw);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.zhd) {
        hT(2131764785, 10000);
      } else if (3 == this.zhd) {
        hT(2131764784, 10000);
      }
    }
  }
  
  private void dWl()
  {
    AppMethodBeat.i(115493);
    if ((this.zsD == null) || (this.zsE == null))
    {
      ad.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.zhd) || (3 == this.zhd))
    {
      this.zsD.setEnabled(false);
      this.zsE.setTextColor(1728053247);
      this.zsD.setBackgroundResource(2131234586);
      ad.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.zhd == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.zsD.setBackgroundResource(2131234590);
      this.zsD.setEnabled(true);
      this.zsE.setTextColor(-1);
      this.zsD.setChecked(bool);
      ad.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  protected final void atj(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.zsJ != null)
    {
      this.zsJ.setVisibility(0);
      this.zsJ.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  protected final void dVQ()
  {
    AppMethodBeat.i(115489);
    if (this.sKW != null)
    {
      this.sKW.clearAnimation();
      this.sKW.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void dVR() {}
  
  public final void hS(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.hS(paramInt1, paramInt2);
    ad.i("MicroMsg.VoipVoiceFragment", "newState: " + i.QI(paramInt2) + ", action: " + i.QI(paramInt1) + ", lastStatus: " + i.QI(zrv) + ", isSwitchFromVideo: " + this.zsP);
    if (this.vHU == null)
    {
      ad.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
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
      dVT();
      AppMethodBeat.o(115477);
      return;
      Qy(paramInt1);
      AppMethodBeat.o(115477);
      return;
      dWg();
      AppMethodBeat.o(115477);
      return;
      dWk();
      AppMethodBeat.o(115477);
      return;
      dWh();
      AppMethodBeat.o(115477);
      return;
      dWi();
      AppMethodBeat.o(115477);
      return;
      dWj();
    }
  }
  
  protected final void hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.zsI == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.zsI.setText(paramInt1);
    this.zsI.setVisibility(0);
    this.zsI.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.zsI.setBackgroundResource(2131234591);
    this.zsI.setCompoundDrawables(null, null, null, null);
    this.zsI.setCompoundDrawablePadding(0);
    this.iDu.removeCallbacks(this.oOz);
    if (-1 != paramInt2) {
      this.iDu.postDelayed(this.oOz, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    ad.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.vHU = ((RelativeLayout)paramLayoutInflater.inflate(2131495885, paramViewGroup, false));
      this.zrs = ((ImageView)this.vHU.findViewById(2131306556));
      this.zsu = this.vHU.findViewById(2131306607);
      this.zsv = ((ImageView)this.vHU.findViewById(2131306621));
      a.b.a(this.zsv, this.flk, 0.0375F, true);
      this.zsw = ((TextView)this.vHU.findViewById(2131306622));
      this.zsw.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getActivity(), v.sh(this.flk), this.zsw.getTextSize()));
      this.zsx = ((TextView)this.vHU.findViewById(2131306624));
      this.zsy = ((TextView)this.vHU.findViewById(2131306629));
      this.zsz = ((TextView)this.vHU.findViewById(2131306611));
      this.zsA = ((TextView)this.vHU.findViewById(2131306613));
      this.zsB = this.vHU.findViewById(2131306612);
      this.zsI = ((TextView)this.vHU.findViewById(2131306608));
      this.zsJ = ((TextView)this.vHU.findViewById(2131306625));
      this.sKW = ((TextView)this.vHU.findViewById(2131306581));
      t(this.zsA);
      if (ab.hWp) {
        this.zqk = ((TextView)this.vHU.findViewById(2131299493));
      }
      this.zsF = ((RelativeLayout)this.vHU.findViewById(2131306615));
      this.zsG = ((MMCheckBox)this.vHU.findViewById(2131306614));
      this.zsG.setChecked(this.mIsMute);
      this.zsH = ((TextView)this.vHU.findViewById(2131306616));
      this.zsH.setText(2131764886);
      this.zsC = ((RelativeLayout)this.vHU.findViewById(2131306627));
      this.zsD = ((MMCheckBox)this.vHU.findViewById(2131306626));
      this.zsE = ((TextView)this.vHU.findViewById(2131306628));
      this.zsE.setText(2131764919);
      dWl();
      this.zsK = ((VoipBigIconButton)this.vHU.findViewById(2131306606));
      this.zsK.setOnClickListener(this.zsS);
      this.zsL = ((VoipBigIconButton)this.vHU.findViewById(2131306620));
      this.zsL.setOnClickListener(this.zsT);
      this.zsM = ((VoipBigIconButton)this.vHU.findViewById(2131306610));
      this.zsM.setOnClickListener(this.zsU);
      this.zsN = ((VoipBigIconButton)this.vHU.findViewById(2131306609));
      this.zsN.setOnClickListener(this.zsV);
      if (com.tencent.mm.plugin.voip.b.k.Bo("VOIPBlockIgnoreButton") != 0) {
        break label938;
      }
    }
    label938:
    for (boolean bool = true;; bool = false)
    {
      this.zqw = bool;
      this.zsO = ((VoipSmallIconButton)this.vHU.findViewById(2131306576));
      this.zsO.setOnClickListener(this.zqQ);
      if (!this.zqw) {
        this.zsO.setVisibility(8);
      }
      this.zsD.setOnClickListener(this.zsQ);
      this.zsG.setOnClickListener(this.zsR);
      this.zpV = ((Button)this.vHU.findViewById(2131297592));
      this.zpV.setOnClickListener(this.zqP);
      int i = t.jA(getActivity());
      ad.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      as(this.zpV, i);
      if ((this.zgY) && (2 == this.zhd)) {
        hT(2131764790, 10000);
      }
      paramLayoutInflater = a.G(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.flk));
      if ((!bt.isNullOrNil(paramLayoutInflater)) && (this.zsx != null)) {
        this.zsx.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      hS(this.zru, this.mStatus);
      paramLayoutInflater = this.vHU;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.vHU = ((RelativeLayout)paramLayoutInflater.inflate(2131495884, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.vHU.findViewById(2131304207)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.nSO = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  protected final void rJ(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.sKW != null)
    {
      if (!paramBoolean) {
        break label49;
      }
      this.sKW.setText(2131764892);
    }
    for (;;)
    {
      this.sKW.clearAnimation();
      this.sKW.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label49:
      this.sKW.setText(2131764891);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    ad.m("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.zsG != null) && (this.zsH != null)) {
      this.zsG.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.zhd = paramInt;
      dWl();
    }
    AppMethodBeat.o(115492);
  }
  
  public final void uninit()
  {
    AppMethodBeat.i(115478);
    if (this.mTimer != null)
    {
      this.mTimer.cancel();
      this.mTimer = null;
    }
    super.uninit();
    AppMethodBeat.o(115478);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */