package com.tencent.mm.plugin.scanner.box.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.f.a.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.MMWebView;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCollect;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "doFav", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "fillTextEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "text", "sourceType", "", "handleMsg", "plugin-scan_release"})
public final class a
  extends b
{
  public static final a IIa;
  private static final String fXz = "collect";
  
  static
  {
    AppMethodBeat.i(218884);
    IIa = new a();
    fXz = "collect";
    AppMethodBeat.o(218884);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(218881);
    p.k(paramf, "env");
    p.k(paramn, "msg");
    Object localObject2 = (String)paramn.params.get("sessionId");
    if (localObject2 == null) {
      localObject2 = "";
    }
    for (;;)
    {
      Object localObject1 = (String)paramn.params.get("content");
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        Log.i("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect sessionId: %s, content: %s", new Object[] { localObject2, localObject1 });
        if (((CharSequence)localObject1).length() == 0) {}
        for (int i = 1; i != 0; i = 0)
        {
          Log.e("MicroMsg.JsApiCollect", "ScanJsApi-Call collect content is empty");
          paramf.PNo.h(paramn.POu, paramn.function + ":ok", null);
          AppMethodBeat.o(218881);
          return true;
        }
        Object localObject3 = com.tencent.mm.plugin.scanner.f.a.INg;
        localObject2 = com.tencent.mm.plugin.scanner.f.a.aXm((String)localObject2);
        localObject3 = new dd();
        Log.d("MicroMsg.JsApiCollect", "fillTextEventInfo text: %s, sourceType %d", new Object[] { localObject1, Integer.valueOf(27) });
        Object localObject4 = new aoc();
        aoi localaoi = new aoi();
        localaoi.arz(27);
        localaoi.Ue(Util.nowMilliSecond());
        ((aoc)localObject4).a(localaoi);
        ((dd)localObject3).fyI.desc = ((String)localObject1);
        ((dd)localObject3).fyI.fyK = ((aoc)localObject4);
        ((dd)localObject3).fyI.type = 1;
        if (localObject2 != null)
        {
          localObject1 = ((a.a)localObject2).IGF;
          label289:
          Log.v("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect fromUser: %s", new Object[] { localObject1 });
          localObject1 = ((dd)localObject3).fyI.fyK;
          if (localObject1 != null)
          {
            localObject4 = ((aoc)localObject1).hpE();
            if (localObject4 != null)
            {
              if (localObject2 != null)
              {
                localObject2 = ((a.a)localObject2).IGF;
                localObject1 = localObject2;
                if (localObject2 != null) {}
              }
              else
              {
                localObject1 = "";
              }
              ((aoi)localObject4).btx((String)localObject1);
            }
          }
          localObject2 = ((dd)localObject3).fyI;
          localObject1 = paramf.PNp;
          if (localObject1 == null) {
            break label467;
          }
          localObject1 = ((MMWebView)localObject1).getParent();
          label390:
          localObject1 = (View)localObject1;
          if (localObject1 == null) {
            break label473;
          }
          localObject1 = ((View)localObject1).getRootView();
          label409:
          localObject1 = (ViewGroup)localObject1;
          if (localObject1 == null) {
            break label479;
          }
        }
        label467:
        label473:
        label479:
        for (localObject1 = ((ViewGroup)localObject1).getChildAt(0);; localObject1 = null)
        {
          ((dd.a)localObject2).fyN = ((View)localObject1);
          ((dd)localObject3).fyI.fyP = 43;
          EventCenter.instance.publish((IEvent)localObject3);
          break;
          localObject1 = null;
          break label289;
          localObject1 = null;
          break label390;
          localObject1 = null;
          break label409;
        }
      }
    }
  }
  
  public final String fCm()
  {
    return fXz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a
 * JD-Core Version:    0.7.0.1
 */