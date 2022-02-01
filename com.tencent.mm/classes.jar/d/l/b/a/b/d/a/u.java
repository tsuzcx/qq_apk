package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
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
    p.h(paramab, "$this$lexicalCastFrom");
    p.h(paramString, "value");
    Object localObject = paramab.gxB().gmq();
    if (((localObject instanceof e)) && (((e)localObject).glY() == d.l.b.a.b.b.f.Nry))
    {
      paramab = ((e)localObject).gnl();
      paramString = d.l.b.a.b.f.f.bei(paramString);
      p.g(paramString, "Name.identifier(value)");
      paramab = paramab.c(paramString, (d.l.b.a.b.c.a.a)c.NxV);
      if (((paramab instanceof e)) && (((e)paramab).glY() == d.l.b.a.b.b.f.Nrz))
      {
        paramab = (l)new h((e)paramab);
        AppMethodBeat.o(57642);
        return paramab;
      }
      AppMethodBeat.o(57642);
      return null;
    }
    localObject = d.l.b.a.b.m.d.a.aE(paramab);
    p.h(paramString, "value");
    String str;
    int i;
    if ((n.nF(paramString, "0x")) || (n.nF(paramString, "0X")))
    {
      paramab = paramString.substring(2);
      p.g(paramab, "(this as java.lang.String).substring(startIndex)");
      paramab = new d.l.b.a.b.o.f(paramab, 16);
      str = paramab.DJL;
      i = paramab.OcZ;
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
        if ((n.nF(paramString, "0b")) || (n.nF(paramString, "0B")))
        {
          paramab = paramString.substring(2);
          p.g(paramab, "(this as java.lang.String).substring(startIndex)");
          paramab = new d.l.b.a.b.o.f(paramab, 2);
          break;
        }
        paramab = new d.l.b.a.b.o.f(paramString, 10);
        break;
        if (g.q((ab)localObject))
        {
          paramab = (CharSequence)paramString;
          p.h(paramab, "$this$singleOrNull");
          if (paramab.length() != 1) {
            break label552;
          }
          paramString = Character.valueOf(paramab.charAt(0));
          continue;
        }
        if (g.s((ab)localObject))
        {
          p.h(str, "$this$toByteOrNull");
          paramab = n.hx(str, i);
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
          p.h(str, "$this$toShortOrNull");
          paramab = n.hx(str, i);
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
            paramString = n.hx(str, i);
            continue;
          }
          if (g.t((ab)localObject))
          {
            paramString = n.hy(str, i);
            continue;
          }
          if (g.v((ab)localObject))
          {
            paramString = n.beJ(paramString);
            continue;
          }
          if (g.w((ab)localObject))
          {
            paramString = n.beK(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.d.a.u
 * JD-Core Version:    0.7.0.1
 */