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
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.f.c.y;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.cg;
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
import com.tencent.mm.pluginsdk.ui.tools.v;
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
import com.tencent.mm.ui.chatting.at;
import com.tencent.mm.ui.chatting.au;
import com.tencent.mm.ui.chatting.d.b.k;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.d.a.a(hRc=com.tencent.mm.ui.chatting.d.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.d.b.b
{
  private com.tencent.mm.plugin.wallet.a Iol;
  private at WGR;
  private final MStorage.IOnStorageChange WGS;
  private final MStorage.IOnStorageChange WGT;
  
  public b()
  {
    AppMethodBeat.i(35072);
    this.Iol = null;
    this.WGR = null;
    this.WGS = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35069);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app attach info watcher notify");
        ((k)b.this.fgR.bC(k.class)).hNI();
        AppMethodBeat.o(35069);
      }
    };
    this.WGT = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(35070);
        Log.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((k)b.this.fgR.bC(k.class)).hNI();
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
    paramca.setClassName("com.tencent.mobileqq", bF(this.fgR.WQv.getContext(), "com.tencent.mobileqq"));
    paramca.putExtra("platformId", "wechat");
    bh.beI();
    paramg = com.tencent.mm.model.c.aHp().b(9, null);
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
            paramg = this.fgR.WQv;
            paramca = new com.tencent.mm.hellhoundlib.b.a().bm(paramca);
            com.tencent.mm.hellhoundlib.a.a.b(paramg, paramca.aFh(), "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramg.startActivity((Intent)paramca.sf(0));
            com.tencent.mm.hellhoundlib.a.a.c(paramg, "com/tencent/mm/ui/chatting/component/AppMsgComponent", "dealOpenQQ", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/pluginsdk/model/app/AppInfo;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  private static String bF(Context paramContext, String paramString)
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
  
  private void hOa()
  {
    AppMethodBeat.i(35073);
    if (this.WGR != null) {
      at.b(this.WGR);
    }
    if (bh.aHB())
    {
      com.tencent.mm.pluginsdk.model.app.ao.ctZ().remove(this.WGS);
      com.tencent.mm.pluginsdk.model.app.ao.fmz().remove(this.WGT);
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
    if (Util.isNullOrNil(paramg.hrX))
    {
      Log.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(35075);
      return;
    }
    Object localObject2 = LocaleUtil.loadApplicationLanguage(this.fgR.WQv.getContext().getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this.fgR.WQv.getContext());
    Object localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (ab.Lj(this.fgR.getTalkerUserName()))
    {
      bh.beI();
      localObject2 = com.tencent.mm.model.c.bbV().Rw(this.fgR.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((ah)localObject2).bjL().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramg.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.fgR.NKq.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramg.hrX, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(35075);
      return;
    }
  }
  
  public final void a(v paramv)
  {
    AppMethodBeat.i(35079);
    cg.bfp().e(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramv.filePath;
    paramv = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new com.tencent.mm.vfs.q((String)localObject);
    paramv.title = ((com.tencent.mm.vfs.q)localObject).getName();
    paramv.description = Util.getSizeKB(((com.tencent.mm.vfs.q)localObject).length());
    localObject = new g();
    ((g)localObject).field_appId = "wx4310bbd51be7d979";
    com.tencent.mm.pluginsdk.model.app.ao.fmz().get((IAutoDBItem)localObject, new String[0]);
    m.a(paramv, ((g)localObject).field_appId, ((g)localObject).field_appName, this.fgR.getTalkerUserName(), 2, null);
    AppMethodBeat.o(35079);
  }
  
  public final void a(ca paramca, al paramal)
  {
    AppMethodBeat.i(35076);
    Object localObject1 = paramca.field_content;
    Object localObject2;
    if (paramca.field_isSend == 0)
    {
      localObject2 = this.fgR;
      int i = paramca.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.d.b.d)((com.tencent.mm.ui.chatting.e.a)localObject2).bC(com.tencent.mm.ui.chatting.d.b.d.class)).hOf()) && (((com.tencent.mm.ui.chatting.e.a)localObject2).hRh()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bq.RM((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = k.b.OQ((String)localObject1);
      g localg = h.o(((k.b)localObject2).appId, true, false);
      if ((localg != null) && (com.tencent.mm.pluginsdk.model.app.q.u(this.fgR.WQv.getContext(), localg.field_packageName)))
      {
        if (localg.field_status == 3)
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localg.field_packageName);
          AppMethodBeat.o(35076);
          return;
        }
        if (!com.tencent.mm.pluginsdk.model.app.q.c(this.fgR.WQv.getContext(), localg))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localg.field_appName });
          Toast.makeText(this.fgR.WQv.getContext(), this.fgR.WQv.getMMResources().getString(R.l.game_launch_fail_alert, new Object[] { h.a(this.fgR.WQv.getContext(), localg, null) }), 1).show();
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
        if ((((k.b)localObject2).fvr != null) && (((k.b)localObject2).fvr.length() > 0))
        {
          localObject1 = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(((k.b)localObject2).fvr);
          if (localObject1 != null) {
            break label547;
          }
        }
        label547:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.c)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          if (com.tencent.mm.vfs.u.agG(localWXAppExtendObject.filePath))
          {
            localObject1 = FileProviderHelper.getUriForFile(this.fgR.WQv.getContext(), new com.tencent.mm.vfs.q(localWXAppExtendObject.filePath));
            if (localObject1 != null)
            {
              this.fgR.WQv.getContext().grantUriPermission(localg.field_packageName, (Uri)localObject1, 1);
              localWXAppExtendObject.filePath = ((Uri)localObject1).toString();
            }
          }
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 637992960;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((k.b)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((k.b)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((k.b)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((k.b)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.u.aY(com.tencent.mm.ay.q.bmh().VW(paramca.field_imgPath), 0, -1);
          new au(this.fgR.WQv.getContext()).a(localg.field_packageName, (WXMediaMessage)localObject1, localg.field_appId, localg.field_openId, paramal);
          AppMethodBeat.o(35076);
          return;
        }
      }
      paramca = com.tencent.mm.pluginsdk.model.app.q.Z(this.fgR.WQv.getContext(), ((k.b)localObject2).appId, "message");
      paramal = new Intent();
      paramal.putExtra("rawUrl", paramca);
      com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", paramal);
      AppMethodBeat.o(35076);
      return;
    }
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35081);
    this.Iol = com.tencent.mm.plugin.wallet.a.gE(this.fgR.NKq.field_username, 1);
    this.Iol.cH(1, this.fgR.NKq.field_username);
    com.tencent.mm.pluginsdk.model.app.ao.ctZ().add(this.WGS);
    com.tencent.mm.pluginsdk.model.app.ao.fmz().add(this.WGT);
    if (this.WGR == null) {
      this.WGR = new at(this.fgR);
    }
    at.a(this.WGR);
    AppMethodBeat.o(35081);
  }
  
  public final void hGY()
  {
    AppMethodBeat.i(35082);
    com.tencent.mm.ui.chatting.aq.clear();
    AppMethodBeat.o(35082);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35083);
    hOa();
    AppMethodBeat.o(35083);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35084);
    super.hNZ();
    hOa();
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
        bh.beI();
        a(com.tencent.mm.model.c.bbO().Oq(l), null);
      }
      AppMethodBeat.o(35080);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.WGR != null) {}
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
        if ((this.WGR == null) || (Util.isNullOrNil(str1)))
        {
          v(h.o(paramIntent, true, false));
          AppMethodBeat.o(35080);
          return;
        }
        if (Util.isNullOrNil(str2))
        {
          com.tencent.mm.pluginsdk.model.app.ao.fmB().add(paramIntent);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(35080);
          return;
        }
        bool = this.WGR.nY(str1, str2);
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
    if ((paramg != null) && (g.QWe.equals(paramg.field_appId)) && (this.Iol != null)) {
      this.Iol.cH(2, this.fgR.NKq.field_username);
    }
    if (paramg.hhs())
    {
      if ((paramg == null) || (!paramg.hhs()))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(35074);
        return;
      }
      if ((this.fgR.NKq == null) || (Util.isNullOrNil(this.fgR.NKq.field_username)))
      {
        Log.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(35074);
        return;
      }
      Log.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramg.hrY), paramg.field_packageName, paramg.field_appId });
      if ((paramg.hrY == 2) && (!Util.isNullOrNil(paramg.hrX)))
      {
        v(paramg);
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.hrY == 3)
      {
        if (Util.isNullOrNil(paramg.field_openId))
        {
          com.tencent.mm.pluginsdk.model.app.ao.fmB().add(paramg.field_appId);
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(35074);
          return;
        }
        if ((this.WGR == null) || (Util.isNullOrNil(paramg.field_packageName)))
        {
          Log.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          v(paramg);
          AppMethodBeat.o(35074);
          return;
        }
        boolean bool = this.WGR.nY(paramg.field_packageName, paramg.field_openId);
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          v(paramg);
        }
        AppMethodBeat.o(35074);
        return;
      }
      if (paramg.hrY == 1)
      {
        Log.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramg.hrX });
        q.a.QSe.a(this.fgR.WQv.getContext(), paramg.hrX, false, new com.tencent.mm.pluginsdk.u()
        {
          public final Object hfQ()
          {
            return b.this.fgR.NKq.field_username;
          }
          
          public final Object hfR()
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
    if ((!this.WGR.nY(paramg.field_packageName, paramg.field_openId)) && (paramg.field_status == 5))
    {
      Log.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramg.hrL });
      if (Util.isNullOrNil(paramg.hrL))
      {
        AppMethodBeat.o(35074);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramg.hrL);
      com.tencent.mm.by.c.b(this.fgR.WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(35074);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.b
 * JD-Core Version:    0.7.0.1
 */