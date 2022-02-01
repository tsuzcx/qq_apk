package com.tencent.mm.ui.conversation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class e$3
  implements Runnable
{
  e$3(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38302);
    Object localObject = ((a)g.af(a.class)).a(0L, this.val$content);
    if ((localObject == null) || (((u)localObject).iAd.size() == 0))
    {
      AppMethodBeat.o(38302);
      return;
    }
    localObject = (v)((u)localObject).iAd.getFirst();
    if (!TextUtils.isEmpty(((v)localObject).url))
    {
      ((b)g.af(b.class)).a(((v)localObject).url, ((v)localObject).type, 92, new Object[0]);
      Log.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((v)localObject).title });
    }
    AppMethodBeat.o(38302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.e.3
 * JD-Core Version:    0.7.0.1
 */