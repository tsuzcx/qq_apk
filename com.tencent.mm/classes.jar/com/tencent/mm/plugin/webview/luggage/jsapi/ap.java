package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
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
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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
    ac.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    h.bD(((f)parama.bWR).bLL(), System.currentTimeMillis());
    Object localObject1 = parama.bWS.bVY;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    ac.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((f)parama.bWR).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      ac.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
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
        if (!bs.isNullOrNil((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      if (bs.isNullOrNil(localException)) {
        break label292;
      }
    }
    catch (Exception localException)
    {
      ac.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
      parama.a("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (bs.isNullOrNil((String)localObject1)))
    {
      label292:
      ac.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      parama.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new b.a();
    ((b.a)localObject2).hvt = new bmh();
    ((b.a)localObject2).hvu = new bmi();
    ((b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((b.a)localObject2).funcId = 1093;
    ((b.a)localObject2).reqCmdId = 0;
    ((b.a)localObject2).respCmdId = 0;
    localObject2 = ((b.a)localObject2).aAz();
    Object localObject3 = (bmh)((b)localObject2).hvr.hvw;
    ((bmh)localObject3).url = ((String)localObject1);
    ((bmh)localObject3).djj = localException;
    ((bmh)localObject3).FbE = localLinkedList;
    ((bmh)localObject3).cJz = str4;
    ((bmh)localObject3).Fbl = str3;
    ((bmh)localObject3).signature = str2;
    ((bmh)localObject3).Fbm = str5;
    IPCRunCgi.a((b)localObject2, new a(parama, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int bYk()
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
    private com.tencent.luggage.d.a<f>.a Cnw;
    private String appId;
    
    a(com.tencent.luggage.d.a<f>.a parama, String paramString)
    {
      this.Cnw = parama;
      this.appId = paramString;
    }
    
    private void LV(String paramString)
    {
      AppMethodBeat.i(78595);
      if (bs.isNullOrNil(paramString)) {
        this.Cnw.a("", null);
      }
      for (;;)
      {
        h.bE(((f)this.Cnw.bWR).bLL(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.Cnw.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.Cnw = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
    {
      AppMethodBeat.i(78594);
      if (this.Cnw == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        LV(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramb = (bmi)paramb.hvs.hvw;
      if ((paramb == null) || (paramb.Fbq == null) || (paramb.Fbq.dfm != 0))
      {
        LV(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((f)this.Cnw.bWR).ClA;
      Object localObject1 = this.appId;
      if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil(paramString.CkZ.getUrl()))) {
        paramString.CmT.put(t.aBE(paramString.CkZ.getUrl()), localObject1);
      }
      paramString = ((f)this.Cnw.bWR).ClA;
      localObject1 = this.appId;
      Object localObject2 = paramb.FbJ;
      if ((!bs.isNullOrNil((String)localObject1)) && (!bs.isNullOrNil((String)localObject2))) {
        paramString.CmV.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramb);
      localObject1 = ((f)this.Cnw.bWR).ClA;
      if (!bs.isNullOrNil(((t)localObject1).CkZ.getUrl())) {
        ((t)localObject1).CmU.put(t.aBE(((t)localObject1).CkZ.getUrl()), paramString);
      }
      localObject1 = paramb.FbH;
      paramString = ((f)this.Cnw.bWR).eAs().aCC(((f)this.Cnw.bWR).getUrl());
      if (paramString == null)
      {
        LV("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!bs.gY((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (dox)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.aIy(((dox)localObject2).Fbj);
          if ((localg != null) && (paramString.XF(localg.eQY()) != ((dox)localObject2).state)) {
            paramString.a(localg.eQY(), (byte)((dox)localObject2).state);
          }
        }
      }
      if (((f)this.Cnw.bWR).eAv() != null)
      {
        ac.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramb.FbJ });
        ((f)this.Cnw.bWR).eAv().SN(paramb.FbJ);
      }
      if (((f)this.Cnw.bWR).eAw() != null)
      {
        ((f)this.Cnw.bWR).eAw().setIcon(bs.nullAsNil(paramb.FbJ));
        ((com.tencent.mm.plugin.handoff.a.a)g.ab(com.tencent.mm.plugin.handoff.a.a.class)).e(((f)this.Cnw.bWR).eAw());
      }
      LV("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ap
 * JD-Core Version:    0.7.0.1
 */