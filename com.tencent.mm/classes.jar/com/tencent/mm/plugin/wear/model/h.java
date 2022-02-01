package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.yb;
import com.tencent.mm.g.a.yb.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.c;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.eda;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static eda aE(bu parambu)
  {
    AppMethodBeat.i(30023);
    eda localeda = new eda();
    localeda.FAf = parambu.field_msgId;
    localeda.FzV = parambu.field_createTime;
    localeda.ugm = 1;
    localeda.HOP = true;
    Object localObject2;
    Object localObject1;
    label97:
    int i;
    if (parambu.field_isSend == 1)
    {
      localeda.Nickname = aFs(u.aAm());
      localeda.Hnp = u.aAm();
      localObject2 = null;
      if (parambu.isSystem())
      {
        localObject1 = aj.getContext().getString(2131761727);
        localeda.ugm = 3;
        parambu = (bu)localObject1;
        if (localObject1 == null) {
          parambu = aj.getContext().getString(2131761720);
        }
        localeda.hDa = parambu;
        AppMethodBeat.o(30023);
        return localeda;
      }
    }
    else if (w.vF(parambu.field_talker))
    {
      localObject1 = parambu.field_talker;
      i = bj.Bh(parambu.field_content);
      if (i == -1) {
        break label1508;
      }
      localObject2 = parambu.field_content.substring(0, i).trim();
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
        localeda.Nickname = aFs((String)localObject1);
        localeda.Hnp = ((String)localObject1);
        break;
        localeda.Nickname = aFs(parambu.field_talker);
        localeda.Hnp = parambu.field_talker;
        break;
        if (parambu.fpi())
        {
          localObject1 = aj.getContext().getString(2131761693);
          localeda.ugm = 4;
          break label97;
        }
        if (parambu.isText())
        {
          if ((w.vF(parambu.field_talker)) && (parambu.field_isSend != 1))
          {
            i = bj.Bh(parambu.field_content);
            if (i != -1)
            {
              localObject1 = parambu.field_content.substring(i + 1).trim();
              break label97;
            }
            localObject1 = parambu.field_content;
            break label97;
          }
          localObject1 = parambu.field_content;
          break label97;
        }
        if (parambu.fph())
        {
          localObject1 = aj.getContext().getString(2131761729);
          localeda.ugm = 6;
          localeda.HOP = s.Z(parambu);
          float f = s.sv(new com.tencent.mm.modelvoice.p(parambu.field_content).time);
          localeda.HOQ = new com.tencent.mm.bx.b(aj.getContext().getString(2131759570, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label97;
        }
        if (parambu.cxf())
        {
          localObject1 = aj.getContext().getString(2131761728);
          break label97;
        }
        if (parambu.cxh())
        {
          localObject1 = aj.getContext().getString(2131761719);
          break label97;
        }
        if (parambu.frx())
        {
          k.b localb = k.b.yr(parambu.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label97;
          }
          if (localb.hBx.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localeda.ugm = 5;
            if (parambu.field_isSend == 1)
            {
              localObject1 = localb.hBr;
              break label97;
            }
            localObject1 = localb.hBq;
            break label97;
          }
          if (parambu.field_isSend == 1) {}
          for (parambu = localb.hBr;; parambu = localb.hBq)
          {
            localObject1 = aj.getContext().getString(2131761672, new Object[] { parambu });
            break;
          }
        }
        if (parambu.fry())
        {
          localObject1 = aj.getContext().getString(2131761671);
          localeda.ugm = 5;
          break label97;
        }
        if (parambu.cTc())
        {
          parambu = k.b.yr(parambu.field_content);
          localObject1 = localObject2;
          if (parambu == null) {
            break label97;
          }
          switch (parambu.type)
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
            localObject1 = String.format(aj.getContext().getString(2131761693), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(aj.getContext().getString(2131761662), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 3: 
            localObject1 = String.format(aj.getContext().getString(2131761665), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 6: 
            localObject1 = String.format(aj.getContext().getString(2131761661), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 4: 
            localObject1 = String.format(aj.getContext().getString(2131761669), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 19: 
            localObject1 = String.format(aj.getContext().getString(2131761667), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 15: 
            localObject1 = String.format(aj.getContext().getString(2131761660), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 10: 
            localObject1 = String.format(aj.getContext().getString(2131761666), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 13: 
            localObject1 = String.format(aj.getContext().getString(2131761664), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 20: 
            localObject1 = String.format(aj.getContext().getString(2131761668), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 16: 
            localObject1 = String.format(aj.getContext().getString(2131761673), new Object[] { bt.bI(parambu.title, "") });
            break;
          case 8: 
            localObject1 = aj.getContext().getString(2131761674, new Object[] { bt.bI(parambu.title, "") });
            break;
          }
        }
        if (parambu.frG())
        {
          localObject1 = aj.getContext().getString(2131761682);
          if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1505;
          }
          parambu = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abr(parambu.field_imgPath);
          if (bt.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(parambu.Lb())))
          {
            localObject1 = aj.getContext().getString(2131761682);
            localObject2 = new ecj();
            ((ecj)localObject2).MD5 = parambu.Lb();
            if (!parambu.isGif()) {
              break label1264;
            }
            ((ecj)localObject2).nEf = 1;
          }
        }
        try
        {
          for (;;)
          {
            localeda.HOQ = new com.tencent.mm.bx.b(((ecj)localObject2).toByteArray());
            localeda.ugm = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().abv(parambu.Lb()) + "]";
            break label1159;
            label1264:
            ((ecj)localObject2).nEf = 2;
          }
          if (parambu.cTe())
          {
            localObject1 = aj.getContext().getString(2131761694);
            break label97;
          }
          if ((!parambu.frA()) && (!parambu.frB()))
          {
            if (parambu.getType() == 64)
            {
              i = 1;
              if (i == 0) {
                break label1425;
              }
            }
          }
          else if (!parambu.field_content.equals(bu.IMd))
          {
            parambu = parambu.field_content;
            localObject1 = new yb();
            ((yb)localObject1).dMo.dsi = 1;
            ((yb)localObject1).dMo.content = parambu;
            a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
            if (((yb)localObject1).dMp.type != 3) {
              break label1407;
            }
          }
          label1407:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1412;
            }
            localObject1 = aj.getContext().getString(2131761733);
            break;
            i = 0;
            break label1318;
          }
          localObject1 = aj.getContext().getString(2131761732);
          break label97;
          if (parambu.frE())
          {
            ba.aBQ();
            parambu = c.azs().aqk(parambu.field_content);
            localObject1 = String.format(aj.getContext().getString(2131761673), new Object[] { parambu.getDisplayName() });
            break label97;
          }
          localObject1 = localObject2;
          if (parambu.getType() != -1879048186) {
            break label97;
          }
          localObject1 = aj.getContext().getString(2131761663);
        }
        catch (IOException parambu)
        {
          break label1207;
        }
      }
      break label97;
    }
  }
  
  public static final Bitmap aFr(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.fbx().fg(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.ak.p.aEk();
      paramString = com.tencent.mm.ak.e.K(paramString, false);
      ad.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = com.tencent.mm.ak.e.Dd(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      ad.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String aFs(String paramString)
  {
    AppMethodBeat.i(30022);
    ba.aBQ();
    am localam = c.azp().Bf(paramString);
    String str;
    if (w.vF(paramString))
    {
      str = aj.getContext().getString(2131757293);
      paramString = v.b(localam, paramString);
      if ((localam.field_username.equals(paramString)) || (bt.isNullOrNil(paramString))) {
        break label78;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = v.b(localam, paramString);
      continue;
      label78:
      paramString = str;
    }
  }
  
  public static byte[] aFt(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = com.tencent.mm.vfs.i.aY(q.B(new com.tencent.mm.vfs.e(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.arL(), "lib"), paramString).fOK()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static boolean afh()
  {
    boolean bool = true;
    AppMethodBeat.i(30025);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
  
  public static boolean afi()
  {
    boolean bool = true;
    AppMethodBeat.i(30026);
    PackageManager localPackageManager = aj.getContext().getPackageManager();
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
  
  public static byte[] as(Bitmap paramBitmap)
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