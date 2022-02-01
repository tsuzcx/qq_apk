package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private cjo DsH;
  private LinearLayout DsI;
  private LinearLayout DsJ;
  private LinearLayout DsK;
  private LinearLayout DsL;
  private LinearLayout DsM;
  private LinearLayout DsN;
  private LinearLayout DsO;
  private TextView DsP;
  private TextView DsQ;
  private TextView DsR;
  private TextView DsS;
  private TextView lYA;
  private TextView vjQ;
  private String wxW = "";
  private TextView ybq;
  
  private void dzU()
  {
    AppMethodBeat.i(72068);
    if (this.DsH == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!bt.isNullOrNil(this.DsH.wDo))
    {
      this.DsI.setVisibility(0);
      this.DsP.setText(this.DsH.wDo);
      label53:
      if (bt.isNullOrNil(this.DsH.wDx)) {
        break label303;
      }
      this.DsJ.setVisibility(0);
      this.DsQ.setText(this.DsH.wDx);
      label88:
      if (bt.isNullOrNil(this.DsH.wDq)) {
        break label315;
      }
      this.DsK.setVisibility(0);
      this.DsR.setText(this.DsH.wDq);
      label123:
      if (bt.isNullOrNil(this.DsH.wDt)) {
        break label327;
      }
      this.DsL.setVisibility(0);
      this.ybq.setText(e.d(this.DsH.Hdr / 100.0D, this.DsH.wDt));
      label173:
      if (this.DsH.CreateTime < 0) {
        break label339;
      }
      this.DsM.setVisibility(0);
      this.vjQ.setText(e.ov(this.DsH.CreateTime));
      label208:
      if (bt.isNullOrNil(this.DsH.wDr)) {
        break label351;
      }
      this.DsN.setVisibility(0);
      this.lYA.setText(this.DsH.wDr);
    }
    for (;;)
    {
      switch (this.DsH.wDv)
      {
      case 4: 
      default: 
        this.DsS.setText(2131765712);
        AppMethodBeat.o(72068);
        return;
        this.DsI.setVisibility(8);
        break label53;
        label303:
        this.DsJ.setVisibility(8);
        break label88;
        label315:
        this.DsK.setVisibility(8);
        break label123;
        label327:
        this.DsL.setVisibility(8);
        break label173;
        label339:
        this.DsM.setVisibility(8);
        break label208;
        label351:
        this.DsN.setVisibility(8);
      }
    }
    this.DsS.setText(2131765007);
    AppMethodBeat.o(72068);
    return;
    this.DsS.setText(2131765318);
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
    this.wxW = getInput().getString("key_trans_id");
    if (bt.isNullOrNil(this.wxW))
    {
      ad.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.wxW));
    this.DsI = ((LinearLayout)findViewById(2131299059));
    this.DsJ = ((LinearLayout)findViewById(2131299036));
    this.DsK = ((LinearLayout)findViewById(2131299044));
    this.DsL = ((LinearLayout)findViewById(2131299050));
    this.DsM = ((LinearLayout)findViewById(2131299057));
    this.DsN = ((LinearLayout)findViewById(2131299052));
    this.DsO = ((LinearLayout)findViewById(2131299062));
    this.DsP = ((TextView)findViewById(2131299060));
    this.DsQ = ((TextView)findViewById(2131299037));
    this.DsR = ((TextView)findViewById(2131299045));
    this.ybq = ((TextView)findViewById(2131299051));
    this.vjQ = ((TextView)findViewById(2131299058));
    this.lYA = ((TextView)findViewById(2131299053));
    this.DsS = ((TextView)findViewById(2131299063));
    dzU();
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
        this.DsH = ((c)paramn).DsG;
        dzU();
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