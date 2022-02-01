package com.tencent.mm.ui.chatting.m;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.component.aj;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/utils/SportReportComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/IChattingComponent;", "()V", "onChattingPause", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends com.tencent.mm.ui.chatting.component.a
  implements aj
{
  public final void jjj()
  {
    AppMethodBeat.i(253886);
    super.jjj();
    Object localObject = k.aeZF;
    localObject = this.hlc.aezO.getContext();
    s.s(localObject, "mChattingContext.context");
    localObject = (c)k.nq((Context)localObject).q(c.class);
    Log.i("SimpleUIComponent", s.X("clearSer: ", Integer.valueOf(((c)localObject).jxe().size())));
    ((c)localObject).jxe().clear();
    AppMethodBeat.o(253886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.m.b
 * JD-Core Version:    0.7.0.1
 */