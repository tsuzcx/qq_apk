package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class ap
{
  public String cqq;
  private String fXq;
  public boolean fXr;
  public long time;
  public boolean yMK;
  public String yML;
  
  public ap(String paramString)
  {
    AppMethodBeat.i(62699);
    this.cqq = "-1";
    this.yML = "";
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. content is null.");
      AppMethodBeat.o(62699);
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
          if ((localObject.length == 4) && (ad.nM(localObject[0])))
          {
            i = 1;
            if (localObject.length > i) {
              this.fXq = localObject[i];
            }
            if (localObject.length > i + 1) {
              this.time = bo.getLong(localObject[(i + 1)], 0L);
            }
            if (localObject.length > i + 2) {
              this.fXr = localObject[(i + 2)].equals("1");
            }
            if (localObject.length > i + 3) {
              this.cqq = localObject[(i + 3)];
            }
            if (localObject.length > i + 4) {
              this.yML = localObject[(i + 4)].replace("*#*", ":");
            }
            if (localObject.length > i + 5) {
              this.yMK = localObject[(i + 5)].equals("1");
            }
            AppMethodBeat.o(62699);
          }
        }
        else
        {
          this.yML = paramString.replace(":", "*#*");
          localObject = paramString;
          continue;
        }
        int i = 0;
      }
      catch (Exception localException)
      {
        this.time = 0L;
        ab.e("MicroMsg.emoji.EmojiContent", "EmojiContent parse failed. Content:%s Excpetion:%s", new Object[] { paramString, bo.l(localException) });
        AppMethodBeat.o(62699);
        return;
      }
    }
  }
  
  public static String a(String paramString1, long paramLong, boolean paramBoolean1, String paramString2, boolean paramBoolean2, String paramString3)
  {
    int j = 1;
    AppMethodBeat.i(62697);
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
      AppMethodBeat.o(62697);
      return paramString1;
      i = 0;
      break;
    }
  }
  
  public static ap arZ(String paramString)
  {
    AppMethodBeat.i(62700);
    paramString = new ap(paramString);
    AppMethodBeat.o(62700);
    return paramString;
  }
  
  public final String alM()
  {
    return this.fXq;
  }
  
  public final String dxr()
  {
    int j = 1;
    AppMethodBeat.i(62698);
    Object localObject = new StringBuilder().append(this.fXq).append(":").append(this.time).append(":");
    if (this.fXr)
    {
      i = 1;
      localObject = ((StringBuilder)localObject).append(i).append(":").append(this.cqq).append(":").append(this.yML).append(":");
      if (!this.yMK) {
        break label118;
      }
    }
    label118:
    for (int i = j;; i = 0)
    {
      localObject = i + "\n";
      AppMethodBeat.o(62698);
      return localObject;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.storage.ap
 * JD-Core Version:    0.7.0.1
 */