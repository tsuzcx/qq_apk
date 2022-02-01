package com.tencent.mm.plugin.scanner.box.a;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.a;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.f.a.a;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCollect;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "doFav", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "fillTextEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "text", "sourceType", "", "handleMsg", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends b
{
  public static final a ONZ;
  private static final String idA;
  
  static
  {
    AppMethodBeat.i(313800);
    ONZ = new a();
    idA = "collect";
    AppMethodBeat.o(313800);
  }
  
  public final boolean a(h paramh, p paramp)
  {
    AppMethodBeat.i(313817);
    s.u(paramh, "env");
    s.u(paramp, "msg");
    Object localObject2 = (String)paramp.params.get("sessionId");
    if (localObject2 == null)
    {
      localObject2 = "";
      localObject1 = (String)paramp.params.get("content");
      if (localObject1 != null) {
        break label147;
      }
      localObject1 = "";
      label67:
      Log.i("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect sessionId: %s, content: %s", new Object[] { localObject2, localObject1 });
      if (((CharSequence)localObject1).length() != 0) {
        break label150;
      }
    }
    label147:
    label150:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label155;
      }
      Log.e("MicroMsg.JsApiCollect", "ScanJsApi-Call collect content is empty");
      paramh.WDy.doCallback(paramp.WEH, s.X(paramp.function, ":ok"), null);
      AppMethodBeat.o(313817);
      return true;
      break;
      break label67;
    }
    label155:
    Object localObject3 = com.tencent.mm.plugin.scanner.f.a.OUi;
    localObject3 = com.tencent.mm.plugin.scanner.f.a.aUR((String)localObject2);
    dn localdn = new dn();
    Log.d("MicroMsg.JsApiCollect", "fillTextEventInfo text: %s, sourceType %d", new Object[] { localObject1, Integer.valueOf(27) });
    localObject2 = new arv();
    asb localasb = new asb();
    localasb.axH(27);
    localasb.yu(Util.nowMilliSecond());
    ((arv)localObject2).a(localasb);
    localdn.hDr.desc = ((String)localObject1);
    localdn.hDr.hDt = ((arv)localObject2);
    localdn.hDr.type = 1;
    if (localObject3 == null)
    {
      localObject1 = null;
      label280:
      Log.v("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect fromUser: %s", new Object[] { localObject1 });
      localObject1 = localdn.hDr.hDt;
      if (localObject1 != null) {
        break label448;
      }
      localObject2 = null;
      label314:
      if (localObject2 != null)
      {
        if (localObject3 != null) {
          break label458;
        }
        localObject1 = "";
        label328:
        ((asb)localObject2).bto((String)localObject1);
      }
      if ((paramh.context instanceof Activity)) {
        localdn.hDr.activity = ((Activity)paramh.context);
      }
      localObject2 = localdn.hDr;
      localObject1 = paramh.WDz;
      if (localObject1 != null) {
        break label481;
      }
      localObject1 = null;
      label382:
      localObject1 = (View)localObject1;
      if (localObject1 != null) {
        break label491;
      }
      localObject1 = null;
      label397:
      localObject1 = (ViewGroup)localObject1;
      if (localObject1 != null) {
        break label501;
      }
    }
    label448:
    label458:
    label481:
    label491:
    label501:
    for (Object localObject1 = null;; localObject1 = ((ViewGroup)localObject1).getChildAt(0))
    {
      ((dn.a)localObject2).hDw = ((View)localObject1);
      localdn.hDr.hDy = 43;
      localdn.publish();
      break;
      localObject1 = ((a.a)localObject3).OMN;
      break label280;
      localObject2 = ((arv)localObject1).ZBt;
      break label314;
      localObject3 = ((a.a)localObject3).OMN;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label328;
      }
      localObject1 = "";
      break label328;
      localObject1 = ((MMWebView)localObject1).getParent();
      break label382;
      localObject1 = ((View)localObject1).getRootView();
      break label397;
    }
  }
  
  public final String gPX()
  {
    return idA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a
 * JD-Core Version:    0.7.0.1
 */