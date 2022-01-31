package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.q;
import com.tencent.mm.plugin.webview.model.r;
import com.tencent.mm.plugin.webview.model.s;
import com.tencent.mm.plugin.webview.stub.WebViewStubTempUI;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.protocal.c.aqw;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.ari;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.arx;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class c
  implements f
{
  private Context context;
  final HashMap<String, c.d> rcT = new HashMap();
  final int rfv;
  private e rgh;
  final HashMap<String, aqw> rxo = new HashMap();
  final HashMap<String, String> rxp = new HashMap();
  
  public c(int paramInt)
  {
    this.rfv = paramInt;
  }
  
  static String RL(String paramString)
  {
    int i = paramString.indexOf("#");
    if (i < 0) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  private void a(int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.plugin.webview.model.p paramp)
  {
    if (paramp == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth scene is null");
      return;
    }
    int j = 0;
    int i = j;
    if (paramp.cbJ() != null)
    {
      i = j;
      if (paramp.cbJ().tmF != null) {
        i = paramp.cbJ().tmF.bLB;
      }
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth netscene error, %s, %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      if (paramInt1 == 4)
      {
        paramp.rft.a(c.a.a.rxu, paramString, null, paramInt2, i);
        return;
      }
      paramp.rft.a(c.a.a.rxu, null, null, paramInt2, i);
      return;
    }
    if (bk.bl(paramp.rfu))
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "scene.jsapi is null or nil.");
      paramp.rft.a(c.a.a.rxu, null, null, paramInt2, i);
      return;
    }
    paramString = paramp.cbJ();
    if ((paramString == null) || (paramString.tmF == null))
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth resp is null");
      paramp.rft.a(c.a.a.rxu, null, null, paramInt2, i);
      return;
    }
    if (paramString.tmF.bLB != 0)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "auth jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.tmF.bLB), paramString.tmF.bLC });
      paramp.rft.a(c.a.a.rxu, paramString.tmF.bLC, null, paramInt2, i);
      return;
    }
    if (paramp.cbI() == null) {}
    for (paramInt1 = 0;; paramInt1 = paramp.cbI().tmE)
    {
      y.i("MicroMsg.webview.JSVerifyHelper", "signature flag : %d.", new Object[] { Integer.valueOf(paramInt1) });
      if (paramInt1 != 1) {
        break label520;
      }
      if (paramString.tmI != null) {
        break;
      }
      y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPI scope_auth_info is null.");
      paramp.rft.a(c.a.a.rxu, null, null, paramInt2, i);
      return;
    }
    paramString = paramString.tmI.iterator();
    Object localObject;
    while (paramString.hasNext())
    {
      localObject = (arx)paramString.next();
      if (((arx)localObject).tnl == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "authInfo.apiname is null.");
      }
      else
      {
        Iterator localIterator = ((arx)localObject).tnl.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!bk.bl(str))
          {
            aqw localaqw = new aqw();
            localaqw.tmz = str;
            localaqw.syA = ((arx)localObject).tnk;
            localaqw.tmA = ((arx)localObject).nRj;
            this.rxo.put(localaqw.tmz + paramp.url, localaqw);
          }
        }
      }
    }
    label520:
    if (paramString.tmG == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIAuth auth_info is null");
      paramp.rft.a(c.a.a.rxu, "nullAuthInfo", null, paramInt2, i);
      return;
    }
    paramString = paramString.tmG.iterator();
    while (paramString.hasNext())
    {
      localObject = (aqw)paramString.next();
      if (!bk.bl(((aqw)localObject).tmz)) {
        this.rxo.put(((aqw)localObject).tmz + paramp.url, localObject);
      }
    }
    paramString = (aqw)this.rxo.get(paramp.rfu + paramp.url);
    if (paramString == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "The JSAPIAuthInfo is null. (jsapi : %s , url : %s)", new Object[] { paramp.rfu, paramp.url });
      paramp.rft.a(c.a.a.rxu, null, null, paramInt2, i);
      return;
    }
    if (paramString.syA == 1)
    {
      paramp.rft.a(c.a.a.rxt, null, null, paramInt2, i);
      return;
    }
    if (this.context == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "JSVerify context not activity");
      a(paramp, paramInt2, paramString);
      return;
    }
    WebViewStubTempUI.a(this.context, this.rgh, bk.pm(paramString.tmA), "", this.context.getString(R.l.js_oauth_yes), this.context.getString(R.l.js_oauth_no), new c.1(this, paramp, paramInt2, paramString), new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        y.i("MicroMsg.webview.JSVerifyHelper", "showDlgForJSVerify click cancel");
        paramp.rft.a(c.a.a.rxv, "cancel", null, paramInt2, paramp.cbJ().tmF.bLB);
      }
    });
  }
  
  public final String TL(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    String str2;
    do
    {
      String str1;
      do
      {
        return localObject;
        str1 = (String)this.rxp.get(paramString);
        localObject = str1;
      } while (!bk.bl(str1));
      str2 = RL(paramString);
      y.i("MicroMsg.webview.JSVerifyHelper", "appid = %s, url = %s, drophash url = %s", new Object[] { str1, paramString, str2 });
      localObject = str1;
    } while (bk.bl(str2));
    return (String)this.rxp.get(str2);
  }
  
  final void a(Context paramContext, e parame)
  {
    this.context = paramContext;
    this.rgh = parame;
  }
  
  final void a(com.tencent.mm.plugin.webview.model.p paramp, int paramInt, aqw paramaqw)
  {
    aqx localaqx = paramp.cbI();
    Object localObject = paramp.cbJ();
    if (localaqx == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "authReq is null");
      paramp.rft.a(c.a.a.rxu, null, null, paramInt, paramp.cbJ().tmF.bLB);
      return;
    }
    if (localObject == null)
    {
      y.e("MicroMsg.webview.JSVerifyHelper", "authResp is null");
      paramp.rft.a(c.a.a.rxu, null, null, paramInt, paramp.cbJ().tmF.bLB);
      return;
    }
    au.Dk().a(1096, this);
    localObject = ((aqy)localObject).tmI;
    if (localObject != null)
    {
      Iterator localIterator = ((LinkedList)localObject).iterator();
      arx localarx;
      while (localIterator.hasNext())
      {
        localarx = (arx)localIterator.next();
        if (localarx != null)
        {
          y.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localarx.tnl, localarx.scope, localarx.nRj, Integer.valueOf(localarx.tnk), localaqx.tmz });
          localarx.tnk = 1;
        }
      }
      localIterator = ((LinkedList)localObject).iterator();
      while (localIterator.hasNext())
      {
        localarx = (arx)localIterator.next();
        if (localarx != null) {
          y.i("MicroMsg.webview.JSVerifyHelper", "apiname = %s, scope = %s, scope desc = %s, status = %d, now jsapi name = %s", new Object[] { localarx.tnl, localarx.scope, localarx.nRj, Integer.valueOf(localarx.tnk), localaqx.tmz });
        }
      }
    }
    paramaqw = new s(paramaqw, localaqx.url, localaqx.kRX, localaqx.tmz, localaqx.bIK, localaqx.tmB, localaqx.signature, localaqx.tmC, localaqx.tmD, localaqx.tmE, (LinkedList)localObject, this.rfv);
    au.Dk().a(paramaqw, 0);
    paramp.rft.a(c.a.a.rxt, null, null, paramInt, paramp.cbJ().tmF.bLB);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: type[%d], errType[%s], errCode[%s], errMsg[%s]", new Object[] { Integer.valueOf(paramm.getType()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (!(paramm instanceof c.b))
    {
      y.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: net scene type mismatched, return");
      return;
    }
    if (((c.b)paramm).cbK() != this.rfv)
    {
      y.i("MicroMsg.webview.JSVerifyHelper", "JSVerifyHelper onSceneEnd: this.binderId = %d, incoming binderId = %d, not equal, return", new Object[] { Integer.valueOf(this.rfv), Integer.valueOf(((c.b)paramm).cbK()) });
      return;
    }
    int i = paramm.getType();
    if (i == 1093)
    {
      au.Dk().b(1093, this);
      paramm = (q)paramm;
      if (paramm == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "");
        return;
      }
      if (paramm.rft == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify, VerifyCallback is null");
        return;
      }
      int j = 0;
      i = j;
      if (paramm.cbL() != null)
      {
        i = j;
        if (paramm.cbL().tmF != null) {
          i = paramm.cbL().tmF.bLB;
        }
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        if (paramInt1 == 4)
        {
          paramm.rft.a(c.a.a.rxu, paramInt2 + "_" + paramString, null, paramInt2, i);
          return;
        }
        paramm.rft.a(c.a.a.rxu, null, null, paramInt2, i);
        return;
      }
      arg localarg = paramm.cbL();
      boolean bool1;
      label348:
      boolean bool3;
      if (paramm.dmK == null)
      {
        paramString = null;
        if ((localarg != null) && (!bk.bl(paramm.gZO)) && (paramString != null) && (!bk.bl(paramString.bOL))) {
          break label450;
        }
        if (localarg != null) {
          break label438;
        }
        bool1 = true;
        bool3 = bk.bl(paramm.gZO);
        if (paramString != null) {
          break label444;
        }
      }
      label438:
      label444:
      for (boolean bool2 = true;; bool2 = false)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "something null %b, %b, %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
        paramm.rft.a(c.a.a.rxu, null, null, paramInt2, i);
        return;
        paramString = (arf)paramm.dmK.ecE.ecN;
        break;
        bool1 = false;
        break label348;
      }
      label450:
      if (localarg.tmF == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "jsapi_baseresponse null");
        paramm.rft.a(c.a.a.rxu, null, null, paramInt2, i);
        return;
      }
      if (localarg.tmF.bLB != 0)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "jsapi baseresponse errcode fail : %d, errmsg = %s", new Object[] { Integer.valueOf(localarg.tmF.bLB), localarg.tmF.bLC });
        paramm.rft.a(c.a.a.rxu, localarg.tmF.bLC, null, paramInt2, i);
        return;
      }
      paramm.rft.TM(localarg.tmV);
      this.rxp.put(RL(paramString.url), paramString.bOL);
      c.d locald = new c.d();
      locald.appId = paramString.bOL;
      locald.rxz = localarg.tmU;
      this.rcT.put(RL(paramString.url), locald);
      paramm.rft.a(c.a.a.rxt, null, localarg.tmT, paramInt2, i);
      y.d("MicroMsg.webview.JSVerifyHelper", "dealJSAPIPreVerify url is %s", new Object[] { paramString.url });
      return;
    }
    if (i == 1095)
    {
      au.Dk().b(1095, this);
      a(paramInt1, paramInt2, paramString, (com.tencent.mm.plugin.webview.model.p)paramm);
      return;
    }
    if (i == 1094)
    {
      au.Dk().b(1094, this);
      paramm = (r)paramm;
      if (paramm == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify scene is null");
        return;
      }
      h.nFQ.a(157L, 24L, 1L, false);
      if ((paramm.cbM() == null) || (paramm.cbM().tmF == null)) {
        break label1328;
      }
    }
    label1328:
    for (i = paramm.cbM().tmF.bLB;; i = 0)
    {
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify netscene error", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        h.nFQ.a(157L, 25L, 1L, false);
        if (paramInt1 == 4)
        {
          paramm.rft.a(c.a.a.rxu, paramInt2 + "_" + paramString, null, paramInt2, i);
          return;
        }
        paramm.rft.a(c.a.a.rxu, null, null, paramInt2, i);
        return;
      }
      paramString = paramm.cbM();
      if ((paramString == null) || (paramString.tmF == null))
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "dealJSAPIRealtimeVerify resp is null");
        paramm.rft.a(c.a.a.rxu, null, null, paramInt2, i);
        return;
      }
      if (paramString.tmF.bLB != 0)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "realtime jsapi_baseresponse %s, %s", new Object[] { Integer.valueOf(paramString.tmF.bLB), paramString.tmF.bLC });
        paramm.rft.a(c.a.a.rxu, paramString.tmF.bLC, null, paramInt2, i);
        return;
      }
      paramString = paramString.tmW;
      if (paramString == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, vInfo is null");
        paramm.rft.a(c.a.a.rxu, "verifyFail", null, paramInt2, i);
        return;
      }
      if (paramString.tRH != 1)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "realtime not ok, %s", new Object[] { Integer.valueOf(paramString.tRH) });
        paramm.rft.a(c.a.a.rxu, "verifyFail", null, paramInt2, i);
        return;
      }
      paramm.rft.a(c.a.a.rxt, null, null, paramInt2, i);
      return;
      if (i != 1096) {
        break;
      }
      au.Dk().b(1096, this);
      paramString = (s)paramm;
      if (paramString.dmK == null) {}
      for (paramString = null; paramString == null; paramString = (arj)paramString.dmK.ecE.ecN)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, setAuthReq is null");
        return;
      }
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s], %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString.tmz });
        return;
      }
      if (com.tencent.mm.protocal.c.Xq(bk.pm(paramString.tmz)) == null)
      {
        y.e("MicroMsg.webview.JSVerifyHelper", "JSAPISetOAuth, errType[%s], errCode[%s]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        return;
      }
      paramm = ((s)paramm).rfw;
      paramm.syA = 1;
      this.rxo.put(paramString.tmz + paramString.url, paramm);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void TM(String paramString);
    
    public abstract void a(c.a.a parama, String paramString, LinkedList<ccq> paramLinkedList, int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.c
 * JD-Core Version:    0.7.0.1
 */