package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.d.n;
import com.tencent.mm.plugin.webview.d.n.a;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.cdw;
import com.tencent.mm.protocal.protobuf.cdx;
import com.tencent.mm.protocal.protobuf.cdy;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cef;
import com.tencent.mm.protocal.protobuf.ceg;
import com.tencent.mm.protocal.protobuf.cei;
import com.tencent.mm.protocal.protobuf.cej;
import com.tencent.mm.protocal.protobuf.cel;
import com.tencent.mm.protocal.protobuf.cey;
import com.tencent.mm.protocal.protobuf.epn;
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
  private f ISw;
  private final HashMap<String, d> IVk;
  final int IXV;
  private final HashMap<String, cdw> Jsn;
  private final HashMap<String, String> Jso;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.Jsn = new HashMap();
    this.Jso = new HashMap();
    this.IVk = new HashMap();
    this.IXV = paramInt;
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
    if (paramt.gcx() != null)
    {
      i = j;
      if (paramt.gcx().Mjz != null) {
        i = paramt.gcx().Mjz.dIZ;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.IXT.a(a.a.a.Jst, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (Util.isNullOrNil(paramt.IXU))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.gcx();
    if ((paramString == null) || (paramString.Mjz == null))
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.Mjz.dIZ != 0)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Mjz.dIZ), paramString.Mjz.dJa });
      paramt.IXT.a(a.a.a.Jst, paramString.Mjz.dJa, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.gcw() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.gcw().Mjx)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.MjC != null) {
        break;
      }
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.MjC.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (cey)paramString.next();
      if (((cey)localObject).Mkw == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((cey)localObject).Mkw.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!Util.isNullOrNil(str))
          {
            cdw localcdw = new cdw();
            localcdw.Mjs = str;
            localcdw.KLv = ((cey)localObject).Mkv;
            localcdw.Mjt = ((cey)localObject).CYp;
            this.Jsn.put(localcdw.Mjs + paramt.url, localcdw);
          }
        }
      }
    }
    label560:
    if (paramString.MjA == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.IXT.a(a.a.a.Jst, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.MjA.iterator();
    while (paramString.hasNext())
    {
      localObject = (cdw)paramString.next();
      if (!Util.isNullOrNil(((cdw)localObject).Mjs)) {
        this.Jsn.put(((cdw)localObject).Mjs + paramt.url, localObject);
      }
    }
    paramString = (cdw)this.Jsn.get(paramt.IXU + paramt.url);
    if (paramString == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.IXU, paramt.url });
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.KLv == 1)
    {
      paramt.IXT.a(a.a.a.Jss, null, null, paramInt2, i);
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
    WebViewStubTempUI.a(this.context, this.ISw, Util.nullAsNil(paramString.Mjt), "", this.context.getString(2131762027), this.context.getString(2131762026), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81006);
        Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        a.this.a(paramt, paramInt2, paramString);
        AppMethodBeat.o(81006);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81007);
        Log.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramt.IXT.a(a.a.a.Jsu, "cancel", null, paramInt2, paramt.gcx().Mjz.dIZ);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private static String aYy(String paramString)
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
    this.ISw = paramf;
  }
  
  final void a(com.tencent.mm.plugin.webview.model.t paramt, int paramInt, cdw paramcdw)
  {
    AppMethodBeat.i(81017);
    cdx localcdx = paramt.gcw();
    Object localObject = paramt.gcx();
    if (localcdx == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt, paramt.gcx().Mjz.dIZ);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      Log.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.IXT.a(a.a.a.Jst, null, null, paramInt, paramt.gcx().Mjz.dIZ);
      AppMethodBeat.o(81017);
      return;
    }
    g.azz().a(1096, this);
    localObject = ((cdy)localObject).MjC;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      cey localcey;
      while (localIterator.hasNext())
      {
        localcey = (cey)localIterator.next();
        if (localcey != null)
        {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localcey.Mkw, localcey.scope, localcey.CYp, Integer.valueOf(localcey.Mkv), localcdx.Mjs });
          localcey.Mkv = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localcey = (cey)localIterator.next();
        if (localcey != null) {
          Log.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localcey.Mkw, localcey.scope, localcey.CYp, Integer.valueOf(localcey.Mkv), localcdx.Mjs });
        }
      }
    }
    paramcdw = new w(paramcdw, localcdx.url, localcdx.Mjy, localcdx.hik, localcdx.Mjs, localcdx.dmc, localcdx.Mju, localcdx.signature, localcdx.Mjv, localcdx.Mjw, localcdx.Mjx, (LinkedList)localObject, this.IXV);
    g.azz().a(paramcdw, 0);
    paramt.IXT.a(a.a.a.Jss, null, null, paramInt, paramt.gcx().Mjz.dIZ);
    AppMethodBeat.o(81017);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt, n paramn, a parama)
  {
    AppMethodBeat.i(211343);
    if (paramn != null) {}
    for (String str2 = paramn.mhO;; str2 = "")
    {
      if (Util.isNullOrNil(str2))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.Jsv, null, null, 0, 0);
        AppMethodBeat.o(211343);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (Util.isNullOrNil(paramString1)) || (paramn == null) || (paramJsapiPermissionWrapper.Kzq == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.Jst, "localParameters", null, 0, 0);
          AppMethodBeat.o(211343);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.aiW(paramInt);
      Log.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.Jso.get(paramString1);
      if (Util.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paramn.params.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paramn.ISg;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.Jst, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          Log.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(211343);
          return;
        case 1: 
          parama.a(a.a.a.Jss, null, null, 0, 0);
          AppMethodBeat.o(211343);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.Jss, null, null, 0, 0);
            AppMethodBeat.o(211343);
            return;
          }
          parama.a(a.a.a.Jsv, null, null, 0, 0);
          AppMethodBeat.o(211343);
          return;
        case 0: 
          parama.a(a.a.a.Jsv, null, null, 0, 0);
          AppMethodBeat.o(211343);
          return;
        case 4: 
          localObject2 = (String)paramn.params.get("url");
          localObject1 = paramString1;
          if (!Util.isEqual((String)localObject2, paramString1)) {
            if (((b)g.af(b.class)).a(b.a.rSL, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt = 1;; paramInt = 0)
          {
            localObject1 = paramString1;
            if (paramInt != 0)
            {
              h.CyF.idkeyStat(1200L, 103L, 1L, false);
              Log.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (cdw)this.Jsn.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.KLv != 1) {
              break;
            }
            parama.a(a.a.a.Jss, null, null, 0, 0);
            AppMethodBeat.o(211343);
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
        paramInt = 0;
        if ((Util.isNullOrNil(paramString1)) && (!Util.isNullOrNil(str3)))
        {
          paramInt = 1;
          paramJsapiPermissionWrapper = (String)paramn.params.get("appId");
          localObject2 = (String)paramn.params.get("addrSign");
          str1 = (String)paramn.params.get("signType");
          paramString1 = (String)paramn.params.get("timeStamp");
          localObject1 = (String)paramn.params.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = n.a.be(paramn.params);
          paramn = str3;
          if (localJSONObject != null) {
            paramn = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new com.tencent.mm.plugin.webview.model.t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paramn, paramInt, str4, this.IXV);
            g.azz().a(1095, this);
            g.azz().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(211343);
            return;
            if (!Util.isNullOrNil(paramString1))
            {
              paramInt = 2;
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
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paramn, this.IXV);
            g.azz().a(1094, this);
            g.azz().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(211343);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final String baN(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.Jso.get(paramString);
    String str1 = str2;
    if (Util.isNullOrNil(str2))
    {
      String str3 = aYy(paramString);
      Log.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!Util.isNullOrNil(str3)) {
        str1 = (String)this.Jso.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d baO(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.IVk.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = aYy(paramString);
      locald1 = (d)this.IVk.get(paramString);
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
    if (((b)paramq).fZu() != this.IXV)
    {
      Log.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.IXV), Integer.valueOf(((b)paramq).fZu()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramq.getType();
    if (i == 1093)
    {
      g.azz().b(1093, this);
      paramq = (u)paramq;
      if (paramq == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramq.IXT == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramq.gcy() != null)
      {
        i = j;
        if (paramq.gcy().Mjz != null) {
          i = paramq.gcy().Mjz.dIZ;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramq.IXT.a(a.a.a.Jst, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramq.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      ceg localceg = paramq.gcy();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramq.rr == null)
      {
        paramString = null;
        if ((localceg != null) && (!Util.isNullOrNil(paramq.nKc)) && (paramString != null) && (!Util.isNullOrNil(paramString.dNI))) {
          break label498;
        }
        if (localceg != null) {
          break label486;
        }
        bool1 = true;
        bool3 = Util.isNullOrNil(paramq.nKc);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramq.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (cef)paramq.rr.iLK.iLR;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localceg.Mjz == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramq.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localceg.Mjz.dIZ != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localceg.Mjz.dIZ), localceg.Mjz.dJa });
        paramq.IXT.a(a.a.a.Jst, localceg.Mjz.dJa, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramq.IXT.baP(localceg.MjR);
      this.Jso.put(aYy(paramString.url), paramString.dNI);
      d locald = new d(paramString.dNI, localceg);
      this.IVk.put(aYy(paramString.url), locald);
      this.IVk.put(aYy(paramString.Mjy), locald);
      paramq.IXT.a(a.a.a.Jss, null, localceg.MjP, paramInt2, i);
      Log.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      g.azz().b(1095, this);
      a(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.webview.model.t)paramq);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      g.azz().b(1094, this);
      paramq = (v)paramq;
      if (paramq == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      h.CyF.idkeyStat(157L, 24L, 1L, false);
      if ((paramq.gcz() == null) || (paramq.gcz().Mjz == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramq.gcz().Mjz.dIZ;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.CyF.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramq.IXT.a(a.a.a.Jst, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramq.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramq.gcz();
      if ((paramString == null) || (paramString.Mjz == null))
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramq.IXT.a(a.a.a.Jst, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Mjz.dIZ != 0)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Mjz.dIZ), paramString.Mjz.dJa });
        paramq.IXT.a(a.a.a.Jst, paramString.Mjz.dJa, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.MjT;
      if (paramString == null)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramq.IXT.a(a.a.a.Jst, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Nnk != 1)
      {
        Log.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.Nnk) });
        paramq.IXT.a(a.a.a.Jst, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramq.IXT.a(a.a.a.Jss, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        g.azz().b(1096, this);
        paramString = (w)paramq;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (cej)paramString.rr.iLK.iLR)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.Mjs });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.bgb(Util.nullAsNil(paramString.Mjs)) == null)
        {
          Log.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramq = ((w)paramq).IXW;
        paramq.KLv = 1;
        this.Jsn.put(paramString.Mjs + paramString.url, paramq);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<epn> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void baP(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        Jss = new a("RET_OK", 0, 0);
        Jst = new a("RET_FAIL", 1, -1);
        Jsu = new a("RET_REJECT", 2, -2);
        Jsv = new a("RET_ACCESS_DENIED", 3, -3);
        Jsw = new a[] { Jss, Jst, Jsu, Jsv };
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
    public abstract int fZu();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean Jsx = true;
    
    public void baP(String paramString) {}
    
    public boolean ghm()
    {
      return this.Jsx;
    }
    
    public final void zn(boolean paramBoolean)
    {
      this.Jsx = paramBoolean;
    }
  }
  
  public static final class d
  {
    public List<String> Jsy;
    public List<cel> Jsz;
    public String appId;
    
    public d(String paramString, ceg paramceg)
    {
      this.appId = paramString;
      this.Jsy = paramceg.MjQ;
      this.Jsz = paramceg.MjS;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */