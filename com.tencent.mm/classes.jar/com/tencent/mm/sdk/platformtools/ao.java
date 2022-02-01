package com.tencent.mm.sdk.platformtools;

import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import d.d.a.a;
import d.d.d;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sdk/platformtools/MMFileSlotManager;", "Lcom/tencent/mm/sdk/platformtools/BaseSlotManager;", "Lcom/tencent/mm/vfs/VFSFile;", "name", "", "slotSeconds", "", "(Ljava/lang/String;J)V", "CLEAR_DELAY", "TAG", "prefix", "getPrefix", "()Ljava/lang/String;", "clearSlot", "", "slotId", "slot", "containsKey", "", "key", "getSlotByKey", "slotKey", "remarkSlot", "verifySlot", "getSlotPath", "libcompatible_release"})
public final class ao
  extends e<com.tencent.mm.vfs.e>
{
  private final long IdH;
  final String TAG;
  private final String inP;
  
  public ao(String paramString, long paramLong)
  {
    super(paramLong, (byte)0);
    AppMethodBeat.i(156390);
    this.TAG = "MMFileSlotManager";
    this.IdH = 1000L;
    this.inP = (paramString + '/' + paramLong + '/');
    AppMethodBeat.o(156390);
  }
  
  private static String bX(String paramString, long paramLong)
  {
    AppMethodBeat.i(156384);
    StringBuilder localStringBuilder = new StringBuilder().append(b.arM()).append("mmslot/").append(paramString).append('/');
    if (paramLong > 0L) {}
    for (paramString = paramLong + '/';; paramString = "")
    {
      paramString = paramString;
      AppMethodBeat.o(156384);
      return paramString;
    }
  }
  
  protected final void bU(String paramString, long paramLong)
  {
    AppMethodBeat.i(156387);
    p.h(paramString, "slotKey");
    AppMethodBeat.o(156387);
  }
  
  protected final boolean bV(String paramString, long paramLong)
  {
    AppMethodBeat.i(156388);
    p.h(paramString, "slotKey");
    paramString = new com.tencent.mm.vfs.e(bX(paramString, paramLong));
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
    return this.inP;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "com/tencent/mm/sdk/platformtools/MMBatchRunKt$batchRun$2", "com/tencent/mm/sdk/platformtools/MMFileSlotManager$$special$$inlined$batchRun$1"})
  public static final class a
    extends d.d.b.a.j
    implements d.g.a.m<ah, d<? super z>, Object>
  {
    int label;
    private ah nWQ;
    Object nWR;
    
    public a(long paramLong, String paramString, d paramd, ao paramao)
    {
      super();
    }
    
    public final d<z> a(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(175892);
      p.h(paramd, "completion");
      paramd = new a(this.oju, this.kxJ, paramd, this.IdI);
      paramd.nWQ = ((ah)paramObject);
      AppMethodBeat.o(175892);
      return paramd;
    }
    
    public final Object cQ(Object paramObject)
    {
      AppMethodBeat.i(175891);
      Object localObject1 = a.MLc;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(175891);
        throw paramObject;
      case 0: 
        paramObject = this.nWQ;
        long l = this.oju;
        this.nWR = paramObject;
        this.label = 1;
        if (at.a(l, this) == localObject1)
        {
          AppMethodBeat.o(175891);
          return localObject1;
        }
        break;
      case 1: 
        paramObject = (ah)this.nWR;
      }
      if (!ai.a(paramObject))
      {
        paramObject = z.MKo;
        AppMethodBeat.o(175891);
        return paramObject;
      }
      synchronized (by.IgT)
      {
        paramObject = by.IgT;
        localObject1 = by.fmd().get(this.kxJ);
        paramObject = localObject1;
        if (!(localObject1 instanceof Queue)) {
          paramObject = null;
        }
        paramObject = (Queue)paramObject;
        if (paramObject != null)
        {
          localObject1 = by.IgT;
          by.fmd().remove(this.kxJ);
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
              p.gfZ();
            }
            d.a.j.a(paramObject, (Iterable)???);
          }
        }
        paramObject = null;
      }
      paramObject = (List)paramObject;
      if (!paramObject.isEmpty())
      {
        ad.i(this.IdI.TAG, "clear file slots:\n" + d.a.j.a((Iterable)paramObject, (CharSequence)"\n", null, null, 0, null, null, 62));
        h.LTJ.aS((Runnable)new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(175890);
            Iterator localIterator = ((Iterable)this.IdJ).iterator();
            while (localIterator.hasNext()) {
              com.tencent.mm.vfs.i.deleteDir((String)localIterator.next());
            }
            AppMethodBeat.o(175890);
          }
        });
      }
      label364:
      paramObject = by.IgT;
      by.fmc().remove(this.kxJ);
      paramObject = z.MKo;
      AppMethodBeat.o(175891);
      return paramObject;
    }
    
    public final Object p(Object paramObject1, Object paramObject2)
    {
      AppMethodBeat.i(175893);
      paramObject1 = ((a)a(paramObject1, (d)paramObject2)).cQ(z.MKo);
      AppMethodBeat.o(175893);
      return paramObject1;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/vfs/VFSFile;", "kotlin.jvm.PlatformType", "name", "", "accept"})
  static final class b
    implements com.tencent.mm.vfs.m
  {
    b(long paramLong) {}
    
    public final boolean wY(String paramString)
    {
      AppMethodBeat.i(175894);
      boolean bool = p.i(paramString, String.valueOf(this.IdK));
      AppMethodBeat.o(175894);
      return bool ^ true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.ao
 * JD-Core Version:    0.7.0.1
 */