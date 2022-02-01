package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern QCl;
  public static String[] QCm;
  public static HashMap<String, a> QCn;
  
  static
  {
    AppMethodBeat.i(96137);
    QCl = Pattern.compile("\\{([\\s\\S]*?)\\}");
    QCm = new String[] { "{sex", "{username", "{richtext" };
    QCn = new HashMap();
    AppMethodBeat.o(96137);
  }
  
  public static String a(d.a parama)
  {
    AppMethodBeat.i(96136);
    if (QCn.containsKey(parama.QCi))
    {
      if ((a)QCn.get(parama.QCi) == a.QCo)
      {
        parama = parama.QCi;
        AppMethodBeat.o(96136);
        return parama;
      }
      parama = parama.QCh;
      AppMethodBeat.o(96136);
      return parama;
    }
    Object localObject2 = parama.QCi;
    Object localObject1 = localObject2;
    if (Util.isNullOrNil((String)localObject2))
    {
      parama = parama.QCh;
      AppMethodBeat.o(96136);
      return parama;
    }
    label237:
    label240:
    for (;;)
    {
      localObject2 = QCl.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        Log.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= QCm.length) {
          break label237;
        }
        if (((String)localObject2).indexOf(QCm[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label240;
        }
        QCn.put(parama.QCi, a.QCp);
        parama = parama.QCh;
        AppMethodBeat.o(96136);
        return parama;
        i += 1;
        break;
        QCn.put(parama.QCi, a.QCo);
        parama = parama.QCi;
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
      QCo = new a("OK", 0);
      QCp = new a("FAIL", 1);
      QCq = new a[] { QCo, QCp };
      AppMethodBeat.o(96135);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.f
 * JD-Core Version:    0.7.0.1
 */