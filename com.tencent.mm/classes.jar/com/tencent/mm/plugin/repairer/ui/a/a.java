package com.tencent.mm.plugin.repairer.ui.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/datasource/RepairerDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/repairer/ui/model/RepairerMvvmListItem;", "initItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "needTop", "", "(Lcom/tencent/mm/protocal/protobuf/RepairerItem;Z)V", "getInitItem", "()Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "getNeedTop", "()Z", "repairerItemList", "Ljava/util/LinkedList;", "getRepairerItemList", "()Ljava/util/LinkedList;", "findItemByKey", "key", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "onCreate", "", "Companion", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.mvvmlist.a.a<com.tencent.mm.plugin.repairer.ui.c.c>
{
  public static final a OwD;
  private final ept OwE;
  private final boolean OwF;
  private final LinkedList<com.tencent.mm.plugin.repairer.ui.c.c> OwG;
  
  static
  {
    AppMethodBeat.i(277892);
    OwD = new a((byte)0);
    AppMethodBeat.o(277892);
  }
  
  public a(ept paramept, boolean paramBoolean)
  {
    AppMethodBeat.i(277881);
    this.OwE = paramept;
    this.OwF = paramBoolean;
    this.OwG = new LinkedList();
    AppMethodBeat.o(277881);
  }
  
  private ept a(String paramString, ept paramept)
  {
    AppMethodBeat.i(277886);
    s.u(paramString, "key");
    s.u(paramept, "item");
    if (s.p(paramept.key, paramString))
    {
      AppMethodBeat.o(277886);
      return paramept;
    }
    if (paramept.type == 1)
    {
      paramept = paramept.abtJ;
      s.s(paramept, "item.subItemList");
      paramept = ((Iterable)paramept).iterator();
      while (paramept.hasNext())
      {
        ept localept = (ept)paramept.next();
        s.s(localept, "it");
        localept = a(paramString, localept);
        if (localept != null)
        {
          AppMethodBeat.o(277886);
          return localept;
        }
      }
    }
    AppMethodBeat.o(277886);
    return null;
  }
  
  public final g<d<com.tencent.mm.plugin.repairer.ui.c.c>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<com.tencent.mm.plugin.repairer.ui.c.c> paramc)
  {
    AppMethodBeat.i(277914);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    paramLifecycleScope = new q();
    paramc = new d(paramc);
    paramc.pUj.addAll((Collection)this.OwG);
    paramLifecycleScope.offer(paramc);
    paramLifecycleScope = k.a((f)paramLifecycleScope);
    AppMethodBeat.o(277914);
    return paramLifecycleScope;
  }
  
  public final void onCreate()
  {
    int j = 0;
    AppMethodBeat.i(277907);
    this.OwG.clear();
    Object localObject2;
    if (this.OwF)
    {
      localObject1 = i.agtt;
      localObject1 = i.a(b.a.agqq, "");
      Log.i("MicroMsg.Repairer.RepairerDataSource", s.X("favKeyString: ", localObject1));
      localObject1 = ((Iterable)n.a((CharSequence)localObject1, new String[] { "," })).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localObject2 = a((String)localObject2, this.OwE);
        if (localObject2 != null) {
          this.OwG.add(new com.tencent.mm.plugin.repairer.ui.c.c(i, 0, (ept)localObject2, a.a((ept)localObject2)));
        }
        i += 1;
      }
    }
    Object localObject1 = this.OwE.abtJ;
    s.s(localObject1, "initItem.subItemList");
    localObject1 = ((Iterable)localObject1).iterator();
    int i = j;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        p.kkW();
      }
      localObject2 = (ept)localObject2;
      LinkedList localLinkedList = this.OwG;
      s.s(localObject2, "item");
      localLinkedList.add(new com.tencent.mm.plugin.repairer.ui.c.c(i, 1, (ept)localObject2, a.a((ept)localObject2)));
      i += 1;
    }
    AppMethodBeat.o(277907);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/repairer/ui/datasource/RepairerDataSource$Companion;", "", "()V", "TAG", "", "getShowValue", "repairerItem", "Lcom/tencent/mm/protocal/protobuf/RepairerItem;", "ui-repairer_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String a(ept paramept)
    {
      AppMethodBeat.i(277885);
      s.u(paramept, "repairerItem");
      if (paramept.type == 3)
      {
        String str = paramept.key;
        s.s(str, "repairerItem.key");
        b.a locala = b.a.valueOf(str);
        str = paramept.key;
        s.s(str, "repairerItem.key");
        Object localObject = n.a((CharSequence)str, new String[] { "_" });
        str = "";
        localObject = (String)((List)localObject).get(3);
        switch (((String)localObject).hashCode())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(277885);
          return str;
          if (((String)localObject).equals("Float"))
          {
            paramept = i.agtt;
            str = i.a(locala, Float.valueOf(0.0F)).toString();
            continue;
            if (((String)localObject).equals("Long"))
            {
              paramept = i.agtt;
              str = i.a(locala, Long.valueOf(0L)).toString();
              continue;
              if (((String)localObject).equals("String"))
              {
                paramept = i.agtt;
                str = i.a(locala, "").toString();
                continue;
                if (((String)localObject).equals("Int"))
                {
                  str = paramept.defaultValue;
                  paramept = (CharSequence)str;
                  if ((paramept == null) || (paramept.length() == 0)) {}
                  for (int i = 1;; i = 0)
                  {
                    if (i == 0) {
                      break label283;
                    }
                    paramept = i.agtt;
                    str = i.a(locala, Integer.valueOf(0)).toString();
                    break;
                  }
                  label283:
                  s.s(str, "{\n                      …                        }");
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(277885);
      return "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.repairer.ui.a.a
 * JD-Core Version:    0.7.0.1
 */