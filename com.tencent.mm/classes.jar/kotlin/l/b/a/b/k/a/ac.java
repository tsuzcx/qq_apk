package kotlin.l.b.a.b.k.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.a.ak;
import kotlin.g.b.s;
import kotlin.l.b.a.b.b.a.g.a;
import kotlin.l.b.a.b.b.ag;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.e.a.p;
import kotlin.l.b.a.b.e.a.p.a;
import kotlin.l.b.a.b.e.a.p.a.b;
import kotlin.l.b.a.b.e.a.r;
import kotlin.l.b.a.b.e.b.b.a;
import kotlin.l.b.a.b.k.a.b.n;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.af;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.ao;
import kotlin.l.b.a.b.m.ap;
import kotlin.l.b.a.b.m.aq;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.m.a;
import kotlin.l.b.a.b.m.v;

public final class ac
{
  private final ac ajmR;
  private final String ajmS;
  boolean ajmT;
  private final kotlin.g.a.b<Integer, kotlin.l.b.a.b.b.h> ajmU;
  private final kotlin.g.a.b<Integer, kotlin.l.b.a.b.b.h> ajmV;
  private final Map<Integer, ba> ajmW;
  final l ajmz;
  private final String roK;
  
  private ac(l paraml, ac paramac, List<a.r> paramList, String paramString1, String paramString2)
  {
    AppMethodBeat.i(60383);
    this.ajmz = paraml;
    this.ajmR = paramac;
    this.roK = paramString1;
    this.ajmS = paramString2;
    this.ajmT = false;
    this.ajmU = ((kotlin.g.a.b)this.ajmz.aiWx.aiBu.be((kotlin.g.a.b)new a(this)));
    this.ajmV = ((kotlin.g.a.b)this.ajmz.aiWx.aiBu.be((kotlin.g.a.b)new c(this)));
    if (paramList.isEmpty()) {}
    for (paraml = ak.kkZ();; paraml = (Map)paraml)
    {
      this.ajmW = paraml;
      AppMethodBeat.o(60383);
      return;
      paraml = new LinkedHashMap();
      paramac = paramList.iterator();
      int i = 0;
      while (paramac.hasNext())
      {
        paramList = (a.r)paramac.next();
        ((Map)paraml).put(Integer.valueOf(paramList.aiYb), new n(this.ajmz, paramList, i));
        i += 1;
      }
    }
  }
  
  private final al Z(ad paramad)
  {
    boolean bool3 = false;
    Object localObject3 = null;
    AppMethodBeat.i(60377);
    boolean bool2 = this.ajmz.aiWx.ajlX.kzV();
    Object localObject1 = (kotlin.l.b.a.b.m.az)kotlin.a.p.oN(kotlin.l.b.a.b.a.g.j(paramad));
    if (localObject1 == null) {}
    for (Object localObject2 = null; localObject2 == null; localObject2 = ((kotlin.l.b.a.b.m.az)localObject1).koG())
    {
      AppMethodBeat.o(60377);
      return null;
    }
    localObject1 = ((ad)localObject2).kzm().knA();
    if (localObject1 == null) {}
    for (localObject1 = null; (((ad)localObject2).klR().size() != 1) || ((!kotlin.l.b.a.b.a.l.a((kotlin.l.b.a.b.f.c)localObject1, true)) && (!kotlin.l.b.a.b.a.l.a((kotlin.l.b.a.b.f.c)localObject1, false))); localObject1 = kotlin.l.b.a.b.j.d.a.o((kotlin.l.b.a.b.b.l)localObject1))
    {
      paramad = (al)paramad;
      AppMethodBeat.o(60377);
      return paramad;
    }
    ad localad = ((kotlin.l.b.a.b.m.az)kotlin.a.p.oO(((ad)localObject2).klR())).koG();
    s.s(localad, "continuationArgumentType.arguments.single().type");
    kotlin.l.b.a.b.b.l locall = this.ajmz.aiJT;
    localObject2 = locall;
    if (!(locall instanceof kotlin.l.b.a.b.b.a)) {
      localObject2 = null;
    }
    localObject2 = (kotlin.l.b.a.b.b.a)localObject2;
    if (localObject2 == null) {}
    for (localObject2 = localObject3; s.p(localObject2, ab.ajmP); localObject2 = kotlin.l.b.a.b.j.d.a.I((kotlin.l.b.a.b.b.l)localObject2))
    {
      paramad = b(paramad, localad);
      AppMethodBeat.o(60377);
      return paramad;
    }
    boolean bool1;
    if (!this.ajmT)
    {
      bool1 = bool3;
      if (!bool2) {
        break label285;
      }
      if (bool2) {
        break label304;
      }
    }
    label285:
    label304:
    for (bool2 = true;; bool2 = false)
    {
      bool1 = bool3;
      if (kotlin.l.b.a.b.a.l.a((kotlin.l.b.a.b.f.c)localObject1, bool2)) {
        bool1 = true;
      }
      this.ajmT = bool1;
      paramad = b(paramad, localad);
      AppMethodBeat.o(60377);
      return paramad;
    }
  }
  
