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
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.o;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.by;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
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

@com.tencent.mm.ui.chatting.c.a.a(eYT=com.tencent.mm.ui.chatting.c.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.c.b.b
{
  private ar Gsr;
  private final k.a Gss;
  private final k.a Gst;
  private com.tencent.mm.plugin.wallet.a vCr;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.vCr = null;
    this.Gsr = null;
    this.Gss = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35069);
        ad.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((com.tencent.mm.ui.chatting.c.b.i)b.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWj();
        AppMethodBeat.o(35069);
      }
    };
    this.Gst = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35070);
        ad.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((com.tencent.mm.ui.chatting.c.b.i)b.this.cOd.be(com.tencent.mm.ui.chatting.c.b.i.class)).eWj();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(bl parambl, com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!parambl.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    ad.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambl = new Intent("android.intent.action.MAIN", null);
    parambl.addCategory("android.intent.category.LAUNCHER");
    parambl.addFlags(268435456);
    parambl.setClassName("com.tencent.mobileqq", aW(this.cOd.GzJ.getContext(), "com.tencent.mobileqq"));
    parambl.putExtra("platformId", "wechat");
    az.arV();
    paramg = com.tencent.mm.model.c.afk().get(9, null);
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
        parambl.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.cOd.GzJ;
            parambl = new com.tencent.mm.hellhoundlib.b.a().bd(parambl);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambl.adn(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambl.lS(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            ad.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambl)
        {
          break label284;
        }
      }
    }
  }
  
  private static String aW(Context paramContext, String paramString)
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
  
  private void eWy()
  {
    AppMethodBeat.i(35073);
    if (this.Gsr != null) {
      ar.b(this.Gsr);
    }
    if (az.afw())
    {
      ap.bxS().remove(this.Gss);
      ap.cZQ().remove(this.Gst);
    }
    AppMethodBeat.o(35073);
  }
  
  private void u(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35075);
    if ((paramg == null) || (bt.isNullOrNil(paramg.field_appId)))
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(35075);
      return;
    }
    if (bt.isNullOrNil(paramg.eoA))
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject1 = this.cOd.GzJ.getContext().getSharedPreferences(com.tencent.mm.sdk.platformtools.aj.eFD(), 0);
    this.cOd.GzJ.getContext();
    Object localObject2 = ac.f((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (com.tencent.mm.model.w.pF(this.cOd.getTalkerUserName()))
    {
      az.arV();
      localObject2 = com.tencent.mm.model.c.apV().tH(this.cOd.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((com.tencent.mm.storage.w)localObject2).awt().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.cOd.zgX.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.eoA, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(35079);
    by.asD().d(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramr.filePath;
    paramr = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new e((String)localObject);
    paramr.title = ((e)localObject).getName();
    paramr.description = bt.mK(((e)localObject).length());
    localObject = new com.tencent.mm.pluginsdk.model.app.g();
    ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId = "wx4310bbd51be7d979";
    ap.cZQ().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    com.tencent.mm.pluginsdk.model.app.m.a(paramr, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appId, ((com.tencent.mm.pluginsdk.model.app.g)localObject).field_appName, this.cOd.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(bl parambl, am paramam)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = parambl.field_content;
    Object localObject2;
    if (parambl.field_isSend == 0)
    {
      localObject2 = this.cOd;
      int i = parambl.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject2).be(com.tencent.mm.ui.chatting.c.b.d.class)).eWD()) && (((com.tencent.mm.ui.chatting.d.a)localObject2).eZa()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bi.ug((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.rx((String)localObject1);
      com.tencent.mm.pluginsdk.model.app.g localg = com.tencent.mm.pluginsdk.model.app.h.j(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (q.t(this.cOd.GzJ.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!q.b(this.cOd.GzJ.getContext(), localg))
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.cOd.GzJ.getContext(), this.cOd.GzJ.getMMResources().getString(2131759894, new Object[] { com.tencent.mm.pluginsdk.model.app.h.a(this.cOd.GzJ.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(parambl, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).dbA != null) && (((k.b)localObject2).dbA.length() > 0))
        {
          localObject1 = ap.bxS().aAL(((k.b)localObject2).dbA);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (com.tencent.mm.vfs.i.eK(localWXAppExtendObject.filePath))
          {
            localObject1 = com.tencent.mm.sdk.platformtools.m.a(this.cOd.GzJ.getContext(), new e(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.cOd.GzJ.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
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
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.i.aR(o.ayF().yg(parambl.field_imgPath), 0, -1);
          new as(this.cOd.GzJ.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramam);
          AppMethodBeat.o(35076);
          return;
        }
      }
      parambl = q.K(this.cOd.GzJ.getContext(), ((k.b)localObject2).appId, "message");
      paramam = new Intent();
      paramam.putExtra("rawUrl", parambl);
      com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", paramam);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void eQC()
  {
    AppMethodBeat.i(35081);
    this.vCr = com.tencent.mm.plugin.wallet.a.eK(this.cOd.zgX.field_username, 1);
    this.vCr.ce(1, this.cOd.zgX.field_username);
    ap.bxS().add(this.Gss);
    ap.cZQ().add(this.Gst);
    if (this.Gsr == null) {
      this.Gsr = new ar(this.cOd);
    }
    ar.a(this.Gsr);
    AppMethodBeat.o(35081);
  }
  
  public final void eQE()
  {
    AppMethodBeat.i(35082);
    ao.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void eQF()
  {
    AppMethodBeat.i(35083);
    eWy();
    AppMethodBeat.o(35083);
  }
  
  public final void eWx()
  {
    AppMethodBeat.i(35084);
    super.eWx();
    eWy();
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
        az.arV();
        a(com.tencent.mm.model.c.apO().rm(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.Gsr != null) {}
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
        if ((this.Gsr == null) || (bt.isNullOrNil(str1)))
        {
          u(com.tencent.mm.pluginsdk.model.app.h.j(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (bt.isNullOrNil(str2))
        {
          ap.cZS().xe(paramIntent);
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.Gsr.lp(str1, str2);
        ad.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(com.tencent.mm.pluginsdk.model.app.h.j(paramIntent, true, false));
        }
      }
    }
  }
  
  public final void t(com.tencent.mm.pluginsdk.model.app.g paramg)
  {
    AppMethodBeat.i(35074);
    if (paramg == null)
    {
      ad.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bt.eGN() });
      AppMethodBeat.o(35074);
      return;
    }
    if ((paramg != null) && (com.tencent.mm.pluginsdk.model.app.g.BPE.equals(paramg.field_appId)) && (this.vCr != null)) {
      this.vCr.ce(2, this.cOd.zgX.field_username);
    }
    if (paramg.evD())
    {
      if ((paramg == null) || (!paramg.evD()))
      {
        ad.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.cOd.zgX == null) || (bt.isNullOrNil(this.cOd.zgX.field_username)))
      {
        ad.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      ad.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.eoB), paramg.field_packageName, paramg.field_appId });
      if ((paramg.eoB == 2) && (!bt.isNullOrNil(paramg.eoA)))
      {
        u(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eoB == 3)
      {
        if (bt.isNullOrNil(paramg.field_openId))
        {
          ap.cZS().xe(paramg.field_appId);
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.Gsr == null) || (bt.isNullOrNil(paramg.field_packageName)))
        {
          ad.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          u(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.Gsr.lp(paramg.field_packageName, paramg.field_openId);
        ad.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eoB == 1)
      {
        ad.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.eoA });
        p.a.BNw.a(this.cOd.GzJ.getContext(), paramg.eoA, false, new t()
        {
          public final Object euS()
          {
            return b.this.cOd.zgX.field_username;
          }
          
          public final Object euT()
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
    if ((!this.Gsr.lp(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      ad.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.eoo });
      if (bt.isNullOrNil(paramg.eoo))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.eoo);
      com.tencent.mm.bs.d.b(this.cOd.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b
 * JD-Core Version:    0.7.0.1
 */