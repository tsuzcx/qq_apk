package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public class aj
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78584);
    ad.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((g)paramb.chg).DOL.getAppId();
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiLogin", "appId is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
    bre localbre = new bre();
    locala.hNM = localbre;
    locala.hNN = new brf();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.hNO = 0;
    locala.respCmdId = 0;
    localbre.iht = str;
    localbre.GLo = localLinkedList;
    localbre.GLz = 0;
    localbre.Url = "";
    localbre.GLA = "";
    localbre.GLq = 0;
    IPCRunCgi.a(locala.aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(78582);
        ad.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousb = (brf)paramAnonymousb.hNL.hNQ;
        if ((paramAnonymousb == null) || (paramAnonymousb.GLs == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.GLs.dqI;
        Object localObject = paramAnonymousb.GLs.dqJ;
        paramAnonymousString = paramAnonymousb.GLA;
        ad.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.Gui;
          final String str = paramAnonymousb.uiR;
          paramAnonymousb = paramAnonymousb.Fts;
          ad.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              r localr = new r(((g)aj.1.this.tTK.chg).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  ad.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ad.i("MicroMsg.JsApiLogin", "press back button!");
                    aj.1.this.tTK.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    aj.a(aj.this, aj.1.this.val$appId, paramAnonymous3Bundle, aj.1.1.this.DRk, paramAnonymous3Int, aj.1.this.tTK);
                  } while (paramAnonymous3Int != 2);
                  ad.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  aj.1.this.tTK.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.kyD != null) && (this.kyD.size() > 0))
              {
                if (!localr.a(this.kyD, str, paramAnonymousb, local1)) {
                  aj.1.this.tTK.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              ad.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              aj.1.this.tTK.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.GLB;
          new HashMap().put("code", paramAnonymousString);
          ad.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          paramb.a("", null);
          AppMethodBeat.o(78582);
          return;
        }
        ad.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        paramb.a("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int ccO()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */