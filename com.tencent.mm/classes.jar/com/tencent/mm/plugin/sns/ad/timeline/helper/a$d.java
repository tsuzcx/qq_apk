package com.tencent.mm.plugin.sns.ad.timeline.helper;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.l;
import kotlinx.coroutines.b.u;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mm/plugin/sns/ad/timeline/helper/AdMediaDownloadHelper$VideoResult;", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
final class a$d
  extends k
  implements q<h<? super a.c>, Throwable, kotlin.d.d<? super ah>, Object>
{
  int label;
  
  a$d(dmz paramdmz, kotlin.d.d<? super d> paramd)
  {
    super(3, paramd);
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(311117);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(311117);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (h)this.L$0;
      Object localObject = this.mrU.Id;
      s.s(localObject, "media.Id");
      localObject = (g)new a(u.b((g)a.aWN((String)localObject)), this.mrU);
      kotlin.d.d locald = (kotlin.d.d)this;
      this.label = 1;
      if (l.a(paramObject, (g)localObject, locald) == locala)
      {
        AppMethodBeat.o(311117);
        return locala;
      }
      break;
    case 1: 
      ResultKt.throwOnFailure(paramObject);
    }
    paramObject = ah.aiuX;
    AppMethodBeat.o(311117);
    return paramObject;
  }
  
  @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements g<a.c>
  {
    public a(g paramg, dmz paramdmz) {}
    
    public final Object a(h paramh, kotlin.d.d paramd)
    {
      AppMethodBeat.i(311067);
      paramh = this.bLp.a((h)new h()
      {
        public final Object a(Object paramAnonymousObject, kotlin.d.d paramAnonymousd)
        {
          AppMethodBeat.i(311096);
          Object localObject1;
          if ((paramAnonymousd instanceof 1))
          {
            localObject1 = (1)paramAnonymousd;
            if ((((1)localObject1).label & 0x80000000) != 0) {
              ((1)localObject1).label += -2147483648;
            }
          }
          for (paramAnonymousd = (kotlin.d.d)localObject1;; paramAnonymousd = new kotlin.d.b.a.d(paramAnonymousd)
              {
                int label;
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(311121);
                  this.result = paramAnonymous2Object;
                  this.label |= 0x80000000;
                  paramAnonymous2Object = this.Qaj.a(null, (kotlin.d.d)this);
                  AppMethodBeat.o(311121);
                  return paramAnonymous2Object;
                }
              })
          {
            localObject2 = paramAnonymousd.result;
            localObject1 = kotlin.d.a.a.aiwj;
            switch (paramAnonymousd.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(311096);
              throw paramAnonymousObject;
            }
          }
          ResultKt.throwOnFailure(localObject2);
          Object localObject2 = this.bLr;
          paramAnonymousObject = (a.c)paramAnonymousObject;
          if (y.ZC(paramAnonymousObject.filePath)) {}
          for (;;)
          {
            Log.d(a.aUw(), s.X("sight downloaded ", paramAnonymousObject));
            paramAnonymousd.label = 1;
            if (((h)localObject2).a(paramAnonymousObject, paramAnonymousd) != localObject1) {
              break;
            }
            AppMethodBeat.o(311096);
            return localObject1;
            paramAnonymousObject = this.Qai.Id;
            s.s(paramAnonymousObject, "media.Id");
            paramAnonymousObject = new a.c(paramAnonymousObject, null, a.a.Qae);
          }
          ResultKt.throwOnFailure(localObject2);
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(311096);
          return paramAnonymousObject;
        }
      }, paramd);
      if (paramh == kotlin.d.a.a.aiwj)
      {
        AppMethodBeat.o(311067);
        return paramh;
      }
      paramh = ah.aiuX;
      AppMethodBeat.o(311067);
      return paramh;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ad.timeline.helper.a.d
 * JD-Core Version:    0.7.0.1
 */