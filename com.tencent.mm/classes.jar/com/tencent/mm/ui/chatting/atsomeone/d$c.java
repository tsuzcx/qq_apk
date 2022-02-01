package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ah;
import com.tencent.mm.view.recyclerview.f;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/ui/chatting/atsomeone/AtSomeoneDialog$buildItemConvertFactory$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "app_release"})
public final class d$c
  implements f
{
  public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
  {
    AppMethodBeat.i(278008);
    if (paramInt == 1)
    {
      localObject = this.WGi.hNW();
      p.j(localObject, "chatroomMember");
      localObject = (com.tencent.mm.view.recyclerview.e)new g((ah)localObject);
      AppMethodBeat.o(278008);
      return localObject;
    }
    Object localObject = this.WGi.hNW();
    p.j(localObject, "chatroomMember");
    localObject = (com.tencent.mm.view.recyclerview.e)new e((ah)localObject);
    AppMethodBeat.o(278008);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.d.c
 * JD-Core Version:    0.7.0.1
 */