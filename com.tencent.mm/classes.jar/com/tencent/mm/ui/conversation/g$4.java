package com.tencent.mm.ui.conversation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class g$4
  implements Runnable
{
  g$4(g paramg, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(256745);
    Object localObject = ((a)h.ax(a.class)).c(0L, this.val$content);
    if ((localObject == null) || (((u)localObject).nUC.size() == 0))
    {
      AppMethodBeat.o(256745);
      return;
    }
    localObject = (v)((u)localObject).nUC.getFirst();
    if (!TextUtils.isEmpty(((v)localObject).url))
    {
      ((c)h.ax(c.class)).a(((v)localObject).url, ((v)localObject).type, 92, new Object[0]);
      Log.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((v)localObject).title });
    }
    AppMethodBeat.o(256745);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.g.4
 * JD-Core Version:    0.7.0.1
 */