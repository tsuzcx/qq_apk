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
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.o;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cpz;
import com.tencent.mm.protocal.protobuf.dm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  private Button iXb;
  private String mBankType;
  private String mDesc;
  private ScrollView tEk;
  private String uwk;
  private CdnImageView wEP;
  private TextView wER;
  private String wGA;
  private String wGB;
  private String wGC;
  private String wGD;
  private int wGE;
  private int wGF;
  private q wGG;
  private long wGH;
  private int wGI;
  private int wGJ;
  private int wGK;
  private String wGg;
  private TextView wGs;
  private WalletFormView wGt;
  private LinearLayout wGu;
  private TextView wGv;
  private TextView wGw;
  private TextView wGx;
  private TextView wGy;
  private BankcardElemParcel wGz;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 270);
    this.wGI = 0;
    AppMethodBeat.o(67556);
  }
  
  private void dxx()
  {
    AppMethodBeat.i(67563);
    if ((bs.getDouble(this.wGt.getText(), 0.0D) > 0.0D) && (!bs.isNullOrNil(this.wGB)) && (!bs.isNullOrNil(this.wGC)) && (!bs.isNullOrNil(this.mBankType)) && (!bs.isNullOrNil(this.wGD)))
    {
      this.iXb.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    ac.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.wGt.getText(), Boolean.valueOf(bs.isNullOrNil(this.wGB)), Boolean.valueOf(bs.isNullOrNil(this.wGC)), Boolean.valueOf(bs.isNullOrNil(this.mBankType)), Boolean.valueOf(bs.isNullOrNil(this.wGD)) });
    this.iXb.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  private void dxz()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!bs.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(k.c(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(2131756393));
      localSpannableStringBuilder.setSpan(this.wGG, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.wGy.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(2131756394));
      localSpannableStringBuilder.setSpan(this.wGG, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493158;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.tEk = ((ScrollView)findViewById(2131304251));
    this.wEP = ((CdnImageView)findViewById(2131297550));
    this.wER = ((TextView)findViewById(2131297552));
    this.wGs = ((TextView)findViewById(2131297557));
    this.wGt = ((WalletFormView)findViewById(2131297551));
    this.wGu = ((LinearLayout)findViewById(2131297553));
    this.wGv = ((TextView)this.wGu.findViewById(2131297554));
    this.wGw = ((TextView)this.wGu.findViewById(2131297555));
    this.wGx = ((TextView)this.wGu.findViewById(2131297559));
    this.wGy = ((TextView)this.wGu.findViewById(2131297558));
    this.iXb = ((Button)findViewById(2131297556));
    this.wGv.setText(getString(2131756378, new Object[] { this.wGz.wED }));
    this.wEP.setUrl(this.wGz.wEw);
    this.wER.setText(getString(2131756399, new Object[] { this.wGz.tGS, this.wGC }));
    this.wGs.setText(this.wGA);
    this.wGt.setTitleText(ah.fAw());
    setEditFocusListener(this.wGt, 2, false);
    this.wGt.setmContentAbnormalMoneyCheck(true);
    this.wGt.a(new TextWatcher()
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
        if ((!bs.isNullOrNil(paramAnonymousEditable)) && (bs.getDouble(paramAnonymousEditable, 0.0D) > 0.0D)) {
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
    this.wGy.setClickable(true);
    this.wGy.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.wGG = new q(new q.a()
    {
      public final void dK(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(2131756394), BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this), BankRemitMoneyInputUI.this.getString(2131756409, new Object[] { this.wGN }), true, this.wGN * 2, new h.b()new DialogInterface.OnClickListener
        {
          public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
          {
            AppMethodBeat.i(67551);
            if (!bs.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
            ap.n(new Runnable()
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
        h.wUl.f(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    dxz();
    this.iXb.setOnClickListener(new w()
    {
      public final void bWk()
      {
        AppMethodBeat.i(67546);
        ac.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.iG(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          ac.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, 2131756382, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    dxx();
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
        ac.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.wGg);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        ac.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.wGg, localObject });
        doSceneProgress(new c(this.wGg, (String)localObject), false);
        this.wGI = 1;
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.wGg, this.uwk, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ag.br(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ag.bs(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        ac.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.wGI = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.wGg, this.uwk, this.wGI);
        ac.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.wGI) });
      }
    }
    if (paramInt1 == 2)
    {
      ac.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
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
    int j = ((Integer)g.agR().agA().get(ah.a.GPt, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.wGJ = i;
    j = ((Integer)g.agR().agA().get(ah.a.GPu, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.wGK = i;
    ac.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.wGJ), Integer.valueOf(this.wGK) });
    this.uwk = getIntent().getStringExtra("key_unique_id");
    this.wGz = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.wGA = getIntent().getStringExtra("key_payee_name");
    this.wGB = getIntent().getStringExtra("key_bank_card_seqno");
    this.wGC = getIntent().getStringExtra("key_bank_card_tailno");
    this.wGD = getIntent().getStringExtra("key_encrypt_data");
    this.wGE = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.wGF = getIntent().getIntExtra("key_input_type", 0);
    ac.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.uwk });
    if (this.wGz == null)
    {
      ac.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.wGz = new BankcardElemParcel();
    }
    this.mBankType = this.wGz.cZz;
    initView();
    setMMTitle(2131756407);
    b.fzz();
    if ((b.b(b.a.pRO, true)) && (((com.tencent.mm.pluginsdk.wallet.a)g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY"))) {}
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(67559);
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(67550);
          ac.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.wEv.skK, paramString.wEv.EfL });
          ac.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.wEv.wEU, paramString.wEv.tGS });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.wEv.EfL);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.wEv.skK, paramString.wEv.wEU, paramString.wEv.tGS, paramString.wEv.wET);
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
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(67549);
          ac.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.wEv.dae), paramString.wEv.oxf });
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString);
          if (BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67549);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.n paramAnonymousn)
        {
          AppMethodBeat.i(67548);
          ac.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[] { paramAnonymousn });
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