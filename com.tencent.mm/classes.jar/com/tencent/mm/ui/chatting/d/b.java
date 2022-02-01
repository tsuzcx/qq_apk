package com.tencent.mm.ui.chatting.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.g.c.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cf;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.j;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.pluginsdk.u;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.at;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.d.b.k;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.d.a.a(gRF=com.tencent.mm.ui.chatting.d.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.d.b.b
{
  private com.tencent.mm.plugin.wallet.a CqM;
  private at PmF;
  private final MStorage.IOnStorageChange PmG;
  private final MStorage.IOnStorageChange PmH;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.CqM = null;
    this.PmF = null;
    this.PmG = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35069);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((k)b.this.dom.bh(k.class)).gOw();
        AppMethodBeat.o(35069);
      }
    };
    this.PmH = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35070);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((k)b.this.dom.bh(k.class)).gOw();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(ca paramca, g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!paramca.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    Log.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    paramca = new Intent("android.intent.action.MAIN", null);
    paramca.addCategory("android.intent.category.LAUNCHER");
    paramca.addFlags(268435456);
    paramca.setClassName("com.tencent.mobileqq", bs(this.dom.Pwc.getContext(), "com.tencent.mobileqq"));
    paramca.putExtra("platformId", "wechat");
    bg.aVF();
    paramg = com.tencent.mm.model.c.azQ().get(9, null);
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
        paramca.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.dom.Pwc;
            paramca = new com.tencent.mm.hellhoundlib.b.a().bl(paramca);
            com.tencent.mm.hellhoundlib.a.a.a(paramg, paramca.axQ(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)paramca.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramca)
        {
          break label284;
        }
      }
    }
  }
  
  private static String bs(Context paramContext, String paramString)
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
        Log.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(35078);
    return paramContext;
  }
  
  private void gOL()
  {
    AppMethodBeat.i(35073);
    if (this.PmF != null) {
      at.b(this.PmF);
    }
    if (bg.aAc())
    {
      com.tencent.mm.pluginsdk.model.app.ao.cgO().remove(this.PmG);
      com.tencent.mm.pluginsdk.model.app.ao.eAS().remove(this.PmH);
    }
    AppMethodBeat.o(35073);
  }
  
  private void v(g paramg)
  {
    AppMethodBeat.i(35075);
    if ((paramg == null) || (Util.isNullOrNil(paramg.field_appId)))
    {
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(35075);
      return;
    }
    if (Util.isNullOrNil(paramg.fmY))
    {
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject2 = LocaleUtil.loadApplicationLanguage(this.dom.Pwc.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.dom.Pwc.getContext());
    Object localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (ab.Eq(this.dom.getTalkerUserName()))
    {
      bg.aVF();
      localObject2 = com.tencent.mm.model.c.aSX().Kd(this.dom.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((ah)localObject2).bax().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.dom.GUe.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.fmY, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(t paramt)
  {
    AppMethodBeat.i(35079);
    cf.aWl().f(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramt.filePath;
    paramt = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new o((String)localObject);
    paramt.title = ((o)localObject).getName();
    paramt.description = Util.getSizeKB(((o)localObject).length());
    localObject = new g();
    ((g)localObject).field_appId = "wx4310bbd51be7d979";
    com.tencent.mm.pluginsdk.model.app.ao.eAS().get((IAutoDBItem)localObject, new String[0]);
    m.a(paramt, ((g)localObject).field_appId, ((g)localObject).field_appName, this.dom.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(ca paramca, al paramal)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = paramca.field_content;
    Object localObject2;
    if (paramca.field_isSend == 0)
    {
      localObject2 = this.dom;
      int i = paramca.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject2).bh(com.tencent.mm.ui.chatting.d.b.d.class)).gOQ()) && (((com.tencent.mm.ui.chatting.e.a)localObject2).gRL()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bp.Kt((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.HD((String)localObject1);
      g localg = h.o(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.q.s(this.dom.Pwc.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!com.tencent.mm.pluginsdk.model.app.q.b(this.dom.Pwc.getContext(), localg))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.dom.Pwc.getContext(), this.dom.Pwc.getMMResources().getString(2131761232, new Object[] { h.a(this.dom.Pwc.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(paramca, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).dCK != null) && (((k.b)localObject2).dCK.length() > 0))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx(((k.b)localObject2).dCK);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (s.YS(localWXAppExtendObject.filePath))
          {
            localObject1 = FileProviderHelper.getUriForFile(this.dom.Pwc.getContext(), new o(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.dom.Pwc.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
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
          ((WXMediaMessage)localObject1).thumbData = s.aW(com.tencent.mm.av.q.bcR().Oz(paramca.field_imgPath), 0, -1);
          new au(this.dom.Pwc.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramal);
          AppMethodBeat.o(35076);
          return;
        }
      }
      paramca = com.tencent.mm.pluginsdk.model.app.q.R(this.dom.Pwc.getContext(), ((k.b)localObject2).appId, "message");
      paramal = new Intent();
      paramal.putExtra("rawUrl", paramca);
      com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", paramal);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void cFy()
  {
    AppMethodBeat.i(35082);
    aq.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35081);
    this.CqM = com.tencent.mm.plugin.wallet.a.fV(this.dom.GUe.field_username, 1);
    this.CqM.cG(1, this.dom.GUe.field_username);
    com.tencent.mm.pluginsdk.model.app.ao.cgO().add(this.PmG);
    com.tencent.mm.pluginsdk.model.app.ao.eAS().add(this.PmH);
    if (this.PmF == null) {
      this.PmF = new at(this.dom);
    }
    at.a(this.PmF);
    AppMethodBeat.o(35081);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35083);
    gOL();
    AppMethodBeat.o(35083);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35084);
    super.gOK();
    gOL();
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
        bg.aVF();
        a(com.tencent.mm.model.c.aSQ().Hb(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.PmF != null) {}
        for (boolean bool = true;; bool = false)
        {
          Log.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
          if (!Util.isNullOrNil(paramIntent)) {
            break;
          }
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
          AppMethodBeat.o(35080);
          return;
        }
        if ((this.PmF == null) || (Util.isNullOrNil(str1)))
        {
          v(h.o(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (Util.isNullOrNil(str2))
        {
          com.tencent.mm.pluginsdk.model.app.ao.eAU().add(paramIntent);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.PmF.nf(str1, str2);
        Log.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          v(h.o(paramIntent, true, false));
        }
      }
    }
  }
  
  public final void u(g paramg)
  {
    AppMethodBeat.i(35074);
    if (paramg == null)
    {
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { Util.getStack() });
      AppMethodBeat.o(35074);
      return;
    }
    if ((paramg != null) && (g.JVR.equals(paramg.field_appId)) && (this.CqM != null)) {
      this.CqM.cG(2, this.dom.GUe.field_username);
    }
    if (paramg.gmR())
    {
      if ((paramg == null) || (!paramg.gmR()))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.dom.GUe == null) || (Util.isNullOrNil(this.dom.GUe.field_username)))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      Log.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.fmZ), paramg.field_packageName, paramg.field_appId });
      if ((paramg.fmZ == 2) && (!Util.isNullOrNil(paramg.fmY)))
      {
        v(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.fmZ == 3)
      {
        if (Util.isNullOrNil(paramg.field_openId))
        {
          com.tencent.mm.pluginsdk.model.app.ao.eAU().add(paramg.field_appId);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.PmF == null) || (Util.isNullOrNil(paramg.field_packageName)))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          v(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.PmF.nf(paramg.field_packageName, paramg.field_openId);
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          v(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.fmZ == 1)
      {
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.fmY });
        q.a.JSZ.a(this.dom.Pwc.getContext(), paramg.fmY, false, new u()
        {
          public final Object glZ()
          {
            return b.this.dom.GUe.field_username;
          }
          
          public final Object gma()
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
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramg.field_packageName);
      AppMethodBeat.o(35074);
      return;
    }
    if ((!this.PmF.nf(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      Log.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.fmM });
      if (Util.isNullOrNil(paramg.fmM))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.fmM);
      com.tencent.mm.br.c.b(this.dom.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b
 * JD-Core Version:    0.7.0.1
 */