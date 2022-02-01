package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.yh;
import com.tencent.mm.g.a.yh.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.eea;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static eer aD(bv parambv)
  {
    AppMethodBeat.i(30023);
    eer localeer = new eer();
    localeer.FSD = parambv.field_msgId;
    localeer.FSt = parambv.field_createTime;
    localeer.urJ = 1;
    localeer.IiW = true;
    Object localObject2;
    Object localObject1;
    label97:
    int i;
    if (parambv.field_isSend == 1)
    {
      localeer.Nickname = aGM(v.aAC());
      localeer.HGP = v.aAC();
      localObject2 = null;
      if (parambv.isSystem())
      {
        localObject1 = ak.getContext().getString(2131761727);
        localeer.urJ = 3;
        parambv = (bv)localObject1;
        if (localObject1 == null) {
          parambv = ak.getContext().getString(2131761720);
        }
        localeer.hFS = parambv;
        AppMethodBeat.o(30023);
        return localeer;
      }
    }
    else if (x.wb(parambv.field_talker))
    {
      localObject1 = parambv.field_talker;
      i = bl.BJ(parambv.field_content);
      if (i == -1) {
        break label1508;
      }
      localObject2 = parambv.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1508;
      }
      localObject1 = localObject2;
    }
    label1159:
    label1207:
    label1505:
    label1508:
    for (;;)
    {
      for (;;)
      {
        localeer.Nickname = aGM((String)localObject1);
        localeer.HGP = ((String)localObject1);
        break;
        localeer.Nickname = aGM(parambv.field_talker);
        localeer.HGP = parambv.field_talker;
        break;
        if (parambv.ftg())
        {
          localObject1 = ak.getContext().getString(2131761693);
          localeer.urJ = 4;
          break label97;
        }
        if (parambv.isText())
        {
          if ((x.wb(parambv.field_talker)) && (parambv.field_isSend != 1))
          {
            i = bl.BJ(parambv.field_content);
            if (i != -1)
            {
              localObject1 = parambv.field_content.substring(i + 1).trim();
              break label97;
            }
            localObject1 = parambv.field_content;
            break label97;
          }
          localObject1 = parambv.field_content;
          break label97;
        }
        if (parambv.ftf())
        {
          localObject1 = ak.getContext().getString(2131761729);
          localeer.urJ = 6;
          localeer.IiW = s.Y(parambv);
          float f = s.sI(new com.tencent.mm.modelvoice.p(parambv.field_content).time);
          localeer.IiX = new com.tencent.mm.bw.b(ak.getContext().getString(2131759570, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label97;
        }
        if (parambv.cyG())
        {
          localObject1 = ak.getContext().getString(2131761728);
          break label97;
        }
        if (parambv.cyI())
        {
          localObject1 = ak.getContext().getString(2131761719);
          break label97;
        }
        if (parambv.fvx())
        {
          k.b localb = k.b.zb(parambv.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label97;
          }
          if (localb.hEl.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localeer.urJ = 5;
            if (parambv.field_isSend == 1)
            {
              localObject1 = localb.hEf;
              break label97;
            }
            localObject1 = localb.hEe;
            break label97;
          }
          if (parambv.field_isSend == 1) {}
          for (parambv = localb.hEf;; parambv = localb.hEe)
          {
            localObject1 = ak.getContext().getString(2131761672, new Object[] { parambv });
            break;
          }
        }
        if (parambv.fvy())
        {
          localObject1 = ak.getContext().getString(2131761671);
          localeer.urJ = 5;
          break label97;
        }
        if (parambv.cVH())
        {
          parambv = k.b.zb(parambv.field_content);
          localObject1 = localObject2;
          if (parambv == null) {
            break label97;
          }
          switch (parambv.type)
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
            localObject1 = String.format(ak.getContext().getString(2131761693), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(ak.getContext().getString(2131761662), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 3: 
            localObject1 = String.format(ak.getContext().getString(2131761665), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 6: 
            localObject1 = String.format(ak.getContext().getString(2131761661), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 4: 
            localObject1 = String.format(ak.getContext().getString(2131761669), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 19: 
            localObject1 = String.format(ak.getContext().getString(2131761667), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 15: 
            localObject1 = String.format(ak.getContext().getString(2131761660), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 10: 
            localObject1 = String.format(ak.getContext().getString(2131761666), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 13: 
            localObject1 = String.format(ak.getContext().getString(2131761664), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 20: 
            localObject1 = String.format(ak.getContext().getString(2131761668), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 16: 
            localObject1 = String.format(ak.getContext().getString(2131761673), new Object[] { bu.bI(parambv.title, "") });
            break;
          case 8: 
            localObject1 = ak.getContext().getString(2131761674, new Object[] { bu.bI(parambv.title, "") });
            break;
          }
        }
        if (parambv.fvG())
        {
          localObject1 = ak.getContext().getString(2131761682);
          if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1505;
          }
          parambv = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(parambv.field_imgPath);
          if (bu.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(parambv.Lj())))
          {
            localObject1 = ak.getContext().getString(2131761682);
            localObject2 = new eea();
            ((eea)localObject2).MD5 = parambv.Lj();
            if (!parambv.isGif()) {
              break label1264;
            }
            ((eea)localObject2).nJA = 1;
          }
        }
        try
        {
          for (;;)
          {
            localeer.IiX = new com.tencent.mm.bw.b(((eea)localObject2).toByteArray());
            localeer.urJ = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().acm(parambv.Lj()) + "]";
            break label1159;
            label1264:
            ((eea)localObject2).nJA = 2;
          }
          if (parambv.cVJ())
          {
            localObject1 = ak.getContext().getString(2131761694);
            break label97;
          }
          if ((!parambv.fvA()) && (!parambv.fvB()))
          {
            if (parambv.getType() == 64)
            {
              i = 1;
              if (i == 0) {
                break label1425;
              }
            }
          }
          else if (!parambv.field_content.equals(bv.JgK))
          {
            parambv = parambv.field_content;
            localObject1 = new yh();
            ((yh)localObject1).dNE.dto = 1;
            ((yh)localObject1).dNE.content = parambv;
            a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
            if (((yh)localObject1).dNF.type != 3) {
              break label1407;
            }
          }
          label1407:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1412;
            }
            localObject1 = ak.getContext().getString(2131761733);
            break;
            i = 0;
            break label1318;
          }
          localObject1 = ak.getContext().getString(2131761732);
          break label97;
          if (parambv.fvE())
          {
            bc.aCg();
            parambv = c.azI().arp(parambv.field_content);
            localObject1 = String.format(ak.getContext().getString(2131761673), new Object[] { parambv.getDisplayName() });
            break label97;
          }
          localObject1 = localObject2;
          if (parambv.getType() != -1879048186) {
            break label97;
          }
          localObject1 = ak.getContext().getString(2131761663);
        }
        catch (IOException parambv)
        {
          break label1207;
        }
      }
      break label97;
    }
  }
  
  public static final Bitmap aGL(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.ffl().fl(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.aj.p.aEA();
      paramString = e.K(paramString, false);
      ae.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = e.DF(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      ae.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String aGM(String paramString)
  {
    AppMethodBeat.i(30022);
    bc.aCg();
    an localan = c.azF().BH(paramString);
    String str;
    if (x.wb(paramString))
    {
      str = ak.getContext().getString(2131757293);
      paramString = com.tencent.mm.model.w.b(localan, paramString);
      if ((localan.field_username.equals(paramString)) || (bu.isNullOrNil(paramString))) {
        break label78;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = com.tencent.mm.model.w.b(localan, paramString);
      continue;
      label78:
      paramString = str;
    }
  }
  
  public static byte[] aGN(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = o.bb(com.tencent.mm.vfs.w.B(new k(new k(com.tencent.mm.loader.j.b.asa(), "lib"), paramString).fTh()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static boolean afv()
  {
    boolean bool = true;
    AppMethodBeat.i(30025);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
  
  public static boolean afw()
  {
    boolean bool = true;
    AppMethodBeat.i(30026);
    PackageManager localPackageManager = ak.getContext().getPackageManager();
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
  
  public static byte[] at(Bitmap paramBitmap)
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