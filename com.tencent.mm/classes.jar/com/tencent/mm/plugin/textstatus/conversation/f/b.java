package com.tencent.mm.plugin.textstatus.conversation.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.textstatus.b.f;
import com.tencent.mm.plugin.textstatus.conversation.d.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.cc;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/middler/TextStatusConversationUpdater;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusSessionInfo;", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusConversation;", "()V", "tempLastMsgId", "", "getTempLastMsgId", "()J", "setTempLastMsgId", "(J)V", "afterConvUpdate", "", "conversation", "insertCount", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "afterConversationUpdate", "Lcom/tencent/mm/storage/Conversation;", "newCon", "", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "assemble", "beforeConvUpdate", "checkInsertHolder", "checkInsertHolderInternal", "getConversation", "sessionId", "", "getSessionInfo", "onConversationMsgEmpty", "saveConversationAndNotify", "support", "updateConversation", "conv", "sessionInfo", "lastMsgInfo", "digestData", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;", "hasRedDot", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.plugin.byp.c.a<g, com.tencent.mm.plugin.textstatus.conversation.d.a>
{
  public static final b.a Tjk;
  
  static
  {
    AppMethodBeat.i(291058);
    Tjk = new b.a((byte)0);
    AppMethodBeat.o(291058);
  }
  
  private static com.tencent.mm.plugin.textstatus.conversation.d.a bdJ(String paramString)
  {
    AppMethodBeat.i(291047);
    s.u(paramString, "sessionId");
    f localf = f.TjQ;
    paramString = f.hGL().bdO(paramString);
    AppMethodBeat.o(291047);
    return paramString;
  }
  
  private static boolean bu(cc paramcc)
  {
    AppMethodBeat.i(291041);
    s.u(paramcc, "<this>");
    if (paramcc.getType() == 570425393) {
      try
      {
        paramcc = (String)XmlParser.parseXml(paramcc.field_content, "reddot", null).get(".reddot");
        if ((paramcc != null) && (Integer.parseInt(paramcc) == 1)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(291041);
          return true;
        }
        AppMethodBeat.o(291041);
      }
      finally {}
    }
    return false;
  }
  
  public final void a(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(291069);
    Log.d("MicroMsg.TextStatus.TextStatusConversationUpdater", "assemble() called with: latestMsg = " + paramcc + ", conversation = " + parambb + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(291069);
  }
  
  public final boolean akf(String paramString)
  {
    AppMethodBeat.i(291074);
    s.u(paramString, "sessionId");
    boolean bool = au.bwY(paramString);
    AppMethodBeat.o(291074);
    return bool;
  }
  
  public final void aki(String paramString)
  {
    AppMethodBeat.i(291085);
    s.u(paramString, "sessionId");
    paramString = bdJ(paramString);
    Log.i("MicroMsg.TextStatus.TextStatusConversationUpdater", s.X("[onConversationMsgEmpty] ", Long.valueOf(paramString.systemRowid)));
    if (paramString.systemRowid > 0L)
    {
      paramString.field_digest = "";
      f localf = f.TjQ;
      f.hGL().update(paramString.systemRowid, (IAutoDBItem)paramString, false);
      localf = f.TjQ;
      f.hGL().doNotify(paramString.field_sessionId, 1, paramString);
    }
    AppMethodBeat.o(291085);
  }
  
  public final void b(cc paramcc, bb parambb, boolean paramBoolean, i.c paramc)
  {
    AppMethodBeat.i(291065);
    Log.d("MicroMsg.TextStatus.TextStatusConversationUpdater", "afterConversationUpdate() called with: latestMsg = " + paramcc + ", conversation = " + parambb + ", newCon = " + paramBoolean + ", notifyInfo = " + paramc);
    AppMethodBeat.o(291065);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.f.b
 * JD-Core Version:    0.7.0.1
 */