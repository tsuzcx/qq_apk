package kotlin.l.b.a.b.j.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.au;
import kotlin.l.b.a.b.b.x;
import kotlin.l.b.a.b.f.f;
import kotlin.l.b.a.b.j.j;
import kotlin.l.b.a.b.l.m;

public abstract class e
  extends i
{
  protected final kotlin.l.b.a.b.b.e ajlc;
  private final kotlin.l.b.a.b.l.h ajld;
  
  public e(m paramm, kotlin.l.b.a.b.b.e parame)
  {
    this.ajlc = parame;
    this.ajld = paramm.cq((a)new a(this));
  }
  
  private final List<kotlin.l.b.a.b.b.l> kzJ()
  {
    return (List)kotlin.l.b.a.b.l.l.a(this.ajld, aYe[0]);
  }
  
  public final Collection<ap> a(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    Object localObject1 = (Iterable)kzJ();
    paramb = (Collection)new kotlin.l.b.a.b.o.e();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localObject2 instanceof ap)) && (s.p(((ap)localObject2).kok(), paramf))) {
        paramb.add(localObject2);
      }
    }
    return paramb;
  }
  
  public final Collection<kotlin.l.b.a.b.b.l> a(d paramd, kotlin.g.a.b<? super f, Boolean> paramb)
  {
    s.u(paramd, "kindFilter");
    s.u(paramb, "nameFilter");
    if (!paramd.aMn(d.ajkR.ajkE)) {
      return (Collection)ab.aivy;
    }
    return (Collection)kzJ();
  }
  
  public final Collection<au> b(f paramf, kotlin.l.b.a.b.c.a.b paramb)
  {
    s.u(paramf, "name");
    s.u(paramb, "location");
    Object localObject1 = (Iterable)kzJ();
    paramb = (Collection)new kotlin.l.b.a.b.o.e();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((localObject2 instanceof au)) && (s.p(((au)localObject2).kok(), paramf))) {
        paramb.add(localObject2);
      }
    }
    return paramb;
  }
  
  protected abstract List<x> knB();
  
  static final class a
    extends u
    implements a<List<? extends kotlin.l.b.a.b.b.l>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  public static final class b
    extends kotlin.l.b.a.b.j.h
  {
    b(ArrayList<kotlin.l.b.a.b.b.l> paramArrayList, e parame) {}
    
    public final void a(kotlin.l.b.a.b.b.b paramb1, kotlin.l.b.a.b.b.b paramb2)
    {
      AppMethodBeat.i(60204);
      s.u(paramb1, "fromSuper");
      s.u(paramb2, "fromCurrent");
      paramb1 = (Throwable)new IllegalStateException(("Conflict in scope of " + this.ajle.ajlc + ": " + paramb1 + " vs " + paramb2).toString());
      AppMethodBeat.o(60204);
      throw paramb1;
    }
    
    public final void e(kotlin.l.b.a.b.b.b paramb)
    {
      AppMethodBeat.i(60203);
      s.u(paramb, "fakeOverride");
      j.a(paramb, null);
      this.nkI.add(paramb);
      AppMethodBeat.o(60203);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.j.g.e
 * JD-Core Version:    0.7.0.1
 */