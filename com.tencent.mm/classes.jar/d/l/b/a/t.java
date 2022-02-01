package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.aa;
import d.g.a.a;
import d.l.b.a.a.e.f;
import d.l.b.a.a.e.f.a;
import d.l.b.a.a.e.f.b;
import d.l.b.a.a.e.f.c;
import d.l.b.a.a.e.f.d;
import d.l.b.a.a.e.f.e;
import d.l.b.a.a.e.g;
import d.l.b.a.a.e.g.a;
import d.l.b.a.a.e.g.b;
import d.l.b.a.a.e.g.c;
import d.l.b.a.a.e.g.d;
import d.l.b.a.a.e.g.e;
import d.l.b.a.a.e.h;
import d.l.b.a.a.e.h.a;
import d.l.b.a.a.e.h.b;
import d.l.b.a.a.e.h.c;
import d.l.b.a.a.e.h.d;
import d.l.b.a.a.e.h.e;
import d.l.b.a.a.e.h.f;
import d.l.b.a.a.h;
import d.l.b.a.a.i.a;
import d.l.b.a.a.i.b;
import d.l.b.a.a.j;
import d.l.b.a.b.b.a.g;
import d.l.b.a.b.b.ah;
import d.l.b.a.b.b.ax;
import d.l.b.a.b.b.az;
import d.l.b.a.b.e.b.c;
import d.l.b.a.b.e.c.a.b;
import d.l.b.a.b.e.c.a.c;
import d.l.b.a.b.e.c.a.e.b;
import d.l.b.a.b.m.bc;
import d.m;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class t
{
  static final d.l.b.a.a.d<?> a(s.a<?, ?> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(56487);
    Object localObject1 = i.KWD;
    if (i.fOY().aB((CharSequence)parama.fPb().signature))
    {
      parama = (d.l.b.a.a.d)j.KYL;
      AppMethodBeat.o(56487);
      return parama;
    }
    final a locala = new a(parama);
    Object localObject2 = new c(parama, paramBoolean, new b(parama), locala);
    localObject1 = ad.KXZ;
    d locald = ad.c(parama.fPb().fPl());
    if ((locald instanceof d.c))
    {
      localObject1 = ((d.c)locald).KVN;
      if (paramBoolean) {
        if (((a.c)localObject1).fZc())
        {
          localObject1 = ((a.c)localObject1).Lyv;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = parama.fPb().KWP.mS(((d.c)locald).KVO.getString(((a.b)localObject1).LuF), ((d.c)locald).KVO.getString(((a.b)localObject1).Lyq));
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          if ((d.l.b.a.b.j.e.a((ax)parama.fPb().fPl())) && (d.g.b.k.g(parama.fPb().fPl().fQb(), az.Lel)))
          {
            localObject1 = h.a(parama.fPb().fPl().fPU());
            if (localObject1 != null)
            {
              localObject1 = h.a((Class)localObject1, (d.l.b.a.b.b.b)parama.fPb().fPl());
              if (localObject1 != null) {}
            }
            else
            {
              parama = (Throwable)new x("Underlying property of inline class " + parama.fPb() + " should have a field");
              AppMethodBeat.o(56487);
              throw parama;
              localObject1 = null;
              break;
              if (((a.c)localObject1).fZd())
              {
                localObject1 = ((a.c)localObject1).Lyw;
                break;
              }
              localObject1 = null;
              break;
              label318:
              localObject1 = null;
              continue;
            }
            if (parama.fPb().isBound())
            {
              localObject1 = (d.l.b.a.a.i)new i.a((Method)localObject1, a(parama));
              localObject1 = (d.l.b.a.a.d)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      parama = h.a((d.l.b.a.a.d)localObject1, (d.l.b.a.b.b.b)parama.fPm());
      AppMethodBeat.o(56487);
      return parama;
      localObject1 = (d.l.b.a.a.i)new i.b((Method)localObject1);
      break;
      localObject1 = parama.fPb().fPj();
      if (localObject1 == null)
      {
        parama = (Throwable)new x("No accessors or field is found for property " + parama.fPb());
        AppMethodBeat.o(56487);
        throw parama;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e((Field)localObject1);
      continue;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.fPb().isBound()) {}
        for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (locala.hJ())
      {
        if (parama.fPb().isBound()) {}
        for (localObject1 = (e.h)new e.h.b((Method)localObject1);; localObject1 = (e.h)new e.h.e((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (parama.fPb().isBound()) {}
      for (localObject1 = (e.h)new e.h.c((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.f((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
      }
      if (!(locald instanceof d.a)) {
        break label639;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e(((d.a)locald).bCy);
    }
    label639:
    if ((locald instanceof d.b)) {
      if (paramBoolean) {
        localObject1 = ((d.b)locald).KVJ;
      }
    }
    label1040:
    for (;;)
    {
      if (parama.fPb().isBound()) {}
      for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
        localObject1 = ((d.b)locald).KVK;
        if (localObject1 != null) {
          break label1040;
        }
        parama = (Throwable)new x("No source found for setter of Java method property: " + ((d.b)locald).KVJ);
        AppMethodBeat.o(56487);
        throw parama;
      }
      if ((locald instanceof d.d))
      {
        if (paramBoolean) {
          localObject1 = ((d.d)locald).KVQ;
        }
        do
        {
          localObject1 = parama.fPb().KWP.mS(((c.e)localObject1).KVI.name, ((c.e)localObject1).KVI.desc);
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new x("No accessor found for property " + parama.fPb());
          AppMethodBeat.o(56487);
          throw parama;
          localObject2 = ((d.d)locald).KVR;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new x("No setter found for property " + parama.fPb());
        AppMethodBeat.o(56487);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (aa.KTq) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.fPb());
          AppMethodBeat.o(56487);
          throw parama;
        }
        if (parama.fPb().isBound())
        {
          parama = (d.l.b.a.a.d)new e.h.a((Method)localObject1, a(parama));
          AppMethodBeat.o(56487);
          return parama;
        }
        parama = (d.l.b.a.a.d)new e.h.d((Method)localObject1);
        AppMethodBeat.o(56487);
        return parama;
      }
      parama = new m();
      AppMethodBeat.o(56487);
      throw parama;
    }
  }
  
  public static final Object a(s.a<?, ?> parama)
  {
    AppMethodBeat.i(56486);
    d.g.b.k.h(parama, "$this$boundReceiver");
    parama = parama.fPb().fOp();
    AppMethodBeat.o(56486);
    return parama;
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"isJvmStaticProperty", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Boolean>
  {
    a(s.a parama)
    {
      super();
    }
    
    public final boolean hJ()
    {
      AppMethodBeat.i(56481);
      boolean bool = this.KXB.fPb().fPl().fQj().h(af.fPr());
      AppMethodBeat.o(56481);
      return bool;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"isNotNullProperty", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Boolean>
  {
    b(s.a parama)
    {
      super();
    }
    
    public final boolean hJ()
    {
      AppMethodBeat.i(56483);
      if (!bc.aF(this.KXB.fPb().fPl().fRV()))
      {
        AppMethodBeat.o(56483);
        return true;
      }
      AppMethodBeat.o(56483);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 15}, fNZ={""}, fOa={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
  static final class c
    extends d.g.b.l
    implements d.g.a.b<Field, d.l.b.a.a.e<? extends Field>>
  {
    c(s.a parama, boolean paramBoolean, t.b paramb, t.a parama1)
    {
      super();
    }
    
    public final d.l.b.a.a.e<Field> e(Field paramField)
    {
      AppMethodBeat.i(56485);
      d.g.b.k.h(paramField, "field");
      if ((t.a(this.KXB.fPb().fPl())) || (!Modifier.isStatic(paramField.getModifiers())))
      {
        if (paramBoolean)
        {
          if (this.KXB.fPb().isBound()) {}
          for (paramField = (e.f)new e.f.a(paramField, t.a(this.KXB));; paramField = (e.f)new e.f.c(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.KXB.fPb().isBound()) {}
        for (paramField = (e.g)new e.g.a(paramField, this.KXD.hJ(), t.a(this.KXB));; paramField = (e.g)new e.g.c(paramField, this.KXD.hJ()))
        {
          paramField = (d.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (locala.hJ())
      {
        if (paramBoolean)
        {
          if (this.KXB.fPb().isBound()) {}
          for (paramField = (e.f)new e.f.b(paramField);; paramField = (e.f)new e.f.d(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.KXB.fPb().isBound()) {}
        for (paramField = (e.g)new e.g.b(paramField, this.KXD.hJ());; paramField = (e.g)new e.g.d(paramField, this.KXD.hJ()))
        {
          paramField = (d.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (paramBoolean)
      {
        paramField = (d.l.b.a.a.e)new e.f.e(paramField);
        AppMethodBeat.o(56485);
        return paramField;
      }
      paramField = (d.l.b.a.a.e)new e.g.e(paramField, this.KXD.hJ());
      AppMethodBeat.o(56485);
      return paramField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */