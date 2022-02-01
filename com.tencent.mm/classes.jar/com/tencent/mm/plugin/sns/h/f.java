package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern yam;
  public static String[] yan;
  public static HashMap<String, a> yao;
  
  static
  {
    AppMethodBeat.i(96137);
    yam = Pattern.compile("\\{([\\s\\S]*?)\\}");
    yan = new String[] { "{sex", "{username", "{richtext" };
    yao = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (yao.containsKey(parama.yaj))
    {
      if ((a)yao.get(parama.yaj) == a.yap)
      {
        parama = parama.yaj;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.yai;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.yaj;
    Object localObject1 = localObject2;
    if (bs.isNullOrNil((String)localObject2))
    {
      parama = parama.yai;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = yam.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        ac.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= yan.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(yan[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        yao.put(parama.yaj, a.yaq);
        parama = parama.yai;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        yao.put(parama.yaj, a.yap);
        parama = parama.yaj;
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
      yap = new a("OK", 0);
      yaq = new a("FAIL", 1);
      yar = new a[] { yap, yaq };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */