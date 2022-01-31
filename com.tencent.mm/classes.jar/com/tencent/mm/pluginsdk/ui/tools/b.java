package com.tencent.mm.pluginsdk.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.List;

public final class b
{
  public static boolean amD(String paramString)
  {
    AppMethodBeat.i(79911);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppNewIconUtil", "markNew fail, appId is empty");
      AppMethodBeat.o(79911);
      return false;
    }
    z localz = g.RL().Ru();
    if (localz == null)
    {
      ab.e("MicroMsg.AppNewIconUtil", "markNew fail, cfgStg is null");
      AppMethodBeat.o(79911);
      return false;
    }
    b.a locala = new b.a((byte)0);
    locala.Yy((String)localz.get(69121, null));
    if (!locala.qIG.contains(paramString)) {
      locala.qIG.add(paramString);
    }
    localz.set(69121, locala.dpu());
    AppMethodBeat.o(79911);
    return true;
  }
  
  public static boolean amE(String paramString)
  {
    AppMethodBeat.i(79912);
    if ((paramString == null) || (paramString.length() == 0))
    {
      ab.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, appId is empty");
      AppMethodBeat.o(79912);
      return false;
    }
    z localz = g.RL().Ru();
    if (localz == null)
    {
      ab.e("MicroMsg.AppNewIconUtil", "unmarkNew fail, cfgStg is null");
      AppMethodBeat.o(79912);
      return false;
    }
    b.a locala = new b.a((byte)0);
    locala.Yy((String)localz.get(69121, null));
    if (locala.qIG.contains(paramString)) {
      locala.qIG.remove(paramString);
    }
    localz.set(69121, locala.dpu());
    AppMethodBeat.o(79912);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.tools.b
 * JD-Core Version:    0.7.0.1
 */