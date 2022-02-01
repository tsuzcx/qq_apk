package kotlinx.coroutines.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.d.f.c;
import kotlin.g.b.s;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.a.r;
import kotlinx.coroutines.b.a.u;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.cf;
import kotlinx.coroutines.internal.ac;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", "", "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", "", "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", "", "size", "", "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", "", "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k=1, mv={1, 5, 1}, xi=48)
final class ag<T>
  extends kotlinx.coroutines.b.a.b<ai>
  implements r<T>, c<T>, x<T>
{
  private int hSX;
  
  public ag(Object paramObject)
  {
    this._state = paramObject;
  }
  
  private final boolean ae(Object paramObject1, Object paramObject2)
  {
    AppMethodBeat.i(189028);
    kDI();
    for (;;)
    {
      int i;
      try
      {
        localObject = this._state;
        if (paramObject1 != null)
        {
          bool = s.p(localObject, paramObject1);
          if (!bool) {
            return false;
          }
        }
        boolean bool = s.p(localObject, paramObject2);
        if (bool) {
          return true;
        }
        this._state = paramObject2;
        i = this.hSX;
        if ((i & 0x1) == 0)
        {
          i += 1;
          this.hSX = i;
          paramObject1 = kDI();
          paramObject2 = kotlin.ah.aiuX;
          paramObject1 = (ai[])paramObject1;
          if (paramObject1 == null) {
            break label259;
          }
          int k = paramObject1.length;
          int j = 0;
          if (j >= k) {
            break label259;
          }
          paramObject2 = paramObject1[j];
          if (paramObject2 != null)
          {
            localObject = paramObject2._state;
            if ((localObject != null) && (localObject != ah.kDH()))
            {
              if (localObject != ah.kDG()) {
                break label211;
              }
              if (!ai.ajvp.compareAndSet(paramObject2, localObject, ah.kDH())) {
                continue;
              }
            }
          }
          j += 1;
          continue;
        }
        else
        {
          this.hSX = (i + 2);
          return true;
        }
      }
      finally
      {
        AppMethodBeat.o(189028);
      }
      label211:
      if (!ai.ajvp.compareAndSet(paramObject2, localObject, ah.kDG())) {
        continue;
      }
      paramObject2 = (kotlin.d.d)localObject;
      Object localObject = kotlin.ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      paramObject2.resumeWith(Result.constructor-impl(localObject));
      continue;
      try
      {
        label259:
        if (this.hSX == i)
        {
          this.hSX = (i + 1);
          return true;
        }
        i = this.hSX;
        paramObject1 = kDI();
        paramObject2 = kotlin.ah.aiuX;
      }
      finally
      {
        AppMethodBeat.o(189028);
      }
    }
  }
  
  public final Object a(T paramT, kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(189074);
    setValue(paramT);
    paramT = kotlin.ah.aiuX;
    AppMethodBeat.o(189074);
    return paramT;
  }
  
  public final Object a(h<? super T> paramh, kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(189088);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject7;
    a locala;
    for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject1;; paramd = new a(this, paramd))
    {
      localObject7 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramh = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189088);
        throw paramh;
      }
    }
    ResultKt.throwOnFailure(localObject7);
    Object localObject2 = (ai)kDK();
    try
    {
      if (!(paramh instanceof aj)) {
        break label1290;
      }
      paramd.L$0 = this;
      paramd.Uf = paramh;
      paramd.VC = localObject2;
      paramd.label = 1;
      AppMethodBeat.o(189088);
      throw null;
    }
    finally
    {
      localObject1 = this;
    }
    ((ag)localObject1).a((kotlinx.coroutines.b.a.d)paramh);
    AppMethodBeat.o(189088);
    throw paramd;
    Object localObject1 = (ai)paramd.VC;
    Object localObject3 = (h)paramd.Uf;
    paramh = (ag)paramd.L$0;
    try
    {
      ResultKt.throwOnFailure(localObject7);
      localObject2 = localObject1;
      localObject1 = paramh;
      paramh = (h<? super T>)localObject2;
    }
    finally
    {
      try
      {
        localObject5 = (cb)paramd.getContext().get((f.c)cb.ajws);
        localObject4 = null;
        localObject6 = paramh;
        paramh = (h<? super T>)localObject1;
        localObject2 = paramd;
        paramd = (kotlin.d.d<? super kotlin.ah>)localObject6;
        localObject1 = localObject5;
        localObject6 = paramd;
        localObject5 = paramh;
      }
      finally
      {
        for (;;)
        {
          try
          {
            localObject7 = paramh._state;
            if (localObject1 != null)
            {
              localObject6 = paramd;
              localObject5 = paramh;
              cf.d((cb)localObject1);
            }
            if (localObject4 != null)
            {
              localObject6 = paramd;
              localObject5 = paramh;
              if (s.p(localObject4, localObject7)) {}
            }
            else
            {
              localObject6 = paramd;
              localObject5 = paramh;
              if (localObject7 == u.ajzN)
              {
                localObject4 = null;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).L$0 = paramh;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).Uf = localObject3;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).VC = paramd;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).VD = localObject1;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).Ze = localObject7;
                localObject6 = paramd;
                localObject5 = paramh;
                ((a)localObject2).label = 2;
                localObject6 = paramd;
                localObject5 = paramh;
                localObject4 = ((h)localObject3).a(localObject4, (kotlin.d.d)localObject2);
                if (localObject4 == locala)
                {
                  AppMethodBeat.o(189088);
                  return locala;
                }
              }
              else
              {
                localObject4 = localObject7;
                continue;
                localObject5 = paramd.Ze;
                localObject4 = (cb)paramd.VD;
                localObject3 = (ai)paramd.VC;
                localObject6 = (h)paramd.Uf;
                localObject2 = (ag)paramd.L$0;
                localObject1 = localObject3;
                paramh = (h<? super T>)localObject2;
                try
                {
                  ResultKt.throwOnFailure(localObject7);
                  localObject1 = localObject4;
                  localObject4 = localObject3;
                  localObject3 = localObject6;
                  paramh = (h<? super T>)localObject2;
                  localObject2 = localObject1;
                  localObject1 = localObject5;
                  localObject5 = localObject4;
                  localObject4 = paramd;
                  paramd = (kotlin.d.d<? super kotlin.ah>)localObject5;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  localObject7 = ai.ajvp.getAndSet(paramd, ah.kDG());
                  localObject6 = paramd;
                  localObject5 = paramh;
                  s.checkNotNull(localObject7);
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (au.ASSERTIONS_ENABLED)
                  {
                    localObject6 = paramd;
                    localObject5 = paramh;
                    if ((localObject7 instanceof q)) {
                      break label1313;
                    }
                    i = 1;
                    if (i == 0)
                    {
                      localObject6 = paramd;
                      localObject5 = paramh;
                      localObject1 = new AssertionError();
                      localObject6 = paramd;
                      localObject5 = paramh;
                      AppMethodBeat.o(189088);
                      localObject6 = paramd;
                      localObject5 = paramh;
                      throw ((Throwable)localObject1);
                    }
                  }
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (localObject7 != ah.kDH()) {
                    break label1318;
                  }
                  i = 1;
                  if (i != 0) {
                    continue;
                  }
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).L$0 = paramh;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).Uf = localObject3;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).VC = paramd;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).VD = localObject2;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).Ze = localObject1;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((a)localObject4).label = 3;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  localObject7 = new q(kotlin.d.a.b.au((kotlin.d.d)localObject4), 1);
                  localObject6 = paramd;
                  localObject5 = paramh;
                  ((q)localObject7).kBA();
                  localObject6 = paramd;
                  localObject5 = paramh;
                  Object localObject8 = (p)localObject7;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (au.ASSERTIONS_ENABLED)
                  {
                    localObject6 = paramd;
                    localObject5 = paramh;
                    if ((paramd._state instanceof q)) {
                      break label1323;
                    }
                    i = 1;
                    if (i == 0)
                    {
                      localObject6 = paramd;
                      localObject5 = paramh;
                      localObject1 = new AssertionError();
                      localObject6 = paramd;
                      localObject5 = paramh;
                      AppMethodBeat.o(189088);
                      localObject6 = paramd;
                      localObject5 = paramh;
                      throw ((Throwable)localObject1);
                    }
                  }
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (!ai.ajvp.compareAndSet(paramd, ah.kDG(), localObject8))
                  {
                    localObject6 = paramd;
                    localObject5 = paramh;
                    if (au.ASSERTIONS_ENABLED)
                    {
                      localObject6 = paramd;
                      localObject5 = paramh;
                      if (paramd._state != ah.kDH()) {
                        break label1328;
                      }
                      i = 1;
                      if (i == 0)
                      {
                        localObject6 = paramd;
                        localObject5 = paramh;
                        localObject1 = new AssertionError();
                        localObject6 = paramd;
                        localObject5 = paramh;
                        AppMethodBeat.o(189088);
                        localObject6 = paramd;
                        localObject5 = paramh;
                        throw ((Throwable)localObject1);
                      }
                    }
                    localObject6 = paramd;
                    localObject5 = paramh;
                    localObject8 = (kotlin.d.d)localObject8;
                    localObject6 = paramd;
                    localObject5 = paramh;
                    kotlin.ah localah = kotlin.ah.aiuX;
                    localObject6 = paramd;
                    localObject5 = paramh;
                    Result.Companion localCompanion = Result.Companion;
                    localObject6 = paramd;
                    localObject5 = paramh;
                    ((kotlin.d.d)localObject8).resumeWith(Result.constructor-impl(localah));
                  }
                  localObject6 = paramd;
                  localObject5 = paramh;
                  localObject8 = ((q)localObject7).getResult();
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (localObject8 == a.aiwj)
                  {
                    localObject6 = paramd;
                    localObject5 = paramh;
                    s.u(localObject4, "frame");
                  }
                  localObject7 = localObject8;
                  localObject6 = paramd;
                  localObject5 = paramh;
                  if (localObject8 != a.aiwj)
                  {
                    localObject6 = paramd;
                    localObject5 = paramh;
                    localObject7 = kotlin.ah.aiuX;
                  }
                  if (localObject7 != locala) {
                    continue;
                  }
                  AppMethodBeat.o(189088);
                  return locala;
                }
                finally
                {
                  localObject2 = localObject1;
                  localObject1 = paramh;
                  paramh = (h<? super T>)localObject2;
                }
                localObject4 = paramd.Ze;
                localObject5 = (cb)paramd.VD;
                localObject3 = (ai)paramd.VC;
                localObject6 = (h)paramd.Uf;
                localObject2 = (ag)paramd.L$0;
                localObject1 = localObject3;
                paramh = (h<? super T>)localObject2;
                ResultKt.throwOnFailure(localObject7);
                localObject1 = localObject6;
                paramh = (h<? super T>)localObject2;
                localObject2 = paramd;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject5;
                localObject5 = localObject1;
                localObject1 = paramd;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject3;
                localObject3 = localObject5;
                continue;
                paramd = finally;
                localObject2 = paramh;
                paramh = (h<? super T>)localObject1;
                localObject1 = localObject2;
                break;
                paramd = finally;
                break;
                break;
                localObject5 = paramd;
                localObject6 = localObject3;
                paramd = (kotlin.d.d<? super kotlin.ah>)localObject2;
                localObject2 = localObject4;
                localObject4 = localObject1;
                localObject3 = localObject5;
                localObject1 = localObject6;
                continue;
              }
              localObject4 = localObject1;
              localObject5 = paramd;
              paramd = (kotlin.d.d<? super kotlin.ah>)localObject2;
              localObject1 = localObject7;
              localObject2 = localObject4;
              localObject4 = localObject5;
              continue;
            }
            localObject5 = localObject4;
            localObject6 = localObject1;
            Object localObject4 = localObject2;
            localObject1 = localObject5;
            localObject2 = localObject6;
            continue;
            localObject5 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject4;
            localObject4 = localObject5;
            continue;
          }
          finally
          {
            Object localObject5;
            Object localObject6;
            label1290:
            paramh = (h<? super T>)localObject6;
            localObject1 = localObject5;
          }
          localObject1 = this;
          localObject3 = paramh;
          paramh = (h<? super T>)localObject2;
          continue;
          break;
          label1313:
          int i = 0;
          continue;
          label1318:
          i = 0;
          continue;
          label1323:
          i = 0;
          continue;
          label1328:
          i = 0;
        }
      }
    }
  }
  
  public final boolean ad(T paramT1, T paramT2)
  {
    AppMethodBeat.i(189054);
    Object localObject = paramT1;
    if (paramT1 == null) {
      localObject = u.ajzN;
    }
    paramT1 = paramT2;
    if (paramT2 == null) {
      paramT1 = u.ajzN;
    }
    boolean bool = ae(localObject, paramT1);
    AppMethodBeat.o(189054);
    return bool;
  }
  
  public final g<T> b(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189100);
    paramf = ah.a((af)this, paramf, paramInt, paramg);
    AppMethodBeat.o(189100);
    return paramf;
  }
  
  public final T getValue()
  {
    ac localac = u.ajzN;
    Object localObject2 = this._state;
    Object localObject1 = localObject2;
    if (localObject2 == localac) {
      localObject1 = null;
    }
    return localObject1;
  }
  
  public final boolean jc(T paramT)
  {
    AppMethodBeat.i(189062);
    setValue(paramT);
    AppMethodBeat.o(189062);
    return true;
  }
  
  public final void setValue(T paramT)
  {
    AppMethodBeat.i(189045);
    Object localObject = paramT;
    if (paramT == null) {
      localObject = u.ajzN;
    }
    ae(null, localObject);
    AppMethodBeat.o(189045);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    Object Ze;
    int label;
    
    a(ag<T> paramag, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189132);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ajzc.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(189132);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.ag
 * JD-Core Version:    0.7.0.1
 */