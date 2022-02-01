package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.plugin.webview.ui.tools.widget.p.a;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.protocal.protobuf.cnn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public class aj
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78584);
    Log.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((g)paramb.crg).PPO.getAppId();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiLogin", "appId is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    d.a locala = new d.a();
    cnm localcnm = new cnm();
    locala.lBU = localcnm;
    locala.lBV = new cnn();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.lBW = 0;
    locala.respCmdId = 0;
    localcnm.lVG = str;
    localcnm.TuN = localLinkedList;
    localcnm.Tva = 0;
    localcnm.Url = "";
    localcnm.Tvb = "";
    localcnm.TuP = 0;
    IPCRunCgi.a(locala.bgN(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd)
      {
        AppMethodBeat.i(78582);
        Log.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousd = (cnn)d.c.b(paramAnonymousd.lBS);
        if ((paramAnonymousd == null) || (paramAnonymousd.TuR == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousd.TuR.fBP;
        Object localObject = paramAnonymousd.TuR.errmsg;
        paramAnonymousString = paramAnonymousd.Tvb;
        Log.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousd.Tau;
          final String str = paramAnonymousd.CQz;
          paramAnonymousd = paramAnonymousd.RGJ;
          Log.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousd });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              p localp = new p(((g)aj.1.this.CAL.crg).mContext);
              p.a local1 = new p.a()
              {
                public final void k(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  Log.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.i("MicroMsg.JsApiLogin", "press back button!");
                    aj.1.this.CAL.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    aj.a(aj.this, aj.1.this.val$appId, paramAnonymous3Bundle, aj.1.1.this.PSv, paramAnonymous3Int, aj.1.this.CAL);
                  } while (paramAnonymous3Int != 2);
                  Log.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  aj.1.this.CAL.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.oBO != null) && (this.oBO.size() > 0))
              {
                if (!localp.a(this.oBO, str, paramAnonymousd, local1)) {
                  aj.1.this.CAL.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              Log.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              aj.1.this.CAL.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousd.Tvc;
          new HashMap().put("code", paramAnonymousString);
          Log.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          paramb.a("", null);
          AppMethodBeat.o(78582);
          return;
        }
        Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        paramb.a("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int cDj()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */