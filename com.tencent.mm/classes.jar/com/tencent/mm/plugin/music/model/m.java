package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.ov;
import com.tencent.mm.autogen.a.ov.b;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.dmz;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.LinkedList;

public final class m
{
  private static HashMap<Long, Long> vYD;
  private static HashMap<Long, String> vYE;
  
  static
  {
    AppMethodBeat.i(271279);
    vYD = new HashMap();
    vYE = new HashMap();
    AppMethodBeat.o(271279);
  }
  
  public static boolean G(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(271162);
    if ((!Util.isNullOrNil(paramf.oOC)) || (!Util.isNullOrNil(paramf.oOD)) || (!Util.isNullOrNil(paramf.oOB)))
    {
      AppMethodBeat.o(271162);
      return true;
    }
    AppMethodBeat.o(271162);
    return false;
  }
  
  public static String H(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = o.god().aPg(com.tencent.mm.plugin.music.h.b.Y(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.cA(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!y.ZC((String)localObject2)) {
      switch (paramf.oOt)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (q.Qki != null)
        {
          localObject1 = new dmz();
          ((dmz)localObject1).Id = paramf.oOL;
          ((dmz)localObject1).aaTl = paramf.oOA;
          ((dmz)localObject1).aaTm = paramf.oOJ;
          ((dmz)localObject1).Url = ((dmz)localObject1).aaTl;
          localObject1 = g.r((dmz)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new ov();
      ((ov)localObject1).hRE.action = 12;
      ((ov)localObject1).hRE.songAlbumUrl = paramf.oOA;
      ((ov)localObject1).publish();
      localObject1 = ((ov)localObject1).hRF.hRL;
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.oOF;
      }
      localObject1 = localObject2;
      if (!y.ZC((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.cA(locala.field_musicId, false);
        continue;
        localObject1 = r.bKa().X(paramf.oOF, true);
        continue;
        if (paramf.oOF == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.oOF;
          continue;
          if (paramf.oOF == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.oOF;
            continue;
            if (paramf.oOF == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.oOF;
            }
          }
        }
      }
    }
  }
  
  public static String I(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.oOI;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      switch (paramf.oOt)
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(63020);
      return str1;
      str1 = "wx482a4001c37e2b74";
      continue;
      str1 = "wx485a97c844086dc9";
    }
  }
  
  public static String J(com.tencent.mm.aw.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.oOt)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      paramf = MMApplicationContext.getContext().getString(a.h.default_music_prefix);
      AppMethodBeat.o(63021);
      return paramf;
    case 0: 
    case 1: 
    case 8: 
      paramf = MMApplicationContext.getContext().getString(a.h.sns_music_prefix);
      AppMethodBeat.o(63021);
      return paramf;
    case 5: 
      paramf = MMApplicationContext.getContext().getString(a.h.scan_music_prefix);
      AppMethodBeat.o(63021);
      return paramf;
    }
    paramf = MMApplicationContext.getContext().getString(a.h.shake_music_app);
    AppMethodBeat.o(63021);
    return paramf;
  }
  
  public static final void M(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(271264);
    by(paramContext, String.format("https://" + WeChatHosts.domainString(a.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s&comment_ID=%s", new Object[] { Integer.valueOf(71), paramString1, paramString2 }));
    AppMethodBeat.o(271264);
  }
  
  public static void a(com.tencent.mm.aw.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10910, "3");
    dn localdn = new dn();
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localasb.bto(z.bAM());
    localasb.btp(z.bAM());
    localasb.axH(5);
    localasb.yu(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bpJ(I(paramf))) {
      localasb.btu(I(paramf));
    }
    localarf.bsv(paramf.oOB);
    localarf.bsw(paramf.oOC);
    localarf.bsu(paramf.oOD);
    Object localObject = o.god().aPg(com.tencent.mm.plugin.music.h.b.Y(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).gop())
    {
      localarf.bsx(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localarf.Kj(true);
      localObject = H(paramf);
      if (!y.ZC((String)localObject)) {
        break label342;
      }
      localarf.bsD((String)localObject);
    }
    for (;;)
    {
      localarf.bso(paramf.oOx);
      localarf.bsp(paramf.oOy);
      localarf.axy(7);
      localarf.bsU(paramf.oOM);
      localarf.bsV(paramf.oOE);
      localdn.hDr.title = paramf.oOx;
      localdn.hDr.desc = paramf.oOy;
      localdn.hDr.hDt = localarv;
      localdn.hDr.type = 7;
      localarv.a(localasb);
      localarv.vEn.add(localarf);
      localdn.hDr.activity = paramActivity;
      localdn.hDr.hDy = 3;
      localdn.publish();
      AppMethodBeat.o(63015);
      return;
      localarf.bsx(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localarf.Kk(true);
    }
  }
  
  public static void a(com.tencent.mm.aw.f paramf, Intent paramIntent, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(271216);
    String str1 = paramIntent.getStringExtra("Select_Conv_User");
    paramIntent = new WXMusicObject();
    paramIntent.musicUrl = paramf.oOD;
    paramIntent.musicDataUrl = paramf.oOB;
    paramIntent.musicLowBandUrl = paramf.oOC;
    paramIntent.musicLowBandDataUrl = paramf.oOC;
    paramIntent.songAlbumUrl = paramf.oOM;
    paramIntent.songLyric = paramf.oOE;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = paramIntent;
    localWXMediaMessage.title = paramf.oOx;
    localWXMediaMessage.description = paramf.oOy;
    Object localObject = null;
    String str2 = H(paramf);
    paramIntent = localObject;
    if (str2 != null)
    {
      paramIntent = localObject;
      if (y.ZC(str2))
      {
        int i = (int)paramMMActivity.getResources().getDimension(a.c.NormalAvatarSize);
        paramIntent = BitmapUtil.getBitmapNative(str2, i, i);
      }
    }
    if (paramIntent != null)
    {
      localWXMediaMessage.thumbData = Util.bmpToByteArray(paramIntent, true);
      if (!com.tencent.mm.pluginsdk.model.app.h.bpJ(I(paramf))) {
        break label247;
      }
    }
    label247:
    for (paramIntent = I(paramf);; paramIntent = "")
    {
      if (f.pFn != null) {
        f.pFn.a(paramMMActivity, paramIntent, localWXMediaMessage, str1, J(paramf));
      }
      Log.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
      AppMethodBeat.o(271216);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(a.d.default_icon_music), true);
      break;
    }
  }
  
  public static void a(com.tencent.mm.aw.f paramf, boo paramboo, Activity paramActivity, dtj paramdtj)
  {
    AppMethodBeat.i(271190);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10910, "3");
    dn localdn = new dn();
    arv localarv = new arv();
    asb localasb = new asb();
    arf localarf = new arf();
    localarf.bso(paramboo.songName);
    localarf.bsV(paramboo.Mcq);
    localarf.bsU(paramboo.ZWS);
    localasb.bto(z.bAM());
    localasb.btp(z.bAM());
    localasb.axH(27);
    localasb.yu(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bpJ(I(paramf))) {
      localasb.btu(I(paramf));
    }
    localarf.bsv(paramf.oOB);
    localarf.bsw(paramf.oOC);
    localarf.bsu(paramf.oOD);
    paramboo = o.god().aPg(com.tencent.mm.plugin.music.h.b.Y(paramf));
    if (paramboo.gop())
    {
      localarf.bsx(paramboo.field_songHAlbumUrl);
      localarf.Kj(true);
      paramboo = H(paramf);
      if (!y.ZC(paramboo)) {
        break label399;
      }
      localarf.bsD(paramboo);
    }
    for (;;)
    {
      localarf.bso(paramf.oOx);
      localarf.bsp(paramf.oOy);
      localarf.axy(29);
      localarf.bsU(paramf.oOM);
      localarf.bsV(paramf.oOE);
      paramboo = new arg();
      paramboo.e(paramdtj);
      localarf.a(paramboo);
      localdn.hDr.title = paramf.oOx;
      localdn.hDr.desc = paramf.oOy;
      localdn.hDr.hDt = localarv;
      localdn.hDr.type = 21;
      localarv.a(localasb);
      localarv.vEn.add(localarf);
      localdn.hDr.activity = paramActivity;
      localdn.hDr.hDy = 3;
      localdn.publish();
      AppMethodBeat.o(271190);
      return;
      localarf.bsx(paramboo.field_songAlbumUrl);
      break;
      label399:
      localarf.Kk(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63014);
    Log.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!Util.isNullOrNil(parama.field_songWapLinkUrl)) || (!Util.isNullOrNil(parama.field_songWebUrl)) || (!Util.isNullOrNil(parama.field_songWifiUrl)))
    {
      AppMethodBeat.o(63014);
      return true;
    }
    AppMethodBeat.o(63014);
    return false;
  }
  
  private static com.tencent.mm.ui.widget.a.e aP(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new e.a(paramContext);
    paramContext.aEK(a.h.app_tip);
    paramContext.aEO(paramInt);
    paramContext.aER(a.h.welcome_i_know).c(null);
    paramContext.NC(true);
    paramContext = paramContext.jHH();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static final boolean aml(String paramString)
  {
    AppMethodBeat.i(271269);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
    boolean bool = com.tencent.mm.plugin.comm.a.aml(paramString);
    AppMethodBeat.o(271269);
    return bool;
  }
  
  public static void at(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    Log.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    zp localzp = new zp();
    localzp.icM.appId = paramString1;
    localzp.icM.appVersion = -1;
    localzp.icM.icP = paramInt;
    localzp.icM.userName = paramString2;
    localzp.icM.scene = 1056;
    if (paramInt == 1) {
      localzp.icM.icT = true;
    }
    localzp.publish();
    AppMethodBeat.o(63022);
  }
  
  public static boolean b(com.tencent.mm.aw.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.h.OAn.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.oOD;
    Object localObject = com.tencent.mm.plugin.music.h.e.aPv(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.aPu(str1);
    paramf = "";
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      Log.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str1 });
      paramf = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { paramf });
      localObject = Uri.parse(paramf);
      if (localObject != null) {
        break;
      }
      Log.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { paramf });
      AppMethodBeat.o(63016);
      return false;
      if (!TextUtils.isEmpty(str2))
      {
        Log.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { str2 });
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + str2 + "%22%7D%5D%7D";
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + (String)localObject + "%22%7D%5D%7D";
      }
    }
    com.tencent.mm.aw.a.bLi();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (Util.isIntentAvailable(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().cG(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramf.aYi(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(63016);
      return true;
    }
    paramf = new Intent();
    paramf.putExtra("rawUrl", str1);
    c.b(paramActivity, "webview", ".ui.tools.WebViewUI", paramf);
    AppMethodBeat.o(63016);
    return false;
  }
  
  public static boolean b(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(271244);
    if (parama == null)
    {
      AppMethodBeat.o(271244);
      return false;
    }
    if ((TextUtils.isEmpty(parama.field_songWifiUrl)) && (TextUtils.isEmpty(parama.field_songWapLinkUrl)) && (TextUtils.isEmpty(parama.field_songWebUrl)))
    {
      AppMethodBeat.o(271244);
      return false;
    }
    AppMethodBeat.o(271244);
    return true;
  }
  
  public static void bc(Activity paramActivity)
  {
    AppMethodBeat.i(63017);
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("scene_from", 6);
    c.d(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  public static void bd(Activity paramActivity)
  {
    AppMethodBeat.i(271241);
    if (((Boolean)com.tencent.mm.kernel.h.baE().ban().d(82, Boolean.TRUE)).booleanValue())
    {
      com.tencent.mm.kernel.h.baE().ban().B(82, Boolean.FALSE);
      switch (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).gnl().field_musicType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(271241);
        return;
        aP(paramActivity, a.h.shake_first_time_chatting);
        AppMethodBeat.o(271241);
        return;
        aP(paramActivity, a.h.shake_first_time_favorite);
        AppMethodBeat.o(271241);
        return;
        aP(paramActivity, a.h.shake_first_time_shake);
        AppMethodBeat.o(271241);
        return;
        aP(paramActivity, a.h.shake_first_time_timeline);
      }
    }
    if (((com.tencent.mm.plugin.music.logic.e)com.tencent.mm.plugin.music.e.c.b.bU(com.tencent.mm.plugin.music.logic.e.class)).getMode() == 2)
    {
      Toast.makeText(MMApplicationContext.getContext(), a.h.switch_to_multi_music, 0).show();
      AppMethodBeat.o(271241);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), a.h.switch_to_single_music, 0).show();
    AppMethodBeat.o(271241);
  }
  
  private static final void by(Context paramContext, String paramString)
  {
    AppMethodBeat.i(271255);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(271255);
  }
  
  public static final void bz(Context paramContext, String paramString)
  {
    AppMethodBeat.i(271259);
    by(paramContext, String.format("https://" + WeChatHosts.domainString(a.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s", new Object[] { Integer.valueOf(69), paramString }));
    AppMethodBeat.o(271259);
  }
  
  public static void c(com.tencent.mm.aw.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.oOD;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.oOB;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.oOC;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.oOC;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.oOM;
    ((WXMusicObject)localObject1).songLyric = paramf.oOE;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.oOx;
    localWXMediaMessage.description = paramf.oOy;
    Object localObject2 = null;
    Object localObject3 = H(paramf);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (y.ZC((String)localObject3))
      {
        int i = (int)paramActivity.getResources().getDimension(a.c.NormalAvatarSize);
        localObject1 = BitmapUtil.getBitmapNative((String)localObject3, i, i);
      }
    }
    if (localObject1 != null)
    {
      localWXMediaMessage.thumbData = Util.bmpToByteArray((Bitmap)localObject1, true);
      localObject1 = new Intent();
      localObject2 = new Bundle();
      localObject3 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject3).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject3).toBundle((Bundle)localObject2);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.oOv);
      localObject2 = I(paramf);
      if (com.tencent.mm.pluginsdk.model.app.h.bpJ((String)localObject2)) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", (String)localObject2);
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", J(paramf));
      paramf = ad.Jo("music_player");
      ad.bCb().M(paramf, true).q("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      ((Intent)localObject1).putExtra("ksnsis_music", true);
      if (!aml((String)localObject2)) {
        break label362;
      }
      ((Intent)localObject1).putExtra("Ksnsupload_type", 25);
    }
    for (;;)
    {
      c.a((MMActivity)paramActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1001, new MMActivity.a()
      {
        public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent) {}
      });
      AppMethodBeat.o(63018);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(a.d.default_icon_music), true);
      break;
      label362:
      paramf = com.tencent.mm.plugin.comm.a.xeG;
      if (com.tencent.mm.plugin.comm.a.dsO()) {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 26);
      } else {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 2);
      }
    }
  }
  
  public static final boolean dsO()
  {
    AppMethodBeat.i(369747);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
    boolean bool = com.tencent.mm.plugin.comm.a.dsO();
    AppMethodBeat.o(369747);
    return bool;
  }
  
  public static final boolean dsQ()
  {
    AppMethodBeat.i(271272);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
    boolean bool = com.tencent.mm.plugin.comm.a.dsQ();
    AppMethodBeat.o(271272);
    return bool;
  }
  
  public static final boolean dsS()
  {
    AppMethodBeat.i(271275);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.xeG;
    boolean bool = com.tencent.mm.plugin.comm.a.dsS();
    AppMethodBeat.o(271275);
    return bool;
  }
  
  public static int ew(String paramString)
  {
    AppMethodBeat.i(63024);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(63024);
        return 0;
      }
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(63024);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      Log.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(63024);
    }
    return 0;
  }
  
  public static boolean ky(String paramString1, String paramString2)
  {
    AppMethodBeat.i(271156);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(271156);
      return true;
    }
    AppMethodBeat.o(271156);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.m
 * JD-Core Version:    0.7.0.1
 */