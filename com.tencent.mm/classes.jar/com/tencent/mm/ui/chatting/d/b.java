package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bu;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.d.a.a(fFo=com.tencent.mm.ui.chatting.d.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.d.b.b
{
  private ar JGs;
  private final k.a JGt;
  private final k.a JGu;
  private com.tencent.mm.plugin.wallet.a yad;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.yad = null;
    this.JGs = null;
    this.JGt = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35069);
        ad.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((k)b.this.cWM.bh(k.class)).fCo();
        AppMethodBeat.o(35069);
      }
    };
    this.JGu = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35070);
        ad.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((k)b.this.cWM.bh(k.class)).fCo();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(bu parambu, g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!parambu.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    ad.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambu = new Intent("android.intent.action.MAIN", null);
    parambu.addCategory("android.intent.category.LAUNCHER");
    parambu.addFlags(268435456);
    parambu.setClassName("com.tencent.mobileqq", ba(this.cWM.JOR.getContext(), "com.tencent.mobileqq"));
    parambu.putExtra("platformId", "wechat");
    ba.aBQ();
    paramg = com.tencent.mm.model.c.ajl().get(9, null);
    int i;
    if ((paramg != null) && ((paramg instanceof Integer))) {
      i = ((Integer)paramg).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramg = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramg.length) {
            break;
          }
          paramg[i] = ((byte)(m ^ paramg[i]));
          j += 1;
          i += 1;
        }
        parambu.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.cWM.JOR;
            parambu = new com.tencent.mm.hellhoundlib.b.a().bc(parambu);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambu.ahp(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambu.mq(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            ad.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambu)
        {
          break label284;
        }
      }
    }
  }
  
  private static String ba(Context paramContext, String paramString)
  {
    AppMethodBeat.i(35078);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label96;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35078);
    return paramContext;
  }
  
  private void fCD()
  {
    AppMethodBeat.i(35073);
    if (this.JGs != null) {
      ar.b(this.JGs);
    }
    if (ba.ajx())
    {
      com.tencent.mm.pluginsdk.model.app.ao.bIX().remove(this.JGt);
      com.tencent.mm.pluginsdk.model.app.ao.dxQ().remove(this.JGu);
    }
    AppMethodBeat.o(35073);
  }
  
  private void u(g paramg)
  {
    AppMethodBeat.i(35075);
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(35075);
      return;
    }
    if (bt.isNullOrNil(paramg.eHN))
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject1 = this.cWM.JOR.getContext().getSharedPreferences(aj.fkC(), 0);
    this.cWM.JOR.getContext();
    Object localObject2 = ac.f((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (w.vF(this.cWM.getTalkerUserName()))
    {
      ba.aBQ();
      localObject2 = com.tencent.mm.model.c.azz().AN(this.cWM.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((ab)localObject2).aGo().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.cWM.BYG.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.eHN, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(35079);
    bz.aCx().d(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramr.filePath;
    paramr = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new e((String)localObject);
    paramr.title = ((e)localObject).getName();
    paramr.description = bt.sy(((e)localObject).length());
    localObject = new g();
    ((g)localObject).field_appId = "wx4310bbd51be7d979";
    com.tencent.mm.pluginsdk.model.app.ao.dxQ().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    com.tencent.mm.pluginsdk.model.app.m.a(paramr, ((g)localObject).field_appId, ((g)localObject).field_appName, this.cWM.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(bu parambu, al paramal)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = parambu.field_content;
    Object localObject2;
    if (parambu.field_isSend == 0)
    {
      localObject2 = this.cWM;
      int i = parambu.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fCI()) && (((com.tencent.mm.ui.chatting.e.a)localObject2).fFu()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bj.Bl((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.yr((String)localObject1);
      g localg = h.m(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.q.s(this.cWM.JOR.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!com.tencent.mm.pluginsdk.model.app.q.b(this.cWM.JOR.getContext(), localg))
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.cWM.JOR.getContext(), this.cWM.JOR.getMMResources().getString(2131759894, new Object[] { h.a(this.cWM.JOR.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(parambu, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).dks != null) && (((k.b)localObject2).dks.length() > 0))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.ao.bIX().aLD(((k.b)localObject2).dks);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (com.tencent.mm.vfs.i.fv(localWXAppExtendObject.filePath))
          {
            localObject1 = com.tencent.mm.sdk.platformtools.n.a(this.cWM.JOR.getContext(), new e(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.cWM.JOR.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
              localWXAppExtendObject.filePath = ((Uri)localObject1).toString();
            }
          }
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 637928960;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((k.b)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((k.b)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((k.b)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((k.b)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.i.aY(com.tencent.mm.aw.q.aIF().Fm(parambu.field_imgPath), 0, -1);
          new as(this.cWM.JOR.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramal);
          AppMethodBeat.o(35076);
          return;
        }
      }
      parambu = com.tencent.mm.pluginsdk.model.app.q.M(this.cWM.JOR.getContext(), ((k.b)localObject2).appId, "message");
      paramal = new Intent();
      paramal.putExtra("rawUrl", parambu);
      com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "webview", ".ui.tools.WebViewUI", paramal);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(35084);
    super.fCC();
    fCD();
    AppMethodBeat.o(35084);
  }
  
  public final void fwu()
  {
    AppMethodBeat.i(35081);
    this.yad = com.tencent.mm.plugin.wallet.a.fl(this.cWM.BYG.field_username, 1);
    this.yad.cp(1, this.cWM.BYG.field_username);
    com.tencent.mm.pluginsdk.model.app.ao.bIX().add(this.JGt);
    com.tencent.mm.pluginsdk.model.app.ao.dxQ().add(this.JGu);
    if (this.JGs == null) {
      this.JGs = new ar(this.cWM);
    }
    ar.a(this.JGs);
    AppMethodBeat.o(35081);
  }
  
  public final void fww()
  {
    AppMethodBeat.i(35082);
    com.tencent.mm.ui.chatting.ao.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void fwx()
  {
    AppMethodBeat.i(35083);
    fCD();
    AppMethodBeat.o(35083);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(35080);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(35080);
      return;
      if (paramInt2 == -1)
      {
        long l = paramIntent.getLongExtra("App_MsgId", 0L);
        ba.aBQ();
        a(com.tencent.mm.model.c.azs().xY(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.JGs != null) {}
        for (boolean bool = true;; bool = false)
        {
          ad.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
          if (!bt.isNullOrNil(paramIntent)) {
            break;
          }
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
          AppMethodBeat.o(35080);
          return;
        }
        if ((this.JGs == null) || (bt.isNullOrNil(str1)))
        {
          u(h.m(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (bt.isNullOrNil(str2))
        {
          com.tencent.mm.pluginsdk.model.app.ao.dxS().Ej(paramIntent);
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.JGs.mk(str1, str2);
        ad.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(h.m(paramIntent, true, false));
        }
      }
    }
  }
  
  public final void t(g paramg)
  {
    AppMethodBeat.i(35074);
    if (paramg == null)
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bt.flS() });
      AppMethodBeat.o(35074);
      return;
    }
    if ((paramg != null) && (g.EMD.equals(paramg.field_appId)) && (this.yad != null)) {
      this.yad.cp(2, this.cWM.BYG.field_username);
    }
    if (paramg.eZR())
    {
      if ((paramg == null) || (!paramg.eZR()))
      {
        ad.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.cWM.BYG == null) || (bt.isNullOrNil(this.cWM.BYG.field_username)))
      {
        ad.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      ad.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.eHO), paramg.field_packageName, paramg.field_appId });
      if ((paramg.eHO == 2) && (!bt.isNullOrNil(paramg.eHN)))
      {
        u(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eHO == 3)
      {
        if (bt.isNullOrNil(paramg.field_openId))
        {
          com.tencent.mm.pluginsdk.model.app.ao.dxS().Ej(paramg.field_appId);
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.JGs == null) || (bt.isNullOrNil(paramg.field_packageName)))
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          u(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.JGs.mk(paramg.field_packageName, paramg.field_openId);
        ad.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eHO == 1)
      {
        ad.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.eHN });
        q.a.EJC.a(this.cWM.JOR.getContext(), paramg.eHN, false, new u()
        {
          public final Object eYZ()
          {
            return b.this.cWM.BYG.field_username;
          }
          
          public final Object eZa()
          {
            AppMethodBeat.i(35071);
            com.tencent.mm.plugin.wallet.a locala = b.a(b.this);
            AppMethodBeat.o(35071);
            return locala;
          }
        });
      }
      AppMethodBeat.o(35074);
      return;
    }
    if (paramg.field_status == 3)
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramg.field_packageName);
      AppMethodBeat.o(35074);
      return;
    }
    if ((!this.JGs.mk(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      ad.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.eHB });
      if (bt.isNullOrNil(paramg.eHB))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.eHB);
      com.tencent.mm.bs.d.b(this.cWM.JOR.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b
 * JD-Core Version:    0.7.0.1
 */