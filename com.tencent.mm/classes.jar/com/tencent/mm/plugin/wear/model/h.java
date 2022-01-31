package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.ag.o;
import com.tencent.mm.h.a.td;
import com.tencent.mm.h.a.td.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.c.cjb;
import com.tencent.mm.protocal.c.cjs;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static byte[] P(Bitmap paramBitmap)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    return localByteArrayOutputStream.toByteArray();
  }
  
  public static final Bitmap Ri(String paramString)
  {
    Bitmap localBitmap = a.b.cmd().ch(paramString);
    if (localBitmap == null)
    {
      o.JQ();
      paramString = com.tencent.mm.ag.d.A(paramString, false);
      y.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
      return com.tencent.mm.ag.d.kj(paramString);
    }
    y.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    return localBitmap;
  }
  
  public static String Rj(String paramString)
  {
    au.Hx();
    ad localad = c.Fw().abl(paramString);
    String str;
    if (s.fn(paramString))
    {
      str = ae.getContext().getString(R.l.chatting_roominfo_noname);
      paramString = r.a(localad, paramString);
      if ((!localad.field_username.equals(paramString)) && (!bk.bl(paramString))) {
        return paramString;
      }
    }
    else
    {
      return r.a(localad, paramString);
    }
    return str;
  }
  
  public static byte[] Rk(String paramString)
  {
    paramString = "lib" + paramString + ".so";
    return e.c(j.n(new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.loader.a.b.dOO, "lib"), paramString).cLr()), 0, -1);
  }
  
  public static boolean aHI()
  {
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static boolean aHJ()
  {
    PackageManager localPackageManager = ae.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      return true;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    return false;
  }
  
  public static cjs aa(bi parambi)
  {
    cjs localcjs = new cjs();
    localcjs.tXq = parambi.field_msgId;
    localcjs.tXv = parambi.field_createTime;
    localcjs.kSW = 1;
    localcjs.tXw = true;
    Object localObject2;
    Object localObject1;
    label92:
    int i;
    if (parambi.field_isSend == 1)
    {
      localcjs.tqh = Rj(com.tencent.mm.model.q.Gj());
      localcjs.tXp = com.tencent.mm.model.q.Gj();
      localObject2 = null;
      if (parambi.isSystem())
      {
        localObject1 = ae.getContext().getString(R.l.notification_sys_content);
        localcjs.kSW = 3;
        parambi = (bi)localObject1;
        if (localObject1 == null) {
          parambi = ae.getContext().getString(R.l.notification_simple_tip);
        }
        localcjs.kVs = parambi;
        return localcjs;
      }
    }
    else if (s.fn(parambi.field_talker))
    {
      localObject1 = parambi.field_talker;
      i = com.tencent.mm.model.bd.iH(parambi.field_content);
      if (i == -1) {
        break label1534;
      }
      localObject2 = parambi.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1534;
      }
      localObject1 = localObject2;
    }
    label1183:
    label1231:
    label1531:
    label1534:
    for (;;)
    {
      for (;;)
      {
        localcjs.tqh = Rj((String)localObject1);
        localcjs.tXp = ((String)localObject1);
        break;
        localcjs.tqh = Rj(parambi.field_talker);
        localcjs.tXp = parambi.field_talker;
        break;
        if (parambi.ctB())
        {
          localObject1 = ae.getContext().getString(R.l.notification_img_content);
          localcjs.kSW = 4;
          break label92;
        }
        if (parambi.isText())
        {
          if ((s.fn(parambi.field_talker)) && (parambi.field_isSend != 1))
          {
            i = com.tencent.mm.model.bd.iH(parambi.field_content);
            if (i != -1)
            {
              localObject1 = parambi.field_content.substring(i + 1).trim();
              break label92;
            }
            localObject1 = parambi.field_content;
            break label92;
          }
          localObject1 = parambi.field_content;
          break label92;
        }
        if (parambi.ctA())
        {
          localObject1 = ae.getContext().getString(R.l.notification_voice_content);
          localcjs.kSW = 6;
          localcjs.tXw = com.tencent.mm.modelvoice.q.F(parambi);
          float f = com.tencent.mm.modelvoice.q.ck(new n(parambi.field_content).time);
          localcjs.tXx = new com.tencent.mm.bv.b(ae.getContext().getString(R.l.fmt_time_length, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label92;
        }
        if (parambi.aRQ())
        {
          localObject1 = ae.getContext().getString(R.l.notification_video_content);
          break label92;
        }
        if (parambi.aRR())
        {
          localObject1 = ae.getContext().getString(R.l.notification_short_video_content);
          break label92;
        }
        if (parambi.cvg())
        {
          g.a locala = g.a.gp(parambi.field_content);
          localObject1 = localObject2;
          if (locala == null) {
            break label92;
          }
          if (locala.dSi.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localcjs.kSW = 5;
            if (parambi.field_isSend == 1)
            {
              localObject1 = locala.dSc;
              break label92;
            }
            localObject1 = locala.dSb;
            break label92;
          }
          if (parambi.field_isSend == 1) {}
          for (parambi = locala.dSc;; parambi = locala.dSb)
          {
            localObject1 = ae.getContext().getString(R.l.notification_c2c_template, new Object[] { parambi });
            break;
          }
        }
        if (parambi.cvh())
        {
          localObject1 = ae.getContext().getString(R.l.notification_c2c_new_year_lucky_content);
          localcjs.kSW = 5;
          break label92;
        }
        if (parambi.aVK())
        {
          parambi = g.a.gp(parambi.field_content);
          localObject1 = localObject2;
          if (parambi == null) {
            break label92;
          }
          switch (parambi.type)
          {
          case 7: 
          case 9: 
          case 11: 
          case 12: 
          case 14: 
          case 17: 
          case 18: 
          default: 
            localObject1 = localObject2;
            break;
          case 2: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_img_content), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_link_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 3: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_music_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 6: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_file_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 4: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_video_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 19: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_record_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 15: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_emoji_share_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 10: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_product_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 13: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_mall_product_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 20: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_app_tv_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 16: 
            localObject1 = String.format(ae.getContext().getString(R.l.notification_card_content), new Object[] { bk.aM(parambi.title, "") });
            break;
          case 8: 
            localObject1 = ae.getContext().getString(R.l.notification_custom_emoji_content, new Object[] { bk.aM(parambi.title, "") });
            break;
          }
        }
        if (parambi.cvo())
        {
          localObject1 = ae.getContext().getString(R.l.notification_emoji_content);
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1531;
          }
          parambi = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().As(parambi.field_imgPath);
          if (bk.bl(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(parambi.Wv())))
          {
            localObject1 = ae.getContext().getString(R.l.notification_emoji_content);
            localObject2 = new cjb();
            ((cjb)localObject2).sRE = parambi.Wv();
            if (!parambi.isGif()) {
              break label1289;
            }
            ((cjb)localObject2).hQR = 1;
          }
        }
        try
        {
          for (;;)
          {
            localcjs.tXx = new com.tencent.mm.bv.b(((cjb)localObject2).toByteArray());
            localcjs.kSW = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Aw(parambi.Wv()) + "]";
            break label1183;
            ((cjb)localObject2).hQR = 2;
          }
          if (parambi.aVM())
          {
            localObject1 = ae.getContext().getString(R.l.notification_location_content);
            break label92;
          }
          if ((!parambi.cvj()) && (!parambi.cvk()))
          {
            if (parambi.getType() == 64)
            {
              i = 1;
              if (i == 0) {
                break label1450;
              }
            }
          }
          else if (!parambi.field_content.equals(bi.uBP))
          {
            parambi = parambi.field_content;
            localObject1 = new td();
            ((td)localObject1).ccJ.bNb = 1;
            ((td)localObject1).ccJ.content = parambi;
            a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
            if (((td)localObject1).ccK.type != 3) {
              break label1432;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1437;
            }
            localObject1 = ae.getContext().getString(R.l.notification_voip_voice_content);
            break;
            i = 0;
            break label1343;
          }
          localObject1 = ae.getContext().getString(R.l.notification_voip_content);
          break label92;
          if (parambi.cvn())
          {
            au.Hx();
            parambi = c.Fy().HN(parambi.field_content);
            localObject1 = String.format(ae.getContext().getString(R.l.notification_card_content), new Object[] { parambi.getDisplayName() });
            break label92;
          }
          localObject1 = localObject2;
          if (parambi.getType() != -1879048186) {
            break label92;
          }
          localObject1 = ae.getContext().getString(R.l.notification_app_location_share_content);
        }
        catch (IOException parambi)
        {
          break label1231;
        }
      }
      break label92;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */