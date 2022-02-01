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
import com.tencent.mm.an.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.w.b;
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
  private int OBy;
  private List<ElementQuery> OXX;
  private List<ElementQuery> OXY;
  private CheckedTextView OXZ;
  private CheckedTextView OYa;
  private String OYb;
  private int OYc;
  private int OYd;
  private int OYe;
  private a OYf;
  private MaxListView OYg;
  private int Ovx;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.OXX = new LinkedList();
    this.OXY = new LinkedList();
    this.OBy = 3;
    this.OYd = -1;
    this.OYe = -1;
    this.Ovx = -1;
    AppMethodBeat.o(70870);
  }
  
  private void Ci(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.OYg.setVisibility(0);
    if (paramBoolean)
    {
      this.OXZ.setChecked(true);
      this.OYa.setChecked(false);
      this.OYf.lxh = this.OXX;
      this.OYf.notifyDataSetChanged();
      this.OYg.clearChoices();
      if (this.OYd >= 0)
      {
        this.OYg.setItemChecked(this.OYd, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.OXZ.setChecked(false);
    this.OYa.setChecked(true);
    this.OYf.lxh = this.OXY;
    this.OYf.notifyDataSetChanged();
    this.OYg.clearChoices();
    if (this.OYe >= 0)
    {
      this.OYg.setItemChecked(this.OYe, true);
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
    return a.g.wallet_cardselect_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(70872);
    this.OYb = getInput().getString("key_bank_type");
    this.OYc = getInput().getInt("key_bankcard_type", 1);
    this.OBy = getInput().getInt("key_support_bankcard", 1);
    this.Ovx = getInput().getInt("key_bind_scene", -1);
    this.OYg = ((MaxListView)findViewById(a.f.settings_lv_bank));
    this.OXZ = ((CheckedTextView)findViewById(a.f.check_type_first_tv));
    this.OYa = ((CheckedTextView)findViewById(a.f.check_type_second_tv));
    this.OYf = new a(this);
    this.OYg.setAdapter(this.OYf);
    this.OYg.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        b localb = new b();
        localb.bn(paramAnonymousAdapterView);
        localb.bn(paramAnonymousView);
        localb.sg(paramAnonymousInt);
        localb.Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).amE(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.OPr))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.OPr, null, true, null);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.gIX()) {
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
    addTextOptionMenu(0, getString(a.i.app_finish), new MenuItem.OnMenuItemClickListener()
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
    }, null, w.b.Wao);
    enableOptionMenu(false);
    this.OXZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70862);
      }
    });
    this.OYa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        b localb = new b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
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
    setMMTitle(a.i.wallet_card_select_ui);
    initView();
    this.OXY.clear();
    this.OXX.clear();
    if (u.gJw().OIn != null)
    {
      paramBundle = u.gJw().OIn.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.Ovx == 5) && (!localElementQuery.OPH)) {
          localElementQuery.OPr = getString(a.i.wallet_wx_offline_no_support);
        }
        if (localElementQuery.gIJ()) {
          this.OXY.add(localElementQuery);
        } else if (localElementQuery.gIX()) {
          this.OXX.add(localElementQuery);
        }
      }
    }
    if ((this.OBy == 3) && (!this.OXY.isEmpty()))
    {
      if (!u.gJo().gJZ()) {
        break label251;
      }
      Collections.sort(this.OXY, new Comparator() {});
    }
    while (!this.OXX.isEmpty()) {
      if (Util.isNullOrNil(this.OYb))
      {
        this.OXZ.setChecked(false);
        this.OYa.setChecked(false);
        this.OYg.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label251:
        Collections.sort(this.OXY, new Comparator() {});
      }
      else
      {
        if (this.OYc == 2)
        {
          j = this.OXY.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.OXY.get(i)).fvP.equals(this.OYb))
              {
                this.OYe = i;
                Ci(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.OYe < 0)
              {
                Ci(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.OXX.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.OXX.get(i)).fvP.equals(this.OYb))
            {
              this.OYd = i;
              Ci(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.OYd < 0)
            {
              Ci(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.OXY.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.OXY.get(i)).fvP.equals(this.OYb))
        {
          this.OYe = i;
          Ci(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.OYe < 0)
        {
          Ci(false);
          enableOptionMenu(false);
        }
        this.OXZ.setVisibility(8);
        this.OYa.setBackgroundResource(a.e.comm_list_item_selector);
        this.OYa.setCheckMarkDrawable(a.e.round_selector);
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
    List<ElementQuery> lxh;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.lxh = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery amE(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.lxh.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.lxh.size();
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
      View localView = View.inflate(this.context, a.g.wallet_bank_select_item, null);
      paramViewGroup.OYi = ((CheckedTextView)localView.findViewById(a.f.check_tv_cv));
      ElementQuery localElementQuery = (ElementQuery)this.lxh.get(paramInt);
      paramView = Util.nullAs(localElementQuery.DNV, "");
      if (!Util.isNullOrNil(localElementQuery.OPr))
      {
        paramView = paramView + "[" + localElementQuery.OPr + "]";
        paramViewGroup.OYi.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.OYi.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.OYi.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = Util.isNullOrNil(((ElementQuery)this.lxh.get(paramInt)).OPr);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView OYi;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */