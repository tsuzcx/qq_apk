package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.c.l;
import com.tencent.mm.plugin.webview.c.l.a;
import com.tencent.mm.plugin.webview.model.t;
import com.tencent.mm.plugin.webview.model.u;
import com.tencent.mm.plugin.webview.model.v;
import com.tencent.mm.plugin.webview.model.w;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.f;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.blz;
import com.tencent.mm.protocal.protobuf.bma;
import com.tencent.mm.protocal.protobuf.bmb;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.protocal.protobuf.bml;
import com.tencent.mm.protocal.protobuf.bmn;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.dox;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ak.g
{
  private final HashMap<String, bly> CGU;
  private final HashMap<String, String> CGV;
  private f CkJ;
  private final HashMap<String, d> CmU;
  final int Cpz;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.CGU = new HashMap();
    this.CGV = new HashMap();
    this.CmU = new HashMap();
    this.Cpz = paramInt;
    AppMethodBeat.o(81013);
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString, final t paramt)
  {
    AppMethodBeat.i(81016);
    if (paramt == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      AppMethodBeat.o(81016);
      return;
    }
    int j = 0;
    int i = j;
    if (paramt.eBg() != null)
    {
      i = j;
      if (paramt.eBg().Fbq != null) {
        i = paramt.eBg().Fbq.dfm;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.Cpx.a(a.a.a.CHa, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (bs.isNullOrNil(paramt.Cpy))
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.eBg();
    if ((paramString == null) || (paramString.Fbq == null))
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.Fbq.dfm != 0)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Fbq.dfm), paramString.Fbq.dfn });
      paramt.Cpx.a(a.a.a.CHa, paramString.Fbq.dfn, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.eBf() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.eBf().Fbo)
    {
      ac.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.Fbt != null) {
        break;
      }
      ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Fbt.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (bna)paramString.next();
      if (((bna)localObject).Fcl == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((bna)localObject).Fcl.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bs.isNullOrNil(str))
          {
            bly localbly = new bly();
            localbly.Fbj = str;
            localbly.DTW = ((bna)localObject).Fck;
            localbly.Fbk = ((bna)localObject).xoN;
            this.CGU.put(localbly.Fbj + paramt.url, localbly);
          }
        }
      }
    }
    label560:
    if (paramString.Fbr == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.Cpx.a(a.a.a.CHa, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Fbr.iterator();
    while (paramString.hasNext())
    {
      localObject = (bly)paramString.next();
      if (!bs.isNullOrNil(((bly)localObject).Fbj)) {
        this.CGU.put(((bly)localObject).Fbj + paramt.url, localObject);
      }
    }
    paramString = (bly)this.CGU.get(paramt.Cpy + paramt.url);
    if (paramString == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.Cpy, paramt.url });
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.DTW == 1)
    {
      paramt.Cpx.a(a.a.a.CGZ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (this.context == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(paramt, paramInt2, paramString);
      AppMethodBeat.o(81016);
      return;
    }
    WebViewStubTempUI.a(this.context, this.CkJ, bs.nullAsNil(paramString.Fbk), "", this.context.getString(2131760582), this.context.getString(2131760581), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81006);
        ac.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        a.this.a(paramt, paramInt2, paramString);
        AppMethodBeat.o(81006);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81007);
        ac.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramt.Cpx.a(a.a.a.CHb, "cancel", null, paramInt2, paramt.eBg().Fbq.dfm);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private static String aBE(String paramString)
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
    this.CkJ = paramf;
  }
  
  final void a(t paramt, int paramInt, bly parambly)
  {
    AppMethodBeat.i(81017);
    blz localblz = paramt.eBf();
    Object localObject = paramt.eBg();
    if (localblz == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt, paramt.eBg().Fbq.dfm);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      ac.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.Cpx.a(a.a.a.CHa, null, null, paramInt, paramt.eBg().Fbq.dfm);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.g.agi().a(1096, this);
    localObject = ((bma)localObject).Fbt;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      bna localbna;
      while (localIterator.hasNext())
      {
        localbna = (bna)localIterator.next();
        if (localbna != null)
        {
          ac.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbna.Fcl, localbna.scope, localbna.xoN, Integer.valueOf(localbna.Fck), localblz.Fbj });
          localbna.Fck = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localbna = (bna)localIterator.next();
        if (localbna != null) {
          ac.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbna.Fcl, localbna.scope, localbna.xoN, Integer.valueOf(localbna.Fck), localblz.Fbj });
        }
      }
    }
    parambly = new w(parambly, localblz.url, localblz.Fbp, localblz.fZx, localblz.Fbj, localblz.cJz, localblz.Fbl, localblz.signature, localblz.Fbm, localblz.Fbn, localblz.Fbo, (LinkedList)localObject, this.Cpz);
    com.tencent.mm.kernel.g.agi().a(parambly, 0);
    paramt.Cpx.a(a.a.a.CGZ, null, null, paramInt, paramt.eBg().Fbq.dfm);
    AppMethodBeat.o(81017);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt, l paraml, a parama)
  {
    AppMethodBeat.i(188574);
    if (paraml != null) {}
    for (String str2 = paraml.kCH;; str2 = "")
    {
      if (bs.isNullOrNil(str2))
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.CHc, null, null, 0, 0);
        AppMethodBeat.o(188574);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (bs.isNullOrNil(paramString1)) || (paraml == null) || (paramJsapiPermissionWrapper.DIA == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.CHa, "localParameters", null, 0, 0);
          AppMethodBeat.o(188574);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.XF(paramInt);
      ac.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.CGV.get(paramString1);
      if (bs.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paraml.vUl.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paraml.Ckw;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.CHa, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          ac.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(188574);
          return;
        case 1: 
          parama.a(a.a.a.CGZ, null, null, 0, 0);
          AppMethodBeat.o(188574);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.CGZ, null, null, 0, 0);
            AppMethodBeat.o(188574);
            return;
          }
          parama.a(a.a.a.CHc, null, null, 0, 0);
          AppMethodBeat.o(188574);
          return;
        case 0: 
          parama.a(a.a.a.CHc, null, null, 0, 0);
          AppMethodBeat.o(188574);
          return;
        case 4: 
          localObject2 = (String)paraml.vUl.get("url");
          localObject1 = paramString1;
          if (!bs.lr((String)localObject2, paramString1)) {
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pPJ, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt = 1;; paramInt = 0)
          {
            localObject1 = paramString1;
            if (paramInt != 0)
            {
              h.wUl.idkeyStat(1200L, 103L, 1L, false);
              ac.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (bly)this.CGU.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.DTW != 1) {
              break;
            }
            parama.a(a.a.a.CGZ, null, null, 0, 0);
            AppMethodBeat.o(188574);
            return;
          }
        }
        paramString1 = (String)paraml.vUl.get("verifySignature");
        localObject1 = (String)paraml.vUl.get("verifyNonceStr");
        Object localObject2 = (String)paraml.vUl.get("verifyTimestamp");
        String str1 = (String)paraml.vUl.get("verifySignType");
        String str4 = (String)paraml.vUl.get("scope");
        String str3 = (String)paraml.vUl.get("addrSign");
        ac.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt = 0;
        if ((bs.isNullOrNil(paramString1)) && (!bs.isNullOrNil(str3)))
        {
          paramInt = 1;
          paramJsapiPermissionWrapper = (String)paraml.vUl.get("appId");
          localObject2 = (String)paraml.vUl.get("addrSign");
          str1 = (String)paraml.vUl.get("signType");
          paramString1 = (String)paraml.vUl.get("timeStamp");
          localObject1 = (String)paraml.vUl.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = l.a.aX(paraml.vUl);
          paraml = str3;
          if (localJSONObject != null) {
            paraml = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, paramInt, str4, this.Cpz);
            com.tencent.mm.kernel.g.agi().a(1095, this);
            com.tencent.mm.kernel.g.agi().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(188574);
            return;
            if (!bs.isNullOrNil(paramString1))
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
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, this.Cpz);
            com.tencent.mm.kernel.g.agi().a(1094, this);
            com.tencent.mm.kernel.g.agi().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(188574);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final String aDF(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.CGV.get(paramString);
    String str1 = str2;
    if (bs.isNullOrNil(str2))
    {
      String str3 = aBE(paramString);
      ac.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!bs.isNullOrNil(str3)) {
        str1 = (String)this.CGV.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d aDG(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.CmU.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = aBE(paramString);
      locald1 = (d)this.CmU.get(paramString);
    }
    AppMethodBeat.o(81012);
    return locald1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(81014);
    ac.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof b))
    {
      ac.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(81014);
      return;
    }
    if (((b)paramn).eyt() != this.Cpz)
    {
      ac.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.Cpz), Integer.valueOf(((b)paramn).eyt()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramn.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.g.agi().b(1093, this);
      paramn = (u)paramn;
      if (paramn == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramn.Cpx == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramn.eBh() != null)
      {
        i = j;
        if (paramn.eBh().Fbq != null) {
          i = paramn.eBh().Fbq.dfm;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramn.Cpx.a(a.a.a.CHa, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      bmi localbmi = paramn.eBh();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramn.rr == null)
      {
        paramString = null;
        if ((localbmi != null) && (!bs.isNullOrNil(paramn.lUn)) && (paramString != null) && (!bs.isNullOrNil(paramString.djj))) {
          break label498;
        }
        if (localbmi != null) {
          break label486;
        }
        bool1 = true;
        bool3 = bs.isNullOrNil(paramn.lUn);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramn.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (bmh)paramn.rr.hvr.hvw;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localbmi.Fbq == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramn.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localbmi.Fbq.dfm != 0)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localbmi.Fbq.dfm), localbmi.Fbq.dfn });
        paramn.Cpx.a(a.a.a.CHa, localbmi.Fbq.dfn, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.Cpx.aDH(localbmi.FbJ);
      this.CGV.put(aBE(paramString.url), paramString.djj);
      d locald = new d(paramString.djj, localbmi);
      this.CmU.put(aBE(paramString.url), locald);
      this.CmU.put(aBE(paramString.Fbp), locald);
      paramn.Cpx.a(a.a.a.CGZ, null, localbmi.FbH, paramInt2, i);
      ac.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.g.agi().b(1095, this);
      a(paramInt1, paramInt2, paramString, (t)paramn);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.g.agi().b(1094, this);
      paramn = (v)paramn;
      if (paramn == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      h.wUl.idkeyStat(157L, 24L, 1L, false);
      if ((paramn.eBi() == null) || (paramn.eBi().Fbq == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramn.eBi().Fbq.dfm;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.wUl.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramn.Cpx.a(a.a.a.CHa, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramn.eBi();
      if ((paramString == null) || (paramString.Fbq == null))
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramn.Cpx.a(a.a.a.CHa, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Fbq.dfm != 0)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Fbq.dfm), paramString.Fbq.dfn });
        paramn.Cpx.a(a.a.a.CHa, paramString.Fbq.dfn, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.FbL;
      if (paramString == null)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramn.Cpx.a(a.a.a.CHa, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.FWr != 1)
      {
        ac.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.FWr) });
        paramn.Cpx.a(a.a.a.CHa, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.Cpx.a(a.a.a.CGZ, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.g.agi().b(1096, this);
        paramString = (w)paramn;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (bml)paramString.rr.hvr.hvw)
        {
          ac.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ac.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.Fbj });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.aIy(bs.nullAsNil(paramString.Fbj)) == null)
        {
          ac.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramn = ((w)paramn).CpA;
        paramn.DTW = 1;
        this.CGU.put(paramString.Fbj + paramString.url, paramn);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<dox> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void aDH(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        CGZ = new a("RET_OK", 0, 0);
        CHa = new a("RET_FAIL", 1, -1);
        CHb = new a("RET_REJECT", 2, -2);
        CHc = new a("RET_ACCESS_DENIED", 3, -3);
        CHd = new a[] { CGZ, CHa, CHb, CHc };
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
    public abstract int eyt();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean CHe = true;
    
    public void aDH(String paramString) {}
    
    public boolean eFy()
    {
      return this.CHe;
    }
    
    public final void uz(boolean paramBoolean)
    {
      this.CHe = paramBoolean;
    }
  }
  
  public static final class d
  {
    public List<String> CHf;
    public List<bmn> CHg;
    public String appId;
    
    public d(String paramString, bmi parambmi)
    {
      this.appId = paramString;
      this.CHf = parambmi.FbI;
      this.CHg = parambmi.FbK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */