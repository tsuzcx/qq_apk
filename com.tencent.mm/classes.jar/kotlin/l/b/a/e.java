package kotlin.l.b.a;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.d;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.av;
import kotlin.l.b.a.b.b.b;
import kotlin.l.j.a;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lkotlin/reflect/jvm/internal/KCallableImpl;", "R", "Lkotlin/reflect/KCallable;", "()V", "_annotations", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "", "", "kotlin.jvm.PlatformType", "_parameters", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "_returnType", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "_typeParameters", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "annotations", "getAnnotations", "()Ljava/util/List;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;", "isAbstract", "", "()Z", "isAnnotationConstructor", "isBound", "isFinal", "isOpen", "parameters", "getParameters", "returnType", "Lkotlin/reflect/KType;", "getReturnType", "()Lkotlin/reflect/KType;", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility", "()Lkotlin/reflect/KVisibility;", "call", "args", "", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "callAnnotationConstructor", "", "(Ljava/util/Map;)Ljava/lang/Object;", "callBy", "callDefaultMethod", "continuationArgument", "Lkotlin/coroutines/Continuation;", "callDefaultMethod$kotlin_reflection", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "defaultPrimitiveValue", "type", "Ljava/lang/reflect/Type;", "extractContinuationArgument", "kotlin-reflection"})
public abstract class e<R>
  implements kotlin.l.a<R>
{
  private final y.a<List<Annotation>> SZL;
  private final y.a<ArrayList<kotlin.l.j>> SZM;
  private final y.a<t> SZN;
  private final y.a<List<v>> SZO;
  
  public e()
  {
    y.a locala = y.ak((kotlin.g.a.a)new a(this));
    p.g(locala, "ReflectProperties.lazySo…or.computeAnnotations() }");
    this.SZL = locala;
    locala = y.ak((kotlin.g.a.a)new b(this));
    p.g(locala, "ReflectProperties.lazySo…ze()\n        result\n    }");
    this.SZM = locala;
    locala = y.ak((kotlin.g.a.a)new c(this));
    p.g(locala, "ReflectProperties.lazySo…eturnType\n        }\n    }");
    this.SZN = locala;
    locala = y.ak((kotlin.g.a.a)new d(this));
    p.g(locala, "ReflectProperties.lazySo…KTypeParameterImpl)\n    }");
    this.SZO = locala;
  }
  
  private R cy(Map<kotlin.l.j, ? extends Object> paramMap)
  {
    p.h(paramMap, "args");
    Object localObject = getParameters();
    ArrayList localArrayList1 = new ArrayList(((List)localObject).size());
    ArrayList localArrayList2 = new ArrayList(1);
    Iterator localIterator = ((List)localObject).iterator();
    int j = 0;
    int i = 0;
    int k = 0;
    kotlin.l.j localj;
    label101:
    int m;
    if (localIterator.hasNext())
    {
      localj = (kotlin.l.j)localIterator.next();
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
        if (localj.hym() != j.a.SZk) {
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
      if (localj.FI())
      {
        localObject = localj.hyl();
        p.h(localObject, "$this$javaType");
        localObject = ((t)localObject).hyT();
        if (((localObject instanceof Class)) && (((Class)localObject).isPrimitive())) {
          if (p.j(localObject, Boolean.TYPE)) {
            localObject = Boolean.FALSE;
          }
        }
        for (;;)
        {
          localArrayList1.add(localObject);
          j = k | 1 << i % 32;
          k = 1;
          break;
          if (p.j(localObject, Character.TYPE))
          {
            localObject = Character.valueOf('\000');
          }
          else if (p.j(localObject, Byte.TYPE))
          {
            localObject = Byte.valueOf((byte)0);
          }
          else if (p.j(localObject, Short.TYPE))
          {
            localObject = Short.valueOf((short)0);
          }
          else if (p.j(localObject, Integer.TYPE))
          {
            localObject = Integer.valueOf(0);
          }
          else if (p.j(localObject, Float.TYPE))
          {
            localObject = Float.valueOf(0.0F);
          }
          else if (p.j(localObject, Long.TYPE))
          {
            localObject = Long.valueOf(0L);
          }
          else if (p.j(localObject, Double.TYPE))
          {
            localObject = Double.valueOf(0.0D);
          }
          else
          {
            if (p.j(localObject, Void.TYPE)) {
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
          throw new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        }
        return ag(Arrays.copyOf(paramMap, paramMap.length));
      }
      localArrayList2.add(Integer.valueOf(k));
      paramMap = hyu();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + hys()));
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
      paramMap = paramMap.ag((Object[])localObject);
      return paramMap;
      break label101;
    }
  }
  
  private final R cz(Map<kotlin.l.j, ? extends Object> paramMap)
  {
    Object localObject = (Iterable)getParameters();
    Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
    Iterator localIterator = ((Iterable)localObject).iterator();
    kotlin.l.j localj;
    if (localIterator.hasNext())
    {
      localj = (kotlin.l.j)localIterator.next();
      if (paramMap.containsKey(localj))
      {
        localObject = paramMap.get(localj);
        if (localObject != null) {
          break label255;
        }
        throw ((Throwable)new IllegalArgumentException("Annotation argument value cannot be null (" + localj + ')'));
      }
      if (localj.FI()) {
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
      paramMap = hyu();
      if (paramMap == null) {
        throw ((Throwable)new w("This callable does not support a default call: " + hys()));
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
      paramMap = paramMap.ag((Object[])localObject);
      return paramMap;
    }
  }
  
  public final R ag(Object... paramVarArgs)
  {
    p.h(paramVarArgs, "args");
    try
    {
      paramVarArgs = hyt().ag(paramVarArgs);
      return paramVarArgs;
    }
    catch (IllegalAccessException paramVarArgs)
    {
      throw ((Throwable)new kotlin.l.a.a(paramVarArgs));
    }
  }
  
  public final R cx(Map<kotlin.l.j, ? extends Object> paramMap)
  {
    p.h(paramMap, "args");
    if (hyw()) {
      return cz(paramMap);
    }
    return cy(paramMap);
  }
  
  public final List<kotlin.l.j> getParameters()
  {
    Object localObject = this.SZM.invoke();
    p.g(localObject, "_parameters()");
    return (List)localObject;
  }
  
  public abstract b hys();
  
  public abstract d<?> hyt();
  
  public abstract d<?> hyu();
  
  public abstract i hyv();
  
  protected final boolean hyw()
  {
    return (p.j(getName(), "<init>")) && (hyv().hxU().isAnnotation());
  }
  
  public abstract boolean isBound();
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "", "R", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<List<? extends Annotation>>
  {
    a(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Ljava/util/ArrayList;", "Lkotlin/reflect/KParameter;", "R", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<ArrayList<kotlin.l.j>>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "Lkotlin/reflect/jvm/internal/KTypeImpl;", "R", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<t>
  {
    c(e parame)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "Lkotlin/reflect/jvm/internal/KTypeParameterImpl;", "R", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     kotlin.l.b.a.e
 * JD-Core Version:    0.7.0.1
 */