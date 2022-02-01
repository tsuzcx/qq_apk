package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brx;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.brz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.LinkedList;

public class aj
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78584);
    ae.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((g)paramb.chg).EgL.getAppId();
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.JsApiLogin", "appId is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    bry localbry = new bry();
    locala.hQF = localbry;
    locala.hQG = new brz();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.hQH = 0;
    locala.respCmdId = 0;
    localbry.ikm = str;
    localbry.HeP = localLinkedList;
    localbry.Hfa = 0;
    localbry.Url = "";
    localbry.Hfb = "";
    localbry.HeR = 0;
    IPCRunCgi.a(locala.aDS(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(78582);
        ae.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousb = (brz)paramAnonymousb.hQE.hQJ;
        if ((paramAnonymousb == null) || (paramAnonymousb.HeT == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.HeT.drN;
        Object localObject = paramAnonymousb.HeT.drO;
        paramAnonymousString = paramAnonymousb.Hfb;
        ae.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.GNH;
          final String str = paramAnonymousb.uuo;
          paramAnonymousb = paramAnonymousb.FLQ;
          ae.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              r localr = new r(((g)aj.1.this.ueC.chg).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  ae.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ae.i("MicroMsg.JsApiLogin", "press back button!");
                    aj.1.this.ueC.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    aj.a(aj.this, aj.1.this.val$appId, paramAnonymous3Bundle, aj.1.1.this.Ejk, paramAnonymous3Int, aj.1.this.ueC);
                  } while (paramAnonymous3Int != 2);
                  ae.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  aj.1.this.ueC.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.kBS != null) && (this.kBS.size() > 0))
              {
                if (!localr.a(this.kBS, str, paramAnonymousb, local1)) {
                  aj.1.this.ueC.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              ae.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              aj.1.this.ueC.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.Hfc;
          new HashMap().put("code", paramAnonymousString);
          ae.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          paramb.a("", null);
          AppMethodBeat.o(78582);
          return;
        }
        ae.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        paramb.a("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */