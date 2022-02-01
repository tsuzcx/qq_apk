package kotlinx.coroutines.b;

import TT;;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<Lkotlin.ah;>;
import kotlin.d.f;
import kotlinx.coroutines.au;
import kotlinx.coroutines.b.a.r;
import kotlinx.coroutines.bi;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl;", "T", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/SharedFlowSlot;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "replay", "", "bufferCapacity", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(IILkotlinx/coroutines/channels/BufferOverflow;)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferEndIndex", "", "getBufferEndIndex", "()J", "bufferSize", "head", "getHead", "minCollectorIndex", "queueEndIndex", "getQueueEndIndex", "queueSize", "replayCache", "", "getReplayCache", "()Ljava/util/List;", "replayIndex", "replaySize", "getReplaySize", "()I", "totalSize", "getTotalSize", "awaitValue", "", "slot", "(Lkotlinx/coroutines/flow/SharedFlowSlot;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cancelEmitter", "emitter", "Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "cleanupTailLocked", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "correctCollectorIndexesOnDropOldest", "newHead", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/SharedFlowSlot;", "dropOldestLocked", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSuspend", "enqueueLocked", "item", "findSlotsToResumeLocked", "Lkotlin/coroutines/Continuation;", "resumesIn", "([Lkotlin/coroutines/Continuation;)[Lkotlin/coroutines/Continuation;", "fuse", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "getPeekedValueLockedAt", "index", "growBuffer", "curBuffer", "curSize", "newSize", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "resetReplayCache", "tryEmit", "", "(Ljava/lang/Object;)Z", "tryEmitLocked", "tryEmitNoCollectorsLocked", "tryPeekLocked", "tryTakeValue", "updateBufferLocked", "newReplayIndex", "newMinCollectorIndex", "newBufferEndIndex", "newQueueEndIndex", "updateCollectorIndexLocked", "oldIndex", "updateCollectorIndexLocked$kotlinx_coroutines_core", "(J)[Lkotlin/coroutines/Continuation;", "updateNewCollectorIndexLocked", "updateNewCollectorIndexLocked$kotlinx_coroutines_core", "Emitter", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
final class ac<T>
  extends kotlinx.coroutines.b.a.b<ae>
  implements r<T>, c<T>, w<T>
{
  private final kotlinx.coroutines.a.g ajxw;
  private final int ajyT;
  private final int ajyU;
  long ajyV;
  long ajyW;
  private int ajyX;
  private Object[] buffer;
  private int bufferSize;
  
  public ac(int paramInt1, int paramInt2, kotlinx.coroutines.a.g paramg)
  {
    this.ajyT = paramInt1;
    this.ajyU = paramInt2;
    this.ajxw = paramg;
  }
  
  private final void BM(long paramLong)
  {
    AppMethodBeat.i(189080);
    Object localObject = (kotlinx.coroutines.b.a.b)this;
    if (kotlinx.coroutines.b.a.b.a((kotlinx.coroutines.b.a.b)localObject) != 0)
    {
      localObject = kotlinx.coroutines.b.a.b.b((kotlinx.coroutines.b.a.b)localObject);
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          ae localae = localObject[i];
          if (localae != null)
          {
            localae = (ae)localae;
            if ((localae.Dpr >= 0L) && (localae.Dpr < paramLong)) {
              localae.Dpr = paramLong;
            }
          }
          i += 1;
        }
      }
    }
    this.ajyW = paramLong;
    AppMethodBeat.o(189080);
  }
  
  private final Object a(ae paramae)
  {
    AppMethodBeat.i(189137);
    Object localObject1 = kotlinx.coroutines.b.a.c.ajzj;
    try
    {
      long l1 = b(paramae);
      Object localObject2;
      if (l1 < 0L)
      {
        localObject2 = ad.ajzb;
        paramae = (ae)localObject1;
        localObject1 = localObject2;
      }
      for (;;)
      {
        int i = 0;
        int k = paramae.length;
        while (i < k)
        {
          localObject2 = paramae[i];
          int j = i + 1;
          i = j;
          if (localObject2 != null)
          {
            ah localah = ah.aiuX;
            Result.Companion localCompanion = Result.Companion;
            ((kotlin.d.d)localObject2).resumeWith(Result.constructor-impl(localah));
            i = j;
          }
        }
        long l2 = paramae.Dpr;
        localObject1 = this.buffer;
        kotlin.g.b.s.checkNotNull(localObject1);
        localObject2 = ad.a((Object[])localObject1, l1);
        localObject1 = localObject2;
        if ((localObject2 instanceof a)) {
          localObject1 = ((a)localObject2).value;
        }
        paramae.Dpr = (l1 + 1L);
        paramae = BN(l2);
      }
      AppMethodBeat.o(189137);
    }
    finally
    {
      AppMethodBeat.o(189137);
    }
    return localObject1;
  }
  
  private final Object a(ae paramae, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189152);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    Object localObject = (p)localq;
    try
    {
      if (b(paramae) < 0L)
      {
        paramae.ajyZ = ((kotlin.d.d)localObject);
        paramae.ajyZ = ((kotlin.d.d)localObject);
      }
      for (;;)
      {
        paramae = ah.aiuX;
        paramae = localq.getResult();
        if (paramae == a.aiwj) {
          kotlin.g.b.s.u(paramd, "frame");
        }
        if (paramae != a.aiwj) {
          break;
        }
        AppMethodBeat.o(189152);
        return paramae;
        paramae = (kotlin.d.d)localObject;
        localObject = ah.aiuX;
        Result.Companion localCompanion = Result.Companion;
        paramae.resumeWith(Result.constructor-impl(localObject));
      }
      paramae = ah.aiuX;
    }
    finally
    {
      AppMethodBeat.o(189152);
    }
    AppMethodBeat.o(189152);
    return paramae;
  }
  
  private final kotlin.d.d<ah>[] a(kotlin.d.d<ah>[] paramArrayOfd)
  {
    AppMethodBeat.i(189161);
    int i = paramArrayOfd.length;
    Object localObject = (kotlinx.coroutines.b.a.b)this;
    if (kotlinx.coroutines.b.a.b.a((kotlinx.coroutines.b.a.b)localObject) != 0)
    {
      kotlinx.coroutines.b.a.d[] arrayOfd = kotlinx.coroutines.b.a.b.b((kotlinx.coroutines.b.a.b)localObject);
      if (arrayOfd != null)
      {
        int k = arrayOfd.length;
        int j = 0;
        while (j < k)
        {
          localObject = arrayOfd[j];
          if (localObject == null) {
            break label171;
          }
          ae localae = (ae)localObject;
          kotlin.d.d locald = localae.ajyZ;
          if ((locald == null) || (b(localae) < 0L)) {
            break label171;
          }
          localObject = paramArrayOfd;
          if (i >= ((Object[])paramArrayOfd).length)
          {
            localObject = Arrays.copyOf((Object[])paramArrayOfd, Math.max(2, ((Object[])paramArrayOfd).length * 2));
            kotlin.g.b.s.s(localObject, "java.util.Arrays.copyOf(this, newSize)");
          }
          ((kotlin.d.d[])localObject)[i] = locald;
          localae.ajyZ = null;
          i += 1;
          paramArrayOfd = (kotlin.d.d<ah>[])localObject;
          j += 1;
        }
      }
    }
    for (;;)
    {
      paramArrayOfd = (kotlin.d.d[])paramArrayOfd;
      AppMethodBeat.o(189161);
      return paramArrayOfd;
      label171:
      break;
    }
  }
  
  private final long b(ae paramae)
  {
    AppMethodBeat.i(189143);
    long l = paramae.Dpr;
    if (l < kDA())
    {
      AppMethodBeat.o(189143);
      return l;
    }
    if (this.ajyU > 0)
    {
      AppMethodBeat.o(189143);
      return -1L;
    }
    if (l > kDy())
    {
      AppMethodBeat.o(189143);
      return -1L;
    }
    if (this.ajyX == 0)
    {
      AppMethodBeat.o(189143);
      return -1L;
    }
    AppMethodBeat.o(189143);
    return l;
  }
  
  private final Object f(T paramT, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189111);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    Object localObject3 = (p)localq;
    Object localObject1 = kotlinx.coroutines.b.a.c.ajzj;
    for (;;)
    {
      Object localObject2;
      try
      {
        if (jd(paramT))
        {
          paramT = (kotlin.d.d)localObject3;
          localObject2 = ah.aiuX;
          Result.Companion localCompanion = Result.Companion;
          paramT.resumeWith(Result.constructor-impl(localObject2));
          paramT = a((kotlin.d.d[])localObject1);
          localObject1 = null;
          if (localObject1 != null) {
            kotlinx.coroutines.s.a((p)localObject3, (bi)localObject1);
          }
          int i = 0;
          int k = paramT.length;
          if (i < k)
          {
            localObject1 = paramT[i];
            int j = i + 1;
            i = j;
            if (localObject1 == null) {
              continue;
            }
            localObject2 = ah.aiuX;
            localObject3 = Result.Companion;
            ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
            i = j;
            continue;
          }
        }
        else
        {
          localObject2 = new a(this, kDy() + getTotalSize(), paramT, (kotlin.d.d)localObject3);
          jf(localObject2);
          this.ajyX += 1;
          if (this.ajyU != 0) {
            break label280;
          }
          paramT = a((kotlin.d.d[])localObject1);
          localObject1 = localObject2;
          continue;
        }
        paramT = localq.getResult();
      }
      finally
      {
        AppMethodBeat.o(189111);
      }
      if (paramT == a.aiwj) {
        kotlin.g.b.s.u(paramd, "frame");
      }
      if (paramT == a.aiwj)
      {
        AppMethodBeat.o(189111);
        return paramT;
      }
      paramT = ah.aiuX;
      AppMethodBeat.o(189111);
      return paramT;
      label280:
      paramT = (TT)localObject1;
      localObject1 = localObject2;
    }
  }
  
  private final void f(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    AppMethodBeat.i(189120);
    long l3 = Math.min(paramLong2, paramLong1);
    int i;
    Object localObject;
    if (au.ASSERTIONS_ENABLED)
    {
      if (l3 >= kDy()) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject = new AssertionError();
        AppMethodBeat.o(189120);
        throw ((Throwable)localObject);
      }
    }
    long l1 = kDy();
    if (l1 < l3) {}
    for (;;)
    {
      long l2 = 1L + l1;
      localObject = this.buffer;
      kotlin.g.b.s.checkNotNull(localObject);
      ad.a((Object[])localObject, l1, null);
      if (l2 >= l3)
      {
        this.ajyV = paramLong1;
        this.ajyW = paramLong2;
        this.bufferSize = ((int)(paramLong3 - l3));
        this.ajyX = ((int)(paramLong4 - paramLong3));
        if (au.ASSERTIONS_ENABLED)
        {
          if (this.bufferSize >= 0) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject = new AssertionError();
            AppMethodBeat.o(189120);
            throw ((Throwable)localObject);
          }
        }
        if (au.ASSERTIONS_ENABLED)
        {
          if (this.ajyX >= 0) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject = new AssertionError();
            AppMethodBeat.o(189120);
            throw ((Throwable)localObject);
          }
        }
        if (au.ASSERTIONS_ENABLED)
        {
          if (this.ajyV <= kDy() + this.bufferSize) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject = new AssertionError();
            AppMethodBeat.o(189120);
            throw ((Throwable)localObject);
          }
        }
        AppMethodBeat.o(189120);
        return;
      }
      l1 = l2;
    }
  }
  
  private final Object[] g(Object[] paramArrayOfObject, int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(189103);
    if (paramInt2 > 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramArrayOfObject = (Throwable)new IllegalStateException("Buffer size overflow".toString());
      AppMethodBeat.o(189103);
      throw paramArrayOfObject;
    }
    Object[] arrayOfObject = new Object[paramInt2];
    this.buffer = arrayOfObject;
    if (paramArrayOfObject == null)
    {
      AppMethodBeat.o(189103);
      return arrayOfObject;
    }
    long l = kDy();
    if (paramInt1 > 0) {}
    for (paramInt2 = j;; paramInt2 = i)
    {
      i = paramInt2 + 1;
      ad.a(arrayOfObject, paramInt2 + l, ad.a(paramArrayOfObject, paramInt2 + l));
      if (i >= paramInt1)
      {
        AppMethodBeat.o(189103);
        return arrayOfObject;
      }
    }
  }
  
  private final int getTotalSize()
  {
    return this.bufferSize + this.ajyX;
  }
  
  private final boolean jd(T paramT)
  {
    AppMethodBeat.i(189056);
    if (kDJ() == 0)
    {
      boolean bool = je(paramT);
      AppMethodBeat.o(189056);
      return bool;
    }
    kotlinx.coroutines.a.g localg;
    if ((this.bufferSize >= this.ajyU) && (this.ajyW <= this.ajyV)) {
      localg = this.ajxw;
    }
    switch (b.$EnumSwitchMapping$0[localg.ordinal()])
    {
    default: 
      jf(paramT);
      this.bufferSize += 1;
      if (this.bufferSize > this.ajyU) {
        kDC();
      }
      if (kDz() > this.ajyT) {
        f(this.ajyV + 1L, this.ajyW, kDA(), kDB());
      }
      AppMethodBeat.o(189056);
      return true;
    case 1: 
      AppMethodBeat.o(189056);
      return false;
    }
    AppMethodBeat.o(189056);
    return true;
  }
  
  private final boolean je(T paramT)
  {
    AppMethodBeat.i(189061);
    if (au.ASSERTIONS_ENABLED)
    {
      if (kDJ() == 0) {}
      for (int i = 1; i == 0; i = 0)
      {
        paramT = new AssertionError();
        AppMethodBeat.o(189061);
        throw paramT;
      }
    }
    if (this.ajyT == 0)
    {
      AppMethodBeat.o(189061);
      return true;
    }
    jf(paramT);
    this.bufferSize += 1;
    if (this.bufferSize > this.ajyT) {
      kDC();
    }
    this.ajyW = (kDy() + this.bufferSize);
    AppMethodBeat.o(189061);
    return true;
  }
  
  private final void jf(Object paramObject)
  {
    AppMethodBeat.i(189091);
    int i = getTotalSize();
    Object[] arrayOfObject2 = this.buffer;
    Object[] arrayOfObject1;
    if (arrayOfObject2 == null) {
      arrayOfObject1 = g(null, 0, 2);
    }
    for (;;)
    {
      ad.a(arrayOfObject1, kDy() + i, paramObject);
      AppMethodBeat.o(189091);
      return;
      arrayOfObject1 = arrayOfObject2;
      if (i >= arrayOfObject2.length) {
        arrayOfObject1 = g(arrayOfObject2, i, arrayOfObject2.length * 2);
      }
    }
  }
  
  private final long kDA()
  {
    AppMethodBeat.i(189042);
    long l1 = kDy();
    long l2 = this.bufferSize;
    AppMethodBeat.o(189042);
    return l1 + l2;
  }
  
  private final long kDB()
  {
    AppMethodBeat.i(189046);
    long l1 = kDy();
    long l2 = this.bufferSize;
    long l3 = this.ajyX;
    AppMethodBeat.o(189046);
    return l1 + l2 + l3;
  }
  
  private final void kDC()
  {
    AppMethodBeat.i(189069);
    Object localObject = this.buffer;
    kotlin.g.b.s.checkNotNull(localObject);
    ad.a((Object[])localObject, kDy(), null);
    this.bufferSize -= 1;
    long l = kDy() + 1L;
    if (this.ajyV < l) {
      this.ajyV = l;
    }
    if (this.ajyW < l) {
      BM(l);
    }
    if (au.ASSERTIONS_ENABLED)
    {
      if (kDy() == l) {}
      for (int i = 1; i == 0; i = 0)
      {
        localObject = new AssertionError();
        AppMethodBeat.o(189069);
        throw ((Throwable)localObject);
      }
    }
    AppMethodBeat.o(189069);
  }
  
  private final void kDD()
  {
    AppMethodBeat.i(189129);
    if ((this.ajyU == 0) && (this.ajyX <= 1))
    {
      AppMethodBeat.o(189129);
      return;
    }
    Object[] arrayOfObject = this.buffer;
    kotlin.g.b.s.checkNotNull(arrayOfObject);
    while ((this.ajyX > 0) && (ad.a(arrayOfObject, kDy() + getTotalSize() - 1L) == ad.ajzb))
    {
      this.ajyX -= 1;
      ad.a(arrayOfObject, kDy() + getTotalSize(), null);
    }
    AppMethodBeat.o(189129);
  }
  
  private final long kDy()
  {
    AppMethodBeat.i(189020);
    long l = Math.min(this.ajyW, this.ajyV);
    AppMethodBeat.o(189020);
    return l;
  }
  
  private final int kDz()
  {
    AppMethodBeat.i(189024);
    int i = (int)(kDy() + this.bufferSize - this.ajyV);
    AppMethodBeat.o(189024);
    return i;
  }
  
  public final kotlin.d.d<ah>[] BN(long paramLong)
  {
    AppMethodBeat.i(189209);
    int i;
    Object localObject1;
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramLong >= this.ajyW) {}
      for (i = 1; i == 0; i = 0)
      {
        localObject1 = new AssertionError();
        AppMethodBeat.o(189209);
        throw ((Throwable)localObject1);
      }
    }
    if (paramLong > this.ajyW)
    {
      localObject1 = kotlinx.coroutines.b.a.c.ajzj;
      AppMethodBeat.o(189209);
      return localObject1;
    }
    long l4 = kDy();
    paramLong = this.bufferSize + l4;
    if ((this.ajyU == 0) && (this.ajyX > 0)) {
      paramLong += 1L;
    }
    for (;;)
    {
      localObject1 = (kotlinx.coroutines.b.a.b)this;
      long l1 = paramLong;
      int j;
      Object localObject2;
      if (kotlinx.coroutines.b.a.b.a((kotlinx.coroutines.b.a.b)localObject1) != 0)
      {
        localObject1 = kotlinx.coroutines.b.a.b.b((kotlinx.coroutines.b.a.b)localObject1);
        l1 = paramLong;
        if (localObject1 != null)
        {
          j = localObject1.length;
          i = 0;
          l1 = paramLong;
          if (i < j)
          {
            localObject2 = localObject1[i];
            if (localObject2 == null) {
              break label667;
            }
            localObject2 = (ae)localObject2;
            if ((((ae)localObject2).Dpr < 0L) || (((ae)localObject2).Dpr >= paramLong)) {
              break label667;
            }
            paramLong = ((ae)localObject2).Dpr;
          }
        }
      }
      label651:
      label658:
      label661:
      label664:
      label667:
      for (;;)
      {
        i += 1;
        break;
        if (au.ASSERTIONS_ENABLED)
        {
          if (l1 >= this.ajyW) {}
          for (i = 1; i == 0; i = 0)
          {
            localObject1 = new AssertionError();
            AppMethodBeat.o(189209);
            throw ((Throwable)localObject1);
          }
        }
        if (l1 <= this.ajyW)
        {
          localObject1 = kotlinx.coroutines.b.a.c.ajzj;
          AppMethodBeat.o(189209);
          return localObject1;
        }
        paramLong = kDA();
        if (kDJ() > 0) {
          i = (int)(paramLong - l1);
        }
        long l5;
        long l3;
        Object localObject3;
        for (i = Math.min(this.ajyX, this.ajyU - i);; i = this.ajyX)
        {
          localObject1 = kotlinx.coroutines.b.a.c.ajzj;
          l5 = paramLong + this.ajyX;
          if (i <= 0) {
            break label664;
          }
          localObject1 = new kotlin.d.d[i];
          localObject2 = this.buffer;
          kotlin.g.b.s.checkNotNull(localObject2);
          if (paramLong >= l5) {
            break label661;
          }
          l2 = paramLong;
          j = 0;
          l3 = l2 + 1L;
          localObject3 = ad.a((Object[])localObject2, l2);
          if (localObject3 == ad.ajzb) {
            break label658;
          }
          if (localObject3 != null) {
            break;
          }
          localObject1 = new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.flow.SharedFlowImpl.Emitter");
          AppMethodBeat.o(189209);
          throw ((Throwable)localObject1);
        }
        int k = j + 1;
        localObject1[j] = ((a)localObject3).ajyZ;
        ad.a((Object[])localObject2, l2, ad.ajzb);
        ad.a((Object[])localObject2, paramLong, ((a)localObject3).value);
        long l2 = 1L + paramLong;
        paramLong = l2;
        if (k < i)
        {
          j = k;
          paramLong = l2;
          label475:
          if (l3 < l5) {
            break label651;
          }
        }
        for (;;)
        {
          i = (int)(paramLong - l4);
          if (kDJ() == 0) {
            l1 = paramLong;
          }
          for (;;)
          {
            l3 = Math.max(this.ajyV, paramLong - Math.min(this.ajyT, i));
            if ((this.ajyU == 0) && (l3 < l5))
            {
              localObject2 = this.buffer;
              kotlin.g.b.s.checkNotNull(localObject2);
              if (kotlin.g.b.s.p(ad.a((Object[])localObject2, l3), ad.ajzb))
              {
                l3 += 1L;
                l2 = paramLong + 1L;
              }
            }
            for (paramLong = l3;; paramLong = l3)
            {
              f(paramLong, l1, l2, l5);
              kDD();
              if (localObject1.length == 0)
              {
                i = 1;
                if (i != 0) {
                  break label634;
                }
              }
              label634:
              for (i = 1;; i = 0)
              {
                localObject2 = localObject1;
                if (i != 0) {
                  localObject2 = a((kotlin.d.d[])localObject1);
                }
                AppMethodBeat.o(189209);
                return localObject2;
                i = 0;
                break;
              }
              l2 = paramLong;
            }
          }
          l2 = l3;
          break;
          break label475;
        }
      }
    }
  }
  
  public final Object a(T paramT, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(189197);
    if (jc(paramT))
    {
      paramT = ah.aiuX;
      AppMethodBeat.o(189197);
      return paramT;
    }
    paramT = f(paramT, paramd);
    if (paramT == a.aiwj)
    {
      AppMethodBeat.o(189197);
      return paramT;
    }
    paramT = ah.aiuX;
    AppMethodBeat.o(189197);
    return paramT;
  }
  
  /* Error */
  public final Object a(h<? super T> paramh, kotlin.d.d<? super ah> paramd)
  {
    // Byte code:
    //   0: ldc_w 431
    //   3: invokestatic 153	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_2
    //   7: instanceof 19
    //   10: ifeq +101 -> 111
    //   13: aload_2
    //   14: checkcast 19	kotlinx/coroutines/b/ac$c
    //   17: astore 7
    //   19: aload 7
    //   21: getfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   24: ldc_w 435
    //   27: iand
    //   28: ifeq +83 -> 111
    //   31: aload 7
    //   33: aload 7
    //   35: getfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   38: ldc_w 435
    //   41: iadd
    //   42: putfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   45: aload 7
    //   47: getfield 438	kotlinx/coroutines/b/ac$c:result	Ljava/lang/Object;
    //   50: astore 9
    //   52: getstatic 257	kotlin/d/a/a:aiwj	Lkotlin/d/a/a;
    //   55: astore 8
    //   57: aload 7
    //   59: getfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   62: tableswitch	default:+30 -> 92, 0:+63->125, 1:+134->196, 2:+312->374, 3:+471->533
    //   93: aconst_null
    //   94: fadd
    //   95: dup
    //   96: ldc_w 440
    //   99: invokespecial 365	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   102: astore_1
    //   103: ldc_w 431
    //   106: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: athrow
    //   111: new 19	kotlinx/coroutines/b/ac$c
    //   114: dup
    //   115: aload_0
    //   116: aload_2
    //   117: invokespecial 443	kotlinx/coroutines/b/ac$c:<init>	(Lkotlinx/coroutines/b/ac;Lkotlin/d/d;)V
    //   120: astore 7
    //   122: goto -77 -> 45
    //   125: aload 9
    //   127: invokestatic 448	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   130: aload_0
    //   131: invokevirtual 452	kotlinx/coroutines/b/ac:kDK	()Lkotlinx/coroutines/b/a/d;
    //   134: checkcast 161	kotlinx/coroutines/b/ae
    //   137: astore_2
    //   138: aload_1
    //   139: instanceof 454
    //   142: ifeq +451 -> 593
    //   145: aload 7
    //   147: aload_0
    //   148: putfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   151: aload 7
    //   153: aload_1
    //   154: putfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   157: aload 7
    //   159: aload_2
    //   160: putfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   163: aload 7
    //   165: iconst_1
    //   166: putfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   169: ldc_w 431
    //   172: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aconst_null
    //   176: athrow
    //   177: astore_3
    //   178: aload_0
    //   179: astore_1
    //   180: aload_1
    //   181: aload_2
    //   182: checkcast 465	kotlinx/coroutines/b/a/d
    //   185: invokevirtual 468	kotlinx/coroutines/b/ac:a	(Lkotlinx/coroutines/b/a/d;)V
    //   188: ldc_w 431
    //   191: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   194: aload_3
    //   195: athrow
    //   196: aload 7
    //   198: getfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   201: checkcast 161	kotlinx/coroutines/b/ae
    //   204: astore_2
    //   205: aload 7
    //   207: getfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   210: checkcast 470	kotlinx/coroutines/b/h
    //   213: astore_3
    //   214: aload 7
    //   216: getfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   219: checkcast 2	kotlinx/coroutines/b/ac
    //   222: astore_1
    //   223: aload 9
    //   225: invokestatic 448	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   228: aload 7
    //   230: invokeinterface 474 1 0
    //   235: getstatic 480	kotlinx/coroutines/cb:ajws	Lkotlinx/coroutines/cb$b;
    //   238: checkcast 482	kotlin/d/f$c
    //   241: invokeinterface 488 2 0
    //   246: checkcast 476	kotlinx/coroutines/cb
    //   249: astore 5
    //   251: aload_1
    //   252: astore 4
    //   254: aload_3
    //   255: astore 6
    //   257: aload_2
    //   258: astore_3
    //   259: aload_3
    //   260: astore_2
    //   261: aload 4
    //   263: astore_1
    //   264: aload 4
    //   266: aload_3
    //   267: invokespecial 490	kotlinx/coroutines/b/ac:a	(Lkotlinx/coroutines/b/ae;)Ljava/lang/Object;
    //   270: astore 9
    //   272: aload_3
    //   273: astore_2
    //   274: aload 4
    //   276: astore_1
    //   277: aload 9
    //   279: getstatic 186	kotlinx/coroutines/b/ad:ajzb	Lkotlinx/coroutines/internal/ac;
    //   282: if_acmpne +144 -> 426
    //   285: aload_3
    //   286: astore_2
    //   287: aload 4
    //   289: astore_1
    //   290: aload 7
    //   292: aload 4
    //   294: putfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   297: aload_3
    //   298: astore_2
    //   299: aload 4
    //   301: astore_1
    //   302: aload 7
    //   304: aload 6
    //   306: putfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   309: aload_3
    //   310: astore_2
    //   311: aload 4
    //   313: astore_1
    //   314: aload 7
    //   316: aload_3
    //   317: putfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   320: aload_3
    //   321: astore_2
    //   322: aload 4
    //   324: astore_1
    //   325: aload 7
    //   327: aload 5
    //   329: putfield 493	kotlinx/coroutines/b/ac$c:VD	Ljava/lang/Object;
    //   332: aload_3
    //   333: astore_2
    //   334: aload 4
    //   336: astore_1
    //   337: aload 7
    //   339: iconst_2
    //   340: putfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   343: aload_3
    //   344: astore_2
    //   345: aload 4
    //   347: astore_1
    //   348: aload 4
    //   350: aload_3
    //   351: aload 7
    //   353: invokespecial 495	kotlinx/coroutines/b/ac:a	(Lkotlinx/coroutines/b/ae;Lkotlin/d/d;)Ljava/lang/Object;
    //   356: astore 9
    //   358: aload 9
    //   360: aload 8
    //   362: if_acmpne -103 -> 259
    //   365: ldc_w 431
    //   368: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   371: aload 8
    //   373: areturn
    //   374: aload 7
    //   376: getfield 493	kotlinx/coroutines/b/ac$c:VD	Ljava/lang/Object;
    //   379: checkcast 476	kotlinx/coroutines/cb
    //   382: astore 5
    //   384: aload 7
    //   386: getfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   389: checkcast 161	kotlinx/coroutines/b/ae
    //   392: astore_3
    //   393: aload 7
    //   395: getfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   398: checkcast 470	kotlinx/coroutines/b/h
    //   401: astore 6
    //   403: aload 7
    //   405: getfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   408: checkcast 2	kotlinx/coroutines/b/ac
    //   411: astore 4
    //   413: aload_3
    //   414: astore_2
    //   415: aload 4
    //   417: astore_1
    //   418: aload 9
    //   420: invokestatic 448	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   423: goto -164 -> 259
    //   426: aload 5
    //   428: ifnull +13 -> 441
    //   431: aload_3
    //   432: astore_2
    //   433: aload 4
    //   435: astore_1
    //   436: aload 5
    //   438: invokestatic 501	kotlinx/coroutines/cf:d	(Lkotlinx/coroutines/cb;)V
    //   441: aload_3
    //   442: astore_2
    //   443: aload 4
    //   445: astore_1
    //   446: aload 7
    //   448: aload 4
    //   450: putfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   453: aload_3
    //   454: astore_2
    //   455: aload 4
    //   457: astore_1
    //   458: aload 7
    //   460: aload 6
    //   462: putfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   465: aload_3
    //   466: astore_2
    //   467: aload 4
    //   469: astore_1
    //   470: aload 7
    //   472: aload_3
    //   473: putfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   476: aload_3
    //   477: astore_2
    //   478: aload 4
    //   480: astore_1
    //   481: aload 7
    //   483: aload 5
    //   485: putfield 493	kotlinx/coroutines/b/ac$c:VD	Ljava/lang/Object;
    //   488: aload_3
    //   489: astore_2
    //   490: aload 4
    //   492: astore_1
    //   493: aload 7
    //   495: iconst_3
    //   496: putfield 434	kotlinx/coroutines/b/ac$c:label	I
    //   499: aload_3
    //   500: astore_2
    //   501: aload 4
    //   503: astore_1
    //   504: aload 6
    //   506: aload 9
    //   508: aload 7
    //   510: invokeinterface 503 3 0
    //   515: astore 9
    //   517: aload 9
    //   519: aload 8
    //   521: if_acmpne -262 -> 259
    //   524: ldc_w 431
    //   527: invokestatic 169	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   530: aload 8
    //   532: areturn
    //   533: aload 7
    //   535: getfield 493	kotlinx/coroutines/b/ac$c:VD	Ljava/lang/Object;
    //   538: checkcast 476	kotlinx/coroutines/cb
    //   541: astore 5
    //   543: aload 7
    //   545: getfield 463	kotlinx/coroutines/b/ac$c:VC	Ljava/lang/Object;
    //   548: checkcast 161	kotlinx/coroutines/b/ae
    //   551: astore_3
    //   552: aload 7
    //   554: getfield 460	kotlinx/coroutines/b/ac$c:Uf	Ljava/lang/Object;
    //   557: checkcast 470	kotlinx/coroutines/b/h
    //   560: astore 6
    //   562: aload 7
    //   564: getfield 457	kotlinx/coroutines/b/ac$c:L$0	Ljava/lang/Object;
    //   567: checkcast 2	kotlinx/coroutines/b/ac
    //   570: astore 4
    //   572: aload_3
    //   573: astore_2
    //   574: aload 4
    //   576: astore_1
    //   577: aload 9
    //   579: invokestatic 448	kotlin/ResultKt:throwOnFailure	(Ljava/lang/Object;)V
    //   582: goto -323 -> 259
    //   585: astore_3
    //   586: goto -406 -> 180
    //   589: astore_3
    //   590: goto -410 -> 180
    //   593: aload_1
    //   594: astore_3
    //   595: aload_0
    //   596: astore_1
    //   597: goto -369 -> 228
    //   600: astore_3
    //   601: goto -421 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	ac
    //   0	604	1	paramh	h<? super T>
    //   0	604	2	paramd	kotlin.d.d<? super ah>
    //   177	18	3	localObject1	Object
    //   213	360	3	localObject2	Object
    //   585	1	3	localObject3	Object
    //   589	1	3	localObject4	Object
    //   594	1	3	localh	h<? super T>
    //   600	1	3	localObject5	Object
    //   252	323	4	localObject6	Object
    //   249	293	5	localcb	kotlinx.coroutines.cb
    //   255	306	6	localObject7	Object
    //   17	546	7	localc	c
    //   55	476	8	locala	a
    //   50	528	9	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   138	177	177	finally
    //   223	228	585	finally
    //   228	251	589	finally
    //   264	272	600	finally
    //   277	285	600	finally
    //   290	297	600	finally
    //   302	309	600	finally
    //   314	320	600	finally
    //   325	332	600	finally
    //   337	343	600	finally
    //   348	358	600	finally
    //   418	423	600	finally
    //   436	441	600	finally
    //   446	453	600	finally
    //   458	465	600	finally
    //   470	476	600	finally
    //   481	488	600	finally
    //   493	499	600	finally
    //   504	517	600	finally
    //   577	582	600	finally
  }
  
  public final g<T> b(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    AppMethodBeat.i(189217);
    paramf = ad.a((ab)this, paramf, paramInt, paramg);
    AppMethodBeat.o(189217);
    return paramf;
  }
  
  public final boolean jc(T paramT)
  {
    int i = 0;
    AppMethodBeat.i(189190);
    kotlin.d.d[] arrayOfd = kotlinx.coroutines.b.a.c.ajzj;
    try
    {
      if (jd(paramT))
      {
        paramT = a(arrayOfd);
        bool = true;
        int k = paramT.length;
        while (i < k)
        {
          arrayOfd = paramT[i];
          int j = i + 1;
          i = j;
          if (arrayOfd != null)
          {
            ah localah = ah.aiuX;
            Result.Companion localCompanion = Result.Companion;
            arrayOfd.resumeWith(Result.constructor-impl(localah));
            i = j;
          }
        }
      }
      boolean bool = false;
      return bool;
    }
    finally
    {
      AppMethodBeat.o(189190);
    }
  }
  
  @Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/SharedFlowImpl$Emitter;", "Lkotlinx/coroutines/DisposableHandle;", "flow", "Lkotlinx/coroutines/flow/SharedFlowImpl;", "index", "", "value", "", "cont", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlowImpl;JLjava/lang/Object;Lkotlin/coroutines/Continuation;)V", "dispose", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements bi
  {
    public long Dpr;
    public final ac<?> ajyY;
    public final kotlin.d.d<ah> ajyZ;
    public final Object value;
    
    public a(ac<?> paramac, long paramLong, Object paramObject, kotlin.d.d<? super ah> paramd)
    {
      this.ajyY = paramac;
      this.Dpr = paramLong;
      this.value = paramObject;
      this.ajyZ = paramd;
    }
    
    public final void dispose()
    {
      AppMethodBeat.i(189146);
      ac.a(this.ajyY, this);
      AppMethodBeat.o(189146);
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    c(ac<T> paramac, kotlin.d.d<? super c> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189148);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ajza.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(189148);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.ac
 * JD-Core Version:    0.7.0.1
 */