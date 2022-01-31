package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.bq.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.h;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private String mReceiverName;
  private int ppH;
  private int ppI;
  private int qpS;
  private String uDL;
  private String uDM;
  private int uDN;
  private int uDO;
  
  public final void Cu(int paramInt)
  {
    AppMethodBeat.i(48554);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.qlT, this.qpO, this.qpL), true);
    AppMethodBeat.o(48554);
  }
  
  public final void Cv(int paramInt)
  {
    AppMethodBeat.i(48555);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.qlT, this.qpO, this.qpL, paramInt), true);
    AppMethodBeat.o(48555);
  }
  
  public final void am(Intent paramIntent)
  {
    AppMethodBeat.i(48556);
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(48556);
  }
  
  public final void chx()
  {
    AppMethodBeat.i(48557);
    doSceneProgress(new c(this.qlT, this.qpS, this.uDL, this.qpO));
    AppMethodBeat.o(48557);
  }
  
  public final void chy()
  {
    AppMethodBeat.i(48558);
    doSceneProgress(new b(this.qlT, this.qpS, this.uDL, this.qpO));
    AppMethodBeat.o(48558);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48553);
    super.onCreate(paramBundle);
    this.qpS = getIntent().getIntExtra("total_fee", 0);
    this.uDL = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.uDM = r.Zn();
      this.mReceiverName = this.qpO;
      AppMethodBeat.o(48553);
      return;
    }
    this.uDM = this.qpO;
    this.mReceiverName = r.Zn();
    AppMethodBeat.o(48553);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    AppMethodBeat.i(48559);
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.e))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.e)paramm;
      Object localObject1;
      Object localObject2;
      a locala;
      if (paramString.ctW == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.qpM == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.qpa.setImageResource(2130840886);
            this.qpb.setText(2131302567);
            this.qpc.setText(com.tencent.mm.wallet_core.ui.e.e(paramString.kNS, paramString.ppp));
            this.qpf.setVisibility(0);
            this.qpf.setOnClickListener(new PayURemittanceDetailUI.6(this));
            paramm = getString(2131302571, new Object[] { Integer.valueOf(this.qpQ) });
            localObject1 = getString(2131302559);
            localObject2 = new SpannableString(paramm + (String)localObject1);
            locala = new a(this);
            locala.prW = new PayURemittanceDetailUI.7(this);
            ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
            this.orU.setMovementMethod(LinkMovementMethod.getInstance());
            this.orU.setText((CharSequence)localObject2);
            this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(paramString.qku) }));
            this.qpd.setVisibility(0);
            this.qpe.setVisibility(8);
          }
          AppMethodBeat.o(48559);
          return true;
        }
        Cv(0);
        AppMethodBeat.o(48559);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.uDN = paramString.status;
          this.uDO = paramString.qku;
          this.ppI = paramString.uDH;
          this.ppH = paramString.uDI;
          this.qpS = ((int)(paramString.kNS * 100.0D));
          this.uDL = paramString.ppp;
          paramm = r.Zn();
          bool1 = this.mReceiverName.equals(paramm);
          this.qpf.setVisibility(8);
          this.qpc.setText(com.tencent.mm.wallet_core.ui.e.e(this.qpS / 100.0D, this.uDL));
          this.qpg.setVisibility(0);
          this.qpB.setVisibility(8);
          paramInt1 = this.uDN;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.bsY == 1)
        {
          g.RM();
          if (!((String)g.RL().Ru().get(327729, "0")).equals("0")) {
            break label1562;
          }
          h.a(getContext(), 2131298203, 2131305584, new PayURemittanceDetailUI.8(this));
          g.RM();
          g.RL().Ru().set(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(48559);
        return bool1;
        if (!bool1)
        {
          paramm = getString(2131302568, new Object[] { bi(this.mReceiverName, true) });
          this.qpb.setText(j.b(this, paramm, this.qpb.getTextSize()));
          paramm = getString(2131302575, new Object[] { Integer.valueOf(this.qpQ) });
          localObject1 = getString(2131302614);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.prW = new PayURemittanceDetailUI.1(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.orU.setMovementMethod(LinkMovementMethod.getInstance());
          this.orU.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.qpa.setImageResource(2130840886);
          this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(this.ppI) }));
          this.qpd.setVisibility(0);
          this.qpe.setVisibility(8);
          bool1 = true;
          break;
          this.qpa.setImageResource(2130840886);
          this.qpf.setVisibility(0);
          this.qpf.setOnClickListener(new PayURemittanceDetailUI.2(this));
          paramm = getString(2131302571, new Object[] { Integer.valueOf(this.qpQ) });
          localObject1 = getString(2131302559);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.prW = new PayURemittanceDetailUI.3(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.orU.setMovementMethod(LinkMovementMethod.getInstance());
          this.orU.setText((CharSequence)localObject2);
        }
        this.qpa.setImageResource(2131231923);
        if (bool1)
        {
          this.qpb.setText(2131302562);
          paramm = getString(2131302543);
          localObject1 = new SpannableString(paramm);
          localObject2 = new a(this);
          ((a)localObject2).prW = new PayURemittanceDetailUI.4(this);
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramm.length(), 33);
          this.orU.setMovementMethod(LinkMovementMethod.getInstance());
          this.orU.setText((CharSequence)localObject1);
          this.orU.setVisibility(0);
        }
        for (;;)
        {
          this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(this.uDO) }));
          this.qpd.setVisibility(0);
          this.qpe.setText(getString(2131302551, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(this.ppH) }));
          this.qpe.setVisibility(0);
          bool1 = true;
          break;
          paramm = bi(this.mReceiverName, true) + " " + getString(2131302562);
          this.qpb.setText(j.b(this, paramm, this.qpb.getTextSize()));
          this.orU.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.qpa.setImageResource(2131231925);
          this.qpb.setText(2131302566);
          label1260:
          if (bool1) {
            break label1549;
          }
          paramm = getString(2131302556);
          localObject1 = getString(2131302543);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.prW = new PayURemittanceDetailUI.5(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.orU.setMovementMethod(LinkMovementMethod.getInstance());
          this.orU.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.orU.setVisibility(0);
          this.qpd.setText(getString(2131302576, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(this.uDO) }));
          this.qpd.setVisibility(0);
          this.qpe.setText(getString(2131302554, new Object[] { com.tencent.mm.wallet_core.ui.e.kB(this.ppI) }));
          this.qpe.setVisibility(0);
          bool1 = true;
          break;
          this.qpa.setImageResource(2131231924);
          if (bool1)
          {
            this.qpb.setText(2131302564);
            break label1260;
          }
          paramm = bi(this.mReceiverName, true) + getString(2131302564);
          this.qpb.setText(j.b(this, paramm, this.qpb.getTextSize()));
          break label1260;
          label1549:
          this.orU.setText("");
        }
        label1562:
        h.bO(getContext(), getString(2131302549));
      }
    }
    if (((paramm instanceof c)) || ((paramm instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramm instanceof c)) {
          Cv(1);
        }
        for (;;)
        {
          AppMethodBeat.o(48559);
          return true;
          aZ(0, getString(2131302550));
        }
      }
      aZ(paramInt2, paramString);
      AppMethodBeat.o(48559);
      return true;
    }
    AppMethodBeat.o(48559);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */