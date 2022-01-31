package com.tencent.mm.plugin.wallet_payu.bind.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_payu.a.c;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery;
import com.tencent.mm.plugin.wallet_payu.bind.model.NetScenePayUElementQuery.PayUBankcardElement;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.wallet_core.c.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.HashMap;
import java.util.HashSet;

@com.tencent.mm.ui.base.a(19)
public class WalletPayUCardElementUI
  extends WalletBaseUI
  implements WalletFormView.a
{
  private Button frP;
  private WalletFormView qMN;
  WalletFormView qMO;
  private WalletFormView qMP;
  private TextView qMQ;
  private TextView qMR;
  private TextView qMS;
  private WalletPayUCardElementUI.b qMT;
  private boolean qMU = false;
  private boolean qMV = false;
  private boolean qMW = false;
  private HashMap<String, NetScenePayUElementQuery.PayUBankcardElement> qMX = null;
  private HashSet<String> qMY = null;
  
  protected final boolean bTZ()
  {
    return true;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((paramm instanceof NetScenePayUElementQuery))
    {
      this.qMX.put(((NetScenePayUElementQuery)paramm).qMF, (NetScenePayUElementQuery.PayUBankcardElement)this.BX.getParcelable("key_card_element"));
      this.qMT.bXF();
      this.qMY.remove(((NetScenePayUElementQuery)paramm).qMF);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!(paramm instanceof com.tencent.mm.plugin.wallet_payu.bind.model.a));
      if (paramInt1 != 0) {
        break;
      }
      bool1 = bool2;
    } while (paramInt2 == 0);
    this.qMN.setEncryptType(0);
    return false;
  }
  
  public final void gG(boolean paramBoolean) {}
  
  protected final int getLayoutId()
  {
    return a.g.payu_ui_card_element;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qMT = new WalletPayUCardElementUI.b(this);
    this.qMX = new HashMap();
    this.qMY = new HashSet();
    this.qMN = ((WalletFormView)findViewById(a.f.card_num_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this.qMN);
    this.qMO = ((WalletFormView)findViewById(a.f.date_et));
    com.tencent.mm.wallet_core.ui.formview.a.a(this, this.qMO);
    this.qMP = ((WalletFormView)findViewById(a.f.cvv_et));
    com.tencent.mm.wallet_core.ui.formview.a.b(this, this.qMP);
    this.qMQ = ((TextView)findViewById(a.f.wallet_card_num_err_tipmsg));
    this.qMR = ((TextView)findViewById(a.f.wallet_card_cvv_err_tipmsg));
    this.frP = ((Button)findViewById(a.f.next_btn));
    e(this.qMN, 0, false);
    e(this.qMP, 0, false);
    this.qMN.setOnInputValidChangeListener(this);
    this.qMP.setOnInputValidChangeListener(this);
    this.qMO.setOnInputValidChangeListener(this);
    this.qMN.setEncryptType(0);
    this.qMP.a(new WalletPayUCardElementUI.1(this));
    this.qMO.a(new WalletPayUCardElementUI.2(this));
    this.qMN.a(new WalletPayUCardElementUI.3(this));
    this.frP.setOnClickListener(new WalletPayUCardElementUI.4(this));
    ((TextView)findViewById(a.f.wallet_power_by_tenpay)).setText(ab.cMK());
    this.qMS = ((TextView)findViewById(a.f.start_introduction_tv));
    c.a(this, this.qMS);
  }
  
  public void onResume()
  {
    super.onResume();
    this.qMT.bXF();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_payu.bind.ui.WalletPayUCardElementUI
 * JD-Core Version:    0.7.0.1
 */