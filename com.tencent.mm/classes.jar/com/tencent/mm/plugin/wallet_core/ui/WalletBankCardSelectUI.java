package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.plugin.wallet_core.utils.b.7;
import com.tencent.mm.plugin.wallet_core.utils.b.8;
import com.tencent.mm.plugin.wallet_core.utils.b.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.g;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class WalletBankCardSelectUI
  extends WalletBaseUI
{
  private static final String TAG = "WalletBankCardSelectUI";
  protected List<ElementQuery> bankcardList;
  private List<d> bankcardQueryList;
  public List<ElementQuery> bankcardTypeList;
  private boolean isSearchMode;
  protected a mBankCardComparator;
  protected BankCardSelectSortView mBankCardSelectSortView;
  private s mSearchViewHelper;
  private List<d> origBankcardList;
  
  public WalletBankCardSelectUI()
  {
    AppMethodBeat.i(70699);
    this.mBankCardComparator = new a((byte)0);
    this.isSearchMode = false;
    AppMethodBeat.o(70699);
  }
  
  private boolean containByBankName(ElementQuery paramElementQuery)
  {
    AppMethodBeat.i(70703);
    Iterator localIterator = this.origBankcardList.iterator();
    while (localIterator.hasNext())
    {
      BankCardSelectSortView.a locala = (BankCardSelectSortView.a)((d)localIterator.next()).cpt;
      if ((!Util.isNullOrNil(paramElementQuery.JFk)) && (paramElementQuery.JFk.equals(locala.MEo)))
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
      String str = SpellMap.v(paramString1.charAt(i));
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
        locala.MEo = ((ElementQuery)localObject).JFk;
        if (paramMap != null)
        {
          localObject = (e)paramMap.get(((ElementQuery)localObject).hAk);
          if (localObject != null)
          {
            locala.icon = ((e)localObject).MpW;
            locala.VVL = ((e)localObject).VDY;
            locala.pinyin = ((e)localObject).pinyin;
          }
        }
        if (!Util.isNullOrNil(locala.pinyin)) {
          Log.d("WalletBankCardSelectUI", "have pinyin：%s", new Object[] { locala.pinyin });
        }
        for (;;)
        {
          locald.aeaK = locala.pinyin.toUpperCase().charAt(0);
          locald.cpt = locala;
          this.origBankcardList.add(locald);
          break;
          locala.pinyin = getFullPY(locala.MEo, "#", "_", true);
        }
      }
    }
    Collections.sort(this.origBankcardList, this.mBankCardComparator);
    runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(70696);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.lG(WalletBankCardSelectUI.this.origBankcardList);
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
    com.tencent.mm.plugin.wallet_core.utils.b localb = new com.tencent.mm.plugin.wallet_core.utils.b();
    LinkedList localLinkedList = new LinkedList();
    if (this.bankcardList != null)
    {
      localObject1 = this.bankcardList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ElementQuery)((Iterator)localObject1).next();
        Bankcard localBankcard = new Bankcard();
        localBankcard.field_bankName = ((ElementQuery)localObject2).JFk;
        localBankcard.field_bankcardType = ((ElementQuery)localObject2).hAk;
        localLinkedList.add(localBankcard);
      }
    }
    getContext();
    Object localObject1 = new b.a()
    {
      public final void bn(Map<String, e> paramAnonymousMap)
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
      ((b.a)localObject1).bn((Map)localObject2);
      AppMethodBeat.o(70704);
      return;
    }
    g.gR(localLinkedList).d(new b.8(localb)).d(new b.7(localb, localLinkedList, (Map)localObject2, (b.a)localObject1));
    AppMethodBeat.o(70704);
  }
  
  public int getLayoutId()
  {
    return a.g.wallet_bankcard_select_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70701);
    this.mBankCardSelectSortView = ((BankCardSelectSortView)findViewById(a.f.bankcard_sort_view));
    this.mBankCardSelectSortView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70690);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = (d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        WalletBankCardSelectUI.this.onItemSelect(paramAnonymousAdapterView.cpt, paramAnonymousInt);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletBankCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(70690);
      }
    });
    this.mSearchViewHelper = new s(true);
    this.mSearchViewHelper.afKz = new s.c()
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
        WalletBankCardSelectUI.this.mBankCardSelectSortView.bAo(paramAnonymousString);
        AppMethodBeat.o(70693);
      }
      
      public final void bWw()
      {
        AppMethodBeat.i(70692);
        WalletBankCardSelectUI.access$102(WalletBankCardSelectUI.this, false);
        WalletBankCardSelectUI.this.hideVKB();
        WalletBankCardSelectUI.this.mBankCardSelectSortView.LL(true);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(0);
        AppMethodBeat.o(70692);
      }
      
      public final void bWx()
      {
        AppMethodBeat.i(70691);
        WalletBankCardSelectUI.access$102(WalletBankCardSelectUI.this, true);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.LL(false);
        WalletBankCardSelectUI.this.mBankCardSelectSortView.setMode(1);
        AppMethodBeat.o(70691);
      }
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    AppMethodBeat.o(70701);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70700);
    super.onCreate(paramBundle);
    setMMTitle(a.i.bank_remit_select_bank_title);
    this.bankcardList = u.iiK().VxZ;
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
      localIntent.putExtra("bank_name", paramObject.MEo);
      Log.i("WalletBankCardSelectUI", "item bank: %s", new Object[] { paramObject.MEo });
      setResult(-1, localIntent);
      finish();
    }
    AppMethodBeat.o(70702);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(301222);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.wallet_core.utils.a.class);
    AppMethodBeat.o(301222);
  }
  
  static class a
    implements Comparator<d>
  {
    private Collator VLH;
    
    private a()
    {
      AppMethodBeat.i(70697);
      this.VLH = Collator.getInstance(Locale.getDefault());
      AppMethodBeat.o(70697);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
 * JD-Core Version:    0.7.0.1
 */