package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.an.a;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public final class at
  extends a
{
  private static String bM(Intent paramIntent)
  {
    AppMethodBeat.i(79039);
    try
    {
      paramIntent = URLDecoder.decode(IntentUtil.getStringExtra(paramIntent, "ext_info"), "utf-8");
      AppMethodBeat.o(79039);
      return paramIntent;
    }
    catch (UnsupportedEncodingException paramIntent)
    {
      AppMethodBeat.o(79039);
    }
    return "";
  }
  
  public final void C(Context paramContext, Intent paramIntent)
  {
    AppMethodBeat.i(79038);
    paramIntent.putExtra("type", 4);
    paramIntent.putExtra("id", "");
    paramIntent = bM(paramIntent);
    if (Util.isNullOrNil(paramIntent))
    {
      AppMethodBeat.o(79038);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramIntent);
    localIntent.putExtra("from_shortcut", true);
    localIntent.addFlags(268435456);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(79038);
  }
  
  public final int getType()
  {
    return 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.at
 * JD-Core Version:    0.7.0.1
 */