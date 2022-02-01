package com.tencent.mm.sdk.platformtools;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.e;
import d.a.j;
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
import kotlinx.coroutines.ag;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.as;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class an
  extends d<e>
{
  private final long GrS;
  final String TAG;
  private final String hUu;
  
  public an(String paramString, long paramLong)
  {
    super(paramLong, (byte)0);
    AppMethodBeat.i(156390);
    this.TAG = "MMFileSlotManager";
    this.GrS = 1000L;
    this.hUu = (paramString + '/' + paramLong + '/');
    AppMethodBeat.o(156390);
  }
  
  private static String bT(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.aoZ()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void bQ(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    k.h(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean bR(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    k.h(paramString, "slotKey");
    paramString = new e(bT(paramString, paramLong));
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
    return this.hUu;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1"})
  public static final class a
    extends d.d.b.a.i
    implements d.g.a.m<ag, d.d.d<? super y>, Object>
  {
    int label;
    private ag nvs;
    Object nvt;
    
    public a(long paramLong, String paramString, d.d.d paramd, an paraman)
    {
      super();
    }
    
    public final d.d.d<y> a(Object paramObject, d.d.d<?> paramd)
    {
      AppMethodBeat.i(175892);
      k.h(paramd, "completion");
      paramd = new a(this.nGR, this.kdj, paramd, this.GrT);
      paramd.nvs = ((ag)paramObject);
      AppMethodBeat.o(175892);
      return paramd;
    }
    
    public final Object cO(Object paramObject)
    {
      AppMethodBeat.i(175891);
      Object localObject1 = a.KUd;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(175891);
        throw paramObject;
      case 0: 
        paramObject = this.nvs;
        long l = this.nGR;
        this.nvt = paramObject;
        this.label = 1;
        if (as.b(l, this) == localObject1)
        {
          AppMethodBeat.o(175891);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ag)this.nvt;
      }
      if (!ah.a(paramObject))
      {
        paramObject = y.KTp;
        AppMethodBeat.o(175891);
        return paramObject;
      }
      synchronized (bx.GuY)
      {
        paramObject = bx.GuY;
        localObject1 = bx.eWt().get(this.kdj);
        paramObject = localObject1;
        if (!(localObject1 instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject1 = bx.GuY;
          bx.eWt().remove(this.kdj);
          paramObject = new ArrayList((Collection)paramObject);
          if (paramObject == null) {
            break label364;
          }
          localObject1 = (Iterable)paramObject;
          paramObject = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (List)((Iterator)localObject1).next();
            if (??? == null) {
              k.fOy();
            }
            j.a(paramObject, (Iterable)???);
          }
        }
        paramObject = null;
      }
      paramObject = (List)paramObject;
      if (!paramObject.isEmpty())
      {
        ac.i(this.GrT.TAG, "clear file slots:\n" + j.a((Iterable)paramObject, (CharSequence)"\n", null, null, 0, null, null, 62));
        h.JZN.aT((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175890);
            Iterator localIterator = ((Iterable)this.GrU).iterator();
            while (localIterator.hasNext()) {
              com.tencent.mm.vfs.i.deleteDir((String)localIterator.next());
            }
            AppMethodBeat.o(175890);
          }
        });
      }
      label364:
      paramObject = bx.GuY;
      bx.eWs().remove(this.kdj);
      paramObject = y.KTp;
      AppMethodBeat.o(175891);
      return paramObject;
    }
    
    public final Object n(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(175893);
      paramObject1 = ((a)a(paramObject1, (d.d.d)paramObject2)).cO(y.KTp);
      AppMethodBeat.o(175893);
      return paramObject1;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
  static final class b
    implements com.tencent.mm.vfs.m
  {
    b(long paramLong) {}
    
    public final boolean ui(String paramString)
    {
      AppMethodBeat.i(175894);
      boolean bool = k.g(paramString, String.valueOf(this.GrV));
      AppMethodBeat.o(175894);
      return bool ^ true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.an
 * JD-Core Version:    0.7.0.1
 */