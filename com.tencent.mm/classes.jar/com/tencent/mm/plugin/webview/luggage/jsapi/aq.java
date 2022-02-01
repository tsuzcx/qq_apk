package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
    ad.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.ui.tools.game.g.bG(((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).bQm(), System.currentTimeMillis());
    Object localObject1 = paramb.chh.cgn;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    ad.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)paramb.chg).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      ad.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
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
        if (!bt.isNullOrNil((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      if (bt.isNullOrNil(localException)) {
        break label292;
      }
    }
    catch (Exception localException)
    {
      ad.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
      paramb.a("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (bt.isNullOrNil((String)localObject1)))
    {
      label292:
      ad.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      paramb.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new com.tencent.mm.al.b.a();
    ((com.tencent.mm.al.b.a)localObject2).hNM = new bqr();
    ((com.tencent.mm.al.b.a)localObject2).hNN = new bqs();
    ((com.tencent.mm.al.b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((com.tencent.mm.al.b.a)localObject2).funcId = 1093;
    ((com.tencent.mm.al.b.a)localObject2).hNO = 0;
    ((com.tencent.mm.al.b.a)localObject2).respCmdId = 0;
    localObject2 = ((com.tencent.mm.al.b.a)localObject2).aDC();
    Object localObject3 = (bqr)((com.tencent.mm.al.b)localObject2).hNK.hNQ;
    ((bqr)localObject3).url = ((String)localObject1);
    ((bqr)localObject3).duW = localException;
    ((bqr)localObject3).GLd = localLinkedList;
    ((bqr)localObject3).cUM = str4;
    ((bqr)localObject3).GKK = str3;
    ((bqr)localObject3).signature = str2;
    ((bqr)localObject3).GKL = str5;
    IPCRunCgi.a((com.tencent.mm.al.b)localObject2, new a(paramb, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int ccO()
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
    private com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a DQQ;
    private String appId;
    
    a(com.tencent.luggage.d.b<com.tencent.mm.plugin.webview.luggage.g>.a paramb, String paramString)
    {
      this.DQQ = paramb;
      this.appId = paramString;
    }
    
    private void Pr(String paramString)
    {
      AppMethodBeat.i(78595);
      if (bt.isNullOrNil(paramString)) {
        this.DQQ.a("", null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.ui.tools.game.g.bH(((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).bQm(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.DQQ.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.DQQ = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.b paramb)
    {
      AppMethodBeat.i(78594);
      if (this.DQQ == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        Pr(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramb = (bqs)paramb.hNL.hNQ;
      if ((paramb == null) || (paramb.GKP == null) || (paramb.GKP.dqI != 0))
      {
        Pr(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).DOL;
      Object localObject1 = this.appId;
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(paramString.DOl.getUrl()))) {
        paramString.DQo.put(u.aHc(paramString.DOl.getUrl()), localObject1);
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).DOL;
      localObject1 = this.appId;
      Object localObject2 = paramb.GLi;
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2))) {
        paramString.DQq.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramb);
      localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).DOL;
      if (!bt.isNullOrNil(((u)localObject1).DOl.getUrl())) {
        ((u)localObject1).DQp.put(u.aHc(((u)localObject1).DOl.getUrl()), paramString);
      }
      localObject1 = paramb.GLg;
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePi().aIe(((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).getUrl());
      if (paramString == null)
      {
        Pr("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!bt.hj((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (duo)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.aOb(((duo)localObject2).GKI);
          if ((localg != null) && (paramString.ZB(localg.fgc()) != ((duo)localObject2).state)) {
            paramString.a(localg.fgc(), (byte)((duo)localObject2).state);
          }
        }
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePl() != null)
      {
        ad.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramb.GLi });
        ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePl().Wl(paramb.GLi);
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePm() != null)
      {
        ((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePm().setIcon(bt.nullAsNil(paramb.GLi));
        ((a)com.tencent.mm.kernel.g.ab(a.class)).e(((com.tencent.mm.plugin.webview.luggage.g)this.DQQ.chg).ePm());
      }
      Pr("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */