package kotlinx.coroutines.b.a;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.g.b.s;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "<set-?>", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots$annotations", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<S extends d<?>>
{
  private S[] ajzg;
  private int ajzh;
  private x<Integer> ajzi;
  private int nextIndex;
  
  protected final void a(S paramS)
  {
    int i = 0;
    x localx;
    try
    {
      this.ajzh -= 1;
      localx = this.ajzi;
      if (this.ajzh == 0) {
        this.nextIndex = 0;
      }
      paramS = paramS.jh(this);
      int k = paramS.length;
      while (i < k)
      {
        Object localObject = paramS[i];
        int j = i + 1;
        i = j;
        if (localObject != null)
        {
          kotlin.ah localah = kotlin.ah.aiuX;
          Result.Companion localCompanion = Result.Companion;
          localObject.resumeWith(Result.constructor-impl(localah));
          i = j;
        }
      }
      if (localx == null) {
        return;
      }
    }
    finally {}
    kotlinx.coroutines.b.ah.a(localx, -1);
  }
  
  protected abstract S kDE();
  
  protected abstract S[] kDF();
  
  protected final S[] kDI()
  {
    return this.ajzg;
  }
  
  protected final int kDJ()
  {
    return this.ajzh;
  }
  
  protected final S kDK()
  {
    try
    {
      Object localObject1 = this.ajzg;
      int i;
      if (localObject1 == null)
      {
        localObject1 = kDF();
        this.ajzg = ((d[])localObject1);
        i = this.nextIndex;
      }
      for (;;)
      {
        d locald = localObject1[i];
        if (locald == null)
        {
          locald = kDE();
          localObject1[i] = locald;
        }
        for (;;)
        {
          int j = i + 1;
          i = j;
          if (j >= localObject1.length) {
            i = 0;
          }
          if (!locald.jg(this)) {
            break label155;
          }
          this.nextIndex = i;
          this.ajzh += 1;
          localObject1 = this.ajzi;
          if (localObject1 != null) {
            kotlinx.coroutines.b.ah.a((x)localObject1, 1);
          }
          return locald;
          if (this.ajzh >= localObject1.length)
          {
            localObject1 = Arrays.copyOf((Object[])localObject1, localObject1.length * 2);
            s.s(localObject1, "java.util.Arrays.copyOf(this, newSize)");
            this.ajzg = ((d[])localObject1);
            localObject1 = (d[])localObject1;
            break;
          }
          break;
        }
      }
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.b
 * JD-Core Version:    0.7.0.1
 */