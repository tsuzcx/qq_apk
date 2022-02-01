package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.widget.r;
import com.tencent.mm.plugin.webview.ui.tools.widget.r.a;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = paramb.chh.cgn.optJSONArray("scope");
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiAuthorize", "scope is null!");
      paramb.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((g)paramb.chg).DOL.getAppId();
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiAuthorize", "appId is null!");
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
    localObject = new com.tencent.mm.al.b.a();
    bra localbra = new bra();
    ((com.tencent.mm.al.b.a)localObject).hNM = localbra;
    ((com.tencent.mm.al.b.a)localObject).hNN = new brb();
    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((com.tencent.mm.al.b.a)localObject).funcId = 1157;
    ((com.tencent.mm.al.b.a)localObject).hNO = 0;
    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
    localbra.iht = str;
    localbra.GLo = localLinkedList;
    localbra.GLq = 0;
    IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).aDC(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.al.b paramAnonymousb)
      {
        AppMethodBeat.i(78519);
        ad.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (brb)paramAnonymousb.hNL.hNQ;
        if ((paramAnonymousString == null) || (paramAnonymousString.GLs == null))
        {
          paramb.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.GLs.dqI;
        paramAnonymousb = paramAnonymousString.GLs.dqJ;
        ad.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              r localr = new r(((g)c.1.this.tTK.chg).mContext);
              r.a local1 = new r.a()
              {
                public final void j(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  ad.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ad.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.tTK.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    com.tencent.luggage.d.b.a locala = c.1.this.tTK;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new com.tencent.mm.al.b.a();
                    bqy localbqy = new bqy();
                    ((com.tencent.mm.al.b.a)localObject).hNM = localbqy;
                    ((com.tencent.mm.al.b.a)localObject).hNN = new bqz();
                    ((com.tencent.mm.al.b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((com.tencent.mm.al.b.a)localObject).funcId = 1158;
                    ((com.tencent.mm.al.b.a)localObject).hNO = 0;
                    ((com.tencent.mm.al.b.a)localObject).respCmdId = 0;
                    localbqy.iht = str;
                    localbqy.GLo = paramAnonymous3Bundle;
                    localbqy.GLq = 0;
                    localbqy.GLp = paramAnonymous3Int;
                    IPCRunCgi.a(((com.tencent.mm.al.b.a)localObject).aDC(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.tTK.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.kyD != null) && (this.kyD.size() > 0))
              {
                if (!localr.a(this.kyD, this.DQJ, this.DQK, local1)) {
                  c.1.this.tTK.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              ad.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.tTK.a("fail", null);
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
        ad.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousb });
        paramb.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int ccO()
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