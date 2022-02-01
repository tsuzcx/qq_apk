package com.tencent.mm.plugin.textstatus.conversation.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.view.recyclerview.j;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "()V", "dataList", "Ljava/util/LinkedList;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "onItemClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function3;)V", "onItemLongClickListener", "", "getOnItemLongClickListener", "setOnItemLongClickListener", "afterPageEnter", "context", "Landroid/content/Context;", "deleteItem", "item", "", "getItem", "position", "getItemCount", "insertConvList", "convs", "insertItem", "onBindViewHolder", "holder", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$ConversationHolder;", "onConversationOrContactChange", "_event", "", "_eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "datas", "updateByContact", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "updateByConversation", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "getIndexOf", "getIndexsOf", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.textstatus.conversation.d.d>
{
  public static final d.a Tiu;
  public q<? super View, ? super Integer, ? super com.tencent.mm.plugin.textstatus.conversation.d.d, Boolean> DQi;
  public q<? super View, ? super Integer, ? super com.tencent.mm.plugin.textstatus.conversation.d.d, ah> Tiv;
  public LinkedList<com.tencent.mm.plugin.textstatus.conversation.d.d> vEn;
  
  static
  {
    AppMethodBeat.i(290944);
    Tiu = new d.a((byte)0);
    AppMethodBeat.o(290944);
  }
  
  public d()
  {
    AppMethodBeat.i(290883);
    this.vEn = new LinkedList();
    AppMethodBeat.o(290883);
  }
  
  private static final void a(BasePrivateMsgConvListFragment.b paramb, d paramd, View paramView)
  {
    AppMethodBeat.i(290891);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(paramd, "this$0");
    localObject = (com.tencent.mm.plugin.textstatus.conversation.d.d)paramb.CSA;
    paramd = paramd.Tiv;
    if (paramd != null)
    {
      s.s(paramView, "it");
      int i = paramb.KJ();
      s.s(localObject, "item");
      paramd.invoke(paramView, Integer.valueOf(i), localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290891);
  }
  
  private static final boolean b(BasePrivateMsgConvListFragment.b paramb, d paramd, View paramView)
  {
    AppMethodBeat.i(290898);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramb);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(paramd, "this$0");
    localObject = (com.tencent.mm.plugin.textstatus.conversation.d.d)paramb.CSA;
    paramd = paramd.DQi;
    if (paramd != null)
    {
      s.s(paramView, "it");
      int i = paramb.KJ();
      s.s(localObject, "item");
      paramd.invoke(paramView, Integer.valueOf(i), localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(290898);
    return true;
  }
  
  private static final void w(View paramView1, View paramView2)
  {
    AppMethodBeat.i(290904);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramView1, "$itemView");
    paramView1.performClick();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusGreetingAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290904);
  }
  
  public final boolean a(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290972);
    if ((paramString != null) && (paramMStorageEventData != null))
    {
      Log.i("MicroMsg.TextStatus.TextStatusGreetingAdapter", "[onConversationStorageChange] eventData.eventId = " + paramMStorageEventData.eventId + ",obj=" + paramMStorageEventData.obj);
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.textstatus.conversation.d.d))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramMStorageEventData, this));
        AppMethodBeat.o(290972);
        return true;
      }
      if ((paramMStorageEventData.obj instanceof h))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramMStorageEventData, this));
        AppMethodBeat.o(290972);
        return true;
      }
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramMStorageEventData, this));
        AppMethodBeat.o(290972);
        return true;
      }
      AppMethodBeat.o(290972);
      return false;
    }
    AppMethodBeat.o(290972);
    return false;
  }
  
  public final void bw(List<com.tencent.mm.plugin.textstatus.conversation.d.d> paramList)
  {
    AppMethodBeat.i(290968);
    s.u(paramList, "convs");
    if (paramList != null)
    {
      int i = this.vEn.size();
      this.vEn.addAll((Collection)paramList);
      bA(i, paramList.size());
    }
    AppMethodBeat.o(290968);
  }
  
  public final List<com.tencent.mm.plugin.textstatus.conversation.d.d> getDataList()
  {
    return (List)this.vEn;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(369823);
    int i = this.vEn.size();
    AppMethodBeat.o(369823);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(MStorageEventData paramMStorageEventData, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(MStorageEventData paramMStorageEventData, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(MStorageEventData paramMStorageEventData, d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.d
 * JD-Core Version:    0.7.0.1
 */