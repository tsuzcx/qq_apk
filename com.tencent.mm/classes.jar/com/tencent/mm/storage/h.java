package com.tencent.mm.storage;

import com.tencent.mm.plugin.messenger.foundation.a.a.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.g.b;
import junit.framework.Assert;

public final class h
  extends e
{
  public static final String[] dXp = { "CREATE TABLE IF NOT EXISTS appbrandmessage ( msgId INTEGER PRIMARY KEY, msgSvrId INTEGER , type INT, status INT, isSend INT, isShowTimer INTEGER, createTime INTEGER, talker TEXT, content TEXT, imgPath TEXT, reserved TEXT, lvbuffer BLOB, transContent TEXT, transBrandWording TEXT ) ", "CREATE INDEX IF NOT EXISTS  appbrandmessageSvrIdIndex ON appbrandmessage ( msgSvrId )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerIndex ON appbrandmessage ( talker )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalerStatusIndex ON appbrandmessage ( talker,status )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTimeIndex ON appbrandmessage ( createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageCreateTaklerTimeIndex ON appbrandmessage ( talker,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageSendCreateTimeIndex ON appbrandmessage ( status,isSend,createTime )", "CREATE INDEX IF NOT EXISTS  appbrandmessageTalkerTypeIndex ON appbrandmessage ( talker,type )" };
  
  public h(g paramg)
  {
    super(paramg);
    a(bhV(), "appbrandmessage");
    a(new g.b(256, "appbrandmessage", g.b.a(3000001L, 3500000L, 102000001L, 105000000L)));
  }
  
  public final String aaD(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (!ad.gr(paramString)) {
        break;
      }
      return "appbrandmessage";
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.h
 * JD-Core Version:    0.7.0.1
 */