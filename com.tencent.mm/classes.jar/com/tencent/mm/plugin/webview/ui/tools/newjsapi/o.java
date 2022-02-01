package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.ipcinvoker.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class o
  extends a
{
  public static final o EHS;
  
  static
  {
    AppMethodBeat.i(199431);
    EHS = new o();
    AppMethodBeat.o(199431);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(199430);
    p.h(paramd, "env");
    p.h(paraml, "msg");
    String str = (String)paraml.xqN.get("urlList");
    if (bu.isNullOrNil(str))
    {
      com.tencent.d.f.h.fYG();
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
      AppMethodBeat.o(199430);
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("urlList", str);
    if (((Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, a.class)).getBoolean("ret")) {
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":ok", null);
    }
    for (;;)
    {
      AppMethodBeat.o(199430);
      return true;
      paramd.DQe.i(paraml.Efy, paraml.lcx + ":fail", null);
    }
  }
  
  public final int eSw()
  {
    return 373;
  }
  
  public final String eSx()
  {
    return "onWebPageUrlExposed";
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements k<Bundle, Bundle>
  {
    private static Bundle D(Bundle paramBundle)
    {
      AppMethodBeat.i(199428);
      Bundle localBundle = new Bundle();
      if (paramBundle == null)
      {
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(199428);
        return localBundle;
      }
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        int i;
        try
        {
          paramBundle = new com.tencent.mm.ab.f(paramBundle.getString("urlList"));
          if (paramBundle.length() <= 0)
          {
            com.tencent.d.f.h.fYG();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(199428);
            return localBundle;
          }
          int j = paramBundle.length();
          i = 0;
          if (i < j)
          {
            Object localObject = paramBundle.mM(i);
            String str = ((i)localObject).optString("url");
            if ((str != null) && (n.aD((CharSequence)str) == true))
            {
              com.tencent.d.f.h.fYG();
            }
            else
            {
              localObject = ((i)localObject).optString("extInfo");
              d.a locala = new d.a();
              locala.url = str;
              locala.extInfo = ((String)localObject);
              locala.obQ = 176;
              localArrayList.add(locala);
            }
          }
        }
        catch (Exception paramBundle)
        {
          com.tencent.d.f.h.fYG();
          if (localArrayList.isEmpty())
          {
            com.tencent.d.f.h.fYG();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(199428);
            return localBundle;
          }
          localBundle.putBoolean("ret", true);
          ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).cf((List)localArrayList);
          AppMethodBeat.o(199428);
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