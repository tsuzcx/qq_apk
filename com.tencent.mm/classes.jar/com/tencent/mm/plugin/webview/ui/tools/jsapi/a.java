package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.webview.c.i;
import com.tencent.mm.plugin.webview.jsapi.p.a;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.dde;
import com.tencent.mm.protocal.protobuf.ddf;
import com.tencent.mm.protocal.protobuf.ddg;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddr;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.protocal.protobuf.ddu;
import com.tencent.mm.protocal.protobuf.ddv;
import com.tencent.mm.protocal.protobuf.ddx;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.fwc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.am.h
{
  private f WFb;
  private final HashMap<String, d> WHX;
  final int WKY;
  private final HashMap<String, dde> XhY;
  private final HashMap<String, String> XhZ;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.XhY = new HashMap();
    this.XhZ = new HashMap();
    this.WHX = new HashMap();
    this.WKY = paramInt;
    AppMethodBeat.o(81013);
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString, final t paramt)
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
    if (paramt.ivd() != null)
    {
      i = j;
      if (paramt.ivd().aaIR != null) {
        i = paramt.ivd().aaIR.hGE;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.WKW.a(a.a.a.Xie, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (Util.isNullOrNil(paramt.WKX))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.ivd();
    if ((paramString == null) || (paramString.aaIR == null))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.aaIR.hGE != 0)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.aaIR.hGE), paramString.aaIR.errmsg });
      paramt.WKW.a(a.a.a.Xie, paramString.aaIR.errmsg, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.ivc() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.ivc().aaIO)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.aaIU != null) {
        break;
      }
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.aaIU.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (dek)paramString.next();
      if (((dek)localObject).aaJU == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((dek)localObject).aaJU.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!Util.isNullOrNil(str))
          {
            dde localdde = new dde();
            localdde.aaIK = str;
            localdde.YJF = ((dek)localObject).aaJT;
            localdde.auth_desc = ((dek)localObject).Poo;
            this.XhY.put(localdde.aaIK + paramt.url, localdde);
          }
        }
      }
    }
    label560:
    if (paramString.aaIS == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.WKW.a(a.a.a.Xie, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.aaIS.iterator();
    while (paramString.hasNext())
    {
      localObject = (dde)paramString.next();
      if (!Util.isNullOrNil(((dde)localObject).aaIK)) {
        this.XhY.put(((dde)localObject).aaIK + paramt.url, localObject);
      }
    }
    paramString = (dde)this.XhY.get(paramt.WKX + paramt.url);
    if (paramString == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.WKX, paramt.url });
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.YJF == 1)
    {
      paramt.WKW.a(a.a.a.Xid, null, null, paramInt2, i);
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
    WebViewStubTempUI.a(this.context, this.WFb, Util.nullAsNil(paramString.aaAp), Util.nullAsNil(paramString.auth_desc), this.context.getString(c.i.js_oauth_yes), this.context.getString(c.i.js_oauth_no), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        paramt.WKW.a(a.a.a.Xif, "cancel", null, paramInt2, paramt.ivd().aaIR.hGE);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private void a(t paramt, int paramInt, dde paramdde)
  {
    AppMethodBeat.i(81017);
    ddf localddf = paramt.ivc();
    Object localObject = paramt.ivd();
    if (localddf == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt, paramt.ivd().aaIR.hGE);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.WKW.a(a.a.a.Xie, null, null, paramInt, paramt.ivd().aaIR.hGE);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.h.aZW().a(1096, this);
    localObject = ((ddg)localObject).aaIU;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      dek localdek;
      while (localIterator.hasNext())
      {
        localdek = (dek)localIterator.next();
        if (localdek != null)
        {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localdek.aaJU, localdek.scope, localdek.Poo, Integer.valueOf(localdek.aaJT), localddf.aaIK });
          localdek.aaJT = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localdek = (dek)localIterator.next();
        if (localdek != null) {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localdek.aaJU, localdek.scope, localdek.Poo, Integer.valueOf(localdek.aaJT), localddf.aaIK });
        }
      }
    }
    int i = ((ddf)c.b.b(((com.tencent.mm.am.c)paramt.getReqResp()).otB)).aaIQ;
    paramdde = new w(paramdde, localddf.url, localddf.aaIP, localddf.muA, localddf.aaIK, localddf.hhx, localddf.aaIL, localddf.signature, localddf.aaIM, localddf.aaIN, localddf.aaIO, (LinkedList)localObject, this.WKY, i);
    com.tencent.mm.kernel.h.aZW().a(paramdde, 0);
    paramt.WKW.a(a.a.a.Xid, null, null, paramInt, paramt.ivd().aaIR.hGE);
    AppMethodBeat.o(81017);
  }
  
  private static String bkc(String paramString)
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
    this.WFb = paramf;
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt1, com.tencent.mm.plugin.webview.jsapi.p paramp, int paramInt2, a parama)
  {
    AppMethodBeat.i(297453);
    String str1 = "";
    if (paramp != null) {
      str1 = paramp.function;
    }
    if (Util.isNullOrNil(str1))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
      parama.a(a.a.a.Xig, null, null, 0, 0);
      AppMethodBeat.o(297453);
      return;
    }
    if ((paramJsapiPermissionWrapper == null) || (Util.isNullOrNil(paramString1)) || (paramp == null) || (paramJsapiPermissionWrapper.YxJ == null))
    {
      if (paramJsapiPermissionWrapper != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str1, Boolean.valueOf(bool) });
        parama.a(a.a.a.Xie, "localParameters", null, 0, 0);
        AppMethodBeat.o(297453);
        return;
      }
    }
    int i = paramJsapiPermissionWrapper.axr(paramInt1);
    Log.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str1, Integer.valueOf(paramInt1), Integer.valueOf(i), paramString1 });
    paramJsapiPermissionWrapper = (String)this.XhZ.get(paramString1);
    if (Util.isNullOrNil(paramJsapiPermissionWrapper)) {
      paramJsapiPermissionWrapper = (String)paramp.params.get("verifyAppId");
    }
    for (;;)
    {
      Object localObject1 = paramp.WEJ;
      ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
      ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
      String str2;
      switch (i)
      {
      default: 
        parama.a(a.a.a.Xie, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
        Log.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
        AppMethodBeat.o(297453);
        return;
      case 1: 
        parama.a(a.a.a.Xid, null, null, 0, 0);
        AppMethodBeat.o(297453);
        return;
      case 2: 
        if (str1.equals("preVerifyJSAPI"))
        {
          parama.a(a.a.a.Xid, null, null, 0, 0);
          AppMethodBeat.o(297453);
          return;
        }
        parama.a(a.a.a.Xig, null, null, 0, 0);
        AppMethodBeat.o(297453);
        return;
      case 0: 
        parama.a(a.a.a.Xig, null, null, 0, 0);
        AppMethodBeat.o(297453);
        return;
      case 4: 
        str2 = (String)paramp.params.get("url");
        paramString1 = (dde)this.XhY.get(str1 + str2);
        if ((paramString1 != null) && (paramString1.YJF == 1))
        {
          parama.a(a.a.a.Xid, null, null, 0, 0);
          AppMethodBeat.o(297453);
          return;
        }
        break;
      }
      for (;;)
      {
        paramString1 = (String)paramp.params.get("verifySignature");
        Object localObject2 = (String)paramp.params.get("verifyNonceStr");
        localObject1 = (String)paramp.params.get("verifyTimestamp");
        String str4 = (String)paramp.params.get("verifySignType");
        String str5 = (String)paramp.params.get("scope");
        String str3 = (String)paramp.params.get("addrSign");
        Log.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt1 = 0;
        if ((Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(str3)))
        {
          paramInt1 = 1;
          paramJsapiPermissionWrapper = (String)paramp.params.get("appId");
          localObject2 = (String)paramp.params.get("addrSign");
          str3 = (String)paramp.params.get("signType");
          paramString1 = (String)paramp.params.get("timeStamp");
          localObject1 = (String)paramp.params.get("nonceStr");
        }
        for (;;)
        {
          str4 = null;
          JSONObject localJSONObject = p.a.bp(paramp.params);
          paramp = str4;
          if (localJSONObject != null) {
            paramp = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new t(parama, str2, paramString2, paramJsapiPermissionWrapper, str1, paramString1, (String)localObject1, (String)localObject2, str3, paramp, paramInt1, str5, this.WKY, paramInt2);
            com.tencent.mm.kernel.h.aZW().a(1095, this);
            com.tencent.mm.kernel.h.aZW().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(297453);
            return;
            if (!Util.isNullOrNil(paramString1))
            {
              paramInt1 = 2;
              str3 = paramString1;
              paramString1 = (String)localObject1;
              localObject1 = localObject2;
              localObject2 = str3;
              str3 = str4;
            }
          }
          else
          {
            if (i != 3) {
              break;
            }
            paramJsapiPermissionWrapper = new v(parama, str2, paramString2, paramJsapiPermissionWrapper, str1, paramString1, (String)localObject1, (String)localObject2, str3, paramp, this.WKY, paramInt2);
            com.tencent.mm.kernel.h.aZW().a(1094, this);
            com.tencent.mm.kernel.h.aZW().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(297453);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject1;
          localObject1 = localObject2;
          localObject2 = str3;
          str3 = str4;
        }
        str2 = paramString1;
      }
    }
  }
  
  public final String bmp(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.XhZ.get(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      String str3 = bkc(paramString);
      Log.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = (String)this.XhZ.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d bmq(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.WHX.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = bkc(paramString);
      locald1 = (d)this.WHX.get(paramString);
    }
    AppMethodBeat.o(81012);
    return locald1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(81014);
    Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramp.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramp instanceof b))
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(81014);
      return;
    }
    if (((b)paramp).irL() != this.WKY)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.WKY), Integer.valueOf(((b)paramp).irL()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramp.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.h.aZW().b(1093, this);
      paramp = (u)paramp;
      if (paramp == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramp.WKW == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramp.ive() != null)
      {
        i = j;
        if (paramp.ive().aaIR != null) {
          i = paramp.ive().aaIR.hGE;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramp.WKW.a(a.a.a.Xie, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramp.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      dds localdds = paramp.ive();
      boolean bool1;
      label391:
      boolean bool3;
      if (paramp.rr == null)
      {
        paramString = null;
        if ((localdds != null) && (!Util.isNullOrNil(paramp.sML)) && (paramString != null) && (!Util.isNullOrNil(paramString.appid))) {
          break label499;
        }
        if (localdds != null) {
          break label487;
        }
        bool1 = true;
        bool3 = Util.isNullOrNil(paramp.sML);
        if (paramString != null) {
          break label493;
        }
      }
      label487:
      label493:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramp.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (ddr)c.b.b(paramp.rr.otB);
        break;
        bool1 = false;
        break label391;
      }
      label499:
      if (localdds.aaIR == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramp.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localdds.aaIR.hGE != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localdds.aaIR.hGE), localdds.aaIR.errmsg });
        paramp.WKW.a(a.a.a.Xie, localdds.aaIR.errmsg, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramp.WKW.bmr(localdds.aaJn);
      this.XhZ.put(bkc(paramString.url), paramString.appid);
      d locald = new d(paramString.appid, localdds);
      this.WHX.put(bkc(paramString.url), locald);
      this.WHX.put(bkc(paramString.aaIP), locald);
      paramp.WKW.a(a.a.a.Xid, null, localdds.aaJl, paramInt2, i);
      Log.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.h.aZW().b(1095, this);
      a(paramInt1, paramInt2, paramString, (t)paramp);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.h.aZW().b(1094, this);
      paramp = (v)paramp;
      if (paramp == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(157L, 24L, 1L, false);
      if ((paramp.ivf() == null) || (paramp.ivf().aaIR == null)) {
        break label1477;
      }
    }
    label1477:
    for (i = paramp.ivf().aaIR.hGE;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramp.WKW.a(a.a.a.Xie, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramp.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramp.ivf();
      if ((paramString == null) || (paramString.aaIR == null))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramp.WKW.a(a.a.a.Xie, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.aaIR.hGE != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.aaIR.hGE), paramString.aaIR.errmsg });
        paramp.WKW.a(a.a.a.Xie, paramString.aaIR.errmsg, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.aaJp;
      if (paramString == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramp.WKW.a(a.a.a.Xie, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.abUe != 1)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.abUe) });
        paramp.WKW.a(a.a.a.Xie, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramp.WKW.a(a.a.a.Xid, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.h.aZW().b(1096, this);
        paramString = (w)paramp;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (ddv)c.b.b(paramString.rr.otB))
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.aaIK });
          AppMethodBeat.o(81014);
          return;
        }
        if (com.tencent.mm.protocal.c.bsk(Util.nullAsNil(paramString.aaIK)) == null)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramp = ((w)paramp).WKZ;
        paramp.YJF = 1;
        this.XhY.put(paramString.aaIK + paramString.url, paramp);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<fwc> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void bmr(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        Xid = new a("RET_OK", 0, 0);
        Xie = new a("RET_FAIL", 1, -1);
        Xif = new a("RET_REJECT", 2, -2);
        Xig = new a("RET_ACCESS_DENIED", 3, -3);
        Xih = new a[] { Xid, Xie, Xif, Xig };
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
    public abstract int irL();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean Xii = true;
    
    public final void IT(boolean paramBoolean)
    {
      this.Xii = paramBoolean;
    }
    
    public void bmr(String paramString) {}
    
    public boolean iAT()
    {
      return this.Xii;
    }
  }
  
  public static final class d
  {
    public List<String> Xij;
    public List<ddx> Xik;
    public String appId;
    
    public d(String paramString, dds paramdds)
    {
      this.appId = paramString;
      this.Xij = paramdds.aaJm;
      this.Xik = paramdds.aaJo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */