package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "", "supportFuncList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "featureSupportList", "type", "(Ljava/util/HashSet;Ljava/util/HashSet;Ljava/util/HashSet;I)V", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "getMoreFuncList", "setMoreFuncList", "getSupportFuncList", "setSupportFuncList", "getType", "()I", "setType", "(I)V", "checkFeatureSupport", "", "func", "checkFuncSupport", "getMoreFuncSupportList", "Builder", "Companion", "MoreItem", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final b LxN;
  private HashSet<Integer> LxO;
  HashSet<e.c> LxP;
  private HashSet<Integer> LxQ;
  private int type;
  
  static
  {
    AppMethodBeat.i(285696);
    LxN = new b((byte)0);
    AppMethodBeat.o(285696);
  }
  
  public e(HashSet<Integer> paramHashSet1, HashSet<e.c> paramHashSet, HashSet<Integer> paramHashSet2, int paramInt)
  {
    AppMethodBeat.i(285685);
    this.LxO = paramHashSet1;
    this.LxP = paramHashSet;
    this.LxQ = paramHashSet2;
    this.type = paramInt;
    AppMethodBeat.o(285685);
  }
  
  public final boolean abY(int paramInt)
  {
    AppMethodBeat.i(285703);
    boolean bool = this.LxO.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(285703);
    return bool;
  }
  
  public final boolean abZ(int paramInt)
  {
    AppMethodBeat.i(285710);
    boolean bool = this.LxQ.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(285710);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "", "()V", "featureSupportList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "getMoreFuncList", "setMoreFuncList", "supportFuncList", "getSupportFuncList", "setSupportFuncList", "type", "getType", "()I", "setType", "(I)V", "addFeatureSupport", "funcs", "", "addFunc", "addMoreFuncSupport", "", "([Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;)Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "build", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    HashSet<Integer> LxO;
    HashSet<e.c> LxP;
    private HashSet<Integer> LxQ;
    int type;
    
    public a()
    {
      AppMethodBeat.i(285963);
      this.LxO = new HashSet();
      this.LxP = new HashSet();
      this.LxQ = new HashSet();
      AppMethodBeat.o(285963);
    }
    
    public final a I(int... paramVarArgs)
    {
      AppMethodBeat.i(285967);
      s.u(paramVarArgs, "funcs");
      int i = 0;
      while (i < 2)
      {
        int j = paramVarArgs[i];
        i += 1;
        this.LxQ.add(Integer.valueOf(j));
      }
      AppMethodBeat.o(285967);
      return this;
    }
    
    public final e gid()
    {
      AppMethodBeat.i(285974);
      e locale = new e(this.LxO, this.LxP, this.LxQ, this.type);
      AppMethodBeat.o(285974);
      return locale;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Companion;", "", "()V", "CLEAR_SCREEN", "", "COUNT_DOWN", "DOODLE", "FAV", "FLIP_SUPPORTED", "MORE", "RENDER_IGNORE_BG", "SAVE_TO_PICTURE", "SCALE_SUPPORTED", "SEND_TO_FRIEND", "TAG", "", "TEXT", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e
 * JD-Core Version:    0.7.0.1
 */