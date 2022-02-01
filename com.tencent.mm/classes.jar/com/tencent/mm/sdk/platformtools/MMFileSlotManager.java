package com.tencent.mm.sdk.platformtools;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.ResultKt;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.aw;
import kotlinx.coroutines.bc;
import kotlinx.coroutines.br;
import kotlinx.coroutines.by;
import kotlinx.coroutines.g;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class MMFileSlotManager
  extends BaseSlotManager<q>
{
  private final long CLEAR_DELAY;
  private final String TAG;
  private final String prefix;
  
  public MMFileSlotManager(String paramString, long paramLong)
  {
    super(paramLong, 0, 2, null);
    AppMethodBeat.i(156390);
    this.TAG = "MMFileSlotManager";
    this.CLEAR_DELAY = 1000L;
    this.prefix = (paramString + '/' + paramLong + '/');
    AppMethodBeat.o(156390);
  }
  
  private final String getSlotPath(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.aSD()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void clearSlot(long paramLong, q paramq)
  {
    AppMethodBeat.i(261522);
    p.k(paramq, "slot");
    Log.v(this.TAG, "clearSlot");
    ??? = paramq.a((z)new z()
    {
      public final boolean accept(q paramAnonymousq, String paramAnonymousString)
      {
        AppMethodBeat.i(263316);
        p.k(paramAnonymousString, "name");
        boolean bool = p.h(paramAnonymousString, String.valueOf(this.$slotId));
        AppMethodBeat.o(263316);
        return bool ^ true;
      }
    });
    Object localObject2;
    Object localObject3;
    if (??? != null)
    {
      localObject2 = (Collection)new ArrayList(???.length);
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = ???[i];
        ((Collection)localObject2).add(paramq.getPath() + '/' + (String)localObject3);
        i += 1;
      }
    }
    for (paramq = (List)localObject2;; paramq = null)
    {
      paramLong = this.CLEAR_DELAY;
      localObject2 = List.class.getCanonicalName() + '_' + "batch";
      synchronized (__BATCH_RUN_OBJ.INSTANCE)
      {
        localObject3 = (by)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject2);
        if (localObject3 != null) {
          ((by)localObject3).a(null);
        }
        localObject3 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
        if (!((HashMap)localObject3).containsKey(localObject2)) {
          ((Map)localObject3).put(localObject2, new LinkedList());
        }
        localObject3 = ((HashMap)localObject3).get(localObject2);
        if (localObject3 != null) {
          break;
        }
        paramq = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(261522);
        throw paramq;
      }
    }
    ((LinkedList)localObject3).add(paramq);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject2, g.b((ak)br.abxo, (f)bc.iRs(), (m)new kotlin.d.b.a.j(paramLong, (String)localObject2)
    {
      Object L$0;
      int label;
      private ak p$;
      
      public final d<x> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(175892);
        p.k(paramAnonymousd, "completion");
        paramAnonymousd = new 1(this.$delay, this.$key, paramAnonymousd, this.this$0);
        paramAnonymousd.p$ = ((ak)paramAnonymousObject);
        AppMethodBeat.o(175892);
        return paramAnonymousd;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(175893);
        paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (d)paramAnonymousObject2)).invokeSuspend(x.aazN);
        AppMethodBeat.o(175893);
        return paramAnonymousObject1;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(175891);
        Object localObject1 = a.aaAA;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(175891);
          throw paramAnonymousObject;
        case 0: 
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = this.p$;
          long l = this.$delay;
          this.L$0 = paramAnonymousObject;
          this.label = 1;
          if (aw.a(l, this) == localObject1)
          {
            AppMethodBeat.o(175891);
            return localObject1;
          }
          break;
        case 1: 
          localObject1 = (ak)this.L$0;
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = localObject1;
        }
        if (!al.a(paramAnonymousObject))
        {
          paramAnonymousObject = x.aazN;
          AppMethodBeat.o(175891);
          return paramAnonymousObject;
        }
        synchronized (__BATCH_RUN_OBJ.INSTANCE)
        {
          localObject1 = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(this.$key);
          paramAnonymousObject = localObject1;
          if (!(localObject1 instanceof Queue)) {
            paramAnonymousObject = null;
          }
          paramAnonymousObject = (Queue)paramAnonymousObject;
          if (paramAnonymousObject != null)
          {
            __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(this.$key);
            paramAnonymousObject = new ArrayList((Collection)paramAnonymousObject);
            if (paramAnonymousObject == null) {
              break label373;
            }
            localObject1 = (Iterable)paramAnonymousObject;
            paramAnonymousObject = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              ??? = (List)((Iterator)localObject1).next();
              if (??? == null) {
                p.iCn();
              }
              kotlin.a.j.a(paramAnonymousObject, (Iterable)???);
            }
          }
          paramAnonymousObject = null;
        }
        paramAnonymousObject = (List)paramAnonymousObject;
        if (!paramAnonymousObject.isEmpty())
        {
          Log.i(MMFileSlotManager.access$getTAG$p(this.this$0), "clear file slots:\n" + kotlin.a.j.a((Iterable)paramAnonymousObject, (CharSequence)"\n", null, null, 0, null, null, 62));
          h.ZvG.bf((Runnable)new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(175890);
              Iterator localIterator = ((Iterable)this.$toClear).iterator();
              while (localIterator.hasNext()) {
                u.deleteDir((String)localIterator.next());
              }
              AppMethodBeat.o(175890);
            }
          });
        }
        label373:
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
        paramAnonymousObject = x.aazN;
        AppMethodBeat.o(175891);
        return paramAnonymousObject;
      }
    }, 2));
    AppMethodBeat.o(261522);
  }
  
  protected final boolean containsKey(q paramq, String paramString)
  {
    AppMethodBeat.i(261533);
    p.k(paramq, "slot");
    p.k(paramString, "key");
    paramq = new q(paramq.getPath() + '/' + paramString);
    if ((paramq.ifE()) && (paramq.length() > 0L))
    {
      AppMethodBeat.o(261533);
      return true;
    }
    AppMethodBeat.o(261533);
    return false;
  }
  
  protected final String getPrefix()
  {
    return this.prefix;
  }
  
  protected final q getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(261526);
    p.k(paramString, "slotKey");
    paramString = new q(getSlotPath(paramString, paramLong));
    Log.v(this.TAG, "getSlotByKey path = " + paramString.getPath());
    if (!paramString.ifE())
    {
      paramString.ifL();
      Log.v(this.TAG, "getSlotByKey mkdirs = ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(261526);
    return paramString;
  }
  
  protected final void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    p.k(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    p.k(paramString, "slotKey");
    paramString = new q(getSlotPath(paramString, paramLong));
    if ((paramString.ifE()) && (paramString.length() > 0L))
    {
      AppMethodBeat.o(156388);
      return true;
    }
    AppMethodBeat.o(156388);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMFileSlotManager
 * JD-Core Version:    0.7.0.1
 */