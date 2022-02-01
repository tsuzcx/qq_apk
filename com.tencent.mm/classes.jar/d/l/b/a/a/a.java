package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.a.j;
import d.g.b.k;
import d.l;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(fvt={1, 1, 15}, fvu={""}, fvv={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> Jhj;
  private final List<Method> Jij;
  private final List<Type> JkK;
  private final List<Class<?>> JkL;
  private final List<Object> JkM;
  private final List<String> JkN;
  private final a.a JkO;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.Jhj = paramClass;
    this.JkN = paramList;
    this.JkO = parama;
    this.Jij = paramList1;
    paramList = (Iterable)this.Jij;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.JkK = ((List)paramClass);
    paramClass = (Iterable)this.Jij;
    parama = (Collection)new ArrayList(j.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      k.g(paramClass, "it");
      paramList = d.l.b.a.b.b.d.b.b.bv(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.JkL = ((List)parama);
      paramList = (Iterable)this.Jij;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.JkM = ((List)paramClass);
      if ((this.JkO == a.a.JkQ) && (paramb == a.b.JkS))
      {
        if (!((Collection)j.c((Iterable)this.JkN, "value")).isEmpty()) {}
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
  
  public final Object ac(Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(56574);
    k.h(paramArrayOfObject, "args");
    k.h(paramArrayOfObject, "args");
    d.a.a(this, paramArrayOfObject);
    Collection localCollection = (Collection)new ArrayList(paramArrayOfObject.length);
    int k = paramArrayOfObject.length;
    int j = 0;
    int i = 0;
    while (j < k)
    {
      Object localObject = paramArrayOfObject[j];
      if ((localObject == null) && (this.JkO == a.a.JkP)) {}
      for (localObject = this.JkM.get(i); localObject == null; localObject = b.f(localObject, (Class)this.JkL.get(i)))
      {
        b.a(i, (String)this.JkN.get(i), (Class)this.JkL.get(i));
        AppMethodBeat.o(56574);
        throw null;
      }
      localCollection.add(localObject);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localCollection;
    paramArrayOfObject = b.a(this.Jhj, ae.z((Iterable)j.b((Iterable)this.JkN, (Iterable)paramArrayOfObject)), this.Jij);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type fwP()
  {
    return (Type)this.Jhj;
  }
  
  public final List<Type> fwQ()
  {
    return this.JkK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */