package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private cep BSo;
  private LinearLayout BSp;
  private LinearLayout BSq;
  private LinearLayout BSr;
  private LinearLayout BSs;
  private LinearLayout BSt;
  private LinearLayout BSu;
  private LinearLayout BSv;
  private TextView BSw;
  private TextView BSx;
  private TextView BSy;
  private TextView BSz;
  private TextView lzc;
  private TextView uhg;
  private String vsE = "";
  private TextView wNI;
  
  private void dps()
  {
    AppMethodBeat.i(72068);
    if (this.BSo == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!bs.isNullOrNil(this.BSo.vxU))
    {
      this.BSp.setVisibility(0);
      this.BSw.setText(this.BSo.vxU);
      label53:
      if (bs.isNullOrNil(this.BSo.vyd)) {
        break label303;
      }
      this.BSq.setVisibility(0);
      this.BSx.setText(this.BSo.vyd);
      label88:
      if (bs.isNullOrNil(this.BSo.vxW)) {
        break label315;
      }
      this.BSr.setVisibility(0);
      this.BSy.setText(this.BSo.vxW);
      label123:
      if (bs.isNullOrNil(this.BSo.vxZ)) {
        break label327;
      }
      this.BSs.setVisibility(0);
      this.wNI.setText(e.d(this.BSo.Ftl / 100.0D, this.BSo.vxZ));
      label173:
      if (this.BSo.CreateTime < 0) {
        break label339;
      }
      this.BSt.setVisibility(0);
      this.uhg.setText(e.nV(this.BSo.CreateTime));
      label208:
      if (bs.isNullOrNil(this.BSo.vxX)) {
        break label351;
      }
      this.BSu.setVisibility(0);
      this.lzc.setText(this.BSo.vxX);
    }
    for (;;)
    {
      switch (this.BSo.vyb)
      {
      case 4: 
      default: 
        this.BSz.setText(2131765712);
        AppMethodBeat.o(72068);
        return;
        this.BSp.setVisibility(8);
        break label53;
        label303:
        this.BSq.setVisibility(8);
        break label88;
        label315:
        this.BSr.setVisibility(8);
        break label123;
        label327:
        this.BSs.setVisibility(8);
        break label173;
        label339:
        this.BSt.setVisibility(8);
        break label208;
        label351:
        this.BSu.setVisibility(8);
      }
    }
    this.BSz.setText(2131765007);
    AppMethodBeat.o(72068);
    return;
    this.BSz.setText(2131765318);
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
    this.vsE = getInput().getString("key_trans_id");
    if (bs.isNullOrNil(this.vsE))
    {
      ac.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.vsE));
    this.BSp = ((LinearLayout)findViewById(2131299059));
    this.BSq = ((LinearLayout)findViewById(2131299036));
    this.BSr = ((LinearLayout)findViewById(2131299044));
    this.BSs = ((LinearLayout)findViewById(2131299050));
    this.BSt = ((LinearLayout)findViewById(2131299057));
    this.BSu = ((LinearLayout)findViewById(2131299052));
    this.BSv = ((LinearLayout)findViewById(2131299062));
    this.BSw = ((TextView)findViewById(2131299060));
    this.BSx = ((TextView)findViewById(2131299037));
    this.BSy = ((TextView)findViewById(2131299045));
    this.wNI = ((TextView)findViewById(2131299051));
    this.uhg = ((TextView)findViewById(2131299058));
    this.lzc = ((TextView)findViewById(2131299053));
    this.BSz = ((TextView)findViewById(2131299063));
    dps();
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
        this.BSo = ((c)paramn).BSn;
        dps();
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