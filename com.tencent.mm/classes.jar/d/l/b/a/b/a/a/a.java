package d.l.b.a.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.j;
import d.a.x;
import d.g.b.k;
import d.l.b.a.b.b.ab;
import d.l.b.a.b.b.ad;
import d.l.b.a.b.b.y;
import d.l.b.a.b.f.f;
import d.l.b.a.b.l.i;
import d.n.n;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class a
  implements d.l.b.a.b.b.b.b
{
  public static final a LbI;
  private final i KZf;
  private final y LbH;
  
  static
  {
    AppMethodBeat.i(56715);
    LbI = new a((byte)0);
    AppMethodBeat.o(56715);
  }
  
  public a(i parami, y paramy)
  {
    AppMethodBeat.i(56714);
    this.KZf = parami;
    this.LbH = paramy;
    AppMethodBeat.o(56714);
  }
  
  public final boolean a(d.l.b.a.b.f.b paramb, f paramf)
  {
    AppMethodBeat.i(56711);
    k.h(paramb, "packageFqName");
    k.h(paramf, "name");
    paramf = paramf.rf();
    k.g(paramf, "name.asString()");
    if (((n.nb(paramf, "Function")) || (n.nb(paramf, "KFunction")) || (n.nb(paramf, "SuspendFunction")) || (n.nb(paramf, "KSuspendFunction"))) && (a.a(paramf, paramb) != null))
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
    k.h(parama, "classId");
    if ((parama.Dgz) || (parama.fZE()))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    Object localObject1 = parama.fZB().rf();
    k.g(localObject1, "classId.relativeClassName.asString()");
    if (!n.a((CharSequence)localObject1, (CharSequence)"Function", false))
    {
      AppMethodBeat.o(56712);
      return null;
    }
    parama = parama.fZA();
    k.g(parama, "classId.packageFqName");
    Object localObject2 = a.a((String)localObject1, parama);
    if (localObject2 == null)
    {
      AppMethodBeat.o(56712);
      return null;
    }
    localObject1 = ((b)localObject2).LbJ;
    int i = ((b)localObject2).arity;
    localObject2 = (Iterable)this.LbH.e(parama).getFragments();
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
    localObject2 = (d.l.b.a.b.a.e)j.iP((List)localObject2);
    if (localObject2 != null) {}
    for (parama = (d.l.b.a.b.a.b)localObject2;; parama = (d.l.b.a.b.a.b)j.iO(parama))
    {
      parama = (d.l.b.a.b.b.e)new b(this.KZf, (ab)parama, (b.c)localObject1, i);
      AppMethodBeat.o(56712);
      return parama;
    }
  }
  
  public final Collection<d.l.b.a.b.b.e> b(d.l.b.a.b.f.b paramb)
  {
    AppMethodBeat.i(56713);
    k.h(paramb, "packageFqName");
    paramb = (Collection)x.KTH;
    AppMethodBeat.o(56713);
    return paramb;
  }
  
  public static final class a
  {
    static a.b a(String paramString, d.l.b.a.b.f.b paramb)
    {
      AppMethodBeat.i(56705);
      b.c.a locala = b.c.LbZ;
      k.h(paramb, "packageFqName");
      k.h(paramString, "className");
      b.c[] arrayOfc = b.c.values();
      int k = arrayOfc.length;
      int i = 0;
      int j;
      if (i < k)
      {
        locala = arrayOfc[i];
        if ((k.g(locala.LbX, paramb)) && (n.nb(paramString, locala.LbY)))
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
      i = paramb.LbY.length();
      if (paramString == null)
      {
        paramString = new v("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(56705);
        throw paramString;
      }
      paramString = paramString.substring(i);
      k.g(paramString, "(this as java.lang.String).substring(startIndex)");
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
      k.h(paramString, "className");
      k.h(paramb, "packageFqName");
      paramString = a(paramString, paramb);
      if (paramString != null)
      {
        paramString = paramString.LbJ;
        AppMethodBeat.o(56706);
        return paramString;
      }
      AppMethodBeat.o(56706);
      return null;
    }
  }
  
  static final class b
  {
    final b.c LbJ;
    final int arity;
    
    public b(b.c paramc, int paramInt)
    {
      AppMethodBeat.i(56707);
      this.LbJ = paramc;
      this.arity = paramInt;
      AppMethodBeat.o(56707);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(56710);
      if (this != paramObject)
      {
        if (!(paramObject instanceof b)) {
          break label65;
        }
        paramObject = (b)paramObject;
        if (!k.g(this.LbJ, paramObject.LbJ)) {
          break label65;
        }
        if (this.arity != paramObject.arity) {
          break label60;
        }
      }
      label60:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(56710);
        return true;
      }
      label65:
      AppMethodBeat.o(56710);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(56709);
      b.c localc = this.LbJ;
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
      String str = "KindWithArity(kind=" + this.LbJ + ", arity=" + this.arity + ")";
      AppMethodBeat.o(56708);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */