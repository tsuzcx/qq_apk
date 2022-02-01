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

@d.l(fvt={1, 1, 15}, fvu={""}, fvv={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"})
public final class t
{
  static final d.l.b.a.a.d<?> a(s.a<?, ?> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(56487);
    Object localObject1 = i.Jjj;
    if (i.fwu().aA((CharSequence)parama.fwx().signature))
    {
      parama = (d.l.b.a.a.d)j.Jlr;
      AppMethodBeat.o(56487);
      return parama;
    }
    final a locala = new a(parama);
    Object localObject2 = new c(parama, paramBoolean, new b(parama), locala);
    localObject1 = ad.JkF;
    d locald = ad.c(parama.fwx().fwH());
    if ((locald instanceof d.c))
    {
      localObject1 = ((d.c)locald).Jit;
      if (paramBoolean) {
        if (((a.c)localObject1).fGy())
        {
          localObject1 = ((a.c)localObject1).JLc;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = parama.fwx().Jjv.mr(((d.c)locald).Jiu.getString(((a.b)localObject1).JHm), ((d.c)locald).Jiu.getString(((a.b)localObject1).JKX));
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          if ((d.l.b.a.b.j.e.a((ax)parama.fwx().fwH())) && (d.g.b.k.g(parama.fwx().fwH().fxx(), az.JqS)))
          {
            localObject1 = h.a(parama.fwx().fwH().fxq());
            if (localObject1 != null)
            {
              localObject1 = h.a((Class)localObject1, (d.l.b.a.b.b.b)parama.fwx().fwH());
              if (localObject1 != null) {}
            }
            else
            {
              parama = (Throwable)new x("Underlying property of inline class " + parama.fwx() + " should have a field");
              AppMethodBeat.o(56487);
              throw parama;
              localObject1 = null;
              break;
              if (((a.c)localObject1).fGz())
              {
                localObject1 = ((a.c)localObject1).JLd;
                break;
              }
              localObject1 = null;
              break;
              label318:
              localObject1 = null;
              continue;
            }
            if (parama.fwx().isBound())
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
      parama = h.a((d.l.b.a.a.d)localObject1, (d.l.b.a.b.b.b)parama.fwI());
      AppMethodBeat.o(56487);
      return parama;
      localObject1 = (d.l.b.a.a.i)new i.b((Method)localObject1);
      break;
      localObject1 = parama.fwx().fwF();
      if (localObject1 == null)
      {
        parama = (Throwable)new x("No accessors or field is found for property " + parama.fwx());
        AppMethodBeat.o(56487);
        throw parama;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e((Field)localObject1);
      continue;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.fwx().isBound()) {}
        for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (locala.hB())
      {
        if (parama.fwx().isBound()) {}
        for (localObject1 = (e.h)new e.h.b((Method)localObject1);; localObject1 = (e.h)new e.h.e((Method)localObject1))
        {
          localObject1 = (d.l.b.a.a.d)localObject1;
          break;
        }
      }
      if (parama.fwx().isBound()) {}
      for (localObject1 = (e.h)new e.h.c((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.f((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
      }
      if (!(locald instanceof d.a)) {
        break label639;
      }
      localObject1 = (d.l.b.a.a.d)((c)localObject2).e(((d.a)locald).bEQ);
    }
    label639:
    if ((locald instanceof d.b)) {
      if (paramBoolean) {
        localObject1 = ((d.b)locald).Jip;
      }
    }
    label1040:
    for (;;)
    {
      if (parama.fwx().isBound()) {}
      for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
      {
        localObject1 = (d.l.b.a.a.d)localObject1;
        break;
        localObject1 = ((d.b)locald).Jiq;
        if (localObject1 != null) {
          break label1040;
        }
        parama = (Throwable)new x("No source found for setter of Java method property: " + ((d.b)locald).Jip);
        AppMethodBeat.o(56487);
        throw parama;
      }
      if ((locald instanceof d.d))
      {
        if (paramBoolean) {
          localObject1 = ((d.d)locald).Jiw;
        }
        do
        {
          localObject1 = parama.fwx().Jjv.mr(((c.e)localObject1).Jio.name, ((c.e)localObject1).Jio.desc);
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new x("No accessor found for property " + parama.fwx());
          AppMethodBeat.o(56487);
          throw parama;
          localObject2 = ((d.d)locald).Jix;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new x("No setter found for property " + parama.fwx());
        AppMethodBeat.o(56487);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (aa.JfW) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.fwx());
          AppMethodBeat.o(56487);
          throw parama;
        }
        if (parama.fwx().isBound())
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
    parama = parama.fwx().fvL();
    AppMethodBeat.o(56486);
    return parama;
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"isJvmStaticProperty", "", "invoke"})
  static final class a
    extends d.g.b.l
    implements a<Boolean>
  {
    a(s.a parama)
    {
      super();
    }
    
    public final boolean hB()
    {
      AppMethodBeat.i(56481);
      boolean bool = this.Jkh.fwx().fwH().fxF().h(af.fwN());
      AppMethodBeat.o(56481);
      return bool;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"isNotNullProperty", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<Boolean>
  {
    b(s.a parama)
    {
      super();
    }
    
    public final boolean hB()
    {
      AppMethodBeat.i(56483);
      if (!bc.aF(this.Jkh.fwx().fwH().fzr()))
      {
        AppMethodBeat.o(56483);
        return true;
      }
      AppMethodBeat.o(56483);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 15}, fvu={""}, fvv={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"})
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
      if ((t.a(this.Jkh.fwx().fwH())) || (!Modifier.isStatic(paramField.getModifiers())))
      {
        if (paramBoolean)
        {
          if (this.Jkh.fwx().isBound()) {}
          for (paramField = (e.f)new e.f.a(paramField, t.a(this.Jkh));; paramField = (e.f)new e.f.c(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.Jkh.fwx().isBound()) {}
        for (paramField = (e.g)new e.g.a(paramField, this.Jkj.hB(), t.a(this.Jkh));; paramField = (e.g)new e.g.c(paramField, this.Jkj.hB()))
        {
          paramField = (d.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (locala.hB())
      {
        if (paramBoolean)
        {
          if (this.Jkh.fwx().isBound()) {}
          for (paramField = (e.f)new e.f.b(paramField);; paramField = (e.f)new e.f.d(paramField))
          {
            paramField = (d.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.Jkh.fwx().isBound()) {}
        for (paramField = (e.g)new e.g.b(paramField, this.Jkj.hB());; paramField = (e.g)new e.g.d(paramField, this.Jkj.hB()))
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
      paramField = (d.l.b.a.a.e)new e.g.e(paramField, this.Jkj.hB());
      AppMethodBeat.o(56485);
      return paramField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     d.l.b.a.t
 * JD-Core Version:    0.7.0.1
 */