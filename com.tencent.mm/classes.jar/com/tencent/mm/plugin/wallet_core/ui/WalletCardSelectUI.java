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
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.model.x;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
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
  private int HDE;
  private int HJE;
  private List<ElementQuery> IfI;
  private List<ElementQuery> IfJ;
  private CheckedTextView IfK;
  private CheckedTextView IfL;
  private String IfM;
  private int IfN;
  private int IfO;
  private int IfP;
  private a IfQ;
  private MaxListView IfR;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.IfI = new LinkedList();
    this.IfJ = new LinkedList();
    this.HJE = 3;
    this.IfO = -1;
    this.IfP = -1;
    this.HDE = -1;
    AppMethodBeat.o(70870);
  }
  
  private void yn(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.IfR.setVisibility(0);
    if (paramBoolean)
    {
      this.IfK.setChecked(true);
      this.IfL.setChecked(false);
      this.IfQ.iHf = this.IfI;
      this.IfQ.notifyDataSetChanged();
      this.IfR.clearChoices();
      if (this.IfO >= 0)
      {
        this.IfR.setItemChecked(this.IfO, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.IfK.setChecked(false);
    this.IfL.setChecked(true);
    this.IfQ.iHf = this.IfJ;
    this.IfQ.notifyDataSetChanged();
    this.IfR.clearChoices();
    if (this.IfP >= 0)
    {
      this.IfR.setItemChecked(this.IfP, true);
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
    return 2131496911;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70872);
    this.IfM = getInput().getString("key_bank_type");
    this.IfN = getInput().getInt("key_bankcard_type", 1);
    this.HJE = getInput().getInt("key_support_bankcard", 1);
    this.HDE = getInput().getInt("key_bind_scene", -1);
    this.IfR = ((MaxListView)findViewById(2131307706));
    this.IfK = ((CheckedTextView)findViewById(2131298635));
    this.IfL = ((CheckedTextView)findViewById(2131298636));
    this.IfQ = new a(this);
    this.IfR.setAdapter(this.IfQ);
    this.IfR.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).aeQ(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.HXr))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.HXr, null, true, null);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.fQr()) {
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
    addTextOptionMenu(0, getString(2131755858), new MenuItem.OnMenuItemClickListener()
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
    }, null, t.b.OGU);
    enableOptionMenu(false);
    this.IfK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70862);
      }
    });
    this.IfL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    setMMTitle(2131767621);
    initView();
    this.IfJ.clear();
    this.IfI.clear();
    if (t.fQQ().HQe != null)
    {
      paramBundle = t.fQQ().HQe.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.HDE == 5) && (!localElementQuery.HXH)) {
          localElementQuery.HXr = getString(2131768422);
        }
        if (localElementQuery.fQd()) {
          this.IfJ.add(localElementQuery);
        } else if (localElementQuery.fQr()) {
          this.IfI.add(localElementQuery);
        }
      }
    }
    if ((this.HJE == 3) && (!this.IfJ.isEmpty()))
    {
      if (!t.fQI().fRt()) {
        break label249;
      }
      Collections.sort(this.IfJ, new Comparator() {});
    }
    while (!this.IfI.isEmpty()) {
      if (Util.isNullOrNil(this.IfM))
      {
        this.IfK.setChecked(false);
        this.IfL.setChecked(false);
        this.IfR.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label249:
        Collections.sort(this.IfJ, new Comparator() {});
      }
      else
      {
        if (this.IfN == 2)
        {
          j = this.IfJ.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.IfJ.get(i)).dDj.equals(this.IfM))
              {
                this.IfP = i;
                yn(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.IfP < 0)
              {
                yn(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.IfI.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.IfI.get(i)).dDj.equals(this.IfM))
            {
              this.IfO = i;
              yn(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.IfO < 0)
            {
              yn(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.IfJ.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.IfJ.get(i)).dDj.equals(this.IfM))
        {
          this.IfP = i;
          yn(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.IfP < 0)
        {
          yn(false);
          enableOptionMenu(false);
        }
        this.IfK.setVisibility(8);
        this.IfL.setBackgroundResource(2131231898);
        this.IfL.setCheckMarkDrawable(2131234697);
        AppMethodBeat.o(70871);
        return;
      }
      i += 1;
    }
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
  
  public final class a
    extends BaseAdapter
  {
    private Context context;
    List<ElementQuery> iHf;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.iHf = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery aeQ(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.iHf.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.iHf.size();
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
      View localView = View.inflate(this.context, 2131496890, null);
      paramViewGroup.IfT = ((CheckedTextView)localView.findViewById(2131298634));
      ElementQuery localElementQuery = (ElementQuery)this.iHf.get(paramInt);
      paramView = Util.nullAs(localElementQuery.ynT, "");
      if (!Util.isNullOrNil(localElementQuery.HXr))
      {
        paramView = paramView + "[" + localElementQuery.HXr + "]";
        paramViewGroup.IfT.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.IfT.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.IfT.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = Util.isNullOrNil(((ElementQuery)this.iHf.get(paramInt)).HXr);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView IfT;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */