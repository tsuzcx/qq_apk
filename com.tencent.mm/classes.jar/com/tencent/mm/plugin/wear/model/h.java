package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.acn;
import com.tencent.mm.autogen.a.acn.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.gfn;
import com.tencent.mm.protocal.protobuf.gge;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static byte[] aU(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30024);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(30024);
    return paramBitmap;
  }
  
  public static boolean aVb()
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
  
  public static boolean aVc()
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
  
  public static final Bitmap bhD(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.iKa().loadBitmap(paramString);
    if (localBitmap == null)
    {
      q.bFp();
      paramString = AvatarStorage.R(paramString, false);
      Log.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = AvatarStorage.LL(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      Log.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String bhE(String paramString)
  {
    AppMethodBeat.i(30022);
    bh.bCz();
    au localau = c.bzA().JE(paramString);
    String str;
    if (au.bwE(paramString))
    {
      str = MMApplicationContext.getContext().getString(R.l.gzv);
      paramString = aa.b(localau, paramString);
      if ((localau.field_username.equals(paramString)) || (Util.isNullOrNil(paramString))) {
        break label78;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = aa.b(localau, paramString);
      continue;
      label78:
      paramString = str;
    }
  }
  
  public static byte[] bhF(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = y.bi(ah.v(new u(new u(com.tencent.mm.loader.i.b.bmq(), "lib"), paramString).jKT()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static gge bv(cc paramcc)
  {
    AppMethodBeat.i(30023);
    gge localgge = new gge();
    localgge.YKx = paramcc.field_msgId;
    localgge.YKn = paramcc.getCreateTime();
    localgge.IIs = 1;
    localgge.accT = true;
    Object localObject2;
    Object localObject1;
    label98:
    int i;
    if (paramcc.field_isSend == 1)
    {
      localgge.Nickname = bhE(z.bAM());
      localgge.abvu = z.bAM();
      localObject2 = null;
      if (paramcc.jbD())
      {
        localObject1 = MMApplicationContext.getContext().getString(R.l.gPX);
        localgge.IIs = 3;
        paramcc = (cc)localObject1;
        if (localObject1 == null) {
          paramcc = MMApplicationContext.getContext().getString(R.l.gPW);
        }
        localgge.nUB = paramcc;
        AppMethodBeat.o(30023);
        return localgge;
      }
    }
    else if (au.bwE(paramcc.field_talker))
    {
      localObject1 = paramcc.field_talker;
      i = br.JG(paramcc.field_content);
      if (i == -1) {
        break label1543;
      }
      localObject2 = paramcc.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1543;
      }
      localObject1 = localObject2;
    }
    label1540:
    label1543:
    for (;;)
    {
      for (;;)
      {
        localgge.Nickname = bhE((String)localObject1);
        localgge.abvu = ((String)localObject1);
        break;
        localgge.Nickname = bhE(paramcc.field_talker);
        localgge.abvu = paramcc.field_talker;
        break;
        if (paramcc.iYk())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPE);
          localgge.IIs = 4;
          break label98;
        }
        if (paramcc.iYl())
        {
          if ((au.bwE(paramcc.field_talker)) && (paramcc.field_isSend != 1))
          {
            i = br.JG(paramcc.field_content);
            if (i != -1)
            {
              localObject1 = paramcc.field_content.substring(i + 1).trim();
              break label98;
            }
            localObject1 = paramcc.field_content;
            break label98;
          }
          localObject1 = paramcc.field_content;
          break label98;
        }
        if (paramcc.iYj())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPZ);
          localgge.IIs = 6;
          localgge.accT = s.aw(paramcc);
          float f = s.jh(new p(paramcc.field_content).time);
          localgge.accU = new com.tencent.mm.bx.b(MMApplicationContext.getContext().getString(R.l.gIM, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label98;
        }
        if (paramcc.dSH())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPY);
          break label98;
        }
        if (paramcc.dSJ())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPV);
          break label98;
        }
        if (paramcc.jbu())
        {
          k.b localb = k.b.Hf(paramcc.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label98;
          }
          if (localb.nSL.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localgge.IIs = 5;
            if (paramcc.field_isSend == 1)
            {
              localObject1 = localb.nSF;
              break label98;
            }
            localObject1 = localb.nSE;
            break label98;
          }
          if (paramcc.field_isSend == 1) {}
          for (paramcc = localb.nSF;; paramcc = localb.nSE)
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.gPy, new Object[] { paramcc });
            break;
          }
        }
        if (paramcc.jbv())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPx);
          localgge.IIs = 5;
          break label98;
        }
        if (paramcc.fxR())
        {
          paramcc = k.b.Hf(paramcc.field_content);
          localObject1 = localObject2;
          if (paramcc == null) {
            break label98;
          }
          switch (paramcc.type)
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
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPE), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPp), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 3: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPs), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 6: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPo), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 4: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPw), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 19: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPu), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 15: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPn), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 10: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPt), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 13: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPr), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 20: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPv), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 16: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPz), new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          case 8: 
            localObject1 = MMApplicationContext.getContext().getString(R.l.gPA, new Object[] { Util.nullAs(paramcc.title, "") });
            break;
          }
        }
        if (paramcc.jbG())
        {
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPB);
          if (((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr() == null) {
            break label1540;
          }
          paramcc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramcc.field_imgPath);
          if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramcc.getMd5())))
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.gPB);
            label1195:
            localObject2 = new gfn();
            ((gfn)localObject2).MD5 = paramcc.getMd5();
            if (!paramcc.isGif()) {
              break label1301;
            }
            ((gfn)localObject2).vhJ = 1;
          }
        }
        try
        {
          for (;;)
          {
            localgge.accU = new com.tencent.mm.bx.b(((gfn)localObject2).toByteArray());
            label1243:
            localgge.IIs = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoi(paramcc.getMd5()) + "]";
            break label1195;
            label1301:
            ((gfn)localObject2).vhJ = 2;
          }
          if (paramcc.fxT())
          {
            localObject1 = MMApplicationContext.getContext().getString(R.l.gPF);
            break label98;
          }
          if ((!paramcc.jbx()) && (!paramcc.jby()))
          {
            if (paramcc.getType() == 64)
            {
              i = 1;
              label1355:
              if (i == 0) {
                break label1459;
              }
            }
          }
          else if (!paramcc.field_content.equals(cc.adko))
          {
            paramcc = paramcc.field_content;
            localObject1 = new acn();
            ((acn)localObject1).ifU.hId = 1;
            ((acn)localObject1).ifU.content = paramcc;
            ((acn)localObject1).publish();
            if (((acn)localObject1).ifV.type != 3) {
              break label1441;
            }
          }
          label1441:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1446;
            }
            localObject1 = MMApplicationContext.getContext().getString(R.l.gQb);
            break;
            i = 0;
            break label1355;
          }
          label1446:
          localObject1 = MMApplicationContext.getContext().getString(R.l.gQa);
          break label98;
          label1459:
          if (paramcc.jbB())
          {
            bh.bCz();
            paramcc = c.bzD().aLU(paramcc.field_content);
            localObject1 = String.format(MMApplicationContext.getContext().getString(R.l.gPz), new Object[] { paramcc.getDisplayName() });
            break label98;
          }
          localObject1 = localObject2;
          if (paramcc.getType() != -1879048186) {
            break label98;
          }
          localObject1 = MMApplicationContext.getContext().getString(R.l.gPq);
        }
        catch (IOException paramcc)
        {
          break label1243;
        }
      }
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */