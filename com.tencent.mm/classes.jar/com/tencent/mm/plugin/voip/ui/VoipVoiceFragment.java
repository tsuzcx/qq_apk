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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private View.OnClickListener CAh;
  private View.OnClickListener CAi;
  private View CBO;
  private ImageView CBP;
  private TextView CBQ;
  private TextView CBS;
  private TextView CBT;
  private TextView CBU;
  private TextView CBV;
  private View CBW;
  private RelativeLayout CBX;
  private MMCheckBox CBY;
  private TextView CBZ;
  private RelativeLayout CCa;
  private MMCheckBox CCb;
  private TextView CCc;
  private TextView CCd;
  private TextView CCe;
  private VoipBigIconButton CCf;
  private VoipBigIconButton CCg;
  private VoipBigIconButton CCh;
  private VoipBigIconButton CCi;
  private VoipSmallIconButton CCj;
  private ImageView CCk;
  private boolean CCl;
  private boolean CCm;
  private View.OnClickListener CCn;
  private View.OnClickListener CCo;
  private View.OnClickListener CCp;
  private View.OnClickListener CCq;
  private View.OnClickListener CCr;
  private View.OnClickListener CCs;
  private Runnable CCt;
  private int Cqn;
  private TextView CzB;
  private boolean CzP;
  private Button Czm;
  private boolean mIsMute;
  private Timer mTimer;
  private boolean pgi;
  private Runnable qce;
  private TextView vhc;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.Cqn = 1;
    this.mIsMute = false;
    this.pgi = false;
    this.CzP = false;
    this.CCl = false;
    this.CCm = false;
    this.CAh = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115463);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null)) {
          ((c)VoipVoiceFragment.this.CAv.get()).tm(true);
        }
        if (VoipVoiceFragment.this.CAN != null) {
          VoipVoiceFragment.this.CAN.aw(false, true);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115463);
      }
    };
    this.CAi = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115466);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.plugin.report.service.g.yxI.f(11619, new Object[] { Integer.valueOf(3) });
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null)) {
          ((c)VoipVoiceFragment.this.CAv.get()).ezj();
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115466);
      }
    };
    this.CCn = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115467);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        boolean bool = VoipVoiceFragment.a(VoipVoiceFragment.this).isChecked();
        ae.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null)) {
          ((c)VoipVoiceFragment.this.CAv.get()).tk(bool);
        }
        paramAnonymousView = VoipVoiceFragment.this;
        if (bool) {}
        for (int i = 1;; i = 2)
        {
          VoipVoiceFragment.a(paramAnonymousView, i);
          VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(true);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(115467);
          return;
        }
      }
    };
    this.CCo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115468);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        ae.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null)) {
          ((c)VoipVoiceFragment.this.CAv.get()).oN(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115468);
      }
    };
    this.CCp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().eBd()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().eBe()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().ezE()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null) && (((c)VoipVoiceFragment.this.CAv.get()).eyJ()))
        {
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setText(2131764949);
          VoipVoiceFragment.this.CAO.a(VoipVoiceFragment.e(VoipVoiceFragment.this), VoipBaseFragment.CAI);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.h(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(0);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115469);
      }
    };
    this.CCq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        com.tencent.mm.plugin.report.service.g.yxI.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.eys().eBd()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().eBe()), Long.valueOf(com.tencent.mm.plugin.voip.c.eys().ezE()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null) && (((c)VoipVoiceFragment.this.CAv.get()).eyI()))
        {
          VoipVoiceFragment.h(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.iz(2131764909, -1);
          if (VoipVoiceFragment.this.CAN != null) {
            VoipVoiceFragment.this.CAN.aw(true, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115470);
      }
    };
    this.CCr = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115471);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null) && (((c)VoipVoiceFragment.this.CAv.get()).eyD())) {
          VoipVoiceFragment.this.iz(2131764857, -1);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115471);
      }
    };
    this.CCs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115472);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
        if ((VoipVoiceFragment.this.CAv != null) && (VoipVoiceFragment.this.CAv.get() != null) && (((c)VoipVoiceFragment.this.CAv.get()).eyL()))
        {
          VoipVoiceFragment.this.iz(2131764813, -1);
          VoipVoiceFragment.j(VoipVoiceFragment.this).setEnabled(false);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115472);
      }
    };
    this.qce = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115465);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(115465);
          return;
        }
        VoipVoiceFragment.k(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(115465);
      }
    };
    this.CCt = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210208);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(210208);
          return;
        }
        if (VoipVoiceFragment.this.lUu.findViewById(2131308162) != null) {
          VoipVoiceFragment.this.lUu.findViewById(2131308162).setOnClickListener(null);
        }
        VoipVoiceFragment.l(VoipVoiceFragment.this);
        VoipVoiceFragment.m(VoipVoiceFragment.this).setVisibility(8);
        VoipVoiceFragment.n(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(210208);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void Vh(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.CBO.setVisibility(0);
    this.CBT.setVisibility(8);
    this.CBU.setText(2131764874);
    this.CAO.a(this.CBV, CAI);
    this.CBW.setVisibility(0);
    if (this.CBS != null)
    {
      if ((!an.aUq(this.fIQ)) || (bu.ah(this.CBS.getText()))) {
        break label277;
      }
      this.CBS.setVisibility(0);
    }
    for (;;)
    {
      this.CCf.setVisibility(8);
      this.CCg.setVisibility(8);
      this.CCh.setVisibility(8);
      this.CCi.setVisibility(0);
      this.CCj.setVisibility(8);
      this.CCa.setVisibility(0);
      this.CCb.setEnabled(false);
      this.CCb.setBackgroundResource(2131234600);
      this.CCc.setTextColor(1728053247);
      eCP();
      this.CCb.setChecked(this.mIsMute);
      this.CBX.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.Cqn)) {
        iz(2131764790, 10000);
      }
      eCE();
      this.CCe.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
      {
        this.CCe.setVisibility(0);
        this.CCe.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
      }
      if (CAM == 2) {
        this.CCl = true;
      }
      AppMethodBeat.o(115480);
      return;
      label277:
      this.CBS.setVisibility(8);
    }
  }
  
  private void aUH()
  {
    AppMethodBeat.i(115491);
    if ((this.mTimer == null) || (this.pgi))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.CAw) {
      this.CAw = bu.aRi();
    }
    this.pgi = true;
    TimerTask local4 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(210210);
        VoipVoiceFragment.this.jzz.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210209);
            String str = VoipVoiceFragment.sz(bu.rZ(VoipVoiceFragment.this.CAw));
            VoipVoiceFragment.g(VoipVoiceFragment.this).setText(str);
            VoipVoiceFragment.o(VoipVoiceFragment.this);
            AppMethodBeat.o(210209);
          }
        });
        AppMethodBeat.o(210210);
      }
    };
    this.mTimer.schedule(local4, 50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void eCK()
  {
    AppMethodBeat.i(115481);
    this.CBU.setText(2131764949);
    this.CAO.a(this.CBV, CAI);
    this.CCf.setVisibility(8);
    this.CCg.setVisibility(8);
    this.CCh.setVisibility(0);
    this.CCi.setVisibility(8);
    this.CCj.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void eCL()
  {
    AppMethodBeat.i(115482);
    this.CAO.eCG();
    this.CCh.setEnabled(false);
    this.CCi.setEnabled(false);
    this.CCf.setEnabled(false);
    this.CCg.setEnabled(false);
    this.CCj.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void eCM()
  {
    AppMethodBeat.i(115483);
    this.CBO.setVisibility(0);
    this.CBW.setVisibility(0);
    this.CBU.setText(2131764875);
    this.CAO.a(this.CBV, CAI);
    if (this.CBS != null)
    {
      if ((!an.aUq(this.fIQ)) || (bu.ah(this.CBS.getText()))) {
        break label211;
      }
      this.CBS.setVisibility(0);
    }
    for (;;)
    {
      eCP();
      this.CCf.setVisibility(0);
      this.CCg.setVisibility(0);
      this.CCh.setVisibility(8);
      this.CCi.setVisibility(8);
      if (this.CzP) {
        this.CCj.setVisibility(0);
      }
      if (CAM == 256)
      {
        this.CCl = true;
        iz(2131764791, 10000);
      }
      eCE();
      this.CCe.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
      {
        this.CCe.setVisibility(0);
        this.CCe.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.CBS.setVisibility(8);
    }
  }
  
  private void eCN()
  {
    AppMethodBeat.i(115484);
    this.CBO.setVisibility(0);
    this.CBW.setVisibility(0);
    this.CBU.setText(2131764949);
    this.CAO.a(this.CBV, CAI);
    this.CCf.setVisibility(8);
    this.CCg.setVisibility(8);
    this.CCh.setVisibility(0);
    this.CCi.setVisibility(8);
    this.CCj.setVisibility(8);
    iz(2131764790, 10000);
    eCE();
    AppMethodBeat.o(115484);
  }
  
  private void eCO()
  {
    AppMethodBeat.i(115485);
    this.CCi.setVisibility(8);
    this.CCf.setVisibility(8);
    this.CCg.setVisibility(8);
    this.CCj.setVisibility(8);
    this.CBW.setVisibility(8);
    this.CAO.eCG();
    this.CCh.setVisibility(0);
    this.CBT.setVisibility(0);
    this.CCa.setVisibility(0);
    this.CBX.setVisibility(0);
    this.CBO.setVisibility(0);
    this.Czm.setVisibility(0);
    this.CCb.setEnabled(true);
    this.CCb.setBackgroundResource(2131234589);
    this.CCc.setTextColor(-1);
    eCP();
    this.CCb.setChecked(this.mIsMute);
    if (!this.CCl) {
      iz(2131764783, 10000);
    }
    for (;;)
    {
      if (ac.iSu) {
        this.CzB.setVisibility(0);
      }
      eCE();
      aUH();
      this.CCe.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
      {
        this.CCe.setVisibility(0);
        this.CCe.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.Cqn) {
        iz(2131764785, 10000);
      } else if (3 == this.Cqn) {
        iz(2131764784, 10000);
      }
    }
  }
  
  private void eCP()
  {
    AppMethodBeat.i(115493);
    if ((this.CBY == null) || (this.CBZ == null))
    {
      ae.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.Cqn) || (3 == this.Cqn))
    {
      this.CBY.setEnabled(false);
      this.CBZ.setTextColor(1728053247);
      this.CBY.setBackgroundResource(2131234586);
      ae.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.Cqn == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.CBY.setBackgroundResource(2131234590);
      this.CBY.setEnabled(true);
      this.CBZ.setTextColor(-1);
      this.CBY.setChecked(bool);
      ae.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  private void eCx()
  {
    AppMethodBeat.i(115479);
    this.CBO.setVisibility(0);
    this.CBT.setVisibility(8);
    this.CBU.setText(2131764902);
    this.CAO.a(this.CBV, CAI);
    this.CBW.setVisibility(0);
    this.CCf.setVisibility(8);
    this.CCg.setVisibility(8);
    this.CCh.setVisibility(8);
    this.CCi.setVisibility(0);
    this.CCj.setVisibility(8);
    this.CCa.setVisibility(0);
    this.CCb.setEnabled(false);
    this.CCb.setBackgroundResource(2131234600);
    this.CCc.setTextColor(1728053247);
    this.CCe.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.eys().CqG != null)
    {
      this.CCe.setVisibility(0);
      this.CCe.setText(com.tencent.mm.plugin.voip.c.eys().CqG);
    }
    eCP();
    this.CCb.setChecked(this.mIsMute);
    this.CBX.setVisibility(0);
    if (2 == this.Cqn) {
      iz(2131764790, 10000);
    }
    eCE();
    AppMethodBeat.o(115479);
  }
  
  public final void Vg(int paramInt)
  {
    AppMethodBeat.i(210212);
    if (this.vhc != null)
    {
      this.CCm = true;
      if (this.lUu.findViewById(2131308162) != null) {
        this.lUu.findViewById(2131308162).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(210211);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (VoipVoiceFragment.this.lUu.findViewById(2131308162) != null) {
              ((c)VoipVoiceFragment.this.CAv.get()).eyV();
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(210211);
          }
        });
      }
      this.CCk.setVisibility(0);
      this.vhc.setVisibility(0);
      this.vhc.setText(2131766838);
      this.jzz.removeCallbacks(this.CCt);
      this.jzz.postDelayed(this.CCt, paramInt * 1000);
    }
    AppMethodBeat.o(210212);
  }
  
  protected final void aFb(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.CCe != null)
    {
      this.CCe.setVisibility(0);
      this.CCe.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  protected final void eCu()
  {
    AppMethodBeat.i(115489);
    if (this.vhc != null)
    {
      this.vhc.clearAnimation();
      this.vhc.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void eCv() {}
  
  public final void iy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.iy(paramInt1, paramInt2);
    ae.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.Vr(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.b.l.Vr(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.b.l.Vr(CAM) + ", isSwitchFromVideo: " + this.CCl);
    if (this.lUu == null)
    {
      ae.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
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
      eCx();
      AppMethodBeat.o(115477);
      return;
      Vh(paramInt1);
      AppMethodBeat.o(115477);
      return;
      eCK();
      AppMethodBeat.o(115477);
      return;
      eCO();
      AppMethodBeat.o(115477);
      return;
      eCL();
      AppMethodBeat.o(115477);
      return;
      eCM();
      AppMethodBeat.o(115477);
      return;
      eCN();
    }
  }
  
  protected final void iz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.CCd == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.CCd.setText(paramInt1);
    this.CCd.setVisibility(0);
    this.CCd.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.CCd.setBackgroundResource(2131234591);
    this.CCd.setCompoundDrawables(null, null, null, null);
    this.CCd.setCompoundDrawablePadding(0);
    this.jzz.removeCallbacks(this.qce);
    if (-1 != paramInt2) {
      this.jzz.postDelayed(this.qce, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    ae.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.lUu = ((RelativeLayout)paramLayoutInflater.inflate(2131495885, paramViewGroup, false));
      this.CAJ = ((ImageView)this.lUu.findViewById(2131306556));
      this.CBO = this.lUu.findViewById(2131306607);
      this.CBP = ((ImageView)this.lUu.findViewById(2131306621));
      a.b.a(this.CBP, this.fIQ, 0.0375F, true);
      this.CBQ = ((TextView)this.lUu.findViewById(2131306622));
      this.CBQ.setText(k.b(getActivity(), w.zP(this.fIQ), this.CBQ.getTextSize()));
      this.CBS = ((TextView)this.lUu.findViewById(2131306624));
      this.CBT = ((TextView)this.lUu.findViewById(2131306629));
      this.CBU = ((TextView)this.lUu.findViewById(2131306611));
      this.CBV = ((TextView)this.lUu.findViewById(2131306613));
      this.CBW = this.lUu.findViewById(2131306612);
      this.CCd = ((TextView)this.lUu.findViewById(2131306608));
      this.CCe = ((TextView)this.lUu.findViewById(2131306625));
      this.vhc = ((TextView)this.lUu.findViewById(2131306581));
      this.CCk = ((ImageView)this.lUu.findViewById(2131308146));
      this.CCk.setImageDrawable(ao.k(ak.getContext(), 2131690349, -1));
      r(this.CBV);
      if (ac.iSu) {
        this.CzB = ((TextView)this.lUu.findViewById(2131299493));
      }
      this.CCa = ((RelativeLayout)this.lUu.findViewById(2131306615));
      this.CCb = ((MMCheckBox)this.lUu.findViewById(2131306614));
      this.CCb.setChecked(this.mIsMute);
      this.CCc = ((TextView)this.lUu.findViewById(2131306616));
      this.CCc.setText(2131764886);
      this.CBX = ((RelativeLayout)this.lUu.findViewById(2131306627));
      this.CBY = ((MMCheckBox)this.lUu.findViewById(2131306626));
      this.CBZ = ((TextView)this.lUu.findViewById(2131306628));
      this.CBZ.setText(2131764919);
      eCP();
      this.CCf = ((VoipBigIconButton)this.lUu.findViewById(2131306606));
      this.CCf.setOnClickListener(this.CCp);
      this.CCg = ((VoipBigIconButton)this.lUu.findViewById(2131306620));
      this.CCg.setOnClickListener(this.CCq);
      this.CCh = ((VoipBigIconButton)this.lUu.findViewById(2131306610));
      this.CCh.setOnClickListener(this.CCr);
      this.CCi = ((VoipBigIconButton)this.lUu.findViewById(2131306609));
      this.CCi.setOnClickListener(this.CCs);
      if (n.Jh("VOIPBlockIgnoreButton") != 0) {
        break label972;
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      this.CzP = bool;
      this.CCj = ((VoipSmallIconButton)this.lUu.findViewById(2131306576));
      this.CCj.setOnClickListener(this.CAi);
      if (!this.CzP) {
        this.CCj.setVisibility(8);
      }
      this.CBY.setOnClickListener(this.CCn);
      this.CCb.setOnClickListener(this.CCo);
      this.Czm = ((Button)this.lUu.findViewById(2131297592));
      this.Czm.setOnClickListener(this.CAh);
      int i = t.kd(getActivity());
      ae.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      av(this.Czm, i);
      if ((this.Cqi) && (2 == this.Cqn)) {
        iz(2131764790, 10000);
      }
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.O(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(this.fIQ));
      if ((!bu.isNullOrNil(paramLayoutInflater)) && (this.CBS != null)) {
        this.CBS.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      iy(this.CAL, this.mStatus);
      paramLayoutInflater = this.lUu;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.lUu = ((RelativeLayout)paramLayoutInflater.inflate(2131495884, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.lUu.findViewById(2131304207)).setPadding(0, 0, 0, BackwardSupportUtil.b.h(getActivity(), 40.0F));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.pgi = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    ae.m("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.CCb != null) && (this.CCc != null)) {
      this.CCb.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.Cqn = paramInt;
      eCP();
    }
    AppMethodBeat.o(115492);
  }
  
  protected final void tA(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.CCm)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.vhc != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.vhc.setText(2131764892);
    }
    for (;;)
    {
      this.vhc.clearAnimation();
      this.vhc.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.vhc.setText(2131764891);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */