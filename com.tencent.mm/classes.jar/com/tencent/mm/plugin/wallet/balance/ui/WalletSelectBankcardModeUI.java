package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private int drX = 0;
  private ArrayList<WalletSelectBankcardModeUI.a> mData = new ArrayList();
  private ListView mQH;
  private int qgC = 0;
  private int qgG = -1;
  private ArrayList<Bankcard> qgr;
  private Bankcard qgs;
  private String qgt;
  private TextView qhC;
  private WalletSelectBankcardModeUI.b qhD;
  
  public final boolean bgK()
  {
    return false;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_select_bank_card_mode_ui;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.wallet_bancard_list_dialog_title);
    setBackBtn(new WalletSelectBankcardModeUI.1(this));
    this.qhC = ((TextView)findViewById(a.f.wallet_select_tips));
    Object localObject;
    label200:
    int i;
    label254:
    Bankcard localBankcard;
    WalletSelectBankcardModeUI.a locala;
    if (this.drX == 0)
    {
      this.qhC.setText(a.i.wallet_select_tips_for_fetch);
      this.mQH = ((ListView)findViewById(a.f.wallet_bankcard_list));
      this.qhD = new WalletSelectBankcardModeUI.b(this);
      this.mQH.setAdapter(this.qhD);
      this.mQH.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this, paramAnonymousInt);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this).notifyDataSetChanged();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_select_index", paramAnonymousInt);
          WalletSelectBankcardModeUI.this.setResult(-1, paramAnonymousAdapterView);
          y.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is " + paramAnonymousInt);
          WalletSelectBankcardModeUI.this.finish();
        }
      });
      this.mData.clear();
      this.qgt = getString(a.i.wallet_balance_save_bind_new_card_to_fetch);
      if (this.drX != 0) {
        break label564;
      }
      p.bTK();
      localObject = p.bTL();
      this.qgr = ((ag)localObject).bWb();
      this.qgs = ((ag)localObject).a(this.qgr, null, false, true);
      if (((ag)localObject).qzh == null) {
        break label397;
      }
      this.qgC = ((ag)localObject).qzh.qgC;
      y.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.qgC);
      if ((this.qgr == null) || (this.qgr.size() <= 0)) {
        break label572;
      }
      y.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.qgr.size());
      localObject = this.qgr.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label511;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new WalletSelectBankcardModeUI.a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.qgC != 1)) {
        break label457;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label412;
      }
      locala.ioU = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mData.add(locala);
      if ((this.qgG == -1) && (this.qgs != null) && (this.qgs.equals(localBankcard))) {
        this.qgG = i;
      }
      i += 1;
      break label254;
      if (this.drX != 1) {
        break;
      }
      this.qhC.setText(a.i.wallet_select_tips_for_save);
      break;
      label397:
      this.qgC = 0;
      y.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label200;
      label412:
      locala.ioU = (getString(a.i.wallet_balance_fetch_charge_rate_tips_for_select) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label457:
      y.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.qgC);
    }
    label511:
    if ((this.qgG == -1) && (this.qgs == null)) {
      this.qgG = i;
    }
    for (;;)
    {
      localObject = new WalletSelectBankcardModeUI.a((byte)0);
      ((WalletSelectBankcardModeUI.a)localObject).title = this.qgt;
      ((WalletSelectBankcardModeUI.a)localObject).ioU = "";
      this.mData.add(localObject);
      label564:
      this.qhD.notifyDataSetChanged();
      return;
      label572:
      y.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setResult(0);
    this.drX = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.qgG = getIntent().getIntExtra("key_select_index", -1);
    y.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.drX);
    initView();
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      setResult(0);
      finish();
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */