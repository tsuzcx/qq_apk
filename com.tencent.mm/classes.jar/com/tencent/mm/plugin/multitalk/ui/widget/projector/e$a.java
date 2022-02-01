package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "", "()V", "featureSupportList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getFeatureSupportList", "()Ljava/util/HashSet;", "setFeatureSupportList", "(Ljava/util/HashSet;)V", "moreFuncList", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;", "getMoreFuncList", "setMoreFuncList", "supportFuncList", "getSupportFuncList", "setSupportFuncList", "type", "getType", "()I", "setType", "(I)V", "addFeatureSupport", "funcs", "", "addFunc", "addMoreFuncSupport", "", "([Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$MoreItem;)Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig$Builder;", "build", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "plugin-multitalk_release"})
public final class e$a
{
  int type;
  private HashSet<Integer> zWe;
  private HashSet<e.c> zWf;
  private HashSet<Integer> zWg;
  
  public e$a()
  {
    AppMethodBeat.i(239927);
    this.zWe = new HashSet();
    this.zWf = new HashSet();
    this.zWg = new HashSet();
    AppMethodBeat.o(239927);
  }
  
  public final a E(int... paramVarArgs)
  {
    AppMethodBeat.i(239923);
    p.h(paramVarArgs, "funcs");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      int k = paramVarArgs[i];
      this.zWe.add(Integer.valueOf(k));
      i += 1;
    }
    AppMethodBeat.o(239923);
    return this;
  }
  
  public final a F(int... paramVarArgs)
  {
    AppMethodBeat.i(239925);
    p.h(paramVarArgs, "funcs");
    int i = 0;
    while (i < 2)
    {
      int j = paramVarArgs[i];
      this.zWg.add(Integer.valueOf(j));
      i += 1;
    }
    AppMethodBeat.o(239925);
    return this;
  }
  
  public final a a(e.c... paramVarArgs)
  {
    AppMethodBeat.i(239924);
    p.h(paramVarArgs, "funcs");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      e.c localc = paramVarArgs[i];
      this.zWf.add(localc);
      i += 1;
    }
    AppMethodBeat.o(239924);
    return this;
  }
  
  public final e epo()
  {
    AppMethodBeat.i(239926);
    e locale = new e(this.zWe, this.zWf, this.zWg, this.type);
    AppMethodBeat.o(239926);
    return locale;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.e.a
 * JD-Core Version:    0.7.0.1
 */