  private static final List<a.p.a> a(a.p paramp, ac paramac)
  {
    AppMethodBeat.i(192316);
    Object localObject = paramp.aiYc;
    s.s(localObject, "argumentList");
    localObject = (Collection)localObject;
    paramp = kotlin.l.b.a.b.e.b.f.b(paramp, paramac.ajmz.aiyl);
    if (paramp == null) {}
    for (paramp = null;; paramp = a(paramp, paramac))
    {
      paramac = paramp;
      if (paramp == null) {
        paramac = (List)kotlin.a.ab.aivy;
      }
      paramp = kotlin.a.p.b((Collection)localObject, (Iterable)paramac);
      AppMethodBeat.o(192316);
      return paramp;
    }
  }
  
  private static final kotlin.l.b.a.b.b.e a(ac paramac, a.p paramp, int paramInt)
  {
    AppMethodBeat.i(192319);
    kotlin.l.b.a.b.f.b localb = w.a(paramac.ajmz.aiyk, paramInt);
    paramp = kotlin.m.k.e(kotlin.m.k.d(kotlin.m.k.b(paramp, (kotlin.g.a.b)new e(paramac)), (kotlin.g.a.b)ac.f.ajna));
    paramInt = kotlin.m.k.f(kotlin.m.k.b(localb, (kotlin.g.a.b)d.ajmZ));
    while (paramp.size() < paramInt) {
      paramp.add(Integer.valueOf(0));
    }
    paramac = paramac.ajmz.aiWx.aiBS.a(localb, paramp);
    AppMethodBeat.o(192319);
    return paramac;
  }
  
  private final al a(kotlin.l.b.a.b.b.a.g paramg, ax paramax, List<? extends kotlin.l.b.a.b.m.az> paramList, boolean paramBoolean)
  {
    Object localObject = null;
    AppMethodBeat.i(60375);
    switch (paramax.klq().size() - paramList.size())
    {
    }
    while (localObject == null)
    {
      paramg = v.aa(s.X("Bad suspend function in metadata with constructor: ", paramax), paramList);
      s.s(paramg, "createErrorTypeWithArgum…      arguments\n        )");
      AppMethodBeat.o(60375);
      return paramg;
      localObject = b(paramg, paramax, paramList, paramBoolean);
      continue;
      int i = paramList.size() - 1;
      if (i >= 0)
      {
        localObject = paramax.koV().aKv(i).kmZ();
        s.s(localObject, "functionTypeConstructor.…on(arity).typeConstructor");
        localObject = kotlin.l.b.a.b.m.ae.c(paramg, (ax)localObject, paramList, paramBoolean);
      }
    }
    AppMethodBeat.o(60375);
    return localObject;
  }
  
