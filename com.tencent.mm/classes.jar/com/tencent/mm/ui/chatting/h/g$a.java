package com.tencent.mm.ui.chatting.h;

import com.tencent.mm.ui.chatting.a.c.b;

final class g$a
  extends c.b
{
  public String appId;
  public String desc;
  public int iconRes;
  public int vzf;
  public int vzg = 0;
  
  public g$a(g paramg, long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    super(paramLong1, paramInt, paramString1, paramLong2, paramString2, paramString3, paramString4, paramString5);
  }
  
  public final boolean ado(String paramString)
  {
    if (paramString != null)
    {
      boolean bool2 = super.ado(paramString);
      boolean bool1 = bool2;
      if (!bool2) {
        bool1 = this.title.contains(paramString);
      }
      return bool1;
    }
    return false;
  }
  
  public final int getType()
  {
    return this.type;
  }
  
  public final String toString()
  {
    return "PayMediaHistoryListItem{appId='" + this.appId + '\'' + ", desc='" + this.desc + '\'' + ", timestamp=" + this.timestamp + ", type=" + this.type + ", title='" + this.title + '\'' + ", msgId=" + this.bIt + ", username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", remarkName='" + this.aVs + '\'' + ", nameInRoom='" + this.hkV + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.g.a
 * JD-Core Version:    0.7.0.1
 */