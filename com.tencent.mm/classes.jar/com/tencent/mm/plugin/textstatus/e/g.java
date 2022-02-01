package com.tencent.mm.plugin.textstatus.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "obj", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "ref", "Ljava/lang/ref/WeakReference;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
public final class g
  implements i
{
  private final WeakReference<i> quK;
  
  public g(i parami)
  {
    AppMethodBeat.i(238747);
    this.quK = new WeakReference(parami);
    AppMethodBeat.o(238747);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(238745);
    i locali = (i)this.quK.get();
    if (locali != null)
    {
      locali.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(238745);
      return;
    }
    AppMethodBeat.o(238745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.e.g
 * JD-Core Version:    0.7.0.1
 */