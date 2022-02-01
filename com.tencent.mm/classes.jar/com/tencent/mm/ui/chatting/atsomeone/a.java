package com.tencent.mm.ui.chatting.atsomeone;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.storage.ah;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/atsomeone/AtAllDataSource;", "Lcom/tencent/mm/plugin/livelist/datasource/BaseDataSource;", "Lcom/tencent/mm/ui/chatting/atsomeone/AtSomeoneLiveItem;", "chatroom", "", "(Ljava/lang/String;)V", "getChatroom", "()Ljava/lang/String;", "memberList", "", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/livelist/datasource/DataResponse;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "request", "Lcom/tencent/mm/plugin/livelist/datasource/DataRequest;", "getPriority", "", "onCreate", "", "Companion", "app_release"})
public final class a
  extends com.tencent.mm.plugin.livelist.a.a<f>
{
  public static final a.a WFV;
  private List<String> fMr;
  private final String fxT;
  
  static
  {
    AppMethodBeat.i(277258);
    WFV = new a.a((byte)0);
    AppMethodBeat.o(277258);
  }
  
  public a(String paramString)
  {
    AppMethodBeat.i(277256);
    this.fxT = paramString;
    AppMethodBeat.o(277256);
  }
  
  public final int getPriority()
  {
    return 0;
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(277251);
    Object localObject = h.ae(b.class);
    p.j(localObject, "MMKernel.service(IChatroomService::class.java)");
    localObject = ((b)localObject).bbV().Rw(this.fxT);
    if (localObject != null)
    {
      if ((((ah)localObject).Rh(z.bcZ())) || (((ah)localObject).bvA(z.bcZ())))
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("notify@all");
        this.fMr = ((List)localObject);
      }
      AppMethodBeat.o(277251);
      return;
    }
    AppMethodBeat.o(277251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.atsomeone.a
 * JD-Core Version:    0.7.0.1
 */