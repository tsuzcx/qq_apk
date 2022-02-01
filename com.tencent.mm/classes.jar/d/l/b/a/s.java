package d.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
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
import d.n.k;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class s
{
  static final d.l.b.a.a.d<?> a(r.a<?, ?> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(56487);
    Object localObject1 = i.NkO;
    if (i.gla().aB((CharSequence)parama.glc().signature))
    {
      parama = (d.l.b.a.a.d)j.NmL;
      AppMethodBeat.o(56487);
      return parama;
    }
    final a locala = new a(parama);
    Object localObject2 = new c(parama, paramBoolean, new b(parama), locala);
    localObject1 = ac.Nmb;
    d locald = ac.c(parama.glc().gll());
    if ((locald instanceof d.c))
    {
      localObject1 = ((d.c)locald).NjY;
      if (paramBoolean) {
        if (((a.c)localObject1).gvd())
        {
          localObject1 = ((a.c)localObject1).NMy;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = parama.glc().Nla.nw(((d.c)locald).NjZ.getString(((a.b)localObject1).NII), ((d.c)locald).NjZ.getString(((a.b)localObject1).NMt));
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          if ((d.l.b.a.b.j.e.a((ax)parama.glc().gll())) && (p.i(parama.glc().gll().gmb(), az.Nsl)))
          {
            localObject1 = h.a(parama.glc().gll().glU());
            if (localObject1 != null)
            {
              localObject1 = h.a((Class)localObject1, (d.l.b.a.b.b.b)parama.glc().gll());
              if (localObject1 != null) {}
            }
            else
            {
              parama = (Throwable)new w("Underlying property of inline class " + parama.glc() + " should have a field");
              AppMethodBeat.o(56487);
              throw parama;
              localObject1 = null;
              break;
              if (((a.c)localObject1).gve())
              {
                localObject1 = ((a.c)localObject1).NMz;
                break;
              }
              localObject1 = null;
              break;
              label318:
              localObject1 = null;
              continue;
            }
            if (parama.glc().isBound())
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
      parama = h.a((d.l.b.a.a.d)localObject1, (d.l.b.a.b.b.b)parama.glm());
      AppMethodBeat.o(56487);
      return parama;
      localObject1 = (d.l.b.a.a.i)new i.b((Method)localObject1);
      break;
      localObject1 = parama.glc().glj();
      if (localObject1 == null)
      {
        parama = (Throwable)new w("No accessors or field is found for property " + parama.glc());
        AppMethodBeat.o(56487);
        throw parama;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e((Field)localObject1);
      continue;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.glc().isBound()) {}
        for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (locala.hZ())
      {
        if (parama.glc().isBound()) {}
        for (localObject1 = (e.h)new e.h.b((Method)localObject1);; localObject1 = (e.h)new e.h.e((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (parama.glc().isBound()) {}
      for (localObject1 = (e.h)new e.h.c((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.f((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
      }
      if (!(locald instanceof d.a)) {
        break label639;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e(((d.a)locald).bMM);
    }
    label639:
    if ((locald instanceof d.b)) {
      if (paramBoolean) {
        localObject1 = ((d.b)locald).NjU;
      }
    }
    label1040:
    for (;;)
    {
      if (parama.glc().isBound()) {}
      for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
        localObject1 = ((d.b)locald).NjV;
        if (localObject1 != null) {
          break label1040;
        }
        parama = (Throwable)new w("No source found for setter of Java method property: " + ((d.b)locald).NjU);
        AppMethodBeat.o(56487);
        throw parama;
      }
      if ((locald instanceof d.d))
      {
        if (paramBoolean) {
          localObject1 = ((d.d)locald).Nkb;
        }
        do
        {
          localObject1 = parama.glc().Nla.nw(((c.e)localObject1).NjT.name, ((c.e)localObject1).NjT.desc);
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new w("No accessor found for property " + parama.glc());
          AppMethodBeat.o(56487);
          throw parama;
          localObject2 = ((d.d)locald).Nkc;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new w("No setter found for property " + parama.glc());
        AppMethodBeat.o(56487);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (d.ac.Nhs) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.glc());
          AppMethodBeat.o(56487);
          throw parama;
        }
        if (parama.glc().isBound())
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
  
  public static final Object a(r.a<?, ?> parama)
  {
    AppMethodBeat.i(56486);
    p.h(parama, "$this$boundReceiver");
    parama = parama.glc().gkr();
    AppMethodBeat.o(56486);
    return parama;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"isJvmStaticProperty", "", "invoke"})
  static final class a
    extends q
    implements a<Boolean>
  {
    a(r.a parama)
    {
      super();
    }
    
    public final boolean hZ()
    {
      AppMethodBeat.i(56481);
      boolean bool = this.NlD.glc().gll().gmj().h(ae.glr());
      AppMethodBeat.o(56481);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"isNotNullProperty", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(r.a parama)
    {
      super();
    }
    
    public final boolean hZ()
    {
      AppMethodBeat.i(56483);
      if (!bc.aF(this.NlD.glc().gll().gnW()))
      {
        AppMethodBeat.o(56483);
        return true;
      }
      AppMethodBeat.o(56483);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
  static final class c
    extends q
    implements d.g.a.b<Field, d.l.b.a.a.e<? extends Field>>
  {
    c(r.a parama, boolean paramBoolean, s.b paramb, s.a parama1)
    {
      super();
    }
    
    public final d.l.b.a.a.e<Field> e(Field paramField)
    {
      AppMethodBeat.i(56485);
      p.h(paramField, "field");
      if ((s.a(this.NlD.glc().gll())) || (!Modifier.isStatic(paramField.getModifiers())))
      {
        if (paramBoolean)
        {
          if (this.NlD.glc().isBound()) {}
          for (paramField = (e.f)new e.f.a(paramField, s.a(this.NlD));; paramField = (e.f)new e.f.c(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.NlD.glc().isBound()) {}
        for (paramField = (e.g)new e.g.a(paramField, this.NlF.hZ(), s.a(this.NlD));; paramField = (e.g)new e.g.c(paramField, this.NlF.hZ()))
        {
          paramField = (d.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (locala.hZ())
      {
        if (paramBoolean)
        {
          if (this.NlD.glc().isBound()) {}
          for (paramField = (e.f)new e.f.b(paramField);; paramField = (e.f)new e.f.d(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.NlD.glc().isBound()) {}
        for (paramField = (e.g)new e.g.b(paramField, this.NlF.hZ());; paramField = (e.g)new e.g.d(paramField, this.NlF.hZ()))
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
      paramField = (d.l.b.a.a.e)new e.g.e(paramField, this.NlF.hZ());
      AppMethodBeat.o(56485);
      return paramField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.l.b.a.s
 * JD-Core Version:    0.7.0.1
 */