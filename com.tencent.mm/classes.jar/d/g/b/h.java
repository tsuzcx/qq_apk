package d.g.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.a.ae;
import d.g.a.d;
import d.g.a.f;
import d.g.a.i;
import d.g.a.k;
import d.g.a.m;
import d.g.a.q;
import d.g.a.r;
import d.g.a.s;
import d.g.a.t;
import d.g.a.v;
import d.g.a.w;
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

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "sealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "supertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "typeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "visibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"})
public final class h
  implements g, d.l.b<Object>
{
  private static final Map<Class<? extends d.c<?>>, Integer> MLF;
  private static final HashMap<String, String> MLG;
  private static final HashMap<String, String> MLH;
  private static final HashMap<String, String> MLI;
  private static final Map<String, String> MLJ;
  public static final a MLK;
  private final Class<?> MLE;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(199626);
    MLK = new a((byte)0);
    Object localObject2 = (Iterable)d.a.j.listOf(new Class[] { d.g.a.a.class, d.g.a.b.class, m.class, q.class, r.class, s.class, t.class, d.g.a.u.class, v.class, w.class, d.g.a.c.class, d.class, d.g.a.e.class, f.class, d.g.a.g.class, d.g.a.h.class, i.class, d.g.a.j.class, k.class, d.g.a.l.class, d.g.a.n.class, d.g.a.o.class, d.g.a.p.class });
    Object localObject1 = (Collection)new ArrayList(d.a.j.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        d.a.j.gfB();
      }
      ((Collection)localObject1).add(d.u.S((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    MLF = ae.A((Iterable)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    MLG = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject1).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject1).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject1).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject1).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject1).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject1).put("java.lang.Double", "kotlin.Double");
    MLH = (HashMap)localObject1;
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
    ((HashMap)localObject1).putAll((Map)MLG);
    ((HashMap)localObject1).putAll((Map)MLH);
    localObject2 = MLG.values();
    p.g(localObject2, "primitiveFqNames.values");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Map)localObject1;
      localObject4 = (String)localObject4;
      StringBuilder localStringBuilder = new StringBuilder("kotlin.jvm.internal.");
      p.g(localObject4, "kotlinName");
      localObject4 = d.u.S(d.n.n.b((String)localObject4, '.') + "CompanionObject", (String)localObject4 + ".Companion");
      ((Map)localObject3).put(((d.o)localObject4).first, ((d.o)localObject4).second);
    }
    localObject2 = MLF.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (Class)((Map.Entry)localObject3).getKey();
      i = ((Number)((Map.Entry)localObject3).getValue()).intValue();
      ((HashMap)localObject1).put(((Class)localObject4).getName(), "kotlin.Function".concat(String.valueOf(i)));
    }
    MLI = (HashMap)localObject1;
    localObject2 = (Map)localObject1;
    localObject1 = (Map)new LinkedHashMap(ae.aji(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), d.n.n.b((String)((Map.Entry)localObject3).getValue(), '.'));
    }
    MLJ = (Map)localObject1;
    AppMethodBeat.o(199626);
  }
  
  public h(Class<?> paramClass)
  {
    AppMethodBeat.i(129340);
    this.MLE = paramClass;
    AppMethodBeat.o(129340);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129337);
    if (((paramObject instanceof h)) && (p.i(d.g.a.c(this), d.g.a.c((d.l.b)paramObject))))
    {
      AppMethodBeat.o(129337);
      return true;
    }
    AppMethodBeat.o(129337);
    return false;
  }
  
  public final String getSimpleName()
  {
    AppMethodBeat.i(199624);
    Class localClass = this.MLE;
    p.h(localClass, "jClass");
    if (localClass.isAnonymousClass())
    {
      AppMethodBeat.o(199624);
      return null;
    }
    if (localClass.isLocalClass())
    {
      String str = localClass.getSimpleName();
      localObject1 = localClass.getEnclosingMethod();
      if (localObject1 != null)
      {
        p.g(str, "name");
        localObject1 = d.n.n.nD(str, ((Method)localObject1).getName() + "$");
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = localClass.getEnclosingConstructor();
        if (localObject1 == null) {
          break label173;
        }
        p.g(str, "name");
      }
      label173:
      for (localObject2 = d.n.n.nD(str, ((Constructor)localObject1).getName() + "$");; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        p.g(str, "name");
        localObject1 = d.n.n.nC(str, str);
        AppMethodBeat.o(199624);
        return localObject1;
      }
    }
    if (localClass.isArray())
    {
      localObject1 = localClass.getComponentType();
      p.g(localObject1, "componentType");
      if (((Class)localObject1).isPrimitive())
      {
        localObject1 = (String)MLJ.get(((Class)localObject1).getName());
        if (localObject1 == null) {}
      }
      for (localObject2 = (String)localObject1 + "Array";; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        AppMethodBeat.o(199624);
        return "Array";
      }
    }
    Object localObject2 = (String)MLJ.get(localClass.getName());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localClass.getSimpleName();
    }
    AppMethodBeat.o(199624);
    return localObject1;
  }
  
  public final Class<?> gfT()
  {
    return this.MLE;
  }
  
  public final String gfU()
  {
    AppMethodBeat.i(129336);
    Class localClass = this.MLE;
    p.h(localClass, "jClass");
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
      p.g(localObject, "componentType");
      if (((Class)localObject).isPrimitive())
      {
        localObject = (String)MLI.get(((Class)localObject).getName());
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
    String str = (String)MLI.get(localClass.getName());
    Object localObject = str;
    if (str == null) {
      localObject = localClass.getCanonicalName();
    }
    AppMethodBeat.o(129336);
    return localObject;
  }
  
  public final Collection<d.l.e<Object>> gfV()
  {
    AppMethodBeat.i(199625);
    Throwable localThrowable = (Throwable)new d.g.b();
    AppMethodBeat.o(199625);
    throw localThrowable;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(129338);
    int i = d.g.a.c(this).hashCode();
    AppMethodBeat.o(129338);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129339);
    String str = this.MLE.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(129339);
    return str;
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     d.g.b.h
 * JD-Core Version:    0.7.0.1
 */