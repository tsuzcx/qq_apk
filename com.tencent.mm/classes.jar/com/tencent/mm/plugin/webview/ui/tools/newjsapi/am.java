package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiShowKeyBoard;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "callbackID", "getCallbackID", "()Ljava/lang/String;", "setCallbackID", "(Ljava/lang/String;)V", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "sendRespToWeb", "", "jsApiHandler", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiHandler;", "text", "cancel", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class am
  extends a
{
  private static final int OOk;
  public static final am Xoc;
  private static String Xod;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297548);
    Xoc = new am();
    OOk = 187;
    idA = "showKeyboard";
    AppMethodBeat.o(297548);
  }
  
  public static void a(j paramj, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(297542);
    s.u(paramj, "jsApiHandler");
    s.u(paramString, "text");
    if (Xod == null)
    {
      Log.i("MicroMsg.JsApiShowKeyBoard", "callbackID == null, return");
      AppMethodBeat.o(297542);
      return;
    }
    Map localMap = (Map)new HashMap();
    localMap.put("text", paramString);
    if (paramBoolean) {}
    for (paramString = "showKeyboard:cancel";; paramString = "showKeyboard:ok")
    {
      paramj.doCallback(Xod, paramString, localMap);
      Xod = null;
      AppMethodBeat.o(297542);
      return;
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297565);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Xod = paramp.WEH;
    Bundle localBundle = new Bundle();
    String str1 = (String)paramp.params.get("text");
    String str2 = (String)paramp.params.get("placeholder");
    Object localObject = paramp.params.get("maxLength");
    int i;
    label127:
    int j;
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      i = Util.safeParseInt((String)localObject);
      localObject = paramp.params.get("showRemindWordCount");
      if (!(localObject instanceof String)) {
        break label328;
      }
      localObject = (String)localObject;
      j = Util.safeParseInt((String)localObject);
      if (Util.getBoolean((String)paramp.params.get("hidden"), false)) {
        break label334;
      }
    }
    label328:
    label334:
    for (boolean bool = true;; bool = false)
    {
      paramp = (String)paramp.params.get("customParams");
      localBundle.putString("show_kb_placeholder", str2);
      localBundle.putInt("show_kb_max_length", i);
      localBundle.putInt("show_kb_show_remind_word_count", j);
      localBundle.putString("show_kb_text", str1);
      localBundle.putBoolean("show_kb_to_show", bool);
      localBundle.putString("key_show_kb_custom_params", paramp);
      Log.d("MicroMsg.JsApiShowKeyBoard", idA + " text=" + str1 + ", placeholder=" + str2 + ", maxLength=" + i + ", showRemindWordCount=" + j + ", toShow=" + bool);
      paramh = paramh.isi();
      if (paramh != null) {
        paramh.m(37, localBundle);
      }
      AppMethodBeat.o(297565);
      return true;
      localObject = null;
      break;
      localObject = null;
      break label127;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
  
  public final int gPZ()
  {
    return OOk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.am
 * JD-Core Version:    0.7.0.1
 */