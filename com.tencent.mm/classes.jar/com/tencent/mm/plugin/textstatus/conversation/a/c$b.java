package com.tencent.mm.plugin.textstatus.conversation.a;

import android.widget.AdapterView.AdapterContextMenuInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.br.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/conversation/adapter/TextStatusConversationLongClickListener$onMMMenuItemSelected$1$2", "Lcom/tencent/mm/model/MsgInfoStorageLogic$IDeleteMsg;", "finishCallback", "", "isCancel", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c$b
  implements br.a
{
  c$b(boolean paramBoolean, AdapterView.AdapterContextMenuInfo paramAdapterContextMenuInfo) {}
  
  public final boolean aMJ()
  {
    return false;
  }
  
  public final void aMK()
  {
    AppMethodBeat.i(290897);
    Log.i("MicroMsg.TextStatus.TextStatusConversationLongClickListener", "longclick delete msg finish");
    Log.i("MicroMsg.TextStatus.TextStatusConversationLongClickListener", "[CONTEXT_MENU_LONG_CLICK_DELETE] ret" + this.AFR + " position=" + this.AFS.position);
    AppMethodBeat.o(290897);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.a.c.b
 * JD-Core Version:    0.7.0.1
 */