package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "", "supportFuncList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "featureSupportList", "type", "(Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;I)V", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "getMoreFuncList", "setMoreFuncList", "getSupportFuncList", "setSupportFuncList", "getType", "()I", "setType", "(I)V", "checkFeatureSupport", "", "func", "checkFuncSupport", "getMoreFuncSupportList", "Builder", "Companion", "MoreItem", "plugin-multitalk_release"})
public final class e
{
  public static final b FBQ;
  private HashSet<Integer> FBN;
  HashSet<e.c> FBO;
  private HashSet<Integer> FBP;
  private int type;
  
  static
  {
    AppMethodBeat.i(197141);
    FBQ = new b((byte)0);
    AppMethodBeat.o(197141);
  }
  
  public e(HashSet<Integer> paramHashSet1, HashSet<e.c> paramHashSet, HashSet<Integer> paramHashSet2, int paramInt)
  {
    AppMethodBeat.i(197139);
    this.FBN = paramHashSet1;
    this.FBO = paramHashSet;
    this.FBP = paramHashSet2;
    this.type = paramInt;
    AppMethodBeat.o(197139);
  }
  
  public final boolean XO(int paramInt)
  {
    AppMethodBeat.i(197134);
    boolean bool = this.FBN.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(197134);
    return bool;
  }
  
  public final boolean XP(int paramInt)
  {
    AppMethodBeat.i(197136);
    boolean bool = this.FBP.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(197136);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "", "()V", "featureSupportList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "getMoreFuncList", "setMoreFuncList", "supportFuncList", "getSupportFuncList", "setSupportFuncList", "type", "getType", "()I", "setType", "(I)V", "addFeatureSupport", "funcs", "", "addFunc", "addMoreFuncSupport", "", "([Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;)Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "build", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "plugin-multitalk_release"})
  public static final class a
  {
    HashSet<Integer> FBN;
    HashSet<e.c> FBO;
    private HashSet<Integer> FBP;
    int type;
    
    public a()
    {
      AppMethodBeat.i(207364);
      this.FBN = new HashSet();
      this.FBO = new HashSet();
      this.FBP = new HashSet();
      AppMethodBeat.o(207364);
    }
    
    public final a E(int... paramVarArgs)
    {
      AppMethodBeat.i(207360);
      p.k(paramVarArgs, "funcs");
      int i = 0;
      while (i < 2)
      {
        int j = paramVarArgs[i];
        this.FBP.add(Integer.valueOf(j));
        i += 1;
      }
      AppMethodBeat.o(207360);
      return this;
    }
    
    public final e eZe()
    {
      AppMethodBeat.i(207362);
      e locale = new e(this.FBN, this.FBO, this.FBP, this.type);
      AppMethodBeat.o(207362);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Companion;", "", "()V", "CLEAR_SCREEN", "", "COUNT_DOWN", "DOODLE", "FAV", "FLIP_SUPPORTED", "MORE", "RENDER_IGNORE_BG", "SAVE_TO_PICTURE", "SCALE_SUPPORTED", "SEND_TO_FRIEND", "TAG", "", "TEXT", "plugin-multitalk_release"})
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e
 * JD-Core Version:    0.7.0.1
 */