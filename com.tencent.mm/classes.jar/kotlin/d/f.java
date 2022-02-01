package kotlin.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lkotlin/coroutines/CoroutineContext;", "", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext$Element;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "plus", "context", "Element", "Key", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
public abstract interface f
{
  public abstract <R> R fold(R paramR, m<? super R, ? super b, ? extends R> paramm);
  
  public abstract <E extends b> E get(c<E> paramc);
  
  public abstract f minusKey(c<?> paramc);
  
  public abstract f plus(f paramf);
  
  @Metadata(k=3, mv={1, 5, 1})
  public static final class a
  {
    public static f a(f paramf1, f paramf2)
    {
      AppMethodBeat.i(129629);
      s.u(paramf2, "context");
      if (paramf2 == g.aiwf)
      {
        AppMethodBeat.o(129629);
        return paramf1;
      }
      paramf1 = (f)paramf2.fold(paramf1, (m)a.aiwe);
      AppMethodBeat.o(129629);
      return paramf1;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "Lkotlin/coroutines/CoroutineContext;", "acc", "element", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke"}, k=3, mv={1, 5, 1})
    static final class a
      extends u
      implements m<f, f.b, f>
    {
      public static final a aiwe;
      
      static
      {
        AppMethodBeat.i(129622);
        aiwe = new a();
        AppMethodBeat.o(129622);
      }
      
      a()
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/coroutines/CoroutineContext$Element;", "Lkotlin/coroutines/CoroutineContext;", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "fold", "R", "initial", "operation", "Lkotlin/Function2;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "get", "E", "(Lkotlin/coroutines/CoroutineContext$Key;)Lkotlin/coroutines/CoroutineContext$Element;", "minusKey", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static abstract interface b
    extends f
  {
    public abstract <E extends b> E get(f.c<E> paramc);
    
    public abstract f.c<?> getKey();
    
    @Metadata(k=3, mv={1, 5, 1})
    public static final class a
    {
      public static <R> R a(f.b paramb, R paramR, m<? super R, ? super f.b, ? extends R> paramm)
      {
        AppMethodBeat.i(129626);
        s.u(paramm, "operation");
        paramb = paramm.invoke(paramR, paramb);
        AppMethodBeat.o(129626);
        return paramb;
      }
      
      public static <E extends f.b> E a(f.b paramb, f.c<E> paramc)
      {
        AppMethodBeat.i(129625);
        s.u(paramc, "key");
        if (s.p(paramb.getKey(), paramc))
        {
          paramc = paramb;
          if (paramb == null)
          {
            paramb = new NullPointerException("null cannot be cast to non-null type E");
            AppMethodBeat.o(129625);
            throw paramb;
          }
        }
        else
        {
          paramc = null;
        }
        AppMethodBeat.o(129625);
        return paramc;
      }
      
      public static f a(f.b paramb, f paramf)
      {
        AppMethodBeat.i(129628);
        s.u(paramf, "context");
        paramb = f.a.a((f)paramb, paramf);
        AppMethodBeat.o(129628);
        return paramb;
      }
      
      public static f b(f.b paramb, f.c<?> paramc)
      {
        AppMethodBeat.i(129627);
        s.u(paramc, "key");
        if (s.p(paramb.getKey(), paramc))
        {
          paramb = (f)g.aiwf;
          AppMethodBeat.o(129627);
          return paramb;
        }
        paramb = (f)paramb;
        AppMethodBeat.o(129627);
        return paramb;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlin/coroutines/CoroutineContext$Key;", "E", "Lkotlin/coroutines/CoroutineContext$Element;", "", "kotlin-stdlib"}, k=1, mv={1, 5, 1})
  public static abstract interface c<E extends f.b> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     kotlin.d.f
 * JD-Core Version:    0.7.0.1
 */