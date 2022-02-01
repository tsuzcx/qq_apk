package kotlin.l.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import kotlin.Metadata;
import kotlin.ak;
import kotlin.g.a.a;
import kotlin.l.b.a.a.d;
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
import kotlin.l.b.a.a.i;
import kotlin.l.b.a.a.i.a;
import kotlin.l.b.a.a.i.b;
import kotlin.l.b.a.b.b.a.g;
import kotlin.l.b.a.b.b.ap;
import kotlin.l.b.a.b.b.bf;
import kotlin.l.b.a.b.e.b.c;
import kotlin.l.b.a.b.e.c.a.b;
import kotlin.l.b.a.b.e.c.a.c;
import kotlin.l.b.a.b.e.c.a.d.b;
import kotlin.l.b.a.b.j.f;
import kotlin.l.b.a.b.m.bg;
import kotlin.n.k;
import kotlin.p;

@Metadata(d1={""}, d2={"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k=2, mv={1, 5, 1})
public final class u
{
  public static final Object a(t.a<?, ?> parama)
  {
    AppMethodBeat.i(56486);
    kotlin.g.b.s.u(parama, "$this$boundReceiver");
    parama = parama.kmj().kln();
    AppMethodBeat.o(56486);
    return parama;
  }
  
  static final d<?> a(t.a<?, ?> parama, final boolean paramBoolean)
  {
    AppMethodBeat.i(56487);
    Object localObject1 = j.aiyZ;
    if (j.kmg().bm((CharSequence)parama.kmj().signature))
    {
      parama = (d)kotlin.l.b.a.a.j.aiBe;
      AppMethodBeat.o(56487);
      return parama;
    }
    final a locala = new a(parama);
    Object localObject2 = new c(parama, paramBoolean, new b(parama), locala);
    localObject1 = ag.aiAv;
    e locale = ag.c(parama.kmj().kmt());
    if ((locale instanceof e.c))
    {
      localObject1 = ((e.c)locale).aiyj;
      if (paramBoolean) {
        if (((a.c)localObject1).kxn())
        {
          localObject1 = ((a.c)localObject1).ajdD;
          if (localObject1 == null) {
            break label318;
          }
          localObject1 = parama.kmj().aixX.rk(((e.c)locale).aiyk.getString(((a.b)localObject1).aiZC), ((e.c)locale).aiyk.getString(((a.b)localObject1).ajdy));
        }
      }
      for (;;)
      {
        if (localObject1 == null) {
          if ((f.a((bf)parama.kmj().kmt())) && (kotlin.g.b.s.p(parama.kmj().kmt().knc(), kotlin.l.b.a.b.b.s.aiGF)))
          {
            localObject1 = h.a(parama.kmj().kmt().knp());
            if (localObject1 != null)
            {
              localObject1 = h.a((Class)localObject1, (kotlin.l.b.a.b.b.b)parama.kmj().kmt());
              if (localObject1 != null) {}
            }
            else
            {
              parama = (Throwable)new aa("Underlying property of inline class " + parama.kmj() + " should have a field");
              AppMethodBeat.o(56487);
              throw parama;
              localObject1 = null;
              break;
              if (((a.c)localObject1).kxo())
              {
                localObject1 = ((a.c)localObject1).ajdE;
                break;
              }
              localObject1 = null;
              break;
              label318:
              localObject1 = null;
              continue;
            }
            if (parama.kmj().isBound())
            {
              localObject1 = (i)new i.a((Method)localObject1, a(parama));
              localObject1 = (d)localObject1;
            }
          }
        }
      }
    }
    for (;;)
    {
      parama = h.a((d)localObject1, (kotlin.l.b.a.b.b.b)parama.kmu());
      AppMethodBeat.o(56487);
      return parama;
      localObject1 = (i)new i.b((Method)localObject1);
      break;
      localObject1 = parama.kmj().kmr();
      if (localObject1 == null)
      {
        parama = (Throwable)new aa("No accessors or field is found for property " + parama.kmj());
        AppMethodBeat.o(56487);
        throw parama;
      }
      localObject1 = (d)((c)localObject2).j((Field)localObject1);
      continue;
      if (!Modifier.isStatic(((Method)localObject1).getModifiers()))
      {
        if (parama.kmj().isBound()) {}
        for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
        {
          localObject1 = (d)localObject1;
          break;
        }
      }
      if (locala.df())
      {
        if (parama.kmj().isBound()) {}
        for (localObject1 = (e.h)new e.h.b((Method)localObject1);; localObject1 = (e.h)new e.h.e((Method)localObject1))
        {
          localObject1 = (d)localObject1;
          break;
        }
      }
      if (parama.kmj().isBound()) {}
      for (localObject1 = (e.h)new e.h.c((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.f((Method)localObject1))
      {
        localObject1 = (d)localObject1;
        break;
      }
      if (!(locale instanceof e.a)) {
        break label640;
      }
      localObject1 = (d)((c)localObject2).j(((e.a)locale).dEn);
    }
    label640:
    if ((locale instanceof e.b)) {
      if (paramBoolean) {
        localObject1 = ((e.b)locale).aiyf;
      }
    }
    label1041:
    for (;;)
    {
      if (parama.kmj().isBound()) {}
      for (localObject1 = (e.h)new e.h.a((Method)localObject1, a(parama));; localObject1 = (e.h)new e.h.d((Method)localObject1))
      {
        localObject1 = (d)localObject1;
        break;
        localObject1 = ((e.b)locale).aiyg;
        if (localObject1 != null) {
          break label1041;
        }
        parama = (Throwable)new aa("No source found for setter of Java method property: " + ((e.b)locale).aiyf);
        AppMethodBeat.o(56487);
        throw parama;
      }
      if ((locale instanceof e.d))
      {
        if (paramBoolean) {
          localObject1 = ((e.d)locale).aiym;
        }
        do
        {
          localObject1 = parama.kmj().aixX.rk(((d.e)localObject1).aiye.name, ((d.e)localObject1).aiye.desc);
          if (localObject1 != null) {
            break;
          }
          parama = (Throwable)new aa("No accessor found for property " + parama.kmj());
          AppMethodBeat.o(56487);
          throw parama;
          localObject2 = ((e.d)locale).aiyn;
          localObject1 = localObject2;
        } while (localObject2 != null);
        parama = (Throwable)new aa("No setter found for property " + parama.kmj());
        AppMethodBeat.o(56487);
        throw parama;
        if (!Modifier.isStatic(((Method)localObject1).getModifiers())) {}
        for (int i = 1; (ak.aiuY) && (i == 0); i = 0)
        {
          parama = (Throwable)new AssertionError("Mapped property cannot have a static accessor: " + parama.kmj());
          AppMethodBeat.o(56487);
          throw parama;
        }
        if (parama.kmj().isBound())
        {
          parama = (d)new e.h.a((Method)localObject1, a(parama));
          AppMethodBeat.o(56487);
          return parama;
        }
        parama = (d)new e.h.d((Method)localObject1);
        AppMethodBeat.o(56487);
        return parama;
      }
      parama = new p();
      AppMethodBeat.o(56487);
      throw parama;
    }
  }
  
  @Metadata(d1={""}, d2={"isJvmStaticProperty", "", "invoke"}, k=3, mv={1, 5, 1})
  static final class a
    extends kotlin.g.b.u
    implements a<Boolean>
  {
    a(t.a parama)
    {
      super();
    }
    
    public final boolean df()
    {
      AppMethodBeat.i(56481);
      boolean bool = this.aizW.kmj().kmt().knl().i(ai.kmx());
      AppMethodBeat.o(56481);
      return bool;
    }
  }
  
  @Metadata(d1={""}, d2={"isNotNullProperty", "", "invoke"}, k=3, mv={1, 5, 1})
  static final class b
    extends kotlin.g.b.u
    implements a<Boolean>
  {
    b(t.a parama)
    {
      super();
    }
    
    public final boolean df()
    {
      AppMethodBeat.i(56483);
      if (!bg.aw(this.aizW.kmj().kmt().koG()))
      {
        AppMethodBeat.o(56483);
        return true;
      }
      AppMethodBeat.o(56483);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"computeFieldCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Field;", "field", "invoke"}, k=3, mv={1, 5, 1})
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Field, kotlin.l.b.a.a.e<? extends Field>>
  {
    c(t.a parama, boolean paramBoolean, u.b paramb, u.a parama1)
    {
      super();
    }
    
    public final kotlin.l.b.a.a.e<Field> j(Field paramField)
    {
      AppMethodBeat.i(56485);
      kotlin.g.b.s.u(paramField, "field");
      if ((u.a(this.aizW.kmj().kmt())) || (!Modifier.isStatic(paramField.getModifiers())))
      {
        if (paramBoolean)
        {
          if (this.aizW.kmj().isBound()) {}
          for (paramField = (e.f)new e.f.a(paramField, u.a(this.aizW));; paramField = (e.f)new e.f.c(paramField))
          {
            paramField = (kotlin.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.aizW.kmj().isBound()) {}
        for (paramField = (e.g)new e.g.a(paramField, this.aizY.df(), u.a(this.aizW));; paramField = (e.g)new e.g.c(paramField, this.aizY.df()))
        {
          paramField = (kotlin.l.b.a.a.e)paramField;
          AppMethodBeat.o(56485);
          return paramField;
        }
      }
      if (locala.df())
      {
        if (paramBoolean)
        {
          if (this.aizW.kmj().isBound()) {}
          for (paramField = (e.f)new e.f.b(paramField);; paramField = (e.f)new e.f.d(paramField))
          {
            paramField = (kotlin.l.b.a.a.e)paramField;
            AppMethodBeat.o(56485);
            return paramField;
          }
        }
        if (this.aizW.kmj().isBound()) {}
        for (paramField = (e.g)new e.g.b(paramField, this.aizY.df());; paramField = (e.g)new e.g.d(paramField, this.aizY.df()))
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
      paramField = (kotlin.l.b.a.a.e)new e.g.e(paramField, this.aizY.df());
      AppMethodBeat.o(56485);
      return paramField;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     kotlin.l.b.a.u
 * JD-Core Version:    0.7.0.1
 */