package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.luggage.u;
import com.tencent.mm.plugin.webview.luggage.x;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.fwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

public class av
  extends bw<g>
{
  public final void a(Context paramContext, String paramString, bv.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78596);
    Log.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.ui.tools.game.h.ca(((g)paramb.eiY).dgY(), System.currentTimeMillis());
    Object localObject1 = paramb.eiZ.eif;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    Log.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((g)paramb.eiY).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Log.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
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
        if (!Util.isNullOrNil((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      if (Util.isNullOrNil(localException)) {
        break label292;
      }
    }
    catch (Exception localException)
    {
      Log.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
      paramb.a("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (Util.isNullOrNil((String)localObject1)))
    {
      label292:
      Log.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      paramb.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new c.a();
    ((c.a)localObject2).otE = new ddr();
    ((c.a)localObject2).otF = new dds();
    ((c.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((c.a)localObject2).funcId = 1093;
    ((c.a)localObject2).otG = 0;
    ((c.a)localObject2).respCmdId = 0;
    localObject2 = ((c.a)localObject2).bEF();
    Object localObject3 = (ddr)c.b.b(((com.tencent.mm.am.c)localObject2).otB);
    ((ddr)localObject3).url = ((String)localObject1);
    ((ddr)localObject3).appid = localException;
    ((ddr)localObject3).aaJh = localLinkedList;
    ((ddr)localObject3).hhx = str4;
    ((ddr)localObject3).aaIL = str3;
    ((ddr)localObject3).signature = str2;
    ((ddr)localObject3).aaIM = str5;
    IPCRunCgi.a((com.tencent.mm.am.c)localObject2, new a(paramb, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int dgI()
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
    private b<g>.a WIy;
    private String appId;
    
    a(b<g>.a paramb, String paramString)
    {
      this.WIy = paramb;
      this.appId = paramString;
    }
    
    private void aal(String paramString)
    {
      AppMethodBeat.i(78595);
      if (Util.isNullOrNil(paramString)) {
        this.WIy.a("", null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.ui.tools.game.h.cb(((g)this.WIy.eiY).dgY(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.WIy.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.WIy = null;
      this.appId = null;
    }
    
    public final void callback(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.c paramc)
    {
      AppMethodBeat.i(78594);
      if (this.WIy == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        aal(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramc = (dds)c.c.b(paramc.otC);
      if ((paramc == null) || (paramc.aaIR == null) || (paramc.aaIR.hGE != 0))
      {
        aal(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((g)this.WIy.eiY).WGh;
      Object localObject1 = this.appId;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString.WFG.getUrl()))) {
        paramString.WHW.put(x.bkc(paramString.WFG.getUrl()), localObject1);
      }
      paramString = ((g)this.WIy.eiY).WGh;
      localObject1 = this.appId;
      Object localObject2 = paramc.aaJn;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2))) {
        paramString.WHY.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramc);
      localObject1 = ((g)this.WIy.eiY).WGh;
      if (!Util.isNullOrNil(((x)localObject1).WFG.getUrl())) {
        ((x)localObject1).WHX.put(x.bkc(((x)localObject1).WFG.getUrl()), paramString);
      }
      localObject1 = paramc.aaJl;
      paramString = ((g)this.WIy.eiY).iuj().blb(((g)this.WIy.eiY).getUrl());
      if (paramString == null)
      {
        aal("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (fwc)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.bsk(((fwc)localObject2).aaIK);
          if ((localg != null) && (paramString.axr(localg.iPC()) != ((fwc)localObject2).state)) {
            paramString.a(localg.iPC(), (byte)((fwc)localObject2).state);
          }
        }
      }
      if (((g)this.WIy.eiY).ium() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramc.aaJn });
        ((g)this.WIy.eiY).ium().ahT(paramc.aaJn);
      }
      if (((g)this.WIy.eiY).iun() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramc.aaJn });
        paramString = ((g)this.WIy.eiY).iun();
        localObject1 = paramc.aaJn;
        s.u(localObject1, "icon");
        if (paramString.WHQ == null) {
          paramString.ahT((String)localObject1);
        }
      }
      if (((g)this.WIy.eiY).iuo() != null)
      {
        ((g)this.WIy.eiY).iuo().setIcon(Util.nullAsNil(paramc.aaJn));
        ((a)com.tencent.mm.kernel.h.ax(a.class)).e(((g)this.WIy.eiY).iuo());
      }
      aal("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.av
 * JD-Core Version:    0.7.0.1
 */