package com.tencent.xweb.xwalk.b;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;

public final class d
{
  static a.b a(a.e parame)
  {
    AppMethodBeat.i(85471);
    if (parame.BKU != null)
    {
      parame = parame.BKU;
      int j = parame.length;
      int i = 0;
      while (i < j)
      {
        a.b localb = parame[i];
        if (localb.BKN == XWalkEnvironment.getInstalledNewstVersion())
        {
          XWalkInitializer.addXWalkInitializeLog("got matched patch");
          AppMethodBeat.o(85471);
          return localb;
        }
        i += 1;
      }
    }
    XWalkInitializer.addXWalkInitializeLog("no matched patch");
    AppMethodBeat.o(85471);
    return null;
  }
  
  static a.e a(a.a parama)
  {
    AppMethodBeat.i(85470);
    if ((parama == null) || (parama.BKL == null) || (parama.BKL.length == 0))
    {
      AppMethodBeat.o(85470);
      return null;
    }
    int i = Build.VERSION.SDK_INT;
    parama = parama.BKL;
    int j = parama.length;
    i = 0;
    if (i < j)
    {
      a.e locale = parama[i];
      if (locale == null) {
        XWalkInitializer.addXWalkInitializeLog("no matched version  version == null");
      }
      for (;;)
      {
        i += 1;
        break;
        Log.i("VersionMatcher", "try match version = " + locale.BKV);
        if (locale.BKV < 49)
        {
          Log.i("VersionMatcher", " apk is not support, below 49");
        }
        else if (locale.BKV <= XWalkEnvironment.getInstalledNewstVersion())
        {
          Log.i("VersionMatcher", " apk is too old ");
        }
        else
        {
          if (locale.BGj.dYM()) {
            break label153;
          }
          Log.i("VersionMatcher", " apk filter out ");
        }
      }
      label153:
      AppMethodBeat.o(85470);
      return locale;
    }
    XWalkInitializer.addXWalkInitializeLog("no matched version");
    AppMethodBeat.o(85470);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.xweb.xwalk.b.d
 * JD-Core Version:    0.7.0.1
 */