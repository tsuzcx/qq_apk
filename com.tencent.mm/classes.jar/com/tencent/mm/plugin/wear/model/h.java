package com.tencent.mm.plugin.wear.model;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.aj.e;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.g.a.zj.b;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.j.a;
import com.tencent.mm.protocal.protobuf.eyi;
import com.tencent.mm.protocal.protobuf.eyz;
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
import com.tencent.mm.vfs.o;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public final class h
{
  public static byte[] aF(Bitmap paramBitmap)
  {
    AppMethodBeat.i(30024);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    AppMethodBeat.o(30024);
    return paramBitmap;
  }
  
  public static eyz aP(ca paramca)
  {
    AppMethodBeat.i(30023);
    eyz localeyz = new eyz();
    localeyz.KMm = paramca.field_msgId;
    localeyz.KMc = paramca.field_createTime;
    localeyz.xKb = 1;
    localeyz.NvA = true;
    Object localObject2;
    Object localObject1;
    label97:
    int i;
    if (paramca.field_isSend == 1)
    {
      localeyz.Nickname = aWo(z.aTY());
      localeyz.MRZ = z.aTY();
      localObject2 = null;
      if (paramca.isSystem())
      {
        localObject1 = MMApplicationContext.getContext().getString(2131763695);
        localeyz.xKb = 3;
        paramca = (ca)localObject1;
        if (localObject1 == null) {
          paramca = MMApplicationContext.getContext().getString(2131763688);
        }
        localeyz.iAc = paramca;
        AppMethodBeat.o(30023);
        return localeyz;
      }
    }
    else if (ab.Eq(paramca.field_talker))
    {
      localObject1 = paramca.field_talker;
      i = bp.Kp(paramca.field_content);
      if (i == -1) {
        break label1523;
      }
      localObject2 = paramca.field_content.substring(0, i).trim();
      if ((localObject2 == null) || (((String)localObject2).length() <= 0)) {
        break label1523;
      }
      localObject1 = localObject2;
    }
    label1172:
    label1220:
    label1520:
    label1523:
    for (;;)
    {
      for (;;)
      {
        localeyz.Nickname = aWo((String)localObject1);
        localeyz.MRZ = ((String)localObject1);
        break;
        localeyz.Nickname = aWo(paramca.field_talker);
        localeyz.MRZ = paramca.field_talker;
        break;
        if (paramca.gAz())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763661);
          localeyz.xKb = 4;
          break label97;
        }
        if (paramca.isText())
        {
          if ((ab.Eq(paramca.field_talker)) && (paramca.field_isSend != 1))
          {
            i = bp.Kp(paramca.field_content);
            if (i != -1)
            {
              localObject1 = paramca.field_content.substring(i + 1).trim();
              break label97;
            }
            localObject1 = paramca.field_content;
            break label97;
          }
          localObject1 = paramca.field_content;
          break label97;
        }
        if (paramca.gAy())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763697);
          localeyz.xKb = 6;
          localeyz.NvA = com.tencent.mm.modelvoice.s.ai(paramca);
          float f = com.tencent.mm.modelvoice.s.AO(new com.tencent.mm.modelvoice.p(paramca.field_content).time);
          localeyz.NvB = new com.tencent.mm.bw.b(MMApplicationContext.getContext().getString(2131760887, new Object[] { Integer.valueOf((int)f) }).getBytes());
          break label97;
        }
        if (paramca.cWJ())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763696);
          break label97;
        }
        if (paramca.cWL())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763687);
          break label97;
        }
        if (paramca.gDe())
        {
          k.b localb = k.b.HD(paramca.field_content);
          localObject1 = localObject2;
          if (localb == null) {
            break label97;
          }
          if (localb.iyr.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            localeyz.xKb = 5;
            if (paramca.field_isSend == 1)
            {
              localObject1 = localb.iyl;
              break label97;
            }
            localObject1 = localb.iyk;
            break label97;
          }
          if (paramca.field_isSend == 1) {}
          for (paramca = localb.iyl;; paramca = localb.iyk)
          {
            localObject1 = MMApplicationContext.getContext().getString(2131763640, new Object[] { paramca });
            break;
          }
        }
        if (paramca.gDf())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763639);
          localeyz.xKb = 5;
          break label97;
        }
        if (paramca.dOQ())
        {
          paramca = k.b.HD(paramca.field_content);
          localObject1 = localObject2;
          if (paramca == null) {
            break label97;
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
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763661), new Object[0]);
            break;
          case 5: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763630), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 3: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763633), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 6: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763629), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 4: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763637), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 19: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763635), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 15: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763628), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 10: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763634), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 13: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763632), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 20: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763636), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 16: 
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763641), new Object[] { Util.nullAs(paramca.title, "") });
            break;
          case 8: 
            localObject1 = MMApplicationContext.getContext().getString(2131763642, new Object[] { Util.nullAs(paramca.title, "") });
            break;
          }
        }
        if (paramca.gDn())
        {
          localObject1 = MMApplicationContext.getContext().getString(2131763650);
          if (((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr() == null) {
            break label1520;
          }
          paramca = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramca.field_imgPath);
          if (Util.isNullOrNil(((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramca.getMd5())))
          {
            localObject1 = MMApplicationContext.getContext().getString(2131763650);
            localObject2 = new eyi();
            ((eyi)localObject2).MD5 = paramca.getMd5();
            if (!paramca.isGif()) {
              break label1278;
            }
            ((eyi)localObject2).oUv = 1;
          }
        }
        try
        {
          for (;;)
          {
            localeyz.NvB = new com.tencent.mm.bw.b(((eyi)localObject2).toByteArray());
            localeyz.xKb = 2;
            break;
            localObject1 = "[" + ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().amp(paramca.getMd5()) + "]";
            break label1172;
            label1278:
            ((eyi)localObject2).oUv = 2;
          }
          if (paramca.dOS())
          {
            localObject1 = MMApplicationContext.getContext().getString(2131763662);
            break label97;
          }
          if ((!paramca.gDh()) && (!paramca.gDi()))
          {
            if (paramca.getType() == 64)
            {
              i = 1;
              if (i == 0) {
                break label1439;
              }
            }
          }
          else if (!paramca.field_content.equals(ca.OqB))
          {
            paramca = paramca.field_content;
            localObject1 = new zj();
            ((zj)localObject1).efx.dKy = 1;
            ((zj)localObject1).efx.content = paramca;
            EventCenter.instance.publish((IEvent)localObject1);
            if (((zj)localObject1).efy.type != 3) {
              break label1421;
            }
          }
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label1426;
            }
            localObject1 = MMApplicationContext.getContext().getString(2131763701);
            break;
            i = 0;
            break label1332;
          }
          localObject1 = MMApplicationContext.getContext().getString(2131763700);
          break label97;
          if (paramca.gDl())
          {
            bg.aVF();
            paramca = c.aSQ().aEK(paramca.field_content);
            localObject1 = String.format(MMApplicationContext.getContext().getString(2131763641), new Object[] { paramca.getDisplayName() });
            break label97;
          }
          localObject1 = localObject2;
          if (paramca.getType() != -1879048186) {
            break label97;
          }
          localObject1 = MMApplicationContext.getContext().getString(2131763631);
        }
        catch (IOException paramca)
        {
          break label1220;
        }
      }
      break label97;
    }
  }
  
  public static final Bitmap aWn(String paramString)
  {
    AppMethodBeat.i(30021);
    Bitmap localBitmap = a.b.gov().fZ(paramString);
    if (localBitmap == null)
    {
      com.tencent.mm.aj.p.aYn();
      paramString = e.M(paramString, false);
      Log.d("MicroMsg.Wear.WearUtil", "avatar fullpath: %s", new Object[] { paramString });
    }
    for (paramString = e.Mq(paramString);; paramString = localBitmap)
    {
      AppMethodBeat.o(30021);
      return paramString;
      Log.d("MicroMsg.Wear.WearUtil", "get wear avatar from cache: %s", new Object[] { paramString });
    }
  }
  
  public static String aWo(String paramString)
  {
    AppMethodBeat.i(30022);
    bg.aVF();
    as localas = c.aSN().Kn(paramString);
    String str;
    if (ab.Eq(paramString))
    {
      str = MMApplicationContext.getContext().getString(2131757507);
      paramString = com.tencent.mm.model.aa.b(localas, paramString);
      if ((localas.field_username.equals(paramString)) || (Util.isNullOrNil(paramString))) {
        break label78;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(30022);
      return paramString;
      paramString = com.tencent.mm.model.aa.b(localas, paramString);
      continue;
      label78:
      paramString = str;
    }
  }
  
  public static byte[] aWp(String paramString)
  {
    AppMethodBeat.i(30027);
    paramString = "lib" + paramString + ".so";
    paramString = com.tencent.mm.vfs.s.aW(com.tencent.mm.vfs.aa.z(new o(new o(com.tencent.mm.loader.j.b.aKA(), "lib"), paramString).her()), 0, -1);
    AppMethodBeat.o(30027);
    return paramString;
  }
  
  public static boolean avj()
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
  
  public static boolean avk()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.h
 * JD-Core Version:    0.7.0.1
 */