package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;

final class g$111
  implements Runnable
{
  g$111(g paramg, String paramString1, i parami, String paramString2, String paramString3) {}
  
  public final void run()
  {
    y.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
    int i = this.rAz.indexOf(";base64,");
    Object localObject = "";
    if (i != -1) {
      localObject = this.rAz.substring(i + 8, this.rAz.length());
    }
    try
    {
      localObject = Base64.decode((String)localObject, 0);
      if (bk.bE((byte[])localObject))
      {
        g.a(this.rzi, this.rzk, "addToEmoticon:fail", null);
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + localException.getMessage());
      g.a(this.rzi, this.rzk, "addToEmoticon:fail_" + localException.getMessage(), null);
      return;
    }
    String str1 = com.tencent.mm.a.g.o(localException);
    au.Hx();
    String str2 = EmojiLogic.J(c.FL(), "", str1);
    if ((!e.bK(str2)) || (!e.aeY(str2).equalsIgnoreCase(str1))) {
      e.b(str2, localException, localException.length);
    }
    g.a(this.rzi, str1, this.eoz, this.rAA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.111
 * JD-Core Version:    0.7.0.1
 */