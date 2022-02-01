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
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.q.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.dor;
import com.tencent.mm.protocal.protobuf.dx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.x;
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
  private CdnImageView Cjq;
  private TextView Cjs;
  public String CkH;
  private TextView CkS;
  private WalletFormView CkT;
  private LinearLayout CkU;
  private TextView CkV;
  private TextView CkW;
  private TextView CkX;
  private TextView CkY;
  private BankcardElemParcel CkZ;
  private String Cla;
  private String Clb;
  private String Clc;
  private String Cld;
  private int Cle;
  private int Clf;
  private com.tencent.mm.plugin.wallet_core.ui.q Clg;
  private long Clh;
  public int Cli;
  private int Clj;
  private int Clk;
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private ScrollView jVf;
  private Button krs;
  private String mBankType;
  private String mDesc;
  public String zfX;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(67556);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 270);
    this.Cli = 0;
    AppMethodBeat.o(67556);
  }
  
  private void bmw()
  {
    AppMethodBeat.i(67562);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!Util.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(l.c(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(2131756528));
      localSpannableStringBuilder.setSpan(this.Clg, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.CkY.setText(localSpannableStringBuilder);
      AppMethodBeat.o(67562);
      return;
      localSpannableStringBuilder.append(getString(2131756529));
      localSpannableStringBuilder.setSpan(this.Clg, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  private void eNh()
  {
    AppMethodBeat.i(67563);
    if ((Util.getDouble(this.CkT.getText(), 0.0D) > 0.0D) && (!Util.isNullOrNil(this.Clb)) && (!Util.isNullOrNil(this.Clc)) && (!Util.isNullOrNil(this.mBankType)) && (!Util.isNullOrNil(this.Cld)))
    {
      this.krs.setEnabled(true);
      AppMethodBeat.o(67563);
      return;
    }
    Log.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.CkT.getText(), Boolean.valueOf(Util.isNullOrNil(this.Clb)), Boolean.valueOf(Util.isNullOrNil(this.Clc)), Boolean.valueOf(Util.isNullOrNil(this.mBankType)), Boolean.valueOf(Util.isNullOrNil(this.Cld)) });
    this.krs.setEnabled(false);
    AppMethodBeat.o(67563);
  }
  
  public final void aDI(String paramString)
  {
    AppMethodBeat.i(213702);
    Log.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.CkH, paramString });
    doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.c(this.CkH, paramString), false);
    AppMethodBeat.o(213702);
  }
  
  public int getLayoutId()
  {
    return 2131493204;
  }
  
  public void initView()
  {
    AppMethodBeat.i(67558);
    this.jVf = ((ScrollView)findViewById(2131307173));
    this.Cjq = ((CdnImageView)findViewById(2131297776));
    this.Cjs = ((TextView)findViewById(2131297778));
    this.CkS = ((TextView)findViewById(2131297783));
    this.CkT = ((WalletFormView)findViewById(2131297777));
    this.CkU = ((LinearLayout)findViewById(2131297779));
    this.CkV = ((TextView)this.CkU.findViewById(2131297780));
    this.CkW = ((TextView)this.CkU.findViewById(2131297781));
    this.CkX = ((TextView)this.CkU.findViewById(2131297785));
    this.CkY = ((TextView)this.CkU.findViewById(2131297784));
    this.krs = ((Button)findViewById(2131297782));
    this.CkV.setText(getString(2131756513, new Object[] { this.CkZ.Cje }));
    this.Cjq.setUrl(this.CkZ.CiX);
    this.Cjs.setText(getString(2131756534, new Object[] { this.CkZ.ynT, this.Clc }));
    this.CkS.setText(this.Cla);
    this.CkT.setTitleText(ah.hhz());
    setEditFocusListener(this.CkT, 2, false);
    this.CkT.setmContentAbnormalMoneyCheck(true);
    this.CkT.a(new TextWatcher()
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
    this.CkY.setClickable(true);
    this.CkY.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
    this.Clg = new com.tencent.mm.plugin.wallet_core.ui.q(new q.a()
    {
      public final void dF(View paramAnonymousView)
      {
        AppMethodBeat.i(67554);
        com.tencent.mm.plugin.wallet_core.ui.view.a.a(BankRemitMoneyInputUI.this, BankRemitMoneyInputUI.this.getString(2131756529), BankRemitMoneyInputUI.j(BankRemitMoneyInputUI.this), BankRemitMoneyInputUI.this.getString(2131756544, new Object[] { this.Cln }), true, this.Cln * 2, new h.b()new DialogInterface.OnClickListener
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
        h.CyF.a(14673, new Object[] { Integer.valueOf(4) });
        AppMethodBeat.o(67554);
      }
    });
    bmw();
    this.krs.setOnClickListener(new x()
    {
      public final void czW()
      {
        AppMethodBeat.i(67546);
        Log.d("MicroMsg.BankRemitMoneyInputUI", "on click next");
        double d = com.tencent.mm.plugin.remittance.bankcard.model.a.jK(BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this).getText(), "100");
        if (d <= 0.0D)
        {
          Log.w("MicroMsg.BankRemitMoneyInputUI", "illegal money: %s", new Object[] { Double.valueOf(d) });
          Toast.makeText(BankRemitMoneyInputUI.this, 2131756517, 1).show();
          AppMethodBeat.o(67546);
          return;
        }
        BankRemitMoneyInputUI.d(BankRemitMoneyInputUI.this);
        AppMethodBeat.o(67546);
      }
    });
    eNh();
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
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.CkH);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        aDI((String)localObject);
        this.Cli = 1;
        paramIntent = new n(this.CkH, this.zfX, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(67561);
        return;
        if (ag.bH(paramIntent))
        {
          finish();
          AppMethodBeat.o(67561);
          return;
        }
        if (ag.bI(paramIntent))
        {
          AppMethodBeat.o(67561);
          return;
        }
        Log.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.Cli = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new n(this.CkH, this.zfX, this.Cli);
        Log.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.Cli) });
      }
    }
    if (paramInt1 == 2)
    {
      Log.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      com.tencent.mm.br.c.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
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
    int j = ((Integer)g.aAh().azQ().get(ar.a.OeF, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.Clj = i;
    j = ((Integer)g.aAh().azQ().get(ar.a.OeG, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.Clk = i;
    Log.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.Clj), Integer.valueOf(this.Clk) });
    this.zfX = getIntent().getStringExtra("key_unique_id");
    this.CkZ = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.Cla = getIntent().getStringExtra("key_payee_name");
    this.Clb = getIntent().getStringExtra("key_bank_card_seqno");
    this.Clc = getIntent().getStringExtra("key_bank_card_tailno");
    this.Cld = getIntent().getStringExtra("key_encrypt_data");
    this.Cle = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.Clf = getIntent().getIntExtra("key_input_type", 0);
    Log.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.zfX });
    if (this.CkZ == null)
    {
      Log.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.CkZ = new BankcardElemParcel();
    }
    this.mBankType = this.CkZ.dDj;
    initView();
    setMMTitle(2131756542);
    b.hgC();
    this.mKindaEnable = b.b(b.a.rWd, true);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(67559);
    if ((paramq instanceof com.tencent.mm.plugin.remittance.bankcard.a.o))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.o)paramq;
      paramString.a(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(67550);
          Log.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.CiW.wFL, paramString.CiW.KZa });
          Log.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.CiW.Cjv, paramString.CiW.ynT });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.CiW.KZa);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.CiW.wFL, paramString.CiW.Cjv, paramString.CiW.ynT, paramString.CiW.Cju);
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
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
        {
          AppMethodBeat.i(67549);
          Log.e("MicroMsg.BankRemitMoneyInputUI", "request order error: %s, %s", new Object[] { Integer.valueOf(paramString.CiW.dDN), paramString.CiW.qwn });
          BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString);
          if (BankRemitMoneyInputUI.h(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(67549);
        }
      }).c(new r.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.q paramAnonymousq)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */