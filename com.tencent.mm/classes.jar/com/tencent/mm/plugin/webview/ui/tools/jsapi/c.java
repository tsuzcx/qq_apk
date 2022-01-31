package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.axb;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.axd;
import com.tencent.mm.protocal.protobuf.axe;
import com.tencent.mm.protocal.protobuf.axk;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.axn;
import com.tencent.mm.protocal.protobuf.axo;
import com.tencent.mm.protocal.protobuf.ayc;
import com.tencent.mm.protocal.protobuf.cpx;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public final class c
  implements f
{
  private Context context;
  final HashMap<String, c.d> uSR;
  final int uVH;
  private e uWu;
  private final HashMap<String, axb> voh;
  private final HashMap<String, String> voi;
  
  public c(int paramInt)
  {
    AppMethodBeat.i(8858);
    this.voh = new HashMap();
    this.voi = new HashMap();
    this.uSR = new HashMap();
    this.uVH = paramInt;
    AppMethodBeat.o(8858);
  }
  
  private void a(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(8861);
    if (params == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      AppMethodBeat.o(8861);
      return;
    }
    int j = 0;
    int i = j;
    if (params.dbM() != null)
    {
      i = j;
      if (params.dbM().xmu != null) {
        i = params.dbM().xmu.csV;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        params.uVF.a(c.a.a.von, paramString, null, paramInt2, i);
        AppMethodBeat.o(8861);
        return;
      }
      params.uVF.a(c.a.a.von, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    if (bo.isNullOrNil(params.uVG))
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      params.uVF.a(c.a.a.von, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    paramString = params.dbM();
    if ((paramString == null) || (paramString.xmu == null))
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      params.uVF.a(c.a.a.von, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    if (paramString.xmu.csV != 0)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.xmu.csV), paramString.xmu.csW });
      params.uVF.a(c.a.a.von, paramString.xmu.csW, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    if (params.dbL() == null) {}
    for (paramInt1 = 0;; paramInt1 = params.dbL().xmt)
    {
      ab.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label568;
      }
      if (paramString.xmx != null) {
        break;
      }
      ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      params.uVF.a(c.a.a.von, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    paramString = paramString.xmx.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (ayc)paramString.next();
      if (((ayc)localObject).xni == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((ayc)localObject).xni.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bo.isNullOrNil(str))
          {
            axb localaxb = new axb();
            localaxb.xmo = str;
            localaxb.wsg = ((ayc)localObject).xnh;
            localaxb.xmp = ((ayc)localObject).qFg;
            this.voh.put(localaxb.xmo + params.url, localaxb);
          }
        }
      }
    }
    label568:
    if (paramString.xmv == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      params.uVF.a(c.a.a.von, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    paramString = paramString.xmv.iterator();
    while (paramString.hasNext())
    {
      localObject = (axb)paramString.next();
      if (!bo.isNullOrNil(((axb)localObject).xmo)) {
        this.voh.put(((axb)localObject).xmo + params.url, localObject);
      }
    }
    paramString = (axb)this.voh.get(params.uVG + params.url);
    if (paramString == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { params.uVG, params.url });
      params.uVF.a(c.a.a.von, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    if (paramString.wsg == 1)
    {
      params.uVF.a(c.a.a.vom, null, null, paramInt2, i);
      AppMethodBeat.o(8861);
      return;
    }
    if (this.context == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(params, paramInt2, paramString);
      AppMethodBeat.o(8861);
      return;
    }
    WebViewStubTempUI.a(this.context, this.uWu, bo.nullAsNil(paramString.xmp), "", this.context.getString(2131300980), this.context.getString(2131300979), new c.1(this, params, paramInt2, paramString), new c.2(this, params, paramInt2));
    AppMethodBeat.o(8861);
  }
  
  static String agP(String paramString)
  {
    AppMethodBeat.i(8863);
    int i = paramString.indexOf("#");
    if (i < 0)
    {
      AppMethodBeat.o(8863);
      return paramString;
    }
    paramString = paramString.substring(0, i);
    AppMethodBeat.o(8863);
    return paramString;
  }
  
  final void a(Context paramContext, e parame)
  {
    this.context = paramContext;
    this.uWu = parame;
  }
  
  final void a(s params, int paramInt, axb paramaxb)
  {
    AppMethodBeat.i(8862);
    axc localaxc = params.dbL();
    Object localObject = params.dbM();
    if (localaxc == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      params.uVF.a(c.a.a.von, null, null, paramInt, params.dbM().xmu.csV);
      AppMethodBeat.o(8862);
      return;
    }
    if (localObject == null)
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      params.uVF.a(c.a.a.von, null, null, paramInt, params.dbM().xmu.csV);
      AppMethodBeat.o(8862);
      return;
    }
    g.Rc().a(1096, this);
    localObject = ((axd)localObject).xmx;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      ayc localayc;
      while (localIterator.hasNext())
      {
        localayc = (ayc)localIterator.next();
        if (localayc != null)
        {
          ab.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localayc.xni, localayc.scope, localayc.qFg, Integer.valueOf(localayc.xnh), localaxc.xmo });
          localayc.xnh = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localayc = (ayc)localIterator.next();
        if (localayc != null) {
          ab.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localayc.xni, localayc.scope, localayc.qFg, Integer.valueOf(localayc.xnh), localaxc.xmo });
        }
      }
    }
    paramaxb = new v(paramaxb, localaxc.url, localaxc.npZ, localaxc.xmo, localaxc.cqf, localaxc.xmq, localaxc.signature, localaxc.xmr, localaxc.xms, localaxc.xmt, (LinkedList)localObject, this.uVH);
    g.Rc().a(paramaxb, 0);
    params.uVF.a(c.a.a.vom, null, null, paramInt, params.dbM().xmu.csV);
    AppMethodBeat.o(8862);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString, int paramInt, i parami, a parama)
  {
    AppMethodBeat.i(8860);
    String str1 = "";
    if (parami != null) {
      str1 = parami.vrQ;
    }
    if (bo.isNullOrNil(str1))
    {
      ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString });
      parama.a(c.a.a.vop, null, null, 0, 0);
      AppMethodBeat.o(8860);
      return;
    }
    if ((paramJsapiPermissionWrapper == null) || (bo.isNullOrNil(paramString)) || (parami == null) || (paramJsapiPermissionWrapper.wif == null))
    {
      if (paramJsapiPermissionWrapper != null) {}
      for (boolean bool = true;; bool = false)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString, str1, Boolean.valueOf(bool) });
        parama.a(c.a.a.von, "localParameters", null, 0, 0);
        AppMethodBeat.o(8860);
        return;
      }
    }
    int i = paramJsapiPermissionWrapper.MB(paramInt);
    ab.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str1, Integer.valueOf(paramInt), Integer.valueOf(i), paramString });
    paramJsapiPermissionWrapper = (String)this.voi.get(paramString);
    if (bo.isNullOrNil(paramJsapiPermissionWrapper)) {
      paramJsapiPermissionWrapper = (String)parami.pJb.get("verifyAppId");
    }
    for (;;)
    {
      Object localObject1 = parami.vrP;
      ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
      ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
      switch (i)
      {
      default: 
        parama.a(c.a.a.von, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
        ab.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
        AppMethodBeat.o(8860);
        return;
      case 1: 
        parama.a(c.a.a.vom, null, null, 0, 0);
        AppMethodBeat.o(8860);
        return;
      case 2: 
        if (str1.equals("preVerifyJSAPI"))
        {
          parama.a(c.a.a.vom, null, null, 0, 0);
          AppMethodBeat.o(8860);
          return;
        }
        parama.a(c.a.a.vop, null, null, 0, 0);
        AppMethodBeat.o(8860);
        return;
      case 0: 
        parama.a(c.a.a.vop, null, null, 0, 0);
        AppMethodBeat.o(8860);
        return;
      case 4: 
        localObject1 = (axb)this.voh.get(str1 + paramString);
        if ((localObject1 != null) && (((axb)localObject1).wsg == 1))
        {
          parama.a(c.a.a.vom, null, null, 0, 0);
          AppMethodBeat.o(8860);
          return;
        }
        break;
      }
      localObject1 = (String)parami.pJb.get("verifySignature");
      Object localObject3 = (String)parami.pJb.get("verifyNonceStr");
      Object localObject2 = (String)parami.pJb.get("verifyTimestamp");
      String str2 = (String)parami.pJb.get("verifySignType");
      String str3 = (String)parami.pJb.get("scope");
      Object localObject4 = (String)parami.pJb.get("addrSign");
      ab.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { localObject4, localObject1 });
      paramInt = 0;
      if ((bo.isNullOrNil((String)localObject1)) && (!bo.isNullOrNil((String)localObject4)))
      {
        paramInt = 1;
        paramJsapiPermissionWrapper = (String)parami.pJb.get("appId");
        localObject3 = (String)parami.pJb.get("addrSign");
        localObject4 = (String)parami.pJb.get("signType");
        localObject1 = (String)parami.pJb.get("timeStamp");
        localObject2 = (String)parami.pJb.get("nonceStr");
      }
      for (;;)
      {
        str2 = null;
        JSONObject localJSONObject = i.a.ao(parami.pJb);
        parami = str2;
        if (localJSONObject != null) {
          parami = localJSONObject.toString().getBytes();
        }
        if (i == 4)
        {
          paramJsapiPermissionWrapper = new s(parama, paramString, paramJsapiPermissionWrapper, str1, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, parami, paramInt, str3, this.uVH);
          g.Rc().a(1095, this);
          g.Rc().a(paramJsapiPermissionWrapper, 0);
          AppMethodBeat.o(8860);
          return;
          if (!bo.isNullOrNil((String)localObject1))
          {
            paramInt = 2;
            localObject4 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            localObject3 = localObject4;
            localObject4 = str2;
          }
        }
        else
        {
          if (i != 3) {
            break;
          }
          paramJsapiPermissionWrapper = new u(parama, paramString, paramJsapiPermissionWrapper, str1, (String)localObject1, (String)localObject2, (String)localObject3, (String)localObject4, parami, this.uVH);
          g.Rc().a(1094, this);
          g.Rc().a(paramJsapiPermissionWrapper, 0);
          AppMethodBeat.o(8860);
          return;
        }
        localObject4 = localObject1;
        localObject1 = localObject2;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = str2;
      }
    }
  }
  
  public final String aiQ(String paramString)
  {
    AppMethodBeat.i(8857);
    if (paramString == null)
    {
      AppMethodBeat.o(8857);
      return null;
    }
    String str2 = (String)this.voi.get(paramString);
    String str1 = str2;
    if (bo.isNullOrNil(str2))
    {
      String str3 = agP(paramString);
      ab.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!bo.isNullOrNil(str3)) {
        str1 = (String)this.voi.get(str3);
      }
    }
    AppMethodBeat.o(8857);
    return str1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(8859);
    ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramm instanceof c.b))
    {
      ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(8859);
      return;
    }
    if (((c.b)paramm).dbN() != this.uVH)
    {
      ab.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.uVH), Integer.valueOf(((c.b)paramm).dbN()) });
      AppMethodBeat.o(8859);
      return;
    }
    int i = paramm.getType();
    if (i == 1093)
    {
      g.Rc().b(1093, this);
      paramm = (t)paramm;
      if (paramm == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(8859);
        return;
      }
      if (paramm.uVF == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(8859);
        return;
      }
      int j = 0;
      i = j;
      if (paramm.dbO() != null)
      {
        i = j;
        if (paramm.dbO().xmu != null) {
          i = paramm.dbO().xmu.csV;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramm.uVF.a(c.a.a.von, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(8859);
          return;
        }
        paramm.uVF.a(c.a.a.von, null, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      axl localaxl = paramm.dbO();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramm.rr == null)
      {
        paramString = null;
        if ((localaxl != null) && (!bo.isNullOrNil(paramm.iIg)) && (paramString != null) && (!bo.isNullOrNil(paramString.cwc))) {
          break label498;
        }
        if (localaxl != null) {
          break label486;
        }
        bool1 = true;
        bool3 = bo.isNullOrNil(paramm.iIg);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramm.uVF.a(c.a.a.von, null, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
        paramString = (axk)paramm.rr.fsV.fta;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localaxl.xmu == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramm.uVF.a(c.a.a.von, null, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      if (localaxl.xmu.csV != 0)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localaxl.xmu.csV), localaxl.xmu.csW });
        paramm.uVF.a(c.a.a.von, localaxl.xmu.csW, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      paramm.uVF.aiR(localaxl.xmM);
      this.voi.put(agP(paramString.url), paramString.cwc);
      c.d locald = new c.d();
      locald.appId = paramString.cwc;
      locald.vos = localaxl.xmL;
      this.uSR.put(agP(paramString.url), locald);
      paramm.uVF.a(c.a.a.vom, null, localaxl.xmK, paramInt2, i);
      ab.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(8859);
      return;
    }
    if (i == 1095)
    {
      g.Rc().b(1095, this);
      a(paramInt1, paramInt2, paramString, (s)paramm);
      AppMethodBeat.o(8859);
      return;
    }
    if (i == 1094)
    {
      g.Rc().b(1094, this);
      paramm = (u)paramm;
      if (paramm == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(8859);
        return;
      }
      h.qsU.idkeyStat(157L, 24L, 1L, false);
      if ((paramm.dbP() == null) || (paramm.dbP().xmu == null)) {
        break label1472;
      }
    }
    label1472:
    for (i = paramm.dbP().xmu.csV;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.qsU.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramm.uVF.a(c.a.a.von, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(8859);
          return;
        }
        paramm.uVF.a(c.a.a.von, null, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      paramString = paramm.dbP();
      if ((paramString == null) || (paramString.xmu == null))
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramm.uVF.a(c.a.a.von, null, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      if (paramString.xmu.csV != 0)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.xmu.csV), paramString.xmu.csW });
        paramm.uVF.a(c.a.a.von, paramString.xmu.csW, null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      paramString = paramString.xmN;
      if (paramString == null)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramm.uVF.a(c.a.a.von, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      if (paramString.xYD != 1)
      {
        ab.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.xYD) });
        paramm.uVF.a(c.a.a.von, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(8859);
        return;
      }
      paramm.uVF.a(c.a.a.vom, null, null, paramInt2, i);
      AppMethodBeat.o(8859);
      return;
      if (i == 1096)
      {
        g.Rc().b(1096, this);
        paramString = (v)paramm;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (axo)paramString.rr.fsV.fta)
        {
          ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(8859);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.xmo });
          AppMethodBeat.o(8859);
          return;
        }
        if (com.tencent.mm.protocal.c.anm(bo.nullAsNil(paramString.xmo)) == null)
        {
          ab.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(8859);
          return;
        }
        paramm = ((v)paramm).uVI;
        paramm.wsg = 1;
        this.voh.put(paramString.xmo + paramString.url, paramm);
      }
      AppMethodBeat.o(8859);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(c.a.a parama, String paramString, LinkedList<cpx> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void aiR(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c
 * JD-Core Version:    0.7.0.1
 */