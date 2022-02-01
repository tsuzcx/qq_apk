package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.auth.a.a;
import com.tencent.mm.plugin.textstatus.a.t;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.plugin.textstatus.conversation.h.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusSessionInfoService;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusSessionInfoService;", "()V", "getSessionId", "", "selfUsername", "", "talker", "scene", "", "extInfo", "Lcom/tencent/mm/protobuf/ByteString;", "callback", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusSessionInfoService$SessionIdCallback;", "getSessionIdFromLocal", "getSessionInfoBySessionId", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusSessionInfo;", "sessionId", "getSessionSender", "getTalkerFromLocal", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements t
{
  public static final a TjB;
  
  static
  {
    AppMethodBeat.i(291083);
    TjB = new a((byte)0);
    AppMethodBeat.o(291083);
  }
  
  public final String aAw(String paramString)
  {
    AppMethodBeat.i(291095);
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    paramString = com.tencent.mm.plugin.textstatus.b.f.hGM().bdP(paramString).field_talker;
    if (paramString == null)
    {
      AppMethodBeat.o(291095);
      return "";
    }
    AppMethodBeat.o(291095);
    return paramString;
  }
  
  public final String hFy()
  {
    AppMethodBeat.i(291088);
    String str = a.cUx();
    s.s(str, "username()");
    AppMethodBeat.o(291088);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusSessionInfoService$Companion;", "", "()V", "TAG", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.f
 * JD-Core Version:    0.7.0.1
 */