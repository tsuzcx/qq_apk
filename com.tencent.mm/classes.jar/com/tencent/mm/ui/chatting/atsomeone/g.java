package com.tencent.mm.ui.chatting.atsomeone;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.ci.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ah;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"})
public final class g
  extends e<f>
{
  private final ah WFW;
  
  public g(ah paramah)
  {
    AppMethodBeat.i(268430);
    this.WFW = paramah;
    AppMethodBeat.o(268430);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(268428);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(268428);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(268427);
    if (a.ko(MMApplicationContext.getContext()))
    {
      i = R.i.select_ui_listcontactitem_large;
      AppMethodBeat.o(268427);
      return i;
    }
    int i = R.i.select_ui_listcontactitem;
    AppMethodBeat.o(268427);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.g
 * JD-Core Version:    0.7.0.1
 */