package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class g$121
  implements Runnable
{
  g$121(g paramg, String paramString1, i parami, String paramString2, String paramString3) {}
  
  public final void run()
  {
    AppMethodBeat.i(9198);
    ab.i("MicroMsg.MsgHandler", "doAddToEmoticon use base64DataString");
    int i = this.vrC.indexOf(";base64,");
    Object localObject = "";
    if (i != -1) {
      localObject = this.vrC.substring(i + 8, this.vrC.length());
    }
    try
    {
      localObject = Base64.decode((String)localObject, 0);
      if (bo.ce((byte[])localObject))
      {
        this.vqm.a(this.uZa, "addToEmoticon:fail", null);
        AppMethodBeat.o(9198);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MsgHandler", "doAddToEmoticon error:" + localException.getMessage());
      this.vqm.a(this.uZa, "addToEmoticon:fail_" + localException.getMessage(), null);
      AppMethodBeat.o(9198);
      return;
    }
    String str1 = com.tencent.mm.a.g.w(localException);
    String str2 = EmojiLogic.M(b.YP(), "", str1);
    if ((!e.cN(str2)) || (!e.avP(str2).equalsIgnoreCase(str1))) {
      e.b(str2, localException, localException.length);
    }
    g.a(this.vqm, str1, this.fEW, this.vrD);
    AppMethodBeat.o(9198);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.121
 * JD-Core Version:    0.7.0.1
 */