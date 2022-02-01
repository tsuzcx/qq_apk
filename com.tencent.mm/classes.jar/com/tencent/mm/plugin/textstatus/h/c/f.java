package com.tencent.mm.plugin.textstatus.h.c;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.h.f.g.c;
import com.tencent.mm.plugin.textstatus.ui.j;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/OtherTopicFriendDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "context", "Landroid/content/Context;", "excludeTopicId", "", "source", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "getContext", "()Landroid/content/Context;", "getExcludeTopicId", "()Ljava/lang/String;", "setExcludeTopicId", "(Ljava/lang/String;)V", "getSource", "()I", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getUvPerIconStr", "", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.textstatus.h.g.b>
{
  public static final a Tnu;
  private String Tnv;
  private final Context context;
  private final int source;
  
  static
  {
    AppMethodBeat.i(290649);
    Tnu = new a((byte)0);
    AppMethodBeat.o(290649);
  }
  
  public f(Context paramContext, String paramString, int paramInt)
  {
    AppMethodBeat.i(290642);
    this.context = paramContext;
    this.Tnv = paramString;
    this.source = paramInt;
    AppMethodBeat.o(290642);
  }
  
  public final kotlinx.coroutines.b.g<d<com.tencent.mm.plugin.textstatus.h.g.b>> a(LifecycleScope paramLifecycleScope, c<com.tencent.mm.plugin.textstatus.h.g.b> paramc)
  {
    AppMethodBeat.i(290662);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    Object localObject1 = new d(paramc);
    paramLifecycleScope = new q();
    paramc = a.kp(this.context);
    Object localObject2 = ((Iterable)paramc).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      com.tencent.mm.plugin.textstatus.h.g.b localb = (com.tencent.mm.plugin.textstatus.h.g.b)((Iterator)localObject2).next();
      ((d)localObject1).pUj.add(localb);
    }
    paramLifecycleScope.offer(localObject1);
    localObject1 = new StringBuilder();
    paramc = paramc.iterator();
    int i = 0;
    for (;;)
    {
      int j;
      if (paramc.hasNext())
      {
        j = i + 1;
        localObject2 = (com.tencent.mm.plugin.textstatus.h.g.b)paramc.next();
        if (i != 0) {
          ((StringBuilder)localObject1).append(";");
        }
        if (((com.tencent.mm.plugin.textstatus.h.g.b)localObject2).TnV.bMQ.size() > 0)
        {
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.textstatus.h.f.b)((com.tencent.mm.plugin.textstatus.h.g.b)localObject2).TnV.bMQ.get(0)).field_IconID);
          ((StringBuilder)localObject1).append("#");
          ((StringBuilder)localObject1).append(((com.tencent.mm.plugin.textstatus.h.g.b)localObject2).TnV.bMQ.size());
          i = j;
        }
      }
      else
      {
        paramc = ((StringBuilder)localObject1).toString();
        s.s(paramc, "sb.toString()");
        localObject1 = com.tencent.mm.plugin.textstatus.i.b.Trt;
        com.tencent.mm.plugin.textstatus.i.b.a(1L, null, 0, null, paramc, null, this.source, 0L, 174);
        paramLifecycleScope = kotlinx.coroutines.b.k.a((kotlinx.coroutines.a.f)paramLifecycleScope);
        AppMethodBeat.o(290662);
        return paramLifecycleScope;
      }
      i = j;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/model/feed/OtherTopicFriendDataSource$Companion;", "", "()V", "TAG", "", "getTotalList", "", "Lcom/tencent/mm/plugin/textstatus/model/topic/SameTopicFriendsItem;", "context", "Landroid/content/Context;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static List<com.tencent.mm.plugin.textstatus.h.g.b> kp(Context paramContext)
    {
      Object localObject2 = null;
      AppMethodBeat.i(290675);
      s.u(paramContext, "context");
      Object localObject3 = new LinkedList();
      Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
      localObject1 = com.tencent.mm.plugin.textstatus.b.f.bdN(com.tencent.mm.plugin.auth.a.a.cUx());
      Object localObject4;
      Object localObject5;
      if (localObject1 == null)
      {
        localObject1 = null;
        if (ac.hGq())
        {
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          localObject4 = com.tencent.mm.plugin.textstatus.b.f.hGH();
          localObject5 = com.tencent.mm.plugin.auth.a.a.cUx();
          s.s(localObject5, "username()");
          localObject4 = p.a((Iterable)((com.tencent.mm.plugin.textstatus.h.f.g)localObject4).p((String)localObject1, p.al(new String[] { localObject5 })), (Comparator)new a());
          localObject5 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
          localObject5 = com.tencent.mm.plugin.textstatus.b.f.bdN(com.tencent.mm.plugin.auth.a.a.cUx());
          if (localObject5 != null) {
            break label254;
          }
        }
      }
      for (;;)
      {
        if (localObject2 != null) {
          ((LinkedList)localObject3).add(0, localObject2);
        }
        localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        ((LinkedList)localObject3).addAll((Collection)com.tencent.mm.plugin.textstatus.b.f.hGH().nj((String)localObject1, com.tencent.mm.plugin.auth.a.a.cUx()));
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        paramContext = com.tencent.mm.ui.component.k.nq(paramContext).q(j.class);
        s.s(paramContext, "UICProvider.of(context).…pPageDataUIC::class.java)");
        paramContext = (j)paramContext;
        paramContext.pUj.clear();
        localObject1 = ((LinkedList)localObject3).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (g.c)((Iterator)localObject1).next();
          if (((g.c)localObject2).isValid())
          {
            ((g.c)localObject2).hHQ();
            localObject3 = paramContext.pUj;
            s.s(localObject2, "sameTopicItem");
            ((ArrayList)localObject3).add(new com.tencent.mm.plugin.textstatus.h.g.b((g.c)localObject2));
          }
        }
        localObject1 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_TopicId;
        break;
        label254:
        localObject5 = ((com.tencent.mm.plugin.textstatus.h.f.b)localObject5).field_TopicId;
        if (localObject5 != null) {
          localObject2 = new g.c((String)localObject5, p.J((Collection)localObject4));
        }
      }
      localObject1 = new LinkedList();
      paramContext = ((Iterable)paramContext.pUj).iterator();
      while (paramContext.hasNext()) {
        ((LinkedList)localObject1).add((com.tencent.mm.plugin.textstatus.h.g.b)paramContext.next());
      }
      paramContext = (List)localObject1;
      AppMethodBeat.o(290675);
      return paramContext;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k=3, mv={1, 5, 1})
    public static final class a<T>
      implements Comparator
    {
      public final int compare(T paramT1, T paramT2)
      {
        AppMethodBeat.i(290668);
        int i = kotlin.b.a.b((Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT2).field_CreateTime), (Comparable)Integer.valueOf(((com.tencent.mm.plugin.textstatus.h.f.b)paramT1).field_CreateTime));
        AppMethodBeat.o(290668);
        return i;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.h.c.f
 * JD-Core Version:    0.7.0.1
 */