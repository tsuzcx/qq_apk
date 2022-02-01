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
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.s;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.bs;
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
  private List<ElementQuery> BEB;
  private List<ElementQuery> BEC;
  private CheckedTextView BED;
  private CheckedTextView BEE;
  private String BEF;
  private int BEG;
  private int BEH;
  private int BEI;
  private a BEJ;
  private MaxListView BEK;
  private int BfW;
  private int BlN;
  
  public WalletCardSelectUI()
  {
    AppMethodBeat.i(70870);
    this.BEB = new LinkedList();
    this.BEC = new LinkedList();
    this.BlN = 3;
    this.BEH = -1;
    this.BEI = -1;
    this.BfW = -1;
    AppMethodBeat.o(70870);
  }
  
  private void tH(boolean paramBoolean)
  {
    AppMethodBeat.i(70873);
    this.BEK.setVisibility(0);
    if (paramBoolean)
    {
      this.BED.setChecked(true);
      this.BEE.setChecked(false);
      this.BEJ.hqR = this.BEB;
      this.BEJ.notifyDataSetChanged();
      this.BEK.clearChoices();
      if (this.BEH >= 0)
      {
        this.BEK.setItemChecked(this.BEH, true);
        enableOptionMenu(true);
        AppMethodBeat.o(70873);
        return;
      }
      enableOptionMenu(false);
      AppMethodBeat.o(70873);
      return;
    }
    this.BED.setChecked(false);
    this.BEE.setChecked(true);
    this.BEJ.hqR = this.BEC;
    this.BEJ.notifyDataSetChanged();
    this.BEK.clearChoices();
    if (this.BEI >= 0)
    {
      this.BEK.setItemChecked(this.BEI, true);
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
    this.BEF = getInput().getString("key_bank_type");
    this.BEG = getInput().getInt("key_bankcard_type", 1);
    this.BlN = getInput().getInt("key_support_bankcard", 1);
    this.BfW = getInput().getInt("key_bind_scene", -1);
    this.BEK = ((MaxListView)findViewById(2131304653));
    this.BED = ((CheckedTextView)findViewById(2131298251));
    this.BEE = ((CheckedTextView)findViewById(2131298252));
    this.BEJ = new a(this);
    this.BEK.setAdapter(this.BEJ);
    this.BEK.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(70859);
        paramAnonymousAdapterView = WalletCardSelectUI.a(WalletCardSelectUI.this).TN(paramAnonymousInt);
        if (!bs.isNullOrNil(paramAnonymousAdapterView.Bwe))
        {
          h.a(WalletCardSelectUI.this, paramAnonymousAdapterView.Bwe, null, true, null);
          AppMethodBeat.o(70859);
          return;
        }
        if (paramAnonymousAdapterView.erh()) {
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
    }, null, s.b.Hom);
    enableOptionMenu(false);
    this.BED.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(70862);
        WalletCardSelectUI.a(WalletCardSelectUI.this, true);
        AppMethodBeat.o(70862);
      }
    });
    this.BEE.setOnClickListener(new View.OnClickListener()
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
    this.BEC.clear();
    this.BEB.clear();
    if (s.erG().BoS != null)
    {
      paramBundle = s.erG().BoS.iterator();
      while (paramBundle.hasNext())
      {
        ElementQuery localElementQuery = (ElementQuery)paramBundle.next();
        if ((this.BfW == 5) && (!localElementQuery.Bwu)) {
          localElementQuery.Bwe = getString(2131765969);
        }
        if (localElementQuery.eqT()) {
          this.BEC.add(localElementQuery);
        } else if (localElementQuery.erh()) {
          this.BEB.add(localElementQuery);
        }
      }
    }
    if ((this.BlN == 3) && (!this.BEC.isEmpty()))
    {
      if (!s.ery().esj()) {
        break label249;
      }
      Collections.sort(this.BEC, new Comparator() {});
    }
    while (!this.BEB.isEmpty()) {
      if (bs.isNullOrNil(this.BEF))
      {
        this.BED.setChecked(false);
        this.BEE.setChecked(false);
        this.BEK.setVisibility(8);
        AppMethodBeat.o(70871);
        return;
        label249:
        Collections.sort(this.BEC, new Comparator() {});
      }
      else
      {
        if (this.BEG == 2)
        {
          j = this.BEC.size();
          i = 0;
          for (;;)
          {
            if (i < j)
            {
              if (((ElementQuery)this.BEC.get(i)).cZz.equals(this.BEF))
              {
                this.BEI = i;
                tH(false);
                enableOptionMenu(true);
              }
            }
            else
            {
              if (this.BEI < 0)
              {
                tH(false);
                enableOptionMenu(false);
              }
              AppMethodBeat.o(70871);
              return;
            }
            i += 1;
          }
        }
        j = this.BEB.size();
        i = 0;
        for (;;)
        {
          if (i < j)
          {
            if (((ElementQuery)this.BEB.get(i)).cZz.equals(this.BEF))
            {
              this.BEH = i;
              tH(true);
              enableOptionMenu(true);
            }
          }
          else
          {
            if (this.BEH < 0)
            {
              tH(false);
              enableOptionMenu(false);
            }
            AppMethodBeat.o(70871);
            return;
          }
          i += 1;
        }
      }
    }
    int j = this.BEC.size();
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        if (((ElementQuery)this.BEC.get(i)).cZz.equals(this.BEF))
        {
          this.BEI = i;
          tH(false);
          enableOptionMenu(true);
        }
      }
      else
      {
        if (this.BEI < 0)
        {
          tH(false);
          enableOptionMenu(false);
        }
        this.BED.setVisibility(8);
        this.BEE.setBackgroundResource(2131231818);
        this.BEE.setCheckMarkDrawable(2131233872);
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
    List<ElementQuery> hqR;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(70864);
      this.hqR = new ArrayList();
      this.context = paramContext;
      AppMethodBeat.o(70864);
    }
    
    public final ElementQuery TN(int paramInt)
    {
      AppMethodBeat.i(70868);
      ElementQuery localElementQuery = (ElementQuery)this.hqR.get(paramInt);
      AppMethodBeat.o(70868);
      return localElementQuery;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(70867);
      int i = this.hqR.size();
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
      paramViewGroup.BEM = ((CheckedTextView)localView.findViewById(2131298250));
      ElementQuery localElementQuery = (ElementQuery)this.hqR.get(paramInt);
      paramView = bs.bG(localElementQuery.tGS, "");
      if (!bs.isNullOrNil(localElementQuery.Bwe))
      {
        paramView = paramView + "[" + localElementQuery.Bwe + "]";
        paramViewGroup.BEM.setEnabled(false);
      }
      for (;;)
      {
        paramViewGroup.BEM.setText(paramView);
        AppMethodBeat.o(70866);
        return localView;
        paramViewGroup.BEM.setEnabled(true);
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      AppMethodBeat.i(70865);
      boolean bool = bs.isNullOrNil(((ElementQuery)this.hqR.get(paramInt)).Bwe);
      AppMethodBeat.o(70865);
      return bool;
    }
    
    final class a
    {
      CheckedTextView BEM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.ui.WalletCardSelectUI
 * JD-Core Version:    0.7.0.1
 */