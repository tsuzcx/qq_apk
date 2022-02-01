package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.f;
import com.tencent.mm.plugin.webview.luggage.p;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.ui.tools.game.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ap
  extends bo<f>
{
  public final void a(Context paramContext, String paramString, bn.a parama) {}
  
  public final void b(com.tencent.luggage.d.a<f>.a parama)
  {
    AppMethodBeat.i(78596);
    ad.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    h.bB(((f)parama.bZU).bEx(), System.currentTimeMillis());
    Object localObject1 = parama.bZV.bZb;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    ad.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((f)parama.bZU).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      ad.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
      if (((JSONArray)localObject2).length() == 0)
      {
        parama.a("checkJsApi:param is empty", null);
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
      parama.a("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (bt.isNullOrNil((String)localObject1)))
    {
      label292:
      ad.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      parama.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new b.a();
    ((b.a)localObject2).gUU = new bip();
    ((b.a)localObject2).gUV = new biq();
    ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((b.a)localObject2).funcId = 1093;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).atI();
    Object localObject3 = (bip)((b)localObject2).gUS.gUX;
    ((bip)localObject3).url = ((String)localObject1);
    ((bip)localObject3).dlB = localException;
    ((bip)localObject3).DGk = localLinkedList;
    ((bip)localObject3).cMo = str4;
    ((bip)localObject3).DFR = str3;
    ((bip)localObject3).signature = str2;
    ((bip)localObject3).DFS = str5;
    IPCRunCgi.a((b)localObject2, new a(parama, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int bQV()
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
    private com.tencent.luggage.d.a<f>.a AVj;
    private String appId;
    
    a(com.tencent.luggage.d.a<f>.a parama, String paramString)
    {
      this.AVj = parama;
      this.appId = paramString;
    }
    
    private void HQ(String paramString)
    {
      AppMethodBeat.i(78595);
      if (bt.isNullOrNil(paramString)) {
        this.AVj.a("", null);
      }
      for (;;)
      {
        h.bC(((f)this.AVj.bZU).bEx(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.AVj.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.AVj = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
    {
      AppMethodBeat.i(78594);
      if (this.AVj == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        HQ(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramb = (biq)paramb.gUT.gUX;
      if ((paramb == null) || (paramb.DFW == null) || (paramb.DFW.dhR != 0))
      {
        HQ(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((f)this.AVj.bZU).ATn;
      Object localObject1 = this.appId;
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil(paramString.ASM.getUrl()))) {
        paramString.AUG.put(t.awm(paramString.ASM.getUrl()), localObject1);
      }
      paramString = ((f)this.AVj.bZU).ATn;
      localObject1 = this.appId;
      Object localObject2 = paramb.DGp;
      if ((!bt.isNullOrNil((String)localObject1)) && (!bt.isNullOrNil((String)localObject2))) {
        paramString.AUI.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramb);
      localObject1 = ((f)this.AVj.bZU).ATn;
      if (!bt.isNullOrNil(((t)localObject1).ASM.getUrl())) {
        ((t)localObject1).AUH.put(t.awm(((t)localObject1).ASM.getUrl()), paramString);
      }
      localObject1 = paramb.DGn;
      paramString = ((f)this.AVj.bZU).ekW().axk(((f)this.AVj.bZU).getUrl());
      if (paramString == null)
      {
        HQ("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!bt.gL((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dji)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.aDh(((dji)localObject2).DFP);
          if ((localg != null) && (paramString.Vw(localg.eBD()) != ((dji)localObject2).state)) {
            paramString.a(localg.eBD(), (byte)((dji)localObject2).state);
          }
        }
      }
      if (((f)this.AVj.bZU).ekZ() != null)
      {
        ad.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramb.DGp });
        ((f)this.AVj.bZU).ekZ().OD(paramb.DGp);
      }
      if (((f)this.AVj.bZU).ela() != null)
      {
        ((f)this.AVj.bZU).ela().setIcon(bt.nullAsNil(paramb.DGp));
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(((f)this.AVj.bZU).ela());
      }
      HQ("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */