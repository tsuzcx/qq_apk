package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.g;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.kh;
import com.tencent.mm.g.a.kh.b;
import com.tencent.mm.g.a.so;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.bcs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.c.a;
import java.util.LinkedList;

public final class d
{
  public static void M(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(104889);
    ab.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    so localso = new so();
    localso.cIQ.appId = paramString1;
    localso.cIQ.bDc = -1;
    localso.cIQ.cIT = paramInt;
    localso.cIQ.userName = paramString2;
    localso.cIQ.scene = 1056;
    if (paramInt == 1) {
      localso.cIQ.cIW = true;
    }
    com.tencent.mm.sdk.b.a.ymk.l(localso);
    AppMethodBeat.o(104889);
  }
  
  public static c T(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(104890);
    paramContext = new c.a(paramContext);
    paramContext.Rb(2131297087);
    paramContext.Rf(paramInt);
    paramContext.Ri(2131305958).a(null);
    paramContext.rG(true);
    paramContext = paramContext.aLZ();
    paramContext.show();
    AppMethodBeat.o(104890);
    return paramContext;
  }
  
  public static void Y(Activity paramActivity)
  {
    AppMethodBeat.i(104884);
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("scene_from", 6);
    com.tencent.mm.bq.d.b(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
    AppMethodBeat.o(104884);
  }
  
  public static void a(com.tencent.mm.aw.e parame, Activity paramActivity)
  {
    AppMethodBeat.i(104883);
    h.qsU.kvStat(10910, "3");
    cm localcm = new cm();
    acq localacq = new acq();
    acw localacw = new acw();
    aca localaca = new aca();
    localacw.aon(r.Zn());
    localacw.aoo(r.Zn());
    localacw.MR(5);
    localacw.nI(bo.aoy());
    localacw.aot(v(parame));
    localaca.anx(parame.fKp);
    localaca.any(parame.fKq);
    localaca.anw(parame.fKr);
    Object localObject = e.bVM().VC(com.tencent.mm.plugin.music.h.b.K(parame));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).bVX())
    {
      localaca.anz(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localaca.py(true);
      localObject = u(parame);
      if (!com.tencent.mm.vfs.e.cN((String)localObject)) {
        break label312;
      }
      localaca.anF((String)localObject);
    }
    for (;;)
    {
      localaca.anq(parame.fKl);
      localaca.anr(parame.fKm);
      localaca.MI(7);
      localcm.cpR.title = parame.fKl;
      localcm.cpR.desc = parame.fKm;
      localcm.cpR.cpT = localacq;
      localcm.cpR.type = 7;
      localacq.a(localacw);
      localacq.wVc.add(localaca);
      localcm.cpR.activity = paramActivity;
      localcm.cpR.cpY = 3;
      com.tencent.mm.sdk.b.a.ymk.l(localcm);
      AppMethodBeat.o(104883);
      return;
      localaca.anz(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label312:
      localaca.pz(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    AppMethodBeat.i(104882);
    ab.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!bo.isNullOrNil(parama.field_songWapLinkUrl)) || (!bo.isNullOrNil(parama.field_songWebUrl)) || (!bo.isNullOrNil(parama.field_songWifiUrl)))
    {
      AppMethodBeat.o(104882);
      return true;
    }
    AppMethodBeat.o(104882);
    return false;
  }
  
  public static void b(com.tencent.mm.aw.e parame, Activity paramActivity)
  {
    AppMethodBeat.i(104885);
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = parame.fKr;
    ((WXMusicObject)localObject1).musicDataUrl = parame.fKp;
    ((WXMusicObject)localObject1).musicLowBandUrl = parame.fKq;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = parame.fKq;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = parame.fKl;
    localWXMediaMessage.description = parame.fKm;
    Bundle localBundle = null;
    Object localObject2 = u(parame);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(2131427800);
        localObject1 = com.tencent.mm.sdk.platformtools.d.aA((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bo.an((Bitmap)localObject1);; localWXMediaMessage.thumbData = bo.an(com.tencent.mm.sdk.platformtools.d.Na(2130838497)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", parame.fKj);
      ((Intent)localObject1).putExtra("Ksnsupload_appid", v(parame));
      ((Intent)localObject1).putExtra("Ksnsupload_appname", w(parame));
      parame = v.oQ("music_player");
      v.aae().z(parame, true).i("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", parame);
      b.gmO.l((Intent)localObject1, paramActivity);
      AppMethodBeat.o(104885);
      return;
    }
  }
  
  public static int lT(String paramString)
  {
    AppMethodBeat.i(104891);
    if (paramString != null) {}
    try
    {
      if (paramString.length() <= 0)
      {
        AppMethodBeat.o(104891);
        return 0;
      }
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(104891);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      ab.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      AppMethodBeat.o(104891);
    }
    return 0;
  }
  
  public static String u(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104886);
    com.tencent.mm.plugin.music.model.e.a locala = e.bVM().VC(com.tencent.mm.plugin.music.h.b.K(parame));
    if (locala == null)
    {
      AppMethodBeat.o(104886);
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.be(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!com.tencent.mm.vfs.e.cN((String)localObject2)) {
      switch (parame.fKh)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (com.tencent.mm.plugin.sns.b.n.raR != null)
        {
          localObject1 = new bcs();
          ((bcs)localObject1).Id = parame.fKz;
          ((bcs)localObject1).xrS = parame.fKo;
          ((bcs)localObject1).xrT = parame.fKx;
          ((bcs)localObject1).Url = ((bcs)localObject1).xrS;
          localObject1 = com.tencent.mm.plugin.sns.b.n.raQ.a((bcs)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      AppMethodBeat.o(104886);
      return localObject1;
      localObject1 = new kh();
      ((kh)localObject1).czU.action = 12;
      ((kh)localObject1).czU.czZ = parame.fKo;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((kh)localObject1).czV.cAb;
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = parame.fKt;
      }
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.e.cN((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.be(locala.field_musicId, false);
        continue;
        localObject1 = o.ahC().J(parame.fKt, true);
        continue;
        if (parame.fKt == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = parame.fKt;
          continue;
          if (parame.fKt == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = parame.fKt;
            continue;
            if (parame.fKt == null) {
              localObject1 = "";
            } else {
              localObject1 = parame.fKt;
            }
          }
        }
      }
    }
  }
  
  public static String v(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104887);
    String str2 = parame.fKw;
    String str1 = str2;
    if (bo.isNullOrNil(str2)) {
      switch (parame.fKh)
      {
      default: 
        str1 = str2;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104887);
      return str1;
      str1 = "wx482a4001c37e2b74";
      continue;
      str1 = "wx485a97c844086dc9";
    }
  }
  
  public static String w(com.tencent.mm.aw.e parame)
  {
    AppMethodBeat.i(104888);
    switch (parame.fKh)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      parame = ah.getContext().getString(2131298934);
      AppMethodBeat.o(104888);
      return parame;
    case 0: 
    case 1: 
    case 8: 
      parame = ah.getContext().getString(2131303909);
      AppMethodBeat.o(104888);
      return parame;
    case 5: 
      parame = ah.getContext().getString(2131302917);
      AppMethodBeat.o(104888);
      return parame;
    }
    parame = ah.getContext().getString(2131303610);
    AppMethodBeat.o(104888);
    return parame;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */