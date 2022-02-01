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
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.o;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cve;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private Button jqk;
  private String mBankType;
  private String mDesc;
  private ScrollView uGT;
  private String vyN;
  private CdnImageView xSw;
  private TextView xSy;
  private String xTN;
  private TextView xTZ;
  private WalletFormView xUa;
  private LinearLayout xUb;
  private TextView xUc;
  private TextView xUd;
  private TextView xUe;
  private TextView xUf;
  private BankcardElemParcel xUg;
  private String xUh;
  private String xUi;
  private String xUj;
  private String xUk;
  private int xUl;
  private int xUm;
  private q xUn;
  private long xUo;
  private int xUp;
  private int xUq;
  private int xUr;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 270);
    this.xUp = 0;
    AppMethodBeat.o(67556);
  }
  
  private void dIP()
  {
    AppMethodBeat.i(67563);
    if ((bt.getDouble(this.xUa.getText(), 0.0D) > 0.0D) && (!bt.isNullOrNil(this.xUi)) && (!bt.isNullOrNil(this.xUj)) && (!bt.isNullOrNil(this.mBankType)) && (!bt.isNullOrNil(this.xUk)))
    {
      this.jqk.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    ad.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.xUa.getText(), Boolean.valueOf(bt.isNullOrNil(this.xUi)), Boolean.valueOf(bt.isNullOrNil(this.xUj)), Boolean.valueOf(bt.isNullOrNil(this.mBankType)), Boolean.valueOf(bt.isNullOrNil(this.xUk)) });
    this.jqk.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  private void dIR()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!bt.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(k.c(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(2131756393));
      localSpannableStringBuilder.setSpan(this.xUn, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.xUf.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(2131756394));
      localSpannableStringBuilder.setSpan(this.xUn, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493158;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.uGT = ((ScrollView)findViewById(2131304251));
    this.xSw = ((CdnImageView)findViewById(2131297550));
    this.xSy = ((TextView)findViewById(2131297552));
    this.xTZ = ((TextView)findViewById(2131297557));
    this.xUa = ((WalletFormView)findViewById(2131297551));
    this.xUb = ((LinearLayout)findViewById(2131297553));
    this.xUc = ((TextView)this.xUb.findViewById(2131297554));
    this.xUd = ((TextView)this.xUb.findViewById(2131297555));
    this.xUe = ((TextView)this.xUb.findViewById(2131297559));
    this.xUf = ((TextView)this.xUb.findViewById(2131297558));
    this.jqk = ((Button)findViewById(2131297556));
    this.xUc.setText(getString(2131756378, new Object[] { this.xUg.xSk }));
    this.xSw.setUrl(this.xUg.xSd);
    this.xSy.setText(getString(2131756399, new Object[] { this.xUg.uJF, this.xUj }));
    this.xTZ.setText(this.xUh);
    this.xUa.setTitleText(ah.fRG());
    setEditFocusListener(this.xUa, 2, false);
    this.xUa.setmContentAbnormalMoneyCheck(true);
    this.xUa.a(new TextWatcher()
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
        if ((!bt.isNullOrNil(paramAnonymousEditable)) && (bt.getDouble(paramAnonymousEditable, 0.0D) > 0.0D)) {
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
    this.xUf.setClickable(true);
    this.xUf.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.xUn = new q(new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(2131756394), BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this), BankRemitMoneyInputUI.this.getString(2131756409, new Object[] { this.xUu }), true, this.xUu * 2, new h.b()new DialogInterface.OnClickListener
        {
          public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
          {
            AppMethodBeat.i(67551);
            if (!bt.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
            aq.o(new Runnable()
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
        com.tencent.mm.plugin.report.service.g.yhR.f(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    dIR();
    this.jqk.setOnClickListener(new w()
    {
      public final void caN()
      {
        AppMethodBeat.i(67546);
        ad.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.iT(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          ad.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, 2131756382, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    dIP();
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
        ad.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.xTN);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        ad.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.xTN, localObject });
        doSceneProgress(new c(this.xTN, (String)localObject), false);
        this.xUp = 1;
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.xTN, this.vyN, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ag.bw(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ag.bx(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        ad.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.xUp = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.xTN, this.vyN, this.xUp);
        ad.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.xUp) });
      }
    }
    if (paramInt1 == 2)
    {
      ad.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      d.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
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
    int j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBO, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.xUq = i;
    j = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.IBP, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.xUr = i;
    ad.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.xUq), Integer.valueOf(this.xUr) });
    this.vyN = getIntent().getStringExtra("key_unique_id");
    this.xUg = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.xUh = getIntent().getStringExtra("key_payee_name");
    this.xUi = getIntent().getStringExtra("key_bank_card_seqno");
    this.xUj = getIntent().getStringExtra("key_bank_card_tailno");
    this.xUk = getIntent().getStringExtra("key_encrypt_data");
    this.xUl = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.xUm = getIntent().getIntExtra("key_input_type", 0);
    ad.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.vyN });
    if (this.xUg == null)
    {
      ad.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.xUg = new BankcardElemParcel();
    }
    this.mBankType = this.xUg.dkR;
    initView();
    setMMTitle(2131756407);
    b.fQJ();
    if ((b.b(b.a.qwl, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      AppMethodBeat.o(67557);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(67560);
    super.onDestroy();
    removeSceneEndListener(1380);
    removeSceneEndListener(2739);
    AppMethodBeat.o(67560);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(67559);
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(67550);
          ad.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.xSc.thm, paramString.xSc.FMk });
          ad.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.xSc.xSB, paramString.xSc.uJF });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.xSc.FMk);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.xSc.thm, paramString.xSc.xSB, paramString.xSc.uJF, paramString.xSc.xSA);
            AppMethodBeat.o(67550);
            return;
          }
          if (BankRemitMoneyInputUI.i(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67550);
        }
      }).b(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(67549);
          ad.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.xSc.dlw), paramString.xSc.paA });
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString);
          if (BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67549);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.n paramAnonymousn)
        {
          AppMethodBeat.i(67548);
          ad.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[] { paramAnonymousn });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */