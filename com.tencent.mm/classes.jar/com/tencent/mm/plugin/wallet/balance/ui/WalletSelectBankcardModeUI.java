package com.tencent.mm.plugin.wallet.balance.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private ArrayList<Bankcard> CQh;
  private Bankcard CQi;
  private String CQj;
  private int CQv;
  private TextView CRN;
  private b CRO;
  private ListView GF;
  private int fRv;
  private ArrayList<a> mData;
  private int tci;
  
  public WalletSelectBankcardModeUI()
  {
    AppMethodBeat.i(68732);
    this.fRv = 0;
    this.CQv = 0;
    this.mData = new ArrayList();
    this.tci = -1;
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
    return 2131496024;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68734);
    setMMTitle(2131765035);
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
    this.CRN = ((TextView)findViewById(2131306832));
    Object localObject;
    label200:
    int i;
    label254:
    Bankcard localBankcard;
    a locala;
    if (this.fRv == 0)
    {
      this.CRN.setText(2131765863);
      this.GF = ((ListView)findViewById(2131306687));
      this.CRO = new b();
      this.GF.setAdapter(this.CRO);
      this.GF.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(68728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousAdapterView);
          localb.bd(paramAnonymousView);
          localb.mu(paramAnonymousInt);
          localb.rl(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this, paramAnonymousInt);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this).notifyDataSetChanged();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_select_index", paramAnonymousInt);
          WalletSelectBankcardModeUI.this.setResult(-1, paramAnonymousAdapterView);
          ae.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(paramAnonymousInt)));
          WalletSelectBankcardModeUI.this.finish();
          a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(68728);
        }
      });
      this.mData.clear();
      this.CQj = getString(2131765025);
      if (this.fRv != 0) {
        break label557;
      }
      s.eGW();
      localObject = s.eGX();
      this.CQh = ((an)localObject).eKd();
      this.CQi = ((an)localObject).a(this.CQh, null, false, true);
      if (((an)localObject).DsC == null) {
        break label396;
      }
      this.CQv = ((an)localObject).DsC.CQv;
      ae.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.CQv);
      if ((this.CQh == null) || (this.CQh.size() <= 0)) {
        break label570;
      }
      ae.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.CQh.size());
      localObject = this.CQh.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label505;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.CQv != 1)) {
        break label454;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label411;
      }
      locala.oIr = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mData.add(locala);
      if ((this.tci == -1) && (this.CQi != null) && (this.CQi.equals(localBankcard))) {
        this.tci = i;
      }
      i += 1;
      break label254;
      if (this.fRv != 1) {
        break;
      }
      this.CRN.setText(2131765864);
      break;
      label396:
      this.CQv = 0;
      ae.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label200;
      label411:
      locala.oIr = (getString(2131764982) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label454:
      ae.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.CQv);
    }
    label505:
    if ((this.tci == -1) && (this.CQi == null)) {
      this.tci = i;
    }
    for (;;)
    {
      localObject = new a((byte)0);
      ((a)localObject).title = this.CQj;
      ((a)localObject).oIr = "";
      this.mData.add(localObject);
      label557:
      this.CRO.notifyDataSetChanged();
      AppMethodBeat.o(68734);
      return;
      label570:
      ae.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68733);
    super.onCreate(paramBundle);
    setResult(0);
    this.fRv = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.tci = getIntent().getIntExtra("key_select_index", -1);
    ae.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.fRv);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
    public String oIr = "";
    public String title = "";
  }
  
  @SuppressLint({"ViewHolder"})
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
      paramView = View.inflate(WalletSelectBankcardModeUI.this, 2131496025, null);
      paramViewGroup = (WalletSelectBankcardModeUI.a)WalletSelectBankcardModeUI.b(WalletSelectBankcardModeUI.this).get(paramInt);
      TextView localTextView1 = (TextView)paramView.findViewById(2131297175);
      TextView localTextView2 = (TextView)paramView.findViewById(2131297174);
      ImageView localImageView = (ImageView)paramView.findViewById(2131304542);
      localTextView1.setText(paramViewGroup.title);
      if (!TextUtils.isEmpty(paramViewGroup.oIr))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup.oIr);
        if (WalletSelectBankcardModeUI.c(WalletSelectBankcardModeUI.this) != paramInt) {
          break label133;
        }
        localImageView.setImageResource(2131691078);
      }
      for (;;)
      {
        AppMethodBeat.o(68730);
        return paramView;
        localTextView2.setVisibility(8);
        break;
        label133:
        localImageView.setImageResource(2131691077);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */