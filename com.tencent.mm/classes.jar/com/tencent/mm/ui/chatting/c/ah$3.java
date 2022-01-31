package com.tencent.mm.ui.chatting.c;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.model.aw;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.c.b.o;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.v;

final class ah$3
  implements DialogInterface.OnClickListener
{
  ah$3(ah paramah, boolean paramBoolean, o paramo, String paramString1, String paramString2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(31665);
    if ((this.zHQ) && (this.zHN.dIg() != null) && (this.zHN.dIg().getCallback() != null) && ((this.zHN.dIg().getCallback() instanceof v)))
    {
      if (this.zHR.contains("com.sohu.inputmethod.sogou")) {
        h.qsU.cT(1062, 3);
      }
      for (;;)
      {
        paramDialogInterface = new BitmapFactory.Options();
        paramDialogInterface.inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.d.decodeFile(this.zHS, paramDialogInterface) == null) || (paramDialogInterface.outHeight <= b.MV())) && (paramDialogInterface.outWidth <= b.MV())) {
          break;
        }
        Toast.makeText(this.zHO.caz.zJz.getContext(), 2131299130, 0).show();
        AppMethodBeat.o(31665);
        return;
        if (this.zHR.contains("com.tencent.qqpinyin")) {
          h.qsU.cT(1062, 4);
        }
      }
      paramDialogInterface = new WXMediaMessage(new WXEmojiObject(this.zHS));
      paramDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.zHO.caz.zJz.getContext(), paramDialogInterface, null);
      if (paramDialogInterface != null) {
        ((v)this.zHN.dIg().getCallback()).C(((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(paramDialogInterface));
      }
      AppMethodBeat.o(31665);
      return;
    }
    paramDialogInterface = new l(5, this.zHO.caz.dJD(), this.zHO.caz.getTalkerUserName(), this.zHS, 0, null, 0, "", "", true, 2130838228);
    aw.Rc().a(paramDialogInterface, 0);
    AppMethodBeat.o(31665);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ah.3
 * JD-Core Version:    0.7.0.1
 */