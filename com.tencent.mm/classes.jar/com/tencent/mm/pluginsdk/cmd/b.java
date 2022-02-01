package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  private static final HashMap<String, a> JTi;
  private static final HashMap<String, a> JTj;
  private static final Pattern JTk;
  
  static
  {
    AppMethodBeat.i(151624);
    JTi = new HashMap();
    JTj = new HashMap();
    JTk = Pattern.compile(" +");
    AppMethodBeat.o(151624);
  }
  
  public static boolean Q(Context paramContext, String arg1, String paramString2)
  {
    AppMethodBeat.i(151622);
    String[] arrayOfString = JTk.split(???);
    synchronized (JTi)
    {
      a locala = (a)JTi.get(arrayOfString[0]);
      if (locala != null)
      {
        Log.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
        boolean bool = locala.a(paramContext, arrayOfString, paramString2);
        AppMethodBeat.o(151622);
        return bool;
      }
    }
    AppMethodBeat.o(151622);
    return false;
  }
  
  public static void V(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(151621);
    synchronized (JTi)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        JTi.remove(str);
        Log.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
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
    synchronized (JTi)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        JTi.put(str, parama);
        Log.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(151620);
      return;
    }
  }
  
  static List<a> gmb()
  {
    AppMethodBeat.i(151623);
    synchronized (JTj)
    {
      ArrayList localArrayList = new ArrayList(JTj.values());
      AppMethodBeat.o(151623);
      return localArrayList;
    }
  }
  
  static final class a
  {
    a JTl;
    String ehK;
    int nBF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.b
 * JD-Core Version:    0.7.0.1
 */