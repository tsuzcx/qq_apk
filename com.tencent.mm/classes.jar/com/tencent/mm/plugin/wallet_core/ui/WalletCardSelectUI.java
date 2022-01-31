package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.v;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.q.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI
  extends WalletBaseUI
{
  private int tTs;
  private int tZc;
  private List<ElementQuery> upl;
  private List<ElementQuery> upm;
  private CheckedTextView upn;
  private CheckedTextView upo;
  private String upp;
  private int upq;
  private int upr;
  private int ups;
  private WalletCardSelectUI.a upt;
  private MaxListView upu;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(47307);
    this.upl = new LinkedList();
    this.upm = new LinkedList();
    this.tZc = 3;
    this.upr = -1;
    this.ups = -1;
    this.tTs = -1;
    AppMethodBeat.o(47307);
  }
  
  private void nL(boolean paramBoolean)
  {
    AppMethodBeat.i(47310);
    this.upu.setVisibility(0);
    if (paramBoolean)
    {
      this.upn.setChecked(true);
      this.upo.setChecked(false);
      this.upt.items = this.upl;
      this.upt.notifyDataSetChanged();
      this.upu.clearChoices();
      if (this.upr >= 0)
      {
        this.upu.setItemChecked(this.upr, true);
        enableOptionMenu(true);
        AppMethodBeat.o(47310);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(47310);
      return;
    }
    this.upn.setChecked(false);
    this.upo.setChecked(true);
    this.upt.items = this.upm;
    this.upt.notifyDataSetChanged();
    this.upu.clearChoices();
    if (this.ups >= 0)
    {
      this.upu.setItemChecked(this.ups, true);
      enableOptionMenu(true);
      AppMethodBeat.o(47310);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(47310);
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
    return 2130971157;
  }
  
  public void initView()
  {
    AppMethodBeat.i(47309);
    this.upp = getInput().getString("key_bank_type");
    this.upq = getInput().getInt("key_bankcard_type", 1);
    this.tZc = getInput().getInt("key_support_bankcard", 1);
    this.tTs = getInput().getInt("key_bind_scene", -1);
    this.upu = ((MaxListView)findViewById(2131829075));
    this.upn = ((CheckedTextView)findViewById(2131829073));
    this.upo = ((CheckedTextView)findViewById(2131829074));
    this.upt = new WalletCardSelectUI.a(this, this);
    this.upu.setAdapter(this.upt);
    this.upu.setOnItemClickListener(new WalletCardSelectUI.1(this));
    setBackBtn(new WalletCardSelectUI.2(this));
    addTextOptionMenu(0, getString(2131296964), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(47298);
        Object localObject = null;
        Intent localIntent = new Intent();
        if ((WalletCardSelectUI.b(WalletCardSelectUI.this).isChecked()) && (WalletCardSelectUI.c(WalletCardSelectUI.this) >= 0))
        {
          paramAnonymousMenuItem = (ElementQuery)WalletCardSelectUI.d(WalletCardSelectUI.this).get(WalletCardSelectUI.c(WalletCardSelectUI.this));
          if (paramAnonymousMenuItem == null) {
            break label149;
          }
          localIntent.putExtra("elemt_query", paramAnonymousMenuItem);
          WalletCardSelectUI.this.setResult(-1, localIntent);
        }
        for (;;)
        {
          WalletCardSelectUI.this.finish();
          AppMethodBeat.o(47298);
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
          label149:
          WalletCardSelectUI.this.setResult(0);
        }
      }
    }, null, q.b.zby);
    enableOptionMenu(false);
    this.upn.setOnClickListener(new WalletCardSelectUI.4(this));
    this.upo.setOnClickListener(new WalletCardSelectUI.5(this));
    AppMethodBeat.o(47309);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(47308);
    super.onCreate(paramBundle);
    setMMTitle(2131304986);
    initView();
    this.upm.clear();
    this.upl.clear();
    if (t.cTV().ubS != null)
    {
      paramBundle = t.cTV().ubS.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.tTs == 5) && (!localElementQuery.uhT)) {
          localElementQuery.uhD = getString(2131305749);
        }
        if (localElementQuery.cTh()) {
          this.upm.add(localElementQuery);
        } else if (localElementQuery.cTv()) {
          this.upl.add(localElementQuery);
        }
      }
    }
    if ((this.tZc == 3) && (!this.upm.isEmpty()))
    {
      if (!t.cTN().cUu()) {
        break label249;
      }
      Collections.sort(this.upm, new WalletCardSelectUI.6(this));
    }
    while (!this.upl.isEmpty()) {
      if (bo.isNullOrNil(this.upp))
      {
        this.upn.setChecked(false);
        this.upo.setChecked(false);
        this.upu.setVisibility(8);
        AppMethodBeat.o(47308);
        return;
        label249:
        Collections.sort(this.upm, new WalletCardSelectUI.7(this));
      }
      else
      {
        if (this.upq == 2)
        {
          j = this.upm.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.upm.get(i)).poq.equals(this.upp))
              {
                this.ups = i;
                nL(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.ups < 0)
              {
                nL(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(47308);
              return;
            }
            i += 1;
          }
        }
        j = this.upl.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.upl.get(i)).poq.equals(this.upp))
            {
              this.upr = i;
              nL(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.upr < 0)
            {
              nL(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(47308);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.upm.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.upm.get(i)).poq.equals(this.upp))
        {
          this.ups = i;
          nL(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.ups < 0)
        {
          nL(false);
          enableOptionMenu(false);
        }
        this.upn.setVisibility(8);
        this.upo.setBackgroundResource(2130838445);
        this.upo.setCheckMarkDrawable(2130840179);
        AppMethodBeat.o(47308);
        return;
      }
      i += 1;
    }
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
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */