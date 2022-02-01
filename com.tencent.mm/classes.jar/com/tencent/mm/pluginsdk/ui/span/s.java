package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.r;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.u;

public final class s
{
  public static void i(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(31947);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      h.CyF.a(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.cBv().alh("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      Log.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (com.tencent.mm.vfs.s.YS(paramBundle.path)) {
        r.b(paramContext, paramBundle.path, null, false);
      }
      AppMethodBeat.o(31947);
      return;
    }
    u.makeText(paramContext, paramContext.getString(2131757481), 2000).show();
    paramBundle = new g.a();
    paramBundle.alj("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
    paramBundle.all(paramContext.getString(2131757487));
    paramBundle.Fl(1);
    paramBundle.kS(true);
    f.cBv().a(paramBundle.qIY);
    AppMethodBeat.o(31947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.s
 * JD-Core Version:    0.7.0.1
 */