package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.g;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.g.a.lm.b;
import com.tencent.mm.g.a.uj;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class e
{
  public static com.tencent.mm.ui.widget.a.d W(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.aau(2131755906);
    paramContext.aay(paramInt);
    paramContext.aaB(2131766205).b(null);
    paramContext.wX(true);
    paramContext = paramContext.fft();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static void Y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    ad.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    uj localuj = new uj();
    localuj.dzH.appId = paramString1;
    localuj.dzH.aAS = -1;
    localuj.dzH.dzK = paramInt;
    localuj.dzH.userName = paramString2;
    localuj.dzH.scene = 1056;
    if (paramInt == 1) {
      localuj.dzH.dzN = true;
    }
    com.tencent.mm.sdk.b.a.ESL.l(localuj);
    AppMethodBeat.o(63022);
  }
  
  public static void a(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10910, "3");
    cs localcs = new cs();
    ago localago = new ago();
    agu localagu = new agu();
    afy localafy = new afy();
    localagu.aEl(u.aqG());
    localagu.aEm(u.aqG());
    localagu.VM(5);
    localagu.vv(bt.eGO());
    if (com.tencent.mm.pluginsdk.model.app.h.aAM(y(paramf))) {
      localagu.aEr(y(paramf));
    }
    localafy.aDs(paramf.hnv);
    localafy.aDt(paramf.hnw);
    localafy.aDr(paramf.hnx);
    Object localObject = f.cVn().aiP(com.tencent.mm.plugin.music.h.b.N(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).cVy())
    {
      localafy.aDu(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localafy.uw(true);
      localObject = x(paramf);
      if (!i.eK((String)localObject)) {
        break label342;
      }
      localafy.aDA((String)localObject);
    }
    for (;;)
    {
      localafy.aDl(paramf.hnr);
      localafy.aDm(paramf.hns);
      localafy.VD(7);
      localafy.aDR(paramf.hnG);
      localafy.aDS(paramf.hny);
      localcs.deQ.title = paramf.hnr;
      localcs.deQ.desc = paramf.hns;
      localcs.deQ.deS = localago;
      localcs.deQ.type = 7;
      localago.a(localagu);
      localago.mVb.add(localafy);
      localcs.deQ.activity = paramActivity;
      localcs.deQ.deW = 3;
      com.tencent.mm.sdk.b.a.ESL.l(localcs);
      AppMethodBeat.o(63015);
      return;
      localafy.aDu(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localafy.ux(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63014);
    ad.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!bt.isNullOrNil(parama.field_songWapLinkUrl)) || (!bt.isNullOrNil(parama.field_songWebUrl)) || (!bt.isNullOrNil(parama.field_songWifiUrl)))
    {
      AppMethodBeat.o(63014);
      return true;
    }
    AppMethodBeat.o(63014);
    return false;
  }
  
  public static void aq(Activity paramActivity)
  {
    AppMethodBeat.i(63017);
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("scene_from", 6);
    com.tencent.mm.bs.d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  public static boolean b(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    Object localObject = null;
    int j = -1;
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.h.vKh.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str2 = paramf.hnx;
    int i;
    if (str2 == null)
    {
      i = -1;
      if (i >= 0) {
        break label164;
      }
      paramf = null;
      label54:
      if (str2 != null) {
        break label215;
      }
      i = j;
      label61:
      if (i >= 0) {
        break label227;
      }
      label65:
      if ((!TextUtils.isEmpty((CharSequence)localObject)) || (!TextUtils.isEmpty(paramf))) {
        break label281;
      }
      ad.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str2 });
      paramf = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      ad.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { paramf });
      localObject = Uri.parse(paramf);
      if (localObject == null)
      {
        ad.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { paramf });
        AppMethodBeat.o(63016);
        return false;
        i = str2.indexOf("songid=");
        break;
        label164:
        String str1 = str2.substring(i + 7);
        paramf = str1;
        if (str1 == null) {
          break label54;
        }
        paramf = str1;
        if (!str1.contains("&")) {
          break label54;
        }
        paramf = str1.substring(0, str1.indexOf("&"));
        break label54;
        label215:
        i = str2.indexOf("songmid=");
        break label61;
        label227:
        str1 = str2.substring(i + 8);
        localObject = str1;
        if (str1 == null) {
          break label65;
        }
        localObject = str1;
        if (!str1.contains("&")) {
          break label65;
        }
        localObject = str1.substring(0, str1.indexOf("&"));
        break label65;
        label281:
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          ad.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { localObject });
          paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + (String)localObject + "%22%7D%5D%7D";
          continue;
        }
        if (!TextUtils.isEmpty(paramf)) {
          break label516;
        }
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + paramf + "%22%7D%5D%7D";
        continue;
      }
      com.tencent.mm.az.a.azD();
      paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
      paramf.addFlags(268435456);
      if (bt.T(paramActivity, paramf))
      {
        paramf = new com.tencent.mm.hellhoundlib.b.a().bd(paramf);
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramf.adn(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramActivity.startActivity((Intent)paramf.lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(63016);
        return true;
      }
      paramf = new Intent();
      paramf.putExtra("rawUrl", str2);
      c.hYt.i(paramf, paramActivity);
      AppMethodBeat.o(63016);
      return false;
      label516:
      paramf = "";
    }
  }
  
  public static void c(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.hnx;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.hnv;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.hnw;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.hnw;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.hnG;
    ((WXMusicObject)localObject1).songLyric = paramf.hny;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.hnr;
    localWXMediaMessage.description = paramf.hns;
    Bundle localBundle = null;
    Object localObject2 = x(paramf);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (i.eK((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(2131165508);
        localObject1 = com.tencent.mm.sdk.platformtools.f.aF((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bt.aB((Bitmap)localObject1);; localWXMediaMessage.thumbData = bt.aB(com.tencent.mm.sdk.platformtools.f.Wf(2131231880)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.hnp);
      if (com.tencent.mm.pluginsdk.model.app.h.aAM(y(paramf))) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", y(paramf));
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", z(paramf));
      paramf = y.tD("music_player");
      y.arz().E(paramf, true).m("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      c.hYt.l((Intent)localObject1, paramActivity);
      AppMethodBeat.o(63018);
      return;
    }
  }
  
  public static int ep(String paramString)
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
      ad.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(63024);
    }
    return 0;
  }
  
  public static String x(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = f.cVn().aiP(com.tencent.mm.plugin.music.h.b.N(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.bn(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!i.eK((String)localObject2)) {
      switch (paramf.hnn)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.c.o.wzH != null)
        {
          localObject1 = new bpi();
          ((bpi)localObject1).Id = paramf.hnF;
          ((bpi)localObject1).DMQ = paramf.hnu;
          ((bpi)localObject1).DMR = paramf.hnD;
          ((bpi)localObject1).Url = ((bpi)localObject1).DMQ;
          localObject1 = com.tencent.mm.plugin.sns.model.f.q((bpi)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new lm();
      ((lm)localObject1).dqd.action = 12;
      ((lm)localObject1).dqd.songAlbumUrl = paramf.hnu;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((lm)localObject1).dqe.dqk;
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.hnz;
      }
      localObject1 = localObject2;
      if (!i.eK((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.bn(locala.field_musicId, false);
        continue;
        localObject1 = com.tencent.mm.aw.o.ayF().Q(paramf.hnz, true);
        continue;
        if (paramf.hnz == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.hnz;
          continue;
          if (paramf.hnz == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.hnz;
            continue;
            if (paramf.hnz == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.hnz;
            }
          }
        }
      }
    }
  }
  
  public static String y(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.hnC;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      switch (paramf.hnn)
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
  
  public static String z(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.hnn)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      paramf = aj.getContext().getString(2131758018);
      AppMethodBeat.o(63021);
      return paramf;
    case 0: 
    case 1: 
    case 8: 
      paramf = aj.getContext().getString(2131763920);
      AppMethodBeat.o(63021);
      return paramf;
    case 5: 
      paramf = aj.getContext().getString(2131762841);
      AppMethodBeat.o(63021);
      return paramf;
    }
    paramf = aj.getContext().getString(2131763592);
    AppMethodBeat.o(63021);
    return paramf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */