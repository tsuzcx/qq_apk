package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.plugin.webview.ui.tools.widget.t;
import com.tencent.mm.plugin.webview.ui.tools.widget.t.a;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddy;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.dea;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78521);
    Log.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = paramb.eiZ.eif.optJSONArray("scope");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiAuthorize", "scope is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((g)paramb.eiY).WGh.getAppId();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiAuthorize", "appId is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < ((JSONArray)localObject).length())
    {
      localLinkedList.add(((JSONArray)localObject).optString(i));
      i += 1;
    }
    localObject = new c.a();
    dea localdea = new dea();
    ((c.a)localObject).otE = localdea;
    ((c.a)localObject).otF = new deb();
    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((c.a)localObject).funcId = 1157;
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    localdea.oOI = str;
    localdea.aaJs = localLinkedList;
    localdea.aaJu = 0;
    IPCRunCgi.a(((c.a)localObject).bEF(), new IPCRunCgi.a()
    {
      public final void callback(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.am.c paramAnonymousc)
      {
        AppMethodBeat.i(78519);
        Log.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (deb)c.c.b(paramAnonymousc.otC);
        if ((paramAnonymousString == null) || (paramAnonymousString.aaJx == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.aaJx.hGE;
        paramAnonymousc = paramAnonymousString.aaJx.errmsg;
        Log.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              t localt = new t(((g)c.1.this.Iux.eiY).mContext);
              t.a local1 = new t.a()
              {
                public final void l(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  Log.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.Iux.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.etl;
                    b.a locala = c.1.this.Iux;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new c.a();
                    ddy localddy = new ddy();
                    ((c.a)localObject).otE = localddy;
                    ((c.a)localObject).otF = new ddz();
                    ((c.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((c.a)localObject).funcId = 1158;
                    ((c.a)localObject).otG = 0;
                    ((c.a)localObject).respCmdId = 0;
                    localddy.oOI = str;
                    localddy.aaJs = paramAnonymous3Bundle;
                    localddy.aaJu = 0;
                    localddy.aaJt = paramAnonymous3Int;
                    IPCRunCgi.a(((c.a)localObject).bEF(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.Iux.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.rFB != null) && (this.rFB.size() > 0))
              {
                if (!localt.a(this.rFB, this.WIr, this.WIs, local1)) {
                  c.1.this.Iux.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              Log.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.Iux.a("fail", null);
              AppMethodBeat.o(78518);
            }
          });
          AppMethodBeat.o(78519);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramb.a("", null);
          AppMethodBeat.o(78519);
          return;
        }
        Log.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousc });
        paramb.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int dgI()
  {
    return 0;
  }
  
  public final String name()
  {
    return "authorize";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.c
 * JD-Core Version:    0.7.0.1
 */