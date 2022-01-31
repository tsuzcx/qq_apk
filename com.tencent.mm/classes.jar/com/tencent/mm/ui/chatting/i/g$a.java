package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.a.c.b;

final class g$a
  extends c.b
{
  public String appId;
  public String desc;
  public int iconRes;
  public int zPC;
  public int zPD = 0;
  
  public g$a(g paramg, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean atP(String paramString)
  {
    AppMethodBeat.i(32629);
    if (paramString != null)
    {
      boolean bool2 = super.atP(paramString);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = this.title.contains(paramString);
      }
      AppMethodBeat.o(32629);
      return bool1;
    }
    AppMethodBeat.o(32629);
    return false;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(32630);
    String str = "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.cpO + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.bma + '\'' + ", nameInRoom='" + this.iXn + '\'' + '}';
    AppMethodBeat.o(32630);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.g.a
 * JD-Core Version:    0.7.0.1
 */