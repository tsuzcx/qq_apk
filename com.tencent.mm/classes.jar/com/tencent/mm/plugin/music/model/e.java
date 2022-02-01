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
import com.tencent.mm.aw.q;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.me.b;
import com.tencent.mm.g.a.vm;
import com.tencent.mm.model.u;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.LinkedList;

public final class e
{
  public static String A(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63021);
    switch (paramf.ihe)
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
  
  public static void a(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63015);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(10910, "3");
    cv localcv = new cv();
    akd localakd = new akd();
    akj localakj = new akj();
    ajn localajn = new ajn();
    localakj.aPf(u.aAm());
    localakj.aPg(u.aAm());
    localakj.ZR(5);
    localakj.CM(bt.flT());
    if (h.aLE(z(paramf))) {
      localakj.aPl(z(paramf));
    }
    localajn.aOm(paramf.ihm);
    localajn.aOn(paramf.ihn);
    localajn.aOl(paramf.iho);
    Object localObject = f.dtf().asJ(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).dtq())
    {
      localajn.aOo(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localajn.wk(true);
      localObject = y(paramf);
      if (!com.tencent.mm.vfs.i.fv((String)localObject)) {
        break label342;
      }
      localajn.aOu((String)localObject);
    }
    for (;;)
    {
      localajn.aOf(paramf.ihi);
      localajn.aOg(paramf.ihj);
      localajn.ZI(7);
      localajn.aOL(paramf.ihx);
      localajn.aOM(paramf.ihp);
      localcv.dnG.title = paramf.ihi;
      localcv.dnG.desc = paramf.ihj;
      localcv.dnG.dnI = localakd;
      localcv.dnG.type = 7;
      localakd.a(localakj);
      localakd.nZa.add(localajn);
      localcv.dnG.activity = paramActivity;
      localcv.dnG.dnM = 3;
      com.tencent.mm.sdk.b.a.IbL.l(localcv);
      AppMethodBeat.o(63015);
      return;
      localajn.aOo(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label342:
      localajn.wl(true);
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
  
  public static void ac(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(63022);
    ad.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    vm localvm = new vm();
    localvm.dJF.appId = paramString1;
    localvm.dJF.aDD = -1;
    localvm.dJF.dJI = paramInt;
    localvm.dJF.userName = paramString2;
    localvm.dJF.scene = 1056;
    if (paramInt == 1) {
      localvm.dJF.dJL = true;
    }
    com.tencent.mm.sdk.b.a.IbL.l(localvm);
    AppMethodBeat.o(63022);
  }
  
  public static com.tencent.mm.ui.widget.a.d af(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(63023);
    paramContext = new d.a(paramContext);
    paramContext.afe(2131755906);
    paramContext.afi(paramInt);
    paramContext.afl(2131766205).c(null);
    paramContext.yR(true);
    paramContext = paramContext.fMb();
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
    com.tencent.mm.bs.d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(63017);
  }
  
  public static boolean b(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63016);
    com.tencent.mm.plugin.report.service.g.yhR.kvStat(10910, "4");
    if (paramf == null)
    {
      AppMethodBeat.o(63016);
      return false;
    }
    String str1 = paramf.iho;
    Object localObject = com.tencent.mm.plugin.music.h.e.asW(str1);
    String str2 = com.tencent.mm.plugin.music.h.e.asV(str1);
    paramf = "";
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      ad.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str1 });
      paramf = "qqmusic://qq.com/ui/pageVisibility";
    }
    for (;;)
    {
      ad.i("MicroMsg.Music.MusicUtil", "qqMusicActionUrl:%s", new Object[] { paramf });
      localObject = Uri.parse(paramf);
      if (localObject != null) {
        break;
      }
      ad.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { paramf });
      AppMethodBeat.o(63016);
      return false;
      if (!TextUtils.isEmpty(str2))
      {
        ad.i("MicroMsg.Music.MusicUtil", "get qq music songmid %s", new Object[] { str2 });
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songmid%22%3A%22" + str2 + "%22%7D%5D%7D";
      }
      else if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramf = "qqmusic://qq.com/media/playSonglist?p=%7B%22song%22%3A%5B%7B%22songid%22%3A%22" + (String)localObject + "%22%7D%5D%7D";
      }
    }
    com.tencent.mm.az.a.aJE();
    paramf = new Intent("android.intent.action.VIEW", (Uri)localObject);
    paramf.addFlags(268435456);
    if (bt.aj(paramActivity, paramf))
    {
      paramf = new com.tencent.mm.hellhoundlib.b.a().bc(paramf);
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, paramf.ahp(), "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramActivity.startActivity((Intent)paramf.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, "com/tencent/mm/plugin/music/model/MusicUtil", "doOpenInQQMusic", "(Lcom/tencent/mm/modelmusic/MusicWrapper;Landroid/app/Activity;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(63016);
      return true;
    }
    paramf = new Intent();
    paramf.putExtra("rawUrl", str1);
    c.iRG.i(paramf, paramActivity);
    AppMethodBeat.o(63016);
    return false;
  }
  
  public static void c(com.tencent.mm.az.f paramf, Activity paramActivity)
  {
    AppMethodBeat.i(63018);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = paramf.iho;
    ((WXMusicObject)localObject1).musicDataUrl = paramf.ihm;
    ((WXMusicObject)localObject1).musicLowBandUrl = paramf.ihn;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = paramf.ihn;
    ((WXMusicObject)localObject1).songAlbumUrl = paramf.ihx;
    ((WXMusicObject)localObject1).songLyric = paramf.ihp;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = paramf.ihi;
    localWXMediaMessage.description = paramf.ihj;
    Bundle localBundle = null;
    Object localObject2 = y(paramf);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(2131165508);
        localObject1 = com.tencent.mm.sdk.platformtools.g.aM((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bt.aF((Bitmap)localObject1);; localWXMediaMessage.thumbData = bt.aF(com.tencent.mm.sdk.platformtools.g.aat(2131231880)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", paramf.ihg);
      if (h.aLE(z(paramf))) {
        ((Intent)localObject1).putExtra("Ksnsupload_appid", z(paramf));
      }
      ((Intent)localObject1).putExtra("Ksnsupload_appname", A(paramf));
      paramf = y.AH("music_player");
      y.aBq().F(paramf, true).k("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", paramf);
      c.iRG.l((Intent)localObject1, paramActivity);
      AppMethodBeat.o(63018);
      return;
    }
  }
  
  public static int eZ(String paramString)
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
  
  public static String y(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63019);
    com.tencent.mm.plugin.music.model.e.a locala = f.dtf().asJ(com.tencent.mm.plugin.music.h.b.O(paramf));
    if (locala == null)
    {
      AppMethodBeat.o(63019);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.bB(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!com.tencent.mm.vfs.i.fv((String)localObject2)) {
      switch (paramf.ihe)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (o.zbT != null)
        {
          localObject1 = new byn();
          ((byn)localObject1).Id = paramf.ihw;
          ((byn)localObject1).GSI = paramf.ihl;
          ((byn)localObject1).GSJ = paramf.ihu;
          ((byn)localObject1).Url = ((byn)localObject1).GSI;
          localObject1 = com.tencent.mm.plugin.sns.model.f.q((byn)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(63019);
      return localObject1;
      localObject1 = new me();
      ((me)localObject1).dzC.action = 12;
      ((me)localObject1).dzC.songAlbumUrl = paramf.ihl;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((me)localObject1).dzD.dzJ;
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1)) {
        localObject2 = paramf.ihq;
      }
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.i.fv((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.bB(locala.field_musicId, false);
        continue;
        localObject1 = q.aIF().R(paramf.ihq, true);
        continue;
        if (paramf.ihq == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = paramf.ihq;
          continue;
          if (paramf.ihq == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = paramf.ihq;
            continue;
            if (paramf.ihq == null) {
              localObject1 = "";
            } else {
              localObject1 = paramf.ihq;
            }
          }
        }
      }
    }
  }
  
  public static String z(com.tencent.mm.az.f paramf)
  {
    AppMethodBeat.i(63020);
    String str2 = paramf.iht;
    String str1 = str2;
    if (bt.isNullOrNil(str2)) {
      switch (paramf.ihe)
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