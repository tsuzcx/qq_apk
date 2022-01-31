package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.a;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.plugin.webview.ui.tools.game.g;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class am
  extends bi<e>
{
  public final void a(Context paramContext, String paramString, bh.a parama) {}
  
  public final void b(a<e>.a parama)
  {
    AppMethodBeat.i(6346);
    ab.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    g.aU(((e)parama.byE).daZ(), System.currentTimeMillis());
    Object localObject1 = parama.byF.bxK;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    ab.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((e)parama.byE).getUrl();
    LinkedList localLinkedList = new LinkedList();
    try
    {
      ab.i("MicroMsg.JsApiPreVerify", "jsItem length %s", new Object[] { Integer.valueOf(((JSONArray)localObject2).length()) });
      if (((JSONArray)localObject2).length() == 0)
      {
        parama.a("checkJsApi:param is empty", null);
        AppMethodBeat.o(6346);
        return;
      }
      int i = 0;
      while (i < ((JSONArray)localObject2).length())
      {
        localObject3 = ((JSONArray)localObject2).getString(i);
        if (!bo.isNullOrNil((String)localObject3)) {
          localLinkedList.add(localObject3);
        }
        i += 1;
      }
      if (bo.isNullOrNil(localException)) {
        break label295;
      }
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.JsApiPreVerify", "exception occur " + localException.getMessage());
      parama.a("", null);
      AppMethodBeat.o(6346);
      return;
    }
    if ((localLinkedList.size() <= 0) || (bo.isNullOrNil((String)localObject1)))
    {
      label295:
      ab.e("MicroMsg.JsApiPreVerify", "handlePreVerify wrong args, %s", new Object[] { localException });
      parama.a("pre_verify_jsapi:fail_invalid_args", null);
      AppMethodBeat.o(6346);
      return;
    }
    localObject2 = new com.tencent.mm.ai.b.a();
    ((com.tencent.mm.ai.b.a)localObject2).fsX = new axk();
    ((com.tencent.mm.ai.b.a)localObject2).fsY = new axl();
    ((com.tencent.mm.ai.b.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((com.tencent.mm.ai.b.a)localObject2).funcId = 1093;
    ((com.tencent.mm.ai.b.a)localObject2).reqCmdId = 0;
    ((com.tencent.mm.ai.b.a)localObject2).respCmdId = 0;
    localObject2 = ((com.tencent.mm.ai.b.a)localObject2).ado();
    Object localObject3 = (axk)((com.tencent.mm.ai.b)localObject2).fsV.fta;
    ((axk)localObject3).url = ((String)localObject1);
    ((axk)localObject3).cwc = localException;
    ((axk)localObject3).xmI = localLinkedList;
    ((axk)localObject3).cqf = str4;
    ((axk)localObject3).xmq = str3;
    ((axk)localObject3).signature = str2;
    ((axk)localObject3).xmr = str5;
    com.tencent.mm.ipcinvoker.wx_extension.b.a((com.tencent.mm.ai.b)localObject2, new a(parama, localException));
    AppMethodBeat.o(6346);
  }
  
  public final int bjL()
  {
    return 0;
  }
  
  public final String name()
  {
    return "preVerifyJSAPI";
  }
  
  static final class a
    implements com.tencent.mm.ipcinvoker.wx_extension.b.a
  {
    private String appId;
    private a<e>.a uTt;
    
    a(a<e>.a parama, String paramString)
    {
      this.uTt = parama;
      this.appId = paramString;
    }
    
    private void BS(String paramString)
    {
      AppMethodBeat.i(6345);
      if (bo.isNullOrNil(paramString)) {
        this.uTt.a("", null);
      }
      for (;;)
      {
        g.aV(((e)this.uTt.byE).daZ(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(6345);
        return;
        this.uTt.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.uTt = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb)
    {
      AppMethodBeat.i(6344);
      if (this.uTt == null)
      {
        AppMethodBeat.o(6344);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        BS(paramString);
        AppMethodBeat.o(6344);
        return;
      }
      paramb = (axl)paramb.fsW.fta;
      if ((paramb == null) || (paramb.xmu == null) || (paramb.xmu.csV != 0))
      {
        BS(paramString);
        AppMethodBeat.o(6344);
        return;
      }
      paramString = ((e)this.uTt.byE).uRD;
      Object localObject = this.appId;
      if ((!bo.isNullOrNil((String)localObject)) && (!bo.isNullOrNil(paramString.uSb.getUrl()))) {
        paramString.uSQ.put(r.agP(paramString.uSb.getUrl()), localObject);
      }
      paramString = new c.d();
      paramString.appId = this.appId;
      paramString.vos = paramb.xmL;
      localObject = ((e)this.uTt.byE).uRD;
      if (!bo.isNullOrNil(((r)localObject).uSb.getUrl())) {
        ((r)localObject).uSR.put(r.agP(((r)localObject).uSb.getUrl()), paramString);
      }
      localObject = paramb.xmK;
      paramString = ((e)this.uTt.byE).dba().agS(((e)this.uTt.byE).getUrl());
      if (paramString == null)
      {
        BS("");
        AppMethodBeat.o(6344);
        return;
      }
      if (!bo.es((List)localObject))
      {
        localObject = ((LinkedList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          cpx localcpx = (cpx)((Iterator)localObject).next();
          c.g localg = c.anm(localcpx.xmo);
          if ((localg != null) && (paramString.MB(localg.dqm()) != localcpx.state)) {
            paramString.a(localg.dqm(), (byte)localcpx.state);
          }
        }
      }
      ((e)this.uTt.byE).dbd().aiE(paramb.xmM);
      BS("");
      AppMethodBeat.o(6344);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.am
 * JD-Core Version:    0.7.0.1
 */