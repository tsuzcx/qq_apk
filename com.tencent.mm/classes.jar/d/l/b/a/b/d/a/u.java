package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.b.a.g;
import d.l.b.a.b.b.e;
import d.l.b.a.b.c.a.c;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.n.n;

public final class u
{
  public static final l a(ab paramab, String paramString)
  {
    AppMethodBeat.i(57642);
    k.h(paramab, "$this$lexicalCastFrom");
    k.h(paramString, "value");
    Object localObject = paramab.fIW().fxM();
    if (((localObject instanceof e)) && (((e)localObject).fxu() == d.l.b.a.b.b.f.Jqf))
    {
      paramab = ((e)localObject).fyG();
      paramString = d.l.b.a.b.f.f.aQC(paramString);
      k.g(paramString, "Name.identifier(value)");
      paramab = paramab.c(paramString, (d.l.b.a.b.c.a.a)c.JwA);
      if (((paramab instanceof e)) && (((e)paramab).fxu() == d.l.b.a.b.b.f.Jqg))
      {
        paramab = (l)new h((e)paramab);
        AppMethodBeat.o(57642);
        return paramab;
      }
      AppMethodBeat.o(57642);
      return null;
    }
    localObject = d.l.b.a.b.m.d.a.aE(paramab);
    k.h(paramString, "value");
    String str;
    int i;
    if ((n.mA(paramString, "0x")) || (n.mA(paramString, "0X")))
    {
      paramab = paramString.substring(2);
      k.g(paramab, "(this as java.lang.String).substring(startIndex)");
      paramab = new d.l.b.a.b.o.f(paramab, 16);
      str = paramab.Azr;
      i = paramab.KbD;
    }
    for (;;)
    {
      try
      {
        if (!g.p((ab)localObject)) {
          continue;
        }
        bool = Boolean.parseBoolean(paramString);
        paramString = Boolean.valueOf(bool);
      }
      catch (IllegalArgumentException paramab)
      {
        boolean bool;
        paramString = null;
        continue;
        AppMethodBeat.o(57642);
        return null;
      }
      if (paramString != null)
      {
        paramab = (l)new f(paramString);
        AppMethodBeat.o(57642);
        return paramab;
        if ((n.mA(paramString, "0b")) || (n.mA(paramString, "0B")))
        {
          paramab = paramString.substring(2);
          k.g(paramab, "(this as java.lang.String).substring(startIndex)");
          paramab = new d.l.b.a.b.o.f(paramab, 2);
          break;
        }
        paramab = new d.l.b.a.b.o.f(paramString, 10);
        break;
        if (g.q((ab)localObject))
        {
          paramab = (CharSequence)paramString;
          k.h(paramab, "$this$singleOrNull");
          if (paramab.length() != 1) {
            break label552;
          }
          paramString = Character.valueOf(paramab.charAt(0));
          continue;
        }
        if (g.s((ab)localObject))
        {
          k.h(str, "$this$toByteOrNull");
          paramab = n.gJ(str, i);
          if (paramab != null)
          {
            i = paramab.intValue();
            if ((i < -128) || (i > 127)) {
              break label557;
            }
            paramString = Byte.valueOf((byte)i);
          }
        }
        else if (g.u((ab)localObject))
        {
          k.h(str, "$this$toShortOrNull");
          paramab = n.gJ(str, i);
          if (paramab != null)
          {
            i = paramab.intValue();
            if ((i < -32768) || (i > 32767)) {
              break label562;
            }
            paramString = Short.valueOf((short)i);
          }
        }
        else
        {
          if (g.r((ab)localObject))
          {
            paramString = n.gJ(str, i);
            continue;
          }
          if (g.t((ab)localObject))
          {
            paramString = n.gK(str, i);
            continue;
          }
          if (g.v((ab)localObject))
          {
            paramString = n.aRd(paramString);
            continue;
          }
          if (g.w((ab)localObject))
          {
            paramString = n.aRe(paramString);
            continue;
          }
          bool = g.D((ab)localObject);
          if (bool) {
            continue;
          }
        }
        paramString = null;
        continue;
      }
      label552:
      paramString = null;
      continue;
      label557:
      paramString = null;
      continue;
      label562:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.u
 * JD-Core Version:    0.7.0.1
 */