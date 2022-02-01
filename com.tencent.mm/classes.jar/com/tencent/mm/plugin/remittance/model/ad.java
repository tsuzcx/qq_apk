package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;

public final class ad
{
  public static void aml(String paramString)
  {
    AppMethodBeat.i(67912);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67912);
      return;
    }
    Object localObject = djO();
    com.tencent.mm.sdk.platformtools.ad.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(localObject)));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bt.isNullOrNil((String)localObject))
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
    com.tencent.mm.sdk.platformtools.ad.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
    g.afC();
    g.afB().afk().set(327733, localStringBuilder.toString());
    g.afC();
    g.afB().afk().eKy();
    AppMethodBeat.o(67912);
  }
  
  public static String djO()
  {
    AppMethodBeat.i(67913);
    g.afC();
    String str = bt.nullAsNil((String)g.afB().afk().get(327733, null));
    AppMethodBeat.o(67913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ad
 * JD-Core Version:    0.7.0.1
 */