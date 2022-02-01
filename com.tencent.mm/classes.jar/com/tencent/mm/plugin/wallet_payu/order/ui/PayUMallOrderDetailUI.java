package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eco;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.i;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private TextView KmP;
  private String MyF = "";
  private TextView OmP;
  private LinearLayout WdA;
  private LinearLayout WdB;
  private LinearLayout WdC;
  private LinearLayout WdD;
  private LinearLayout WdE;
  private LinearLayout WdF;
  private TextView WdG;
  private TextView WdH;
  private TextView WdI;
  private TextView WdJ;
  private eco Wdy;
  private LinearLayout Wdz;
  private TextView ttK;
  
  private void gAA()
  {
    AppMethodBeat.i(72068);
    if (this.Wdy == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!Util.isNullOrNil(this.Wdy.MEX))
    {
      this.Wdz.setVisibility(0);
      this.WdG.setText(this.Wdy.MEX);
      label53:
      if (Util.isNullOrNil(this.Wdy.MFg)) {
        break label304;
      }
      this.WdA.setVisibility(0);
      this.WdH.setText(this.Wdy.MFg);
      label88:
      if (Util.isNullOrNil(this.Wdy.MEZ)) {
        break label316;
      }
      this.WdB.setVisibility(0);
      this.WdI.setText(this.Wdy.MEZ);
      label123:
      if (Util.isNullOrNil(this.Wdy.MFc)) {
        break label328;
      }
      this.WdC.setVisibility(0);
      this.OmP.setText(i.e(this.Wdy.abic / 100.0D, this.Wdy.MFc));
      label173:
      if (this.Wdy.CreateTime < 0) {
        break label340;
      }
      this.WdD.setVisibility(0);
      this.KmP.setText(i.vh(this.Wdy.CreateTime));
      label208:
      if (Util.isNullOrNil(this.Wdy.MFa)) {
        break label352;
      }
      this.WdE.setVisibility(0);
      this.ttK.setText(this.Wdy.MFa);
    }
    for (;;)
    {
      switch (this.Wdy.MFe)
      {
      case 4: 
      default: 
        this.WdJ.setText(a.i.wallet_payu_detail_type_reserve);
        AppMethodBeat.o(72068);
        return;
        this.Wdz.setVisibility(8);
        break label53;
        label304:
        this.WdA.setVisibility(8);
        break label88;
        label316:
        this.WdB.setVisibility(8);
        break label123;
        label328:
        this.WdC.setVisibility(8);
        break label173;
        label340:
        this.WdD.setVisibility(8);
        break label208;
        label352:
        this.WdE.setVisibility(8);
      }
    }
    this.WdJ.setText(a.i.wallet_balance_manager_save);
    AppMethodBeat.o(72068);
    return;
    this.WdJ.setText(a.i.wallet_index_ui_transfer);
    AppMethodBeat.o(72068);
  }
  
  public int getLayoutId()
  {
    return a.g.payu_mall_order_info_detail;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72067);
    super.onCreate(paramBundle);
    addSceneEndListener(1520);
    this.MyF = getInput().getString("key_trans_id");
    if (Util.isNullOrNil(this.MyF))
    {
      Log.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.MyF));
    this.Wdz = ((LinearLayout)findViewById(a.f.detail_transid));
    this.WdA = ((LinearLayout)findViewById(a.f.detail_appname));
    this.WdB = ((LinearLayout)findViewById(a.f.detail_goodsname));
    this.WdC = ((LinearLayout)findViewById(a.f.detail_moneyspent));
    this.WdD = ((LinearLayout)findViewById(a.f.detail_time));
    this.WdE = ((LinearLayout)findViewById(a.f.detail_status));
    this.WdF = ((LinearLayout)findViewById(a.f.detail_type));
    this.WdG = ((TextView)findViewById(a.f.detail_transid_tv));
    this.WdH = ((TextView)findViewById(a.f.detail_appname_tv));
    this.WdI = ((TextView)findViewById(a.f.detail_goodsname_tv));
    this.OmP = ((TextView)findViewById(a.f.detail_moneyspent_tv));
    this.KmP = ((TextView)findViewById(a.f.detail_time_tv));
    this.ttK = ((TextView)findViewById(a.f.detail_status_tv));
    this.WdJ = ((TextView)findViewById(a.f.detail_type_tv));
    gAA();
    AppMethodBeat.o(72067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72070);
    super.onDestroy();
    removeSceneEndListener(1520);
    AppMethodBeat.o(72070);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(72069);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramp instanceof c))
      {
        this.Wdy = ((c)paramp).Wdx;
        gAA();
      }
      AppMethodBeat.o(72069);
      return true;
    }
    AppMethodBeat.o(72069);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI
 * JD-Core Version:    0.7.0.1
 */