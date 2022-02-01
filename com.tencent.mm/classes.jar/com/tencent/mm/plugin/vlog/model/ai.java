package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.xeffect.effect.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VideoCompositionExportFrameRenderCallback;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "labelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;Ljava/util/HashMap;Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "getLabelMap", "()Ljava/util/HashMap;", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
public final class ai
  implements e
{
  private final ac Nlb;
  private final HashMap<String, Integer> NnA;
  private final n NnB;
  
  public ai(ac paramac, HashMap<String, Integer> paramHashMap, n paramn)
  {
    AppMethodBeat.i(227520);
    this.Nlb = paramac;
    this.NnA = paramHashMap;
    this.NnB = paramn;
    AppMethodBeat.o(227520);
  }
  
  public final void Sj(long paramLong)
  {
    AppMethodBeat.i(227517);
    Object localObject = i.a(this.Nlb, paramLong);
    Map localMap = (Map)this.NnA;
    if (localObject != null)
    {
      localObject = ((ad)localObject).path;
      localObject = (Integer)localMap.get(localObject);
      if (localObject == null) {
        break label110;
      }
    }
    label110:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      localObject = a.Nol;
      if (!a.gtS().contains(Integer.valueOf(i))) {
        break label115;
      }
      localObject = this.NnB;
      if (localObject == null) {
        break label115;
      }
      ((n)localObject).setScene(i);
      AppMethodBeat.o(227517);
      return;
      localObject = null;
      break;
    }
    label115:
    AppMethodBeat.o(227517);
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ai
 * JD-Core Version:    0.7.0.1
 */