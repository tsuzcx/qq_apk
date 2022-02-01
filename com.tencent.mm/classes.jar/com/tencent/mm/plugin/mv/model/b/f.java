package com.tencent.mm.plugin.mv.model.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mvvmlist.a.a;
import com.tencent.mm.plugin.mvvmlist.a.c;
import com.tencent.mm.plugin.mvvmlist.a.c<Lcom.tencent.mm.plugin.mv.model.b.e;>;
import com.tencent.mm.plugin.mvvmlist.a.d;
import com.tencent.mm.protocal.protobuf.egx;
import com.tencent.mm.protocal.protobuf.egz;
import com.tencent.mm.protocal.protobuf.eww;
import com.tencent.mm.sdk.coroutines.LifecycleScope;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.b.g;
import kotlinx.coroutines.b.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewSelectedDataSource;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/BaseDataSource;", "Lcom/tencent/mm/plugin/mv/model/preview/MvPreviewLiveItem;", "previewItemObj", "Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "(Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;)V", "getPreviewItemObj", "()Lcom/tencent/mm/protocal/protobuf/PreviewItemObj;", "getData", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataResponse;", "scope", "Lcom/tencent/mm/sdk/coroutines/LifecycleScope;", "request", "Lcom/tencent/mm/plugin/mvvmlist/datasource/DataRequest;", "plugin-mv_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends a<e>
{
  private final egz LZC;
  
  public f(egz paramegz)
  {
    AppMethodBeat.i(286183);
    this.LZC = paramegz;
    AppMethodBeat.o(286183);
  }
  
  public final g<d<e>> a(LifecycleScope paramLifecycleScope, c<e> paramc)
  {
    AppMethodBeat.i(286196);
    s.u(paramLifecycleScope, "scope");
    s.u(paramc, "request");
    d locald = new d(paramc);
    q localq = new q();
    int k = this.LZC.abmm.size();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      Object localObject = (eww)this.LZC.abmm.get(i);
      egx localegx = ((eww)localObject).abyX;
      if (localegx != null) {
        if ((!s.p(this.LZC.abmn, ((eww)localObject).LZD)) || (!s.p(this.LZC.abmo, localegx.id))) {
          break label233;
        }
      }
      label233:
      for (boolean bool = true;; bool = false)
      {
        ArrayList localArrayList = locald.pUj;
        paramc = localegx.id;
        paramLifecycleScope = paramc;
        if (paramc == null) {
          paramLifecycleScope = "";
        }
        localObject = ((eww)localObject).LZD;
        paramc = (c<e>)localObject;
        if (localObject == null) {
          paramc = "";
        }
        paramLifecycleScope = new e(paramLifecycleScope, 0, localegx, paramc);
        paramLifecycleScope.idG = true;
        paramLifecycleScope.LZH = bool;
        paramc = ah.aiuX;
        localArrayList.add(paramLifecycleScope);
        if (j < k) {
          break;
        }
        localq.offer(locald);
        paramLifecycleScope = k.a((kotlinx.coroutines.a.f)localq);
        AppMethodBeat.o(286196);
        return paramLifecycleScope;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.model.b.f
 * JD-Core Version:    0.7.0.1
 */