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
import kotlin.g.b.aa;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> SYp;
  private final List<Method> SZw;
  private final List<Type> TbO;
  private final List<Class<?>> TbP;
  private final List<Object> TbQ;
  private final List<String> TbR;
  private final a.a TbS;
  
  public a(Class<?> paramClass, List<String> paramList, a.a parama, a.b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.SYp = paramClass;
    this.TbR = paramList;
    this.TbS = parama;
    this.SZw = paramList1;
    paramList = (Iterable)this.SZw;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.TbO = ((List)paramClass);
    paramClass = (Iterable)this.SZw;
    parama = (Collection)new ArrayList(j.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      p.g(paramClass, "it");
      paramList = kotlin.l.b.a.b.b.d.b.b.bA(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.TbP = ((List)parama);
      paramList = (Iterable)this.SZw;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.TbQ = ((List)paramClass);
      if ((this.TbS == a.a.TbU) && (paramb == a.b.TbW))
      {
        if (!((Collection)j.c((Iterable)this.TbR, "value")).isEmpty()) {}
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
  
  public final Object ag(Object[] paramArrayOfObject)
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
      if ((localObject1 == null) && (this.TbS == a.a.TbT))
      {
        localObject1 = this.TbQ.get(i);
        if (localObject1 != null) {
          break label338;
        }
        localObject1 = (String)this.TbR.get(i);
        paramArrayOfObject = (Class)this.TbP.get(i);
        if (!p.j(paramArrayOfObject, Class.class)) {
          break label291;
        }
        paramArrayOfObject = aa.bp(kotlin.l.b.class);
        label131:
        if (!p.j(paramArrayOfObject.hxV(), aa.bp([Ljava.lang.Object.class).hxV())) {
          break label328;
        }
        localObject2 = new StringBuilder().append(paramArrayOfObject.hxV()).append('<');
        paramArrayOfObject = kotlin.g.a.a(paramArrayOfObject).getComponentType();
        p.g(paramArrayOfObject, "kotlinClass.java.componentType");
      }
      label291:
      label328:
      for (paramArrayOfObject = kotlin.g.a.bo(paramArrayOfObject).hxV() + '>';; paramArrayOfObject = paramArrayOfObject.hxV())
      {
        paramArrayOfObject = (Throwable)new IllegalArgumentException("Argument #" + i + ' ' + (String)localObject1 + " is not of the required type " + paramArrayOfObject);
        AppMethodBeat.o(56574);
        throw paramArrayOfObject;
        localObject1 = b.d(localObject1, (Class)this.TbP.get(i));
        break;
        if ((paramArrayOfObject.isArray()) && (p.j(paramArrayOfObject.getComponentType(), Class.class)))
        {
          paramArrayOfObject = aa.bp([Lkotlin.l.b.class);
          break label131;
        }
        paramArrayOfObject = kotlin.g.a.bo(paramArrayOfObject);
        break label131;
      }
      label338:
      ((Collection)localObject2).add(localObject1);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localObject2;
    paramArrayOfObject = b.a(this.SYp, ae.E((Iterable)j.c((Iterable)this.TbR, (Iterable)paramArrayOfObject)), this.SZw);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type hyW()
  {
    return (Type)this.SYp;
  }
  
  public final List<Type> hyX()
  {
    return this.TbO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */