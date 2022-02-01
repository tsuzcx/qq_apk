package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l.b.a.b.a.g;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.c.a.c;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.n.n;

public final class u
{
  public static final l a(ab paramab, String paramString)
  {
    AppMethodBeat.i(57642);
    p.h(paramab, "$this$lexicalCastFrom");
    p.h(paramString, "value");
    Object localObject = paramab.hKE().hzS();
    if (((localObject instanceof e)) && (((e)localObject).hzB() == kotlin.l.b.a.b.b.f.Thg))
    {
      paramab = ((e)localObject).hAN();
      paramString = kotlin.l.b.a.b.f.f.btY(paramString);
      p.g(paramString, "Name.identifier(value)");
      paramab = paramab.c(paramString, (kotlin.l.b.a.b.c.a.a)c.TnD);
      if (((paramab instanceof e)) && (((e)paramab).hzB() == kotlin.l.b.a.b.b.f.Thh))
      {
        paramab = (l)new h((e)paramab);
        AppMethodBeat.o(57642);
        return paramab;
      }
      AppMethodBeat.o(57642);
      return null;
    }
    localObject = kotlin.l.b.a.b.m.d.a.aD(paramab);
    p.h(paramString, "value");
    String str;
    int i;
    if ((n.J(paramString, "0x", false)) || (n.J(paramString, "0X", false)))
    {
      paramab = paramString.substring(2);
      p.g(paramab, "(this as java.lang.String).substring(startIndex)");
      paramab = new kotlin.l.b.a.b.o.f(paramab, 16);
      str = paramab.Itb;
      i = paramab.TRT;
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
        if ((n.J(paramString, "0b", false)) || (n.J(paramString, "0B", false)))
        {
          paramab = paramString.substring(2);
          p.g(paramab, "(this as java.lang.String).substring(startIndex)");
          paramab = new kotlin.l.b.a.b.o.f(paramab, 2);
          break;
        }
        paramab = new kotlin.l.b.a.b.o.f(paramString, 10);
        break;
        if (g.q((ab)localObject))
        {
          paramab = (CharSequence)paramString;
          p.h(paramab, "$this$singleOrNull");
          if (paramab.length() != 1) {
            break label556;
          }
          paramString = Character.valueOf(paramab.charAt(0));
          continue;
        }
        if (g.s((ab)localObject))
        {
          p.h(str, "$this$toByteOrNull");
          paramab = n.hT(str, i);
          if (paramab != null)
          {
            i = paramab.intValue();
            if ((i < -128) || (i > 127)) {
              break label561;
            }
            paramString = Byte.valueOf((byte)i);
          }
        }
        else if (g.u((ab)localObject))
        {
          p.h(str, "$this$toShortOrNull");
          paramab = n.hT(str, i);
          if (paramab != null)
          {
            i = paramab.intValue();
            if ((i < -32768) || (i > 32767)) {
              break label566;
            }
            paramString = Short.valueOf((short)i);
          }
        }
        else
        {
          if (g.r((ab)localObject))
          {
            paramString = n.hT(str, i);
            continue;
          }
          if (g.t((ab)localObject))
          {
            paramString = n.hU(str, i);
            continue;
          }
          if (g.v((ab)localObject))
          {
            paramString = n.buy(paramString);
            continue;
          }
          if (g.w((ab)localObject))
          {
            paramString = n.buz(paramString);
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
      label556:
      paramString = null;
      continue;
      label561:
      paramString = null;
      continue;
      label566:
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.u
 * JD-Core Version:    0.7.0.1
 */