package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.am.f;
import com.tencent.mm.f.a.aaq;
import com.tencent.mm.f.a.aaq.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.fiz;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static byte[] aC(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30024);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(30024);
    return paramBitmap;
  }
  
  public static boolean aCe()
  {
    boolean bool = true;
    AppMethodBeat.i(30025);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
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
  
  public static boolean aCf()
  {
    boolean bool = true;
    AppMethodBeat.i(30026);
    PackageManager localPackageManager = MMApplicationContext.getContext().getPackageManager();
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
  
  public static fjq bd(ca paramca)
  {
    AppMethodBeat.i(30023);
    fjq localfjq = new fjq();
    localfjq.RNj = paramca.field_msgId;
    localfjq.RMZ = paramca.field_createTime;
    localfjq.COi = 1;
    localfjq.UIL = true;
    Object localObject2;
    Object localObject1;
    label98:
    int i;
    if (paramca.field_isSend == 1)
    {
      localfjq.Nickname = bhV(z.bcZ());
      localfjq.Ueg = z.bcZ();
      localObject2 = null;
      if (paramca.hzz())
      {
        localObject1 = MMApplicationContext.getContext().getString(R.l.eNJ);
        localfjq.COi = 3;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = MMApplicationContext.getContext().getString(R.l.eNI);
        }
        localfjq.lpy = paramca;
        AppMethodBeat.o(30023);
        return localfjq;
      }
    }
    else if (ab.Lj(paramca.field_talker))
    {
      localObject1 = paramca.field_talker;
      i = bq.RI(paramca.field_content);
      if (i == -1) {
        break label1546;
      }
      localObject2 = paramca.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1546;
      }
      localObject1 = localObject2;
    }
    label1543:
    label1546:
    for (;;)
    {
      for (;;)
      {
        localfjq.Nickname = bhV((String)localObject1);
        localfjq.Ueg = ((String)localObject1);
        break;
        localfjq.Nickname = bhV(paramca.field_talker);
        localfjq.Ueg = paramca.field_talker;
        break;
        if (paramca.hwG())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNr);
          localfjq.COi = 4;
          break label98;
        }
        if (paramca.hwH())
        {
          if ((ab.Lj(paramca.field_talker)) && (paramca.field_isSend != 1))
          {
            i = bq.RI(paramca.field_content);
            if (i != -1)
            {
              localObject1 = paramca.field_content.substring(i + 1).trim();
              break label98;
            }
            localObject1 = paramca.field_content;
            break label98;
          }
          localObject1 = paramca.field_content;
          break label98;
        }
        if (paramca.hwF())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNL);
          localfjq.COi = 6;
          localfjq.UIL = s.aq(paramca);
          float f = s.GW(new p(paramca.field_content).time);
          localfjq.UIM = new com.tencent.mm.cd.b(MMApplicationContext.getContext().getString(R.l.eFR, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label98;
        }
        if (paramca.dlR())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNK);
          break label98;
        }
        if (paramca.dlT())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNH);
          break label98;
        }
        if (paramca.hzr())
        {
          k.b localb = k.b.OQ(paramca.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label98;
          }
          if (localb.lnH.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localfjq.COi = 5;
            if (paramca.field_isSend == 1)
            {
              localObject1 = localb.lnB;
              break label98;
            }
            localObject1 = localb.lnA;
            break label98;
          }
          if (paramca.field_isSend == 1) {}
          for (paramca = localb.lnB;; paramca = localb.lnA)
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.eNl, new Object[] { paramca });
            break;
          }
        }
        if (paramca.hzs())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNk);
          localfjq.COi = 5;
          break label98;
        }
        if (paramca.erk())
        {
          paramca = k.b.OQ(paramca.field_content);
          localObject1 = localObject2;
          if (paramca == null) {
            break label98;
          }
          switch (paramca.type)
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
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNr), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNc), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 3: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNf), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 6: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNb), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 4: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNj), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 19: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNh), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 15: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNa), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 10: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNg), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 13: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNe), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 20: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNi), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 16: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNm), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 8: 
            localObject1 = MMApplicationContext.getContext().getString(R.l.eNn, new Object[] { Util.nullAs(paramca.title, "") });
            break;
          }
        }
        if (paramca.hzB())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNo);
          if (((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1543;
          }
          paramca = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramca.field_imgPath);
          if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramca.getMd5())))
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.eNo);
            label1195:
            localObject2 = new fiz();
            ((fiz)localObject2).MD5 = paramca.getMd5();
            if (!paramca.isGif()) {
              break label1301;
            }
            ((fiz)localObject2).rWu = 1;
          }
        }
        try
        {
          for (;;)
          {
            localfjq.UIM = new com.tencent.mm.cd.b(((fiz)localObject2).toByteArray());
            label1243:
            localfjq.COi = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().auh(paramca.getMd5()) + "]";
            break label1195;
            label1301:
            ((fiz)localObject2).rWu = 2;
          }
          if (paramca.erm())
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.eNs);
            break label98;
          }
          if ((!paramca.hzu()) && (!paramca.hzv()))
          {
            if (paramca.getType() == 64)
            {
              i = 1;
              label1355:
              if (i == 0) {
                break label1462;
              }
            }
          }
          else if (!paramca.field_content.equals(ca.VGx))
          {
            paramca = paramca.field_content;
            localObject1 = new aaq();
            ((aaq)localObject1).fZM.fDn = 1;
            ((aaq)localObject1).fZM.content = paramca;
            EventCenter.instance.publish((IEvent)localObject1);
            if (((aaq)localObject1).fZN.type != 3) {
              break label1444;
            }
          }
          label1444:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1449;
            }
            localObject1 = MMApplicationContext.getContext().getString(R.l.eNN);
            break;
            i = 0;
            break label1355;
          }
          label1449:
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNM);
          break label98;
          label1462:
          if (paramca.hzy())
          {
            bh.beI();
            paramca = c.bbO().aOU(paramca.field_content);
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.eNm), new Object[] { paramca.getDisplayName() });
            break label98;
          }
          localObject1 = localObject2;
          if (paramca.getType() != -1879048186) {
            break label98;
          }
          localObject1 = MMApplicationContext.getContext().getString(R.l.eNd);
        }
        catch (IOException paramca)
        {
          break label1243;
        }
      }
      break label98;
    }
  }
  
  public static final Bitmap bhU(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.hjf().gJ(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.am.q.bhz();
      paramString = f.O(paramString, false);
      Log.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = f.TL(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      Log.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String bhV(String paramString)
  {
    AppMethodBeat.i(30022);
    bh.beI();
    as localas = c.bbL().RG(paramString);
    String str;
    if (ab.Lj(paramString))
    {
      str = MMApplicationContext.getContext().getString(R.l.ewS);
      paramString = aa.b(localas, paramString);
      if ((localas.field_username.equals(paramString)) || (Util.isNullOrNil(paramString))) {
        break label78;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = aa.b(localas, paramString);
      continue;
      label78:
      paramString = str;
    }
  }
  
  public static byte[] bhW(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = u.aY(new com.tencent.mm.vfs.q(new com.tencent.mm.vfs.q(com.tencent.mm.loader.j.b.aSC(), "lib"), paramString).bOF(), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */