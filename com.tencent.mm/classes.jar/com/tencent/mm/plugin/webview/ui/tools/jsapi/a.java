package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqk;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.protocal.protobuf.bqv;
import com.tencent.mm.protocal.protobuf.bqx;
import com.tencent.mm.protocal.protobuf.brk;
import com.tencent.mm.protocal.protobuf.duo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.al.f
{
  private com.tencent.mm.plugin.webview.stub.f DNO;
  private final HashMap<String, d> DQp;
  final int DSX;
  private final HashMap<String, bqi> EkG;
  private final HashMap<String, String> EkH;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.EkG = new HashMap();
    this.EkH = new HashMap();
    this.DQp = new HashMap();
    this.DSX = paramInt;
    AppMethodBeat.o(81013);
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString, final t paramt)
  {
    AppMethodBeat.i(81016);
    if (paramt == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      AppMethodBeat.o(81016);
      return;
    }
    int j = 0;
    int i = j;
    if (paramt.ePY() != null)
    {
      i = j;
      if (paramt.ePY().GKP != null) {
        i = paramt.ePY().GKP.dqI;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.DSV.a(a.a.a.EkM, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (bt.isNullOrNil(paramt.DSW))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.ePY();
    if ((paramString == null) || (paramString.GKP == null))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.GKP.dqI != 0)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.GKP.dqI), paramString.GKP.dqJ });
      paramt.DSV.a(a.a.a.EkM, paramString.GKP.dqJ, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.ePX() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.ePX().GKN)
    {
      ad.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.GKS != null) {
        break;
      }
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.GKS.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (brk)paramString.next();
      if (((brk)localObject).GLL == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((brk)localObject).GLL.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bt.isNullOrNil(str))
          {
            bqi localbqi = new bqi();
            localbqi.GKI = str;
            localbqi.Fzq = ((brk)localObject).GLK;
            localbqi.GKJ = ((brk)localObject).yDs;
            this.EkG.put(localbqi.GKI + paramt.url, localbqi);
          }
        }
      }
    }
    label560:
    if (paramString.GKQ == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.DSV.a(a.a.a.EkM, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.GKQ.iterator();
    while (paramString.hasNext())
    {
      localObject = (bqi)paramString.next();
      if (!bt.isNullOrNil(((bqi)localObject).GKI)) {
        this.EkG.put(((bqi)localObject).GKI + paramt.url, localObject);
      }
    }
    paramString = (bqi)this.EkG.get(paramt.DSW + paramt.url);
    if (paramString == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.DSW, paramt.url });
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.Fzq == 1)
    {
      paramt.DSV.a(a.a.a.EkL, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (this.context == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(paramt, paramInt2, paramString);
      AppMethodBeat.o(81016);
      return;
    }
    WebViewStubTempUI.a(this.context, this.DNO, bt.nullAsNil(paramString.GKJ), "", this.context.getString(2131760582), this.context.getString(2131760581), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81006);
        ad.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        a.this.a(paramt, paramInt2, paramString);
        AppMethodBeat.o(81006);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81007);
        ad.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramt.DSV.a(a.a.a.EkN, "cancel", null, paramInt2, paramt.ePY().GKP.dqI);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private static String aHc(String paramString)
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
  
  final void a(Context paramContext, com.tencent.mm.plugin.webview.stub.f paramf)
  {
    this.context = paramContext;
    this.DNO = paramf;
  }
  
  final void a(t paramt, int paramInt, bqi parambqi)
  {
    AppMethodBeat.i(81017);
    bqj localbqj = paramt.ePX();
    Object localObject = paramt.ePY();
    if (localbqj == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt, paramt.ePY().GKP.dqI);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.DSV.a(a.a.a.EkM, null, null, paramInt, paramt.ePY().GKP.dqI);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.g.aiU().a(1096, this);
    localObject = ((bqk)localObject).GKS;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      brk localbrk;
      while (localIterator.hasNext())
      {
        localbrk = (brk)localIterator.next();
        if (localbrk != null)
        {
          ad.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbrk.GLL, localbrk.scope, localbrk.yDs, Integer.valueOf(localbrk.GLK), localbqj.GKI });
          localbrk.GLK = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localbrk = (brk)localIterator.next();
        if (localbrk != null) {
          ad.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbrk.GLL, localbrk.scope, localbrk.yDs, Integer.valueOf(localbrk.GLK), localbqj.GKI });
        }
      }
    }
    parambqi = new w(parambqi, localbqj.url, localbqj.GKO, localbqj.gsT, localbqj.GKI, localbqj.cUM, localbqj.GKK, localbqj.signature, localbqj.GKL, localbqj.GKM, localbqj.GKN, (LinkedList)localObject, this.DSX);
    com.tencent.mm.kernel.g.aiU().a(parambqi, 0);
    paramt.DSV.a(a.a.a.EkL, null, null, paramInt, paramt.ePY().GKP.dqI);
    AppMethodBeat.o(81017);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt, l paraml, a parama)
  {
    AppMethodBeat.i(208250);
    if (paraml != null) {}
    for (String str2 = paraml.kYO;; str2 = "")
    {
      if (bt.isNullOrNil(str2))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.EkO, null, null, 0, 0);
        AppMethodBeat.o(208250);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (bt.isNullOrNil(paramString1)) || (paraml == null) || (paramJsapiPermissionWrapper.FnH == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.EkM, "localParameters", null, 0, 0);
          AppMethodBeat.o(208250);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.ZB(paramInt);
      ad.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.EkH.get(paramString1);
      if (bt.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paraml.xaW.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paraml.DNB;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.EkM, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          ad.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(208250);
          return;
        case 1: 
          parama.a(a.a.a.EkL, null, null, 0, 0);
          AppMethodBeat.o(208250);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.EkL, null, null, 0, 0);
            AppMethodBeat.o(208250);
            return;
          }
          parama.a(a.a.a.EkO, null, null, 0, 0);
          AppMethodBeat.o(208250);
          return;
        case 0: 
          parama.a(a.a.a.EkO, null, null, 0, 0);
          AppMethodBeat.o(208250);
          return;
        case 4: 
          localObject2 = (String)paraml.xaW.get("url");
          localObject1 = paramString1;
          if (!bt.lQ((String)localObject2, paramString1)) {
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qtK, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt = 1;; paramInt = 0)
          {
            localObject1 = paramString1;
            if (paramInt != 0)
            {
              com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1200L, 103L, 1L, false);
              ad.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (bqi)this.EkG.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.Fzq != 1) {
              break;
            }
            parama.a(a.a.a.EkL, null, null, 0, 0);
            AppMethodBeat.o(208250);
            return;
          }
        }
        paramString1 = (String)paraml.xaW.get("verifySignature");
        localObject1 = (String)paraml.xaW.get("verifyNonceStr");
        Object localObject2 = (String)paraml.xaW.get("verifyTimestamp");
        String str1 = (String)paraml.xaW.get("verifySignType");
        String str4 = (String)paraml.xaW.get("scope");
        String str3 = (String)paraml.xaW.get("addrSign");
        ad.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt = 0;
        if ((bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(str3)))
        {
          paramInt = 1;
          paramJsapiPermissionWrapper = (String)paraml.xaW.get("appId");
          localObject2 = (String)paraml.xaW.get("addrSign");
          str1 = (String)paraml.xaW.get("signType");
          paramString1 = (String)paraml.xaW.get("timeStamp");
          localObject1 = (String)paraml.xaW.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = l.a.aZ(paraml.xaW);
          paraml = str3;
          if (localJSONObject != null) {
            paraml = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, paramInt, str4, this.DSX);
            com.tencent.mm.kernel.g.aiU().a(1095, this);
            com.tencent.mm.kernel.g.aiU().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(208250);
            return;
            if (!bt.isNullOrNil(paramString1))
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
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, this.DSX);
            com.tencent.mm.kernel.g.aiU().a(1094, this);
            com.tencent.mm.kernel.g.aiU().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(208250);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final String aJg(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.EkH.get(paramString);
    String str1 = str2;
    if (bt.isNullOrNil(str2))
    {
      String str3 = aHc(paramString);
      ad.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!bt.isNullOrNil(str3)) {
        str1 = (String)this.EkH.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d aJh(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.DQp.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = aHc(paramString);
      locald1 = (d)this.DQp.get(paramString);
    }
    AppMethodBeat.o(81012);
    return locald1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(81014);
    ad.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof b))
    {
      ad.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(81014);
      return;
    }
    if (((b)paramn).eNj() != this.DSX)
    {
      ad.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.DSX), Integer.valueOf(((b)paramn).eNj()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramn.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.g.aiU().b(1093, this);
      paramn = (u)paramn;
      if (paramn == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramn.DSV == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramn.ePZ() != null)
      {
        i = j;
        if (paramn.ePZ().GKP != null) {
          i = paramn.ePZ().GKP.dqI;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramn.DSV.a(a.a.a.EkM, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      bqs localbqs = paramn.ePZ();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramn.rr == null)
      {
        paramString = null;
        if ((localbqs != null) && (!bt.isNullOrNil(paramn.mue)) && (paramString != null) && (!bt.isNullOrNil(paramString.duW))) {
          break label498;
        }
        if (localbqs != null) {
          break label486;
        }
        bool1 = true;
        bool3 = bt.isNullOrNil(paramn.mue);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramn.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (bqr)paramn.rr.hNK.hNQ;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localbqs.GKP == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramn.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localbqs.GKP.dqI != 0)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localbqs.GKP.dqI), localbqs.GKP.dqJ });
        paramn.DSV.a(a.a.a.EkM, localbqs.GKP.dqJ, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.DSV.aJi(localbqs.GLi);
      this.EkH.put(aHc(paramString.url), paramString.duW);
      d locald = new d(paramString.duW, localbqs);
      this.DQp.put(aHc(paramString.url), locald);
      this.DQp.put(aHc(paramString.GKO), locald);
      paramn.DSV.a(a.a.a.EkL, null, localbqs.GLg, paramInt2, i);
      ad.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.g.aiU().b(1095, this);
      a(paramInt1, paramInt2, paramString, (t)paramn);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.g.aiU().b(1094, this);
      paramn = (v)paramn;
      if (paramn == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(157L, 24L, 1L, false);
      if ((paramn.eQa() == null) || (paramn.eQa().GKP == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramn.eQa().GKP.dqI;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramn.DSV.a(a.a.a.EkM, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramn.eQa();
      if ((paramString == null) || (paramString.GKP == null))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramn.DSV.a(a.a.a.EkM, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.GKP.dqI != 0)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.GKP.dqI), paramString.GKP.dqJ });
        paramn.DSV.a(a.a.a.EkM, paramString.GKP.dqJ, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.GLk;
      if (paramString == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramn.DSV.a(a.a.a.EkM, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.HHh != 1)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.HHh) });
        paramn.DSV.a(a.a.a.EkM, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.DSV.a(a.a.a.EkL, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.g.aiU().b(1096, this);
        paramString = (w)paramn;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (bqv)paramString.rr.hNK.hNQ)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.GKI });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.aOb(bt.nullAsNil(paramString.GKI)) == null)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramn = ((w)paramn).DSY;
        paramn.Fzq = 1;
        this.EkG.put(paramString.GKI + paramString.url, paramn);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<duo> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void aJi(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        EkL = new a("RET_OK", 0, 0);
        EkM = new a("RET_FAIL", 1, -1);
        EkN = new a("RET_REJECT", 2, -2);
        EkO = new a("RET_ACCESS_DENIED", 3, -3);
        EkP = new a[] { EkL, EkM, EkN, EkO };
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
    public abstract int eNj();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean EkQ = true;
    
    public void aJi(String paramString) {}
    
    public boolean eUu()
    {
      return this.EkQ;
    }
    
    public final void vk(boolean paramBoolean)
    {
      this.EkQ = paramBoolean;
    }
  }
  
  public static final class d
  {
    public List<String> EkR;
    public List<bqx> EkS;
    public String appId;
    
    public d(String paramString, bqs parambqs)
    {
      this.appId = paramString;
      this.EkR = parambqs.GLh;
      this.EkS = parambqs.GLj;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */