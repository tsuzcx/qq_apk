package com.tencent.mm.plugin.music.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.as.g;
import com.tencent.mm.as.o;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.jx;
import com.tencent.mm.h.a.jx.b;
import com.tencent.mm.h.a.rc;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage.IMediaObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.plugin.music.a.b;
import com.tencent.mm.plugin.music.a.c;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.awd;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.a.c.a;
import java.util.LinkedList;

public final class d
{
  public static void D(Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("mutil_select_is_ret", true);
    localIntent.putExtra("scene_from", 6);
    com.tencent.mm.br.d.c(paramActivity, ".ui.transmit.SelectConversationUI", localIntent, 1);
  }
  
  public static void F(String paramString1, String paramString2, int paramInt)
  {
    y.i("MicroMsg.Music.MusicUtil", "gotoAppbrand(), appId:%s, appUserName:%s, pkgType:%d", new Object[] { paramString1, paramString2, Integer.valueOf(paramInt) });
    rc localrc = new rc();
    localrc.caq.appId = paramString1;
    localrc.caq.cau = -1;
    localrc.caq.cat = paramInt;
    localrc.caq.userName = paramString2;
    localrc.caq.scene = 1056;
    if (paramInt == 1) {
      localrc.caq.cax = true;
    }
    com.tencent.mm.sdk.b.a.udP.m(localrc);
  }
  
  public static com.tencent.mm.ui.widget.a.c H(Context paramContext, int paramInt)
  {
    paramContext = new c.a(paramContext);
    paramContext.Ip(a.f.app_tip);
    paramContext.Iq(paramInt);
    paramContext.Is(a.f.welcome_i_know).a(null);
    paramContext.nW(true);
    paramContext = paramContext.aoP();
    paramContext.show();
    return paramContext;
  }
  
