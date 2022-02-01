package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
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
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cni;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(final b<g>.a paramb)
  {
    AppMethodBeat.i(78521);
    Log.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = paramb.crh.cqn.optJSONArray("scope");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiAuthorize", "scope is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((g)paramb.crg).PPO.getAppId();
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
    localObject = new d.a();
    cni localcni = new cni();
    ((d.a)localObject).lBU = localcni;
    ((d.a)localObject).lBV = new cnj();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((d.a)localObject).funcId = 1157;
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    localcni.lVG = str;
    localcni.TuN = localLinkedList;
    localcni.TuP = 0;
    IPCRunCgi.a(((d.a)localObject).bgN(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(78519);
        Log.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (cnj)d.c.b(paramAnonymousd.lBS);
        if ((paramAnonymousString == null) || (paramAnonymousString.TuR == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.TuR.fBP;
        paramAnonymousd = paramAnonymousString.TuR.errmsg;
        Log.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              p localp = new p(((g)c.1.this.CAL.crg).mContext);
              p.a local1 = new p.a()
              {
                public final void k(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  Log.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.CAL.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    b.a locala = c.1.this.CAL;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new d.a();
                    cng localcng = new cng();
                    ((d.a)localObject).lBU = localcng;
                    ((d.a)localObject).lBV = new cnh();
                    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((d.a)localObject).funcId = 1158;
                    ((d.a)localObject).lBW = 0;
                    ((d.a)localObject).respCmdId = 0;
                    localcng.lVG = str;
                    localcng.TuN = paramAnonymous3Bundle;
                    localcng.TuP = 0;
                    localcng.TuO = paramAnonymous3Int;
                    IPCRunCgi.a(((d.a)localObject).bgN(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.CAL.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.oBO != null) && (this.oBO.size() > 0))
              {
                if (!localp.a(this.oBO, this.PRU, this.PRV, local1)) {
                  c.1.this.CAL.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              Log.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.CAL.a("fail", null);
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
        Log.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousd });
        paramb.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int cDj()
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