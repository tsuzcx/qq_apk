package d.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.m;
import d.g.b.p;
import d.g.b.q;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"})
public abstract interface f
{
  public abstract <R> R fold(R paramR, m<? super R, ? super b, ? extends R> paramm);
  
  public abstract <E extends b> E get(f.c<E> paramc);
  
  public abstract f minusKey(f.c<?> paramc);
  
  public abstract f plus(f paramf);
  
  @l(gfx={1, 1, 16})
  public static final class a
  {
    public static f a(f paramf1, f paramf2)
    {
      AppMethodBeat.i(129629);
      p.h(paramf2, "context");
      if (paramf2 == g.MKY)
      {
        AppMethodBeat.o(129629);
        return paramf1;
      }
      paramf1 = (f)paramf2.fold(paramf1, (m)a.MKX);
      AppMethodBeat.o(129629);
      return paramf1;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"})
    static final class a
      extends q
      implements m<f, f.b, f>
    {
      public static final a MKX;
      
      static
      {
        AppMethodBeat.i(129622);
        MKX = new a();
        AppMethodBeat.o(129622);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"})
  public static abstract interface b
    extends f
  {
    public abstract <E extends b> E get(f.c<E> paramc);
    
    public abstract f.c<?> getKey();
    
    @l(gfx={1, 1, 16})
    public static final class a
    {
      public static <E extends f.b> E a(f.b paramb, f.c<E> paramc)
      {
        AppMethodBeat.i(129625);
        p.h(paramc, "key");
        if (p.i(paramb.getKey(), paramc))
        {
          AppMethodBeat.o(129625);
          return paramb;
        }
        AppMethodBeat.o(129625);
        return null;
      }
      
      public static f a(f.b paramb, f paramf)
      {
        AppMethodBeat.i(129628);
        p.h(paramf, "context");
        paramb = f.a.a((f)paramb, paramf);
        AppMethodBeat.o(129628);
        return paramb;
      }
      
      public static <R> R a(f.b paramb, R paramR, m<? super R, ? super f.b, ? extends R> paramm)
      {
        AppMethodBeat.i(129626);
        p.h(paramm, "operation");
        paramb = paramm.p(paramR, paramb);
        AppMethodBeat.o(129626);
        return paramb;
      }
      
      public static f b(f.b paramb, f.c<?> paramc)
      {
        AppMethodBeat.i(129627);
        p.h(paramc, "key");
        if (p.i(paramb.getKey(), paramc))
        {
          paramb = (f)g.MKY;
          AppMethodBeat.o(129627);
          return paramb;
        }
        paramb = (f)paramb;
        AppMethodBeat.o(129627);
        return paramb;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     d.d.f
 * JD-Core Version:    0.7.0.1
 */