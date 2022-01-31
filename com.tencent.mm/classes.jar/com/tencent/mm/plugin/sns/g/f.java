package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern rlA;
  public static String[] rlB;
  public static HashMap<String, f.a> rlC;
  
  static
  {
    AppMethodBeat.i(36809);
    rlA = Pattern.compile("\\{([\\s\\S]*?)\\}");
    rlB = new String[] { "{sex", "{username", "{richtext" };
    rlC = new HashMap();
    AppMethodBeat.o(36809);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(36808);
    if (rlC.containsKey(parama.rlx))
    {
      if ((f.a)rlC.get(parama.rlx) == f.a.rlD)
      {
        parama = parama.rlx;
        AppMethodBeat.o(36808);
        return parama;
      }
      parama = parama.rlw;
      AppMethodBeat.o(36808);
      return parama;
    }
    Object localObject2 = parama.rlx;
    Object localObject1 = localObject2;
    if (bo.isNullOrNil((String)localObject2))
    {
      parama = parama.rlw;
      AppMethodBeat.o(36808);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = rlA.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        ab.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= rlB.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(rlB[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        rlC.put(parama.rlx, f.a.rlE);
        parama = parama.rlw;
        AppMethodBeat.o(36808);
        return parama;
        i += 1;
        break;
        rlC.put(parama.rlx, f.a.rlD);
        parama = parama.rlx;
        AppMethodBeat.o(36808);
        return parama;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.g.f
 * JD-Core Version:    0.7.0.1
 */