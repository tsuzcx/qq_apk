package com.tencent.mm.plugin.remittance.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.fu;
import com.tencent.mm.h.a.fu.a;
import com.tencent.mm.h.a.fv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.remittance.model.ac;
import com.tencent.mm.plugin.remittance.model.t;
import com.tencent.mm.plugin.remittance.model.v;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.c.pj;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.a.c.a;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(2)
public abstract class RemittanceBaseUI
  extends WalletBaseUI
  implements d.a
{
  protected String djD;
  protected String dkv;
  private final int eYf = com.tencent.mm.cb.a.fromDPToPix(com.tencent.mm.sdk.platformtools.ae.getContext(), 270);
  protected Button frP;
  protected int fzn;
  protected WalletFormView iKG;
  private int lTG;
  protected ScrollView lls;
  private boolean nAA = false;
  private boolean nAB = false;
  private boolean nAC = false;
  private boolean nAD = false;
  private pj nAE = null;
  private com.tencent.mm.sdk.b.c nAF = new RemittanceBaseUI.16(this);
  private com.tencent.mm.sdk.b.c<fv> nAG = new RemittanceBaseUI.18(this);
  protected ImageView nAa;
  protected TextView nAb;
  protected TextView nAc;
  protected TextView nAd;
  protected TextView nAe;
  protected TextView nAf;
  private TextView nAg;
  private TextView nAh;
  protected TextView nAi;
  private LinearLayout nAj;
  private LinearLayout nAk;
  protected String nAl;
  private String nAm;
  private String nAn;
  protected String nAo;
  protected String nAp = null;
  protected String nAq = null;
  protected int nAr;
  private int nAs;
  protected String nAt;
  protected String nAu;
  protected String nAv;
  private Map<String, a> nAw = new HashMap();
  private String nAx;
  protected boolean nAy = false;
  private boolean nAz = false;
  private double nyG;
  protected com.tencent.mm.plugin.wallet.a nzT = null;
  protected double nzU;
  protected String nzV;
  protected String nzW;
  protected String nzX;
  protected int nzY;
  protected String nzZ;
  
  private void a(v paramv, pj parampj)
  {
    this.nAz = true;
    b localb = new b(this);
    localb.nzK = new RemittanceBaseUI.11(this);
    localb.nza = parampj;
    Object localObject = View.inflate(localb.mContext, a.g.real_name_check_dialog, null);
    TextView localTextView = (TextView)((View)localObject).findViewById(a.f.last_name);
    EditText localEditText = (EditText)((View)localObject).findViewById(a.f.first_name);
    ((TextView)((View)localObject).findViewById(a.f.content)).setText(localb.nza.bQZ);
    localTextView.setText(parampj.mPk);
    parampj = new e.a(localb.mContext);
    parampj.aeF(localb.nza.title).ek((View)localObject);
    localObject = com.tencent.mm.ui.tools.a.c.d(localEditText);
    ((com.tencent.mm.ui.tools.a.c)localObject).huj = f.a.wcS;
    localObject = ((com.tencent.mm.ui.tools.a.c)localObject).fJ(1, 1);
    ((com.tencent.mm.ui.tools.a.c)localObject).wfM = false;
    ((com.tencent.mm.ui.tools.a.c)localObject).a(null);
    ai.l(new b.1(localb, localEditText), 200L);
    localObject = new com.tencent.mm.h.b.a.ab();
    ((com.tencent.mm.h.b.a.ab)localObject).ckv = paramv.amount;
    ((com.tencent.mm.h.b.a.ab)localObject).cku = paramv.username;
    ((com.tencent.mm.h.b.a.ab)localObject).ckp = 1L;
    ((com.tencent.mm.h.b.a.ab)localObject).QX();
    parampj.c(new b.2(localb, paramv, localEditText)).show();
  }
  
  private void a(boolean paramBoolean, Intent paramIntent)
  {
    if (paramBoolean)
    {
      if (this.nAy) {
        com.tencent.mm.plugin.report.service.h.nFQ.f(15386, new Object[] { Integer.valueOf(3), Integer.valueOf(1) });
      }
      paramIntent = paramIntent.getStringExtra("key_trans_id");
      if (bk.bl(this.nAx)) {
        this.nAx = paramIntent;
      }
      if ((this.nzY != 33) && (this.nzY != 32))
      {
        paramIntent = this.djD;
        if (!bk.bl(paramIntent))
        {
          Object localObject = ac.bwi();
          y.d("Micromsg.RemittanceLogic", "cur friendsListStr=" + (String)localObject);
          StringBuilder localStringBuilder = new StringBuilder();
          if (!bk.bl((String)localObject))
          {
            localObject = ((String)localObject).split(",");
            if (localObject != null)
            {
              int i = 0;
              int k;
              for (int j = 0; i < localObject.length; j = k)
              {
                k = j;
                if (!paramIntent.equals(localObject[i]))
                {
                  localStringBuilder.append(localObject[i]);
                  localStringBuilder.append(",");
                  k = j + 1;
                  if (k >= 4) {
                    break;
                  }
                }
                i += 1;
              }
            }
          }
          localStringBuilder.insert(0, ",");
          localStringBuilder.insert(0, paramIntent);
          localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
          y.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
          g.DQ();
          g.DP().Dz().o(327733, localStringBuilder.toString());
          g.DQ();
          g.DP().Dz().mC(true);
        }
      }
      if (this.nyG == 0.0D)
      {
        if (this.fzn != 1) {
          break label364;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(17), Integer.valueOf(1) });
      }
      for (;;)
      {
        finish();
        return;
        label364:
        com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(8), Integer.valueOf(1) });
      }
    }
    if (this.fzn == 1)
    {
      com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(16), Integer.valueOf(1) });
      return;
    }
    com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(7), Integer.valueOf(1) });
  }
  
  private boolean a(final v paramv)
  {
    boolean bool2 = false;
    boolean bool1;
    label174:
    double d;
    Object localObject;
    if (!this.nAA)
    {
      if (!bk.bl(paramv.nyA))
      {
        this.nAA = true;
        com.tencent.mm.ui.base.h.a(this, paramv.nyA, getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.app_cancel), new DialogInterface.OnClickListener()new RemittanceBaseUI.7
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramv)) {
              RemittanceBaseUI.this.a(paramv.bOT, RemittanceBaseUI.this.djD, RemittanceBaseUI.this.nAo, paramv);
            }
          }
        }, new RemittanceBaseUI.7(this));
        bool2 = true;
      }
    }
    else
    {
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.nAB)
        {
          if (paramv.nyz <= 0) {
            break label607;
          }
          this.nAB = true;
          com.tencent.mm.ui.base.h.a(this, getString(a.i.remittance_remind_desc, new Object[] { Integer.valueOf(paramv.nyz) }), getString(a.i.app_remind), getString(a.i.remittance_continue), getString(a.i.remittance_open_order_history_action), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              if (!RemittanceBaseUI.a(RemittanceBaseUI.this, paramv)) {
                RemittanceBaseUI.this.a(paramv.bOT, RemittanceBaseUI.this.djD, RemittanceBaseUI.this.nAo, paramv);
              }
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              com.tencent.mm.wallet_core.a.b(RemittanceBaseUI.this, "ShowOrdersInfoProcess", null);
            }
          });
          bool1 = true;
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!this.nAC)
        {
          if (!paramv.nyF) {
            break label613;
          }
          this.nAC = true;
          int i = this.fzn;
          d = paramv.nyJ / 100.0D;
          localObject = paramv.nyH;
          c.a(this, i, d, paramv.nyI / 100.0D, paramv.nyC / 100.0D, paramv.nyE, new RemittanceBaseUI.10(this, paramv));
          bool2 = true;
        }
      }
      label267:
      bool1 = bool2;
      if (!bool2)
      {
        bool1 = bool2;
        if (!this.nAD) {
          bool1 = b(paramv);
        }
      }
      bool2 = bool1;
      if (!bool1)
      {
        bool2 = bool1;
        if (!bk.bl(paramv.nyO))
        {
          bool2 = bool1;
          if (!bk.bl(paramv.nyP))
          {
            localObject = com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(this.djD), 10);
            if (bk.bl(this.nAo)) {
              break label619;
            }
            localObject = getString(a.i.remittance_collect_block, new Object[] { localObject, this.nAo });
          }
        }
      }
    }
    label607:
    label613:
    label619:
    for (;;)
    {
      String str1 = paramv.bOT;
      String str2 = paramv.nyP;
      String str3 = paramv.nyO;
      View localView = LayoutInflater.from(this).inflate(a.g.remittance_second_alert_ui, null);
      TextView localTextView1 = (TextView)localView.findViewById(a.f.rsau_title);
      TextView localTextView2 = (TextView)localView.findViewById(a.f.rsau_payee);
      TextView localTextView3 = (TextView)localView.findViewById(a.f.rsau_money);
      localTextView1.setText(str2);
      localTextView2.setText(j.a(this, (CharSequence)localObject, localTextView2.getTextSize()));
      d = bk.getDouble(str3, 0.0D);
      localTextView3.setText(String.format("%s%.2f", new Object[] { com.tencent.mm.wallet_core.c.ab.cML(), Double.valueOf(Double.valueOf(d).doubleValue() / 100.0D) }));
      localObject = new c.a(this);
      ((c.a)localObject).nW(false);
      ((c.a)localObject).Ip(a.i.remittance_second_alert_title);
      ((c.a)localObject).ei(localView);
      ((c.a)localObject).Is(a.i.remittance_continue);
      ((c.a)localObject).It(a.i.button_cancel);
      ((c.a)localObject).a(new RemittanceBaseUI.17(this, str1, paramv));
      ((c.a)localObject).aoP().show();
      bool2 = true;
      return bool2;
      bool2 = false;
      break;
      bool1 = false;
      break label174;
      bool2 = false;
      break label267;
    }
  }
  
  private boolean b(v paramv)
  {
    if ((paramv.bZo != null) && (paramv.bZo.bUO()))
    {
      this.nAD = true;
      com.tencent.mm.ui.base.h.a(this, paramv.bZo.bQZ, "", paramv.bZo.lRF, paramv.bZo.lRE, new RemittanceBaseUI.4(this, paramv), new RemittanceBaseUI.5(this));
      return true;
    }
    return false;
  }
  
  private void bws()
  {
    if ((bwx()) && (!bk.bl(this.nAq)) && (this.nAs != 0) && (this.nAr == 1))
    {
      addIconOptionMenu(0, a.e.wallet_qanda_icon, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          com.tencent.mm.wallet_core.ui.e.l(RemittanceBaseUI.this.mController.uMN, RemittanceBaseUI.this.nAq, false);
          return false;
        }
      });
      return;
    }
    this.mController.removeAllOptionMenu();
  }
  
  private void bwt()
  {
    if ((!bk.bl(this.nAp)) && (this.nAs != 0))
    {
      int i;
      if (this.nAs == 1) {
        i = 2;
      }
      try
      {
        for (;;)
        {
          this.nAd.setText(String.format(this.nAp, new Object[] { Integer.valueOf(i) }));
          this.nAd.setVisibility(0);
          return;
          i = 24;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.RemittanceBaseUI", localException, "", new Object[0]);
          this.nAd.setText(getString(a.i.remittance_hardcode_tips, new Object[] { Integer.valueOf(i) }));
        }
      }
    }
    this.nAd.setText("");
    this.nAd.setVisibility(8);
  }
  
  private void bww()
  {
    ai.d(new RemittanceBaseUI.23(this));
  }
  
  public abstract void a(String paramString1, String paramString2, String paramString3, fu paramfu);
  
  protected final void a(String paramString1, String paramString2, String paramString3, v paramv)
  {
    int i;
    if (((paramv.nyZ == 1) && (paramv.nza != null)) || ((paramv.nza != null) && (paramv.nza.sNe > 0)))
    {
      i = 1;
      if (i == 0) {
        break label247;
      }
      if (paramv.nza.sNe != 0) {
        break label82;
      }
      this.nAE = paramv.nza;
      a(paramv, paramv.nza);
    }
    label82:
    do
    {
      return;
      i = 0;
      break;
      if (paramv.nza.sNe == 1)
      {
        paramString1 = new com.tencent.mm.h.b.a.ab();
        paramString1.ckv = paramv.amount;
        paramString1.cku = paramv.username;
        paramString1.ckp = 4L;
        paramString1.QX();
        com.tencent.mm.ui.base.h.a(this, paramv.nza.bQZ, paramv.nza.title, getResources().getString(a.i.remittance_warn_re_input), getResources().getString(a.i.app_cancel), new RemittanceBaseUI.13(this, paramv), new RemittanceBaseUI.14(this, paramv));
        return;
      }
    } while (paramv.nza.sNe != 2);
    com.tencent.mm.ui.base.h.a(this, paramv.nza.bQZ, paramv.nza.title, getResources().getString(a.i.welcome_i_know), new RemittanceBaseUI.15(this));
    return;
    label247:
    Object localObject;
    if (this.nAz)
    {
      localObject = new com.tencent.mm.h.b.a.ab();
      ((com.tencent.mm.h.b.a.ab)localObject).ckv = paramv.amount;
      ((com.tencent.mm.h.b.a.ab)localObject).cku = paramv.username;
      ((com.tencent.mm.h.b.a.ab)localObject).ckp = 5L;
      ((com.tencent.mm.h.b.a.ab)localObject).QX();
    }
    this.nAz = false;
    if (this.nzY == 31)
    {
      localObject = this.nAn;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        y.e("MicroMsg.RemittanceBaseUI", "msgxml is null");
      }
    }
    else
    {
      localObject = new PayInfo();
      ((PayInfo)localObject).bMX = paramString1;
      ((PayInfo)localObject).bUV = this.nzY;
      if (this.lTG > 0) {
        ((PayInfo)localObject).bUR = this.lTG;
      }
      if ((this.fzn != 2) && (this.fzn != 5)) {
        break label1056;
      }
    }
    label1056:
    for (boolean bool = true;; bool = false)
    {
      paramString1 = new Bundle();
      paramString1.putString("extinfo_key_1", paramString2);
      paramString1.putString("extinfo_key_2", getIntent().getStringExtra("receiver_true_name"));
      paramString1.putString("extinfo_key_3", this.nAl);
      paramString1.putBoolean("extinfo_key_4", bool);
      paramString1.putString("extinfo_key_5", getIntent().getStringExtra("receiver_tips"));
      paramString1.putString("extinfo_key_6", getIntent().getStringExtra("payer_desc"));
      paramString1.putString("extinfo_key_7", this.dkv);
      paramString1.putString("extinfo_key_8", getIntent().getStringExtra("rcvr_new_desc"));
      paramString1.putString("extinfo_key_16", this.nAx);
      if (paramv != null) {
        paramString1.putString("extinfo_key_19", paramv.nyX);
      }
      if ((this.fzn == 1) && (paramv != null))
      {
        paramString1.putString("extinfo_key_11", paramv.nyL);
        paramString1.putInt("extinfo_key_12", paramv.nyR);
        paramString1.putString("extinfo_key_13", paramv.nyS);
        paramString1.putString("extinfo_key_14", paramv.nyT);
        paramString1.putString("extinfo_key_17", paramv.nyV);
        paramString1.putString("extinfo_key_18", paramv.nyW);
      }
      for (i = paramv.nyU;; i = 0)
      {
        if (paramv != null) {
          paramString1.putInt("extinfo_key_15", paramv.amount);
        }
        ((PayInfo)localObject).snX = paramString1;
        paramString1 = new Intent();
        y.i("MicroMsg.RemittanceBaseUI", "dynamic code flag: %s", new Object[] { Integer.valueOf(i) });
        if (i == 1)
        {
          paramString1.setClass(this, RemittanceF2fDynamicCodeUI.class);
          paramString1.putExtra("key_pay_info", (Parcelable)localObject);
          paramString1.putExtra("key_rcvr_open_id", this.nAt);
          paramString1.putExtra("key_mch_info", this.nzX);
          paramString1.putExtra("from_patch_ui", true);
          paramString1.putExtra("get_dynamic_code_sign", paramv.nyV);
          paramString1.putExtra("get_dynamic_code_extend", paramv.nyW);
          paramString1.putExtra("dynamic_code_spam_wording", paramv.nyY);
          paramString1.putExtra("show_paying_wording", paramv.nyX);
          paramString1.putExtra("key_transfer_qrcode_id", this.nzZ);
          com.tencent.mm.plugin.report.service.h.nFQ.f(15386, new Object[] { Integer.valueOf(2), Integer.valueOf(1) });
          this.nAF.cqo();
          startActivityForResult(paramString1, 5);
          return;
          localObject = URLDecoder.decode((String)localObject);
          y.i("MicroMsg.RemittanceBaseUI", "helios:" + (String)localObject);
          String str = (String)bn.s((String)localObject, "msg").get(".msg.appmsg.wcpayinfo.transferid");
          if (TextUtils.isEmpty(str))
          {
            y.e("MicroMsg.RemittanceBaseUI", "paymsgid count't be null in appmsg");
            break;
          }
          com.tencent.mm.plugin.remittance.model.ab localab = com.tencent.mm.plugin.remittance.a.b.bvS().bvV();
          if ((bk.bl(str)) || (bk.bl((String)localObject)))
          {
            y.e(com.tencent.mm.plugin.remittance.model.ab.TAG, "saveMsgContent param error");
            break;
          }
          localab.nzF.put(str, localObject);
          break;
        }
        com.tencent.mm.plugin.wallet.a.a(this.nzT, paramString1);
        if ((paramv.nyj != null) && (paramv.nyj.bMR.bMV != null))
        {
          com.tencent.mm.pluginsdk.wallet.h.a(paramv.nyj.bMR.bMV, false, "", (PayInfo)localObject, paramString3, paramString1, paramv.nyj.bMR.bMT);
          return;
        }
        com.tencent.mm.pluginsdk.wallet.h.a(this, false, "", (PayInfo)localObject, paramString3, paramString1, 1);
        return;
      }
    }
  }
  
  protected final boolean bwA()
  {
    return true;
  }
  
  public abstract void bwo();
  
  public void bwp()
  {
    t localt = new t(this.djD, this.nzZ);
    localt.dIA = "RemittanceProcess";
    a(localt, true, true);
  }
  
  public void bwq() {}
  
  public abstract void bwr();
  
  public abstract void bwu();
  
  protected final void bwv()
  {
    Object localObject1 = com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(this.djD), 10);
    Object localObject2 = localObject1;
    if (!bk.bl(this.nAo)) {
      localObject2 = getString(a.i.remittance_collect_block, new Object[] { localObject1, this.nAo });
    }
    if (this.fzn == 1)
    {
      localObject2 = getIntent().getStringExtra("receiver_tips");
      this.nAb.setTextColor(getResources().getColor(a.c.black));
      this.nAc.setVisibility(0);
      if (bk.bl(this.djD))
      {
        localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip_withdout_username, new Object[] { this.nAo });
        this.nAc.setText(j.a(this, (CharSequence)localObject1, this.nAc.getTextSize()));
        localObject1 = localObject2;
        label152:
        this.nAb.setText(j.a(this, (CharSequence)localObject1, this.nAb.getTextSize()));
        this.nAa.setImageResource(a.e.default_avatar);
        if (!g.DK()) {
          break label385;
        }
        localObject1 = o.Kh();
        if ((localObject1 == null) || (bk.bl(this.djD))) {
          break label385;
        }
        localObject1 = ((i)localObject1).kp(this.djD);
        if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.ag.h)localObject1).JY()))) {
          break label385;
        }
        long l = bk.UY();
        am.a.dVy.a(this.djD, "", new RemittanceBaseUI.22(this, l));
      }
    }
    label385:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        bww();
      }
      return;
      localObject1 = getString(a.i.remittance_collect_pay_wrords_nick_tip, new Object[] { com.tencent.mm.wallet_core.ui.e.dP(com.tencent.mm.wallet_core.ui.e.gV(this.djD), 10), this.nAo });
      break;
      localObject1 = localObject2;
      if (this.fzn != 6) {
        break label152;
      }
      localObject1 = getIntent().getStringExtra("receiver_tips");
      if (bk.bl((String)localObject1))
      {
        localObject1 = getString(a.i.remittance_collect_pay_wrords, new Object[] { localObject2 });
        break label152;
      }
      localObject1 = bk.q((String)localObject1, new Object[] { localObject2 });
      break label152;
    }
  }
  
  protected final boolean bwx()
  {
    return (this.fzn == 0) || (this.fzn == 2);
  }
  
  protected final void bwy()
  {
    if (this.nzY == 33)
    {
      a(this.dkv, this.nAl, "", null);
      return;
    }
    a(this.dkv, null, "", null);
  }
  
  protected void bwz()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("recent_remittance_contact_list", ac.bwi());
    localIntent.setClass(this.mController.uMN, SelectRemittanceContactUI.class);
    startActivityForResult(localIntent, 2);
  }
  
  public boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    this.nAv = "";
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof v))
      {
        paramm = (v)paramm;
        aa.l(this.nzY, paramm.bOT, paramInt2);
        this.nAn = paramm.nyB;
        if (!bk.bl(paramm.nyK)) {
          this.nAo = paramm.nyK;
        }
        if ((this.nzY == 32) || (this.nzY == 33))
        {
          this.nAx = paramm.iGK;
          if (this.nzT != null) {
            this.nzT.i(10000, new Object[] { Integer.valueOf(this.nzY), this.djD, Double.valueOf(paramm.nyN) });
          }
          if (paramm.nza != null) {
            break label280;
          }
          paramString = "";
          label160:
          this.nAu = paramString;
          if (!a(paramm)) {
            a(paramm.bOT, this.djD, this.nAo, paramm);
          }
          paramString = new a(paramm.nyL, paramm.iGK, paramm.iIB, paramm.nyM, paramm.amount, paramm.bQR, paramm.bMY, paramm.nyQ, bk.getLong(paramm.nyO, 0L));
          this.nAw.put(paramm.bOT, paramString);
        }
      }
      for (;;)
      {
        return true;
        this.nAx = paramm.bQR;
        break;
        label280:
        if (bk.bl(paramm.nza.nAu))
        {
          paramString = this.nAu;
          break label160;
        }
        paramString = paramm.nza.nAu;
        break label160;
        if ((paramm instanceof ad))
        {
          paramString = (ad)paramm;
          if (!bk.bl(paramString.qrf))
          {
            ((TextView)findViewById(a.f.remittance_tip)).setText(paramString.qrf);
            paramm = findViewById(a.f.tip_container);
            paramm.setVisibility(0);
            paramm.setOnClickListener(new RemittanceBaseUI.3(this));
          }
          this.nAm = paramString.nAm;
          this.nyG = paramString.nyG;
          if (this.nyG == 0.0D) {
            if (this.fzn == 1) {
              com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(14), Integer.valueOf(1) });
            } else {
              com.tencent.mm.plugin.report.service.h.nFQ.f(12689, new Object[] { Integer.valueOf(5), Integer.valueOf(1) });
            }
          }
        }
        else if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ae))
        {
          this.nAp = ((com.tencent.mm.plugin.wallet_core.c.ae)paramm).qrh;
          this.nAq = ((com.tencent.mm.plugin.wallet_core.c.ae)paramm).qrl;
          this.nAr = ((com.tencent.mm.plugin.wallet_core.c.ae)paramm).qrm;
          bwt();
          bws();
        }
      }
    }
    if ((paramm instanceof com.tencent.mm.plugin.wallet_core.c.ae))
    {
      y.i("MicroMsg.RemittanceBaseUI", "net error, use hardcode wording");
      this.nAd.setText("");
      this.nAd.setVisibility(8);
    }
    do
    {
      do
      {
        return false;
      } while (!(paramm instanceof v));
      aa.l(this.nzY, "", paramInt2);
    } while (!b((v)paramm));
    return true;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected int getLayoutId()
  {
    if ((this.nzY == 33) || (this.nzY == 32)) {
      return a.g.remittance_new_ui_f2f;
    }
    return a.g.remittance_new_ui;
  }
  
  protected final void initView()
  {
    if ((this.nzY == 33) || (this.nzY == 32))
    {
      setMMTitle(a.i.remittance_busi_pay);
      setBackBtn(new RemittanceBaseUI.1(this));
      this.mKeyboard = ((MyKeyboardWindow)findViewById(a.f.tenpay_num_keyboard));
      this.lMr = findViewById(a.f.tenpay_keyboard_layout);
      this.lls = ((ScrollView)findViewById(a.f.root_view));
      this.nAa = ((ImageView)findViewById(a.f.remittance_receiver_avatar));
      this.nAb = ((TextView)findViewById(a.f.remittance_receiver_display_name));
      this.nAc = ((TextView)findViewById(a.f.remittance_receiver_display_name_tip));
      this.nAc.setVisibility(8);
      this.nAk = ((LinearLayout)findViewById(a.f.remittance_edit_layout));
      this.nAj = ((LinearLayout)findViewById(a.f.remittance_ftf_desc_layout));
      this.nAh = ((TextView)findViewById(a.f.remittance_fixed_amount_fee));
      this.nAi = ((TextView)findViewById(a.f.remittance_fixed_amount_fee_currency));
      this.nAg = ((TextView)findViewById(a.f.remittance_fixed_amount_desc));
      bwv();
      this.iKG = ((WalletFormView)findViewById(a.f.money_ev));
      if (this.nzY != 33) {
        break label579;
      }
      this.nAh.setText(com.tencent.mm.wallet_core.ui.e.A(this.nzU));
      this.nAi.setText(com.tencent.mm.wallet_core.c.ab.cML());
      this.nAl = getIntent().getStringExtra("desc");
      if (bk.bl(this.nAl)) {
        break label567;
      }
      this.nAg.setText(j.a(this.mController.uMN, this.nAl, this.nAg.getTextSize()));
      this.nAg.setVisibility(0);
      label308:
      this.nAj.setVisibility(0);
      this.nAk.setVisibility(8);
      label325:
      this.frP = ((Button)findViewById(a.f.next_btn));
      this.frP.setOnClickListener(new RemittanceBaseUI.12(this));
      this.nAe = ((TextView)findViewById(a.f.remittance_desc));
      this.nAf = ((TextView)findViewById(a.f.add_remittance_desc));
      if ((this.fzn != 1) && (this.fzn != 6)) {
        break label700;
      }
      this.nAf.setText(a.i.remittance_add_f2f_desc_link);
    }
    for (;;)
    {
      if (!q.Gw()) {
        findViewById(a.f.remittance_desc_container).setOnClickListener(new RemittanceBaseUI.19(this));
      }
      if (this.fzn == 1)
      {
        g.DQ();
        if (((String)g.DP().Dz().get(327732, "0")).equals("0"))
        {
          com.tencent.mm.ui.base.h.a(this.mController.uMN, a.i.remittance_first_ftf_pay_tips, a.i.remittance_first_ftf_pay_tips_title, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
          });
          g.DQ();
          g.DP().Dz().o(327732, "1");
          g.DQ();
          g.DP().Dz().mC(true);
        }
      }
      this.nAd = ((TextView)findViewById(a.f.placeholder));
      bwt();
      bwu();
      bws();
      return;
      setMMTitle(a.i.remittance_title);
      break;
      label567:
      this.nAg.setVisibility(8);
      break label308;
      label579:
      this.iKG.setOnClickListener(new RemittanceBaseUI.24(this));
      this.iKG.getTitleTv().setText(String.format(getString(a.i.remittance_fee_tips), new Object[] { "¥" }));
      this.iKG.a(new RemittanceBaseUI.25(this));
      e(this.iKG, 2, false);
      findViewById(a.f.placeholder);
      findViewById(a.f.remittance_main_ui).setVisibility(0);
      this.nAj.setVisibility(8);
      this.nAk.setVisibility(0);
      this.lTH = new RemittanceBaseUI.2(this);
      break label325;
      label700:
      this.nAf.setText(a.i.remittance_add_desc_link);
    }
  }
  
  public void kk(String paramString)
  {
    y.i("MicroMsg.RemittanceBaseUI", "onGet");
    if (bk.pm(paramString).length() <= 0) {
      y.e("MicroMsg.RemittanceBaseUI", "notifyChanged: user = " + paramString);
    }
    while (!paramString.equals(this.djD)) {
      return;
    }
    bww();
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    y.i("MicroMsg.RemittanceBaseUI", "reqcode=" + paramInt1 + ", resultCode=" + paramInt2 + ", username=" + this.djD);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      if (paramInt2 == -1) {}
      for (;;)
      {
        a(bool1, paramIntent);
        break;
        bool1 = false;
      }
      if (paramInt2 == -1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        a(bool1, paramIntent);
        break;
      }
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str = paramIntent.getStringExtra("Select_Conv_User");
        if (!bk.bl(str))
        {
          this.djD = str;
          bwv();
        }
        else
        {
          finish();
        }
      }
      else
      {
        finish();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.fzn = getIntent().getIntExtra("scene", 0);
    this.nzY = getIntent().getIntExtra("pay_scene", 31);
    super.onCreate(paramBundle);
    this.nzT = com.tencent.mm.plugin.wallet.a.Y(getIntent());
    this.nzZ = getIntent().getStringExtra("scan_remittance_id");
    this.nzU = getIntent().getDoubleExtra("fee", 0.0D);
    this.djD = getIntent().getStringExtra("receiver_name");
    this.nzW = getIntent().getStringExtra("receiver_nick_name");
    this.nAo = getIntent().getStringExtra("receiver_true_name");
    this.nzV = getIntent().getStringExtra("mch_name");
    this.nzX = getIntent().getStringExtra("mch_info");
    this.lTG = getIntent().getIntExtra("pay_channel", 0);
    this.nAt = bk.aM(getIntent().getStringExtra("rcvr_open_id"), "");
    y.i("MicroMsg.RemittanceBaseUI", "mUserName %s", new Object[] { this.djD });
    g.DQ();
    long l = ((Long)g.DP().Dz().get(147457, Long.valueOf(0L))).longValue();
    if ((0x10 & l) != 0L) {
      this.nAs = 1;
    }
    for (;;)
    {
      bwo();
      o.JQ().a(this);
      initView();
      this.nAG.cqo();
      return;
      if ((l & 0x20) != 0L) {
        this.nAs = 2;
      } else {
        this.nAs = 0;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    o.JQ().b(this);
    this.nAG.dead();
    this.nAF.dead();
  }
  
  private static final class a
  {
    int amount;
    String bMY;
    String bQR;
    String iGK;
    String iIB;
    long nAM;
    String nyL;
    String nyM;
    String nyQ;
    
    a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, String paramString5, String paramString6, String paramString7, long paramLong)
    {
      this.nyL = paramString1;
      this.iGK = paramString2;
      this.iIB = paramString3;
      this.nyM = paramString4;
      this.amount = paramInt;
      this.bQR = paramString5;
      this.bMY = paramString6;
      this.nyQ = paramString7;
      this.nAM = paramLong;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.ui.RemittanceBaseUI
 * JD-Core Version:    0.7.0.1
 */