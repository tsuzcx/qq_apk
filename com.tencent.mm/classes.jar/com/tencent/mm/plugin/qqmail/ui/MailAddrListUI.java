package com.tencent.mm.plugin.qqmail.ui;

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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.plugin.qqmail.model.j;
import com.tencent.mm.plugin.qqmail.model.l;
import com.tencent.mm.plugin.qqmail.model.l.a;
import com.tencent.mm.plugin.qqmail.model.u;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.c;
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
  private l Nkb;
  private w NnX;
  private ListView NnY;
  private a NnZ;
  private List<com.tencent.mm.plugin.qqmail.model.k> Noa;
  private l.a Nob;
  private TextView pVD;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(123053);
    this.NnX = null;
    this.pVD = null;
    this.Nkb = null;
    this.Nob = new l.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123037);
        Log.i("MicroMsg.MailAddrListUI", "sync addr complete");
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aSm(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(e.i.settings_recommend_no_mail_contact);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject2 = MailAddrListUI.this;
        Object localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(e.i.plugin_qqmail_addrlist_title));
        if (MailAddrListUI.e(MailAddrListUI.this).gEF() > 0) {}
        for (Object localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).gEF() + ")";; localObject1 = "")
        {
          ((MailAddrListUI)localObject2).setMMTitle((String)localObject1);
          localObject2 = MailAddrListUI.this.getIntent().getStringArrayExtra("INIT_SELECTED_ADDRS_INTENT_EXTRA");
          if (localObject2 == null) {
            break label332;
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
          localObject3 = (com.tencent.mm.plugin.qqmail.model.k)((Iterator)localObject2).next();
          if (((Set)localObject1).contains(((com.tencent.mm.plugin.qqmail.model.k)localObject3).KbS)) {
            MailAddrListUI.e(MailAddrListUI.this).Nod.put(((com.tencent.mm.plugin.qqmail.model.k)localObject3).KbS, localObject3);
          }
        }
        label332:
        MailAddrListUI.e(MailAddrListUI.this).notifyDataSetChanged();
        AppMethodBeat.o(123037);
      }
    };
    AppMethodBeat.o(123053);
  }
  
  public int getLayoutId()
  {
    return e.f.qqmail_addrlist;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123055);
    this.NnY = ((ListView)findViewById(e.e.qqmail_addrlist_lv));
    this.pVD = ((TextView)findViewById(e.e.empty_tip_tv));
    this.NnZ = new a(this);
    Object localObject = new s(true);
    ((s)localObject).afKz = new s.c()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(123038);
        paramAnonymousString = Util.nullAs(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aSm(paramAnonymousString.toLowerCase().trim()));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(e.i.plugin_qqmail_composeui_addr_list_search_empty);
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
      
      public final void bWw() {}
      
      public final void bWx() {}
      
      public final void bWy() {}
      
      public final void bWz() {}
    };
    addSearchMenu(true, (s)localObject);
    this.NnY.setAdapter(this.NnZ);
    this.NnY.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(123039);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousAdapterView);
        ((b)localObject).cH(paramAnonymousView);
        ((b)localObject).sc(paramAnonymousInt);
        ((b)localObject).hB(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aYj());
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.age(paramAnonymousInt - MailAddrListUI.f(MailAddrListUI.this).getHeaderViewsCount());
        localObject = paramAnonymousView.KbS;
        if (paramAnonymousAdapterView.Nod.containsKey(localObject))
        {
          paramAnonymousAdapterView.Nod.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(e.i.plugin_qqmail_addrlist_title));
          if (MailAddrListUI.e(MailAddrListUI.this).gEF() <= 0) {
            break label235;
          }
        }
        label235:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).gEF() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(123039);
          return;
          paramAnonymousAdapterView.Nod.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.NnY.setOnScrollListener(new AbsListView.OnScrollListener()
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
    this.Noa = this.Nkb.aSm(null);
    this.NnZ.notifyDataSetChanged();
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
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = MailAddrListUI.f(MailAddrListUI.this);
        paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
        localObject = new Object();
        com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramAnonymousView.sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123042);
      }
    });
    addTextOptionMenu(0, getString(e.i.plugin_qqmail_addrlist_choose), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(123043);
        paramAnonymousMenuItem = MailAddrListUI.e(MailAddrListUI.this);
        ArrayList localArrayList = new ArrayList();
        Iterator localIterator = paramAnonymousMenuItem.Nod.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localArrayList.add((com.tencent.mm.plugin.qqmail.model.k)paramAnonymousMenuItem.Nod.get(str));
        }
        ComposeUI.jA(localArrayList);
        MailAddrListUI.this.setResult(-1);
        MailAddrListUI.this.finish();
        AppMethodBeat.o(123043);
        return true;
      }
    });
    if (!this.Noa.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(e.i.app_tip);
      this.NnX = com.tencent.mm.ui.base.k.a((Context)localObject, getString(e.i.plugin_qqmail_addressui_sync_dlg), true, new DialogInterface.OnCancelListener()
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
    setMMTitle(e.i.plugin_qqmail_addrlist_title);
    this.Noa = new ArrayList();
    this.Nkb = ((j)h.az(j.class)).getNormalMailAppService().Nkb;
    initView();
    this.Nkb.a(this.Nob);
    this.Nkb.gDW();
    AppMethodBeat.o(123054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123058);
    super.onDestroy();
    this.Nkb.b(this.Nob);
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
    this.NnZ.notifyDataSetChanged();
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
    Map<String, com.tencent.mm.plugin.qqmail.model.k> Nod;
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(123044);
      this.Nod = new HashMap();
      this.context = paramContext;
      AppMethodBeat.o(123044);
    }
    
    private static String a(com.tencent.mm.plugin.qqmail.model.k paramk)
    {
      AppMethodBeat.i(123050);
      if (paramk == null)
      {
        AppMethodBeat.o(123050);
        return null;
      }
      paramk = paramk.pinyin;
      if (paramk.length() > 1) {}
      for (char c = paramk.charAt(0);; c = '~') {
        switch (c)
        {
        case '|': 
        case '}': 
        default: 
          if (!Util.isAlpha(c)) {
            break label130;
          }
          AppMethodBeat.o(123050);
          return String.valueOf(c);
        }
      }
      c = paramk.charAt(1);
      if (Util.isNum(c))
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
    
    public final com.tencent.mm.plugin.qqmail.model.k age(int paramInt)
    {
      AppMethodBeat.i(123051);
      com.tencent.mm.plugin.qqmail.model.k localk = (com.tencent.mm.plugin.qqmail.model.k)MailAddrListUI.c(MailAddrListUI.this).get(paramInt);
      AppMethodBeat.o(123051);
      return localk;
    }
    
    public final int gEF()
    {
      AppMethodBeat.i(123046);
      int i = this.Nod.size();
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
      com.tencent.mm.plugin.qqmail.model.k localk;
      if ((paramView == null) || (paramView.getTag() == null))
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.context, e.f.qqmail_addrlist_item, null);
        paramViewGroup.Noe = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_category));
        paramViewGroup.pUL = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_name_tv));
        paramViewGroup.Nof = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_addr_iv));
        paramViewGroup.pJL = ((CheckBox)paramView.findViewById(e.e.qqmail_addrlist_item_select_cb));
        paramView.setTag(paramViewGroup);
        localk = age(paramInt);
        if (paramInt <= 0) {
          break label270;
        }
      }
      label264:
      label270:
      for (Object localObject = age(paramInt - 1);; localObject = null)
      {
        String str = a(localk);
        localObject = a((com.tencent.mm.plugin.qqmail.model.k)localObject);
        if (str != null) {
          if (!str.equals(localObject))
          {
            paramViewGroup.Noe.setText(str.toUpperCase());
            paramViewGroup.Noe.setVisibility(0);
            label167:
            paramViewGroup.pUL.setText(localk.name);
            paramViewGroup.Nof.setText(localk.KbS);
            paramViewGroup = paramViewGroup.pJL;
            if (this.Nod.get(localk.KbS) == null) {
              break label264;
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
          paramViewGroup.Noe.setVisibility(8);
          break label167;
          paramViewGroup.Noe.setVisibility(8);
          break label167;
        }
      }
    }
    
    final class a
    {
      TextView Noe;
      TextView Nof;
      CheckBox pJL;
      TextView pUL;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */