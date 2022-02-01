package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.c.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetPageTitle;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "doSetPageTitle", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "handleMsg", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  extends a
{
  private static final int OOk;
  private static final String TAG;
  public static final al Xob;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(297561);
    Xob = new al();
    TAG = "MicroMsg.JsApiSetPageTitle";
    OOk = 113;
    idA = "setPageTitle";
    AppMethodBeat.o(297561);
  }
  
  private static boolean q(h paramh, p paramp)
  {
    AppMethodBeat.i(297553);
    Bundle localBundle = new Bundle(2);
    localBundle.putString("set_page_title_text", (String)paramp.params.get("title"));
    localObject3 = "";
    for (;;)
    {
      try
      {
        localObject1 = aa.brW((String)paramp.params.get("wxcolor"));
        if (localObject1 == null)
        {
          localObject1 = "";
          localObject3 = localObject1;
          localObject4 = localObject1;
          if (!Util.isNullOrNil((String)localObject1)) {
            continue;
          }
          localObject3 = localObject1;
          localObject4 = (String)paramp.params.get("color");
          localObject1 = localObject4;
          if (localObject4 == null) {
            localObject1 = "";
          }
        }
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Log.e(TAG, localException1.getMessage());
        Object localObject4 = localObject3;
        Object localObject2 = localObject4;
        continue;
        i = 0;
        continue;
      }
      try
      {
        localObject3 = (String)paramp.params.get("alpha");
        localObject4 = (CharSequence)localObject3;
        if (localObject4 == null) {
          break label280;
        }
        if (!n.bp((CharSequence)localObject4)) {
          continue;
        }
      }
      catch (Exception localException2)
      {
        Log.e(TAG, localException2.getMessage());
        f = 1.0F;
        continue;
        i = 1;
        continue;
      }
      if (i != 0) {
        break label275;
      }
      f = Util.getFloat((String)localObject3, 1.0F);
      localBundle.putString("set_page_title_color", (String)localObject1);
      localBundle.putFloat("set_page_title_alpha", f);
      localObject1 = paramh.isi();
      if (localObject1 != null) {
        ((f)localObject1).m(43, localBundle);
      }
      paramh.WDy.doCallback(paramp.WEH, "setPageTitle:ok", null);
      AppMethodBeat.o(297553);
      return true;
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297573);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    q(paramh, paramp);
    AppMethodBeat.o(297573);
    return true;
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.al
 * JD-Core Version:    0.7.0.1
 */