package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
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
import com.tencent.mm.protocal.protobuf.brs;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class c
  extends br<g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(final com.tencent.luggage.d.b<g>.a paramb)
  {
    AppMethodBeat.i(78521);
    ae.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = paramb.chh.cgn.optJSONArray("scope");
    if (localObject == null)
    {
      ae.e("MicroMsg.JsApiAuthorize", "scope is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((g)paramb.chg).EgL.getAppId();
    if (bu.isNullOrNil(str))
    {
      ae.e("MicroMsg.JsApiAuthorize", "appId is null!");
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
    localObject = new com.tencent.mm.ak.b.a();
    bru localbru = new bru();
    ((com.tencent.mm.ak.b.a)localObject).hQF = localbru;
    ((com.tencent.mm.ak.b.a)localObject).hQG = new brv();
    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((com.tencent.mm.ak.b.a)localObject).funcId = 1157;
    ((com.tencent.mm.ak.b.a)localObject).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
    localbru.ikm = str;
    localbru.HeP = localLinkedList;
    localbru.HeR = 0;
    IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aDS(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ak.b paramAnonymousb)
      {
        AppMethodBeat.i(78519);
        ae.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (brv)paramAnonymousb.hQE.hQJ;
        if ((paramAnonymousString == null) || (paramAnonymousString.HeT == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.HeT.drN;
        paramAnonymousb = paramAnonymousString.HeT.drO;
        ae.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              r localr = new r(((g)c.1.this.ueC.chg).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  ae.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ae.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.ueC.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    com.tencent.luggage.d.b.a locala = c.1.this.ueC;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new com.tencent.mm.ak.b.a();
                    brs localbrs = new brs();
                    ((com.tencent.mm.ak.b.a)localObject).hQF = localbrs;
                    ((com.tencent.mm.ak.b.a)localObject).hQG = new brt();
                    ((com.tencent.mm.ak.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((com.tencent.mm.ak.b.a)localObject).funcId = 1158;
                    ((com.tencent.mm.ak.b.a)localObject).hQH = 0;
                    ((com.tencent.mm.ak.b.a)localObject).respCmdId = 0;
                    localbrs.ikm = str;
                    localbrs.HeP = paramAnonymous3Bundle;
                    localbrs.HeR = 0;
                    localbrs.HeQ = paramAnonymous3Int;
                    IPCRunCgi.a(((com.tencent.mm.ak.b.a)localObject).aDS(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.ueC.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.kBS != null) && (this.kBS.size() > 0))
              {
                if (!localr.a(this.kBS, this.EiJ, this.EiK, local1)) {
                  c.1.this.ueC.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              ae.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.ueC.a("fail", null);
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
        ae.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousb });
        paramb.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int ced()
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