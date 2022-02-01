package d.l.b.a.b.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.l.b.a.b.b.a.c;
import d.l.b.a.b.l.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private final d.l.b.a.b.l.d<d.l.b.a.b.b.e, c> JwX;
  public final d.l.b.a.b.o.e JwY;
  public final boolean zSe;
  
  public a(i parami, d.l.b.a.b.o.e parame)
  {
    AppMethodBeat.i(57541);
    this.JwY = parame;
    this.JwX = parami.B((d.g.a.b)new c((a)this));
    this.zSe = this.JwY.fKk();
    AppMethodBeat.o(57541);
  }
  
  private final List<a> a(d.l.b.a.b.j.b.g<?> paramg)
  {
    AppMethodBeat.i(57540);
    if ((paramg instanceof d.l.b.a.b.j.b.b))
    {
      Object localObject = (Iterable)((d.l.b.a.b.j.b.b)paramg).getValue();
      paramg = (Collection)new ArrayList();
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        d.a.j.a(paramg, (Iterable)a((d.l.b.a.b.j.b.g)((Iterator)localObject).next()));
      }
      paramg = (List)paramg;
      AppMethodBeat.o(57540);
      return paramg;
    }
    if ((paramg instanceof d.l.b.a.b.j.b.j))
    {
      paramg = ((d.l.b.a.b.j.b.j)paramg).JSf.getIdentifier();
      switch (paramg.hashCode())
      {
      default: 
        paramg = null;
      }
      for (;;)
      {
        paramg = d.a.j.eG(paramg);
        AppMethodBeat.o(57540);
        return paramg;
        if (!paramg.equals("FIELD")) {
          break;
        }
        paramg = a.Jxb;
        continue;
        if (!paramg.equals("METHOD")) {
          break;
        }
        paramg = a.JwZ;
        continue;
        if (!paramg.equals("TYPE_USE")) {
          break;
        }
        paramg = a.Jxc;
        continue;
        if (!paramg.equals("PARAMETER")) {
          break;
        }
        paramg = a.Jxa;
      }
    }
    paramg = (List)v.Jgl;
    AppMethodBeat.o(57540);
    return paramg;
  }
  
  private final d.l.b.a.b.o.g q(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(57539);
    parame = parame.fxF().g(b.fBi());
    if (parame != null) {}
    for (parame = d.l.b.a.b.j.d.a.m(parame);; parame = null)
    {
      localObject = parame;
      if (!(parame instanceof d.l.b.a.b.j.b.j)) {
        localObject = null;
      }
      parame = (d.l.b.a.b.j.b.j)localObject;
      if (parame != null) {
        break;
      }
      AppMethodBeat.o(57539);
      return null;
    }
    Object localObject = this.JwY.Kbv;
    if (localObject != null)
    {
      AppMethodBeat.o(57539);
      return localObject;
    }
    parame = parame.JSf.qV();
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
        parame = d.l.b.a.b.o.g.KbG;
        AppMethodBeat.o(57539);
        return parame;
      } while (!parame.equals("IGNORE"));
      parame = d.l.b.a.b.o.g.KbE;
      AppMethodBeat.o(57539);
      return parame;
    } while (!parame.equals("WARN"));
    parame = d.l.b.a.b.o.g.KbF;
    AppMethodBeat.o(57539);
    return parame;
  }
  
  public final c d(c paramc)
  {
    AppMethodBeat.i(57535);
    k.h(paramc, "annotationDescriptor");
    if (this.JwY.fKk())
    {
      AppMethodBeat.o(57535);
      return null;
    }
    d.l.b.a.b.b.e locale = d.l.b.a.b.j.d.a.l(paramc);
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
    if (locale.fxu() != d.l.b.a.b.b.f.Jqh)
    {
      AppMethodBeat.o(57535);
      return null;
    }
    paramc = (c)this.JwX.aA(locale);
    AppMethodBeat.o(57535);
    return paramc;
  }
  
  public final b e(c paramc)
  {
    AppMethodBeat.i(57536);
    k.h(paramc, "annotationDescriptor");
    if (this.JwY.fKk())
    {
      AppMethodBeat.o(57536);
      return null;
    }
    Object localObject1 = d.l.b.a.b.j.d.a.l(paramc);
    if (localObject1 != null) {
      if (!((d.l.b.a.b.b.e)localObject1).fxF().h(b.fBh())) {
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
    paramc = d.l.b.a.b.j.d.a.l(paramc);
    if (paramc == null) {
      k.fvU();
    }
    paramc = paramc.fxF().g(b.fBh());
    if (paramc == null) {
      k.fvU();
    }
    paramc = paramc.fzH();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = paramc.entrySet().iterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = (Map.Entry)localIterator.next();
      paramc = (d.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
      localObject2 = (d.l.b.a.b.j.b.g)((Map.Entry)localObject2).getValue();
      if (k.g(paramc, p.Jyi)) {}
      for (paramc = a((d.l.b.a.b.j.b.g)localObject2);; paramc = (List)v.Jgl)
      {
        d.a.j.a(localCollection, (Iterable)paramc);
        break;
      }
    }
    paramc = ((Iterable)localCollection).iterator();
    for (int i = 0; paramc.hasNext(); i = 1 << ((a)paramc.next()).ordinal() | i) {}
    localObject1 = ((Iterable)((d.l.b.a.b.b.e)localObject1).fxF()).iterator();
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
  
  public final d.l.b.a.b.o.g f(c paramc)
  {
    AppMethodBeat.i(57537);
    k.h(paramc, "annotationDescriptor");
    paramc = g(paramc);
    if (paramc != null)
    {
      AppMethodBeat.o(57537);
      return paramc;
    }
    paramc = this.JwY.Kbu;
    AppMethodBeat.o(57537);
    return paramc;
  }
  
  public final d.l.b.a.b.o.g g(c paramc)
  {
    AppMethodBeat.i(57538);
    k.h(paramc, "annotationDescriptor");
    Map localMap = this.JwY.Kbw;
    Object localObject = paramc.fzd();
    if (localObject != null) {}
    for (localObject = ((d.l.b.a.b.f.b)localObject).qV();; localObject = null)
    {
      localObject = (d.l.b.a.b.o.g)localMap.get(localObject);
      if (localObject == null) {
        break;
      }
      AppMethodBeat.o(57538);
      return localObject;
    }
    paramc = d.l.b.a.b.j.d.a.l(paramc);
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
      JwZ = locala1;
      a locala2 = new a("VALUE_PARAMETER", 1);
      Jxa = locala2;
      a locala3 = new a("FIELD", 2);
      Jxb = locala3;
      a locala4 = new a("TYPE_USE", 3);
      Jxc = locala4;
      Jxd = new a[] { locala1, locala2, locala3, locala4 };
      AppMethodBeat.o(57527);
    }
    
    private a() {}
  }
  
  public static final class b
  {
    public final c Jxe;
    private final int Jxf;
    
    public b(c paramc, int paramInt)
    {
      AppMethodBeat.i(57532);
      this.Jxe = paramc;
      this.Jxf = paramInt;
      AppMethodBeat.o(57532);
    }
    
    private final boolean a(a.a parama)
    {
      AppMethodBeat.i(57531);
      if ((this.Jxf & 1 << parama.ordinal()) != 0)
      {
        AppMethodBeat.o(57531);
        return true;
      }
      AppMethodBeat.o(57531);
      return false;
    }
    
    public final List<a.a> fBf()
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
        if ((localb.a(a.a.Jxc)) || (localb.a(locala))) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.d.a.a
 * JD-Core Version:    0.7.0.1
 */