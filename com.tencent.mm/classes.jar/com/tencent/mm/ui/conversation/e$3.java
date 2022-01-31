package com.tencent.mm.ui.conversation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

final class e$3
  implements Runnable
{
  e$3(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(34187);
    Object localObject = ((a)g.E(a.class)).b(0L, this.fOX);
    if ((localObject == null) || (((p)localObject).fjy.size() == 0))
    {
      AppMethodBeat.o(34187);
      return;
    }
    localObject = (q)((p)localObject).fjy.getFirst();
    if (!TextUtils.isEmpty(((q)localObject).url))
    {
      ((b)g.E(b.class)).a(((q)localObject).url, ((q)localObject).type, 92, new Object[0]);
      ab.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((q)localObject).title });
    }
    AppMethodBeat.o(34187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e.3
 * JD-Core Version:    0.7.0.1
 */