package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.cb.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.n;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.p;
import com.tencent.mm.wallet_core.c.p.a;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  private final int HARDCODE_TENPAY_KEYBOARD_HEIGHT;
  private Button gJr;
  private String mDesc;
  private ScrollView nIO;
  private String ovh;
  private CdnImageView qgr;
  private TextView qgt;
  private String qhD;
  private TextView qhP;
  private WalletFormView qhQ;
  private LinearLayout qhR;
  private TextView qhS;
  private TextView qhT;
  private TextView qhU;
  private TextView qhV;
  private BankcardElemParcel qhW;
  private String qhX;
  private String qhY;
  private String qhZ;
  private String qia;
  private String qib;
  private int qic;
  private int qid;
  private com.tencent.mm.plugin.wallet_core.ui.o qie;
  private long qif;
  private int qig;
  private int qih;
  private int qii;
  
  public BankRemitMoneyInputUI()
  {
    AppMethodBeat.i(44642);
    this.HARDCODE_TENPAY_KEYBOARD_HEIGHT = a.fromDPToPix(ah.getContext(), 270);
    this.qig = 0;
    AppMethodBeat.o(44642);
  }
  
  private void cgS()
  {
    AppMethodBeat.i(44650);
    if ((bo.getDouble(this.qhQ.getText(), 0.0D) > 0.0D) && (!bo.isNullOrNil(this.qhY)) && (!bo.isNullOrNil(this.qhZ)) && (!bo.isNullOrNil(this.qib)) && (!bo.isNullOrNil(this.qia)))
    {
      this.gJr.setEnabled(true);
      AppMethodBeat.o(44650);
      return;
    }
    ab.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.qhQ.getText(), Boolean.valueOf(bo.isNullOrNil(this.qhY)), Boolean.valueOf(bo.isNullOrNil(this.qhZ)), Boolean.valueOf(bo.isNullOrNil(this.qib)), Boolean.valueOf(bo.isNullOrNil(this.qia)) });
    this.gJr.setEnabled(false);
    AppMethodBeat.o(44650);
  }
  
  private void cgU()
  {
    AppMethodBeat.i(44649);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!bo.isNullOrNil(this.mDesc))
    {
      localSpannableStringBuilder.append(j.b(getContext(), this.mDesc));
      localSpannableStringBuilder.append(getString(2131297507));
      localSpannableStringBuilder.setSpan(this.qie, this.mDesc.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.qhV.setText(localSpannableStringBuilder);
      AppMethodBeat.o(44649);
      return;
      localSpannableStringBuilder.append(getString(2131297508));
      localSpannableStringBuilder.setSpan(this.qie, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  public int getLayoutId()
  {
    return 2130968826;
  }
  
  public void initView()
  {
    AppMethodBeat.i(44644);
    this.nIO = ((ScrollView)findViewById(2131820898));
    this.qgr = ((CdnImageView)findViewById(2131821710));
    this.qgt = ((TextView)findViewById(2131821711));
    this.qhP = ((TextView)findViewById(2131821712));
    this.qhQ = ((WalletFormView)findViewById(2131821713));
    this.qhR = ((LinearLayout)findViewById(2131821714));
    this.qhS = ((TextView)this.qhR.findViewById(2131821715));
    this.qhT = ((TextView)this.qhR.findViewById(2131821716));
    this.qhU = ((TextView)this.qhR.findViewById(2131821717));
    this.qhV = ((TextView)this.qhR.findViewById(2131821718));
    this.gJr = ((Button)findViewById(2131821719));
    this.qhS.setText(getString(2131297492, new Object[] { this.qhW.qgf }));
    this.qgr.setUrl(this.qhW.qfY);
    this.qgt.setText(getString(2131297513, new Object[] { this.qhW.nLq, this.qhZ }));
    this.qhP.setText(this.qhX);
    this.qhQ.setTitleText(ae.dSz());
    setEditFocusListener(this.qhQ, 2, false);
    this.qhQ.a(new BankRemitMoneyInputUI.1(this));
    this.qhV.setClickable(true);
    this.qhV.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.qie = new com.tencent.mm.plugin.wallet_core.ui.o(new BankRemitMoneyInputUI.8(this));
    cgU();
    this.gJr.setOnClickListener(new BankRemitMoneyInputUI.3(this));
    cgS();
    setTenpayKBStateListener(new BankRemitMoneyInputUI.4(this));
    AppMethodBeat.o(44644);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(44647);
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        ab.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(getContext(), BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.qhD);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        ab.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.qhD, localObject });
        doSceneProgress(new com.tencent.mm.plugin.remittance.bankcard.a.c(this.qhD, (String)localObject), false);
        this.qig = 1;
        paramIntent = new n(this.qhD, this.ovh, 1);
      }
      for (;;)
      {
        doSceneProgress(paramIntent, false);
        AppMethodBeat.o(44647);
        return;
        if (com.tencent.mm.plugin.wallet_core.utils.c.av(paramIntent))
        {
          finish();
          AppMethodBeat.o(44647);
          return;
        }
        if (com.tencent.mm.plugin.wallet_core.utils.c.aw(paramIntent))
        {
          AppMethodBeat.o(44647);
          return;
        }
        ab.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
        this.qig = paramIntent.getIntExtra("key_pay_reslut_type", 0);
        paramIntent = new n(this.qhD, this.ovh, this.qig);
        ab.i("MicroMsg.BankRemitMoneyInputUI", "onActivityResult() requestCode == REQ_PAY resultCode != RESULT_OK  mUnpayType:%s", new Object[] { Integer.valueOf(this.qig) });
      }
    }
    if (paramInt1 == 2)
    {
      ab.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      d.b(getContext(), "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
      AppMethodBeat.o(44647);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(44647);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(44643);
    super.onCreate(paramBundle);
    hideActionbarLine();
    addSceneEndListener(1380);
    addSceneEndListener(2739);
    int j = ((Integer)g.RL().Ru().get(ac.a.yIG, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.qih = i;
    j = ((Integer)g.RL().Ru().get(ac.a.yIH, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.qii = i;
    ab.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.qih), Integer.valueOf(this.qii) });
    this.ovh = getIntent().getStringExtra("key_unique_id");
    this.qhW = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.qhX = getIntent().getStringExtra("key_payee_name");
    this.qhY = getIntent().getStringExtra("key_bank_card_seqno");
    this.qhZ = getIntent().getStringExtra("key_bank_card_tailno");
    this.qia = getIntent().getStringExtra("key_encrypt_data");
    this.qic = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.qid = getIntent().getIntExtra("key_input_type", 0);
    ab.d("MicroMsg.BankRemitMoneyInputUI", "set uniqueId:%s", new Object[] { this.ovh });
    if (this.qhW == null)
    {
      ab.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.qhW = new BankcardElemParcel();
    }
    this.qib = this.qhW.poq;
    initView();
    setMMTitle(2131297521);
    com.tencent.mm.wallet_core.b.dRI();
    if ((com.tencent.mm.wallet_core.b.dpQ()) && (((com.tencent.mm.pluginsdk.wallet.b)g.E(com.tencent.mm.pluginsdk.wallet.b.class)).kindaCacheServiceGetBool("NEW_CASHIER_TRANSFER2BANK_PAY_SWTICH_KEY"))) {}
    for (boolean bool = true;; bool = false)
    {
      this.mKindaEnable = bool;
      AppMethodBeat.o(44643);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(44646);
    super.onDestroy();
    removeSceneEndListener(1380);
    removeSceneEndListener(2739);
    AppMethodBeat.o(44646);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(44645);
    if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.o))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.o)paramm;
      paramString.a(new p.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ai.m paramAnonymousm)
        {
          AppMethodBeat.i(44636);
          ab.i("MicroMsg.BankRemitMoneyInputUI", "reqKey: %s, billId: %s", new Object[] { paramString.qfX.opy, paramString.qfX.wBQ });
          ab.d("MicroMsg.BankRemitMoneyInputUI", "name: %s, bank: %s", new Object[] { paramString.qfX.qgw, paramString.qfX.nLq });
          BankRemitMoneyInputUI.b(BankRemitMoneyInputUI.this, paramString.qfX.wBQ);
          if (!BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString))
          {
            BankRemitMoneyInputUI.a(BankRemitMoneyInputUI.this, paramString.qfX.opy, paramString.qfX.qgw, paramString.qfX.nLq, paramString.qfX.qgv);
            AppMethodBeat.o(44636);
            return;
          }
          if (BankRemitMoneyInputUI.i(BankRemitMoneyInputUI.this)) {
            BankRemitMoneyInputUI.this.hideLoading();
          }
          AppMethodBeat.o(44636);
        }
      }).b(new BankRemitMoneyInputUI.6(this, paramString)).c(new BankRemitMoneyInputUI.5(this));
    }
    AppMethodBeat.o(44645);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */