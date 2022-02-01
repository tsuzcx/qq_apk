package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import junit.framework.Assert;

public final class i
  extends e
{
  public static final String[] SQL_CREATE = { "CREATE TABLE IF NOT EXISTS appbrandnotifymessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSvrIdIndex ON appbrandnotifymessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerIndex ON appbrandnotifymessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalerStatusIndex ON appbrandnotifymessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTimeIndex ON appbrandnotifymessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageCreateTaklerTimeIndex ON appbrandnotifymessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageSendCreateTimeIndex ON appbrandnotifymessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandnotifymessageTalkerTypeIndex ON appbrandnotifymessage ( talker,type )" };
  
  public i(com.tencent.mm.plugin.messenger.foundation.a.a.i parami)
  {
    super(parami);
    AppMethodBeat.i(186859);
    d(getDB(), "appbrandnotifymessage");
    a(new i.b(32, "appbrandnotifymessage", i.b.a(3500001L, 4000000L, 105000001L, 108000000L)));
    AppMethodBeat.o(186859);
  }
  
  public final String ajr(String paramString)
  {
    AppMethodBeat.i(186860);
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!x.AX(paramString)) {
        break;
      }
      AppMethodBeat.o(186860);
      return "appbrandnotifymessage";
    }
    AppMethodBeat.o(186860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.i
 * JD-Core Version:    0.7.0.1
 */