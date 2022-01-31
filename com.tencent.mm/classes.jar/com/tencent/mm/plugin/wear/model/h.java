package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.ux;
import com.tencent.mm.g.a.ux.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.protocal.protobuf.cwo;
import com.tencent.mm.protocal.protobuf.cxf;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static boolean OV()
  {
    boolean bool = true;
    AppMethodBeat.i(26343);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app.cn", 1);
      AppMethodBeat.o(26343);
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
  
  public static boolean OW()
  {
    boolean bool = true;
    AppMethodBeat.i(26344);
    PackageManager localPackageManager = ah.getContext().getPackageManager();
    try
    {
      localPackageManager.getPackageInfo("com.google.android.wearable.app", 1);
      AppMethodBeat.o(26344);
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
  
  public static byte[] ad(Bitmap paramBitmap)
  {
    AppMethodBeat.i(26342);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(26342);
    return paramBitmap;
  }
  
  public static final Bitmap agf(String paramString)
  {
    AppMethodBeat.i(26339);
    Bitmap localBitmap = a.b.dmT().dt(paramString);
    if (localBitmap == null)
    {
      o.acQ();
      paramString = com.tencent.mm.ah.d.E(paramString, false);
      ab.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = com.tencent.mm.ah.d.rd(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(26339);
      return paramString;
      ab.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String agg(String paramString)
  {
    AppMethodBeat.i(26340);
    aw.aaz();
    ad localad = c.YA().arw(paramString);
    String str;
    if (t.lA(paramString))
    {
      str = ah.getContext().getString(2131298302);
      paramString = com.tencent.mm.model.s.a(localad, paramString);
      if ((localad.field_username.equals(paramString)) || (bo.isNullOrNil(paramString))) {
        break label77;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(26340);
      return paramString;
      paramString = com.tencent.mm.model.s.a(localad, paramString);
      continue;
      label77:
      paramString = str;
    }
  }
  
  public static byte[] agh(String paramString)
  {
    AppMethodBeat.i(26345);
    paramString = "lib" + paramString + ".so";
    paramString = e.i(j.p(new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.loader.j.b.eQu, "lib"), paramString).dQJ()), 0, -1);
    AppMethodBeat.o(26345);
    return paramString;
  }
  
  public static cxf aj(bi parambi)
  {
    AppMethodBeat.i(26341);
    cxf localcxf = new cxf();
    localcxf.wsz = parambi.field_msgId;
    localcxf.wsC = parambi.field_createTime;
    localcxf.nqW = 1;
    localcxf.yeN = true;
    Object localObject2;
    Object localObject1;
    label98:
    int i;
    if (parambi.field_isSend == 1)
    {
      localcxf.Nickname = agg(r.Zn());
      localcxf.xlH = r.Zn();
      localObject2 = null;
      if (parambi.isSystem())
      {
        localObject1 = ah.getContext().getString(2131301965);
        localcxf.nqW = 3;
        parambi = (bi)localObject1;
        if (localObject1 == null) {
          parambi = ah.getContext().getString(2131301958);
        }
        localcxf.ntu = parambi;
        AppMethodBeat.o(26341);
        return localcxf;
      }
    }
    else if (t.lA(parambi.field_talker))
    {
      localObject1 = parambi.field_talker;
      i = bf.pt(parambi.field_content);
      if (i == -1) {
        break label1546;
      }
      localObject2 = parambi.field_content.substring(0, i).trim();
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
        localcxf.Nickname = agg((String)localObject1);
        localcxf.xlH = ((String)localObject1);
        break;
        localcxf.Nickname = agg(parambi.field_talker);
        localcxf.xlH = parambi.field_talker;
        break;
        if (parambi.dvX())
        {
          localObject1 = ah.getContext().getString(2131301931);
          localcxf.nqW = 4;
          break label98;
        }
        if (parambi.isText())
        {
          if ((t.lA(parambi.field_talker)) && (parambi.field_isSend != 1))
          {
            i = bf.pt(parambi.field_content);
            if (i != -1)
            {
              localObject1 = parambi.field_content.substring(i + 1).trim();
              break label98;
            }
            localObject1 = parambi.field_content;
            break label98;
          }
          localObject1 = parambi.field_content;
          break label98;
        }
        if (parambi.dvW())
        {
          localObject1 = ah.getContext().getString(2131301967);
          localcxf.nqW = 6;
          localcxf.yeN = com.tencent.mm.modelvoice.s.K(parambi);
          float f = com.tencent.mm.modelvoice.s.hi(new p(parambi.field_content).time);
          localcxf.yeO = new com.tencent.mm.bv.b(ah.getContext().getString(2131300103, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label98;
        }
        if (parambi.byj())
        {
          localObject1 = ah.getContext().getString(2131301966);
          break label98;
        }
        if (parambi.byk())
        {
          localObject1 = ah.getContext().getString(2131301957);
          break label98;
        }
        if (parambi.dxK())
        {
          j.b localb = j.b.mY(parambi.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label98;
          }
          if (localb.fih.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localcxf.nqW = 5;
            if (parambi.field_isSend == 1)
            {
              localObject1 = localb.fib;
              break label98;
            }
            localObject1 = localb.fia;
            break label98;
          }
          if (parambi.field_isSend == 1) {}
          for (parambi = localb.fib;; parambi = localb.fia)
          {
            localObject1 = ah.getContext().getString(2131301910, new Object[] { parambi });
            break;
          }
        }
        if (parambi.dxL())
        {
          localObject1 = ah.getContext().getString(2131301909);
          localcxf.nqW = 5;
          break label98;
        }
        if (parambi.bCn())
        {
          parambi = j.b.mY(parambi.field_content);
          localObject1 = localObject2;
          if (parambi == null) {
            break label98;
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
            localObject1 = String.format(ah.getContext().getString(2131301931), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(ah.getContext().getString(2131301900), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 3: 
            localObject1 = String.format(ah.getContext().getString(2131301903), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 6: 
            localObject1 = String.format(ah.getContext().getString(2131301899), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 4: 
            localObject1 = String.format(ah.getContext().getString(2131301907), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 19: 
            localObject1 = String.format(ah.getContext().getString(2131301905), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 15: 
            localObject1 = String.format(ah.getContext().getString(2131301898), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 10: 
            localObject1 = String.format(ah.getContext().getString(2131301904), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 13: 
            localObject1 = String.format(ah.getContext().getString(2131301902), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 20: 
            localObject1 = String.format(ah.getContext().getString(2131301906), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 16: 
            localObject1 = String.format(ah.getContext().getString(2131301911), new Object[] { bo.bf(parambi.title, "") });
            break;
          case 8: 
            localObject1 = ah.getContext().getString(2131301912, new Object[] { bo.bf(parambi.title, "") });
            break;
          }
        }
        if (parambi.dxS())
        {
          localObject1 = ah.getContext().getString(2131301920);
          if (((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1543;
          }
          parambi = ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kt(parambi.field_imgPath);
          if (bo.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(parambi.Al())))
          {
            localObject1 = ah.getContext().getString(2131301920);
            label1195:
            localObject2 = new cwo();
            ((cwo)localObject2).wQr = parambi.Al();
            if (!parambi.isGif()) {
              break label1301;
            }
            ((cwo)localObject2).jKs = 1;
          }
        }
        try
        {
          for (;;)
          {
            localcxf.yeO = new com.tencent.mm.bv.b(((cwo)localObject2).toByteArray());
            label1243:
            localcxf.nqW = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Kx(parambi.Al()) + "]";
            break label1195;
            label1301:
            ((cwo)localObject2).jKs = 2;
          }
          if (parambi.bCp())
          {
            localObject1 = ah.getContext().getString(2131301932);
            break label98;
          }
          if ((!parambi.dxN()) && (!parambi.dxO()))
          {
            if (parambi.getType() == 64)
            {
              i = 1;
              label1355:
              if (i == 0) {
                break label1462;
              }
            }
          }
          else if (!parambi.field_content.equals(bi.yOb))
          {
            parambi = parambi.field_content;
            localObject1 = new ux();
            ((ux)localObject1).cLs.cut = 1;
            ((ux)localObject1).cLs.content = parambi;
            a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
            if (((ux)localObject1).cLt.type != 3) {
              break label1444;
            }
          }
          label1444:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1449;
            }
            localObject1 = ah.getContext().getString(2131301969);
            break;
            i = 0;
            break label1355;
          }
          label1449:
          localObject1 = ah.getContext().getString(2131301968);
          break label98;
          label1462:
          if (parambi.dxR())
          {
            aw.aaz();
            parambi = c.YC().Ty(parambi.field_content);
            localObject1 = String.format(ah.getContext().getString(2131301911), new Object[] { parambi.getDisplayName() });
            break label98;
          }
          localObject1 = localObject2;
          if (parambi.getType() != -1879048186) {
            break label98;
          }
          localObject1 = ah.getContext().getString(2131301901);
        }
        catch (IOException parambi)
        {
          break label1243;
        }
      }
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */