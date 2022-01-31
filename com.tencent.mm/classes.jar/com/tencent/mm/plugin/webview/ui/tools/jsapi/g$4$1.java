package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.h.a.iw;
import com.tencent.mm.h.a.iw.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.protocal.c.arb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class g$4$1
  implements Runnable
{
  g$4$1(g.4 param4, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.b paramb) {}
  
  public final void run()
  {
    y.d("MicroMsg.MsgHandler", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(this.bEf), Integer.valueOf(this.bEg), this.edL });
    if ((this.bEf != 0) || (this.bEg != 0))
    {
      g.a(this.rzl.rzi, this.rzl.rzk, "launchApplication:fail_check fail", null);
      return;
    }
    Object localObject2 = (arb)this.eew.ecF.ecN;
    switch (((arb)localObject2).bLB)
    {
    case 1: 
    default: 
      g.a(this.rzl.rzi, this.rzl.rzk, "launchApplication:fail_check fail", null);
      return;
    case 2: 
      g.a(this.rzl.rzi, this.rzl.rzk, "launchApplication:fail_check fail forbidden scene", null);
      return;
    }
    g.d locald = new g.d(new g.4.1.1(this));
    y.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((arb)localObject2).tmN), Integer.valueOf(((arb)localObject2).bLB) });
    if (!bk.bl(this.rzl.ggc))
    {
      localObject3 = new Intent("android.intent.action.VIEW", Uri.parse(this.rzl.ggc));
      ((Intent)localObject3).addFlags(268435456);
      localObject1 = bk.A(g.i(this.rzl.rzi), (Intent)localObject3);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0)); !bk.pm(ae.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject3).getPackage())
        {
          locald.cX(com.tencent.mm.pluginsdk.model.app.g.a(g.i(this.rzl.rzi), (Intent)localObject3, null, ((arb)localObject2).tmN, locald, this.rzl.ggd));
          return;
        }
      }
    }
    Object localObject1 = new WXAppExtendObject();
    ((WXAppExtendObject)localObject1).extInfo = this.rzl.ggg;
    localObject1 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject1);
    ((WXMediaMessage)localObject1).sdkVer = 620824064;
    ((WXMediaMessage)localObject1).messageExt = this.rzl.ggg;
    Object localObject3 = new iw();
    ((iw)localObject3).bRb.bRd = ((WXMediaMessage)localObject1);
    ((iw)localObject3).bRb.appId = this.rzl.gge;
    ((iw)localObject3).bRb.showType = ((arb)localObject2).tmN;
    ((iw)localObject3).bRb.context = g.i(this.rzl.rzi);
    ((iw)localObject3).bRb.bIo = this.rzl.ggd;
    ((iw)localObject3).bRb.bRe = locald;
    a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
    boolean bool = ((iw)localObject3).bRc.bRf;
    if (!bool)
    {
      localObject1 = this.rzl.gge + "://" + this.rzl.ggf;
      localObject2 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject1));
      y.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject1 });
      ((Intent)localObject2).addFlags(268435456);
      localObject1 = bk.A(g.i(this.rzl.rzi), (Intent)localObject2);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        if ((TextUtils.isEmpty(((Intent)localObject2).getPackage())) && (((List)localObject1).size() == 1))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0));
          if (bk.pm(ae.getPackageName()).equals(localObject1)) {
            break label741;
          }
          locald.edU = false;
          locald.ggq = false;
          locald.ggr = false;
          locald.bRf = false;
          bool = com.tencent.mm.pluginsdk.model.app.g.a(g.i(this.rzl.rzi), (Intent)localObject2, null, locald, this.rzl.ggd);
        }
      }
    }
    label741:
    for (;;)
    {
      locald.cX(bool);
      return;
      localObject1 = ((Intent)localObject2).getPackage();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.4.1
 * JD-Core Version:    0.7.0.1
 */