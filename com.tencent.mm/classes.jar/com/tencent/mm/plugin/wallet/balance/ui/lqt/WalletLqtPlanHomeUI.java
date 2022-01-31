package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.n;
import com.tencent.mm.plugin.wallet.balance.a.a.w;
import com.tencent.mm.plugin.wallet.balance.a.a.w.a;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
import java.util.ArrayList;
import java.util.List;

public class WalletLqtPlanHomeUI
  extends WalletLqtBasePresenterUI
{
  private ViewGroup kyN;
  private ListView tQI;
  private TextView tQJ;
  private TextView tQK;
  private LinearLayout tQL;
  private Button tQM;
  private RelativeLayout tQN;
  private LinearLayout tQO;
  private TextView tQP;
  private w tQQ;
  private WalletLqtPlanHomeUI.a tQR;
  private List<bmo> tQS;
  private int tQT;
  private int tQU;
  
  public WalletLqtPlanHomeUI()
  {
    AppMethodBeat.i(45622);
    this.tQQ = ((w)P(w.class));
    this.tQR = new WalletLqtPlanHomeUI.a(this, (byte)0);
    this.tQS = new ArrayList();
    AppMethodBeat.o(45622);
  }
  
  private void nq(boolean paramBoolean)
  {
    AppMethodBeat.i(45627);
    n localn = new n();
    localn.b(new com.tencent.mm.plugin.wallet.balance.a.a.g());
    localn.a(new WalletLqtPlanHomeUI.7(this, paramBoolean));
    AppMethodBeat.o(45627);
  }
  
  public int getLayoutId()
  {
    return 2130970009;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45626);
    this.tQI = ((ListView)findViewById(2131825512));
    this.tQJ = ((TextView)findViewById(2131825515));
    this.tQK = ((TextView)findViewById(2131825516));
    this.tQL = ((LinearLayout)findViewById(2131825514));
    this.tQM = ((Button)findViewById(2131825517));
    this.tQN = ((RelativeLayout)findViewById(2131825513));
    this.tQO = ((LinearLayout)findViewById(2131825518));
    this.tQP = ((TextView)findViewById(2131825519));
    this.tQR = new WalletLqtPlanHomeUI.a(this, (byte)0);
    this.tQI.setAdapter(this.tQR);
    this.kyN = ((ViewGroup)LayoutInflater.from(this).inflate(2130970008, this.tQI, false));
    this.kyN.setOnClickListener(new WalletLqtPlanHomeUI.3(this));
    this.tQI.addFooterView(this.kyN);
    this.tQM.setOnClickListener(new WalletLqtPlanHomeUI.1(this));
    this.tQI.setOnItemClickListener(new WalletLqtPlanHomeUI.2(this));
    AppMethodBeat.o(45626);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(45625);
    ab.i("MicroMsg.WalletLqtPlanHomeUI", "activity result: %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(45625);
      return;
      if (paramInt2 == -1)
      {
        String str = paramIntent.getStringExtra("encrypt_pwd");
        int i = this.tQT;
        int j = this.tQU;
        Dialog localDialog = com.tencent.mm.wallet_core.ui.g.c(getContext(), false, null);
        w.a locala = this.tQQ.tMW;
        f.h(Integer.valueOf(i), Integer.valueOf(j), str).c(locala).f(new WalletLqtPlanHomeUI.9(this, localDialog)).a(new WalletLqtPlanHomeUI.8(this, localDialog));
        continue;
        if (paramInt2 == -1) {
          nq(false);
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45623);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    initView();
    nq(true);
    AppMethodBeat.o(45623);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtPlanHomeUI
 * JD-Core Version:    0.7.0.1
 */