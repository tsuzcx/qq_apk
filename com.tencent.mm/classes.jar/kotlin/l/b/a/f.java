package kotlin.l.b.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.b.b.am;
import kotlin.l.b.a.b.b.as;
import kotlin.l.n;
import kotlin.l.n.a;

@Metadata(d1={""}, d2={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/reflect/jvm/internal/KTypeParameterOwnerImpl;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultEmptyArray", "type", "extractContinuationArgument", "Ljava/lang/reflect/Type;", "kotlin-reflection"}, k=1, mv={1, 5, 1})
public abstract class f<R>
  implements kotlin.l.b<R>, z
{
  private final ac.a<List<Annotation>> aiyo;
  private final ac.a<ArrayList<n>> aiyp;
  private final ac.a<v> aiyq;
  private final ac.a<List<x>> aiyr;
  
  public f()
  {
    ac.a locala = ac.cp((kotlin.g.a.a)new a(this));
    s.s(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.aiyo = locala;
    locala = ac.cp((kotlin.g.a.a)new b(this));
    s.s(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.aiyp = locala;
    locala = ac.cp((kotlin.g.a.a)new c(this));
    s.s(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.aiyq = locala;
    locala = ac.cp((kotlin.g.a.a)new d(this));
    s.s(locala, "ReflectProperties.lazySo…this, descriptor) }\n    }");
    this.aiyr = locala;
  }
  
  private static Object d(kotlin.l.u paramu)
  {
    paramu = kotlin.g.a.b(kotlin.l.b.a.c(paramu));
    if (paramu.isArray())
    {
      paramu = Array.newInstance(paramu.getComponentType(), 0);
      s.s(paramu, "type.jvmErasure.java.run…\"\n            )\n        }");
      return paramu;
    }
    throw ((Throwable)new aa("Cannot instantiate the default empty array of type " + paramu.getSimpleName() + ", because it is not an array type"));
  }
  
  private R dB(Map<n, ? extends Object> paramMap)
  {
    s.u(paramMap, "args");
    Object localObject = klq();
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size());
    ArrayList localArrayList2 = new ArrayList(1);
    Iterator localIterator = ((List)localObject).iterator();
    int i = 0;
    int j = 0;
    int k = 0;
    n localn;
    if (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      if ((j == 0) || (j % 32 != 0)) {
        break label470;
      }
      localArrayList2.add(Integer.valueOf(k));
      k = 0;
      label101:
      if (paramMap.containsKey(localn))
      {
        localArrayList1.add(paramMap.get(localn));
        label126:
        if (localn.klO() != n.a.aixH) {
          break label473;
        }
        j += 1;
      }
    }
    label470:
    label473:
    for (;;)
    {
      break;
      if (localn.ahk())
      {
        if (ai.e(localn.klN())) {}
        for (localObject = null;; localObject = ai.j((Type)localObject))
        {
          localArrayList1.add(localObject);
          k |= 1 << j % 32;
          i = 1;
          break;
          kotlin.l.u localu = localn.klN();
          s.u(localu, "$this$javaType");
          Type localType = ((v)localu).klA();
          localObject = localType;
          if (localType == null) {
            localObject = kotlin.l.ac.a(localu);
          }
        }
      }
      if (localn.klP())
      {
        localArrayList1.add(d(localn.klN()));
        break label126;
      }
      throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localn))));
      if (i == 0)
      {
        paramMap = ((Collection)localArrayList1).toArray(new Object[0]);
        if (paramMap == null) {
          throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return ap(Arrays.copyOf(paramMap, paramMap.length));
      }
      localArrayList2.add(Integer.valueOf(k));
      paramMap = klX();
      if (paramMap == null) {
        throw ((Throwable)new aa("This callable does not support a default call: " + klV()));
      }
      localArrayList1.addAll((Collection)localArrayList2);
      localArrayList1.add(null);
      try
      {
        localObject = ((Collection)localArrayList1).toArray(new Object[0]);
        if (localObject == null) {
          throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new kotlin.l.a.a(paramMap));
      }
      paramMap = paramMap.ap((Object[])localObject);
      return paramMap;
      break label101;
    }
  }
  
  private final R dC(Map<n, ? extends Object> paramMap)
  {
    Object localObject = (Iterable)klq();
    Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    n localn;
    if (localIterator.hasNext())
    {
      localn = (n)localIterator.next();
      if (paramMap.containsKey(localn))
      {
        localObject = paramMap.get(localn);
        if (localObject != null) {
          break label279;
        }
        throw ((Throwable)new IllegalArgumentException("Annotation argument value cannot be null (" + localn + ')'));
      }
      if (localn.ahk()) {
        localObject = null;
      }
    }
    label279:
    for (;;)
    {
      localCollection.add(localObject);
      break;
      if (localn.klP())
      {
        localObject = d(localn.klN());
      }
      else
      {
        throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localn))));
        localObject = (List)localCollection;
        paramMap = klX();
        if (paramMap == null) {
          throw ((Throwable)new aa("This callable does not support a default call: " + klV()));
        }
        try
        {
          localObject = ((Collection)localObject).toArray(new Object[0]);
          if (localObject == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          }
        }
        catch (IllegalAccessException paramMap)
        {
          throw ((Throwable)new kotlin.l.a.a(paramMap));
        }
        paramMap = paramMap.ap((Object[])localObject);
        return paramMap;
      }
    }
  }
  
  public final R ap(Object... paramVarArgs)
  {
    s.u(paramVarArgs, "args");
    try
    {
      paramVarArgs = klW().ap(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new kotlin.l.a.a(paramVarArgs));
    }
  }
  
  public final R dA(Map<n, ? extends Object> paramMap)
  {
    s.u(paramMap, "args");
    if (klZ()) {
      return dC(paramMap);
    }
    return dB(paramMap);
  }
  
  public abstract boolean isBound();
  
  public abstract kotlin.l.b.a.b.b.b klV();
  
  public abstract d<?> klW();
  
  public abstract d<?> klX();
  
  public abstract j klY();
  
  protected final boolean klZ()
  {
    return (s.p(getName(), "<init>")) && (klY().kls().isAnnotation());
  }
  
  public final List<n> klq()
  {
    Object localObject = this.aiyp.invoke();
    s.s(localObject, "_parameters()");
    return (List)localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "kotlin.jvm.PlatformType", "R", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "kotlin.jvm.PlatformType", "R", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ArrayList<n>>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.a<v>
  {
    c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "kotlin.jvm.PlatformType", "R", "invoke"}, k=3, mv={1, 5, 1})
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.a<List<? extends x>>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.f
 * JD-Core Version:    0.7.0.1
 */