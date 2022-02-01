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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.mw;
import com.tencent.mm.g.a.mw.b;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.z;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.ao;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.LinkedList;

public final class m
{
  private static HashMap<Long, Long> pMp;
  private static HashMap<Long, String> pMq;
  
  static
  {
    AppMethodBeat.i(219848);
    pMp = new HashMap();
    pMq = new HashMap();
    AppMethodBeat.o(219848);
  }
  
  public static String C(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = o.euD().aHW(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.bV(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!s.YS((String)localObject2)) {
      switch (paramf.jeT)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.o.DCN != null)
        {
          localObject1 = new cnb();
          ((cnb)localObject1).Id = paramf.jfl;
          ((cnb)localObject1).Msz = paramf.jfa;
          ((cnb)localObject1).MsA = paramf.jfj;
          ((cnb)localObject1).Url = ((cnb)localObject1).Msz;
          localObject1 = com.tencent.mm.plugin.sns.model.g.r((cnb)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new mw();
      ((mw)localObject1).dSw.action = 12;
      ((mw)localObject1).dSw.songAlbumUrl = paramf.jfa;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = ((mw)localObject1).dSx.dSD;
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.jff;
      }
      localObject1 = localObject2;
      if (!s.YS((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.bV(locala.field_musicId, false);
        continue;
        localObject1 = q.bcR().R(paramf.jff, true);
        continue;
        if (paramf.jff == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.jff;
          continue;
          if (paramf.jff == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.jff;
            continue;
            if (paramf.jff == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.jff;
            }
          }
        }
      }
    }
  }
  
  public static String D(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.jfi;
    String str1 = str2;
    if (Util.isNullOrNil(str2)) {
      switch (paramf.jeT)
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
  
  public static String E(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.jeT)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      paramf = MMApplicationContext.getContext().getString(2131758270);
      AppMethodBeat.o(63021);
      return paramf;
    case 0: 
    case 1: 
    case 8: 
      paramf = MMApplicationContext.getContext().getString(2131766147);
      AppMethodBeat.o(63021);
      return paramf;
    case 5: 
      paramf = MMApplicationContext.getContext().getString(2131764948);
      AppMethodBeat.o(63021);
      return paramf;
    }
    paramf = MMApplicationContext.getContext().getString(2131765780);
    AppMethodBeat.o(63021);
    return paramf;
  }
  
  public static final void F(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(219844);
    bj(paramContext, String.format("https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s&comment_ID=%s", new Object[] { Integer.valueOf(71), paramString1, paramString2 }));
    AppMethodBeat.o(219844);
  }
  
  public static void a(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10910, "3");
    cz localcz = new cz();
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(5);
    localanh.MA(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bdy(D(paramf))) {
      localanh.bhl(D(paramf));
    }
    localaml.bgm(paramf.jfb);
    localaml.bgn(paramf.jfc);
    localaml.bgl(paramf.jfd);
    Object localObject = o.euD().aHW(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).euN())
    {
      localaml.bgo(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localaml.As(true);
      localObject = C(paramf);
      if (!s.YS((String)localObject)) {
        break label342;
      }
      localaml.bgu((String)localObject);
    }
    for (;;)
    {
      localaml.bgf(paramf.jeX);
      localaml.bgg(paramf.jeY);
      localaml.ajd(7);
      localaml.bgL(paramf.jfm);
      localaml.bgM(paramf.jfe);
      localcz.dFZ.title = paramf.jeX;
      localcz.dFZ.desc = paramf.jeY;
      localcz.dFZ.dGb = localanb;
      localcz.dFZ.type = 7;
      localanb.a(localanh);
      localanb.ppH.add(localaml);
      localcz.dFZ.activity = paramActivity;
      localcz.dFZ.dGf = 3;
      EventCenter.instance.publish(localcz);
      AppMethodBeat.o(63015);
      return;
      localaml.bgo(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localaml.At(true);
    }
  }
  
  public static void a(com.tencent.mm.ay.f paramf, Intent paramIntent, MMActivity paramMMActivity)
  {
    AppMethodBeat.i(219839);
    String str1 = paramIntent.getStringExtra("Select_Conv_User");
    paramIntent = new WXMusicObject();
    paramIntent.musicUrl = paramf.jfd;
    paramIntent.musicDataUrl = paramf.jfb;
    paramIntent.musicLowBandUrl = paramf.jfc;
    paramIntent.musicLowBandDataUrl = paramf.jfc;
    paramIntent.songAlbumUrl = paramf.jfm;
    paramIntent.songLyric = paramf.jfe;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = paramIntent;
    localWXMediaMessage.title = paramf.jeX;
    localWXMediaMessage.description = paramf.jeY;
    Object localObject = null;
    String str2 = C(paramf);
    paramIntent = localObject;
    if (str2 != null)
    {
      paramIntent = localObject;
      if (s.YS(str2))
      {
        int i = (int)paramMMActivity.getResources().getDimension(2131165526);
        paramIntent = BitmapUtil.getBitmapNative(str2, i, i);
      }
    }
    if (paramIntent != null)
    {
      localWXMediaMessage.thumbData = Util.bmpToByteArray(paramIntent, true);
      if (!com.tencent.mm.pluginsdk.model.app.h.bdy(D(paramf))) {
        break label247;
      }
    }
    label247:
    for (paramIntent = D(paramf);; paramIntent = "")
    {
      if (f.jRt != null) {
        f.jRt.a(paramMMActivity, paramIntent, localWXMediaMessage, str1, E(paramf));
      }
      Log.i("MicroMsg.Music.MusicUtil", "succeed to share to friend:%s", new Object[] { str1 });
      AppMethodBeat.o(219839);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(2131231962), true);
      break;
    }
  }
  
  public static void a(com.tencent.mm.ay.f paramf, axy paramaxy, Activity paramActivity, css paramcss)
  {
    AppMethodBeat.i(219838);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10910, "3");
    cz localcz = new cz();
    anb localanb = new anb();
    anh localanh = new anh();
    aml localaml = new aml();
    amm localamm = new amm();
    localaml.bgf(paramaxy.BPc);
    localaml.bgM(paramaxy.LIh);
    localaml.bgL(paramaxy.Djf);
    localamm.e(paramcss);
    localanh.bhf(z.aTY());
    localanh.bhg(z.aTY());
    localanh.ajm(27);
    localanh.MA(Util.nowMilliSecond());
    if (com.tencent.mm.pluginsdk.model.app.h.bdy(D(paramf))) {
      localanh.bhl(D(paramf));
    }
    localaml.bgm(paramf.jfb);
    localaml.bgn(paramf.jfc);
    localaml.bgl(paramf.jfd);
    paramaxy = o.euD().aHW(com.tencent.mm.plugin.music.h.b.S(paramf));
    if (paramaxy.euN())
    {
      localaml.bgo(paramaxy.field_songHAlbumUrl);
      localaml.As(true);
      paramaxy = C(paramf);
      if (!s.YS(paramaxy)) {
        break label411;
      }
      localaml.bgu(paramaxy);
    }
    for (;;)
    {
      localaml.bgf(paramf.jeX);
      localaml.bgg(paramf.jeY);
      localaml.ajd(29);
      localaml.bgL(paramf.jfm);
      localaml.bgM(paramf.jfe);
      localamm.e(paramcss);
      localaml.a(localamm);
      localcz.dFZ.title = paramf.jeX;
      localcz.dFZ.desc = paramf.jeY;
      localcz.dFZ.dGb = localanb;
      localcz.dFZ.type = 21;
      localanb.a(localanh);
      localanb.ppH.add(localaml);
      localcz.dFZ.activity = paramActivity;
      localcz.dFZ.dGf = 3;
      EventCenter.instance.publish(localcz);
      AppMethodBeat.o(219838);
      return;
      localaml.bgo(paramaxy.field_songAlbumUrl);
      break;
      label411:
      localaml.At(true);
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
  
  public static void ag(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    Log.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    wq localwq = new wq();
    localwq.ecI.appId = paramString1;
    localwq.ecI.appVersion = -1;
    localwq.ecI.ecL = paramInt;
    localwq.ecI.userName = paramString2;
    localwq.ecI.scene = 1056;
    if (paramInt == 1) {
      localwq.ecI.ecP = true;
    }
    EventCenter.instance.publish(localwq);
    AppMethodBeat.o(63022);
  }
  
  public static final boolean akQ(String paramString)
  {
    AppMethodBeat.i(219846);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.qCo;
    boolean bool = com.tencent.mm.plugin.comm.a.akQ(paramString);
    AppMethodBeat.o(219846);
    return bool;
  }
  
  private static d al(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.aoO(2131755998);
    paramContext.aoS(paramInt);
    paramContext.aoV(2131768713).c(null);
    paramContext.Dk(true);
    paramContext = paramContext.hbn();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static void av(Activity paramActivity)
  {
    AppMethodBeat.i(63017);
    Intent localIntent = new Intent();
    localIntent.putExtra("select_is_ret", true);
    localIntent.putExtra("mutil_select_is_ret", false);
    localIntent.putExtra("scene_from", 6);
    c.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  public static void aw(Activity paramActivity)
  {
    AppMethodBeat.i(219840);
    if (((Boolean)com.tencent.mm.kernel.g.aAh().azQ().get(82, Boolean.TRUE)).booleanValue())
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(82, Boolean.FALSE);
      switch (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).etY().field_musicType)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(219840);
        return;
        al(paramActivity, 2131765743);
        AppMethodBeat.o(219840);
        return;
        al(paramActivity, 2131765744);
        AppMethodBeat.o(219840);
        return;
        al(paramActivity, 2131765745);
        AppMethodBeat.o(219840);
        return;
        al(paramActivity, 2131765746);
      }
    }
    if (((com.tencent.mm.plugin.music.e.e)com.tencent.mm.plugin.music.f.c.b.aS(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2)
    {
      Toast.makeText(MMApplicationContext.getContext(), 2131766598, 0).show();
      AppMethodBeat.o(219840);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), 2131766599, 0).show();
    AppMethodBeat.o(219840);
  }
  
  public static boolean b(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.h.CyF.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.jfd;
    Object localObject = com.tencent.mm.plugin.music.h.e.aIl(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.aIk(str1);
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
    com.tencent.mm.ay.a.bea();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (Util.isIntentAvailable(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().bl(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramf.axQ(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
    AppMethodBeat.i(219841);
    if (parama == null)
    {
      AppMethodBeat.o(219841);
      return false;
    }
    if ((TextUtils.isEmpty(parama.field_songWifiUrl)) && (TextUtils.isEmpty(parama.field_songWapLinkUrl)) && (TextUtils.isEmpty(parama.field_songWebUrl)))
    {
      AppMethodBeat.o(219841);
      return false;
    }
    AppMethodBeat.o(219841);
    return true;
  }
  
  private static final void bj(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219842);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", paramString);
    c.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
    AppMethodBeat.o(219842);
  }
  
  public static final void bk(Context paramContext, String paramString)
  {
    AppMethodBeat.i(219843);
    bj(paramContext, String.format("https://" + WeChatHosts.domainString(2131761748) + "/security/readtemplate?t=weixin_report/w_type&scene=%d&content_ID=%s", new Object[] { Integer.valueOf(69), paramString }));
    AppMethodBeat.o(219843);
  }
  
  public static void c(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.jfd;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.jfb;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.jfc;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.jfc;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.jfm;
    ((WXMusicObject)localObject1).songLyric = paramf.jfe;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.jeX;
    localWXMediaMessage.description = paramf.jeY;
    Object localObject2 = null;
    Object localObject3 = C(paramf);
    localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (s.YS((String)localObject3))
      {
        int i = (int)paramActivity.getResources().getDimension(2131165526);
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
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.jeV);
      localObject2 = D(paramf);
      if (com.tencent.mm.pluginsdk.model.app.h.bdy((String)localObject2)) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", (String)localObject2);
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", E(paramf));
      paramf = ad.JX("music_player");
      ad.aVe().G(paramf, true).l("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      ((Intent)localObject1).putExtra("ksnsis_music", true);
      if (!akQ((String)localObject2)) {
        break label362;
      }
      ((Intent)localObject1).putExtra("Ksnsupload_type", 25);
    }
    for (;;)
    {
      c.a((MMActivity)paramActivity, ".plugin.sns.ui.SnsUploadUI", (Intent)localObject1, 1001, new m.1());
      AppMethodBeat.o(63018);
      return;
      localWXMediaMessage.thumbData = Util.bmpToByteArray(BitmapUtil.getBitmapNative(2131231962), true);
      break;
      label362:
      paramf = com.tencent.mm.plugin.comm.a.qCo;
      if (com.tencent.mm.plugin.comm.a.cAI()) {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 26);
      } else {
        ((Intent)localObject1).putExtra("Ksnsupload_type", 2);
      }
    }
  }
  
  public static final boolean cAI()
  {
    AppMethodBeat.i(258338);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.qCo;
    boolean bool = com.tencent.mm.plugin.comm.a.cAI();
    AppMethodBeat.o(258338);
    return bool;
  }
  
  public static final boolean cAJ()
  {
    AppMethodBeat.i(219847);
    com.tencent.mm.plugin.comm.a locala = com.tencent.mm.plugin.comm.a.qCo;
    boolean bool = com.tencent.mm.plugin.comm.a.cAJ();
    AppMethodBeat.o(219847);
    return bool;
  }
  
  public static int cL(String paramString)
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
  
  public static boolean iZ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(219837);
    if ((!Util.isNullOrNil(paramString1)) || (!Util.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(219837);
      return true;
    }
    AppMethodBeat.o(219837);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.m
 * JD-Core Version:    0.7.0.1
 */