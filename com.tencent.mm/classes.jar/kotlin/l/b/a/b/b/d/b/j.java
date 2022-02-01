package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.ad;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.f.a;
import kotlin.l.d;

public final class j
  extends n
  implements f, t, g
{
  public final Class<?> TmJ;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(57461);
    this.TmJ = paramClass;
    AppMethodBeat.o(57461);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57458);
    if (((paramObject instanceof j)) && (kotlin.g.b.p.j(this.TmJ, ((j)paramObject).TmJ)))
    {
      AppMethodBeat.o(57458);
      return true;
    }
    AppMethodBeat.o(57458);
    return false;
  }
  
  public final int getModifiers()
  {
    AppMethodBeat.i(57445);
    int i = this.TmJ.getModifiers();
    AppMethodBeat.o(57445);
    return i;
  }
  
  public final kotlin.l.b.a.b.f.f hAH()
  {
    AppMethodBeat.i(57453);
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.btY(this.TmJ.getSimpleName());
    kotlin.g.b.p.g(localf, "Name.identifier(klass.simpleName)");
    AppMethodBeat.o(57453);
    return localf;
  }
  
  public final List<x> hAt()
  {
    AppMethodBeat.i(57454);
    Object localObject = this.TmJ.getTypeParameters();
    kotlin.g.b.p.g(localObject, "klass.typeParameters");
    Collection localCollection = (Collection)new ArrayList(localObject.length);
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      localCollection.add(new x(localObject[i]));
      i += 1;
    }
    localObject = (List)localCollection;
    AppMethodBeat.o(57454);
    return localObject;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.j> hBV()
  {
    AppMethodBeat.i(57449);
    if (kotlin.g.b.p.j(this.TmJ, Object.class))
    {
      localObject1 = (Collection)v.SXr;
      AppMethodBeat.o(57449);
      return localObject1;
    }
    ad localad = new ad(2);
    Object localObject2 = this.TmJ.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localad.add(localObject1);
    localObject1 = this.TmJ.getGenericInterfaces();
    kotlin.g.b.p.g(localObject1, "klass.genericInterfaces");
    localad.eS(localObject1);
    localObject2 = (Iterable)kotlin.a.j.listOf((Type[])localad.toArray(new Type[localad.dtS.size()]));
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(57449);
    return localObject1;
  }
  
  public final kotlin.l.b.a.b.f.b hBk()
  {
    AppMethodBeat.i(57447);
    kotlin.l.b.a.b.f.b localb = b.bB(this.TmJ).hJd();
    kotlin.g.b.p.g(localb, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(57447);
    return localb;
  }
  
  public final boolean hCO()
  {
    AppMethodBeat.i(258512);
    boolean bool = this.TmJ.isAnnotation();
    AppMethodBeat.o(258512);
    return bool;
  }
  
  public final boolean hCQ()
  {
    AppMethodBeat.i(57464);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(57464);
    return bool;
  }
  
  public final boolean hCR()
  {
    AppMethodBeat.i(57466);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(57466);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57459);
    int i = this.TmJ.hashCode();
    AppMethodBeat.o(57459);
    return i;
  }
  
  public final boolean hgu()
  {
    AppMethodBeat.i(57465);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(57465);
    return bool;
  }
  
  public final ba hzE()
  {
    AppMethodBeat.i(57467);
    ba localba = t.a.d(this);
    AppMethodBeat.o(57467);
    return localba;
  }
  
  public final boolean isEnum()
  {
    AppMethodBeat.i(57457);
    boolean bool = this.TmJ.isEnum();
    AppMethodBeat.o(57457);
    return bool;
  }
  
  public final boolean isInterface()
  {
    AppMethodBeat.i(57455);
    boolean bool = this.TmJ.isInterface();
    AppMethodBeat.o(57455);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57460);
    String str = getClass().getName() + ": " + this.TmJ;
    AppMethodBeat.o(57460);
    return str;
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<Class<?>, kotlin.l.b.a.b.f.f>
  {
    public static final f Tnl;
    
    static
    {
      AppMethodBeat.i(57440);
      Tnl = new f();
      AppMethodBeat.o(57440);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */