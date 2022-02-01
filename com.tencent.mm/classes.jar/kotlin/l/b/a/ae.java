package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.g.b.p;
import kotlin.l.b.a.b.b.ak;
import kotlin.l.b.a.b.b.d.a.k.a;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.j.b.g;
import kotlin.l.b.a.b.j.b.k;
import kotlin.l.b.a.b.j.b.r.b;
import kotlin.l.b.a.b.j.b.r.b.a;
import kotlin.l.b.a.b.j.b.r.b.b;
import kotlin.l.b.a.b.m.ab;
import kotlin.l.b.a.b.m.at;
import kotlin.o;
import kotlin.s;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"})
public final class ae
{
  private static final kotlin.l.b.a.b.f.b aaEF;
  
  static
  {
    AppMethodBeat.i(56564);
    aaEF = new kotlin.l.b.a.b.f.b("kotlin.jvm.JvmStatic");
    AppMethodBeat.o(56564);
  }
  
  private static final Class<?> a(ClassLoader paramClassLoader, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(56556);
    if (p.h(paramString1, "kotlin")) {}
    switch (paramString2.hashCode())
    {
    default: 
      paramString1 = paramString1 + '.' + kotlin.n.n.a(paramString2, '.', '$');
      if (paramInt > 0) {
        paramString1 = kotlin.n.n.v((CharSequence)"[", paramInt) + 'L' + paramString1 + ';';
      }
      break;
    }
    for (;;)
    {
      paramClassLoader = kotlin.l.b.a.b.b.d.a.e.a(paramClassLoader, paramString1);
      AppMethodBeat.o(56556);
      return paramClassLoader;
      if (!paramString2.equals("Array")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [Ljava.lang.Object.class;
      if (!paramString2.equals("LongArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [J.class;
      if (!paramString2.equals("CharArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [C.class;
      if (!paramString2.equals("FloatArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [F.class;
      if (!paramString2.equals("IntArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [I.class;
      if (!paramString2.equals("ByteArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [B.class;
      if (!paramString2.equals("ShortArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [S.class;
      if (!paramString2.equals("DoubleArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [D.class;
      if (!paramString2.equals("BooleanArray")) {
        break;
      }
      AppMethodBeat.o(56556);
      return [Z.class;
    }
  }
  
  private static final Class<?> a(ClassLoader paramClassLoader, kotlin.l.b.a.b.f.a parama, int paramInt)
  {
    AppMethodBeat.i(56555);
    Object localObject = kotlin.l.b.a.b.a.b.c.aaIT;
    localObject = parama.iNx().iNy();
    p.j(localObject, "kotlinClassId.asSingleFqName().toUnsafe()");
    localObject = kotlin.l.b.a.b.a.b.c.c((kotlin.l.b.a.b.f.c)localObject);
    if (localObject == null) {}
    for (;;)
    {
      localObject = parama.iNs().qu();
      p.j(localObject, "javaClassId.packageFqName.asString()");
      parama = parama.iNt().qu();
      p.j(parama, "javaClassId.relativeClassName.asString()");
      paramClassLoader = a(paramClassLoader, (String)localObject, parama, paramInt);
      AppMethodBeat.o(56555);
      return paramClassLoader;
      parama = (kotlin.l.b.a.b.f.a)localObject;
    }
  }
  
  public static final Class<?> a(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56554);
    p.k(parame, "$this$toJavaClass");
    Object localObject = parame.iDZ();
    p.j(localObject, "source");
    if ((localObject instanceof kotlin.l.b.a.b.d.b.r))
    {
      parame = ((kotlin.l.b.a.b.d.b.r)localObject).aaYF;
      if (parame == null)
      {
        parame = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((kotlin.l.b.a.b.b.d.a.f)parame).aaPD;
      AppMethodBeat.o(56554);
      return parame;
    }
    if ((localObject instanceof k.a))
    {
      parame = ((k.a)localObject).aaPM;
      if (parame == null)
      {
        parame = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((kotlin.l.b.a.b.b.d.b.j)parame).aaPD;
      AppMethodBeat.o(56554);
      return parame;
    }
    localObject = kotlin.l.b.a.b.j.d.a.c((kotlin.l.b.a.b.b.h)parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56554);
      return null;
    }
    parame = a(kotlin.l.b.a.b.b.d.b.b.bW(parame.getClass()), (kotlin.l.b.a.b.f.a)localObject, 0);
    AppMethodBeat.o(56554);
    return parame;
  }
  
  private static final Object a(g<?> paramg, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56559);
    if ((paramg instanceof kotlin.l.b.a.b.j.b.a))
    {
      paramg = a((kotlin.l.b.a.b.b.a.c)((kotlin.l.b.a.b.j.b.a)paramg).getValue());
      AppMethodBeat.o(56559);
      return paramg;
    }
    Object localObject;
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      localObject = (Iterable)((kotlin.l.b.a.b.j.b.b)paramg).getValue();
      paramg = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramg.add(a((g)((Iterator)localObject).next(), paramClassLoader));
      }
      paramClassLoader = ((Collection)paramg).toArray(new Object[0]);
      paramg = paramClassLoader;
      if (paramClassLoader == null)
      {
        paramg = new kotlin.t("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56559);
        throw paramg;
      }
    }
    else
    {
      if ((paramg instanceof kotlin.l.b.a.b.j.b.j))
      {
        localObject = (o)((kotlin.l.b.a.b.j.b.j)paramg).getValue();
        paramg = (kotlin.l.b.a.b.f.a)((o)localObject).Mx;
        localObject = (kotlin.l.b.a.b.f.f)((o)localObject).My;
        paramg = a(paramClassLoader, paramg, 0);
        if (paramg != null)
        {
          if (paramg == null)
          {
            paramg = new kotlin.t("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
            AppMethodBeat.o(56559);
            throw paramg;
          }
          paramg = Enum.valueOf(paramg, ((kotlin.l.b.a.b.f.f)localObject).qu());
          AppMethodBeat.o(56559);
          return paramg;
        }
        AppMethodBeat.o(56559);
        return null;
      }
      if ((paramg instanceof kotlin.l.b.a.b.j.b.r))
      {
        paramg = (r.b)((kotlin.l.b.a.b.j.b.r)paramg).getValue();
        if ((paramg instanceof r.b.b))
        {
          paramg = a(paramClassLoader, ((r.b.b)paramg).abln.aaId, ((r.b.b)paramg).abln.abkX);
          AppMethodBeat.o(56559);
          return paramg;
        }
        if ((paramg instanceof r.b.a))
        {
          paramClassLoader = ((r.b.a)paramg).aaEm.iOU().iEf();
          paramg = paramClassLoader;
          if (!(paramClassLoader instanceof kotlin.l.b.a.b.b.e)) {
            paramg = null;
          }
          paramg = (kotlin.l.b.a.b.b.e)paramg;
          if (paramg != null)
          {
            paramg = a(paramg);
            AppMethodBeat.o(56559);
            return paramg;
          }
          AppMethodBeat.o(56559);
          return null;
        }
        paramg = new kotlin.m();
        AppMethodBeat.o(56559);
        throw paramg;
      }
      if (((paramg instanceof k)) || ((paramg instanceof kotlin.l.b.a.b.j.b.t)))
      {
        AppMethodBeat.o(56559);
        return null;
      }
      paramg = paramg.getValue();
    }
    AppMethodBeat.o(56559);
    return paramg;
  }
  
  private static final Annotation a(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(56558);
    Object localObject1 = kotlin.l.b.a.b.j.d.a.l(paramc);
    if (localObject1 != null)
    {
      localObject1 = a((kotlin.l.b.a.b.b.e)localObject1);
      if ((localObject1 instanceof Class)) {
        break label206;
      }
      localObject1 = null;
    }
    label178:
    label206:
    for (;;)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(56558);
        return null;
        localObject1 = null;
        break;
      }
      paramc = (Iterable)paramc.iGd().entrySet();
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
        localObject2 = (g)((Map.Entry)localObject2).getValue();
        ClassLoader localClassLoader = ((Class)localObject1).getClassLoader();
        p.j(localClassLoader, "annotationClass.classLoader");
        localObject2 = a((g)localObject2, localClassLoader);
        if (localObject2 != null) {}
        for (paramc = s.M(paramc.qu(), localObject2);; paramc = null)
        {
          if (paramc == null) {
            break label178;
          }
          localCollection.add(paramc);
          break;
        }
      }
      paramc = (Annotation)kotlin.l.b.a.a.b.a((Class)localObject1, kotlin.a.ae.E((Iterable)localCollection));
      AppMethodBeat.o(56558);
      return paramc;
    }
  }
  
  public static final List<Annotation> a(kotlin.l.b.a.b.b.a.a parama)
  {
    AppMethodBeat.i(56557);
    p.k(parama, "$this$computeAnnotations");
    parama = (Iterable)parama.iDY();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = parama.iterator();
    label151:
    while (localIterator.hasNext())
    {
      parama = (kotlin.l.b.a.b.b.a.c)localIterator.next();
      Object localObject = parama.iDZ();
      if ((localObject instanceof kotlin.l.b.a.b.b.d.a.b)) {
        parama = ((kotlin.l.b.a.b.b.d.a.b)localObject).aaPA;
      }
      for (;;)
      {
        if (parama == null) {
          break label151;
        }
        localCollection.add(parama);
        break;
        if ((localObject instanceof k.a))
        {
          localObject = ((k.a)localObject).aaPM;
          parama = (kotlin.l.b.a.b.b.a.a)localObject;
          if (!(localObject instanceof kotlin.l.b.a.b.b.d.b.c)) {
            parama = null;
          }
          parama = (kotlin.l.b.a.b.b.d.b.c)parama;
          if (parama != null) {
            parama = parama.aaPA;
          } else {
            parama = null;
          }
        }
        else
        {
          parama = a(parama);
        }
      }
    }
    parama = (List)localCollection;
    AppMethodBeat.o(56557);
    return parama;
  }
  
  public static final <M extends kotlin.l.b.a.b.h.r, D extends kotlin.l.b.a.b.b.a> D a(Class<?> paramClass, M paramM, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.h paramh, kotlin.l.b.a.b.e.b.a parama, kotlin.g.a.m<? super kotlin.l.b.a.b.k.a.w, ? super M, ? extends D> paramm)
  {
    AppMethodBeat.i(56563);
    p.k(paramClass, "moduleAnchor");
    p.k(paramM, "proto");
    p.k(paramc, "nameResolver");
    p.k(paramh, "typeTable");
    p.k(parama, "metadataVersion");
    p.k(paramm, "createDescriptor");
    Object localObject1 = x.bR(paramClass);
    if ((paramM instanceof a.h)) {}
    for (paramClass = ((a.h)paramM).abal;; paramClass = ((a.m)paramM).abal)
    {
      kotlin.l.b.a.b.k.a.l locall = ((kotlin.l.b.a.b.b.d.a.j)localObject1).aaPI;
      localObject1 = (kotlin.l.b.a.b.b.l)((kotlin.l.b.a.b.b.d.a.j)localObject1).aaPI.aaIY;
      Object localObject2 = i.abey;
      localObject2 = i.iMF();
      p.j(paramClass, "typeParameters");
      paramClass = (kotlin.l.b.a.b.b.a)paramm.invoke(new kotlin.l.b.a.b.k.a.w(new kotlin.l.b.a.b.k.a.n(locall, paramc, (kotlin.l.b.a.b.b.l)localObject1, paramh, (i)localObject2, parama, null, null, paramClass)), paramM);
      AppMethodBeat.o(56563);
      return paramClass;
      if (!(paramM instanceof a.m)) {
        break;
      }
    }
    paramClass = (Throwable)new IllegalStateException("Unsupported message: ".concat(String.valueOf(paramM)).toString());
    AppMethodBeat.o(56563);
    throw paramClass;
  }
  
  public static final ak a(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(56562);
    p.k(parama, "$this$instanceReceiverParameter");
    if (parama.iEF() != null)
    {
      parama = parama.iDJ();
      if (parama == null)
      {
        parama = new kotlin.t("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(56562);
        throw parama;
      }
      parama = ((kotlin.l.b.a.b.b.e)parama).iFb();
      AppMethodBeat.o(56562);
      return parama;
    }
    AppMethodBeat.o(56562);
    return null;
  }
  
  public static final j fo(Object paramObject)
  {
    AppMethodBeat.i(56560);
    if (!(paramObject instanceof j)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      j localj = (j)localObject;
      localObject = localj;
      if (localj == null)
      {
        if ((paramObject instanceof kotlin.g.b.n)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (kotlin.g.b.n)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.iBZ();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof j)) {
            localObject = null;
          }
          localObject = (j)localObject;
          AppMethodBeat.o(56560);
          return localObject;
        }
      }
    }
  }
  
  public static final r<?> fp(Object paramObject)
  {
    AppMethodBeat.i(56561);
    if (!(paramObject instanceof r)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      r localr = (r)localObject;
      localObject = localr;
      if (localr == null)
      {
        if ((paramObject instanceof kotlin.g.b.w)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (kotlin.g.b.w)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.iBZ();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof r)) {
            localObject = null;
          }
          localObject = (r)localObject;
          AppMethodBeat.o(56561);
          return localObject;
        }
      }
    }
  }
  
  public static final kotlin.l.b.a.b.f.b iDf()
  {
    return aaEF;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.ae
 * JD-Core Version:    0.7.0.1
 */