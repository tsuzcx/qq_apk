package com.tencent.mm.ui.chatting.atsomeone;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.cd.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aj;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneSearchItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroomMember", "Lcom/tencent/mm/storage/ChatRoomMember;", "(Lcom/tencent/mm/storage/ChatRoomMember;)V", "getChatroomMember", "()Lcom/tencent/mm/storage/ChatRoomMember;", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.view.recyclerview.f<f>
{
  private final aj HuK;
  
  public g(aj paramaj)
  {
    AppMethodBeat.i(254160);
    this.HuK = paramaj;
    AppMethodBeat.o(254160);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(254168);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(254168);
  }
  
  public final int getLayoutId()
  {
    AppMethodBeat.i(254161);
    if (a.mp(MMApplicationContext.getContext()))
    {
      i = R.i.select_ui_listcontactitem_large;
      AppMethodBeat.o(254161);
      return i;
    }
    int i = R.i.select_ui_listcontactitem;
    AppMethodBeat.o(254161);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.g
 * JD-Core Version:    0.7.0.1
 */