package com.tencent.mm.sdk.platformtools;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.e;
import d.d.a.a;
import d.g.b.k;
import d.l;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class ao
  extends d<e>
{
  private final long EUG;
  final String TAG;
  private final String htS;
  
  public ao(String paramString, long paramLong)
  {
    super(paramLong, (byte)0);
    AppMethodBeat.i(156390);
    this.TAG = "MMFileSlotManager";
    this.EUG = 1000L;
    this.htS = (paramString + '/' + paramLong + '/');
    AppMethodBeat.o(156390);
  }
  
  private static String bR(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.ahZ()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void bO(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    k.h(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean bP(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    k.h(paramString, "slotKey");
    paramString = new e(bR(paramString, paramLong));
    if ((paramString.exists()) && (paramString.length() > 0L))
    {
      AppMethodBeat.o(156388);
      return true;
    }
    AppMethodBeat.o(156388);
    return false;
  }
  
  protected final String getPrefix()
  {
    return this.htS;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1"})
  public static final class a
    extends d.d.b.a.j
    implements d.g.a.m<kotlinx.coroutines.ad, d.d.d<? super y>, Object>
  {
    int label;
    private kotlinx.coroutines.ad mTa;
    Object mTb;
    
    public a(long paramLong, String paramString, d.d.d paramd, ao paramao)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(175892);
      k.h(paramd, "completion");
      paramd = new a(this.nef, this.jCN, paramd, this.EUH);
      paramd.mTa = ((kotlinx.coroutines.ad)paramObject);
      AppMethodBeat.o(175892);
      return paramd;
    }
    
    public final Object cP(Object paramObject)
    {
      AppMethodBeat.i(175891);
      paramObject = a.JgJ;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(175891);
        throw paramObject;
      case 0: 
        localObject1 = this.mTa;
        long l = this.nef;
        this.mTb = localObject1;
        this.label = 1;
        if (kotlinx.coroutines.ao.a(l, this) == paramObject)
        {
          AppMethodBeat.o(175891);
          return paramObject;
        }
        break;
      }
      synchronized (by.EXM)
      {
        paramObject = by.EXM;
        localObject1 = by.eGY().get(this.jCN);
        paramObject = localObject1;
        if (!(localObject1 instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject1 = by.EXM;
          by.eGY().remove(this.jCN);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject == null) {
            break label338;
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (List)((Iterator)localObject1).next();
            if (??? == null) {
              k.fvU();
            }
            d.a.j.a(paramObject, (Iterable)???);
          }
        }
        paramObject = null;
      }
      paramObject = (List)paramObject;
      if (!paramObject.isEmpty())
      {
        ad.i(this.EUH.TAG, "clear file slots:\n" + d.a.j.a((Iterable)paramObject, (CharSequence)"\n", null, null, 0, null, null, 62));
        h.Iye.aQ((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175890);
            Iterator localIterator = ((Iterable)this.EUI).iterator();
            while (localIterator.hasNext()) {
              com.tencent.mm.vfs.i.deleteDir((String)localIterator.next());
            }
            AppMethodBeat.o(175890);
          }
        });
      }
      label338:
      paramObject = by.EXM;
      by.eGX().remove(this.jCN);
      paramObject = y.JfV;
      AppMethodBeat.o(175891);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(175893);
      paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cP(y.JfV);
      AppMethodBeat.o(175893);
      return paramObject1;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
  static final class b
    implements com.tencent.mm.vfs.m
  {
    b(long paramLong) {}
    
    public final boolean qT(String paramString)
    {
      AppMethodBeat.i(175894);
      boolean bool = k.g(paramString, String.valueOf(this.EUJ));
      AppMethodBeat.o(175894);
      return bool ^ true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ao
 * JD-Core Version:    0.7.0.1
 */