package kotlin.l.b.a.b.b.e.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.g.b.al;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.l.b.a.b.b.bi;
import kotlin.l.b.a.b.d.a.e.ac;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.d.a.e.v;
import kotlin.l.b.a.b.f.c;

public final class j
  extends n
  implements f, t, g
{
  public final Class<?> aiMA;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(57461);
    this.aiMA = paramClass;
    AppMethodBeat.o(57461);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57458);
    if (((paramObject instanceof j)) && (s.p(this.aiMA, ((j)paramObject).aiMA)))
    {
      AppMethodBeat.o(57458);
      return true;
    }
    AppMethodBeat.o(57458);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57459);
    int i = this.aiMA.hashCode();
    AppMethodBeat.o(57459);
    return i;
  }
  
  public final boolean jNm()
  {
    AppMethodBeat.i(57465);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(57465);
    return bool;
  }
  
  public final c koY()
  {
    AppMethodBeat.i(57447);
    c localc = b.cM(this.aiMA).kxQ();
    s.s(localc, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(57447);
    return localc;
  }
  
  public final List<x> koa()
  {
    AppMethodBeat.i(57454);
    Object localObject = this.aiMA.getTypeParameters();
    s.s(localObject, "klass.typeParameters");
    localObject = (Object[])localObject;
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x((TypeVariable)localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(57454);
    return localObject;
  }
  
  public final kotlin.l.b.a.b.f.f kok()
  {
    AppMethodBeat.i(57453);
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bJe(this.aiMA.getSimpleName());
    s.s(localf, "identifier(klass.simpleName)");
    AppMethodBeat.o(57453);
    return localf;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.j> kpG()
  {
    AppMethodBeat.i(57449);
    if (s.p(this.aiMA, Object.class))
    {
      localObject1 = (Collection)ab.aivy;
      AppMethodBeat.o(57449);
      return localObject1;
    }
    al localal = new al(2);
    Object localObject2 = this.aiMA.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localal.add(localObject1);
    localObject1 = this.aiMA.getGenericInterfaces();
    s.s(localObject1, "klass.genericInterfaces");
    localal.hx(localObject1);
    localObject2 = (Iterable)p.listOf(localal.toArray(new Type[localal.hqL.size()]));
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(57449);
    return localObject1;
  }
  
  public final boolean kqA()
  {
    AppMethodBeat.i(191872);
    s.u(this, "this");
    AppMethodBeat.o(191872);
    return false;
  }
  
  public final int kqC()
  {
    AppMethodBeat.i(57445);
    int i = this.aiMA.getModifiers();
    AppMethodBeat.o(57445);
    return i;
  }
  
  public final Collection<v> kqD()
  {
    return (Collection)ab.aivy;
  }
  
  public final boolean kqE()
  {
    return false;
  }
  
  public final ac kqF()
  {
    return null;
  }
  
  public final boolean kqG()
  {
    AppMethodBeat.i(57455);
    boolean bool = this.aiMA.isInterface();
    AppMethodBeat.o(57455);
    return bool;
  }
  
  public final boolean kqH()
  {
    AppMethodBeat.i(369493);
    boolean bool = this.aiMA.isAnnotation();
    AppMethodBeat.o(369493);
    return bool;
  }
  
  public final boolean kqI()
  {
    AppMethodBeat.i(57457);
    boolean bool = this.aiMA.isEnum();
    AppMethodBeat.o(57457);
    return bool;
  }
  
  public final boolean kqJ()
  {
    return false;
  }
  
  public final boolean kqK()
  {
    return false;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.j> kqL()
  {
    return (Collection)ab.aivy;
  }
  
  public final boolean kqM()
  {
    AppMethodBeat.i(57464);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(57464);
    return bool;
  }
  
  public final boolean kqN()
  {
    AppMethodBeat.i(57466);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(57466);
    return bool;
  }
  
  public final bi kqO()
  {
    AppMethodBeat.i(57467);
    bi localbi = t.a.d(this);
    AppMethodBeat.o(57467);
    return localbi;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57460);
    String str = getClass().getName() + ": " + this.aiMA;
    AppMethodBeat.o(57460);
    return str;
  }
  
  static final class f
    extends u
    implements kotlin.g.a.b<Class<?>, kotlin.l.b.a.b.f.f>
  {
    public static final f aiNe;
    
    static
    {
      AppMethodBeat.i(57440);
      aiNe = new f();
      AppMethodBeat.o(57440);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.b.b.e.b.j
 * JD-Core Version:    0.7.0.1
 */