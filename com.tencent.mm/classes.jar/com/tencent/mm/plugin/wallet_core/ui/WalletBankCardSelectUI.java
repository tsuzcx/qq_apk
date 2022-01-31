package com.tencent.mm.plugin.wallet_core.ui;

import android.os.Bundle;
import com.tencent.mm.ah.m;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.plugin.wallet_core.e.a;
import com.tencent.mm.plugin.wallet_core.e.a.8;
import com.tencent.mm.plugin.wallet_core.e.a.9;
import com.tencent.mm.plugin.wallet_core.e.a.a;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.e;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView;
import com.tencent.mm.plugin.wallet_core.ui.view.BankCardSelectSortView.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.sortview.d;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
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
  private n icu;
  private boolean ide = false;
  private BankCardSelectSortView qAl;
  private List<ElementQuery> qAm;
  private List<d> qAn;
  
  private void R(Map<String, e> paramMap)
  {
    boolean bool;
    label44:
    Object localObject2;
    BankCardSelectSortView.a locala;
    int i;
    if (paramMap != null)
    {
      bool = true;
      y.d("WalletBankCardSelectUI", "refresh data: %s", new Object[] { Boolean.valueOf(bool) });
      this.qAn.clear();
      Iterator localIterator = this.qAm.iterator();
      if (localIterator.hasNext())
      {
        Object localObject1 = (ElementQuery)localIterator.next();
        localObject2 = this.qAn.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          locala = (BankCardSelectSortView.a)((d)((Iterator)localObject2).next()).data;
          if (((ElementQuery)localObject1).lnT.equals(locala.mOX))
          {
            i = 1;
            label123:
            if (i != 0) {
              break label300;
            }
            localObject2 = new d();
            locala = new BankCardSelectSortView.a();
            locala.mOX = ((ElementQuery)localObject1).lnT;
            if (paramMap != null)
            {
              localObject1 = (e)paramMap.get(((ElementQuery)localObject1).mOb);
              if (localObject1 != null)
              {
                locala.bVO = ((e)localObject1).mEi;
                locala.qHC = ((e)localObject1).qtU;
                locala.ndQ = ((e)localObject1).ndQ;
              }
            }
            if (bk.bl(locala.ndQ)) {
              break label302;
            }
            y.d("WalletBankCardSelectUI", "have pinyin：%s", new Object[] { locala.ndQ });
          }
        }
      }
    }
    else
    {
      for (;;)
      {
        ((d)localObject2).vem = locala.ndQ.toUpperCase().charAt(0);
        ((d)localObject2).data = locala;
        this.qAn.add(localObject2);
        break label44;
        bool = false;
        break;
        i = 0;
        break label123;
        label300:
        break label44;
        label302:
        locala.ndQ = ae(locala.mOX, "#", "_");
      }
    }
    Collections.sort(this.qAn, new WalletBankCardSelectUI.a((byte)0));
    runOnUiThread(new WalletBankCardSelectUI.4(this));
  }
  
  public static String ae(String paramString1, String paramString2, String paramString3)
  {
    if (bk.bl(paramString1)) {}
    do
    {
      return paramString2;
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramString1.length();
      int i = 0;
      while (i < j)
      {
        String str = SpellMap.e(paramString1.charAt(i));
        if (!bk.bl(str))
        {
          localStringBuilder.append(str.toUpperCase());
          if (i != j - 1) {
            localStringBuilder.append(paramString3);
          }
        }
        i += 1;
      }
      paramString1 = localStringBuilder.toString();
      y.d("WalletBankCardSelectUI", "full py: %s", new Object[] { paramString1 });
    } while (bk.bl(paramString1));
    return paramString1;
  }
  
  public final boolean c(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  protected final int getLayoutId()
  {
    return a.g.wallet_bankcard_select_ui;
  }
  
  protected final void initView()
  {
    this.qAl = ((BankCardSelectSortView)findViewById(a.f.bankcard_sort_view));
    this.qAl.setOnItemClickListener(new WalletBankCardSelectUI.1(this));
    this.icu = new n((byte)0);
    this.icu.weq = new WalletBankCardSelectUI.2(this);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.bank_remit_select_bank_title);
    this.qAm = o.bVA().qqW;
    initView();
    this.qAn = new ArrayList();
    R(null);
    paramBundle = new a();
    Object localObject1 = o.bVA().qqW;
    LinkedList localLinkedList = new LinkedList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ElementQuery)((Iterator)localObject1).next();
      Bankcard localBankcard = new Bankcard();
      localBankcard.field_bankName = ((ElementQuery)localObject2).lnT;
      localBankcard.field_bankcardType = ((ElementQuery)localObject2).mOb;
      localLinkedList.add(localBankcard);
    }
    localObject1 = this.mController.uMN;
    localObject1 = new WalletBankCardSelectUI.3(this);
    Object localObject2 = new HashMap();
    if (localLinkedList.isEmpty())
    {
      y.w("MicroMsg.BankcardLogoHelper", "req is null");
      ((a.a)localObject1).S((Map)localObject2);
    }
    for (;;)
    {
      a(this.icu);
      return;
      f.ci(localLinkedList).d(new a.9(paramBundle)).d(new a.8(paramBundle, localLinkedList, (Map)localObject2, (a.a)localObject1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletBankCardSelectUI
 * JD-Core Version:    0.7.0.1
 */