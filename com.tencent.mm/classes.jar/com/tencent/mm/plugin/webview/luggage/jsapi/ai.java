package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bjb;
import com.tencent.mm.protocal.protobuf.bjc;
import com.tencent.mm.protocal.protobuf.bjd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.LinkedList;

public class ai
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78584);
    ad.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((f)parama.bZU).ATn.getAppId();
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiLogin", "appId is null!");
      parama.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    b.a locala = new b.a();
    bjc localbjc = new bjc();
    locala.gUU = localbjc;
    locala.gUV = new bjd();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    localbjc.hnC = str;
    localbjc.DGv = localLinkedList;
    localbjc.DGF = 0;
    localbjc.Url = "";
    localbjc.DGG = "";
    localbjc.DGx = 0;
    IPCRunCgi.a(locala.atI(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final b paramAnonymousb)
      {
        AppMethodBeat.i(78582);
        ad.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousb = (bjd)paramAnonymousb.gUT.gUX;
        if ((paramAnonymousb == null) || (paramAnonymousb.DGz == null))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.DGz.dhR;
        Object localObject = paramAnonymousb.DGz.dhS;
        paramAnonymousString = paramAnonymousb.DGG;
        ad.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.Dqc;
          final String str = paramAnonymousb.scR;
          paramAnonymousb = paramAnonymousb.CvQ;
          ad.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              r localr = new r(((f)ai.1.this.rPk.bZU).mContext);
              r.a local1 = new r.a()
              {
                public final void i(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  ad.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ad.i("MicroMsg.JsApiLogin", "press back button!");
                    ai.1.this.rPk.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    ai.a(ai.this, ai.1.this.val$appId, paramAnonymous3Bundle, ai.1.1.this.AVC, paramAnonymous3Int, ai.1.this.rPk);
                  } while (paramAnonymous3Int != 2);
                  ad.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  ai.1.this.rPk.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.jDz != null) && (this.jDz.size() > 0))
              {
                if (!localr.a(this.jDz, str, paramAnonymousb, local1)) {
                  ai.1.this.rPk.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              ad.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              ai.1.this.rPk.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.DGH;
          new HashMap().put("code", paramAnonymousString);
          ad.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          parama.a("", null);
          AppMethodBeat.o(78582);
          return;
        }
        ad.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        parama.a("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int bQV()
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