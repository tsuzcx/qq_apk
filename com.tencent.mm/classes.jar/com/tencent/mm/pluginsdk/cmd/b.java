package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  private static final HashMap<String, a> Fcj;
  private static final HashMap<String, a> Fck;
  private static final Pattern Fcl;
  
  static
  {
    AppMethodBeat.i(151624);
    Fcj = new HashMap();
    Fck = new HashMap();
    Fcl = Pattern.compile(" +");
    AppMethodBeat.o(151624);
  }
  
  public static boolean L(Context paramContext, String arg1, String paramString2)
  {
    AppMethodBeat.i(151622);
    String[] arrayOfString = Fcl.split(???);
    synchronized (Fcj)
    {
      a locala = (a)Fcj.get(arrayOfString[0]);
      if (locala != null)
      {
        ae.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
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
    synchronized (Fcj)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        Fcj.remove(str);
        ae.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
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
    synchronized (Fcj)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        Fcj.put(str, parama);
        ae.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      AppMethodBeat.o(151620);
      return;
    }
  }
  
  static List<a> fcP()
  {
    AppMethodBeat.i(151623);
    synchronized (Fck)
    {
      ArrayList localArrayList = new ArrayList(Fck.values());
      AppMethodBeat.o(151623);
      return localArrayList;
    }
  }
  
  static final class a
  {
    a Fcm;
    String dPH;
    int mqT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.b
 * JD-Core Version:    0.7.0.1
 */