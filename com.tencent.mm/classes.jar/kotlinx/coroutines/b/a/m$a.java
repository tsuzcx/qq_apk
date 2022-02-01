package kotlinx.coroutines.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.ae;
import kotlin.ah;
import kotlin.d.a.b;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.a.q;
import kotlin.g.b.s;
import kotlinx.coroutines.a.ab;
import kotlinx.coroutines.a.l;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.cg;
import kotlinx.coroutines.dg;
import kotlinx.coroutines.internal.i;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class m$a
  extends kotlin.d.b.a.k
  implements m<aq, kotlin.d.d<? super ah>, Object>
{
  Object Uf;
  Object VC;
  int aai;
  int asI;
  int label;
  
  m$a(g<? extends T>[] paramArrayOfg, kotlin.g.a.a<T[]> parama, q<? super kotlinx.coroutines.b.h<? super R>, ? super T[], ? super kotlin.d.d<? super ah>, ? extends Object> paramq, kotlinx.coroutines.b.h<? super R> paramh, kotlin.d.d<? super a> paramd)
  {
    super(2, paramd);
  }
  
  public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
  {
    AppMethodBeat.i(189253);
    paramd = new a(this.ajzC, this.ajzD, this.bML, this.ajzE, paramd);
    paramd.L$0 = paramObject;
    paramObject = (kotlin.d.d)paramd;
    AppMethodBeat.o(189253);
    return paramObject;
  }
  
  public final Object invokeSuspend(final Object paramObject)
  {
    AppMethodBeat.i(189243);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject1;
    int j;
    Object[] arrayOfObject;
    Object localObject2;
    final int i;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(189243);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      localObject1 = (aq)this.L$0;
      j = this.ajzC.length;
      if (j == 0)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(189243);
        return paramObject;
      }
      arrayOfObject = new Object[j];
      kotlin.a.k.b(arrayOfObject, u.ajzO);
      paramObject = kotlinx.coroutines.a.k.a(j, null, 6);
      localObject2 = new AtomicInteger(j);
      i = 0;
      if (j <= 0) {
        break;
      }
    }
    for (;;)
    {
      int k = i + 1;
      j.a((aq)localObject1, null, null, (m)new kotlin.d.b.a.k(this.ajzC, i)
      {
        int label;
        
        public final kotlin.d.d<ah> create(Object paramAnonymousObject, kotlin.d.d<?> paramAnonymousd)
        {
          AppMethodBeat.i(189199);
          paramAnonymousObject = (kotlin.d.d)new 1(this.ajzC, i, this.ajzF, paramObject, paramAnonymousd);
          AppMethodBeat.o(189199);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(189192);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(189192);
            throw paramAnonymousObject;
          case 0: 
            ResultKt.throwOnFailure(paramAnonymousObject);
          }
          try
          {
            paramAnonymousObject = this.ajzC[i];
            kotlinx.coroutines.b.h localh = (kotlinx.coroutines.b.h)new a(paramObject, i);
            kotlin.d.d locald = (kotlin.d.d)this;
            this.label = 1;
            paramAnonymousObject = paramAnonymousObject.a(localh, locald);
            if (paramAnonymousObject == locala)
            {
              AppMethodBeat.o(189192);
              return locala;
              ResultKt.throwOnFailure(paramAnonymousObject);
            }
            if (this.ajzF.decrementAndGet() == 0) {
              ((ab)paramObject).k(null);
            }
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(189192);
            return paramAnonymousObject;
          }
          finally
          {
            if (this.ajzF.decrementAndGet() == 0) {
              ((ab)paramObject).k(null);
            }
            AppMethodBeat.o(189192);
          }
        }
        
        @Metadata(d1={""}, d2={"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k=1, mv={1, 5, 1}, xi=48)
        public static final class a
          implements kotlinx.coroutines.b.h<T>
        {
          public a(kotlinx.coroutines.a.h paramh, int paramInt) {}
          
          public final Object a(T paramT, kotlin.d.d<? super ah> paramd)
          {
            AppMethodBeat.i(189176);
            Object localObject1;
            if ((paramd instanceof 1))
            {
              localObject1 = (1)paramd;
              if ((((1)localObject1).label & 0x80000000) != 0) {
                ((1)localObject1).label += -2147483648;
              }
            }
            for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new kotlin.d.b.a.d(paramd)
                {
                  int label;
                  
                  public final Object invokeSuspend(Object paramAnonymousObject)
                  {
                    AppMethodBeat.i(189185);
                    this.result = paramAnonymousObject;
                    this.label |= 0x80000000;
                    paramAnonymousObject = this.ajzJ.a(null, (kotlin.d.d)this);
                    AppMethodBeat.o(189185);
                    return paramAnonymousObject;
                  }
                })
            {
              localObject2 = paramd.result;
              localObject1 = kotlin.d.a.a.aiwj;
              switch (paramd.label)
              {
              default: 
                paramT = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                AppMethodBeat.o(189176);
                throw paramT;
              }
            }
            ResultKt.throwOnFailure(localObject2);
            Object localObject2 = this.ajzH;
            paramT = new ae(this.ajzI, paramT);
            paramd.label = 1;
            if (((kotlinx.coroutines.a.h)localObject2).b(paramT, paramd) == localObject1)
            {
              AppMethodBeat.o(189176);
              return localObject1;
              ResultKt.throwOnFailure(localObject2);
            }
            paramd.label = 2;
            localObject2 = paramd.getContext();
            cg.g((f)localObject2);
            paramT = b.au(paramd);
            if ((paramT instanceof kotlinx.coroutines.internal.h))
            {
              paramT = (kotlinx.coroutines.internal.h)paramT;
              if (paramT != null) {
                break label250;
              }
              paramT = ah.aiuX;
            }
            for (;;)
            {
              if (paramT == kotlin.d.a.a.aiwj) {
                s.u(paramd, "frame");
              }
              paramd = paramT;
              if (paramT != kotlin.d.a.a.aiwj) {
                paramd = ah.aiuX;
              }
              if (paramd != localObject1) {
                break label331;
              }
              AppMethodBeat.o(189176);
              return localObject1;
              paramT = null;
              break;
              label250:
              if (paramT.bRx.kBY()) {
                paramT.a((f)localObject2, ah.aiuX);
              }
              dg localdg;
              do
              {
                paramT = kotlin.d.a.a.aiwj;
                break;
                localdg = new dg();
                paramT.a(((f)localObject2).plus((f)localdg), ah.aiuX);
              } while ((!localdg.ajwV) || (i.a(paramT)));
              paramT = ah.aiuX;
            }
            ResultKt.throwOnFailure(localObject2);
            label331:
            paramT = ah.aiuX;
            AppMethodBeat.o(189176);
            return paramT;
          }
        }
      }, 3);
      if (k >= j)
      {
        localObject1 = new byte[j];
        k = 0;
        i = j;
        j = k;
        j = (byte)(j + 1);
        localObject2 = (kotlin.d.d)this;
        this.L$0 = arrayOfObject;
        this.Uf = paramObject;
        this.VC = localObject1;
        this.aai = i;
        this.asI = j;
        this.label = 1;
        localObject2 = paramObject.aB((kotlin.d.d)localObject2);
        Object localObject3;
        if (localObject2 == locala)
        {
          AppMethodBeat.o(189243);
          return locala;
          j = this.asI;
          i = this.aai;
          localObject3 = (byte[])this.VC;
          localObject1 = (kotlinx.coroutines.a.h)this.Uf;
          arrayOfObject = (Object[])this.L$0;
          ResultKt.throwOnFailure(paramObject);
          localObject2 = ((l)paramObject).ajxG;
          paramObject = localObject3;
          label306:
          localObject2 = (ae)l.getOrNull-impl(localObject2);
          if (localObject2 != null)
          {
            label321:
            k = ((ae)localObject2).index;
            localObject3 = arrayOfObject[k];
            arrayOfObject[k] = ((ae)localObject2).value;
            if (localObject3 != u.ajzO) {
              break label725;
            }
            i -= 1;
          }
        }
        label706:
        label725:
        for (;;)
        {
          if (paramObject[k] != j)
          {
            paramObject[k] = ((byte)j);
            localObject2 = (ae)l.getOrNull-impl(((kotlinx.coroutines.a.h)localObject1).kCV());
            if (localObject2 != null) {}
          }
          else
          {
            if (i == 0)
            {
              localObject2 = (Object[])this.ajzD.invoke();
              if (localObject2 == null)
              {
                localObject2 = this.bML;
                localObject3 = this.ajzE;
                this.L$0 = arrayOfObject;
                this.Uf = localObject1;
                this.VC = paramObject;
                this.aai = i;
                this.asI = j;
                this.label = 2;
                if (((q)localObject2).invoke(localObject3, arrayOfObject, this) != locala) {
                  break label706;
                }
                AppMethodBeat.o(189243);
                return locala;
                j = this.asI;
                i = this.aai;
                localObject2 = (byte[])this.VC;
                localObject1 = (kotlinx.coroutines.a.h)this.Uf;
                arrayOfObject = (Object[])this.L$0;
                ResultKt.throwOnFailure(paramObject);
                paramObject = localObject2;
              }
              for (;;)
              {
                localObject2 = paramObject;
                paramObject = localObject1;
                localObject1 = localObject2;
                break;
                kotlin.a.k.a(arrayOfObject, (Object[])localObject2, 0, 0, 0, 14);
                localObject3 = this.bML;
                kotlinx.coroutines.b.h localh = this.ajzE;
                this.L$0 = arrayOfObject;
                this.Uf = localObject1;
                this.VC = paramObject;
                this.aai = i;
                this.asI = j;
                this.label = 3;
                if (((q)localObject3).invoke(localh, localObject2, this) == locala)
                {
                  AppMethodBeat.o(189243);
                  return locala;
                  j = this.asI;
                  i = this.aai;
                  localObject2 = (byte[])this.VC;
                  localObject1 = (kotlinx.coroutines.a.h)this.Uf;
                  arrayOfObject = (Object[])this.L$0;
                  ResultKt.throwOnFailure(paramObject);
                  paramObject = localObject2;
                }
                for (;;)
                {
                  localObject2 = paramObject;
                  paramObject = localObject1;
                  localObject1 = localObject2;
                  break;
                  paramObject = ah.aiuX;
                  AppMethodBeat.o(189243);
                  return paramObject;
                }
                localObject3 = paramObject;
                paramObject = localObject1;
                localObject1 = localObject3;
                break label306;
              }
            }
            localObject2 = paramObject;
            paramObject = localObject1;
            localObject1 = localObject2;
            break;
          }
          break label321;
        }
      }
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     kotlinx.coroutines.b.a.m.a
 * JD-Core Version:    0.7.0.1
 */