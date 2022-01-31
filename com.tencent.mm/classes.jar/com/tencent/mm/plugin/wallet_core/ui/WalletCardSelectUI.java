package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckedTextView;
import com.tencent.mm.ah.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.model.q;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI
  extends WalletBaseUI
{
  private List<ElementQuery> qCB = new LinkedList();
  private List<ElementQuery> qCC = new LinkedList();
  private CheckedTextView qCD;
  private CheckedTextView qCE;
  private String qCF;
  private int qCG;
  private int qCH = -1;
  private int qCI = -1;
  private WalletCardSelectUI.a qCJ;
  private MaxListView qCK;
  private int qks = -1;
  private int qoP = 3;
  
  private void kE(boolean paramBoolean)
  {
    this.qCK.setVisibility(0);
    if (paramBoolean)
    {
      this.qCD.setChecked(true);
      this.qCE.setChecked(false);
      this.qCJ.items = this.qCB;
      this.qCJ.notifyDataSetChanged();
      this.qCK.clearChoices();
      if (this.qCH >= 0)
      {
        this.qCK.setItemChecked(this.qCH, true);
        enableOptionMenu(true);
        return;
      }
      enableOptionMenu(false);
      return;
    }
    this.qCD.setChecked(false);
    this.qCE.setChecked(true);
    this.qCJ.items = this.qCC;
    this.qCJ.notifyDataSetChanged();
    this.qCK.clearChoices();
    if (this.qCI >= 0)
    {
      this.qCK.setItemChecked(this.qCI, true);
      enableOptionMenu(true);
      return;
    }
    enableOptionMenu(false);
  }
  
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
    return a.g.wallet_cardselect_ui;
  }
  
  public final void initView()
  {
    this.qCF = this.BX.getString("key_bank_type");
    this.qCG = this.BX.getInt("key_bankcard_type", 1);
    this.qoP = this.BX.getInt("key_support_bankcard", 1);
    this.qks = this.BX.getInt("key_bind_scene", -1);
    this.qCK = ((MaxListView)findViewById(a.f.settings_lv_bank));
    this.qCD = ((CheckedTextView)findViewById(a.f.check_type_first_tv));
    this.qCE = ((CheckedTextView)findViewById(a.f.check_type_second_tv));
    this.qCJ = new WalletCardSelectUI.a(this, this);
    this.qCK.setAdapter(this.qCJ);
    this.qCK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).AU(paramAnonymousInt);
        if (!bk.bl(paramAnonymousAdapterView.qvl))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.qvl, null, true, null);
          return;
        }
        if (paramAnonymousAdapterView.bVc()) {
          WalletCardSelectUI.a(WalletCardSelectUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          WalletCardSelectUI.this.enableOptionMenu(true);
          return;
          WalletCardSelectUI.b(WalletCardSelectUI.this, paramAnonymousInt);
        }
      }
    });
    setBackBtn(new WalletCardSelectUI.2(this));
    a(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        Object localObject = null;
        Intent localIntent = new Intent();
        if ((WalletCardSelectUI.b(WalletCardSelectUI.this).isChecked()) && (WalletCardSelectUI.c(WalletCardSelectUI.this) >= 0))
        {
          paramAnonymousMenuItem = (ElementQuery)WalletCardSelectUI.d(WalletCardSelectUI.this).get(WalletCardSelectUI.c(WalletCardSelectUI.this));
          if (paramAnonymousMenuItem == null) {
            break label139;
          }
          localIntent.putExtra("elemt_query", paramAnonymousMenuItem);
          WalletCardSelectUI.this.setResult(-1, localIntent);
        }
        for (;;)
        {
          WalletCardSelectUI.this.finish();
          return true;
          paramAnonymousMenuItem = localObject;
          if (!WalletCardSelectUI.e(WalletCardSelectUI.this).isChecked()) {
            break;
          }
          paramAnonymousMenuItem = localObject;
          if (WalletCardSelectUI.f(WalletCardSelectUI.this) < 0) {
            break;
          }
          paramAnonymousMenuItem = (ElementQuery)WalletCardSelectUI.g(WalletCardSelectUI.this).get(WalletCardSelectUI.f(WalletCardSelectUI.this));
          break;
          label139:
          WalletCardSelectUI.this.setResult(0);
        }
      }
    }, s.b.uNx);
    enableOptionMenu(false);
    this.qCD.setOnClickListener(new WalletCardSelectUI.4(this));
    this.qCE.setOnClickListener(new WalletCardSelectUI.5(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.wallet_card_select_ui);
    initView();
    this.qCC.clear();
    this.qCB.clear();
    if (o.bVA().qqW != null)
    {
      paramBundle = o.bVA().qqW.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.qks == 5) && (!localElementQuery.qvB)) {
          localElementQuery.qvl = getString(a.i.wallet_wx_offline_no_support);
        }
        if (localElementQuery.bUS()) {
          this.qCC.add(localElementQuery);
        } else if (localElementQuery.bVc()) {
          this.qCB.add(localElementQuery);
        }
      }
    }
    if ((this.qoP == 3) && (!this.qCC.isEmpty()))
    {
      if (!o.bVs().bVS()) {
        break label241;
      }
      Collections.sort(this.qCC, new WalletCardSelectUI.6(this));
    }
    while (!this.qCB.isEmpty()) {
      if (bk.bl(this.qCF))
      {
        this.qCD.setChecked(false);
        this.qCE.setChecked(false);
        this.qCK.setVisibility(8);
        return;
        label241:
        Collections.sort(this.qCC, new WalletCardSelectUI.7(this));
      }
      else
      {
        if (this.qCG == 2)
        {
          j = this.qCC.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.qCC.get(i)).mOb.equals(this.qCF))
              {
                this.qCI = i;
                kE(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.qCI >= 0) {
                break;
              }
              kE(false);
              enableOptionMenu(false);
              return;
            }
            i += 1;
          }
        }
        j = this.qCB.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.qCB.get(i)).mOb.equals(this.qCF))
            {
              this.qCH = i;
              kE(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.qCH >= 0) {
              break;
            }
            kE(false);
            enableOptionMenu(false);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.qCC.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.qCC.get(i)).mOb.equals(this.qCF))
        {
          this.qCI = i;
          kE(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.qCI < 0)
        {
          kE(false);
          enableOptionMenu(false);
        }
        this.qCD.setVisibility(8);
        this.qCE.setBackgroundResource(a.e.comm_list_item_selector);
        this.qCE.setCheckMarkDrawable(a.e.round_selector);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */