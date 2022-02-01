package com.tencent.mm.ui.chatting.component;

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
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.b.z;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.ch;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.n;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.pluginsdk.v;
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.av;
import com.tencent.mm.ui.chatting.aw;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.component.api.m;
import com.tencent.mm.vfs.y;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.component.api.b
{
  private com.tencent.mm.plugin.wallet.a OlE;
  private av aeog;
  private final MStorage.IOnStorageChange aeoh;
  private final MStorage.IOnStorageChange aeoi;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.OlE = null;
    this.aeog = null;
    this.aeoh = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35069);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((m)b.this.hlc.cm(m.class)).jqp();
        AppMethodBeat.o(35069);
      }
    };
    this.aeoi = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35070);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((m)b.this.hlc.cm(m.class)).jqp();
        AppMethodBeat.o(35070);
      }
    };
    AppMethodBeat.o(35072);
  }
  
  private boolean a(cc paramcc, g paramg)
  {
    AppMethodBeat.i(35077);
    if ((!paramcc.field_talker.endsWith("@qqim")) || (!paramg.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(35077);
      return false;
    }
    Log.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    paramcc = new Intent("android.intent.action.MAIN", null);
    paramcc.addCategory("android.intent.category.LAUNCHER");
    paramcc.addFlags(268435456);
    paramcc.setClassName("com.tencent.mobileqq", bH(this.hlc.aezO.getContext(), "com.tencent.mobileqq"));
    paramcc.putExtra("platformId", "wechat");
    bh.bCz();
    paramg = com.tencent.mm.model.c.ban().d(9, null);
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
        paramcc.putExtra("tencent_gif", paramg);
        label284:
        i = 0;
      }
      catch (UnsupportedEncodingException paramg)
      {
        try
        {
          for (;;)
          {
            paramg = this.hlc.aezO;
            paramcc = new com.tencent.mm.hellhoundlib.b.a().cG(paramcc);
            com.tencent.mm.hellhoundlib.a.a.b(paramg, paramcc.aYi(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)paramcc.sb(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(35077);
            return true;
            paramg = paramg;
            Log.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramg, "", new Object[0]);
          }
        }
        catch (Exception paramcc)
        {
          break label284;
        }
      }
    }
  }
  
  private static String bH(Context paramContext, String paramString)
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
  
  private void jqG()
  {
    AppMethodBeat.i(35073);
    if (this.aeog != null) {
      av.b(this.aeog);
    }
    if (bh.baz())
    {
      com.tencent.mm.pluginsdk.model.app.as.cWJ().remove(this.aeoh);
      com.tencent.mm.pluginsdk.model.app.as.gxn().remove(this.aeoi);
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
    if (Util.isNullOrNil(paramg.jOK))
    {
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject2 = LocaleUtil.loadApplicationLanguage(this.hlc.aezO.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.hlc.aezO.getContext());
    Object localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (au.bwE(this.hlc.getTalkerUserName()))
    {
      bh.bCz();
      localObject2 = com.tencent.mm.model.c.bzK().Ju(this.hlc.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((aj)localObject2).bHw().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.hlc.Uxa.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.jOK, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(com.tencent.mm.pluginsdk.ui.tools.u paramu)
  {
    AppMethodBeat.i(35079);
    ch.bDg().f(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramu.filePath;
    paramu = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new com.tencent.mm.vfs.u((String)localObject);
    paramu.title = ((com.tencent.mm.vfs.u)localObject).getName();
    paramu.description = Util.getSizeKB(((com.tencent.mm.vfs.u)localObject).length());
    localObject = new g();
    ((g)localObject).field_appId = "wx4310bbd51be7d979";
    com.tencent.mm.pluginsdk.model.app.as.gxn().get((IAutoDBItem)localObject, new String[0]);
    n.a(paramu, ((g)localObject).field_appId, ((g)localObject).field_appName, this.hlc.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(cc paramcc, ap paramap)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = paramcc.field_content;
    Object localObject2;
    if (paramcc.field_isSend == 0)
    {
      localObject2 = this.hlc;
      int i = paramcc.field_isSend;
      if ((!((e)((com.tencent.mm.ui.chatting.d.a)localObject2).cm(e.class)).jqW()) && (((com.tencent.mm.ui.chatting.d.a)localObject2).juF()) && (localObject1 != null) && (i == 0)) {
        localObject1 = br.JK((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.Hf((String)localObject1);
      g localg = h.s(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.u.y(this.hlc.aezO.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!com.tencent.mm.pluginsdk.model.app.u.b(this.hlc.aezO.getContext(), localg))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.hlc.aezO.getContext(), this.hlc.aezO.getMMResources().getString(R.l.game_launch_fail_alert, new Object[] { h.a(this.hlc.aezO.getContext(), localg, null) }), 1).show();
          AppMethodBeat.o(35076);
          return;
        }
        if (a(paramcc, localg))
        {
          AppMethodBeat.o(35076);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((k.b)localObject2).extInfo;
        if ((((k.b)localObject2).hzM != null) && (((k.b)localObject2).hzM.length() > 0))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.as.cWJ().bpI(((k.b)localObject2).hzM);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (y.ZC(localWXAppExtendObject.filePath))
          {
            localObject1 = FileProviderHelper.getUriForFile(this.hlc.aezO.getContext(), new com.tencent.mm.vfs.u(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.hlc.aezO.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
              localWXAppExtendObject.filePath = ((Uri)localObject1).toString();
            }
          }
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 638058496;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((k.b)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((k.b)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((k.b)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((k.b)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = y.bi(com.tencent.mm.modelimage.r.bKa().NY(paramcc.field_imgPath), 0, -1);
          new aw(this.hlc.aezO.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramap);
          AppMethodBeat.o(35076);
          return;
        }
      }
      paramcc = com.tencent.mm.pluginsdk.model.app.u.ad(this.hlc.aezO.getContext(), ((k.b)localObject2).appId, "message");
      paramap = new Intent();
      paramap.putExtra("rawUrl", paramcc);
      com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramap);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35081);
    this.OlE = com.tencent.mm.plugin.wallet.a.hB(this.hlc.Uxa.field_username, 1);
    this.OlE.dx(1, this.hlc.Uxa.field_username);
    com.tencent.mm.pluginsdk.model.app.as.cWJ().add(this.aeoh);
    com.tencent.mm.pluginsdk.model.app.as.gxn().add(this.aeoi);
    if (this.aeog == null) {
      this.aeog = new av(this.hlc);
    }
    av.a(this.aeog);
    AppMethodBeat.o(35081);
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(35082);
    com.tencent.mm.ui.chatting.as.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35083);
    jqG();
    AppMethodBeat.o(35083);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35084);
    super.jqF();
    jqG();
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
        bh.bCz();
        a(com.tencent.mm.model.c.bzD().sl(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.aeog != null) {}
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
        if ((this.aeog == null) || (Util.isNullOrNil(str1)))
        {
          v(h.s(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (Util.isNullOrNil(str2))
        {
          com.tencent.mm.pluginsdk.model.app.as.gxp().add(paramIntent);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.aeog.pX(str1, str2);
        Log.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          v(h.s(paramIntent, true, false));
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
    if ((paramg != null) && (g.XSb.equals(paramg.field_appId)) && (this.OlE != null)) {
      this.OlE.dx(2, this.hlc.Uxa.field_username);
    }
    if (paramg.iIs())
    {
      if ((paramg == null) || (!paramg.iIs()))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.hlc.Uxa == null) || (Util.isNullOrNil(this.hlc.Uxa.field_username)))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      Log.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.jOL), paramg.field_packageName, paramg.field_appId });
      if ((paramg.jOL == 2) && (!Util.isNullOrNil(paramg.jOK)))
      {
        v(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.jOL == 3)
      {
        if (Util.isNullOrNil(paramg.field_openId))
        {
          com.tencent.mm.pluginsdk.model.app.as.gxp().add(paramg.field_appId);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.aeog == null) || (Util.isNullOrNil(paramg.field_packageName)))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          v(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.aeog.pX(paramg.field_packageName, paramg.field_openId);
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          v(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.jOL == 1)
      {
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.jOK });
        r.a.XNV.a(this.hlc.aezO.getContext(), paramg.jOK, false, new v()
        {
          public final Object iGK()
          {
            return b.this.hlc.Uxa.field_username;
          }
          
          public final Object iGL()
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
    if ((!this.aeog.pX(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      Log.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.jOy });
      if (Util.isNullOrNil(paramg.jOy))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.jOy);
      com.tencent.mm.br.c.b(this.hlc.aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.b
 * JD-Core Version:    0.7.0.1
 */