package com.tencent.mm.ui.chatting.l;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.b;

final class g$a
  extends c.b
{
  public String appId;
  public String desc;
  public int fcB;
  public int iconRes;
  public int rqS = 0;
  
  public g$a(g paramg, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean bzd(String paramString)
  {
    AppMethodBeat.i(36569);
    if (paramString != null)
    {
      boolean bool2 = super.bzd(paramString);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = this.title.contains(paramString);
      }
      AppMethodBeat.o(36569);
      return bool1;
    }
    AppMethodBeat.o(36569);
    return false;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(36570);
    String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.msgId + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.cip + '\'' + ", nameInRoom='" + this.rif + '\'' + '}';
    AppMethodBeat.o(36570);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.l.g.a
 * JD-Core Version:    0.7.0.1
 */