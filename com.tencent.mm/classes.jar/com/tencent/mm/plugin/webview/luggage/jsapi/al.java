package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.t;
import com.tencent.mm.plugin.webview.ui.tools.widget.t.a;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;

public class al
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78584);
    Log.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((g)paramb.eiY).WGh.getAppId();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiLogin", "appId is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78584);
      return;
    }
    c.a locala = new c.a();
    dee localdee = new dee();
    locala.otE = localdee;
    locala.otF = new def();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.funcId = 1029;
    locala.otG = 0;
    locala.respCmdId = 0;
    localdee.oOI = str;
    localdee.aaJs = localLinkedList;
    localdee.aaJG = 0;
    localdee.Url = "";
    localdee.aaJH = "";
    localdee.aaJu = 0;
    IPCRunCgi.a(locala.bEF(), new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, final String paramAnonymousString, final c paramAnonymousc)
      {
        AppMethodBeat.i(78582);
        Log.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousc = (def)c.c.b(paramAnonymousc.otC);
        if ((paramAnonymousc == null) || (paramAnonymousc.aaJx == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78582);
          return;
        }
        paramAnonymousInt1 = paramAnonymousc.aaJx.hGE;
        Object localObject = paramAnonymousc.aaJx.errmsg;
        paramAnonymousString = paramAnonymousc.aaJH;
        Log.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousc.aans;
          final String str = paramAnonymousc.IKJ;
          paramAnonymousc = paramAnonymousc.YDL;
          Log.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousc });
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78581);
              t localt = new t(((g)al.1.this.Iux.eiY).mContext);
              t.a local1 = new t.a()
              {
                public final void l(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78580);
                  Log.i("MicroMsg.JsApiLogin", "onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.i("MicroMsg.JsApiLogin", "press back button!");
                    al.1.this.Iux.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78580);
                    return;
                    al.a(al.this, al.1.this.etl, paramAnonymous3Bundle, al.1.1.this.WJb, paramAnonymous3Int, al.1.this.Iux);
                  } while (paramAnonymous3Int != 2);
                  Log.e("MicroMsg.JsApiLogin", "fail auth deny!");
                  al.1.this.Iux.a("auth_deny", null);
                  AppMethodBeat.o(78580);
                }
              };
              if ((this.rFB != null) && (this.rFB.size() > 0))
              {
                if (!localt.a(this.rFB, str, paramAnonymousc, local1)) {
                  al.1.this.Iux.a("fail", null);
                }
                AppMethodBeat.o(78581);
                return;
              }
              Log.e("MicroMsg.JsApiLogin", "scopeInfoList is empty!");
              al.1.this.Iux.a("fail", null);
              AppMethodBeat.o(78581);
            }
          });
          AppMethodBeat.o(78582);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousc.aaJI;
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
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.al
 * JD-Core Version:    0.7.0.1
 */