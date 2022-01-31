package com.tencent.mm.splash;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class g
{
  public static final boolean qd;
  
  static
  {
    AppMethodBeat.i(114827);
    qd = D(System.getProperty("java.vm.version"));
    AppMethodBeat.o(114827);
  }
  
  private static boolean D(String paramString)
  {
    bool2 = false;
    AppMethodBeat.i(114826);
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
      ab.i("MicroMsg.MultiDex", paramString);
      AppMethodBeat.o(114826);
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.splash.g
 * JD-Core Version:    0.7.0.1
 */