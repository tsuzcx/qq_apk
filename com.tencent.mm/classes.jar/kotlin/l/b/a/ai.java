package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.b.ac;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.e.a.l.a;
import kotlin.l.b.a.b.e.a.h;
import kotlin.l.b.a.b.e.a.m;
import kotlin.l.b.a.b.e.b.i;
import kotlin.l.b.a.b.f.d;
import kotlin.l.b.a.b.j.b.q.b;
import kotlin.l.b.a.b.j.b.q.b.a;
import kotlin.l.b.a.b.j.b.q.b.b;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;
import kotlin.l.b.a.b.m.az;
import kotlin.l.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", "", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", "", "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", "", "className", "arrayDimensions", "", "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", "", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class ai
{
  private static final kotlin.l.b.a.b.f.c aiAx;
  
  static
  {
    AppMethodBeat.i(56564);
    aiAx = new kotlin.l.b.a.b.f.c("kotlin.jvm.JvmStatic");
    AppMethodBeat.o(56564);
  }
  
  private static final Class<?> a(ClassLoader paramClassLoader, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(56556);
    if (kotlin.g.b.s.p(paramString1, "kotlin")) {}
    switch (paramString2.hashCode())
    {
    default: 
      paramString1 = paramString1 + '.' + n.a(paramString2, '.', '$');
      if (paramInt > 0) {
        paramString1 = n.p((CharSequence)"[", paramInt) + 'L' + paramString1 + ';';
      }
      break;
    }
    for (;;)
    {
      paramClassLoader = kotlin.l.b.a.b.b.e.a.e.e(paramClassLoader, paramString1);
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
  
  private static final Class<?> a(ClassLoader paramClassLoader, kotlin.l.b.a.b.f.b paramb, int paramInt)
  {
    AppMethodBeat.i(56555);
    Object localObject = kotlin.l.b.a.b.a.b.c.aiEX;
    localObject = paramb.kxQ().kxR();
    kotlin.g.b.s.s(localObject, "kotlinClassId.asSingleFqName().toUnsafe()");
    localObject = kotlin.l.b.a.b.a.b.c.c((d)localObject);
    if (localObject == null) {}
    for (;;)
    {
      localObject = paramb.kxL().PF();
      kotlin.g.b.s.s(localObject, "javaClassId.packageFqName.asString()");
      paramb = paramb.kxM().PF();
      kotlin.g.b.s.s(paramb, "javaClassId.relativeClassName.asString()");
      paramClassLoader = a(paramClassLoader, (String)localObject, paramb, paramInt);
      AppMethodBeat.o(56555);
      return paramClassLoader;
      paramb = (kotlin.l.b.a.b.f.b)localObject;
    }
  }
  
  private static final Object a(kotlin.l.b.a.b.j.b.b paramb, ClassLoader paramClassLoader)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i = 0;
    AppMethodBeat.i(191347);
    if (!(paramb instanceof kotlin.l.b.a.b.k.a.m)) {}
    for (Object localObject1 = null;; localObject1 = paramb)
    {
      localObject1 = (kotlin.l.b.a.b.k.a.m)localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((kotlin.l.b.a.b.k.a.m)localObject1).aiAd;
        if (localObject1 != null) {}
      }
      else
      {
        AppMethodBeat.o(191347);
        return null;
      }
      Object localObject3 = (Iterable)paramb.getValue();
      Object localObject2 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(a((kotlin.l.b.a.b.j.b.g)((Iterator)localObject3).next(), paramClassLoader));
      }
      localObject3 = (List)localObject2;
      localObject2 = kotlin.l.b.a.b.a.h.o((ad)localObject1);
      if (localObject2 == null)
      {
        if (!kotlin.l.b.a.b.a.h.m((ad)localObject1))
        {
          paramb = (Throwable)new IllegalStateException("Not an array type: ".concat(String.valueOf(localObject1)).toString());
          AppMethodBeat.o(191347);
          throw paramb;
        }
      }
      else
      {
        switch (aj.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          paramb = new kotlin.p();
          AppMethodBeat.o(191347);
          throw paramb;
        case 1: 
          j = ((List)paramb.getValue()).size();
          paramb = new boolean[j];
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Boolean)paramClassLoader).booleanValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 2: 
          k = ((List)paramb.getValue()).size();
          paramb = new char[k];
          i = j;
          while (i < k)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Char");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Character)paramClassLoader).charValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 3: 
          j = ((List)paramb.getValue()).size();
          paramb = new byte[j];
          i = k;
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Byte");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Byte)paramClassLoader).byteValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 4: 
          j = ((List)paramb.getValue()).size();
          paramb = new short[j];
          i = m;
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Short");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Short)paramClassLoader).shortValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 5: 
          j = ((List)paramb.getValue()).size();
          paramb = new int[j];
          i = n;
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Integer)paramClassLoader).intValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 6: 
          j = ((List)paramb.getValue()).size();
          paramb = new float[j];
          i = i1;
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Float)paramClassLoader).floatValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        case 7: 
          j = ((List)paramb.getValue()).size();
          paramb = new long[j];
          i = i2;
          while (i < j)
          {
            paramClassLoader = ((List)localObject3).get(i);
            if (paramClassLoader == null)
            {
              paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Long");
              AppMethodBeat.o(191347);
              throw paramb;
            }
            paramb[i] = ((Long)paramClassLoader).longValue();
            i += 1;
          }
          AppMethodBeat.o(191347);
          return paramb;
        }
        j = ((List)paramb.getValue()).size();
        paramb = new double[j];
        i = i3;
        while (i < j)
        {
          paramClassLoader = ((List)localObject3).get(i);
          if (paramClassLoader == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Double");
            AppMethodBeat.o(191347);
            throw paramb;
          }
          paramb[i] = ((Double)paramClassLoader).doubleValue();
          i += 1;
        }
        AppMethodBeat.o(191347);
        return paramb;
      }
      ad localad = ((az)kotlin.a.p.oO(((ad)localObject1).klR())).koG();
      kotlin.g.b.s.s(localad, "type.arguments.single().type");
      localObject2 = localad.kzm().knA();
      localObject1 = localObject2;
      if (!(localObject2 instanceof kotlin.l.b.a.b.b.e)) {
        localObject1 = null;
      }
      localObject1 = (kotlin.l.b.a.b.b.e)localObject1;
      if (localObject1 == null)
      {
        paramb = (Throwable)new IllegalStateException("Not a class type: ".concat(String.valueOf(localad)).toString());
        AppMethodBeat.o(191347);
        throw paramb;
      }
      if (kotlin.l.b.a.b.a.h.w(localad))
      {
        j = ((List)paramb.getValue()).size();
        paramb = new String[j];
        i = i4;
        while (i < j)
        {
          paramClassLoader = ((List)localObject3).get(i);
          if (paramClassLoader == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(191347);
            throw paramb;
          }
          paramb[i] = ((String)paramClassLoader);
          i += 1;
        }
        AppMethodBeat.o(191347);
        return paramb;
      }
      if (kotlin.l.b.a.b.a.h.g((kotlin.l.b.a.b.b.e)localObject1))
      {
        j = ((List)paramb.getValue()).size();
        paramb = new Class[j];
        i = i5;
        while (i < j)
        {
          paramClassLoader = ((List)localObject3).get(i);
          if (paramClassLoader == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
            AppMethodBeat.o(191347);
            throw paramb;
          }
          paramb[i] = ((Class)paramClassLoader);
          i += 1;
        }
        AppMethodBeat.o(191347);
        return paramb;
      }
      localObject1 = kotlin.l.b.a.b.j.d.a.d((kotlin.l.b.a.b.b.h)localObject1);
      if (localObject1 != null)
      {
        paramClassLoader = a(paramClassLoader, (kotlin.l.b.a.b.f.b)localObject1, 0);
        if (paramClassLoader != null) {}
      }
      else
      {
        AppMethodBeat.o(191347);
        return null;
      }
      paramb = Array.newInstance(paramClassLoader, ((List)paramb.getValue()).size());
      if (paramb == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
        AppMethodBeat.o(191347);
        throw paramb;
      }
      paramb = (Object[])paramb;
      j = ((List)localObject3).size();
      i = 0;
      while (i < j)
      {
        paramb[i] = ((List)localObject3).get(i);
        i += 1;
      }
      AppMethodBeat.o(191347);
      return paramb;
    }
  }
  
  private static final Object a(kotlin.l.b.a.b.j.b.g<?> paramg, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(56559);
    if ((paramg instanceof kotlin.l.b.a.b.j.b.a))
    {
      paramg = a((kotlin.l.b.a.b.b.a.c)((kotlin.l.b.a.b.j.b.a)paramg).getValue());
      AppMethodBeat.o(56559);
      return paramg;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.b))
    {
      paramg = a((kotlin.l.b.a.b.j.b.b)paramg, paramClassLoader);
      AppMethodBeat.o(56559);
      return paramg;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.j))
    {
      Object localObject = (kotlin.r)((kotlin.l.b.a.b.j.b.j)paramg).getValue();
      paramg = (kotlin.l.b.a.b.f.b)((kotlin.r)localObject).bsC;
      localObject = (kotlin.l.b.a.b.f.f)((kotlin.r)localObject).bsD;
      paramg = a(paramClassLoader, paramg, 0);
      if (paramg != null)
      {
        if (paramg == null)
        {
          paramg = new NullPointerException("null cannot be cast to non-null type java.lang.Class<out kotlin.Enum<*>>");
          AppMethodBeat.o(56559);
          throw paramg;
        }
        paramg = Enum.valueOf(paramg, ((kotlin.l.b.a.b.f.f)localObject).PF());
        AppMethodBeat.o(56559);
        return paramg;
      }
      AppMethodBeat.o(56559);
      return null;
    }
    if ((paramg instanceof kotlin.l.b.a.b.j.b.q))
    {
      paramg = (q.b)((kotlin.l.b.a.b.j.b.q)paramg).getValue();
      if ((paramg instanceof q.b.b))
      {
        paramg = a(paramClassLoader, ((q.b.b)paramg).ajjT.aiEe, ((q.b.b)paramg).ajjT.ajjD);
        AppMethodBeat.o(56559);
        return paramg;
      }
      if ((paramg instanceof q.b.a))
      {
        paramClassLoader = ((q.b.a)paramg).aiAd.kzm().knA();
        paramg = paramClassLoader;
        if (!(paramClassLoader instanceof kotlin.l.b.a.b.b.e)) {
          paramg = null;
        }
        paramg = (kotlin.l.b.a.b.b.e)paramg;
        if (paramg != null)
        {
          paramg = b(paramg);
          AppMethodBeat.o(56559);
          return paramg;
        }
        AppMethodBeat.o(56559);
        return null;
      }
      paramg = new kotlin.p();
      AppMethodBeat.o(56559);
      throw paramg;
    }
    if (((paramg instanceof kotlin.l.b.a.b.j.b.k)) || ((paramg instanceof kotlin.l.b.a.b.j.b.s)))
    {
      AppMethodBeat.o(56559);
      return null;
    }
    paramg = paramg.getValue();
    AppMethodBeat.o(56559);
    return paramg;
  }
  
  private static final Annotation a(kotlin.l.b.a.b.b.a.c paramc)
  {
    AppMethodBeat.i(56558);
    Object localObject1 = kotlin.l.b.a.b.j.d.a.j(paramc);
    if (localObject1 != null)
    {
      localObject1 = b((kotlin.l.b.a.b.b.e)localObject1);
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
      paramc = (Iterable)paramc.kpA().entrySet();
      Collection localCollection = (Collection)new ArrayList();
      Iterator localIterator = paramc.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        paramc = (kotlin.l.b.a.b.f.f)((Map.Entry)localObject2).getKey();
        localObject2 = (kotlin.l.b.a.b.j.b.g)((Map.Entry)localObject2).getValue();
        ClassLoader localClassLoader = ((Class)localObject1).getClassLoader();
        kotlin.g.b.s.s(localClassLoader, "annotationClass.classLoader");
        localObject2 = a((kotlin.l.b.a.b.j.b.g)localObject2, localClassLoader);
        if (localObject2 != null) {}
        for (paramc = kotlin.v.Y(paramc.PF(), localObject2);; paramc = null)
        {
          if (paramc == null) {
            break label178;
          }
          localCollection.add(paramc);
          break;
        }
      }
      paramc = (Annotation)kotlin.l.b.a.a.b.a((Class)localObject1, ak.F((Iterable)localCollection));
      AppMethodBeat.o(56558);
      return paramc;
    }
  }
  
  public static final List<Annotation> a(kotlin.l.b.a.b.b.a.a parama)
  {
    AppMethodBeat.i(56557);
    kotlin.g.b.s.u(parama, "$this$computeAnnotations");
    parama = (Iterable)parama.knl();
    Collection localCollection = (Collection)new ArrayList();
    Iterator localIterator = parama.iterator();
    label151:
    while (localIterator.hasNext())
    {
      parama = (kotlin.l.b.a.b.b.a.c)localIterator.next();
      Object localObject = parama.knm();
      if ((localObject instanceof kotlin.l.b.a.b.b.e.a.b)) {
        parama = ((kotlin.l.b.a.b.b.e.a.b)localObject).aiMw;
      }
      for (;;)
      {
        if (parama == null) {
          break label151;
        }
        localCollection.add(parama);
        break;
        if ((localObject instanceof l.a))
        {
          localObject = ((l.a)localObject).aiMJ;
          parama = (kotlin.l.b.a.b.b.a.a)localObject;
          if (!(localObject instanceof kotlin.l.b.a.b.b.e.b.c)) {
            parama = null;
          }
          parama = (kotlin.l.b.a.b.b.e.b.c)parama;
          if (parama != null) {
            parama = parama.aiMw;
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
  
  public static final <M extends kotlin.l.b.a.b.h.r, D extends kotlin.l.b.a.b.b.a> D a(Class<?> paramClass, M paramM, kotlin.l.b.a.b.e.b.c paramc, kotlin.l.b.a.b.e.b.g paramg, kotlin.l.b.a.b.e.b.a parama, kotlin.g.a.m<? super kotlin.l.b.a.b.k.a.v, ? super M, ? extends D> paramm)
  {
    AppMethodBeat.i(56563);
    kotlin.g.b.s.u(paramClass, "moduleAnchor");
    kotlin.g.b.s.u(paramM, "proto");
    kotlin.g.b.s.u(paramc, "nameResolver");
    kotlin.g.b.s.u(paramg, "typeTable");
    kotlin.g.b.s.u(parama, "metadataVersion");
    kotlin.g.b.s.u(paramm, "createDescriptor");
    Object localObject1 = ab.cC(paramClass);
    if ((paramM instanceof a.h)) {}
    for (paramClass = ((a.h)paramM).aiYJ;; paramClass = ((a.m)paramM).aiYJ)
    {
      kotlin.l.b.a.b.k.a.j localj = ((kotlin.l.b.a.b.b.e.a.j)localObject1).aiMG;
      localObject1 = (kotlin.l.b.a.b.b.l)((kotlin.l.b.a.b.b.e.a.j)localObject1).aiMG.aiFr;
      Object localObject2 = i.ajdj;
      localObject2 = i.kwY();
      kotlin.g.b.s.s(paramClass, "typeParameters");
      paramClass = (kotlin.l.b.a.b.b.a)paramm.invoke(new kotlin.l.b.a.b.k.a.v(new kotlin.l.b.a.b.k.a.l(localj, paramc, (kotlin.l.b.a.b.b.l)localObject1, paramg, (i)localObject2, parama, null, null, paramClass)), paramM);
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
  
  public static final as a(kotlin.l.b.a.b.b.a parama)
  {
    AppMethodBeat.i(56562);
    kotlin.g.b.s.u(parama, "$this$instanceReceiverParameter");
    if (parama.knZ() != null)
    {
      parama = parama.knp();
      if (parama == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        AppMethodBeat.o(56562);
        throw parama;
      }
      parama = ((kotlin.l.b.a.b.b.e)parama).kov();
      AppMethodBeat.o(56562);
      return parama;
    }
    AppMethodBeat.o(56562);
    return null;
  }
  
  public static final Class<?> b(kotlin.l.b.a.b.b.e parame)
  {
    AppMethodBeat.i(56554);
    kotlin.g.b.s.u(parame, "$this$toJavaClass");
    Object localObject = parame.knm();
    kotlin.g.b.s.s(localObject, "source");
    if ((localObject instanceof kotlin.l.b.a.b.d.b.q))
    {
      parame = ((kotlin.l.b.a.b.d.b.q)localObject).aiXb;
      if (parame == null)
      {
        parame = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((kotlin.l.b.a.b.b.e.a.f)parame).aiMA;
      AppMethodBeat.o(56554);
      return parame;
    }
    if ((localObject instanceof l.a))
    {
      parame = ((l.a)localObject).aiMJ;
      if (parame == null)
      {
        parame = new NullPointerException("null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
        AppMethodBeat.o(56554);
        throw parame;
      }
      parame = ((kotlin.l.b.a.b.b.e.b.j)parame).aiMA;
      AppMethodBeat.o(56554);
      return parame;
    }
    localObject = kotlin.l.b.a.b.j.d.a.d((kotlin.l.b.a.b.b.h)parame);
    if (localObject == null)
    {
      AppMethodBeat.o(56554);
      return null;
    }
    parame = a(kotlin.l.b.a.b.b.e.b.b.cI(parame.getClass()), (kotlin.l.b.a.b.f.b)localObject, 0);
    AppMethodBeat.o(56554);
    return parame;
  }
  
  public static final Class<?> cE(Class<?> paramClass)
  {
    AppMethodBeat.i(191340);
    kotlin.g.b.s.u(paramClass, "$this$createArrayType");
    paramClass = Array.newInstance(paramClass, 0).getClass();
    AppMethodBeat.o(191340);
    return paramClass;
  }
  
  public static final boolean e(u paramu)
  {
    AppMethodBeat.i(191350);
    kotlin.g.b.s.u(paramu, "$this$isInlineClassType");
    if (!(paramu instanceof v)) {
      paramu = null;
    }
    for (;;)
    {
      paramu = (v)paramu;
      if (paramu != null)
      {
        paramu = paramu.aiAd;
        if ((paramu != null) && (kotlin.l.b.a.b.j.f.R(paramu) == true))
        {
          AppMethodBeat.o(191350);
          return true;
        }
      }
      AppMethodBeat.o(191350);
      return false;
    }
  }
  
  public static final k hO(Object paramObject)
  {
    AppMethodBeat.i(56560);
    if (!(paramObject instanceof k)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      k localk = (k)localObject;
      localObject = localk;
      if (localk == null)
      {
        if ((paramObject instanceof kotlin.g.b.p)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (kotlin.g.b.p)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.klo();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof k)) {
            localObject = null;
          }
          localObject = (k)localObject;
          AppMethodBeat.o(56560);
          return localObject;
        }
      }
    }
  }
  
  public static final t<?> hP(Object paramObject)
  {
    AppMethodBeat.i(56561);
    if (!(paramObject instanceof t)) {}
    for (Object localObject = null;; localObject = paramObject)
    {
      t localt = (t)localObject;
      localObject = localt;
      if (localt == null)
      {
        if ((paramObject instanceof ac)) {
          break label78;
        }
        paramObject = null;
      }
      label78:
      for (;;)
      {
        paramObject = (ac)paramObject;
        if (paramObject != null) {}
        for (paramObject = paramObject.klo();; paramObject = null)
        {
          localObject = paramObject;
          if (!(paramObject instanceof t)) {
            localObject = null;
          }
          localObject = (t)localObject;
          AppMethodBeat.o(56561);
          return localObject;
        }
      }
    }
  }
  
  public static final Object j(Type paramType)
  {
    AppMethodBeat.i(191351);
    kotlin.g.b.s.u(paramType, "type");
    if (((paramType instanceof Class)) && (((Class)paramType).isPrimitive()))
    {
      if (kotlin.g.b.s.p(paramType, Boolean.TYPE))
      {
        paramType = Boolean.FALSE;
        AppMethodBeat.o(191351);
        return paramType;
      }
      if (kotlin.g.b.s.p(paramType, Character.TYPE))
      {
        AppMethodBeat.o(191351);
        return Character.valueOf('\000');
      }
      if (kotlin.g.b.s.p(paramType, Byte.TYPE))
      {
        AppMethodBeat.o(191351);
        return Byte.valueOf((byte)0);
      }
      if (kotlin.g.b.s.p(paramType, Short.TYPE))
      {
        AppMethodBeat.o(191351);
        return Short.valueOf((short)0);
      }
      if (kotlin.g.b.s.p(paramType, Integer.TYPE))
      {
        AppMethodBeat.o(191351);
        return Integer.valueOf(0);
      }
      if (kotlin.g.b.s.p(paramType, Float.TYPE))
      {
        AppMethodBeat.o(191351);
        return Float.valueOf(0.0F);
      }
      if (kotlin.g.b.s.p(paramType, Long.TYPE))
      {
        AppMethodBeat.o(191351);
        return Long.valueOf(0L);
      }
      if (kotlin.g.b.s.p(paramType, Double.TYPE))
      {
        AppMethodBeat.o(191351);
        return Double.valueOf(0.0D);
      }
      if (kotlin.g.b.s.p(paramType, Void.TYPE))
      {
        paramType = (Throwable)new IllegalStateException("Parameter with void type is illegal");
        AppMethodBeat.o(191351);
        throw paramType;
      }
      paramType = (Throwable)new UnsupportedOperationException("Unknown primitive: ".concat(String.valueOf(paramType)));
      AppMethodBeat.o(191351);
      throw paramType;
    }
    AppMethodBeat.o(191351);
    return null;
  }
  
  public static final kotlin.l.b.a.b.f.c kmx()
  {
    return aiAx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.ai
 * JD-Core Version:    0.7.0.1
 */