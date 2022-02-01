package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private int Fjh;
  private int VbN;
  private ArrayList<Bankcard> Vbt;
  private Bankcard Vbu;
  private String Vbv;
  private TextView Vdn;
  private b Vdo;
  private ListView bEw;
  private int lCR;
  private ArrayList<a> mlK;
  
  public WalletSelectBankcardModeUI()
  {
    AppMethodBeat.i(68732);
    this.lCR = 0;
    this.VbN = 0;
    this.mlK = new ArrayList();
    this.Fjh = -1;
    AppMethodBeat.o(68732);
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
    return a.g.wallet_select_bank_card_mode_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68734);
    setMMTitle(a.i.wallet_bancard_list_dialog_title);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(68727);
        WalletSelectBankcardModeUI.this.setResult(0);
        WalletSelectBankcardModeUI.this.finish();
        AppMethodBeat.o(68727);
        return true;
      }
    });
    this.Vdn = ((TextView)findViewById(a.f.wallet_select_tips));
    Object localObject;
    label205:
    int i;
    label259:
    Bankcard localBankcard;
    a locala;
    if (this.lCR == 0)
    {
      this.Vdn.setText(a.i.wallet_select_tips_for_fetch);
      this.bEw = ((ListView)findViewById(a.f.wallet_bankcard_list));
      this.Vdo = new b();
      this.bEw.setAdapter(this.Vdo);
      this.bEw.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(68728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this, paramAnonymousInt);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this).notifyDataSetChanged();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_select_index", paramAnonymousInt);
          WalletSelectBankcardModeUI.this.setResult(-1, paramAnonymousAdapterView);
          Log.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(paramAnonymousInt)));
          WalletSelectBankcardModeUI.this.finish();
          a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(68728);
        }
      });
      this.mlK.clear();
      this.Vbv = getString(a.i.wallet_balance_save_bind_new_card_to_fetch);
      if (this.lCR != 0) {
        break label569;
      }
      com.tencent.mm.plugin.wallet.model.p.ifO();
      localObject = com.tencent.mm.plugin.wallet.model.p.ifP();
      this.Vbt = ((am)localObject).ijD();
      this.Vbu = ((am)localObject).a(this.Vbt, null, false, true);
      if (((am)localObject).VKg == null) {
        break label402;
      }
      this.VbN = ((am)localObject).VKg.VbN;
      Log.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.VbN);
      if ((this.Vbt == null) || (this.Vbt.size() <= 0)) {
        break label582;
      }
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.Vbt.size());
      localObject = this.Vbt.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label516;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.VbN != 1)) {
        break label462;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label417;
      }
      locala.lym = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mlK.add(locala);
      if ((this.Fjh == -1) && (this.Vbu != null) && (this.Vbu.equals(localBankcard))) {
        this.Fjh = i;
      }
      i += 1;
      break label259;
      if (this.lCR != 1) {
        break;
      }
      this.Vdn.setText(a.i.wallet_select_tips_for_save);
      break;
      label402:
      this.VbN = 0;
      Log.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label205;
      label417:
      locala.lym = (getString(a.i.wallet_balance_fetch_charge_rate_tips_for_select) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label462:
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.VbN);
    }
    label516:
    if ((this.Fjh == -1) && (this.Vbu == null)) {
      this.Fjh = i;
    }
    for (;;)
    {
      localObject = new a((byte)0);
      ((a)localObject).title = this.Vbv;
      ((a)localObject).lym = "";
      this.mlK.add(localObject);
      label569:
      this.Vdo.notifyDataSetChanged();
      AppMethodBeat.o(68734);
      return;
      label582:
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68733);
    super.onCreate(paramBundle);
    setResult(0);
    this.lCR = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.Fjh = getIntent().getIntExtra("key_select_index", -1);
    Log.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.lCR);
    initView();
    AppMethodBeat.o(68733);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(68735);
    if (paramInt == 4)
    {
      setResult(0);
      finish();
    }
    boolean bool = super.onKeyUp(paramInt, paramKeyEvent);
    AppMethodBeat.o(68735);
    return bool;
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  static final class a
  {
    public String lym = "";
    public String title = "";
  }
  
  final class b
    extends BaseAdapter
  {
    b() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(68729);
      int i = WalletSelectBankcardModeUI.b(WalletSelectBankcardModeUI.this).size();
      AppMethodBeat.o(68729);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(68730);
      paramView = View.inflate(WalletSelectBankcardModeUI.this, a.g.wallet_select_bankcard_item, null);
      paramViewGroup = (WalletSelectBankcardModeUI.a)WalletSelectBankcardModeUI.b(WalletSelectBankcardModeUI.this).get(paramInt);
      TextView localTextView1 = (TextView)paramView.findViewById(a.f.bankcard_title);
      TextView localTextView2 = (TextView)paramView.findViewById(a.f.bankcard_tips);
      ImageView localImageView = (ImageView)paramView.findViewById(a.f.selected_icon);
      localTextView1.setText(paramViewGroup.title);
      if (!TextUtils.isEmpty(paramViewGroup.lym))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup.lym);
        if (WalletSelectBankcardModeUI.c(WalletSelectBankcardModeUI.this) != paramInt) {
          break label138;
        }
        localImageView.setImageResource(a.h.radio_on);
      }
      for (;;)
      {
        AppMethodBeat.o(68730);
        return paramView;
        localTextView2.setVisibility(8);
        break;
        label138:
        localImageView.setImageResource(a.h.radio_off);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */