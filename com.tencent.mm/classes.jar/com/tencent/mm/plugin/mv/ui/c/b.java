package com.tencent.mm.plugin.mv.ui.c;

import android.graphics.Bitmap;
import androidx.b.e;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.ui.thumb.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.videocomposition.c;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.bb;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader;", "", "thumbFetcherFactory", "Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/ThumbFetcherFactory;)V", "caches", "com/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$caches$1", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$caches$1;", "entries", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Entry;", "Lkotlin/collections/HashMap;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "enqueue", "", "track", "time", "", "findNearby", "Landroid/graphics/Bitmap;", "get", "getEntry", "observe", "Lkotlinx/coroutines/flow/Flow;", "release", "stop", "Companion", "Entry", "Key", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final a Mde;
  private final g Mdf;
  public final d Mdg;
  public final HashMap<com.tencent.mm.plugin.vlog.ui.thumb.a, b> cmd;
  public final aq scope;
  
  static
  {
    AppMethodBeat.i(286565);
    Mde = new a((byte)0);
    AppMethodBeat.o(286565);
  }
  
  public b(g paramg)
  {
    AppMethodBeat.i(286529);
    this.Mdf = paramg;
    this.cmd = new HashMap();
    this.scope = ar.kBZ();
    this.Mdg = new d(this);
    AppMethodBeat.o(286529);
  }
  
  public final b a(com.tencent.mm.plugin.vlog.ui.thumb.a parama)
  {
    AppMethodBeat.i(286572);
    Map localMap = (Map)this.cmd;
    Object localObject = localMap.get(parama);
    if (localObject == null)
    {
      localObject = new b();
      localMap.put(parama, localObject);
    }
    for (parama = (com.tencent.mm.plugin.vlog.ui.thumb.a)localObject;; parama = (com.tencent.mm.plugin.vlog.ui.thumb.a)localObject)
    {
      parama = (b)parama;
      AppMethodBeat.o(286572);
      return parama;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Companion;", "", "()V", "TAG", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Entry;", "", "thumbFetcher", "Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "pending", "", "", "requesting", "readyTimes", "channel", "Lkotlinx/coroutines/channels/BroadcastChannel;", "job", "Lkotlinx/coroutines/Job;", "(Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;Ljava/util/Set;Ljava/util/Set;Ljava/util/Set;Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlinx/coroutines/Job;)V", "getChannel", "()Lkotlinx/coroutines/channels/BroadcastChannel;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "getPending", "()Ljava/util/Set;", "getReadyTimes", "getRequesting", "getThumbFetcher", "()Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;", "setThumbFetcher", "(Lcom/tencent/mm/videocomposition/ITrackThumbFetcher;)V", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public volatile c FTn;
    public final Set<Long> Mdh;
    public final Set<Long> Mdi;
    public final Set<Long> Mdj;
    public final kotlinx.coroutines.a.f<Long> Mdk;
    public cb job;
    
    private b(Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, kotlinx.coroutines.a.f<Long> paramf)
    {
      AppMethodBeat.i(286516);
      this.FTn = null;
      this.Mdh = paramSet1;
      this.Mdi = paramSet2;
      this.Mdj = paramSet3;
      this.Mdk = paramf;
      this.job = null;
      AppMethodBeat.o(286516);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Key;", "", "track", "Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "time", "", "(Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;J)V", "getTime", "()J", "getTrack", "()Lcom/tencent/mm/plugin/vlog/ui/thumb/BaseTrackThumbInfo;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
  {
    final com.tencent.mm.plugin.vlog.ui.thumb.a Mdl;
    final long time;
    
    public c(com.tencent.mm.plugin.vlog.ui.thumb.a parama, long paramLong)
    {
      AppMethodBeat.i(286513);
      this.Mdl = parama;
      this.time = paramLong;
      AppMethodBeat.o(286513);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(286526);
      if (this == paramObject)
      {
        AppMethodBeat.o(286526);
        return true;
      }
      if (!(paramObject instanceof c))
      {
        AppMethodBeat.o(286526);
        return false;
      }
      paramObject = (c)paramObject;
      if (!s.p(this.Mdl, paramObject.Mdl))
      {
        AppMethodBeat.o(286526);
        return false;
      }
      if (this.time != paramObject.time)
      {
        AppMethodBeat.o(286526);
        return false;
      }
      AppMethodBeat.o(286526);
      return true;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(286522);
      int i = this.Mdl.hashCode();
      int j = q.a..ExternalSyntheticBackport0.m(this.time);
      AppMethodBeat.o(286522);
      return i * 31 + j;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(286518);
      String str = "Key(track=" + this.Mdl + ", time=" + this.time + ')';
      AppMethodBeat.o(286518);
      return str;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$caches$1", "Landroidx/collection/LruCache;", "Lcom/tencent/mm/plugin/mv/ui/thumb/ThumbCachedLoader$Key;", "Landroid/graphics/Bitmap;", "entryRemoved", "", "evicted", "", "key", "oldValue", "newValue", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends e<b.c, Bitmap>
  {
    d(b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class e
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public e(b.b paramb, com.tencent.mm.plugin.vlog.ui.thumb.a parama, b paramb1, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(286543);
      paramObject = (d)new e(this.Mdn, this.Mdo, this.Mdm, paramd);
      AppMethodBeat.o(286543);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(286536);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(286536);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (d)this;
        this.label = 1;
        if (bb.e(50L, paramObject) == locala)
        {
          AppMethodBeat.o(286536);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = p.a((Iterable)p.p((Iterable)this.Mdn.Mdh), (Comparator)new a());
        Object localObject1 = new StringBuilder().append(this.Mdo).append(" request ");
        Object localObject2 = ((Collection)paramObject).toArray(new Long[0]);
        if (localObject2 == null)
        {
          paramObject = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(286536);
          throw paramObject;
        }
        localObject2 = Arrays.toString((Object[])localObject2);
        s.s(localObject2, "java.util.Arrays.toString(this)");
        Log.i("MicroMsg.ThumbCachedLoader", (String)localObject2 + ", size:[" + this.Mdo.width + ',' + this.Mdo.height + ']');
        this.Mdn.Mdi.addAll((Collection)paramObject);
        this.Mdn.Mdh.clear();
        localObject1 = (kotlin.d.f)bg.kCi();
        paramObject = (m)new k(this.Mdn, this.Mdm)
        {
          int label;
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(286537);
            paramAnonymousObject = (d)new 1(this.Mdn, this.Mdm, this.Mdo, paramObject, paramAnonymousd);
            AppMethodBeat.o(286537);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(286531);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(286531);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject = this.Mdn.FTn;
            paramAnonymousObject = localObject;
            if (localObject == null)
            {
              paramAnonymousObject = b.a(this.Mdm).a(this.Mdo, null);
              this.Mdn.FTn = paramAnonymousObject;
            }
            if (!ar.a(b.b(this.Mdm))) {
              paramAnonymousObject.destroy();
            }
            paramAnonymousObject.setSize(this.Mdo.width, this.Mdo.height);
            paramAnonymousObject.b(paramObject, (m)new u(this.Mdm) {});
            paramAnonymousObject = ah.aiuX;
            AppMethodBeat.o(286531);
            return paramAnonymousObject;
          }
        };
        localObject2 = (d)this;
        this.label = 2;
        if (l.a((kotlin.d.f)localObject1, paramObject, (d)localObject2) != locala) {
          break label337;
        }
        AppMethodBeat.o(286536);
        return locala;
      }
      ResultKt.throwOnFailure(paramObject);
      label337:
      paramObject = ah.aiuX;
      AppMethodBeat.o(286536);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(286532);
        int i = kotlin.b.a.b((Comparable)Long.valueOf(((Number)paramT1).longValue()), (Comparable)Long.valueOf(((Number)paramT2).longValue()));
        AppMethodBeat.o(286532);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.c.b
 * JD-Core Version:    0.7.0.1
 */