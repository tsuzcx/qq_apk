package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.g;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private TextView Eui;
  private String GCu = "";
  private TextView Ipw;
  private dke Pmm;
  private LinearLayout Pmn;
  private LinearLayout Pmo;
  private LinearLayout Pmp;
  private LinearLayout Pmq;
  private LinearLayout Pmr;
  private LinearLayout Pms;
  private LinearLayout Pmt;
  private TextView Pmu;
  private TextView Pmv;
  private TextView Pmw;
  private TextView Pmx;
  private TextView qph;
  
  private void dBo()
  {
    AppMethodBeat.i(72068);
    if (this.Pmm == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!Util.isNullOrNil(this.Pmm.GIh))
    {
      this.Pmn.setVisibility(0);
      this.Pmu.setText(this.Pmm.GIh);
      label53:
      if (Util.isNullOrNil(this.Pmm.GIq)) {
        break label304;
      }
      this.Pmo.setVisibility(0);
      this.Pmv.setText(this.Pmm.GIq);
      label88:
      if (Util.isNullOrNil(this.Pmm.GIj)) {
        break label316;
      }
      this.Pmp.setVisibility(0);
      this.Pmw.setText(this.Pmm.GIj);
      label123:
      if (Util.isNullOrNil(this.Pmm.GIm)) {
        break label328;
      }
      this.Pmq.setVisibility(0);
      this.Ipw.setText(g.d(this.Pmm.TRD / 100.0D, this.Pmm.GIm));
      label173:
      if (this.Pmm.CreateTime < 0) {
        break label340;
      }
      this.Pmr.setVisibility(0);
      this.Eui.setText(g.uW(this.Pmm.CreateTime));
      label208:
      if (Util.isNullOrNil(this.Pmm.GIk)) {
        break label352;
      }
      this.Pms.setVisibility(0);
      this.qph.setText(this.Pmm.GIk);
    }
    for (;;)
    {
      switch (this.Pmm.GIo)
      {
      case 4: 
      default: 
        this.Pmx.setText(a.i.wallet_payu_detail_type_reserve);
        AppMethodBeat.o(72068);
        return;
        this.Pmn.setVisibility(8);
        break label53;
        label304:
        this.Pmo.setVisibility(8);
        break label88;
        label316:
        this.Pmp.setVisibility(8);
        break label123;
        label328:
        this.Pmq.setVisibility(8);
        break label173;
        label340:
        this.Pmr.setVisibility(8);
        break label208;
        label352:
        this.Pms.setVisibility(8);
      }
    }
    this.Pmx.setText(a.i.wallet_balance_manager_save);
    AppMethodBeat.o(72068);
    return;
    this.Pmx.setText(a.i.wallet_index_ui_transfer);
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
    this.GCu = getInput().getString("key_trans_id");
    if (Util.isNullOrNil(this.GCu))
    {
      Log.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.GCu));
    this.Pmn = ((LinearLayout)findViewById(a.f.detail_transid));
    this.Pmo = ((LinearLayout)findViewById(a.f.detail_appname));
    this.Pmp = ((LinearLayout)findViewById(a.f.detail_goodsname));
    this.Pmq = ((LinearLayout)findViewById(a.f.detail_moneyspent));
    this.Pmr = ((LinearLayout)findViewById(a.f.detail_time));
    this.Pms = ((LinearLayout)findViewById(a.f.detail_status));
    this.Pmt = ((LinearLayout)findViewById(a.f.detail_type));
    this.Pmu = ((TextView)findViewById(a.f.detail_transid_tv));
    this.Pmv = ((TextView)findViewById(a.f.detail_appname_tv));
    this.Pmw = ((TextView)findViewById(a.f.detail_goodsname_tv));
    this.Ipw = ((TextView)findViewById(a.f.detail_moneyspent_tv));
    this.Eui = ((TextView)findViewById(a.f.detail_time_tv));
    this.qph = ((TextView)findViewById(a.f.detail_status_tv));
    this.Pmx = ((TextView)findViewById(a.f.detail_type_tv));
    dBo();
    AppMethodBeat.o(72067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72070);
    super.onDestroy();
    removeSceneEndListener(1520);
    AppMethodBeat.o(72070);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(72069);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramq instanceof c))
      {
        this.Pmm = ((c)paramq).Pml;
        dBo();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI
 * JD-Core Version:    0.7.0.1
 */