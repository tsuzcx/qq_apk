package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class au
{
  public boolean GXr;
  public String GXs;
  private String iaC;
  public boolean iaD;
  public String md5;
  public long time;
  
  public au(String paramString)
  {
    AppMethodBeat.i(104954);
    this.md5 = "-1";
    this.GXs = "";
    if (bs.isNullOrNil(paramString))
    {
      ac.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
      AppMethodBeat.o(104954);
      return;
    }
    for (;;)
    {
      try
      {
        Object localObject;
        if (paramString.endsWith("\n"))
        {
          localObject = paramString.substring(0, paramString.length() - 1);
          localObject = ((String)localObject).split(":", 6);
          if ((localObject.length == 4) && (ai.ww(localObject[0])))
          {
            i = 1;
            if (localObject.length > i) {
              this.iaC = localObject[i];
            }
            if (localObject.length > i + 1) {
              this.time = bs.getLong(localObject[(i + 1)], 0L);
            }
            if (localObject.length > i + 2) {
              this.iaD = localObject[(i + 2)].equals("1");
            }
            if (localObject.length > i + 3) {
              this.md5 = localObject[(i + 3)];
            }
            if (localObject.length > i + 4) {
              this.GXs = localObject[(i + 4)].replace("*#*", ":");
            }
            if (localObject.length > i + 5) {
              this.GXr = localObject[(i + 5)].equals("1");
            }
            AppMethodBeat.o(104954);
          }
        }
        else
        {
          this.GXs = paramString.replace(":", "*#*");
          localObject = paramString;
          continue;
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        this.time = 0L;
        ac.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[] { paramString, bs.m(localException) });
        AppMethodBeat.o(104954);
        return;
      }
    }
  }
  
  public static String a(String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    int j = 1;
    AppMethodBeat.i(104952);
    paramString3 = paramString3.replace(":", "*#*");
    paramString1 = new StringBuilder().append(paramString1).append(":").append(paramLong).append(":");
    if (paramBoolean1)
    {
      i = 1;
      paramString1 = paramString1.append(i).append(":").append(paramString2).append(":").append(paramString3).append(":");
      if (!paramBoolean2) {
        break label121;
      }
    }
    label121:
    for (int i = j;; i = 0)
    {
      paramString1 = i + "\n";
      AppMethodBeat.o(104952);
      return paramString1;
      i = 0;
      break;
    }
  }
  
  public static au aOb(String paramString)
  {
    AppMethodBeat.i(104955);
    paramString = new au(paramString);
    AppMethodBeat.o(104955);
    return paramString;
  }
  
  public final String aJH()
  {
    return this.iaC;
  }
  
  public final String dFY()
  {
    int j = 1;
    AppMethodBeat.i(104953);
    Object localObject = new StringBuilder().append(this.iaC).append(":").append(this.time).append(":");
    if (this.iaD)
    {
      i = 1;
      localObject = ((StringBuilder)localObject).append(i).append(":").append(this.md5).append(":").append(this.GXs).append(":");
      if (!this.GXr) {
        break label118;
      }
    }
    label118:
    for (int i = j;; i = 0)
    {
      localObject = i + "\n";
      AppMethodBeat.o(104953);
      return localObject;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.au
 * JD-Core Version:    0.7.0.1
 */