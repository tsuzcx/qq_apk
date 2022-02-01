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
import com.tencent.mm.av.i;
import com.tencent.mm.av.q;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.mf;
import com.tencent.mm.g.a.mf.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.bzh;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

public final class e
{
  public static String A(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.ijX)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      paramf = ak.getContext().getString(2131758018);
      AppMethodBeat.o(63021);
      return paramf;
    case 0: 
    case 1: 
    case 8: 
      paramf = ak.getContext().getString(2131763920);
      AppMethodBeat.o(63021);
      return paramf;
    case 5: 
      paramf = ak.getContext().getString(2131762841);
      AppMethodBeat.o(63021);
      return paramf;
    }
    paramf = ak.getContext().getString(2131763592);
    AppMethodBeat.o(63021);
    return paramf;
  }
  
  public static void a(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10910, "3");
    cw localcw = new cw();
    akn localakn = new akn();
    akt localakt = new akt();
    ajx localajx = new ajx();
    localakt.aQC(v.aAC());
    localakt.aQD(v.aAC());
    localakt.aax(5);
    localakt.Dk(bu.fpO());
    if (com.tencent.mm.pluginsdk.model.app.h.aNa(z(paramf))) {
      localakt.aQI(z(paramf));
    }
    localajx.aPJ(paramf.ikf);
    localajx.aPK(paramf.ikg);
    localajx.aPI(paramf.ikh);
    Object localObject = f.dwu().atW(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).dwF())
    {
      localajx.aPL(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localajx.ws(true);
      localObject = y(paramf);
      if (!com.tencent.mm.vfs.o.fB((String)localObject)) {
        break label342;
      }
      localajx.aPR((String)localObject);
    }
    for (;;)
    {
      localajx.aPC(paramf.ikb);
      localajx.aPD(paramf.ikc);
      localajx.aao(7);
      localajx.aQi(paramf.ikq);
      localajx.aQj(paramf.iki);
      localcw.doL.title = paramf.ikb;
      localcw.doL.desc = paramf.ikc;
      localcw.doL.doN = localakn;
      localcw.doL.type = 7;
      localakn.a(localakt);
      localakn.oeJ.add(localajx);
      localcw.doL.activity = paramActivity;
      localcw.doL.doR = 3;
      com.tencent.mm.sdk.b.a.IvT.l(localcw);
      AppMethodBeat.o(63015);
      return;
      localajx.aPL(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localajx.wt(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63014);
    ae.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!bu.isNullOrNil(parama.field_songWapLinkUrl)) || (!bu.isNullOrNil(parama.field_songWebUrl)) || (!bu.isNullOrNil(parama.field_songWifiUrl)))
    {
      AppMethodBeat.o(63014);
      return true;
    }
    AppMethodBeat.o(63014);
    return false;
  }
  
  public static void ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    ae.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    vq localvq = new vq();
    localvq.dKT.appId = paramString1;
    localvq.dKT.aDD = -1;
    localvq.dKT.dKW = paramInt;
    localvq.dKT.userName = paramString2;
    localvq.dKT.scene = 1056;
    if (paramInt == 1) {
      localvq.dKT.dLa = true;
    }
    com.tencent.mm.sdk.b.a.IvT.l(localvq);
    AppMethodBeat.o(63022);
  }
  
  public static com.tencent.mm.ui.widget.a.d af(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.afN(2131755906);
    paramContext.afR(paramInt);
    paramContext.afU(2131766205).c(null);
    paramContext.zf(true);
    paramContext = paramContext.fQv();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static void av(Activity paramActivity)
  {
    AppMethodBeat.i(63017);
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("scene_from", 6);
    com.tencent.mm.br.d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  public static boolean b(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.g.yxI.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.ikh;
    Object localObject = com.tencent.mm.plugin.music.h.e.auj(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.aui(str1);
    paramf = "";
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      ae.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str1 });
      paramf = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      ae.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { paramf });
      localObject = Uri.parse(paramf);
      if (localObject != null) {
        break;
      }
      ae.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { paramf });
      AppMethodBeat.o(63016);
      return false;
      if (!TextUtils.isEmpty(str2))
      {
        ae.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { str2 });
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + str2 + "%22%7D%5D%7D";
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + (String)localObject + "%22%7D%5D%7D";
      }
    }
    com.tencent.mm.ay.a.aJX();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (bu.aj(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramf.ahE(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(63016);
      return true;
    }
    paramf = new Intent();
    paramf.putExtra("rawUrl", str1);
    c.iUz.i(paramf, paramActivity);
    AppMethodBeat.o(63016);
    return false;
  }
  
  public static void c(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.ikh;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.ikf;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.ikg;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.ikg;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.ikq;
    ((WXMusicObject)localObject1).songLyric = paramf.iki;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.ikb;
    localWXMediaMessage.description = paramf.ikc;
    Bundle localBundle = null;
    Object localObject2 = y(paramf);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (com.tencent.mm.vfs.o.fB((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(2131165508);
        localObject1 = com.tencent.mm.sdk.platformtools.h.aO((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bu.aG((Bitmap)localObject1);; localWXMediaMessage.thumbData = bu.aG(com.tencent.mm.sdk.platformtools.h.aaZ(2131231880)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.ijZ);
      if (com.tencent.mm.pluginsdk.model.app.h.aNa(z(paramf))) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", z(paramf));
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", A(paramf));
      paramf = z.Br("music_player");
      z.aBG().F(paramf, true).k("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      c.iUz.l((Intent)localObject1, paramActivity);
      AppMethodBeat.o(63018);
      return;
    }
  }
  
  public static int fe(String paramString)
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
      ae.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(63024);
    }
    return 0;
  }
  
  public static String y(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = f.dwu().atW(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.bF(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!com.tencent.mm.vfs.o.fB((String)localObject2)) {
      switch (paramf.ijX)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.o.zsw != null)
        {
          localObject1 = new bzh();
          ((bzh)localObject1).Id = paramf.ikp;
          ((bzh)localObject1).Hmj = paramf.ike;
          ((bzh)localObject1).Hmk = paramf.ikn;
          ((bzh)localObject1).Url = ((bzh)localObject1).Hmj;
          localObject1 = com.tencent.mm.plugin.sns.model.g.q((bzh)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new mf();
      ((mf)localObject1).dAH.action = 12;
      ((mf)localObject1).dAH.songAlbumUrl = paramf.ike;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((mf)localObject1).dAI.dAO;
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.ikj;
      }
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.o.fB((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.bF(locala.field_musicId, false);
        continue;
        localObject1 = q.aIX().R(paramf.ikj, true);
        continue;
        if (paramf.ikj == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.ikj;
          continue;
          if (paramf.ikj == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.ikj;
            continue;
            if (paramf.ikj == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.ikj;
            }
          }
        }
      }
    }
  }
  
  public static String z(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.ikm;
    String str1 = str2;
    if (bu.isNullOrNil(str2)) {
      switch (paramf.ijX)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */