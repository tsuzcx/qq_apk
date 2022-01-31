package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class c$b
{
  public String aVs;
  public long bIt;
  public String hkV;
  public String nickname;
  public long timestamp;
  public String title;
  public int type;
  public String username;
  Pattern vou = Pattern.compile("[._a-zA-Z0-9]+");
  
  public c$b() {}
  
  public c$b(long paramLong1, int paramInt, String paramString1, long paramLong2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.timestamp = paramLong1;
    this.type = paramInt;
    this.title = paramString1;
    this.bIt = paramLong2;
    this.username = paramString2;
    this.nickname = paramString3;
    this.aVs = paramString4;
    this.hkV = paramString5;
  }
  
  public static boolean adp(String paramString)
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
  
  public boolean ado(String paramString)
  {
    if (!adp(paramString))
    {
      if ((!bk.bl(this.title)) && (isContains(paramString, this.title.toLowerCase()))) {}
      while (((!bk.bl(this.nickname)) && (isContains(paramString, this.nickname.toLowerCase()))) || ((!bk.bl(this.hkV)) && (isContains(paramString, this.hkV.toLowerCase()))) || ((!bk.bl(this.aVs)) && (isContains(paramString, this.aVs.toLowerCase())))) {
        return true;
      }
    }
    do
    {
      return false;
      if (((!bk.bl(this.title)) && (this.title.toLowerCase().contains(paramString))) || ((!bk.bl(this.nickname)) && (this.nickname.toLowerCase().contains(paramString))) || ((!bk.bl(this.hkV)) && (this.hkV.toLowerCase().contains(paramString)))) {
        break;
      }
    } while ((bk.bl(this.aVs)) || (!this.aVs.toLowerCase().contains(paramString)));
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof b))) {
      return this.bIt == ((b)paramObject).bIt;
    }
    return super.equals(paramObject);
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public final boolean isContains(String paramString1, String paramString2)
  {
    if (!bk.bl(paramString2))
    {
      paramString2 = this.vou.matcher(paramString2);
      boolean bool1 = false;
      while (paramString2.find())
      {
        String str = paramString2.group();
        boolean bool2 = str.startsWith(paramString1);
        y.i("MicroMsg.MediaHistoryListAdapter", "[isContains] search:%s group:%s", new Object[] { paramString1, str });
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