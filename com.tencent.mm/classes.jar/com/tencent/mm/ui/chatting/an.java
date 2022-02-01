package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.ake;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bv.b;
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

public final class an
{
  private static String JZk = null;
  
  private static WWMediaMergedConvs a(ajx paramajx, bv parambv, com.tencent.mm.storage.an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramajx == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramajx = p.awG(paramajx.GAK);
    if (paramajx == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramajx.title;
    Iterator localIterator = paramajx.hFT.iterator();
    if (localIterator.hasNext())
    {
      ajx localajx = (ajx)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramajx = localajx.GAw;
      if (bu.isNullOrNil(localajx.GAV)) {
        localWWMediaConversation.name = paramajx;
      }
      for (;;)
      {
        try
        {
          paramajx = localajx.GAu.GBb;
          if (!paramajx.GBA) {
            continue;
          }
          paramajx = paramajx.dzZ;
          paramajx = com.tencent.mm.aj.c.a(paramajx, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramajx.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.MLp = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramajx)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localajx.GAy).getTime();
          l1 = l2;
        }
        catch (ParseException paramajx)
        {
          continue;
        }
        localWWMediaConversation.riq = l1;
        localWWMediaConversation.MLq = a(paraman, localajx, parambv, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramajx + localajx.GAV);
        continue;
        if (paramajx.GBF) {
          paramajx = paramajx.GBE;
        } else {
          paramajx = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(bv parambv, com.tencent.mm.storage.an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = parambv.field_content;
    if (x.wb(parambv.field_talker)) {
      localObject1 = bl.BN(parambv.field_content);
    }
    localObject1 = k.b.zb((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = p.awG(((k.b)localObject1).hDg);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).hFT.iterator();
      if (localIterator.hasNext())
      {
        ajx localajx = (ajx)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localajx.GAw;
        if (bu.isNullOrNil(localajx.GAV)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localajx.GAu.GBb;
            if (!((ajz)localObject1).GBA) {
              continue;
            }
            localObject1 = ((ajz)localObject1).dzZ;
            localObject1 = com.tencent.mm.aj.c.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.MLp = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localajx.GAy).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.riq = l1;
          localWWMediaConversation.MLq = a(paraman, localajx, parambv, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localajx.GAV);
          continue;
          if (((ajz)localObject1).GBF) {
            localObject1 = ((ajz)localObject1).GBE;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.an paraman, ajx paramajx, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramajx.dataType;
    if (i == 1)
    {
      paraman = new WWMediaText(paramajx.desc);
      AppMethodBeat.o(34923);
      return paraman;
    }
    if (i == 2)
    {
      long l = parambv.field_msgId;
      if (!e.abo()) {
        paramajx = null;
      }
      while (bu.isNullOrNil(paramajx))
      {
        ae.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        parambv = p.c(paramajx, l);
        paraman = parambv;
        if (bu.isNullOrNil(parambv)) {
          paraman = p.f(paramajx, l);
        }
        if (!bu.isNullOrNil(paraman))
        {
          paramajx = paraman;
          if (com.tencent.mm.vfs.o.fB(paraman)) {}
        }
        else
        {
          ae.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paraman });
          paramajx = null;
        }
      }
      paraman = new WWMediaImage();
      paraman.filePath = aXx(paramajx);
      ae.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paraman.filePath });
      AppMethodBeat.o(34923);
      return paraman;
    }
    if (i == 4)
    {
      paraman = p.c(paramajx, parambv.field_msgId);
      if ((bu.isNullOrNil(paraman)) || (!com.tencent.mm.pluginsdk.j.a.d.a.fB(paraman)))
      {
        ae.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramajx = new WWMediaVideo();
      paramajx.filePath = aXx(paraman);
      ae.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramajx.filePath });
      AppMethodBeat.o(34923);
      return paramajx;
    }
    if (i == 6)
    {
      paraman = new WWMediaLocation();
      if (paramajx.GAu == null)
      {
        ae.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      parambv = paramajx.GAu.GBd;
      if (parambv == null)
      {
        ae.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramajx.dua });
        AppMethodBeat.o(34923);
        return null;
      }
      paraman.title = parambv.dEv;
      paraman.hZQ = parambv.label;
      paraman.longitude = parambv.lng;
      paraman.latitude = parambv.lat;
      paraman.MLr = parambv.dzG;
      AppMethodBeat.o(34923);
      return paraman;
    }
    if (i == 8)
    {
      paraman = p.c(paramajx, parambv.field_msgId);
      if (bu.isNullOrNil(paraman))
      {
        ae.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramajx.dua });
        AppMethodBeat.o(34923);
        return null;
      }
      i = com.tencent.mm.n.b.acs();
      if (com.tencent.mm.pluginsdk.j.a.d.a.gE(paraman) > i)
      {
        paraman = new an.a((byte)0);
        AppMethodBeat.o(34923);
        throw paraman;
      }
      parambv = new WWMediaFile();
      parambv.fileName = paramajx.title;
      parambv.filePath = aXx(paraman);
      parambv.setContentLengthLimit(i);
      AppMethodBeat.o(34923);
      return parambv;
    }
    if (i == 17)
    {
      paraman = a(paramajx, parambv, paraman, paramBoolean);
      AppMethodBeat.o(34923);
      return paraman;
    }
    if (i == 19)
    {
      paraman = paramajx.GAu.GBs;
      paramajx = new WWMediaMiniProgram();
      paramajx.username = paraman.username;
      paramajx.path = paraman.dlk;
      paramajx.iconUrl = paraman.iconUrl;
      paramajx.MLt = new byte[1];
      paramajx.name = paraman.Gzq;
      paramajx.title = "";
      paramajx.type = paraman.type;
      ae.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramajx.username, paramajx.path, paramajx.iconUrl, Integer.valueOf(paramajx.MLt.length), paramajx.name, paramajx.title });
      AppMethodBeat.o(34923);
      return paramajx;
    }
    ae.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.an paraman, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34922);
    int i = parambv.getType();
    if (i == 1)
    {
      paraman = new WWMediaText(k.x(parambv.field_content, parambv.field_isSend, paramBoolean));
      AppMethodBeat.o(34922);
      return paraman;
    }
    if (i == 3)
    {
      paraman = bA(parambv);
      AppMethodBeat.o(34922);
      return paraman;
    }
    if (i == 43)
    {
      paraman = new WWMediaVideo();
      parambv = u.Ia(parambv.field_imgPath);
      com.tencent.mm.modelvideo.o.aNh();
      paraman.filePath = aXx(t.HJ(parambv.getFileName()));
      ae.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paraman.filePath });
      AppMethodBeat.o(34922);
      return paraman;
    }
    if (i == 48)
    {
      paraman = new WWMediaLocation();
      parambv = k.x(parambv.field_content, parambv.field_isSend, paramBoolean);
      bc.aCg();
      parambv = com.tencent.mm.model.c.azI().arq(parambv);
      paraman.title = parambv.jGd;
      paraman.hZQ = parambv.label;
      paraman.longitude = parambv.vlD;
      paraman.latitude = parambv.vlC;
      paraman.MLr = parambv.dzG;
      AppMethodBeat.o(34922);
      return paraman;
    }
    if ((i == 49) || (i == 268435505))
    {
      paraman = b(paraman, parambv, paramBoolean);
      AppMethodBeat.o(34922);
      return paraman;
    }
    ae.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34922);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(com.tencent.mm.storage.an paraman, List<bv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34924);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paraman.field_username;
    Object localObject1 = ak.getContext();
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
        localObject2 = (bv)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((ei)localObject2).field_isSend == 1)
        {
          paramList = v.aAC();
          localObject4 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(paramList));
          ((WWMediaConversation)localObject3).name = (w.zO(paramList) + bu.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.aj.c.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).MLp = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label191:
        ((WWMediaConversation)localObject3).riq = ((ei)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).MLq = a(paraman, (bv)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label50;
        localObject2 = v.aAE();
        localObject3 = w.zO((String)localObject3);
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
        paramList = bl.BM(((ei)localObject2).field_content);
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
  
  public static boolean a(Context paramContext, com.tencent.mm.storage.an paraman, List<bv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(187177);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(187177);
      return false;
    }
    if (k.jdMethod_if(paramList))
    {
      ae.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131757940), "", new an.1(), null);
      AppMethodBeat.o(187177);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!ac.bm((bv)localIterator.next()))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131766957), "", paramContext.getString(2131766205), null);
        AppMethodBeat.o(187177);
        return false;
      }
    }
    if (!k.a(true, paramList, paraman.field_username, null))
    {
      ae.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      com.tencent.mm.ui.base.h.e(paramContext, paramContext.getString(2131760349), "", paramContext.getString(2131762559), paramContext.getString(2131755691), new an.2(paramContext, paraman, paramList, paramBoolean), new an.3());
      AppMethodBeat.o(187177);
      return true;
    }
    b(paramContext, paraman, paramList, paramBoolean);
    AppMethodBeat.o(187177);
    return true;
  }
  
  private static String aXx(String paramString)
  {
    AppMethodBeat.i(187178);
    if ((!bu.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (JZk == null) {
          JZk = new File(com.tencent.mm.loader.j.b.ase()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = JZk + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (com.tencent.mm.vfs.o.fB((String)localObject)) {
          com.tencent.mm.vfs.o.deleteFile((String)localObject);
        }
        if (!com.tencent.mm.vfs.o.fB(str)) {
          com.tencent.mm.vfs.o.aZI(str);
        }
        com.tencent.mm.sdk.platformtools.q.C(paramString, (String)localObject, false);
        ae.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, bu.fpN().toString() });
        AppMethodBeat.o(187178);
        return localObject;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(187178);
    return paramString;
  }
  
  private static WWMediaMessage.WWMediaObject b(com.tencent.mm.storage.an paraman, bv parambv, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject2 = parambv.field_content;
    Object localObject1 = localObject2;
    int i;
    if (paramBoolean)
    {
      i = parambv.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambv.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.aB((String)localObject1, parambv.field_reserved);; localObject1 = null)
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
        paraman = new WWMediaLink();
        paraman.webpageUrl = ((k.b)localObject1).url;
        paraman.title = ((k.b)localObject1).title;
        paraman.description = ((k.b)localObject1).description;
        paraman.setThumbImage(com.tencent.mm.av.q.aIX().a(parambv.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false));
      }
      try
      {
        parambv = com.tencent.mm.av.q.aIX().a(parambv.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        parambv.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paraman.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paraman;
        if ((((k.b)localObject1).dlu != null) && (((k.b)localObject1).dlu.length() > 0))
        {
          paraman = ao.bJV().aMZ(((k.b)localObject1).dlu);
          if ((paraman != null) && (paraman.cZe()))
          {
            paraman = paraman.field_fileFullPath;
            if (!com.tencent.mm.vfs.o.fB(paraman))
            {
              ae.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paraman, Long.valueOf(parambv.field_msgId), Long.valueOf(parambv.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            parambv = new WWMediaImage();
            parambv.filePath = aXx(paraman);
            ae.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambv.filePath });
            AppMethodBeat.o(34926);
            return parambv;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.aNj(((k.b)localObject1).dlu);
        paraman = (com.tencent.mm.storage.an)localObject2;
        if (localObject2 == null) {
          paraman = ao.bJV().CZ(parambv.field_msgId);
        }
        i = com.tencent.mm.n.b.acs();
        if (paraman.field_totalLen > i)
        {
          paraman = new an.a((byte)0);
          AppMethodBeat.o(34926);
          throw paraman;
        }
        parambv = new WWMediaFile();
        parambv.fileName = ((k.b)localObject1).title;
        parambv.filePath = aXx(paraman.field_fileFullPath);
        parambv.setContentLengthLimit(i);
        AppMethodBeat.o(34926);
        return parambv;
        paraman = a(parambv, paraman, paramBoolean);
        AppMethodBeat.o(34926);
        return paraman;
        if (((k.b)localObject1).hFe == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paraman = new WWMediaMiniProgram();
        paraman.username = ((k.b)localObject1).hFc;
        paraman.path = ((k.b)localObject1).hFb;
        paraman.iconUrl = ((k.b)localObject1).hFt;
        parambv = com.tencent.mm.av.q.aIX().c(parambv.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.j.a.d.a.fB(parambv)) {}
        for (;;)
        {
          try
          {
            parambv = n.alP(parambv);
            localObject2 = new ByteArrayOutputStream();
            parambv.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paraman.MLt = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paraman.MLt.length > 1048576)
            {
              ae.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paraman.MLt = new byte[1];
            }
            paraman.name = ((k.b)localObject1).dIu;
            paraman.title = ((k.b)localObject1).title;
            paraman.type = ((k.b)localObject1).hFe;
            ae.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paraman.username, paraman.path, paraman.iconUrl, Integer.valueOf(paraman.MLt.length), paraman.name, paraman.title });
            AppMethodBeat.o(34926);
            return paraman;
          }
          catch (Exception parambv)
          {
            ae.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { parambv.getMessage() });
          }
          paraman.MLt = new byte[1];
        }
      }
      catch (Exception parambv)
      {
        break label249;
      }
    }
  }
  
  private static void b(Context paramContext, com.tencent.mm.storage.an paraman, List<bv> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34921);
    IWWAPI localIWWAPI = WWAPIFactory.lz(paramContext);
    for (;;)
    {
      try
      {
        if (paramList.size() != 1) {
          continue;
        }
        paraman = a(paraman, (bv)paramList.get(0), paramBoolean);
        localIWWAPI.a(paraman);
        com.tencent.mm.plugin.selectrecord.b.b.dQy().PG(1);
      }
      catch (an.a paraman)
      {
        int i = com.tencent.mm.n.b.acs() / 1048576;
        com.tencent.mm.ui.base.h.c(paramContext, paramContext.getResources().getString(2131767168, new Object[] { Integer.valueOf(i) }), paramContext.getResources().getString(2131755906), true);
        com.tencent.mm.plugin.selectrecord.b.b.dQy().PG(2);
        continue;
      }
      com.tencent.mm.plugin.selectrecord.b.b.dQy().aLH();
      AppMethodBeat.o(34921);
      return;
      paraman = a(paraman, paramList, paramBoolean);
    }
  }
  
  private static WWMediaMessage.WWMediaObject bA(bv parambv)
  {
    AppMethodBeat.i(34925);
    if (parambv.field_msgId > 0L) {}
    for (Object localObject1 = com.tencent.mm.av.q.aIX().G(parambv.field_talker, parambv.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.g)localObject1).doE > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambv.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.av.q.aIX().F(parambv.field_talker, parambv.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      parambv = com.tencent.mm.av.q.aIX().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = aXx(parambv);
      ae.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  public static boolean dK(Context paramContext)
  {
    AppMethodBeat.i(187175);
    boolean bool = WWAPIFactory.lz(paramContext).geD();
    AppMethodBeat.o(187175);
    return bool;
  }
  
  public static String kr(Context paramContext)
  {
    AppMethodBeat.i(187176);
    paramContext = WWAPIFactory.lz(paramContext).geE();
    AppMethodBeat.o(187176);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.an
 * JD-Core Version:    0.7.0.1
 */