package com.tencent.mm.plugin.remittance.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;

public final class ac
{
  public static void Yi(String paramString)
  {
    AppMethodBeat.i(44799);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44799);
      return;
    }
    Object localObject = cgX();
    ab.d("Micromsg.RemittanceLogic", "cur friendsListStr=".concat(String.valueOf(localObject)));
    StringBuilder localStringBuilder = new StringBuilder();
    if (!bo.isNullOrNil((String)localObject))
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
    ab.d("Micromsg.RemittanceLogic", "new friendsListStr=" + localStringBuilder.toString());
    g.RM();
    g.RL().Ru().set(327733, localStringBuilder.toString());
    g.RM();
    g.RL().Ru().dww();
    AppMethodBeat.o(44799);
  }
  
  public static String cgX()
  {
    AppMethodBeat.i(44800);
    g.RM();
    String str = bo.nullAsNil((String)g.RL().Ru().get(327733, null));
    AppMethodBeat.o(44800);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.remittance.model.ac
 * JD-Core Version:    0.7.0.1
 */