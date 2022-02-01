package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.x;
import d.g.b.p;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  implements d.l.b.a.b.b.b.b
{
  public static final a NpI;
  private final d.l.b.a.b.l.j Nnf;
  private final y NpH;
  
  static
  {
    AppMethodBeat.i(56715);
    NpI = new a((byte)0);
    AppMethodBeat.o(56715);
  }
  
  public a(d.l.b.a.b.l.j paramj, y paramy)
  {
    AppMethodBeat.i(56714);
    this.Nnf = paramj;
    this.NpH = paramy;
    AppMethodBeat.o(56714);
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, f paramf)
  {
    AppMethodBeat.i(56711);
    p.h(paramb, "packageFqName");
    p.h(paramf, "name");
    paramf = paramf.sD();
    p.g(paramf, "name.asString()");
    if (((n.nF(paramf, "Function")) || (n.nF(paramf, "KFunction")) || (n.nF(paramf, "SuspendFunction")) || (n.nF(paramf, "KSuspendFunction"))) && (a.a(paramf, paramb) != null))
    {
      AppMethodBeat.o(56711);
      return true;
    }
    AppMethodBeat.o(56711);
    return false;
  }
  
  public final d.l.b.a.b.b.e b(d.l.b.a.b.f.a parama)
  {
    AppMethodBeat.i(56712);
    p.h(parama, "classId");
    if ((parama.FdH) || (parama.gvF()))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    Object localObject1 = parama.gvC().sD();
    p.g(localObject1, "classId.relativeClassName.asString()");
    if (!n.a((CharSequence)localObject1, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    parama = parama.gvB();
    p.g(parama, "classId.packageFqName");
    Object localObject2 = a.a((String)localObject1, parama);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56712);
      return null;
    }
    localObject1 = ((b)localObject2).NpJ;
    int i = ((b)localObject2).arity;
    localObject2 = (Iterable)this.NpH.e(parama).getFragments();
    parama = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if ((localObject3 instanceof d.l.b.a.b.a.b)) {
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
      if ((localObject4 instanceof d.l.b.a.b.a.e)) {
        ((Collection)localObject2).add(localObject4);
      }
    }
    localObject2 = (d.l.b.a.b.a.e)d.a.j.jm((List)localObject2);
    if (localObject2 != null) {}
    for (parama = (d.l.b.a.b.a.b)localObject2;; parama = (d.l.b.a.b.a.b)d.a.j.jl(parama))
    {
      parama = (d.l.b.a.b.b.e)new b(this.Nnf, (ab)parama, (b.c)localObject1, i);
      AppMethodBeat.o(56712);
      return parama;
    }
  }
  
  public final Collection<d.l.b.a.b.b.e> b(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56713);
    p.h(paramb, "packageFqName");
    paramb = (Collection)x.NhJ;
    AppMethodBeat.o(56713);
    return paramb;
  }
  
  public static final class a
  {
    static a.b a(String paramString, d.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(56705);
      b.c.a locala = b.c.NpZ;
      p.h(paramb, "packageFqName");
      p.h(paramString, "className");
      b.c[] arrayOfc = b.c.values();
      int k = arrayOfc.length;
      int i = 0;
      int j;
      if (i < k)
      {
        locala = arrayOfc[i];
        if ((p.i(locala.NpX, paramb)) && (n.nF(paramString, locala.NpY)))
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
      i = paramb.NpY.length();
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
    
    public static b.c b(String paramString, d.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(56706);
      p.h(paramString, "className");
      p.h(paramb, "packageFqName");
      paramString = a(paramString, paramb);
      if (paramString != null)
      {
        paramString = paramString.NpJ;
        AppMethodBeat.o(56706);
        return paramString;
      }
      AppMethodBeat.o(56706);
      return null;
    }
  }
  
  static final class b
  {
    final b.c NpJ;
    final int arity;
    
    public b(b.c paramc, int paramInt)
    {
      AppMethodBeat.i(56707);
      this.NpJ = paramc;
      this.arity = paramInt;
      AppMethodBeat.o(56707);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(56710);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((!p.i(this.NpJ, paramObject.NpJ)) || (this.arity != paramObject.arity)) {}
        }
      }
      else
      {
        AppMethodBeat.o(56710);
        return true;
      }
      AppMethodBeat.o(56710);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(56709);
      b.c localc = this.NpJ;
      if (localc != null) {}
      for (int i = localc.hashCode();; i = 0)
      {
        int j = this.arity;
        AppMethodBeat.o(56709);
        return i * 31 + j;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(56708);
      String str = "KindWithArity(kind=" + this.NpJ + ", arity=" + this.arity + ")";
      AppMethodBeat.o(56708);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */