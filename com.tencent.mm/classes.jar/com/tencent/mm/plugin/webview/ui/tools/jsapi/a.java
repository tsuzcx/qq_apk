package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
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
import com.tencent.mm.protocal.protobuf.big;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.protocal.protobuf.bii;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.biq;
import com.tencent.mm.protocal.protobuf.bis;
import com.tencent.mm.protocal.protobuf.bit;
import com.tencent.mm.protocal.protobuf.biv;
import com.tencent.mm.protocal.protobuf.bji;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.al.g
{
  private f ASw;
  private final HashMap<String, d> AUH;
  final int AXm;
  private final HashMap<String, big> BoN;
  private final HashMap<String, String> BoO;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.BoN = new HashMap();
    this.BoO = new HashMap();
    this.AUH = new HashMap();
    this.AXm = paramInt;
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
    if (paramt.elK() != null)
    {
      i = j;
      if (paramt.elK().DFW != null) {
        i = paramt.elK().DFW.dhR;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.AXk.a(a.a.a.BoT, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (bt.isNullOrNil(paramt.AXl))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.elK();
    if ((paramString == null) || (paramString.DFW == null))
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.DFW.dhR != 0)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.DFW.dhR), paramString.DFW.dhS });
      paramt.AXk.a(a.a.a.BoT, paramString.DFW.dhS, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.elJ() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.elJ().DFU)
    {
      ad.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.DFZ != null) {
        break;
      }
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.DFZ.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (bji)paramString.next();
      if (((bji)localObject).DGR == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((bji)localObject).DGR.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bt.isNullOrNil(str))
          {
            big localbig = new big();
            localbig.DFP = str;
            localbig.CBy = ((bji)localObject).DGQ;
            localbig.DFQ = ((bji)localObject).wdz;
            this.BoN.put(localbig.DFP + paramt.url, localbig);
          }
        }
      }
    }
    label560:
    if (paramString.DFX == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.AXk.a(a.a.a.BoT, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.DFX.iterator();
    while (paramString.hasNext())
    {
      localObject = (big)paramString.next();
      if (!bt.isNullOrNil(((big)localObject).DFP)) {
        this.BoN.put(((big)localObject).DFP + paramt.url, localObject);
      }
    }
    paramString = (big)this.BoN.get(paramt.AXl + paramt.url);
    if (paramString == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.AXl, paramt.url });
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.CBy == 1)
    {
      paramt.AXk.a(a.a.a.BoS, null, null, paramInt2, i);
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
    WebViewStubTempUI.a(this.context, this.ASw, bt.nullAsNil(paramString.DFQ), "", this.context.getString(2131760582), this.context.getString(2131760581), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
        paramt.AXk.a(a.a.a.BoU, "cancel", null, paramInt2, paramt.elK().DFW.dhR);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private static String awm(String paramString)
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
    this.ASw = paramf;
  }
  
  final void a(t paramt, int paramInt, big parambig)
  {
    AppMethodBeat.i(81017);
    bih localbih = paramt.elJ();
    Object localObject = paramt.elK();
    if (localbih == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt, paramt.elK().DFW.dhR);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      ad.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.AXk.a(a.a.a.BoT, null, null, paramInt, paramt.elK().DFW.dhR);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.g.aeS().a(1096, this);
    localObject = ((bii)localObject).DFZ;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      bji localbji;
      while (localIterator.hasNext())
      {
        localbji = (bji)localIterator.next();
        if (localbji != null)
        {
          ad.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbji.DGR, localbji.scope, localbji.wdz, Integer.valueOf(localbji.DGQ), localbih.DFP });
          localbji.DGQ = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localbji = (bji)localIterator.next();
        if (localbji != null) {
          ad.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbji.DGR, localbji.scope, localbji.wdz, Integer.valueOf(localbji.DGQ), localbih.DFP });
        }
      }
    }
    parambig = new w(parambig, localbih.url, localbih.DFV, localbih.fVC, localbih.DFP, localbih.cMo, localbih.DFR, localbih.signature, localbih.DFS, localbih.DFT, localbih.DFU, (LinkedList)localObject, this.AXm);
    com.tencent.mm.kernel.g.aeS().a(parambig, 0);
    paramt.AXk.a(a.a.a.BoS, null, null, paramInt, paramt.elK().DFW.dhR);
    AppMethodBeat.o(81017);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt, l paraml, a parama)
  {
    AppMethodBeat.i(188130);
    if (paraml != null) {}
    for (String str2 = paraml.kbU;; str2 = "")
    {
      if (bt.isNullOrNil(str2))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.BoV, null, null, 0, 0);
        AppMethodBeat.o(188130);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (bt.isNullOrNil(paramString1)) || (paraml == null) || (paramJsapiPermissionWrapper.Cqi == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.BoT, "localParameters", null, 0, 0);
          AppMethodBeat.o(188130);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.Vw(paramInt);
      ad.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.BoO.get(paramString1);
      if (bt.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paraml.uLu.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paraml.ASj;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.BoT, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          ad.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(188130);
          return;
        case 1: 
          parama.a(a.a.a.BoS, null, null, 0, 0);
          AppMethodBeat.o(188130);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.BoS, null, null, 0, 0);
            AppMethodBeat.o(188130);
            return;
          }
          parama.a(a.a.a.BoV, null, null, 0, 0);
          AppMethodBeat.o(188130);
          return;
        case 0: 
          parama.a(a.a.a.BoV, null, null, 0, 0);
          AppMethodBeat.o(188130);
          return;
        case 4: 
          localObject2 = (String)paraml.uLu.get("url");
          localObject1 = paramString1;
          if (!bt.kU((String)localObject2, paramString1)) {
            if (((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pmn, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt = 1;; paramInt = 0)
          {
            localObject1 = paramString1;
            if (paramInt != 0)
            {
              h.vKh.idkeyStat(1200L, 103L, 1L, false);
              ad.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (big)this.BoN.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.CBy != 1) {
              break;
            }
            parama.a(a.a.a.BoS, null, null, 0, 0);
            AppMethodBeat.o(188130);
            return;
          }
        }
        paramString1 = (String)paraml.uLu.get("verifySignature");
        localObject1 = (String)paraml.uLu.get("verifyNonceStr");
        Object localObject2 = (String)paraml.uLu.get("verifyTimestamp");
        String str1 = (String)paraml.uLu.get("verifySignType");
        String str4 = (String)paraml.uLu.get("scope");
        String str3 = (String)paraml.uLu.get("addrSign");
        ad.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt = 0;
        if ((bt.isNullOrNil(paramString1)) && (!bt.isNullOrNil(str3)))
        {
          paramInt = 1;
          paramJsapiPermissionWrapper = (String)paraml.uLu.get("appId");
          localObject2 = (String)paraml.uLu.get("addrSign");
          str1 = (String)paraml.uLu.get("signType");
          paramString1 = (String)paraml.uLu.get("timeStamp");
          localObject1 = (String)paraml.uLu.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = l.a.aT(paraml.uLu);
          paraml = str3;
          if (localJSONObject != null) {
            paraml = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, paramInt, str4, this.AXm);
            com.tencent.mm.kernel.g.aeS().a(1095, this);
            com.tencent.mm.kernel.g.aeS().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(188130);
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
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, this.AXm);
            com.tencent.mm.kernel.g.aeS().a(1094, this);
            com.tencent.mm.kernel.g.aeS().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(188130);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final String ayo(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.BoO.get(paramString);
    String str1 = str2;
    if (bt.isNullOrNil(str2))
    {
      String str3 = awm(paramString);
      ad.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!bt.isNullOrNil(str3)) {
        str1 = (String)this.BoO.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final d ayp(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.AUH.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = awm(paramString);
      locald1 = (d)this.AUH.get(paramString);
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
    if (((b)paramn).eiZ() != this.AXm)
    {
      ad.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.AXm), Integer.valueOf(((b)paramn).eiZ()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramn.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.g.aeS().b(1093, this);
      paramn = (u)paramn;
      if (paramn == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramn.AXk == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramn.elL() != null)
      {
        i = j;
        if (paramn.elL().DFW != null) {
          i = paramn.elL().DFW.dhR;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramn.AXk.a(a.a.a.BoT, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      biq localbiq = paramn.elL();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramn.rr == null)
      {
        paramString = null;
        if ((localbiq != null) && (!bt.isNullOrNil(paramn.lst)) && (paramString != null) && (!bt.isNullOrNil(paramString.dlB))) {
          break label498;
        }
        if (localbiq != null) {
          break label486;
        }
        bool1 = true;
        bool3 = bt.isNullOrNil(paramn.lst);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramn.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (bip)paramn.rr.gUS.gUX;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localbiq.DFW == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramn.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localbiq.DFW.dhR != 0)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localbiq.DFW.dhR), localbiq.DFW.dhS });
        paramn.AXk.a(a.a.a.BoT, localbiq.DFW.dhS, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.AXk.ayq(localbiq.DGp);
      this.BoO.put(awm(paramString.url), paramString.dlB);
      d locald = new d(paramString.dlB, localbiq);
      this.AUH.put(awm(paramString.url), locald);
      this.AUH.put(awm(paramString.DFV), locald);
      paramn.AXk.a(a.a.a.BoS, null, localbiq.DGn, paramInt2, i);
      ad.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.g.aeS().b(1095, this);
      a(paramInt1, paramInt2, paramString, (t)paramn);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.g.aeS().b(1094, this);
      paramn = (v)paramn;
      if (paramn == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      h.vKh.idkeyStat(157L, 24L, 1L, false);
      if ((paramn.elM() == null) || (paramn.elM().DFW == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramn.elM().DFW.dhR;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.vKh.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramn.AXk.a(a.a.a.BoT, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramn.elM();
      if ((paramString == null) || (paramString.DFW == null))
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramn.AXk.a(a.a.a.BoT, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.DFW.dhR != 0)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.DFW.dhR), paramString.DFW.dhS });
        paramn.AXk.a(a.a.a.BoT, paramString.DFW.dhS, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.DGr;
      if (paramString == null)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramn.AXk.a(a.a.a.BoT, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Ezn != 1)
      {
        ad.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.Ezn) });
        paramn.AXk.a(a.a.a.BoT, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.AXk.a(a.a.a.BoS, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.g.aeS().b(1096, this);
        paramString = (w)paramn;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (bit)paramString.rr.gUS.gUX)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.DFP });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.aDh(bt.nullAsNil(paramString.DFP)) == null)
        {
          ad.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramn = ((w)paramn).AXn;
        paramn.CBy = 1;
        this.BoN.put(paramString.DFP + paramString.url, paramn);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<dji> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void ayq(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        BoS = new a("RET_OK", 0, 0);
        BoT = new a("RET_FAIL", 1, -1);
        BoU = new a("RET_REJECT", 2, -2);
        BoV = new a("RET_ACCESS_DENIED", 3, -3);
        BoW = new a[] { BoS, BoT, BoU, BoV };
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
    public abstract int eiZ();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean BoX = true;
    
    public void ayq(String paramString) {}
    
    public boolean eqe()
    {
      return this.BoX;
    }
    
    public final void tx(boolean paramBoolean)
    {
      this.BoX = paramBoolean;
    }
  }
  
  public static final class d
  {
    public List<String> BoY;
    public List<biv> BoZ;
    public String appId;
    
    public d(String paramString, biq parambiq)
    {
      this.appId = paramString;
      this.BoY = parambiq.DGo;
      this.BoZ = parambiq.DGq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */