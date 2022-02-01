package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"debounce", "Lkotlin/Function1;", "T", "", "waitMs", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "destinationFunction", "throttleFirst", "skipMs", "throttleLatest", "intervalMs", "libcompatible_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class ReactiveKt
{
  public static final <T> b<T, ah> debounce(final long paramLong, final aq paramaq, b<? super T, ah> paramb)
  {
    AppMethodBeat.i(243855);
    s.u(paramaq, "coroutineScope");
    s.u(paramb, "destinationFunction");
    paramaq = (b)new u(new ah.f())
    {
      public final void invoke(final T paramAnonymousT)
      {
        AppMethodBeat.i(243790);
        cb localcb = (cb)this.$debounceJob.aqH;
        if (localcb != null) {
          localcb.a(null);
        }
        this.$debounceJob.aqH = j.a(paramaq, null, null, (m)new k(paramLong, this.$destinationFunction)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymous2Object, d<?> paramAnonymous2d)
          {
            AppMethodBeat.i(244069);
            paramAnonymous2Object = (d)new 1(this.$waitMs, paramAnonymousT, this.$param, paramAnonymous2d);
            AppMethodBeat.o(244069);
            return paramAnonymous2Object;
          }
          
          public final Object invoke(aq paramAnonymous2aq, d<? super ah> paramAnonymous2d)
          {
            AppMethodBeat.i(244073);
            paramAnonymous2aq = ((1)create(paramAnonymous2aq, paramAnonymous2d)).invokeSuspend(ah.aiuX);
            AppMethodBeat.o(244073);
            return paramAnonymous2aq;
          }
          
          public final Object invokeSuspend(Object paramAnonymous2Object)
          {
            AppMethodBeat.i(244062);
            a locala = a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(244062);
              throw paramAnonymous2Object;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymous2Object);
              long l = this.$waitMs;
              paramAnonymous2Object = (d)this;
              this.label = 1;
              if (bb.e(l, paramAnonymous2Object) == locala)
              {
                AppMethodBeat.o(244062);
                return locala;
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymous2Object);
            }
            paramAnonymousT.invoke(this.$param);
            paramAnonymous2Object = ah.aiuX;
            AppMethodBeat.o(244062);
            return paramAnonymous2Object;
          }
        }, 3);
        AppMethodBeat.o(243790);
      }
    };
    AppMethodBeat.o(243855);
    return paramaq;
  }
  
  public static final <T> b<T, ah> throttleFirst(final long paramLong, final aq paramaq, final b<? super T, ah> paramb)
  {
    AppMethodBeat.i(243863);
    s.u(paramaq, "coroutineScope");
    s.u(paramb, "destinationFunction");
    paramaq = (b)new u(new ah.f())
    {
      public final void invoke(final T paramAnonymousT)
      {
        AppMethodBeat.i(244056);
        cb localcb = (cb)this.$throttleJob.aqH;
        if ((localcb != null) && (!localcb.isCompleted())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            this.$throttleJob.aqH = j.a(paramaq, null, null, (m)new k(paramb, paramAnonymousT)
            {
              int label;
              
              public final d<ah> create(Object paramAnonymous2Object, d<?> paramAnonymous2d)
              {
                AppMethodBeat.i(243928);
                paramAnonymous2Object = (d)new 1(this.$destinationFunction, paramAnonymousT, this.$skipMs, paramAnonymous2d);
                AppMethodBeat.o(243928);
                return paramAnonymous2Object;
              }
              
              public final Object invoke(aq paramAnonymous2aq, d<? super ah> paramAnonymous2d)
              {
                AppMethodBeat.i(243935);
                paramAnonymous2aq = ((1)create(paramAnonymous2aq, paramAnonymous2d)).invokeSuspend(ah.aiuX);
                AppMethodBeat.o(243935);
                return paramAnonymous2aq;
              }
              
              public final Object invokeSuspend(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(243919);
                a locala = a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(243919);
                  throw paramAnonymous2Object;
                case 0: 
                  ResultKt.throwOnFailure(paramAnonymous2Object);
                  this.$destinationFunction.invoke(paramAnonymousT);
                  long l = this.$skipMs;
                  paramAnonymous2Object = (d)this;
                  this.label = 1;
                  if (bb.e(l, paramAnonymous2Object) == locala)
                  {
                    AppMethodBeat.o(243919);
                    return locala;
                  }
                  break;
                case 1: 
                  ResultKt.throwOnFailure(paramAnonymous2Object);
                }
                paramAnonymous2Object = ah.aiuX;
                AppMethodBeat.o(243919);
                return paramAnonymous2Object;
              }
            }, 3);
          }
          AppMethodBeat.o(244056);
          return;
        }
      }
    };
    AppMethodBeat.o(243863);
    return paramaq;
  }
  
  public static final <T> b<T, ah> throttleLatest(final long paramLong, final aq paramaq, b<? super T, ah> paramb)
  {
    AppMethodBeat.i(243843);
    s.u(paramaq, "coroutineScope");
    s.u(paramb, "destinationFunction");
    final ah.f localf = new ah.f();
    paramaq = (b)new u(new ah.f())
    {
      public final void invoke(T paramAnonymousT)
      {
        AppMethodBeat.i(243885);
        this.$latestParam.aqH = paramAnonymousT;
        paramAnonymousT = (cb)localf.aqH;
        if ((paramAnonymousT != null) && (!paramAnonymousT.isCompleted())) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            localf.aqH = j.a(paramaq, null, null, (m)new k(paramLong, this.$destinationFunction)
            {
              int label;
              
              public final d<ah> create(Object paramAnonymous2Object, d<?> paramAnonymous2d)
              {
                AppMethodBeat.i(244087);
                paramAnonymous2Object = (d)new 1(this.$intervalMs, this.$destinationFunction, this.$latestParam, paramAnonymous2d);
                AppMethodBeat.o(244087);
                return paramAnonymous2Object;
              }
              
              public final Object invoke(aq paramAnonymous2aq, d<? super ah> paramAnonymous2d)
              {
                AppMethodBeat.i(244091);
                paramAnonymous2aq = ((1)create(paramAnonymous2aq, paramAnonymous2d)).invokeSuspend(ah.aiuX);
                AppMethodBeat.o(244091);
                return paramAnonymous2aq;
              }
              
              public final Object invokeSuspend(Object paramAnonymous2Object)
              {
                AppMethodBeat.i(244084);
                a locala = a.aiwj;
                switch (this.label)
                {
                default: 
                  paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                  AppMethodBeat.o(244084);
                  throw paramAnonymous2Object;
                case 0: 
                  ResultKt.throwOnFailure(paramAnonymous2Object);
                  long l = this.$intervalMs;
                  paramAnonymous2Object = (d)this;
                  this.label = 1;
                  if (bb.e(l, paramAnonymous2Object) == locala)
                  {
                    AppMethodBeat.o(244084);
                    return locala;
                  }
                  break;
                case 1: 
                  ResultKt.throwOnFailure(paramAnonymous2Object);
                }
                this.$destinationFunction.invoke(this.$latestParam.aqH);
                paramAnonymous2Object = ah.aiuX;
                AppMethodBeat.o(244084);
                return paramAnonymous2Object;
              }
            }, 3);
          }
          AppMethodBeat.o(243885);
          return;
        }
      }
    };
    AppMethodBeat.o(243843);
    return paramaq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ReactiveKt
 * JD-Core Version:    0.7.0.1
 */