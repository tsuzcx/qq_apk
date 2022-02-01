package com.tencent.mm.plugin.textstatus.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/logic/WeakOnSceneEnd;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "obj", "(Lcom/tencent/mm/modelbase/IOnSceneEnd;)V", "ref", "Ljava/lang/ref/WeakReference;", "onSceneEnd", "", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  implements h
{
  private final WeakReference<h> tzB;
  
  public g(h paramh)
  {
    AppMethodBeat.i(289726);
    this.tzB = new WeakReference(paramh);
    AppMethodBeat.o(289726);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(289730);
    h localh = (h)this.tzB.get();
    if (localh != null) {
      localh.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    }
    AppMethodBeat.o(289730);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.f.g
 * JD-Core Version:    0.7.0.1
 */