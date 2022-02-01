package kotlin.l.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.l.b.a.aa;
import kotlin.l.b.a.ai;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.as;
import kotlin.l.b.a.b.b.b;
import kotlin.l.b.a.b.b.bd;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.b.e;
import kotlin.l.b.a.b.b.k;
import kotlin.l.b.a.b.b.l;
import kotlin.l.b.a.b.j.f;
import kotlin.l.b.a.b.m.ad;
import kotlin.l.b.a.b.m.ax;

@Metadata(d1={""}, d2={"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class h
{
  public static final Class<?> a(l paraml)
  {
    AppMethodBeat.i(56637);
    Class localClass1;
    if (((paraml instanceof e)) && (f.D(paraml)))
    {
      Class localClass2 = ai.b((e)paraml);
      localClass1 = localClass2;
      if (localClass2 == null)
      {
        paraml = (Throwable)new aa("Class object for the class " + ((e)paraml).kok() + " cannot be found (classId=" + kotlin.l.b.a.b.j.d.a.d((kotlin.l.b.a.b.b.h)paraml) + ')');
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
    s.u(paramb, "descriptor");
    if (((paramb instanceof ap)) && (f.a((bf)paramb)))
    {
      AppMethodBeat.o(56639);
      return paramObject;
    }
    Object localObject = c(paramb);
    if (localObject != null)
    {
      localObject = c((ad)localObject);
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
    s.u(paramClass, "$this$getUnboxMethod");
    s.u(paramb, "descriptor");
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("unbox-impl", new Class[0]);
      s.s(localMethod, "getDeclaredMethod(\"unbox…FOR_INLINE_CLASS_MEMBERS)");
      AppMethodBeat.o(56634);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new aa("No unbox method found in inline class: " + paramClass + " (calling " + paramb + ')');
      AppMethodBeat.o(56634);
      throw paramClass;
    }
  }
  
  public static final <M extends Member> d<M> a(d<? extends M> paramd, b paramb, boolean paramBoolean)
  {
    AppMethodBeat.i(56632);
    s.u(paramd, "$this$createInlineClassAwareCallerIfNeeded");
    s.u(paramb, "descriptor");
    if (!f.f((kotlin.l.b.a.b.b.a)paramb))
    {
      Object localObject1 = paramb.kod();
      s.s(localObject1, "descriptor.valueParameters");
      localObject1 = (Iterable)localObject1;
      if (((localObject1 instanceof Collection)) && (((Collection)localObject1).isEmpty())) {
        break label220;
      }
      localObject1 = ((Iterable)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (bd)((Iterator)localObject1).next();
          s.s(localObject2, "it");
          localObject2 = ((bd)localObject2).koG();
          s.s(localObject2, "it.type");
          if (f.R((ad)localObject2))
          {
            i = 1;
            if (i == 0)
            {
              localObject1 = paramb.kob();
              if ((localObject1 == null) || (f.R((ad)localObject1) != true))
              {
                if ((paramd instanceof c)) {
                  break label230;
                }
                localObject1 = c(paramb);
                if ((localObject1 == null) || (f.R((ad)localObject1) != true)) {
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
  
  public static final Method b(Class<?> paramClass, b paramb)
  {
    AppMethodBeat.i(56635);
    s.u(paramClass, "$this$getBoxMethod");
    s.u(paramb, "descriptor");
    try
    {
      Method localMethod = paramClass.getDeclaredMethod("box-impl", new Class[] { a(paramClass, paramb).getReturnType() });
      s.s(localMethod, "getDeclaredMethod(\"box\" …d(descriptor).returnType)");
      AppMethodBeat.o(56635);
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      paramClass = (Throwable)new aa("No box method found in inline class: " + paramClass + " (calling " + paramb + ')');
      AppMethodBeat.o(56635);
      throw paramClass;
    }
  }
  
  public static final Class<?> c(ad paramad)
  {
    AppMethodBeat.i(56636);
    s.u(paramad, "$this$toInlineClass");
    paramad = a((l)paramad.kzm().knA());
    AppMethodBeat.o(56636);
    return paramad;
  }
  
  private static final ad c(b paramb)
  {
    AppMethodBeat.i(56638);
    Object localObject = paramb.knY();
    as localas = paramb.knZ();
    if (localObject != null)
    {
      paramb = ((as)localObject).koG();
      AppMethodBeat.o(56638);
      return paramb;
    }
    if (localas == null)
    {
      AppMethodBeat.o(56638);
      return null;
    }
    if ((paramb instanceof k))
    {
      paramb = localas.koG();
      AppMethodBeat.o(56638);
      return paramb;
    }
    localObject = paramb.knp();
    paramb = (b)localObject;
    if (!(localObject instanceof e)) {
      paramb = null;
    }
    paramb = (e)paramb;
    if (paramb != null) {}
    for (paramb = paramb.koj();; paramb = null)
    {
      paramb = (ad)paramb;
      AppMethodBeat.o(56638);
      return paramb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.a.h
 * JD-Core Version:    0.7.0.1
 */