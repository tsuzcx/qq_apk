package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private cki DKm;
  private LinearLayout DKn;
  private LinearLayout DKo;
  private LinearLayout DKp;
  private LinearLayout DKq;
  private LinearLayout DKr;
  private LinearLayout DKs;
  private LinearLayout DKt;
  private TextView DKu;
  private TextView DKv;
  private TextView DKw;
  private TextView DKx;
  private TextView mdh;
  private TextView vvV;
  private String wNH = "";
  private TextView yrh;
  
  private void dDl()
  {
    AppMethodBeat.i(72068);
    if (this.DKm == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!bu.isNullOrNil(this.DKm.wSZ))
    {
      this.DKn.setVisibility(0);
      this.DKu.setText(this.DKm.wSZ);
      label53:
      if (bu.isNullOrNil(this.DKm.wTi)) {
        break label303;
      }
      this.DKo.setVisibility(0);
      this.DKv.setText(this.DKm.wTi);
      label88:
      if (bu.isNullOrNil(this.DKm.wTb)) {
        break label315;
      }
      this.DKp.setVisibility(0);
      this.DKw.setText(this.DKm.wTb);
      label123:
      if (bu.isNullOrNil(this.DKm.wTe)) {
        break label327;
      }
      this.DKq.setVisibility(0);
      this.yrh.setText(f.d(this.DKm.HwR / 100.0D, this.DKm.wTe));
      label173:
      if (this.DKm.CreateTime < 0) {
        break label339;
      }
      this.DKr.setVisibility(0);
      this.vvV.setText(f.oy(this.DKm.CreateTime));
      label208:
      if (bu.isNullOrNil(this.DKm.wTc)) {
        break label351;
      }
      this.DKs.setVisibility(0);
      this.mdh.setText(this.DKm.wTc);
    }
    for (;;)
    {
      switch (this.DKm.wTg)
      {
      case 4: 
      default: 
        this.DKx.setText(2131765712);
        AppMethodBeat.o(72068);
        return;
        this.DKn.setVisibility(8);
        break label53;
        label303:
        this.DKo.setVisibility(8);
        break label88;
        label315:
        this.DKp.setVisibility(8);
        break label123;
        label327:
        this.DKq.setVisibility(8);
        break label173;
        label339:
        this.DKr.setVisibility(8);
        break label208;
        label351:
        this.DKs.setVisibility(8);
      }
    }
    this.DKx.setText(2131765007);
    AppMethodBeat.o(72068);
    return;
    this.DKx.setText(2131765318);
    AppMethodBeat.o(72068);
  }
  
  public int getLayoutId()
  {
    return 2131495070;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72067);
    super.onCreate(paramBundle);
    addSceneEndListener(1520);
    this.wNH = getInput().getString("key_trans_id");
    if (bu.isNullOrNil(this.wNH))
    {
      ae.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.wNH));
    this.DKn = ((LinearLayout)findViewById(2131299059));
    this.DKo = ((LinearLayout)findViewById(2131299036));
    this.DKp = ((LinearLayout)findViewById(2131299044));
    this.DKq = ((LinearLayout)findViewById(2131299050));
    this.DKr = ((LinearLayout)findViewById(2131299057));
    this.DKs = ((LinearLayout)findViewById(2131299052));
    this.DKt = ((LinearLayout)findViewById(2131299062));
    this.DKu = ((TextView)findViewById(2131299060));
    this.DKv = ((TextView)findViewById(2131299037));
    this.DKw = ((TextView)findViewById(2131299045));
    this.yrh = ((TextView)findViewById(2131299051));
    this.vvV = ((TextView)findViewById(2131299058));
    this.mdh = ((TextView)findViewById(2131299053));
    this.DKx = ((TextView)findViewById(2131299063));
    dDl();
    AppMethodBeat.o(72067);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(72070);
    super.onDestroy();
    removeSceneEndListener(1520);
    AppMethodBeat.o(72070);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(72069);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramn instanceof c))
      {
        this.DKm = ((c)paramn).DKl;
        dDl();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI
 * JD-Core Version:    0.7.0.1
 */