package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.a.e.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;
import kotlin.n.n;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
public final class p$a
  implements k<Bundle, Bundle>
{
  private static Bundle J(Bundle paramBundle)
  {
    AppMethodBeat.i(210628);
    Bundle localBundle = new Bundle();
    if (paramBundle == null)
    {
      localBundle.putBoolean("ret", false);
      AppMethodBeat.o(210628);
      return localBundle;
    }
    ArrayList localArrayList = new ArrayList();
    for (;;)
    {
      int i;
      try
      {
        paramBundle = new f(paramBundle.getString("urlList"));
        if (paramBundle.length() <= 0)
        {
          h.hkS();
          localBundle.putBoolean("ret", false);
          AppMethodBeat.o(210628);
          return localBundle;
        }
        int j = paramBundle.length();
        i = 0;
        if (i < j)
        {
          Object localObject = paramBundle.pZ(i);
          String str = ((i)localObject).optString("url");
          int k = ((i)localObject).optInt("bizScene");
          if ((str != null) && (n.aL((CharSequence)str) == true))
          {
            h.hkS();
          }
          else
          {
            localObject = ((i)localObject).optString("extInfo");
            e.a locala = new e.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.pmM = 176;
            locala.pmN = k;
            localArrayList.add(locala);
          }
        }
      }
      catch (Exception paramBundle)
      {
        h.hkS();
        if (localArrayList.isEmpty())
        {
          h.hkS();
          localBundle.putBoolean("ret", false);
          AppMethodBeat.o(210628);
          return localBundle;
        }
        localBundle.putBoolean("ret", true);
        ((e)g.af(e.class)).cu((List)localArrayList);
        AppMethodBeat.o(210628);
        return localBundle;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.p.a
 * JD-Core Version:    0.7.0.1
 */