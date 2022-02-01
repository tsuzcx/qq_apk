package kotlin.l.b.a.b.d.a.c.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.a.ad;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.b.af;
import kotlin.g.b.ag;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.d.a.c.c;
import kotlin.l.b.a.b.d.a.e.t;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.g.j;
import kotlin.l.b.a.b.l.m;
import kotlin.l.e;
import kotlin.l.o;

public final class d
  implements kotlin.l.b.a.b.j.g.h
{
  private final h aiSH;
  final i aiSI;
  private final kotlin.l.b.a.b.l.h aiSJ;
  private final kotlin.l.b.a.b.d.a.c.h aiSh;
  
  static
  {
    AppMethodBeat.i(57783);
    aYe = new o[] { (o)ai.a((af)new ag((e)ai.cz(d.class), "kotlinScopes", "getKotlinScopes()[Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")) };
    AppMethodBeat.o(57783);
  }
  
  public d(kotlin.l.b.a.b.d.a.c.h paramh, t paramt, h paramh1)
  {
    AppMethodBeat.i(57792);
    this.aiSh = paramh;
    this.aiSH = paramh1;
    this.aiSI = new i(this.aiSh, paramt, this.aiSH);
    this.aiSJ = this.aiSh.aiSp.aiBu.cq((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(57792);
  }
  
  private final kotlin.l.b.a.b.j.g.h[] ksn()
  {
    AppMethodBeat.i(192162);
    kotlin.l.b.a.b.j.g.h[] arrayOfh = (kotlin.l.b.a.b.j.g.h[])kotlin.l.b.a.b.l.l.a(this.aiSJ, aYe[0]);
    AppMethodBeat.o(192162);
    return arrayOfh;
  }
  
  public final Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57786);
    s.u(paramf, "name");
    s.u(paramb, "location");
    d(paramf, paramb);
    Object localObject = this.aiSI;
    kotlin.l.b.a.b.j.g.h[] arrayOfh = ksn();
    localObject = ((kotlin.l.b.a.b.j.g.h)localObject).a(paramf, paramb);
    int i = 0;
    int j = arrayOfh.length;
    while (i < j)
    {
      kotlin.l.b.a.b.j.g.h localh = arrayOfh[i];
      i += 1;
      localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, localh.a(paramf, paramb));
    }
    if (localObject == null)
    {
      paramf = (Collection)ad.aivA;
      AppMethodBeat.o(57786);
      return paramf;
    }
    AppMethodBeat.o(57786);
    return localObject;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(kotlin.l.b.a.b.j.g.d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    AppMethodBeat.i(57788);
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    Object localObject = this.aiSI;
    kotlin.l.b.a.b.j.g.h[] arrayOfh = ksn();
    localObject = ((kotlin.l.b.a.b.j.g.h)localObject).a(paramd, paramb);
    int i = 0;
    int j = arrayOfh.length;
    while (i < j)
    {
      kotlin.l.b.a.b.j.g.h localh = arrayOfh[i];
      i += 1;
      localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, localh.a(paramd, paramb));
    }
    if (localObject == null)
    {
      paramd = (Collection)ad.aivA;
      AppMethodBeat.o(57788);
      return paramd;
    }
    AppMethodBeat.o(57788);
    return localObject;
  }
  
  public final Collection<au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57787);
    s.u(paramf, "name");
    s.u(paramb, "location");
    d(paramf, paramb);
    Object localObject = this.aiSI;
    kotlin.l.b.a.b.j.g.h[] arrayOfh = ksn();
    localObject = ((kotlin.l.b.a.b.j.g.h)localObject).b(paramf, paramb);
    int i = 0;
    int j = arrayOfh.length;
    while (i < j)
    {
      kotlin.l.b.a.b.j.g.h localh = arrayOfh[i];
      i += 1;
      localObject = kotlin.l.b.a.b.n.b.a.a((Collection)localObject, localh.b(paramf, paramb));
    }
    if (localObject == null)
    {
      paramf = (Collection)ad.aivA;
      AppMethodBeat.o(57787);
      return paramf;
    }
    AppMethodBeat.o(57787);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.b.h c(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57785);
    s.u(paramf, "name");
    s.u(paramb, "location");
    d(paramf, paramb);
    Object localObject1 = this.aiSI.e(paramf, paramb);
    if (localObject1 != null)
    {
      paramf = (kotlin.l.b.a.b.b.h)localObject1;
      AppMethodBeat.o(57785);
      return paramf;
    }
    kotlin.l.b.a.b.j.g.h[] arrayOfh = ksn();
    localObject1 = null;
    int i = 0;
    int j = arrayOfh.length;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = arrayOfh[i];
        i += 1;
        localObject2 = ((kotlin.l.b.a.b.j.g.h)localObject2).c(paramf, paramb);
        if (localObject2 != null) {
          if (((localObject2 instanceof kotlin.l.b.a.b.b.i)) && (((kotlin.l.b.a.b.b.i)localObject2).kni()))
          {
            if (localObject1 == null) {
              localObject1 = localObject2;
            }
          }
          else
          {
            AppMethodBeat.o(57785);
            return localObject2;
          }
        }
      }
      else
      {
        AppMethodBeat.o(57785);
        return localObject1;
      }
    }
  }
  
  public final void d(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    AppMethodBeat.i(57791);
    s.u(paramf, "name");
    s.u(paramb, "location");
    kotlin.l.b.a.b.c.a.a(this.aiSh.aiSp.aiRV, paramb, (ah)this.aiSH, paramf);
    AppMethodBeat.o(57791);
  }
  
  public final Set<f> kpL()
  {
    AppMethodBeat.i(57789);
    Object localObject = ksn();
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      p.a(localCollection, (Iterable)localObject[i].kpL());
      i += 1;
    }
    ((Set)localCollection).addAll((Collection)this.aiSI.kpL());
    localObject = (Set)localCollection;
    AppMethodBeat.o(57789);
    return localObject;
  }
  
  public final Set<f> kpM()
  {
    AppMethodBeat.i(192172);
    Set localSet = j.H(k.ai(ksn()));
    if (localSet == null)
    {
      AppMethodBeat.o(192172);
      return null;
    }
    localSet.addAll((Collection)this.aiSI.kpM());
    AppMethodBeat.o(192172);
    return localSet;
  }
  
  public final Set<f> kpN()
  {
    AppMethodBeat.i(57790);
    Object localObject = ksn();
    Collection localCollection = (Collection)new LinkedHashSet();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      p.a(localCollection, (Iterable)localObject[i].kpN());
      i += 1;
    }
    ((Set)localCollection).addAll((Collection)this.aiSI.kpN());
    localObject = (Set)localCollection;
    AppMethodBeat.o(57790);
    return localObject;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(192175);
    String str = s.X("scope for ", this.aiSH);
    AppMethodBeat.o(192175);
    return str;
  }
  
  static final class a
    extends u
    implements kotlin.g.a.a<kotlin.l.b.a.b.j.g.h[]>
  {
    a(d paramd)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.c.a.d
 * JD-Core Version:    0.7.0.1
 */