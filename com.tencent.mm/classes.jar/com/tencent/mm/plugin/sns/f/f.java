package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class f
{
  public static final Pattern owG = Pattern.compile("\\{([\\s\\S]*?)\\}");
  public static String[] owH = { "{sex", "{username", "{richtext" };
  public static HashMap<String, f.a> owI = new HashMap();
  
  public static String a(d.a parama)
  {
    if (owI.containsKey(parama.owD))
    {
      if ((f.a)owI.get(parama.owD) == f.a.owJ) {
        return parama.owD;
      }
      return parama.owC;
    }
    Object localObject2 = parama.owD;
    Object localObject1 = localObject2;
    if (bk.bl((String)localObject2)) {
      return parama.owC;
    }
    label197:
    label200:
    for (;;)
    {
      localObject2 = owG.matcher((CharSequence)localObject1);
      if (((Matcher)localObject2).find())
      {
        i = ((Matcher)localObject2).groupCount();
        localObject2 = ((Matcher)localObject2).group();
        y.i("MicroMsg.SnsAbTestUtil", "hello matcher group() " + i + " " + (String)localObject2);
        localObject1 = ((String)localObject1).replace((CharSequence)localObject2, "");
        i = 0;
        if (i >= owH.length) {
          break label197;
        }
        if (((String)localObject2).indexOf(owH[i]) < 0) {}
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label200;
        }
        owI.put(parama.owD, f.a.owK);
        return parama.owC;
        i += 1;
        break;
        owI.put(parama.owD, f.a.owJ);
        return parama.owD;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.f.f
 * JD-Core Version:    0.7.0.1
 */