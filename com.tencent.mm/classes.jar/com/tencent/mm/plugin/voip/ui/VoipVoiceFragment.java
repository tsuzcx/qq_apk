package com.tencent.mm.plugin.voip.ui;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
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
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.voip.b.n;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private int BYM;
  private Button ChL;
  private View.OnClickListener CiD;
  private View.OnClickListener CiE;
  private TextView Cia;
  private boolean Cil;
  private VoipBigIconButton CkA;
  private VoipBigIconButton CkB;
  private VoipBigIconButton CkC;
  private VoipBigIconButton CkD;
  private VoipSmallIconButton CkE;
  private ImageView CkF;
  private boolean CkG;
  private boolean CkH;
  private View.OnClickListener CkI;
  private View.OnClickListener CkJ;
  private View.OnClickListener CkK;
  private View.OnClickListener CkL;
  private View.OnClickListener CkM;
  private View.OnClickListener CkN;
  private Runnable CkO;
  private View Ckk;
  private ImageView Ckl;
  private TextView Ckm;
  private TextView Ckn;
  private TextView Cko;
  private TextView Ckp;
  private TextView Ckq;
  private View Ckr;
  private RelativeLayout Cks;
  private MMCheckBox Ckt;
  private TextView Cku;
  private RelativeLayout Ckv;
  private MMCheckBox Ckw;
  private TextView Ckx;
  private TextView Cky;
  private TextView Ckz;
  private boolean mIsMute;
  private Timer mTimer;
  private boolean oZE;
  private Runnable pVz;
  private TextView uVp;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.BYM = 1;
    this.mIsMute = false;
    this.oZE = false;
    this.Cil = false;
    this.CkG = false;
    this.CkH = false;
    this.CiD = new VoipVoiceFragment.1(this);
    this.CiE = new VoipVoiceFragment.5(this);
    this.CkI = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115467);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        boolean bool = VoipVoiceFragment.a(VoipVoiceFragment.this).isChecked();
        ad.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.CiR != null) && (VoipVoiceFragment.this.CiR.get() != null)) {
          ((c)VoipVoiceFragment.this.CiR.get()).td(bool);
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
    this.CkJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115468);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        ad.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.CiR != null) && (VoipVoiceFragment.this.CiR.get() != null)) {
          ((c)VoipVoiceFragment.this.CiR.get()).oG(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115468);
      }
    };
    this.CkK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        com.tencent.mm.plugin.report.service.g.yhR.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().exw()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().exx()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().evX()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.CiR != null) && (VoipVoiceFragment.this.CiR.get() != null) && (((c)VoipVoiceFragment.this.CiR.get()).evc()))
        {
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setText(2131764949);
          VoipVoiceFragment.this.Cjk.a(VoipVoiceFragment.e(VoipVoiceFragment.this), VoipBaseFragment.Cje);
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
    this.CkL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        com.tencent.mm.plugin.report.service.g.yhR.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.euM().exw()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().exx()), Long.valueOf(com.tencent.mm.plugin.voip.c.euM().evX()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.CiR != null) && (VoipVoiceFragment.this.CiR.get() != null) && (((c)VoipVoiceFragment.this.CiR.get()).evb()))
        {
          VoipVoiceFragment.h(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.iv(2131764909, -1);
          if (VoipVoiceFragment.this.Cjj != null) {
            VoipVoiceFragment.this.Cjj.ax(true, false);
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/voip/ui/VoipVoiceFragment$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(115470);
      }
    };
    this.CkM = new VoipVoiceFragment.10(this);
    this.CkN = new VoipVoiceFragment.11(this);
    this.pVz = new VoipVoiceFragment.2(this);
    this.CkO = new VoipVoiceFragment.3(this);
    AppMethodBeat.o(115474);
  }
  
  private void UA(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.Ckk.setVisibility(0);
    this.Cko.setVisibility(8);
    this.Ckp.setText(2131764874);
    this.Cjk.a(this.Ckq, Cje);
    this.Ckr.setVisibility(0);
    if (this.Ckn != null)
    {
      if ((!am.aSQ(this.fGM)) || (bt.ai(this.Ckn.getText()))) {
        break label277;
      }
      this.Ckn.setVisibility(0);
    }
    for (;;)
    {
      this.CkA.setVisibility(8);
      this.CkB.setVisibility(8);
      this.CkC.setVisibility(8);
      this.CkD.setVisibility(0);
      this.CkE.setVisibility(8);
      this.Ckv.setVisibility(0);
      this.Ckw.setEnabled(false);
      this.Ckw.setBackgroundResource(2131234600);
      this.Ckx.setTextColor(1728053247);
      ezh();
      this.Ckw.setChecked(this.mIsMute);
      this.Cks.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.BYM)) {
        iv(2131764790, 10000);
      }
      eyW();
      this.Ckz.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
      {
        this.Ckz.setVisibility(0);
        this.Ckz.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
      }
      if (Cji == 2) {
        this.CkG = true;
      }
      AppMethodBeat.o(115480);
      return;
      label277:
      this.Ckn.setVisibility(8);
    }
  }
  
  private void aUi()
  {
    AppMethodBeat.i(115491);
    if ((this.mTimer == null) || (this.oZE))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.CiS) {
      this.CiS = bt.aQJ();
    }
    this.oZE = true;
    TimerTask local4 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(216531);
        VoipVoiceFragment.this.jwD.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(216530);
            String str = VoipVoiceFragment.sm(bt.rM(VoipVoiceFragment.this.CiS));
            VoipVoiceFragment.g(VoipVoiceFragment.this).setText(str);
            VoipVoiceFragment.o(VoipVoiceFragment.this);
            AppMethodBeat.o(216530);
          }
        });
        AppMethodBeat.o(216531);
      }
    };
    this.mTimer.schedule(local4, 50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void eyP()
  {
    AppMethodBeat.i(115479);
    this.Ckk.setVisibility(0);
    this.Cko.setVisibility(8);
    this.Ckp.setText(2131764902);
    this.Cjk.a(this.Ckq, Cje);
    this.Ckr.setVisibility(0);
    this.CkA.setVisibility(8);
    this.CkB.setVisibility(8);
    this.CkC.setVisibility(8);
    this.CkD.setVisibility(0);
    this.CkE.setVisibility(8);
    this.Ckv.setVisibility(0);
    this.Ckw.setEnabled(false);
    this.Ckw.setBackgroundResource(2131234600);
    this.Ckx.setTextColor(1728053247);
    this.Ckz.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
    {
      this.Ckz.setVisibility(0);
      this.Ckz.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
    }
    ezh();
    this.Ckw.setChecked(this.mIsMute);
    this.Cks.setVisibility(0);
    if (2 == this.BYM) {
      iv(2131764790, 10000);
    }
    eyW();
    AppMethodBeat.o(115479);
  }
  
  private void ezc()
  {
    AppMethodBeat.i(115481);
    this.Ckp.setText(2131764949);
    this.Cjk.a(this.Ckq, Cje);
    this.CkA.setVisibility(8);
    this.CkB.setVisibility(8);
    this.CkC.setVisibility(0);
    this.CkD.setVisibility(8);
    this.CkE.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void ezd()
  {
    AppMethodBeat.i(115482);
    this.Cjk.eyY();
    this.CkC.setEnabled(false);
    this.CkD.setEnabled(false);
    this.CkA.setEnabled(false);
    this.CkB.setEnabled(false);
    this.CkE.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void eze()
  {
    AppMethodBeat.i(115483);
    this.Ckk.setVisibility(0);
    this.Ckr.setVisibility(0);
    this.Ckp.setText(2131764875);
    this.Cjk.a(this.Ckq, Cje);
    if (this.Ckn != null)
    {
      if ((!am.aSQ(this.fGM)) || (bt.ai(this.Ckn.getText()))) {
        break label211;
      }
      this.Ckn.setVisibility(0);
    }
    for (;;)
    {
      ezh();
      this.CkA.setVisibility(0);
      this.CkB.setVisibility(0);
      this.CkC.setVisibility(8);
      this.CkD.setVisibility(8);
      if (this.Cil) {
        this.CkE.setVisibility(0);
      }
      if (Cji == 256)
      {
        this.CkG = true;
        iv(2131764791, 10000);
      }
      eyW();
      this.Ckz.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
      {
        this.Ckz.setVisibility(0);
        this.Ckz.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.Ckn.setVisibility(8);
    }
  }
  
  private void ezf()
  {
    AppMethodBeat.i(115484);
    this.Ckk.setVisibility(0);
    this.Ckr.setVisibility(0);
    this.Ckp.setText(2131764949);
    this.Cjk.a(this.Ckq, Cje);
    this.CkA.setVisibility(8);
    this.CkB.setVisibility(8);
    this.CkC.setVisibility(0);
    this.CkD.setVisibility(8);
    this.CkE.setVisibility(8);
    iv(2131764790, 10000);
    eyW();
    AppMethodBeat.o(115484);
  }
  
  private void ezg()
  {
    AppMethodBeat.i(115485);
    this.CkD.setVisibility(8);
    this.CkA.setVisibility(8);
    this.CkB.setVisibility(8);
    this.CkE.setVisibility(8);
    this.Ckr.setVisibility(8);
    this.Cjk.eyY();
    this.CkC.setVisibility(0);
    this.Cko.setVisibility(0);
    this.Ckv.setVisibility(0);
    this.Cks.setVisibility(0);
    this.Ckk.setVisibility(0);
    this.ChL.setVisibility(0);
    this.Ckw.setEnabled(true);
    this.Ckw.setBackgroundResource(2131234589);
    this.Ckx.setTextColor(-1);
    ezh();
    this.Ckw.setChecked(this.mIsMute);
    if (!this.CkG) {
      iv(2131764783, 10000);
    }
    for (;;)
    {
      if (ac.iPB) {
        this.Cia.setVisibility(0);
      }
      eyW();
      aUi();
      this.Ckz.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.euM().BZf != null)
      {
        this.Ckz.setVisibility(0);
        this.Ckz.setText(com.tencent.mm.plugin.voip.c.euM().BZf);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.BYM) {
        iv(2131764785, 10000);
      } else if (3 == this.BYM) {
        iv(2131764784, 10000);
      }
    }
  }
  
  private void ezh()
  {
    AppMethodBeat.i(115493);
    if ((this.Ckt == null) || (this.Cku == null))
    {
      ad.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.BYM) || (3 == this.BYM))
    {
      this.Ckt.setEnabled(false);
      this.Cku.setTextColor(1728053247);
      this.Ckt.setBackgroundResource(2131234586);
      ad.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.BYM == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.Ckt.setBackgroundResource(2131234590);
      this.Ckt.setEnabled(true);
      this.Cku.setTextColor(-1);
      this.Ckt.setChecked(bool);
      ad.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  public final void Uz(int paramInt)
  {
    AppMethodBeat.i(216533);
    if (this.uVp != null)
    {
      this.CkH = true;
      if (this.lPT.findViewById(2131308162) != null) {
        this.lPT.findViewById(2131308162).setOnClickListener(new VoipVoiceFragment.12(this));
      }
      this.CkF.setVisibility(0);
      this.uVp.setVisibility(0);
      this.uVp.setText(2131766838);
      this.jwD.removeCallbacks(this.CkO);
      this.jwD.postDelayed(this.CkO, paramInt * 1000);
    }
    AppMethodBeat.o(216533);
  }
  
  protected final void aDI(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.Ckz != null)
    {
      this.Ckz.setVisibility(0);
      this.Ckz.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  protected final void eyM()
  {
    AppMethodBeat.i(115489);
    if (this.uVp != null)
    {
      this.uVp.clearAnimation();
      this.uVp.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void eyN() {}
  
  public final void iu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.iu(paramInt1, paramInt2);
    ad.i("MicroMsg.VoipVoiceFragment", "newState: " + com.tencent.mm.plugin.voip.b.l.UK(paramInt2) + ", action: " + com.tencent.mm.plugin.voip.b.l.UK(paramInt1) + ", lastStatus: " + com.tencent.mm.plugin.voip.b.l.UK(Cji) + ", isSwitchFromVideo: " + this.CkG);
    if (this.lPT == null)
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
      eyP();
      AppMethodBeat.o(115477);
      return;
      UA(paramInt1);
      AppMethodBeat.o(115477);
      return;
      ezc();
      AppMethodBeat.o(115477);
      return;
      ezg();
      AppMethodBeat.o(115477);
      return;
      ezd();
      AppMethodBeat.o(115477);
      return;
      eze();
      AppMethodBeat.o(115477);
      return;
      ezf();
    }
  }
  
  protected final void iv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.Cky == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.Cky.setText(paramInt1);
    this.Cky.setVisibility(0);
    this.Cky.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.Cky.setBackgroundResource(2131234591);
    this.Cky.setCompoundDrawables(null, null, null, null);
    this.Cky.setCompoundDrawablePadding(0);
    this.jwD.removeCallbacks(this.pVz);
    if (-1 != paramInt2) {
      this.jwD.postDelayed(this.pVz, paramInt2);
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
      this.lPT = ((RelativeLayout)paramLayoutInflater.inflate(2131495885, paramViewGroup, false));
      this.Cjf = ((ImageView)this.lPT.findViewById(2131306556));
      this.Ckk = this.lPT.findViewById(2131306607);
      this.Ckl = ((ImageView)this.lPT.findViewById(2131306621));
      a.b.a(this.Ckl, this.fGM, 0.0375F, true);
      this.Ckm = ((TextView)this.lPT.findViewById(2131306622));
      this.Ckm.setText(k.b(getActivity(), v.zf(this.fGM), this.Ckm.getTextSize()));
      this.Ckn = ((TextView)this.lPT.findViewById(2131306624));
      this.Cko = ((TextView)this.lPT.findViewById(2131306629));
      this.Ckp = ((TextView)this.lPT.findViewById(2131306611));
      this.Ckq = ((TextView)this.lPT.findViewById(2131306613));
      this.Ckr = this.lPT.findViewById(2131306612);
      this.Cky = ((TextView)this.lPT.findViewById(2131306608));
      this.Ckz = ((TextView)this.lPT.findViewById(2131306625));
      this.uVp = ((TextView)this.lPT.findViewById(2131306581));
      this.CkF = ((ImageView)this.lPT.findViewById(2131308146));
      this.CkF.setImageDrawable(ao.k(aj.getContext(), 2131690349, -1));
      t(this.Ckq);
      if (ac.iPB) {
        this.Cia = ((TextView)this.lPT.findViewById(2131299493));
      }
      this.Ckv = ((RelativeLayout)this.lPT.findViewById(2131306615));
      this.Ckw = ((MMCheckBox)this.lPT.findViewById(2131306614));
      this.Ckw.setChecked(this.mIsMute);
      this.Ckx = ((TextView)this.lPT.findViewById(2131306616));
      this.Ckx.setText(2131764886);
      this.Cks = ((RelativeLayout)this.lPT.findViewById(2131306627));
      this.Ckt = ((MMCheckBox)this.lPT.findViewById(2131306626));
      this.Cku = ((TextView)this.lPT.findViewById(2131306628));
      this.Cku.setText(2131764919);
      ezh();
      this.CkA = ((VoipBigIconButton)this.lPT.findViewById(2131306606));
      this.CkA.setOnClickListener(this.CkK);
      this.CkB = ((VoipBigIconButton)this.lPT.findViewById(2131306620));
      this.CkB.setOnClickListener(this.CkL);
      this.CkC = ((VoipBigIconButton)this.lPT.findViewById(2131306610));
      this.CkC.setOnClickListener(this.CkM);
      this.CkD = ((VoipBigIconButton)this.lPT.findViewById(2131306609));
      this.CkD.setOnClickListener(this.CkN);
      if (n.II("VOIPBlockIgnoreButton") != 0) {
        break label972;
      }
    }
    label972:
    for (boolean bool = true;; bool = false)
    {
      this.Cil = bool;
      this.CkE = ((VoipSmallIconButton)this.lPT.findViewById(2131306576));
      this.CkE.setOnClickListener(this.CiE);
      if (!this.Cil) {
        this.CkE.setVisibility(8);
      }
      this.Ckt.setOnClickListener(this.CkI);
      this.Ckw.setOnClickListener(this.CkJ);
      this.ChL = ((Button)this.lPT.findViewById(2131297592));
      this.ChL.setOnClickListener(this.CiD);
      int i = t.jW(getActivity());
      ad.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      av(this.ChL, i);
      if ((this.BYH) && (2 == this.BYM)) {
        iv(2131764790, 10000);
      }
      paramLayoutInflater = com.tencent.mm.openim.room.a.a.H(((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.fGM));
      if ((!bt.isNullOrNil(paramLayoutInflater)) && (this.Ckn != null)) {
        this.Ckn.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      iu(this.Cjh, this.mStatus);
      paramLayoutInflater = this.lPT;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.lPT = ((RelativeLayout)paramLayoutInflater.inflate(2131495884, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.lPT.findViewById(2131304207)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.oZE = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    ad.m("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.Ckw != null) && (this.Ckx != null)) {
      this.Ckw.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.BYM = paramInt;
      ezh();
    }
    AppMethodBeat.o(115492);
  }
  
  protected final void tt(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.CkH)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.uVp != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.uVp.setText(2131764892);
    }
    for (;;)
    {
      this.uVp.clearAnimation();
      this.uVp.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.uVp.setText(2131764891);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */