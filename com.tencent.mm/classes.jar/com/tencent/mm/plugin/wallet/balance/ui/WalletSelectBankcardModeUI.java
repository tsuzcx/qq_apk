package com.tencent.mm.plugin.wallet.balance.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private int ejF;
  private ArrayList<WalletSelectBankcardModeUI.a> mData;
  private ArrayList<Bankcard> tNG;
  private Bankcard tNH;
  private String tNI;
  private int tNT;
  private int tNX;
  private TextView tOX;
  private WalletSelectBankcardModeUI.b tOY;
  private ListView xx;
  
  public WalletSelectBankcardModeUI()
  {
    AppMethodBeat.i(45494);
    this.ejF = 0;
    this.tNT = 0;
    this.mData = new ArrayList();
    this.tNX = -1;
    AppMethodBeat.o(45494);
  }
  
  public boolean checkProcLife()
  {
    return false;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130971247;
  }
  
  public void initView()
  {
    AppMethodBeat.i(45496);
    setMMTitle(2131304849);
    setBackBtn(new WalletSelectBankcardModeUI.1(this));
    this.tOX = ((TextView)findViewById(2131829389));
    Object localObject;
    label200:
    int i;
    label254:
    Bankcard localBankcard;
    WalletSelectBankcardModeUI.a locala;
    if (this.ejF == 0)
    {
      this.tOX.setText(2131305644);
      this.xx = ((ListView)findViewById(2131829390));
      this.tOY = new WalletSelectBankcardModeUI.b(this);
      this.xx.setAdapter(this.tOY);
      this.xx.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(45490);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this, paramAnonymousInt);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this).notifyDataSetChanged();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_select_index", paramAnonymousInt);
          WalletSelectBankcardModeUI.this.setResult(-1, paramAnonymousAdapterView);
          ab.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(paramAnonymousInt)));
          WalletSelectBankcardModeUI.this.finish();
          AppMethodBeat.o(45490);
        }
      });
      this.mData.clear();
      this.tNI = getString(2131304841);
      if (this.ejF != 0) {
        break label557;
      }
      s.cRG();
      localObject = s.cRH();
      this.tNG = ((am)localObject).cUH();
      this.tNH = ((am)localObject).a(this.tNG, null, false, true);
      if (((am)localObject).ulR == null) {
        break label396;
      }
      this.tNT = ((am)localObject).ulR.tNT;
      ab.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.tNT);
      if ((this.tNG == null) || (this.tNG.size() <= 0)) {
        break label570;
      }
      ab.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.tNG.size());
      localObject = this.tNG.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label505;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new WalletSelectBankcardModeUI.a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.tNT != 1)) {
        break label454;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label411;
      }
      locala.kqb = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mData.add(locala);
      if ((this.tNX == -1) && (this.tNH != null) && (this.tNH.equals(localBankcard))) {
        this.tNX = i;
      }
      i += 1;
      break label254;
      if (this.ejF != 1) {
        break;
      }
      this.tOX.setText(2131305645);
      break;
      label396:
      this.tNT = 0;
      ab.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label200;
      label411:
      locala.kqb = (getString(2131304799) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label454:
      ab.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.tNT);
    }
    label505:
    if ((this.tNX == -1) && (this.tNH == null)) {
      this.tNX = i;
    }
    for (;;)
    {
      localObject = new WalletSelectBankcardModeUI.a((byte)0);
      ((WalletSelectBankcardModeUI.a)localObject).title = this.tNI;
      ((WalletSelectBankcardModeUI.a)localObject).kqb = "";
      this.mData.add(localObject);
      label557:
      this.tOY.notifyDataSetChanged();
      AppMethodBeat.o(45496);
      return;
      label570:
      ab.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(45495);
    super.onCreate(paramBundle);
    setResult(0);
    this.ejF = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.tNX = getIntent().getIntExtra("key_select_index", -1);
    ab.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.ejF);
    initView();
    AppMethodBeat.o(45495);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(45497);
    if (paramInt == 4)
    {
      setResult(0);
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(45497);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */