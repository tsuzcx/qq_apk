package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.c.b;
import com.tencent.mm.chatroom.plugin.PluginChatroomUI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.chatting.d.a;
import java.util.Iterator;
import java.util.List;

final class e$17
  implements Runnable
{
  e$17(e parame, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(210134);
    Object localObject = ((k)g.ab(k.class)).awG().faM();
    ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration conversation size:%s", new Object[] { Integer.valueOf(((List)localObject).size()) });
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if ((!w.wq(str)) && (!bs.lr(this.HSR, str)))
      {
        x localx = ((c)g.ab(c.class)).awK().xN(str);
        if ((localx != null) && (localx.eZS()))
        {
          ac.i("MicroMsg.ChattingUI.ChatroomComponent", "checkConversationsForMigration %s", new Object[] { str });
          ((PluginChatroomUI)g.ad(PluginChatroomUI.class)).getOpenImMigrateService().ab(this.HSO.cLy.getTalkerUserName(), localx.field_associateOpenIMRoomName);
        }
      }
    }
    AppMethodBeat.o(210134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.e.17
 * JD-Core Version:    0.7.0.1
 */