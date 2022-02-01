package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.bj;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ajl;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bu.b;
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
  private static String JEt = null;
  
  private static WWMediaMergedConvs a(ajn paramajn, bu parambu, com.tencent.mm.storage.am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramajn == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramajn = com.tencent.mm.plugin.record.b.p.avr(paramajn.Gib);
    if (paramajn == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramajn.title;
    Iterator localIterator = paramajn.hDb.iterator();
    if (localIterator.hasNext())
    {
      ajn localajn = (ajn)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramajn = localajn.GhN;
      if (bt.isNullOrNil(localajn.Gim)) {
        localWWMediaConversation.name = paramajn;
      }
      for (;;)
      {
        try
        {
          paramajn = localajn.GhL.Gis;
          if (!paramajn.GiR) {
            continue;
          }
          paramajn = paramajn.dyU;
          paramajn = com.tencent.mm.ak.c.a(paramajn, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramajn.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.Mot = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramajn)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localajn.GhP).getTime();
          l1 = l2;
        }
        catch (ParseException paramajn)
        {
          continue;
        }
        localWWMediaConversation.rak = l1;
        localWWMediaConversation.Mou = a(paramam, localajn, parambu, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramajn + localajn.Gim);
        continue;
        if (paramajn.GiW) {
          paramajn = paramajn.GiV;
        } else {
          paramajn = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(bu parambu, com.tencent.mm.storage.am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = parambu.field_content;
    if (w.vF(parambu.field_talker)) {
      localObject1 = bj.Bl(parambu.field_content);
    }
    localObject1 = k.b.yr((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = com.tencent.mm.plugin.record.b.p.avr(((k.b)localObject1).hAs);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).hDb.iterator();
      if (localIterator.hasNext())
      {
        ajn localajn = (ajn)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localajn.GhN;
        if (bt.isNullOrNil(localajn.Gim)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localajn.GhL.Gis;
            if (!((ajp)localObject1).GiR) {
              continue;
            }
            localObject1 = ((ajp)localObject1).dyU;
            localObject1 = com.tencent.mm.ak.c.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.Mot = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localajn.GhP).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.rak = l1;
          localWWMediaConversation.Mou = a(paramam, localajn, parambu, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localajn.Gim);
          continue;
          if (((ajp)localObject1).GiW) {
            localObject1 = ((ajp)localObject1).GiV;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.am paramam, ajn paramajn, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramajn.dataType;
    if (i == 1)
    {
      paramam = new WWMediaText(paramajn.desc);
      AppMethodBeat.o(34923);
      return paramam;
    }
    if (i == 2)
    {
      long l = parambu.field_msgId;
      if (!e.abf()) {
        paramajn = null;
      }
      while (bt.isNullOrNil(paramajn))
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        parambu = com.tencent.mm.plugin.record.b.p.c(paramajn, l);
        paramam = parambu;
        if (bt.isNullOrNil(parambu)) {
          paramam = com.tencent.mm.plugin.record.b.p.f(paramajn, l);
        }
        if (!bt.isNullOrNil(paramam))
        {
          paramajn = paramam;
          if (com.tencent.mm.vfs.i.fv(paramam)) {}
        }
        else
        {
          ad.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramam });
          paramajn = null;
        }
      }
      paramam = new WWMediaImage();
      paramam.filePath = aVW(paramajn);
      ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramam.filePath });
      AppMethodBeat.o(34923);
      return paramam;
    }
    if (i == 4)
    {
      paramam = com.tencent.mm.plugin.record.b.p.c(paramajn, parambu.field_msgId);
      if ((bt.isNullOrNil(paramam)) || (!com.tencent.mm.pluginsdk.j.a.d.a.fv(paramam)))
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramajn = new WWMediaVideo();
      paramajn.filePath = aVW(paramam);
      ad.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramajn.filePath });
      AppMethodBeat.o(34923);
      return paramajn;
    }
    if (i == 6)
    {
      paramam = new WWMediaLocation();
      if (paramajn.GhL == null)
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      parambu = paramajn.GhL.Giu;
      if (parambu == null)
      {
        ad.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramajn.dsU });
        AppMethodBeat.o(34923);
        return null;
      }
      paramam.title = parambu.dDq;
      paramam.hWY = parambu.label;
      paramam.longitude = parambu.lng;
      paramam.latitude = parambu.lat;
      paramam.Mov = parambu.dyB;
      AppMethodBeat.o(34923);
      return paramam;
    }
    if (i == 8)
    {
      paramam = com.tencent.mm.plugin.record.b.p.c(paramajn, parambu.field_msgId);
      if (bt.isNullOrNil(paramam))
      {
        ad.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramajn.dsU });
        AppMethodBeat.o(34923);
        return null;
      }
      i = com.tencent.mm.n.b.aci();
      if (com.tencent.mm.pluginsdk.j.a.d.a.gy(paramam) > i)
      {
        paramam = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramam;
      }
      parambu = new WWMediaFile();
      parambu.fileName = paramajn.title;
      parambu.filePath = aVW(paramam);
      parambu.setContentLengthLimit(i);
      AppMethodBeat.o(34923);
      return parambu;
    }
    if (i == 17)
    {
      paramam = a(paramajn, parambu, paramam, paramBoolean);
      AppMethodBeat.o(34923);
      return paramam;
    }
    if (i == 19)
    {
      paramam = paramajn.GhL.GiJ;
      paramajn = new WWMediaMiniProgram();
      paramajn.username = paramam.username;
      paramajn.path = paramam.dki;
      paramajn.iconUrl = paramam.iconUrl;
      paramajn.Mox = new byte[1];
      paramajn.name = paramam.GgH;
      paramajn.title = "";
      paramajn.type = paramam.type;
      ad.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramajn.username, paramajn.path, paramajn.iconUrl, Integer.valueOf(paramajn.Mox.length), paramajn.name, paramajn.title });
      AppMethodBeat.o(34923);
      return paramajn;
    }
    ad.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.am paramam, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34922);
    int i = parambu.getType();
    if (i == 1)
    {
      paramam = new WWMediaText(j.x(parambu.field_content, parambu.field_isSend, paramBoolean));
      AppMethodBeat.o(34922);
      return paramam;
    }
    if (i == 3)
    {
      paramam = bB(parambu);
      AppMethodBeat.o(34922);
      return paramam;
    }
    if (i == 43)
    {
      paramam = new WWMediaVideo();
      parambu = com.tencent.mm.modelvideo.u.Hy(parambu.field_imgPath);
      o.aMJ();
      paramam.filePath = aVW(t.Hh(parambu.getFileName()));
      ad.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramam.filePath });
      AppMethodBeat.o(34922);
      return paramam;
    }
    if (i == 48)
    {
      paramam = new WWMediaLocation();
      parambu = j.x(parambu.field_content, parambu.field_isSend, paramBoolean);
      ba.aBQ();
      parambu = com.tencent.mm.model.c.azs().aql(parambu);
      paramam.title = parambu.jDf;
      paramam.hWY = parambu.label;
      paramam.longitude = parambu.uZs;
      paramam.latitude = parambu.uZr;
      paramam.Mov = parambu.dyB;
      AppMethodBeat.o(34922);
      return paramam;
    }
    if ((i == 49) || (i == 268435505))
    {
      paramam = b(paramam, parambu, paramBoolean);
      AppMethodBeat.o(34922);
      return paramam;
    }
    ad.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34922);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.am paramam, List<bu> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34924);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramam.field_username;
    Object localObject1 = aj.getContext();
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
        localObject2 = (bu)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((ei)localObject2).field_isSend == 1)
        {
          paramList = com.tencent.mm.model.u.aAm();
          localObject4 = com.tencent.mm.openim.room.a.a.H(((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(paramList));
          ((WWMediaConversation)localObject3).name = (v.ze(paramList) + bt.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.ak.c.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).Mot = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label191:
        ((WWMediaConversation)localObject3).rak = ((ei)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).Mou = a(paramam, (bu)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label50;
        localObject2 = com.tencent.mm.model.u.aAo();
        localObject3 = v.ze((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(2131758964, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(2131758963, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((ei)localObject2).field_talker;
          break label92;
        }
        paramList = bj.Bk(((ei)localObject2).field_content);
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
  
  public static void a(Context paramContext, com.tencent.mm.storage.am paramam, List<bu> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(193870);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(193870);
      return;
    }
    if (j.hV(paramList))
    {
      ad.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757940), "", new am.1(), null);
      AppMethodBeat.o(193870);
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!ab.bn((bu)localIterator.next()))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766957), "", paramContext.getString(2131766205), null);
        AppMethodBeat.o(193870);
        return;
      }
    }
    if (!j.a(true, paramList, paramam.field_username, null))
    {
      ad.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      com.tencent.mm.ui.base.h.e(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131762559), paramContext.getString(2131755691), new am.2(paramContext, paramam, paramList, paramBoolean), null);
      AppMethodBeat.o(193870);
      return;
    }
    b(paramContext, paramam, paramList, paramBoolean);
    AppMethodBeat.o(193870);
  }
  
  private static String aVW(String paramString)
  {
    AppMethodBeat.i(193871);
    if ((!bt.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (JEt == null) {
          JEt = new File(com.tencent.mm.loader.j.b.arP()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = JEt + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (com.tencent.mm.vfs.i.fv((String)localObject)) {
          com.tencent.mm.vfs.i.deleteFile((String)localObject);
        }
        if (!com.tencent.mm.vfs.i.fv(str)) {
          com.tencent.mm.vfs.i.aYg(str);
        }
        com.tencent.mm.sdk.platformtools.p.C(paramString, (String)localObject, false);
        ad.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, bt.flS().toString() });
        AppMethodBeat.o(193871);
        return localObject;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(193871);
    return paramString;
  }
  
  private static WWMediaMessage.WWMediaObject b(com.tencent.mm.storage.am paramam, bu parambu, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject2 = parambu.field_content;
    Object localObject1 = localObject2;
    int i;
    if (paramBoolean)
    {
      i = parambu.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambu.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.aA((String)localObject1, parambu.field_reserved);; localObject1 = null)
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
        paramam = new WWMediaLink();
        paramam.webpageUrl = ((k.b)localObject1).url;
        paramam.title = ((k.b)localObject1).title;
        paramam.description = ((k.b)localObject1).description;
        paramam.setThumbImage(q.aIF().a(parambu.field_imgPath, com.tencent.mm.cc.a.getDensity(null), false));
      }
      try
      {
        parambu = q.aIF().a(parambu.field_imgPath, com.tencent.mm.cc.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        parambu.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramam.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paramam;
        if ((((k.b)localObject1).dks != null) && (((k.b)localObject1).dks.length() > 0))
        {
          paramam = ao.bIX().aLD(((k.b)localObject1).dks);
          if ((paramam != null) && (paramam.cWz()))
          {
            paramam = paramam.field_fileFullPath;
            if (!com.tencent.mm.vfs.i.fv(paramam))
            {
              ad.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramam, Long.valueOf(parambu.field_msgId), Long.valueOf(parambu.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            parambu = new WWMediaImage();
            parambu.filePath = aVW(paramam);
            ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambu.filePath });
            AppMethodBeat.o(34926);
            return parambu;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.aLN(((k.b)localObject1).dks);
        paramam = (com.tencent.mm.storage.am)localObject2;
        if (localObject2 == null) {
          paramam = ao.bIX().CB(parambu.field_msgId);
        }
        i = com.tencent.mm.n.b.aci();
        if (paramam.field_totalLen > i)
        {
          paramam = new a((byte)0);
          AppMethodBeat.o(34926);
          throw paramam;
        }
        parambu = new WWMediaFile();
        parambu.fileName = ((k.b)localObject1).title;
        parambu.filePath = aVW(paramam.field_fileFullPath);
        parambu.setContentLengthLimit(i);
        AppMethodBeat.o(34926);
        return parambu;
        paramam = a(parambu, paramam, paramBoolean);
        AppMethodBeat.o(34926);
        return paramam;
        if (((k.b)localObject1).hCp == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paramam = new WWMediaMiniProgram();
        paramam.username = ((k.b)localObject1).hCn;
        paramam.path = ((k.b)localObject1).hCm;
        paramam.iconUrl = ((k.b)localObject1).hCB;
        parambu = q.aIF().c(parambu.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.j.a.d.a.fv(parambu)) {}
        for (;;)
        {
          try
          {
            parambu = n.akR(parambu);
            localObject2 = new ByteArrayOutputStream();
            parambu.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramam.Mox = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramam.Mox.length > 1048576)
            {
              ad.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramam.Mox = new byte[1];
            }
            paramam.name = ((k.b)localObject1).dHp;
            paramam.title = ((k.b)localObject1).title;
            paramam.type = ((k.b)localObject1).hCp;
            ad.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramam.username, paramam.path, paramam.iconUrl, Integer.valueOf(paramam.Mox.length), paramam.name, paramam.title });
            AppMethodBeat.o(34926);
            return paramam;
          }
          catch (Exception parambu)
          {
            ad.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { parambu.getMessage() });
          }
          paramam.Mox = new byte[1];
        }
      }
      catch (Exception parambu)
      {
        break label249;
      }
    }
  }
  
  private static void b(Context paramContext, com.tencent.mm.storage.am paramam, List<bu> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34921);
    IWWAPI localIWWAPI = WWAPIFactory.lt(paramContext);
    try
    {
      if (paramList.size() == 1) {}
      for (paramam = a(paramam, (bu)paramList.get(0), paramBoolean);; paramam = a(paramam, paramList, paramBoolean))
      {
        localIWWAPI.a(paramam);
        AppMethodBeat.o(34921);
        return;
      }
      int i;
      return;
    }
    catch (a paramam)
    {
      i = com.tencent.mm.n.b.aci() / 1048576;
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getResources().getString(2131767168, new Object[] { Integer.valueOf(i) }), paramContext.getResources().getString(2131755906), true);
      AppMethodBeat.o(34921);
    }
  }
  
  private static WWMediaMessage.WWMediaObject bB(bu parambu)
  {
    AppMethodBeat.i(34925);
    if (parambu.field_msgId > 0L) {}
    for (Object localObject1 = q.aIF().G(parambu.field_talker, parambu.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.aw.g)localObject1).dnz > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambu.field_msgSvrId > 0L) {
          localObject2 = q.aIF().F(parambu.field_talker, parambu.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      parambu = q.aIF().o(com.tencent.mm.aw.h.c((com.tencent.mm.aw.g)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = aVW(parambu);
      ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  public static boolean dG(Context paramContext)
  {
    AppMethodBeat.i(193868);
    boolean bool = WWAPIFactory.lt(paramContext).gab();
    AppMethodBeat.o(193868);
    return bool;
  }
  
  public static String kk(Context paramContext)
  {
    AppMethodBeat.i(193869);
    paramContext = WWAPIFactory.lt(paramContext).gac();
    AppMethodBeat.o(193869);
    return paramContext;
  }
  
  static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */