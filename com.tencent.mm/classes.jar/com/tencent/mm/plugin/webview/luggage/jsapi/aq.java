package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class aq
  extends br<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, bq.a parama) {}
  
  public final void b(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78596);
    ae.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.ui.tools.game.g.bH(((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).bRn(), System.currentTimeMillis());
    Object localObject1 = paramb.chh.cgn;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    ae.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      ae.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
      if (((JSONArray)localObject2).length() == 0)
      {
        paramb.a("checkJsApi:param is empty", null);
        AppMethodBeat.o(78596);
        return;
      }
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getString(i);
        if (!bu.isNullOrNil((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      if (bu.isNullOrNil(localException)) {
        break label292;
      }
    }
    catch (Exception localException)
    {
      ae.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
      paramb.a("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (bu.isNullOrNil((String)localObject1)))
    {
      label292:
      ae.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      paramb.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new com.tencent.mm.ak.b.a();
    ((com.tencent.mm.ak.b.a)localObject2).hQF = new brl();
    ((com.tencent.mm.ak.b.a)localObject2).hQG = new brm();
    ((com.tencent.mm.ak.b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((com.tencent.mm.ak.b.a)localObject2).funcId = 1093;
    ((com.tencent.mm.ak.b.a)localObject2).hQH = 0;
    ((com.tencent.mm.ak.b.a)localObject2).respCmdId = 0;
    localObject2 = ((com.tencent.mm.ak.b.a)localObject2).aDS();
    Object localObject3 = (brl)((com.tencent.mm.ak.b)localObject2).hQD.hQJ;
    ((brl)localObject3).url = ((String)localObject1);
    ((brl)localObject3).dwb = localException;
    ((brl)localObject3).HeE = localLinkedList;
    ((brl)localObject3).cVJ = str4;
    ((brl)localObject3).Hel = str3;
    ((brl)localObject3).signature = str2;
    ((brl)localObject3).Hem = str5;
    IPCRunCgi.a((com.tencent.mm.ak.b)localObject2, new a(paramb, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int ced()
  {
    return 0;
  }
  
  public final String name()
  {
    return "preVerifyJSAPI";
  }
  
  static final class a
    implements IPCRunCgi.a
  {
    private com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a EiQ;
    private String appId;
    
    a(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb, String paramString)
    {
      this.EiQ = paramb;
      this.appId = paramString;
    }
    
    private void PZ(String paramString)
    {
      AppMethodBeat.i(78595);
      if (bu.isNullOrNil(paramString)) {
        this.EiQ.a("", null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.ui.tools.game.g.bI(((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).bRn(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.EiQ.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.EiQ = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.b paramb)
    {
      AppMethodBeat.i(78594);
      if (this.EiQ == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        PZ(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramb = (brm)paramb.hQE.hQJ;
      if ((paramb == null) || (paramb.Heq == null) || (paramb.Heq.drN != 0))
      {
        PZ(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).EgL;
      Object localObject1 = this.appId;
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil(paramString.Egl.getUrl()))) {
        paramString.Eio.put(u.aIw(paramString.Egl.getUrl()), localObject1);
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).EgL;
      localObject1 = this.appId;
      Object localObject2 = paramb.HeJ;
      if ((!bu.isNullOrNil((String)localObject1)) && (!bu.isNullOrNil((String)localObject2))) {
        paramString.Eiq.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramb);
      localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).EgL;
      if (!bu.isNullOrNil(((u)localObject1).Egl.getUrl())) {
        ((u)localObject1).Eip.put(u.aIw(((u)localObject1).Egl.getUrl()), paramString);
      }
      localObject1 = paramb.HeH;
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSU().aJx(((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).getUrl());
      if (paramString == null)
      {
        PZ("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!bu.ht((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dvl)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.aPy(((dvl)localObject2).Hej);
          if ((localg != null) && (paramString.aah(localg.fjS()) != ((dvl)localObject2).state)) {
            paramString.a(localg.fjS(), (byte)((dvl)localObject2).state);
          }
        }
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSX() != null)
      {
        ae.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramb.HeJ });
        ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSX().WX(paramb.HeJ);
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSY() != null)
      {
        ((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSY().setIcon(bu.nullAsNil(paramb.HeJ));
        ((a)com.tencent.mm.kernel.g.ab(a.class)).e(((com.tencent.mm.plugin.webview.luggage.g)this.EiQ.chg).eSY());
      }
      PZ("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */