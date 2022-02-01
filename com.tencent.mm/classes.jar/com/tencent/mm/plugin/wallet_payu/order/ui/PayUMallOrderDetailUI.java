package com.tencent.mm.plugin.wallet_payu.order.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet_payu.order.a.c;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class PayUMallOrderDetailUI
  extends WalletBaseUI
{
  private String AJn = "";
  private TextView CrY;
  private daq ItC;
  private LinearLayout ItD;
  private LinearLayout ItE;
  private LinearLayout ItF;
  private LinearLayout ItG;
  private LinearLayout ItH;
  private LinearLayout ItI;
  private LinearLayout ItJ;
  private TextView ItK;
  private TextView ItL;
  private TextView ItM;
  private TextView ItN;
  private TextView nnA;
  private TextView yQj;
  
  private void eDD()
  {
    AppMethodBeat.i(72068);
    if (this.ItC == null)
    {
      AppMethodBeat.o(72068);
      return;
    }
    if (!Util.isNullOrNil(this.ItC.AOT))
    {
      this.ItD.setVisibility(0);
      this.ItK.setText(this.ItC.AOT);
      label53:
      if (Util.isNullOrNil(this.ItC.APc)) {
        break label303;
      }
      this.ItE.setVisibility(0);
      this.ItL.setText(this.ItC.APc);
      label88:
      if (Util.isNullOrNil(this.ItC.AOV)) {
        break label315;
      }
      this.ItF.setVisibility(0);
      this.ItM.setText(this.ItC.AOV);
      label123:
      if (Util.isNullOrNil(this.ItC.AOY)) {
        break label327;
      }
      this.ItG.setVisibility(0);
      this.CrY.setText(f.d(this.ItC.MFR / 100.0D, this.ItC.AOY));
      label173:
      if (this.ItC.CreateTime < 0) {
        break label339;
      }
      this.ItH.setVisibility(0);
      this.yQj.setText(f.rZ(this.ItC.CreateTime));
      label208:
      if (Util.isNullOrNil(this.ItC.AOW)) {
        break label351;
      }
      this.ItI.setVisibility(0);
      this.nnA.setText(this.ItC.AOW);
    }
    for (;;)
    {
      switch (this.ItC.APa)
      {
      case 4: 
      default: 
        this.ItN.setText(2131768165);
        AppMethodBeat.o(72068);
        return;
        this.ItD.setVisibility(8);
        break label53;
        label303:
        this.ItE.setVisibility(8);
        break label88;
        label315:
        this.ItF.setVisibility(8);
        break label123;
        label327:
        this.ItG.setVisibility(8);
        break label173;
        label339:
        this.ItH.setVisibility(8);
        break label208;
        label351:
        this.ItI.setVisibility(8);
      }
    }
    this.ItN.setText(2131767450);
    AppMethodBeat.o(72068);
    return;
    this.ItN.setText(2131767761);
    AppMethodBeat.o(72068);
  }
  
  public int getLayoutId()
  {
    return 2131495907;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(72067);
    super.onCreate(paramBundle);
    addSceneEndListener(1520);
    this.AJn = getInput().getString("key_trans_id");
    if (Util.isNullOrNil(this.AJn))
    {
      Log.e("MicroMsg.PayUMallOrderDetailUI", "hy: trans id is null");
      finish();
    }
    doSceneProgress(new c(this.AJn));
    this.ItD = ((LinearLayout)findViewById(2131299565));
    this.ItE = ((LinearLayout)findViewById(2131299539));
    this.ItF = ((LinearLayout)findViewById(2131299550));
    this.ItG = ((LinearLayout)findViewById(2131299556));
    this.ItH = ((LinearLayout)findViewById(2131299563));
    this.ItI = ((LinearLayout)findViewById(2131299558));
    this.ItJ = ((LinearLayout)findViewById(2131299568));
    this.ItK = ((TextView)findViewById(2131299566));
    this.ItL = ((TextView)findViewById(2131299540));
    this.ItM = ((TextView)findViewById(2131299551));
    this.CrY = ((TextView)findViewById(2131299557));
    this.yQj = ((TextView)findViewById(2131299564));
    this.nnA = ((TextView)findViewById(2131299559));
    this.ItN = ((TextView)findViewById(2131299569));
    eDD();
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
        this.ItC = ((c)paramq).ItB;
        eDD();
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