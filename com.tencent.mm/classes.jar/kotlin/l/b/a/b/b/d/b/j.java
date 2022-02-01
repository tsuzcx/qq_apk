package kotlin.l.b.a.b.b.d.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.v;
import kotlin.g.b.ae;
import kotlin.g.b.q;
import kotlin.l.b.a.b.b.ba;
import kotlin.l.b.a.b.d.a.e.g;
import kotlin.l.b.a.b.f.a;
import kotlin.l.d;

public final class j
  extends n
  implements f, t, g
{
  public final Class<?> aaPD;
  
  public j(Class<?> paramClass)
  {
    AppMethodBeat.i(57461);
    this.aaPD = paramClass;
    AppMethodBeat.o(57461);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(57458);
    if (((paramObject instanceof j)) && (kotlin.g.b.p.h(this.aaPD, ((j)paramObject).aaPD)))
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
    int i = this.aaPD.hashCode();
    AppMethodBeat.o(57459);
    return i;
  }
  
  public final ba iDQ()
  {
    AppMethodBeat.i(57467);
    ba localba = t.a.d(this);
    AppMethodBeat.o(57467);
    return localba;
  }
  
  public final List<x> iEG()
  {
    AppMethodBeat.i(57454);
    Object localObject = this.aaPD.getTypeParameters();
    kotlin.g.b.p.j(localObject, "klass.typeParameters");
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
  
  public final kotlin.l.b.a.b.f.f iEU()
  {
    AppMethodBeat.i(57453);
    kotlin.l.b.a.b.f.f localf = kotlin.l.b.a.b.f.f.bHb(this.aaPD.getSimpleName());
    kotlin.g.b.p.j(localf, "Name.identifier(klass.simpleName)");
    AppMethodBeat.o(57453);
    return localf;
  }
  
  public final kotlin.l.b.a.b.f.b iFy()
  {
    AppMethodBeat.i(57447);
    kotlin.l.b.a.b.f.b localb = b.ca(this.aaPD).iNx();
    kotlin.g.b.p.j(localb, "klass.classId.asSingleFqName()");
    AppMethodBeat.o(57447);
    return localb;
  }
  
  public final Collection<kotlin.l.b.a.b.d.a.e.j> iGk()
  {
    AppMethodBeat.i(57449);
    if (kotlin.g.b.p.h(this.aaPD, Object.class))
    {
      localObject1 = (Collection)v.aaAd;
      AppMethodBeat.o(57449);
      return localObject1;
    }
    ae localae = new ae(2);
    Object localObject2 = this.aaPD.getGenericSuperclass();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = (Type)Object.class;
    }
    localae.add(localObject1);
    localObject1 = this.aaPD.getGenericInterfaces();
    kotlin.g.b.p.j(localObject1, "klass.genericInterfaces");
    localae.eZ(localObject1);
    localObject2 = (Iterable)kotlin.a.j.listOf((Type[])localae.toArray(new Type[localae.fmA.size()]));
    localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((Collection)localObject1).add(new l((Type)((Iterator)localObject2).next()));
    }
    localObject1 = (Collection)localObject1;
    AppMethodBeat.o(57449);
    return localObject1;
  }
  
  public final int iHb()
  {
    AppMethodBeat.i(57445);
    int i = this.aaPD.getModifiers();
    AppMethodBeat.o(57445);
    return i;
  }
  
  public final boolean iHg()
  {
    AppMethodBeat.i(57455);
    boolean bool = this.aaPD.isInterface();
    AppMethodBeat.o(57455);
    return bool;
  }
  
  public final boolean iHh()
  {
    AppMethodBeat.i(292945);
    boolean bool = this.aaPD.isAnnotation();
    AppMethodBeat.o(292945);
    return bool;
  }
  
  public final boolean iHi()
  {
    AppMethodBeat.i(57457);
    boolean bool = this.aaPD.isEnum();
    AppMethodBeat.o(57457);
    return bool;
  }
  
  public final boolean iHk()
  {
    AppMethodBeat.i(57464);
    boolean bool = t.a.a(this);
    AppMethodBeat.o(57464);
    return bool;
  }
  
  public final boolean iHl()
  {
    AppMethodBeat.i(57466);
    boolean bool = t.a.c(this);
    AppMethodBeat.o(57466);
    return bool;
  }
  
  public final boolean ihW()
  {
    AppMethodBeat.i(57465);
    boolean bool = t.a.b(this);
    AppMethodBeat.o(57465);
    return bool;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(57460);
    String str = getClass().getName() + ": " + this.aaPD;
    AppMethodBeat.o(57460);
    return str;
  }
  
  static final class f
    extends q
    implements kotlin.g.a.b<Class<?>, kotlin.l.b.a.b.f.f>
  {
    public static final f aaQf;
    
    static
    {
      AppMethodBeat.i(57440);
      aaQf = new f();
      AppMethodBeat.o(57440);
    }
    
    f()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.b.b.d.b.j
 * JD-Core Version:    0.7.0.1
 */