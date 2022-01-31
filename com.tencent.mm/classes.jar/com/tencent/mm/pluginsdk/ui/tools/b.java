package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.List;

public final class b
{
  public static boolean WT(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      return false;
    }
    z localz = g.DP().Dz();
    if (localz == null)
    {
      y.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      return false;
    }
    b.a locala = new b.a((byte)0);
    locala.LX((String)localz.get(69121, null));
    if (!locala.nUB.contains(paramString)) {
      locala.nUB.add(paramString);
    }
    localz.o(69121, locala.cof());
    return true;
  }
  
  public static boolean WU(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      y.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      return false;
    }
    z localz = g.DP().Dz();
    if (localz == null)
    {
      y.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      return false;
    }
    b.a locala = new b.a((byte)0);
    locala.LX((String)localz.get(69121, null));
    if (locala.nUB.contains(paramString)) {
      locala.nUB.remove(paramString);
    }
    localz.o(69121, locala.cof());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */