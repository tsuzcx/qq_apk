package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  private static final HashMap<String, a> EJL;
  private static final HashMap<String, a> EJM;
  private static final Pattern EJN;
  
  static
  {
    AppMethodBeat.i(151624);
    EJL = new HashMap();
    EJM = new HashMap();
    EJN = Pattern.compile(" +");
    AppMethodBeat.o(151624);
  }
  
  public static boolean L(Context paramContext, String arg1, String paramString2)
  {
    AppMethodBeat.i(151622);
    String[] arrayOfString = EJN.split(???);
    synchronized (EJL)
    {
      a locala = (a)EJL.get(arrayOfString[0]);
      if (locala != null)
      {
        ad.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
        boolean bool = locala.a(paramContext, arrayOfString, paramString2);
        AppMethodBeat.o(151622);
        return bool;
      }
    }
    AppMethodBeat.o(151622);
    return false;
  }
  
  public static void S(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(151621);
    synchronized (EJL)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        EJL.remove(str);
        ad.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(151621);
      return;
    }
  }
  
  public static void a(a parama, String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(151620);
    synchronized (EJL)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        EJL.put(str, parama);
        ad.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(151620);
      return;
    }
  }
  
  static List<a> eZb()
  {
    AppMethodBeat.i(151623);
    synchronized (EJM)
    {
      ArrayList localArrayList = new ArrayList(EJM.values());
      AppMethodBeat.o(151623);
      return localArrayList;
    }
  }
  
  static final class a
  {
    a EJO;
    String dOr;
    int mlW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.b
 * JD-Core Version:    0.7.0.1
 */