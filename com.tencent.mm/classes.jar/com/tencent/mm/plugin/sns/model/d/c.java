package com.tencent.mm.plugin.sns.model.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.a.b.a;
import com.tencent.mm.plugin.sns.data.t;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ap;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.protocal.protobuf.SnsObject;
import com.tencent.mm.protocal.protobuf.ffz;
import com.tencent.mm.protocal.protobuf.fga;
import com.tencent.mm.sns_compose.a.e;
import com.tencent.mm.sns_compose.a.e.a;
import com.tencent.mm.sns_compose.a.e.b;
import com.tencent.mm.sns_compose.a.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.sns_compose.a.e<Lcom.tencent.mm.sns_compose.a.d<Lcom.tencent.mm.sns_compose.a.f;>;>;>;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/model/withta/WithTaComposeGetPageOpImpl;", "", "()V", "getPage", "Lcom/tencent/mm/sns_compose/api/PageLoadResult;", "Lcom/tencent/mm/sns_compose/api/PageDataWrapper;", "Lcom/tencent/mm/sns_compose/api/SnsWithTaBase;", "feedId", "", "pageSize", "", "userName", "", "(JILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "resp", "Lcom/tencent/mm/protocal/protobuf/SnsWithTaPageResponse;", "toWrapperData", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c QAQ;
  
  static
  {
    AppMethodBeat.i(309606);
    QAQ = new c();
    AppMethodBeat.o(309606);
  }
  
  public final Object a(long paramLong, int paramInt, String paramString, kotlin.d.d<? super e<com.tencent.mm.sns_compose.a.d<f>>> paramd)
  {
    AppMethodBeat.i(309620);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super e<com.tencent.mm.sns_compose.a.d<f>>>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(309620);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    Object localObject1 = new com.tencent.mm.am.c.a();
    ((com.tencent.mm.am.c.a)localObject1).funcId = 6843;
    ((com.tencent.mm.am.c.a)localObject1).uri = "/cgi-bin/micromsg-bin/mmsnswithtapage";
    ffz localffz = new ffz();
    localffz.username = paramString;
    localffz.Tqa = paramLong;
    localffz.limit = paramInt;
    localffz.abFU = 1;
    paramString = ah.aiuX;
    ((com.tencent.mm.am.c.a)localObject1).otE = ((com.tencent.mm.bx.a)localffz);
    ((com.tencent.mm.am.c.a)localObject1).otF = ((com.tencent.mm.bx.a)new fga());
    paramString = ((com.tencent.mm.am.c.a)localObject1).bEF();
    localObject1 = com.tencent.mm.am.a.b.ovw;
    kotlin.g.b.s.s(paramString, "commReqResp");
    paramString = b.a.e(paramString);
    paramd.label = 1;
    paramd = kotlinx.coroutines.b.s.b(paramString, paramd);
    paramString = paramd;
    if (paramd == localObject2)
    {
      AppMethodBeat.o(309620);
      return localObject2;
      ResultKt.throwOnFailure(localObject1);
      paramString = (String)localObject1;
    }
    if (((com.tencent.mm.am.a.a)paramString).ovD == com.tencent.mm.am.b.b.ovB)
    {
      paramInt = 1;
      if (paramInt == 0) {
        break label350;
      }
      label304:
      paramString = (com.tencent.mm.am.a.a)paramString;
      if (paramString != null) {
        break label356;
      }
      paramString = null;
    }
    for (;;)
    {
      if (paramString != null) {
        break label704;
      }
      paramString = (e)new e.a((byte)0);
      AppMethodBeat.o(309620);
      return paramString;
      paramInt = 0;
      break;
      label350:
      paramString = null;
      break label304;
      label356:
      localObject1 = (fga)paramString.ott;
      if (localObject1 == null)
      {
        paramString = null;
      }
      else
      {
        paramString = ((fga)localObject1).YMW;
        if (paramString == null)
        {
          paramString = null;
          paramd = paramString;
          if (paramString == null) {
            paramd = (List)ab.aivy;
          }
          if (((fga)localObject1).abFX == 0) {
            break label684;
          }
        }
        label672:
        label684:
        for (boolean bool = true;; bool = false)
        {
          paramString = new com.tencent.mm.sns_compose.a.d(paramd, bool, ((fga)localObject1).abFW, ((fga)localObject1).abFV);
          if ((((fga)localObject1).YMW != null) && (((fga)localObject1).YMW.size() > 0))
          {
            kotlin.g.b.s.u(localObject1, "resp");
            ap.a("@__with_together", 256, ((fga)localObject1).YMW, t.aXy(t.uA(((SnsObject)((fga)localObject1).YMW.getFirst()).Id)));
          }
          paramd = ((Iterable)paramString.bMf).iterator();
          while (paramd.hasNext())
          {
            localObject1 = (f)paramd.next();
            localObject2 = al.hgB().aZK(((f)localObject1).hQX);
            if (localObject2 != null) {
              ((f)localObject1).icg = ((SnsInfo)localObject2).localid;
            }
          }
          paramString = (Iterable)paramString;
          paramd = (Collection)new ArrayList();
          localObject2 = paramString.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            paramString = (SnsObject)((Iterator)localObject2).next();
            if (paramString == null) {
              paramString = null;
            }
            for (;;)
            {
              if (paramString == null) {
                break label672;
              }
              paramd.add(paramString);
              break;
              paramString = b.i(paramString);
              if (paramString == null) {
                paramString = null;
              } else {
                paramString = b.N(paramString);
              }
            }
          }
          paramString = (List)paramd;
          break;
        }
        paramString = new e.b(paramString);
      }
    }
    label704:
    paramString = (e)paramString;
    AppMethodBeat.o(309620);
    return paramString;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(c paramc, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(309600);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.QAR.a(0L, 0, null, (kotlin.d.d)this);
      AppMethodBeat.o(309600);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.d.c
 * JD-Core Version:    0.7.0.1
 */