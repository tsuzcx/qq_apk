package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiOnWebPageUrlExposed;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "WebPrefetchTask", "plugin-webview_release"})
public final class p
  extends a
{
  public static final p JxA;
  
  static
  {
    AppMethodBeat.i(210631);
    JxA = new p();
    AppMethodBeat.o(210631);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(210630);
    kotlin.g.b.p.h(paramf, "env");
    kotlin.g.b.p.h(paramn, "msg");
    String str = (String)paramn.params.get("urlList");
    if (Util.isNullOrNil(str))
    {
      com.tencent.e.f.h.hkS();
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
      AppMethodBeat.o(210630);
      return true;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString("urlList", str);
    if (((Bundle)com.tencent.mm.ipcinvoker.h.a(MainProcessIPCService.dkO, (Parcelable)localBundle, p.a.class)).getBoolean("ret")) {
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
    }
    for (;;)
    {
      AppMethodBeat.o(210630);
      return true;
      paramf.IQZ.h(paramn.ISe, paramn.mhO + ":fail", null);
    }
  }
  
  public final int ePA()
  {
    return 373;
  }
  
  public final String ePz()
  {
    return "onWebPageUrlExposed";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.p
 * JD-Core Version:    0.7.0.1
 */