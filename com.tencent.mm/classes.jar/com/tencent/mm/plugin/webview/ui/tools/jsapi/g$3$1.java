package com.tencent.mm.plugin.webview.ui.tools.jsapi;

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
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.protocal.protobuf.axg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.List;

final class g$3$1
  implements Runnable
{
  g$3$1(g.3 param3, int paramInt1, int paramInt2, com.tencent.mm.ai.b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(154922);
    if ((this.val$errType != 0) || (this.val$errCode != 0))
    {
      this.vqn.vqm.a(this.vqn.uZa, "launchApplication:fail_check fail", null);
      AppMethodBeat.o(154922);
      return;
    }
    Object localObject3 = (axg)this.fuz.fsW.fta;
    ab.i("MicroMsg.MsgHandler", "launchApplication check result(showType : %d, errCode : %d)", new Object[] { Integer.valueOf(((axg)localObject3).xmD), Integer.valueOf(((axg)localObject3).csV) });
    switch (((axg)localObject3).csV)
    {
    case 1: 
    default: 
      this.vqn.vqm.a(this.vqn.uZa, "launchApplication:fail_check fail", null);
      AppMethodBeat.o(154922);
      return;
    case 2: 
      this.vqn.vqm.a(this.vqn.uZa, "launchApplication:fail_check fail forbidden scene", null);
      AppMethodBeat.o(154922);
      return;
    }
    g.d locald = new g.d(new g.3.1.1(this));
    Object localObject1;
    if (!bo.isNullOrNil(this.vqn.hya))
    {
      localObject4 = new Intent("android.intent.action.VIEW", Uri.parse(this.vqn.hya));
      ((Intent)localObject4).addFlags(268435456);
      localObject1 = bo.H(g.j(this.vqn.vqm), (Intent)localObject4);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
      {
        if ((TextUtils.isEmpty(((Intent)localObject4).getPackage())) && (((List)localObject1).size() == 1)) {}
        for (localObject1 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject1).get(0)); !bo.nullAsNil(ah.getPackageName()).equals(localObject1); localObject1 = ((Intent)localObject4).getPackage())
        {
          locald.ea(com.tencent.mm.pluginsdk.model.app.g.a(g.j(this.vqn.vqm), (Intent)localObject4, null, ((axg)localObject3).xmD, locald, this.vqn.hyb));
          AppMethodBeat.o(154922);
          return;
        }
      }
    }
    if ((!bo.isNullOrNil(this.vqn.Cl)) && (!bo.isNullOrNil(this.vqn.hyc)))
    {
      localObject1 = p.bv(g.j(this.vqn.vqm), this.vqn.Cl);
      if ((localObject1 != null) && (localObject1[0] != null))
      {
        localObject1 = com.tencent.mm.a.g.w(localObject1[0].toByteArray());
        if ((localObject1 == null) || (!((String)localObject1).equalsIgnoreCase(this.vqn.hyc))) {
          break label944;
        }
        try
        {
          localObject1 = ah.getContext().getPackageManager().getLaunchIntentForPackage(this.vqn.Cl);
          if (localObject1 != null)
          {
            localObject4 = new Bundle();
            p.j((Bundle)localObject4, this.vqn.hyd);
            ((Intent)localObject1).putExtras((Bundle)localObject4);
            ((Intent)localObject1).addFlags(268435456);
            locald.ea(com.tencent.mm.pluginsdk.model.app.g.a(g.j(this.vqn.vqm), (Intent)localObject1, null, locald, this.vqn.hyb));
            AppMethodBeat.o(154922);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.e("MicroMsg.MsgHandler", "launchApplication getLaunchIntentForPackage, %s", new Object[] { localException.getMessage() });
        }
      }
    }
    Object localObject2 = new WXAppExtendObject();
    ((WXAppExtendObject)localObject2).extInfo = this.vqn.hyf;
    localObject2 = new WXMediaMessage((WXMediaMessage.IMediaObject)localObject2);
    ((WXMediaMessage)localObject2).sdkVer = 620954624;
    ((WXMediaMessage)localObject2).messageExt = this.vqn.hyf;
    Object localObject4 = new jf();
    ((jf)localObject4).cyD.cyF = ((WXMediaMessage)localObject2);
    ((jf)localObject4).cyD.appId = this.vqn.hye;
    ((jf)localObject4).cyD.showType = ((axg)localObject3).xmD;
    ((jf)localObject4).cyD.context = g.j(this.vqn.vqm);
    ((jf)localObject4).cyD.cpJ = this.vqn.hyb;
    ((jf)localObject4).cyD.cyG = locald;
    a.ymk.l((com.tencent.mm.sdk.b.b)localObject4);
    boolean bool = ((jf)localObject4).cyE.cyH;
    if ((!bool) && (!bo.isNullOrNil(this.vqn.hye)) && (!bo.isNullOrNil(this.vqn.hyd)))
    {
      localObject2 = this.vqn.hye + "://" + this.vqn.hyd;
      localObject3 = new Intent("android.intent.action.VIEW", Uri.parse((String)localObject2));
      ab.i("MicroMsg.MsgHandler", "launchApplication by opensdk failed, try to launch by scheme(%s).", new Object[] { localObject2 });
      ((Intent)localObject3).addFlags(268435456);
      localObject2 = bo.H(g.j(this.vqn.vqm), (Intent)localObject3);
      if ((localObject2 != null) && (!((List)localObject2).isEmpty())) {
        if ((TextUtils.isEmpty(((Intent)localObject3).getPackage())) && (((List)localObject2).size() == 1))
        {
          localObject2 = com.tencent.mm.pluginsdk.model.app.g.b((ResolveInfo)((List)localObject2).get(0));
          label875:
          if (bo.nullAsNil(ah.getPackageName()).equals(localObject2)) {
            break label964;
          }
          locald.ftW = false;
          locald.hyp = false;
          locald.hyq = false;
          locald.cyH = false;
          bool = com.tencent.mm.pluginsdk.model.app.g.a(g.j(this.vqn.vqm), (Intent)localObject3, null, locald, this.vqn.hyb);
        }
      }
    }
    label944:
    label964:
    for (;;)
    {
      locald.ea(bool);
      AppMethodBeat.o(154922);
      return;
      ab.i("MicroMsg.MsgHandler", "launchApplication signature not match");
      break;
      localObject2 = ((Intent)localObject3).getPackage();
      break label875;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.g.3.1
 * JD-Core Version:    0.7.0.1
 */