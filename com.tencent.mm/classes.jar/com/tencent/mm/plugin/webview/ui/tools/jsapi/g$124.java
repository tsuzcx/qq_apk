package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

final class g$124
  implements Runnable
{
  g$124(g paramg, String paramString1, i parami, String paramString2) {}
  
  public final void run()
  {
    AppMethodBeat.i(155038);
    ab.i("MicroMsg.MsgHandler", "doShareEmoticon use base64DataString");
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
        this.vqm.a(this.uZa, "shareEmoticon:fail", null);
        AppMethodBeat.o(155038);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.MsgHandler", "doShareEmoticon error:" + localException.getMessage());
      this.vqm.a(this.uZa, "shareEmoticon:fail_" + localException.getMessage(), null);
      AppMethodBeat.o(155038);
      return;
    }
    String str1 = com.tencent.mm.a.g.w(localException);
    if (bo.isNullOrNil(str1))
    {
      this.vqm.a(this.uZa, "shareEmoticon:fail empty buffer", null);
      AppMethodBeat.o(155038);
      return;
    }
    String str2 = EmojiLogic.M(b.YP(), "", str1);
    if ((!e.cN(str2)) || (!e.avP(str2).equalsIgnoreCase(str1))) {
      e.b(str2, localException, localException.length);
    }
    g.a(this.vqm, str1, this.vrD);
    AppMethodBeat.o(155038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.124
 * JD-Core Version:    0.7.0.1
 */