package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private TextView iuP;
  private TextView ojf;
  private String plc = "";
  private TextView qmv;
  private blp uCM;
  private LinearLayout uCN;
  private LinearLayout uCO;
  private LinearLayout uCP;
  private LinearLayout uCQ;
  private LinearLayout uCR;
  private LinearLayout uCS;
  private LinearLayout uCT;
  private TextView uCU;
  private TextView uCV;
  private TextView uCW;
  private TextView uCX;
  
  private void cbv()
  {
    AppMethodBeat.i(48427);
    if (this.uCM == null)
    {
      AppMethodBeat.o(48427);
      return;
    }
    if (!bo.isNullOrNil(this.uCM.ppY))
    {
      this.uCN.setVisibility(0);
      this.uCU.setText(this.uCM.ppY);
      label53:
      if (bo.isNullOrNil(this.uCM.pqh)) {
        break label303;
      }
      this.uCO.setVisibility(0);
      this.uCV.setText(this.uCM.pqh);
      label88:
      if (bo.isNullOrNil(this.uCM.pqa)) {
        break label315;
      }
      this.uCP.setVisibility(0);
      this.uCW.setText(this.uCM.pqa);
      label123:
      if (bo.isNullOrNil(this.uCM.pqd)) {
        break label327;
      }
      this.uCQ.setVisibility(0);
      this.qmv.setText(e.e(this.uCM.xAm / 100.0D, this.uCM.pqd));
      label173:
      if (this.uCM.CreateTime < 0) {
        break label339;
      }
      this.uCR.setVisibility(0);
      this.ojf.setText(e.kB(this.uCM.CreateTime));
      label208:
      if (bo.isNullOrNil(this.uCM.pqb)) {
        break label351;
      }
      this.uCS.setVisibility(0);
      this.iuP.setText(this.uCM.pqb);
    }
    for (;;)
    {
      switch (this.uCM.pqf)
      {
      case 4: 
      default: 
        this.uCX.setText(2131305497);
        AppMethodBeat.o(48427);
        return;
        this.uCN.setVisibility(8);
        break label53;
        label303:
        this.uCO.setVisibility(8);
        break label88;
        label315:
        this.uCP.setVisibility(8);
        break label123;
        label327:
        this.uCQ.setVisibility(8);
        break label173;
        label339:
        this.uCR.setVisibility(8);
        break label208;
        label351:
        this.uCS.setVisibility(8);
      }
    }
    this.uCX.setText(2131304823);
    AppMethodBeat.o(48427);
    return;
    this.uCX.setText(2131305126);
    AppMethodBeat.o(48427);
  }
  
  public int getLayoutId()
  {
    return 2130970406;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(48426);
    super.onCreate(paramBundle);
    addSceneEndListener(1520);
    this.plc = getInput().getString("key_trans_id");
    if (bo.isNullOrNil(this.plc))
    {
      ab.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.plc));
    this.uCN = ((LinearLayout)findViewById(2131826679));
    this.uCO = ((LinearLayout)findViewById(2131826681));
    this.uCP = ((LinearLayout)findViewById(2131826683));
    this.uCQ = ((LinearLayout)findViewById(2131826685));
    this.uCR = ((LinearLayout)findViewById(2131826691));
    this.uCS = ((LinearLayout)findViewById(2131826687));
    this.uCT = ((LinearLayout)findViewById(2131826689));
    this.uCU = ((TextView)findViewById(2131826680));
    this.uCV = ((TextView)findViewById(2131826682));
    this.uCW = ((TextView)findViewById(2131826684));
    this.qmv = ((TextView)findViewById(2131826686));
    this.ojf = ((TextView)findViewById(2131826692));
    this.iuP = ((TextView)findViewById(2131826688));
    this.uCX = ((TextView)findViewById(2131826690));
    cbv();
    AppMethodBeat.o(48426);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(48429);
    super.onDestroy();
    removeSceneEndListener(1520);
    AppMethodBeat.o(48429);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(48428);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if ((paramm instanceof c))
      {
        this.uCM = ((c)paramm).uCL;
        cbv();
      }
      AppMethodBeat.o(48428);
      return true;
    }
    AppMethodBeat.o(48428);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.order.ui.PayUMallOrderDetailUI
 * JD-Core Version:    0.7.0.1
 */