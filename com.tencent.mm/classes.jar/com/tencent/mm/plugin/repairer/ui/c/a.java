package com.tencent.mm.plugin.repairer.ui.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.repairer.ui.b.b;
import com.tencent.mm.plugin.repairer.ui.b.d;
import com.tencent.mm.plugin.repairer.ui.c;
import com.tencent.mm.protocal.protobuf.dwp;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.util.i;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/repairer/ui/model/OnItemClickListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerConvertDataItem;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "adapter$delegate", "Lkotlin/Lazy;", "dataList", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getShowValue", "", "repairerItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "handleActivityItemClick", "", "groupItem", "handleConfigItemClick", "position", "", "dataItem", "handleGroupItemClick", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateData", "itemList", "", "ui-repairer_release"})
public final class a
  extends UIComponent
  implements com.tencent.mm.plugin.repairer.ui.b.a
{
  private final kotlin.f BiY;
  final ArrayList<b> mXB;
  private WxRecyclerView xUj;
  
  public a(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(227077);
    this.BiY = g.ar((kotlin.g.a.a)new a(this));
    this.mXB = new ArrayList();
    AppMethodBeat.o(227077);
  }
  
  private static String a(dwp paramdwp)
  {
    AppMethodBeat.i(227063);
    p.k(paramdwp, "repairerItem");
    if (paramdwp.type == 3)
    {
      Object localObject = paramdwp.key;
      p.j(localObject, "repairerItem.key");
      localObject = com.tencent.mm.util.b.a.valueOf((String)localObject);
      paramdwp = paramdwp.key;
      p.j(paramdwp, "repairerItem.key");
      paramdwp = (String)n.a((CharSequence)paramdwp, new String[] { "_" }).get(3);
      switch (paramdwp.hashCode())
      {
      default: 
        paramdwp = "";
      }
      for (;;)
      {
        AppMethodBeat.o(227063);
        return paramdwp;
        if (!paramdwp.equals("Float")) {
          break;
        }
        paramdwp = i.YyX;
        paramdwp = i.a((com.tencent.mm.util.b.a)localObject, Float.valueOf(0.0F)).toString();
        continue;
        if (!paramdwp.equals("Long")) {
          break;
        }
        paramdwp = i.YyX;
        paramdwp = i.a((com.tencent.mm.util.b.a)localObject, Long.valueOf(0L)).toString();
        continue;
        if (!paramdwp.equals("String")) {
          break;
        }
        paramdwp = i.YyX;
        paramdwp = i.a((com.tencent.mm.util.b.a)localObject, "").toString();
        continue;
        if (!paramdwp.equals("Int")) {
          break;
        }
        paramdwp = i.YyX;
        paramdwp = i.a((com.tencent.mm.util.b.a)localObject, Integer.valueOf(0)).toString();
      }
    }
    AppMethodBeat.o(227063);
    return "";
  }
  
  public final void a(final int paramInt, final b paramb)
  {
    AppMethodBeat.i(227074);
    p.k(paramb, "dataItem");
    switch (paramb.Iye.type)
    {
    }
    label519:
    label525:
    do
    {
      AppMethodBeat.o(227074);
      return;
      paramb = paramb.Iye.TDA;
      p.j(paramb, "groupItem.values");
      Object localObject1 = (String)j.lp((List)paramb);
      if (localObject1 != null)
      {
        paramb = getActivity();
        localObject1 = new Intent().setClassName((Context)getActivity(), (String)localObject1);
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramb, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC", "handleActivityItemClick", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramb.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramb, "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC", "handleActivityItemClick", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(227074);
        return;
      }
      AppMethodBeat.o(227074);
      return;
      localObject1 = paramb.Iye;
      paramb = ((dwp)localObject1).TDA;
      p.j(paramb, "groupItem.values");
      Object localObject2 = (String)j.lp((List)paramb);
      if (localObject2 != null)
      {
        paramb = getActivity();
        localObject1 = new Intent().setClassName((Context)getActivity(), (String)localObject2).putExtra("key_config_item_list", ((dwp)localObject1).toByteArray());
        localObject1 = new com.tencent.mm.hellhoundlib.b.a().bm(localObject1);
        com.tencent.mm.hellhoundlib.a.a.b(paramb, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aFh(), "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC", "handleGroupItemClick", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramb.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramb, "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC", "handleGroupItemClick", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(227074);
        return;
      }
      AppMethodBeat.o(227074);
      return;
      localObject2 = paramb.Iye;
      localObject1 = ((dwp)localObject2).key;
      p.j(localObject1, "configItem.key");
      final com.tencent.mm.util.b.a locala = com.tencent.mm.util.b.a.valueOf((String)localObject1);
      localObject1 = ((dwp)localObject2).key;
      p.j(localObject1, "configItem.key");
      final List localList = n.b((CharSequence)localObject1, new String[] { "_" });
      localObject1 = ((dwp)localObject2).TDA;
      int i;
      if (((LinkedList)localObject1).size() > 0)
      {
        i = 1;
        if (i == 0) {
          break label519;
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label525;
        }
        final com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e((Context)getActivity(), 2, false);
        locale.a((q.f)new c((LinkedList)localObject1, locale, this, paramb, (dwp)localObject2, localList, locala, paramInt));
        locale.a((q.g)new d(this, paramb, (dwp)localObject2, localList, locala, paramInt));
        locale.eik();
        AppMethodBeat.o(227074);
        return;
        i = 0;
        break;
        localObject1 = null;
      }
      localObject1 = (a)this;
      paramb = new c((Context)((a)localObject1).getActivity(), ((dwp)localObject2).name, paramb.value, (com.tencent.mm.plugin.repairer.ui.a)new e((a)localObject1, (dwp)localObject2, paramb, localList, locala, paramInt));
      paramb.show();
      paramb = paramb.getWindow();
    } while (paramb == null);
    paramb.setLayout(-1, -1);
    AppMethodBeat.o(227074);
  }
  
  public final void aa(List<? extends dwp> paramList)
  {
    AppMethodBeat.i(227058);
    p.k(paramList, "itemList");
    this.mXB.clear();
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext())
    {
      dwp localdwp = (dwp)paramList.next();
      this.mXB.add(new b(localdwp, a(localdwp)));
    }
    getAdapter().notifyDataSetChanged();
    AppMethodBeat.o(227058);
  }
  
  public final WxRecyclerAdapter<b> getAdapter()
  {
    AppMethodBeat.i(227054);
    WxRecyclerAdapter localWxRecyclerAdapter = (WxRecyclerAdapter)this.BiY.getValue();
    AppMethodBeat.o(227054);
    return localWxRecyclerAdapter;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(227057);
    this.xUj = ((WxRecyclerView)findViewById(com.tencent.mm.plugin.repairer.ui.b.a.recycler_view));
    paramBundle = this.xUj;
    if (paramBundle != null)
    {
      getActivity();
      paramBundle.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    }
    paramBundle = this.xUj;
    if (paramBundle != null)
    {
      paramBundle.setAdapter((RecyclerView.a)getAdapter());
      AppMethodBeat.o(227057);
      return;
    }
    AppMethodBeat.o(227057);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerConvertDataItem;", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<WxRecyclerAdapter<b>>
  {
    a(a parama)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-repairer_release"})
  public static final class b
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(227189);
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new d((com.tencent.mm.plugin.repairer.ui.b.a)this.Iyj);
      AppMethodBeat.o(227189);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "kotlin.jvm.PlatformType", "onCreateMMMenu", "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC$handleConfigItemClick$2$1"})
  static final class c
    implements q.f
  {
    c(LinkedList paramLinkedList, com.tencent.mm.ui.widget.a.e parame, a parama, b paramb, dwp paramdwp, List paramList, com.tencent.mm.util.b.a parama1, int paramInt) {}
    
    public final void onCreateMMMenu(o paramo)
    {
      AppMethodBeat.i(226998);
      Iterator localIterator = ((Iterable)this.Iyk).iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if (i < 0) {
          j.iBO();
        }
        localObject = (String)localObject;
        paramo.b(i, (CharSequence)localObject, 0);
        if (p.h(paramb.value, localObject)) {
          locale.ayn(i);
        }
        i += 1;
      }
      AppMethodBeat.o(226998);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "index", "", "onMMMenuItemSelected", "com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC$handleConfigItemClick$2$2"})
  static final class d
    implements q.g
  {
    d(a parama, b paramb, dwp paramdwp, List paramList, com.tencent.mm.util.b.a parama1, int paramInt) {}
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      AppMethodBeat.i(227560);
      Object localObject = this.Iym.TDA;
      p.j(localObject, "configItem.values");
      localObject = (List)localObject;
      p.j(paramMenuItem, "menuItem");
      paramMenuItem = (String)j.M((List)localObject, paramMenuItem.getItemId());
      if (paramMenuItem != null)
      {
        localObject = (String)localList.get(3);
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          paramb.setValue(paramMenuItem);
          this.Iyj.getAdapter().cL(paramInt);
          AppMethodBeat.o(227560);
          return;
          if (((String)localObject).equals("Float"))
          {
            localObject = i.YyX;
            i.b(locala, Float.valueOf(Float.parseFloat(paramMenuItem)));
            continue;
            if (((String)localObject).equals("Long"))
            {
              localObject = i.YyX;
              i.b(locala, Long.valueOf(Long.parseLong(paramMenuItem)));
              continue;
              if (((String)localObject).equals("String"))
              {
                localObject = i.YyX;
                i.b(locala, paramMenuItem);
                continue;
                if (((String)localObject).equals("Int"))
                {
                  localObject = i.YyX;
                  i.b(locala, Integer.valueOf(Integer.parseInt(paramMenuItem)));
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(227560);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/repairer/ui/uic/RepairerContentUIC$handleConfigItemClick$3$dialog$1", "Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "onSetValue", "", "value", "", "ui-repairer_release"})
  public static final class e
    implements com.tencent.mm.plugin.repairer.ui.a
  {
    e(a parama, dwp paramdwp, b paramb, List paramList, com.tencent.mm.util.b.a parama1, int paramInt) {}
    
    public final void aWU(String paramString)
    {
      AppMethodBeat.i(227575);
      p.k(paramString, "value");
      Object localObject = (String)localList.get(3);
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        paramb.setValue(paramString);
        this.Iyp.getAdapter().cL(paramInt);
        AppMethodBeat.o(227575);
        return;
        if (((String)localObject).equals("Float"))
        {
          localObject = i.YyX;
          i.b(locala, Float.valueOf(Float.parseFloat(paramString)));
          continue;
          if (((String)localObject).equals("Long"))
          {
            localObject = i.YyX;
            i.b(locala, Long.valueOf(Long.parseLong(paramString)));
            continue;
            if (((String)localObject).equals("String"))
            {
              localObject = i.YyX;
              i.b(locala, paramString);
              continue;
              if (((String)localObject).equals("Int"))
              {
                localObject = i.YyX;
                i.b(locala, Integer.valueOf(Integer.parseInt(paramString)));
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.c.a
 * JD-Core Version:    0.7.0.1
 */