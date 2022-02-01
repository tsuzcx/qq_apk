package com.tencent.mm.plugin.webview.luggage.b;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.luggage.d.c;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.luggage.v;
import com.tencent.mm.plugin.webview.model.as.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
  
  private static String awn(String paramString)
  {
    AppMethodBeat.i(78682);
    Uri localUri = Uri.parse(paramString);
    String str1 = localUri.getQuery();
    if (bt.isNullOrNil(str1)) {
      str1 = "ssid=25";
    }
    try
    {
      for (;;)
      {
        str1 = new URI(localUri.getScheme(), localUri.getAuthority(), localUri.getPath(), str1, localUri.getFragment()).toString();
        ad.d("MicroMsg.MenuDelegate_AddShortcut", "rawUrl : %s, newUrl : %s", new Object[] { paramString, str1 });
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
        ad.printErrStackTrace("MicroMsg.MenuDelegate_AddShortcut", localURISyntaxException, "", new Object[0]);
        String str2 = paramString;
      }
    }
  }
  
  public final void a(final Context paramContext, final f paramf)
  {
    AppMethodBeat.i(78681);
    Bundle localBundle = new Bundle();
    v localv = paramf.ATz;
    String str2;
    if (bt.isNullOrNil(localv.iconUrl))
    {
      str2 = paramf.ATn.elv();
      if (bt.isNullOrNil(str2))
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
      ad.i("MicroMsg.MenuDelegate_AddShortcut", "rawIconUrl : %s, newIconUrl : %s", new Object[] { str2, str1 });
      localBundle.putString("icon_url", str1);
      if (bt.isNullOrNil(localv.jumpUrl))
      {
        localBundle.putString("page_url", awn(paramf.bEx()));
        label153:
        if (!bt.isNullOrNil(localv.title)) {
          break label263;
        }
        localBundle.putString("title", paramf.getTitle());
      }
      for (;;)
      {
        com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", localBundle, a.class, new d() {});
        com.tencent.mm.plugin.report.service.h.vKh.dB(982, 12);
        e.a(paramContext, 34, 3401, 1, 2, 0, e.aj("url", paramf.bEx()));
        AppMethodBeat.o(78681);
        return;
        localBundle.putString("icon_url", localv.iconUrl);
        break;
        localBundle.putString("page_url", localv.iconUrl);
        break label153;
        localBundle.putString("title", localv.title);
      }
    }
  }
  
  public final void a(Context paramContext, f paramf, l paraml)
  {
    AppMethodBeat.i(78680);
    boolean bool = paramf.mParams.getBoolean("from_shortcut", false);
    Object localObject = paramf.ATz;
    String str;
    if (bt.isNullOrNil(((v)localObject).title))
    {
      str = paramf.getTitle();
      if (!bt.isNullOrNil(((v)localObject).iconUrl)) {
        break label143;
      }
    }
    label143:
    for (localObject = paramf.ATn.elv();; localObject = ((v)localObject).iconUrl)
    {
      if ((!bool) && (!bt.isNullOrNil(str)) && (!bt.isNullOrNil((String)localObject)) && (paramf.Em(255)))
      {
        paraml.a(29, paramContext.getString(2131762161), 2131691431);
        e.a(paramContext, 34, 3401, 1, 1, 0, e.aj("url", paramf.bEx()));
      }
      AppMethodBeat.o(78680);
      return;
      str = ((v)localObject).title;
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