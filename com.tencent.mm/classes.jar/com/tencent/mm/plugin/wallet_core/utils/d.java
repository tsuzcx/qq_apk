package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.storage.ca;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.b.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.br;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageReportor;", "", "()V", "report", "", "messages", "", "Lcom/tencent/mm/storage/MsgInfo;", "eventType", "Lcom/tencent/mm/plugin/wallet_core/utils/MessageEventType;", "plugin-wxpay_release"})
public final class d
{
  public static void a(List<? extends ca> paramList, final c paramc)
  {
    AppMethodBeat.i(216523);
    p.k(paramList, "messages");
    p.k(paramc, "eventType");
    g.b((ak)br.abxo, null, (m)new a(paramList, paramc, null), 3);
    AppMethodBeat.o(216523);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"})
  static final class a
    extends j
    implements m<ak, kotlin.d.d<? super x>, Object>
  {
    int label;
    private ak p$;
    
    a(List paramList, c paramc, kotlin.d.d paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<x> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(192848);
      p.k(paramd, "completion");
      paramd = new a(this.Phl, paramc, paramd);
      paramd.p$ = ((ak)paramObject);
      AppMethodBeat.o(192848);
      return paramd;
    }
    
    public final Object invoke(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(192854);
      paramObject1 = ((a)create(paramObject1, (kotlin.d.d)paramObject2)).invokeSuspend(x.aazN);
      AppMethodBeat.o(192854);
      return paramObject1;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(192840);
      Object localObject1 = a.aaAA;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(192840);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Iterator localIterator = this.Phl.iterator();
      k.b localb;
      int i;
      Object localObject2;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ca localca = (ca)localIterator.next();
          if ((localca.erk()) && (localca.getContent() != null) && (localca.apJ() != null))
          {
            localb = k.b.OQ(localca.getContent());
            if (localb != null)
            {
              paramObject = e.Phn;
              paramObject = f.Phr;
              String str = localca.apJ();
              paramObject = "";
              if (localb.type == 2000)
              {
                paramObject = e.Pho;
                localObject1 = localb.lnf;
                if (localObject1 != null) {}
                for (i = 0;; i = 0)
                {
                  if (localca.apA() != 1) {
                    break label377;
                  }
                  localObject2 = f.Phs;
                  label184:
                  h.IzE.a(22835, new Object[] { Integer.valueOf(paramObject.value), Integer.valueOf(paramc.value), Integer.valueOf(((f)localObject2).value), str, Integer.valueOf(i), localObject1 });
                  break;
                  localObject1 = "";
                }
              }
              if (localb.type == 2001)
              {
                localObject2 = e.Php;
                localObject1 = localb.lnJ;
                if (localObject1 != null)
                {
                  if (((CharSequence)localObject1).length() <= 0) {
                    break label354;
                  }
                  i = 1;
                  label299:
                  if (i == 0) {
                    break label396;
                  }
                }
              }
            }
          }
        }
      }
      label396:
      for (paramObject = localObject1;; paramObject = "")
      {
        localObject1 = localb.lnP;
        if (localObject1 != null) {
          if (((CharSequence)localObject1).length() > 0)
          {
            i = 1;
            label329:
            if (i == 0) {
              break label364;
            }
          }
        }
        for (;;)
        {
          paramObject = localb.lnG;
          if (paramObject == null) {
            break label369;
          }
          i = Integer.parseInt(paramObject);
          paramObject = localObject2;
          break;
          label354:
          i = 0;
          break label299;
          i = 0;
          break label329;
          label364:
          localObject1 = paramObject;
        }
        label369:
        paramObject = localObject2;
        i = 0;
        break;
        label377:
        localObject2 = f.Pht;
        break label184;
        paramObject = x.aazN;
        AppMethodBeat.o(192840);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.d
 * JD-Core Version:    0.7.0.1
 */