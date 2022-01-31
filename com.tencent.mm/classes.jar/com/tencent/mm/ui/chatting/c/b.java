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
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bv;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ai;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.r;
import com.tencent.mm.pluginsdk.r.a;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.chatting.ar;
import com.tencent.mm.vfs.e;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@com.tencent.mm.ui.chatting.c.a.a(dJy=com.tencent.mm.ui.chatting.c.b.b.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.c.b.b
{
  private com.tencent.mm.plugin.wallet.a qlj;
  private com.tencent.mm.ui.chatting.aq zDW;
  private final k.a zDX;
  private final k.a zDY;
  
  public b()
  {
    AppMethodBeat.i(31181);
    this.qlj = null;
    this.zDW = null;
    this.zDX = new b.1(this);
    this.zDY = new b.2(this);
    AppMethodBeat.o(31181);
  }
  
  private boolean a(bi parambi, f paramf)
  {
    AppMethodBeat.i(31186);
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq")))
    {
      AppMethodBeat.o(31186);
      return false;
    }
    ab.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aO(this.caz.zJz.getContext(), "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    aw.aaz();
    paramf = com.tencent.mm.model.c.Ru().get(9, null);
    int i;
    if ((paramf != null) && ((paramf instanceof Integer))) {
      i = ((Integer)paramf).intValue();
    }
    for (;;)
    {
      if (i != 0) {}
      try
      {
        paramf = String.valueOf(i).getBytes("utf-8");
        byte[] arrayOfByte = "asdfghjkl;'".getBytes("utf-8");
        int k = arrayOfByte.length;
        int j = 0;
        i = 0;
        while (j < k)
        {
          int m = arrayOfByte[j];
          if (i >= paramf.length) {
            break;
          }
          paramf[i] = ((byte)(m ^ paramf[i]));
          j += 1;
          i += 1;
        }
        parambi.putExtra("tencent_gif", paramf);
        label229:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            this.caz.zJz.startActivity(parambi);
            AppMethodBeat.o(31186);
            return true;
            paramf = paramf;
            ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label229;
        }
      }
    }
  }
  
  private static String aO(Context paramContext, String paramString)
  {
    AppMethodBeat.i(31187);
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext == null) {
        break label98;
      }
      paramContext = paramContext.activityInfo.name;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
        paramContext = null;
      }
    }
    AppMethodBeat.o(31187);
    return paramContext;
  }
  
  private void dHr()
  {
    AppMethodBeat.i(31182);
    if (this.zDW != null) {
      com.tencent.mm.ui.chatting.aq.b(this.zDW);
    }
    if (aw.RG())
    {
      al.aUJ().remove(this.zDX);
      al.cac().remove(this.zDY);
    }
    AppMethodBeat.o(31182);
  }
  
  private void t(f paramf)
  {
    AppMethodBeat.i(31184);
    if ((paramf == null) || (bo.isNullOrNil(paramf.field_appId)))
    {
      ab.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      AppMethodBeat.o(31184);
      return;
    }
    if (bo.isNullOrNil(paramf.dkd))
    {
      ab.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      AppMethodBeat.o(31184);
      return;
    }
    Object localObject1 = this.caz.zJz.getContext().getSharedPreferences(ah.dsP(), 0);
    this.caz.zJz.getContext();
    Object localObject2 = aa.f((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (com.tencent.mm.model.t.lA(this.caz.getTalkerUserName()))
    {
      aw.aaz();
      localObject2 = com.tencent.mm.model.c.YJ().oU(this.caz.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((u)localObject2).afx().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramf.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.caz.txj.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramf.dkd, Integer.valueOf(i), localObject1 }));
      com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      AppMethodBeat.o(31184);
      return;
    }
  }
  
  public final void a(com.tencent.mm.pluginsdk.ui.tools.o paramo)
  {
    AppMethodBeat.i(31188);
    bv.abc().c(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramo.filePath;
    paramo = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new com.tencent.mm.vfs.b((String)localObject);
    paramo.title = ((com.tencent.mm.vfs.b)localObject).getName();
    paramo.description = bo.hk(((com.tencent.mm.vfs.b)localObject).length());
    localObject = new f();
    ((f)localObject).field_appId = "wx4310bbd51be7d979";
    al.cac().get((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    l.a(paramo, ((f)localObject).field_appId, ((f)localObject).field_appName, this.caz.getTalkerUserName(), 2, null);
    AppMethodBeat.o(31188);
  }
  
  public final void a(bi parambi, ai paramai)
  {
    AppMethodBeat.i(31185);
    Object localObject1 = parambi.field_content;
    Object localObject2;
    if (parambi.field_isSend == 0)
    {
      localObject2 = this.caz;
      int i = parambi.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.c.b.d)((com.tencent.mm.ui.chatting.d.a)localObject2).ay(com.tencent.mm.ui.chatting.c.b.d.class)).dHw()) && (((com.tencent.mm.ui.chatting.d.a)localObject2).dJF()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bf.pv((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = j.b.mY((String)localObject1);
      f localf = com.tencent.mm.pluginsdk.model.app.g.ca(((j.b)localObject2).appId, true);
      if ((localf != null) && (p.u(this.caz.zJz.getContext(), localf.field_packageName)))
      {
        if (localf.field_status == 3)
        {
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localf.field_packageName);
          AppMethodBeat.o(31185);
          return;
        }
        if (!p.b(this.caz.zJz.getContext(), localf))
        {
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localf.field_appName });
          Toast.makeText(this.caz.zJz.getContext(), this.caz.zJz.getMMResources().getString(2131300385, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.caz.zJz.getContext(), localf, null) }), 1).show();
          AppMethodBeat.o(31185);
          return;
        }
        if (a(parambi, localf))
        {
          AppMethodBeat.o(31185);
          return;
        }
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((j.b)localObject2).extInfo;
        if ((((j.b)localObject2).cmN != null) && (((j.b)localObject2).cmN.length() > 0))
        {
          localObject1 = al.aUJ().alo(((j.b)localObject2).cmN);
          if (localObject1 != null) {
            break label472;
          }
        }
        label472:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 620954624;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((j.b)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((j.b)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((j.b)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((j.b)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = e.i(com.tencent.mm.at.o.ahC().te(parambi.field_imgPath), 0, -1);
          new ar(this.caz.zJz.getContext()).a(localf.field_packageName, (WXMediaMessage)localObject1, localf.field_appId, localf.field_openId, paramai);
          AppMethodBeat.o(31185);
          return;
        }
      }
      parambi = p.C(this.caz.zJz.getContext(), ((j.b)localObject2).appId, "message");
      paramai = new Intent();
      paramai.putExtra("rawUrl", parambi);
      com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "webview", ".ui.tools.WebViewUI", paramai);
      AppMethodBeat.o(31185);
      return;
    }
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31190);
    this.qlj = com.tencent.mm.plugin.wallet.a.dC(this.caz.txj.field_username, 1);
    this.qlj.bs(1, this.caz.txj.field_username);
    al.aUJ().add(this.zDX);
    al.cac().add(this.zDY);
    if (this.zDW == null) {
      this.zDW = new com.tencent.mm.ui.chatting.aq(this.caz);
    }
    com.tencent.mm.ui.chatting.aq.a(this.zDW);
    AppMethodBeat.o(31190);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31191);
    an.clear();
    AppMethodBeat.o(31191);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31192);
    dHr();
    AppMethodBeat.o(31192);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31193);
    super.dHq();
    dHr();
    AppMethodBeat.o(31193);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(31189);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(31189);
      return;
      if (paramInt2 == -1)
      {
        long l = paramIntent.getLongExtra("App_MsgId", 0L);
        aw.aaz();
        a(com.tencent.mm.model.c.YC().kB(l), null);
      }
      AppMethodBeat.o(31189);
      return;
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        String str1 = paramIntent.getStringExtra("service_app_package_name");
        String str2 = paramIntent.getStringExtra("service_app_openid");
        paramIntent = paramIntent.getStringExtra("service_app_appid");
        if (this.zDW != null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
          if (!bo.isNullOrNil(paramIntent)) {
            break;
          }
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
          AppMethodBeat.o(31189);
          return;
        }
        if ((this.zDW == null) || (bo.isNullOrNil(str1)))
        {
          t(com.tencent.mm.pluginsdk.model.app.g.ca(paramIntent, true));
          AppMethodBeat.o(31189);
          return;
        }
        if (bo.isNullOrNil(str2))
        {
          al.cae().xB(paramIntent);
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
          AppMethodBeat.o(31189);
          return;
        }
        bool = this.zDW.iz(str1, str2);
        ab.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          t(com.tencent.mm.pluginsdk.model.app.g.ca(paramIntent, true));
        }
      }
    }
  }
  
  public final void s(f paramf)
  {
    AppMethodBeat.i(31183);
    if (paramf == null)
    {
      ab.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bo.dtY() });
      AppMethodBeat.o(31183);
      return;
    }
    if ((paramf != null) && (f.vKX.equals(paramf.field_appId)) && (this.qlj != null)) {
      this.qlj.bs(2, this.caz.txj.field_username);
    }
    if (paramf.dlw())
    {
      if ((paramf == null) || (!paramf.dlw()))
      {
        ab.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
        AppMethodBeat.o(31183);
        return;
      }
      if ((this.caz.txj == null) || (bo.isNullOrNil(this.caz.txj.field_username)))
      {
        ab.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
        AppMethodBeat.o(31183);
        return;
      }
      ab.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramf.dke), paramf.field_packageName, paramf.field_appId });
      if ((paramf.dke == 2) && (!bo.isNullOrNil(paramf.dkd)))
      {
        t(paramf);
        AppMethodBeat.o(31183);
        return;
      }
      if (paramf.dke == 3)
      {
        if (bo.isNullOrNil(paramf.field_openId))
        {
          al.cae().xB(paramf.field_appId);
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
          AppMethodBeat.o(31183);
          return;
        }
        if ((this.zDW == null) || (bo.isNullOrNil(paramf.field_packageName)))
        {
          ab.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
          t(paramf);
          AppMethodBeat.o(31183);
          return;
        }
        boolean bool = this.zDW.iz(paramf.field_packageName, paramf.field_openId);
        ab.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
        if (!bool) {
          t(paramf);
        }
        AppMethodBeat.o(31183);
        return;
      }
      if (paramf.dke == 1)
      {
        ab.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramf.dkd });
        r.a.vJD.a(this.caz.zJz.getContext(), paramf.dkd, false, new b.3(this));
      }
      AppMethodBeat.o(31183);
      return;
    }
    if (paramf.field_status == 3)
    {
      ab.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramf.field_packageName);
      AppMethodBeat.o(31183);
      return;
    }
    if ((!this.zDW.iz(paramf.field_packageName, paramf.field_openId)) && (paramf.field_status == 5))
    {
      ab.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramf.djR });
      if (bo.isNullOrNil(paramf.djR))
      {
        AppMethodBeat.o(31183);
        return;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("rawUrl", paramf.djR);
      com.tencent.mm.bq.d.b(this.caz.zJz.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
    }
    AppMethodBeat.o(31183);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.b
 * JD-Core Version:    0.7.0.1
 */