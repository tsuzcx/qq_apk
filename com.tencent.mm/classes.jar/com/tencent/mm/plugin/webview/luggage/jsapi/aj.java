package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cer;
import com.tencent.mm.protocal.protobuf.ces;
import com.tencent.mm.protocal.protobuf.cet;
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
    final String str = ((g)paramb.cta).ITw.getAppId();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiLogin", "appId is null!");
      paramb.c("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    d.a locala = new d.a();
    ces localces = new ces();
    locala.iLN = localces;
    locala.iLO = new cet();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.iLP = 0;
    locala.respCmdId = 0;
    localces.jfi = str;
    localces.MjX = localLinkedList;
    localces.Mkk = 0;
    localces.Url = "";
    localces.Mkl = "";
    localces.MjZ = 0;
    IPCRunCgi.a(locala.aXF(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final d paramAnonymousd)
      {
        AppMethodBeat.i(78582);
        Log.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.c("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousd = (cet)paramAnonymousd.iLL.iLR;
        if ((paramAnonymousd == null) || (paramAnonymousd.Mkb == null))
        {
          paramb.c("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousd.Mkb.dIZ;
        Object localObject = paramAnonymousd.Mkb.dJa;
        paramAnonymousString = paramAnonymousd.Mkl;
        Log.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousd.LRN;
          final String str = paramAnonymousd.xMq;
          paramAnonymousd = paramAnonymousd.KFs;
          Log.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousd });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              r localr = new r(((g)aj.1.this.xwD.cta).mContext);
              r.a local1 = new r.a()
              {
                public final void i(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  Log.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.i("MicroMsg.JsApiLogin", "press back button!");
                    aj.1.this.xwD.c("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    aj.a(aj.this, aj.1.this.val$appId, paramAnonymous3Bundle, aj.1.1.this.IWf, paramAnonymous3Int, aj.1.this.xwD);
                  } while (paramAnonymous3Int != 2);
                  Log.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  aj.1.this.xwD.c("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.lGl != null) && (this.lGl.size() > 0))
              {
                if (!localr.a(this.lGl, str, paramAnonymousd, local1)) {
                  aj.1.this.xwD.c("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              Log.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              aj.1.this.xwD.c("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousd.Mkm;
          new HashMap().put("code", paramAnonymousString);
          Log.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          paramb.c("", null);
          AppMethodBeat.o(78582);
          return;
        }
        Log.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        paramb.c("fail", null);
        AppMethodBeat.o(78582);
      }
    });
    AppMethodBeat.o(78584);
  }
  
  public final int dTs()
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