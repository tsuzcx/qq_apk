package com.tencent.mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
{
  public static final boolean zF;
  
  static
  {
    AppMethodBeat.i(40620);
    zF = o(System.getProperty("java.vm.version"));
    AppMethodBeat.o(40620);
  }
  
  private static boolean o(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(40619);
    bool1 = bool2;
    if (paramString != null)
    {
      localObject = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      bool1 = bool2;
      if (!((Matcher)localObject).matches()) {}
    }
    try
    {
      int i = Integer.parseInt(((Matcher)localObject).group(1));
      int j = Integer.parseInt(((Matcher)localObject).group(2));
      if (i <= 2)
      {
        bool1 = bool2;
        if (i == 2)
        {
          bool1 = bool2;
          if (j <= 0) {}
        }
      }
      else
      {
        bool1 = true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        bool1 = bool2;
      }
    }
    Object localObject = new StringBuilder("VM with version ").append(paramString);
    if (bool1) {}
    for (paramString = " has multidex support";; paramString = " does not have multidex support")
    {
      Log.i("MicroMsg.MultiDex", paramString);
      AppMethodBeat.o(40619);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.g
 * JD-Core Version:    0.7.0.1
 */