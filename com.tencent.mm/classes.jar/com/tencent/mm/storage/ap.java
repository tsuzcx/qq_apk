package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class ap
{
  public String bIW = "-1";
  public String eHA;
  public boolean eHB;
  public long time;
  public boolean uAB;
  public String uAC = "";
  
  public ap(String paramString)
  {
    if (bk.bl(paramString))
    {
      y.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
      return;
    }
    for (;;)
    {
      try
      {
        if (paramString.endsWith("\n"))
        {
          Object localObject = paramString.substring(0, paramString.length() - 1);
          localObject = ((String)localObject).split(":", 6);
          if ((localObject.length != 4) || (!ad.hd(localObject[0]))) {
            break label244;
          }
          i = 1;
          if (localObject.length > i) {
            this.eHA = localObject[i];
          }
          if (localObject.length > i + 1) {
            this.time = bk.getLong(localObject[(i + 1)], 0L);
          }
          if (localObject.length > i + 2) {
            this.eHB = localObject[(i + 2)].equals("1");
          }
          if (localObject.length > i + 3) {
            this.bIW = localObject[(i + 3)];
          }
          if (localObject.length > i + 4) {
            this.uAC = localObject[(i + 4)].replace("*#*", ":");
          }
          if (localObject.length <= i + 5) {
            break;
          }
          this.uAB = localObject[(i + 5)].equals("1");
          return;
        }
      }
      catch (Exception localException)
      {
        this.time = 0L;
        y.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[] { paramString, bk.j(localException) });
        return;
      }
      this.uAC = paramString.replace(":", "*#*");
      String str = paramString;
      continue;
      label244:
      int i = 0;
    }
  }
  
  public static String a(String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    int j = 1;
    paramString3 = paramString3.replace(":", "*#*");
    paramString1 = new StringBuilder().append(paramString1).append(":").append(paramLong).append(":");
    if (paramBoolean1)
    {
      i = 1;
      paramString1 = paramString1.append(i).append(":").append(paramString2).append(":").append(paramString3).append(":");
      if (!paramBoolean2) {
        break label109;
      }
    }
    label109:
    for (int i = j;; i = 0)
    {
      return i + "\n";
      i = 0;
      break;
    }
  }
  
  public static ap abP(String paramString)
  {
    return new ap(paramString);
  }
  
  public final String cuQ()
  {
    int j = 1;
    StringBuilder localStringBuilder = new StringBuilder().append(this.eHA).append(":").append(this.time).append(":");
    if (this.eHB)
    {
      i = 1;
      localStringBuilder = localStringBuilder.append(i).append(":").append(this.bIW).append(":").append(this.uAC).append(":");
      if (!this.uAB) {
        break label106;
      }
    }
    label106:
    for (int i = j;; i = 0)
    {
      return i + "\n";
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */