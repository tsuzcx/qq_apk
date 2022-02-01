package com.tencent.mm.plugin.textstatus.conversation.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.b;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.view.recyclerview.j;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.q;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationAdapter;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "()V", "dataList", "Ljava/util/LinkedList;", "getDataList", "()Ljava/util/LinkedList;", "setDataList", "(Ljava/util/LinkedList;)V", "dataMap", "Ljava/util/HashMap;", "", "getDataMap", "()Ljava/util/HashMap;", "setDataMap", "(Ljava/util/HashMap;)V", "onClickListener", "Lkotlin/Function3;", "Landroid/view/View;", "", "", "getOnClickListener", "()Lkotlin/jvm/functions/Function3;", "setOnClickListener", "(Lkotlin/jvm/functions/Function3;)V", "onLongClickListener", "getOnLongClickListener", "setOnLongClickListener", "delConv", "conv", "formatTime", "", "context", "Landroid/content/Context;", "", "getFirstGreetItemDigest", "getItem", "position", "getItemCount", "insertConvList", "convs", "insertOrUpdateConv", "notifyGreetingConversation", "onBindViewHolder", "holder", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$ConversationHolder;", "onConversationOrContactChange", "", "_event", "_eventData", "Lcom/tencent/mm/sdk/storage/MStorageEventData;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setConvRead", "submitList", "datas", "updateConvContent", "contact", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusStrangerContact;", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.textstatus.conversation.d.a>
{
  public static final a.a Tik;
  HashMap<String, com.tencent.mm.plugin.textstatus.conversation.d.a> AFz;
  public q<? super View, ? super Integer, ? super com.tencent.mm.plugin.textstatus.conversation.d.a, ah> DPS;
  public q<? super View, ? super Integer, ? super com.tencent.mm.plugin.textstatus.conversation.d.a, ah> Til;
  LinkedList<com.tencent.mm.plugin.textstatus.conversation.d.a> vEn;
  
  static
  {
    AppMethodBeat.i(290940);
    Tik = new a.a((byte)0);
    AppMethodBeat.o(290940);
  }
  
  public a()
  {
    AppMethodBeat.i(290881);
    this.vEn = new LinkedList();
    this.AFz = new HashMap();
    AppMethodBeat.o(290881);
  }
  
  private static final void a(BasePrivateMsgConvListFragment.b paramb, a parama, View paramView)
  {
    AppMethodBeat.i(290886);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(parama, "this$0");
    localObject = (com.tencent.mm.plugin.textstatus.conversation.d.a)paramb.CSA;
    parama = parama.Til;
    if (parama != null)
    {
      s.s(paramView, "it");
      int i = paramb.KJ();
      s.s(localObject, "item");
      parama.invoke(paramView, Integer.valueOf(i), localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationAdapter", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(290886);
  }
  
  private static final boolean b(BasePrivateMsgConvListFragment.b paramb, a parama, View paramView)
  {
    AppMethodBeat.i(290895);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramb);
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramb, "$holder");
    s.u(parama, "this$0");
    localObject = (com.tencent.mm.plugin.textstatus.conversation.d.a)paramb.CSA;
    parama = parama.DPS;
    if (parama != null)
    {
      s.s(paramView, "it");
      int i = paramb.KJ();
      s.s(localObject, "item");
      parama.invoke(paramView, Integer.valueOf(i), localObject);
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationAdapter", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(290895);
    return true;
  }
  
  public final boolean a(final String paramString, final MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(290969);
    if ((paramString != null) && (paramMStorageEventData != null))
    {
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.textstatus.conversation.d.a))
      {
        paramString = new ah.f();
        localObject = paramMStorageEventData.obj;
        if (localObject == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.textstatus.conversation.data.TextStatusConversation");
          AppMethodBeat.o(290969);
          throw paramString;
        }
        paramString.aqH = ((com.tencent.mm.plugin.textstatus.conversation.d.a)localObject);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(paramMStorageEventData, this, paramString));
        AppMethodBeat.o(290969);
        return true;
      }
      paramString = paramMStorageEventData.event;
      Object localObject = com.tencent.mm.plugin.textstatus.conversation.h.b.TjE;
      if (s.p(paramString, com.tencent.mm.plugin.textstatus.conversation.h.b.hGG()))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(this));
        AppMethodBeat.o(290969);
        return true;
      }
      if ((paramMStorageEventData.obj instanceof com.tencent.mm.plugin.textstatus.conversation.d.d))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramMStorageEventData, this));
        AppMethodBeat.o(290969);
        return true;
      }
      if ((paramMStorageEventData.obj instanceof h))
      {
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new e(this, paramMStorageEventData));
        AppMethodBeat.o(290969);
        return true;
      }
      AppMethodBeat.o(290969);
      return false;
    }
    AppMethodBeat.o(290969);
    return false;
  }
  
  public final void bw(final List<com.tencent.mm.plugin.textstatus.conversation.d.a> paramList)
  {
    AppMethodBeat.i(290962);
    s.u(paramList, "convs");
    if (paramList != null) {
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this, paramList));
    }
    AppMethodBeat.o(290962);
  }
  
  public final List<com.tencent.mm.plugin.textstatus.conversation.d.a> getDataList()
  {
    return (List)this.vEn;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(290976);
    int i = this.vEn.size();
    AppMethodBeat.o(290976);
    return i;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(MStorageEventData paramMStorageEventData, a parama, ah.f<com.tencent.mm.plugin.textstatus.conversation.d.a> paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(MStorageEventData paramMStorageEventData, a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(a parama, MStorageEventData paramMStorageEventData)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(a parama, List<com.tencent.mm.plugin.textstatus.conversation.d.a> paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.a
 * JD-Core Version:    0.7.0.1
 */