package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.d;

public final class bl
{
  private ae<String, String> yqA;
  private final d yqz;
  
  public bl(String paramString)
  {
    AppMethodBeat.i(52281);
    this.yqA = new ae(256);
    this.yqz = new d(paramString);
    AppMethodBeat.o(52281);
  }
  
  public final String decryptTag(String paramString)
  {
    AppMethodBeat.i(52282);
    String str1 = paramString;
    try
    {
      if (!paramString.startsWith("!")) {
        break label192;
      }
      if (this.yqA.Z(paramString))
      {
        str1 = (String)this.yqA.get(paramString);
        AppMethodBeat.o(52282);
        return str1;
      }
      str1 = paramString.substring(1);
      Object localObject2;
      String str2;
      int i;
      ab.printErrStackTrace("MicroMsg.TagDecrypter", localException1, "", new Object[0]);
    }
    catch (Exception localException1)
    {
      try
      {
        localObject2 = str1.split("@");
        if (localObject2.length <= 1) {
          break label209;
        }
        str2 = localObject2[0];
        i = Integer.valueOf(localObject2[0]).intValue();
        localObject2 = str1.substring(str2.length() + 1, str2.length() + 1 + i);
        str2 = str1.substring(i + (str2.length() + 1));
        str2 = this.yqz.cL((String)localObject2) + str2;
        this.yqA.put(paramString, str2);
        AppMethodBeat.o(52282);
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
    localObject1 = "[td]".concat(String.valueOf(paramString));
    label192:
    AppMethodBeat.o(52282);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bl
 * JD-Core Version:    0.7.0.1
 */