package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ServiceNotifySettingsUI;

final class ServiceNotifyConversationUI$4
  implements MenuItem.OnMenuItemClickListener
{
  ServiceNotifyConversationUI$4(ServiceNotifyConversationUI paramServiceNotifyConversationUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(256495);
    Object localObject = new Intent(this.afst.getContext(), ServiceNotifySettingsUI.class);
    ((Intent)localObject).putExtra("mode", 0);
    ((Intent)localObject).putExtra("from_scene", "scene_service_notify_conversation");
    paramMenuItem = this.afst;
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramMenuItem, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMenuItem.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMenuItem, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$2", "onMenuItemClick", "(Landroid/view/MenuItem;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    h.OAn.b(21825, new Object[] { Integer.valueOf(2), null, Long.valueOf(Util.nowSecond()), null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    AppMethodBeat.o(256495);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.4
 * JD-Core Version:    0.7.0.1
 */