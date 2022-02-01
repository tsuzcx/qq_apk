package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern wNG;
  public static String[] wNH;
  public static HashMap<String, a> wNI;
  
  static
  {
    AppMethodBeat.i(96137);
    wNG = Pattern.compile("\\{([\\s\\S]*?)\\}");
    wNH = new String[] { "{sex", "{username", "{richtext" };
    wNI = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (wNI.containsKey(parama.wND))
    {
      if ((a)wNI.get(parama.wND) == a.wNJ)
      {
        parama = parama.wND;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.wNC;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.wND;
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      parama = parama.wNC;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = wNG.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        ad.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= wNH.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(wNH[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        wNI.put(parama.wND, a.wNK);
        parama = parama.wNC;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        wNI.put(parama.wND, a.wNJ);
        parama = parama.wND;
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
      wNJ = new a("OK", 0);
      wNK = new a("FAIL", 1);
      wNL = new a[] { wNJ, wNK };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.f
 * JD-Core Version:    0.7.0.1
 */