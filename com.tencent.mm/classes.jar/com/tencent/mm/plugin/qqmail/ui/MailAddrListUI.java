package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.b.o;
import com.tencent.mm.plugin.qqmail.b.q;
import com.tencent.mm.plugin.qqmail.b.q.a;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailAddrListUI
  extends MMActivity
{
  private TextView iNs;
  private q vUL;
  private com.tencent.mm.ui.base.p vYj;
  private TextView vYk;
  private ListView vYl;
  private a vYm;
  private List<com.tencent.mm.plugin.qqmail.b.p> vYn;
  private q.a vYo;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(123053);
    this.vYj = null;
    this.iNs = null;
    this.vYk = null;
    this.vUL = null;
    this.vYo = new q.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123037);
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).apU(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131763379);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject1 = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
        if (localObject1 == null) {
          localObject1 = new String[] { "" };
        }
        for (;;)
        {
          int k = localObject1.length;
          int i = 0;
          Object localObject2;
          Object localObject3;
          if (i < k)
          {
            localObject2 = q.apV(localObject1[i]);
            if (localObject2 != null)
            {
              localObject3 = MailAddrListUI.c(MailAddrListUI.this).iterator();
              while (((Iterator)localObject3).hasNext())
              {
                com.tencent.mm.plugin.qqmail.b.p localp = (com.tencent.mm.plugin.qqmail.b.p)((Iterator)localObject3).next();
                if (localp.tWE.equalsIgnoreCase(((com.tencent.mm.plugin.qqmail.b.p)localObject2).tWE)) {
                  MailAddrListUI.e(MailAddrListUI.this).c(localp);
                }
              }
            }
          }
          for (int j = 1;; j = 0)
          {
            if (j == 0) {
              MailAddrListUI.e(MailAddrListUI.this).c((com.tencent.mm.plugin.qqmail.b.p)localObject2);
            }
            i += 1;
            break;
            localObject2 = MailAddrListUI.this;
            localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(2131761948));
            if (MailAddrListUI.e(MailAddrListUI.this).dsn() > 0) {}
            for (localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).dsn() + ")";; localObject1 = "")
            {
              ((MailAddrListUI)localObject2).setMMTitle((String)localObject1);
              MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
              AppMethodBeat.o(123037);
              return;
            }
          }
        }
      }
    };
    AppMethodBeat.o(123053);
  }
  
  public int getLayoutId()
  {
    return 2131495154;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123055);
    this.vYl = ((ListView)findViewById(2131303581));
    this.iNs = ((TextView)findViewById(2131299475));
    this.vYk = ((TextView)findViewById(2131302890));
    this.vYm = new a(this);
    Object localObject = new r((byte)0);
    ((r)localObject).ITM = new r.b()
    {
      public final boolean Ga(String paramAnonymousString)
      {
        return false;
      }
      
      public final void Gb(String paramAnonymousString)
      {
        AppMethodBeat.i(123038);
        paramAnonymousString = bs.bG(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).apU(paramAnonymousString.toLowerCase().trim()));
        if (paramAnonymousString.length() > 0)
        {
          MailAddrListUI.e(MailAddrListUI.this).vYr = true;
          MailAddrListUI.e(MailAddrListUI.this).vYq = false;
          if (MailAddrListUI.c(MailAddrListUI.this).size() != 0) {
            break label130;
          }
          MailAddrListUI.this.enableOptionMenu(false);
          MailAddrListUI.f(MailAddrListUI.this).setVisibility(0);
        }
        for (;;)
        {
          MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
          AppMethodBeat.o(123038);
          return;
          MailAddrListUI.e(MailAddrListUI.this).vYr = false;
          break;
          label130:
          MailAddrListUI.this.enableOptionMenu(true);
          MailAddrListUI.f(MailAddrListUI.this).setVisibility(8);
        }
      }
      
      public final void aPa() {}
      
      public final void aPb() {}
      
      public final void aPc() {}
      
      public final void aPd() {}
    };
    addSearchMenu(true, (r)localObject);
    this.vYl.setAdapter(this.vYm);
    this.vYl.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(123039);
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.LO(paramAnonymousInt - MailAddrListUI.g(MailAddrListUI.this).getHeaderViewsCount());
        Object localObject = paramAnonymousView.tWE;
        if (paramAnonymousAdapterView.vYs.containsKey(localObject))
        {
          paramAnonymousAdapterView.vYs.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(2131761948));
          if (MailAddrListUI.e(MailAddrListUI.this).dsn() <= 0) {
            break label171;
          }
        }
        label171:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).dsn() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          AppMethodBeat.o(123039);
          return;
          paramAnonymousAdapterView.vYs.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.vYl.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        AppMethodBeat.i(123040);
        if (1 == paramAnonymousInt) {
          MailAddrListUI.this.hideVKB();
        }
        AppMethodBeat.o(123040);
      }
    });
    this.vYn = this.vUL.apU(null);
    this.vYm.notifyDataSetChanged();
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123041);
        MailAddrListUI.this.setResult(0);
        MailAddrListUI.this.finish();
        AppMethodBeat.o(123041);
        return true;
      }
    });
    setToTop(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123042);
        paramAnonymousView = MailAddrListUI.g(MailAddrListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().ba(paramAnonymousView);
        Object localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.aeD(), "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.lR(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        AppMethodBeat.o(123042);
      }
    });
    addTextOptionMenu(0, getString(2131761947), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123043);
        paramAnonymousMenuItem = MailAddrListUI.e(MailAddrListUI.this);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramAnonymousMenuItem.vYs.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(paramAnonymousMenuItem.vYs.get(str));
        }
        ComposeUI.eE(localArrayList);
        MailAddrListUI.this.setResult(-1);
        MailAddrListUI.this.finish();
        AppMethodBeat.o(123043);
        return true;
      }
    });
    if (!this.vYn.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(2131755906);
      this.vYj = h.b((Context)localObject, getString(2131761946), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
      });
      AppMethodBeat.o(123055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123054);
    super.onCreate(paramBundle);
    setMMTitle(2131761948);
    this.vYn = new ArrayList();
    this.vUL = ((o)g.ad(o.class)).getNormalMailAppService().vUL;
    initView();
    this.vUL.a(this.vYo);
    this.vUL.drE();
    AppMethodBeat.o(123054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123058);
    super.onDestroy();
    this.vUL.b(this.vYo);
    AppMethodBeat.o(123058);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(123056);
    super.onPause();
    AppMethodBeat.o(123056);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(123057);
    super.onResume();
    this.vYm.notifyDataSetChanged();
    AppMethodBeat.o(123057);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private final Context context;
    boolean vYq;
    boolean vYr;
    Map<String, com.tencent.mm.plugin.qqmail.b.p> vYs;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(123044);
      this.vYq = false;
      this.vYr = false;
      this.vYs = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(123044);
    }
    
    private int LN(int paramInt)
    {
      if (this.vYr) {
        return paramInt;
      }
      if (paramInt == 0) {
        return 0;
      }
      return paramInt - 1;
    }
    
    private static String d(com.tencent.mm.plugin.qqmail.b.p paramp)
    {
      AppMethodBeat.i(123050);
      if (paramp == null)
      {
        AppMethodBeat.o(123050);
        return null;
      }
      paramp = com.tencent.mm.plugin.qqmail.b.a.apP(paramp.pinyin);
      if (paramp.length() > 1) {}
      for (char c = paramp.charAt(0);; c = '~') {
        switch (c)
        {
        case '|': 
        case '}': 
        default: 
          if (!bs.D(c)) {
            break label130;
          }
          AppMethodBeat.o(123050);
          return String.valueOf(c);
        }
      }
      c = paramp.charAt(1);
      if (bs.E(c))
      {
        AppMethodBeat.o(123050);
        return String.valueOf(c);
      }
      AppMethodBeat.o(123050);
      return "~";
      AppMethodBeat.o(123050);
      return "~";
      label130:
      AppMethodBeat.o(123050);
      return "~";
    }
    
    private TextView getTitleTextView()
    {
      AppMethodBeat.i(123048);
      TextView localTextView = new TextView(this.context);
      localTextView.setBackgroundResource(2131232878);
      localTextView.setTextColor(-16777216);
      localTextView.setTextSize(0, MailAddrListUI.this.getResources().getDimensionPixelSize(2131165466));
      int i = MailAddrListUI.this.getResources().getDimensionPixelSize(2131165480);
      int j = MailAddrListUI.this.getResources().getDimensionPixelSize(2131165568);
      localTextView.setPadding(j, i, j, j);
      AppMethodBeat.o(123048);
      return localTextView;
    }
    
    public final com.tencent.mm.plugin.qqmail.b.p LO(int paramInt)
    {
      AppMethodBeat.i(123051);
      paramInt = LN(paramInt);
      com.tencent.mm.plugin.qqmail.b.p localp = (com.tencent.mm.plugin.qqmail.b.p)MailAddrListUI.c(MailAddrListUI.this).get(paramInt);
      AppMethodBeat.o(123051);
      return localp;
    }
    
    public final boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public final void c(com.tencent.mm.plugin.qqmail.b.p paramp)
    {
      AppMethodBeat.i(123045);
      this.vYs.put(paramp.tWE, paramp);
      AppMethodBeat.o(123045);
    }
    
    public final int dsn()
    {
      AppMethodBeat.i(123046);
      int i = this.vYs.size();
      AppMethodBeat.o(123046);
      return i;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(123047);
      int i = MailAddrListUI.c(MailAddrListUI.this).size();
      if (i == 0)
      {
        if (this.vYq)
        {
          AppMethodBeat.o(123047);
          return 1;
        }
        AppMethodBeat.o(123047);
        return 0;
      }
      if (this.vYr)
      {
        AppMethodBeat.o(123047);
        return i;
      }
      AppMethodBeat.o(123047);
      return i + 1;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(123049);
      if (paramInt == 0)
      {
        if (this.vYq)
        {
          paramView = getTitleTextView();
          paramView.setText(2131761957);
          paramInt = MailAddrListUI.this.getResources().getDimensionPixelSize(2131165480);
          paramView.setPadding(paramInt, paramInt, paramInt, paramInt);
          paramView.setTextSize(0, MailAddrListUI.this.getResources().getDimensionPixelSize(2131165192));
          paramView.setGravity(17);
          AppMethodBeat.o(123049);
          return paramView;
        }
        if (!this.vYr)
        {
          paramView = getTitleTextView();
          paramView.setText(2131761956);
          AppMethodBeat.o(123049);
          return paramView;
        }
      }
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495155, null);
        paramViewGroup.vYt = ((TextView)paramView.findViewById(2131303577));
        paramViewGroup.iMz = ((TextView)paramView.findViewById(2131303579));
        paramViewGroup.vYu = ((TextView)paramView.findViewById(2131303576));
        paramViewGroup.iCi = ((CheckBox)paramView.findViewById(2131303580));
        paramView.setTag(paramViewGroup);
        com.tencent.mm.plugin.qqmail.b.p localp = LO(paramInt);
        if ((this.vYr) || (paramInt <= 10)) {
          break label376;
        }
        Object localObject = LO(paramInt - 1);
        if (paramInt == 11) {
          localObject = null;
        }
        String str = d(localp);
        localObject = d((com.tencent.mm.plugin.qqmail.b.p)localObject);
        if (str == null) {
          break label364;
        }
        if (str.equals(localObject)) {
          break label352;
        }
        paramViewGroup.vYt.setText(str.toUpperCase());
        paramViewGroup.vYt.setVisibility(0);
        label279:
        paramViewGroup.iMz.setText(localp.name);
        paramViewGroup.vYu.setText(localp.tWE);
        paramViewGroup = paramViewGroup.iCi;
        if (this.vYs.get(localp.tWE) == null) {
          break label388;
        }
      }
      label388:
      for (boolean bool = true;; bool = false)
      {
        paramViewGroup.setChecked(bool);
        AppMethodBeat.o(123049);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label352:
        paramViewGroup.vYt.setVisibility(8);
        break label279;
        label364:
        paramViewGroup.vYt.setVisibility(8);
        break label279;
        label376:
        paramViewGroup.vYt.setVisibility(8);
        break label279;
      }
    }
    
    public final boolean isEnabled(int paramInt)
    {
      if (paramInt == 0) {
        return this.vYr;
      }
      return true;
    }
    
    final class a
    {
      CheckBox iCi;
      TextView iMz;
      TextView vYt;
      TextView vYu;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */