package kotlin.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.x;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ab;
import kotlin.l.b.a.b.b.ad;
import kotlin.l.b.a.b.b.y;
import kotlin.l.b.a.b.f.f;
import kotlin.n.n;
import kotlin.t;

public final class a
  implements kotlin.l.b.a.b.b.b.b
{
  public static final a aaIk;
  private final kotlin.l.b.a.b.l.j aaFH;
  private final y aaIj;
  
  static
  {
    AppMethodBeat.i(56715);
    aaIk = new a((byte)0);
    AppMethodBeat.o(56715);
  }
  
  public a(kotlin.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56714);
    this.aaFH = paramj;
    this.aaIj = paramy;
    AppMethodBeat.o(56714);
  }
  
  public final boolean a(kotlin.l.b.a.b.f.b paramb, f paramf)
  {
    AppMethodBeat.i(56711);
    p.k(paramb, "packageFqName");
    p.k(paramf, "name");
    paramf = paramf.qu();
    p.j(paramf, "name.asString()");
    if (((n.M(paramf, "Function", false)) || (n.M(paramf, "KFunction", false)) || (n.M(paramf, "SuspendFunction", false)) || (n.M(paramf, "KSuspendFunction", false))) && (a.a(paramf, paramb) != null))
    {
      AppMethodBeat.o(56711);
      return true;
    }
    AppMethodBeat.o(56711);
    return false;
  }
  
  public final Collection<kotlin.l.b.a.b.b.e> b(kotlin.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56713);
    p.k(paramb, "packageFqName");
    paramb = (Collection)x.aaAf;
    AppMethodBeat.o(56713);
    return paramb;
  }
  
  public final kotlin.l.b.a.b.b.e b(kotlin.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56712);
    p.k(parama, "classId");
    if ((parama.HLG) || (parama.iNw()))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    Object localObject1 = parama.iNt().qu();
    p.j(localObject1, "classId.relativeClassName.asString()");
    if (!n.a((CharSequence)localObject1, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    parama = parama.iNs();
    p.j(parama, "classId.packageFqName");
    Object localObject2 = a.a((String)localObject1, parama);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56712);
      return null;
    }
    localObject1 = ((a.b)localObject2).aaIl;
    int i = ((a.b)localObject2).arity;
    localObject2 = (Iterable)this.aaIj.e(parama).getFragments();
    parama = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof kotlin.l.b.a.b.a.b)) {
        parama.add(localObject3);
      }
    }
    parama = (List)parama;
    Object localObject3 = (Iterable)parama;
    localObject2 = (Collection)new ArrayList();
    localObject3 = ((Iterable)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = ((Iterator)localObject3).next();
      if ((localObject4 instanceof kotlin.l.b.a.b.a.e)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject2 = (kotlin.l.b.a.b.a.e)kotlin.a.j.lp((List)localObject2);
    if (localObject2 != null) {}
    for (parama = (kotlin.l.b.a.b.a.b)localObject2;; parama = (kotlin.l.b.a.b.a.b)kotlin.a.j.lo(parama))
    {
      parama = (kotlin.l.b.a.b.b.e)new b(this.aaFH, (ab)parama, (b.c)localObject1, i);
      AppMethodBeat.o(56712);
      return parama;
    }
  }
  
  public static final class a
  {
    static a.b a(String paramString, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(56705);
      b.c.a locala = b.c.aaIB;
      p.k(paramb, "packageFqName");
      p.k(paramString, "className");
      b.c[] arrayOfc = b.c.values();
      int k = arrayOfc.length;
      int i = 0;
      int j;
      if (i < k)
      {
        locala = arrayOfc[i];
        if ((p.h(locala.aaIz, paramb)) && (n.M(paramString, locala.aaIA, false)))
        {
          j = 1;
          label73:
          if (j == 0) {
            break label96;
          }
        }
      }
      for (paramb = locala;; paramb = null)
      {
        if (paramb != null) {
          break label108;
        }
        AppMethodBeat.o(56705);
        return null;
        j = 0;
        break label73;
        label96:
        i += 1;
        break;
      }
      label108:
      i = paramb.aaIA.length();
      if (paramString == null)
      {
        paramString = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(56705);
        throw paramString;
      }
      paramString = paramString.substring(i);
      p.j(paramString, "(this as java.lang.String).substring(startIndex)");
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label198;
        }
        paramString = null;
      }
      for (;;)
      {
        if (paramString == null) {
          break label264;
        }
        paramString = new a.b(paramb, paramString.intValue());
        AppMethodBeat.o(56705);
        return paramString;
        i = 0;
        break;
        label198:
        k = paramString.length();
        j = 0;
        int m;
        for (i = 0;; i = m + i * 10)
        {
          if (j >= k) {
            break label256;
          }
          m = paramString.charAt(j) - '0';
          if ((m < 0) || (9 < m))
          {
            paramString = null;
            break;
          }
          j += 1;
        }
        label256:
        paramString = Integer.valueOf(i);
      }
      label264:
      AppMethodBeat.o(56705);
      return null;
    }
    
    public static b.c b(String paramString, kotlin.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(56706);
      p.k(paramString, "className");
      p.k(paramb, "packageFqName");
      paramString = a(paramString, paramb);
      if (paramString != null)
      {
        paramString = paramString.aaIl;
        AppMethodBeat.o(56706);
        return paramString;
      }
      AppMethodBeat.o(56706);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */