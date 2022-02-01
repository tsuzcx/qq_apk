package d.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l.b.a.ae;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ak;
import d.l.b.a.b.b.av;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.b;
import d.l.b.a.b.b.k;
import d.l.b.a.b.m.ab;
import d.l.b.a.b.m.at;
import d.l.b.a.w;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"})
public final class h
{
  public static final <M extends Member> d<M> a(d<? extends M> paramd, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(56632);
    p.h(paramd, "$this$createInlineClassAwareCallerIfNeeded");
    p.h(paramb, "descriptor");
    if (!d.l.b.a.b.j.e.f((d.l.b.a.b.b.a)paramb))
    {
      Object localObject1 = paramb.gmU();
      p.g(localObject1, "descriptor.valueParameters");
      localObject1 = (Iterable)localObject1;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label220;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (av)((Iterator)localObject1).next();
          p.g(localObject2, "it");
          localObject2 = ((av)localObject2).gnW();
          p.g(localObject2, "it.type");
          if (d.l.b.a.b.j.e.ab((ab)localObject2))
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = paramb.gmS();
              if ((localObject1 == null) || (d.l.b.a.b.j.e.ab((ab)localObject1) != true))
              {
                if ((paramd instanceof c)) {
                  break label230;
                }
                localObject1 = c(paramb);
                if ((localObject1 == null) || (d.l.b.a.b.j.e.ab((ab)localObject1) != true)) {
                  break label225;
                }
                i = 1;
                label189:
                if (i == 0) {
                  break label230;
                }
              }
            }
          }
        }
      }
    }
    label220:
    label225:
    label230:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label235;
      }
      paramd = (d)new g(paramb, paramd, paramBoolean);
      AppMethodBeat.o(56632);
      return paramd;
      i = 0;
      break;
      i = 0;
      break label189;
    }
    label235:
    AppMethodBeat.o(56632);
    return paramd;
  }
  
  public static final Class<?> a(d.l.b.a.b.b.l paraml)
  {
    AppMethodBeat.i(56637);
    Class localClass1;
    if (((paraml instanceof d.l.b.a.b.b.e)) && (((d.l.b.a.b.b.e)paraml).gmf()))
    {
      Class localClass2 = ae.a((d.l.b.a.b.b.e)paraml);
      localClass1 = localClass2;
      if (localClass2 == null)
      {
        paraml = (Throwable)new w("Class object for the class " + ((d.l.b.a.b.b.e)paraml).gnf() + " cannot be found (classId=" + d.l.b.a.b.j.d.a.c((d.l.b.a.b.b.h)paraml) + ')');
        AppMethodBeat.o(56637);
        throw paraml;
      }
    }
    else
    {
      localClass1 = null;
    }
    AppMethodBeat.o(56637);
    return localClass1;
  }
  
  public static final Object a(Object paramObject, b paramb)
  {
    AppMethodBeat.i(56639);
    p.h(paramb, "descriptor");
    if (((paramb instanceof ah)) && (d.l.b.a.b.j.e.a((ax)paramb)))
    {
      AppMethodBeat.o(56639);
      return paramObject;
    }
    Object localObject = c(paramb);
    if (localObject != null)
    {
      localObject = c((ab)localObject);
      if (localObject != null)
      {
        paramb = a((Class)localObject, paramb);
        if (paramb != null) {
          break label70;
        }
      }
    }
    AppMethodBeat.o(56639);
    return paramObject;
    label70:
    paramObject = paramb.invoke(paramObject, new Object[0]);
    AppMethodBeat.o(56639);
    return paramObject;
  }
  
  public static final Method a(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56634);
    p.h(paramClass, "$this$getUnboxMethod");
    p.h(paramb, "descriptor");
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("unbox-impl", new Class[0]);
      p.g(localMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
      AppMethodBeat.o(56634);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new w("No unbox method found in inline class: " + paramClass + " (calling " + paramb + ')');
      AppMethodBeat.o(56634);
      throw paramClass;
    }
  }
  
  public static final Method b(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56635);
    p.h(paramClass, "$this$getBoxMethod");
    p.h(paramb, "descriptor");
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("box-impl", new Class[] { a(paramClass, paramb).getReturnType() });
      p.g(localMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
      AppMethodBeat.o(56635);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new w("No box method found in inline class: " + paramClass + " (calling " + paramb + ')');
      AppMethodBeat.o(56635);
      throw paramClass;
    }
  }
  
  private static final ab c(b paramb)
  {
    AppMethodBeat.i(56638);
    Object localObject = paramb.gmP();
    ak localak = paramb.gmQ();
    if (localObject != null)
    {
      paramb = ((ak)localObject).gnW();
      AppMethodBeat.o(56638);
      return paramb;
    }
    if (localak == null)
    {
      AppMethodBeat.o(56638);
      return null;
    }
    if ((paramb instanceof k))
    {
      paramb = localak.gnW();
      AppMethodBeat.o(56638);
      return paramb;
    }
    localObject = paramb.glU();
    paramb = (b)localObject;
    if (!(localObject instanceof d.l.b.a.b.b.e)) {
      paramb = null;
    }
    paramb = (d.l.b.a.b.b.e)paramb;
    if (paramb != null) {}
    for (paramb = paramb.gne();; paramb = null)
    {
      paramb = (ab)paramb;
      AppMethodBeat.o(56638);
      return paramb;
    }
  }
  
  public static final Class<?> c(ab paramab)
  {
    AppMethodBeat.i(56636);
    p.h(paramab, "$this$toInlineClass");
    paramab = a((d.l.b.a.b.b.l)paramab.gxB().gmq());
    AppMethodBeat.o(56636);
    return paramab;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */