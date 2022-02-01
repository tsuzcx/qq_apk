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

@l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"})
public final class a
  implements d
{
  private final Class<?> KUC;
  private final List<Method> KVD;
  private final List<Type> KYe;
  private final List<Class<?>> KYf;
  private final List<Object> KYg;
  private final List<String> KYh;
  private final a KYi;
  
  public a(Class<?> paramClass, List<String> paramList, a parama, b paramb, List<Method> paramList1)
  {
    AppMethodBeat.i(56575);
    this.KUC = paramClass;
    this.KYh = paramList;
    this.KYi = parama;
    this.KVD = paramList1;
    paramList = (Iterable)this.KVD;
    paramClass = (Collection)new ArrayList(j.a(paramList, 10));
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramClass.add(((Method)paramList.next()).getGenericReturnType());
    }
    this.KYe = ((List)paramClass);
    paramClass = (Iterable)this.KVD;
    parama = (Collection)new ArrayList(j.a(paramClass, 10));
    paramList1 = paramClass.iterator();
    if (paramList1.hasNext())
    {
      paramClass = ((Method)paramList1.next()).getReturnType();
      k.g(paramClass, "it");
      paramList = d.l.b.a.b.b.d.b.b.by(paramClass);
      if (paramList != null) {
        break label376;
      }
    }
    for (;;)
    {
      parama.add(paramClass);
      break;
      this.KYf = ((List)parama);
      paramList = (Iterable)this.KVD;
      paramClass = (Collection)new ArrayList(j.a(paramList, 10));
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        paramClass.add(((Method)paramList.next()).getDefaultValue());
      }
      this.KYg = ((List)paramClass);
      if ((this.KYi == a.KYk) && (paramb == b.KYm))
      {
        if (!((Collection)j.c((Iterable)this.KYh, "value")).isEmpty()) {}
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
      if ((localObject == null) && (this.KYi == a.KYj)) {}
      for (localObject = this.KYg.get(i); localObject == null; localObject = b.f(localObject, (Class)this.KYf.get(i)))
      {
        b.a(i, (String)this.KYh.get(i), (Class)this.KYf.get(i));
        AppMethodBeat.o(56574);
        throw null;
      }
      localCollection.add(localObject);
      j += 1;
      i += 1;
    }
    paramArrayOfObject = (List)localCollection;
    paramArrayOfObject = b.a(this.KUC, ae.y((Iterable)j.b((Iterable)this.KYh, (Iterable)paramArrayOfObject)), this.KVD);
    AppMethodBeat.o(56574);
    return paramArrayOfObject;
  }
  
  public final Type fPt()
  {
    return (Type)this.KUC;
  }
  
  public final List<Type> fPu()
  {
    return this.KYe;
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(56568);
      a locala1 = new a("CALL_BY_NAME", 0);
      KYj = locala1;
      a locala2 = new a("POSITIONAL_CALL", 1);
      KYk = locala2;
      KYl = new a[] { locala1, locala2 };
      AppMethodBeat.o(56568);
    }
    
    private a() {}
  }
  
  @l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"})
  public static enum b
  {
    static
    {
      AppMethodBeat.i(56571);
      b localb1 = new b("JAVA", 0);
      KYm = localb1;
      b localb2 = new b("KOTLIN", 1);
      KYn = localb2;
      KYo = new b[] { localb1, localb2 };
      AppMethodBeat.o(56571);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.a
 * JD-Core Version:    0.7.0.1
 */