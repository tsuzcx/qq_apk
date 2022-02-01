package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.graphics.Paint;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.PluginMessengerFoundation;
import com.tencent.mm.plugin.selectcontact.a.e;
import com.tencent.mm.plugin.selectcontact.a.f;
import com.tencent.mm.plugin.selectcontact.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c.b;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.contact.ag;
import com.tencent.mm.ui.contact.ah;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.i.c;
import com.tencent.mm.view.recyclerview.i.d;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "(I)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/ui/contact/RecentForwardItemConvertData;", "dataList", "Ljava/util/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "listener", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnClickUserListener;", "loadDataListListener", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnLoadDataListListener;", "menu", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "removeListener", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnRemoveListener;", "viewHolder", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardListViewHolder;", "getViewHolder", "()Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardListViewHolder;", "viewHolder$delegate", "Lkotlin/Lazy;", "viewItem", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardViewItem;", "getViewItem", "()Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardViewItem;", "viewItem$delegate", "createViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "fillingDataItem", "", "context", "Landroid/content/Context;", "baseViewHolder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "notifySelectedUserList", "selectedUserList", "", "", "removeItem", "userName", "selectUser", "setOnClickListener", "setOnLoadDataListListener", "setOnRemoveListener", "showLongSelectMenu", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "showRecentForwardList", "isShow", "", "holder", "updateAllCheckBox", "isMultiSelect", "Companion", "OnClickUserListener", "OnLoadDataListListener", "OnRemoveListener", "RecentForwardListViewHolder", "RecentForwardViewItem", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends a
{
  public static final o.a afkC;
  public WxRecyclerAdapter<ah> ALE;
  private com.tencent.mm.ui.widget.b.a GAa;
  private final kotlin.j afjL;
  private final kotlin.j afjM;
  public b afkD;
  public d afkE;
  public c afkF;
  public ArrayList<ah> pUj;
  
  static
  {
    AppMethodBeat.i(253606);
    afkC = new o.a((byte)0);
    AppMethodBeat.o(253606);
  }
  
  public o(int paramInt)
  {
    super(9, paramInt);
    AppMethodBeat.i(253560);
    this.afjM = k.cm((kotlin.g.a.a)new j(this));
    this.afjL = k.cm((kotlin.g.a.a)new k(this));
    AppMethodBeat.o(253560);
  }
  
  private static final void a(com.tencent.mm.ui.base.s params, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(253577);
    params.oh(0, a.h.select_contact_remove_recent_conversation);
    AppMethodBeat.o(253577);
  }
  
  private static final void a(o paramo)
  {
    AppMethodBeat.i(253564);
    kotlin.g.b.s.u(paramo, "this$0");
    paramo.GAa = null;
    AppMethodBeat.o(253564);
  }
  
  private static final void a(String paramString, o paramo, RecyclerView paramRecyclerView, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(253572);
    kotlin.g.b.s.u(paramString, "$userName");
    kotlin.g.b.s.u(paramo, "this$0");
    kotlin.g.b.s.u(paramRecyclerView, "$recyclerView");
    paramMenuItem = (PluginMessengerFoundation)h.az(PluginMessengerFoundation.class);
    if (paramMenuItem != null)
    {
      paramMenuItem = paramMenuItem.getRecentForwardInfoStorage();
      if (paramMenuItem != null) {
        paramMenuItem.bzp(paramString);
      }
    }
    paramMenuItem = paramo.afkF;
    if (paramMenuItem != null) {
      paramMenuItem.jzg();
    }
    paramRecyclerView = paramRecyclerView.getAdapter();
    if (paramRecyclerView != null) {
      paramRecyclerView.bZE.notifyChanged();
    }
    paramRecyclerView = paramo.afkE;
    if (paramRecyclerView != null) {
      paramRecyclerView.bBV(paramString);
    }
    paramString = paramo.GAa;
    if (paramString != null) {
      paramString.diW();
    }
    AppMethodBeat.o(253572);
  }
  
  public final void a(Context paramContext, a.a parama)
  {
    AppMethodBeat.i(253629);
    paramContext = this.pUj;
    if (paramContext != null) {
      if (!((Collection)paramContext).isEmpty())
      {
        i = 1;
        if (i != 1) {
          break label133;
        }
      }
    }
    label133:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramContext = (g)new g();
        parama = this.pUj;
        kotlin.g.b.s.checkNotNull(parama);
        this.ALE = new WxRecyclerAdapter(paramContext, parama);
        paramContext = this.ALE;
        if (paramContext != null) {
          paramContext.agOe = ((i.c)new h(this));
        }
        paramContext = this.ALE;
        if (paramContext != null) {
          paramContext.agOd = ((i.d)new i(this));
        }
      }
      AppMethodBeat.o(253629);
      return;
      i = 0;
      break;
    }
  }
  
  public final a.b bVv()
  {
    AppMethodBeat.i(253622);
    a.b localb = (a.b)this.afjL.getValue();
    AppMethodBeat.o(253622);
    return localb;
  }
  
  protected final a.a bVw()
  {
    AppMethodBeat.i(253626);
    a.a locala = (a.a)this.afjM.getValue();
    AppMethodBeat.o(253626);
    return locala;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnClickUserListener;", "", "onClick", "", "userName", "", "index", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void bBU(String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnLoadDataListListener;", "", "onRequestLoad", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void jzg();
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$OnRemoveListener;", "", "onRemove", "", "userName", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void bBV(String paramString);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardListViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem;)V", "headerTitleTv", "Landroid/widget/TextView;", "getHeaderTitleTv", "()Landroid/widget/TextView;", "setHeaderTitleTv", "(Landroid/widget/TextView;)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "rootView", "Landroid/widget/LinearLayout;", "getRootView", "()Landroid/widget/LinearLayout;", "setRootView", "(Landroid/widget/LinearLayout;)V", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class e
    extends a.a
  {
    TextView FZP;
    LinearLayout Ikm;
    RecyclerView mkw;
    
    public e()
    {
      super();
      AppMethodBeat.i(253573);
      AppMethodBeat.o(253573);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewItem;", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "(Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem;)V", "fillingViewItem", "", "context", "Landroid/content/Context;", "holder", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem$BaseContactViewHolder;", "data", "alwaysCheck", "", "isCheck", "inflateView", "Landroid/view/View;", "parent", "Landroid/view/ViewGroup;", "originConvertView", "onItemClick", "v", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class f
    extends a.b
  {
    public f()
    {
      super();
      AppMethodBeat.i(253561);
      AppMethodBeat.o(253561);
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      Object localObject = null;
      AppMethodBeat.i(253579);
      paramViewGroup = LayoutInflater.from(paramContext).inflate(a.f.recent_forward_horizontal_list, paramViewGroup, false);
      o.e locale = (o.e)this.afkG.bVw();
      if (paramViewGroup == null) {}
      for (paramContext = null; paramContext == null; paramContext = (RecyclerView)paramViewGroup.findViewById(a.e.recent_forward_recyclerview))
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        AppMethodBeat.o(253579);
        throw paramContext;
      }
      locale.mkw = paramContext;
      if (paramViewGroup == null) {}
      for (paramContext = null; paramContext == null; paramContext = (TextView)paramViewGroup.findViewById(a.e.header_title_tv))
      {
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(253579);
        throw paramContext;
      }
      locale.FZP = paramContext;
      paramContext = locale.FZP;
      if (paramContext == null)
      {
        paramContext = null;
        aw.d((Paint)paramContext);
        if (paramViewGroup != null) {
          break label180;
        }
      }
      label180:
      for (paramContext = localObject;; paramContext = (LinearLayout)paramViewGroup.findViewById(a.e.root_ll))
      {
        if (paramContext != null) {
          break label194;
        }
        paramContext = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
        AppMethodBeat.o(253579);
        throw paramContext;
        paramContext = paramContext.getPaint();
        break;
      }
      label194:
      locale.Ikm = paramContext;
      paramViewGroup.setTag(locale);
      AppMethodBeat.o(253579);
      return paramViewGroup;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(253567);
      if (((parama instanceof o.e)) && ((parama1 instanceof o)))
      {
        paramContext = this.afkG.pUj;
        if ((paramContext == null) || (((Collection)paramContext).isEmpty())) {
          break label124;
        }
      }
      label124:
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        o.a(paramBoolean1, (o.e)parama);
        o.a(this.afkG, this.afkG.afey);
        paramContext = ((o.e)parama).mkw;
        if (paramContext != null)
        {
          parama = this.afkG;
          paramContext.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
          paramContext.setHasFixedSize(true);
          paramContext.setAdapter((RecyclerView.a)o.b(parama));
        }
        AppMethodBeat.o(253567);
        return;
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a parama)
    {
      return true;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/contact/item/RecentForwardListDataItem$fillingDataItem$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements g
  {
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(253556);
      Log.i("RecentForwardListDataItem", kotlin.g.b.s.X("getItemConvert, type:", Integer.valueOf(paramInt)));
      f localf = (f)new ag();
      AppMethodBeat.o(253556);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/contact/item/RecentForwardListDataItem$fillingDataItem$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements i.c<com.tencent.mm.view.recyclerview.j>
  {
    h(o paramo) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/contact/item/RecentForwardListDataItem$fillingDataItem$3", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemLongClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemLongClick", "", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "ui-selectcontact_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements i.d<com.tencent.mm.view.recyclerview.j>
  {
    i(o paramo) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardListViewHolder;", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<o.e>
  {
    j(o paramo)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem$RecentForwardViewItem;", "Lcom/tencent/mm/ui/contact/item/RecentForwardListDataItem;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends u
    implements kotlin.g.a.a<o.f>
  {
    k(o paramo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.a.o
 * JD-Core Version:    0.7.0.1
 */