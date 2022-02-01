package com.tencent.mm.plugin.ringtone.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.ringtone.b.e;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.r;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dc;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/flow/RingtoneRemoteDataSource;", "", "()V", "mBackgroundScope", "Lkotlinx/coroutines/CoroutineScope;", "bindDataSource", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;", "ringtone", "(Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "release", "", "spiltDataSource", "", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b.a OCR;
  public final aq OCJ;
  
  static
  {
    AppMethodBeat.i(272961);
    OCR = new b.a((byte)0);
    AppMethodBeat.o(272961);
  }
  
  public b()
  {
    AppMethodBeat.i(272942);
    this.OCJ = ar.b(ar.d((f)bg.kCi()), (f)cx.g(null));
    AppMethodBeat.o(272942);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<kotlinx.coroutines.b.h<? super e>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(e parame, b paramb, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272964);
      paramd = new b(this.OCS, this.OCT, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272964);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(272955);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272955);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.h)this.L$0;
        Log.e("MicroMsg.RingtoneRemoteDataSource", "bindDataSource");
        paramObject = (m)new k(this.OCS, paramObject)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(273000);
            paramAnonymousObject = (kotlin.d.d)new 1(this.OCS, paramObject, this.OCT, paramAnonymousd);
            AppMethodBeat.o(273000);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(272991);
            a locala = a.aiwj;
            Object localObject1;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(272991);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject1 = this.OCS.OCa;
              if ((((aa)localObject1).acjt) || (((aa)localObject1).Idd != 0))
              {
                Log.e("MicroMsg.RingtoneRemoteDataSource", s.X("has Invalid data is ", localObject1));
                paramAnonymousObject = paramObject;
                localObject1 = (kotlin.d.d)this;
                this.label = 1;
                if (paramAnonymousObject.a(null, (kotlin.d.d)localObject1) == locala)
                {
                  AppMethodBeat.o(272991);
                  return locala;
                }
              }
              break;
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            for (;;)
            {
              paramAnonymousObject = ah.aiuX;
              AppMethodBeat.o(272991);
              return paramAnonymousObject;
              Object localObject2;
              if (((aa)localObject1).vhJ == 2)
              {
                paramAnonymousObject = ((aa)localObject1).acjs;
                if (paramAnonymousObject == null)
                {
                  paramAnonymousObject = paramObject;
                  localObject1 = (kotlin.d.d)this;
                  this.label = 2;
                  if (paramAnonymousObject.a(null, (kotlin.d.d)localObject1) == locala)
                  {
                    AppMethodBeat.o(272991);
                    return locala;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                  }
                  paramAnonymousObject = ah.aiuX;
                  AppMethodBeat.o(272991);
                  return paramAnonymousObject;
                }
                localObject2 = com.tencent.mm.plugin.ringtone.g.d.ODu;
                paramAnonymousObject = d.a.a(paramAnonymousObject, (aa)localObject1);
                paramAnonymousObject.ODy = this.OCS.OCa;
                com.tencent.mm.plugin.ringtone.d.b.a(this.OCS.bZA(), paramAnonymousObject);
                localObject1 = paramAnonymousObject.nUM;
                if (localObject1 != null) {
                  ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadRingtoneBgImage((String)localObject1, null);
                }
                kotlinx.coroutines.j.a(b.a(this.OCT), null, null, (m)new k(paramAnonymousObject, null)
                {
                  int label;
                  
                  public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                  {
                    AppMethodBeat.i(272969);
                    paramAnonymous2Object = (kotlin.d.d)new 1(this.OCN, paramAnonymous2d);
                    AppMethodBeat.o(272969);
                    return paramAnonymous2Object;
                  }
                  
                  public final Object invokeSuspend(Object paramAnonymous2Object)
                  {
                    AppMethodBeat.i(272962);
                    a locala = a.aiwj;
                    switch (this.label)
                    {
                    default: 
                      paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                      AppMethodBeat.o(272962);
                      throw paramAnonymous2Object;
                    case 0: 
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                      paramAnonymous2Object = com.tencent.mm.plugin.ringtone.d.b.OCt;
                      com.tencent.mm.plugin.ringtone.g.d locald = this.OCN;
                      kotlin.d.d locald1 = (kotlin.d.d)this;
                      this.label = 1;
                      if (paramAnonymous2Object.a(locald, locald1) == locala)
                      {
                        AppMethodBeat.o(272962);
                        return locala;
                      }
                      break;
                    case 1: 
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                    }
                    paramAnonymous2Object = ah.aiuX;
                    AppMethodBeat.o(272962);
                    return paramAnonymous2Object;
                  }
                }, 3);
                paramAnonymousObject = paramObject;
                localObject1 = this.OCS;
                localObject2 = (kotlin.d.d)this;
                this.label = 3;
                if (paramAnonymousObject.a(localObject1, (kotlin.d.d)localObject2) == locala)
                {
                  AppMethodBeat.o(272991);
                  return locala;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                }
              }
              else if (((aa)localObject1).vhJ == 1)
              {
                v localv = ((aa)localObject1).acjr;
                localObject2 = paramObject;
                e locale = this.OCS;
                if (localv == null) {
                  paramAnonymousObject = null;
                }
                while (paramAnonymousObject == null)
                {
                  this.label = 4;
                  if (((kotlinx.coroutines.b.h)localObject2).a(null, this) == locala)
                  {
                    AppMethodBeat.o(272991);
                    return locala;
                    paramAnonymousObject = localv.acjj;
                    if (paramAnonymousObject == null)
                    {
                      paramAnonymousObject = null;
                    }
                    else
                    {
                      paramAnonymousObject = Integer.valueOf(paramAnonymousObject.aaYO);
                      continue;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                    }
                  }
                  else
                  {
                    paramAnonymousObject = ah.aiuX;
                    AppMethodBeat.o(272991);
                    return paramAnonymousObject;
                  }
                }
                int i = paramAnonymousObject.intValue();
                if ((localv.acjj == null) || (i == 0) || (((aa)localObject1).Idd != 0))
                {
                  this.label = 5;
                  if (((kotlinx.coroutines.b.h)localObject2).a(null, this) == locala)
                  {
                    AppMethodBeat.o(272991);
                    return locala;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                  }
                }
                else
                {
                  paramAnonymousObject = com.tencent.mm.plugin.ringtone.g.d.ODu;
                  paramAnonymousObject = d.a.a(0L, localv.acjm, (aa)localObject1, String.valueOf(i));
                  if (paramAnonymousObject == null)
                  {
                    this.label = 6;
                    if (((kotlinx.coroutines.b.h)localObject2).a(null, this) == locala)
                    {
                      AppMethodBeat.o(272991);
                      return locala;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                    }
                    paramAnonymousObject = ah.aiuX;
                    AppMethodBeat.o(272991);
                    return paramAnonymousObject;
                  }
                  com.tencent.mm.plugin.ringtone.d.b.a(locale.bZA(), paramAnonymousObject);
                  paramAnonymousObject.ODy = locale.OCa;
                  paramAnonymousObject = paramAnonymousObject.nUM;
                  if (paramAnonymousObject != null) {
                    ((cn)com.tencent.mm.kernel.h.az(cn.class)).loadRingtoneBgImage(paramAnonymousObject, null);
                  }
                  this.label = 7;
                  if (((kotlinx.coroutines.b.h)localObject2).a(locale, this) == locala)
                  {
                    AppMethodBeat.o(272991);
                    return locala;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                  }
                }
              }
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (dc.a(2000L, paramObject, locald) == locala)
        {
          AppMethodBeat.o(272955);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(272955);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lcom/tencent/mm/plugin/ringtone/data/RingtoneConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
    implements m<kotlinx.coroutines.b.h<? super List<? extends e>>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public c(List<e> paramList, b paramb, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272967);
      paramd = new c(this.OCO, this.OCT, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272967);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(272960);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272960);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlinx.coroutines.b.h)this.L$0;
        Object localObject = new ArrayList();
        paramObject = (m)new k(this.OCO, paramObject)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(272940);
            paramAnonymousObject = (kotlin.d.d)new 1(this.OCO, paramObject, this.OCT, this.OCU, paramAnonymousd);
            AppMethodBeat.o(272940);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(272932);
            a locala = a.aiwj;
            Object localObject1;
            Object localObject2;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(272932);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = r.b(kotlinx.coroutines.b.j.K((Iterable)this.OCO), (m)new k(this.OCT, null)
              {
                int label;
                
                public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                {
                  AppMethodBeat.i(272943);
                  paramAnonymous2d = new 1(this.OCT, paramAnonymous2d);
                  paramAnonymous2d.L$0 = paramAnonymous2Object;
                  paramAnonymous2Object = (kotlin.d.d)paramAnonymous2d;
                  AppMethodBeat.o(272943);
                  return paramAnonymous2Object;
                }
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(272936);
                  a locala = a.aiwj;
                  switch (this.label)
                  {
                  default: 
                    paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(272936);
                    throw paramAnonymous2Object;
                  case 0: 
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                    paramAnonymous2Object = (e)this.L$0;
                    Object localObject = this.OCT;
                    this.label = 1;
                    localObject = b.a((b)localObject, paramAnonymous2Object);
                    paramAnonymous2Object = localObject;
                    if (localObject == locala)
                    {
                      AppMethodBeat.o(272936);
                      return locala;
                    }
                    break;
                  case 1: 
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                  }
                  AppMethodBeat.o(272936);
                  return paramAnonymous2Object;
                }
              });
              localObject1 = (kotlinx.coroutines.b.h)new a(this.OCU);
              localObject2 = (kotlin.d.d)this;
              this.label = 1;
              if (paramAnonymousObject.a((kotlinx.coroutines.b.h)localObject1, (kotlin.d.d)localObject2) == locala)
              {
                AppMethodBeat.o(272932);
                return locala;
              }
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = new ArrayList();
              localObject2 = (Iterable)this.OCO;
              localObject1 = this.OCU;
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                e locale = (e)((Iterator)localObject2).next();
                if (((ArrayList)localObject1).contains(locale))
                {
                  paramAnonymousObject.add(locale);
                  Log.e("MicroMsg.RingtoneRemoteDataSource", "avail data receive");
                }
                else
                {
                  Log.e("MicroMsg.RingtoneRemoteDataSource", "no avail data receive");
                }
              }
              localObject1 = paramObject;
              localObject2 = (kotlin.d.d)this;
              this.label = 2;
              if (((kotlinx.coroutines.b.h)localObject1).a(paramAnonymousObject, (kotlin.d.d)localObject2) != locala) {
                break label269;
              }
              AppMethodBeat.o(272932);
              return locala;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            label269:
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(272932);
            return paramAnonymousObject;
          }
          
          @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
          public static final class a
            implements kotlinx.coroutines.b.h<e>
          {
            public a(ArrayList paramArrayList) {}
            
            public final Object a(e parame, kotlin.d.d<? super ah> paramd)
            {
              AppMethodBeat.i(272926);
              parame = (e)parame;
              if (parame != null) {
                this.OCV.add(parame);
              }
              parame = ah.aiuX;
              AppMethodBeat.o(272926);
              return parame;
            }
          }
        };
        localObject = (kotlin.d.d)this;
        this.label = 1;
        if (dc.b(5000L, paramObject, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(272960);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(272960);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.e.b
 * JD-Core Version:    0.7.0.1
 */