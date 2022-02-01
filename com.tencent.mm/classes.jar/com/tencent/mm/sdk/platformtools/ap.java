package com.tencent.mm.sdk.platformtools;

import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import d.d.a.a;
import d.d.d;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlinx.coroutines.ah;
import kotlinx.coroutines.ai;
import kotlinx.coroutines.at;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class ap
  extends f<k>
{
  private final long IxS;
  final String TAG;
  private final String iqJ;
  
  public ap(String paramString, long paramLong)
  {
    super(paramLong, (byte)0);
    AppMethodBeat.i(156390);
    this.TAG = "MMFileSlotManager";
    this.IxS = 1000L;
    this.iqJ = (paramString + '/' + paramLong + '/');
    AppMethodBeat.o(156390);
  }
  
  private static String bY(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.asb()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    p.h(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean bW(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    p.h(paramString, "slotKey");
    paramString = new k(bY(paramString, paramLong));
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
    return this.iqJ;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1"})
  public static final class a
    extends d.d.b.a.j
    implements m<ah, d<? super z>, Object>
  {
    int label;
    Object ocA;
    private ah ocz;
    
    public a(long paramLong, String paramString, d paramd, ap paramap)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(175892);
      p.h(paramd, "completion");
      paramd = new a(this.opu, this.kAY, paramd, this.IxT);
      paramd.ocz = ((ah)paramObject);
      AppMethodBeat.o(175892);
      return paramd;
    }
    
    public final Object cR(Object paramObject)
    {
      AppMethodBeat.i(175891);
      Object localObject1 = a.Nif;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(175891);
        throw paramObject;
      case 0: 
        paramObject = this.ocz;
        long l = this.opu;
        this.ocA = paramObject;
        this.label = 1;
        if (at.a(l, this) == localObject1)
        {
          AppMethodBeat.o(175891);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ah)this.ocA;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.Nhr;
        AppMethodBeat.o(175891);
        return paramObject;
      }
      synchronized (bz.IBe)
      {
        paramObject = bz.IBe;
        localObject1 = bz.fpY().get(this.kAY);
        paramObject = localObject1;
        if (!(localObject1 instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject1 = bz.IBe;
          bz.fpY().remove(this.kAY);
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
              p.gkB();
            }
            d.a.j.a(paramObject, (Iterable)???);
          }
        }
        paramObject = null;
      }
      paramObject = (List)paramObject;
      if (!paramObject.isEmpty())
      {
        ae.i(this.IxT.TAG, "clear file slots:\n" + d.a.j.a((Iterable)paramObject, (CharSequence)"\n", null, null, 0, null, null, 62));
        h.MqF.aP((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175890);
            Iterator localIterator = ((Iterable)this.IxU).iterator();
            while (localIterator.hasNext()) {
              o.deleteDir((String)localIterator.next());
            }
            AppMethodBeat.o(175890);
          }
        });
      }
      label364:
      paramObject = bz.IBe;
      bz.fpX().remove(this.kAY);
      paramObject = z.Nhr;
      AppMethodBeat.o(175891);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(175893);
      paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cR(z.Nhr);
      AppMethodBeat.o(175893);
      return paramObject1;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
  static final class b
    implements s
  {
    b(long paramLong) {}
    
    public final boolean xH(String paramString)
    {
      AppMethodBeat.i(175894);
      boolean bool = p.i(paramString, String.valueOf(this.IxV));
      AppMethodBeat.o(175894);
      return bool ^ true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ap
 * JD-Core Version:    0.7.0.1
 */