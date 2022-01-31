package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.plugin.wallet_core.utils.a;
import com.tencent.mm.plugin.wallet_core.utils.a.8;
import com.tencent.mm.plugin.wallet_core.utils.a.9;
import com.tencent.mm.plugin.wallet_core.utils.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.tools.q;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.f;
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
  private boolean isSearchMode;
  protected WalletBankCardSelectUI.a mBankCardComparator;
  protected BankCardSelectSortView mBankCardSelectSortView;
  private q mSearchViewHelper;
  private List<d> origBankcardList;
  
  public WalletBankCardSelectUI()
  {
    AppMethodBeat.i(142491);
    this.mBankCardComparator = new WalletBankCardSelectUI.a((byte)0);
    this.isSearchMode = false;
    AppMethodBeat.o(142491);
  }
  
  private boolean containByBankName(ElementQuery paramElementQuery)
  {
    AppMethodBeat.i(142493);
    Iterator localIterator = this.origBankcardList.iterator();
    while (localIterator.hasNext())
    {
      BankCardSelectSortView.a locala = (BankCardSelectSortView.a)((d)localIterator.next()).data;
      if ((!bo.isNullOrNil(paramElementQuery.nLq)) && (paramElementQuery.nLq.equals(locala.ppn)))
      {
        AppMethodBeat.o(142493);
        return true;
      }
    }
    AppMethodBeat.o(142493);
    return false;
  }
  
  public static char getAlpha(String paramString, char paramChar, boolean paramBoolean)
  {
    AppMethodBeat.i(142495);
    paramChar = getFullPY(paramString, String.valueOf(paramChar), "_", paramBoolean).charAt(0);
    AppMethodBeat.o(142495);
    return paramChar;
  }
  
  public static String getFullPY(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    AppMethodBeat.i(142496);
    if (bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(142496);
      return paramString2;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramString1.length();
    int i = 0;
    if (i < j)
    {
      String str = SpellMap.u(paramString1.charAt(i));
      if (!bo.isNullOrNil(str))
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
    ab.d("WalletBankCardSelectUI", "full py: %s", new Object[] { paramString1 });
    if (!bo.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(142496);
      return paramString1;
    }
    AppMethodBeat.o(142496);
    return paramString2;
  }
  
  private void refreshData(Map<String, g> paramMap)
  {
    AppMethodBeat.i(47151);
    if (paramMap != null) {}
    for (boolean bool = true;; bool = false)
    {
      ab.d("WalletBankCardSelectUI", "refresh data: %s", new Object[] { Boolean.valueOf(bool) });
      this.origBankcardList.clear();
      if ((this.bankcardList != null) && (!this.bankcardList.isEmpty())) {
        break;
      }
      ab.w("WalletBankCardSelectUI", "bankcardlist is null");
      AppMethodBeat.o(47151);
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
        locala.ppn = ((ElementQuery)localObject).nLq;
        if (paramMap != null)
        {
          localObject = (g)paramMap.get(((ElementQuery)localObject).poq);
          if (localObject != null)
          {
            locala.cDz = ((g)localObject).pek;
            locala.uwn = ((g)localObject).ugp;
            locala.pJg = ((g)localObject).pJg;
          }
        }
        if (!bo.isNullOrNil(locala.pJg)) {
          ab.d("WalletBankCardSelectUI", "have pinyin：%s", new Object[] { locala.pJg });
        }
        for (;;)
        {
          locald.zsM = locala.pJg.toUpperCase().charAt(0);
          locald.data = locala;
          this.origBankcardList.add(locald);
          break;
          locala.pJg = getFullPY(locala.ppn, "#", "_", true);
        }
      }
    }
    Collections.sort(this.origBankcardList, this.mBankCardComparator);
    runOnUiThread(new WalletBankCardSelectUI.4(this));
    AppMethodBeat.o(47151);
  }
  
  public void fetchData()
  {
    AppMethodBeat.i(142494);
    this.origBankcardList = new ArrayList();
    refreshData(null);
    a locala = new a();
    LinkedList localLinkedList = new LinkedList();
    if (this.bankcardList != null)
    {
      localObject1 = this.bankcardList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ElementQuery)((Iterator)localObject1).next();
        Bankcard localBankcard = new Bankcard();
        localBankcard.field_bankName = ((ElementQuery)localObject2).nLq;
        localBankcard.field_bankcardType = ((ElementQuery)localObject2).poq;
        localLinkedList.add(localBankcard);
      }
    }
    getContext();
    Object localObject1 = new WalletBankCardSelectUI.3(this);
    Object localObject2 = new HashMap();
    if (localLinkedList.isEmpty())
    {
      ab.w("MicroMsg.BankcardLogoHelper", "req is null");
      ((a.a)localObject1).am((Map)localObject2);
      AppMethodBeat.o(142494);
      return;
    }
    f.cN(localLinkedList).d(new a.9(locala)).d(new a.8(locala, localLinkedList, (Map)localObject2, (a.a)localObject1));
    AppMethodBeat.o(142494);
  }
  
  public int getLayoutId()
  {
    return 2130971147;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47150);
    this.mBankCardSelectSortView = ((BankCardSelectSortView)findViewById(2131829029));
    this.mBankCardSelectSortView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(47140);
        paramAnonymousAdapterView = (d)paramAnonymousAdapterView.getAdapter().getItem(paramAnonymousInt);
        WalletBankCardSelectUI.this.onItemSelect(paramAnonymousAdapterView.data, paramAnonymousInt);
        AppMethodBeat.o(47140);
      }
    });
    this.mSearchViewHelper = new q((byte)0);
    this.mSearchViewHelper.Axg = new WalletBankCardSelectUI.2(this);
    AppMethodBeat.o(47150);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47149);
    super.onCreate(paramBundle);
    setMMTitle(2131297511);
    this.bankcardList = t.cTV().ubS;
    initView();
    fetchData();
    addSearchMenu(true, this.mSearchViewHelper);
    AppMethodBeat.o(47149);
  }
  
  protected void onItemSelect(Object paramObject, int paramInt)
  {
    AppMethodBeat.i(142492);
    paramObject = (BankCardSelectSortView.a)paramObject;
    if (paramObject != null)
    {
      hideVKB();
      Intent localIntent = new Intent();
      localIntent.putExtra("bank_name", paramObject.ppn);
      ab.i("WalletBankCardSelectUI", "item bank: %s", new Object[] { paramObject.ppn });
      setResult(-1, localIntent);
      finish();
    }
    AppMethodBeat.o(142492);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
 * JD-Core Version:    0.7.0.1
 */