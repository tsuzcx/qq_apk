package com.tencent.mm.plugin.wallet_core.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/wallet_core/utils/MessageReportor;", "", "()V", "report", "", "messages", "", "Lcom/tencent/mm/storage/MsgInfo;", "eventType", "Lcom/tencent/mm/plugin/wallet_core/utils/MessageEventType;", "plugin-wxpay_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static void a(List<? extends cc> paramList, final d paramd)
  {
    AppMethodBeat.i(301410);
    s.u(paramList, "messages");
    s.u(paramd, "eventType");
    j.a((aq)bu.ajwo, null, null, (m)new a(paramList, paramd, null), 3);
    AppMethodBeat.o(301410);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    a(List<? extends cc> paramList, d paramd, kotlin.d.d<? super a> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(301443);
      paramObject = (kotlin.d.d)new a(this.VXY, paramd, paramd);
      AppMethodBeat.o(301443);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(301442);
      Object localObject1 = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(301442);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      Iterator localIterator = this.VXY.iterator();
      cc localcc;
      Object localObject2;
      String str;
      ah.d locald;
      ah.f localf;
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localcc = (cc)localIterator.next();
          if ((localcc.fxR()) && (localcc.field_content != null) && (localcc.field_talker != null))
          {
            localObject2 = k.b.Hf(localcc.field_content);
            if (localObject2 != null)
            {
              paramObject = f.VYa;
              paramObject = h.VYe;
              str = localcc.field_talker;
              locald = new ah.d();
              localf = new ah.f();
              localf.aqH = "";
              if (((k.b)localObject2).type == 2000)
              {
                localObject1 = f.VYb;
                localObject2 = ((k.b)localObject2).nSk;
                paramObject = localObject1;
                if (localObject2 != null)
                {
                  localf.aqH = localObject2;
                  paramObject = localObject1;
                }
              }
            }
          }
        }
      }
      label395:
      label400:
      label423:
      for (;;)
      {
        if (localcc.field_isSend == 1) {}
        for (localObject1 = h.VYf;; localObject1 = h.VYg)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(22835, new Object[] { Integer.valueOf(paramObject.value), Integer.valueOf(paramd.value), Integer.valueOf(((h)localObject1).value), str, Integer.valueOf(locald.aixb), localf.aqH });
          break;
          if (((k.b)localObject2).type != 2001) {
            break;
          }
          paramObject = f.VYc;
          localObject1 = ((k.b)localObject2).nSN;
          if (localObject1 != null)
          {
            if (((CharSequence)localObject1).length() <= 0) {
              break label395;
            }
            i = 1;
            label329:
            if (i != 0) {
              localf.aqH = localObject1;
            }
          }
          localObject1 = ((k.b)localObject2).nST;
          if (localObject1 != null) {
            if (((CharSequence)localObject1).length() <= 0) {
              break label400;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              localf.aqH = localObject1;
            }
            localObject1 = ((k.b)localObject2).nSK;
            if (localObject1 == null) {
              break label423;
            }
            locald.aixb = Integer.parseInt((String)localObject1);
            break;
            i = 0;
            break label329;
          }
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(301442);
        return paramObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_core.utils.e
 * JD-Core Version:    0.7.0.1
 */