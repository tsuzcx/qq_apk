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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private ListView DQ;
  private int fsv;
  private ArrayList<a> mData;
  private ArrayList<Bankcard> zGg;
  private Bankcard zGh;
  private String zGi;
  private int zGt;
  private int zGx;
  private TextView zHJ;
  private b zHK;
  
  public WalletSelectBankcardModeUI()
  {
    AppMethodBeat.i(68732);
    this.fsv = 0;
    this.zGt = 0;
    this.mData = new ArrayList();
    this.zGx = -1;
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
    this.zHJ = ((TextView)findViewById(2131306832));
    Object localObject;
    label200:
    int i;
    label254:
    Bankcard localBankcard;
    a locala;
    if (this.fsv == 0)
    {
      this.zHJ.setText(2131765863);
      this.DQ = ((ListView)findViewById(2131306687));
      this.zHK = new b();
      this.DQ.setAdapter(this.zHK);
      this.DQ.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(68728);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this, paramAnonymousInt);
          WalletSelectBankcardModeUI.a(WalletSelectBankcardModeUI.this).notifyDataSetChanged();
          paramAnonymousAdapterView = new Intent();
          paramAnonymousAdapterView.putExtra("key_select_index", paramAnonymousInt);
          WalletSelectBankcardModeUI.this.setResult(-1, paramAnonymousAdapterView);
          ad.i("MicroMsg.WalletSelectBankcardModeUI", "onItemClick pos is ".concat(String.valueOf(paramAnonymousInt)));
          WalletSelectBankcardModeUI.this.finish();
          AppMethodBeat.o(68728);
        }
      });
      this.mData.clear();
      this.zGi = getString(2131765025);
      if (this.fsv != 0) {
        break label557;
      }
      s.dZT();
      localObject = s.dZU();
      this.zGg = ((am)localObject).edb();
      this.zGh = ((am)localObject).a(this.zGg, null, false, true);
      if (((am)localObject).Ail == null) {
        break label396;
      }
      this.zGt = ((am)localObject).Ail.zGt;
      ad.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.zGt);
      if ((this.zGg == null) || (this.zGg.size() <= 0)) {
        break label570;
      }
      ad.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.zGg.size());
      localObject = this.zGg.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label505;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.zGt != 1)) {
        break label454;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label411;
      }
      locala.nvv = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mData.add(locala);
      if ((this.zGx == -1) && (this.zGh != null) && (this.zGh.equals(localBankcard))) {
        this.zGx = i;
      }
      i += 1;
      break label254;
      if (this.fsv != 1) {
        break;
      }
      this.zHJ.setText(2131765864);
      break;
      label396:
      this.zGt = 0;
      ad.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label200;
      label411:
      locala.nvv = (getString(2131764982) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label454:
      ad.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.zGt);
    }
    label505:
    if ((this.zGx == -1) && (this.zGh == null)) {
      this.zGx = i;
    }
    for (;;)
    {
      localObject = new a((byte)0);
      ((a)localObject).title = this.zGi;
      ((a)localObject).nvv = "";
      this.mData.add(localObject);
      label557:
      this.zHK.notifyDataSetChanged();
      AppMethodBeat.o(68734);
      return;
      label570:
      ad.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68733);
    super.onCreate(paramBundle);
    setResult(0);
    this.fsv = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.zGx = getIntent().getIntExtra("key_select_index", -1);
    ad.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.fsv);
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
    public String nvv = "";
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
      if (!TextUtils.isEmpty(paramViewGroup.nvv))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup.nvv);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */