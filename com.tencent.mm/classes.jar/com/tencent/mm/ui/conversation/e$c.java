package com.tencent.mm.ui.conversation;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

final class e$c
  implements n.b
{
  public final void a(int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(34188);
    if ((paramObject == null) || (!(paramObject instanceof String)))
    {
      ab.d("MicroMsg.ConversationAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramn, paramObject });
      AppMethodBeat.o(34188);
      return;
    }
    paramn = (String)paramObject;
    if (e.a(this.AhR))
    {
      AppMethodBeat.o(34188);
      return;
    }
    if ((paramn != null) && (!paramn.equals("")) && (e.b(this.AhR) != null) && (e.b(this.AhR).containsKey(Integer.valueOf(paramInt))))
    {
      e.b(this.AhR).remove(Integer.valueOf(paramInt));
      e.c(this.AhR);
    }
    AppMethodBeat.o(34188);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e.c
 * JD-Core Version:    0.7.0.1
 */