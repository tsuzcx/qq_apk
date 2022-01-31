package com.tencent.mm.plugin.story.f;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.graphics.Matrix;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.chf;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$reshowStoryDataEditorItem$1$3$2", "com/tencent/mm/plugin/story/presenter/StoryDataProtoUtil$$special$$inlined$let$lambda$3"})
final class k$c
  implements Runnable
{
  k$c(bar parambar, Matrix paramMatrix, Context paramContext, ViewGroup paramViewGroup, chf paramchf) {}
  
  public final void run()
  {
    AppMethodBeat.i(109668);
    Object localObject = k.sCp;
    localObject = this.sCw.eSL;
    j.p(localObject, "it.cityName");
    String str = this.sCw.eSM;
    j.p(str, "it.poiName");
    k.a((String)localObject, str, this.sCr, this.faP, this.sCs);
    AppMethodBeat.o(109668);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.story.f.k.c
 * JD-Core Version:    0.7.0.1
 */