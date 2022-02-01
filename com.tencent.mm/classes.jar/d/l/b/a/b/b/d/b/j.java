package d.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.v;
import d.g.b.k;
import d.g.b.y;
import d.l.b.a.b.b.ba;
import d.l.b.a.b.d.a.e.g;
import d.l.b.a.b.f.a;
import d.l.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class j
  extends n
  implements f, t, g
{
  public final Class<?> LiZ;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(57461);
    this.LiZ = paramClass;
    AppMethodBeat.o(57461);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57458);
    if (((paramObject instanceof j)) && (k.g(this.LiZ, ((j)paramObject).LiZ)))
    {
      AppMethodBeat.o(57458);
      return true;
    }
    AppMethodBeat.o(57458);
    return false;
  }
  
  public final List<x> fQR()
  {
    AppMethodBeat.i(57454);
    Object localObject = this.LiZ.getTypeParameters();
    k.g(localObject, "klass.typeParameters");
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
  
  public final ba fQb()
  {
    AppMethodBeat.i(57467);
    ba localba = t.a.d(this);
    AppMethodBeat.o(57467);
    return localba;
  }
  
  public final d.l.b.a.b.f.b fRH()
  {
    AppMethodBeat.i(57447);
    d.l.b.a.b.f.b localb = b.bz(this.LiZ).fZF();
    k.g(localb, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(57447);
    return localb;
  }
  
  public final d.l.b.a.b.f.f fRf()
  {
    AppMethodBeat.i(57453);
    d.l.b.a.b.f.f localf = d.l.b.a.b.f.f.aWB(this.LiZ.getSimpleName());
    k.g(localf, "Name.identifier(klass.simpleName)");
    AppMethodBeat.o(57453);
    return localf;
  }
  
  public final Collection<d.l.b.a.b.d.a.e.j> fSt()
  {
    AppMethodBeat.i(57449);
    if (k.g(this.LiZ, Object.class))
    {
      localObject1 = (Collection)v.KTF;
      AppMethodBeat.o(57449);
      return localObject1;
    }
    y localy = new y(2);
    Object localObject2 = this.LiZ.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localy.add(localObject1);
    localObject1 = this.LiZ.getGenericInterfaces();
    k.g(localObject1, "klass.genericInterfaces");
    localy.eL(localObject1);
    localObject2 = (Iterable)d.a.j.listOf((Type[])localy.toArray(new Type[localy.cQJ.size()]));
    localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(57449);
    return localObject1;
  }
  
  public final boolean fTl()
  {
    AppMethodBeat.i(210234);
    boolean bool = this.LiZ.isAnnotation();
    AppMethodBeat.o(210234);
    return bool;
  }
  
  public final boolean fTn()
  {
    AppMethodBeat.i(57464);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(57464);
    return bool;
  }
  
  public final boolean fTo()
  {
    AppMethodBeat.i(57466);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(57466);
    return bool;
  }
  
  public final boolean fzr()
  {
    AppMethodBeat.i(57465);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(57465);
    return bool;
  }
  
  public final int getModifiers()
  {
    AppMethodBeat.i(57445);
    int i = this.LiZ.getModifiers();
    AppMethodBeat.o(57445);
    return i;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(57459);
    int i = this.LiZ.hashCode();
    AppMethodBeat.o(57459);
    return i;
  }
  
  public final boolean isEnum()
  {
    AppMethodBeat.i(57457);
    boolean bool = this.LiZ.isEnum();
    AppMethodBeat.o(57457);
    return bool;
  }
  
  public final boolean isInterface()
  {
    AppMethodBeat.i(57455);
    boolean bool = this.LiZ.isInterface();
    AppMethodBeat.o(57455);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57460);
    String str = getClass().getName() + ": " + this.LiZ;
    AppMethodBeat.o(57460);
    return str;
  }
  
  static final class f
    extends d.g.b.l
    implements d.g.a.b<Class<?>, d.l.b.a.b.f.f>
  {
    public static final f LjB;
    
    static
    {
      AppMethodBeat.i(57440);
      LjB = new f();
      AppMethodBeat.o(57440);
    }
    
    f()
    {
      super();
    }
  }
  
  static final class g
    extends d.g.b.l
    implements d.g.a.b<Method, Boolean>
  {
    g(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.b.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */