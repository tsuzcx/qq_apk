package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private int mPr;
  private int mPs;
  private int nDi;
  private String nEi;
  private String qOE;
  private String qOF;
  private int qOG;
  private int qOH;
  
  protected final void T(Intent paramIntent)
  {
    d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
  }
  
  protected final void bwG()
  {
    a(new c(this.nAx, this.nDi, this.qOE, this.nDe), true, true);
  }
  
  protected final void bwH()
  {
    a(new b(this.nAx, this.nDi, this.qOE, this.nDe), true, true);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.e))
    {
      paramString = (com.tencent.mm.plugin.wallet_payu.remittance.a.e)paramm;
      Object localObject1;
      Object localObject2;
      a locala;
      boolean bool2;
      if (paramString.bMC == 0) {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.nDc == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.nCV.setImageResource(a.e.wallet_subject_receiving);
            this.nCW.setText(a.i.remittance_detail_result_wait_receiver);
            this.nCX.setText(com.tencent.mm.wallet_core.ui.e.d(paramString.iHP, paramString.mOZ));
            this.nCY.setVisibility(0);
            this.nCY.setOnClickListener(new PayURemittanceDetailUI.6(this));
            paramm = getString(a.i.remittance_detail_reveiver_tips_payu, new Object[] { Integer.valueOf(this.nDg) });
            localObject1 = getString(a.i.remittance_detail_refuse_action);
            localObject2 = new SpannableString(paramm + (String)localObject1);
            locala = new a(this);
            locala.mRJ = new PayURemittanceDetailUI.7(this);
            ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
            this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
            this.lUL.setText((CharSequence)localObject2);
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(paramString.nzr) }));
            this.nCZ.setVisibility(0);
            this.nDa.setVisibility(8);
          }
          bool2 = true;
        }
      }
      boolean bool1;
      do
      {
        return bool2;
        wF(0);
        return true;
        bool2 = false;
        bool1 = bool2;
        if (paramInt1 == 0)
        {
          bool1 = bool2;
          if (paramInt2 == 0)
          {
            this.qOG = paramString.status;
            this.qOH = paramString.nzr;
            this.mPs = paramString.qOA;
            this.mPr = paramString.qOB;
            this.nDi = ((int)(paramString.iHP * 100.0D));
            this.qOE = paramString.mOZ;
            bool1 = true;
            paramm = q.Gj();
            bool2 = this.nEi.equals(paramm);
            this.nCY.setVisibility(8);
            this.nCX.setText(com.tencent.mm.wallet_core.ui.e.d(this.nDi / 100.0D, this.qOE));
            paramInt1 = this.qOG;
          }
        }
        switch (paramInt1)
        {
        default: 
          finish();
          bool2 = bool1;
        }
      } while (paramString.bcw != 1);
      g.DQ();
      if (((String)g.DP().Dz().get(327729, "0")).equals("0"))
      {
        h.a(this.mController.uMN, a.i.chatting_item_appmsg_remittance_collect_tips_payu, a.i.wallet_remittance_collect_tips, new PayURemittanceDetailUI.8(this));
        g.DQ();
        g.DP().Dz().o(327729, "1");
        return bool1;
        if (!bool2)
        {
          paramm = getString(a.i.remittance_detail_result_wait_sender, new Object[] { aT(this.nEi, true) });
          this.nCW.setText(j.a(this, paramm, this.nCW.getTextSize()));
          paramm = getString(a.i.remittance_detail_sender_tips_payu, new Object[] { Integer.valueOf(this.nDg) });
          localObject1 = getString(a.i.remittance_resend_transfer_msg);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.mRJ = new PayURemittanceDetailUI.1(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
          this.lUL.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.nCV.setImageResource(a.e.wallet_subject_receiving);
          this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(this.mPs) }));
          this.nCZ.setVisibility(0);
          this.nDa.setVisibility(8);
          bool1 = true;
          break;
          this.nCV.setImageResource(a.e.wallet_subject_receiving);
          this.nCY.setVisibility(0);
          this.nCY.setOnClickListener(new PayURemittanceDetailUI.2(this));
          paramm = getString(a.i.remittance_detail_reveiver_tips_payu, new Object[] { Integer.valueOf(this.nDg) });
          localObject1 = getString(a.i.remittance_detail_refuse_action);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.mRJ = new PayURemittanceDetailUI.3(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
          this.lUL.setText((CharSequence)localObject2);
        }
        this.nCV.setImageResource(a.h.remittance_received);
        if (bool2)
        {
          this.nCW.setText(a.i.remittance_detail_result_collected);
          paramm = getString(a.i.remittance_detail_check_ballance);
          localObject1 = new SpannableString(paramm);
          localObject2 = new a(this);
          ((a)localObject2).mRJ = new PayURemittanceDetailUI.4(this);
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramm.length(), 33);
          this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
          this.lUL.setText((CharSequence)localObject1);
          this.lUL.setVisibility(0);
        }
        for (;;)
        {
          this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(this.qOH) }));
          this.nCZ.setVisibility(0);
          this.nDa.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(this.mPr) }));
          this.nDa.setVisibility(0);
          bool1 = true;
          break;
          paramm = aT(this.nEi, true) + " " + getString(a.i.remittance_detail_result_collected);
          this.nCW.setText(j.a(this, paramm, this.nCW.getTextSize()));
          this.lUL.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool2))
        {
          this.nCV.setImageResource(a.h.remittance_timed_out);
          this.nCW.setText(a.i.remittance_detail_result_timeout_refunded);
          label1243:
          if (bool2) {
            break label1532;
          }
          paramm = getString(a.i.remittance_detail_refund_to_ballance);
          localObject1 = getString(a.i.remittance_detail_check_ballance);
          localObject2 = new SpannableString(paramm + (String)localObject1);
          locala = new a(this);
          locala.mRJ = new PayURemittanceDetailUI.5(this);
          ((SpannableString)localObject2).setSpan(locala, paramm.length(), paramm.length() + ((String)localObject1).length(), 33);
          this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
          this.lUL.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.lUL.setVisibility(0);
          this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(this.qOH) }));
          this.nCZ.setVisibility(0);
          this.nDa.setText(getString(a.i.remittance_detail_refund_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(this.mPs) }));
          this.nDa.setVisibility(0);
          bool1 = true;
          break;
          this.nCV.setImageResource(a.h.remittance_refunded);
          if (bool2)
          {
            this.nCW.setText(a.i.remittance_detail_result_refunded);
            break label1243;
          }
          paramm = aT(this.nEi, true) + getString(a.i.remittance_detail_result_refunded);
          this.nCW.setText(j.a(this, paramm, this.nCW.getTextSize()));
          break label1243;
          label1532:
          this.lUL.setText("");
        }
      }
      h.bC(this.mController.uMN, getString(a.i.remittance_detail_msg_collect_suc));
      return bool1;
    }
    if (((paramm instanceof c)) || ((paramm instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramm instanceof c)) {
          wF(1);
        }
        for (;;)
        {
          return true;
          aB(0, getString(a.i.remittance_detail_msg_refuse_suc));
        }
      }
      aB(paramInt2, paramString);
      return true;
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nDi = getIntent().getIntExtra("total_fee", 0);
    this.qOE = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.qOF = q.Gj();
      this.nEi = this.nDe;
      return;
    }
    this.qOF = this.nDe;
    this.nEi = q.Gj();
  }
  
  protected final void wE(int paramInt)
  {
    a(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.nAx, this.nDe, this.nDb), true, false);
  }
  
  protected final void wF(int paramInt)
  {
    a(new com.tencent.mm.plugin.wallet_payu.remittance.a.e(this.nAx, this.nDe, this.nDb, paramInt), true, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.remittance.ui.PayURemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */