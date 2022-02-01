package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static String[] DRA;
  public static HashMap<String, a> DRB;
  public static final Pattern DRz;
  
  static
  {
    AppMethodBeat.i(96137);
    DRz = Pattern.compile("\\{([\\s\\S]*?)\\}");
    DRA = new String[] { "{sex", "{username", "{richtext" };
    DRB = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (DRB.containsKey(parama.DRw))
    {
      if ((a)DRB.get(parama.DRw) == a.DRC)
      {
        parama = parama.DRw;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.DRv;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.DRw;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      parama = parama.DRv;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = DRz.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        Log.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= DRA.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(DRA[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        DRB.put(parama.DRw, a.DRD);
        parama = parama.DRv;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        DRB.put(parama.DRw, a.DRC);
        parama = parama.DRw;
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
      DRC = new a("OK", 0);
      DRD = new a("FAIL", 1);
      DRE = new a[] { DRC, DRD };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */