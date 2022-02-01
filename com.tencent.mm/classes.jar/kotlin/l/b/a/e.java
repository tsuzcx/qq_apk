package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.m;
import kotlin.l.m.a;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"})
public abstract class e<R>
  implements kotlin.l.a<R>
{
  private final y.a<List<Annotation>> aaCF;
  private final y.a<ArrayList<m>> aaCG;
  private final y.a<t> aaCH;
  private final y.a<List<v>> aaCI;
  
  public e()
  {
    y.a locala = y.au((kotlin.g.a.a)new a(this));
    p.j(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.aaCF = locala;
    locala = y.au((kotlin.g.a.a)new b(this));
    p.j(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.aaCG = locala;
    locala = y.au((kotlin.g.a.a)new c(this));
    p.j(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.aaCH = locala;
    locala = y.au((kotlin.g.a.a)new d(this));
    p.j(locala, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this.aaCI = locala;
  }
  
  private R cF(Map<m, ? extends Object> paramMap)
  {
    p.k(paramMap, "args");
    Object localObject = iCb();
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size());
    ArrayList localArrayList2 = new ArrayList(1);
    Iterator localIterator = ((List)localObject).iterator();
    int j = 0;
    int i = 0;
    int k = 0;
    m localm;
    label101:
    int m;
    if (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      if ((i == 0) || (i % 32 != 0)) {
        break label646;
      }
      localArrayList2.add(Integer.valueOf(k));
      k = 0;
      if (paramMap.containsKey(localm))
      {
        localArrayList1.add(paramMap.get(localm));
        m = j;
        j = k;
        k = m;
        if (localm.iCx() != m.a.aaCe) {
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
      if (localm.Ho())
      {
        localObject = localm.iCw();
        p.k(localObject, "$this$javaType");
        localObject = ((t)localObject).iDe();
        if (((localObject instanceof Class)) && (((Class)localObject).isPrimitive())) {
          if (p.h(localObject, Boolean.TYPE)) {
            localObject = Boolean.FALSE;
          }
        }
        for (;;)
        {
          localArrayList1.add(localObject);
          j = k | 1 << i % 32;
          k = 1;
          break;
          if (p.h(localObject, Character.TYPE))
          {
            localObject = Character.valueOf('\000');
          }
          else if (p.h(localObject, Byte.TYPE))
          {
            localObject = Byte.valueOf((byte)0);
          }
          else if (p.h(localObject, Short.TYPE))
          {
            localObject = Short.valueOf((short)0);
          }
          else if (p.h(localObject, Integer.TYPE))
          {
            localObject = Integer.valueOf(0);
          }
          else if (p.h(localObject, Float.TYPE))
          {
            localObject = Float.valueOf(0.0F);
          }
          else if (p.h(localObject, Long.TYPE))
          {
            localObject = Long.valueOf(0L);
          }
          else if (p.h(localObject, Double.TYPE))
          {
            localObject = Double.valueOf(0.0D);
          }
          else
          {
            if (p.h(localObject, Void.TYPE)) {
              throw ((Throwable)new IllegalStateException("Parameter with void type is illegal"));
            }
            throw ((Throwable)new UnsupportedOperationException("Unknown primitive: ".concat(String.valueOf(localObject))));
            localObject = null;
          }
        }
      }
      throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localm))));
      if (j == 0)
      {
        paramMap = ((Collection)localArrayList1).toArray(new Object[0]);
        if (paramMap == null) {
          throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return ak(Arrays.copyOf(paramMap, paramMap.length));
      }
      localArrayList2.add(Integer.valueOf(k));
      paramMap = iCF();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + iCD()));
      }
      localArrayList1.addAll((Collection)localArrayList2);
      localArrayList1.add(null);
      try
      {
        localObject = ((Collection)localArrayList1).toArray(new Object[0]);
        if (localObject == null) {
          throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new kotlin.l.a.a(paramMap));
      }
      paramMap = paramMap.ak((Object[])localObject);
      return paramMap;
      break label101;
    }
  }
  
  private final R cG(Map<m, ? extends Object> paramMap)
  {
    Object localObject = (Iterable)iCb();
    Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    m localm;
    if (localIterator.hasNext())
    {
      localm = (m)localIterator.next();
      if (paramMap.containsKey(localm))
      {
        localObject = paramMap.get(localm);
        if (localObject != null) {
          break label255;
        }
        throw ((Throwable)new IllegalArgumentException("Annotation argument value cannot be null (" + localm + ')'));
      }
      if (localm.Ho()) {
        localObject = null;
      }
    }
    label255:
    for (;;)
    {
      localCollection.add(localObject);
      break;
      throw ((Throwable)new IllegalArgumentException("No argument provided for a required parameter: ".concat(String.valueOf(localm))));
      localObject = (List)localCollection;
      paramMap = iCF();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + iCD()));
      }
      try
      {
        localObject = ((Collection)localObject).toArray(new Object[0]);
        if (localObject == null) {
          throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
      }
      catch (IllegalAccessException paramMap)
      {
        throw ((Throwable)new kotlin.l.a.a(paramMap));
      }
      paramMap = paramMap.ak((Object[])localObject);
      return paramMap;
    }
  }
  
  public final R ak(Object... paramVarArgs)
  {
    p.k(paramVarArgs, "args");
    try
    {
      paramVarArgs = iCE().ak(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new kotlin.l.a.a(paramVarArgs));
    }
  }
  
  public final R cE(Map<m, ? extends Object> paramMap)
  {
    p.k(paramMap, "args");
    if (iCH()) {
      return cG(paramMap);
    }
    return cF(paramMap);
  }
  
  public abstract b iCD();
  
  public abstract d<?> iCE();
  
  public abstract d<?> iCF();
  
  public abstract i iCG();
  
  protected final boolean iCH()
  {
    return (p.h(getName(), "<init>")) && (iCG().iCd().isAnnotation());
  }
  
  public final List<m> iCb()
  {
    Object localObject = this.aaCG.invoke();
    p.j(localObject, "_parameters()");
    return (List)localObject;
  }
  
  public abstract boolean isBound();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "", "R", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ArrayList<m>>
  {
    b(e parame)
    {
      super();
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
    public static final class a<T>
      implements Comparator<T>
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(56298);
        int i = kotlin.b.a.a((Comparable)((m)paramT1).getName(), (Comparable)((m)paramT2).getName());
        AppMethodBeat.o(56298);
        return i;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<t>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<List<? extends v>>
  {
    d(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.e
 * JD-Core Version:    0.7.0.1
 */