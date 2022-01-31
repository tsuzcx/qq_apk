package com.tencent.mm.sdk.platformtools;

import com.tencent.mm.a.d;

public final class bh
{
  private final d uiw;
  private ab<String, String> uix = new ab(256);
  
  public bh(String paramString)
  {
    this.uiw = new d(paramString);
  }
  
  public final String decryptTag(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (!paramString.startsWith("!")) {
        break label182;
      }
      if (this.uix.aC(paramString)) {
        return (String)this.uix.get(paramString);
      }
      str1 = paramString.substring(1);
      Object localObject2;
      String str2;
      int i;
      y.printErrStackTrace("MicroMsg.TagDecrypter", localException1, "", new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        localObject2 = str1.split("@");
        if (localObject2.length <= 1) {
          break label194;
        }
        str2 = localObject2[0];
        i = Integer.valueOf(localObject2[0]).intValue();
        localObject2 = str1.substring(str2.length() + 1, str2.length() + 1 + i);
        str2 = str1.substring(i + (str2.length() + 1));
        str2 = this.uiw.bI((String)localObject2) + str2;
        this.uix.put(paramString, str2);
        return str2;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          paramString = (String)localObject1;
          Object localObject1 = localException2;
        }
      }
      localException1 = localException1;
    }
    localObject1 = "[td]" + paramString;
    label182:
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bh
 * JD-Core Version:    0.7.0.1
 */