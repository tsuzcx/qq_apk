package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.nl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.c.a.a;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI
  extends WalletBaseUI
{
  public TextView lUL = null;
  private String mPo;
  private String mPv;
  private String nAq = null;
  private int nAr;
  public String nAx = null;
  public ImageView nCV = null;
  public TextView nCW = null;
  public TextView nCX = null;
  public Button nCY = null;
  public TextView nCZ = null;
  public TextView nDa = null;
  public int nDb;
  public int nDc;
  public String nDd = null;
  public String nDe = null;
  protected String nDf = null;
  public int nDg = 3;
  protected boolean nDh = false;
  protected int nDi;
  private int nDj;
  private u nDk;
  private c<nl> nDl = new RemittanceDetailUI.1(this);
  
  private void a(u paramu)
  {
    if ("confirm".equals(paramu.nyy))
    {
      wE(1);
      return;
    }
    aB(0, getResources().getString(a.i.remittance_detail_msg_refuse_suc));
  }
  
  public static String aT(String paramString, boolean paramBoolean)
  {
    String str = com.tencent.mm.wallet_core.ui.e.gV(paramString);
    if (str == null) {
      paramString = "";
    }
    do
    {
      do
      {
        return paramString;
        paramString = str;
      } while (str.length() <= 10);
      paramString = str;
    } while (!paramBoolean);
    return str.substring(0, 8) + "...";
  }
  
  private void bws()
  {
    if ((this.nDj != 0) && (this.nAr == 1) && (!bk.bl(this.nAq)))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new RemittanceDetailUI.9(this));
      return;
    }
    y.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[] { Integer.valueOf(this.nDj), Boolean.valueOf(bk.bl(this.nAq)) });
    this.mController.removeAllOptionMenu();
  }
  
  public void T(Intent paramIntent)
  {
    d.b(this, "remittance", ".ui.RemittanceResendMsgUI", paramIntent);
  }
  
  public final void aB(int paramInt, String paramString)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("result_msg", paramString);
    setResult(paramInt, localIntent);
    finish();
  }
  
  public void bwG()
  {
    u localu = new u(this.nDd, this.nAx, this.nDi, "confirm", this.nDe, this.nDb);
    localu.dIA = "RemittanceProcess";
    a(localu, true, true);
  }
  
  public void bwH()
  {
    u localu = new u(this.nDd, this.nAx, this.nDi, "refuse", this.nDe, this.nDb);
    localu.dIA = "RemittanceProcess";
    a(localu, true, true);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof x))
    {
      final x localx = (x)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        boolean bool;
        Object localObject;
        if (localx != null)
        {
          if (localx.llS)
          {
            this.mPv = q.Gj();
            this.mPo = this.nDe;
            bool = q.Gj().equals(this.mPo);
            this.nCY.setVisibility(8);
            this.nCX.setText(com.tencent.mm.wallet_core.ui.e.d(localx.iHP, localx.mOZ));
            paramm = localx.nzv;
            paramString = paramm;
            if (!bk.bl(paramm))
            {
              paramString = paramm;
              if (paramm.contains("%s")) {
                paramString = paramm.trim().replace("%s", aT(this.mPo, true));
              }
            }
            paramm = localx.nzw;
            localObject = new Bundle();
            ((Bundle)localObject).putString("transaction_id", this.nDd);
            ((Bundle)localObject).putString("receiver_name", this.mPo);
            ((Bundle)localObject).putString("transfer_id", this.nAx);
            ((Bundle)localObject).putInt("total_fee", this.nDi);
            ((Bundle)localObject).putString("sender_name", this.nDe);
            ((Bundle)localObject).putInt("invalid_time", this.nDb);
            this.lUL.setClickable(true);
            this.nCW.setClickable(true);
            paramInt1 = localx.status;
            y.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[] { Integer.valueOf(paramInt1) });
          }
        }
        else {
          switch (paramInt1)
          {
          default: 
            finish();
            label316:
            if (!bk.bl(localx.nzy)) {
              com.tencent.mm.wallet_core.ui.e.a((TextView)findViewById(a.f.banner_tips), "7", localx.nzy, localx.nzz);
            }
            this.nDj = localx.nzx;
            g.DQ();
            this.nAq = ((String)g.DP().Dz().get(ac.a.uuA, ""));
            g.DQ();
            this.nAr = ((Integer)g.DP().Dz().get(ac.a.uuB, Integer.valueOf(0))).intValue();
            if (bk.bl(this.nAq))
            {
              ae.a(true, this.wCh);
              label436:
              bws();
              if (localx.mPH == 1)
              {
                g.DQ();
                if (!((String)g.DP().Dz().get(327729, "0")).equals("0")) {
                  break label3103;
                }
                paramString = this.mController.uMN;
                if (!q.Gw()) {
                  break label3096;
                }
                paramInt1 = a.i.chatting_item_appmsg_remittance_collect_tips_payu;
                label498:
                com.tencent.mm.ui.base.h.a(paramString, paramInt1, a.i.wallet_remittance_collect_title, new DialogInterface.OnClickListener()
                {
                  public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
                  {
                    com.tencent.mm.ui.base.h.bC(RemittanceDetailUI.this.mController.uMN, RemittanceDetailUI.this.getString(a.i.remittance_detail_msg_collect_suc));
                  }
                });
                g.DQ();
                g.DP().Dz().o(327729, "1");
              }
            }
            break;
          }
        }
        for (;;)
        {
          return true;
          this.mPv = this.nDe;
          this.mPo = q.Gj();
          break;
          if (!bool) {
            if ((!bk.bl(paramString)) && (!bk.bl(paramm)))
            {
              this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
              this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
              this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
          }
          com.tencent.mm.plugin.order.c.a locala;
          for (;;)
          {
            this.nCV.setImageResource(a.h.remittance_wait);
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzr) }));
            this.nCZ.setVisibility(0);
            this.nDa.setVisibility(8);
            break;
            paramString = getString(a.i.remittance_detail_result_wait_sender, new Object[] { aT(this.mPo, true) });
            this.nCW.setText(j.a(this, paramString, this.nCW.getTextSize()));
            paramString = getString(a.i.remittance_detail_sender_tips, new Object[] { Integer.valueOf(this.nDg) });
            paramm = getString(a.i.remittance_resend_transfer_msg);
            localObject = new SpannableString(paramString + paramm);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.mRJ = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                com.tencent.mm.ui.base.h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.remittance_confirm_resend_msg), RemittanceDetailUI.this.getString(a.i.app_remind), RemittanceDetailUI.this.getString(a.i.remittance_resend), RemittanceDetailUI.this.getString(a.i.app_cancel), new RemittanceDetailUI.3.1(this), new RemittanceDetailUI.3.2(this));
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramm.length(), 33);
            this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
            this.lUL.setText((CharSequence)localObject);
            continue;
            this.nCV.setImageResource(a.h.remittance_wait);
            this.nCY.setVisibility(0);
            this.nCY.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                com.tencent.mm.plugin.wallet_core.model.o.bVn();
                paramAnonymousView = RemittanceDetailUI.this;
                com.tencent.mm.wallet_core.d.i locali = RemittanceDetailUI.c(RemittanceDetailUI.this);
                new RemittanceDetailUI.4.1(this);
                if (!com.tencent.mm.plugin.wallet_core.model.o.a(paramAnonymousView, locali)) {
                  RemittanceDetailUI.this.bwG();
                }
              }
            });
            if ((bk.bl(paramString)) || (bk.bl(paramm))) {
              break label999;
            }
            this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
            this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
            this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
          }
          label999:
          this.nCW.setText(a.i.remittance_detail_result_wait_receiver);
          if (localx.nzx != 0) {
            if (!bk.bl(localx.nzw)) {
              paramString = localx.nzw;
            }
          }
          for (;;)
          {
            paramm = getString(a.i.remittance_detail_refuse_action);
            localObject = new SpannableString(paramString + paramm);
            locala = new com.tencent.mm.plugin.order.c.a(this);
            locala.mRJ = new a.a()
            {
              public final void onClick(View paramAnonymousView)
              {
                com.tencent.mm.ui.base.h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(a.i.remittance_detail_refund_tips, new Object[] { RemittanceDetailUI.aT(localx.nzt, false) }), RemittanceDetailUI.this.getString(a.i.app_remind), RemittanceDetailUI.this.getString(a.i.remittance_detail_refuse_btn_text), RemittanceDetailUI.this.getString(a.i.app_cancel), new RemittanceDetailUI.5.1(this), new RemittanceDetailUI.5.2(this));
              }
            };
            ((SpannableString)localObject).setSpan(locala, paramString.length(), paramString.length() + paramm.length(), 33);
            this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
            this.lUL.setText((CharSequence)localObject);
            break;
            y.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
            if (localx.nzx == 1) {}
            for (paramString = "24";; paramString = "2")
            {
              paramString = getString(a.i.remittance_detail_reveiver_tips1, new Object[] { paramString });
              paramm = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.nDg) });
              paramString = paramString + paramm;
              break;
            }
            paramString = getString(a.i.remittance_detail_reveiver_tips2, new Object[] { Integer.valueOf(this.nDg) });
          }
          this.nCV.setImageResource(a.h.remittance_received);
          if ((!bk.bl(paramString)) && (!bk.bl(paramm)))
          {
            this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
            this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
            this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
          }
          for (;;)
          {
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzr) }));
            this.nCZ.setVisibility(0);
            this.nDa.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzu) }));
            this.nDa.setVisibility(0);
            break;
            if (bool)
            {
              this.nCW.setText(a.i.remittance_detail_result_collected);
              paramString = new SpannableStringBuilder(getString(a.i.remittance_detail_check_ballance));
              paramm = new com.tencent.mm.plugin.order.c.a(this);
              paramm.mRJ = new a.a()
              {
                public final void onClick(View paramAnonymousView)
                {
                  com.tencent.mm.pluginsdk.wallet.h.Z(RemittanceDetailUI.this, 0);
                }
              };
              paramString.setSpan(paramm, 0, paramString.length(), 18);
              this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
              this.lUL.setText(paramString);
              this.lUL.setVisibility(0);
            }
            else
            {
              paramString = aT(this.mPo, true) + getString(a.i.remittance_detail_result_collected);
              this.nCW.setText(j.a(this, paramString, this.nCW.getTextSize()));
              this.lUL.setText(a.i.remittance_detail_sender_success_tips);
              this.lUL.setVisibility(0);
            }
          }
          if ((paramInt1 == 2003) && (!bool))
          {
            this.nCV.setImageResource(a.h.remittance_timed_out);
            if (!bk.bl(paramString))
            {
              this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
              this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              label1663:
              if (bool) {
                break label2145;
              }
              if (bk.bl(paramm)) {
                break label1939;
              }
              this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
              this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              label1713:
              this.lUL.setVisibility(0);
            }
          }
          for (;;)
          {
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzr) }));
            this.nCZ.setVisibility(0);
            this.nDa.setText(getString(a.i.remittance_detail_refund_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzu) }));
            this.nDa.setVisibility(0);
            break;
            this.nCW.setText(a.i.remittance_detail_result_timeout_refunded);
            break label1663;
            this.nCV.setImageResource(a.h.remittance_refunded);
            if (!bk.bl(paramString))
            {
              this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
              this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              break label1663;
            }
            if (bool)
            {
              this.nCW.setText(a.i.remittance_detail_result_refunded);
              break label1663;
            }
            paramString = aT(this.mPo, true) + getString(a.i.remittance_detail_result_refunded);
            this.nCW.setText(j.a(this, paramString, this.nCW.getTextSize()));
            break label1663;
            label1939:
            if (("CFT".equals(localx.mPx)) || ("LQT".equals(localx.mPx)))
            {
              bool = "LQT".equals(localx.mPx);
              if (bool)
              {
                paramString = getString(a.i.remittance_detail_refund_to_lqt);
                label1993:
                if (!bool) {
                  break label2120;
                }
              }
              label2120:
              for (paramm = getString(a.i.remittance_detail_check_lqt);; paramm = getString(a.i.remittance_detail_check_ballance))
              {
                localObject = new SpannableString(paramString + paramm);
                locala = new com.tencent.mm.plugin.order.c.a(this);
                locala.mRJ = new RemittanceDetailUI.7(this, bool);
                paramInt1 = paramString.length();
                paramInt2 = paramString.length();
                ((SpannableString)localObject).setSpan(locala, paramInt1, paramm.length() + paramInt2, 33);
                this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
                this.lUL.setText((CharSequence)localObject);
                break;
                paramString = getString(a.i.remittance_detail_refund_to_ballance);
                break label1993;
              }
            }
            this.lUL.setText(a.i.remittance_detail_refund_to_bankcard);
            break label1713;
            label2145:
            this.lUL.setVisibility(8);
          }
          if (bool)
          {
            this.nCV.setImageResource(a.h.remittance_wait);
            if ((!bk.bl(paramString)) && (!bk.bl(paramm)))
            {
              this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
              this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
              this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
          }
          for (;;)
          {
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzr) }));
            this.nCZ.setVisibility(0);
            this.nDa.setText(getString(a.i.remittance_detail_receive_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzu) }));
            this.nDa.setVisibility(0);
            break;
            if (!bk.bl(localx.nzv)) {
              this.nCW.setText(localx.nzv);
            }
            for (;;)
            {
              if (bk.bl(localx.nzw)) {
                break label2399;
              }
              this.lUL.setText(localx.nzw);
              break;
              this.nCW.setText(a.i.remittance_detail_result_receiver_waited);
            }
            label2399:
            this.lUL.setText(a.i.remittance_detail_receiver_wait_tips);
            continue;
            this.nCV.setImageResource(a.h.remittance_wait);
            if ((!bk.bl(paramString)) && (!bk.bl(paramm)))
            {
              this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
              this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
              this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
              this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            }
            else
            {
              if (!bk.bl(localx.nzv)) {}
              for (;;)
              {
                try
                {
                  this.nCW.setText(String.format(localx.nzv, new Object[] { aT(this.mPo, true) }));
                  if (bk.bl(localx.nzw)) {
                    break label2625;
                  }
                  this.lUL.setText(localx.nzw);
                }
                catch (Exception paramString)
                {
                  y.printErrStackTrace("MicroMsg.RemittanceDetailUI", paramString, "", new Object[0]);
                }
                this.nCW.setText(getString(a.i.remittance_detail_result_sender_waited, new Object[] { aT(this.mPo, true) }));
              }
              label2625:
              this.lUL.setText("");
            }
          }
          this.nCV.setImageResource(a.h.remittance_cancle);
          if ((!bk.bl(paramString)) && (!bk.bl(paramm)))
          {
            this.nCW.setText(j.a(this, paramString, (int)this.nCW.getTextSize(), localObject));
            this.lUL.setText(j.a(this, paramm, (int)this.lUL.getTextSize(), localObject));
            this.nCW.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
            this.lUL.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
          }
          for (;;)
          {
            this.nCZ.setText(getString(a.i.remittance_detail_transfer_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzr) }));
            this.nCZ.setVisibility(0);
            if (localx.nzu <= 0) {
              break label3072;
            }
            this.nDa.setText(getString(a.i.remittance_detail_cancel_time, new Object[] { com.tencent.mm.wallet_core.ui.e.hP(localx.nzu) }));
            this.nDa.setVisibility(0);
            break;
            if (!bk.bl(localx.nzv))
            {
              this.nCW.setText(localx.nzv);
              label2843:
              if (bk.bl(localx.nzw)) {
                break label3041;
              }
              if ((!"CFT".equals(localx.mPx)) && (!"LQT".equals(localx.mPx))) {
                break label3026;
              }
              bool = "LQT".equals(localx.mPx);
              paramm = localx.nzw;
              if (!bool) {
                break label3015;
              }
            }
            label3015:
            for (paramString = getString(a.i.remittance_detail_check_lqt);; paramString = getString(a.i.remittance_detail_check_ballance))
            {
              localObject = new SpannableStringBuilder();
              ((SpannableStringBuilder)localObject).append(paramm);
              ((SpannableStringBuilder)localObject).append(paramString);
              paramString = new com.tencent.mm.plugin.order.c.a(this);
              paramString.mRJ = new RemittanceDetailUI.8(this, bool);
              ((SpannableStringBuilder)localObject).setSpan(paramString, paramm.length(), ((SpannableStringBuilder)localObject).length(), 18);
              this.lUL.setMovementMethod(LinkMovementMethod.getInstance());
              this.lUL.setText((CharSequence)localObject);
              break;
              this.nCW.setText(a.i.remittance_detail_result_canceled);
              break label2843;
            }
            label3026:
            this.lUL.setText(localx.nzw);
            continue;
            label3041:
            if (bool) {
              this.lUL.setText(a.i.remittance_detail_receiver_cancel_tips);
            } else {
              this.lUL.setText(a.i.remittance_detail_sender_cancel_tips);
            }
          }
          label3072:
          this.nDa.setVisibility(8);
          break label316;
          ae.a(false, this.wCh);
          break label436;
          label3096:
          paramInt1 = a.i.wallet_remittance_collect_tips;
          break label498;
          label3103:
          if (this.nDj == 0) {
            com.tencent.mm.ui.base.h.bC(this.mController.uMN, getString(a.i.remittance_detail_msg_collect_suc));
          }
        }
      }
    }
    else
    {
      if ((paramm instanceof u))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.nDk = ((u)paramm);
          if ((this.nDk.cMv()) && (this.nDk.lQQ.a(this, new RemittanceDetailUI.2(this)))) {
            return true;
          }
          a(this.nDk);
          return true;
        }
        if (paramInt2 == 416)
        {
          paramString = new Bundle();
          paramString.putString("realname_verify_process_jump_plugin", "remittance");
          paramString.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
          return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, paramInt2, paramm, paramString, 1008);
        }
        aB(paramInt2, paramString);
        return true;
      }
      if ((paramm instanceof ae))
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          this.nAq = ((ae)paramm).qrl;
          this.nAr = ((ae)paramm).qrm;
          bws();
        }
        for (;;)
        {
          return true;
          y.i("MicroMsg.RemittanceDetailUI", "net error");
        }
      }
    }
    return (paramm instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e);
  }
  
  public void finish()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("realname_verify_process_jump_plugin", "remittance");
    localBundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
    if ((this.nDk != null) && (com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, this.nDk, localBundle, true, 1008)))
    {
      this.nDk = null;
      return;
    }
    super.finish();
  }
  
  protected final int getLayoutId()
  {
    return a.g.remittance_detail_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.remittance_result_title);
    this.nCV = ((ImageView)findViewById(a.f.remittance_detail_desc_icon));
    this.nCW = ((TextView)findViewById(a.f.remittance_detail_result_desc));
    this.nCX = ((TextView)findViewById(a.f.remittance_detail_fee));
    this.nCY = ((Button)findViewById(a.f.remittance_detail_collect_btn));
    this.lUL = ((TextView)findViewById(a.f.remittance_detail_main_desc));
    this.nCZ = ((TextView)findViewById(a.f.remittance_detail_time_desc_one));
    this.nDa = ((TextView)findViewById(a.f.remittance_detail_time_desc_two));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.nDb = getIntent().getIntExtra("invalid_time", 0);
    this.nDc = getIntent().getIntExtra("appmsg_type", 0);
    this.nDd = getIntent().getStringExtra("transaction_id");
    this.nDf = getIntent().getStringExtra("bill_id");
    this.nAx = getIntent().getStringExtra("transfer_id");
    this.nDe = getIntent().getStringExtra("sender_name");
    this.nDg = getIntent().getIntExtra("effective_date", 3);
    this.nDh = getIntent().getBooleanExtra("is_sender", false);
    this.nDi = getIntent().getIntExtra("total_fee", 0);
    initView();
    wE(0);
    getIntent();
    com.tencent.mm.sdk.b.a.udP.c(this.nDl);
  }
  
  public void onDestroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.nDl);
    super.onDestroy();
  }
  
  public void wE(int paramInt)
  {
    a(new x(paramInt, this.nDd, this.nAx, this.nDb), true, false);
  }
  
  public void wF(int paramInt)
  {
    if (!getIntent().getBooleanExtra("is_sender", false)) {}
    for (com.tencent.mm.plugin.order.model.h localh = new com.tencent.mm.plugin.order.model.h(this.nAx, this.nDf, paramInt);; localh = new com.tencent.mm.plugin.order.model.h(this.nDd, this.nDf, paramInt))
    {
      localh.dIA = "RemittanceProcess";
      a(localh, true, true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI
 * JD-Core Version:    0.7.0.1
 */