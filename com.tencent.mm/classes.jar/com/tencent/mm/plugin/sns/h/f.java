package com.tencent.mm.plugin.sns.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern zqk;
  public static String[] zql;
  public static HashMap<String, a> zqm;
  
  static
  {
    AppMethodBeat.i(96137);
    zqk = Pattern.compile("\\{([\\s\\S]*?)\\}");
    zql = new String[] { "{sex", "{username", "{richtext" };
    zqm = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (zqm.containsKey(parama.zqh))
    {
      if ((a)zqm.get(parama.zqh) == a.zqn)
      {
        parama = parama.zqh;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.zqg;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.zqh;
    Object localObject1 = localObject2;
    if (bt.isNullOrNil((String)localObject2))
    {
      parama = parama.zqg;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = zqk.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        ad.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= zql.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(zql[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        zqm.put(parama.zqh, a.zqo);
        parama = parama.zqg;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        zqm.put(parama.zqh, a.zqn);
        parama = parama.zqh;
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
      zqn = new a("OK", 0);
      zqo = new a("FAIL", 1);
      zqp = new a[] { zqn, zqo };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.h.f
 * JD-Core Version:    0.7.0.1
 */