package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class MMFileSlotManager
  extends BaseSlotManager<u>
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
  
  private static final boolean clearSlot$lambda-0(long paramLong, u paramu, String paramString)
  {
    AppMethodBeat.i(243462);
    s.u(paramString, "name");
    if (!s.p(paramString, String.valueOf(paramLong)))
    {
      AppMethodBeat.o(243462);
      return true;
    }
    AppMethodBeat.o(243462);
    return false;
  }
  
  private final String getSlotPath(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.bmr()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void clearSlot(long paramLong, u paramu)
  {
    AppMethodBeat.i(243482);
    s.u(paramu, "slot");
    Log.v(this.TAG, "clearSlot");
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        ??? = paramu.a(new MMFileSlotManager..ExternalSyntheticLambda0(paramLong));
        if (??? == null)
        {
          paramu = null;
          paramLong = this.CLEAR_DELAY;
          localObject2 = List.class.getCanonicalName() + '_' + "batch";
          synchronized (__BATCH_RUN_OBJ.INSTANCE)
          {
            localObject3 = (cb)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject2);
            if (localObject3 != null) {
              ((cb)localObject3).a(null);
            }
            localObject3 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
            if (!((HashMap)localObject3).containsKey(localObject2)) {
              ((Map)localObject3).put(localObject2, new LinkedList());
            }
            localObject3 = ((HashMap)localObject3).get(localObject2);
            if (localObject3 != null) {
              break;
            }
            paramu = new NullPointerException("null cannot be cast to non-null type java.util.LinkedList<T of com.tencent.mm.sdk.platformtools.MMBatchRunKt.batchRun$lambda-1$lambda-0>");
            AppMethodBeat.o(243482);
            throw paramu;
          }
        }
        localObject2 = (Collection)new ArrayList(???.length);
      }
      catch (Exception paramu)
      {
        Log.printErrStackTrace(this.TAG, (Throwable)paramu, "clearSlot", new Object[0]);
        AppMethodBeat.o(243482);
        return;
      }
      int j = ???.length;
      int i = 0;
      while (i < j)
      {
        localObject3 = ???[i];
        ((Collection)localObject2).add(com.tencent.mm.vfs.ah.v(paramu.mUri) + '/' + localObject3);
        i += 1;
      }
      paramu = (List)localObject2;
    }
    ((LinkedList)localObject3).add(paramu);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject2, j.a((aq)bu.ajwo, (f)bg.kCi(), null, (m)new k(paramLong, (String)localObject2)
    {
      int label;
      
      public final d<kotlin.ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(243490);
        paramAnonymousd = new 1(this.$delay, this.$key, paramAnonymousd, this.this$0);
        paramAnonymousd.L$0 = paramAnonymousObject;
        paramAnonymousObject = (d)paramAnonymousd;
        AppMethodBeat.o(243490);
        return paramAnonymousObject;
      }
      
      public final Object invoke(aq paramAnonymousaq, d<? super kotlin.ah> paramAnonymousd)
      {
        AppMethodBeat.i(243495);
        paramAnonymousaq = ((1)create(paramAnonymousaq, paramAnonymousd)).invokeSuspend(kotlin.ah.aiuX);
        AppMethodBeat.o(243495);
        return paramAnonymousaq;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(243485);
        Object localObject1 = a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(243485);
          throw paramAnonymousObject;
        case 0: 
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = (aq)this.L$0;
          long l = this.$delay;
          localObject2 = (d)this;
          this.L$0 = paramAnonymousObject;
          this.label = 1;
          if (bb.e(l, (d)localObject2) == localObject1)
          {
            AppMethodBeat.o(243485);
            return localObject1;
          }
          break;
        case 1: 
          localObject1 = (aq)this.L$0;
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = localObject1;
        }
        if (!ar.a(paramAnonymousObject))
        {
          paramAnonymousObject = kotlin.ah.aiuX;
          AppMethodBeat.o(243485);
          return paramAnonymousObject;
        }
        localObject1 = __BATCH_RUN_OBJ.INSTANCE;
        Object localObject2 = this.$key;
        try
        {
          paramAnonymousObject = __BATCH_RUN_OBJ.INSTANCE.getBatchData().get(localObject2);
          if ((paramAnonymousObject instanceof Queue))
          {
            paramAnonymousObject = (Queue)paramAnonymousObject;
            if (paramAnonymousObject != null) {
              break label264;
            }
          }
          for (paramAnonymousObject = null;; paramAnonymousObject = new ArrayList((Collection)paramAnonymousObject))
          {
            if (paramAnonymousObject == null) {
              break label370;
            }
            localObject1 = (Iterable)paramAnonymousObject;
            paramAnonymousObject = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (List)((Iterator)localObject1).next();
              s.checkNotNull(localObject2);
              p.a(paramAnonymousObject, (Iterable)localObject2);
            }
            paramAnonymousObject = null;
            break;
            label264:
            __BATCH_RUN_OBJ.INSTANCE.getBatchData().remove(localObject2);
          }
          paramAnonymousObject = (List)paramAnonymousObject;
        }
        finally
        {
          AppMethodBeat.o(243485);
        }
        if (!paramAnonymousObject.isEmpty())
        {
          Log.i(MMFileSlotManager.access$getTAG$p(this.this$0), s.X("clear file slots:\n", p.a((Iterable)paramAnonymousObject, (CharSequence)"\n", null, null, 0, null, null, 62)));
          h.ahAA.bn((Runnable)new MMFileSlotManager.clearSlot.3.1.1(paramAnonymousObject));
        }
        label370:
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
        paramAnonymousObject = kotlin.ah.aiuX;
        AppMethodBeat.o(243485);
        return paramAnonymousObject;
      }
    }, 2));
    AppMethodBeat.o(243482);
  }
  
  protected final boolean containsKey(u paramu, String paramString)
  {
    AppMethodBeat.i(243502);
    s.u(paramu, "slot");
    s.u(paramString, "key");
    paramu = new u(com.tencent.mm.vfs.ah.v(paramu.mUri) + '/' + paramString);
    if ((paramu.jKS()) && (paramu.length() > 0L))
    {
      AppMethodBeat.o(243502);
      return true;
    }
    AppMethodBeat.o(243502);
    return false;
  }
  
  protected final String getPrefix()
  {
    return this.prefix;
  }
  
  protected final u getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(243487);
    s.u(paramString, "slotKey");
    paramString = new u(getSlotPath(paramString, paramLong));
    Log.v(this.TAG, s.X("getSlotByKey path = ", com.tencent.mm.vfs.ah.v(paramString.mUri)));
    if (!paramString.jKS())
    {
      paramString.jKY();
      Log.v(this.TAG, s.X("getSlotByKey mkdirs = ", paramString));
    }
    AppMethodBeat.o(243487);
    return paramString;
  }
  
  protected final void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    s.u(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    s.u(paramString, "slotKey");
    paramString = new u(getSlotPath(paramString, paramLong));
    if ((paramString.jKS()) && (paramString.length() > 0L))
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