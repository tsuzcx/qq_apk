package kotlin.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.v;
import kotlin.g.b.n;
import kotlin.l.b.a.b.b.a.c;

public final class a
{
  public final boolean Dlq;
  private final kotlin.l.b.a.b.l.d<kotlin.l.b.a.b.b.e, c> aaQU;
  public final kotlin.l.b.a.b.o.e aaQV;
  
  public a(kotlin.l.b.a.b.l.j paramj, kotlin.l.b.a.b.o.e parame)
  {
    AppMethodBeat.i(57541);
    this.aaQV = parame;
    this.aaQU = paramj.al((kotlin.g.a.b)new c((a)this));
    this.Dlq = this.aaQV.iQl();
    AppMethodBeat.o(57541);
  }
  
  private final List<a> a(kotlin.l.b.a.b.j.b.g<?> paramg)
  {
    AppMethodBeat.i(57540);
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      Object localObject = (Iterable)((kotlin.l.b.a.b.j.b.b)paramg).getValue();
      paramg = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        kotlin.a.j.a(paramg, (Iterable)a((kotlin.l.b.a.b.j.b.g)((Iterator)localObject).next()));
      }
      paramg = (List)paramg;
      AppMethodBeat.o(57540);
      return paramg;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.j))
    {
      paramg = ((kotlin.l.b.a.b.j.b.j)paramg).ablc.getIdentifier();
      switch (paramg.hashCode())
      {
      default: 
        paramg = null;
      }
      for (;;)
      {
        paramg = kotlin.a.j.eY(paramg);
        AppMethodBeat.o(57540);
        return paramg;
        if (!paramg.equals("FIELD")) {
          break;
        }
        paramg = a.aaQY;
        continue;
        if (!paramg.equals("METHOD")) {
          break;
        }
        paramg = a.aaQW;
        continue;
        if (!paramg.equals("TYPE_USE")) {
          break;
        }
        paramg = a.aaQZ;
        continue;
        if (!paramg.equals("PARAMETER")) {
          break;
        }
        paramg = a.aaQX;
      }
    }
    paramg = (List)v.aaAd;
    AppMethodBeat.o(57540);
    return paramg;
  }
  
  private final kotlin.l.b.a.b.o.g q(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57539);
    parame = parame.iDY().g(b.iHI());
    if (parame != null) {}
    for (parame = kotlin.l.b.a.b.j.d.a.m(parame);; parame = null)
    {
      localObject = parame;
      if (!(parame instanceof kotlin.l.b.a.b.j.b.j)) {
        localObject = null;
      }
      parame = (kotlin.l.b.a.b.j.b.j)localObject;
      if (parame != null) {
        break;
      }
      AppMethodBeat.o(57539);
      return null;
    }
    Object localObject = this.aaQV.abuk;
    if (localObject != null)
    {
      AppMethodBeat.o(57539);
      return localObject;
    }
    parame = parame.ablc.qu();
    switch (parame.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(57539);
          return null;
        } while (!parame.equals("STRICT"));
        parame = kotlin.l.b.a.b.o.g.abuv;
        AppMethodBeat.o(57539);
        return parame;
      } while (!parame.equals("IGNORE"));
      parame = kotlin.l.b.a.b.o.g.abut;
      AppMethodBeat.o(57539);
      return parame;
    } while (!parame.equals("WARN"));
    parame = kotlin.l.b.a.b.o.g.abuu;
    AppMethodBeat.o(57539);
    return parame;
  }
  
  public final c d(c paramc)
  {
    AppMethodBeat.i(57535);
    kotlin.g.b.p.k(paramc, "annotationDescriptor");
    if (this.aaQV.iQl())
    {
      AppMethodBeat.o(57535);
      return null;
    }
    kotlin.l.b.a.b.b.e locale = kotlin.l.b.a.b.j.d.a.l(paramc);
    if (locale == null)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    if (b.r(locale))
    {
      AppMethodBeat.o(57535);
      return paramc;
    }
    if (locale.iDN() != kotlin.l.b.a.b.b.f.aaKc)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    paramc = (c)this.aaQU.invoke(locale);
    AppMethodBeat.o(57535);
    return paramc;
  }
  
  public final b e(c paramc)
  {
    AppMethodBeat.i(57536);
    kotlin.g.b.p.k(paramc, "annotationDescriptor");
    if (this.aaQV.iQl())
    {
      AppMethodBeat.o(57536);
      return null;
    }
    Object localObject1 = kotlin.l.b.a.b.j.d.a.l(paramc);
    if (localObject1 != null) {
      if (!((kotlin.l.b.a.b.b.e)localObject1).iDY().h(b.iHH())) {
        break label72;
      }
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(57536);
      return null;
      label72:
      localObject1 = null;
    }
    paramc = kotlin.l.b.a.b.j.d.a.l(paramc);
    if (paramc == null) {
      kotlin.g.b.p.iCn();
    }
    paramc = paramc.iDY().g(b.iHH());
    if (paramc == null) {
      kotlin.g.b.p.iCn();
    }
    paramc = paramc.iGd();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
      localObject2 = (kotlin.l.b.a.b.j.b.g)((Map.Entry)localObject2).getValue();
      if (kotlin.g.b.p.h(paramc, p.aaSf)) {}
      for (paramc = a((kotlin.l.b.a.b.j.b.g)localObject2);; paramc = (List)v.aaAd)
      {
        kotlin.a.j.a(localCollection, (Iterable)paramc);
        break;
      }
    }
    paramc = ((Iterable)localCollection).iterator();
    for (int i = 0; paramc.hasNext(); i = 1 << ((a)paramc.next()).ordinal() | i) {}
    localObject1 = ((Iterable)((kotlin.l.b.a.b.b.e)localObject1).iDY()).iterator();
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      paramc = ((Iterator)localObject1).next();
      if (d((c)paramc) != null)
      {
        j = 1;
        label322:
        if (j == 0) {
          break label346;
        }
      }
    }
    for (;;)
    {
      paramc = (c)paramc;
      if (paramc != null) {
        break label353;
      }
      AppMethodBeat.o(57536);
      return null;
      j = 0;
      break label322;
      label346:
      break;
      paramc = null;
    }
    label353:
    paramc = new b(paramc, i);
    AppMethodBeat.o(57536);
    return paramc;
  }
  
  public final kotlin.l.b.a.b.o.g f(c paramc)
  {
    AppMethodBeat.i(57537);
    kotlin.g.b.p.k(paramc, "annotationDescriptor");
    paramc = g(paramc);
    if (paramc != null)
    {
      AppMethodBeat.o(57537);
      return paramc;
    }
    paramc = this.aaQV.abuj;
    AppMethodBeat.o(57537);
    return paramc;
  }
  
  public final kotlin.l.b.a.b.o.g g(c paramc)
  {
    AppMethodBeat.i(57538);
    kotlin.g.b.p.k(paramc, "annotationDescriptor");
    Map localMap = this.aaQV.abul;
    Object localObject = paramc.iFy();
    if (localObject != null) {}
    for (localObject = ((kotlin.l.b.a.b.f.b)localObject).qu();; localObject = null)
    {
      localObject = (kotlin.l.b.a.b.o.g)localMap.get(localObject);
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(57538);
      return localObject;
    }
    paramc = kotlin.l.b.a.b.j.d.a.l(paramc);
    if (paramc != null)
    {
      paramc = q(paramc);
      AppMethodBeat.o(57538);
      return paramc;
    }
    AppMethodBeat.o(57538);
    return null;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(57527);
      a locala1 = new a("METHOD_RETURN_TYPE", 0);
      aaQW = locala1;
      a locala2 = new a("VALUE_PARAMETER", 1);
      aaQX = locala2;
      a locala3 = new a("FIELD", 2);
      aaQY = locala3;
      a locala4 = new a("TYPE_USE", 3);
      aaQZ = locala4;
      aaRa = new a[] { locala1, locala2, locala3, locala4 };
      AppMethodBeat.o(57527);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public final c aaRb;
    private final int aaRc;
    
    public b(c paramc, int paramInt)
    {
      AppMethodBeat.i(57532);
      this.aaRb = paramc;
      this.aaRc = paramInt;
      AppMethodBeat.o(57532);
    }
    
    private final boolean a(a.a parama)
    {
      AppMethodBeat.i(57531);
      if ((this.aaRc & 1 << parama.ordinal()) != 0)
      {
        AppMethodBeat.o(57531);
        return true;
      }
      AppMethodBeat.o(57531);
      return false;
    }
    
    public final List<a.a> component2()
    {
      AppMethodBeat.i(57530);
      Object localObject = a.a.values();
      Collection localCollection = (Collection)new ArrayList();
      int k = localObject.length;
      int i = 0;
      if (i < k)
      {
        a.a locala = localObject[i];
        b localb = (b)this;
        if ((localb.a(a.a.aaQZ)) || (localb.a(locala))) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            localCollection.add(locala);
          }
          i += 1;
          break;
        }
      }
      localObject = (List)localCollection;
      AppMethodBeat.o(57530);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.d.a.a
 * JD-Core Version:    0.7.0.1
 */