  private final kotlin.l.b.a.b.m.az a(ba paramba, a.p.a parama)
  {
    AppMethodBeat.i(60381);
    if (parama.ajaP == a.p.a.b.ajaV)
    {
      if (paramba == null)
      {
        paramba = (kotlin.l.b.a.b.m.az)new ap(this.ajmz.aiWx.aiFr.koV());
        AppMethodBeat.o(60381);
        return paramba;
      }
      paramba = (kotlin.l.b.a.b.m.az)new aq(paramba);
      AppMethodBeat.o(60381);
      return paramba;
    }
    paramba = z.ajmO;
    paramba = parama.ajaP;
    s.s(paramba, "typeArgumentProto.projection");
    paramba = z.b(paramba);
    parama = kotlin.l.b.a.b.e.b.f.a(parama, this.ajmz.aiyl);
    if (parama == null)
    {
      paramba = (kotlin.l.b.a.b.m.az)new bb((ad)v.bJt("No type recorded"));
      AppMethodBeat.o(60381);
      return paramba;
    }
    paramba = (kotlin.l.b.a.b.m.az)new bb(paramba, s(parama));
    AppMethodBeat.o(60381);
    return paramba;
  }
  
  private final ba aMq(int paramInt)
  {
    AppMethodBeat.i(192303);
    Object localObject1 = this;
    Object localObject2;
    do
    {
      localObject2 = (ba)((ac)localObject1).ajmW.get(Integer.valueOf(paramInt));
      if (localObject2 != null) {
        break;
      }
      localObject2 = ((ac)localObject1).ajmR;
      localObject1 = localObject2;
    } while (localObject2 != null);
    AppMethodBeat.o(192303);
    return null;
    AppMethodBeat.o(192303);
    return localObject2;
  }
  
  private final al aMr(int paramInt)
  {
    AppMethodBeat.i(60380);
    if (w.a(this.ajmz.aiyk, paramInt).NIH)
    {
      al localal = this.ajmz.aiWx.ajmb.kzY();
      AppMethodBeat.o(60380);
      return localal;
    }
    AppMethodBeat.o(60380);
    return null;
  }
  
  private final al b(kotlin.l.b.a.b.b.a.g paramg, ax paramax, List<? extends kotlin.l.b.a.b.m.az> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(60376);
    paramg = kotlin.l.b.a.b.m.ae.c(paramg, paramax, paramList, paramBoolean);
    if (!kotlin.l.b.a.b.a.g.d((ad)paramg))
    {
      AppMethodBeat.o(60376);
      return null;
    }
    paramg = Z((ad)paramg);
    AppMethodBeat.o(60376);
    return paramg;
  }
  
