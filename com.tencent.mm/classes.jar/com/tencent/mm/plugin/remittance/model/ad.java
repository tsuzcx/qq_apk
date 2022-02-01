package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;

public final class ad
{
  public static void ars(String paramString)
  {
    AppMethodBeat.i(67912);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(67912);
      return;
    }
    Object localObject = dxQ();
    ac.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(localObject)));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bs.isNullOrNil((String)localObject))
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
    ac.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
    g.agS();
    g.agR().agA().set(327733, localStringBuilder.toString());
    g.agS();
    g.agR().agA().faa();
    AppMethodBeat.o(67912);
  }
  
  public static String dxQ()
  {
    AppMethodBeat.i(67913);
    g.agS();
    String str = bs.nullAsNil((String)g.agR().agA().get(327733, null));
    AppMethodBeat.o(67913);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ad
 * JD-Core Version:    0.7.0.1
 */