package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import junit.framework.Assert;

public final class i
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS appbrandnotifymessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSvrIdIndex ON appbrandnotifymessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerIndex ON appbrandnotifymessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalerStatusIndex ON appbrandnotifymessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTimeIndex ON appbrandnotifymessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTaklerTimeIndex ON appbrandnotifymessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSendCreateTimeIndex ON appbrandnotifymessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerTypeIndex ON appbrandnotifymessage ( talker,type )" };
  
  public i(h paramh)
  {
    super(paramh);
    AppMethodBeat.i(191375);
    c(getDB(), "appbrandnotifymessage");
    a(new h.b(32, "appbrandnotifymessage", h.b.a(3500001L, 4000000L, 105000001L, 108000000L)));
    AppMethodBeat.o(191375);
  }
  
  public final String aHk(String paramString)
  {
    AppMethodBeat.i(191376);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!w.tn(paramString)) {
        break;
      }
      AppMethodBeat.o(191376);
      return "appbrandnotifymessage";
    }
    AppMethodBeat.o(191376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.storage.i
 * JD-Core Version:    0.7.0.1
 */