package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.gallery.model.k;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.protobuf.aby;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.acc;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
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
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
{
  private static WWMediaMergedConvs a(aca paramaca, bi parambi, ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(31041);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramaca == null)
    {
      AppMethodBeat.o(31041);
      return localWWMediaMergedConvs;
    }
    paramaca = n.XS(paramaca.wTM);
    if (paramaca == null)
    {
      AppMethodBeat.o(31041);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramaca.title;
    Iterator localIterator = paramaca.fjy.iterator();
    if (localIterator.hasNext())
    {
      aca localaca = (aca)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramaca = localaca.wTy;
      if (bo.isNullOrNil(localaca.wTX)) {
        localWWMediaConversation.name = paramaca;
      }
      for (;;)
      {
        try
        {
          paramaca = localaca.wTw.wUb;
          if (!paramaca.wUw) {
            continue;
          }
          paramaca = paramaca.czp;
          paramaca = com.tencent.mm.ah.b.b(paramaca, false, -1);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramaca.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.BCJ = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramaca)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localaca.wTA).getTime();
          l1 = l2;
        }
        catch (ParseException paramaca)
        {
          continue;
        }
        localWWMediaConversation.qsy = l1;
        localWWMediaConversation.BCK = a(paramad, localaca, parambi, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramaca + localaca.wTX);
        continue;
        if (paramaca.wUB) {
          paramaca = paramaca.wUA;
        } else {
          paramaca = "";
        }
      }
    }
    AppMethodBeat.o(31041);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(bi parambi, ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(31042);
    Object localObject1 = parambi.field_content;
    if (com.tencent.mm.model.t.lA(parambi.field_talker)) {
      localObject1 = bf.pv(parambi.field_content);
    }
    localObject1 = j.b.mY((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = n.XS(((j.b)localObject1).fhc);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(31042);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).fjy.iterator();
      if (localIterator.hasNext())
      {
        aca localaca = (aca)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localaca.wTy;
        if (bo.isNullOrNil(localaca.wTX)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localaca.wTw.wUb;
            if (!((acc)localObject1).wUw) {
              continue;
            }
            localObject1 = ((acc)localObject1).czp;
            localObject1 = com.tencent.mm.ah.b.b((String)localObject1, false, -1);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.BCJ = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localaca.wTA).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.qsy = l1;
          localWWMediaConversation.BCK = a(paramad, localaca, parambi, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localaca.wTX);
          continue;
          if (((acc)localObject1).wUB) {
            localObject1 = ((acc)localObject1).wUA;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(31042);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(ad paramad, aca paramaca, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31037);
    int i = paramaca.dataType;
    if (i == 1)
    {
      paramad = new WWMediaText(paramaca.desc);
      AppMethodBeat.o(31037);
      return paramad;
    }
    if (i == 2)
    {
      long l = parambi.field_msgId;
      if (!com.tencent.mm.compatible.util.f.Mi()) {
        paramaca = null;
      }
      while (bo.isNullOrNil(paramaca))
      {
        ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(31037);
        return null;
        parambi = n.c(paramaca, l);
        paramad = parambi;
        if (bo.isNullOrNil(parambi)) {
          paramad = n.f(paramaca, l);
        }
        if (!bo.isNullOrNil(paramad))
        {
          paramaca = paramad;
          if (com.tencent.mm.a.e.cN(paramad)) {}
        }
        else
        {
          ab.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramad });
          paramaca = null;
        }
      }
      paramad = new WWMediaImage();
      paramad.filePath = paramaca;
      ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramad.filePath });
      AppMethodBeat.o(31037);
      return paramad;
    }
    if (i == 4)
    {
      paramad = n.c(paramaca, parambi.field_msgId);
      if ((bo.isNullOrNil(paramad)) || (!com.tencent.mm.pluginsdk.g.a.d.a.cN(paramad)))
      {
        ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(31037);
        return null;
      }
      paramaca = new WWMediaVideo();
      paramaca.filePath = paramad;
      ab.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramaca.filePath });
      AppMethodBeat.o(31037);
      return paramaca;
    }
    if (i == 6)
    {
      paramad = new WWMediaLocation();
      if (paramaca.wTw == null)
      {
        ab.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(31037);
        return null;
      }
      parambi = paramaca.wTw.wUd;
      if (parambi == null)
      {
        ab.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramaca.mBq });
        AppMethodBeat.o(31037);
        return null;
      }
      paramad.title = parambi.cDl;
      paramad.fBq = parambi.label;
      paramad.longitude = parambi.lng;
      paramad.latitude = parambi.lat;
      paramad.BCL = parambi.cyX;
      AppMethodBeat.o(31037);
      return paramad;
    }
    if (i == 8)
    {
      paramad = n.c(paramaca, parambi.field_msgId);
      if (bo.isNullOrNil(paramad))
      {
        ab.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramaca.mBq });
        AppMethodBeat.o(31037);
        return null;
      }
      if (com.tencent.mm.pluginsdk.g.a.d.a.eG(paramad) > 104857600L)
      {
        paramad = new am.a((byte)0);
        AppMethodBeat.o(31037);
        throw paramad;
      }
      parambi = new WWMediaFile();
      parambi.fileName = paramaca.title;
      parambi.filePath = paramad;
      parambi.dYa();
      AppMethodBeat.o(31037);
      return parambi;
    }
    if (i == 17)
    {
      paramad = a(paramaca, parambi, paramad, paramBoolean);
      AppMethodBeat.o(31037);
      return paramad;
    }
    if (i == 19)
    {
      paramad = paramaca.wTw.wUs;
      paramaca = new WWMediaMiniProgram();
      paramaca.username = paramad.username;
      paramaca.path = paramad.cmG;
      paramaca.iconUrl = paramad.iconUrl;
      paramaca.BCN = new byte[1];
      paramaca.name = paramad.wSs;
      paramaca.title = "";
      ab.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramaca.username, paramaca.path, paramaca.iconUrl, Integer.valueOf(paramaca.BCN.length), paramaca.name, paramaca.title });
      AppMethodBeat.o(31037);
      return paramaca;
    }
    ab.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(31037);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(ad paramad, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31036);
    int i = parambi.getType();
    if (i == 1)
    {
      paramad = new WWMediaText(j.v(parambi.field_content, parambi.field_isSend, paramBoolean));
      AppMethodBeat.o(31036);
      return paramad;
    }
    if (i == 3)
    {
      paramad = ba(parambi);
      AppMethodBeat.o(31036);
      return paramad;
    }
    if (i == 43)
    {
      paramad = new WWMediaVideo();
      parambi = u.vr(parambi.field_imgPath);
      com.tencent.mm.modelvideo.o.alE();
      paramad.filePath = com.tencent.mm.modelvideo.t.vf(parambi.getFileName());
      ab.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramad.filePath });
      AppMethodBeat.o(31036);
      return paramad;
    }
    if (i == 48)
    {
      paramad = new WWMediaLocation();
      parambi = j.v(parambi.field_content, parambi.field_isSend, paramBoolean);
      aw.aaz();
      parambi = com.tencent.mm.model.c.YC().Tz(parambi);
      paramad.title = parambi.eSM;
      paramad.fBq = parambi.label;
      paramad.longitude = parambi.nZW;
      paramad.latitude = parambi.nZV;
      paramad.BCL = parambi.cyX;
      AppMethodBeat.o(31036);
      return paramad;
    }
    if ((i == 49) || (i == 268435505))
    {
      paramad = b(paramad, parambi, paramBoolean);
      AppMethodBeat.o(31036);
      return paramad;
    }
    ab.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(31036);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(ad paramad, List<bi> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(31038);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramad.field_username;
    Object localObject1 = ah.getContext();
    if (paramBoolean) {
      localObject1 = ((Context)localObject1).getString(2131302353);
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
        localObject2 = (bi)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((dd)localObject2).field_isSend == 1)
        {
          paramList = r.Zn();
          localObject4 = com.tencent.mm.openim.room.a.a.A(((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramList));
          ((WWMediaConversation)localObject3).name = (com.tencent.mm.model.s.nD(paramList) + bo.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.ah.b.b(paramList, false, -1);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).BCJ = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label190:
        ((WWMediaConversation)localObject3).qsy = ((dd)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).BCK = a(paramad, (bi)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label50;
        localObject2 = r.Zp();
        localObject3 = com.tencent.mm.model.s.nD((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(2131299790, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(2131299789, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((dd)localObject2).field_talker;
          break label92;
        }
        paramList = bf.pu(((dd)localObject2).field_content);
        break label92;
        AppMethodBeat.o(31038);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramList)
      {
        break label190;
      }
    }
  }
  
  public static void a(Context paramContext, ad paramad, List<bi> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(31035);
    IWWAPI localIWWAPI = WWAPIFactory.jO(paramContext);
    try
    {
      if (paramList.size() == 1) {}
      for (paramad = a(paramad, (bi)paramList.get(0), paramBoolean);; paramad = a(paramad, paramList, paramBoolean))
      {
        localIWWAPI.a(paramad);
        AppMethodBeat.o(31035);
        return;
      }
      return;
    }
    catch (am.a paramad)
    {
      com.tencent.mm.ui.base.h.h(paramContext, 2131303125, 2131297087);
      AppMethodBeat.o(31035);
    }
  }
  
  private static WWMediaMessage.WWMediaObject b(ad paramad, bi parambi, boolean paramBoolean)
  {
    AppMethodBeat.i(31040);
    Object localObject2 = parambi.field_content;
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      int i = parambi.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambi.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = j.b.ab((String)localObject1, parambi.field_reserved);; localObject1 = null)
    {
      if (localObject1 == null)
      {
        AppMethodBeat.o(31040);
        return null;
      }
      switch (((j.b)localObject1).type)
      {
      default: 
        AppMethodBeat.o(31040);
        return null;
      case 5: 
        paramad = new WWMediaLink();
        paramad.webpageUrl = ((j.b)localObject1).url;
        paramad.title = ((j.b)localObject1).title;
        paramad.description = ((j.b)localObject1).description;
        paramad.setThumbImage(com.tencent.mm.at.o.ahC().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false));
      }
      try
      {
        parambi = com.tencent.mm.at.o.ahC().a(parambi.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        parambi.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramad.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(31040);
        return paramad;
        if ((((j.b)localObject1).cmN != null) && (((j.b)localObject1).cmN.length() > 0))
        {
          paramad = al.aUJ().alo(((j.b)localObject1).cmN);
          if ((paramad != null) && (paramad.bEL()))
          {
            paramad = paramad.field_fileFullPath;
            if (!com.tencent.mm.vfs.e.cN(paramad))
            {
              ab.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramad, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
              AppMethodBeat.o(31040);
              return null;
            }
            parambi = new WWMediaImage();
            parambi.filePath = paramad;
            ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambi.filePath });
            AppMethodBeat.o(31040);
            return parambi;
          }
        }
        AppMethodBeat.o(31040);
        return null;
        localObject2 = l.alv(((j.b)localObject1).cmN);
        paramad = (ad)localObject2;
        if (localObject2 == null) {
          paramad = al.aUJ().nw(parambi.field_msgId);
        }
        if (paramad.field_totalLen > 104857600L)
        {
          paramad = new am.a((byte)0);
          AppMethodBeat.o(31040);
          throw paramad;
        }
        parambi = new WWMediaFile();
        parambi.fileName = ((j.b)localObject1).title;
        parambi.filePath = paramad.field_fileFullPath;
        parambi.dYa();
        AppMethodBeat.o(31040);
        return parambi;
        paramad = a(parambi, paramad, paramBoolean);
        AppMethodBeat.o(31040);
        return paramad;
        if (((j.b)localObject1).fiZ == 3)
        {
          AppMethodBeat.o(31040);
          return null;
        }
        paramad = new WWMediaMiniProgram();
        paramad.username = ((j.b)localObject1).fiX;
        paramad.path = ((j.b)localObject1).fiW;
        paramad.iconUrl = ((j.b)localObject1).fjj;
        parambi = com.tencent.mm.at.o.ahC().c(parambi.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.g.a.d.a.cN(parambi)) {}
        for (;;)
        {
          try
          {
            parambi = k.PC(parambi);
            localObject2 = new ByteArrayOutputStream();
            parambi.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramad.BCN = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramad.BCN.length > 1048576)
            {
              ab.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramad.BCN = new byte[1];
            }
            paramad.name = ((j.b)localObject1).cGO;
            paramad.title = ((j.b)localObject1).title;
            ab.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramad.username, paramad.path, paramad.iconUrl, Integer.valueOf(paramad.BCN.length), paramad.name, paramad.title });
            AppMethodBeat.o(31040);
            return paramad;
          }
          catch (Exception parambi)
          {
            ab.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { parambi.getMessage() });
          }
          paramad.BCN = new byte[1];
        }
      }
      catch (Exception parambi)
      {
        break label249;
      }
    }
  }
  
  private static WWMediaMessage.WWMediaObject ba(bi parambi)
  {
    AppMethodBeat.i(31039);
    if (parambi.field_msgId > 0L) {}
    for (Object localObject1 = com.tencent.mm.at.o.ahC().gT(parambi.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.at.e)localObject1).fDL > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambi.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.at.o.ahC().gS(parambi.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(31039);
        return null;
      }
      parambi = com.tencent.mm.at.o.ahC().q(com.tencent.mm.at.f.c((com.tencent.mm.at.e)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = parambi;
      ab.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(31039);
      return localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */