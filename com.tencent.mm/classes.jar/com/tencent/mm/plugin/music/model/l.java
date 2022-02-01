package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ig;
import com.tencent.mm.autogen.a.ig.a;
import com.tencent.mm.aw.f;
import com.tencent.mm.br.c;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicVideoObject;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.music.e.c.b;
import com.tencent.mm.plugin.secdata.ui.a.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dtk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.threadpool.e.e.a;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/music/model/MusicUIUtil;", "", "()V", "CANCEL_JUMP", "", "FROM_ACTION_BAR_RIGHT", "FROM_ACTION_FORWARD", "FROM_ACTION_LONG_PRESS", "FROM_ACTION_SET_STATUS", "FROM_SONG_DIALOG", "JUMP_ERROR_WITH_NO_WRAPPER", "JUMP_TO_APP", "JUMP_TO_APPBRAND", "JUMP_TO_BIZ", "JUMP_TO_CALLBACK", "JUMP_TO_SHAKE_QQ_MUSIC", "JUMP_TO_WEB", "TAG", "", "doJumpToApp", "context", "Landroid/content/Context;", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "songInfo", "Lcom/tencent/mm/protocal/protobuf/FinderMVSongInfo;", "callback", "Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;", "doJumpToQQMusicPayment", "", "token", "formatFinderNumber", "number", "getBgAndLyricColor", "", "bitmap", "Landroid/graphics/Bitmap;", "getCurrentMusic", "Lcom/tencent/mm/plugin/music/model/storage/Music;", "activity", "Landroid/app/Activity;", "isChinesePeople", "", "isoCode", "jumpToSongWebUrl", "jumpToWebUrl", "url", "launchQQMusic", "setWindowStyle", "isShowStatusBar", "isShowNavigationBar", "updatePlayIcon", "isChecked", "playBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "playBtnColor", "plugin-music_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
{
  public static final l LMH;
  
  static
  {
    AppMethodBeat.i(271233);
    LMH = new l();
    AppMethodBeat.o(271233);
  }
  
  public static int a(Context paramContext, f paramf, boo paramboo, ap paramap)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    int j = 0;
    AppMethodBeat.i(271180);
    s.u(paramContext, "context");
    if (paramf == null)
    {
      Log.e("MusicUIUtil", "doJumpToApp wrapper is null");
      AppMethodBeat.o(271180);
      return -1;
    }
    Log.i("MusicUIUtil", "doJumpToApp MusicType:%d, SongWebUrl:%s, AppId:%s, srcUsername:%s", new Object[] { Integer.valueOf(paramf.oOt), paramf.oOD, paramf.oOI, paramf.iaa });
    Object localObject3 = com.tencent.mm.pluginsdk.model.app.h.s(paramf.oOI, true, false);
    if (localObject3 != null) {
      Log.i("MusicUIUtil", "packageName:%s", new Object[] { ((g)localObject3).field_packageName });
    }
    int i;
    while (paramf.oOt == 11)
    {
      paramContext = new ig();
      paramContext.publish();
      paramboo = paramContext.hJJ.appId;
      paramf = paramContext.hJJ.hEy;
      paramap = paramContext.hJJ.appUserName;
      i = paramContext.hJJ.hJK;
      paramContext = paramf;
      if (TextUtils.isEmpty((CharSequence)paramf)) {
        paramContext = "";
      }
      Log.i("MusicUIUtil", "from app brand, appId:%s, brandName:%s, pkgType:%d, appUserName:%s", new Object[] { paramboo, paramContext, Integer.valueOf(i), paramap });
      Log.i("MusicUIUtil", "launch app brand Application");
      m.at(paramboo, paramap, i);
      AppMethodBeat.o(271180);
      return 4;
      Log.e("MusicUIUtil", "appInfo is null");
    }
    if ((!TextUtils.isEmpty((CharSequence)paramf.oOI)) && (s.p(paramf.oOI, "wx485a97c844086dc9")))
    {
      Log.i("MusicUIUtil", "launch qq music Application");
      m.b(paramf, (Activity)paramContext);
      AppMethodBeat.o(271180);
      return 5;
    }
    if ((!TextUtils.isEmpty((CharSequence)paramf.oOI)) && (localObject3 != null) && (!TextUtils.isEmpty((CharSequence)((g)localObject3).field_packageName)) && (com.tencent.mm.pluginsdk.model.app.h.y(paramContext, paramf.oOI)))
    {
      if (m.aml(paramf.oOI))
      {
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(10910, "4");
        localObject2 = paramf.oOD;
        localObject1 = com.tencent.mm.plugin.music.h.e.aPv((String)localObject2);
        paramboo = (boo)localObject1;
        if (localObject1 == null) {
          paramboo = "";
        }
        localObject2 = com.tencent.mm.plugin.music.h.e.aPu((String)localObject2);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        if (((CharSequence)paramboo).length() > 0)
        {
          i = 1;
          if (i == 0)
          {
            if (((CharSequence)localObject1).length() <= 0) {
              break label545;
            }
            i = 1;
            label439:
            if (i == 0) {
              break label551;
            }
          }
          paramboo = "qqmusic://qq.com/media/playSonglist?p=%7b%22song%22%3a%5b%7b%22type%22%3a%220%22%2c%22songid%22%3a%22" + paramboo + "%22%2c%22songmid%22%3a%22" + (String)localObject1 + "%22%7d%5d%2c%22action%22%3a%22play%22%7d&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_weixin";
          label479:
          Log.i("MusicUIUtil", "launchQQMusic qqMusicActionUrl: %s", new Object[] { paramboo });
          localObject1 = Uri.parse(paramboo);
          if (localObject1 != null) {
            break label558;
          }
          Log.w("MusicUIUtil", "launchQQMusic parse qq music action url fail, url %s", new Object[] { paramboo });
          i = j;
        }
        for (;;)
        {
          if (i != 0)
          {
            AppMethodBeat.o(271180);
            return 7;
            i = 0;
            break;
            label545:
            i = 0;
            break label439;
            label551:
            paramboo = "qqmusic://qq.com/ui/jumpTab?p=%7B%22page%22%3A%221%22%7D&source=https%3a%2f%2fi.y.qq.com%2fv8%2fplaysong.html%3fADTAG%3dhz_weixin";
            break label479;
            label558:
            localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject1);
            ((Intent)localObject2).addFlags(268435456);
            i = j;
            if (Util.isIntentAvailable(paramContext, (Intent)localObject2))
            {
              localObject1 = com.tencent.mm.pluginsdk.model.app.h.a(paramContext, com.tencent.mm.pluginsdk.model.app.h.s(paramf.oOI, true, false), null);
              paramboo = (boo)localObject1;
              if (localObject1 == null) {
                paramboo = "";
              }
              if (((CharSequence)paramboo).length() > 0)
              {
                i = 1;
                label636:
                if (i == 0) {
                  break label755;
                }
                paramboo = paramContext.getString(a.h.launch_3rd_detail_app_tips, new Object[] { paramboo });
                label657:
                s.s(paramboo, "if (appName.isNotEmpty()…d_app_tips)\n            }");
                localObject1 = new g.a(paramContext);
                ((g.a)localObject1).bDE(paramboo).bDI(paramContext.getString(a.h.launch_3rd_app_confirm)).bDJ(paramContext.getString(a.h.app_cancel)).b(new l..ExternalSyntheticLambda1(paramContext, (Intent)localObject2, paramap)).a(new l..ExternalSyntheticLambda2(paramap));
                if (!s.p(Looper.myLooper(), Looper.getMainLooper())) {
                  break label766;
                }
                ((g.a)localObject1).show();
              }
              for (;;)
              {
                i = 1;
                break;
                i = 0;
                break label636;
                label755:
                paramboo = paramContext.getString(a.h.launch_3rd_app_tips);
                break label657;
                label766:
                com.tencent.threadpool.e.e.jZg().jZl().a(new l..ExternalSyntheticLambda4((g.a)localObject1)).jZk();
              }
            }
          }
        }
        Log.e("MusicUIUtil", "jumpToApp launch QQMusic failed");
        a(paramContext, paramf);
        AppMethodBeat.o(271180);
        return 2;
      }
      Log.i("MusicUIUtil", "launch third party app, package name:%s", new Object[] { ((g)localObject3).field_packageName });
      WXMusicVideoObject localWXMusicVideoObject = new WXMusicVideoObject();
      localWXMusicVideoObject.musicUrl = paramf.oOD;
      localWXMusicVideoObject.musicDataUrl = paramf.oOB;
      if (paramboo == null)
      {
        localObject1 = "";
        localWXMusicVideoObject.identification = URLDecoder.decode((String)localObject1);
        localObject3 = new WXMediaMessage((WXMediaMessage.IMediaObject)localWXMusicVideoObject);
        ((WXMediaMessage)localObject3).sdkVer = 638058496;
        if (paramboo != null) {
          break label1019;
        }
        paramboo = "";
      }
      for (;;)
      {
        ((WXMediaMessage)localObject3).messageExt = URLDecoder.decode(paramboo);
        paramboo = com.tencent.mm.plugin.secdata.ui.a.PlI;
        localObject1 = (dtk)a.a.a(paramContext, 7, dtk.class);
        paramboo = (boo)localObject2;
        if (localObject1 != null)
        {
          paramboo = new Bundle();
          paramboo.putString("current_page_biz_info", ((dtk)localObject1).zIO);
          paramboo.putString("current_page_source_info", "music_operation_webview");
          localObject1 = ah.aiuX;
        }
        com.tencent.mm.pluginsdk.model.app.h.a(paramContext, paramf.oOI, (WXMediaMessage)localObject3, 0, paramap, paramboo);
        AppMethodBeat.o(271180);
        return 7;
        localObject3 = paramboo.identification;
        localObject1 = localObject3;
        if (localObject3 != null) {
          break;
        }
        localObject1 = "";
        break;
        label1019:
        localObject1 = paramboo.extraInfo;
        paramboo = (boo)localObject1;
        if (localObject1 == null) {
          paramboo = "";
        }
      }
    }
    if (!TextUtils.isEmpty((CharSequence)paramf.iaa))
    {
      if (paramf.oOD == null) {}
      for (paramf = paramf.oOB;; paramf = paramf.oOD)
      {
        Log.i("MusicUIUtil", "launch biz H5 url:%s", new Object[] { paramf });
        paramboo = new Intent();
        paramboo.putExtra("rawUrl", paramf);
        c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramboo);
        AppMethodBeat.o(271180);
        return 6;
      }
    }
    if (paramboo == null)
    {
      paramap = null;
      if (Util.isNullOrNil(paramap)) {
        break label1191;
      }
      Log.i("MusicUIUtil", "use androdiDownloadUrl");
      if (paramboo != null) {
        break label1183;
      }
    }
    label1183:
    for (paramf = (f)localObject1;; paramf = paramboo.ZWV)
    {
      s.checkNotNull(paramf);
      s.s(paramf, "songInfo?.androidDownloadUrl!!");
      bx(paramContext, paramf);
      AppMethodBeat.o(271180);
      return 2;
      paramap = paramboo.ZWV;
      break;
    }
    label1191:
    if (!TextUtils.isEmpty((CharSequence)paramf.oOI))
    {
      paramboo = com.tencent.mm.plugin.comm.a.xeG;
      if (com.tencent.mm.plugin.comm.a.aml(paramf.oOI)) {
        paramboo = "https://y.qq.com/m/download/index.html?channelId=2005000732";
      }
    }
    for (;;)
    {
      if (!Util.isNullOrNil(paramboo))
      {
        bx(paramContext, paramboo);
        AppMethodBeat.o(271180);
        return 2;
        paramboo = com.tencent.mm.plugin.comm.a.xeG;
        if (com.tencent.mm.plugin.comm.a.amm(paramf.oOI))
        {
          paramboo = "https://a.app.qq.com/o/simple.jsp?pkgname=com.netease.cloudmusic";
        }
        else
        {
          paramboo = com.tencent.mm.plugin.comm.a.xeG;
          if (com.tencent.mm.plugin.comm.a.amo(paramf.oOI))
          {
            paramboo = "https://a.app.qq.com/o/simple.jsp?pkgname=com.kugou.android";
          }
          else
          {
            paramboo = com.tencent.mm.plugin.comm.a.xeG;
            if (com.tencent.mm.plugin.comm.a.amn(paramf.oOI)) {
              paramboo = "https://a.app.qq.com/o/simple.jsp?pkgname=cn.kuwo.player";
            } else {
              paramboo = "";
            }
          }
        }
      }
      else
      {
        a(paramContext, paramf);
        AppMethodBeat.o(271180);
        return 2;
        paramboo = "";
      }
    }
  }
  
  private static final Object a(g.a parama, e.a parama1)
  {
    AppMethodBeat.i(271222);
    s.u(parama, "$builder");
    parama.show();
    AppMethodBeat.o(271222);
    return null;
  }
  
  private static final void a(Context paramContext, Intent paramIntent, ap paramap, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(271212);
    s.u(paramContext, "$context");
    s.u(paramIntent, "$other");
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/music/model/MusicUIUtil", "doJumpToQQMusicPayment$lambda-0", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/music/model/MusicUIUtil", "doJumpToQQMusicPayment$lambda-0", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (paramap != null)
      {
        paramap.onLaunchApp(true, false);
        AppMethodBeat.o(271212);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MusicUIUtil", (Throwable)paramContext, "launchQQMusic exception", new Object[0]);
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(271212);
    }
  }
  
  private static void a(Context paramContext, f paramf)
  {
    AppMethodBeat.i(271188);
    if (paramf.oOD == null) {}
    for (paramf = paramf.oOB;; paramf = paramf.oOD)
    {
      s.s(paramf, "url");
      bx(paramContext, paramf);
      AppMethodBeat.o(271188);
      return;
    }
  }
  
  public static void a(Context paramContext, String paramString, f paramf)
  {
    AppMethodBeat.i(271146);
    s.u(paramContext, "context");
    s.u(paramf, "wrapper");
    if (paramString != null) {
      if (((CharSequence)paramString).length() != 0) {
        break label48;
      }
    }
    label48:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(271146);
      return;
    }
    if (!com.tencent.mm.pluginsdk.model.app.h.y(paramContext, "wx5aa333606550dfd5"))
    {
      bx(paramContext, "https://y.qq.com/m/download/index.html?channelId=2005000732");
      AppMethodBeat.o(271146);
      return;
    }
    paramString = s.X("qqmusic://qq.com/other/wxpurchase?wx_membership_ticket=", paramString);
    Log.i("MusicUIUtil", "launchQQMusic qqMusicActionUrl: %s", new Object[] { paramString });
    Object localObject = Uri.parse(paramString);
    if (localObject == null)
    {
      Log.w("MusicUIUtil", "launchQQMusic parse qq music action url fail, url %s", new Object[] { paramString });
      AppMethodBeat.o(271146);
      return;
    }
    localObject = new Intent("android.intent.action.VIEW", (Uri)localObject);
    ((Intent)localObject).addFlags(268435456);
    if (Util.isIntentAvailable(paramContext, (Intent)localObject))
    {
      paramf = com.tencent.mm.pluginsdk.model.app.h.a(paramContext, com.tencent.mm.pluginsdk.model.app.h.s(paramf.oOI, true, false), null);
      paramString = paramf;
      if (paramf == null) {
        paramString = "";
      }
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label320;
        }
      }
      label320:
      for (paramString = paramContext.getString(a.h.launch_3rd_detail_app_tips, new Object[] { paramString });; paramString = paramContext.getString(a.h.launch_3rd_app_tips))
      {
        s.s(paramString, "if (appName.isNotEmpty()…d_app_tips)\n            }");
        paramf = new g.a(paramContext);
        paramf.bDE(paramString).bDI(paramContext.getString(a.h.launch_3rd_app_confirm)).bDJ(paramContext.getString(a.h.app_cancel)).b(new l..ExternalSyntheticLambda0(paramContext, (Intent)localObject, null)).a(new l..ExternalSyntheticLambda3(null));
        if (!s.p(Looper.myLooper(), Looper.getMainLooper())) {
          break label331;
        }
        paramf.show();
        AppMethodBeat.o(271146);
        return;
        i = 0;
        break;
      }
      label331:
      com.tencent.threadpool.e.e.jZg().jZl().a(new l..ExternalSyntheticLambda5(paramf)).jZk();
    }
    AppMethodBeat.o(271146);
  }
  
  private static final void a(ap paramap, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(271217);
    if (paramap != null) {
      paramap.onLaunchApp(false, true);
    }
    AppMethodBeat.o(271217);
  }
  
  public static void aX(Activity paramActivity)
  {
    AppMethodBeat.i(271199);
    s.u(paramActivity, "activity");
    paramActivity.getWindow().getDecorView().setSystemUiVisibility(5894);
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.getWindow().addFlags(-2147483648);
      paramActivity.getWindow().setStatusBarColor(0);
      paramActivity.getWindow().setNavigationBarColor(0);
    }
    paramActivity.getWindow().setFormat(-3);
    AppMethodBeat.o(271199);
  }
  
  private static final Object b(g.a parama, e.a parama1)
  {
    AppMethodBeat.i(271231);
    s.u(parama, "$builder");
    parama.show();
    AppMethodBeat.o(271231);
    return null;
  }
  
  private static final void b(Context paramContext, Intent paramIntent, ap paramap, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(271225);
    s.u(paramContext, "$context");
    s.u(paramIntent, "$other");
    try
    {
      paramIntent = new com.tencent.mm.hellhoundlib.b.a().cG(paramIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramIntent.aYi(), "com/tencent/mm/plugin/music/model/MusicUIUtil", "launchQQMusic$lambda-7", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramIntent.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/music/model/MusicUIUtil", "launchQQMusic$lambda-7", "(Landroid/content/Context;Landroid/content/Intent;Lcom/tencent/mm/pluginsdk/model/app/OnLaunchAppCallback;ZLjava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      if (paramap != null)
      {
        paramap.onLaunchApp(true, false);
        AppMethodBeat.o(271225);
        return;
      }
    }
    catch (Exception paramContext)
    {
      Log.printErrStackTrace("MusicUIUtil", (Throwable)paramContext, "launchQQMusic exception", new Object[0]);
      if (paramap != null) {
        paramap.onLaunchApp(false, false);
      }
      AppMethodBeat.o(271225);
    }
  }
  
  private static final void b(ap paramap, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(271227);
    if (paramap != null) {
      paramap.onLaunchApp(false, true);
    }
    AppMethodBeat.o(271227);
  }
  
  public static com.tencent.mm.plugin.music.model.e.a bb(Activity paramActivity)
  {
    AppMethodBeat.i(271206);
    s.u(paramActivity, "activity");
    com.tencent.mm.plugin.music.model.e.a locala = ((com.tencent.mm.plugin.music.logic.e)b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl();
    String str;
    if (locala == null)
    {
      str = "";
      if (paramActivity.getIntent().hasExtra("db_music_id"))
      {
        str = paramActivity.getIntent().getStringExtra("db_music_id");
        s.checkNotNull(str);
        s.s(str, "activity.intent.getStrin…sicPlayerUI.KDBMusicId)!!");
      }
      if (TextUtils.isEmpty((CharSequence)str)) {}
    }
    for (paramActivity = ((com.tencent.mm.plugin.music.logic.e)b.bU(com.tencent.mm.plugin.music.logic.e.class)).aOS(str);; paramActivity = locala)
    {
      AppMethodBeat.o(271206);
      return paramActivity;
    }
  }
  
  private static void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(271194);
    Log.i("MusicUIUtil", "launch H5 url:%s", new Object[] { paramString });
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(271194);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.l
 * JD-Core Version:    0.7.0.1
 */