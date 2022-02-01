package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.brandservice.a.f.a;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "BIZ_TYPE_PREFETCH_WEB_PAGE", "", "BIZ_TYPE_PRELOAD_VIDEO", "TAG", "", "controlByte", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class s
  extends a
{
  public static final s Qvv;
  
  static
  {
    AppMethodBeat.i(218543);
    Qvv = new s();
    AppMethodBeat.o(218543);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, com.tencent.mm.plugin.webview.d.n paramn)
  {
    AppMethodBeat.i(218542);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    String str = (String)paramn.params.get("urlList");
    if (Util.isNullOrNil(str))
    {
      com.tencent.d.f.h.ioq();
      paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      AppMethodBeat.o(218542);
      return true;
    }
    Object localObject = paramn.params.get("bizType");
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("urlList", str);
      if (p.h(localObject, "1"))
      {
        localBundle.putInt("bizType", 1);
        if (!((Bundle)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, a.class)).getBoolean("ret")) {
          break label215;
        }
        paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
      }
      for (;;)
      {
        AppMethodBeat.o(218542);
        return true;
        localBundle.putInt("bizType", 0);
        break;
        label215:
        paramf.PNo.h(paramn.POu, paramn.function + ":fail", null);
      }
    }
  }
  
  public final String fCm()
  {
    return "onWebPageUrlExposed";
  }
  
  public final int fCn()
  {
    return 373;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"})
  public static final class a
    implements m<Bundle, Bundle>
  {
    private static Bundle P(Bundle paramBundle)
    {
      AppMethodBeat.i(242582);
      Bundle localBundle = new Bundle();
      if (paramBundle == null)
      {
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(242582);
        return localBundle;
      }
      ArrayList localArrayList = new ArrayList();
      for (;;)
      {
        try
        {
          str = paramBundle.getString("urlList");
          i = paramBundle.getInt("bizType", 0);
        }
        catch (Exception paramBundle)
        {
          String str;
          int k;
          int j;
          Object localObject;
          int m;
          int i = 0;
          continue;
          continue;
          j += 1;
          continue;
        }
        try
        {
          paramBundle = new com.tencent.mm.ad.f(str);
          if (paramBundle.length() <= 0)
          {
            com.tencent.d.f.h.ioq();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(242582);
            return localBundle;
          }
          k = paramBundle.length();
          j = 0;
          if (j >= k) {
            continue;
          }
          localObject = paramBundle.sy(j);
          str = ((i)localObject).optString("url");
          m = ((i)localObject).optInt("bizScene");
          if ((str != null) && (kotlin.n.n.ba((CharSequence)str) == true))
          {
            com.tencent.d.f.h.ioq();
          }
          else
          {
            localObject = ((i)localObject).optString("extInfo");
            f.a locala = new f.a();
            locala.url = str;
            locala.extInfo = ((String)localObject);
            locala.svv = 176;
            locala.svw = m;
            localArrayList.add(locala);
          }
        }
        catch (Exception paramBundle) {}
      }
      com.tencent.d.f.h.ioq();
      if (localArrayList.isEmpty())
      {
        com.tencent.d.f.h.ioq();
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(242582);
        return localBundle;
      }
      localBundle.putBoolean("ret", true);
      "WebPrefetchTask  bizType:".concat(String.valueOf(i));
      com.tencent.d.f.h.ioq();
      if (i == 1) {
        ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).cr((List)localArrayList);
      }
      for (;;)
      {
        AppMethodBeat.o(242582);
        return localBundle;
        ((com.tencent.mm.plugin.brandservice.a.f)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.f.class)).cq((List)localArrayList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.s
 * JD-Core Version:    0.7.0.1
 */