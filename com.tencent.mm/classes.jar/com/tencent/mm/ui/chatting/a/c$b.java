package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class c$b
{
  public String bma;
  public long cpO;
  public String iXn;
  public String nickname;
  public long timestamp;
  public String title;
  public int type;
  public String username;
  Pattern zDQ = Pattern.compile("[._a-zA-Z0-9]+");
  
  public c$b() {}
  
  public c$b(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.timestamp = paramLong1;
    this.type = paramInt;
    this.title = paramString1;
    this.cpO = paramLong2;
    this.username = paramString2;
    this.nickname = paramString3;
    this.bma = paramString4;
    this.iXn = paramString5;
  }
  
  protected static boolean atQ(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toCharArray();
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramString.length)
      {
        if ((paramString[i] >= '一') && (paramString[i] <= 40891)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public boolean atP(String paramString)
  {
    if (!atQ(paramString))
    {
      if ((!bo.isNullOrNil(this.title)) && (isContains(paramString, this.title.toLowerCase()))) {}
      while (((!bo.isNullOrNil(this.nickname)) && (isContains(paramString, this.nickname.toLowerCase()))) || ((!bo.isNullOrNil(this.iXn)) && (isContains(paramString, this.iXn.toLowerCase()))) || ((!bo.isNullOrNil(this.bma)) && (isContains(paramString, this.bma.toLowerCase())))) {
        return true;
      }
    }
    do
    {
      return false;
      if (((!bo.isNullOrNil(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!bo.isNullOrNil(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!bo.isNullOrNil(this.iXn)) && (this.iXn.toLowerCase().contains(paramString)))) {
        break;
      }
    } while ((bo.isNullOrNil(this.bma)) || (!this.bma.toLowerCase().contains(paramString)));
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b))) {
      return this.cpO == ((b)paramObject).cpO;
    }
    return super.equals(paramObject);
  }
  
  public int getType()
  {
    return this.type;
  }
  
  protected final boolean isContains(String paramString1, String paramString2)
  {
    if (!bo.isNullOrNil(paramString2))
    {
      paramString2 = this.zDQ.matcher(paramString2);
      boolean bool1 = false;
      while (paramString2.find())
      {
        String str = paramString2.group();
        boolean bool2 = str.startsWith(paramString1);
        ab.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[] { paramString1, str });
        bool1 = bool2;
        if (bool2) {
          bool1 = bool2;
        }
      }
      return bool1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.a.c.b
 * JD-Core Version:    0.7.0.1
 */