package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.webkit.ConsoleMessage;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.y;
import java.net.URLDecoder;
import java.util.Map;

final class ComposeUI$a
  extends com.tencent.xweb.j
{
  private ComposeUI$a(ComposeUI paramComposeUI) {}
  
  @Deprecated
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    y.i("MicroMsg.ComposeUI", "console, consoleMessage: %s", new Object[] { paramConsoleMessage });
    if (paramConsoleMessage != null) {}
    Object localObject4;
    Object localObject3;
    for (Object localObject1 = paramConsoleMessage.message();; localObject1 = null)
    {
      localObject1 = s.Xd((String)localObject1);
      if (!((String)localObject1).startsWith(ComposeUI.m(this.ngJ))) {
        break label253;
      }
      this.ngJ.XM();
      try
      {
        localObject1 = URLDecoder.decode(((String)localObject1).substring(ComposeUI.m(this.ngJ).length()), "utf-8").split("@@");
        localObject4 = localObject1[0].split(":");
        localObject3 = localObject4[0];
        localObject4 = localObject4[1];
        y.i("MicroMsg.ComposeUI", "img onclick, src: %s, msgLocalId: %s, msgSvrId: %s", new Object[] { localObject1[1], localObject3, localObject4 });
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bhO().fd(Integer.valueOf((String)localObject3).intValue());
        localObject3 = new Intent(this.ngJ, MailImageDownloadUI.class);
        ((Intent)localObject3).putExtra("img_msg_id", ((cs)localObject1).field_msgId);
        ((Intent)localObject3).putExtra("img_server_id", ((cs)localObject1).field_msgSvrId);
        ((Intent)localObject3).putExtra("img_download_compress_type", 0);
        ((Intent)localObject3).putExtra("img_download_username", ((cs)localObject1).field_talker);
        this.ngJ.startActivity((Intent)localObject3);
        return true;
      }
      catch (Exception localException)
      {
        y.w("MicroMsg.ComposeUI", "consoleMessage IMG_ONCLICK, ex = %s", new Object[] { localException.getMessage() });
      }
    }
    label253:
    do
    {
      return super.onConsoleMessage(paramConsoleMessage);
      if (localException.startsWith(ComposeUI.n(this.ngJ)))
      {
        try
        {
          ComposeUI.a(this.ngJ, URLDecoder.decode(localException.substring(ComposeUI.n(this.ngJ).length()), "utf-8"));
          if (ComposeUI.o(this.ngJ)) {
            if (ComposeUI.p(this.ngJ).indexOf("<img") == -1)
            {
              ComposeUI.q(this.ngJ).clear();
              ComposeUI.r(this.ngJ);
              return true;
            }
          }
        }
        catch (Exception paramConsoleMessage)
        {
          for (;;)
          {
            y.w("MicroMsg.ComposeUI", "consoleMessage GET_MAIL_CONTENT, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
          }
          s.c(ComposeUI.s(this.ngJ), ComposeUI.t(this.ngJ), ComposeUI.u(this.ngJ));
        }
        return true;
      }
    } while (!localException.startsWith(ComposeUI.t(this.ngJ)));
    ComposeUI.q(this.ngJ).clear();
    try
    {
      paramConsoleMessage = URLDecoder.decode(localException.substring(ComposeUI.t(this.ngJ).length()), "utf-8");
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
        y.i("MicroMsg.ComposeUI", "put msgImgInfoMap, msgSvrId: %s, path: %s", new Object[] { localObject4, paramConsoleMessage });
        ComposeUI.q(this.ngJ).put(localObject4, paramConsoleMessage);
        i += 1;
      }
      if (!ComposeUI.o(this.ngJ)) {
        break label579;
      }
    }
    catch (Exception paramConsoleMessage)
    {
      y.w("MicroMsg.ComposeUI", "consoleMessage GET_IMG_INFO, ex = %s", new Object[] { paramConsoleMessage.getMessage() });
      return true;
    }
    ComposeUI.r(this.ngJ);
    label579:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ComposeUI.a
 * JD-Core Version:    0.7.0.1
 */