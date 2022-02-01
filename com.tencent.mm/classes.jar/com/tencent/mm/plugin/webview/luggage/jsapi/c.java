package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
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
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.protocal.protobuf.bmq;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(final a<f>.a parama)
  {
    AppMethodBeat.i(78521);
    ac.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = parama.bWS.bVY.optJSONArray("scope");
    if (localObject == null)
    {
      ac.e("MicroMsg.JsApiAuthorize", "scope is null!");
      parama.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((f)parama.bWR).ClA.getAppId();
    if (bs.isNullOrNil(str))
    {
      ac.e("MicroMsg.JsApiAuthorize", "appId is null!");
      parama.a("fail", null);
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
    localObject = new b.a();
    bmq localbmq = new bmq();
    ((b.a)localObject).hvt = localbmq;
    ((b.a)localObject).hvu = new bmr();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localbmq.hOf = str;
    localbmq.FbP = localLinkedList;
    localbmq.FbR = 0;
    IPCRunCgi.a(((b.a)localObject).aAz(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(78519);
        ac.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (bmr)paramAnonymousb.hvs.hvw;
        if ((paramAnonymousString == null) || (paramAnonymousString.FbT == null))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.FbT.dfm;
        paramAnonymousb = paramAnonymousString.FbT.dfn;
        ac.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              r localr = new r(((f)c.1.this.sXa.bWR).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  ac.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ac.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.sXa.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    a.a locala = c.1.this.sXa;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new b.a();
                    bmo localbmo = new bmo();
                    ((b.a)localObject).hvt = localbmo;
                    ((b.a)localObject).hvu = new bmp();
                    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((b.a)localObject).funcId = 1158;
                    ((b.a)localObject).reqCmdId = 0;
                    ((b.a)localObject).respCmdId = 0;
                    localbmo.hOf = str;
                    localbmo.FbP = paramAnonymous3Bundle;
                    localbmo.FbR = 0;
                    localbmo.FbQ = paramAnonymous3Int;
                    IPCRunCgi.a(((b.a)localObject).aAz(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.sXa.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.kdV != null) && (this.kdV.size() > 0))
              {
                if (!localr.a(this.kdV, this.Cnp, this.Cnq, local1)) {
                  c.1.this.sXa.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              ac.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.sXa.a("fail", null);
              AppMethodBeat.o(78518);
            }
          });
          AppMethodBeat.o(78519);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          parama.a("", null);
          AppMethodBeat.o(78519);
          return;
        }
        ac.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousb });
        parama.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int bYk()
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