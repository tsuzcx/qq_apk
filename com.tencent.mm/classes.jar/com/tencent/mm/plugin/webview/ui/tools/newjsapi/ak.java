package com.tencent.mm.plugin.webview.ui.tools.newjsapi;

import android.graphics.Color;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/webview/ui/tools/newjsapi/JsApiSetNavigationBarColor;", "Lcom/tencent/mm/plugin/webview/jsapi/newjsapi/BaseJsApi;", "()V", "TAG", "", "controlByte", "", "getControlByte", "()I", "funcName", "getFuncName", "()Ljava/lang/String;", "handleMsg", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "setNavigationBarColor", "plugin-webview_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends a
{
  public static final int OOk;
  private static final String TAG;
  public static final ak Xoa;
  public static final String idA;
  
  static
  {
    AppMethodBeat.i(297517);
    Xoa = new ak();
    TAG = "MicroMsg.JsApiSetNavigationBarColor";
    OOk = 182;
    idA = "setNavigationBarColor";
    AppMethodBeat.o(297517);
  }
  
  private static boolean p(h paramh, p paramp)
  {
    j = 255;
    AppMethodBeat.i(297511);
    Log.i(TAG, "setNavigationBarColor");
    boolean bool = s.p("1", (String)paramp.params.get("actionCode"));
    localBundle = new Bundle();
    if (bool) {
      localBundle.putBoolean("set_navigation_bar_color_reset", true);
    }
    for (;;)
    {
      paramh = paramh.isi();
      if (paramh != null) {
        paramh.m(53, localBundle);
      }
      AppMethodBeat.o(297511);
      return true;
      try
      {
        localObject2 = aa.brW((String)paramp.params.get("wxcolor"));
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject1 = (String)paramp.params.get("color");
        }
        i = Color.parseColor((String)localObject1);
        m = i | 0xFF000000;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject1;
          Log.e(TAG, localException.getMessage());
          localBundle.putBoolean("set_navigation_bar_color_reset", true);
          int m = -1;
          continue;
          i = 0;
          continue;
          j = 0;
        }
      }
      k = j;
      try
      {
        localObject1 = (String)paramp.params.get("alpha");
        k = j;
        localObject2 = (CharSequence)localObject1;
        if (localObject2 == null) {
          break label387;
        }
        k = j;
        if (!n.bp((CharSequence)localObject2)) {
          break;
        }
      }
      catch (Exception paramp)
      {
        for (;;)
        {
          int n;
          i = k;
          Log.e(TAG, paramp.getMessage());
          continue;
          i = k;
          continue;
          i = n;
          continue;
          i = 1;
          continue;
          j = 1;
        }
      }
      k = j;
      if (i != 0) {
        break label375;
      }
      k = j;
      n = (int)(Util.getFloat((String)localObject1, 1.0F) * 255.0F);
      i = j;
      if (n >= 0)
      {
        if (n <= 255) {
          break label381;
        }
        i = j;
      }
      k = i;
      paramp = (String)paramp.params.get("titleAlphaAdjustment");
      k = i;
      localObject1 = (CharSequence)paramp;
      if (localObject1 == null) {
        break label392;
      }
      k = i;
      if (!n.bp((CharSequence)localObject1)) {
        break label353;
      }
      break label392;
      k = i;
      if (j != 0) {
        break label375;
      }
      k = i;
      localBundle.putBoolean("set_navigation_bar_color_titleAlphaAdjustment", Util.getBoolean(paramp, false));
      localBundle.putInt("set_navigation_bar_color_color", m);
      localBundle.putInt("set_navigation_bar_color_alpha", i);
    }
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(297529);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    p(paramh, paramp);
    paramh.WDy.doCallback(paramp.WEH, "setNavigationBarColor:ok", null);
    AppMethodBeat.o(297529);
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
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.newjsapi.ak
 * JD-Core Version:    0.7.0.1
 */