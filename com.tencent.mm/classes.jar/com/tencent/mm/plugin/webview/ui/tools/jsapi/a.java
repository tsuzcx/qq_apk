package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
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
import com.tencent.mm.protocal.protobuf.brc;
import com.tencent.mm.protocal.protobuf.brd;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.brm;
import com.tencent.mm.protocal.protobuf.bro;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.brr;
import com.tencent.mm.protocal.protobuf.bse;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class a
  implements com.tencent.mm.ak.f
{
  private final HashMap<String, brc> ECK;
  private final HashMap<String, String> ECL;
  private com.tencent.mm.plugin.webview.stub.f EfN;
  private final HashMap<String, d> Eip;
  final int EkX;
  private Context context;
  
  public a(int paramInt)
  {
    AppMethodBeat.i(81013);
    this.ECK = new HashMap();
    this.ECL = new HashMap();
    this.Eip = new HashMap();
    this.EkX = paramInt;
    AppMethodBeat.o(81013);
  }
  
  private void a(int paramInt1, final int paramInt2, final String paramString, final t paramt)
  {
    AppMethodBeat.i(81016);
    if (paramt == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      AppMethodBeat.o(81016);
      return;
    }
    int j = 0;
    int i = j;
    if (paramt.eTK() != null)
    {
      i = j;
      if (paramt.eTK().Heq != null) {
        i = paramt.eTK().Heq.drN;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramt.EkV.a(a.a.a.ECQ, paramString, null, paramInt2, i);
        AppMethodBeat.o(81016);
        return;
      }
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (bu.isNullOrNil(paramt.EkW))
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramt.eTK();
    if ((paramString == null) || (paramString.Heq == null))
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.Heq.drN != 0)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Heq.drN), paramString.Heq.drO });
      paramt.EkV.a(a.a.a.ECQ, paramString.Heq.drO, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramt.eTJ() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramt.eTJ().Heo)
    {
      ae.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label560;
      }
      if (paramString.Het != null) {
        break;
      }
      ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Het.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (bse)paramString.next();
      if (((bse)localObject).Hfm == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((bse)localObject).Hfm.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bu.isNullOrNil(str))
          {
            brc localbrc = new brc();
            localbrc.Hej = str;
            localbrc.FRO = ((bse)localObject).Hfl;
            localbrc.Hek = ((bse)localObject).yTx;
            this.ECK.put(localbrc.Hej + paramt.url, localbrc);
          }
        }
      }
    }
    label560:
    if (paramString.Her == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramt.EkV.a(a.a.a.ECQ, "nullAuthInfo", null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    paramString = paramString.Her.iterator();
    while (paramString.hasNext())
    {
      localObject = (brc)paramString.next();
      if (!bu.isNullOrNil(((brc)localObject).Hej)) {
        this.ECK.put(((brc)localObject).Hej + paramt.url, localObject);
      }
    }
    paramString = (brc)this.ECK.get(paramt.EkW + paramt.url);
    if (paramString == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramt.EkW, paramt.url });
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (paramString.FRO == 1)
    {
      paramt.EkV.a(a.a.a.ECP, null, null, paramInt2, i);
      AppMethodBeat.o(81016);
      return;
    }
    if (this.context == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(paramt, paramInt2, paramString);
      AppMethodBeat.o(81016);
      return;
    }
    WebViewStubTempUI.a(this.context, this.EfN, bu.nullAsNil(paramString.Hek), "", this.context.getString(2131760582), this.context.getString(2131760581), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81006);
        ae.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click ok");
        a.this.a(paramt, paramInt2, paramString);
        AppMethodBeat.o(81006);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(81007);
        ae.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramt.EkV.a(a.a.a.ECR, "cancel", null, paramInt2, paramt.eTK().Heq.drN);
        AppMethodBeat.o(81007);
      }
    });
    AppMethodBeat.o(81016);
  }
  
  private static String aIw(String paramString)
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
    this.EfN = paramf;
  }
  
  final void a(t paramt, int paramInt, brc parambrc)
  {
    AppMethodBeat.i(81017);
    brd localbrd = paramt.eTJ();
    Object localObject = paramt.eTK();
    if (localbrd == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt, paramt.eTK().Heq.drN);
      AppMethodBeat.o(81017);
      return;
    }
    if (localObject == null)
    {
      ae.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramt.EkV.a(a.a.a.ECQ, null, null, paramInt, paramt.eTK().Heq.drN);
      AppMethodBeat.o(81017);
      return;
    }
    com.tencent.mm.kernel.g.ajj().a(1096, this);
    localObject = ((bre)localObject).Het;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      bse localbse;
      while (localIterator.hasNext())
      {
        localbse = (bse)localIterator.next();
        if (localbse != null)
        {
          ae.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbse.Hfm, localbse.scope, localbse.yTx, Integer.valueOf(localbse.Hfl), localbrd.Hej });
          localbse.Hfl = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localbse = (bse)localIterator.next();
        if (localbse != null) {
          ae.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localbse.Hfm, localbse.scope, localbse.yTx, Integer.valueOf(localbse.Hfl), localbrd.Hej });
        }
      }
    }
    parambrc = new w(parambrc, localbrd.url, localbrd.Hep, localbrd.gvv, localbrd.Hej, localbrd.cVJ, localbrd.Hel, localbrd.signature, localbrd.Hem, localbrd.Hen, localbrd.Heo, (LinkedList)localObject, this.EkX);
    com.tencent.mm.kernel.g.ajj().a(parambrc, 0);
    paramt.EkV.a(a.a.a.ECP, null, null, paramInt, paramt.eTK().Heq.drN);
    AppMethodBeat.o(81017);
  }
  
  public final void a(JsapiPermissionWrapper paramJsapiPermissionWrapper, String paramString1, String paramString2, int paramInt, l paraml, a parama)
  {
    AppMethodBeat.i(198432);
    if (paraml != null) {}
    for (String str2 = paraml.lcx;; str2 = "")
    {
      if (bu.isNullOrNil(str2))
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "jsapi is null, %s", new Object[] { paramString1 });
        parama.a(a.a.a.ECS, null, null, 0, 0);
        AppMethodBeat.o(198432);
        return;
      }
      if ((paramJsapiPermissionWrapper == null) || (bu.isNullOrNil(paramString1)) || (paraml == null) || (paramJsapiPermissionWrapper.FGf == null))
      {
        if (paramJsapiPermissionWrapper != null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.e("MicroMsg.webview.JSVerifyHelper", "handleJSVerify invalid argument, currentUrl = %s, jsapi = %s, %s", new Object[] { paramString1, str2, Boolean.valueOf(bool) });
          parama.a(a.a.a.ECQ, "localParameters", null, 0, 0);
          AppMethodBeat.o(198432);
          return;
        }
      }
      int i = paramJsapiPermissionWrapper.aah(paramInt);
      ae.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify jsApi = %s, permission pos = %d, permission = %s currentUrl = %s", new Object[] { str2, Integer.valueOf(paramInt), Integer.valueOf(i), paramString1 });
      paramJsapiPermissionWrapper = (String)this.ECL.get(paramString1);
      if (bu.isNullOrNil(paramJsapiPermissionWrapper)) {
        paramJsapiPermissionWrapper = (String)paraml.xqN.get("verifyAppId");
      }
      for (;;)
      {
        Object localObject1 = paraml.EfA;
        ((Map)localObject1).put("permissionValue", Integer.valueOf(i));
        ((Map)localObject1).put("appId", paramJsapiPermissionWrapper);
        Object localObject3 = paramString1;
        switch (i)
        {
        default: 
          parama.a(a.a.a.ECQ, "unkonwPermission_".concat(String.valueOf(i)), null, 0, 0);
          ae.e("MicroMsg.webview.JSVerifyHelper", "unknow permission");
          AppMethodBeat.o(198432);
          return;
        case 1: 
          parama.a(a.a.a.ECP, null, null, 0, 0);
          AppMethodBeat.o(198432);
          return;
        case 2: 
          if (str2.equals("preVerifyJSAPI"))
          {
            parama.a(a.a.a.ECP, null, null, 0, 0);
            AppMethodBeat.o(198432);
            return;
          }
          parama.a(a.a.a.ECS, null, null, 0, 0);
          AppMethodBeat.o(198432);
          return;
        case 0: 
          parama.a(a.a.a.ECS, null, null, 0, 0);
          AppMethodBeat.o(198432);
          return;
        case 4: 
          localObject2 = (String)paraml.xqN.get("url");
          localObject1 = paramString1;
          if (!bu.lX((String)localObject2, paramString1)) {
            if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qAy, 1) != 1) {
              break label616;
            }
          }
          label616:
          for (paramInt = 1;; paramInt = 0)
          {
            localObject1 = paramString1;
            if (paramInt != 0)
            {
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1200L, 103L, 1L, false);
              ae.i("MicroMsg.webview.JSVerifyHelper", "useWvUrl currentUrl %s, wvUrl %s", new Object[] { paramString1, localObject2 });
              localObject1 = localObject2;
            }
            paramString1 = (brc)this.ECK.get(str2 + (String)localObject1);
            localObject3 = localObject1;
            if (paramString1 == null) {
              break;
            }
            localObject3 = localObject1;
            if (paramString1.FRO != 1) {
              break;
            }
            parama.a(a.a.a.ECP, null, null, 0, 0);
            AppMethodBeat.o(198432);
            return;
          }
        }
        paramString1 = (String)paraml.xqN.get("verifySignature");
        localObject1 = (String)paraml.xqN.get("verifyNonceStr");
        Object localObject2 = (String)paraml.xqN.get("verifyTimestamp");
        String str1 = (String)paraml.xqN.get("verifySignType");
        String str4 = (String)paraml.xqN.get("scope");
        String str3 = (String)paraml.xqN.get("addrSign");
        ae.i("MicroMsg.webview.JSVerifyHelper", "handleJSVerify addrSign = %s, signature = %s", new Object[] { str3, paramString1 });
        paramInt = 0;
        if ((bu.isNullOrNil(paramString1)) && (!bu.isNullOrNil(str3)))
        {
          paramInt = 1;
          paramJsapiPermissionWrapper = (String)paraml.xqN.get("appId");
          localObject2 = (String)paraml.xqN.get("addrSign");
          str1 = (String)paraml.xqN.get("signType");
          paramString1 = (String)paraml.xqN.get("timeStamp");
          localObject1 = (String)paraml.xqN.get("nonceStr");
        }
        for (;;)
        {
          str3 = null;
          JSONObject localJSONObject = l.a.bf(paraml.xqN);
          paraml = str3;
          if (localJSONObject != null) {
            paraml = localJSONObject.toString().getBytes();
          }
          if (i == 4)
          {
            paramJsapiPermissionWrapper = new t(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, paramInt, str4, this.EkX);
            com.tencent.mm.kernel.g.ajj().a(1095, this);
            com.tencent.mm.kernel.g.ajj().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(198432);
            return;
            if (!bu.isNullOrNil(paramString1))
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
            paramJsapiPermissionWrapper = new v(parama, (String)localObject3, paramString2, paramJsapiPermissionWrapper, str2, paramString1, (String)localObject1, (String)localObject2, str1, paraml, this.EkX);
            com.tencent.mm.kernel.g.ajj().a(1094, this);
            com.tencent.mm.kernel.g.ajj().a(paramJsapiPermissionWrapper, 0);
            AppMethodBeat.o(198432);
            return;
          }
          str3 = paramString1;
          paramString1 = (String)localObject2;
          localObject2 = str3;
        }
      }
    }
  }
  
  public final d aKA(String paramString)
  {
    AppMethodBeat.i(81012);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(81012);
      return null;
    }
    d locald2 = (d)this.Eip.get(paramString);
    d locald1 = locald2;
    if (locald2 == null)
    {
      paramString = aIw(paramString);
      locald1 = (d)this.Eip.get(paramString);
    }
    AppMethodBeat.o(81012);
    return locald1;
  }
  
  public final String aKz(String paramString)
  {
    AppMethodBeat.i(81011);
    if (paramString == null)
    {
      AppMethodBeat.o(81011);
      return null;
    }
    String str2 = (String)this.ECL.get(paramString);
    String str1 = str2;
    if (bu.isNullOrNil(str2))
    {
      String str3 = aIw(paramString);
      ae.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str2, paramString, str3 });
      str1 = str2;
      if (!bu.isNullOrNil(str3)) {
        str1 = (String)this.ECL.get(str3);
      }
    }
    AppMethodBeat.o(81011);
    return str1;
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(81014);
    ae.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramn.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramn instanceof b))
    {
      ae.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      AppMethodBeat.o(81014);
      return;
    }
    if (((b)paramn).eQU() != this.EkX)
    {
      ae.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.EkX), Integer.valueOf(((b)paramn).eQU()) });
      AppMethodBeat.o(81014);
      return;
    }
    int i = paramn.getType();
    if (i == 1093)
    {
      com.tencent.mm.kernel.g.ajj().b(1093, this);
      paramn = (u)paramn;
      if (paramn == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "");
        AppMethodBeat.o(81014);
        return;
      }
      if (paramn.EkV == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        AppMethodBeat.o(81014);
        return;
      }
      int j = 0;
      i = j;
      if (paramn.eTL() != null)
      {
        i = j;
        if (paramn.eTL().Heq != null) {
          i = paramn.eTL().Heq.drN;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramn.EkV.a(a.a.a.ECQ, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      brm localbrm = paramn.eTL();
      boolean bool1;
      label390:
      boolean bool3;
      if (paramn.rr == null)
      {
        paramString = null;
        if ((localbrm != null) && (!bu.isNullOrNil(paramn.mzb)) && (paramString != null) && (!bu.isNullOrNil(paramString.dwb))) {
          break label498;
        }
        if (localbrm != null) {
          break label486;
        }
        bool1 = true;
        bool3 = bu.isNullOrNil(paramn.mzb);
        if (paramString != null) {
          break label492;
        }
      }
      label486:
      label492:
      for (boolean bool2 = true;; bool2 = false)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramn.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
        paramString = (brl)paramn.rr.hQD.hQJ;
        break;
        bool1 = false;
        break label390;
      }
      label498:
      if (localbrm.Heq == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramn.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (localbrm.Heq.drN != 0)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localbrm.Heq.drN), localbrm.Heq.drO });
        paramn.EkV.a(a.a.a.ECQ, localbrm.Heq.drO, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.EkV.aKB(localbrm.HeJ);
      this.ECL.put(aIw(paramString.url), paramString.dwb);
      d locald = new d(paramString.dwb, localbrm);
      this.Eip.put(aIw(paramString.url), locald);
      this.Eip.put(aIw(paramString.Hep), locald);
      paramn.EkV.a(a.a.a.ECP, null, localbrm.HeH, paramInt2, i);
      ae.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1095)
    {
      com.tencent.mm.kernel.g.ajj().b(1095, this);
      a(paramInt1, paramInt2, paramString, (t)paramn);
      AppMethodBeat.o(81014);
      return;
    }
    if (i == 1094)
    {
      com.tencent.mm.kernel.g.ajj().b(1094, this);
      paramn = (v)paramn;
      if (paramn == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        AppMethodBeat.o(81014);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(157L, 24L, 1L, false);
      if ((paramn.eTM() == null) || (paramn.eTM().Heq == null)) {
        break label1476;
      }
    }
    label1476:
    for (i = paramn.eTM().Heq.drN;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramn.EkV.a(a.a.a.ECQ, paramInt2 + "_" + paramString, null, paramInt2, i);
          AppMethodBeat.o(81014);
          return;
        }
        paramn.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramn.eTM();
      if ((paramString == null) || (paramString.Heq == null))
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramn.EkV.a(a.a.a.ECQ, null, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.Heq.drN != 0)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.Heq.drN), paramString.Heq.drO });
        paramn.EkV.a(a.a.a.ECQ, paramString.Heq.drO, null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramString = paramString.HeL;
      if (paramString == null)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramn.EkV.a(a.a.a.ECQ, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      if (paramString.IaU != 1)
      {
        ae.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.IaU) });
        paramn.EkV.a(a.a.a.ECQ, "verifyFail", null, paramInt2, i);
        AppMethodBeat.o(81014);
        return;
      }
      paramn.EkV.a(a.a.a.ECP, null, null, paramInt2, i);
      AppMethodBeat.o(81014);
      return;
      if (i == 1096)
      {
        com.tencent.mm.kernel.g.ajj().b(1096, this);
        paramString = (w)paramn;
        if (paramString.rr == null) {}
        for (paramString = null; paramString == null; paramString = (brp)paramString.rr.hQD.hQJ)
        {
          ae.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
          AppMethodBeat.o(81014);
          return;
        }
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          ae.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.Hej });
          AppMethodBeat.o(81014);
          return;
        }
        if (c.aPy(bu.nullAsNil(paramString.Hej)) == null)
        {
          ae.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
          AppMethodBeat.o(81014);
          return;
        }
        paramn = ((w)paramn).EkY;
        paramn.FRO = 1;
        this.ECK.put(paramString.Hej + paramString.url, paramn);
      }
      AppMethodBeat.o(81014);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(a parama, String paramString, LinkedList<dvl> paramLinkedList, int paramInt1, int paramInt2);
    
    public abstract void aKB(String paramString);
    
    public static enum a
    {
      private int code;
      
      static
      {
        AppMethodBeat.i(81010);
        ECP = new a("RET_OK", 0, 0);
        ECQ = new a("RET_FAIL", 1, -1);
        ECR = new a("RET_REJECT", 2, -2);
        ECS = new a("RET_ACCESS_DENIED", 3, -3);
        ECT = new a[] { ECP, ECQ, ECR, ECS };
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
    public abstract int eQU();
  }
  
  public static abstract class c
    implements a.a
  {
    public boolean ECU = true;
    
    public void aKB(String paramString) {}
    
    public boolean eYh()
    {
      return this.ECU;
    }
    
    public final void vt(boolean paramBoolean)
    {
      this.ECU = paramBoolean;
    }
  }
  
  public static final class d
  {
    public List<String> ECV;
    public List<brr> ECW;
    public String appId;
    
    public d(String paramString, brm parambrm)
    {
      this.appId = paramString;
      this.ECV = parambrm.HeI;
      this.ECW = parambrm.HeK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.a
 * JD-Core Version:    0.7.0.1
 */