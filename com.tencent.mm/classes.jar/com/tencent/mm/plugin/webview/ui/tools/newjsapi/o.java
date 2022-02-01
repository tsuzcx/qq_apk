package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class o
  extends a
{
  public static final o EpH;
  
  static
  {
    AppMethodBeat.i(207665);
    EpH = new o();
    AppMethodBeat.o(207665);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(207664);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    String str = (String)paraml.xaW.get("urlList");
    if (bt.isNullOrNil(str))
    {
      com.tencent.d.f.h.fUh();
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail", null);
      AppMethodBeat.o(207664);
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("urlList", str);
    if (((Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, a.class)).getBoolean("ret")) {
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":ok", null);
    }
    for (;;)
    {
      AppMethodBeat.o(207664);
      return true;
      paramd.Dyx.i(paraml.DNz, paraml.kYO + ":fail", null);
    }
  }
  
  public final int eOL()
  {
    return 373;
  }
  
  public final String eOM()
  {
    return "onWebPageUrlExposed";
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements k<Bundle, Bundle>
  {
    private static Bundle C(Bundle paramBundle)
    {
      AppMethodBeat.i(207662);
      Bundle localBundle = new Bundle();
      if (paramBundle == null)
      {
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(207662);
        return localBundle;
      }
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        int i;
        try
        {
          paramBundle = new com.tencent.mm.ac.f(paramBundle.getString("urlList"));
          if (paramBundle.length() <= 0)
          {
            com.tencent.d.f.h.fUh();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(207662);
            return localBundle;
          }
          int j = paramBundle.length();
          i = 0;
          if (i < j)
          {
            Object localObject = paramBundle.mJ(i);
            String str = ((i)localObject).optString("url");
            if ((str != null) && (n.aE((CharSequence)str) == true))
            {
              com.tencent.d.f.h.fUh();
            }
            else
            {
              localObject = ((i)localObject).optString("extInfo");
              d.a locala = new d.a();
              locala.url = str;
              locala.extInfo = ((String)localObject);
              locala.nWh = 176;
              localArrayList.add(locala);
            }
          }
        }
        catch (Exception paramBundle)
        {
          com.tencent.d.f.h.fUh();
          if (localArrayList.isEmpty())
          {
            com.tencent.d.f.h.fUh();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(207662);
            return localBundle;
          }
          localBundle.putBoolean("ret", true);
          ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).cd((List)localArrayList);
          AppMethodBeat.o(207662);
          return localBundle;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.o
 * JD-Core Version:    0.7.0.1
 */