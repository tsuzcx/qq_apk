package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.bridge.k;
import com.tencent.luggage.d.b;
import com.tencent.luggage.d.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.handoff.a.a;
import com.tencent.mm.plugin.handoff.model.HandOffURL;
import com.tencent.mm.plugin.webview.luggage.g;
import com.tencent.mm.plugin.webview.luggage.q;
import com.tencent.mm.plugin.webview.luggage.t;
import com.tencent.mm.plugin.webview.luggage.w;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.a.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.ezy;
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
  extends bs<g>
{
  public final void a(Context paramContext, String paramString, br.a parama) {}
  
  public final void b(b<g>.a paramb)
  {
    AppMethodBeat.i(78596);
    Log.i("MicroMsg.JsApiPreVerify", "invokeInOwn");
    com.tencent.mm.plugin.webview.ui.tools.game.h.bP(((g)paramb.crg).cDu(), System.currentTimeMillis());
    Object localObject1 = paramb.crh.cqn;
    String str1 = ((JSONObject)localObject1).optString("verifyAppId");
    String str2 = ((JSONObject)localObject1).optString("verifySignature");
    String str3 = ((JSONObject)localObject1).optString("verifyNonceStr");
    String str4 = ((JSONObject)localObject1).optString("verifyTimestamp");
    String str5 = ((JSONObject)localObject1).optString("verifySignType");
    Object localObject2 = ((JSONObject)localObject1).optJSONArray("verifyJsApiList");
    Log.i("MicroMsg.JsApiPreVerify", "appid : %s, %s, %s, %s, %s", new Object[] { str1, str2, str3, str4, str5 });
    localObject1 = ((g)paramb.crg).getUrl();
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
    localObject2 = new d.a();
    ((d.a)localObject2).lBU = new cmz();
    ((d.a)localObject2).lBV = new cna();
    ((d.a)localObject2).uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
    ((d.a)localObject2).funcId = 1093;
    ((d.a)localObject2).lBW = 0;
    ((d.a)localObject2).respCmdId = 0;
    localObject2 = ((d.a)localObject2).bgN();
    Object localObject3 = (cmz)d.b.b(((d)localObject2).lBR);
    ((cmz)localObject3).url = ((String)localObject1);
    ((cmz)localObject3).appid = localException;
    ((cmz)localObject3).TuB = localLinkedList;
    ((cmz)localObject3).fdH = str4;
    ((cmz)localObject3).Tuh = str3;
    ((cmz)localObject3).signature = str2;
    ((cmz)localObject3).Tui = str5;
    IPCRunCgi.a((d)localObject2, new a(paramb, localException));
    AppMethodBeat.o(78596);
  }
  
  public final int cDj()
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
    private b<g>.a PSb;
    private String appId;
    
    a(b<g>.a paramb, String paramString)
    {
      this.PSb = paramb;
      this.appId = paramString;
    }
    
    private void aho(String paramString)
    {
      AppMethodBeat.i(78595);
      if (Util.isNullOrNil(paramString)) {
        this.PSb.a("", null);
      }
      for (;;)
      {
        com.tencent.mm.plugin.webview.ui.tools.game.h.bQ(((g)this.PSb.crg).cDu(), System.currentTimeMillis());
        release();
        AppMethodBeat.o(78595);
        return;
        this.PSb.a(paramString, null);
      }
    }
    
    private void release()
    {
      this.PSb = null;
      this.appId = null;
    }
    
    public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
    {
      AppMethodBeat.i(78594);
      if (this.PSb == null)
      {
        AppMethodBeat.o(78594);
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        aho(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramd = (cna)d.c.b(paramd.lBS);
      if ((paramd == null) || (paramd.Tun == null) || (paramd.Tun.fBP != 0))
      {
        aho(paramString);
        AppMethodBeat.o(78594);
        return;
      }
      paramString = ((g)this.PSb.crg).PPO;
      Object localObject1 = this.appId;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(paramString.PPn.getUrl()))) {
        paramString.PRz.put(w.bks(paramString.PPn.getUrl()), localObject1);
      }
      paramString = ((g)this.PSb.crg).PPO;
      localObject1 = this.appId;
      Object localObject2 = paramd.TuH;
      if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil((String)localObject2))) {
        paramString.PRB.put(localObject1, localObject2);
      }
      paramString = new a.d(this.appId, paramd);
      localObject1 = ((g)this.PSb.crg).PPO;
      if (!Util.isNullOrNil(((w)localObject1).PPn.getUrl())) {
        ((w)localObject1).PRA.put(w.bks(((w)localObject1).PPn.getUrl()), paramString);
      }
      localObject1 = paramd.TuF;
      paramString = ((g)this.PSb.crg).gUA().bly(((g)this.PSb.crg).getUrl());
      if (paramString == null)
      {
        aho("");
        AppMethodBeat.o(78594);
        return;
      }
      if (!Util.isNullOrNil((List)localObject1))
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ezy)((Iterator)localObject1).next();
          c.g localg = com.tencent.mm.protocal.c.bst(((ezy)localObject2).Tug);
          if ((localg != null) && (paramString.arj(localg.hoG()) != ((ezy)localObject2).state)) {
            paramString.a(localg.hoG(), (byte)((ezy)localObject2).state);
          }
        }
      }
      if (((g)this.PSb.crg).gUD() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramd.TuH });
        ((g)this.PSb.crg).gUD().aox(paramd.TuH);
      }
      if (((g)this.PSb.crg).gUE() != null)
      {
        Log.i("MicroMsg.JsApiPreVerify", "updateFloatBallIcon:%s", new Object[] { paramd.TuH });
        paramString = ((g)this.PSb.crg).gUE();
        localObject1 = paramd.TuH;
        p.k(localObject1, "icon");
        if (paramString.PRs == null) {
          paramString.aox((String)localObject1);
        }
      }
      if (((g)this.PSb.crg).gUF() != null)
      {
        ((g)this.PSb.crg).gUF().setIcon(Util.nullAsNil(paramd.TuH));
        ((a)com.tencent.mm.kernel.h.ae(a.class)).e(((g)this.PSb.crg).gUF());
      }
      aho("");
      AppMethodBeat.o(78594);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ar
 * JD-Core Version:    0.7.0.1
 */