package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
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
import com.tencent.mm.protocal.protobuf.biw;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biy;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.JsApiAuthorize", "invokeInOwn");
    Object localObject = parama.bZV.bZb.optJSONArray("scope");
    if (localObject == null)
    {
      ad.e("MicroMsg.JsApiAuthorize", "scope is null!");
      parama.a("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((f)parama.bZU).ATn.getAppId();
    if (bt.isNullOrNil(str))
    {
      ad.e("MicroMsg.JsApiAuthorize", "appId is null!");
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
    biy localbiy = new biy();
    ((b.a)localObject).gUU = localbiy;
    ((b.a)localObject).gUV = new biz();
    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((b.a)localObject).funcId = 1157;
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    localbiy.hnC = str;
    localbiy.DGv = localLinkedList;
    localbiy.DGx = 0;
    IPCRunCgi.a(((b.a)localObject).atI(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, b paramAnonymousb)
      {
        AppMethodBeat.i(78519);
        ad.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (biz)paramAnonymousb.gUT.gUX;
        if ((paramAnonymousString == null) || (paramAnonymousString.DGz == null))
        {
          parama.a("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.DGz.dhR;
        paramAnonymousb = paramAnonymousString.DGz.dhS;
        ad.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              r localr = new r(((f)c.1.this.rPk.bZU).mContext);
              r.a local1 = new r.a()
              {
                public final void i(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  ad.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    ad.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.rPk.a("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    a.a locala = c.1.this.rPk;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new b.a();
                    biw localbiw = new biw();
                    ((b.a)localObject).gUU = localbiw;
                    ((b.a)localObject).gUV = new bix();
                    ((b.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((b.a)localObject).funcId = 1158;
                    ((b.a)localObject).reqCmdId = 0;
                    ((b.a)localObject).respCmdId = 0;
                    localbiw.hnC = str;
                    localbiw.DGv = paramAnonymous3Bundle;
                    localbiw.DGx = 0;
                    localbiw.DGw = paramAnonymous3Int;
                    IPCRunCgi.a(((b.a)localObject).atI(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.rPk.a("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.jDz != null) && (this.jDz.size() > 0))
              {
                if (!localr.a(this.jDz, this.AVc, this.AVd, local1)) {
                  c.1.this.rPk.a("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              ad.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.rPk.a("fail", null);
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
        ad.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousb });
        parama.a("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int bQV()
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