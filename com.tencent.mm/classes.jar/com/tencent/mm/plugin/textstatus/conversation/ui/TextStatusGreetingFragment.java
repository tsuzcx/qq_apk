package com.tencent.mm.plugin.textstatus.conversation.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.c;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.f;
import com.tencent.mm.plugin.textstatus.conversation.a.e;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.conversation.h.a;
import com.tencent.mm.plugin.textstatus.conversation.h.b;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.j;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusGreetingFragment;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "()V", "afterPageEnter", "", "getAdapter", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "getContactStorageList", "", "Lcom/tencent/mm/sdk/storage/MStorage;", "getConversationDataSource", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "getEmptyView", "Landroid/view/View;", "getFirstPageCount", "", "getLayoutId", "getLoadingView", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onDestroy", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusGreetingFragment
  extends BasePrivateMsgConvListFragment<com.tencent.mm.plugin.textstatus.conversation.d.d>
{
  public final int aNI()
  {
    return 15;
  }
  
  public final void aNJ()
  {
    AppMethodBeat.i(291028);
    super.aNJ();
    Context localContext = getContext();
    if (localContext != null)
    {
      Object localObject = aNG();
      if ((localObject instanceof com.tencent.mm.plugin.textstatus.conversation.a.d)) {
        localObject = (com.tencent.mm.plugin.textstatus.conversation.a.d)localObject;
      }
      while (localObject != null)
      {
        s.u(localContext, "context");
        LinkedList localLinkedList = new LinkedList();
        int j = Math.min(3, ((com.tencent.mm.plugin.textstatus.conversation.a.d)localObject).vEn.size());
        int i = 0;
        for (;;)
        {
          if (i < j)
          {
            localLinkedList.add(((com.tencent.mm.plugin.textstatus.conversation.d.d)((com.tencent.mm.plugin.textstatus.conversation.a.d)localObject).vEn.get(i)).field_encUsername);
            i += 1;
            continue;
            localObject = null;
            break;
          }
        }
        localObject = com.tencent.mm.plugin.textstatus.conversation.g.c.Tjw;
        com.tencent.mm.plugin.textstatus.conversation.g.c.a(localContext, (List)localLinkedList, "greeting");
      }
    }
    AppMethodBeat.o(291028);
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(290995);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(a.e.rl_layout))
    {
      s.s(localObject, "rl_layout");
      localObject = (RefreshLoadMoreLayout)localObject;
      AppMethodBeat.o(290995);
      return localObject;
    }
  }
  
  public final BasePrivateMsgConvListFragment.c<com.tencent.mm.plugin.textstatus.conversation.d.d> aNM()
  {
    AppMethodBeat.i(291012);
    BasePrivateMsgConvListFragment.c localc = (BasePrivateMsgConvListFragment.c)new com.tencent.mm.plugin.textstatus.conversation.d.c((byte)0);
    AppMethodBeat.o(291012);
    return localc;
  }
  
  public final List<MStorage> aNN()
  {
    AppMethodBeat.i(291015);
    Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject = p.listOf(com.tencent.mm.plugin.textstatus.b.f.hGK());
    AppMethodBeat.o(291015);
    return localObject;
  }
  
  public final BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.textstatus.conversation.d.d> aNO()
  {
    AppMethodBeat.i(291022);
    Object localObject = new com.tencent.mm.plugin.textstatus.conversation.a.d();
    ((com.tencent.mm.plugin.textstatus.conversation.a.d)localObject).DQi = ((q)new com.tencent.mm.plugin.textstatus.conversation.a.f((byte)0));
    ((com.tencent.mm.plugin.textstatus.conversation.a.d)localObject).Tiv = ((q)new e((byte)0));
    localObject = (BasePrivateMsgConvListFragment.a)localObject;
    AppMethodBeat.o(291022);
    return localObject;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(291005);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(a.e.empty_tip))
    {
      s.s(localView, "empty_tip");
      AppMethodBeat.o(291005);
      return localView;
    }
  }
  
  public final int getLayoutId()
  {
    return a.f.Tft;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(291000);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(a.e.loadingIcon))
    {
      s.s(localView, "loadingIcon");
      AppMethodBeat.o(291000);
      return localView;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(290989);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(a.e.conversationRecyclerView))
    {
      s.s(localObject, "conversationRecyclerView");
      localObject = (RecyclerView)localObject;
      AppMethodBeat.o(290989);
      return localObject;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(290975);
    super.onDestroy();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGN().hGD();
    AppMethodBeat.o(290975);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(290981);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGL().add((MStorage.IOnStorageChange)aNG());
    com.tencent.mm.view.f.a(getRecyclerView(), (e.a)new a());
    AppMethodBeat.o(290981);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/ui/TextStatusGreetingFragment$onViewCreated$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends e.a
  {
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(290988);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      paramList = ((Iterable)paramList).iterator();
      label164:
      while (paramList.hasNext())
      {
        paramView = (RecyclerView.v)paramList.next();
        if ((paramView instanceof j)) {}
        for (paramView = (j)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label164;
          }
          com.tencent.mm.plugin.textstatus.conversation.d.d locald = (com.tencent.mm.plugin.textstatus.conversation.d.d)paramView.CSA;
          if (locald == null) {
            break;
          }
          f.a locala = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          paramView = paramView.context;
          s.s(paramView, "holder.context");
          paramView = f.a.ko(paramView);
          s.u(locald, "item");
          paramView = s.X(com.tencent.mm.plugin.textstatus.conversation.d.f.Tjg, Integer.valueOf(paramView.Tjf));
          if (s.p(locald.TiR, paramView)) {
            break;
          }
          s.u(paramView, "<set-?>");
          locald.TiR = paramView;
          paramView = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          paramView = locald.field_session_id;
          s.s(paramView, "item.field_session_id");
          f.a.hp(paramView, 101);
          break;
        }
      }
      AppMethodBeat.o(290988);
    }
    
    public final boolean dXG()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusGreetingFragment
 * JD-Core Version:    0.7.0.1
 */