package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.bzr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private TextView AAa;
  private TextView AAb;
  private TextView AAc;
  private TextView AAd;
  private bzr AzS;
  private LinearLayout AzT;
  private LinearLayout AzU;
  private LinearLayout AzV;
  private LinearLayout AzW;
  private LinearLayout AzX;
  private LinearLayout AzY;
  private LinearLayout AzZ;
  private TextView kXs;
  private TextView sYS;
  private String ujI = "";
  private TextView vDD;
  
  private void dbK()
  {
    AppMethodBeat.i(72068);
    if (this.AzS == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!bt.isNullOrNil(this.AzS.uoY))
    {
      this.AzT.setVisibility(0);
      this.AAa.setText(this.AzS.uoY);
      label53:
      if (bt.isNullOrNil(this.AzS.uph)) {
        break label303;
      }
      this.AzU.setVisibility(0);
      this.AAb.setText(this.AzS.uph);
      label88:
      if (bt.isNullOrNil(this.AzS.upa)) {
        break label315;
      }
      this.AzV.setVisibility(0);
      this.AAc.setText(this.AzS.upa);
      label123:
      if (bt.isNullOrNil(this.AzS.upd)) {
        break label327;
      }
      this.AzW.setVisibility(0);
      this.vDD.setText(e.d(this.AzS.DWt / 100.0D, this.AzS.upd));
      label173:
      if (this.AzS.CreateTime < 0) {
        break label339;
      }
      this.AzX.setVisibility(0);
      this.sYS.setText(e.nh(this.AzS.CreateTime));
      label208:
      if (bt.isNullOrNil(this.AzS.upb)) {
        break label351;
      }
      this.AzY.setVisibility(0);
      this.kXs.setText(this.AzS.upb);
    }
    for (;;)
    {
      switch (this.AzS.upf)
      {
      case 4: 
      default: 
        this.AAd.setText(2131765712);
        AppMethodBeat.o(72068);
        return;
        this.AzT.setVisibility(8);
        break label53;
        label303:
        this.AzU.setVisibility(8);
        break label88;
        label315:
        this.AzV.setVisibility(8);
        break label123;
        label327:
        this.AzW.setVisibility(8);
        break label173;
        label339:
        this.AzX.setVisibility(8);
        break label208;
        label351:
        this.AzY.setVisibility(8);
      }
    }
    this.AAd.setText(2131765007);
    AppMethodBeat.o(72068);
    return;
    this.AAd.setText(2131765318);
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
    this.ujI = getInput().getString("key_trans_id");
    if (bt.isNullOrNil(this.ujI))
    {
      ad.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.ujI));
    this.AzT = ((LinearLayout)findViewById(2131299059));
    this.AzU = ((LinearLayout)findViewById(2131299036));
    this.AzV = ((LinearLayout)findViewById(2131299044));
    this.AzW = ((LinearLayout)findViewById(2131299050));
    this.AzX = ((LinearLayout)findViewById(2131299057));
    this.AzY = ((LinearLayout)findViewById(2131299052));
    this.AzZ = ((LinearLayout)findViewById(2131299062));
    this.AAa = ((TextView)findViewById(2131299060));
    this.AAb = ((TextView)findViewById(2131299037));
    this.AAc = ((TextView)findViewById(2131299045));
    this.vDD = ((TextView)findViewById(2131299051));
    this.sYS = ((TextView)findViewById(2131299058));
    this.kXs = ((TextView)findViewById(2131299053));
    this.AAd = ((TextView)findViewById(2131299063));
    dbK();
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
        this.AzS = ((c)paramn).AzR;
        dbK();
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