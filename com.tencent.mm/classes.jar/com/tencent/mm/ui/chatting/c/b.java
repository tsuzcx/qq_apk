package com.tencent.mm.ui.chatting.c;

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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.o;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.by;
import com.tencent.mm.model.w;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.p;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.pluginsdk.t;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.c.a.a(foJ=com.tencent.mm.ui.chatting.c.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.c.b.b
{
  private ar HSj;
  private final k.a HSk;
  private final k.a HSl;
  private com.tencent.mm.plugin.wallet.a wMw;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.wMw = null;
    this.HSj = null;
    this.HSk = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35069);
        ac.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((com.tencent.mm.ui.chatting.c.b.i)b.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).flV();
        AppMethodBeat.o(35069);
      }
    };
    this.HSl = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35070);
        ac.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((com.tencent.mm.ui.chatting.c.b.i)b.this.cLy.bf(com.tencent.mm.ui.chatting.c.b.i.class)).flV();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(bo parambo, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!parambo.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    ac.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambo = new Intent("android.intent.action.MAIN", null);
    parambo.addCategory("android.intent.category.LAUNCHER");
    parambo.addFlags(268435456);
    parambo.setClassName("com.tencent.mobileqq", aX(this.cLy.HZF.getContext(), "com.tencent.mobileqq"));
    parambo.putExtra("platformId", "wechat");
    az.ayM();
    paramg = com.tencent.mm.model.c.agA().get(9, null);
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
        parambo.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.cLy.HZF;
            parambo = new com.tencent.mm.hellhoundlib.b.a().ba(parambo);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambo.aeD(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambo.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            ac.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambo)
        {
          break label284;
        }
      }
    }
  }
  
  private static String aX(Context paramContext, String paramString)
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
        ac.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35078);
    return paramContext;
  }
  
  private void fmk()
  {
    AppMethodBeat.i(35073);
    if (this.HSj != null) {
      ar.b(this.HSj);
    }
    if (az.agM())
    {
      ap.bEO().remove(this.HSk);
      ap.dny().remove(this.HSl);
    }
    AppMethodBeat.o(35073);
  }
  
  private void u(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35075);
    if ((paramg == null) || (bs.isNullOrNil(paramg.field_appId)))
    {
      ac.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(35075);
      return;
    }
    if (bs.isNullOrNil(paramg.eqE))
    {
      ac.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject1 = this.cLy.HZF.getContext().getSharedPreferences(ai.eUX(), 0);
    this.cLy.HZF.getContext();
    Object localObject2 = ab.f((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (w.sQ(this.cLy.getTalkerUserName()))
    {
      az.ayM();
      localObject2 = com.tencent.mm.model.c.awK().xN(this.cLy.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((x)localObject2).aDl().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.cLy.AzG.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.eqE, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(35079);
    by.azu().d(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramr.filePath;
    paramr = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new e((String)localObject);
    paramr.title = ((e)localObject).getName();
    paramr.description = bs.qz(((e)localObject).length());
    localObject = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId = "wx4310bbd51be7d979";
    ap.dny().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    com.tencent.mm.pluginsdk.model.app.m.a(paramr, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName, this.cLy.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(bo parambo, am paramam)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = parambo.field_content;
    Object localObject2;
    if (parambo.field_isSend == 0)
    {
      localObject2 = this.cLy;
      int i = parambo.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject2).bf(com.tencent.mm.ui.chatting.c.b.d.class)).fmp()) && (((com.tencent.mm.ui.chatting.d.a)localObject2).foP()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bi.ym((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.vA((String)localObject1);
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.k(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (q.t(this.cLy.HZF.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!q.b(this.cLy.HZF.getContext(), localg))
        {
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.cLy.HZF.getContext(), this.cLy.HZF.getMMResources().getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(this.cLy.HZF.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(parambo, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).cZa != null) && (((k.b)localObject2).cZa.length() > 0))
        {
          localObject1 = ap.bEO().aGd(((k.b)localObject2).cZa);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (com.tencent.mm.vfs.i.eA(localWXAppExtendObject.filePath))
          {
            localObject1 = com.tencent.mm.sdk.platformtools.m.a(this.cLy.HZF.getContext(), new e(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.cLy.HZF.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
              localWXAppExtendObject.filePath = ((Uri)localObject1).toString();
            }
          }
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 637927424;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((k.b)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((k.b)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((k.b)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((k.b)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.i.aU(o.aFx().Cl(parambo.field_imgPath), 0, -1);
          new as(this.cLy.HZF.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramam);
          AppMethodBeat.o(35076);
          return;
        }
      }
      parambo = q.J(this.cLy.HZF.getContext(), ((k.b)localObject2).appId, "message");
      paramam = new Intent();
      paramam.putExtra("rawUrl", parambo);
      com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "webview", ".ui.tools.WebViewUI", paramam);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void fgi()
  {
    AppMethodBeat.i(35081);
    this.wMw = com.tencent.mm.plugin.wallet.a.eS(this.cLy.AzG.field_username, 1);
    this.wMw.ch(1, this.cLy.AzG.field_username);
    ap.bEO().add(this.HSk);
    ap.dny().add(this.HSl);
    if (this.HSj == null) {
      this.HSj = new ar(this.cLy);
    }
    ar.a(this.HSj);
    AppMethodBeat.o(35081);
  }
  
  public final void fgk()
  {
    AppMethodBeat.i(35082);
    ao.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void fgl()
  {
    AppMethodBeat.i(35083);
    fmk();
    AppMethodBeat.o(35083);
  }
  
  public final void fmj()
  {
    AppMethodBeat.i(35084);
    super.fmj();
    fmk();
    AppMethodBeat.o(35084);
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
        az.ayM();
        a(com.tencent.mm.model.c.awD().vP(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.HSj != null) {}
        for (boolean bool = true;; bool = false)
        {
          ac.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
          if (!bs.isNullOrNil(paramIntent)) {
            break;
          }
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
          AppMethodBeat.o(35080);
          return;
        }
        if ((this.HSj == null) || (bs.isNullOrNil(str1)))
        {
          u(com.tencent.mm.pluginsdk.model.app.h.k(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (bs.isNullOrNil(str2))
        {
          ap.dnA().Bk(paramIntent);
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.HSj.lM(str1, str2);
        ac.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(com.tencent.mm.pluginsdk.model.app.h.k(paramIntent, true, false));
        }
      }
    }
  }
  
  public final void t(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35074);
    if (paramg == null)
    {
      ac.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bs.eWi() });
      AppMethodBeat.o(35074);
      return;
    }
    if ((paramg != null) && (com.tencent.mm.pluginsdk.model.app.g.DhS.equals(paramg.field_appId)) && (this.wMw != null)) {
      this.wMw.ch(2, this.cLy.AzG.field_username);
    }
    if (paramg.eKX())
    {
      if ((paramg == null) || (!paramg.eKX()))
      {
        ac.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.cLy.AzG == null) || (bs.isNullOrNil(this.cLy.AzG.field_username)))
      {
        ac.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      ac.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.eqF), paramg.field_packageName, paramg.field_appId });
      if ((paramg.eqF == 2) && (!bs.isNullOrNil(paramg.eqE)))
      {
        u(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eqF == 3)
      {
        if (bs.isNullOrNil(paramg.field_openId))
        {
          ap.dnA().Bk(paramg.field_appId);
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.HSj == null) || (bs.isNullOrNil(paramg.field_packageName)))
        {
          ac.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          u(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.HSj.lM(paramg.field_packageName, paramg.field_openId);
        ac.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eqF == 1)
      {
        ac.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.eqE });
        p.a.DfG.a(this.cLy.HZF.getContext(), paramg.eqE, false, new t()
        {
          public final Object eKl()
          {
            return b.this.cLy.AzG.field_username;
          }
          
          public final Object eKm()
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
      ac.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramg.field_packageName);
      AppMethodBeat.o(35074);
      return;
    }
    if ((!this.HSj.lM(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      ac.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.eqs });
      if (bs.isNullOrNil(paramg.eqs))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.eqs);
      com.tencent.mm.br.d.b(this.cLy.HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b
 * JD-Core Version:    0.7.0.1
 */