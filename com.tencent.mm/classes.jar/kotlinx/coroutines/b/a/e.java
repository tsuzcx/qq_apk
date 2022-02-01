package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.a.u;
import kotlinx.coroutines.a.v;
import kotlinx.coroutines.a.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.as;
import kotlinx.coroutines.au;

@Metadata(d1={""}, d2={"Lkotlinx/coroutines/flow/internal/ChannelFlow;", "T", "Lkotlinx/coroutines/flow/internal/FusibleFlow;", "context", "Lkotlin/coroutines/CoroutineContext;", "capacity", "", "onBufferOverflow", "Lkotlinx/coroutines/channels/BufferOverflow;", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "collectToFun", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/coroutines/Continuation;", "", "", "getCollectToFun$kotlinx_coroutines_core", "()Lkotlin/jvm/functions/Function2;", "produceCapacity", "getProduceCapacity$kotlinx_coroutines_core", "()I", "additionalToStringProps", "", "collect", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectTo", "scope", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "create", "dropChannelOperators", "Lkotlinx/coroutines/flow/Flow;", "fuse", "produceImpl", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Lkotlinx/coroutines/CoroutineScope;", "toString", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class e<T>
  implements r<T>
{
  public final f aMa;
  public final kotlinx.coroutines.a.g ajxw;
  public final int cZV;
  
  public e(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    this.aMa = paramf;
    this.cZV = paramInt;
    this.ajxw = paramg;
    if (au.ASSERTIONS_ENABLED)
    {
      if (this.cZV != -1) {}
      for (paramInt = 1; paramInt == 0; paramInt = 0) {
        throw new AssertionError();
      }
    }
  }
  
  protected abstract Object a(v<? super T> paramv, d<? super ah> paramd);
  
  public Object a(kotlinx.coroutines.b.h<? super T> paramh, d<? super ah> paramd)
  {
    paramd = ar.c((m)new e.a(paramh, this, null), paramd);
    paramh = paramd;
    if (paramd != a.aiwj) {
      paramh = ah.aiuX;
    }
    return paramh;
  }
  
  protected abstract e<T> a(f paramf, int paramInt, kotlinx.coroutines.a.g paramg);
  
  public x<T> b(aq paramaq)
  {
    f localf = this.aMa;
    if (this.cZV == -3) {}
    for (int i = -2;; i = this.cZV)
    {
      Object localObject = this.ajxw;
      as localas = as.ajvM;
      m localm = kDL();
      localObject = kotlinx.coroutines.a.k.a(i, (kotlinx.coroutines.a.g)localObject, 4);
      paramaq = new u(ak.a(paramaq, localf), (kotlinx.coroutines.a.h)localObject);
      paramaq.a(localas, paramaq, localm);
      return (x)paramaq;
    }
  }
  
  public final kotlinx.coroutines.b.g<T> b(f paramf, int paramInt, kotlinx.coroutines.a.g paramg)
  {
    int j = 1;
    if (au.ASSERTIONS_ENABLED)
    {
      if (paramInt != -1) {}
      for (i = 1; i == 0; i = 0) {
        throw new AssertionError();
      }
    }
    f localf = paramf.plus(this.aMa);
    int i = paramInt;
    paramf = paramg;
    if (paramg == kotlinx.coroutines.a.g.ajxx)
    {
      if (this.cZV != -3) {
        break label111;
      }
      i = paramInt;
    }
    for (;;)
    {
      paramf = this.ajxw;
      if ((!s.p(localf, this.aMa)) || (i != this.cZV) || (paramf != this.ajxw)) {
        break;
      }
      return (kotlinx.coroutines.b.g)this;
      label111:
      if (paramInt == -3)
      {
        i = this.cZV;
      }
      else
      {
        i = paramInt;
        if (this.cZV != -2) {
          if (paramInt == -2)
          {
            i = this.cZV;
          }
          else
          {
            if (au.ASSERTIONS_ENABLED)
            {
              if (this.cZV >= 0) {}
              for (i = 1; i == 0; i = 0) {
                throw new AssertionError();
              }
            }
            if (au.ASSERTIONS_ENABLED)
            {
              if (paramInt >= 0) {}
              for (i = j; i == 0; i = 0) {
                throw new AssertionError();
              }
            }
            paramInt += this.cZV;
            i = paramInt;
            if (paramInt < 0) {
              i = 2147483647;
            }
          }
        }
      }
    }
    return (kotlinx.coroutines.b.g)a(localf, i, paramf);
  }
  
  public final m<v<? super T>, d<? super ah>, Object> kDL()
  {
    return (m)new b(this, null);
  }
  
  protected String kDx()
  {
    return null;
  }
  
  public String toString()
  {
    ArrayList localArrayList = new ArrayList(4);
    String str = kDx();
    if (str != null) {
      localArrayList.add(str);
    }
    if (this.aMa != kotlin.d.g.aiwf) {
      localArrayList.add(s.X("context=", this.aMa));
    }
    if (this.cZV != -3) {
      localArrayList.add(s.X("capacity=", Integer.valueOf(this.cZV)));
    }
    if (this.ajxw != kotlinx.coroutines.a.g.ajxx) {
      localArrayList.add(s.X("onBufferOverflow=", this.ajxw));
    }
    return getClass().getSimpleName() + '[' + p.a((Iterable)localArrayList, (CharSequence)", ", null, null, 0, null, null, 62) + ']';
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements m<v<? super T>, d<? super ah>, Object>
  {
    int label;
    
    b(e<T> parame, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(189180);
      paramd = new b(this.ajzl, paramd);
      paramd.L$0 = paramObject;
      paramObject = (d)paramd;
      AppMethodBeat.o(189180);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(189169);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(189169);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (v)this.L$0;
        e locale = this.ajzl;
        d locald = (d)this;
        this.label = 1;
        if (locale.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(189169);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(189169);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.e
 * JD-Core Version:    0.7.0.1
 */