package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.f.b;
import d.n.n;
import d.v;

public final class a$a
{
  static a.b a(String paramString, b paramb)
  {
    AppMethodBeat.i(56705);
    b.c.a locala = b.c.MSU;
    p.h(paramb, "packageFqName");
    p.h(paramString, "className");
    b.c[] arrayOfc = b.c.values();
    int k = arrayOfc.length;
    int i = 0;
    int j;
    if (i < k)
    {
      locala = arrayOfc[i];
      if ((p.i(locala.MSS, paramb)) && (n.nz(paramString, locala.MST)))
      {
        j = 1;
        label72:
        if (j == 0) {
          break label95;
        }
      }
    }
    for (paramb = locala;; paramb = null)
    {
      if (paramb != null) {
        break label107;
      }
      AppMethodBeat.o(56705);
      return null;
      j = 0;
      break label72;
      label95:
      i += 1;
      break;
    }
    label107:
    i = paramb.MST.length();
    if (paramString == null)
    {
      paramString = new v("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(56705);
      throw paramString;
    }
    paramString = paramString.substring(i);
    p.g(paramString, "(this as java.lang.String).substring(startIndex)");
    if (((CharSequence)paramString).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label197;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString == null) {
        break label263;
      }
      paramString = new a.b(paramb, paramString.intValue());
      AppMethodBeat.o(56705);
      return paramString;
      i = 0;
      break;
      label197:
      k = paramString.length();
      j = 0;
      int m;
      for (i = 0;; i = m + i * 10)
      {
        if (j >= k) {
          break label255;
        }
        m = paramString.charAt(j) - '0';
        if ((m < 0) || (9 < m))
        {
          paramString = null;
          break;
        }
        j += 1;
      }
      label255:
      paramString = Integer.valueOf(i);
    }
    label263:
    AppMethodBeat.o(56705);
    return null;
  }
  
  public static b.c b(String paramString, b paramb)
  {
    AppMethodBeat.i(56706);
    p.h(paramString, "className");
    p.h(paramb, "packageFqName");
    paramString = a(paramString, paramb);
    if (paramString != null)
    {
      paramString = paramString.MSE;
      AppMethodBeat.o(56706);
      return paramString;
    }
    AppMethodBeat.o(56706);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */