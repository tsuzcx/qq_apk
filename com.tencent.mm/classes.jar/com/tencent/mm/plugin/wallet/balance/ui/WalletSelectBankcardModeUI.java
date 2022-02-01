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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Iterator;

public class WalletSelectBankcardModeUI
  extends WalletBaseUI
{
  private ListView GP;
  private ArrayList<Bankcard> Hva;
  private Bankcard Hvb;
  private String Hvc;
  private int Hvm;
  private TextView HwI;
  private b HwJ;
  private int gwE;
  private ArrayList<a> mData;
  private int whv;
  
  public WalletSelectBankcardModeUI()
  {
    AppMethodBeat.i(68732);
    this.gwE = 0;
    this.Hvm = 0;
    this.mData = new ArrayList();
    this.whv = -1;
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
    return 2131497004;
  }
  
  public void initView()
  {
    AppMethodBeat.i(68734);
    setMMTitle(2131767478);
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
    this.HwI = ((TextView)findViewById(2131310294));
    Object localObject;
    label200:
    int i;
    label254:
    Bankcard localBankcard;
    a locala;
    if (this.gwE == 0)
    {
      this.HwI.setText(2131768316);
      this.GP = ((ListView)findViewById(2131310147));
      this.HwJ = new b();
      this.GP.setAdapter(this.HwJ);
      this.GP.setOnItemClickListener(new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(68728);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousAdapterView);
          localb.bm(paramAnonymousView);
          localb.pH(paramAnonymousInt);
          localb.zo(paramAnonymousLong);
          a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletSelectBankcardModeUI$2", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
      this.mData.clear();
      this.Hvc = getString(2131767468);
      if (this.gwE != 0) {
        break label557;
      }
      s.fOg();
      localObject = s.fOh();
      this.Hva = ((an)localObject).fRG();
      this.Hvb = ((an)localObject).a(this.Hva, null, false, true);
      if (((an)localObject).IbO == null) {
        break label396;
      }
      this.Hvm = ((an)localObject).IbO.Hvm;
      Log.e("MicroMsg.WalletSelectBankcardModeUI", "is_show_charge is " + this.Hvm);
      if ((this.Hva == null) || (this.Hva.size() <= 0)) {
        break label570;
      }
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "mBankcardList size is " + this.Hva.size());
      localObject = this.Hva.iterator();
      i = 0;
      if (!((Iterator)localObject).hasNext()) {
        break label505;
      }
      localBankcard = (Bankcard)((Iterator)localObject).next();
      locala = new a((byte)0);
      locala.title = localBankcard.field_desc;
      if ((localBankcard.field_fetch_charge_rate <= 0.0D) || (this.Hvm != 1)) {
        break label454;
      }
      if (TextUtils.isEmpty(localBankcard.field_fetch_charge_info)) {
        break label411;
      }
      locala.pWf = localBankcard.field_fetch_charge_info;
    }
    for (;;)
    {
      this.mData.add(locala);
      if ((this.whv == -1) && (this.Hvb != null) && (this.Hvb.equals(localBankcard))) {
        this.whv = i;
      }
      i += 1;
      break label254;
      if (this.gwE != 1) {
        break;
      }
      this.HwI.setText(2131768317);
      break;
      label396:
      this.Hvm = 0;
      Log.e("MicroMsg.WalletSelectBankcardModeUI", "userInfo.getBalanceFetchInfo() is null");
      break label200;
      label411:
      locala.pWf = (getString(2131767425) + localBankcard.field_fetch_charge_rate * 100.0D + "%");
      continue;
      label454:
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "the bank " + localBankcard.field_desc + " field_fetch_charge_rate is " + localBankcard.field_fetch_charge_rate + " is_show_charge is " + this.Hvm);
    }
    label505:
    if ((this.whv == -1) && (this.Hvb == null)) {
      this.whv = i;
    }
    for (;;)
    {
      localObject = new a((byte)0);
      ((a)localObject).title = this.Hvc;
      ((a)localObject).pWf = "";
      this.mData.add(localObject);
      label557:
      this.HwJ.notifyDataSetChanged();
      AppMethodBeat.o(68734);
      return;
      label570:
      Log.i("MicroMsg.WalletSelectBankcardModeUI", "hy: no bankcard show new only");
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(68733);
    super.onCreate(paramBundle);
    setResult(0);
    this.gwE = getIntent().getIntExtra("key_scene_select_bankcard_mode_ui", 0);
    this.whv = getIntent().getIntExtra("key_select_index", -1);
    Log.i("MicroMsg.WalletSelectBankcardModeUI", "onCreate() mFromScene is " + this.gwE);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
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
    public String pWf = "";
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
      paramView = View.inflate(WalletSelectBankcardModeUI.this, 2131497005, null);
      paramViewGroup = (WalletSelectBankcardModeUI.a)WalletSelectBankcardModeUI.b(WalletSelectBankcardModeUI.this).get(paramInt);
      TextView localTextView1 = (TextView)paramView.findViewById(2131297319);
      TextView localTextView2 = (TextView)paramView.findViewById(2131297318);
      ImageView localImageView = (ImageView)paramView.findViewById(2131307566);
      localTextView1.setText(paramViewGroup.title);
      if (!TextUtils.isEmpty(paramViewGroup.pWf))
      {
        localTextView2.setVisibility(0);
        localTextView2.setText(paramViewGroup.pWf);
        if (WalletSelectBankcardModeUI.c(WalletSelectBankcardModeUI.this) != paramInt) {
          break label133;
        }
        localImageView.setImageResource(2131691380);
      }
      for (;;)
      {
        AppMethodBeat.o(68730);
        return paramView;
        localTextView2.setVisibility(8);
        break;
        label133:
        localImageView.setImageResource(2131691379);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.ui.WalletSelectBankcardModeUI
 * JD-Core Version:    0.7.0.1
 */