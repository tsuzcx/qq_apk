package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.l.b.a.a.d;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.b;
import d.l.j.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"})
public abstract class e<R>
  implements d.l.a<R>
{
  private final y.a<List<Annotation>> Nkd;
  private final y.a<ArrayList<d.l.j>> Nke;
  private final y.a<t> Nkf;
  private final y.a<List<v>> Nkg;
  
  public e()
  {
    y.a locala = y.R((d.g.a.a)new a(this));
    p.g(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.Nkd = locala;
    locala = y.R((d.g.a.a)new b(this));
    p.g(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.Nke = locala;
    locala = y.R((d.g.a.a)new c(this));
    p.g(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.Nkf = locala;
    locala = y.R((d.g.a.a)new d(this));
    p.g(locala, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this.Nkg = locala;
  }
  
  private R cl(Map<d.l.j, ? extends Object> paramMap)
  {
    p.h(paramMap, "args");
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
        if (localj.gkJ() != j.a.NjC) {
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
      if (localj.brk())
      {
        localObject = localj.gkI();
        p.h(localObject, "$this$javaType");
        localObject = ((t)localObject).glq();
        if (((localObject instanceof Class)) && (((Class)localObject).isPrimitive())) {
          if (p.i(localObject, Boolean.TYPE)) {
            localObject = Boolean.FALSE;
          }
        }
        for (;;)
        {
          localArrayList1.add(localObject);
          j = k | 1 << i % 32;
          k = 1;
          break;
          if (p.i(localObject, Character.TYPE))
          {
            localObject = Character.valueOf('\000');
          }
          else if (p.i(localObject, Byte.TYPE))
          {
            localObject = Byte.valueOf((byte)0);
          }
          else if (p.i(localObject, Short.TYPE))
          {
            localObject = Short.valueOf((short)0);
          }
          else if (p.i(localObject, Integer.TYPE))
          {
            localObject = Integer.valueOf(0);
          }
          else if (p.i(localObject, Float.TYPE))
          {
            localObject = Float.valueOf(0.0F);
          }
          else if (p.i(localObject, Long.TYPE))
          {
            localObject = Long.valueOf(0L);
          }
          else if (p.i(localObject, Double.TYPE))
          {
            localObject = Double.valueOf(0.0D);
          }
          else
          {
            if (p.i(localObject, Void.TYPE)) {
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
          throw new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return ae(Arrays.copyOf(paramMap, paramMap.length));
      }
      localArrayList2.add(Integer.valueOf(k));
      paramMap = gkR();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + gkP()));
      }
      localArrayList1.addAll((Collection)localArrayList2);
      localArrayList1.add(null);
      try
      {
        localObject = ((Collection)localArrayList1).toArray(new Object[0]);
        if (localObject == null) {
          throw new d.v("null cannot be cast to non-null type kotlin.Array<T>");
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
  
  private final R cm(Map<d.l.j, ? extends Object> paramMap)
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
      if (localj.brk()) {
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
      paramMap = gkR();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + gkP()));
      }
      try
      {
        localObject = ((Collection)localObject).toArray(new Object[0]);
        if (localObject == null) {
          throw new d.v("null cannot be cast to non-null type kotlin.Array<T>");
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
    p.h(paramVarArgs, "args");
    try
    {
      paramVarArgs = gkQ().ae(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new d.l.a.a(paramVarArgs));
    }
  }
  
  public final R ck(Map<d.l.j, ? extends Object> paramMap)
  {
    p.h(paramMap, "args");
    if (gkT()) {
      return cm(paramMap);
    }
    return cl(paramMap);
  }
  
  public final List<d.l.j> getParameters()
  {
    Object localObject = this.Nke.invoke();
    p.g(localObject, "_parameters()");
    return (List)localObject;
  }
  
  public abstract b gkP();
  
  public abstract d<?> gkQ();
  
  public abstract d<?> gkR();
  
  public abstract i gkS();
  
  protected final boolean gkT()
  {
    return (p.i(getName(), "<init>")) && (gkS().gkv().isAnnotation());
  }
  
  public abstract boolean isBound();
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "R", "invoke"})
  static final class a
    extends q
    implements d.g.a.a<List<? extends Annotation>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<ArrayList<d.l.j>>
  {
    b(e parame)
    {
      super();
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"})
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
  static final class c
    extends q
    implements d.g.a.a<t>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
  static final class d
    extends q
    implements d.g.a.a<List<? extends v>>
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