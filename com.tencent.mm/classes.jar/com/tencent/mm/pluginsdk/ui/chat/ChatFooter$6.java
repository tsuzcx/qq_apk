package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;

final class ChatFooter$6
  implements ActionMode.Callback
{
  ChatFooter$6(ChatFooter paramChatFooter, Context paramContext) {}
  
  public final boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return false;
  }
  
  public final boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    AppMethodBeat.i(185756);
    paramActionMode = com.tencent.mm.pluginsdk.g.a.eLv();
    h.wUl.n(1014L, 5L, 1L);
    com.tencent.mm.plugin.c.a.aRW();
    if (com.tencent.mm.plugin.c.a.z(paramActionMode))
    {
      ac.i("MicroMsg.ChatFooter", "anti paste text %s", new Object[] { paramActionMode });
      h.wUl.n(1014L, 6L, 1L);
      if (paramMenu.size() > 0)
      {
        paramMenu.removeItem(16908322);
        if (d.kZ(23)) {
          paramMenu.removeItem(16908340);
        }
      }
    }
    AppMethodBeat.o(185756);
    return true;
  }
  
  public final void onDestroyActionMode(ActionMode paramActionMode) {}
  
  public final boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.ChatFooter.6
 * JD-Core Version:    0.7.0.1
 */