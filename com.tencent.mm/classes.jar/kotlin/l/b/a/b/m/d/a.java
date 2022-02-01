package kotlin.l.b.a.b.m.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ak;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.a.h;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.b.f;
import kotlin.l.b.a.b.b.i;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.al;
import kotlin.l.b.a.b.m.aq;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.b.a.b.m.bb;
import kotlin.l.b.a.b.m.bd;
import kotlin.l.b.a.b.m.be;
import kotlin.l.b.a.b.m.bg;
import kotlin.l.b.a.b.m.bi;
import kotlin.l.b.a.b.m.bk;
import kotlin.l.b.a.b.m.bl;
import kotlin.l.b.a.b.m.x;

public final class a
{
  public static final ad a(ad paramad, be parambe, Map<ax, ? extends az> paramMap, bl parambl, Set<? extends ba> paramSet)
  {
    AppMethodBeat.i(191702);
    s.u(paramad, "<this>");
    s.u(parambe, "substitutor");
    s.u(paramMap, "substitutionMap");
    s.u(parambl, "variance");
    bk localbk = paramad.kAK();
    Object localObject2;
    Object localObject1;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    int i;
    if ((localbk instanceof x))
    {
      localObject2 = ((x)localbk).ajpE;
      localObject1 = localObject2;
      if (!((al)localObject2).kzm().klq().isEmpty())
      {
        if (((al)localObject2).kzm().knA() == null) {
          localObject1 = localObject2;
        }
      }
      else
      {
        localObject3 = ((x)localbk).ajpF;
        if ((!((al)localObject3).kzm().klq().isEmpty()) && (((al)localObject3).kzm().knA() != null)) {
          break label371;
        }
      }
      for (paramad = (ad)localObject3;; paramad = bd.a((al)localObject3, (List)localObject4, null, 2))
      {
        paramad = kotlin.l.b.a.b.m.ae.a((al)localObject1, paramad);
        paramad = parambe.b((ad)bi.a(paramad, (ad)localbk), parambl);
        s.s(paramad, "replaceArgumentsByParame…ubstitute(it, variance) }");
        AppMethodBeat.o(191702);
        return paramad;
        localObject1 = ((al)localObject2).kzm().klq();
        s.s(localObject1, "constructor.parameters");
        localObject1 = (Iterable)localObject1;
        localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject4 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ba)((Iterator)localObject4).next();
          localObject1 = (az)kotlin.a.p.ae(paramad.klR(), ((ba)localObject5).getIndex());
          if ((paramSet != null) && (paramSet.contains(localObject5)))
          {
            i = 1;
            label289:
            if ((i != 0) || (localObject1 == null) || (!paramMap.containsKey(((az)localObject1).koG().kzm()))) {
              break label337;
            }
          }
          for (;;)
          {
            ((Collection)localObject3).add(localObject1);
            break;
            i = 0;
            break label289;
            label337:
            localObject1 = (az)new aq((ba)localObject5);
          }
        }
        localObject1 = bd.a((al)localObject2, (List)localObject3, null, 2);
        break;
        label371:
        localObject2 = ((al)localObject3).kzm().klq();
        s.s(localObject2, "constructor.parameters");
        localObject2 = (Iterable)localObject2;
        localObject4 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject5 = ((Iterable)localObject2).iterator();
        if (((Iterator)localObject5).hasNext())
        {
          ba localba = (ba)((Iterator)localObject5).next();
          localObject2 = (az)kotlin.a.p.ae(paramad.klR(), localba.getIndex());
          if ((paramSet != null) && (paramSet.contains(localba)))
          {
            i = 1;
            label486:
            if ((i != 0) || (localObject2 == null) || (!paramMap.containsKey(((az)localObject2).koG().kzm()))) {
              break label534;
            }
          }
          for (;;)
          {
            ((Collection)localObject4).add(localObject2);
            break;
            i = 0;
            break label486;
            label534:
            localObject2 = (az)new aq(localba);
          }
        }
      }
    }
    if ((localbk instanceof al))
    {
      localObject2 = (al)localbk;
      localObject1 = localObject2;
      if (!((al)localObject2).kzm().klq().isEmpty()) {
        if (((al)localObject2).kzm().knA() != null) {
          break label630;
        }
      }
      for (localObject1 = localObject2;; localObject1 = bd.a((al)localObject2, (List)localObject3, null, 2))
      {
        paramad = (bk)localObject1;
        break;
        label630:
        localObject1 = ((al)localObject2).kzm().klq();
        s.s(localObject1, "constructor.parameters");
        localObject1 = (Iterable)localObject1;
        localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject4 = ((Iterable)localObject1).iterator();
        if (((Iterator)localObject4).hasNext())
        {
          localObject5 = (ba)((Iterator)localObject4).next();
          localObject1 = (az)kotlin.a.p.ae(paramad.klR(), ((ba)localObject5).getIndex());
          if ((paramSet != null) && (paramSet.contains(localObject5)))
          {
            i = 1;
            label745:
            if ((i != 0) || (localObject1 == null) || (!paramMap.containsKey(((az)localObject1).koG().kzm()))) {
              break label793;
            }
          }
          for (;;)
          {
            ((Collection)localObject3).add(localObject1);
            break;
            i = 0;
            break label745;
            label793:
            localObject1 = (az)new aq((ba)localObject5);
          }
        }
      }
    }
    paramad = new kotlin.p();
    AppMethodBeat.o(191702);
    throw paramad;
  }
  
  public static final az a(ad paramad, bl parambl, ba paramba)
  {
    AppMethodBeat.i(61253);
    s.u(paramad, "type");
    s.u(parambl, "projectionKind");
    if (paramba == null) {}
    for (paramba = null;; paramba = paramba.kom())
    {
      bl localbl = parambl;
      if (paramba == parambl) {
        localbl = bl.ajqM;
      }
      paramad = (az)new bb(localbl, paramad);
      AppMethodBeat.o(61253);
      return paramad;
    }
  }
  
  public static final void a(ad paramad1, ad paramad2, Set<ba> paramSet, Set<? extends ba> paramSet1)
  {
    AppMethodBeat.i(191675);
    Object localObject = paramad1.kzm().knA();
    if ((localObject instanceof ba))
    {
      if (!s.p(paramad1.kzm(), paramad2.kzm()))
      {
        ((Collection)paramSet).add(localObject);
        AppMethodBeat.o(191675);
        return;
      }
      paramad1 = ((ba)localObject).klF().iterator();
      while (paramad1.hasNext())
      {
        localObject = (ad)paramad1.next();
        s.s(localObject, "upperBound");
        a((ad)localObject, paramad2, paramSet, paramSet1);
      }
    }
    localObject = paramad1.kzm().knA();
    label144:
    Iterator localIterator;
    int i;
    if ((localObject instanceof i))
    {
      localObject = (i)localObject;
      if (localObject != null) {
        break label308;
      }
      localObject = null;
      localIterator = paramad1.klR().iterator();
      i = 0;
    }
    for (;;)
    {
      label158:
      int j;
      if (localIterator.hasNext())
      {
        j = i + 1;
        az localaz = (az)localIterator.next();
        if (localObject == null)
        {
          paramad1 = null;
          label193:
          if ((paramad1 == null) || (paramSet1 == null) || (!paramSet1.contains(paramad1))) {
            break label334;
          }
        }
        label308:
        label334:
        for (i = 1;; i = 0)
        {
          if ((i != 0) || (localaz.kAM()) || (kotlin.a.p.a((Iterable)paramSet, localaz.koG().kzm().knA())) || (s.p(localaz.koG().kzm(), paramad2.kzm()))) {
            break label346;
          }
          paramad1 = localaz.koG();
          s.s(paramad1, "argument.type");
          a(paramad1, paramad2, paramSet, paramSet1);
          i = j;
          break label158;
          localObject = null;
          break;
          localObject = ((i)localObject).kno();
          break label144;
          paramad1 = (ba)kotlin.a.p.ae((List)localObject, i);
          break label193;
        }
      }
      AppMethodBeat.o(191675);
      return;
      label346:
      i = j;
    }
  }
  
  public static final boolean a(ba paramba, ax paramax, Set<? extends ba> paramSet)
  {
    AppMethodBeat.i(191680);
    s.u(paramba, "typeParameter");
    Object localObject = paramba.klF();
    s.s(localObject, "typeParameter.upperBounds");
    localObject = (Iterable)localObject;
    if ((!(localObject instanceof Collection)) || (!((Collection)localObject).isEmpty()))
    {
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ad localad = (ad)((Iterator)localObject).next();
        s.s(localad, "upperBound");
        if ((a(localad, paramba.koj().kzm(), paramSet)) && ((paramax == null) || (s.p(localad.kzm(), paramax)))) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(191680);
          return true;
        }
      }
    }
    AppMethodBeat.o(191680);
    return false;
  }
  
  public static final boolean a(ad paramad, b<? super bk, Boolean> paramb)
  {
    AppMethodBeat.i(191670);
    s.u(paramad, "<this>");
    s.u(paramb, "predicate");
    boolean bool = bg.a(paramad, paramb);
    AppMethodBeat.o(191670);
    return bool;
  }
  
  private static final boolean a(ad paramad, ax paramax, Set<? extends ba> paramSet)
  {
    AppMethodBeat.i(191692);
    if (s.p(paramad.kzm(), paramax))
    {
      AppMethodBeat.o(191692);
      return true;
    }
    Object localObject = paramad.kzm().knA();
    label57:
    Iterator localIterator;
    if ((localObject instanceof i))
    {
      localObject = (i)localObject;
      if (localObject != null) {
        break label192;
      }
      localObject = null;
      paramad = kotlin.a.p.s((Iterable)paramad.klR());
      if (((paramad instanceof Collection)) && (((Collection)paramad).isEmpty())) {
        break label247;
      }
      localIterator = paramad.iterator();
    }
    label137:
    label157:
    label192:
    label217:
    label222:
    label245:
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label247;
      }
      paramad = (kotlin.a.ae)localIterator.next();
      int i = paramad.index;
      az localaz = (az)paramad.value;
      if (localObject == null)
      {
        paramad = null;
        if ((paramad == null) || (paramSet == null) || (!paramSet.contains(paramad))) {
          break label217;
        }
        i = 1;
        if ((i == 0) && (!localaz.kAM())) {
          break label222;
        }
      }
      for (boolean bool = false;; bool = a(paramad, paramax, paramSet))
      {
        if (!bool) {
          break label245;
        }
        AppMethodBeat.o(191692);
        return true;
        localObject = null;
        break;
        localObject = ((i)localObject).kno();
        break label57;
        paramad = (ba)kotlin.a.p.ae((List)localObject, i);
        break label137;
        i = 0;
        break label157;
        paramad = localaz.koG();
        s.s(paramad, "argument.type");
      }
    }
    label247:
    AppMethodBeat.o(191692);
    return false;
  }
  
  public static final boolean aA(ad paramad)
  {
    AppMethodBeat.i(61250);
    s.u(paramad, "<this>");
    boolean bool = bg.aA(paramad);
    AppMethodBeat.o(61250);
    return bool;
  }
  
  public static final h aE(ad paramad)
  {
    AppMethodBeat.i(61247);
    s.u(paramad, "<this>");
    paramad = paramad.kzm().koV();
    s.s(paramad, "constructor.builtIns");
    AppMethodBeat.o(61247);
    return paramad;
  }
  
  public static final az aF(ad paramad)
  {
    AppMethodBeat.i(61254);
    s.u(paramad, "<this>");
    paramad = (az)new bb(paramad);
    AppMethodBeat.o(61254);
    return paramad;
  }
  
  public static final ad aG(ad paramad)
  {
    AppMethodBeat.i(61255);
    s.u(paramad, "<this>");
    bk localbk = paramad.kAK();
    al localal;
    Object localObject1;
    if ((localbk instanceof x))
    {
      localal = ((x)localbk).ajpE;
      paramad = localal;
      if (!localal.kzm().klq().isEmpty())
      {
        if (localal.kzm().knA() == null) {
          paramad = localal;
        }
      }
      else
      {
        localal = ((x)localbk).ajpF;
        if ((!localal.kzm().klq().isEmpty()) && (localal.kzm().knA() != null)) {
          break label222;
        }
      }
      for (;;)
      {
        paramad = kotlin.l.b.a.b.m.ae.a(paramad, localal);
        paramad = (ad)bi.a(paramad, (ad)localbk);
        AppMethodBeat.o(61255);
        return paramad;
        paramad = localal.kzm().klq();
        s.s(paramad, "constructor.parameters");
        localObject1 = (Iterable)paramad;
        paramad = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramad.add(new aq((ba)((Iterator)localObject1).next()));
        }
        paramad = bd.a(localal, (List)paramad, null, 2);
        break;
        label222:
        localObject1 = localal.kzm().klq();
        s.s(localObject1, "constructor.parameters");
        Object localObject2 = (Iterable)localObject1;
        localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((Collection)localObject1).add(new aq((ba)((Iterator)localObject2).next()));
        }
        localal = bd.a(localal, (List)localObject1, null, 2);
      }
    }
    if ((localbk instanceof al))
    {
      localal = (al)localbk;
      paramad = localal;
      if (!localal.kzm().klq().isEmpty()) {
        if (localal.kzm().knA() != null) {
          break label375;
        }
      }
      for (paramad = localal;; paramad = bd.a(localal, (List)paramad, null, 2))
      {
        paramad = (bk)paramad;
        break;
        label375:
        paramad = localal.kzm().klq();
        s.s(paramad, "constructor.parameters");
        localObject1 = (Iterable)paramad;
        paramad = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          paramad.add(new aq((ba)((Iterator)localObject1).next()));
        }
      }
    }
    paramad = new kotlin.p();
    AppMethodBeat.o(61255);
    throw paramad;
  }
  
  public static final boolean aH(ad paramad)
  {
    AppMethodBeat.i(191707);
    s.u(paramad, "<this>");
    boolean bool = a(paramad, (b)b.ajrM);
    AppMethodBeat.o(191707);
    return bool;
  }
  
  public static final ad at(ad paramad)
  {
    AppMethodBeat.i(61248);
    s.u(paramad, "<this>");
    paramad = bg.at(paramad);
    s.s(paramad, "makeNullable(this)");
    AppMethodBeat.o(61248);
    return paramad;
  }
  
  public static final ad au(ad paramad)
  {
    AppMethodBeat.i(61249);
    s.u(paramad, "<this>");
    paramad = bg.au(paramad);
    s.s(paramad, "makeNotNullable(this)");
    AppMethodBeat.o(61249);
    return paramad;
  }
  
  public static final ad b(ad paramad, g paramg)
  {
    AppMethodBeat.i(61252);
    s.u(paramad, "<this>");
    s.u(paramg, "newAnnotations");
    if ((paramad.knl().isEmpty()) && (paramg.isEmpty()))
    {
      AppMethodBeat.o(61252);
      return paramad;
    }
    paramad = (ad)paramad.kAK().b(paramg);
    AppMethodBeat.o(61252);
    return paramad;
  }
  
  public static final ad d(ba paramba)
  {
    AppMethodBeat.i(61256);
    s.u(paramba, "<this>");
    Object localObject1 = paramba.klF();
    s.s(localObject1, "upperBounds");
    if (!((Collection)localObject1).isEmpty()) {}
    for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
    {
      paramba = (Throwable)new AssertionError(s.X("Upper bounds should not be empty: ", paramba));
      AppMethodBeat.o(61256);
      throw paramba;
    }
    localObject1 = paramba.klF();
    s.s(localObject1, "upperBounds");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      localObject1 = ((ad)localObject2).kzm().knA();
      if ((localObject1 instanceof kotlin.l.b.a.b.b.e))
      {
        localObject1 = (kotlin.l.b.a.b.b.e)localObject1;
        label149:
        if ((localObject1 == null) || (((kotlin.l.b.a.b.b.e)localObject1).kna() == f.aiGu) || (((kotlin.l.b.a.b.b.e)localObject1).kna() == f.aiGx)) {
          break label238;
        }
        i = 1;
        label179:
        if (i == 0) {
          break label241;
        }
      }
    }
    for (localObject1 = localObject2;; localObject1 = null)
    {
      localObject1 = (ad)localObject1;
      if (localObject1 != null) {
        break label248;
      }
      paramba = paramba.klF();
      s.s(paramba, "upperBounds");
      paramba = kotlin.a.p.oK(paramba);
      s.s(paramba, "upperBounds.first()");
      paramba = (ad)paramba;
      AppMethodBeat.o(61256);
      return paramba;
      localObject1 = null;
      break label149;
      label238:
      i = 0;
      break label179;
      label241:
      break;
    }
    label248:
    AppMethodBeat.o(61256);
    return localObject1;
  }
  
  public static final boolean d(ad paramad1, ad paramad2)
  {
    AppMethodBeat.i(61251);
    s.u(paramad1, "<this>");
    s.u(paramad2, "superType");
    boolean bool = kotlin.l.b.a.b.m.a.e.ajqY.d(paramad1, paramad2);
    AppMethodBeat.o(61251);
    return bool;
  }
  
  public static final boolean e(ba paramba)
  {
    AppMethodBeat.i(191714);
    s.u(paramba, "typeParameter");
    boolean bool = a(paramba, null, 6);
    AppMethodBeat.o(191714);
    return bool;
  }
  
  public static final class a
    extends u
    implements b<bk, Boolean>
  {
    public static final a ajrL;
    
    static
    {
      AppMethodBeat.i(191647);
      ajrL = new a();
      AppMethodBeat.o(191647);
    }
    
    a()
    {
      super();
    }
  }
  
  static final class b
    extends u
    implements b<bk, Boolean>
  {
    public static final b ajrM;
    
    static
    {
      AppMethodBeat.i(191643);
      ajrM = new b();
      AppMethodBeat.o(191643);
    }
    
    b()
    {
      super();
    }
  }
  
  public static final class c
    extends u
    implements b<bk, Boolean>
  {
    public static final c ajrN;
    
    static
    {
      AppMethodBeat.i(191642);
      ajrN = new c();
      AppMethodBeat.o(191642);
    }
    
    c()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.m.d.a
 * JD-Core Version:    0.7.0.1
 */