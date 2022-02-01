package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.a.xh;
import com.tencent.mm.g.a.xh.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.protobuf.dwj;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static final Bitmap aAh(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.eMA().el(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.aj.p.aBh();
      paramString = com.tencent.mm.aj.e.K(paramString, false);
      ac.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = com.tencent.mm.aj.e.Ae(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      ac.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String aAi(String paramString)
  {
    AppMethodBeat.i(30022);
    az.ayM();
    com.tencent.mm.storage.ai localai = c.awB().aNt(paramString);
    String str;
    if (w.sQ(paramString))
    {
      str = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131757293);
      paramString = v.b(localai, paramString);
      if ((localai.field_username.equals(paramString)) || (bs.isNullOrNil(paramString))) {
        break label77;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = v.b(localai, paramString);
      continue;
      label77:
      paramString = str;
    }
  }
  
  public static byte[] aAj(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = i.aU(q.B(new com.tencent.mm.vfs.e(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.aoY(), "lib"), paramString).fxV()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static dxa aB(bo parambo)
  {
    AppMethodBeat.i(30023);
    dxa localdxa = new dxa();
    localdxa.DUK = parambo.field_msgId;
    localdxa.DUA = parambo.field_createTime;
    localdxa.tit = 1;
    localdxa.GdJ = true;
    Object localObject2;
    Object localObject1;
    label97:
    int i;
    if (parambo.field_isSend == 1)
    {
      localdxa.Nickname = aAi(u.axw());
      localdxa.FDc = u.axw();
      localObject2 = null;
      if (parambo.isSystem())
      {
        localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761727);
        localdxa.tit = 3;
        parambo = (bo)localObject1;
        if (localObject1 == null) {
          parambo = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761720);
        }
        localdxa.hkR = parambo;
        AppMethodBeat.o(30023);
        return localdxa;
      }
    }
    else if (w.sQ(parambo.field_talker))
    {
      localObject1 = parambo.field_talker;
      i = bi.yi(parambo.field_content);
      if (i == -1) {
        break label1541;
      }
      localObject2 = parambo.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1541;
      }
      localObject1 = localObject2;
    }
    label1538:
    label1541:
    for (;;)
    {
      for (;;)
      {
        localdxa.Nickname = aAi((String)localObject1);
        localdxa.FDc = ((String)localObject1);
        break;
        localdxa.Nickname = aAi(parambo.field_talker);
        localdxa.FDc = parambo.field_talker;
        break;
        if (parambo.eZm())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761693);
          localdxa.tit = 4;
          break label97;
        }
        if (parambo.isText())
        {
          if ((w.sQ(parambo.field_talker)) && (parambo.field_isSend != 1))
          {
            i = bi.yi(parambo.field_content);
            if (i != -1)
            {
              localObject1 = parambo.field_content.substring(i + 1).trim();
              break label97;
            }
            localObject1 = parambo.field_content;
            break label97;
          }
          localObject1 = parambo.field_content;
          break label97;
        }
        if (parambo.eZl())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761729);
          localdxa.tit = 6;
          localdxa.GdJ = s.W(parambo);
          float f = s.qw(new com.tencent.mm.modelvoice.p(parambo.field_content).time);
          localdxa.GdK = new com.tencent.mm.bw.b(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131759570, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label97;
        }
        if (parambo.crt())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761728);
          break label97;
        }
        if (parambo.crv())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761719);
          break label97;
        }
        if (parambo.fbu())
        {
          k.b localb = k.b.vA(parambo.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label97;
          }
          if (localb.hjo.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localdxa.tit = 5;
            if (parambo.field_isSend == 1)
            {
              localObject1 = localb.hji;
              break label97;
            }
            localObject1 = localb.hjh;
            break label97;
          }
          if (parambo.field_isSend == 1) {}
          for (parambo = localb.hji;; parambo = localb.hjh)
          {
            localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761672, new Object[] { parambo });
            break;
          }
        }
        if (parambo.fbv())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761671);
          localdxa.tit = 5;
          break label97;
        }
        if (parambo.cKN())
        {
          parambo = k.b.vA(parambo.field_content);
          localObject1 = localObject2;
          if (parambo == null) {
            break label97;
          }
          switch (parambo.type)
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
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761693), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761662), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 3: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761665), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 6: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761661), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 4: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761669), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 19: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761667), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 15: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761660), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 10: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761666), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 13: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761664), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 20: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761668), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 16: 
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761673), new Object[] { bs.bG(parambo.title, "") });
            break;
          case 8: 
            localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761674, new Object[] { bs.bG(parambo.title, "") });
            break;
          }
        }
        if (parambo.fbC())
        {
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761682);
          if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1538;
          }
          parambo = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(parambo.field_imgPath);
          if (bs.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(parambo.JC())))
          {
            localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761682);
            label1190:
            localObject2 = new dwj();
            ((dwj)localObject2).MD5 = parambo.JC();
            if (!parambo.isGif()) {
              break label1296;
            }
            ((dwj)localObject2).ndI = 1;
          }
        }
        try
        {
          for (;;)
          {
            localdxa.GdK = new com.tencent.mm.bw.b(((dwj)localObject2).toByteArray());
            label1238:
            localdxa.tit = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XP(parambo.JC()) + "]";
            break label1190;
            label1296:
            ((dwj)localObject2).ndI = 2;
          }
          if (parambo.cKP())
          {
            localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761694);
            break label97;
          }
          if ((!parambo.fbx()) && (!parambo.fby()))
          {
            if (parambo.getType() == 64)
            {
              i = 1;
              label1350:
              if (i == 0) {
                break label1457;
              }
            }
          }
          else if (!parambo.field_content.equals(bo.GYO))
          {
            parambo = parambo.field_content;
            localObject1 = new xh();
            ((xh)localObject1).dAb.dgL = 1;
            ((xh)localObject1).dAb.content = parambo;
            a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
            if (((xh)localObject1).dAc.type != 3) {
              break label1439;
            }
          }
          label1439:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1444;
            }
            localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761733);
            break;
            i = 0;
            break label1350;
          }
          label1444:
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761732);
          break label97;
          label1457:
          if (parambo.fbB())
          {
            az.ayM();
            parambo = c.awD().alw(parambo.field_content);
            localObject1 = String.format(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761673), new Object[] { parambo.getDisplayName() });
            break label97;
          }
          localObject1 = localObject2;
          if (parambo.getType() != -1879048186) {
            break label97;
          }
          localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131761663);
        }
        catch (IOException parambo)
        {
          break label1238;
        }
      }
      break label97;
    }
  }
  
  public static boolean acD()
  {
    boolean bool = true;
    AppMethodBeat.i(30025);
    PackageManager localPackageManager = com.tencent.mm.sdk.platformtools.ai.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      AppMethodBeat.o(30025);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public static boolean acE()
  {
    boolean bool = true;
    AppMethodBeat.i(30026);
    PackageManager localPackageManager = com.tencent.mm.sdk.platformtools.ai.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      AppMethodBeat.o(30026);
      return bool;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        bool = false;
      }
    }
  }
  
  public static byte[] aq(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30024);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(30024);
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */