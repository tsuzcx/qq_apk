package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;

public final class ad
{
  public static void aMh(String paramString)
  {
    AppMethodBeat.i(67912);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67912);
      return;
    }
    Object localObject = eNA();
    Log.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(localObject)));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!Util.isNullOrNil((String)localObject))
    {
      localObject = ((String)localObject).split(",");
      if (localObject != null)
      {
        int i = 0;
        int k;
        for (int j = 0; i < localObject.length; j = k)
        {
          k = j;
          if (!paramString.equals(localObject[i]))
          {
            localStringBuilder.append(localObject[i]);
            localStringBuilder.append(",");
            k = j + 1;
            if (k >= 4) {
              break;
            }
          }
          i += 1;
        }
      }
    }
    localStringBuilder.insert(0, ",");
    localStringBuilder.insert(0, paramString);
    localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
    Log.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
    g.aAi();
    g.aAh().azQ().set(327733, localStringBuilder.toString());
    g.aAi();
    g.aAh().azQ().gBI();
    AppMethodBeat.o(67912);
  }
  
  public static String eNA()
  {
    AppMethodBeat.i(67913);
    g.aAi();
    String str = Util.nullAsNil((String)g.aAh().azQ().get(327733, null));
    AppMethodBeat.o(67913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ad
 * JD-Core Version:    0.7.0.1
 */