  public static int Jz(String paramString)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return 0;
        }
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        y.printErrStackTrace("MicroMsg.Music.MusicUtil", paramString, "getInt", new Object[0]);
      }
    }
    return 0;
  }
  
  public static void a(com.tencent.mm.av.e parame, Activity paramActivity)
  {
    h.nFQ.aC(10910, "3");
    cj localcj = new cj();
    yj localyj = new yj();
    yp localyp = new yp();
    xv localxv = new xv();
    localyp.Yq(q.Gj());
    localyp.Yr(q.Gj());
    localyp.EQ(5);
    localyp.hl(bk.UY());
    localyp.Yw(v(parame));
    localxv.XB(parame.euD);
    localxv.XC(parame.euE);
    localxv.XA(parame.euF);
    Object localObject = e.bnq().JE(com.tencent.mm.plugin.music.h.b.K(parame));
    if (((com.tencent.mm.plugin.music.model.e.a)localObject).bnA())
    {
      localxv.XD(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songHAlbumUrl);
      localxv.mj(true);
      localObject = u(parame);
      if (!com.tencent.mm.vfs.e.bK((String)localObject)) {
        break label302;
      }
      localxv.XJ((String)localObject);
    }
    for (;;)
    {
      localxv.Xu(parame.euz);
      localxv.Xv(parame.euA);
      localxv.EH(7);
      localcj.bIw.title = parame.euz;
      localcj.bIw.desc = parame.euA;
      localcj.bIw.bIy = localyj;
      localcj.bIw.type = 7;
      localyj.a(localyp);
      localyj.sXc.add(localxv);
      localcj.bIw.activity = paramActivity;
      localcj.bIw.bID = 3;
      com.tencent.mm.sdk.b.a.udP.m(localcj);
      return;
      localxv.XD(((com.tencent.mm.plugin.music.model.e.a)localObject).field_songAlbumUrl);
      break;
      label302:
      localxv.mk(true);
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.music.model.e.a parama)
  {
    boolean bool = false;
    y.d("MicroMsg.Music.MusicUtil", "music urls: %s,  %s,  %s", new Object[] { parama.field_songWapLinkUrl, parama.field_songWebUrl, parama.field_songWifiUrl });
    if ((!bk.bl(parama.field_songWapLinkUrl)) || (!bk.bl(parama.field_songWebUrl)) || (!bk.bl(parama.field_songWifiUrl))) {
      bool = true;
    }
    return bool;
  }
  
  public static void b(com.tencent.mm.av.e parame, Activity paramActivity)
  {
    Object localObject1 = new WXMusicObject();
    ((WXMusicObject)localObject1).musicUrl = parame.euF;
    ((WXMusicObject)localObject1).musicDataUrl = parame.euD;
    ((WXMusicObject)localObject1).musicLowBandUrl = parame.euE;
    ((WXMusicObject)localObject1).musicLowBandDataUrl = parame.euE;
    WXMediaMessage localWXMediaMessage = new WXMediaMessage();
    localWXMediaMessage.mediaObject = ((WXMediaMessage.IMediaObject)localObject1);
    localWXMediaMessage.title = parame.euz;
    localWXMediaMessage.description = parame.euA;
    Bundle localBundle = null;
    Object localObject2 = u(parame);
    localObject1 = localBundle;
    if (localObject2 != null)
    {
      localObject1 = localBundle;
      if (com.tencent.mm.vfs.e.bK((String)localObject2))
      {
        int i = (int)paramActivity.getResources().getDimension(a.b.NormalAvatarSize);
        localObject1 = com.tencent.mm.sdk.platformtools.c.ak((String)localObject2, i, i);
      }
    }
    if (localObject1 != null) {}
    for (localWXMediaMessage.thumbData = bk.X((Bitmap)localObject1);; localWXMediaMessage.thumbData = bk.X(com.tencent.mm.sdk.platformtools.c.EX(a.c.default_icon_music)))
    {
      localObject1 = new Intent();
      localBundle = new Bundle();
      localObject2 = new SendMessageToWX.Req();
      ((SendMessageToWX.Req)localObject2).message = localWXMediaMessage;
      ((SendMessageToWX.Req)localObject2).toBundle(localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_timeline", localBundle);
      ((Intent)localObject1).putExtra("Ksnsupload_musicid", parame.eux);
      ((Intent)localObject1).putExtra("Ksnsupload_appid", v(parame));
      ((Intent)localObject1).putExtra("Ksnsupload_appname", w(parame));
      parame = u.ij("music_player");
      u.Hc().v(parame, true).h("prePublishId", "music_player");
      ((Intent)localObject1).putExtra("reportSessionId", parame);
      b.eUR.m((Intent)localObject1, paramActivity);
      return;
    }
  }
  
  public static String u(com.tencent.mm.av.e parame)
  {
    com.tencent.mm.plugin.music.model.e.a locala = e.bnq().JE(com.tencent.mm.plugin.music.h.b.K(parame));
    if (locala == null) {
      return "";
    }
    Object localObject2 = com.tencent.mm.plugin.music.h.b.aO(locala.field_musicId, true);
    Object localObject1 = localObject2;
    if (!com.tencent.mm.vfs.e.bK((String)localObject2)) {
      switch (parame.euv)
      {
      case 1: 
      case 2: 
      case 3: 
      case 8: 
      case 9: 
      default: 
        localObject1 = localObject2;
        if (n.omD != null)
        {
          localObject1 = new awd();
          ((awd)localObject1).lsK = parame.euN;
          ((awd)localObject1).trP = parame.euC;
          ((awd)localObject1).trQ = parame.euL;
          ((awd)localObject1).kSC = ((awd)localObject1).trP;
          localObject1 = n.omC.a((awd)localObject1);
        }
        break;
      }
    }
    for (;;)
    {
      y.i("MicroMsg.Music.MusicUtil", "real album path = %s", new Object[] { localObject1 });
      return localObject1;
      localObject1 = new jx();
      ((jx)localObject1).bSs.action = 12;
      ((jx)localObject1).bSs.bSx = parame.euC;
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = ((jx)localObject1).bSt.bSz;
      localObject2 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject2 = parame.euH;
      }
      localObject1 = localObject2;
      if (!com.tencent.mm.vfs.e.bK((String)localObject2))
      {
        localObject1 = com.tencent.mm.plugin.music.h.b.aO(locala.field_musicId, false);
        continue;
        localObject1 = o.OJ().F(parame.euH, true);
        continue;
        if (parame.euH == null)
        {
          localObject1 = "";
        }
        else
        {
          localObject1 = parame.euH;
          continue;
          if (parame.euH == null)
          {
            localObject1 = "";
          }
          else
          {
            localObject1 = parame.euH;
            continue;
            if (parame.euH == null) {
              localObject1 = "";
            } else {
              localObject1 = parame.euH;
            }
          }
        }
      }
    }
  }
  
  public static String v(com.tencent.mm.av.e parame)
  {
    String str = parame.euK;
    if (bk.bl(str)) {}
    switch (parame.euv)
    {
    default: 
      return str;
    case 5: 
      return "wx482a4001c37e2b74";
    }
    return "wx485a97c844086dc9";
  }
  
  public static String w(com.tencent.mm.av.e parame)
  {
    switch (parame.euv)
    {
    case 2: 
    case 3: 
    case 6: 
    case 7: 
    default: 
      return ae.getContext().getString(a.f.default_music_prefix);
    case 0: 
    case 1: 
    case 8: 
      return ae.getContext().getString(a.f.sns_music_prefix);
    case 5: 
      return ae.getContext().getString(a.f.scan_music_prefix);
    }
    return ae.getContext().getString(a.f.shake_music_app);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.d
 * JD-Core Version:    0.7.0.1
 */