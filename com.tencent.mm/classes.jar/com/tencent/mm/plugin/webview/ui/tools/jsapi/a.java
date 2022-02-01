package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.cmq;
import com.tencent.mm.protocal.protobuf.cmr;
import com.tencent.mm.protocal.protobuf.cms;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cmz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cnd;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.cns;
import com.tencent.mm.protocal.protobuf.ezy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements i
{
  private f POP;
  private final HashMap<String, d> PRA;
  final int PUm;
  private final HashMap<String, cmq> QpK;
  private final HashMap<String, String> QpL;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.QpK = new HashMap();
    this.QpL = new HashMap();
    this.PRA = new HashMap();
    this.PUm = paramInt;
    AppMethodBeat.o(81013);
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString, final com.tencent.mm.plugin.webview.model.t paramt)
  {
    AppMethodBeat.i(81016);
    if (paramt == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      AppMethodBeat.o(81016);
      return;
    }
    int j = 0;
    int i = j;
    if (paramt.gVs() != null)
    {
      i = j;
      if (paramt.gVs().Tun != null) {
        i = paramt.gVs().Tun.fBP;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.PUk.a(a.a.a.QpQ, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (Util.isNullOrNil(paramt.PUl))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.gVs();
    if ((paramString == null) || (paramString.Tun == null))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.Tun.fBP != 0)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Tun.fBP), paramString.Tun.errmsg });
      paramt.PUk.a(a.a.a.QpQ, paramString.Tun.errmsg, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.gVr() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.gVr().Tuk)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.Tuq != null) {
        break;
      }
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Tuq.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (cns)paramString.next();
      if (((cns)localObject).Tvo == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((cns)localObject).Tvo.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!Util.isNullOrNil(str))
          {
            cmq localcmq = new cmq();
            localcmq.Tug = str;
            localcmq.RMr = ((cns)localObject).Tvn;
            localcmq.auth_desc = ((cns)localObject).JdV;
            this.QpK.put(localcmq.Tug + paramt.url, localcmq);
          }
        }
      }
    }
    label560:
    if (paramString.Tuo == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.PUk.a(a.a.a.QpQ, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Tuo.iterator();
    while (paramString.hasNext())
    {
      localObject = (cmq)paramString.next();
      if (!Util.isNullOrNil(((cmq)localObject).Tug)) {
        this.QpK.put(((cmq)localObject).Tug + paramt.url, localObject);
      }
    }
    paramString = (cmq)this.QpK.get(paramt.PUl + paramt.url);
    if (paramString == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.PUl, paramt.url });
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.RMr == 1)
    {
      paramt.PUk.a(a.a.a.QpP, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (this.context == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(paramt, paramInt2, paramString);
      AppMethodBeat.o(81016);
      return;
    }
    WebViewStubTempUI.a(this.context, this.POP, Util.nullAsNil(paramString.auth_desc), "", this.context.getString(c.i.js_oauth_yes), this.context.getString(c.i.js_oauth_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81006);
        Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        a.a(a.this, paramt, paramInt2, paramString);
        AppMethodBeat.o(81006);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81007);
        Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramt.PUk.a(a.a.a.QpR, "cancel", null, paramInt2, paramt.gVs().Tun.fBP);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private void a(com.tencent.mm.plugin.webview.model.t paramt, int paramInt, cmq paramcmq)
  {
    AppMethodBeat.i(81017);
    cmr localcmr = paramt.gVr();
    Object localObject = paramt.gVs();
    if (localcmr == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt, paramt.gVs().Tun.fBP);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.PUk.a(a.a.a.QpQ, null, null, paramInt, paramt.gVs().Tun.fBP);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.h.aGY().a(1096, this);
    localObject = ((cms)localObject).Tuq;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      cns localcns;
      while (localIterator.hasNext())
      {
        localcns = (cns)localIterator.next();
        if (localcns != null)
        {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localcns.Tvo, localcns.scope, localcns.JdV, Integer.valueOf(localcns.Tvn), localcmr.Tug });
          localcns.Tvn = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localcns = (cns)localIterator.next();
        if (localcns != null) {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localcns.Tvo, localcns.scope, localcns.JdV, Integer.valueOf(localcns.Tvn), localcmr.Tug });
        }
      }
    }
    int i = ((cmr)d.b.b(((d)paramt.getReqResp()).lBR)).Tum;
    paramcmq = new w(paramcmq, localcmr.url, localcmr.Tul, localcmr.jUi, localcmr.Tug, localcmr.fdH, localcmr.Tuh, localcmr.signature, localcmr.Tui, localcmr.Tuj, localcmr.Tuk, (LinkedList)localObject, this.PUm, i);
    com.tencent.mm.kernel.h.aGY().a(paramcmq, 0);
    paramt.PUk.a(a.a.a.QpP, null, null, paramInt, paramt.gVs().Tun.fBP);
    AppMethodBeat.o(81017);
  }
  
  private static String bks(String paramString)
  {
    AppMethodBeat.i(81018);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(81018);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(81018);
    return paramString;
  }
  
  final void a(Context paramContext, f paramf)
  {
    this.context = paramContext;
    this.POP = paramf;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt1, n paramn, int paramInt2, a parama)
  {
    AppMethodBeat.i(227008);
    if (paramn != null) {}
    for (String str2 = paramn.function;; str2 = "")
    {
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.QpS, null, null, 0, 0);
        AppMethodBeat.o(227008);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (Util.isNullOrNil(paramString1)) || (paramn == null) || (paramJsapiPermissionWrapper.RBg == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.QpQ, "localParameters", null, 0, 0);
          AppMethodBeat.o(227008);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.arj(paramInt1);
      Log.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt1), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.QpL.get(paramString1);
      if (Util.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paramn.params.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paramn.POw;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.QpQ, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          Log.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(227008);
          return;
        case 1: 
          parama.a(a.a.a.QpP, null, null, 0, 0);
          AppMethodBeat.o(227008);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.QpP, null, null, 0, 0);
            AppMethodBeat.o(227008);
            return;
          }
          parama.a(a.a.a.QpS, null, null, 0, 0);
          AppMethodBeat.o(227008);
          return;
        case 0: 
          parama.a(a.a.a.QpS, null, null, 0, 0);
          AppMethodBeat.o(227008);
          return;
        case 4: 
          localObject2 = (String)paramn.params.get("url");
          localObject1 = paramString1;
          if (!Util.isEqual((String)localObject2, paramString1)) {
            if (((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vzj, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            localObject1 = paramString1;
            if (paramInt1 != 0)
            {
              com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1200L, 103L, 1L, false);
              Log.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (cmq)this.QpK.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.RMr != 1) {
              break;
            }
            parama.a(a.a.a.QpP, null, null, 0, 0);
            AppMethodBeat.o(227008);
            return;
          }
        }
        paramString1 = (String)paramn.params.get("verifySignature");
        localObject1 = (String)paramn.params.get("verifyNonceStr");
        Object localObject2 = (String)paramn.params.get("verifyTimestamp");
        String str1 = (String)paramn.params.get("verifySignType");
        String str4 = (String)paramn.params.get("scope");
        String str3 = (String)paramn.params.get("addrSign");
        Log.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt1 = 0;
        if ((Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(str3)))
        {
          paramInt1 = 1;
          paramJsapiPermissionWrapper = (String)paramn.params.get("appId");
          localObject2 = (String)paramn.params.get("addrSign");
          str1 = (String)paramn.params.get("signType");
          paramString1 = (String)paramn.params.get("timeStamp");
          localObject1 = (String)paramn.params.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = n.a.aY(paramn.params);
          paramn = str3;
          if (localJSONObject != null) {
            paramn = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new com.tencent.mm.plugin.webview.model.t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paramn, paramInt1, str4, this.PUm, paramInt2);
            com.tencent.mm.kernel.h.aGY().a(1095, this);
            com.tencent.mm.kernel.h.aGY().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(227008);
            return;
            if (!Util.isNullOrNil(paramString1))
            {
              paramInt1 = 2;
              str3 = paramString1;
              paramString1 = (String)localObject2;
              localObject2 = str3;
            }
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paramn, this.PUm, paramInt2);
            com.tencent.mm.kernel.h.aGY().a(1094, this);
            com.tencent.mm.kernel.h.aGY().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(227008);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final String bmL(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.QpL.get(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      String str3 = bks(paramString);
      Log.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = (String)this.QpL.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d bmM(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.PRA.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = bks(paramString);
      locald1 = (d)this.PRA.get(paramString);
    }
    AppMethodBeat.o(81012);
    return locald1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(81014);
    Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramq.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramq instanceof b))
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(81014);
      return;
    }
    if (((b)paramq).gSo() != this.PUm)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.PUm), Integer.valueOf(((b)paramq).gSo()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramq.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.h.aGY().b(1093, this);
      paramq = (u)paramq;
      if (paramq == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramq.PUk == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramq.gVt() != null)
      {
        i = j;
        if (paramq.gVt().Tun != null) {
          i = paramq.gVt().Tun.fBP;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramq.PUk.a(a.a.a.QpQ, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramq.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      cna localcna = paramq.gVt();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramq.rr == null)
      {
        paramString = null;
        if ((localcna != null) && (!Util.isNullOrNil(paramq.pHO)) && (paramString != null) && (!Util.isNullOrNil(paramString.appid))) {
          break label498;
        }
        if (localcna != null) {
          break label486;
        }
        bool1 = true;
        bool3 = Util.isNullOrNil(paramq.pHO);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramq.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (cmz)d.b.b(paramq.rr.lBR);
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localcna.Tun == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramq.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localcna.Tun.fBP != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localcna.Tun.fBP), localcna.Tun.errmsg });
        paramq.PUk.a(a.a.a.QpQ, localcna.Tun.errmsg, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramq.PUk.bmN(localcna.TuH);
      this.QpL.put(bks(paramString.url), paramString.appid);
      d locald = new d(paramString.appid, localcna);
      this.PRA.put(bks(paramString.url), locald);
      this.PRA.put(bks(paramString.Tul), locald);
      paramq.PUk.a(a.a.a.QpP, null, localcna.TuF, paramInt2, i);
      Log.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.h.aGY().b(1095, this);
      a(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.webview.model.t)paramq);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.h.aGY().b(1094, this);
      paramq = (v)paramq;
      if (paramq == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(157L, 24L, 1L, false);
      if ((paramq.gVu() == null) || (paramq.gVu().Tun == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramq.gVu().Tun.fBP;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramq.PUk.a(a.a.a.QpQ, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramq.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramq.gVu();
      if ((paramString == null) || (paramString.Tun == null))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramq.PUk.a(a.a.a.QpQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Tun.fBP != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Tun.fBP), paramString.Tun.errmsg });
        paramq.PUk.a(a.a.a.QpQ, paramString.Tun.errmsg, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.TuJ;
      if (paramString == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramq.PUk.a(a.a.a.QpQ, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.UAb != 1)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.UAb) });
        paramq.PUk.a(a.a.a.QpQ, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramq.PUk.a(a.a.a.QpP, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.h.aGY().b(1096, this);
        paramString = (w)paramq;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (cnd)d.b.b(paramString.rr.lBR))
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.Tug });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.bst(Util.nullAsNil(paramString.Tug)) == null)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramq = ((w)paramq).PUn;
        paramq.RMr = 1;
        this.QpK.put(paramString.Tug + paramString.url, paramq);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<ezy> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void bmN(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        QpP = new a("RET_OK", 0, 0);
        QpQ = new a("RET_FAIL", 1, -1);
        QpR = new a("RET_REJECT", 2, -2);
        QpS = new a("RET_ACCESS_DENIED", 3, -3);
        QpT = new a[] { QpP, QpQ, QpR, QpS };
        AppMethodBeat.o(81010);
      }
      
      private a(int paramInt)
      {
        this.code = paramInt;
      }
      
      public final int getCode()
      {
        return this.code;
      }
    }
  }
  
  public static abstract interface b
  {
    public abstract int gSo();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean QpU = true;
    
    public final void Dl(boolean paramBoolean)
    {
      this.QpU = paramBoolean;
    }
    
    public void bmN(String paramString) {}
    
    public boolean haH()
    {
      return this.QpU;
    }
  }
  
  public static final class d
  {
    public List<String> QpV;
    public List<cnf> QpW;
    public String appId;
    
    public d(String paramString, cna paramcna)
    {
      this.appId = paramString;
      this.QpV = paramcna.TuG;
      this.QpW = paramcna.TuI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */