package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;

@Deprecated
public final class w
{
  public static void k(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(31947);
    if (paramBundle != null) {}
    for (int i = paramBundle.getInt("fromScene");; i = 0)
    {
      h.OAn.b(11621, new Object[] { Integer.valueOf(i), Integer.valueOf(0) });
      paramBundle = f.duv().amP("http://dianhua.qq.com/cgi-bin/cloudgrptemplate?t=dianhuaben_download&channel=100008");
      if ((paramBundle == null) || (paramBundle.status != 3)) {
        break;
      }
      Log.i("MicroMsg.WxPhoneBookHelper", "weixin phonebook already download successfully, install directly");
      if (y.ZC(paramBundle.path)) {
        v.b(paramContext, paramBundle.path, null, false);
      }
      AppMethodBeat.o(31947);
      return;
    }
    AppMethodBeat.o(31947);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.span.w
 * JD-Core Version:    0.7.0.1
 */