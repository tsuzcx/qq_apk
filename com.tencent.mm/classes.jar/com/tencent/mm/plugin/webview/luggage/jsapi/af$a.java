package com.tencent.mm.plugin.webview.luggage.jsapi;

import com.tencent.luggage.e.a.a;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.plugin.webview.luggage.permission.LuggageGetA8Key;
import com.tencent.mm.plugin.webview.luggage.r;
import com.tencent.mm.plugin.webview.ui.tools.bag.h;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.d;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.c;
import com.tencent.mm.protocal.c.g;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.protocal.c.arg;
import com.tencent.mm.protocal.c.ccq;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class af$a
  implements b.a
{
  private String appId;
  private com.tencent.luggage.e.a<e>.a rdy;
  
  af$a(com.tencent.luggage.e.a<e>.a parama, String paramString)
  {
    this.rdy = parama;
    this.appId = paramString;
  }
  
  private void tT(String paramString)
  {
    if (bk.bl(paramString)) {
      this.rdy.a("", null);
    }
    for (;;)
    {
      com.tencent.mm.plugin.webview.luggage.c.a.RZ(((e)this.rdy.big).caV());
      this.rdy = null;
      this.appId = null;
      return;
      this.rdy.a(paramString, null);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    if (this.rdy == null) {
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      y.e("MicroMsg.JsApiPreVerify", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      tT(paramString);
      return;
    }
    paramb = (arg)paramb.ecF.ecN;
    if ((paramb == null) || (paramb.tmF == null) || (paramb.tmF.bLB != 0))
    {
      tT(paramString);
      return;
    }
    paramString = ((e)this.rdy.big).rbS;
    Object localObject = this.appId;
    if ((!bk.bl((String)localObject)) && (!bk.bl(paramString.rcp.getUrl()))) {
      paramString.rcS.put(r.RL(paramString.rcp.getUrl()), localObject);
    }
    paramString = new c.d();
    paramString.appId = this.appId;
    paramString.rxz = paramb.tmU;
    localObject = ((e)this.rdy.big).rbS;
    if (!bk.bl(((r)localObject).rcp.getUrl())) {
      ((r)localObject).rcT.put(r.RL(((r)localObject).rcp.getUrl()), paramString);
    }
    localObject = paramb.tmT;
    paramString = ((e)this.rdy.big).caW().RP(((e)this.rdy.big).getUrl());
    if (paramString == null)
    {
      tT("");
      return;
    }
    if (!bk.dk((List)localObject))
    {
      localObject = ((LinkedList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ccq localccq = (ccq)((Iterator)localObject).next();
        c.g localg = c.Xq(localccq.tmz);
        if ((localg != null) && (paramString.ED(localg.coP()) != localccq.state)) {
          paramString.a(localg.coP(), (byte)localccq.state);
        }
      }
    }
    ((e)this.rdy.big).cba().TC(paramb.tmV);
    tT("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.af.a
 * JD-Core Version:    0.7.0.1
 */