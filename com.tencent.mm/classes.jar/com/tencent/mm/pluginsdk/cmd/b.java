package com.tencent.mm.pluginsdk.cmd;

import android.content.Context;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

public final class b
{
  private static final HashMap<String, a> rSM = new HashMap();
  private static final HashMap<String, b.a> rSN = new HashMap();
  private static final Pattern rSO = Pattern.compile(" +");
  
  public static void E(String... paramVarArgs)
  {
    int i = 0;
    synchronized (rSM)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        rSM.remove(str);
        y.i("MicroMsg.UnifiedCommandProcessor", "Unregistered command: %s", new Object[] { str });
        i += 1;
      }
      return;
    }
  }
  
  public static void a(a parama, String... paramVarArgs)
  {
    int i = 0;
    synchronized (rSM)
    {
      int j = paramVarArgs.length;
      while (i < j)
      {
        String str = paramVarArgs[i];
        rSM.put(str, parama);
        y.i("MicroMsg.UnifiedCommandProcessor", "Registered command: %s", new Object[] { str });
        i += 1;
      }
      return;
    }
  }
  
  public static boolean bg(Context paramContext, String arg1)
  {
    String[] arrayOfString = rSO.split(???);
    synchronized (rSM)
    {
      a locala = (a)rSM.get(arrayOfString[0]);
      if (locala != null)
      {
        y.i("MicroMsg.UnifiedCommandProcessor", "Command: %s", new Object[] { arrayOfString[0] });
        return locala.a(paramContext, arrayOfString);
      }
    }
    return false;
  }
  
  static List<b.a> ckq()
  {
    synchronized (rSN)
    {
      ArrayList localArrayList = new ArrayList(rSN.values());
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.cmd.b
 * JD-Core Version:    0.7.0.1
 */