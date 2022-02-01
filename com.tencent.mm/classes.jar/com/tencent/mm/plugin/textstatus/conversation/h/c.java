package com.tencent.mm.plugin.textstatus.conversation.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.e;
import junit.framework.Assert;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusMessageStorage;", "Lcom/tencent/mm/storage/AbstractMessageStorage;", "storage", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "(Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;)V", "recognizeTableByTalker", "", "talker", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends e
{
  public static final c.a TjG;
  
  static
  {
    AppMethodBeat.i(291052);
    TjG = new c.a((byte)0);
    AppMethodBeat.o(291052);
  }
  
  public c(i parami)
  {
    super(parami);
    AppMethodBeat.i(291045);
    e(getDB(), "textstatusmessage");
    a(new i.b(2048, "textstatusmessage", i.b.d(5000001L, 5500000L, 308000001L, 408000000L)));
    AppMethodBeat.o(291045);
  }
  
  public final String aAD(String paramString)
  {
    AppMethodBeat.i(291060);
    int i;
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label54;
        }
      }
    }
    label54:
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!au.bwY(paramString)) {
        break label59;
      }
      AppMethodBeat.o(291060);
      return "textstatusmessage";
      i = 0;
      break;
    }
    label59:
    AppMethodBeat.o(291060);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.h.c
 * JD-Core Version:    0.7.0.1
 */