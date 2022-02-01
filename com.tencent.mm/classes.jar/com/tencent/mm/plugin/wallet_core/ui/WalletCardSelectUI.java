package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI
  extends WalletBaseUI
{
  private List<ElementQuery> Amg;
  private List<ElementQuery> Amh;
  private CheckedTextView Ami;
  private CheckedTextView Amj;
  private String Amk;
  private int Aml;
  private int Amm;
  private int Amn;
  private a Amo;
  private MaxListView Amp;
  private int zNC;
  private int zTt;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.Amg = new LinkedList();
    this.Amh = new LinkedList();
    this.zTt = 3;
    this.Amm = -1;
    this.Amn = -1;
    this.zNC = -1;
    AppMethodBeat.o(70870);
  }
  
  private void sG(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.Amp.setVisibility(0);
    if (paramBoolean)
    {
      this.Ami.setChecked(true);
      this.Amj.setChecked(false);
      this.Amo.gQr = this.Amg;
      this.Amo.notifyDataSetChanged();
      this.Amp.clearChoices();
      if (this.Amm >= 0)
      {
        this.Amp.setItemChecked(this.Amm, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.Ami.setChecked(false);
    this.Amj.setChecked(true);
    this.Amo.gQr = this.Amh;
    this.Amo.notifyDataSetChanged();
    this.Amp.clearChoices();
    if (this.Amn >= 0)
    {
      this.Amp.setItemChecked(this.Amn, true);
      enableOptionMenu(true);
      AppMethodBeat.o(70873);
      return;
    }
    enableOptionMenu(false);
    AppMethodBeat.o(70873);
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
    return 2131495931;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70872);
    this.Amk = getInput().getString("key_bank_type");
    this.Aml = getInput().getInt("key_bankcard_type", 1);
    this.zTt = getInput().getInt("key_support_bankcard", 1);
    this.zNC = getInput().getInt("key_bind_scene", -1);
    this.Amp = ((MaxListView)findViewById(2131304653));
    this.Ami = ((CheckedTextView)findViewById(2131298251));
    this.Amj = ((CheckedTextView)findViewById(2131298252));
    this.Amo = new a(this);
    this.Amp.setAdapter(this.Amo);
    this.Amp.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).RE(paramAnonymousInt);
        if (!bt.isNullOrNil(paramAnonymousAdapterView.AdK))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.AdK, null, true, null);
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.ebL()) {
          WalletCardSelectUI.a(WalletCardSelectUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          WalletCardSelectUI.this.enableOptionMenu(true);
          AppMethodBeat.o(70859);
          return;
          WalletCardSelectUI.b(WalletCardSelectUI.this, paramAnonymousInt);
        }
      }
    });
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70860);
        WalletCardSelectUI.this.finish();
        AppMethodBeat.o(70860);
        return true;
      }
    });
    addTextOptionMenu(0, getString(2131755779), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(70861);
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
          AppMethodBeat.o(70861);
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
    }, null, r.b.FOB);
    enableOptionMenu(false);
    this.Ami.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        AppMethodBeat.o(70862);
      }
    });
    this.Amj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        WalletCardSelectUI.a(WalletCardSelectUI.this, false);
        AppMethodBeat.o(70863);
      }
    });
    AppMethodBeat.o(70872);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(70871);
    super.onCreate(paramBundle);
    setMMTitle(2131765178);
    initView();
    this.Amh.clear();
    this.Amg.clear();
    if (s.eck().zWy != null)
    {
      paramBundle = s.eck().zWy.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.zNC == 5) && (!localElementQuery.Aea)) {
          localElementQuery.AdK = getString(2131765969);
        }
        if (localElementQuery.ebx()) {
          this.Amh.add(localElementQuery);
        } else if (localElementQuery.ebL()) {
          this.Amg.add(localElementQuery);
        }
      }
    }
    if ((this.zTt == 3) && (!this.Amh.isEmpty()))
    {
      if (!s.ecc().ecO()) {
        break label249;
      }
      Collections.sort(this.Amh, new Comparator() {});
    }
    while (!this.Amg.isEmpty()) {
      if (bt.isNullOrNil(this.Amk))
      {
        this.Ami.setChecked(false);
        this.Amj.setChecked(false);
        this.Amp.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label249:
        Collections.sort(this.Amh, new Comparator() {});
      }
      else
      {
        if (this.Aml == 2)
        {
          j = this.Amh.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.Amh.get(i)).dca.equals(this.Amk))
              {
                this.Amn = i;
                sG(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.Amn < 0)
              {
                sG(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.Amg.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.Amg.get(i)).dca.equals(this.Amk))
            {
              this.Amm = i;
              sG(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.Amm < 0)
            {
              sG(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.Amh.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.Amh.get(i)).dca.equals(this.Amk))
        {
          this.Amn = i;
          sG(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.Amn < 0)
        {
          sG(false);
          enableOptionMenu(false);
        }
        this.Ami.setVisibility(8);
        this.Amj.setBackgroundResource(2131231818);
        this.Amj.setCheckMarkDrawable(2131233872);
        AppMethodBeat.o(70871);
        return;
      }
      i += 1;
    }
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
  
  public final class a
    extends BaseAdapter
  {
    private Context context;
    List<ElementQuery> gQr;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.gQr = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery RE(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.gQr.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.gQr.size();
      AppMethodBeat.o(70867);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(70866);
      paramViewGroup = new a();
      View localView = View.inflate(this.context, 2131495910, null);
      paramViewGroup.Amr = ((CheckedTextView)localView.findViewById(2131298250));
      ElementQuery localElementQuery = (ElementQuery)this.gQr.get(paramInt);
      paramView = bt.by(localElementQuery.szi, "");
      if (!bt.isNullOrNil(localElementQuery.AdK))
      {
        paramView = paramView + "[" + localElementQuery.AdK + "]";
        paramViewGroup.Amr.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.Amr.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.Amr.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = bt.isNullOrNil(((ElementQuery)this.gQr.get(paramInt)).AdK);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView Amr;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */