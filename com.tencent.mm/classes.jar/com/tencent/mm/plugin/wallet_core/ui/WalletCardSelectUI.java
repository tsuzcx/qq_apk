package com.tencent.mm.plugin.wallet_core.ui;

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
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.u;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.y.b;
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
  private List<ElementQuery> VOl;
  private List<ElementQuery> VOm;
  private CheckedTextView VOn;
  private CheckedTextView VOo;
  private String VOp;
  private int VOq;
  private int VOr;
  private int VOs;
  private a VOt;
  private MaxListView VOu;
  private int VkK;
  private int VqL;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.VOl = new LinkedList();
    this.VOm = new LinkedList();
    this.VqL = 3;
    this.VOr = -1;
    this.VOs = -1;
    this.VkK = -1;
    AppMethodBeat.o(70870);
  }
  
  private void HN(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.VOu.setVisibility(0);
    if (paramBoolean)
    {
      this.VOn.setChecked(true);
      this.VOo.setChecked(false);
      this.VOt.bMQ = this.VOl;
      this.VOt.notifyDataSetChanged();
      this.VOu.clearChoices();
      if (this.VOr >= 0)
      {
        this.VOu.setItemChecked(this.VOr, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.VOn.setChecked(false);
    this.VOo.setChecked(true);
    this.VOt.bMQ = this.VOm;
    this.VOt.notifyDataSetChanged();
    this.VOu.clearChoices();
    if (this.VOs >= 0)
    {
      this.VOu.setItemChecked(this.VOs, true);
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
    this.VOp = getInput().getString("key_bank_type");
    this.VOq = getInput().getInt("key_bankcard_type", 1);
    this.VqL = getInput().getInt("key_support_bankcard", 1);
    this.VkK = getInput().getInt("key_bind_scene", -1);
    this.VOu = ((MaxListView)findViewById(a.f.settings_lv_bank));
    this.VOn = ((CheckedTextView)findViewById(a.f.check_type_first_tv));
    this.VOo = ((CheckedTextView)findViewById(a.f.check_type_second_tv));
    this.VOt = new a(this);
    this.VOu.setAdapter(this.VOt);
    this.VOu.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).ast(paramAnonymousInt);
        if (!Util.isNullOrNil(paramAnonymousAdapterView.VFl))
        {
          k.a(WalletCardSelectUI.this, paramAnonymousAdapterView.VFl, null, true, null);
          a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.iil()) {
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
    }, null, y.b.adEJ);
    enableOptionMenu(false);
    this.VOn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(70862);
      }
    });
    this.VOo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70863);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/wallet_core/ui/WalletCardSelectUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
    this.VOm.clear();
    this.VOl.clear();
    if (u.iiK().VxZ != null)
    {
      paramBundle = u.iiK().VxZ.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.VkK == 5) && (!localElementQuery.VFB)) {
          localElementQuery.VFl = getString(a.i.wallet_wx_offline_no_support);
        }
        if (localElementQuery.ihX()) {
          this.VOm.add(localElementQuery);
        } else if (localElementQuery.iil()) {
          this.VOl.add(localElementQuery);
        }
      }
    }
    if ((this.VqL == 3) && (!this.VOm.isEmpty()))
    {
      if (!u.iiC().ijq()) {
        break label251;
      }
      Collections.sort(this.VOm, new Comparator() {});
    }
    while (!this.VOl.isEmpty()) {
      if (Util.isNullOrNil(this.VOp))
      {
        this.VOn.setChecked(false);
        this.VOo.setChecked(false);
        this.VOu.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label251:
        Collections.sort(this.VOm, new Comparator() {});
      }
      else
      {
        if (this.VOq == 2)
        {
          j = this.VOm.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.VOm.get(i)).hAk.equals(this.VOp))
              {
                this.VOs = i;
                HN(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.VOs < 0)
              {
                HN(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.VOl.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.VOl.get(i)).hAk.equals(this.VOp))
            {
              this.VOr = i;
              HN(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.VOr < 0)
            {
              HN(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.VOm.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.VOm.get(i)).hAk.equals(this.VOp))
        {
          this.VOs = i;
          HN(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.VOs < 0)
        {
          HN(false);
          enableOptionMenu(false);
        }
        this.VOn.setVisibility(8);
        this.VOo.setBackgroundResource(a.e.comm_list_item_selector);
        this.VOo.setCheckMarkDrawable(a.e.round_selector);
        AppMethodBeat.o(70871);
        return;
      }
      i += 1;
    }
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
  
  public final class a
    extends BaseAdapter
  {
    List<ElementQuery> bMQ;
    private Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.bMQ = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery ast(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.bMQ.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.bMQ.size();
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
      paramViewGroup.VOw = ((CheckedTextView)localView.findViewById(a.f.check_tv_cv));
      ElementQuery localElementQuery = (ElementQuery)this.bMQ.get(paramInt);
      paramView = Util.nullAs(localElementQuery.JFk, "");
      if (!Util.isNullOrNil(localElementQuery.VFl))
      {
        paramView = paramView + "[" + localElementQuery.VFl + "]";
        paramViewGroup.VOw.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.VOw.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.VOw.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = Util.isNullOrNil(((ElementQuery)this.bMQ.get(paramInt)).VFl);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView VOw;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */