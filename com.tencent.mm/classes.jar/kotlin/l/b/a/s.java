package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.l.b.a.a.e.f;
import kotlin.l.b.a.a.e.f.a;
import kotlin.l.b.a.a.e.f.b;
import kotlin.l.b.a.a.e.f.c;
import kotlin.l.b.a.a.e.f.d;
import kotlin.l.b.a.a.e.f.e;
import kotlin.l.b.a.a.e.g;
import kotlin.l.b.a.a.e.g.a;
import kotlin.l.b.a.a.e.g.b;
import kotlin.l.b.a.a.e.g.c;
import kotlin.l.b.a.a.e.g.d;
import kotlin.l.b.a.a.e.g.e;
import kotlin.l.b.a.a.e.h;
import kotlin.l.b.a.a.e.h.a;
import kotlin.l.b.a.a.e.h.b;
import kotlin.l.b.a.a.e.h.c;
import kotlin.l.b.a.a.e.h.d;
import kotlin.l.b.a.a.e.h.e;
import kotlin.l.b.a.a.e.h.f;
import kotlin.l.b.a.a.h;
import kotlin.l.b.a.a.i.a;
import kotlin.l.b.a.a.i.b;
import kotlin.l.b.a.a.j;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ah;
import kotlin.l.b.a.b.b.ax;
import kotlin.l.b.a.b.b.az;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.e.b;
import kotlin.l.b.a.b.m.bc;
import kotlin.m;
import kotlin.n.k;
import kotlin.z;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class s
{
  public static final Object a(r.a<?, ?> parama)
  {
    AppMethodBeat.i(56486);
    p.k(parama, "$this$boundReceiver");
    parama = parama.iCQ().iBY();
    AppMethodBeat.o(56486);
    return parama;
  }
  
  static final kotlin.l.b.a.a.d<?> a(r.a<?, ?> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(56487);
    Object localObject1 = i.aaDq;
    if (i.iCO().aY((CharSequence)parama.iCQ().signature))
    {
      parama = (kotlin.l.b.a.a.d)j.aaFn;
      AppMethodBeat.o(56487);
      return parama;
    }
    final a locala = new a(parama);
    Object localObject2 = new c(parama, paramBoolean, new b(parama), locala);
    localObject1 = ac.aaED;
    d locald = ac.c(parama.iCQ().iCZ());
    if ((locald instanceof d.c))
    {
      localObject1 = ((d.c)locald).aaCA;
      if (paramBoolean) {
        if (((a.c)localObject1).iMU())
        {
          localObject1 = ((a.c)localObject1).abeQ;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = parama.iCQ().aaDC.pm(((d.c)locald).aaCB.getString(((a.b)localObject1).abbb), ((d.c)locald).aaCB.getString(((a.b)localObject1).abeL));
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          if ((kotlin.l.b.a.b.j.e.a((ax)parama.iCQ().iCZ())) && (p.h(parama.iCQ().iCZ().iDQ(), az.aaKN)))
          {
            localObject1 = h.a(parama.iCQ().iCZ().iDJ());
            if (localObject1 != null)
            {
              localObject1 = h.a((Class)localObject1, (kotlin.l.b.a.b.b.b)parama.iCQ().iCZ());
              if (localObject1 != null) {}
            }
            else
            {
              parama = (Throwable)new w("Underlying property of inline class " + parama.iCQ() + " should have a field");
              AppMethodBeat.o(56487);
              throw parama;
              localObject1 = null;
              break;
              if (((a.c)localObject1).iMV())
              {
                localObject1 = ((a.c)localObject1).abeR;
                break;
              }
              localObject1 = null;
              break;
              label318:
              localObject1 = null;
              continue;
            }
            if (parama.iCQ().isBound())
            {
              localObject1 = (kotlin.l.b.a.a.i)new i.a((Method)localObject1, a(parama));
              localObject1 = (kotlin.l.b.a.a.d)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      parama = h.a((kotlin.l.b.a.a.d)localObject1, (kotlin.l.b.a.b.b.b)parama.iDa());
      AppMethodBeat.o(56487);
      return parama;
      localObject1 = (kotlin.l.b.a.a.i)new i.b((Method)localObject1);
      break;
      localObject1 = parama.iCQ().iCX();
      if (localObject1 == null)
      {
        parama = (Throwable)new w("No accessors or field is found for property " + parama.iCQ());
        AppMethodBeat.o(56487);
        throw parama;
      }
      localObject1 = (kotlin.l.b.a.a.d)((c)localObject2).g((Field)localObject1);
      continue;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.iCQ().isBound()) {}
        for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
        {
          localObject1 = (kotlin.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (locala.cm())
      {
        if (parama.iCQ().isBound()) {}
        for (localObject1 = (e.h)new e.h.b((Method)localObject1);; localObject1 = (e.h)new e.h.e((Method)localObject1))
        {
          localObject1 = (kotlin.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (parama.iCQ().isBound()) {}
      for (localObject1 = (e.h)new e.h.c((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.f((Method)localObject1))
      {
        localObject1 = (kotlin.l.b.a.a.d)localObject1;
        break;
      }
      if (!(locald instanceof d.a)) {
        break label640;
      }
      localObject1 = (kotlin.l.b.a.a.d)((c)localObject2).g(((d.a)locald).bKF);
    }
    label640:
    if ((locald instanceof d.b)) {
      if (paramBoolean) {
        localObject1 = ((d.b)locald).aaCw;
      }
    }
    label1041:
    for (;;)
    {
      if (parama.iCQ().isBound()) {}
      for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
      {
        localObject1 = (kotlin.l.b.a.a.d)localObject1;
        break;
        localObject1 = ((d.b)locald).aaCx;
        if (localObject1 != null) {
          break label1041;
        }
        parama = (Throwable)new w("No source found for setter of Java method property: " + ((d.b)locald).aaCw);
        AppMethodBeat.o(56487);
        throw parama;
      }
      if ((locald instanceof d.d))
      {
        if (paramBoolean) {
          localObject1 = ((d.d)locald).aaCD;
        }
        do
        {
          localObject1 = parama.iCQ().aaDC.pm(((c.e)localObject1).aaCv.name, ((c.e)localObject1).aaCv.desc);
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new w("No accessor found for property " + parama.iCQ());
          AppMethodBeat.o(56487);
          throw parama;
          localObject2 = ((d.d)locald).aaCE;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new w("No setter found for property " + parama.iCQ());
        AppMethodBeat.o(56487);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (z.aazO) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.iCQ());
          AppMethodBeat.o(56487);
          throw parama;
        }
        if (parama.iCQ().isBound())
        {
          parama = (kotlin.l.b.a.a.d)new e.h.a((Method)localObject1, a(parama));
          AppMethodBeat.o(56487);
          return parama;
        }
        parama = (kotlin.l.b.a.a.d)new e.h.d((Method)localObject1);
        AppMethodBeat.o(56487);
        return parama;
      }
      parama = new m();
      AppMethodBeat.o(56487);
      throw parama;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"isJvmStaticProperty", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    a(r.a parama)
    {
      super();
    }
    
    public final boolean cm()
    {
      AppMethodBeat.i(56481);
      boolean bool = this.aaEf.iCQ().iCZ().iDY().h(ae.iDf());
      AppMethodBeat.o(56481);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"isNotNullProperty", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(r.a parama)
    {
      super();
    }
    
    public final boolean cm()
    {
      AppMethodBeat.i(56483);
      if (!bc.aE(this.aaEf.iCQ().iCZ().iFN()))
      {
        AppMethodBeat.o(56483);
        return true;
      }
      AppMethodBeat.o(56483);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.b<Field, kotlin.l.b.a.a.e<? extends Field>>
  {
    c(r.a parama, boolean paramBoolean, s.b paramb, s.a parama1)
    {
      super();
    }
    
    public final kotlin.l.b.a.a.e<Field> g(Field paramField)
    {
      AppMethodBeat.i(56485);
      p.k(paramField, "field");
      if ((s.a(this.aaEf.iCQ().iCZ())) || (!Modifier.isStatic(paramField.getModifiers())))
      {
        if (paramBoolean)
        {
          if (this.aaEf.iCQ().isBound()) {}
          for (paramField = (e.f)new e.f.a(paramField, s.a(this.aaEf));; paramField = (e.f)new e.f.c(paramField))
          {
            paramField = (kotlin.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.aaEf.iCQ().isBound()) {}
        for (paramField = (e.g)new e.g.a(paramField, this.aaEh.cm(), s.a(this.aaEf));; paramField = (e.g)new e.g.c(paramField, this.aaEh.cm()))
        {
          paramField = (kotlin.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (locala.cm())
      {
        if (paramBoolean)
        {
          if (this.aaEf.iCQ().isBound()) {}
          for (paramField = (e.f)new e.f.b(paramField);; paramField = (e.f)new e.f.d(paramField))
          {
            paramField = (kotlin.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.aaEf.iCQ().isBound()) {}
        for (paramField = (e.g)new e.g.b(paramField, this.aaEh.cm());; paramField = (e.g)new e.g.d(paramField, this.aaEh.cm()))
        {
          paramField = (kotlin.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (paramBoolean)
      {
        paramField = (kotlin.l.b.a.a.e)new e.f.e(paramField);
        AppMethodBeat.o(56485);
        return paramField;
      }
      paramField = (kotlin.l.b.a.a.e)new e.g.e(paramField, this.aaEh.cm());
      AppMethodBeat.o(56485);
      return paramField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     kotlin.l.b.a.s
 * JD-Core Version:    0.7.0.1
 */