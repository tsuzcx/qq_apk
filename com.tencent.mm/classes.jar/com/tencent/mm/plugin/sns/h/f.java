package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static String[] zHA;
  public static HashMap<String, a> zHB;
  public static final Pattern zHz;
  
  static
  {
    AppMethodBeat.i(96137);
    zHz = Pattern.compile("\\{([\\s\\S]*?)\\}");
    zHA = new String[] { "{sex", "{username", "{richtext" };
    zHB = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (zHB.containsKey(parama.zHw))
    {
      if ((a)zHB.get(parama.zHw) == a.zHC)
      {
        parama = parama.zHw;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.zHv;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.zHw;
    Object localObject1 = localObject2;
    if (bu.isNullOrNil((String)localObject2))
    {
      parama = parama.zHv;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = zHz.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        ae.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= zHA.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(zHA[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        zHB.put(parama.zHw, a.zHD);
        parama = parama.zHv;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        zHB.put(parama.zHw, a.zHC);
        parama = parama.zHw;
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
      zHC = new a("OK", 0);
      zHD = new a("FAIL", 1);
      zHE = new a[] { zHC, zHD };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */