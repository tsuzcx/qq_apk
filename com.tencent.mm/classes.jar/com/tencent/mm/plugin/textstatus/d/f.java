package com.tencent.mm.plugin.textstatus.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import java.lang.ref.WeakReference;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "obj", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "ref", "Ljava/lang/ref/WeakReference;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"})
public final class f
  implements i
{
  private final WeakReference<i> nsR;
  
  public f(i parami)
  {
    AppMethodBeat.i(216158);
    this.nsR = new WeakReference(parami);
    AppMethodBeat.o(216158);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(216157);
    i locali = (i)this.nsR.get();
    if (locali != null)
    {
      locali.onSceneEnd(paramInt1, paramInt2, paramString, paramq);
      AppMethodBeat.o(216157);
      return;
    }
    AppMethodBeat.o(216157);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.d.f
 * JD-Core Version:    0.7.0.1
 */