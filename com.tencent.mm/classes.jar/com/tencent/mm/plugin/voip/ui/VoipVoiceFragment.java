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
import com.tencent.mm.plugin.voip.b.j;
import com.tencent.mm.plugin.voip.b.l;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.t;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class VoipVoiceFragment
  extends VoipBaseFragment
{
  private Button AIK;
  private TextView AIZ;
  private View.OnClickListener AJC;
  private View.OnClickListener AJD;
  private boolean AJk;
  private boolean ALA;
  private boolean ALB;
  private View.OnClickListener ALC;
  private View.OnClickListener ALD;
  private View.OnClickListener ALE;
  private View.OnClickListener ALF;
  private View.OnClickListener ALG;
  private View.OnClickListener ALH;
  private Runnable ALI;
  private View ALf;
  private ImageView ALg;
  private TextView ALh;
  private TextView ALi;
  private TextView ALj;
  private TextView ALk;
  private TextView ALl;
  private View ALm;
  private RelativeLayout ALn;
  private MMCheckBox ALo;
  private TextView ALp;
  private RelativeLayout ALq;
  private MMCheckBox ALr;
  private TextView ALs;
  private TextView ALt;
  private TextView ALu;
  private VoipBigIconButton ALv;
  private VoipBigIconButton ALw;
  private VoipBigIconButton ALx;
  private VoipBigIconButton ALy;
  private VoipSmallIconButton ALz;
  private int AzM;
  private boolean mIsMute;
  private Timer mTimer;
  private boolean owj;
  private Runnable prT;
  private TextView tSC;
  
  public VoipVoiceFragment()
  {
    AppMethodBeat.i(115474);
    this.AzM = 1;
    this.mIsMute = false;
    this.owj = false;
    this.AJk = false;
    this.ALA = false;
    this.ALB = false;
    this.AJC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115463);
        h.wUl.f(11618, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null)) {
          ((c)VoipVoiceFragment.this.AJQ.get()).sw(true);
        }
        if (VoipVoiceFragment.this.AKh != null) {
          VoipVoiceFragment.this.AKh.as(false, true);
        }
        AppMethodBeat.o(115463);
      }
    };
    this.AJD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115466);
        h.wUl.f(11619, new Object[] { Integer.valueOf(3) });
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null)) {
          ((c)VoipVoiceFragment.this.AJQ.get()).ehR();
        }
        AppMethodBeat.o(115466);
      }
    };
    this.ALC = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115467);
        boolean bool = VoipVoiceFragment.a(VoipVoiceFragment.this).isChecked();
        ac.i("MicroMsg.VoipVoiceFragment", "onSpeakerClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.a(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null)) {
          ((c)VoipVoiceFragment.this.AJQ.get()).su(bool);
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
    this.ALD = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115468);
        boolean bool = VoipVoiceFragment.b(VoipVoiceFragment.this).isChecked();
        ac.i("MicroMsg.VoipVoiceFragment", "onMicClick, status: %b", new Object[] { Boolean.valueOf(bool) });
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(false);
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null)) {
          ((c)VoipVoiceFragment.this.AJQ.get()).om(bool);
        }
        VoipVoiceFragment.a(VoipVoiceFragment.this, bool);
        VoipVoiceFragment.b(VoipVoiceFragment.this).setEnabled(true);
        AppMethodBeat.o(115468);
      }
    };
    this.ALE = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115469);
        ac.i("MicroMsg.VoipVoiceFragment", "click accept voice invite button");
        h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejL()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejM()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().eim()), Integer.valueOf(2) });
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null) && (((c)VoipVoiceFragment.this.AJQ.get()).ehs()))
        {
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.d(VoipVoiceFragment.this).setText(2131764949);
          VoipVoiceFragment.this.AKi.a(VoipVoiceFragment.e(VoipVoiceFragment.this), VoipBaseFragment.AKc);
          VoipVoiceFragment.f(VoipVoiceFragment.this).setVisibility(0);
          VoipVoiceFragment.g(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.h(VoipVoiceFragment.this).setVisibility(8);
          VoipVoiceFragment.i(VoipVoiceFragment.this).setVisibility(0);
        }
        AppMethodBeat.o(115469);
      }
    };
    this.ALF = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115470);
        ac.i("MicroMsg.VoipVoiceFragment", "click reject voice invite button");
        h.wUl.a(11526, true, true, new Object[] { Integer.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejL()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().ejM()), Long.valueOf(com.tencent.mm.plugin.voip.c.ehb().eim()), Integer.valueOf(5) });
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null) && (((c)VoipVoiceFragment.this.AJQ.get()).ehr()))
        {
          VoipVoiceFragment.h(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.c(VoipVoiceFragment.this).setEnabled(false);
          VoipVoiceFragment.this.ii(2131764909, -1);
          if (VoipVoiceFragment.this.AKh != null) {
            VoipVoiceFragment.this.AKh.as(true, false);
          }
        }
        AppMethodBeat.o(115470);
      }
    };
    this.ALG = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115471);
        ac.i("MicroMsg.VoipVoiceFragment", "click hangup voice talking button");
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null) && (((c)VoipVoiceFragment.this.AJQ.get()).ehm())) {
          VoipVoiceFragment.this.ii(2131764857, -1);
        }
        AppMethodBeat.o(115471);
      }
    };
    this.ALH = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(115472);
        ac.i("MicroMsg.VoipVoiceFragment", "click cancel voice invite button");
        if ((VoipVoiceFragment.this.AJQ != null) && (VoipVoiceFragment.this.AJQ.get() != null) && (((c)VoipVoiceFragment.this.AJQ.get()).ehu()))
        {
          VoipVoiceFragment.this.ii(2131764813, -1);
          VoipVoiceFragment.j(VoipVoiceFragment.this).setEnabled(false);
        }
        AppMethodBeat.o(115472);
      }
    };
    this.prT = new Runnable()
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
    this.ALI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(115465);
        if ((VoipVoiceFragment.this.getActivity() == null) || (VoipVoiceFragment.this.getActivity().isFinishing()))
        {
          AppMethodBeat.o(115465);
          return;
        }
        VoipVoiceFragment.l(VoipVoiceFragment.this);
        VoipVoiceFragment.m(VoipVoiceFragment.this).setVisibility(8);
        AppMethodBeat.o(115465);
      }
    };
    AppMethodBeat.o(115474);
  }
  
  private void SH(int paramInt)
  {
    AppMethodBeat.i(115480);
    this.ALf.setVisibility(0);
    this.ALj.setVisibility(8);
    this.ALk.setText(2131764874);
    this.AKi.a(this.ALl, AKc);
    this.ALm.setVisibility(0);
    if (this.ALi != null)
    {
      if ((!ai.aNc(this.foE)) || (bs.aj(this.ALi.getText()))) {
        break label277;
      }
      this.ALi.setVisibility(0);
    }
    for (;;)
    {
      this.ALv.setVisibility(8);
      this.ALw.setVisibility(8);
      this.ALx.setVisibility(8);
      this.ALy.setVisibility(0);
      this.ALz.setVisibility(8);
      this.ALq.setVisibility(0);
      this.ALr.setEnabled(false);
      this.ALr.setBackgroundResource(2131234600);
      this.ALs.setTextColor(1728053247);
      elx();
      this.ALr.setChecked(this.mIsMute);
      this.ALn.setVisibility(0);
      if ((paramInt != 4097) && (2 == this.AzM)) {
        ii(2131764790, 10000);
      }
      elm();
      this.ALu.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
      {
        this.ALu.setVisibility(0);
        this.ALu.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
      }
      if (AKg == 2) {
        this.ALA = true;
      }
      AppMethodBeat.o(115480);
      return;
      label277:
      this.ALi.setVisibility(8);
    }
  }
  
  private void aQW()
  {
    AppMethodBeat.i(115491);
    if ((this.mTimer == null) || (this.owj))
    {
      AppMethodBeat.o(115491);
      return;
    }
    if (-1L == this.AJR) {
      this.AJR = bs.aNx();
    }
    this.owj = true;
    TimerTask local3 = new TimerTask()
    {
      public final void run()
      {
        AppMethodBeat.i(208487);
        VoipVoiceFragment.this.jdu.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(208486);
            String str = VoipVoiceFragment.qn(bs.pN(VoipVoiceFragment.this.AJR));
            VoipVoiceFragment.g(VoipVoiceFragment.this).setText(str);
            VoipVoiceFragment.n(VoipVoiceFragment.this);
            AppMethodBeat.o(208486);
          }
        });
        AppMethodBeat.o(208487);
      }
    };
    this.mTimer.schedule(local3, 50L, 1000L);
    AppMethodBeat.o(115491);
  }
  
  private void elf()
  {
    AppMethodBeat.i(115479);
    this.ALf.setVisibility(0);
    this.ALj.setVisibility(8);
    this.ALk.setText(2131764902);
    this.AKi.a(this.ALl, AKc);
    this.ALm.setVisibility(0);
    this.ALv.setVisibility(8);
    this.ALw.setVisibility(8);
    this.ALx.setVisibility(8);
    this.ALy.setVisibility(0);
    this.ALz.setVisibility(8);
    this.ALq.setVisibility(0);
    this.ALr.setEnabled(false);
    this.ALr.setBackgroundResource(2131234600);
    this.ALs.setTextColor(1728053247);
    this.ALu.setVisibility(8);
    if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
    {
      this.ALu.setVisibility(0);
      this.ALu.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
    }
    elx();
    this.ALr.setChecked(this.mIsMute);
    this.ALn.setVisibility(0);
    if (2 == this.AzM) {
      ii(2131764790, 10000);
    }
    elm();
    AppMethodBeat.o(115479);
  }
  
  private void els()
  {
    AppMethodBeat.i(115481);
    this.ALk.setText(2131764949);
    this.AKi.a(this.ALl, AKc);
    this.ALv.setVisibility(8);
    this.ALw.setVisibility(8);
    this.ALx.setVisibility(0);
    this.ALy.setVisibility(8);
    this.ALz.setVisibility(8);
    AppMethodBeat.o(115481);
  }
  
  private void elt()
  {
    AppMethodBeat.i(115482);
    this.AKi.elo();
    this.ALx.setEnabled(false);
    this.ALy.setEnabled(false);
    this.ALv.setEnabled(false);
    this.ALw.setEnabled(false);
    this.ALz.setEnabled(false);
    AppMethodBeat.o(115482);
  }
  
  private void elu()
  {
    AppMethodBeat.i(115483);
    this.ALf.setVisibility(0);
    this.ALm.setVisibility(0);
    this.ALk.setText(2131764875);
    this.AKi.a(this.ALl, AKc);
    if (this.ALi != null)
    {
      if ((!ai.aNc(this.foE)) || (bs.aj(this.ALi.getText()))) {
        break label211;
      }
      this.ALi.setVisibility(0);
    }
    for (;;)
    {
      elx();
      this.ALv.setVisibility(0);
      this.ALw.setVisibility(0);
      this.ALx.setVisibility(8);
      this.ALy.setVisibility(8);
      if (this.AJk) {
        this.ALz.setVisibility(0);
      }
      if (AKg == 256)
      {
        this.ALA = true;
        ii(2131764791, 10000);
      }
      elm();
      this.ALu.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
      {
        this.ALu.setVisibility(0);
        this.ALu.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
      }
      AppMethodBeat.o(115483);
      return;
      label211:
      this.ALi.setVisibility(8);
    }
  }
  
  private void elv()
  {
    AppMethodBeat.i(115484);
    this.ALf.setVisibility(0);
    this.ALm.setVisibility(0);
    this.ALk.setText(2131764949);
    this.AKi.a(this.ALl, AKc);
    this.ALv.setVisibility(8);
    this.ALw.setVisibility(8);
    this.ALx.setVisibility(0);
    this.ALy.setVisibility(8);
    this.ALz.setVisibility(8);
    ii(2131764790, 10000);
    elm();
    AppMethodBeat.o(115484);
  }
  
  private void elw()
  {
    AppMethodBeat.i(115485);
    this.ALy.setVisibility(8);
    this.ALv.setVisibility(8);
    this.ALw.setVisibility(8);
    this.ALz.setVisibility(8);
    this.ALm.setVisibility(8);
    this.AKi.elo();
    this.ALx.setVisibility(0);
    this.ALj.setVisibility(0);
    this.ALq.setVisibility(0);
    this.ALn.setVisibility(0);
    this.ALf.setVisibility(0);
    this.AIK.setVisibility(0);
    this.ALr.setEnabled(true);
    this.ALr.setBackgroundResource(2131234589);
    this.ALs.setTextColor(-1);
    elx();
    this.ALr.setChecked(this.mIsMute);
    if (!this.ALA) {
      ii(2131764783, 10000);
    }
    for (;;)
    {
      if (ab.iwt) {
        this.AIZ.setVisibility(0);
      }
      elm();
      aQW();
      this.ALu.setVisibility(8);
      if (com.tencent.mm.plugin.voip.c.ehb().AAf != null)
      {
        this.ALu.setVisibility(0);
        this.ALu.setText(com.tencent.mm.plugin.voip.c.ehb().AAf);
      }
      AppMethodBeat.o(115485);
      return;
      if (2 == this.AzM) {
        ii(2131764785, 10000);
      } else if (3 == this.AzM) {
        ii(2131764784, 10000);
      }
    }
  }
  
  private void elx()
  {
    AppMethodBeat.i(115493);
    if ((this.ALo == null) || (this.ALp == null))
    {
      ac.e("MicroMsg.VoipVoiceFragment", "speaker is null");
      AppMethodBeat.o(115493);
      return;
    }
    if ((4 == this.AzM) || (3 == this.AzM))
    {
      this.ALo.setEnabled(false);
      this.ALp.setTextColor(1728053247);
      this.ALo.setBackgroundResource(2131234586);
      ac.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, disable mCbVoiceSpeakerSwitcher");
      AppMethodBeat.o(115493);
      return;
    }
    if (this.AzM == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.ALo.setBackgroundResource(2131234590);
      this.ALo.setEnabled(true);
      this.ALp.setTextColor(-1);
      this.ALo.setChecked(bool);
      ac.i("MicroMsg.VoipVoiceFragment", "updateSpeakerStatus, set mCbVoiceSpeakerSwitcher isChecked:%s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(115493);
      return;
    }
  }
  
  protected final void ayA(String paramString)
  {
    AppMethodBeat.i(115486);
    if (this.ALu != null)
    {
      this.ALu.setVisibility(0);
      this.ALu.setText(paramString);
    }
    AppMethodBeat.o(115486);
  }
  
  public final void ela()
  {
    AppMethodBeat.i(208488);
    if (this.tSC != null)
    {
      this.ALB = true;
      this.tSC.setVisibility(0);
      this.tSC.setText(2131766838);
      this.jdu.removeCallbacks(this.ALI);
      this.jdu.postDelayed(this.ALI, 10000L);
    }
    AppMethodBeat.o(208488);
  }
  
  protected final void elc()
  {
    AppMethodBeat.i(115489);
    if (this.tSC != null)
    {
      this.tSC.clearAnimation();
      this.tSC.setVisibility(8);
    }
    AppMethodBeat.o(115489);
  }
  
  public final void eld() {}
  
  public final void ih(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115477);
    super.ih(paramInt1, paramInt2);
    ac.i("MicroMsg.VoipVoiceFragment", "newState: " + j.SR(paramInt2) + ", action: " + j.SR(paramInt1) + ", lastStatus: " + j.SR(AKg) + ", isSwitchFromVideo: " + this.ALA);
    if (this.wRY == null)
    {
      ac.i("MicroMsg.VoipVoiceFragment", "fragment no create, return first, onCreateView will call it again");
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
      elf();
      AppMethodBeat.o(115477);
      return;
      SH(paramInt1);
      AppMethodBeat.o(115477);
      return;
      els();
      AppMethodBeat.o(115477);
      return;
      elw();
      AppMethodBeat.o(115477);
      return;
      elt();
      AppMethodBeat.o(115477);
      return;
      elu();
      AppMethodBeat.o(115477);
      return;
      elv();
    }
  }
  
  protected final void ii(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(115487);
    if (this.ALt == null)
    {
      AppMethodBeat.o(115487);
      return;
    }
    this.ALt.setText(paramInt1);
    this.ALt.setVisibility(0);
    this.ALt.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
    this.ALt.setBackgroundResource(2131234591);
    this.ALt.setCompoundDrawables(null, null, null, null);
    this.ALt.setCompoundDrawablePadding(0);
    this.jdu.removeCallbacks(this.prT);
    if (-1 != paramInt2) {
      this.jdu.postDelayed(this.prT, paramInt2);
    }
    AppMethodBeat.o(115487);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(115476);
    paramBundle = new DisplayMetrics();
    ((WindowManager)paramLayoutInflater.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(paramBundle);
    ac.i("MicroMsg.VoipVoiceFragment", "dpi: " + paramBundle.heightPixels / paramBundle.density);
    if (paramBundle.heightPixels / paramBundle.density <= 540.0F)
    {
      this.wRY = ((RelativeLayout)paramLayoutInflater.inflate(2131495885, paramViewGroup, false));
      this.AKd = ((ImageView)this.wRY.findViewById(2131306556));
      this.ALf = this.wRY.findViewById(2131306607);
      this.ALg = ((ImageView)this.wRY.findViewById(2131306621));
      a.b.a(this.ALg, this.foE, 0.0375F, true);
      this.ALh = ((TextView)this.wRY.findViewById(2131306622));
      this.ALh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(getActivity(), v.wk(this.foE), this.ALh.getTextSize()));
      this.ALi = ((TextView)this.wRY.findViewById(2131306624));
      this.ALj = ((TextView)this.wRY.findViewById(2131306629));
      this.ALk = ((TextView)this.wRY.findViewById(2131306611));
      this.ALl = ((TextView)this.wRY.findViewById(2131306613));
      this.ALm = this.wRY.findViewById(2131306612);
      this.ALt = ((TextView)this.wRY.findViewById(2131306608));
      this.ALu = ((TextView)this.wRY.findViewById(2131306625));
      this.tSC = ((TextView)this.wRY.findViewById(2131306581));
      t(this.ALl);
      if (ab.iwt) {
        this.AIZ = ((TextView)this.wRY.findViewById(2131299493));
      }
      this.ALq = ((RelativeLayout)this.wRY.findViewById(2131306615));
      this.ALr = ((MMCheckBox)this.wRY.findViewById(2131306614));
      this.ALr.setChecked(this.mIsMute);
      this.ALs = ((TextView)this.wRY.findViewById(2131306616));
      this.ALs.setText(2131764886);
      this.ALn = ((RelativeLayout)this.wRY.findViewById(2131306627));
      this.ALo = ((MMCheckBox)this.wRY.findViewById(2131306626));
      this.ALp = ((TextView)this.wRY.findViewById(2131306628));
      this.ALp.setText(2131764919);
      elx();
      this.ALv = ((VoipBigIconButton)this.wRY.findViewById(2131306606));
      this.ALv.setOnClickListener(this.ALE);
      this.ALw = ((VoipBigIconButton)this.wRY.findViewById(2131306620));
      this.ALw.setOnClickListener(this.ALF);
      this.ALx = ((VoipBigIconButton)this.wRY.findViewById(2131306610));
      this.ALx.setOnClickListener(this.ALG);
      this.ALy = ((VoipBigIconButton)this.wRY.findViewById(2131306609));
      this.ALy.setOnClickListener(this.ALH);
      if (l.Fs("VOIPBlockIgnoreButton") != 0) {
        break label938;
      }
    }
    label938:
    for (boolean bool = true;; bool = false)
    {
      this.AJk = bool;
      this.ALz = ((VoipSmallIconButton)this.wRY.findViewById(2131306576));
      this.ALz.setOnClickListener(this.AJD);
      if (!this.AJk) {
        this.ALz.setVisibility(8);
      }
      this.ALo.setOnClickListener(this.ALC);
      this.ALr.setOnClickListener(this.ALD);
      this.AIK = ((Button)this.wRY.findViewById(2131297592));
      this.AIK.setOnClickListener(this.AJC);
      int i = t.jL(getActivity());
      ac.d("MicroMsg.VoipVoiceFragment", "statusHeight: ".concat(String.valueOf(i)));
      au(this.AIK, i);
      if ((this.AzH) && (2 == this.AzM)) {
        ii(2131764790, 10000);
      }
      paramLayoutInflater = a.H(((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(this.foE));
      if ((!bs.isNullOrNil(paramLayoutInflater)) && (this.ALi != null)) {
        this.ALi.setText(paramLayoutInflater);
      }
      this.mTimer = new Timer();
      ih(this.AKf, this.mStatus);
      paramLayoutInflater = this.wRY;
      AppMethodBeat.o(115476);
      return paramLayoutInflater;
      this.wRY = ((RelativeLayout)paramLayoutInflater.inflate(2131495884, paramViewGroup, false));
      if (!Build.MANUFACTURER.equalsIgnoreCase("meizu")) {
        break;
      }
      ((RelativeLayout)this.wRY.findViewById(2131304207)).setPadding(0, 0, 0, BackwardSupportUtil.b.g(getActivity(), 40.0F));
      break;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(115475);
    this.owj = false;
    super.onDestroy();
    AppMethodBeat.o(115475);
  }
  
  protected final void sK(boolean paramBoolean)
  {
    AppMethodBeat.i(115488);
    if (this.ALB)
    {
      AppMethodBeat.o(115488);
      return;
    }
    if (this.tSC != null)
    {
      if (!paramBoolean) {
        break label63;
      }
      this.tSC.setText(2131764892);
    }
    for (;;)
    {
      this.tSC.clearAnimation();
      this.tSC.setVisibility(0);
      AppMethodBeat.o(115488);
      return;
      label63:
      this.tSC.setText(2131764891);
    }
  }
  
  public final void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(115490);
    ac.m("MicroMsg.VoipVoiceFragment", "setMute:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    if ((this.ALr != null) && (this.ALs != null)) {
      this.ALr.setChecked(paramBoolean);
    }
    AppMethodBeat.o(115490);
  }
  
  public final void setVoicePlayDevice(int paramInt)
  {
    AppMethodBeat.i(115492);
    if (paramInt != -1)
    {
      this.AzM = paramInt;
      elx();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.ui.VoipVoiceFragment
 * JD-Core Version:    0.7.0.1
 */