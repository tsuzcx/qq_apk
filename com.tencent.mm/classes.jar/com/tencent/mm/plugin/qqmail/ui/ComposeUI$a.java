package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.p;
import java.net.URLDecoder;
import java.util.Map;

final class ComposeUI$a
  extends p
{
  private ComposeUI$a(ComposeUI paramComposeUI) {}
  
  @Deprecated
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    AppMethodBeat.i(68207);
    ab.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
    if (paramConsoleMessage != null) {}
    Object localObject4;
    Object localObject3;
    for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
    {
      localObject1 = u.amW((String)localObject1);
      if (!((String)localObject1).startsWith(ComposeUI.m(this.pLX))) {
        break label285;
      }
      this.pLX.hideVKB();
      try
      {
        localObject1 = URLDecoder.decode(((String)localObject1).substring(ComposeUI.m(this.pLX).length()), "utf-8").split("@@");
        localObject4 = localObject1[0].split(":");
        localObject3 = localObject4[0];
        localObject4 = localObject4[1];
        ab.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
        localObject1 = ((j)g.E(j.class)).bPQ().kB(Integer.valueOf((String)localObject3).intValue());
        localObject3 = new Intent(this.pLX, MailImageDownloadUI.class);
        ((Intent)localObject3).putExtra("img_msg_id", ((dd)localObject1).field_msgId);
        ((Intent)localObject3).putExtra("img_server_id", ((dd)localObject1).field_msgSvrId);
        ((Intent)localObject3).putExtra("img_download_compress_type", 0);
        ((Intent)localObject3).putExtra("img_download_username", ((dd)localObject1).field_talker);
        this.pLX.startActivity((Intent)localObject3);
        AppMethodBeat.o(68207);
        return true;
      }
      catch (Exception localException)
      {
        ab.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    label285:
    do
    {
      boolean bool = super.onConsoleMessage(paramConsoleMessage);
      AppMethodBeat.o(68207);
      return bool;
      if (localException.startsWith(ComposeUI.n(this.pLX))) {
        try
        {
          ComposeUI.a(this.pLX, URLDecoder.decode(localException.substring(ComposeUI.n(this.pLX).length()), "utf-8"));
          if (ComposeUI.o(this.pLX)) {
            if (ComposeUI.p(this.pLX).indexOf("<img") == -1)
            {
              ComposeUI.q(this.pLX).clear();
              ComposeUI.r(this.pLX);
              AppMethodBeat.o(68207);
              return true;
            }
          }
        }
        catch (Exception paramConsoleMessage)
        {
          for (;;)
          {
            ab.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
          }
          u.b(ComposeUI.s(this.pLX), ComposeUI.t(this.pLX), ComposeUI.u(this.pLX));
          AppMethodBeat.o(68207);
          return true;
        }
      }
    } while (!localException.startsWith(ComposeUI.t(this.pLX)));
    ComposeUI.q(this.pLX).clear();
    try
    {
      paramConsoleMessage = URLDecoder.decode(localException.substring(ComposeUI.t(this.pLX).length()), "utf-8");
      localObject3 = paramConsoleMessage.split("&&");
      int i = 0;
      while (i < localObject3.length)
      {
        paramConsoleMessage = localObject3[i].split("@@");
        localObject4 = paramConsoleMessage[0].split(":")[1];
        Object localObject2 = paramConsoleMessage[1];
        paramConsoleMessage = localObject2;
        if (localObject2.startsWith("file://")) {
          paramConsoleMessage = localObject2.replaceFirst("file://", "");
        }
        ab.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
        ComposeUI.q(this.pLX).put(localObject4, paramConsoleMessage);
        i += 1;
      }
      if (!ComposeUI.o(this.pLX)) {
        break label634;
      }
    }
    catch (Exception paramConsoleMessage)
    {
      ab.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
      AppMethodBeat.o(68207);
      return true;
    }
    ComposeUI.r(this.pLX);
    label634:
    AppMethodBeat.o(68207);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.a
 * JD-Core Version:    0.7.0.1
 */