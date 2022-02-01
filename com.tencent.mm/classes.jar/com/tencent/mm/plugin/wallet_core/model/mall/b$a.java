package com.tencent.mm.plugin.wallet_core.model.mall;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

public final class b$a
{
  public static void bgK(String paramString)
  {
    int k = 0;
    AppMethodBeat.i(301177);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(301177);
      return;
    }
    h.baF();
    String str2 = (String)h.baE().ban().get(at.a.acLL, null);
    String str1;
    if (Util.isNullOrNil(str2)) {
      str1 = paramString;
    }
    for (;;)
    {
      h.baF();
      h.baE().ban().set(at.a.acLL, str1);
      AppMethodBeat.o(301177);
      return;
      String[] arrayOfString = str2.split(",");
      str1 = paramString;
      if (arrayOfString != null)
      {
        str1 = paramString;
        if (arrayOfString.length != 0)
        {
          int i = 0;
          for (;;)
          {
            int j = k;
            if (i < arrayOfString.length)
            {
              if (arrayOfString[i].equals(paramString)) {
                j = 1;
              }
            }
            else
            {
              if (j != 0) {
                break label167;
              }
              str1 = str2 + "," + paramString;
              break;
            }
            i += 1;
          }
          label167:
          str1 = str2;
        }
      }
    }
  }
  
  public static boolean bgL(String paramString)
  {
    boolean bool2 = false;
    AppMethodBeat.i(301178);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(301178);
      return true;
    }
    h.baF();
    Object localObject = (String)h.baE().ban().get(at.a.acLL, null);
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(301178);
      return false;
    }
    localObject = ((String)localObject).split(",");
    if ((localObject == null) || (localObject.length == 0))
    {
      AppMethodBeat.o(301178);
      return false;
    }
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < localObject.length)
      {
        if (localObject[i].equals(paramString)) {
          bool1 = true;
        }
      }
      else
      {
        AppMethodBeat.o(301178);
        return bool1;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.model.mall.b.a
 * JD-Core Version:    0.7.0.1
 */