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
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.model.at.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.l;
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
  
  private static String aIy(String paramString)
  {
    AppMethodBeat.i(78682);
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getQuery();
    if (bu.isNullOrNil(str1)) {
      str1 = "ssid=25";
    }
    try
    {
      for (;;)
      {
        str1 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), str1, localUri.getFragment()).toString();
        ae.d("MicroMsg.MenuDelegate_AddShortcut", "rawUrl : %s, newUrl : %s", new Object[] { paramString, str1 });
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
        ae.printErrStackTrace("MicroMsg.MenuDelegate_AddShortcut", localURISyntaxException, "", new Object[0]);
        String str2 = paramString;
      }
    }
  }
  
  public final void a(final Context paramContext, final com.tencent.mm.plugin.webview.luggage.g paramg)
  {
    AppMethodBeat.i(78681);
    Bundle localBundle = new Bundle();
    w localw = paramg.EgX;
    String str2;
    if (bu.isNullOrNil(localw.iconUrl))
    {
      str2 = paramg.EgL.eTv();
      if (bu.isNullOrNil(str2))
      {
        AppMethodBeat.o(78681);
        return;
      }
      int i = str2.lastIndexOf("/");
      if (i == -1) {
        break label278;
      }
      str1 = str2.substring(0, i);
    }
    label263:
    label278:
    for (String str1 = str1 + "/0";; str1 = str2)
    {
      ae.i("MicroMsg.MenuDelegate_AddShortcut", "rawIconUrl : %s, newIconUrl : %s", new Object[] { str2, str1 });
      localBundle.putString("icon_url", str1);
      if (bu.isNullOrNil(localw.jumpUrl))
      {
        localBundle.putString("page_url", aIy(paramg.bRn()));
        label153:
        if (!bu.isNullOrNil(localw.title)) {
          break label263;
        }
        localBundle.putString("title", paramg.getTitle());
      }
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, a.class, new com.tencent.mm.ipcinvoker.d() {});
        com.tencent.mm.plugin.report.service.g.yxI.dD(982, 12);
        f.a(paramContext, 34, 3401, 1, 2, 0, f.ao("url", paramg.bRn()));
        AppMethodBeat.o(78681);
        return;
        localBundle.putString("icon_url", localw.iconUrl);
        break;
        localBundle.putString("page_url", localw.iconUrl);
        break label153;
        localBundle.putString("title", localw.title);
      }
    }
  }
  
  public final void a(Context paramContext, com.tencent.mm.plugin.webview.luggage.g paramg, l paraml)
  {
    AppMethodBeat.i(78680);
    boolean bool = paramg.mParams.getBoolean("from_shortcut", false);
    Object localObject = paramg.EgX;
    String str;
    if (bu.isNullOrNil(((w)localObject).title))
    {
      str = paramg.getTitle();
      if (!bu.isNullOrNil(((w)localObject).iconUrl)) {
        break label143;
      }
    }
    label143:
    for (localObject = paramg.EgL.eTv();; localObject = ((w)localObject).iconUrl)
    {
      if ((!bool) && (!bu.isNullOrNil(str)) && (!bu.isNullOrNil((String)localObject)) && (paramg.HZ(255)))
      {
        paraml.a(29, paramContext.getString(2131762161), 2131691431);
        f.a(paramContext, 34, 3401, 1, 1, 0, f.ao("url", paramg.bRn()));
      }
      AppMethodBeat.o(78680);
      return;
      str = ((w)localObject).title;
      break;
    }
  }
  
  static class a
    implements com.tencent.mm.ipcinvoker.b<Bundle, Bundle>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.b.b
 * JD-Core Version:    0.7.0.1
 */