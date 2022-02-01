package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.epn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import org.json.JSONArray;
import org.json.JSONObject;

public class ar
  extends bs<com.tencent.mm.plugin.webview.luggage.g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb)
  {
    AppMethodBeat.i(78596);
    Log.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.ui.tools.game.g.bI(((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).coX(), System.currentTimeMillis());
    Object localObject1 = paramb.ctb.csi;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    Log.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)paramb.cta).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      Log.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
      if (((JSONArray)localObject2).length() == 0)
      {
        paramb.c("checkJsApi:param is empty", null);
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
      paramb.c("", null);
      AppMethodBeat.o(78596);
      return;
    }
    if ((localLinkedList.size() <= 0) || (Util.isNullOrNil((String)localObject1)))
    {
      label292:
      Log.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      paramb.c("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(78596);
      return;
    }
    localObject2 = new d.a();
    ((d.a)localObject2).iLN = new cef();
    ((d.a)localObject2).iLO = new ceg();
    ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((d.a)localObject2).funcId = 1093;
    ((d.a)localObject2).iLP = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject2 = ((d.a)localObject2).aXF();
    Object localObject3 = (cef)((d)localObject2).iLK.iLR;
    ((cef)localObject3).url = ((String)localObject1);
    ((cef)localObject3).dNI = localException;
    ((cef)localObject3).MjM = localLinkedList;
    ((cef)localObject3).dmc = str4;
    ((cef)localObject3).Mju = str3;
    ((cef)localObject3).signature = str2;
    ((cef)localObject3).Mjv = str5;
    IPCRunCgi.a((d)localObject2, new a(paramb, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int dTs()
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
    private b<com.tencent.mm.plugin.webview.luggage.g>.a IVL;
    private String appId;
    
    a(b<com.tencent.mm.plugin.webview.luggage.g>.a paramb, String paramString)
    {
      this.IVL = paramb;
      this.appId = paramString;
    }
    
    private void ZA(String paramString)
    {
      AppMethodBeat.i(78595);
      if (Util.isNullOrNil(paramString)) {
        this.IVL.c("", null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.ui.tools.game.g.bJ(((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).coX(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.IVL.c(paramString, null);
      }
    }
    
    private void release()
    {
      this.IVL = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(78594);
      if (this.IVL == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        ZA(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramd = (ceg)paramd.iLL.iLR;
      if ((paramd == null) || (paramd.Mjz == null) || (paramd.Mjz.dIZ != 0))
      {
        ZA(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).ITw;
      Object localObject1 = this.appId;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString.ISU.getUrl()))) {
        paramString.IVj.put(w.aYy(paramString.ISU.getUrl()), localObject1);
      }
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).ITw;
      localObject1 = this.appId;
      Object localObject2 = paramd.MjR;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2))) {
        paramString.IVl.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramd);
      localObject1 = ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).ITw;
      if (!Util.isNullOrNil(((w)localObject1).ISU.getUrl())) {
        ((w)localObject1).IVk.put(w.aYy(((w)localObject1).ISU.getUrl()), paramString);
      }
      localObject1 = paramd.MjP;
      paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbF().aZE(((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).getUrl());
      if (paramString == null)
      {
        ZA("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (epn)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.bgb(((epn)localObject2).Mjs);
          if ((localg != null) && (paramString.aiW(localg.gtt()) != ((epn)localObject2).state)) {
            paramString.a(localg.gtt(), (byte)((epn)localObject2).state);
          }
        }
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbI() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramd.MjR });
        ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbI().agS(paramd.MjR);
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbJ() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramd.MjR });
        paramString = ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbJ();
        localObject1 = paramd.MjR;
        p.h(localObject1, "icon");
        if (paramString.IVc == null) {
          paramString.agS((String)localObject1);
        }
      }
      if (((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbK() != null)
      {
        ((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbK().setIcon(Util.nullAsNil(paramd.MjR));
        ((a)com.tencent.mm.kernel.g.af(a.class)).e(((com.tencent.mm.plugin.webview.luggage.g)this.IVL.cta).gbK());
      }
      ZA("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */