package com.tencent.mm.plugin.qqmail.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.tools.t;
import com.tencent.mm.ui.tools.t.b;
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
  private m Hmn;
  private s Hqj;
  private ListView Hqk;
  private a Hql;
  private List<l> Hqm;
  private m.a Hqn;
  private TextView mYV;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(123053);
    this.Hqj = null;
    this.mYV = null;
    this.Hmn = null;
    this.Hqn = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123037);
        Log.i("MicroMsg.MailAddrListUI", "sync addr complete");
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aVe(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(e.i.settings_recommend_no_mail_contact);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject2 = MailAddrListUI.this;
        Object localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(e.i.plugin_qqmail_addrlist_title));
        if (MailAddrListUI.e(MailAddrListUI.this).fsW() > 0) {}
        for (Object localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).fsW() + ")";; localObject1 = "")
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
          localObject3 = (l)((Iterator)localObject2).next();
          if (((Set)localObject1).contains(((l)localObject3).Ejj)) {
            MailAddrListUI.e(MailAddrListUI.this).Hqp.put(((l)localObject3).Ejj, localObject3);
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
    this.Hqk = ((ListView)findViewById(e.e.qqmail_addrlist_lv));
    this.mYV = ((TextView)findViewById(e.e.empty_tip_tv));
    this.Hql = new a(this);
    Object localObject = new t((byte)0);
    ((t)localObject).XUl = new t.b()
    {
      public final boolean aat(String paramAnonymousString)
      {
        return false;
      }
      
      public final void aau(String paramAnonymousString)
      {
        AppMethodBeat.i(123038);
        paramAnonymousString = Util.nullAs(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aVe(paramAnonymousString.toLowerCase().trim()));
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
      
      public final void bxH() {}
      
      public final void bxI() {}
      
      public final void bxJ() {}
      
      public final void bxK() {}
    };
    addSearchMenu(true, (t)localObject);
    this.Hqk.setAdapter(this.Hql);
    this.Hqk.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(123039);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousAdapterView);
        ((b)localObject).bn(paramAnonymousView);
        ((b)localObject).sg(paramAnonymousInt);
        ((b)localObject).Fs(paramAnonymousLong);
        a.c("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).aFi());
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.abQ(paramAnonymousInt - MailAddrListUI.f(MailAddrListUI.this).getHeaderViewsCount());
        localObject = paramAnonymousView.Ejj;
        if (paramAnonymousAdapterView.Hqp.containsKey(localObject))
        {
          paramAnonymousAdapterView.Hqp.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(e.i.plugin_qqmail_addrlist_title));
          if (MailAddrListUI.e(MailAddrListUI.this).fsW() <= 0) {
            break label235;
          }
        }
        label235:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).fsW() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(123039);
          return;
          paramAnonymousAdapterView.Hqp.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.Hqk.setOnScrollListener(new MailAddrListUI.4(this));
    this.Hqm = this.Hmn.aVe(null);
    this.Hql.notifyDataSetChanged();
    setBackBtn(new MailAddrListUI.5(this));
    setToTop(new MailAddrListUI.6(this));
    addTextOptionMenu(0, getString(e.i.plugin_qqmail_addrlist_choose), new MailAddrListUI.7(this));
    if (!this.Hqm.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(e.i.app_tip);
      this.Hqj = com.tencent.mm.ui.base.h.a((Context)localObject, getString(e.i.plugin_qqmail_addressui_sync_dlg), true, new MailAddrListUI.8(this));
      AppMethodBeat.o(123055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123054);
    super.onCreate(paramBundle);
    setMMTitle(e.i.plugin_qqmail_addrlist_title);
    this.Hqm = new ArrayList();
    this.Hmn = ((k)com.tencent.mm.kernel.h.ag(k.class)).getNormalMailAppService().Hmn;
    initView();
    this.Hmn.a(this.Hqn);
    this.Hmn.fso();
    AppMethodBeat.o(123054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123058);
    super.onDestroy();
    this.Hmn.b(this.Hqn);
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
    this.Hql.notifyDataSetChanged();
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
    Map<String, l> Hqp;
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(123044);
      this.Hqp = new HashMap();
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
          if (!Util.isAlpha(c)) {
            break label130;
          }
          AppMethodBeat.o(123050);
          return String.valueOf(c);
        }
      }
      c = paraml.charAt(1);
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
    
    public final l abQ(int paramInt)
    {
      AppMethodBeat.i(123051);
      l locall = (l)MailAddrListUI.c(MailAddrListUI.this).get(paramInt);
      AppMethodBeat.o(123051);
      return locall;
    }
    
    public final int fsW()
    {
      AppMethodBeat.i(123046);
      int i = this.Hqp.size();
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
        paramView = View.inflate(this.context, e.f.qqmail_addrlist_item, null);
        paramViewGroup.Hqq = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_category));
        paramViewGroup.mYd = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_name_tv));
        paramViewGroup.Hqr = ((TextView)paramView.findViewById(e.e.qqmail_addrlist_item_addr_iv));
        paramViewGroup.mNd = ((CheckBox)paramView.findViewById(e.e.qqmail_addrlist_item_select_cb));
        paramView.setTag(paramViewGroup);
        locall = abQ(paramInt);
        if (paramInt <= 0) {
          break label270;
        }
      }
      label264:
      label270:
      for (Object localObject = abQ(paramInt - 1);; localObject = null)
      {
        String str = a(locall);
        localObject = a((l)localObject);
        if (str != null) {
          if (!str.equals(localObject))
          {
            paramViewGroup.Hqq.setText(str.toUpperCase());
            paramViewGroup.Hqq.setVisibility(0);
            label167:
            paramViewGroup.mYd.setText(locall.name);
            paramViewGroup.Hqr.setText(locall.Ejj);
            paramViewGroup = paramViewGroup.mNd;
            if (this.Hqp.get(locall.Ejj) == null) {
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
          paramViewGroup.Hqq.setVisibility(8);
          break label167;
          paramViewGroup.Hqq.setVisibility(8);
          break label167;
        }
      }
    }
    
    final class a
    {
      TextView Hqq;
      TextView Hqr;
      CheckBox mNd;
      TextView mYd;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */