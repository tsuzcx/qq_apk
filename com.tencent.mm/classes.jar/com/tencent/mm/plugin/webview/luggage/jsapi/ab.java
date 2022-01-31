package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import com.tencent.luggage.e.a;
import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arr;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.LinkedList;

public class ab
  extends ax<e>
{
  public final void a(Context paramContext, String paramString, aw.a parama) {}
  
  public final int aGj()
  {
    return 0;
  }
  
  public final void b(final a<e>.a parama)
  {
    y.i("MicroMsg.JsApiLogin", "invoke");
    LinkedList localLinkedList = new LinkedList();
    final String str = ((e)parama.big).rbS.getAppId();
    if (bk.bl(str))
    {
      y.e("MicroMsg.JsApiLogin", "appId is null!");
      parama.a("fail", null);
      return;
    }
    com.tencent.mm.ah.b.a locala = new com.tencent.mm.ah.b.a();
    arr localarr = new arr();
    locala.ecH = localarr;
    locala.ecI = new ars();
    locala.uri = "/cgi-bin/mmbiz-bin/js-login";
    locala.ecG = 1029;
    locala.ecJ = 0;
    locala.ecK = 0;
    localarr.euK = str;
    localarr.tmX = localLinkedList;
    localarr.tnc = 0;
    localarr.kSC = "";
    localarr.tnd = "";
    localarr.tmZ = 0;
    com.tencent.mm.ipcinvoker.wx_extension.b.a(locala.Kt(), new com.tencent.mm.ipcinvoker.wx_extension.b.a()
    {
      public final void a(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, com.tencent.mm.ah.b paramAnonymousb)
      {
        y.i("MicroMsg.JsApiLogin", "errType = %d, errCode = %d ,errMsg = %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          parama.a("fail", null);
          return;
        }
        paramAnonymousb = (ars)paramAnonymousb.ecF.ecN;
        if ((paramAnonymousb == null) || (paramAnonymousb.tnb == null))
        {
          parama.a("fail", null);
          return;
        }
        paramAnonymousInt1 = paramAnonymousb.tnb.bLB;
        Object localObject = paramAnonymousb.tnb.bLC;
        paramAnonymousString = paramAnonymousb.tnd;
        y.i("MicroMsg.JsApiLogin", "NetSceneJSLogin jsErrcode %d", new Object[] { Integer.valueOf(paramAnonymousInt1) });
        if (paramAnonymousInt1 == -12000)
        {
          localObject = paramAnonymousb.tab;
          String str = paramAnonymousb.kVn;
          paramAnonymousb = paramAnonymousb.suv;
          y.d("MicroMsg.JsApiLogin", "appName %s, appIconUrl %s", new Object[] { str, paramAnonymousb });
          ai.d(new ab.1.1(this, paramAnonymousString, (LinkedList)localObject, str, paramAnonymousb));
          return;
        }
        if (paramAnonymousInt1 == 0)
        {
          paramAnonymousString = paramAnonymousb.tne;
          new HashMap().put("code", paramAnonymousString);
          y.d("MicroMsg.JsApiLogin", "resp data code [%s]", new Object[] { paramAnonymousString });
          parama.a("", null);
          return;
        }
        y.e("MicroMsg.JsApiLogin", "onSceneEnd NetSceneJSLogin %s", new Object[] { localObject });
        parama.a("fail", null);
      }
    });
  }
  
  public final String name()
  {
    return "login";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ab
 * JD-Core Version:    0.7.0.1
 */