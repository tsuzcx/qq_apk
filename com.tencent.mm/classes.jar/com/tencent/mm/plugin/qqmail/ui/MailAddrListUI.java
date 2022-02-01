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
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.qqmail.d.k;
import com.tencent.mm.plugin.qqmail.d.l;
import com.tencent.mm.plugin.qqmail.d.m;
import com.tencent.mm.plugin.qqmail.d.m.a;
import com.tencent.mm.plugin.qqmail.d.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.ui.tools.s.b;
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
  private m BrU;
  private q BvO;
  private ListView BvP;
  private a BvQ;
  private List<l> BvR;
  private m.a BvS;
  private TextView khw;
  
  public MailAddrListUI()
  {
    AppMethodBeat.i(123053);
    this.BvO = null;
    this.khw = null;
    this.BrU = null;
    this.BvS = new m.a()
    {
      public final void onComplete()
      {
        AppMethodBeat.i(123037);
        Log.i("MicroMsg.MailAddrListUI", "sync addr complete");
        if (MailAddrListUI.a(MailAddrListUI.this) != null) {
          MailAddrListUI.a(MailAddrListUI.this).dismiss();
        }
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aKD(null));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131765561);
          MailAddrListUI.d(MailAddrListUI.this).setVisibility(0);
        }
        Object localObject2 = MailAddrListUI.this;
        Object localObject3 = new StringBuilder().append(MailAddrListUI.this.getString(2131763954));
        if (MailAddrListUI.e(MailAddrListUI.this).eGR() > 0) {}
        for (Object localObject1 = "(" + MailAddrListUI.e(MailAddrListUI.this).eGR() + ")";; localObject1 = "")
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
          if (((Set)localObject1).contains(((l)localObject3).yFq)) {
            MailAddrListUI.e(MailAddrListUI.this).BvU.put(((l)localObject3).yFq, localObject3);
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
    return 2131495997;
  }
  
  public void initView()
  {
    AppMethodBeat.i(123055);
    this.BvP = ((ListView)findViewById(2131306358));
    this.khw = ((TextView)findViewById(2131300105));
    this.BvQ = new a(this);
    Object localObject = new s((byte)0);
    ((s)localObject).Qwi = new s.b()
    {
      public final boolean SN(String paramAnonymousString)
      {
        return false;
      }
      
      public final void SO(String paramAnonymousString)
      {
        AppMethodBeat.i(123038);
        paramAnonymousString = Util.nullAs(paramAnonymousString, "");
        MailAddrListUI.a(MailAddrListUI.this, MailAddrListUI.b(MailAddrListUI.this).aKD(paramAnonymousString.toLowerCase().trim()));
        if (MailAddrListUI.c(MailAddrListUI.this).size() == 0)
        {
          MailAddrListUI.d(MailAddrListUI.this).setText(2131763963);
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
      
      public final void bnA() {}
      
      public final void bnB() {}
      
      public final void bny() {}
      
      public final void bnz() {}
    };
    addSearchMenu(true, (s)localObject);
    this.BvP.setAdapter(this.BvQ);
    this.BvP.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(123039);
        Object localObject = new b();
        ((b)localObject).bm(paramAnonymousAdapterView);
        ((b)localObject).bm(paramAnonymousView);
        ((b)localObject).pH(paramAnonymousInt);
        ((b)localObject).zo(paramAnonymousLong);
        a.b("com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, ((b)localObject).axR());
        paramAnonymousAdapterView = MailAddrListUI.e(MailAddrListUI.this);
        paramAnonymousView = paramAnonymousAdapterView.Vi(paramAnonymousInt - MailAddrListUI.f(MailAddrListUI.this).getHeaderViewsCount());
        localObject = paramAnonymousView.yFq;
        if (paramAnonymousAdapterView.BvU.containsKey(localObject))
        {
          paramAnonymousAdapterView.BvU.remove(localObject);
          paramAnonymousAdapterView.notifyDataSetChanged();
          paramAnonymousView = MailAddrListUI.this;
          localObject = new StringBuilder().append(MailAddrListUI.this.getString(2131763954));
          if (MailAddrListUI.e(MailAddrListUI.this).eGR() <= 0) {
            break label234;
          }
        }
        label234:
        for (paramAnonymousAdapterView = "(" + MailAddrListUI.e(MailAddrListUI.this).eGR() + ")";; paramAnonymousAdapterView = "")
        {
          paramAnonymousView.setMMTitle(paramAnonymousAdapterView);
          a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrListUI$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(123039);
          return;
          paramAnonymousAdapterView.BvU.put(localObject, paramAnonymousView);
          break;
        }
      }
    });
    this.BvP.setOnScrollListener(new MailAddrListUI.4(this));
    this.BvR = this.BrU.aKD(null);
    this.BvQ.notifyDataSetChanged();
    setBackBtn(new MailAddrListUI.5(this));
    setToTop(new MailAddrListUI.6(this));
    addTextOptionMenu(0, getString(2131763953), new MailAddrListUI.7(this));
    if (!this.BvR.isEmpty()) {}
    for (boolean bool = true;; bool = false)
    {
      enableOptionMenu(bool);
      localObject = getContext();
      getString(2131755998);
      this.BvO = h.a((Context)localObject, getString(2131763952), true, new MailAddrListUI.8(this));
      AppMethodBeat.o(123055);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(123054);
    super.onCreate(paramBundle);
    setMMTitle(2131763954);
    this.BvR = new ArrayList();
    this.BrU = ((k)g.ah(k.class)).getNormalMailAppService().BrU;
    initView();
    this.BrU.a(this.BvS);
    this.BrU.eGn();
    AppMethodBeat.o(123054);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(123058);
    super.onDestroy();
    this.BrU.b(this.BvS);
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
    this.BvQ.notifyDataSetChanged();
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
    Map<String, l> BvU;
    private final Context context;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(123044);
      this.BvU = new HashMap();
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
    
    public final l Vi(int paramInt)
    {
      AppMethodBeat.i(123051);
      l locall = (l)MailAddrListUI.c(MailAddrListUI.this).get(paramInt);
      AppMethodBeat.o(123051);
      return locall;
    }
    
    public final int eGR()
    {
      AppMethodBeat.i(123046);
      int i = this.BvU.size();
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
        paramView = View.inflate(this.context, 2131495998, null);
        paramViewGroup.BvV = ((TextView)paramView.findViewById(2131306354));
        paramViewGroup.kgE = ((TextView)paramView.findViewById(2131306356));
        paramViewGroup.BvW = ((TextView)paramView.findViewById(2131306353));
        paramViewGroup.jVQ = ((CheckBox)paramView.findViewById(2131306357));
        paramView.setTag(paramViewGroup);
        locall = Vi(paramInt);
        if (paramInt <= 0) {
          break label265;
        }
      }
      label259:
      label265:
      for (Object localObject = Vi(paramInt - 1);; localObject = null)
      {
        String str = a(locall);
        localObject = a((l)localObject);
        if (str != null) {
          if (!str.equals(localObject))
          {
            paramViewGroup.BvV.setText(str.toUpperCase());
            paramViewGroup.BvV.setVisibility(0);
            label162:
            paramViewGroup.kgE.setText(locall.name);
            paramViewGroup.BvW.setText(locall.yFq);
            paramViewGroup = paramViewGroup.jVQ;
            if (this.BvU.get(locall.yFq) == null) {
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
          paramViewGroup.BvV.setVisibility(8);
          break label162;
          paramViewGroup.BvV.setVisibility(8);
          break label162;
        }
      }
    }
    
    final class a
    {
      TextView BvV;
      TextView BvW;
      CheckBox jVQ;
      TextView kgE;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.MailAddrListUI
 * JD-Core Version:    0.7.0.1
 */