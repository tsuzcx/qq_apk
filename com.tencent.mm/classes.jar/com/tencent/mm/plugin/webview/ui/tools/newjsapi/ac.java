package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.d.c.a;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiShowKeyBoard;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "callbackID", "getCallbackID", "()Ljava/lang/String;", "setCallbackID", "(Ljava/lang/String;)V", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "sendRespToWeb", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "text", "cancel", "plugin-webview_release"})
public final class ac
  extends a
{
  private static final int IIl = 187;
  private static String QvO;
  public static final ac QvP;
  private static final String fXz = "showKeyboard";
  
  static
  {
    AppMethodBeat.i(250339);
    QvP = new ac();
    IIl = 187;
    fXz = "showKeyboard";
    AppMethodBeat.o(250339);
  }
  
  public static void a(h paramh, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(250336);
    p.k(paramh, "jsApiHandler");
    p.k(paramString, "text");
    if (QvO == null)
    {
      Log.i("MicroMsg.JsApiShowKeyBoard", "callbackID == null, return");
      AppMethodBeat.o(250336);
      return;
    }
    Map localMap = (Map)new HashMap();
    localMap.put("text", paramString);
    if (paramBoolean) {}
    for (paramString = "showKeyboard:cancel";; paramString = "showKeyboard:ok")
    {
      paramh.h(QvO, paramString, localMap);
      QvO = null;
      AppMethodBeat.o(250336);
      return;
    }
  }
  
  public final boolean a(com.tencent.mm.plugin.webview.d.f paramf, n paramn)
  {
    AppMethodBeat.i(250333);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    QvO = paramn.POu;
    Bundle localBundle = new Bundle();
    String str1 = (String)paramn.params.get("text");
    String str2 = (String)paramn.params.get("placeholder");
    Object localObject2 = paramn.params.get("maxLength");
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    int i = Util.safeParseInt((String)localObject1);
    localObject2 = paramn.params.get("showRemindWordCount");
    localObject1 = localObject2;
    if (!(localObject2 instanceof String)) {
      localObject1 = null;
    }
    int j = Util.safeParseInt((String)localObject1);
    if (!Util.getBoolean((String)paramn.params.get("hidden"), false)) {}
    for (boolean bool = true;; bool = false)
    {
      localBundle.putString("show_kb_placeholder", str2);
      localBundle.putInt("show_kb_max_length", i);
      localBundle.putInt("show_kb_show_remind_word_count", j);
      localBundle.putString("show_kb_text", str1);
      localBundle.putBoolean("show_kb_to_show", bool);
      Log.d("MicroMsg.JsApiShowKeyBoard", fXz + " text=" + str1 + ", placeholder=" + str2 + ", maxLength=" + i + ", showRemindWordCount=" + j + ", toShow=" + bool);
      paramn = paramf.context;
      paramf = paramn;
      if (!(paramn instanceof WebViewUI)) {
        paramf = null;
      }
      paramf = (WebViewUI)paramf;
      if (paramf != null)
      {
        paramf = paramf.POP;
        if (paramf != null) {
          paramf.l(37, localBundle);
        }
      }
      AppMethodBeat.o(250333);
      return true;
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
  
  public final int fCn()
  {
    return IIl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ac
 * JD-Core Version:    0.7.0.1
 */