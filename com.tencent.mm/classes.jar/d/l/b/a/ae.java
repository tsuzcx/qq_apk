package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.d.a.k.a;
import d.l.b.a.b.e.a.h;
import d.l.b.a.b.e.a.m;
import d.l.b.a.b.e.b.i;
import d.l.b.a.b.h.q;
import d.l.b.a.b.j.b.g;
import d.l.b.a.b.j.b.k;
import d.l.b.a.b.j.b.r.b;
import d.l.b.a.b.j.b.r.b.a;
import d.l.b.a.b.j.b.r.b.b;
import d.l.b.a.b.j.b.t;
import d.l.b.a.b.k.a.w;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.o;
import d.u;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/Visibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"})
public final class ae
{
  private static final d.l.b.a.b.f.b Nmd;
  
  static
  {
    AppMethodBeat.i(56564);
    Nmd = new d.l.b.a.b.f.b("kotlin.jvm.JvmStatic");
    AppMethodBeat.o(56564);
  }
  
  public static final <M extends q, D extends d.l.b.a.b.b.a> D a(Class<?> paramClass, M paramM, d.l.b.a.b.e.b.c paramc, d.l.b.a.b.e.b.h paramh, d.l.b.a.b.e.b.a parama, d.g.a.m<? super w, ? super M, ? extends D> paramm)
  {
    AppMethodBeat.i(56563);
    p.h(paramClass, "moduleAnchor");
    p.h(paramM, "proto");
    p.h(paramc, "nameResolver");
    p.h(paramh, "typeTable");
    p.h(parama, "metadataVersion");
    p.h(paramm, "createDescriptor");
    Object localObject1 = x.bs(paramClass);
    if ((paramM instanceof a.h)) {}
    for (paramClass = ((a.h)paramM).NHS;; paramClass = ((a.m)paramM).NHS)
    {
      d.l.b.a.b.k.a.l locall = ((d.l.b.a.b.b.d.a.j)localObject1).Nxg;
      localObject1 = (d.l.b.a.b.b.l)((d.l.b.a.b.b.d.a.j)localObject1).Nxg.Nqw;
      Object localObject2 = i.NMg;
      localObject2 = i.guO();
      p.g(paramClass, "typeParameters");
      paramClass = (d.l.b.a.b.b.a)paramm.p(new w(new d.l.b.a.b.k.a.n(locall, paramc, (d.l.b.a.b.b.l)localObject1, paramh, (i)localObject2, parama, null, null, paramClass)), paramM);
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
  
  public static final ak a(d.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(56562);
    p.h(parama, "$this$instanceReceiverParameter");
    if (parama.gmQ() != null)
    {
      parama = parama.glU();
      if (parama == null)
      {
        parama = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(56562);
        throw parama;
      }
      parama = ((d.l.b.a.b.b.e)parama).gnm();
      AppMethodBeat.o(56562);
      return parama;
    }
    AppMethodBeat.o(56562);
    return null;
  }
  
  public static final Class<?> a(d.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56554);
    p.h(parame, "$this$toJavaClass");
    Object localObject = parame.gmk();
    p.g(localObject, "source");
    if ((localObject instanceof d.l.b.a.b.d.b.r))
    {
      parame = ((d.l.b.a.b.d.b.r)localObject).NGj;
      if (parame == null)
      {
        parame = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((d.l.b.a.b.b.d.a.f)parame).Nxb;
      AppMethodBeat.o(56554);
      return parame;
    }
    if ((localObject instanceof k.a))
    {
      parame = ((k.a)localObject).Nxk;
      if (parame == null)
      {
        parame = new d.v("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((d.l.b.a.b.b.d.b.j)parame).Nxb;
      AppMethodBeat.o(56554);
      return parame;
    }
    localObject = d.l.b.a.b.j.d.a.c((d.l.b.a.b.b.h)parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56554);
      return null;
    }
    parame = a(d.l.b.a.b.b.d.b.b.bx(parame.getClass()), (d.l.b.a.b.f.a)localObject, 0);
    AppMethodBeat.o(56554);
    return parame;
  }
  
  private static final Class<?> a(ClassLoader paramClassLoader, d.l.b.a.b.f.a parama, int paramInt)
  {
    AppMethodBeat.i(56555);
    Object localObject = d.l.b.a.b.a.b.c.Nqr;
    localObject = parama.gvG().gvH();
    p.g(localObject, "kotlinClassId.asSingleFqName().toUnsafe()");
    localObject = d.l.b.a.b.a.b.c.c((d.l.b.a.b.f.c)localObject);
    if (localObject == null) {}
    for (;;)
    {
      localObject = parama.gvB().sD();
      p.g(localObject, "javaClassId.packageFqName.asString()");
      parama = parama.gvC().sD();
      p.g(parama, "javaClassId.relativeClassName.asString()");
      paramClassLoader = a(paramClassLoader, (String)localObject, parama, paramInt);
      AppMethodBeat.o(56555);
      return paramClassLoader;
      parama = (d.l.b.a.b.f.a)localObject;
    }
  }
  
  private static final Class<?> a(ClassLoader paramClassLoader, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(56556);
    if (p.i(paramString1, "kotlin")) {}
    switch (paramString2.hashCode())
    {
    default: 
      paramString1 = paramString1 + '.' + d.n.n.a(paramString2, '.', '$');
      if (paramInt > 0) {
        paramString1 = d.n.n.r((CharSequence)"[", paramInt) + 'L' + paramString1 + ';';
      }
      break;
    }
    for (;;)
    {
      paramClassLoader = d.l.b.a.b.b.d.a.e.a(paramClassLoader, paramString1);
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
  
  private static final Object a(g<?> paramg, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56559);
    if ((paramg instanceof d.l.b.a.b.j.b.a))
    {
      paramg = a((d.l.b.a.b.b.a.c)((d.l.b.a.b.j.b.a)paramg).getValue());
      AppMethodBeat.o(56559);
      return paramg;
    }
    Object localObject;
    if ((paramg instanceof d.l.b.a.b.j.b.b))
    {
      localObject = (Iterable)((d.l.b.a.b.j.b.b)paramg).getValue();
      paramg = (Collection)new ArrayList(d.a.j.a((Iterable)localObject, 10));
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramg.add(a((g)((Iterator)localObject).next(), paramClassLoader));
      }
      paramClassLoader = ((Collection)paramg).toArray(new Object[0]);
      paramg = paramClassLoader;
      if (paramClassLoader == null)
      {
        paramg = new d.v("null cannot be cast to non-null type kotlin.Array<T>");
        AppMethodBeat.o(56559);
        throw paramg;
      }
    }
    else
    {
      if ((paramg instanceof d.l.b.a.b.j.b.j))
      {
        localObject = (o)((d.l.b.a.b.j.b.j)paramg).getValue();
        paramg = (d.l.b.a.b.f.a)((o)localObject).first;
        localObject = (d.l.b.a.b.f.f)((o)localObject).second;
        paramg = a(paramClassLoader, paramg, 0);
        if (paramg != null)
        {
          if (paramg == null)
          {
            paramg = new d.v("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
            AppMethodBeat.o(56559);
            throw paramg;
          }
          paramg = Enum.valueOf(paramg, ((d.l.b.a.b.f.f)localObject).sD());
          AppMethodBeat.o(56559);
          return paramg;
        }
        AppMethodBeat.o(56559);
        return null;
      }
      if ((paramg instanceof d.l.b.a.b.j.b.r))
      {
        paramg = (r.b)((d.l.b.a.b.j.b.r)paramg).getValue();
        if ((paramg instanceof r.b.b))
        {
          paramg = a(paramClassLoader, ((r.b.b)paramg).NTO.NpB, ((r.b.b)paramg).NTO.NTx);
          AppMethodBeat.o(56559);
          return paramg;
        }
        if ((paramg instanceof r.b.a))
        {
          paramClassLoader = ((r.b.a)paramg).NlK.gxB().gmq();
          paramg = paramClassLoader;
          if (!(paramClassLoader instanceof d.l.b.a.b.b.e)) {
            paramg = null;
          }
          paramg = (d.l.b.a.b.b.e)paramg;
          if (paramg != null)
          {
            paramg = a(paramg);
            AppMethodBeat.o(56559);
            return paramg;
          }
          AppMethodBeat.o(56559);
          return null;
        }
        paramg = new d.m();
        AppMethodBeat.o(56559);
        throw paramg;
      }
      if (((paramg instanceof k)) || ((paramg instanceof t)))
      {
        AppMethodBeat.o(56559);
        return null;
      }
      paramg = paramg.getValue();
    }
    AppMethodBeat.o(56559);
    return paramg;
  }
  
  private static final Annotation a(d.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(56558);
    Object localObject1 = d.l.b.a.b.j.d.a.l(paramc);
    if (localObject1 != null)
    {
      localObject1 = a((d.l.b.a.b.b.e)localObject1);
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
      paramc = (Iterable)paramc.gom().entrySet();
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        paramc = (d.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
        localObject2 = (g)((Map.Entry)localObject2).getValue();
        ClassLoader localClassLoader = ((Class)localObject1).getClassLoader();
        p.g(localClassLoader, "annotationClass.classLoader");
        localObject2 = a((g)localObject2, localClassLoader);
        if (localObject2 != null) {}
        for (paramc = u.R(paramc.sD(), localObject2);; paramc = null)
        {
          if (paramc == null) {
            break label178;
          }
          localCollection.add(paramc);
          break;
        }
      }
      paramc = (Annotation)d.l.b.a.a.b.a((Class)localObject1, d.a.ae.A((Iterable)localCollection));
      AppMethodBeat.o(56558);
      return paramc;
    }
  }
  
  public static final List<Annotation> a(d.l.b.a.b.b.a.a parama)
  {
    AppMethodBeat.i(56557);
    p.h(parama, "$this$computeAnnotations");
    parama = (Iterable)parama.gmj();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = parama.iterator();
    label151:
    while (localIterator.hasNext())
    {
      parama = (d.l.b.a.b.b.a.c)localIterator.next();
      Object localObject = parama.gmk();
      if ((localObject instanceof d.l.b.a.b.b.d.a.b)) {
        parama = ((d.l.b.a.b.b.d.a.b)localObject).NwY;
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
          localObject = ((k.a)localObject).Nxk;
          parama = (d.l.b.a.b.b.a.a)localObject;
          if (!(localObject instanceof d.l.b.a.b.b.d.b.c)) {
            parama = null;
          }
          parama = (d.l.b.a.b.b.d.b.c)parama;
          if (parama != null) {
            parama = parama.NwY;
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
  
  public static final j fc(Object paramObject)
  {
    AppMethodBeat.i(56560);
    if (!(paramObject instanceof j)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      j localj = (j)localObject;
      localObject = localj;
      if (localj == null)
      {
        if ((paramObject instanceof d.g.b.n)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (d.g.b.n)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.gks();; paramObject = null)
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
  
  public static final r<?> fd(Object paramObject)
  {
    AppMethodBeat.i(56561);
    if (!(paramObject instanceof r)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      r localr = (r)localObject;
      localObject = localr;
      if (localr == null)
      {
        if ((paramObject instanceof d.g.b.v)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (d.g.b.v)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.gks();; paramObject = null)
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
  
  public static final d.l.b.a.b.f.b glr()
  {
    return Nmd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.ae
 * JD-Core Version:    0.7.0.1
 */