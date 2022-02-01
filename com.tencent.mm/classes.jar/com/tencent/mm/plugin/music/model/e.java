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
import com.tencent.mm.av.g;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.lv.b;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.widget.a.d.a;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public final class e
{
  public static String A(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.hNQ)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      paramf = ai.getContext().getString(2131758018);
      AppMethodBeat.o(63021);
      return paramf;
    case 0: 
    case 1: 
    case 8: 
      paramf = ai.getContext().getString(2131763920);
      AppMethodBeat.o(63021);
      return paramf;
    case 5: 
      paramf = ai.getContext().getString(2131762841);
      AppMethodBeat.o(63021);
      return paramf;
    }
    paramf = ai.getContext().getString(2131763592);
    AppMethodBeat.o(63021);
    return paramf;
  }
  
  public static void Z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    ac.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    ut localut = new ut();
    localut.dxt.appId = paramString1;
    localut.dxt.aBM = -1;
    localut.dxt.dxw = paramInt;
    localut.dxt.userName = paramString2;
    localut.dxt.scene = 1056;
    if (paramInt == 1) {
      localut.dxt.dxz = true;
    }
    com.tencent.mm.sdk.b.a.GpY.l(localut);
    AppMethodBeat.o(63022);
  }
  
  public static void a(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10910, "3");
    cs localcs = new cs();
    ahn localahn = new ahn();
    aht localaht = new aht();
    agx localagx = new agx();
    localaht.aJC(u.axw());
    localaht.aJD(u.axw());
    localaht.XV(5);
    localaht.zY(bs.eWj());
    if (com.tencent.mm.pluginsdk.model.app.h.aGe(z(paramf))) {
      localaht.aJI(z(paramf));
    }
    localagx.aIJ(paramf.hNY);
    localagx.aIK(paramf.hNZ);
    localagx.aII(paramf.hOa);
    Object localObject = f.diT().anK(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).dje())
    {
      localagx.aIL(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localagx.vy(true);
      localObject = y(paramf);
      if (!i.eA((String)localObject)) {
        break label342;
      }
      localagx.aIR((String)localObject);
    }
    for (;;)
    {
      localagx.aIC(paramf.hNU);
      localagx.aID(paramf.hNV);
      localagx.XM(7);
      localagx.aJi(paramf.hOj);
      localagx.aJj(paramf.hOb);
      localcs.dck.title = paramf.hNU;
      localcs.dck.desc = paramf.hNV;
      localcs.dck.dcm = localahn;
      localcs.dck.type = 7;
      localahn.a(localaht);
      localahn.nxC.add(localagx);
      localcs.dck.activity = paramActivity;
      localcs.dck.dcq = 3;
      com.tencent.mm.sdk.b.a.GpY.l(localcs);
      AppMethodBeat.o(63015);
      return;
      localagx.aIL(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localagx.vz(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(63014);
    ac.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!bs.isNullOrNil(parama.field_songWapLinkUrl)) || (!bs.isNullOrNil(parama.field_songWebUrl)) || (!bs.isNullOrNil(parama.field_songWifiUrl)))
    {
      AppMethodBeat.o(63014);
      return true;
    }
    AppMethodBeat.o(63014);
    return false;
  }
  
  public static com.tencent.mm.ui.widget.a.d ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.acF(2131755906);
    paramContext.acJ(paramInt);
    paramContext.acM(2131766205).b(null);
    paramContext.yf(true);
    paramContext = paramContext.fvp();
    paramContext.show();
    AppMethodBeat.o(63023);
    return paramContext;
  }
  
  public static void au(Activity paramActivity)
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
    com.tencent.mm.plugin.report.service.h.wUl.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.hOa;
    Object localObject = com.tencent.mm.plugin.music.h.e.anX(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.anW(str1);
    paramf = "";
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      ac.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str1 });
      paramf = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      ac.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { paramf });
      localObject = Uri.parse(paramf);
      if (localObject != null) {
        break;
      }
      ac.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { paramf });
      AppMethodBeat.o(63016);
      return false;
      if (!TextUtils.isEmpty(str2))
      {
        ac.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { str2 });
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + str2 + "%22%7D%5D%7D";
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + (String)localObject + "%22%7D%5D%7D";
      }
    }
    com.tencent.mm.ay.a.aGt();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (bs.ah(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().ba(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramf.aeD(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.lR(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(63016);
      return true;
    }
    paramf = new Intent();
    paramf.putExtra("rawUrl", str1);
    c.iyx.i(paramf, paramActivity);
    AppMethodBeat.o(63016);
    return false;
  }
  
  public static void c(com.tencent.mm.ay.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.hOa;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.hNY;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.hNZ;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.hNZ;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.hOj;
    ((WXMusicObject)localObject1).songLyric = paramf.hOb;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.hNU;
    localWXMediaMessage.description = paramf.hNV;
    Bundle localBundle = null;
    Object localObject2 = y(paramf);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (i.eA((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(2131165508);
        localObject1 = com.tencent.mm.sdk.platformtools.f.aI((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bs.aD((Bitmap)localObject1);; localWXMediaMessage.thumbData = bs.aD(com.tencent.mm.sdk.platformtools.f.Yo(2131231880)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.hNS);
      if (com.tencent.mm.pluginsdk.model.app.h.aGe(z(paramf))) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", z(paramf));
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", A(paramf));
      paramf = y.xJ("music_player");
      y.ayq().F(paramf, true).l("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      c.iyx.l((Intent)localObject1, paramActivity);
      AppMethodBeat.o(63018);
      return;
    }
  }
  
  public static int ee(String paramString)
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
      ac.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(63024);
    }
    return 0;
  }
  
  public static String y(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = f.diT().anK(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.bu(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!i.eA((String)localObject2)) {
      switch (paramf.hNQ)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.o.xMb != null)
        {
          localObject1 = new btz();
          ((btz)localObject1).Id = paramf.hOi;
          ((btz)localObject1).Fjh = paramf.hNX;
          ((btz)localObject1).Fji = paramf.hOg;
          ((btz)localObject1).Url = ((btz)localObject1).Fjh;
          localObject1 = com.tencent.mm.plugin.sns.model.f.q((btz)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new lv();
      ((lv)localObject1).dnO.action = 12;
      ((lv)localObject1).dnO.songAlbumUrl = paramf.hNX;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((lv)localObject1).dnP.dnV;
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.hOc;
      }
      localObject1 = localObject2;
      if (!i.eA((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.bu(locala.field_musicId, false);
        continue;
        localObject1 = com.tencent.mm.av.o.aFx().R(paramf.hOc, true);
        continue;
        if (paramf.hOc == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.hOc;
          continue;
          if (paramf.hOc == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.hOc;
            continue;
            if (paramf.hOc == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.hOc;
            }
          }
        }
      }
    }
  }
  
  public static String z(com.tencent.mm.ay.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.hOf;
    String str1 = str2;
    if (bs.isNullOrNil(str2)) {
      switch (paramf.hNQ)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */