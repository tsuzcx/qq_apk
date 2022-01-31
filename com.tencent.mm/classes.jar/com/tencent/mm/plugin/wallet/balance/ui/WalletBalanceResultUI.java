package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vf;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.c;
import com.tencent.mm.plugin.wallet.balance.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.d.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBalanceResultUI
  extends WalletBaseUI
{
  protected Button gJr;
  protected TextView ojf;
  protected TextView qgt;
  protected Orders qrf;
  protected TextView soT;
  protected TextView tON;
  protected TextView tOO;
  protected CheckBox tOP;
  protected Bankcard tOQ;
  
  private void cRh()
  {
    AppMethodBeat.i(45463);
    if (this.tOP.getVisibility() == 0)
    {
      if (this.tOP.isChecked()) {}
      for (String str1 = "0";; str1 = "1")
      {
        int i = getInput().getInt("key_pay_flag", 0);
        String str2 = getInput().getString("key_pwd1");
        String str3 = getInput().getString("key_verify_code");
        PayInfo localPayInfo = (PayInfo)getInput().getParcelable("key_pay_info");
        if (localPayInfo != null) {
          doSceneProgress(new c(i, str2, str3, localPayInfo.cnI, localPayInfo.cCD, str1));
        }
        AppMethodBeat.o(45463);
        return;
      }
    }
    next();
    AppMethodBeat.o(45463);
  }
  
  protected void bJ()
  {
    AppMethodBeat.i(45464);
    if (this.qrf != null)
    {
      this.tON.setText(e.e(this.qrf.cnL, this.qrf.ppp));
      Object localObject;
      if ((this.qrf.ujl != null) && (this.qrf.ujl.size() > 0))
      {
        localObject = (Orders.Commodity)this.qrf.ujl.get(0);
        if (bo.isNullOrNil(((Orders.Commodity)localObject).ujO)) {
          break label207;
        }
        this.qgt.setText(((Orders.Commodity)localObject).ppn + " " + getString(2131305466) + ((Orders.Commodity)localObject).ujO);
      }
      while ((getProcess() instanceof b)) {
        if (this.qrf.qjD > 0.0D)
        {
          findViewById(2131828971).setVisibility(0);
          localObject = (TextView)findViewById(2131828972);
          ((TextView)localObject).setText(e.e(this.qrf.qjD, this.qrf.ppp));
          ((TextView)localObject).setVisibility(0);
          AppMethodBeat.o(45464);
          return;
          label207:
          this.qgt.setText(((Orders.Commodity)localObject).ppn);
        }
        else
        {
          ab.i("MicroMsg.WalletBalanceResultUI", "fetch_fee is 0");
        }
      }
    }
    AppMethodBeat.o(45464);
  }
  
  public int getLayoutId()
  {
    return 2130971132;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45462);
    setMMTitle((String)getNetController().getTips(0));
    this.soT = ((TextView)findViewById(2131828964));
    this.soT.setText(getNetController().getTips(1));
    this.tOO = ((TextView)findViewById(2131828965));
    this.ojf = ((TextView)findViewById(2131828966));
    Object localObject = getNetController().getTips(2);
    if (!bo.aa((CharSequence)localObject))
    {
      this.tOO.setVisibility(0);
      this.ojf.setVisibility(0);
      this.ojf.setText((CharSequence)localObject);
      localObject = (ImageView)findViewById(2131828963);
      int i = getInput().getInt("key_balance_result_logo", -1);
      if (i <= 0) {
        break label324;
      }
      ((ImageView)localObject).setImageResource(i);
      label149:
      this.qgt = ((TextView)findViewById(2131828968));
      this.tON = ((TextView)findViewById(2131828970));
      localObject = (TextView)findViewById(2131828969);
      if ((getProcess() instanceof b)) {
        ((TextView)localObject).setText(getString(2131304837));
      }
      this.tOP = ((CheckBox)findViewById(2131828973));
      this.tOQ = ((Bankcard)getInput().getParcelable("key_bankcard"));
      if (this.tOQ == null) {
        break label334;
      }
      this.tOP.setVisibility(8);
    }
    for (;;)
    {
      this.gJr = ((Button)findViewById(2131822914));
      this.gJr.setOnClickListener(new WalletBalanceResultUI.1(this));
      setBackBtn(new WalletBalanceResultUI.2(this));
      AppMethodBeat.o(45462);
      return;
      this.tOO.setVisibility(8);
      this.ojf.setVisibility(8);
      break;
      label324:
      ((ImageView)localObject).setImageResource(2131231923);
      break label149;
      label334:
      this.tOP.setVisibility(0);
    }
  }
  
  public void next()
  {
    AppMethodBeat.i(45465);
    if (!getNetController().p(new Object[] { this.qrf })) {
      super.next();
    }
    AppMethodBeat.o(45465);
  }
  
  public void onBackPressed() {}
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45461);
    super.onCreate(paramBundle);
    this.qrf = ((Orders)getInput().getParcelable("key_orders"));
    initView();
    bJ();
    AppMethodBeat.o(45461);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(45466);
    if ((paramm instanceof c))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        s.cRG();
        s.cRH().ulU = bo.aox();
        paramString = new vf();
        paramString.cLJ.scene = 15;
        paramString.callback = new WalletBalanceResultUI.4(this);
        com.tencent.mm.sdk.b.a.ymk.l(paramString);
      }
      next();
      AppMethodBeat.o(45466);
      return true;
    }
    AppMethodBeat.o(45466);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceResultUI
 * JD-Core Version:    0.7.0.1
 */