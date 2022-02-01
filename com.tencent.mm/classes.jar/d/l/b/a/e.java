package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l.b.a.a.d;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b;
import d.l.j.a;
import d.v;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"})
public abstract class e<R>
  implements d.l.a<R>
{
  private final z.a<List<Annotation>> KVS;
  private final z.a<ArrayList<d.l.j>> KVT;
  private final z.a<u> KVU;
  private final z.a<List<w>> KVV;
  
  public e()
  {
    z.a locala = z.N((d.g.a.a)new a(this));
    k.g(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.KVS = locala;
    locala = z.N((d.g.a.a)new b(this));
    k.g(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.KVT = locala;
    locala = z.N((d.g.a.a)new c(this));
    k.g(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.KVU = locala;
    locala = z.N((d.g.a.a)new d(this));
    k.g(locala, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this.KVV = locala;
  }
  
  private R cd(Map<d.l.j, ? extends Object> paramMap)
  {
    k.h(paramMap, "args");
    Object localObject = getParameters();
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size());
    ArrayList localArrayList2 = new ArrayList(1);
    Iterator localIterator = ((List)localObject).iterator();
    int j = 0;
    int i = 0;
    int k = 0;
    d.l.j localj;
    label101:
    int m;
    if (localIterator.hasNext())
    {
      localj = (d.l.j)localIterator.next();
      if ((i == 0) || (i % 32 != 0)) {
        break label646;
      }
      localArrayList2.add(Integer.valueOf(k));
      k = 0;
      if (paramMap.containsKey(localj))
      {
        localArrayList1.add(paramMap.get(localj));
        m = j;
        j = k;
        k = m;
        if (localj.fOH() != j.a.KVr) {
          break label649;
        }
        i += 1;
      }
    }
    label646:
    label649:
    for (;;)
    {
      m = k;
      k = j;
      j = m;
      break;
      if (localj.bmP())
      {
        localObject = localj.fOG();
        k.h(localObject, "$this$javaType");
        localObject = ((u)localObject).fPq();
        if (((localObject instanceof Class)) && (((Class)localObject).isPrimitive())) {
          if (k.g(localObject, Boolean.TYPE)) {
            localObject = Boolean.FALSE;
          }
        }
        for (;;)
        {
          localArrayList1.add(localObject);
          j = k | 1 << i % 32;
          k = 1;
          break;
          if (k.g(localObject, Character.TYPE))
          {
            localObject = Character.valueOf('\000');
          }
          else if (k.g(localObject, Byte.TYPE))
          {
            localObject = Byte.valueOf((byte)0);
          }
          else if (k.g(localObject, Short.TYPE))
          {
            localObject = Short.valueOf((short)0);
          }
          else if (k.g(localObject, Integer.TYPE))
          {
            localObject = Integer.valueOf(0);
          }
          else if (k.g(localObject, Float.TYPE))
          {
            localObject = Float.valueOf(0.0F);
          }
          else if (k.g(localObject, Long.TYPE))
          {
            localObject = Long.valueOf(0L);
          }
          else if (k.g(localObject, Double.TYPE))
          {
            localObject = Double.valueOf(0.0D);
          }
          else
          {
            if (k.g(localObject, Void.TYPE)) {
              throw ((Throwable)new IllegalStateException("Parameter with void type is illegal"));
            }
            throw ((Throwable)new UnsupportedOperationException("Unknown primitive: ".concat(String.valueOf(localObject))));
            localObject = null;
          }
        }
      }
      throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localj))));
      if (j == 0)
      {
        paramMap = ((Collection)localArrayList1).toArray(new Object[0]);
        if (paramMap == null) {
          throw new v("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return ae(Arrays.copyOf(paramMap, paramMap.length));
      }
      localArrayList2.add(Integer.valueOf(k));
      paramMap = fOP();
      if (paramMap == null) {
        throw ((Throwable)new x("This callable does not support a default call: " + fON()));
      }
      localArrayList1.addAll((Collection)localArrayList2);
      localArrayList1.add(null);
      try
      {
        localObject = ((Collection)localArrayList1).toArray(new Object[0]);
        if (localObject == null) {
          throw new v("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new d.l.a.a(paramMap));
      }
      paramMap = paramMap.ae((Object[])localObject);
      return paramMap;
      break label101;
    }
  }
  
  private final R ce(Map<d.l.j, ? extends Object> paramMap)
  {
    Object localObject = (Iterable)getParameters();
    Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    d.l.j localj;
    if (localIterator.hasNext())
    {
      localj = (d.l.j)localIterator.next();
      if (paramMap.containsKey(localj))
      {
        localObject = paramMap.get(localj);
        if (localObject != null) {
          break label255;
        }
        throw ((Throwable)new IllegalArgumentException("Annotation argument value cannot be null (" + localj + ')'));
      }
      if (localj.bmP()) {
        localObject = null;
      }
    }
    label255:
    for (;;)
    {
      localCollection.add(localObject);
      break;
      throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localj))));
      localObject = (List)localCollection;
      paramMap = fOP();
      if (paramMap == null) {
        throw ((Throwable)new x("This callable does not support a default call: " + fON()));
      }
      try
      {
        localObject = ((Collection)localObject).toArray(new Object[0]);
        if (localObject == null) {
          throw new v("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new d.l.a.a(paramMap));
      }
      paramMap = paramMap.ae((Object[])localObject);
      return paramMap;
    }
  }
  
  public final R ae(Object... paramVarArgs)
  {
    k.h(paramVarArgs, "args");
    try
    {
      paramVarArgs = fOO().ae(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new d.l.a.a(paramVarArgs));
    }
  }
  
  public final R cc(Map<d.l.j, ? extends Object> paramMap)
  {
    k.h(paramMap, "args");
    if (fOR()) {
      return ce(paramMap);
    }
    return cd(paramMap);
  }
  
  public abstract b fON();
  
  public abstract d<?> fOO();
  
  public abstract d<?> fOP();
  
  public abstract i fOQ();
  
  protected final boolean fOR()
  {
    return (k.g(getName(), "<init>")) && (fOQ().fOt().isAnnotation());
  }
  
  public final List<d.l.j> getParameters()
  {
    Object localObject = this.KVT.invoke();
    k.g(localObject, "_parameters()");
    return (List)localObject;
  }
  
  public abstract boolean isBound();
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "", "R", "invoke"})
  static final class a
    extends d.g.b.l
    implements d.g.a.a<List<? extends Annotation>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<ArrayList<d.l.j>>
  {
    b(e parame)
    {
      super();
    }
    
    @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(56298);
        int i = d.b.a.a((Comparable)((d.l.j)paramT1).getName(), (Comparable)((d.l.j)paramT2).getName());
        AppMethodBeat.o(56298);
        return i;
      }
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.a<u>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.a<List<? extends w>>
  {
    d(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.e
 * JD-Core Version:    0.7.0.1
 */