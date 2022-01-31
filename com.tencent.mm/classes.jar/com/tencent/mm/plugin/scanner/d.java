package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;
import java.util.List;

public final class d
{
  public static boolean chW()
  {
    AppMethodBeat.i(138579);
    int i = ((a)g.E(a.class)).Nq().getInt("EnableSessionPicTranslation", 0);
    Object localObject = ((a)g.E(a.class)).Nq().getValue("SessionPicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ab.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, aa.dsG() });
      if ((i != 1) || (bo.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(aa.dsG()))) {
        break;
      }
      AppMethodBeat.o(138579);
      return true;
    }
    if (com.tencent.mm.protocal.d.whL)
    {
      AppMethodBeat.o(138579);
      return true;
    }
    AppMethodBeat.o(138579);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d
 * JD-Core Version:    0.7.0.1
 */