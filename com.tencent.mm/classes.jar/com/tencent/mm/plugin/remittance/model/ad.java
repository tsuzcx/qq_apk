package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;

public final class ad
{
  public static void axH(String paramString)
  {
    AppMethodBeat.i(67912);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67912);
      return;
    }
    Object localObject = dMA();
    ae.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(localObject)));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bu.isNullOrNil((String)localObject))
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
    ae.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
    g.ajS();
    g.ajR().ajA().set(327733, localStringBuilder.toString());
    g.ajS();
    g.ajR().ajA().fuc();
    AppMethodBeat.o(67912);
  }
  
  public static String dMA()
  {
    AppMethodBeat.i(67913);
    g.ajS();
    String str = bu.nullAsNil((String)g.ajR().ajA().get(327733, null));
    AppMethodBeat.o(67913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ad
 * JD-Core Version:    0.7.0.1
 */