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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int CGk;
  private int CMc;
  private List<ElementQuery> DeT;
  private List<ElementQuery> DeU;
  private CheckedTextView DeV;
  private CheckedTextView DeW;
  private String DeX;
  private int DeY;
  private int DeZ;
  private int Dfa;
  private a Dfb;
  private MaxListView Dfc;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.DeT = new LinkedList();
    this.DeU = new LinkedList();
    this.CMc = 3;
    this.DeZ = -1;
    this.Dfa = -1;
    this.CGk = -1;
    AppMethodBeat.o(70870);
  }
  
  private void ur(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.Dfc.setVisibility(0);
    if (paramBoolean)
    {
      this.DeV.setChecked(true);
      this.DeW.setChecked(false);
      this.Dfb.hJj = this.DeT;
      this.Dfb.notifyDataSetChanged();
      this.Dfc.clearChoices();
      if (this.DeZ >= 0)
      {
        this.Dfc.setItemChecked(this.DeZ, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.DeV.setChecked(false);
    this.DeW.setChecked(true);
    this.Dfb.hJj = this.DeU;
    this.Dfb.notifyDataSetChanged();
    this.Dfc.clearChoices();
    if (this.Dfa >= 0)
    {
      this.Dfc.setItemChecked(this.Dfa, true);
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
    this.DeX = getInput().getString("key_bank_type");
    this.DeY = getInput().getInt("key_bankcard_type", 1);
    this.CMc = getInput().getInt("key_support_bankcard", 1);
    this.CGk = getInput().getInt("key_bind_scene", -1);
    this.Dfc = ((MaxListView)findViewById(2131304653));
    this.DeV = ((CheckedTextView)findViewById(2131298251));
    this.DeW = ((CheckedTextView)findViewById(2131298252));
    this.Dfb = new a(this);
    this.Dfc.setAdapter(this.Dfb);
    this.Dfc.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        b localb = new b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).VF(paramAnonymousInt);
        if (!bt.isNullOrNil(paramAnonymousAdapterView.CWu))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.CWu, null, true, null);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.eFh()) {
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
    }, null, s.b.JbS);
    enableOptionMenu(false);
    this.DeV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70862);
      }
    });
    this.DeW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        b localb = new b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.DeU.clear();
    this.DeT.clear();
    if (t.eFG().CPh != null)
    {
      paramBundle = t.eFG().CPh.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.CGk == 5) && (!localElementQuery.CWK)) {
          localElementQuery.CWu = getString(2131765969);
        }
        if (localElementQuery.eET()) {
          this.DeU.add(localElementQuery);
        } else if (localElementQuery.eFh()) {
          this.DeT.add(localElementQuery);
        }
      }
    }
    if ((this.CMc == 3) && (!this.DeU.isEmpty()))
    {
      if (!t.eFy().eGj()) {
        break label249;
      }
      Collections.sort(this.DeU, new Comparator() {});
    }
    while (!this.DeT.isEmpty()) {
      if (bt.isNullOrNil(this.DeX))
      {
        this.DeV.setChecked(false);
        this.DeW.setChecked(false);
        this.Dfc.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label249:
        Collections.sort(this.DeU, new Comparator() {});
      }
      else
      {
        if (this.DeY == 2)
        {
          j = this.DeU.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.DeU.get(i)).dkR.equals(this.DeX))
              {
                this.Dfa = i;
                ur(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.Dfa < 0)
              {
                ur(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.DeT.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.DeT.get(i)).dkR.equals(this.DeX))
            {
              this.DeZ = i;
              ur(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.DeZ < 0)
            {
              ur(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.DeU.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.DeU.get(i)).dkR.equals(this.DeX))
        {
          this.Dfa = i;
          ur(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.Dfa < 0)
        {
          ur(false);
          enableOptionMenu(false);
        }
        this.DeV.setVisibility(8);
        this.DeW.setBackgroundResource(2131231818);
        this.DeW.setCheckMarkDrawable(2131233872);
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
    List<ElementQuery> hJj;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.hJj = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery VF(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.hJj.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.hJj.size();
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
      paramViewGroup.Dfe = ((CheckedTextView)localView.findViewById(2131298250));
      ElementQuery localElementQuery = (ElementQuery)this.hJj.get(paramInt);
      paramView = bt.bI(localElementQuery.uJF, "");
      if (!bt.isNullOrNil(localElementQuery.CWu))
      {
        paramView = paramView + "[" + localElementQuery.CWu + "]";
        paramViewGroup.Dfe.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.Dfe.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.Dfe.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = bt.isNullOrNil(((ElementQuery)this.hJj.get(paramInt)).CWu);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView Dfe;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */