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
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.a.o;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wallet_core.ui.q;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.b;
import com.tencent.mm.wallet_core.c.ag;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.c.r;
import com.tencent.mm.wallet_core.c.r.a;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private Button jtd;
  private String mBankType;
  private String mDesc;
  private ScrollView uSG;
  private String vKR;
  private CdnImageView yip;
  private TextView yir;
  private String yjG;
  private TextView yjS;
  private WalletFormView yjT;
  private LinearLayout yjU;
  private TextView yjV;
  private TextView yjW;
  private TextView yjX;
  private TextView yjY;
  private BankcardElemParcel yjZ;
  private String yka;
  private String ykb;
  private String ykc;
  private String ykd;
  private int yke;
  private int ykf;
  private q ykg;
  private long ykh;
  private int yki;
  private int ykj;
  private int ykk;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 270);
    this.yki = 0;
    AppMethodBeat.o(67556);
  }
  
  private void dMg()
  {
    AppMethodBeat.i(67563);
    if ((bu.getDouble(this.yjT.getText(), 0.0D) > 0.0D) && (!bu.isNullOrNil(this.ykb)) && (!bu.isNullOrNil(this.ykc)) && (!bu.isNullOrNil(this.mBankType)) && (!bu.isNullOrNil(this.ykd)))
    {
      this.jtd.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    ae.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.yjT.getText(), Boolean.valueOf(bu.isNullOrNil(this.ykb)), Boolean.valueOf(bu.isNullOrNil(this.ykc)), Boolean.valueOf(bu.isNullOrNil(this.mBankType)), Boolean.valueOf(bu.isNullOrNil(this.ykd)) });
    this.jtd.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  private void dMi()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!bu.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(k.c(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(2131756393));
      localSpannableStringBuilder.setSpan(this.ykg, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.yjY.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(2131756394));
      localSpannableStringBuilder.setSpan(this.ykg, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  public int getLayoutId()
  {
    return 2131493158;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.uSG = ((ScrollView)findViewById(2131304251));
    this.yip = ((CdnImageView)findViewById(2131297550));
    this.yir = ((TextView)findViewById(2131297552));
    this.yjS = ((TextView)findViewById(2131297557));
    this.yjT = ((WalletFormView)findViewById(2131297551));
    this.yjU = ((LinearLayout)findViewById(2131297553));
    this.yjV = ((TextView)this.yjU.findViewById(2131297554));
    this.yjW = ((TextView)this.yjU.findViewById(2131297555));
    this.yjX = ((TextView)this.yjU.findViewById(2131297559));
    this.yjY = ((TextView)this.yjU.findViewById(2131297558));
    this.jtd = ((Button)findViewById(2131297556));
    this.yjV.setText(getString(2131756378, new Object[] { this.yjZ.yid }));
    this.yip.setUrl(this.yjZ.yhW);
    this.yir.setText(getString(2131756399, new Object[] { this.yjZ.uVs, this.ykc }));
    this.yjS.setText(this.yka);
    this.yjT.setTitleText(ah.fWc());
    setEditFocusListener(this.yjT, 2, false);
    this.yjT.setmContentAbnormalMoneyCheck(true);
    this.yjT.a(new TextWatcher()
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
        if ((!bu.isNullOrNil(paramAnonymousEditable)) && (bu.getDouble(paramAnonymousEditable, 0.0D) > 0.0D)) {
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
    this.yjY.setClickable(true);
    this.yjY.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.n(this));
    this.ykg = new q(new q.a()
    {
      public final void dN(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(2131756394), BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this), BankRemitMoneyInputUI.this.getString(2131756409, new Object[] { this.ykn }), true, this.ykn * 2, new h.b()new DialogInterface.OnClickListener
        {
          public final boolean onFinish(CharSequence paramAnonymous2CharSequence)
          {
            AppMethodBeat.i(67551);
            if (!bu.isNullOrNil(paramAnonymous2CharSequence.toString()))
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
            ar.o(new Runnable()
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
        com.tencent.mm.plugin.report.service.g.yxI.f(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    dMi();
    this.jtd.setOnClickListener(new w()
    {
      public final void ccc()
      {
        AppMethodBeat.i(67546);
        ae.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.iZ(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          ae.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, 2131756382, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    dMg();
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
        ae.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.yjG);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        ae.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.yjG, localObject });
        doSceneProgress(new c(this.yjG, (String)localObject), false);
        this.yki = 1;
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.yjG, this.vKR, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ag.bx(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ag.by(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        ae.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.yki = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new com.tencent.mm.plugin.remittance.bankcard.a.n(this.yjG, this.vKR, this.yki);
        ae.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.yki) });
      }
    }
    if (paramInt1 == 2)
    {
      ae.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
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
    int j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWn, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.ykj = i;
    j = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWo, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.ykk = i;
    ae.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.ykj), Integer.valueOf(this.ykk) });
    this.vKR = getIntent().getStringExtra("key_unique_id");
    this.yjZ = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.yka = getIntent().getStringExtra("key_payee_name");
    this.ykb = getIntent().getStringExtra("key_bank_card_seqno");
    this.ykc = getIntent().getStringExtra("key_bank_card_tailno");
    this.ykd = getIntent().getStringExtra("key_encrypt_data");
    this.yke = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.ykf = getIntent().getIntExtra("key_input_type", 0);
    ae.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.vKR });
    if (this.yjZ == null)
    {
      ae.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.yjZ = new BankcardElemParcel();
    }
    this.mBankType = this.yjZ.dlT;
    initView();
    setMMTitle(2131756407);
    b.fVf();
    if ((b.b(b.a.qDk, true)) && (((com.tencent.mm.pluginsdk.wallet.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.pluginsdk.wallet.a.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY"))) {}
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
          ae.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.yhV.tsf, paramString.yhV.GeJ });
          ae.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.yhV.yiu, paramString.yhV.uVs });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.yhV.GeJ);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.yhV.tsf, paramString.yhV.yiu, paramString.yhV.uVs, paramString.yhV.yit);
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
          ae.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.yhV.dmy), paramString.yhV.phe });
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
          ae.e("MicroMsg.BankRemitMoneyInputUI", "net error: %s", new Object[] { paramAnonymousn });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */