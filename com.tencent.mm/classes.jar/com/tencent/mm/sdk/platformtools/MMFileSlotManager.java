package com.tencent.mm.sdk.platformtools;

import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.w;
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
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.au;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bn;
import kotlinx.coroutines.bu;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class MMFileSlotManager
  extends BaseSlotManager<o>
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
    StringBuilder localStringBuilder = new StringBuilder().append(b.aKB()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void clearSlot(long paramLong, o paramo)
  {
    AppMethodBeat.i(215486);
    p.h(paramo, "slot");
    Log.v(this.TAG, "clearSlot");
    ??? = paramo.a((w)new MMFileSlotManager.clearSlot.1(paramLong));
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
        ((Collection)localObject2).add(paramo.getPath() + '/' + (String)localObject3);
        i += 1;
      }
    }
    for (paramo = (List)localObject2;; paramo = null)
    {
      paramLong = this.CLEAR_DELAY;
      localObject2 = List.class.getCanonicalName() + '_' + "batch";
      synchronized (__BATCH_RUN_OBJ.INSTANCE)
      {
        localObject3 = (bu)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs().get(localObject2);
        if (localObject3 != null) {
          ((bu)localObject3).a(null);
        }
        localObject3 = __BATCH_RUN_OBJ.INSTANCE.getBatchData();
        if (!((HashMap)localObject3).containsKey(localObject2)) {
          ((Map)localObject3).put(localObject2, new LinkedList());
        }
        localObject3 = ((HashMap)localObject3).get(localObject2);
        if (localObject3 != null) {
          break;
        }
        paramo = new t("null cannot be cast to non-null type java.util.LinkedList<T>");
        AppMethodBeat.o(215486);
        throw paramo;
      }
    }
    ((LinkedList)localObject3).add(paramo);
    ((Map)__BATCH_RUN_OBJ.INSTANCE.getBatchJobs()).put(localObject2, kotlinx.coroutines.f.b((ai)bn.TUK, (kotlin.d.f)ba.hMW(), (m)new kotlin.d.b.a.j(paramLong, (String)localObject2)
    {
      Object L$0;
      int label;
      private ai p$;
      
      public final d<x> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(175892);
        p.h(paramAnonymousd, "completion");
        paramAnonymousd = new 1(this.$delay, this.$key, paramAnonymousd, this.this$0);
        paramAnonymousd.p$ = ((ai)paramAnonymousObject);
        AppMethodBeat.o(175892);
        return paramAnonymousd;
      }
      
      public final Object invoke(Object paramAnonymousObject1, Object paramAnonymousObject2)
      {
        AppMethodBeat.i(175893);
        paramAnonymousObject1 = ((1)create(paramAnonymousObject1, (d)paramAnonymousObject2)).invokeSuspend(x.SXb);
        AppMethodBeat.o(175893);
        return paramAnonymousObject1;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(175891);
        Object localObject1 = a.SXO;
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
          if (au.a(l, this) == localObject1)
          {
            AppMethodBeat.o(175891);
            return localObject1;
          }
          break;
        case 1: 
          localObject1 = (ai)this.L$0;
          ResultKt.throwOnFailure(paramAnonymousObject);
          paramAnonymousObject = localObject1;
        }
        if (!aj.a(paramAnonymousObject))
        {
          paramAnonymousObject = x.SXb;
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
                p.hyc();
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
          h.RTc.aY((Runnable)new MMFileSlotManager.clearSlot..inlined.also.lambda.1.1(paramAnonymousObject));
        }
        label373:
        __BATCH_RUN_OBJ.INSTANCE.getBatchJobs().remove(this.$key);
        paramAnonymousObject = x.SXb;
        AppMethodBeat.o(175891);
        return paramAnonymousObject;
      }
    }, 2));
    AppMethodBeat.o(215486);
  }
  
  protected final boolean containsKey(o paramo, String paramString)
  {
    AppMethodBeat.i(215488);
    p.h(paramo, "slot");
    p.h(paramString, "key");
    paramo = new o(paramo.getPath() + '/' + paramString);
    if ((paramo.exists()) && (paramo.length() > 0L))
    {
      AppMethodBeat.o(215488);
      return true;
    }
    AppMethodBeat.o(215488);
    return false;
  }
  
  protected final String getPrefix()
  {
    return this.prefix;
  }
  
  protected final o getSlotByKey(String paramString, long paramLong)
  {
    AppMethodBeat.i(215487);
    p.h(paramString, "slotKey");
    paramString = new o(getSlotPath(paramString, paramLong));
    Log.v(this.TAG, "getSlotByKey path = " + paramString.getPath());
    if (!paramString.exists())
    {
      paramString.mkdirs();
      Log.v(this.TAG, "getSlotByKey mkdirs = ".concat(String.valueOf(paramString)));
    }
    AppMethodBeat.o(215487);
    return paramString;
  }
  
  protected final void remarkSlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    p.h(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean verifySlot(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    p.h(paramString, "slotKey");
    paramString = new o(getSlotPath(paramString, paramLong));
    if ((paramString.exists()) && (paramString.length() > 0L))
    {
      AppMethodBeat.o(156388);
      return true;
    }
    AppMethodBeat.o(156388);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMFileSlotManager
 * JD-Core Version:    0.7.0.1
 */