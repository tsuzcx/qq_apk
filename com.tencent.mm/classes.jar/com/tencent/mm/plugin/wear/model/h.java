package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.a.ww;
import com.tencent.mm.g.a.ww.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.drj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.a;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static boolean abE()
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
  
  public static boolean abF()
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
  
  public static byte[] ap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30024);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(30024);
    return paramBitmap;
  }
  
  public static final Bitmap auQ(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.exg().ew(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.ak.p.auq();
      paramString = com.tencent.mm.ak.e.J(paramString, false);
      ad.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = com.tencent.mm.ak.e.vY(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      ad.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String auR(String paramString)
  {
    AppMethodBeat.i(30022);
    az.arV();
    af localaf = c.apM().aHY(paramString);
    String str;
    if (w.pF(paramString))
    {
      str = aj.getContext().getString(2131757293);
      paramString = v.b(localaf, paramString);
      if ((localaf.field_username.equals(paramString)) || (bt.isNullOrNil(paramString))) {
        break label77;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = v.b(localaf, paramString);
      continue;
      label77:
      paramString = str;
    }
  }
  
  public static byte[] auS(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = i.aR(q.B(new com.tencent.mm.vfs.e(new com.tencent.mm.vfs.e(com.tencent.mm.loader.j.b.ahY(), "lib"), paramString).fhU()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static drj az(bl parambl)
  {
    AppMethodBeat.i(30023);
    drj localdrj = new drj();
    localdrj.CCn = parambl.field_msgId;
    localdrj.CCd = parambl.field_createTime;
    localdrj.saz = 1;
    localdrj.EGx = true;
    Object localObject2;
    Object localObject1;
    label98:
    int i;
    if (parambl.field_isSend == 1)
    {
      localdrj.Nickname = auR(u.aqG());
      localdrj.Egc = u.aqG();
      localObject2 = null;
      if (parambl.isSystem())
      {
        localObject1 = aj.getContext().getString(2131761727);
        localdrj.saz = 3;
        parambl = (bl)localObject1;
        if (localObject1 == null) {
          parambl = aj.getContext().getString(2131761720);
        }
        localdrj.gKr = parambl;
        AppMethodBeat.o(30023);
        return localdrj;
      }
    }
    else if (w.pF(parambl.field_talker))
    {
      localObject1 = parambl.field_talker;
      i = bi.uc(parambl.field_content);
      if (i == -1) {
        break label1546;
      }
      localObject2 = parambl.field_content.substring(0, i).trim();
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
        localdrj.Nickname = auR((String)localObject1);
        localdrj.Egc = ((String)localObject1);
        break;
        localdrj.Nickname = auR(parambl.field_talker);
        localdrj.Egc = parambl.field_talker;
        break;
        if (parambl.eJO())
        {
          localObject1 = aj.getContext().getString(2131761693);
          localdrj.saz = 4;
          break label98;
        }
        if (parambl.isText())
        {
          if ((w.pF(parambl.field_talker)) && (parambl.field_isSend != 1))
          {
            i = bi.uc(parambl.field_content);
            if (i != -1)
            {
              localObject1 = parambl.field_content.substring(i + 1).trim();
              break label98;
            }
            localObject1 = parambl.field_content;
            break label98;
          }
          localObject1 = parambl.field_content;
          break label98;
        }
        if (parambl.eJN())
        {
          localObject1 = aj.getContext().getString(2131761729);
          localdrj.saz = 6;
          localdrj.EGx = s.W(parambl);
          float f = s.mI(new com.tencent.mm.modelvoice.p(parambl.field_content).time);
          localdrj.EGy = new com.tencent.mm.bx.b(aj.getContext().getString(2131759570, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label98;
        }
        if (parambl.cjM())
        {
          localObject1 = aj.getContext().getString(2131761728);
          break label98;
        }
        if (parambl.cjO())
        {
          localObject1 = aj.getContext().getString(2131761719);
          break label98;
        }
        if (parambl.eLQ())
        {
          k.b localb = k.b.rx(parambl.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label98;
          }
          if (localb.gIO.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localdrj.saz = 5;
            if (parambl.field_isSend == 1)
            {
              localObject1 = localb.gII;
              break label98;
            }
            localObject1 = localb.gIH;
            break label98;
          }
          if (parambl.field_isSend == 1) {}
          for (parambl = localb.gII;; parambl = localb.gIH)
          {
            localObject1 = aj.getContext().getString(2131761672, new Object[] { parambl });
            break;
          }
        }
        if (parambl.eLR())
        {
          localObject1 = aj.getContext().getString(2131761671);
          localdrj.saz = 5;
          break label98;
        }
        if (parambl.cxB())
        {
          parambl = k.b.rx(parambl.field_content);
          localObject1 = localObject2;
          if (parambl == null) {
            break label98;
          }
          switch (parambl.type)
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
            localObject1 = String.format(aj.getContext().getString(2131761662), new Object[] { bt.by(parambl.title, "") });
            break;
          case 3: 
            localObject1 = String.format(aj.getContext().getString(2131761665), new Object[] { bt.by(parambl.title, "") });
            break;
          case 6: 
            localObject1 = String.format(aj.getContext().getString(2131761661), new Object[] { bt.by(parambl.title, "") });
            break;
          case 4: 
            localObject1 = String.format(aj.getContext().getString(2131761669), new Object[] { bt.by(parambl.title, "") });
            break;
          case 19: 
            localObject1 = String.format(aj.getContext().getString(2131761667), new Object[] { bt.by(parambl.title, "") });
            break;
          case 15: 
            localObject1 = String.format(aj.getContext().getString(2131761660), new Object[] { bt.by(parambl.title, "") });
            break;
          case 10: 
            localObject1 = String.format(aj.getContext().getString(2131761666), new Object[] { bt.by(parambl.title, "") });
            break;
          case 13: 
            localObject1 = String.format(aj.getContext().getString(2131761664), new Object[] { bt.by(parambl.title, "") });
            break;
          case 20: 
            localObject1 = String.format(aj.getContext().getString(2131761668), new Object[] { bt.by(parambl.title, "") });
            break;
          case 16: 
            localObject1 = String.format(aj.getContext().getString(2131761673), new Object[] { bt.by(parambl.title, "") });
            break;
          case 8: 
            localObject1 = aj.getContext().getString(2131761674, new Object[] { bt.by(parambl.title, "") });
            break;
          }
        }
        if (parambl.eLY())
        {
          localObject1 = aj.getContext().getString(2131761682);
          if (((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1543;
          }
          parambl = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Tz(parambl.field_imgPath);
          if (bt.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(parambl.JS())))
          {
            localObject1 = aj.getContext().getString(2131761682);
            label1195:
            localObject2 = new dqs();
            ((dqs)localObject2).MD5 = parambl.JS();
            if (!parambl.isGif()) {
              break label1301;
            }
            ((dqs)localObject2).mBH = 1;
          }
        }
        try
        {
          for (;;)
          {
            localdrj.EGy = new com.tencent.mm.bx.b(((dqs)localObject2).toByteArray());
            label1243:
            localdrj.saz = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().TD(parambl.JS()) + "]";
            break label1195;
            label1301:
            ((dqs)localObject2).mBH = 2;
          }
          if (parambl.cxD())
          {
            localObject1 = aj.getContext().getString(2131761694);
            break label98;
          }
          if ((!parambl.eLT()) && (!parambl.eLU()))
          {
            if (parambl.getType() == 64)
            {
              i = 1;
              label1355:
              if (i == 0) {
                break label1462;
              }
            }
          }
          else if (!parambl.field_content.equals(bl.FzM))
          {
            parambl = parambl.field_content;
            localObject1 = new ww();
            ((ww)localObject1).dCp.djq = 1;
            ((ww)localObject1).dCp.content = parambl;
            a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
            if (((ww)localObject1).dCq.type != 3) {
              break label1444;
            }
          }
          label1444:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1449;
            }
            localObject1 = aj.getContext().getString(2131761733);
            break;
            i = 0;
            break label1355;
          }
          label1449:
          localObject1 = aj.getContext().getString(2131761732);
          break label98;
          label1462:
          if (parambl.eLX())
          {
            az.arV();
            parambl = c.apO().agC(parambl.field_content);
            localObject1 = String.format(aj.getContext().getString(2131761673), new Object[] { parambl.getDisplayName() });
            break label98;
          }
          localObject1 = localObject2;
          if (parambl.getType() != -1879048186) {
            break label98;
          }
          localObject1 = aj.getContext().getString(2131761663);
        }
        catch (IOException parambl)
        {
          break label1243;
        }
      }
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */