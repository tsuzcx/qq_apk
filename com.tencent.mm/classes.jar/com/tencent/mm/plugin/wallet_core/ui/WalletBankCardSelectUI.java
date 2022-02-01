package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.plugin.wallet_core.utils.a.8;
import com.tencent.mm.plugin.wallet_core.utils.a.9;
import com.tencent.mm.plugin.wallet_core.utils.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WalletBankCardSelectUI
  extends WalletBaseUI
{
  private static final String TAG = "WalletBankCardSelectUI";
  protected List<ElementQuery> bankcardList;
  private List<d> bankcardQueryList;
  public List<ElementQuery> bankcardTypeList;
  private boolean isSearchMode;
  protected WalletBankCardSelectUI.a mBankCardComparator;
  protected BankCardSelectSortView mBankCardSelectSortView;
  private s mSearchViewHelper;
  private List<d> origBankcardList;
  
  public WalletBankCardSelectUI()
  {
    AppMethodBeat.i(70699);
    this.mBankCardComparator = new WalletBankCardSelectUI.a((byte)0);
    this.isSearchMode = false;
    AppMethodBeat.o(70699);
  }
  
  private boolean containByBankName(ElementQuery paramElementQuery)
  {
    AppMethodBeat.i(70703);
    Iterator localIterator = this.origBankcardList.iterator();
    while (localIterator.hasNext())
    {
      BankCardSelectSortView.a locala = (BankCardSelectSortView.a)((d)localIterator.next()).data;
      if ((!Util.isNullOrNil(paramElementQuery.ynT)) && (paramElementQuery.ynT.equals(locala.AOj)))
      {
        AppMethodBeat.o(70703);
        return true;
      }
    }
    AppMethodBeat.o(70703);
    return false;
  }
  
  public static char getAlpha(String paramString, char paramChar, boolean paramBoolean)
  {
    AppMethodBeat.i(70706);
    paramChar = getFullPY(paramString, String.valueOf(paramChar), "_", paramBoolean).charAt(0);
    AppMethodBeat.o(70706);
    return paramChar;
  }
  
  public static String getFullPY(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(70707);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(70707);
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length();
    int i = 0;
    if (i < j)
    {
      String str = SpellMap.x(paramString1.charAt(i));
      if (!Util.isNullOrNil(str))
      {
        if (!paramBoolean) {
          break label103;
        }
        localStringBuilder.append(str.toUpperCase());
      }
      for (;;)
      {
        if (i != j - 1) {
          localStringBuilder.append(paramString3);
        }
        i += 1;
        break;
        label103:
        localStringBuilder.append(str);
      }
    }
    paramString1 = localStringBuilder.toString();
    Log.d("WalletBankCardSelectUI", "full py: %s", new Object[] { paramString1 });
    if (!Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(70707);
      return paramString1;
    }
    AppMethodBeat.o(70707);
    return paramString2;
  }
  
  private void refreshData(Map<String, e> paramMap)
  {
    AppMethodBeat.i(70705);
    if (paramMap != null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.d("WalletBankCardSelectUI", "refresh data: %s", new Object[] { Boolean.valueOf(bool) });
      this.origBankcardList.clear();
      if ((this.bankcardList != null) && (!this.bankcardList.isEmpty())) {
        break;
      }
      Log.w("WalletBankCardSelectUI", "bankcardlist is null");
      AppMethodBeat.o(70705);
      return;
    }
    Iterator localIterator = this.bankcardList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (ElementQuery)localIterator.next();
      if (!containByBankName((ElementQuery)localObject))
      {
        d locald = new d();
        BankCardSelectSortView.a locala = new BankCardSelectSortView.a();
        locala.AOj = ((ElementQuery)localObject).ynT;
        if (paramMap != null)
        {
          localObject = (e)paramMap.get(((ElementQuery)localObject).dDj);
          if (localObject != null)
          {
            locala.icon = ((e)localObject).AAU;
            locala.ImL = ((e)localObject).HWe;
            locala.pinyin = ((e)localObject).pinyin;
          }
        }
        if (!Util.isNullOrNil(locala.pinyin)) {
          Log.d("WalletBankCardSelectUI", "have pinyin：%s", new Object[] { locala.pinyin });
        }
        for (;;)
        {
          locald.Pae = locala.pinyin.toUpperCase().charAt(0);
          locald.data = locala;
          this.origBankcardList.add(locald);
          break;
          locala.pinyin = getFullPY(locala.AOj, "#", "_", true);
        }
      }
    }
    Collections.sort(this.origBankcardList, this.mBankCardComparator);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70696);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.hy(WalletBankCardSelectUI.this.origBankcardList);
        AppMethodBeat.o(70696);
      }
    });
    AppMethodBeat.o(70705);
  }
  
  public void fetchData()
  {
    AppMethodBeat.i(70704);
    this.origBankcardList = new ArrayList();
    refreshData(null);
    com.tencent.mm.plugin.wallet_core.utils.a locala = new com.tencent.mm.plugin.wallet_core.utils.a();
    LinkedList localLinkedList = new LinkedList();
    if (this.bankcardList != null)
    {
      localObject1 = this.bankcardList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ElementQuery)((Iterator)localObject1).next();
        Bankcard localBankcard = new Bankcard();
        localBankcard.field_bankName = ((ElementQuery)localObject2).ynT;
        localBankcard.field_bankcardType = ((ElementQuery)localObject2).dDj;
        localLinkedList.add(localBankcard);
      }
    }
    getContext();
    Object localObject1 = new a.a()
    {
      public final void bc(Map<String, e> paramAnonymousMap)
      {
        AppMethodBeat.i(70695);
        Log.i("WalletBankCardSelectUI", "get logo callback: %s", new Object[] { Integer.valueOf(paramAnonymousMap.size()) });
        WalletBankCardSelectUI.access$200(WalletBankCardSelectUI.this, paramAnonymousMap);
        AppMethodBeat.o(70695);
      }
    };
    Object localObject2 = new HashMap();
    if (localLinkedList.isEmpty())
    {
      Log.w("MicroMsg.BankcardLogoHelper", "req is null");
      ((a.a)localObject1).bc((Map)localObject2);
      AppMethodBeat.o(70704);
      return;
    }
    g.en(localLinkedList).d(new a.9(locala)).d(new a.8(locala, localLinkedList, (Map)localObject2, (a.a)localObject1));
    AppMethodBeat.o(70704);
  }
  
  public int getLayoutId()
  {
    return 2131496901;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70701);
    this.mBankCardSelectSortView = ((BankCardSelectSortView)findViewById(2131297316));
    this.mBankCardSelectSortView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70690);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = (d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        WalletBankCardSelectUI.this.onItemSelect(paramAnonymousAdapterView.data, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(70690);
      }
    });
    this.mSearchViewHelper = new s((byte)0);
    this.mSearchViewHelper.Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        AppMethodBeat.i(70694);
        WalletBankCardSelectUI.this.hideVKB();
        AppMethodBeat.o(70694);
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(70693);
        Log.d("WalletBankCardSelectUI", "search text: %s", new Object[] { paramAnonymousString });
        WalletBankCardSelectUI.this.mBankCardSelectSortView.bmm(paramAnonymousString);
        AppMethodBeat.o(70693);
      }
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny()
      {
        AppMethodBeat.i(70692);
        WalletBankCardSelectUI.access$102(WalletBankCardSelectUI.this, false);
        WalletBankCardSelectUI.this.hideVKB();
        WalletBankCardSelectUI.this.mBankCardSelectSortView.BF(true);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(0);
        AppMethodBeat.o(70692);
      }
      
      public final void bnz()
      {
        AppMethodBeat.i(70691);
        WalletBankCardSelectUI.access$102(WalletBankCardSelectUI.this, true);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.BF(false);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(1);
        AppMethodBeat.o(70691);
      }
    };
    AppMethodBeat.o(70701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70700);
    super.onCreate(paramBundle);
    setMMTitle(2131756532);
    this.bankcardList = t.fQQ().HQe;
    initView();
    fetchData();
    addSearchMenu(true, this.mSearchViewHelper);
    AppMethodBeat.o(70700);
  }
  
  protected void onItemSelect(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(70702);
    paramObject = (BankCardSelectSortView.a)paramObject;
    if (paramObject != null)
    {
      hideVKB();
      Intent localIntent = new Intent();
      localIntent.putExtra("bank_name", paramObject.AOj);
      Log.i("WalletBankCardSelectUI", "item bank: %s", new Object[] { paramObject.AOj });
      setResult(-1, localIntent);
      finish();
    }
    AppMethodBeat.o(70702);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
 * JD-Core Version:    0.7.0.1
 */