package com.tencent.mm.plugin.textstatus.conversation.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusConversationService;", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusConversationService;", "()V", "getEditing", "", "sessionId", "getUnreadCount", "", "setEditing", "", "content", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.plugin.textstatus.a.s
{
  public static final b Tjv;
  
  static
  {
    AppMethodBeat.i(291064);
    Tjv = new b();
    AppMethodBeat.o(291064);
  }
  
  public final int aAs(String paramString)
  {
    AppMethodBeat.i(291086);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291086);
      return 0;
    }
    localObject = f.TjQ;
    i = f.hGL().aAs(paramString);
    AppMethodBeat.o(291086);
    return i;
  }
  
  public final String aAu(String paramString)
  {
    AppMethodBeat.i(291068);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291068);
      return "";
    }
    localObject = f.TjQ;
    paramString = f.hGL().bdO(paramString).field_editingMsg;
    if (paramString == null)
    {
      AppMethodBeat.o(291068);
      return "";
    }
    AppMethodBeat.o(291068);
    return paramString;
  }
  
  public final boolean ie(String paramString1, String paramString2)
  {
    AppMethodBeat.i(291077);
    Object localObject = (CharSequence)paramString1;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(291077);
      return false;
    }
    if (paramString2 == null)
    {
      AppMethodBeat.o(291077);
      return false;
    }
    localObject = f.TjQ;
    localObject = f.hGL();
    kotlin.g.b.s.u(paramString1, "sessionId");
    kotlin.g.b.s.u(paramString2, "editing");
    com.tencent.mm.plugin.textstatus.conversation.d.a locala = ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject).bdO(paramString1);
    locala.field_editingMsg = paramString2;
    boolean bool = ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject).update(locala.systemRowid, (IAutoDBItem)locala, false);
    ((com.tencent.mm.plugin.textstatus.conversation.h.a)localObject).doNotify(locala.field_sessionId, 7, locala);
    Log.i("MicroMsg.TextStatus.TextStatusConversationStorage", "[setTopPlace] ret=" + bool + " editing=" + paramString2 + " sessionId=" + paramString1);
    AppMethodBeat.o(291077);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.b
 * JD-Core Version:    0.7.0.1
 */