package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.a;
import com.tencent.mm.plugin.mvvmlist.a.c<Lcom.tencent.mm.plugin.mv.model.b.e;>;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egy;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.a.f;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "previewItemObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "(Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;)V", "listId", "", "getListId", "()Ljava/lang/String;", "setListId", "(Ljava/lang/String;)V", "getPreviewItemObj", "()Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "selectedItemFixId", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getSelectedItemFixId", "()Ljava/util/HashSet;", "checkAlbumVideoWidth", "", "item", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "getSelectSourceList", "Lcom/tencent/mm/protocal/protobuf/PreviewItemList;", "onCreate", "Companion", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<e>
{
  public static final c.a LZB;
  private final egz LZC;
  public String LZD;
  private final HashSet<String> LZE;
  
  static
  {
    AppMethodBeat.i(286176);
    LZB = new c.a((byte)0);
    AppMethodBeat.o(286176);
  }
  
  public c(egz paramegz)
  {
    AppMethodBeat.i(286168);
    this.LZC = paramegz;
    this.LZE = new HashSet();
    AppMethodBeat.o(286168);
  }
  
  public final g<d<e>> a(LifecycleScope paramLifecycleScope, com.tencent.mm.plugin.mvvmlist.a.c<e> paramc)
  {
    AppMethodBeat.i(286197);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    d locald = new d(paramc);
    q localq = new q();
    paramLifecycleScope = this.LZC.TZE;
    s.s(paramLifecycleScope, "previewItemObj.sourceList");
    paramc = ((Iterable)paramLifecycleScope).iterator();
    int k;
    for (;;)
    {
      if (paramc.hasNext())
      {
        paramLifecycleScope = (egy)paramc.next();
        if (s.p(paramLifecycleScope.LZD, this.LZD)) {
          if (paramLifecycleScope != null)
          {
            k = paramLifecycleScope.mew.size();
            if (k <= 0) {
              break;
            }
          }
        }
      }
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      egx localegx = (egx)paramLifecycleScope.mew.get(i);
      String str = localegx.id;
      if (str != null)
      {
        boolean bool = this.LZE.contains(paramLifecycleScope.LZD + '-' + str);
        ArrayList localArrayList = locald.pUj;
        s.s(localegx, "previewItem");
        Object localObject = paramLifecycleScope.LZD;
        paramc = (com.tencent.mm.plugin.mvvmlist.a.c<e>)localObject;
        if (localObject == null) {
          paramc = "";
        }
        paramc = new e(str, i, localegx, paramc);
        paramc.idG = bool;
        localObject = ah.aiuX;
        localArrayList.add(paramc);
      }
      if (j >= k)
      {
        localq.offer(locald);
        paramLifecycleScope = k.a((f)localq);
        AppMethodBeat.o(286197);
        return paramLifecycleScope;
        paramLifecycleScope = this.LZC.TZE;
        s.s(paramLifecycleScope, "previewItemObj.sourceList");
        paramLifecycleScope = (egy)p.oL((List)paramLifecycleScope);
        break;
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(286181);
    Object localObject = this.LZC.abmm;
    s.s(localObject, "previewItemObj.selectItemList");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      eww localeww = (eww)((Iterator)localObject).next();
      egx localegx = localeww.abyX;
      if (localegx != null) {
        this.LZE.add(localeww.LZD + '-' + localegx.id);
      }
    }
    AppMethodBeat.o(286181);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.c
 * JD-Core Version:    0.7.0.1
 */