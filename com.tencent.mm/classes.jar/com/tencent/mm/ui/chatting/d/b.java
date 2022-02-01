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
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.x;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.pluginsdk.ui.tools.r;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.chatting.as;
import com.tencent.mm.ui.chatting.at;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.d.a.a(fJv=com.tencent.mm.ui.chatting.d.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.d.b.b
{
  private as Kbj;
  private final k.a Kbk;
  private final k.a Kbl;
  private com.tencent.mm.plugin.wallet.a ypV;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.ypV = null;
    this.Kbj = null;
    this.Kbk = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35069);
        ae.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((com.tencent.mm.ui.chatting.d.b.k)b.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGq();
        AppMethodBeat.o(35069);
      }
    };
    this.Kbl = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(35070);
        ae.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((com.tencent.mm.ui.chatting.d.b.k)b.this.cXJ.bh(com.tencent.mm.ui.chatting.d.b.k.class)).fGq();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(bv parambv, g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!parambv.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    ae.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambv = new Intent("android.intent.action.MAIN", null);
    parambv.addCategory("android.intent.category.LAUNCHER");
    parambv.addFlags(268435456);
    parambv.setClassName("com.tencent.mobileqq", bc(this.cXJ.Kkd.getContext(), "com.tencent.mobileqq"));
    parambv.putExtra("platformId", "wechat");
    bc.aCg();
    paramg = com.tencent.mm.model.c.ajA().get(9, null);
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
        parambv.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.cXJ.Kkd;
            parambv = new com.tencent.mm.hellhoundlib.b.a().bc(parambv);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, parambv.ahE(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)parambv.mt(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            ae.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception parambv)
        {
          break label284;
        }
      }
    }
  }
  
  private static String bc(Context paramContext, String paramString)
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
        ae.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35078);
    return paramContext;
  }
  
  private void fGF()
  {
    AppMethodBeat.i(35073);
    if (this.Kbj != null) {
      as.b(this.Kbj);
    }
    if (bc.ajM())
    {
      ao.bJV().remove(this.Kbk);
      ao.dBg().remove(this.Kbl);
    }
    AppMethodBeat.o(35073);
  }
  
  private void u(g paramg)
  {
    AppMethodBeat.i(35075);
    if ((paramg == null) || (bu.isNullOrNil(paramg.field_appId)))
    {
      ae.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(35075);
      return;
    }
    if (bu.isNullOrNil(paramg.eJw))
    {
      ae.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject1 = this.cXJ.Kkd.getContext().getSharedPreferences(ak.fow(), 0);
    this.cXJ.Kkd.getContext();
    Object localObject2 = ad.f((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (x.wb(this.cXJ.getTalkerUserName()))
    {
      bc.aCg();
      localObject2 = com.tencent.mm.model.c.azP().Bx(this.cXJ.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((ac)localObject2).aGE().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.cXJ.Cqh.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.eJw, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(r paramr)
  {
    AppMethodBeat.i(35079);
    cb.aCN().d(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramr.filePath;
    paramr = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new com.tencent.mm.vfs.k((String)localObject);
    paramr.title = ((com.tencent.mm.vfs.k)localObject).getName();
    paramr.description = bu.sL(((com.tencent.mm.vfs.k)localObject).length());
    localObject = new g();
    ((g)localObject).field_appId = "wx4310bbd51be7d979";
    ao.dBg().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    com.tencent.mm.pluginsdk.model.app.m.a(paramr, ((g)localObject).field_appId, ((g)localObject).field_appName, this.cXJ.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(bv parambv, com.tencent.mm.pluginsdk.model.app.al paramal)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = parambv.field_content;
    Object localObject2;
    if (parambv.field_isSend == 0)
    {
      localObject2 = this.cXJ;
      int i = parambv.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(com.tencent.mm.ui.chatting.d.b.d.class)).fGK()) && (((com.tencent.mm.ui.chatting.e.a)localObject2).fJB()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bl.BN((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.zb((String)localObject1);
      g localg = h.m(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.q.s(this.cXJ.Kkd.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!com.tencent.mm.pluginsdk.model.app.q.b(this.cXJ.Kkd.getContext(), localg))
        {
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.cXJ.Kkd.getContext(), this.cXJ.Kkd.getMMResources().getString(2131759894, new Object[] { h.a(this.cXJ.Kkd.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(parambv, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).dlu != null) && (((k.b)localObject2).dlu.length() > 0))
        {
          localObject1 = ao.bJV().aMZ(((k.b)localObject2).dlu);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (com.tencent.mm.vfs.o.fB(localWXAppExtendObject.filePath))
          {
            localObject1 = com.tencent.mm.sdk.platformtools.o.a(this.cXJ.Kkd.getContext(), new com.tencent.mm.vfs.k(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.cXJ.Kkd.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
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
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.o.bb(com.tencent.mm.av.q.aIX().FO(parambv.field_imgPath), 0, -1);
          new at(this.cXJ.Kkd.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramal);
          AppMethodBeat.o(35076);
          return;
        }
      }
      parambv = com.tencent.mm.pluginsdk.model.app.q.M(this.cXJ.Kkd.getContext(), ((k.b)localObject2).appId, "message");
      paramal = new Intent();
      paramal.putExtra("rawUrl", parambv);
      com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", paramal);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void fAu()
  {
    AppMethodBeat.i(35081);
    this.ypV = com.tencent.mm.plugin.wallet.a.fu(this.cXJ.Cqh.field_username, 1);
    this.ypV.cp(1, this.cXJ.Cqh.field_username);
    ao.bJV().add(this.Kbk);
    ao.dBg().add(this.Kbl);
    if (this.Kbj == null) {
      this.Kbj = new as(this.cXJ);
    }
    as.a(this.Kbj);
    AppMethodBeat.o(35081);
  }
  
  public final void fAw()
  {
    AppMethodBeat.i(35082);
    ap.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void fAx()
  {
    AppMethodBeat.i(35083);
    fGF();
    AppMethodBeat.o(35083);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(35084);
    super.fGE();
    fGF();
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
        bc.aCg();
        a(com.tencent.mm.model.c.azI().ys(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.Kbj != null) {}
        for (boolean bool = true;; bool = false)
        {
          ae.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
          if (!bu.isNullOrNil(paramIntent)) {
            break;
          }
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
          AppMethodBeat.o(35080);
          return;
        }
        if ((this.Kbj == null) || (bu.isNullOrNil(str1)))
        {
          u(h.m(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (bu.isNullOrNil(str2))
        {
          ao.dBi().EL(paramIntent);
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.Kbj.mr(str1, str2);
        ae.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
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
      ae.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bu.fpN() });
      AppMethodBeat.o(35074);
      return;
    }
    if ((paramg != null) && (g.Ffa.equals(paramg.field_appId)) && (this.ypV != null)) {
      this.ypV.cp(2, this.cXJ.Cqh.field_username);
    }
    if (paramg.fdF())
    {
      if ((paramg == null) || (!paramg.fdF()))
      {
        ae.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.cXJ.Cqh == null) || (bu.isNullOrNil(this.cXJ.Cqh.field_username)))
      {
        ae.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      ae.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.eJx), paramg.field_packageName, paramg.field_appId });
      if ((paramg.eJx == 2) && (!bu.isNullOrNil(paramg.eJw)))
      {
        u(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eJx == 3)
      {
        if (bu.isNullOrNil(paramg.field_openId))
        {
          ao.dBi().EL(paramg.field_appId);
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.Kbj == null) || (bu.isNullOrNil(paramg.field_packageName)))
        {
          ae.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          u(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.Kbj.mr(paramg.field_packageName, paramg.field_openId);
        ae.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          u(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.eJx == 1)
      {
        ae.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.eJw });
        q.a.Fca.a(this.cXJ.Kkd.getContext(), paramg.eJw, false, new u()
        {
          public final Object fcN()
          {
            return b.this.cXJ.Cqh.field_username;
          }
          
          public final Object fcO()
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
      ae.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramg.field_packageName);
      AppMethodBeat.o(35074);
      return;
    }
    if ((!this.Kbj.mr(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      ae.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.eJk });
      if (bu.isNullOrNil(paramg.eJk))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.eJk);
      com.tencent.mm.br.d.b(this.cXJ.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b
 * JD-Core Version:    0.7.0.1
 */