package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.h;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.plugin.webview.luggage.z;
import com.tencent.mm.plugin.webview.model.au.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
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
  
  private static String bke(String paramString)
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
  
  public final void a(final Context paramContext, final com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78681);
    Bundle localBundle = new Bundle();
    z localz = paramg.WGs;
    String str2;
    if (Util.isNullOrNil(localz.iconUrl))
    {
      str2 = paramg.WGh.getIcon();
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
      if (Util.isNullOrNil(localz.jumpUrl))
      {
        localBundle.putString("page_url", bke(paramg.dgY()));
        label153:
        if (!Util.isNullOrNil(localz.title)) {
          break label264;
        }
        localBundle.putString("title", paramg.getTitle());
      }
      for (;;)
      {
        j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, new f() {});
        h.OAn.kJ(982, 12);
        com.tencent.mm.game.report.g.a(paramContext, 34, 3401, 1, 2, 0, com.tencent.mm.game.report.g.aC("url", paramg.dgY()));
        AppMethodBeat.o(78681);
        return;
        localBundle.putString("icon_url", localz.iconUrl);
        break;
        localBundle.putString("page_url", localz.iconUrl);
        break label153;
        localBundle.putString("title", localz.title);
      }
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(78680);
    boolean bool = paramg.ejT.getBoolean("from_shortcut", false);
    Object localObject = paramg.WGs;
    String str;
    if (Util.isNullOrNil(((z)localObject).title))
    {
      str = paramg.getTitle();
      if (!Util.isNullOrNil(((z)localObject).iconUrl)) {
        break label145;
      }
    }
    label145:
    for (localObject = paramg.WGh.getIcon();; localObject = ((z)localObject).iconUrl)
    {
      if ((!bool) && (!Util.isNullOrNil(str)) && (!Util.isNullOrNil((String)localObject)) && (paramg.Xp(255)))
      {
        params.a(29, paramContext.getString(c.i.readerapp_add_shortcut), c.h.webview_add_shortcut);
        com.tencent.mm.game.report.g.a(paramContext, 34, 3401, 1, 1, 0, com.tencent.mm.game.report.g.aC("url", paramg.dgY()));
      }
      AppMethodBeat.o(78680);
      return;
      str = ((z)localObject).title;
      break;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.d<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */