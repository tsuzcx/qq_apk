package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.os.Bundle;
import com.tencent.luggage.bridge.k;
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
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.cep;
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
    Object localObject = paramb.ctb.csi.optJSONArray("scope");
    if (localObject == null)
    {
      Log.e("MicroMsg.JsApiAuthorize", "scope is null!");
      paramb.c("fail", null);
      AppMethodBeat.o(78521);
      return;
    }
    final String str = ((g)paramb.cta).ITw.getAppId();
    if (Util.isNullOrNil(str))
    {
      Log.e("MicroMsg.JsApiAuthorize", "appId is null!");
      paramb.c("fail", null);
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
    ceo localceo = new ceo();
    ((d.a)localObject).iLN = localceo;
    ((d.a)localObject).iLO = new cep();
    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize";
    ((d.a)localObject).funcId = 1157;
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    localceo.jfi = str;
    localceo.MjX = localLinkedList;
    localceo.MjZ = 0;
    IPCRunCgi.a(((d.a)localObject).aXF(), new IPCRunCgi.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, d paramAnonymousd)
      {
        AppMethodBeat.i(78519);
        Log.i("MicroMsg.JsApiAuthorize", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          paramb.c("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousString = (cep)paramAnonymousd.iLL.iLR;
        if ((paramAnonymousString == null) || (paramAnonymousString.Mkb == null))
        {
          paramb.c("fail", null);
          AppMethodBeat.o(78519);
          return;
        }
        paramAnonymousInt1 = paramAnonymousString.Mkb.dIZ;
        paramAnonymousd = paramAnonymousString.Mkb.dJa;
        Log.i("MicroMsg.JsApiAuthorize", "jsErrcode = %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(78518);
              r localr = new r(((g)c.1.this.xwD.cta).mContext);
              r.a local1 = new r.a()
              {
                public final void i(int paramAnonymous3Int, Bundle paramAnonymous3Bundle)
                {
                  AppMethodBeat.i(78517);
                  Log.i("MicroMsg.JsApiAuthorize", "stev onRevMsg resultCode %d", new Object[] { Integer.valueOf(paramAnonymous3Int) });
                  switch (paramAnonymous3Int)
                  {
                  default: 
                    Log.d("MicroMsg.JsApiAuthorize", "press back button!");
                    c.1.this.xwD.c("auth_cancel", null);
                  }
                  do
                  {
                    AppMethodBeat.o(78517);
                    return;
                    c localc = c.this;
                    String str = c.1.this.val$appId;
                    b.a locala = c.1.this.xwD;
                    Object localObject = (ArrayList)paramAnonymous3Bundle.getSerializable("key_scope");
                    paramAnonymous3Bundle = new LinkedList();
                    localObject = ((ArrayList)localObject).iterator();
                    while (((Iterator)localObject).hasNext()) {
                      paramAnonymous3Bundle.add((String)((Iterator)localObject).next());
                    }
                    localObject = new d.a();
                    cem localcem = new cem();
                    ((d.a)localObject).iLN = localcem;
                    ((d.a)localObject).iLO = new cen();
                    ((d.a)localObject).uri = "/cgi-bin/mmbiz-bin/js-authorize-confirm";
                    ((d.a)localObject).funcId = 1158;
                    ((d.a)localObject).iLP = 0;
                    ((d.a)localObject).respCmdId = 0;
                    localcem.jfi = str;
                    localcem.MjX = paramAnonymous3Bundle;
                    localcem.MjZ = 0;
                    localcem.MjY = paramAnonymous3Int;
                    IPCRunCgi.a(((d.a)localObject).aXF(), new c.2(localc, locala, paramAnonymous3Int));
                  } while (paramAnonymous3Int != 2);
                  c.1.this.xwD.c("auth_deny", null);
                  AppMethodBeat.o(78517);
                }
              };
              if ((this.lGl != null) && (this.lGl.size() > 0))
              {
                if (!localr.a(this.lGl, this.IVE, this.IVF, local1)) {
                  c.1.this.xwD.c("fail", null);
                }
                AppMethodBeat.o(78518);
                return;
              }
              Log.e("MicroMsg.JsApiAuthorize", "scopeInfoList is empty!");
              c.1.this.xwD.c("fail", null);
              AppMethodBeat.o(78518);
            }
          });
          AppMethodBeat.o(78519);
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramb.c("", null);
          AppMethodBeat.o(78519);
          return;
        }
        Log.e("MicroMsg.JsApiAuthorize", "ERROR = %s", new Object[] { paramAnonymousd });
        paramb.c("fail", null);
        AppMethodBeat.o(78519);
      }
    });
    AppMethodBeat.o(78521);
  }
  
  public final int dTs()
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