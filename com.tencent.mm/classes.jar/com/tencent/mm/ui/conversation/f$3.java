package com.tencent.mm.ui.conversation;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

final class f$3
  implements Runnable
{
  f$3(f paramf, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(38302);
    Object localObject = ((a)h.ae(a.class)).b(0L, this.val$content);
    if ((localObject == null) || (((u)localObject).lpz.size() == 0))
    {
      AppMethodBeat.o(38302);
      return;
    }
    localObject = (v)((u)localObject).lpz.getFirst();
    if (!TextUtils.isEmpty(((v)localObject).url))
    {
      ((c)h.ae(c.class)).a(((v)localObject).url, ((v)localObject).type, 92, new Object[0]);
      Log.v("MicroMsg.ConversationAdapter", "terry trace preload:%s", new Object[] { ((v)localObject).title });
    }
    AppMethodBeat.o(38302);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.f.3
 * JD-Core Version:    0.7.0.1
 */