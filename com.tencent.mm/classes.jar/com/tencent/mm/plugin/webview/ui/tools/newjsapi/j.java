package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.a.d.a;
import com.tencent.mm.plugin.webview.c.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import d.n.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class j
  extends a
{
  public static final j CLJ;
  
  static
  {
    AppMethodBeat.i(189510);
    CLJ = new j();
    AppMethodBeat.o(189510);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.c.d paramd, com.tencent.mm.plugin.webview.c.l paraml)
  {
    AppMethodBeat.i(189509);
    d.g.b.k.h(paramd, "env");
    d.g.b.k.h(paraml, "msg");
    String str = (String)paraml.vUl.get("urlList");
    if (bs.isNullOrNil(str))
    {
      com.tencent.d.f.h.fCP();
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
      AppMethodBeat.o(189509);
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("urlList", str);
    if (((Bundle)com.tencent.mm.ipcinvoker.h.a("com.tencent.mm", (Parcelable)localBundle, a.class)).getBoolean("ret")) {
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":ok", null);
    }
    for (;;)
    {
      AppMethodBeat.o(189509);
      return true;
      paramd.Cjq.j(paraml.Ckt, paraml.kCH + ":fail", null);
    }
  }
  
  public final int ezX()
  {
    return 373;
  }
  
  public final String ezY()
  {
    return "onWebPageUrlExposed";
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements com.tencent.mm.ipcinvoker.k<Bundle, Bundle>
  {
    private static Bundle B(Bundle paramBundle)
    {
      AppMethodBeat.i(189507);
      Bundle localBundle = new Bundle();
      if (paramBundle == null)
      {
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(189507);
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
            com.tencent.d.f.h.fCP();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(189507);
            return localBundle;
          }
          int j = paramBundle.length();
          i = 0;
          if (i < j)
          {
            Object localObject = paramBundle.mk(0);
            String str = ((i)localObject).optString("url");
            if ((str != null) && (n.aD((CharSequence)str) == true))
            {
              com.tencent.d.f.h.fCP();
            }
            else
            {
              localObject = ((i)localObject).optString("extInfo");
              d.a locala = new d.a();
              locala.url = str;
              locala.extInfo = ((String)localObject);
              localArrayList.add(locala);
            }
          }
        }
        catch (Exception paramBundle)
        {
          com.tencent.d.f.h.fCP();
          if (localArrayList.isEmpty())
          {
            com.tencent.d.f.h.fCP();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(189507);
            return localBundle;
          }
          localBundle.putBoolean("ret", true);
          ((com.tencent.mm.plugin.brandservice.a.d)g.ab(com.tencent.mm.plugin.brandservice.a.d.class)).cc((List)localArrayList);
          AppMethodBeat.o(189507);
          return localBundle;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.j
 * JD-Core Version:    0.7.0.1
 */