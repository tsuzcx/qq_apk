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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> MLE;
  private final List<Method> MMJ;
  private final List<Type> MPb;
  private final List<Class<?>> MPc;
  private final List<Object> MPd;
  private final List<String> MPe;
  private final a.a MPf;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.MLE = paramClass;
    this.MPe = paramList;
    this.MPf = parama;
    this.MMJ = paramList1;
    paramList = (Iterable)this.MMJ;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.MPb = ((List)paramClass);
    paramClass = (Iterable)this.MMJ;
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
      this.MPc = ((List)parama);
      paramList = (Iterable)this.MMJ;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.MPd = ((List)paramClass);
      if ((this.MPf == a.a.MPh) && (paramb == a.b.MPj))
      {
        if (!((Collection)j.c((Iterable)this.MPe, "value")).isEmpty()) {}
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
  
  public final Object af(Object[] paramArrayOfObject)
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
      if ((localObject1 == null) && (this.MPf == a.a.MPg))
      {
        localObject1 = this.MPd.get(i);
        if (localObject1 != null) {
          break label338;
        }
        localObject1 = (String)this.MPe.get(i);
        paramArrayOfObject = (Class)this.MPc.get(i);
        if (!p.i(paramArrayOfObject, Class.class)) {
          break label291;
        }
        paramArrayOfObject = z.bp(d.l.b.class);
        label131:
        if (!p.i(paramArrayOfObject.gfU(), z.bp([Ljava.lang.Object.class).gfU())) {
          break label328;
        }
        localObject2 = new StringBuilder().append(paramArrayOfObject.gfU()).append('<');
        paramArrayOfObject = d.g.a.a(paramArrayOfObject).getComponentType();
        p.g(paramArrayOfObject, "kotlinClass.java.componentType");
      }
      label291:
      label328:
      for (paramArrayOfObject = d.g.a.bo(paramArrayOfObject).gfU() + '>';; paramArrayOfObject = paramArrayOfObject.gfU())
      {
        paramArrayOfObject = (Throwable)new IllegalArgumentException("Argument #" + i + ' ' + (String)localObject1 + " is not of the required type " + paramArrayOfObject);
        AppMethodBeat.o(56574);
        throw paramArrayOfObject;
        localObject1 = b.f(localObject1, (Class)this.MPc.get(i));
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
    paramArrayOfObject = b.a(this.MLE, ae.A((Iterable)j.c((Iterable)this.MPe, (Iterable)paramArrayOfObject)), this.MMJ);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type ggR()
  {
    return (Type)this.MLE;
  }
  
  public final List<Type> ggS()
  {
    return this.MPb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */