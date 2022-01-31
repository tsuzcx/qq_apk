package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.BitmapFactory.Options;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.as.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.chatting.b.b.n;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.w;

final class ag$3
  implements DialogInterface.OnClickListener
{
  ag$3(ag paramag, boolean paramBoolean, n paramn, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((this.vsk) && (this.vsh.cEq() != null) && (this.vsh.cEq().getCallback() != null) && ((this.vsh.cEq().getCallback() instanceof w)))
    {
      paramDialogInterface = new BitmapFactory.Options();
      paramDialogInterface.inJustDecodeBounds = true;
      if (((c.decodeFile(this.vsl, paramDialogInterface) != null) && (paramDialogInterface.outHeight > b.Ag())) || (paramDialogInterface.outWidth > b.Ag())) {
        Toast.makeText(this.vsi.byx.vtz.getContext(), R.l.emoji_custom_gif_max_size_limit_cannot_send, 0).show();
      }
      do
      {
        return;
        paramDialogInterface = new WXMediaMessage(new WXEmojiObject(this.vsl));
        paramDialogInterface = ((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(this.vsi.byx.vtz.getContext(), paramDialogInterface, null);
      } while (paramDialogInterface == null);
      ((w)this.vsh.cEq().getCallback()).n(((com.tencent.mm.plugin.emoji.b.d)g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(paramDialogInterface));
      return;
    }
    paramDialogInterface = new l(5, this.vsi.byx.cFB(), this.vsi.byx.getTalkerUserName(), this.vsl, 0, null, 0, "", "", true, R.g.chat_img_template);
    au.Dk().a(paramDialogInterface, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.ag.3
 * JD-Core Version:    0.7.0.1
 */