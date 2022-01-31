package com.tencent.mm.plugin.remittance.bankcard.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.br.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.remittance.bankcard.a.c;
import com.tencent.mm.plugin.remittance.bankcard.model.BankcardElemParcel;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;

public class BankRemitMoneyInputUI
  extends BankRemitBaseUI
{
  private String dkv;
  private final int eYf = com.tencent.mm.cb.a.fromDPToPix(ae.getContext(), 270);
  private Button frP;
  private ScrollView lls;
  private CdnImageView nvv;
  private TextView nvx;
  private String nwB;
  private TextView nwO;
  private WalletFormView nwP;
  private LinearLayout nwQ;
  private TextView nwR;
  private TextView nwS;
  private TextView nwT;
  private TextView nwU;
  private BankcardElemParcel nwV;
  private String nwW;
  private String nwX;
  private String nwY;
  private String nwZ;
  private String nxa;
  private int nxb;
  private int nxc;
  private com.tencent.mm.plugin.wallet_core.ui.m nxd;
  private long nxe;
  private int nxf;
  private int nxg;
  
  private void bwa()
  {
    if ((bk.getDouble(this.nwP.getText(), 0.0D) > 0.0D) && (!bk.bl(this.nwX)) && (!bk.bl(this.nwY)) && (!bk.bl(this.nxa)) && (!bk.bl(this.nwZ)))
    {
      this.frP.setEnabled(true);
      return;
    }
    y.i("MicroMsg.BankRemitMoneyInputUI", "disable btn: money: %s, seqNo: %s, tail: %s, bankType: %s, encrypt: %s", new Object[] { this.nwP.getText(), Boolean.valueOf(bk.bl(this.nwX)), Boolean.valueOf(bk.bl(this.nwY)), Boolean.valueOf(bk.bl(this.nxa)), Boolean.valueOf(bk.bl(this.nwZ)) });
    this.frP.setEnabled(false);
  }
  
  private void bwd()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!bk.bl(this.dkv))
    {
      localSpannableStringBuilder.append(j.b(this.mController.uMN, this.dkv));
      localSpannableStringBuilder.append(getString(a.i.bank_remit_remittance_desc_modify_text));
      localSpannableStringBuilder.setSpan(this.nxd, this.dkv.length(), localSpannableStringBuilder.length(), 34);
    }
    for (;;)
    {
      this.nwU.setText(localSpannableStringBuilder);
      return;
      localSpannableStringBuilder.append(getString(a.i.bank_remit_remittance_desc_text));
      localSpannableStringBuilder.setSpan(this.nxd, 0, localSpannableStringBuilder.length(), 18);
    }
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    if ((paramm instanceof com.tencent.mm.plugin.remittance.bankcard.a.n))
    {
      paramString = (com.tencent.mm.plugin.remittance.bankcard.a.n)paramm;
      paramString.a(new BankRemitMoneyInputUI.7(this, paramString)).b(new BankRemitMoneyInputUI.6(this, paramString)).c(new BankRemitMoneyInputUI.5(this));
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.bank_remit_money_input_ui;
  }
  
  protected final void initView()
  {
    this.lls = ((ScrollView)findViewById(a.f.root_view));
    this.nvv = ((CdnImageView)findViewById(a.f.brmi_bank_logo_iv));
    this.nvx = ((TextView)findViewById(a.f.brmi_bank_name_tv));
    this.nwO = ((TextView)findViewById(a.f.brmi_payee_tv));
    this.nwP = ((WalletFormView)findViewById(a.f.brmi_bank_money_input_tv));
    this.nwQ = ((LinearLayout)findViewById(a.f.brmi_fee_rate_layout));
    this.nwR = ((TextView)this.nwQ.findViewById(a.f.brmi_fee_rate_title_tv));
    this.nwS = ((TextView)this.nwQ.findViewById(a.f.brmi_fee_tv));
    this.nwT = ((TextView)this.nwQ.findViewById(a.f.brmi_total_money_tv));
    this.nwU = ((TextView)this.nwQ.findViewById(a.f.brmi_remit_desc_tv));
    this.frP = ((Button)findViewById(a.f.brmi_next_btn));
    String str = com.tencent.mm.plugin.remittance.bankcard.model.a.ev(new StringBuilder().append(this.nwV.nvf).toString(), "100") + "%";
    this.nwR.setText(getString(a.i.bank_remit_fee_rate_text, new Object[] { str }));
    this.nvv.setUrl(this.nwV.nve);
    this.nvx.setText(getString(a.i.bank_remit_select_payee_name_with_remark, new Object[] { this.nwV.lnT, this.nwY }));
    this.nwO.setText(this.nwW);
    this.nwP.setTitleText(ab.cML());
    e(this.nwP, 2, false);
    this.nwP.a(new BankRemitMoneyInputUI.1(this));
    this.nwU.setClickable(true);
    this.nwU.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m(this));
    this.nxd = new com.tencent.mm.plugin.wallet_core.ui.m(new BankRemitMoneyInputUI.8(this));
    bwd();
    this.frP.setOnClickListener(new BankRemitMoneyInputUI.3(this));
    bwa();
    this.lTH = new BankRemitMoneyInputUI.4(this);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1)
    {
      if (paramInt2 == -1)
      {
        y.i("MicroMsg.BankRemitMoneyInputUI", "goto detail");
        Object localObject = new Intent(this.mController.uMN, BankRemitDetailUI.class);
        ((Intent)localObject).putExtra("key_transfer_bill_id", this.nwB);
        ((Intent)localObject).putExtra("key_enter_scene", 0);
        startActivityForResult((Intent)localObject, 2);
        localObject = "";
        if (paramIntent != null) {
          localObject = paramIntent.getStringExtra("key_trans_id");
        }
        y.i("MicroMsg.BankRemitMoneyInputUI", "do business callback: %s, %s", new Object[] { this.nwB, localObject });
        a(new c(this.nwB, (String)localObject), false, false);
        return;
      }
      y.i("MicroMsg.BankRemitMoneyInputUI", "pay failed: %d", new Object[] { Integer.valueOf(paramInt2) });
      return;
    }
    if (paramInt1 == 2)
    {
      y.d("MicroMsg.BankRemitMoneyInputUI", "return from detail");
      paramIntent = new Intent();
      paramIntent.addFlags(67108864);
      d.b(this.mController.uMN, "offline", ".ui.WalletOfflineCoinPurseUI", paramIntent);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    czo();
    kh(1380);
    int j = ((Integer)g.DP().Dz().get(ac.a.uyw, Integer.valueOf(10))).intValue();
    int i = j;
    if (j < 0) {
      i = 10;
    }
    this.nxf = i;
    j = ((Integer)g.DP().Dz().get(ac.a.uyx, Integer.valueOf(5000000))).intValue();
    i = j;
    if (j <= 0) {
      i = 5000000;
    }
    this.nxg = i;
    y.i("MicroMsg.BankRemitMoneyInputUI", "minFee: %s, maxAmount: %s", new Object[] { Integer.valueOf(this.nxf), Integer.valueOf(this.nxg) });
    this.nwV = ((BankcardElemParcel)getIntent().getParcelableExtra("key_bank_card_elem_parcel"));
    this.nwW = getIntent().getStringExtra("key_payee_name");
    this.nwX = getIntent().getStringExtra("key_bank_card_seqno");
    this.nwY = getIntent().getStringExtra("key_bank_card_tailno");
    this.nwZ = getIntent().getStringExtra("key_encrypt_data");
    this.nxb = getIntent().getIntExtra("key_enter_time_scene", 0);
    this.nxc = getIntent().getIntExtra("key_input_type", 0);
    if (this.nwV == null)
    {
      y.w("MicroMsg.BankRemitMoneyInputUI", "bankcard elem is null");
      this.nwV = new BankcardElemParcel();
    }
    this.nxa = this.nwV.mOb;
    initView();
    setMMTitle(a.i.bank_remit_title);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitMoneyInputUI
 * JD-Core Version:    0.7.0.1
 */