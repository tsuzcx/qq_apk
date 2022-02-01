package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.e;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.storage.ao;
import com.tencent.mm.wallet_core.ui.g;

public class PayURemittanceDetailUI
  extends RemittanceDetailUI
{
  private int GHQ;
  private int GHR;
  private int Ito;
  private String Pnj;
  private String Pnk;
  private int Pnl;
  private String mReceiverName;
  private int wZT;
  
  public final void aP(Intent paramIntent)
  {
    AppMethodBeat.i(72197);
    com.tencent.mm.by.c.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", paramIntent);
    AppMethodBeat.o(72197);
  }
  
  public final void acV(int paramInt)
  {
    AppMethodBeat.i(72195);
    doSceneProgress(new e(this.IoU, this.Itk, this.Ith), true);
    AppMethodBeat.o(72195);
  }
  
  public final void acW(int paramInt)
  {
    AppMethodBeat.i(72196);
    doSceneProgress(new e(this.IoU, this.Itk, this.Ith, paramInt), true);
    AppMethodBeat.o(72196);
  }
  
  public final void fAV()
  {
    AppMethodBeat.i(72198);
    doSceneProgress(new com.tencent.mm.plugin.wallet_payu.remittance.a.c(this.IoU, this.Ito, this.Pnj, this.Itk));
    AppMethodBeat.o(72198);
  }
  
  public final void fAW()
  {
    AppMethodBeat.i(72199);
    doSceneProgress(new b(this.IoU, this.Ito, this.Pnj, this.Itk));
    AppMethodBeat.o(72199);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72194);
    super.onCreate(paramBundle);
    this.Ito = getIntent().getIntExtra("total_fee", 0);
    this.Pnj = getIntent().getStringExtra("fee_type");
    if (getIntent().getBooleanExtra("is_sender", false))
    {
      this.Pnk = z.bcZ();
      this.mReceiverName = this.Itk;
      AppMethodBeat.o(72194);
      return;
    }
    this.Pnk = this.Itk;
    this.mReceiverName = z.bcZ();
    AppMethodBeat.o(72194);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    boolean bool2 = false;
    AppMethodBeat.i(72200);
    if ((paramq instanceof e))
    {
      paramString = (e)paramq;
      Object localObject1;
      Object localObject2;
      a locala;
      if (paramString.fCN == 0)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          if ((this.Iti == 1) && (!getIntent().getBooleanExtra("is_sender", false)))
          {
            this.IjU.setImageResource(a.e.wallet_subject_receiving);
            this.Isu.setText(a.i.remittance_detail_result_wait_receiver);
            this.Isv.setText(g.d(paramString.tVK, paramString.GHz));
            paramq = getString(a.i.remittance_detail_reveiver_tips_payu, new Object[] { Integer.valueOf(this.Itm) });
            localObject1 = getString(a.i.remittance_detail_refuse_action);
            localObject2 = new SpannableString(paramq + (String)localObject1);
            locala = new a(this);
            locala.GKe = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(72189);
                com.tencent.mm.ui.base.h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(a.i.remittance_detail_refund_tips, new Object[] { PayURemittanceDetailUI.b(PayURemittanceDetailUI.this, PayURemittanceDetailUI.f(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(a.i.app_remind), PayURemittanceDetailUI.this.getString(a.i.remittance_detail_refuse_btn_text), PayURemittanceDetailUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                  {
                    AppMethodBeat.i(268173);
                    PayURemittanceDetailUI.this.fAW();
                    AppMethodBeat.o(268173);
                  }
                }, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
                });
                AppMethodBeat.o(72189);
              }
            };
            ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
            this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
            this.Isy.setText((CharSequence)localObject2);
            this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { g.uW(paramString.Ing) }));
            this.Isw.setVisibility(0);
            this.Isx.setVisibility(8);
          }
          AppMethodBeat.o(72200);
          return true;
        }
        acW(0);
        AppMethodBeat.o(72200);
        return true;
      }
      boolean bool1 = bool2;
      if (paramInt1 == 0)
      {
        bool1 = bool2;
        if (paramInt2 == 0)
        {
          this.Pnl = paramString.status;
          this.wZT = paramString.Ing;
          this.GHR = paramString.Pnf;
          this.GHQ = paramString.Png;
          this.Ito = ((int)(paramString.tVK * 100.0D));
          this.Pnj = paramString.GHz;
          paramq = z.bcZ();
          bool1 = this.mReceiverName.equals(paramq);
          this.Isv.setText(g.d(this.Ito / 100.0D, this.Pnj));
          this.IsB.setVisibility(0);
          this.IsX.setVisibility(8);
          paramInt1 = this.Pnl;
        }
      }
      switch (paramInt1)
      {
      default: 
        finish();
        bool1 = true;
        if (paramString.cUP == 1)
        {
          com.tencent.mm.kernel.h.aHH();
          if (!((String)com.tencent.mm.kernel.h.aHG().aHp().b(327729, "0")).equals("0")) {
            break label1518;
          }
          com.tencent.mm.ui.base.h.a(getContext(), a.i.chatting_item_appmsg_remittance_collect_tips_payu, a.i.wallet_remittance_collect_tips, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(266323);
              com.tencent.mm.ui.base.h.cO(PayURemittanceDetailUI.this.getContext(), PayURemittanceDetailUI.this.getString(a.i.remittance_detail_msg_collect_suc));
              AppMethodBeat.o(266323);
            }
          });
          com.tencent.mm.kernel.h.aHH();
          com.tencent.mm.kernel.h.aHG().aHp().i(327729, "1");
        }
        break;
      }
      for (;;)
      {
        AppMethodBeat.o(72200);
        return bool1;
        if (!bool1)
        {
          paramq = getString(a.i.remittance_detail_result_wait_sender, new Object[] { cj(this.mReceiverName, true) });
          this.Isu.setText(l.b(this, paramq, this.Isu.getTextSize()));
          paramq = getString(a.i.remittance_detail_sender_tips_payu, new Object[] { Integer.valueOf(this.Itm) });
          localObject1 = getString(a.i.remittance_resend_transfer_msg);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.GKe = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72184);
              com.tencent.mm.ui.base.h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(a.i.remittance_confirm_resend_msg), PayURemittanceDetailUI.this.getString(a.i.app_remind), PayURemittanceDetailUI.this.getString(a.i.remittance_resend), PayURemittanceDetailUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(72183);
                  paramAnonymous2DialogInterface = new Intent();
                  paramAnonymous2DialogInterface.putExtra("transaction_id", PayURemittanceDetailUI.a(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("receiver_name", PayURemittanceDetailUI.b(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("total_fee", PayURemittanceDetailUI.c(PayURemittanceDetailUI.this));
                  paramAnonymous2DialogInterface.putExtra("fee_type", PayURemittanceDetailUI.d(PayURemittanceDetailUI.this));
                  PayURemittanceDetailUI.this.aP(paramAnonymous2DialogInterface);
                  AppMethodBeat.o(72183);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72184);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
          this.Isy.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.IjU.setImageResource(a.e.wallet_subject_receiving);
          this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { g.uW(this.GHR) }));
          this.Isw.setVisibility(0);
          this.Isx.setVisibility(8);
          bool1 = true;
          break;
          this.IjU.setImageResource(a.e.wallet_subject_receiving);
          paramq = getString(a.i.remittance_detail_reveiver_tips_payu, new Object[] { Integer.valueOf(this.Itm) });
          localObject1 = getString(a.i.remittance_detail_refuse_action);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.GKe = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72185);
              com.tencent.mm.ui.base.h.c(PayURemittanceDetailUI.this, PayURemittanceDetailUI.this.getString(a.i.remittance_detail_refund_tips, new Object[] { PayURemittanceDetailUI.a(PayURemittanceDetailUI.this, PayURemittanceDetailUI.e(PayURemittanceDetailUI.this)) }), PayURemittanceDetailUI.this.getString(a.i.app_remind), PayURemittanceDetailUI.this.getString(a.i.remittance_detail_refuse_btn_text), PayURemittanceDetailUI.this.getString(a.i.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(217070);
                  PayURemittanceDetailUI.this.fAW();
                  AppMethodBeat.o(217070);
                }
              }, new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
              });
              AppMethodBeat.o(72185);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
          this.Isy.setText((CharSequence)localObject2);
        }
        this.IjU.setImageResource(a.h.remittance_received);
        if (bool1)
        {
          this.Isu.setText(a.i.remittance_detail_result_collected);
          paramq = getString(a.i.remittance_detail_check_ballance);
          localObject1 = new SpannableString(paramq);
          localObject2 = new a(this);
          ((a)localObject2).GKe = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72187);
              com.tencent.mm.pluginsdk.wallet.f.aX(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72187);
            }
          };
          ((SpannableString)localObject1).setSpan(localObject2, 0, paramq.length(), 33);
          this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
          this.Isy.setText((CharSequence)localObject1);
          this.Isy.setVisibility(0);
        }
        for (;;)
        {
          this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { g.uW(this.wZT) }));
          this.Isw.setVisibility(0);
          this.Isx.setText(getString(a.i.remittance_detail_receive_time, new Object[] { g.uW(this.GHQ) }));
          this.Isx.setVisibility(0);
          bool1 = true;
          break;
          paramq = cj(this.mReceiverName, true) + " " + getString(a.i.remittance_detail_result_collected);
          this.Isu.setText(l.b(this, paramq, this.Isu.getTextSize()));
          this.Isy.setVisibility(8);
        }
        if ((paramInt1 == 2003) && (!bool1))
        {
          this.IjU.setImageResource(a.h.remittance_timed_out);
          this.Isu.setText(a.i.remittance_detail_result_timeout_refunded);
          label1215:
          if (bool1) {
            break label1505;
          }
          paramq = getString(a.i.remittance_detail_refund_to_ballance);
          localObject1 = getString(a.i.remittance_detail_check_ballance);
          localObject2 = new SpannableString(paramq + (String)localObject1);
          locala = new a(this);
          locala.GKe = new a.a()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(72188);
              com.tencent.mm.pluginsdk.wallet.f.aX(PayURemittanceDetailUI.this, 0);
              AppMethodBeat.o(72188);
            }
          };
          ((SpannableString)localObject2).setSpan(locala, paramq.length(), paramq.length() + ((String)localObject1).length(), 33);
          this.Isy.setMovementMethod(LinkMovementMethod.getInstance());
          this.Isy.setText((CharSequence)localObject2);
        }
        for (;;)
        {
          this.Isy.setVisibility(0);
          this.Isw.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { g.uW(this.wZT) }));
          this.Isw.setVisibility(0);
          this.Isx.setText(getString(a.i.remittance_detail_refund_time, new Object[] { g.uW(this.GHR) }));
          this.Isx.setVisibility(0);
          bool1 = true;
          break;
          this.IjU.setImageResource(a.h.remittance_refunded);
          if (bool1)
          {
            this.Isu.setText(a.i.remittance_detail_result_refunded);
            break label1215;
          }
          paramq = cj(this.mReceiverName, true) + getString(a.i.remittance_detail_result_refunded);
          this.Isu.setText(l.b(this, paramq, this.Isu.getTextSize()));
          break label1215;
          label1505:
          this.Isy.setText("");
        }
        label1518:
        com.tencent.mm.ui.base.h.cO(getContext(), getString(a.i.remittance_detail_msg_collect_suc));
      }
    }
    if (((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c)) || ((paramq instanceof b)))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if ((paramq instanceof com.tencent.mm.plugin.wallet_payu.remittance.a.c)) {
          acW(1);
        }
        for (;;)
        {
          AppMethodBeat.o(72200);
          return true;
          bW(0, getString(a.i.remittance_detail_msg_refuse_suc));
        }
      }
      bW(paramInt2, paramString);
      AppMethodBeat.o(72200);
      return true;
    }
    AppMethodBeat.o(72200);
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