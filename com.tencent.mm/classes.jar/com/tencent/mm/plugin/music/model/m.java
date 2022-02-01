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
import com.tencent.mm.ay.i;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.nn;
import com.tencent.mm.f.a.nn.b;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.d;
import com.tencent.mm.plugin.music.a.h;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.plugin.sns.model.g;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.cvt;
import com.tencent.mm.protocal.protobuf.dbr;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.LinkedList;

public final class m
{
  private static HashMap<Long, Long> sTn;
  private static HashMap<Long, String> sTo;
  
  static
  {
    AppMethodBeat.i(259392);
    sTn = new HashMap();
    sTo = new HashMap();
    AppMethodBeat.o(259392);
  }
  
  public static String C(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = o.feW().aSm(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.ce(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!u.agG((String)localObject2)) {
      switch (paramf.lVr)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (p.JPd != null)
        {
          localObject1 = new cvt();
          ((cvt)localObject1).Id = paramf.lVJ;
          ((cvt)localObject1).TDF = paramf.lVy;
          ((cvt)localObject1).TDG = paramf.lVH;
          ((cvt)localObject1).Url = ((cvt)localObject1).TDF;
          localObject1 = g.r((cvt)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new nn();
      ((nn)localObject1).fLT.action = 12;
      ((nn)localObject1).fLT.songAlbumUrl = paramf.lVy;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = ((nn)localObject1).fLU.fMa;
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.lVD;
      }
      localObject1 = localObject2;
      if (!u.agG((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.ce(locala.field_musicId, false);
        continue;
        localObject1 = q.bmh().T(paramf.lVD, true);
        continue;
        if (paramf.lVD == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.lVD;
          continue;
          if (paramf.lVD == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.lVD;
            continue;
            if (paramf.lVD == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.lVD;
            }
          }
        }
      }
    }
  }
  
  public static String D(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.lVG;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      switch (paramf.lVr)
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
  
  public static String E(com.tencent.mm.bb.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.lVr)
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
  
  public static final void L(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(259380);
    bw(paramContext, String.format("https://" + WeChatHosts.domainString(a.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s&comment_ID=%s", new Object[] { Integer.valueOf(71), paramString1, paramString2 }));
    AppMethodBeat.o(259380);
  }
  
  public static void a(com.tencent.mm.bb.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "3");
    dd localdd = new dd();
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(5);
    localaoi.Ue(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bpT(D(paramf))) {
      localaoi.btD(D(paramf));
    }
    localanm.bsE(paramf.lVz);
    localanm.bsF(paramf.lVA);
    localanm.bsD(paramf.lVB);
    Object localObject = o.feW().aSm(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).ffg())
    {
      localanm.bsG(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localanm.Ex(true);
      localObject = C(paramf);
      if (!u.agG((String)localObject)) {
        break label345;
      }
      localanm.bsM((String)localObject);
    }
    for (;;)
    {
      localanm.bsx(paramf.lVv);
      localanm.bsy(paramf.lVw);
      localanm.arq(7);
      localanm.btd(paramf.lVK);
      localanm.bte(paramf.lVC);
      localdd.fyI.title = paramf.lVv;
      localdd.fyI.desc = paramf.lVw;
      localdd.fyI.fyK = localaoc;
      localdd.fyI.type = 7;
      localaoc.a(localaoi);
      localaoc.syG.add(localanm);
      localdd.fyI.activity = paramActivity;
      localdd.fyI.fyP = 3;
      EventCenter.instance.publish(localdd);
      AppMethodBeat.o(63015);
      return;
      localanm.bsG(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label345:
      localanm.Ey(true);
    }
  }
  
  public static void a(com.tencent.mm.bb.f paramf, Intent paramIntent, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(259350);
    String str1 = paramIntent.getStringExtra("Select_Conv_User");
    paramIntent = new WXMusicObject();
    paramIntent.musicUrl = paramf.lVB;
    paramIntent.musicDataUrl = paramf.lVz;
    paramIntent.musicLowBandUrl = paramf.lVA;
    paramIntent.musicLowBandDataUrl = paramf.lVA;
    paramIntent.songAlbumUrl = paramf.lVK;
    paramIntent.songLyric = paramf.lVC;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = paramIntent;
    localWXMediaMessage.title = paramf.lVv;
    localWXMediaMessage.description = paramf.lVw;
    Object localObject = null;
    String str2 = C(paramf);
    paramIntent = localObject;
    if (str2 != null)
    {
      paramIntent = localObject;
      if (u.agG(str2))
      {
        int i = (int)paramMMActivity.getResources().getDimension(a.c.NormalAvatarSize);
        paramIntent = BitmapUtil.getBitmapNative(str2, i, i);
      }
    }
    if (paramIntent != null)
    {
      localWXMediaMessage.thumbData = Util.bmpToByteArray(paramIntent, true);
      if (!com.tencent.mm.pluginsdk.model.app.h.bpT(D(paramf))) {
        break label247;
      }
    }
    label247:
    for (paramIntent = D(paramf);; paramIntent = "")
    {
      if (f.mIG != null) {
        f.mIG.a(paramMMActivity, paramIntent, localWXMediaMessage, str1, E(paramf));
      }
      Log.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
      AppMethodBeat.o(259350);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(a.d.default_icon_music), true);
      break;
    }
  }
  
  public static void a(com.tencent.mm.bb.f paramf, bds parambds, Activity paramActivity, dbr paramdbr)
  {
    AppMethodBeat.i(259343);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "3");
    dd localdd = new dd();
    aoc localaoc = new aoc();
    aoi localaoi = new aoi();
    anm localanm = new anm();
    ann localann = new ann();
    localanm.bsx(parambds.HLH);
    localanm.bte(parambds.SOL);
    localanm.btd(parambds.SOM);
    localann.e(paramdbr);
    localaoi.btx(z.bcZ());
    localaoi.bty(z.bcZ());
    localaoi.arz(27);
    localaoi.Ue(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bpT(D(paramf))) {
      localaoi.btD(D(paramf));
    }
    localanm.bsE(paramf.lVz);
    localanm.bsF(paramf.lVA);
    localanm.bsD(paramf.lVB);
    parambds = o.feW().aSm(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (parambds.ffg())
    {
      localanm.bsG(parambds.field_songHAlbumUrl);
      localanm.Ex(true);
      parambds = C(paramf);
      if (!u.agG(parambds)) {
        break label412;
      }
      localanm.bsM(parambds);
    }
    for (;;)
    {
      localanm.bsx(paramf.lVv);
      localanm.bsy(paramf.lVw);
      localanm.arq(29);
      localanm.btd(paramf.lVK);
      localanm.bte(paramf.lVC);
      localann.e(paramdbr);
      localanm.a(localann);
      localdd.fyI.title = paramf.lVv;
      localdd.fyI.desc = paramf.lVw;
      localdd.fyI.fyK = localaoc;
      localdd.fyI.type = 21;
      localaoc.a(localaoi);
      localaoc.syG.add(localanm);
      localdd.fyI.activity = paramActivity;
      localdd.fyI.fyP = 3;
      EventCenter.instance.publish(localdd);
      AppMethodBeat.o(259343);
      return;
      localanm.bsG(parambds.field_songAlbumUrl);
      break;
      label412:
      localanm.Ey(true);
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
  
  public static void aB(Activity paramActivity)
  {
    AppMethodBeat.i(63017);
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("scene_from", 6);
    c.d(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  private static d aC(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.ayc(a.h.app_tip);
    paramContext.ayg(paramInt);
    paramContext.ayj(a.h.welcome_i_know).c(null);
    paramContext.HG(true);
    paramContext = paramContext.icu();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static void aC(Activity paramActivity)
  {
    AppMethodBeat.i(259364);
    if (((Boolean)com.tencent.mm.kernel.h.aHG().aHp().b(82, Boolean.TRUE)).booleanValue())
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(82, Boolean.FALSE);
      switch (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).fei().field_musicType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(259364);
        return;
        aC(paramActivity, a.h.shake_first_time_chatting);
        AppMethodBeat.o(259364);
        return;
        aC(paramActivity, a.h.shake_first_time_favorite);
        AppMethodBeat.o(259364);
        return;
        aC(paramActivity, a.h.shake_first_time_shake);
        AppMethodBeat.o(259364);
        return;
        aC(paramActivity, a.h.shake_first_time_timeline);
      }
    }
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.bm(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2)
    {
      Toast.makeText(MMApplicationContext.getContext(), a.h.switch_to_multi_music, 0).show();
      AppMethodBeat.o(259364);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), a.h.switch_to_single_music, 0).show();
    AppMethodBeat.o(259364);
  }
  
  public static void al(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    Log.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    xw localxw = new xw();
    localxw.fWN.appId = paramString1;
    localxw.fWN.appVersion = -1;
    localxw.fWN.fWQ = paramInt;
    localxw.fWN.userName = paramString2;
    localxw.fWN.scene = 1056;
    if (paramInt == 1) {
      localxw.fWN.fWU = true;
    }
    EventCenter.instance.publish(localxw);
    AppMethodBeat.o(63022);
  }
  
  public static final boolean asG(String paramString)
  {
    AppMethodBeat.i(259386);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
    boolean bool = com.tencent.mm.plugin.comm.a.asG(paramString);
    AppMethodBeat.o(259386);
    return bool;
  }
  
  public static boolean b(com.tencent.mm.bb.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.h.IzE.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.lVB;
    Object localObject = com.tencent.mm.plugin.music.h.e.aSB(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.aSA(str1);
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
    com.tencent.mm.bb.a.bnv();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (Util.isIntentAvailable(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().bm(paramf);
      com.tencent.mm.hellhoundlib.a.a.b(paramActivity, paramf.aFh(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.sf(0));
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
    AppMethodBeat.i(259367);
    if (parama == null)
    {
      AppMethodBeat.o(259367);
      return false;
    }
    if ((TextUtils.isEmpty(parama.field_songWifiUrl)) && (TextUtils.isEmpty(parama.field_songWapLinkUrl)) && (TextUtils.isEmpty(parama.field_songWebUrl)))
    {
      AppMethodBeat.o(259367);
      return false;
    }
    AppMethodBeat.o(259367);
    return true;
  }
  
  private static final void bw(Context paramContext, String paramString)
  {
    AppMethodBeat.i(259376);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(259376);
  }
  
  public static final void bx(Context paramContext, String paramString)
  {
    AppMethodBeat.i(259377);
    bw(paramContext, String.format("https://" + WeChatHosts.domainString(a.h.host_weixin110_qq_com) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s", new Object[] { Integer.valueOf(69), paramString }));
    AppMethodBeat.o(259377);
  }
  
  public static void c(com.tencent.mm.bb.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.lVB;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.lVz;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.lVA;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.lVA;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.lVK;
    ((WXMusicObject)localObject1).songLyric = paramf.lVC;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.lVv;
    localWXMediaMessage.description = paramf.lVw;
    Object localObject2 = null;
    Object localObject3 = C(paramf);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (u.agG((String)localObject3))
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
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.lVt);
      localObject2 = D(paramf);
      if (com.tencent.mm.pluginsdk.model.app.h.bpT((String)localObject2)) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", (String)localObject2);
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", E(paramf));
      paramf = ad.Rp("music_player");
      ad.beh().I(paramf, true).k("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      ((Intent)localObject1).putExtra("ksnsis_music", true);
      if (!asG((String)localObject2)) {
        break label362;
      }
      ((Intent)localObject1).putExtra("Ksnsupload_type", 25);
    }
    for (;;)
    {
      c.a((MMActivity)paramActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1001, new MMActivity.a()
      {
        public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent) {}
      });
      AppMethodBeat.o(63018);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(a.d.default_icon_music), true);
      break;
      label362:
      paramf = com.tencent.mm.plugin.comm.a.ubo;
      if (com.tencent.mm.plugin.comm.a.cPi()) {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 26);
      } else {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 2);
      }
    }
  }
  
  public static final boolean cPi()
  {
    AppMethodBeat.i(292973);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
    boolean bool = com.tencent.mm.plugin.comm.a.cPi();
    AppMethodBeat.o(292973);
    return bool;
  }
  
  public static final boolean cPk()
  {
    AppMethodBeat.i(259389);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
    boolean bool = com.tencent.mm.plugin.comm.a.cPk();
    AppMethodBeat.o(259389);
    return bool;
  }
  
  public static final boolean cPm()
  {
    AppMethodBeat.i(259390);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.ubo;
    boolean bool = com.tencent.mm.plugin.comm.a.cPm();
    AppMethodBeat.o(259390);
    return bool;
  }
  
  public static int df(String paramString)
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
  
  public static boolean jj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(259341);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(259341);
      return true;
    }
    AppMethodBeat.o(259341);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.m
 * JD-Core Version:    0.7.0.1
 */