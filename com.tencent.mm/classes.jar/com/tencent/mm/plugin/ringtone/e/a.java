package com.tencent.mm.plugin.ringtone.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ringtone.b.c;
import com.tencent.mm.plugin.ringtone.g.d.a;
import com.tencent.mm.protocal.protobuf.a.aa;
import com.tencent.mm.protocal.protobuf.a.e;
import com.tencent.mm.protocal.protobuf.a.u;
import com.tencent.mm.protocal.protobuf.a.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.b;
import kotlin.d.b.a.k;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.h;
import kotlinx.coroutines.b.r;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cx;
import kotlinx.coroutines.dc;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ringtone/flow/ExclusiveRemoteDataSource;", "", "()V", "mBackgroundScope", "Lkotlinx/coroutines/CoroutineScope;", "release", "", "requestExclusive", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "exclusive", "(Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "spiltDataSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "ringtone", "", "Companion", "plugin-ringtone_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a OCI;
  public final aq OCJ;
  
  static
  {
    AppMethodBeat.i(272958);
    OCI = new a.a((byte)0);
    AppMethodBeat.o(272958);
  }
  
  public a()
  {
    AppMethodBeat.i(272939);
    this.OCJ = ar.b(ar.d((f)bg.kCi()), (f)cx.g(null));
    AppMethodBeat.o(272939);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<h<? super c>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(c paramc, a parama, kotlin.d.d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272925);
      paramd = new b(this.OCK, this.OCL, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272925);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(272916);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272916);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (h)this.L$0;
        Log.i("MicroMsg.ExclusiveRemoteDataSource", s.X("bindDataSource, requestExclusive is ", b.BF(this.OCK.OBY.aciY)));
        paramObject = (m)new k(this.OCK, paramObject)
        {
          Object L$0;
          Object Uf;
          Object VC;
          Object VD;
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(272979);
            paramAnonymousObject = (kotlin.d.d)new 1(this.OCK, paramObject, this.OCL, paramAnonymousd);
            AppMethodBeat.o(272979);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(final Object paramAnonymousObject)
          {
            int j = 0;
            AppMethodBeat.i(272970);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            Object localObject4;
            int i;
            Object localObject1;
            Object localObject2;
            Object localObject3;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(272970);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              localObject4 = this.OCK.OBY.aciQ;
              if ((localObject4 != null) && (((aa)localObject4).vhJ == 2)) {
                i = 1;
              }
            case 1: 
            case 2: 
            case 3: 
              for (;;)
              {
                if (i != 0)
                {
                  paramAnonymousObject = ((aa)localObject4).acjs;
                  if (paramAnonymousObject == null)
                  {
                    paramAnonymousObject = paramObject;
                    localObject1 = (kotlin.d.d)this;
                    this.label = 1;
                    if (paramAnonymousObject.a(null, (kotlin.d.d)localObject1) == locala)
                    {
                      AppMethodBeat.o(272970);
                      return locala;
                      i = 0;
                      continue;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                    }
                    else
                    {
                      paramAnonymousObject = ah.aiuX;
                      AppMethodBeat.o(272970);
                      return paramAnonymousObject;
                    }
                  }
                  else
                  {
                    localObject1 = com.tencent.mm.plugin.ringtone.g.d.ODu;
                    localObject1 = d.a.a(paramAnonymousObject, (aa)localObject4);
                    ((com.tencent.mm.plugin.ringtone.g.d)localObject1).ODy = ((aa)localObject4);
                    paramAnonymousObject = this.OCK.OBY.UserName;
                    if (paramAnonymousObject == null)
                    {
                      paramAnonymousObject = paramObject;
                      localObject1 = (kotlin.d.d)this;
                      this.label = 2;
                      if (paramAnonymousObject.a(null, (kotlin.d.d)localObject1) == locala)
                      {
                        AppMethodBeat.o(272970);
                        return locala;
                        ResultKt.throwOnFailure(paramAnonymousObject);
                      }
                      paramAnonymousObject = ah.aiuX;
                      AppMethodBeat.o(272970);
                      return paramAnonymousObject;
                    }
                    if (((aa)localObject4).acjt)
                    {
                      ((com.tencent.mm.plugin.ringtone.g.d)localObject1).OBU = true;
                      com.tencent.mm.plugin.ringtone.d.a.a(this.OCK.bZA(), (com.tencent.mm.plugin.ringtone.g.d)localObject1);
                      localObject2 = com.tencent.mm.plugin.ringtone.d.OBx;
                      localObject3 = (kotlin.d.d)this;
                      this.L$0 = localObject1;
                      this.Uf = paramAnonymousObject;
                      this.label = 3;
                      if (((com.tencent.mm.plugin.ringtone.d)localObject2).a(paramAnonymousObject, (com.tencent.mm.plugin.ringtone.g.d)localObject1, (kotlin.d.d)localObject3) != locala) {
                        break label1014;
                      }
                      AppMethodBeat.o(272970);
                      return locala;
                      localObject2 = (String)this.Uf;
                      localObject1 = (com.tencent.mm.plugin.ringtone.g.d)this.L$0;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                      paramAnonymousObject = localObject2;
                    }
                  }
                }
              }
            }
            label1014:
            for (;;)
            {
              com.tencent.mm.plugin.ringtone.d.a(paramAnonymousObject, (com.tencent.mm.plugin.ringtone.g.d)localObject1, this.OCK.OBY.aciY);
              for (;;)
              {
                paramAnonymousObject = paramObject;
                localObject1 = this.OCK;
                localObject2 = (kotlin.d.d)this;
                this.L$0 = null;
                this.Uf = null;
                this.label = 5;
                if (paramAnonymousObject.a(localObject1, (kotlin.d.d)localObject2) != locala) {
                  break;
                }
                AppMethodBeat.o(272970);
                return locala;
                com.tencent.mm.plugin.ringtone.d.a.a(this.OCK.bZA(), (com.tencent.mm.plugin.ringtone.g.d)localObject1);
                paramAnonymousObject = this.OCK.OBY.UserName;
                if (paramAnonymousObject == null)
                {
                  paramAnonymousObject = paramObject;
                  localObject1 = (kotlin.d.d)this;
                  this.label = 4;
                  if (paramAnonymousObject.a(null, (kotlin.d.d)localObject1) == locala)
                  {
                    AppMethodBeat.o(272970);
                    return locala;
                    ResultKt.throwOnFailure(paramAnonymousObject);
                  }
                  paramAnonymousObject = ah.aiuX;
                  AppMethodBeat.o(272970);
                  return paramAnonymousObject;
                }
                localObject2 = a.a(this.OCL);
                if (localObject2 != null) {
                  kotlinx.coroutines.j.a((aq)localObject2, null, null, (m)new k(this.OCK, (com.tencent.mm.plugin.ringtone.g.d)localObject1)
                  {
                    Object L$0;
                    Object Uf;
                    Object VC;
                    int label;
                    
                    public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                    {
                      AppMethodBeat.i(272923);
                      paramAnonymous2Object = (kotlin.d.d)new 1(this.OCK, this.OCN, paramAnonymousObject, paramAnonymous2d);
                      AppMethodBeat.o(272923);
                      return paramAnonymous2Object;
                    }
                    
                    public final Object invokeSuspend(Object paramAnonymous2Object)
                    {
                      AppMethodBeat.i(272914);
                      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                      switch (this.label)
                      {
                      default: 
                        paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        AppMethodBeat.o(272914);
                        throw paramAnonymous2Object;
                      case 0: 
                        ResultKt.throwOnFailure(paramAnonymous2Object);
                        paramAnonymous2Object = com.tencent.mm.plugin.ringtone.d.a.OCq;
                        long l = this.OCK.bZA();
                        localObject1 = this.OCN;
                        localObject2 = (kotlin.d.d)this;
                        this.label = 1;
                        localObject1 = paramAnonymous2Object.a(l, (com.tencent.mm.plugin.ringtone.g.d)localObject1, (kotlin.d.d)localObject2);
                        paramAnonymous2Object = localObject1;
                        if (localObject1 == locala)
                        {
                          AppMethodBeat.o(272914);
                          return locala;
                        }
                      case 1: 
                        ResultKt.throwOnFailure(paramAnonymous2Object);
                        localObject3 = (com.tencent.mm.plugin.ringtone.g.d)paramAnonymous2Object;
                        if (localObject3 == null) {
                          break label252;
                        }
                        String str = paramAnonymousObject;
                        localObject2 = this.OCK;
                        com.tencent.mm.plugin.ringtone.d locald = com.tencent.mm.plugin.ringtone.d.OBx;
                        this.L$0 = str;
                        this.Uf = localObject2;
                        this.VC = localObject3;
                        this.label = 2;
                        localObject1 = localObject3;
                        paramAnonymous2Object = str;
                        if (locald.a(str, (com.tencent.mm.plugin.ringtone.g.d)localObject3, this) != locala) {
                          break label238;
                        }
                        AppMethodBeat.o(272914);
                        return locala;
                      }
                      Object localObject1 = (com.tencent.mm.plugin.ringtone.g.d)this.VC;
                      Object localObject2 = (c)this.Uf;
                      Object localObject3 = (String)this.L$0;
                      ResultKt.throwOnFailure(paramAnonymous2Object);
                      paramAnonymous2Object = localObject3;
                      label238:
                      com.tencent.mm.plugin.ringtone.d.a(paramAnonymous2Object, (com.tencent.mm.plugin.ringtone.g.d)localObject1, ((c)localObject2).OBY.aciY);
                      label252:
                      paramAnonymous2Object = ah.aiuX;
                      AppMethodBeat.o(272914);
                      return paramAnonymous2Object;
                    }
                  }, 3);
                }
              }
              ResultKt.throwOnFailure(paramAnonymousObject);
              for (;;)
              {
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(272970);
                return paramAnonymousObject;
                i = j;
                if (localObject4 != null)
                {
                  i = j;
                  if (((aa)localObject4).vhJ == 1) {
                    i = 1;
                  }
                }
                if (i != 0)
                {
                  paramAnonymousObject = ((aa)localObject4).acjr;
                  if (paramAnonymousObject != null)
                  {
                    localObject3 = paramObject;
                    localObject2 = this.OCK;
                    localObject1 = paramAnonymousObject.acjj;
                    if (localObject1 != null) {
                      break;
                    }
                    this.label = 6;
                    if (((h)localObject3).a(null, this) == locala)
                    {
                      AppMethodBeat.o(272970);
                      return locala;
                      ResultKt.throwOnFailure(paramAnonymousObject);
                    }
                  }
                }
              }
              d.a locala1 = com.tencent.mm.plugin.ringtone.g.d.ODu;
              paramAnonymousObject = d.a.a(0L, paramAnonymousObject.acjm, (aa)localObject4, ((u)localObject1).toString());
              if (paramAnonymousObject == null)
              {
                this.label = 7;
                if (((h)localObject3).a(null, this) == locala)
                {
                  AppMethodBeat.o(272970);
                  return locala;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                }
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(272970);
                return paramAnonymousObject;
              }
              if (((aa)localObject4).acjt) {
                paramAnonymousObject.OBU = true;
              }
              paramAnonymousObject.ODy = ((aa)localObject4);
              localObject1 = ((c)localObject2).OBY.UserName;
              if (localObject1 == null)
              {
                this.label = 8;
                if (((h)localObject3).a(null, this) == locala)
                {
                  AppMethodBeat.o(272970);
                  return locala;
                  ResultKt.throwOnFailure(paramAnonymousObject);
                }
                paramAnonymousObject = ah.aiuX;
                AppMethodBeat.o(272970);
                return paramAnonymousObject;
              }
              com.tencent.mm.plugin.ringtone.d.a.a(((c)localObject2).bZA(), paramAnonymousObject);
              localObject4 = com.tencent.mm.plugin.ringtone.d.OBx;
              this.L$0 = localObject3;
              this.Uf = localObject2;
              this.VC = localObject1;
              this.VD = paramAnonymousObject;
              this.label = 9;
              if (((com.tencent.mm.plugin.ringtone.d)localObject4).a((String)localObject1, paramAnonymousObject, this) == locala)
              {
                AppMethodBeat.o(272970);
                return locala;
                localObject4 = (com.tencent.mm.plugin.ringtone.g.d)this.VD;
                localObject1 = (String)this.VC;
                localObject2 = (c)this.Uf;
                localObject3 = (h)this.L$0;
                ResultKt.throwOnFailure(paramAnonymousObject);
                paramAnonymousObject = localObject4;
              }
              for (;;)
              {
                com.tencent.mm.plugin.ringtone.d.a((String)localObject1, paramAnonymousObject, ((c)localObject2).OBY.aciY);
                this.L$0 = null;
                this.Uf = null;
                this.VC = null;
                this.VD = null;
                this.label = 10;
                if (((h)localObject3).a(localObject2, this) != locala) {
                  break;
                }
                AppMethodBeat.o(272970);
                return locala;
                ResultKt.throwOnFailure(paramAnonymousObject);
                break;
              }
            }
          }
        };
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        if (dc.a(2000L, paramObject, locald) == locala)
        {
          AppMethodBeat.o(272916);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(272916);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/ringtone/data/ExclusiveConvertData;", "Lkotlin/collections/ArrayList;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends k
    implements m<h<? super ArrayList<c>>, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    public c(List<c> paramList, a parama, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(272929);
      paramd = new c(this.OCO, this.OCL, paramd);
      paramd.L$0 = paramObject;
      paramObject = (kotlin.d.d)paramd;
      AppMethodBeat.o(272929);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(272920);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(272920);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (h)this.L$0;
        Object localObject = new ArrayList();
        paramObject = (m)new k(this.OCO, paramObject)
        {
          int label;
          
          public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
          {
            AppMethodBeat.i(272930);
            paramAnonymousObject = (kotlin.d.d)new 1(this.OCO, paramObject, this.OCL, this.OCP, paramAnonymousd);
            AppMethodBeat.o(272930);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(272922);
            kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
            Object localObject1;
            Object localObject2;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(272922);
              throw paramAnonymousObject;
            case 0: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = r.b(kotlinx.coroutines.b.j.K((Iterable)this.OCO), (m)new k(this.OCL, null)
              {
                int label;
                
                public final kotlin.d.d<ah> create(Object paramAnonymous2Object, kotlin.d.d<?> paramAnonymous2d)
                {
                  AppMethodBeat.i(272959);
                  paramAnonymous2d = new 1(this.OCL, paramAnonymous2d);
                  paramAnonymous2d.L$0 = paramAnonymous2Object;
                  paramAnonymous2Object = (kotlin.d.d)paramAnonymous2d;
                  AppMethodBeat.o(272959);
                  return paramAnonymous2Object;
                }
                
                public final Object invokeSuspend(Object paramAnonymous2Object)
                {
                  AppMethodBeat.i(272954);
                  kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
                  switch (this.label)
                  {
                  default: 
                    paramAnonymous2Object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    AppMethodBeat.o(272954);
                    throw paramAnonymous2Object;
                  case 0: 
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                    paramAnonymous2Object = (c)this.L$0;
                    Object localObject = this.OCL;
                    this.label = 1;
                    localObject = a.a((a)localObject, paramAnonymous2Object);
                    paramAnonymous2Object = localObject;
                    if (localObject == locala)
                    {
                      AppMethodBeat.o(272954);
                      return locala;
                    }
                    break;
                  case 1: 
                    ResultKt.throwOnFailure(paramAnonymous2Object);
                  }
                  AppMethodBeat.o(272954);
                  return paramAnonymous2Object;
                }
              });
              localObject1 = (h)new a(this.OCP);
              localObject2 = (kotlin.d.d)this;
              this.label = 1;
              if (paramAnonymousObject.a((h)localObject1, (kotlin.d.d)localObject2) == locala)
              {
                AppMethodBeat.o(272922);
                return locala;
              }
            case 1: 
              ResultKt.throwOnFailure(paramAnonymousObject);
              paramAnonymousObject = new ArrayList();
              localObject2 = (Iterable)this.OCO;
              localObject1 = this.OCP;
              localObject2 = ((Iterable)localObject2).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                c localc = (c)((Iterator)localObject2).next();
                if (((ArrayList)localObject1).contains(localc))
                {
                  paramAnonymousObject.add(localc);
                  Log.i("MicroMsg.ExclusiveRemoteDataSource", s.X("avail data receive ", localc.OBY.UserName));
                }
                else
                {
                  Log.e("MicroMsg.ExclusiveRemoteDataSource", "no avail data receive");
                }
              }
              localObject1 = paramObject;
              localObject2 = (kotlin.d.d)this;
              this.label = 2;
              if (((h)localObject1).a(paramAnonymousObject, (kotlin.d.d)localObject2) != locala) {
                break label280;
              }
              AppMethodBeat.o(272922);
              return locala;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            label280:
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(272922);
            return paramAnonymousObject;
          }
          
          @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
          public static final class a
            implements h<c>
          {
            public a(ArrayList paramArrayList) {}
            
            public final Object a(c paramc, kotlin.d.d<? super ah> paramd)
            {
              AppMethodBeat.i(272945);
              paramc = (c)paramc;
              if (paramc != null)
              {
                Log.i("MicroMsg.ExclusiveRemoteDataSource", s.X("avail data receive ", paramc.OBY.UserName));
                this.OCQ.add(paramc);
              }
              paramc = ah.aiuX;
              AppMethodBeat.o(272945);
              return paramc;
            }
          }
        };
        localObject = (kotlin.d.d)this;
        this.label = 1;
        if (dc.b(5000L, paramObject, (kotlin.d.d)localObject) == locala)
        {
          AppMethodBeat.o(272920);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(272920);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ringtone.e.a
 * JD-Core Version:    0.7.0.1
 */