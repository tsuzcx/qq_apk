package com.tencent.mm.plugin.scanner;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;
import java.util.List;

public final class g
{
  public static boolean dkW()
  {
    AppMethodBeat.i(151578);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("EnableSnsPicTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.eFu() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.eFu()))) {
        break;
      }
      AppMethodBeat.o(151578);
      return true;
    }
    if (d.CpO)
    {
      AppMethodBeat.o(151578);
      return true;
    }
    AppMethodBeat.o(151578);
    return false;
  }
  
  public static boolean dkX()
  {
    AppMethodBeat.i(151579);
    int i = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getInt("EnableFavPicTranslation", 0);
    Object localObject = ((a)com.tencent.mm.kernel.g.ab(a.class)).Zd().getValue("PicTranslationSupportUserLanguage");
    if (i == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ad.i("MicroMsg.ScannerHelper", "enable %s, support lang %s, current lang %s", new Object[] { Boolean.valueOf(bool), localObject, ac.eFu() });
      if ((i != 1) || (bt.isNullOrNil((String)localObject))) {
        break;
      }
      localObject = ((String)localObject).split(";");
      if ((localObject == null) || (!Arrays.asList((Object[])localObject).contains(ac.eFu()))) {
        break;
      }
      AppMethodBeat.o(151579);
      return true;
    }
    if (d.CpO)
    {
      AppMethodBeat.o(151579);
      return true;
    }
    AppMethodBeat.o(151579);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.g
 * JD-Core Version:    0.7.0.1
 */