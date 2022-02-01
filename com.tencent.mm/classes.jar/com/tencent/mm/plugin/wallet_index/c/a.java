package com.tencent.mm.plugin.wallet_index.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public static boolean lw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(71809);
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(71809);
      return false;
    }
    Object localObject = null;
    String[] arrayOfString = paramString1.split("&");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString1 = localObject;
      if (i < j)
      {
        paramString1 = arrayOfString[i].split("=");
        if ((paramString1.length > 1) && (paramString1[0].equals("prepay_id"))) {
          paramString1 = paramString1[1];
        }
      }
      else
      {
        if (!Util.isNullOrNil(paramString1)) {
          break;
        }
        AppMethodBeat.o(71809);
        return false;
      }
      i += 1;
    }
    if (paramString1.startsWith(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(71809);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_index.c.a
 * JD-Core Version:    0.7.0.1
 */