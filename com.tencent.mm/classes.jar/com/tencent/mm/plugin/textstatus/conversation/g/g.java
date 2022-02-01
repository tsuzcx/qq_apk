package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.h.f.b;
import com.tencent.mm.plugin.textstatus.h.f.h;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusStrangerInfoService;", "", "()V", "TAG", "", "getStatus", "Lcom/tencent/mm/plugin/textstatus/model/storage/TextStatusItem;", "sessionId", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g TjC;
  
  static
  {
    AppMethodBeat.i(291107);
    TjC = new g();
    AppMethodBeat.o(291107);
  }
  
  public static b bdN(String paramString)
  {
    AppMethodBeat.i(291094);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291094);
      return null;
    }
    localObject1 = a.Tjq;
    h localh = a.bdK(paramString);
    if (localh == null)
    {
      AppMethodBeat.o(291094);
      return null;
    }
    Object localObject2 = localh.hHR();
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new TextStatusExtInfo();
    }
    localObject2 = new b();
    ((b)localObject2).field_UserName = paramString;
    ((b)localObject2).field_StatusID = localh.field_textStatusId;
    paramString = f.TjQ;
    f.a((b)localObject2, (TextStatusExtInfo)localObject1);
    if ((b.b((b)localObject2).topics == null) || (b.b((b)localObject2).topics.isEmpty()))
    {
      AppMethodBeat.o(291094);
      return null;
    }
    AppMethodBeat.o(291094);
    return localObject2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.g
 * JD-Core Version:    0.7.0.1
 */