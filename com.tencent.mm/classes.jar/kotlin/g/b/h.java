package kotlin.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.a.ae;
import kotlin.g.a.d;
import kotlin.g.a.f;
import kotlin.g.a.i;
import kotlin.g.a.k;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.a.r;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.v;
import kotlin.g.a.w;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"})
public final class h
  implements g, kotlin.l.b<Object>
{
  private static final Map<Class<? extends kotlin.c<?>>, Integer> aaBc;
  private static final HashMap<String, String> aaBd;
  private static final HashMap<String, String> aaBe;
  private static final HashMap<String, String> aaBf;
  private static final Map<String, String> aaBg;
  public static final h.a aaBh;
  private final Class<?> aaBb;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(217071);
    aaBh = new h.a((byte)0);
    Object localObject2 = (Iterable)kotlin.a.j.listOf(new Class[] { kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, r.class, kotlin.g.a.s.class, t.class, u.class, v.class, w.class, kotlin.g.a.c.class, d.class, kotlin.g.a.e.class, f.class, kotlin.g.a.g.class, kotlin.g.a.h.class, i.class, kotlin.g.a.j.class, k.class, kotlin.g.a.l.class, kotlin.g.a.n.class, kotlin.g.a.o.class, kotlin.g.a.p.class });
    Object localObject1 = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.j.iBO();
      }
      ((Collection)localObject1).add(kotlin.s.M((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    aaBc = ae.E((Iterable)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    aaBd = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject1).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject1).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject1).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject1).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject1).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject1).put("java.lang.Double", "kotlin.Double");
    aaBe = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Object", "kotlin.Any");
    ((HashMap)localObject1).put("java.lang.String", "kotlin.String");
    ((HashMap)localObject1).put("java.lang.CharSequence", "kotlin.CharSequence");
    ((HashMap)localObject1).put("java.lang.Throwable", "kotlin.Throwable");
    ((HashMap)localObject1).put("java.lang.Cloneable", "kotlin.Cloneable");
    ((HashMap)localObject1).put("java.lang.Number", "kotlin.Number");
    ((HashMap)localObject1).put("java.lang.Comparable", "kotlin.Comparable");
    ((HashMap)localObject1).put("java.lang.Enum", "kotlin.Enum");
    ((HashMap)localObject1).put("java.lang.annotation.Annotation", "kotlin.Annotation");
    ((HashMap)localObject1).put("java.lang.Iterable", "kotlin.collections.Iterable");
    ((HashMap)localObject1).put("java.util.Iterator", "kotlin.collections.Iterator");
    ((HashMap)localObject1).put("java.util.Collection", "kotlin.collections.Collection");
    ((HashMap)localObject1).put("java.util.List", "kotlin.collections.List");
    ((HashMap)localObject1).put("java.util.Set", "kotlin.collections.Set");
    ((HashMap)localObject1).put("java.util.ListIterator", "kotlin.collections.ListIterator");
    ((HashMap)localObject1).put("java.util.Map", "kotlin.collections.Map");
    ((HashMap)localObject1).put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
    ((HashMap)localObject1).put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
    ((HashMap)localObject1).put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
    ((HashMap)localObject1).putAll((Map)aaBd);
    ((HashMap)localObject1).putAll((Map)aaBe);
    localObject2 = aaBd.values();
    p.j(localObject2, "primitiveFqNames.values");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Map)localObject1;
      localObject4 = (String)localObject4;
      StringBuilder localStringBuilder = new StringBuilder("kotlin.jvm.internal.");
      p.j(localObject4, "kotlinName");
      localObject4 = kotlin.s.M(kotlin.n.n.b((String)localObject4, '.') + "CompanionObject", (String)localObject4 + ".Companion");
      ((Map)localObject3).put(((kotlin.o)localObject4).Mx, ((kotlin.o)localObject4).My);
    }
    localObject2 = aaBc.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (Class)((Map.Entry)localObject3).getKey();
      i = ((Number)((Map.Entry)localObject3).getValue()).intValue();
      ((HashMap)localObject1).put(((Class)localObject4).getName(), "kotlin.Function".concat(String.valueOf(i)));
    }
    aaBf = (HashMap)localObject1;
    localObject2 = (Map)localObject1;
    localObject1 = (Map)new LinkedHashMap(ae.aDD(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), kotlin.n.n.b((String)((Map.Entry)localObject3).getValue(), '.'));
    }
    aaBg = (Map)localObject1;
    AppMethodBeat.o(217071);
  }
  
  public h(Class<?> paramClass)
  {
    AppMethodBeat.i(129340);
    this.aaBb = paramClass;
    AppMethodBeat.o(129340);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129337);
    if (((paramObject instanceof h)) && (p.h(kotlin.g.a.c(this), kotlin.g.a.c((kotlin.l.b)paramObject))))
    {
      AppMethodBeat.o(129337);
      return true;
    }
    AppMethodBeat.o(129337);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129338);
    int i = kotlin.g.a.c(this).hashCode();
    AppMethodBeat.o(129338);
    return i;
  }
  
  public final Class<?> iCd()
  {
    return this.aaBb;
  }
  
  public final String iCe()
  {
    AppMethodBeat.i(217063);
    Class localClass = this.aaBb;
    p.k(localClass, "jClass");
    if (localClass.isAnonymousClass())
    {
      AppMethodBeat.o(217063);
      return null;
    }
    if (localClass.isLocalClass())
    {
      String str = localClass.getSimpleName();
      localObject1 = localClass.getEnclosingMethod();
      if (localObject1 != null)
      {
        p.j(str, "name");
        localObject1 = kotlin.n.n.px(str, ((Method)localObject1).getName() + "$");
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = localClass.getEnclosingConstructor();
        if (localObject1 == null) {
          break label173;
        }
        p.j(str, "name");
      }
      label173:
      for (localObject2 = kotlin.n.n.px(str, ((Constructor)localObject1).getName() + "$");; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        p.j(str, "name");
        localObject1 = kotlin.n.n.pw(str, str);
        AppMethodBeat.o(217063);
        return localObject1;
      }
    }
    if (localClass.isArray())
    {
      localObject1 = localClass.getComponentType();
      p.j(localObject1, "componentType");
      if (((Class)localObject1).isPrimitive())
      {
        localObject1 = (String)aaBg.get(((Class)localObject1).getName());
        if (localObject1 == null) {}
      }
      for (localObject2 = (String)localObject1 + "Array";; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        AppMethodBeat.o(217063);
        return "Array";
      }
    }
    Object localObject2 = (String)aaBg.get(localClass.getName());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localClass.getSimpleName();
    }
    AppMethodBeat.o(217063);
    return localObject1;
  }
  
  public final String iCf()
  {
    AppMethodBeat.i(129336);
    Class localClass = this.aaBb;
    p.k(localClass, "jClass");
    if (localClass.isAnonymousClass())
    {
      AppMethodBeat.o(129336);
      return null;
    }
    if (localClass.isLocalClass())
    {
      AppMethodBeat.o(129336);
      return null;
    }
    if (localClass.isArray())
    {
      localObject = localClass.getComponentType();
      p.j(localObject, "componentType");
      if (((Class)localObject).isPrimitive())
      {
        localObject = (String)aaBf.get(((Class)localObject).getName());
        if (localObject == null) {}
      }
      for (str = (String)localObject + "Array";; str = null)
      {
        localObject = str;
        if (str != null) {
          break;
        }
        AppMethodBeat.o(129336);
        return "kotlin.Array";
      }
    }
    String str = (String)aaBf.get(localClass.getName());
    Object localObject = str;
    if (str == null) {
      localObject = localClass.getCanonicalName();
    }
    AppMethodBeat.o(129336);
    return localObject;
  }
  
  public final Collection<kotlin.l.e<Object>> iCg()
  {
    AppMethodBeat.i(217066);
    Throwable localThrowable = (Throwable)new kotlin.g.b();
    AppMethodBeat.o(217066);
    throw localThrowable;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129339);
    String str = this.aaBb.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(129339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.g.b.h
 * JD-Core Version:    0.7.0.1
 */