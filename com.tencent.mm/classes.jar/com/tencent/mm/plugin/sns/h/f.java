package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern KeG;
  public static String[] KeH;
  public static HashMap<String, a> KeI;
  
  static
  {
    AppMethodBeat.i(96137);
    KeG = Pattern.compile("\\{([\\s\\S]*?)\\}");
    KeH = new String[] { "{sex", "{username", "{richtext" };
    KeI = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (KeI.containsKey(parama.KeD))
    {
      if ((a)KeI.get(parama.KeD) == a.KeJ)
      {
        parama = parama.KeD;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.KeC;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.KeD;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      parama = parama.KeC;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = KeG.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        Log.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= KeH.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(KeH[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        KeI.put(parama.KeD, a.KeK);
        parama = parama.KeC;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        KeI.put(parama.KeD, a.KeJ);
        parama = parama.KeD;
        AppMethodBeat.o(96136);
        return parama;
      }
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(96135);
      KeJ = new a("OK", 0);
      KeK = new a("FAIL", 1);
      KeL = new a[] { KeJ, KeK };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */