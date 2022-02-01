package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.vlog.model.local.a;
import com.tencent.mm.videocomposition.c.e;
import com.tencent.mm.xeffect.effect.n;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VideoCompositionExportFrameRenderCallback;", "Lcom/tencent/mm/videocomposition/render/RenderProcessCallback;", "composition", "Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "labelMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "effect", "Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "(Lcom/tencent/mm/plugin/vlog/model/VLogComposition;Ljava/util/HashMap;Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;)V", "getComposition", "()Lcom/tencent/mm/plugin/vlog/model/VLogComposition;", "getEffect", "()Lcom/tencent/mm/xeffect/effect/ImageEnhanceEffect;", "getLabelMap", "()Ljava/util/HashMap;", "onFrameStart", "", "pts", "", "onRelease", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ai
  implements e
{
  private final ac TYA;
  private final HashMap<String, Integer> Ubb;
  private final n Ubc;
  
  public ai(ac paramac, HashMap<String, Integer> paramHashMap, n paramn)
  {
    AppMethodBeat.i(283634);
    this.TYA = paramac;
    this.Ubb = paramHashMap;
    this.Ubc = paramn;
    AppMethodBeat.o(283634);
  }
  
  public final void onRelease() {}
  
  public final void wx(long paramLong)
  {
    AppMethodBeat.i(283640);
    Object localObject = h.a(this.TYA, paramLong);
    Map localMap = (Map)this.Ubb;
    if (localObject == null)
    {
      localObject = null;
      localObject = (Integer)localMap.get(localObject);
      if (localObject != null) {
        break label106;
      }
    }
    label106:
    for (int i = -1;; i = ((Integer)localObject).intValue())
    {
      localObject = a.UbD;
      if (a.hRA().contains(Integer.valueOf(i)))
      {
        localObject = this.Ubc;
        if (localObject != null) {
          ((n)localObject).setScene(i);
        }
      }
      AppMethodBeat.o(283640);
      return;
      localObject = ((ad)localObject).path;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ai
 * JD-Core Version:    0.7.0.1
 */