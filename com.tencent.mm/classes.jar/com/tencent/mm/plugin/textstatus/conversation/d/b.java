package com.tencent.mm.plugin.textstatus.conversation.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversationDataSource;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "type", "", "scene", "(II)V", "getConversationStorage", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "loadOnLoadMore", "", "offset", "loadOnPageEnter", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements BasePrivateMsgConvListFragment.c<a>
{
  public static final b.a TiS;
  private final int scene = 1;
  private final int type = 1;
  
  static
  {
    AppMethodBeat.i(290935);
    TiS = new b.a((byte)0);
    AppMethodBeat.o(290935);
  }
  
  public final MAutoStorage<a> aNP()
  {
    AppMethodBeat.i(290947);
    Object localObject = f.TjQ;
    localObject = (MAutoStorage)f.hGL();
    AppMethodBeat.o(290947);
    return localObject;
  }
  
  public final List<a> aNQ()
  {
    AppMethodBeat.i(290961);
    Object localObject1 = new LinkedList();
    Object localObject2 = ((com.tencent.mm.plugin.textstatus.conversation.h.a)aNP()).bf(0, 15, this.scene);
    if (!((Collection)localObject2).isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((LinkedList)localObject1).addAll((Collection)localObject2);
      }
      localObject2 = f.TjQ;
      f.hGN();
      localObject2 = com.tencent.mm.plugin.textstatus.conversation.h.b.hGE();
      if (localObject2 != null) {
        ((LinkedList)localObject1).add(0, localObject2);
      }
      localObject1 = (List)localObject1;
      AppMethodBeat.o(290961);
      return localObject1;
    }
  }
  
  public final List<a> qH(int paramInt)
  {
    AppMethodBeat.i(290967);
    List localList = ((com.tencent.mm.plugin.textstatus.conversation.h.a)aNP()).bf(paramInt, 60, this.scene);
    AppMethodBeat.o(290967);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.d.b
 * JD-Core Version:    0.7.0.1
 */