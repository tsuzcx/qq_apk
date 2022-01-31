package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.c.bdv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private TextView gSp;
  private TextView lLL;
  private String mKL = "";
  private TextView nAN;
  private bdv qNF;
  private LinearLayout qNG;
  private LinearLayout qNH;
  private LinearLayout qNI;
  private LinearLayout qNJ;
  private LinearLayout qNK;
  private LinearLayout qNL;
  private LinearLayout qNM;
  private TextView qNN;
  private TextView qNO;
  private TextView qNP;
  private TextView qNQ;
  
  private void bXJ()
  {
    if (this.qNF == null) {
      return;
    }
    if (!bk.bl(this.qNF.mPI))
    {
      this.qNG.setVisibility(0);
      this.qNN.setText(this.qNF.mPI);
      label43:
      if (bk.bl(this.qNF.mPS)) {
        break label291;
      }
      this.qNH.setVisibility(0);
      this.qNO.setText(this.qNF.mPS);
      label78:
      if (bk.bl(this.qNF.mPK)) {
        break label303;
      }
      this.qNI.setVisibility(0);
      this.qNP.setText(this.qNF.mPK);
      label113:
      if (bk.bl(this.qNF.mPO)) {
        break label315;
      }
      this.qNJ.setVisibility(0);
      this.nAN.setText(e.d(this.qNF.tze / 100.0D, this.qNF.mPO));
      label163:
      if (this.qNF.mPL < 0) {
        break label327;
      }
      this.qNK.setVisibility(0);
      this.lLL.setText(e.hP(this.qNF.mPL));
      label198:
      if (bk.bl(this.qNF.mPM)) {
        break label339;
      }
      this.qNL.setVisibility(0);
      this.gSp.setText(this.qNF.mPM);
    }
    for (;;)
    {
      switch (this.qNF.mPQ)
      {
      case 4: 
      default: 
        this.qNQ.setText(a.i.wallet_payu_detail_type_reserve);
        return;
        this.qNG.setVisibility(8);
        break label43;
        label291:
        this.qNH.setVisibility(8);
        break label78;
        label303:
        this.qNI.setVisibility(8);
        break label113;
        label315:
        this.qNJ.setVisibility(8);
        break label163;
        label327:
        this.qNK.setVisibility(8);
        break label198;
        label339:
        this.qNL.setVisibility(8);
      }
    }
    this.qNQ.setText(a.i.wallet_balance_manager_save);
    return;
    this.qNQ.setText(a.i.wallet_index_ui_transfer);
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof c))
      {
        this.qNF = ((c)paramm).qNE;
        bXJ();
      }
      return true;
    }
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.payu_mall_order_info_detail;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    kh(1520);
    this.mKL = this.BX.getString("key_trans_id");
    if (bk.bl(this.mKL))
    {
      y.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    a(new c(this.mKL), true, true);
    this.qNG = ((LinearLayout)findViewById(a.f.detail_transid));
    this.qNH = ((LinearLayout)findViewById(a.f.detail_appname));
    this.qNI = ((LinearLayout)findViewById(a.f.detail_goodsname));
    this.qNJ = ((LinearLayout)findViewById(a.f.detail_moneyspent));
    this.qNK = ((LinearLayout)findViewById(a.f.detail_time));
    this.qNL = ((LinearLayout)findViewById(a.f.detail_status));
    this.qNM = ((LinearLayout)findViewById(a.f.detail_type));
    this.qNN = ((TextView)findViewById(a.f.detail_transid_tv));
    this.qNO = ((TextView)findViewById(a.f.detail_appname_tv));
    this.qNP = ((TextView)findViewById(a.f.detail_goodsname_tv));
    this.nAN = ((TextView)findViewById(a.f.detail_moneyspent_tv));
    this.lLL = ((TextView)findViewById(a.f.detail_time_tv));
    this.gSp = ((TextView)findViewById(a.f.detail_status_tv));
    this.qNQ = ((TextView)findViewById(a.f.detail_type_tv));
    bXJ();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ki(1520);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI
 * JD-Core Version:    0.7.0.1
 */