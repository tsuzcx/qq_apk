package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.luggage.d.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.f;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.luggage.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import java.net.URI;
import java.net.URISyntaxException;
import org.json.JSONObject;

public final class b
  extends a
{
  public b()
  {
    super(29);
  }
  
  private static String aYz(String paramString)
  {
    AppMethodBeat.i(78682);
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getQuery();
    if (Util.isNullOrNil(str1)) {
      str1 = "ssid=25";
    }
    try
    {
      for (;;)
      {
        str1 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), str1, localUri.getFragment()).toString();
        Log.d("MicroMsg.MenuDelegate_AddShortcut", "rawUrl : %s, newUrl : %s", new Object[] { paramString, str1 });
        AppMethodBeat.o(78682);
        return str1;
        if (str1.contains("ssid=")) {
          str1 = str1.replaceFirst("ssid=[0-9]*", "ssid=25");
        } else {
          str1 = str1 + "&ssid=25";
        }
      }
    }
    catch (URISyntaxException localURISyntaxException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.MenuDelegate_AddShortcut", localURISyntaxException, "", new Object[0]);
        String str2 = paramString;
      }
    }
  }
  
  public final void a(final Context paramContext, final g paramg)
  {
    AppMethodBeat.i(78681);
    Bundle localBundle = new Bundle();
    y localy = paramg.ITH;
    String str2;
    if (Util.isNullOrNil(localy.iconUrl))
    {
      str2 = paramg.ITw.getIcon();
      if (Util.isNullOrNil(str2))
      {
        AppMethodBeat.o(78681);
        return;
      }
      int i = str2.lastIndexOf("/");
      if (i == -1) {
        break label279;
      }
      str1 = str2.substring(0, i);
    }
    label264:
    label279:
    for (String str1 = str1 + "/0";; str1 = str2)
    {
      Log.i("MicroMsg.MenuDelegate_AddShortcut", "rawIconUrl : %s, newIconUrl : %s", new Object[] { str2, str1 });
      localBundle.putString("icon_url", str1);
      if (Util.isNullOrNil(localy.jumpUrl))
      {
        localBundle.putString("page_url", aYz(paramg.coX()));
        label153:
        if (!Util.isNullOrNil(localy.title)) {
          break label264;
        }
        localBundle.putString("title", paramg.getTitle());
      }
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, localBundle, b.a.class, new com.tencent.mm.ipcinvoker.d() {});
        com.tencent.mm.plugin.report.service.h.CyF.dN(982, 12);
        f.a(paramContext, 34, 3401, 1, 2, 0, f.aq("url", paramg.coX()));
        AppMethodBeat.o(78681);
        return;
        localBundle.putString("icon_url", localy.iconUrl);
        break;
        localBundle.putString("page_url", localy.iconUrl);
        break label153;
        localBundle.putString("title", localy.title);
      }
    }
  }
  
  public final void a(Context paramContext, g paramg, m paramm)
  {
    AppMethodBeat.i(78680);
    boolean bool = paramg.mParams.getBoolean("from_shortcut", false);
    Object localObject = paramg.ITH;
    String str;
    if (Util.isNullOrNil(((y)localObject).title))
    {
      str = paramg.getTitle();
      if (!Util.isNullOrNil(((y)localObject).iconUrl)) {
        break label143;
      }
    }
    label143:
    for (localObject = paramg.ITw.getIcon();; localObject = ((y)localObject).iconUrl)
    {
      if ((!bool) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject)) && (paramg.Oc(255)))
      {
        paramm.b(29, paramContext.getString(2131764182), 2131691769);
        f.a(paramContext, 34, 3401, 1, 1, 0, f.aq("url", paramg.coX()));
      }
      AppMethodBeat.o(78680);
      return;
      str = ((y)localObject).title;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */