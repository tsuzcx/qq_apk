package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.videocomposition.b.e;
import com.tencent.mm.xeffect.effect.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/vlog/model/VideoCompositionExportFrameRenderCallback;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "labelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;Ljava/util/HashMap;Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "getLabelMap", "()Ljava/util/HashMap;", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"})
public final class ai
  implements e
{
  private final ac GxA;
  private final HashMap<String, Integer> GzU;
  private final n GzV;
  
  public ai(ac paramac, HashMap<String, Integer> paramHashMap, n paramn)
  {
    AppMethodBeat.i(190725);
    this.GxA = paramac;
    this.GzU = paramHashMap;
    this.GzV = paramn;
    AppMethodBeat.o(190725);
  }
  
  public final void KM(long paramLong)
  {
    AppMethodBeat.i(190724);
    Object localObject = i.a(this.GxA, paramLong);
    Map localMap = (Map)this.GzU;
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
      localObject = a.GAD;
      if (!a.fBU().contains(Integer.valueOf(i))) {
        break label115;
      }
      localObject = this.GzV;
      if (localObject == null) {
        break label115;
      }
      ((n)localObject).setScene(i);
      AppMethodBeat.o(190724);
      return;
      localObject = null;
      break;
    }
    label115:
    AppMethodBeat.o(190724);
  }
  
  public final void onRelease() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ai
 * JD-Core Version:    0.7.0.1
 */