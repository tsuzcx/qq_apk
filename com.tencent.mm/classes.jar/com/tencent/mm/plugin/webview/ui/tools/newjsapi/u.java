package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.f;
import com.tencent.mm.ad.i;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.brandservice.api.h.a;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "BIZ_TYPE_PREFETCH_WEB_PAGE", "", "BIZ_TYPE_PRELOAD_VIDEO", "TAG", "", "controlByte", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class u
  extends a
{
  public static final u Xnr;
  
  static
  {
    AppMethodBeat.i(297727);
    Xnr = new u();
    AppMethodBeat.o(297727);
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.jsapi.h paramh, p paramp)
  {
    AppMethodBeat.i(297745);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    String str = (String)paramp.params.get("urlList");
    if (Util.isNullOrNil(str))
    {
      com.tencent.e.f.h.jXD();
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
      AppMethodBeat.o(297745);
      return true;
    }
    Object localObject = paramp.params.get("bizType");
    Bundle localBundle;
    if (localObject == null)
    {
      localObject = "";
      localBundle = new Bundle();
      localBundle.putString("urlList", str);
      if (!s.p(localObject, "1")) {
        break label185;
      }
      localBundle.putInt("bizType", 1);
      label128:
      if (!((Bundle)j.a(MainProcessIPCService.PROCESS_NAME, (Parcelable)localBundle, a.class)).getBoolean("ret")) {
        break label196;
      }
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
    }
    for (;;)
    {
      AppMethodBeat.o(297745);
      return true;
      break;
      label185:
      localBundle.putInt("bizType", 0);
      break label128;
      label196:
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":fail"), null);
    }
  }
  
  public final String gPX()
  {
    return "onWebPageUrlExposed";
  }
  
  public final int gPZ()
  {
    return 373;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed$WebPrefetchTask;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Landroid/os/Bundle;", "()V", "invoke", "data", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements m<Bundle, Bundle>
  {
    private static Bundle Z(Bundle paramBundle)
    {
      AppMethodBeat.i(297709);
      localBundle = new Bundle();
      if (paramBundle == null)
      {
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(297709);
        return localBundle;
      }
      localArrayList = new ArrayList();
      for (;;)
      {
        try
        {
          localObject1 = paramBundle.getString("urlList");
          i = paramBundle.getInt("bizType", 0);
        }
        catch (Exception paramBundle)
        {
          Object localObject1;
          int m;
          int k;
          Object localObject2;
          String str1;
          int n;
          String str2;
          int i = 0;
          continue;
          int j = k;
          continue;
          continue;
        }
        try
        {
          paramBundle = new f((String)localObject1);
          if (paramBundle.length() <= 0)
          {
            com.tencent.e.f.h.jXD();
            localBundle.putBoolean("ret", false);
            AppMethodBeat.o(297709);
            return localBundle;
          }
          m = paramBundle.length();
          if (m <= 0) {
            continue;
          }
          j = 0;
          k = j + 1;
          localObject2 = paramBundle.su(j);
          if (localObject2 != null)
          {
            str1 = ((i)localObject2).optString("url");
            n = ((i)localObject2).optInt("bizScene");
            if ((str1 == null) || (n.bp((CharSequence)str1) != true)) {
              continue;
            }
            j = 1;
            if (j == 0) {
              continue;
            }
            com.tencent.e.f.h.jXD();
          }
          if (k < m) {
            continue;
          }
        }
        catch (Exception paramBundle)
        {
          com.tencent.e.f.h.jXD();
          continue;
          localBundle.putBoolean("ret", true);
          s.X("WebPrefetchTask  bizType:", Integer.valueOf(i));
          com.tencent.e.f.h.jXD();
          if (i != 1) {
            continue;
          }
          ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ej((List)localArrayList);
          AppMethodBeat.o(297709);
          return localBundle;
          ((com.tencent.mm.plugin.brandservice.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.h.class)).ei((List)localArrayList);
          continue;
        }
        if (!localArrayList.isEmpty()) {
          continue;
        }
        com.tencent.e.f.h.jXD();
        localBundle.putBoolean("ret", false);
        AppMethodBeat.o(297709);
        return localBundle;
        j = 0;
        continue;
        str2 = ((i)localObject2).optString("extInfo");
        localObject1 = new h.a();
        ((h.a)localObject1).url = str1;
        ((h.a)localObject1).extInfo = str2;
        ((h.a)localObject1).vAZ = 176;
        ((h.a)localObject1).vBa = n;
        ((h.a)localObject1).vAY = ((i)localObject2).optString("prefetchId", "");
        localObject2 = ah.aiuX;
        localArrayList.add(localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.u
 * JD-Core Version:    0.7.0.1
 */