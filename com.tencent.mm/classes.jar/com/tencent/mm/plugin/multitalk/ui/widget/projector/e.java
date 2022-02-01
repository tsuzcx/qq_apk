package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "", "supportFuncList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "featureSupportList", "type", "(Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;I)V", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "getMoreFuncList", "setMoreFuncList", "getSupportFuncList", "setSupportFuncList", "getType", "()I", "setType", "(I)V", "checkFeatureSupport", "", "func", "checkFuncSupport", "getMoreFuncSupportList", "Builder", "Companion", "MoreItem", "plugin-multitalk_release"})
public final class e
{
  public static final b zWh;
  private int type;
  private HashSet<Integer> zWe;
  HashSet<e.c> zWf;
  private HashSet<Integer> zWg;
  
  static
  {
    AppMethodBeat.i(239935);
    zWh = new b((byte)0);
    AppMethodBeat.o(239935);
  }
  
  public e(HashSet<Integer> paramHashSet1, HashSet<e.c> paramHashSet, HashSet<Integer> paramHashSet2, int paramInt)
  {
    AppMethodBeat.i(239934);
    this.zWe = paramHashSet1;
    this.zWf = paramHashSet;
    this.zWg = paramHashSet2;
    this.type = paramInt;
    AppMethodBeat.o(239934);
  }
  
  public final boolean Rx(int paramInt)
  {
    AppMethodBeat.i(239932);
    boolean bool = this.zWe.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(239932);
    return bool;
  }
  
  public final boolean Ry(int paramInt)
  {
    AppMethodBeat.i(239933);
    boolean bool = this.zWg.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(239933);
    return bool;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Companion;", "", "()V", "CLEAR_SCREEN", "", "COUNT_DOWN", "DOODLE", "FAV", "FLIP_SUPPORTED", "MORE", "RENDER_IGNORE_BG", "SAVE_TO_PICTURE", "SCALE_SUPPORTED", "SEND_TO_FRIEND", "TAG", "", "TEXT", "plugin-multitalk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e
 * JD-Core Version:    0.7.0.1
 */