package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.av.f;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.agv;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.agz;
import com.tencent.mm.protocal.protobuf.ahe;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bo.b;
import com.tencent.mm.vfs.i;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaMiniProgram;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
{
  private static String Kgq = null;
  
  private static WWMediaMergedConvs a(agx paramagx, bo parambo, com.tencent.mm.storage.ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramagx == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramagx = com.tencent.mm.plugin.record.b.n.aqs(paramagx.EAp);
    if (paramagx == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramagx.title;
    Iterator localIterator = paramagx.hkS.iterator();
    if (localIterator.hasNext())
    {
      agx localagx = (agx)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramagx = localagx.EAb;
      if (bs.isNullOrNil(localagx.EAA)) {
        localWWMediaConversation.name = paramagx;
      }
      for (;;)
      {
        try
        {
          paramagx = localagx.EzZ.EAG;
          if (!paramagx.EBf) {
            continue;
          }
          paramagx = paramagx.dng;
          paramagx = com.tencent.mm.aj.c.a(paramagx, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramagx.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.Kyp = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramagx)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localagx.EAd).getTime();
          l1 = l2;
        }
        catch (ParseException paramagx)
        {
          continue;
        }
        localWWMediaConversation.wTQ = l1;
        localWWMediaConversation.Kyq = a(paramai, localagx, parambo, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramagx + localagx.EAA);
        continue;
        if (paramagx.EBk) {
          paramagx = paramagx.EBj;
        } else {
          paramagx = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(bo parambo, com.tencent.mm.storage.ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = parambo.field_content;
    if (w.sQ(parambo.field_talker)) {
      localObject1 = bi.ym(parambo.field_content);
    }
    localObject1 = k.b.vA((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = com.tencent.mm.plugin.record.b.n.aqs(((k.b)localObject1).hij);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).hkS.iterator();
      if (localIterator.hasNext())
      {
        agx localagx = (agx)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localagx.EAb;
        if (bs.isNullOrNil(localagx.EAA)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localagx.EzZ.EAG;
            if (!((agz)localObject1).EBf) {
              continue;
            }
            localObject1 = ((agz)localObject1).dng;
            localObject1 = com.tencent.mm.aj.c.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.Kyp = localByteArrayOutputStream.toByteArray();
            localByteArrayOutputStream.close();
          }
          catch (Exception localException)
          {
            long l1;
            continue;
          }
          l1 = 0L;
          try
          {
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localagx.EAd).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.wTQ = l1;
          localWWMediaConversation.Kyq = a(paramai, localagx, parambo, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localagx.EAA);
          continue;
          if (((agz)localObject1).EBk) {
            localObject1 = ((agz)localObject1).EBj;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.ai paramai, agx paramagx, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramagx.dataType;
    if (i == 1)
    {
      paramai = new WWMediaText(paramagx.desc);
      AppMethodBeat.o(34923);
      return paramai;
    }
    if (i == 2)
    {
      long l = parambo.field_msgId;
      if (!com.tencent.mm.compatible.util.e.YD()) {
        paramagx = null;
      }
      while (bs.isNullOrNil(paramagx))
      {
        ac.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        parambo = com.tencent.mm.plugin.record.b.n.c(paramagx, l);
        paramai = parambo;
        if (bs.isNullOrNil(parambo)) {
          paramai = com.tencent.mm.plugin.record.b.n.f(paramagx, l);
        }
        if (!bs.isNullOrNil(paramai))
        {
          paramagx = paramai;
          if (i.eA(paramai)) {}
        }
        else
        {
          ac.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramai });
          paramagx = null;
        }
      }
      paramai = new WWMediaImage();
      paramai.filePath = aXK(paramagx);
      ac.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramai.filePath });
      AppMethodBeat.o(34923);
      return paramai;
    }
    if (i == 4)
    {
      paramai = com.tencent.mm.plugin.record.b.n.c(paramagx, parambo.field_msgId);
      if ((bs.isNullOrNil(paramai)) || (!com.tencent.mm.pluginsdk.h.a.d.a.eA(paramai)))
      {
        ac.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramagx = new WWMediaVideo();
      paramagx.filePath = aXK(paramai);
      ac.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramagx.filePath });
      AppMethodBeat.o(34923);
      return paramagx;
    }
    if (i == 6)
    {
      paramai = new WWMediaLocation();
      if (paramagx.EzZ == null)
      {
        ac.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      parambo = paramagx.EzZ.EAI;
      if (parambo == null)
      {
        ac.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramagx.dhw });
        AppMethodBeat.o(34923);
        return null;
      }
      paramai.title = parambo.dry;
      paramai.hEt = parambo.label;
      paramai.longitude = parambo.lng;
      paramai.latitude = parambo.lat;
      paramai.Kyr = parambo.dmN;
      AppMethodBeat.o(34923);
      return paramai;
    }
    if (i == 8)
    {
      paramai = com.tencent.mm.plugin.record.b.n.c(paramagx, parambo.field_msgId);
      if (bs.isNullOrNil(paramai))
      {
        ac.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramagx.dhw });
        AppMethodBeat.o(34923);
        return null;
      }
      if (com.tencent.mm.pluginsdk.h.a.d.a.fD(paramai) > 104857600L)
      {
        paramai = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramai;
      }
      parambo = new WWMediaFile();
      parambo.fileName = paramagx.title;
      parambo.filePath = aXK(paramai);
      parambo.fIM();
      AppMethodBeat.o(34923);
      return parambo;
    }
    if (i == 17)
    {
      paramai = a(paramagx, parambo, paramai, paramBoolean);
      AppMethodBeat.o(34923);
      return paramai;
    }
    if (i == 19)
    {
      paramai = paramagx.EzZ.EAX;
      paramagx = new WWMediaMiniProgram();
      paramagx.username = paramai.username;
      paramagx.path = paramai.cYQ;
      paramagx.iconUrl = paramai.iconUrl;
      paramagx.Kyt = new byte[1];
      paramagx.name = paramai.EyV;
      paramagx.title = "";
      paramagx.type = paramai.type;
      ac.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramagx.username, paramagx.path, paramagx.iconUrl, Integer.valueOf(paramagx.Kyt.length), paramagx.name, paramagx.title });
      AppMethodBeat.o(34923);
      return paramagx;
    }
    ac.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.ai paramai, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34922);
    int i = parambo.getType();
    if (i == 1)
    {
      paramai = new WWMediaText(j.x(parambo.field_content, parambo.field_isSend, paramBoolean));
      AppMethodBeat.o(34922);
      return paramai;
    }
    if (i == 3)
    {
      paramai = bx(parambo);
      AppMethodBeat.o(34922);
      return paramai;
    }
    if (i == 43)
    {
      paramai = new WWMediaVideo();
      parambo = com.tencent.mm.modelvideo.u.Ej(parambo.field_imgPath);
      com.tencent.mm.modelvideo.o.aJy();
      paramai.filePath = aXK(t.DV(parambo.getFileName()));
      ac.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramai.filePath });
      AppMethodBeat.o(34922);
      return paramai;
    }
    if (i == 48)
    {
      paramai = new WWMediaLocation();
      parambo = j.x(parambo.field_content, parambo.field_isSend, paramBoolean);
      az.ayM();
      parambo = com.tencent.mm.model.c.awD().alx(parambo);
      paramai.title = parambo.gPy;
      paramai.hEt = parambo.label;
      paramai.longitude = parambo.tWJ;
      paramai.latitude = parambo.tWI;
      paramai.Kyr = parambo.dmN;
      AppMethodBeat.o(34922);
      return paramai;
    }
    if ((i == 49) || (i == 268435505))
    {
      paramai = b(paramai, parambo, paramBoolean);
      AppMethodBeat.o(34922);
      return paramai;
    }
    ac.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34922);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.ai paramai, List<bo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34924);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramai.field_username;
    Object localObject1 = com.tencent.mm.sdk.platformtools.ai.getContext();
    if (paramBoolean) {
      localObject1 = ((Context)localObject1).getString(2131762236);
    }
    for (;;)
    {
      localWWMediaMergedConvs.title = ((String)localObject1);
      localObject1 = paramList.iterator();
      label50:
      Object localObject2;
      label92:
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (bo)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((dy)localObject2).field_isSend == 1)
        {
          paramList = com.tencent.mm.model.u.axw();
          localObject4 = com.tencent.mm.openim.room.a.a.H(((k)com.tencent.mm.kernel.g.ab(k.class)).awB().aNt(paramList));
          ((WWMediaConversation)localObject3).name = (v.wj(paramList) + bs.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.aj.c.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).Kyp = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label191:
        ((WWMediaConversation)localObject3).wTQ = ((dy)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).Kyq = a(paramai, (bo)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label50;
        localObject2 = com.tencent.mm.model.u.axy();
        localObject3 = v.wj((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(2131758964, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(2131758963, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((dy)localObject2).field_talker;
          break label92;
        }
        paramList = bi.yl(((dy)localObject2).field_content);
        break label92;
        AppMethodBeat.o(34924);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramList)
      {
        break label191;
      }
    }
  }
  
  private static void a(Context paramContext, com.tencent.mm.storage.ai paramai, List<bo> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34921);
    IWWAPI localIWWAPI = WWAPIFactory.lg(paramContext);
    try
    {
      if (paramList.size() == 1) {}
      for (paramai = a(paramai, (bo)paramList.get(0), paramBoolean);; paramai = a(paramai, paramList, paramBoolean))
      {
        localIWWAPI.a(paramai);
        AppMethodBeat.o(34921);
        return;
      }
      return;
    }
    catch (a paramai)
    {
      com.tencent.mm.ui.base.h.l(paramContext, 2131763074, 2131755906);
      AppMethodBeat.o(34921);
    }
  }
  
  private static String aXK(String paramString)
  {
    AppMethodBeat.i(210132);
    if ((!bs.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (Kgq == null) {
          Kgq = new File(b.apc()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = Kgq + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (i.eA((String)localObject)) {
          i.deleteFile((String)localObject);
        }
        if (!i.eA(str)) {
          i.aSh(str);
        }
        com.tencent.mm.sdk.platformtools.o.C(paramString, (String)localObject, false);
        ac.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, bs.eWi().toString() });
        AppMethodBeat.o(210132);
        return localObject;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(210132);
    return paramString;
  }
  
  private static WWMediaMessage.WWMediaObject b(com.tencent.mm.storage.ai paramai, bo parambo, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject2 = parambo.field_content;
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      int i = parambo.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambo.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.az((String)localObject1, parambo.field_reserved);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(34926);
        return null;
      }
      switch (((k.b)localObject1).type)
      {
      default: 
        AppMethodBeat.o(34926);
        return null;
      case 5: 
        paramai = new WWMediaLink();
        paramai.webpageUrl = ((k.b)localObject1).url;
        paramai.title = ((k.b)localObject1).title;
        paramai.description = ((k.b)localObject1).description;
        paramai.setThumbImage(com.tencent.mm.av.o.aFx().a(parambo.field_imgPath, com.tencent.mm.cc.a.getDensity(null), false));
      }
      try
      {
        parambo = com.tencent.mm.av.o.aFx().a(parambo.field_imgPath, com.tencent.mm.cc.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        parambo.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramai.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paramai;
        if ((((k.b)localObject1).cZa != null) && (((k.b)localObject1).cZa.length() > 0))
        {
          paramai = ap.bEO().aGd(((k.b)localObject1).cZa);
          if ((paramai != null) && (paramai.cOg()))
          {
            paramai = paramai.field_fileFullPath;
            if (!i.eA(paramai))
            {
              ac.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramai, Long.valueOf(parambo.field_msgId), Long.valueOf(parambo.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            parambo = new WWMediaImage();
            parambo.filePath = aXK(paramai);
            ac.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambo.filePath });
            AppMethodBeat.o(34926);
            return parambo;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.aGn(((k.b)localObject1).cZa);
        paramai = (com.tencent.mm.storage.ai)localObject2;
        if (localObject2 == null) {
          paramai = ap.bEO().zM(parambo.field_msgId);
        }
        if (paramai.field_totalLen > 104857600L)
        {
          paramai = new a((byte)0);
          AppMethodBeat.o(34926);
          throw paramai;
        }
        parambo = new WWMediaFile();
        parambo.fileName = ((k.b)localObject1).title;
        parambo.filePath = aXK(paramai.field_fileFullPath);
        parambo.fIM();
        AppMethodBeat.o(34926);
        return parambo;
        paramai = a(parambo, paramai, paramBoolean);
        AppMethodBeat.o(34926);
        return paramai;
        if (((k.b)localObject1).hkg == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paramai = new WWMediaMiniProgram();
        paramai.username = ((k.b)localObject1).hke;
        paramai.path = ((k.b)localObject1).hkd;
        paramai.iconUrl = ((k.b)localObject1).hks;
        parambo = com.tencent.mm.av.o.aFx().b(parambo.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.h.a.d.a.eA(parambo)) {}
        for (;;)
        {
          try
          {
            parambo = com.tencent.mm.plugin.gallery.model.n.agt(parambo);
            localObject2 = new ByteArrayOutputStream();
            parambo.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramai.Kyt = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramai.Kyt.length > 1048576)
            {
              ac.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramai.Kyt = new byte[1];
            }
            paramai.name = ((k.b)localObject1).dvm;
            paramai.title = ((k.b)localObject1).title;
            paramai.type = ((k.b)localObject1).hkg;
            ac.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramai.username, paramai.path, paramai.iconUrl, Integer.valueOf(paramai.Kyt.length), paramai.name, paramai.title });
            AppMethodBeat.o(34926);
            return paramai;
          }
          catch (Exception parambo)
          {
            ac.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { parambo.getMessage() });
          }
          paramai.Kyt = new byte[1];
        }
      }
      catch (Exception parambo)
      {
        break label249;
      }
    }
  }
  
  public static void b(Context paramContext, final com.tencent.mm.storage.ai paramai, final List<bo> paramList, final boolean paramBoolean)
  {
    AppMethodBeat.i(210131);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(210131);
      return;
    }
    if (j.hJ(paramList))
    {
      ac.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757940), "", new am.1(), null);
      AppMethodBeat.o(210131);
      return;
    }
    if (!j.a(true, paramList, paramai.field_username, null))
    {
      ac.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      com.tencent.mm.ui.base.h.d(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131762559), paramContext.getString(2131755691), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34920);
          am.c(this.val$context, paramai, paramList, paramBoolean);
          AppMethodBeat.o(34920);
        }
      }, null);
      AppMethodBeat.o(210131);
      return;
    }
    a(paramContext, paramai, paramList, paramBoolean);
    AppMethodBeat.o(210131);
  }
  
  private static WWMediaMessage.WWMediaObject bx(bo parambo)
  {
    AppMethodBeat.i(34925);
    if (parambo.field_msgId > 0L) {}
    for (Object localObject1 = com.tencent.mm.av.o.aFx().qg(parambo.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.e)localObject1).dcd > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambo.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.av.o.aFx().qf(parambo.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      parambo = com.tencent.mm.av.o.aFx().p(f.c((com.tencent.mm.av.e)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = aXK(parambo);
      ac.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  public static boolean lL(Context paramContext)
  {
    AppMethodBeat.i(210129);
    boolean bool = WWAPIFactory.lg(paramContext).fIK();
    AppMethodBeat.o(210129);
    return bool;
  }
  
  public static String lM(Context paramContext)
  {
    AppMethodBeat.i(210130);
    paramContext = WWAPIFactory.lg(paramContext).fIL();
    AppMethodBeat.o(210130);
    return paramContext;
  }
  
  static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */