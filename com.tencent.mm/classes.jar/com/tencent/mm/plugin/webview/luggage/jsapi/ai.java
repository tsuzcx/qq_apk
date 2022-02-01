package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmt;
import com.tencent.mm.protocal.protobuf.bmu;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.LinkedList;

public class ai
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78584);
    ac.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((f)parama.bWR).ClA.getAppId();
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.JsApiLogin", "appId is null!");
      parama.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    b.a locala = new b.a();
    bmu localbmu = new bmu();
    locala.hvt = localbmu;
    locala.hvu = new bmv();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localbmu.hOf = str;
    localbmu.FbP = localLinkedList;
    localbmu.FbZ = 0;
    localbmu.Url = "";
    localbmu.Fca = "";
    localbmu.FbR = 0;
    IPCRunCgi.a(locala.aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final b paramAnonymousb)
      {
        AppMethodBeat.i(78582);
        ac.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousb = (bmv)paramAnonymousb.hvs.hvw;
        if ((paramAnonymousb == null) || (paramAnonymousb.FbT == null))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.FbT.dfm;
        Object localObject = paramAnonymousb.FbT.dfn;
        paramAnonymousString = paramAnonymousb.Fca;
        ac.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.ELf;
          final String str = paramAnonymousb.tkL;
          paramAnonymousb = paramAnonymousb.DOl;
          ac.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              r localr = new r(((f)ai.1.this.sXa.bWR).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  ac.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ac.i("MicroMsg.JsApiLogin", "press back button!");
                    ai.1.this.sXa.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    ai.a(ai.this, ai.1.this.val$appId, paramAnonymous3Bundle, ai.1.1.this.CnP, paramAnonymous3Int, ai.1.this.sXa);
                  } while (paramAnonymous3Int != 2);
                  ac.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  ai.1.this.sXa.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.kdV != null) && (this.kdV.size() > 0))
              {
                if (!localr.a(this.kdV, str, paramAnonymousb, local1)) {
                  ai.1.this.sXa.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              ac.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              ai.1.this.sXa.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.Fcb;
          new HashMap().put("code", paramAnonymousString);
          ac.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          parama.a("", null);
          AppMethodBeat.o(78582);
          return;
        }
        ac.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        parama.a("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int bYk()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ai
 * JD-Core Version:    0.7.0.1
 */