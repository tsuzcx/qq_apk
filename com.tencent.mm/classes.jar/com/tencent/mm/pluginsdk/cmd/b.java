package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  private static final HashMap<String, a> vJK;
  private static final HashMap<String, b.a> vJL;
  private static final Pattern vJM;
  
  static
  {
    AppMethodBeat.i(79203);
    vJK = new HashMap();
    vJL = new HashMap();
    vJM = Pattern.compile(" +");
    AppMethodBeat.o(79203);
  }
  
  public static boolean B(Context paramContext, String arg1, String paramString2)
  {
    AppMethodBeat.i(79201);
    String[] arrayOfString = vJM.split(???);
    synchronized (vJK)
    {
      a locala = (a)vJK.get(arrayOfString[0]);
      if (locala != null)
      {
        ab.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
        boolean bool = locala.a(paramContext, arrayOfString, paramString2);
        AppMethodBeat.o(79201);
        return bool;
      }
    }
    AppMethodBeat.o(79201);
    return false;
  }
  
  public static void N(String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(79200);
    synchronized (vJK)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        vJK.remove(str);
        ab.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(79200);
      return;
    }
  }
  
  public static void a(a parama, String... paramVarArgs)
  {
    int i = 0;
    AppMethodBeat.i(79199);
    synchronized (vJK)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        vJK.put(str, parama);
        ab.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(79199);
      return;
    }
  }
  
  static List<b.a> dkW()
  {
    AppMethodBeat.i(79202);
    synchronized (vJL)
    {
      ArrayList localArrayList = new ArrayList(vJL.values());
      AppMethodBeat.o(79202);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.b
 * JD-Core Version:    0.7.0.1
 */