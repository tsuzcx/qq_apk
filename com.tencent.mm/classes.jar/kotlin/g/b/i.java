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
import kotlin.Metadata;
import kotlin.a.ak;
import kotlin.g.a.e;
import kotlin.g.a.g;
import kotlin.g.a.j;
import kotlin.g.a.k;
import kotlin.g.a.l;
import kotlin.g.a.m;
import kotlin.g.a.o;
import kotlin.g.a.q;
import kotlin.g.a.t;
import kotlin.g.a.u;
import kotlin.g.a.w;

@Metadata(d1={""}, d2={"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public final class i
  implements h, kotlin.l.c<Object>
{
  private static final Map<Class<? extends kotlin.d<?>>, Integer> aiwO;
  private static final HashMap<String, String> aiwP;
  private static final HashMap<String, String> aiwQ;
  private static final HashMap<String, String> aiwR;
  private static final Map<String, String> aiwS;
  public static final i.a aiwT;
  private final Class<?> aiwN;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(190967);
    aiwT = new i.a((byte)0);
    Object localObject2 = (Iterable)kotlin.a.p.listOf(new Class[] { kotlin.g.a.a.class, kotlin.g.a.b.class, m.class, q.class, kotlin.g.a.r.class, kotlin.g.a.s.class, t.class, u.class, kotlin.g.a.v.class, w.class, kotlin.g.a.c.class, kotlin.g.a.d.class, e.class, kotlin.g.a.f.class, g.class, kotlin.g.a.h.class, kotlin.g.a.i.class, j.class, k.class, l.class, kotlin.g.a.n.class, o.class, kotlin.g.a.p.class });
    Object localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      ((Collection)localObject1).add(kotlin.v.Y((Class)localObject3, Integer.valueOf(i)));
      i += 1;
    }
    aiwO = ak.F((Iterable)localObject1);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("char", "kotlin.Char");
    ((HashMap)localObject1).put("byte", "kotlin.Byte");
    ((HashMap)localObject1).put("short", "kotlin.Short");
    ((HashMap)localObject1).put("int", "kotlin.Int");
    ((HashMap)localObject1).put("float", "kotlin.Float");
    ((HashMap)localObject1).put("long", "kotlin.Long");
    ((HashMap)localObject1).put("double", "kotlin.Double");
    aiwP = (HashMap)localObject1;
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("java.lang.Boolean", "kotlin.Boolean");
    ((HashMap)localObject1).put("java.lang.Character", "kotlin.Char");
    ((HashMap)localObject1).put("java.lang.Byte", "kotlin.Byte");
    ((HashMap)localObject1).put("java.lang.Short", "kotlin.Short");
    ((HashMap)localObject1).put("java.lang.Integer", "kotlin.Int");
    ((HashMap)localObject1).put("java.lang.Float", "kotlin.Float");
    ((HashMap)localObject1).put("java.lang.Long", "kotlin.Long");
    ((HashMap)localObject1).put("java.lang.Double", "kotlin.Double");
    aiwQ = (HashMap)localObject1;
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
    ((HashMap)localObject1).putAll((Map)aiwP);
    ((HashMap)localObject1).putAll((Map)aiwQ);
    localObject2 = aiwP.values();
    s.s(localObject2, "primitiveFqNames.values");
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = ((Iterator)localObject2).next();
      localObject3 = (Map)localObject1;
      localObject4 = (String)localObject4;
      StringBuilder localStringBuilder = new StringBuilder("kotlin.jvm.internal.");
      s.s(localObject4, "kotlinName");
      localObject4 = kotlin.v.Y(kotlin.n.n.c((String)localObject4, '.') + "CompanionObject", (String)localObject4 + ".Companion");
      ((Map)localObject3).put(((kotlin.r)localObject4).bsC, ((kotlin.r)localObject4).bsD);
    }
    localObject2 = aiwO.entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = (Class)((Map.Entry)localObject3).getKey();
      i = ((Number)((Map.Entry)localObject3).getValue()).intValue();
      ((HashMap)localObject1).put(((Class)localObject4).getName(), "kotlin.Function".concat(String.valueOf(i)));
    }
    aiwR = (HashMap)localObject1;
    localObject2 = (Map)localObject1;
    localObject1 = (Map)new LinkedHashMap(ak.aKi(((Map)localObject2).size()));
    localObject2 = ((Iterable)((Map)localObject2).entrySet()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      ((Map)localObject1).put(((Map.Entry)localObject3).getKey(), kotlin.n.n.c((String)((Map.Entry)localObject3).getValue(), '.'));
    }
    aiwS = (Map)localObject1;
    AppMethodBeat.o(190967);
  }
  
  public i(Class<?> paramClass)
  {
    AppMethodBeat.i(129340);
    this.aiwN = paramClass;
    AppMethodBeat.o(129340);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(129337);
    if (((paramObject instanceof i)) && (s.p(kotlin.g.a.d(this), kotlin.g.a.d((kotlin.l.c)paramObject))))
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
    int i = kotlin.g.a.d(this).hashCode();
    AppMethodBeat.o(129338);
    return i;
  }
  
  public final Class<?> kls()
  {
    return this.aiwN;
  }
  
  public final String klt()
  {
    AppMethodBeat.i(190970);
    Class localClass = this.aiwN;
    s.u(localClass, "jClass");
    if (localClass.isAnonymousClass())
    {
      AppMethodBeat.o(190970);
      return null;
    }
    if (localClass.isLocalClass())
    {
      String str = localClass.getSimpleName();
      localObject1 = localClass.getEnclosingMethod();
      if (localObject1 != null)
      {
        s.s(str, "name");
        localObject1 = kotlin.n.n.rv(str, ((Method)localObject1).getName() + "$");
        localObject2 = localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = localClass.getEnclosingConstructor();
        if (localObject1 == null) {
          break label173;
        }
        s.s(str, "name");
      }
      label173:
      for (localObject2 = kotlin.n.n.rv(str, ((Constructor)localObject1).getName() + "$");; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        s.s(str, "name");
        localObject1 = kotlin.n.n.ru(str, str);
        AppMethodBeat.o(190970);
        return localObject1;
      }
    }
    if (localClass.isArray())
    {
      localObject1 = localClass.getComponentType();
      s.s(localObject1, "componentType");
      if (((Class)localObject1).isPrimitive())
      {
        localObject1 = (String)aiwS.get(((Class)localObject1).getName());
        if (localObject1 == null) {}
      }
      for (localObject2 = (String)localObject1 + "Array";; localObject2 = null)
      {
        localObject1 = localObject2;
        if (localObject2 != null) {
          break;
        }
        AppMethodBeat.o(190970);
        return "Array";
      }
    }
    Object localObject2 = (String)aiwS.get(localClass.getName());
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = localClass.getSimpleName();
    }
    AppMethodBeat.o(190970);
    return localObject1;
  }
  
  public final String klu()
  {
    AppMethodBeat.i(129336);
    Class localClass = this.aiwN;
    s.u(localClass, "jClass");
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
      s.s(localObject, "componentType");
      if (((Class)localObject).isPrimitive())
      {
        localObject = (String)aiwR.get(((Class)localObject).getName());
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
    String str = (String)aiwR.get(localClass.getName());
    Object localObject = str;
    if (str == null) {
      localObject = localClass.getCanonicalName();
    }
    AppMethodBeat.o(129336);
    return localObject;
  }
  
  public final Collection<kotlin.l.f<Object>> klv()
  {
    AppMethodBeat.i(190982);
    Throwable localThrowable = (Throwable)new kotlin.g.b();
    AppMethodBeat.o(190982);
    throw localThrowable;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(129339);
    String str = this.aiwN.toString() + " (Kotlin reflection is not available)";
    AppMethodBeat.o(129339);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.g.b.i
 * JD-Core Version:    0.7.0.1
 */