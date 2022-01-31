package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.g.a.jf;
import com.tencent.mm.g.a.jf.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.pluginsdk.model.app.aj;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class ac$1$1
  implements Runnable
{
  ac$1$1(ac.1 param1, int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(6327);
    ab.d("MicroMsg.JsApiLaunchApplication", "on RunCgi callback errType:%d errCode:%d msg:%s", new Object[] { Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode), this.ftO });
    if ((this.val$errType != 0) || (this.val$errCode != 0))
    {
      this.uTG.lax.c("check fail", null);
      AppMethodBeat.o(6327);
      return;
    }
    Object localObject3 = (axg)this.fuz.fsW.fta;
    switch (((axg)localObject3).csV)
    {
    case 1: 
    default: 
      this.uTG.lax.c("check fail", null);
      AppMethodBeat.o(6327);
      return;
    case 2: 
      this.uTG.lax.c("check fail forbidden scene", null);
      AppMethodBeat.o(6327);
      return;
    }
    aj localaj = new aj(new ac.1.1.1(this));
    ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((axg)localObject3).xmD), Integer.valueOf(((axg)localObject3).csV) });
    Object localObject1;
    if (!bo.isNullOrNil(this.uTG.hya))
    {
      localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(this.uTG.hya));
      ((Intent)localObject4).addFlags(268435456);
      localObject1 = bo.H(this.uTG.val$context, (Intent)localObject4);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0)); !bo.nullAsNil(ah.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
        {
          localaj.ea(com.tencent.mm.pluginsdk.model.app.g.a(this.uTG.val$context, (Intent)localObject4, null, ((axg)localObject3).xmD, localaj, this.uTG.hyb));
          AppMethodBeat.o(6327);
          return;
        }
      }
    }
    if ((!bo.isNullOrNil(this.uTG.Cl)) && (!bo.isNullOrNil(this.uTG.hyc)))
    {
      localObject1 = p.bv(this.uTG.val$context, this.uTG.Cl);
      if ((localObject1 != null) && (localObject1[0] != null))
      {
        localObject1 = com.tencent.mm.a.g.w(localObject1[0].toByteArray());
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(this.uTG.hyc))) {
          break label947;
        }
        try
        {
          localObject1 = ah.getContext().getPackageManager().getLaunchIntentForPackage(this.uTG.Cl);
          if (localObject1 != null)
          {
            localObject4 = new Bundle();
            p.j((Bundle)localObject4, this.uTG.hyd);
            ((Intent)localObject1).putExtras((Bundle)localObject4);
            ((Intent)localObject1).addFlags(268435456);
            localaj.ea(com.tencent.mm.pluginsdk.model.app.g.a(this.uTG.val$context, (Intent)localObject1, null, localaj, this.uTG.hyb));
            AppMethodBeat.o(6327);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.JsApiLaunchApplication", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
        }
      }
    }
    Object localObject2 = new WXAppExtendObject();
    ((WXAppExtendObject)localObject2).extInfo = this.uTG.hyf;
    localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject2).sdkVer = 620954624;
    ((WXMediaMessage)localObject2).messageExt = this.uTG.hyf;
    Object localObject4 = new jf();
    ((jf)localObject4).cyD.cyF = ((WXMediaMessage)localObject2);
    ((jf)localObject4).cyD.appId = this.uTG.hye;
    ((jf)localObject4).cyD.showType = ((axg)localObject3).xmD;
    ((jf)localObject4).cyD.context = this.uTG.val$context;
    ((jf)localObject4).cyD.cpJ = this.uTG.hyb;
    ((jf)localObject4).cyD.cyG = localaj;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
    boolean bool = ((jf)localObject4).cyE.cyH;
    if ((!bool) && (!bo.isNullOrNil(this.uTG.hye)) && (!bo.isNullOrNil(this.uTG.hyd)))
    {
      localObject2 = this.uTG.hye + "://" + this.uTG.hyd;
      localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
      ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
      ((Intent)localObject3).addFlags(268435456);
      localObject2 = bo.H(this.uTG.val$context, (Intent)localObject3);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject2).get(0));
          label880:
          if (bo.nullAsNil(ah.getPackageName()).equals(localObject2)) {
            break label967;
          }
          localaj.ftW = false;
          localaj.hyp = false;
          localaj.hyq = false;
          localaj.cyH = false;
          bool = com.tencent.mm.pluginsdk.model.app.g.a(this.uTG.val$context, (Intent)localObject3, null, localaj, this.uTG.hyb);
        }
      }
    }
    label947:
    label967:
    for (;;)
    {
      localaj.ea(bool);
      AppMethodBeat.o(6327);
      return;
      ab.i("MicroMsg.JsApiLaunchApplication", "launchApplication signature not match");
      break;
      localObject2 = ((Intent)localObject3).getPackage();
      break label880;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.jsapi.ac.1.1
 * JD-Core Version:    0.7.0.1
 */