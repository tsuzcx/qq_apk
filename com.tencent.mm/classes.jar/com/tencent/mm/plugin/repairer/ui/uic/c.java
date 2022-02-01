package com.tencent.mm.plugin.repairer.ui.uic;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.widget.AdapterView.AdapterContextMenuInfo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmbase.BaseMvvmActivity;
import com.tencent.mm.plugin.mvvmlist.MvvmList;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.statecenter.UIStateCenter;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC;", "Lcom/tencent/mm/plugin/mvvmbase/BaseMvvmUIC;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "itemClickListener", "com/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$itemClickListener$1", "Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$itemClickListener$1;", "popupMenu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "getPopupMenu", "()Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "setPopupMenu", "(Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;)V", "repairerMvvmList", "Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "getRepairerMvvmList", "()Lcom/tencent/mm/plugin/mvvmlist/MvvmList;", "setRepairerMvvmList", "(Lcom/tencent/mm/plugin/mvvmlist/MvvmList;)V", "x_down", "", "getX_down", "()I", "setX_down", "(I)V", "y_down", "getY_down", "setY_down", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "handleActivityItemClick", "", "groupItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "handleConfigItemClick", "position", "dataItem", "handleGroupItemClick", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "MenuCreateListener", "MenuSelectedListener", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends com.tencent.mm.plugin.mvvmbase.a
{
  public static final c.a Oyw;
  MvvmList<com.tencent.mm.plugin.repairer.ui.c.c> Oyx;
  private final f Oyy;
  com.tencent.mm.ui.widget.b.a vEV;
  int x_down;
  int y_down;
  
  static
  {
    AppMethodBeat.i(278120);
    Oyw = new c.a((byte)0);
    AppMethodBeat.o(278120);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(278043);
    this.Oyy = new f(this);
    AppMethodBeat.o(278043);
  }
  
  private static final void a(ept paramept, List paramList, b.a parama, com.tencent.mm.plugin.repairer.ui.c.c paramc, c paramc1, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(278068);
    kotlin.g.b.s.u(paramept, "$configItem");
    kotlin.g.b.s.u(paramList, "$arr");
    kotlin.g.b.s.u(parama, "$key");
    kotlin.g.b.s.u(paramc, "$dataItem");
    kotlin.g.b.s.u(paramc1, "this$0");
    paramept = paramept.aaTg;
    kotlin.g.b.s.s(paramept, "configItem.values");
    paramept = (String)p.ae((List)paramept, paramMenuItem.getItemId());
    if (paramept != null)
    {
      paramList = (String)paramList.get(3);
      switch (paramList.hashCode())
      {
      }
    }
    for (;;)
    {
      paramList = (com.tencent.mm.plugin.repairer.ui.c.c)paramc.gsx();
      paramList.setValue(paramept);
      paramept = paramc1.Oyx;
      if (paramept != null) {
        MvvmList.b(paramept, (com.tencent.mm.plugin.mvvmlist.b)paramList);
      }
      AppMethodBeat.o(278068);
      return;
      if (paramList.equals("Float"))
      {
        paramList = i.agtt;
        i.b(parama, Float.valueOf(Float.parseFloat(paramept)));
        continue;
        if (paramList.equals("Long"))
        {
          paramList = i.agtt;
          i.b(parama, Long.valueOf(Long.parseLong(paramept)));
          continue;
          if (paramList.equals("String"))
          {
            paramList = i.agtt;
            i.b(parama, paramept);
            continue;
            if (paramList.equals("Int"))
            {
              paramList = i.agtt;
              i.b(parama, Integer.valueOf(Integer.parseInt(paramept)));
            }
          }
        }
      }
    }
  }
  
  private static final void a(LinkedList paramLinkedList, ept paramept, c paramc, com.tencent.mm.plugin.repairer.ui.c.c paramc1, com.tencent.mm.ui.widget.a.f paramf, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(278056);
    kotlin.g.b.s.u(paramLinkedList, "$values");
    kotlin.g.b.s.u(paramept, "$configItem");
    kotlin.g.b.s.u(paramc, "this$0");
    kotlin.g.b.s.u(paramc1, "$dataItem");
    kotlin.g.b.s.u(paramf, "$bottomSheet");
    paramc = ((Iterable)paramLinkedList).iterator();
    int i = 0;
    if (paramc.hasNext())
    {
      paramLinkedList = paramc.next();
      if (i < 0) {
        p.kkW();
      }
      String str = (String)paramLinkedList;
      paramLinkedList = paramept.abtK;
      kotlin.g.b.s.s(paramLinkedList, "configItem.valueAlias");
      paramLinkedList = (String)p.ae((List)paramLinkedList, i);
      if (paramLinkedList == null) {}
      for (paramLinkedList = null;; paramLinkedList = params.a(i, (CharSequence)(str + '(' + paramLinkedList + ')'), 0))
      {
        if (paramLinkedList == null) {
          params.a(i, (CharSequence)String.valueOf(str), 0);
        }
        if (kotlin.g.b.s.p(paramc1.value, str)) {
          paramf.pym = i;
        }
        i += 1;
        break;
      }
    }
    AppMethodBeat.o(278056);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(278148);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      paramIntent = this.Oyx;
      if (paramIntent != null) {
        paramIntent.gsy();
      }
    }
    AppMethodBeat.o(278148);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(278142);
    paramBundle = gst();
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getStateCenter();
      if (paramBundle != null) {
        paramBundle.observe((q)getActivity(), (kotlin.g.a.b)new g(this));
      }
    }
    AppMethodBeat.o(278142);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$MenuCreateListener;", "Landroid/view/View$OnCreateContextMenuListener;", "dataItem", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "position", "", "(Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC;Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;I)V", "getDataItem", "()Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "getPosition", "()I", "onCreateContextMenu", "", "menu", "Landroid/view/ContextMenu;", "v", "Landroid/view/View;", "menuInfo", "Landroid/view/ContextMenu$ContextMenuInfo;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    implements View.OnCreateContextMenuListener
  {
    private final com.tencent.mm.plugin.repairer.ui.c.c Oyz;
    private final int position;
    
    public b(int paramInt)
    {
      AppMethodBeat.i(278007);
      this.Oyz = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(278007);
    }
    
    public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
    {
      AppMethodBeat.i(278014);
      if ((paramContextMenuInfo instanceof AdapterView.AdapterContextMenuInfo)) {
        if (this.Oyz.type == 1)
        {
          if (paramContextMenu != null)
          {
            paramContextMenu.add(this.position, 0, 0, (CharSequence)"置顶");
            AppMethodBeat.o(278014);
          }
        }
        else if (paramContextMenu != null) {
          paramContextMenu.add(this.position, 1, 0, (CharSequence)"取消置顶");
        }
      }
      AppMethodBeat.o(278014);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$MenuSelectedListener;", "Lcom/tencent/mm/ui/base/MMMenuListener$OnMMMenuItemSelectedListener;", "dataItem", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "position", "", "(Lcom/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC;Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;I)V", "getDataItem", "()Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "getPosition", "()I", "onMMMenuItemSelected", "", "menuItem", "Landroid/view/MenuItem;", "index", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    implements u.i
  {
    private final com.tencent.mm.plugin.repairer.ui.c.c Oyz;
    private final int position;
    
    public c(int paramInt)
    {
      AppMethodBeat.i(278009);
      this.Oyz = paramInt;
      int i;
      this.position = i;
      AppMethodBeat.o(278009);
    }
    
    public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
    {
      paramInt = 1;
      AppMethodBeat.i(278024);
      if (paramMenuItem != null)
      {
        c localc = c.this;
        i locali;
        switch (paramMenuItem.getItemId())
        {
        default: 
          AppMethodBeat.o(278024);
          return;
        case 0: 
          paramMenuItem = i.agtt;
          paramMenuItem = i.a(b.a.agqq, "");
          Log.i("MicroMsg.Repairer.RepairerListUIC", kotlin.g.b.s.X("favKeyString: ", paramMenuItem));
          paramMenuItem = n.a((CharSequence)paramMenuItem, new String[] { "," });
          if (paramMenuItem.contains(this.Oyz.Oyn.key)) {
            break label475;
          }
          paramMenuItem = new LinkedList((Collection)paramMenuItem);
          paramMenuItem.add(0, this.Oyz.Oyn.key);
          paramMenuItem = p.a((Iterable)paramMenuItem, (CharSequence)",", null, null, 0, null, null, 62);
          locali = i.agtt;
          i.b(b.a.agqq, paramMenuItem);
          paramMenuItem = localc.gst();
          if (paramMenuItem != null)
          {
            paramMenuItem = paramMenuItem.getStateCenter();
            if (paramMenuItem != null)
            {
              paramMenuItem = (com.tencent.mm.plugin.repairer.ui.d.b)paramMenuItem.getState();
              if ((paramMenuItem == null) || (paramMenuItem.Oyo != true)) {
                break;
              }
            }
          }
          break;
        }
        while (paramInt != 0)
        {
          paramMenuItem = localc.Oyx;
          if (paramMenuItem != null)
          {
            paramMenuItem.a((com.tencent.mm.plugin.mvvmlist.b)new com.tencent.mm.plugin.repairer.ui.c.c(0, 0, this.Oyz.Oyn, this.Oyz.value), false);
            AppMethodBeat.o(278024);
            return;
            paramInt = 0;
            continue;
            paramMenuItem = i.agtt;
            paramMenuItem = i.a(b.a.agqq, "");
            Log.i("MicroMsg.Repairer.RepairerListUIC", kotlin.g.b.s.X("favKeyString: ", paramMenuItem));
            paramMenuItem = n.b((CharSequence)paramMenuItem, new String[] { "," });
            if (paramMenuItem.contains(this.Oyz.Oyn.key))
            {
              paramMenuItem = new LinkedList((Collection)paramMenuItem);
              paramMenuItem.remove(this.Oyz.Oyn.key);
              paramMenuItem = p.a((Iterable)paramMenuItem, (CharSequence)",", null, null, 0, null, null, 62);
              locali = i.agtt;
              i.b(b.a.agqq, paramMenuItem);
              paramMenuItem = localc.gst();
              if (paramMenuItem != null)
              {
                paramMenuItem = paramMenuItem.getStateCenter();
                if (paramMenuItem != null)
                {
                  paramMenuItem = (com.tencent.mm.plugin.repairer.ui.d.b)paramMenuItem.getState();
                  if ((paramMenuItem == null) || (paramMenuItem.Oyo != true)) {}
                }
              }
              for (paramInt = 1; paramInt != 0; paramInt = 0)
              {
                paramMenuItem = localc.Oyx;
                if (paramMenuItem == null) {
                  break;
                }
                paramMenuItem.a((com.tencent.mm.plugin.mvvmlist.b)new com.tencent.mm.plugin.repairer.ui.c.c(0, 0, this.Oyz.Oyn, this.Oyz.value));
                AppMethodBeat.o(278024);
                return;
              }
            }
          }
        }
      }
      label475:
      AppMethodBeat.o(278024);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements g
  {
    public final com.tencent.mm.view.recyclerview.f<?> yF(int paramInt)
    {
      AppMethodBeat.i(278008);
      com.tencent.mm.view.recyclerview.f localf = (com.tencent.mm.view.recyclerview.f)new com.tencent.mm.plugin.repairer.ui.c.b();
      AppMethodBeat.o(278008);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$handleConfigItemClick$3$dialog$1", "Lcom/tencent/mm/plugin/repairer/ui/OnValueSetListener;", "onSetValue", "", "value", "", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements com.tencent.mm.plugin.repairer.ui.a
  {
    e(List<String> paramList, b.a parama, com.tencent.mm.plugin.repairer.ui.c.c paramc, c paramc1) {}
    
    public final void aUk(String paramString)
    {
      AppMethodBeat.i(278016);
      kotlin.g.b.s.u(paramString, "value");
      Object localObject = (String)this.OyB.get(3);
      switch (((String)localObject).hashCode())
      {
      }
      for (;;)
      {
        localObject = (com.tencent.mm.plugin.repairer.ui.c.c)this.OyD.gsx();
        ((com.tencent.mm.plugin.repairer.ui.c.c)localObject).setValue(paramString);
        paramString = this.OyE.Oyx;
        if (paramString != null) {
          MvvmList.b(paramString, (com.tencent.mm.plugin.mvvmlist.b)localObject);
        }
        AppMethodBeat.o(278016);
        return;
        if (((String)localObject).equals("Float"))
        {
          localObject = i.agtt;
          i.b(this.OyC, Float.valueOf(Float.parseFloat(paramString)));
          continue;
          if (((String)localObject).equals("Long"))
          {
            localObject = i.agtt;
            i.b(this.OyC, Long.valueOf(Long.parseLong(paramString)));
            continue;
            if (((String)localObject).equals("String"))
            {
              localObject = i.agtt;
              i.b(this.OyC, paramString);
              continue;
              if (((String)localObject).equals("Int"))
              {
                localObject = i.agtt;
                i.b(this.OyC, Integer.valueOf(Integer.parseInt(paramString)));
              }
            }
          }
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/repairer/ui/uic/RepairerListUIC$itemClickListener$1", "Lcom/tencent/mm/view/recyclerview/OnItemConvertClickListener;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "onClick", "", "itemView", "Landroid/view/View;", "dataItem", "position", "", "onLongClick", "", "data", "onTouch", "event", "Landroid/view/MotionEvent;", "item", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements h<com.tencent.mm.plugin.repairer.ui.c.c>
  {
    f(c paramc) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "state", "Lcom/tencent/mm/plugin/repairer/ui/state/RepairerState;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.repairer.ui.d.b, ah>
  {
    g(c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.uic.c
 * JD-Core Version:    0.7.0.1
 */