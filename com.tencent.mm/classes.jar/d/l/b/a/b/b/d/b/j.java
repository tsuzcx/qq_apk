package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.ac;
import d.g.b.p;
import d.g.b.q;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.f.a;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class j
  extends n
  implements f, t, g
{
  public final Class<?> MZV;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(57461);
    this.MZV = paramClass;
    AppMethodBeat.o(57461);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57458);
    if (((paramObject instanceof j)) && (p.i(this.MZV, ((j)paramObject).MZV)))
    {
      AppMethodBeat.o(57458);
      return true;
    }
    AppMethodBeat.o(57458);
    return false;
  }
  
  public final boolean fQB()
  {
    AppMethodBeat.i(57465);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(57465);
    return bool;
  }
  
  public final int getModifiers()
  {
    AppMethodBeat.i(57445);
    int i = this.MZV.getModifiers();
    AppMethodBeat.o(57445);
    return i;
  }
  
  public final ba ghz()
  {
    AppMethodBeat.i(57467);
    ba localba = t.a.d(this);
    AppMethodBeat.o(57467);
    return localba;
  }
  
  public final d.l.b.a.b.f.f giD()
  {
    AppMethodBeat.i(57453);
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.bcE(this.MZV.getSimpleName());
    p.g(localf, "Name.identifier(klass.simpleName)");
    AppMethodBeat.o(57453);
    return localf;
  }
  
  public final List<x> gip()
  {
    AppMethodBeat.i(57454);
    Object localObject = this.MZV.getTypeParameters();
    p.g(localObject, "klass.typeParameters");
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
  
  public final Collection<d.l.b.a.b.d.a.e.j> gjR()
  {
    AppMethodBeat.i(57449);
    if (p.i(this.MZV, Object.class))
    {
      localObject1 = (Collection)v.MKE;
      AppMethodBeat.o(57449);
      return localObject1;
    }
    ac localac = new ac(2);
    Object localObject2 = this.MZV.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localac.add(localObject1);
    localObject1 = this.MZV.getGenericInterfaces();
    p.g(localObject1, "klass.genericInterfaces");
    localac.eO(localObject1);
    localObject2 = (Iterable)d.a.j.listOf((Type[])localac.toArray(new Type[localac.dbZ.size()]));
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(57449);
    return localObject1;
  }
  
  public final d.l.b.a.b.f.b gjg()
  {
    AppMethodBeat.i(57447);
    d.l.b.a.b.f.b localb = b.bB(this.MZV).gre();
    p.g(localb, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(57447);
    return localb;
  }
  
  public final boolean gkK()
  {
    AppMethodBeat.i(221690);
    boolean bool = this.MZV.isAnnotation();
    AppMethodBeat.o(221690);
    return bool;
  }
  
  public final boolean gkM()
  {
    AppMethodBeat.i(57464);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(57464);
    return bool;
  }
  
  public final boolean gkN()
  {
    AppMethodBeat.i(57466);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(57466);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57459);
    int i = this.MZV.hashCode();
    AppMethodBeat.o(57459);
    return i;
  }
  
  public final boolean isEnum()
  {
    AppMethodBeat.i(57457);
    boolean bool = this.MZV.isEnum();
    AppMethodBeat.o(57457);
    return bool;
  }
  
  public final boolean isInterface()
  {
    AppMethodBeat.i(57455);
    boolean bool = this.MZV.isInterface();
    AppMethodBeat.o(57455);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57460);
    String str = getClass().getName() + ": " + this.MZV;
    AppMethodBeat.o(57460);
    return str;
  }
  
  static final class f
    extends q
    implements d.g.a.b<Class<?>, d.l.b.a.b.f.f>
  {
    public static final f Nax;
    
    static
    {
      AppMethodBeat.i(57440);
      Nax = new f();
      AppMethodBeat.o(57440);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */