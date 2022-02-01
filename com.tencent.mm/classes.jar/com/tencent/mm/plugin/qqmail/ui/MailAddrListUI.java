package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.tools.r.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MailAddrListUI
  extends MMActivity
{
  private TextView jju;
  private m xrQ;
  private p xvN;
  private ListView xvO;
  private a xvP;
  private List<l> xvQ;
  private m.a xvR;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(123053);
    this.xvN = null;
    this.jju = null;
    this.xrQ = null;
    this.xvR = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123037);
        ae.i("MicroMsg.MailAddrListUI", "sync addr complete");
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).awl(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131763379);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject2 = MailAddrListUI.this;
        Object localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(2131761948));
        if (MailAddrListUI.e(MailAddrListUI.this).dGd() > 0) {}
        for (Object localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).dGd() + ")";; localObject1 = "")
        {
          ((MailAddrListUI)localObject2).setMMTitle((String)localObject1);
          localObject2 = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
          if (localObject2 == null) {
            break label330;
          }
          localObject1 = new HashSet();
          int j = localObject2.length;
          int i = 0;
          while (i < j)
          {
            localObject3 = localObject2[i].split(" ");
            if (localObject3.length == 2) {
              ((Set)localObject1).add(localObject3[1]);
            }
            i += 1;
          }
        }
        localObject2 = MailAddrListUI.c(MailAddrListUI.this).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (l)((Iterator)localObject2).next();
          if (((Set)localObject1).contains(((l)localObject3).vly)) {
            MailAddrListUI.e(MailAddrListUI.this).xvT.put(((l)localObject3).vly, localObject3);
          }
        }
        label330:
        MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
        AppMethodBeat.o(123037);
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
    this.xvO = ((ListView)findViewById(2131303581));
    this.jju = ((TextView)findViewById(2131299475));
    this.xvP = new a(this);
    Object localObject = new r((byte)0);
    ((r)localObject).Lhk = new r.b()
    {
      public final boolean JO(String paramAnonymousString)
      {
        return false;
      }
      
      public final void JP(String paramAnonymousString)
      {
        AppMethodBeat.i(123038);
        paramAnonymousString = bu.bI(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).awl(paramAnonymousString.toLowerCase().trim()));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131761957);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
          MailAddrListUI.this.enableOptionMenu(false);
        }
        for (;;)
        {
          MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
          AppMethodBeat.o(123038);
          return;
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(8);
          MailAddrListUI.this.enableOptionMenu(true);
        }
      }
      
      public final void aSL() {}
      
      public final void aSM() {}
      
      public final void aSN() {}
      
      public final void aSO() {}
    };
    addSearchMenu(true, (r)localObject);
    this.xvO.setAdapter(this.xvP);
    this.xvO.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(123039);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousAdapterView);
        ((b)localObject).bd(paramAnonymousView);
        ((b)localObject).mu(paramAnonymousInt);
        ((b)localObject).rl(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).ahF());
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.NT(paramAnonymousInt - MailAddrListUI.f(MailAddrListUI.this).getHeaderViewsCount());
        localObject = paramAnonymousView.vly;
        if (paramAnonymousAdapterView.xvT.containsKey(localObject))
        {
          paramAnonymousAdapterView.xvT.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(2131761948));
          if (MailAddrListUI.e(MailAddrListUI.this).dGd() <= 0) {
            break label234;
          }
        }
        label234:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).dGd() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(123039);
          return;
          paramAnonymousAdapterView.xvT.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.xvO.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.xvQ = this.xrQ.awl(null);
    this.xvP.notifyDataSetChanged();
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
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        paramAnonymousView = MailAddrListUI.f(MailAddrListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.c.b((ListView)paramAnonymousView.mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        Iterator localIterator = paramAnonymousMenuItem.xvT.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add(paramAnonymousMenuItem.xvT.get(str));
        }
        ComposeUI.fa(localArrayList);
        MailAddrListUI.this.setResult(-1);
        MailAddrListUI.this.finish();
        AppMethodBeat.o(123043);
        return true;
      }
    });
    if (!this.xvQ.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(2131755906);
      this.xvN = h.b((Context)localObject, getString(2131761946), true, new DialogInterface.OnCancelListener()
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
    this.xvQ = new ArrayList();
    this.xrQ = ((k)g.ad(k.class)).getNormalMailAppService().xrQ;
    initView();
    this.xrQ.a(this.xvR);
    this.xrQ.dFy();
    AppMethodBeat.o(123054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123058);
    super.onDestroy();
    this.xrQ.b(this.xvR);
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
    this.xvP.notifyDataSetChanged();
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
    Map<String, l> xvT;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(123044);
      this.xvT = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(123044);
    }
    
    private static String a(l paraml)
    {
      AppMethodBeat.i(123050);
      if (paraml == null)
      {
        AppMethodBeat.o(123050);
        return null;
      }
      paraml = paraml.pinyin;
      if (paraml.length() > 1) {}
      for (char c = paraml.charAt(0);; c = '~') {
        switch (c)
        {
        case '|': 
        case '}': 
        default: 
          if (!bu.F(c)) {
            break label130;
          }
          AppMethodBeat.o(123050);
          return String.valueOf(c);
        }
      }
      c = paraml.charAt(1);
      if (bu.G(c))
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
    
    public final l NT(int paramInt)
    {
      AppMethodBeat.i(123051);
      l locall = (l)MailAddrListUI.c(MailAddrListUI.this).get(paramInt);
      AppMethodBeat.o(123051);
      return locall;
    }
    
    public final int dGd()
    {
      AppMethodBeat.i(123046);
      int i = this.xvT.size();
      AppMethodBeat.o(123046);
      return i;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(123047);
      int i = MailAddrListUI.c(MailAddrListUI.this).size();
      AppMethodBeat.o(123047);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(123049);
      l locall;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, 2131495155, null);
        paramViewGroup.xvU = ((TextView)paramView.findViewById(2131303577));
        paramViewGroup.jiC = ((TextView)paramView.findViewById(2131303579));
        paramViewGroup.xvV = ((TextView)paramView.findViewById(2131303576));
        paramViewGroup.iYl = ((CheckBox)paramView.findViewById(2131303580));
        paramView.setTag(paramViewGroup);
        locall = NT(paramInt);
        if (paramInt <= 0) {
          break label265;
        }
      }
      label259:
      label265:
      for (Object localObject = NT(paramInt - 1);; localObject = null)
      {
        String str = a(locall);
        localObject = a((l)localObject);
        if (str != null) {
          if (!str.equals(localObject))
          {
            paramViewGroup.xvU.setText(str.toUpperCase());
            paramViewGroup.xvU.setVisibility(0);
            label162:
            paramViewGroup.jiC.setText(locall.name);
            paramViewGroup.xvV.setText(locall.vly);
            paramViewGroup = paramViewGroup.iYl;
            if (this.xvT.get(locall.vly) == null) {
              break label259;
            }
          }
        }
        for (boolean bool = true;; bool = false)
        {
          paramViewGroup.setChecked(bool);
          AppMethodBeat.o(123049);
          return paramView;
          paramViewGroup = (a)paramView.getTag();
          break;
          paramViewGroup.xvU.setVisibility(8);
          break label162;
          paramViewGroup.xvU.setVisibility(8);
          break label162;
        }
      }
    }
    
    final class a
    {
      CheckBox iYl;
      TextView jiC;
      TextView xvU;
      TextView xvV;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */