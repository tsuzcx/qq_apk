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
import com.tencent.mm.ak.n;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s.b;
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
  private int CXQ;
  private int DdK;
  private CheckedTextView DwA;
  private String DwB;
  private int DwC;
  private int DwD;
  private int DwE;
  private a DwF;
  private MaxListView DwG;
  private List<ElementQuery> Dwx;
  private List<ElementQuery> Dwy;
  private CheckedTextView Dwz;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.Dwx = new LinkedList();
    this.Dwy = new LinkedList();
    this.DdK = 3;
    this.DwD = -1;
    this.DwE = -1;
    this.CXQ = -1;
    AppMethodBeat.o(70870);
  }
  
  private void uz(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.DwG.setVisibility(0);
    if (paramBoolean)
    {
      this.Dwz.setChecked(true);
      this.DwA.setChecked(false);
      this.DwF.hMc = this.Dwx;
      this.DwF.notifyDataSetChanged();
      this.DwG.clearChoices();
      if (this.DwD >= 0)
      {
        this.DwG.setItemChecked(this.DwD, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.Dwz.setChecked(false);
    this.DwA.setChecked(true);
    this.DwF.hMc = this.Dwy;
    this.DwF.notifyDataSetChanged();
    this.DwG.clearChoices();
    if (this.DwE >= 0)
    {
      this.DwG.setItemChecked(this.DwE, true);
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
    this.DwB = getInput().getString("key_bank_type");
    this.DwC = getInput().getInt("key_bankcard_type", 1);
    this.DdK = getInput().getInt("key_support_bankcard", 1);
    this.CXQ = getInput().getInt("key_bind_scene", -1);
    this.DwG = ((MaxListView)findViewById(2131304653));
    this.Dwz = ((CheckedTextView)findViewById(2131298251));
    this.DwA = ((CheckedTextView)findViewById(2131298252));
    this.DwF = new a(this);
    this.DwG.setAdapter(this.DwF);
    this.DwG.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mu(paramAnonymousInt);
        localb.rl(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).Wm(paramAnonymousInt);
        if (!bu.isNullOrNil(paramAnonymousAdapterView.DnZ))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.DnZ, null, true, null);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.eIO()) {
          WalletCardSelectUI.a(WalletCardSelectUI.this, paramAnonymousInt);
        }
        for (;;)
        {
          WalletCardSelectUI.this.enableOptionMenu(true);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
    }, null, s.b.JwA);
    enableOptionMenu(false);
    this.Dwz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70862);
      }
    });
    this.DwA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        WalletCardSelectUI.a(WalletCardSelectUI.this, false);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
    this.Dwy.clear();
    this.Dwx.clear();
    if (t.eJn().DgL != null)
    {
      paramBundle = t.eJn().DgL.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.CXQ == 5) && (!localElementQuery.Dop)) {
          localElementQuery.DnZ = getString(2131765969);
        }
        if (localElementQuery.eIA()) {
          this.Dwy.add(localElementQuery);
        } else if (localElementQuery.eIO()) {
          this.Dwx.add(localElementQuery);
        }
      }
    }
    if ((this.DdK == 3) && (!this.Dwy.isEmpty()))
    {
      if (!t.eJf().eJQ()) {
        break label249;
      }
      Collections.sort(this.Dwy, new Comparator() {});
    }
    while (!this.Dwx.isEmpty()) {
      if (bu.isNullOrNil(this.DwB))
      {
        this.Dwz.setChecked(false);
        this.DwA.setChecked(false);
        this.DwG.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label249:
        Collections.sort(this.Dwy, new Comparator() {});
      }
      else
      {
        if (this.DwC == 2)
        {
          j = this.Dwy.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.Dwy.get(i)).dlT.equals(this.DwB))
              {
                this.DwE = i;
                uz(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.DwE < 0)
              {
                uz(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.Dwx.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.Dwx.get(i)).dlT.equals(this.DwB))
            {
              this.DwD = i;
              uz(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.DwD < 0)
            {
              uz(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.Dwy.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.Dwy.get(i)).dlT.equals(this.DwB))
        {
          this.DwE = i;
          uz(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.DwE < 0)
        {
          uz(false);
          enableOptionMenu(false);
        }
        this.Dwz.setVisibility(8);
        this.DwA.setBackgroundResource(2131231818);
        this.DwA.setCheckMarkDrawable(2131233872);
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
    List<ElementQuery> hMc;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.hMc = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery Wm(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.hMc.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.hMc.size();
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
      paramViewGroup.DwI = ((CheckedTextView)localView.findViewById(2131298250));
      ElementQuery localElementQuery = (ElementQuery)this.hMc.get(paramInt);
      paramView = bu.bI(localElementQuery.uVs, "");
      if (!bu.isNullOrNil(localElementQuery.DnZ))
      {
        paramView = paramView + "[" + localElementQuery.DnZ + "]";
        paramViewGroup.DwI.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.DwI.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.DwI.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = bu.isNullOrNil(((ElementQuery)this.hMc.get(paramInt)).DnZ);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView DwI;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */