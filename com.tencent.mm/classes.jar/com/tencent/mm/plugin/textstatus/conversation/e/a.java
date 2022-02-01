package com.tencent.mm.plugin.textstatus.conversation.e;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"doSceneAndObserveInUIThread", "", "Lcom/tencent/mm/modelbase/NetSceneQueue;", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "plugin-textstatus_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final void a(com.tencent.mm.am.s params, p paramp, q paramq, h paramh)
  {
    AppMethodBeat.i(290827);
    kotlin.g.b.s.u(params, "<this>");
    kotlin.g.b.s.u(paramp, "scene");
    if (paramq == null) {
      params.a(paramp.getType(), paramh);
    }
    for (;;)
    {
      params.a(paramp, 0);
      AppMethodBeat.o(290827);
      return;
      params.a(paramp.getType(), paramq, paramh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.e.a
 * JD-Core Version:    0.7.0.1
 */