  private static al b(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(60378);
    kotlin.l.b.a.b.a.h localh = kotlin.l.b.a.b.m.d.a.aE(paramad1);
    kotlin.l.b.a.b.b.a.g localg = paramad1.knl();
    ad localad = kotlin.l.b.a.b.a.g.h(paramad1);
    Object localObject = (Iterable)kotlin.a.p.af(kotlin.l.b.a.b.a.g.j(paramad1), 1);
    Collection localCollection = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localCollection.add(((kotlin.l.b.a.b.m.az)((Iterator)localObject).next()).koG());
    }
    paramad1 = kotlin.l.b.a.b.a.g.a(localh, localg, localad, (List)localCollection, paramad2, true).Pq(paramad1.ksB());
    AppMethodBeat.o(60378);
    return paramad1;
  }
  
  private final ax t(a.p paramp)
  {
    AppMethodBeat.i(60374);
    Object localObject2;
    Object localObject1;
    if (paramp.kvM())
    {
      localObject2 = (kotlin.l.b.a.b.b.h)this.ajmU.invoke(Integer.valueOf(paramp.ajaG));
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = (kotlin.l.b.a.b.b.h)a(this, paramp, paramp.ajaG);
      }
    }
    for (;;)
    {
      paramp = ((kotlin.l.b.a.b.b.h)localObject1).kmZ();
      s.s(paramp, "classifier.typeConstructor");
      AppMethodBeat.o(60374);
      return paramp;
      if (paramp.kvN())
      {
        localObject1 = aMq(paramp.ajaH);
        if (localObject1 == null)
        {
          paramp = v.bJv("Unknown type parameter " + paramp.ajaH + ". Please try recompiling module containing \"" + this.ajmS + '"');
          s.s(paramp, "createErrorTypeConstruct…\\\"\"\n                    )");
          AppMethodBeat.o(60374);
          return paramp;
        }
        localObject1 = (kotlin.l.b.a.b.b.h)localObject1;
      }
      else if (paramp.kvO())
      {
        localObject1 = this.ajmz.aiyk.getString(paramp.ajaI);
        localObject2 = ((Iterable)kAa()).iterator();
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          paramp = ((Iterator)localObject2).next();
        } while (!s.p(((ba)paramp).kok().PF(), localObject1));
        for (;;)
        {
          paramp = (ba)paramp;
          if (paramp != null) {
            break;
          }
          paramp = v.bJv("Deserialized type parameter " + (String)localObject1 + " in " + this.ajmz.aiJT);
          s.s(paramp, "createErrorTypeConstruct….containingDeclaration}\")");
          AppMethodBeat.o(60374);
          return paramp;
          paramp = null;
        }
        localObject1 = (kotlin.l.b.a.b.b.h)paramp;
      }
      else
      {
        if (!paramp.kvP()) {
          break;
        }
        localObject2 = (kotlin.l.b.a.b.b.h)this.ajmV.invoke(Integer.valueOf(paramp.ajaJ));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = (kotlin.l.b.a.b.b.h)a(this, paramp, paramp.ajaJ);
        }
      }
    }
    paramp = v.bJv("Unknown type");
    s.s(paramp, "createErrorTypeConstructor(\"Unknown type\")");
    AppMethodBeat.o(60374);
    return paramp;
  }
  
  public final al b(final a.p paramp, boolean paramBoolean)
  {
    AppMethodBeat.i(192340);
    s.u(paramp, "proto");
    if (paramp.kvM()) {
      localObject1 = aMr(paramp.ajaG);
    }
    while (localObject1 != null)
    {
      AppMethodBeat.o(192340);
      return localObject1;
      if (paramp.kvP()) {
        localObject1 = aMr(paramp.ajaJ);
      } else {
        localObject1 = null;
      }
    }
    Object localObject2 = t(paramp);
    if (v.L((kotlin.l.b.a.b.b.l)((ax)localObject2).knA()))
    {
      paramp = v.a(localObject2.toString(), (ax)localObject2);
      s.s(paramp, "createErrorTypeWithCusto….toString(), constructor)");
      AppMethodBeat.o(192340);
      return paramp;
    }
    Object localObject1 = new kotlin.l.b.a.b.k.a.b.b(this.ajmz.aiWx.aiBu, (kotlin.g.a.a)new b(this, paramp));
    Object localObject4 = (Iterable)a(paramp, this);
    Object localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    int i = 0;
    while (((Iterator)localObject4).hasNext())
    {
      Object localObject5 = ((Iterator)localObject4).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject5 = (a.p.a)localObject5;
      List localList = ((ax)localObject2).klq();
      s.s(localList, "constructor.parameters");
      ((Collection)localObject3).add(a((ba)kotlin.a.p.ae(localList, i), (a.p.a)localObject5));
      i += 1;
    }
    localObject3 = kotlin.a.p.p((Iterable)localObject3);
    localObject4 = ((ax)localObject2).knA();
    if ((paramBoolean) && ((localObject4 instanceof kotlin.l.b.a.b.b.az)))
    {
      localObject2 = kotlin.l.b.a.b.m.ae.ajpU;
      localObject2 = kotlin.l.b.a.b.m.ae.a((kotlin.l.b.a.b.b.az)localObject4, (List)localObject3);
      if ((af.ah((ad)localObject2)) || (paramp.ajaC))
      {
        paramBoolean = true;
        localObject3 = ((al)localObject2).Pq(paramBoolean);
        localObject4 = kotlin.l.b.a.b.b.a.g.aiIh;
        localObject1 = ((al)localObject3).d(g.a.oS(kotlin.a.p.c((Iterable)localObject1, (Iterable)((al)localObject2).knl())));
        label380:
        localObject2 = kotlin.l.b.a.b.e.b.f.c(paramp, this.ajmz.aiyl);
        if (localObject2 != null) {
          break label627;
        }
      }
    }
    for (;;)
    {
      if (!paramp.kvM()) {
        break label653;
      }
      paramp = w.a(this.ajmz.aiyk, paramp.ajaG);
      paramp = this.ajmz.aiWx.ajmi.a(paramp, (al)localObject1);
      AppMethodBeat.o(192340);
      return paramp;
      paramBoolean = false;
      break;
      localObject4 = kotlin.l.b.a.b.e.b.b.ajcj.aLV(paramp.aiYq);
      s.s(localObject4, "SUSPEND_TYPE.get(proto.flags)");
      if (((Boolean)localObject4).booleanValue())
      {
        localObject1 = a((kotlin.l.b.a.b.b.a.g)localObject1, (ax)localObject2, (List)localObject3, paramp.ajaC);
        break label380;
      }
      localObject1 = kotlin.l.b.a.b.m.ae.c((kotlin.l.b.a.b.b.a.g)localObject1, (ax)localObject2, (List)localObject3, paramp.ajaC);
      localObject2 = kotlin.l.b.a.b.e.b.b.ajck.aLV(paramp.aiYq);
      s.s(localObject2, "DEFINITELY_NOT_NULL_TYPE.get(proto.flags)");
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = kotlin.l.b.a.b.m.m.ajpo;
        localObject2 = m.a.a((bk)localObject1, false);
        if (localObject2 == null)
        {
          paramp = (Throwable)new IllegalStateException(("null DefinitelyNotNullType for '" + localObject1 + '\'').toString());
          AppMethodBeat.o(192340);
          throw paramp;
        }
        localObject1 = (al)localObject2;
        break label380;
      }
      break label380;
      label627:
      localObject2 = ao.b((al)localObject1, b((a.p)localObject2, false));
      if (localObject2 != null) {
        localObject1 = localObject2;
      }
    }
    label653:
    AppMethodBeat.o(192340);
    return localObject1;
  }
  
  public final List<ba> kAa()
  {
    AppMethodBeat.i(60371);
    List localList = kotlin.a.p.p((Iterable)this.ajmW.values());
    AppMethodBeat.o(60371);
    return localList;
  }
  
  public final ad s(a.p paramp)
  {
    AppMethodBeat.i(60372);
    s.u(paramp, "proto");
    if (paramp.kvJ())
    {
      String str = this.ajmz.aiyk.getString(paramp.ajaD);
      al localal = b(paramp, true);
      Object localObject = kotlin.l.b.a.b.e.b.f.a(paramp, this.ajmz.aiyl);
      s.checkNotNull(localObject);
      localObject = b((a.p)localObject, true);
      paramp = this.ajmz.aiWx.ajmc.a(paramp, str, localal, (al)localObject);
      AppMethodBeat.o(60372);
      return paramp;
    }
    paramp = (ad)b(paramp, true);
    AppMethodBeat.o(60372);
    return paramp;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(60382);
    String str2 = this.roK;
    if (this.ajmR == null) {}
    for (String str1 = "";; str1 = s.X(". Child of ", this.ajmR.roK))
    {
      str1 = s.X(str2, str1);
      AppMethodBeat.o(60382);
      return str1;
    }
  }
  
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, kotlin.l.b.a.b.b.h>
  {
    a(ac paramac)
    {
      super();
    }
  }
  
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends kotlin.l.b.a.b.b.a.c>>
  {
    b(ac paramac, a.p paramp)
    {
      super();
    }
  }
  
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Integer, kotlin.l.b.a.b.b.h>
  {
    c(ac paramac)
    {
      super();
    }
  }
  
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<a.p, a.p>
  {
    e(ac paramac)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.k.a.ac
 * JD-Core Version:    0.7.0.1
 */