package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.protocal.protobuf.dyn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.g;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  public String ELa;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private CdnImageView Igj;
  private TextView Igl;
  public String IhA;
  private TextView IhL;
  private WalletFormView IhM;
  private LinearLayout IhN;
  private TextView IhO;
  private TextView IhP;
  private TextView IhQ;
  private TextView IhR;
  private BankcardElemParcel IhS;
  private String IhT;
  private String IhU;
  private String IhV;
  private String IhW;
  private int IhX;
  private int IhY;
  private com.tencent.mm.plugin.wallet_core.ui.r IhZ;
  private long Iia;
  public int Iib;
  private int Iic;
  private int Iid;
  private String mBankType;
  private String mDesc;
  private ScrollView mMs;
  private Button njb;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.Iib = 0;
    AppMethodBeat.o(67556);
  }
  
  private void bwE()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!Util.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(l.c(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(a.i.bank_remit_remittance_desc_modify_text));
      localSpannableStringBuilder.setSpan(this.IhZ, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.IhR.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(a.i.bank_remit_remittance_desc_text));
      localSpannableStringBuilder.setSpan(this.IhZ, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  private void fzW()
  {
    AppMethodBeat.i(67563);
    if ((Util.getDouble(this.IhM.getText(), 0.0D) > 0.0D) && (!Util.isNullOrNil(this.IhU)) && (!Util.isNullOrNil(this.IhV)) && (!Util.isNullOrNil(this.mBankType)) && (!Util.isNullOrNil(this.IhW)))
    {
      this.njb.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    Log.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.IhM.getText(), Boolean.valueOf(Util.isNullOrNil(this.IhU)), Boolean.valueOf(Util.isNullOrNil(this.IhV)), Boolean.valueOf(Util.isNullOrNil(this.mBankType)), Boolean.valueOf(Util.isNullOrNil(this.IhW)) });
    this.njb.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  public final void aNS(String paramString)
  {
    AppMethodBeat.i(231883);
    Log.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.IhA, paramString });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.c(this.IhA, paramString), false);
    AppMethodBeat.o(231883);
  }
  
  public int getLayoutId()
  {
    return a.g.bank_remit_money_input_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.mMs = ((ScrollView)findViewById(a.f.root_view));
    this.Igj = ((CdnImageView)findViewById(a.f.brmi_bank_logo_iv));
    this.Igl = ((TextView)findViewById(a.f.brmi_bank_name_tv));
    this.IhL = ((TextView)findViewById(a.f.brmi_payee_tv));
    this.IhM = ((WalletFormView)findViewById(a.f.brmi_bank_money_input_tv));
    this.IhN = ((LinearLayout)findViewById(a.f.brmi_fee_rate_layout));
    this.IhO = ((TextView)this.IhN.findViewById(a.f.brmi_fee_rate_title_tv));
    this.IhP = ((TextView)this.IhN.findViewById(a.f.brmi_fee_tv));
    this.IhQ = ((TextView)this.IhN.findViewById(a.f.brmi_total_money_tv));
    this.IhR = ((TextView)this.IhN.findViewById(a.f.brmi_remit_desc_tv));
    this.njb = ((Button)findViewById(a.f.brmi_next_btn));
    this.IhO.setText(getString(a.i.bank_remit_fee_rate_text, new Object[] { this.IhS.IfX }));
    this.Igj.setUrl(this.IhS.IfQ);
    this.Igl.setText(getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { this.IhS.DNV, this.IhV }));
    this.IhL.setText(this.IhT);
    this.IhM.setTitleText(ah.ijb());
    setEditFocusListener(this.IhM, 2, false);
    this.IhM.setmContentAbnormalMoneyCheck(true);
    this.IhM.a(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        AppMethodBeat.i(67544);
        if (paramAnonymousEditable.toString().startsWith(".")) {
          paramAnonymousEditable.insert(0, "0");
        }
        String str = paramAnonymousEditable.toString();
        int i = str.indexOf(".");
        int j = str.length();
        if ((i >= 0) && (j - i > 2)) {
          WalletFormView.a(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getContentEt(), str, i + 3, j);
        }
        paramAnonymousEditable = paramAnonymousEditable.toString();
        if ((!Util.isNullOrNil(paramAnonymousEditable)) && (Util.getDouble(paramAnonymousEditable, 0.0D) > 0.0D)) {
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this).setVisibility(0);
        }
        for (;;)
        {
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramAnonymousEditable);
          BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this);
          AppMethodBeat.o(67544);
          return;
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this).setVisibility(8);
        }
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    this.IhR.setClickable(true);
    this.IhR.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
    this.IhZ = new com.tencent.mm.plugin.wallet_core.ui.r(new com.tencent.mm.plugin.wallet_core.ui.r.a()
    {
      public final void ed(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(a.i.bank_remit_remittance_desc_text), BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this), BankRemitMoneyInputUI.this.getString(a.i.bank_remit_transfer_wording, new Object[] { this.Iig }), true, this.Iig * 2, new h.b()new DialogInterface.OnClickListener
        {
          public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
          {
            AppMethodBeat.i(67551);
            if (!Util.isNullOrNil(paramAnonymous2CharSequence.toString()))
            {
              BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this, paramAnonymous2CharSequence.toString());
              BankRemitMoneyInputUI.k(BankRemitMoneyInputUI.this);
            }
            for (;;)
            {
              AppMethodBeat.o(67551);
              return true;
              BankRemitMoneyInputUI.c(BankRemitMoneyInputUI.this, null);
              BankRemitMoneyInputUI.k(BankRemitMoneyInputUI.this);
            }
          }
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(67553);
            MMHandlerThread.postToMainThreadDelayed(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(67552);
                BankRemitMoneyInputUI.this.hideVKB();
                AppMethodBeat.o(67552);
              }
            }, 500L);
            AppMethodBeat.o(67553);
          }
        });
        com.tencent.mm.plugin.report.service.h.IzE.a(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    bwE();
    this.njb.setOnClickListener(new aa()
    {
      public final void cOw()
      {
        AppMethodBeat.i(67546);
        Log.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.jZ(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          Log.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, a.i.bank_remit_illegal_arg_text, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    fzW();
    setTenpayKBStateListener(new com.tencent.mm.wallet_core.ui.a()
    {
      public final void onVisibleStateChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(67547);
        if (paramAnonymousBoolean)
        {
          BankRemitMoneyInputUI.e(BankRemitMoneyInputUI.this);
          AppMethodBeat.o(67547);
          return;
        }
        BankRemitMoneyInputUI.f(BankRemitMoneyInputUI.this).scrollTo(0, 0);
        AppMethodBeat.o(67547);
      }
    });
    AppMethodBeat.o(67558);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(67561);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        Log.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.IhA);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        aNS((String)localObject);
        this.Iib = 1;
        paramIntent = new n(this.IhA, this.ELa, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ag.bL(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ag.bM(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        Log.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.Iib = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new n(this.IhA, this.ELa, this.Iib);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.Iib) });
      }
    }
    if (paramInt1 == 2)
    {
      Log.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      com.tencent.mm.by.c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
      AppMethodBeat.o(67561);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(67561);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(67557);
    super.onCreate(paramBundle);
    hideActionbarLine();
    addSceneEndListener(1380);
    addSceneEndListener(2739);
    int j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsQ, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.Iic = i;
    j = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VsR, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.Iid = i;
    Log.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.Iic), Integer.valueOf(this.Iid) });
    this.ELa = getIntent().getStringExtra("key_unique_id");
    this.IhS = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.IhT = getIntent().getStringExtra("key_payee_name");
    this.IhU = getIntent().getStringExtra("key_bank_card_seqno");
    this.IhV = getIntent().getStringExtra("key_bank_card_tailno");
    this.IhW = getIntent().getStringExtra("key_encrypt_data");
    this.IhX = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.IhY = getIntent().getIntExtra("key_input_type", 0);
    Log.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.ELa });
    if (this.IhS == null)
    {
      Log.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.IhS = new BankcardElemParcel();
    }
    this.mBankType = this.IhS.fvP;
    initView();
    setMMTitle(a.i.bank_remit_title);
    b.iie();
    this.mKindaEnable = b.b(b.a.vCG, true);
    AppMethodBeat.o(67557);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67560);
    super.onDestroy();
    removeSceneEndListener(1380);
    removeSceneEndListener(2739);
    AppMethodBeat.o(67560);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(67559);
    if ((paramq instanceof com.tencent.mm.plugin.remittance.bankcard.a.o))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.o)paramq;
      paramString.a(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67550);
          Log.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.IfP.ByI, paramString.IfP.Saj });
          Log.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.IfP.Igo, paramString.IfP.DNV });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.IfP.Saj);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.IfP.ByI, paramString.IfP.Igo, paramString.IfP.DNV, paramString.IfP.Ign);
            AppMethodBeat.o(67550);
            return;
          }
          if (BankRemitMoneyInputUI.i(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67550);
        }
      }).b(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67549);
          Log.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.IfP.fwx), paramString.IfP.tVo });
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString);
          if (BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67549);
        }
      }).c(new com.tencent.mm.wallet_core.c.r.a()
      {
        public final void e(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
        {
          AppMethodBeat.i(67548);
          Log.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[] { paramAnonymousq });
          if (BankRemitMoneyInputUI.g(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67548);
        }
      });
    }
    AppMethodBeat.o(67559);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public boolean shouldEnsureSoterConnection()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */