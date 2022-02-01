package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.p;
import d.g.b.z;
import d.l;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> NiH;
  private final List<Method> NjO;
  private final List<Type> Nmg;
  private final List<Class<?>> Nmh;
  private final List<Object> Nmi;
  private final List<String> Nmj;
  private final a Nmk;
  
  public a(Class<?> paramClass, List<String> paramList, a parama, b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.NiH = paramClass;
    this.Nmj = paramList;
    this.Nmk = parama;
    this.NjO = paramList1;
    paramList = (Iterable)this.NjO;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.Nmg = ((List)paramClass);
    paramClass = (Iterable)this.NjO;
    parama = (Collection)new ArrayList(j.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      p.g(paramClass, "it");
      paramList = d.l.b.a.b.b.d.b.b.bA(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.Nmh = ((List)parama);
      paramList = (Iterable)this.NjO;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.Nmi = ((List)paramClass);
      if ((this.Nmk == a.Nmm) && (paramb == b.Nmo))
      {
        if (!((Collection)j.c((Iterable)this.Nmj, "value")).isEmpty()) {}
        for (int i = 1; i != 0; i = 0)
        {
          paramClass = (Throwable)new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
          AppMethodBeat.o(56575);
          throw paramClass;
        }
      }
      AppMethodBeat.o(56575);
      return;
      label376:
      paramClass = paramList;
    }
  }
  
  public final Object ae(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56574);
    p.h(paramArrayOfObject, "args");
    p.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
    Object localObject2 = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject1 = paramArrayOfObject[j];
      if ((localObject1 == null) && (this.Nmk == a.Nml))
      {
        localObject1 = this.Nmi.get(i);
        if (localObject1 != null) {
          break label338;
        }
        localObject1 = (String)this.Nmj.get(i);
        paramArrayOfObject = (Class)this.Nmh.get(i);
        if (!p.i(paramArrayOfObject, Class.class)) {
          break label291;
        }
        paramArrayOfObject = z.bp(d.l.b.class);
        label131:
        if (!p.i(paramArrayOfObject.gkw(), z.bp([Ljava.lang.Object.class).gkw())) {
          break label328;
        }
        localObject2 = new StringBuilder().append(paramArrayOfObject.gkw()).append('<');
        paramArrayOfObject = d.g.a.a(paramArrayOfObject).getComponentType();
        p.g(paramArrayOfObject, "kotlinClass.java.componentType");
      }
      label291:
      label328:
      for (paramArrayOfObject = d.g.a.bo(paramArrayOfObject).gkw() + '>';; paramArrayOfObject = paramArrayOfObject.gkw())
      {
        paramArrayOfObject = (Throwable)new IllegalArgumentException("Argument #" + i + ' ' + (String)localObject1 + " is not of the required type " + paramArrayOfObject);
        AppMethodBeat.o(56574);
        throw paramArrayOfObject;
        localObject1 = b.f(localObject1, (Class)this.Nmh.get(i));
        break;
        if ((paramArrayOfObject.isArray()) && (p.i(paramArrayOfObject.getComponentType(), Class.class)))
        {
          paramArrayOfObject = z.bp([Ld.l.b.class);
          break label131;
        }
        paramArrayOfObject = d.g.a.bo(paramArrayOfObject);
        break label131;
      }
      label338:
      ((Collection)localObject2).add(localObject1);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localObject2;
    paramArrayOfObject = b.a(this.NiH, ae.A((Iterable)j.c((Iterable)this.Nmj, (Iterable)paramArrayOfObject)), this.NjO);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type glt()
  {
    return (Type)this.NiH;
  }
  
  public final List<Type> glu()
  {
    return this.Nmg;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56568);
      a locala1 = new a("CALL_BY_NAME", 0);
      Nml = locala1;
      a locala2 = new a("POSITIONAL_CALL", 1);
      Nmm = locala2;
      Nmn = new a[] { locala1, locala2 };
      AppMethodBeat.o(56568);
    }
    
    private a() {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(56571);
      b localb1 = new b("JAVA", 0);
      Nmo = localb1;
      b localb2 = new b("KOTLIN", 1);
      Nmp = localb2;
      Nmq = new b[] { localb1, localb2 };
      AppMethodBeat.o(56571);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */