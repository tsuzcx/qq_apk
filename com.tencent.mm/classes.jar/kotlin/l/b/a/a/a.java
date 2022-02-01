package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.a.p;
import kotlin.g.b.ai;
import kotlin.g.b.s;
import kotlin.l.c;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public final class a
  implements d
{
  private final List<Class<?>> aiAA;
  private final List<Object> aiAB;
  private final List<String> aiAC;
  private final a.a aiAD;
  private final List<Type> aiAz;
  private final Class<?> aiwN;
  private final List<Method> aixZ;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.aiwN = paramClass;
    this.aiAC = paramList;
    this.aiAD = parama;
    this.aixZ = paramList1;
    paramList = (Iterable)this.aixZ;
    paramClass = (Collection)new ArrayList(p.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.aiAz = ((List)paramClass);
    paramClass = (Iterable)this.aixZ;
    parama = (Collection)new ArrayList(p.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      s.s(paramClass, "it");
      paramList = kotlin.l.b.a.b.b.e.b.b.cL(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.aiAA = ((List)parama);
      paramList = (Iterable)this.aixZ;
      paramClass = (Collection)new ArrayList(p.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.aiAB = ((List)paramClass);
      if ((this.aiAD == a.a.aiAF) && (paramb == a.b.aiAH))
      {
        if (!((Collection)p.c((Iterable)this.aiAC, "value")).isEmpty()) {}
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
  
  public final Object ap(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56574);
    s.u(paramArrayOfObject, "args");
    s.u(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
    Object localObject2 = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject1 = paramArrayOfObject[j];
      if ((localObject1 == null) && (this.aiAD == a.a.aiAE))
      {
        localObject1 = this.aiAB.get(i);
        if (localObject1 != null) {
          break label338;
        }
        localObject1 = (String)this.aiAC.get(i);
        paramArrayOfObject = (Class)this.aiAA.get(i);
        if (!s.p(paramArrayOfObject, Class.class)) {
          break label291;
        }
        paramArrayOfObject = ai.cz(c.class);
        label131:
        if (!s.p(paramArrayOfObject.klu(), ai.cz([Ljava.lang.Object.class).klu())) {
          break label328;
        }
        localObject2 = new StringBuilder().append(paramArrayOfObject.klu()).append('<');
        paramArrayOfObject = kotlin.g.a.b(paramArrayOfObject).getComponentType();
        s.s(paramArrayOfObject, "kotlinClass.java.componentType");
      }
      label291:
      label328:
      for (paramArrayOfObject = kotlin.g.a.cx(paramArrayOfObject).klu() + '>';; paramArrayOfObject = paramArrayOfObject.klu())
      {
        paramArrayOfObject = (Throwable)new IllegalArgumentException("Argument #" + i + ' ' + (String)localObject1 + " is not of the required type " + paramArrayOfObject);
        AppMethodBeat.o(56574);
        throw paramArrayOfObject;
        localObject1 = b.e(localObject1, (Class)this.aiAA.get(i));
        break;
        if ((paramArrayOfObject.isArray()) && (s.p(paramArrayOfObject.getComponentType(), Class.class)))
        {
          paramArrayOfObject = ai.cz([Lkotlin.l.c.class);
          break label131;
        }
        paramArrayOfObject = kotlin.g.a.cx(paramArrayOfObject);
        break label131;
      }
      label338:
      ((Collection)localObject2).add(localObject1);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localObject2;
    paramArrayOfObject = b.a(this.aiwN, ak.F((Iterable)p.d((Iterable)this.aiAC, (Iterable)paramArrayOfObject)), this.aixZ);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final List<Type> kmA()
  {
    return this.aiAz;
  }
  
  public final Type kmz()
  {
    return (Type)this.aiwN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */