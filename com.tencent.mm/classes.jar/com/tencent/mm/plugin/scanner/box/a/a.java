package com.tencent.mm.plugin.scanner.box.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.cz.a;
import com.tencent.mm.g.a.cz.b;
import com.tencent.mm.plugin.scanner.box.a.a.b;
import com.tencent.mm.plugin.scanner.e.a.a;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/jsapi/JsApiCollect;", "Lcom/tencent/mm/plugin/scanner/box/jsapi/base/ScanBaseJsApi;", "()V", "TAG", "", "funcName", "getFuncName", "()Ljava/lang/String;", "doFav", "", "env", "Lcom/tencent/mm/plugin/webview/jsapi/JsApiEnv;", "msg", "Lcom/tencent/mm/plugin/webview/jsapi/MsgWrapper;", "fillTextEventInfo", "", "favEvent", "Lcom/tencent/mm/autogen/events/DoFavoriteEvent;", "text", "sourceType", "", "handleMsg", "plugin-scan_release"})
public final class a
  extends b
{
  public static final a CDA;
  private static final String edq = "collect";
  
  static
  {
    AppMethodBeat.i(240342);
    CDA = new a();
    edq = "collect";
    AppMethodBeat.o(240342);
  }
  
  public final boolean a(f paramf, n paramn)
  {
    AppMethodBeat.i(240341);
    p.h(paramf, "env");
    p.h(paramn, "msg");
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
        int i;
        if (((CharSequence)localObject1).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label160;
          }
          Log.e("MicroMsg.JsApiCollect", "ScanJsApi-Call collect content is empty");
        }
        for (;;)
        {
          paramf.IQZ.h(paramn.ISe, paramn.mhO + ":ok", null);
          AppMethodBeat.o(240341);
          return true;
          i = 0;
          break;
          label160:
          Object localObject3 = com.tencent.mm.plugin.scanner.e.a.CHU;
          localObject2 = com.tencent.mm.plugin.scanner.e.a.aMF((String)localObject2);
          localObject3 = new cz();
          Log.d("MicroMsg.JsApiCollect", "fillTextEventInfo text: %s, sourceType %d", new Object[] { localObject1, Integer.valueOf(27) });
          Object localObject4 = new anb();
          anh localanh = new anh();
          localanh.ajm(27);
          localanh.MA(Util.nowMilliSecond());
          ((anb)localObject4).a(localanh);
          ((cz)localObject3).dFZ.desc = ((String)localObject1);
          ((cz)localObject3).dFZ.dGb = ((anb)localObject4);
          ((cz)localObject3).dFZ.type = 1;
          if (localObject2 != null) {}
          for (localObject1 = ((a.a)localObject2).CAZ;; localObject1 = null)
          {
            Log.v("MicroMsg.JsApiCollect", "ScanJsApi-Call:collect fromUser: %s", new Object[] { localObject1 });
            localObject1 = ((cz)localObject3).dFZ.dGb;
            if (localObject1 != null)
            {
              localObject4 = ((anb)localObject1).gui();
              if (localObject4 != null)
              {
                if (localObject2 != null)
                {
                  localObject2 = ((a.a)localObject2).CAZ;
                  localObject1 = localObject2;
                  if (localObject2 != null) {}
                }
                else
                {
                  localObject1 = "";
                }
                ((anh)localObject4).bhf((String)localObject1);
              }
            }
            localObject1 = ((cz)localObject3).dFZ;
            localObject2 = paramf.context;
            if (localObject2 != null) {
              break;
            }
            paramf = new t("null cannot be cast to non-null type android.app.Activity");
            AppMethodBeat.o(240341);
            throw paramf;
          }
          ((cz.a)localObject1).activity = ((Activity)localObject2);
          ((cz)localObject3).dFZ.dGi = false;
          ((cz)localObject3).dFZ.dGf = 43;
          EventCenter.instance.publish((IEvent)localObject3);
          if (Iu(System.currentTimeMillis())) {
            if (((cz)localObject3).dGa.ret == 0) {
              u.cG(paramf.context, paramf.context.getString(2131759260));
            } else {
              u.cH(paramf.context, paramf.context.getString(2131764896));
            }
          }
        }
      }
    }
  }
  
  public final String ePz()
  {
    return edq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.a.a
 * JD-Core Version:    0.7.0.1
 */