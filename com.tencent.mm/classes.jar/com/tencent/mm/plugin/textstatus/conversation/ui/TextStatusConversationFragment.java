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
import com.tencent.mm.plugin.textstatus.conversation.a.c;
import com.tencent.mm.plugin.textstatus.conversation.d.f.a;
import com.tencent.mm.plugin.textstatus.h.f.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.e.a;
import com.tencent.mm.view.recyclerview.j;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.a.q;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "()V", "afterPageEnter", "", "getAdapter", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "getContactStorageList", "", "Lcom/tencent/mm/sdk/storage/MStorage;", "getConversationDataSource", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "getEmptyView", "Landroid/view/View;", "getFirstPageCount", "", "getLayoutId", "getLoadingView", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onDestroy", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "setUserVisibleHint", "isVisibleToUser", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class TextStatusConversationFragment
  extends BasePrivateMsgConvListFragment<com.tencent.mm.plugin.textstatus.conversation.d.a>
{
  public static final TextStatusConversationFragment.a TjI;
  
  static
  {
    AppMethodBeat.i(290987);
    TjI = new TextStatusConversationFragment.a((byte)0);
    AppMethodBeat.o(290987);
  }
  
  public final int aNI()
  {
    return 15;
  }
  
  public final void aNJ()
  {
    AppMethodBeat.i(291050);
    super.aNJ();
    AppMethodBeat.o(291050);
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(291024);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(a.e.rl_layout))
    {
      s.s(localObject, "rl_layout");
      localObject = (RefreshLoadMoreLayout)localObject;
      AppMethodBeat.o(291024);
      return localObject;
    }
  }
  
  public final BasePrivateMsgConvListFragment.c<com.tencent.mm.plugin.textstatus.conversation.d.a> aNM()
  {
    AppMethodBeat.i(291036);
    BasePrivateMsgConvListFragment.c localc = (BasePrivateMsgConvListFragment.c)new com.tencent.mm.plugin.textstatus.conversation.d.b((byte)0);
    AppMethodBeat.o(291036);
    return localc;
  }
  
  public final List<MStorage> aNN()
  {
    AppMethodBeat.i(291039);
    Object localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject = p.listOf(com.tencent.mm.plugin.textstatus.b.f.hGK());
    AppMethodBeat.o(291039);
    return localObject;
  }
  
  public final BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.textstatus.conversation.d.a> aNO()
  {
    AppMethodBeat.i(291044);
    Object localObject = new com.tencent.mm.plugin.textstatus.conversation.a.a();
    ((com.tencent.mm.plugin.textstatus.conversation.a.a)localObject).Til = ((q)new com.tencent.mm.plugin.textstatus.conversation.a.b(this));
    ((com.tencent.mm.plugin.textstatus.conversation.a.a)localObject).DPS = ((q)new c(this, (byte)0));
    localObject = (BasePrivateMsgConvListFragment.a)localObject;
    AppMethodBeat.o(291044);
    return localObject;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(291032);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(a.e.empty_tip))
    {
      s.s(localView, "empty_tip");
      AppMethodBeat.o(291032);
      return localView;
    }
  }
  
  public final int getLayoutId()
  {
    return a.f.Tfh;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(291027);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(a.e.loadingIcon))
    {
      s.s(localView, "loadingIcon");
      AppMethodBeat.o(291027);
      return localView;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(291016);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(a.e.conversationRecyclerView))
    {
      s.s(localObject, "conversationRecyclerView");
      localObject = (RecyclerView)localObject;
      AppMethodBeat.o(291016);
      return localObject;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291006);
    super.onDestroy();
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGN().remove((MStorage.IOnStorageChange)aNG());
    localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGK().remove((MStorage.IOnStorageChange)aNG());
    AppMethodBeat.o(291006);
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(290996);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    paramView = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGN().add((MStorage.IOnStorageChange)aNG());
    paramView = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.hGK().add((MStorage.IOnStorageChange)aNG());
    com.tencent.mm.view.f.a(getRecyclerView(), (e.a)new b());
    AppMethodBeat.o(290996);
  }
  
  public final void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(291002);
    super.setUserVisibleHint(paramBoolean);
    Log.d("MicroMsg.TextStatus.TextStatusConversationFragment", s.X("setUserVisibleHint() called with: isVisibleToUser = ", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(291002);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/ui/TextStatusConversationFragment$onViewCreated$1", "Lcom/tencent/mm/view/ExposeElves$OnRecyclerViewChildExposedListener;", "getExposedId", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "ignoreFlingExposed", "", "onChildExposeChanged", "", "parent", "Landroid/view/View;", "exposedHolders", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.a
  {
    public final long aa(RecyclerView.v paramv)
    {
      long l2 = -1L;
      AppMethodBeat.i(291034);
      long l1;
      if (paramv == null) {
        l1 = l2;
      }
      for (;;)
      {
        l2 = super.aa(paramv);
        AppMethodBeat.o(291034);
        return l1 + l2;
        Object localObject = paramv.caK;
        l1 = l2;
        if (localObject != null)
        {
          localObject = ((View)localObject).getContext();
          l1 = l2;
          if (localObject != null)
          {
            f.a locala = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
            l1 = f.a.ko((Context)localObject).Tjf;
          }
        }
      }
    }
    
    public final void b(View paramView, List<? extends RecyclerView.v> paramList)
    {
      AppMethodBeat.i(291017);
      s.u(paramView, "parent");
      s.u(paramList, "exposedHolders");
      Iterator localIterator = ((Iterable)paramList).iterator();
      label174:
      label176:
      label179:
      while (localIterator.hasNext())
      {
        paramView = (RecyclerView.v)localIterator.next();
        if ((paramView instanceof j))
        {
          paramList = (j)paramView;
          label58:
          if (paramList == null) {
            break label174;
          }
          paramView = paramList.CSA;
          if (!(paramView instanceof com.tencent.mm.plugin.textstatus.conversation.d.a)) {
            break label176;
          }
        }
        for (paramView = (com.tencent.mm.plugin.textstatus.conversation.d.a)paramView;; paramView = null)
        {
          if (paramView == null) {
            break label179;
          }
          f.a locala = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          paramList = paramList.context;
          s.s(paramList, "holder.context");
          paramList = f.a.ko(paramList);
          s.u(paramView, "conv");
          if (com.tencent.mm.plugin.textstatus.conversation.e.b.a(paramView)) {
            break;
          }
          paramList = s.X(com.tencent.mm.plugin.textstatus.conversation.d.f.Tjg, Integer.valueOf(paramList.Tjf));
          if (s.p(paramView.TiR, paramList)) {
            break;
          }
          paramView.TiR = paramList;
          paramList = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
          paramView = paramView.field_sessionId;
          s.s(paramView, "conv.field_sessionId");
          f.a.hp(paramView, 52);
          break;
          paramList = null;
          break label58;
          break;
        }
      }
      AppMethodBeat.o(291017);
    }
    
    public final boolean dXG()
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.ui.TextStatusConversationFragment
 * JD-Core Version:    0.7.0.1
 */