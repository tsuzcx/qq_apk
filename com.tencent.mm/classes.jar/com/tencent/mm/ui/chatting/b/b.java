package com.tencent.mm.ui.chatting.b;

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
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.o;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.h.c.r;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bt;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXFileObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.p.a;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.u;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.aq;
import com.tencent.mm.ui.chatting.at;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@com.tencent.mm.ui.chatting.b.a.a(cFA=com.tencent.mm.ui.chatting.b.b.a.class)
public class b
  extends a
  implements com.tencent.mm.ui.chatting.b.b.a
{
  private com.tencent.mm.plugin.wallet.a nzT = null;
  private at vow = null;
  private final j.a vox = new b.1(this);
  private final j.a voy = new b.2(this);
  
  private boolean a(bi parambi, f paramf)
  {
    if ((!parambi.field_talker.endsWith("@qqim")) || (!paramf.field_packageName.equals("com.tencent.mobileqq"))) {
      return false;
    }
    y.d("MicroMsg.ChattingUI.AppMsgComponent", "jacks open QQ");
    parambi = new Intent("android.intent.action.MAIN", null);
    parambi.addCategory("android.intent.category.LAUNCHER");
    parambi.addFlags(268435456);
    parambi.setClassName("com.tencent.mobileqq", aF(this.byx.vtz.getContext(), "com.tencent.mobileqq"));
    parambi.putExtra("platformId", "wechat");
    com.tencent.mm.model.au.Hx();
    paramf = com.tencent.mm.model.c.Dz().get(9, null);
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
        label217:
        i = 0;
      }
      catch (UnsupportedEncodingException paramf)
      {
        try
        {
          for (;;)
          {
            this.byx.vtz.startActivity(parambi);
            return true;
            paramf = paramf;
            y.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramf, "", new Object[0]);
          }
        }
        catch (Exception parambi)
        {
          break label217;
        }
      }
    }
  }
  
  private static String aF(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramString = paramContext.getPackageInfo(paramString, 0);
      Intent localIntent = new Intent("android.intent.action.MAIN", null);
      localIntent.addCategory("android.intent.category.LAUNCHER");
      localIntent.setPackage(paramString.packageName);
      paramContext = (ResolveInfo)paramContext.queryIntentActivities(localIntent, 0).iterator().next();
      if (paramContext != null)
      {
        paramContext = paramContext.activityInfo.name;
        return paramContext;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      y.printErrStackTrace("MicroMsg.ChattingUI.AppMsgComponent", paramContext, "", new Object[0]);
    }
    return null;
  }
  
  private void o(f paramf)
  {
    if ((paramf == null) || (bk.bl(paramf.field_appId)))
    {
      y.e("MicroMsg.ChattingUI.AppMsgComponent", "jumpServiceH5 error args");
      return;
    }
    if (bk.bl(paramf.cvS))
    {
      y.e("MicroMsg.ChattingUI.AppMsgComponent", "ForwardUrl is null");
      return;
    }
    Object localObject1 = this.byx.vtz.getContext().getSharedPreferences(ae.cqR(), 0);
    this.byx.vtz.getContext();
    Object localObject2 = com.tencent.mm.sdk.platformtools.x.d((SharedPreferences)localObject1);
    localObject1 = localObject2;
    if ("language_default".equalsIgnoreCase((String)localObject2))
    {
      localObject1 = localObject2;
      if (Locale.getDefault() != null) {
        localObject1 = Locale.getDefault().toString();
      }
    }
    if (s.fn(this.byx.getTalkerUserName()))
    {
      com.tencent.mm.model.au.Hx();
      localObject2 = com.tencent.mm.model.c.FF().in(this.byx.getTalkerUserName());
      if (localObject2 == null) {}
    }
    for (int i = ((u)localObject2).MN().size();; i = 1)
    {
      localObject2 = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("jsapi_args_appid", paramf.field_appId);
      localBundle.putBoolean("isFromService", true);
      ((Intent)localObject2).putExtra("forceHideShare", true);
      localBundle.putString("sendAppMsgToUserName", this.byx.pSb.field_username);
      ((Intent)localObject2).putExtra("jsapiargs", localBundle);
      ((Intent)localObject2).putExtra("show_bottom", false);
      ((Intent)localObject2).putExtra("rawUrl", String.format("%s&wxchatmembers=%s&lang=%s", new Object[] { paramf.cvS, Integer.valueOf(i), localObject1 }));
      d.b(this.byx.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject2);
      return;
    }
  }
  
  public final void a(com.tencent.mm.pluginsdk.ui.tools.m paramm)
  {
    bt.If().d(38, new Object[] { Integer.valueOf(1) });
    Object localObject = paramm.filePath;
    paramm = new WXMediaMessage(new WXFileObject((String)localObject));
    localObject = new com.tencent.mm.vfs.b((String)localObject);
    paramm.title = ((com.tencent.mm.vfs.b)localObject).getName();
    paramm.description = bk.cm(((com.tencent.mm.vfs.b)localObject).length());
    localObject = new f();
    ((f)localObject).field_appId = "wx4310bbd51be7d979";
    ap.brn().b((com.tencent.mm.sdk.e.c)localObject, new String[0]);
    l.a(paramm, ((f)localObject).field_appId, ((f)localObject).field_appName, this.byx.getTalkerUserName(), 2, null);
  }
  
  public final void a(bi parambi, am paramam)
  {
    Object localObject1 = parambi.field_content;
    Object localObject2;
    if (parambi.field_isSend == 0)
    {
      localObject2 = this.byx;
      int i = parambi.field_isSend;
      if ((!((com.tencent.mm.ui.chatting.b.b.c)((com.tencent.mm.ui.chatting.c.a)localObject2).ac(com.tencent.mm.ui.chatting.b.b.c.class)).cDH()) && (((com.tencent.mm.ui.chatting.c.a)localObject2).cFD()) && (localObject1 != null) && (i == 0)) {
        localObject1 = bd.iJ((String)localObject1);
      }
    }
    for (;;)
    {
      localObject2 = g.a.gp((String)localObject1);
      f localf = com.tencent.mm.pluginsdk.model.app.g.by(((g.a)localObject2).appId, true);
      if ((localf != null) && (com.tencent.mm.pluginsdk.model.app.p.o(this.byx.vtz.getContext(), localf.field_packageName)))
      {
        if (localf.field_status == 3) {
          y.e("MicroMsg.ChattingUI.AppMsgComponent", "requestAppShow fail, app is in blacklist, packageName = " + localf.field_packageName);
        }
        do
        {
          return;
          if (!com.tencent.mm.pluginsdk.model.app.p.b(this.byx.vtz.getContext(), localf))
          {
            y.e("MicroMsg.ChattingUI.AppMsgComponent", "The app %s signature is incorrect.", new Object[] { localf.field_appName });
            Toast.makeText(this.byx.vtz.getContext(), this.byx.vtz.getMMResources().getString(R.l.game_launch_fail_alert, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.byx.vtz.getContext(), localf, null) }), 1).show();
            return;
          }
        } while (a(parambi, localf));
        WXAppExtendObject localWXAppExtendObject = new WXAppExtendObject();
        localWXAppExtendObject.extInfo = ((g.a)localObject2).extInfo;
        if ((((g.a)localObject2).bFE != null) && (((g.a)localObject2).bFE.length() > 0))
        {
          localObject1 = ap.avh().VQ(((g.a)localObject2).bFE);
          if (localObject1 != null) {
            break label441;
          }
        }
        label441:
        for (localObject1 = null;; localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath)
        {
          localWXAppExtendObject.filePath = ((String)localObject1);
          localObject1 = new WXMediaMessage();
          ((WXMediaMessage)localObject1).sdkVer = 620824064;
          ((WXMediaMessage)localObject1).mediaObject = localWXAppExtendObject;
          ((WXMediaMessage)localObject1).title = ((g.a)localObject2).title;
          ((WXMediaMessage)localObject1).description = ((g.a)localObject2).description;
          ((WXMediaMessage)localObject1).messageAction = ((g.a)localObject2).messageAction;
          ((WXMediaMessage)localObject1).messageExt = ((g.a)localObject2).messageExt;
          ((WXMediaMessage)localObject1).thumbData = com.tencent.mm.vfs.e.c(o.OJ().me(parambi.field_imgPath), 0, -1);
          new com.tencent.mm.ui.chatting.au(this.byx.vtz.getContext()).a(localf.field_packageName, (WXMediaMessage)localObject1, localf.field_appId, localf.field_openId, paramam);
          return;
        }
      }
      parambi = com.tencent.mm.pluginsdk.model.app.p.v(this.byx.vtz.getContext(), ((g.a)localObject2).appId, "message");
      paramam = new Intent();
      paramam.putExtra("rawUrl", parambi);
      d.b(this.byx.vtz.getContext(), "webview", ".ui.tools.WebViewUI", paramam);
      return;
    }
  }
  
  public final void cyO()
  {
    this.nzT = com.tencent.mm.plugin.wallet.a.cE(this.byx.pSb.field_username, 1);
    this.nzT.aO(1, this.byx.pSb.field_username);
    ap.avh().c(this.vox);
    ap.brn().c(this.voy);
    if (this.vow == null) {
      this.vow = new at(this.byx);
    }
    at localat = this.vow;
    this.byx.vtz.getContext();
    at.vnx.a(localat, null);
  }
  
  public final void cyQ() {}
  
  public final void cyR()
  {
    at localat = this.vow;
    this.byx.vtz.getContext();
    at.vnx.remove(localat);
    localat.vnw.clear();
    at.b(localat.vnv.getContext(), null);
    if (com.tencent.mm.model.au.DK())
    {
      ap.avh().d(this.vox);
      ap.brn().d(this.voy);
    }
  }
  
  public final void n(f paramf)
  {
    if (paramf == null) {
      y.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSelected, info is null, %s", new Object[] { bk.csb() });
    }
    label360:
    do
    {
      do
      {
        do
        {
          boolean bool;
          do
          {
            return;
            if ((paramf != null) && (f.rUa.equals(paramf.field_appId)) && (this.nzT != null)) {
              this.nzT.aO(2, this.byx.pSb.field_username);
            }
            if (!paramf.ckN()) {
              break label360;
            }
            if ((paramf == null) || (!paramf.ckN()))
            {
              y.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect not service app");
              return;
            }
            if ((this.byx.pSb == null) || (bk.bl(this.byx.pSb.field_username)))
            {
              y.e("MicroMsg.ChattingUI.AppMsgComponent", "serviceAppSelect talker is null");
              return;
            }
            y.i("MicroMsg.ChattingUI.AppMsgComponent", "serviceApp, jumpType[%d], package[%s], appid[%s]", new Object[] { Integer.valueOf(paramf.cvT), paramf.field_packageName, paramf.field_appId });
            if ((paramf.cvT == 2) && (!bk.bl(paramf.cvS)))
            {
              o(paramf);
              return;
            }
            if (paramf.cvT != 3) {
              break;
            }
            if (bk.bl(paramf.field_openId))
            {
              ap.brp().qh(paramf.field_appId);
              y.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail, openId is null, go get it");
              return;
            }
            if ((this.vow == null) || (bk.bl(paramf.field_packageName)))
            {
              y.e("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP fail");
              o(paramf);
              return;
            }
            bool = this.vow.gw(paramf.field_packageName, paramf.field_openId);
            y.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP 3RD APP success[%s]", new Object[] { Boolean.valueOf(bool) });
          } while (bool);
          o(paramf);
          return;
        } while (paramf.cvT != 1);
        y.i("MicroMsg.ChattingUI.AppMsgComponent", "JUMP NATIVE ForwardUrl[%s]", new Object[] { paramf.cvS });
        p.a.rSH.a(this.byx.vtz.getContext(), paramf.cvS, false, new b.3(this));
        return;
        if (paramf.field_status == 3)
        {
          y.e("MicroMsg.ChattingUI.AppMsgComponent", "onAppSeleted fail, app is in blacklist, packageName = " + paramf.field_packageName);
          return;
        }
      } while ((this.vow.gw(paramf.field_packageName, paramf.field_openId)) || (paramf.field_status != 5));
      y.d("MicroMsg.ChattingUI.AppMsgComponent", "SuggestionApp appSuggestionIntroUrl = %s", new Object[] { paramf.cvG });
    } while (bk.bl(paramf.cvG));
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramf.cvG);
    d.b(this.byx.vtz.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    }
    boolean bool;
    do
    {
      do
      {
        do
        {
          return;
        } while (paramInt2 != -1);
        long l = paramIntent.getLongExtra("App_MsgId", 0L);
        com.tencent.mm.model.au.Hx();
        a(com.tencent.mm.model.c.Fy().fd(l), null);
        return;
      } while ((paramInt2 != -1) || (paramIntent == null));
      String str1 = paramIntent.getStringExtra("service_app_package_name");
      String str2 = paramIntent.getStringExtra("service_app_openid");
      paramIntent = paramIntent.getStringExtra("service_app_appid");
      if (this.vow != null) {}
      for (bool = true;; bool = false)
      {
        y.i("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg, wxmessage[%b], package[%s], appId[%s], openId[%s]", new Object[] { Boolean.valueOf(bool), str1, paramIntent, str2 });
        if (!bk.bl(paramIntent)) {
          break;
        }
        y.e("MicroMsg.ChattingUI.AppMsgComponent", "REQUEST_CODE_SERVICE_APP openId is null");
        return;
      }
      if ((this.vow == null) || (bk.bl(str1)))
      {
        o(com.tencent.mm.pluginsdk.model.app.g.by(paramIntent, true));
        return;
      }
      if (bk.bl(str2))
      {
        ap.brp().qh(paramIntent);
        y.e("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg fail, openId is null, go get it");
        return;
      }
      bool = this.vow.gw(str1, str2);
      y.d("MicroMsg.ChattingUI.AppMsgComponent", "request send wx msg success = %b", new Object[] { Boolean.valueOf(bool) });
    } while (bool);
    o(com.tencent.mm.pluginsdk.model.app.g.by(paramIntent, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.b
 * JD-Core Version:    0.7.0.1
 */