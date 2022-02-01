package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.a.ae;
import kotlin.a.j;
import kotlin.g.b.ab;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> aaBb;
  private final List<Method> aaCq;
  private final List<Type> aaEI;
  private final List<Class<?>> aaEJ;
  private final List<Object> aaEK;
  private final List<String> aaEL;
  private final a.a aaEM;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.aaBb = paramClass;
    this.aaEL = paramList;
    this.aaEM = parama;
    this.aaCq = paramList1;
    paramList = (Iterable)this.aaCq;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.aaEI = ((List)paramClass);
    paramClass = (Iterable)this.aaCq;
    parama = (Collection)new ArrayList(j.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      p.j(paramClass, "it");
      paramList = kotlin.l.b.a.b.b.d.b.b.bZ(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.aaEJ = ((List)parama);
      paramList = (Iterable)this.aaCq;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.aaEK = ((List)paramClass);
      if ((this.aaEM == a.a.aaEO) && (paramb == a.b.aaEQ))
      {
        if (!((Collection)j.c((Iterable)this.aaEL, "value")).isEmpty()) {}
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
  
  public final Object ak(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56574);
    p.k(paramArrayOfObject, "args");
    p.k(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
    Object localObject2 = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject1 = paramArrayOfObject[j];
      if ((localObject1 == null) && (this.aaEM == a.a.aaEN))
      {
        localObject1 = this.aaEK.get(i);
        if (localObject1 != null) {
          break label338;
        }
        localObject1 = (String)this.aaEL.get(i);
        paramArrayOfObject = (Class)this.aaEJ.get(i);
        if (!p.h(paramArrayOfObject, Class.class)) {
          break label291;
        }
        paramArrayOfObject = ab.bO(kotlin.l.b.class);
        label131:
        if (!p.h(paramArrayOfObject.iCf(), ab.bO([Ljava.lang.Object.class).iCf())) {
          break label328;
        }
        localObject2 = new StringBuilder().append(paramArrayOfObject.iCf()).append('<');
        paramArrayOfObject = kotlin.g.a.a(paramArrayOfObject).getComponentType();
        p.j(paramArrayOfObject, "kotlinClass.java.componentType");
      }
      label291:
      label328:
      for (paramArrayOfObject = kotlin.g.a.bN(paramArrayOfObject).iCf() + '>';; paramArrayOfObject = paramArrayOfObject.iCf())
      {
        paramArrayOfObject = (Throwable)new IllegalArgumentException("Argument #" + i + ' ' + (String)localObject1 + " is not of the required type " + paramArrayOfObject);
        AppMethodBeat.o(56574);
        throw paramArrayOfObject;
        localObject1 = b.d(localObject1, (Class)this.aaEJ.get(i));
        break;
        if ((paramArrayOfObject.isArray()) && (p.h(paramArrayOfObject.getComponentType(), Class.class)))
        {
          paramArrayOfObject = ab.bO([Lkotlin.l.b.class);
          break label131;
        }
        paramArrayOfObject = kotlin.g.a.bN(paramArrayOfObject);
        break label131;
      }
      label338:
      ((Collection)localObject2).add(localObject1);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localObject2;
    paramArrayOfObject = b.a(this.aaBb, ae.E((Iterable)j.c((Iterable)this.aaEL, (Iterable)paramArrayOfObject)), this.aaCq);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type iDh()
  {
    return (Type)this.aaBb;
  }
  
  public final List<Type> iDi()
  {
    return this.aaEI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */