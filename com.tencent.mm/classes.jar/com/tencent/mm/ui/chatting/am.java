package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.aw.f;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
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
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.protocal.protobuf.agf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bl.b;
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
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class am
{
  private static WWMediaMergedConvs a(afy paramafy, bl parambl, af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramafy == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramafy = com.tencent.mm.plugin.record.b.n.alt(paramafy.Dhj);
    if (paramafy == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramafy.title;
    Iterator localIterator = paramafy.gKs.iterator();
    if (localIterator.hasNext())
    {
      afy localafy = (afy)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramafy = localafy.DgV;
      if (bt.isNullOrNil(localafy.Dhu)) {
        localWWMediaConversation.name = paramafy;
      }
      for (;;)
      {
        try
        {
          paramafy = localafy.DgT.DhA;
          if (!paramafy.DhZ) {
            continue;
          }
          paramafy = paramafy.dpv;
          paramafy = com.tencent.mm.ak.c.a(paramafy, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramafy.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.ILX = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramafy)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localafy.DgX).getTime();
          l1 = l2;
        }
        catch (ParseException paramafy)
        {
          continue;
        }
        localWWMediaConversation.vJM = l1;
        localWWMediaConversation.ILY = a(paramaf, localafy, parambl, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramafy + localafy.Dhu);
        continue;
        if (paramafy.Die) {
          paramafy = paramafy.Did;
        } else {
          paramafy = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(bl parambl, af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = parambl.field_content;
    if (w.pF(parambl.field_talker)) {
      localObject1 = bi.ug(parambl.field_content);
    }
    localObject1 = k.b.rx((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = com.tencent.mm.plugin.record.b.n.alt(((k.b)localObject1).gHI);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).gKs.iterator();
      if (localIterator.hasNext())
      {
        afy localafy = (afy)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localafy.DgV;
        if (bt.isNullOrNil(localafy.Dhu)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localafy.DgT.DhA;
            if (!((aga)localObject1).DhZ) {
              continue;
            }
            localObject1 = ((aga)localObject1).dpv;
            localObject1 = com.tencent.mm.ak.c.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.ILX = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localafy.DgX).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.vJM = l1;
          localWWMediaConversation.ILY = a(paramaf, localafy, parambl, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localafy.Dhu);
          continue;
          if (((aga)localObject1).Die) {
            localObject1 = ((aga)localObject1).Did;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(af paramaf, afy paramafy, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramafy.dataType;
    if (i == 1)
    {
      paramaf = new WWMediaText(paramafy.desc);
      AppMethodBeat.o(34923);
      return paramaf;
    }
    if (i == 2)
    {
      long l = parambl.field_msgId;
      if (!com.tencent.mm.compatible.util.e.XG()) {
        paramafy = null;
      }
      while (bt.isNullOrNil(paramafy))
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        parambl = com.tencent.mm.plugin.record.b.n.c(paramafy, l);
        paramaf = parambl;
        if (bt.isNullOrNil(parambl)) {
          paramaf = com.tencent.mm.plugin.record.b.n.f(paramafy, l);
        }
        if (!bt.isNullOrNil(paramaf))
        {
          paramafy = paramaf;
          if (i.eK(paramaf)) {}
        }
        else
        {
          ad.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramaf });
          paramafy = null;
        }
      }
      paramaf = new WWMediaImage();
      paramaf.filePath = paramafy;
      ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramaf.filePath });
      AppMethodBeat.o(34923);
      return paramaf;
    }
    if (i == 4)
    {
      paramaf = com.tencent.mm.plugin.record.b.n.c(paramafy, parambl.field_msgId);
      if ((bt.isNullOrNil(paramaf)) || (!com.tencent.mm.pluginsdk.h.a.d.a.eK(paramaf)))
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramafy = new WWMediaVideo();
      paramafy.filePath = paramaf;
      ad.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramafy.filePath });
      AppMethodBeat.o(34923);
      return paramafy;
    }
    if (i == 6)
    {
      paramaf = new WWMediaLocation();
      if (paramafy.DgT == null)
      {
        ad.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      parambl = paramafy.DgT.DhC;
      if (parambl == null)
      {
        ad.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramafy.dkb });
        AppMethodBeat.o(34923);
        return null;
      }
      paramaf.title = parambl.dtN;
      paramaf.hdQ = parambl.label;
      paramaf.longitude = parambl.lng;
      paramaf.latitude = parambl.lat;
      paramaf.ILZ = parambl.dpd;
      AppMethodBeat.o(34923);
      return paramaf;
    }
    if (i == 8)
    {
      paramaf = com.tencent.mm.plugin.record.b.n.c(paramafy, parambl.field_msgId);
      if (bt.isNullOrNil(paramaf))
      {
        ad.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramafy.dkb });
        AppMethodBeat.o(34923);
        return null;
      }
      if (com.tencent.mm.pluginsdk.h.a.d.a.fN(paramaf) > 104857600L)
      {
        paramaf = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramaf;
      }
      parambl = new WWMediaFile();
      parambl.fileName = paramafy.title;
      parambl.filePath = paramaf;
      parambl.fqr();
      AppMethodBeat.o(34923);
      return parambl;
    }
    if (i == 17)
    {
      paramaf = a(paramafy, parambl, paramaf, paramBoolean);
      AppMethodBeat.o(34923);
      return paramaf;
    }
    if (i == 19)
    {
      paramaf = paramafy.DgT.DhR;
      paramafy = new WWMediaMiniProgram();
      paramafy.username = paramaf.username;
      paramafy.path = paramaf.dbu;
      paramafy.iconUrl = paramaf.iconUrl;
      paramafy.IMb = new byte[1];
      paramafy.name = paramaf.DfP;
      paramafy.title = "";
      paramafy.type = paramaf.type;
      ad.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramafy.username, paramafy.path, paramafy.iconUrl, Integer.valueOf(paramafy.IMb.length), paramafy.name, paramafy.title });
      AppMethodBeat.o(34923);
      return paramafy;
    }
    ad.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(af paramaf, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34922);
    int i = parambl.getType();
    if (i == 1)
    {
      paramaf = new WWMediaText(j.x(parambl.field_content, parambl.field_isSend, paramBoolean));
      AppMethodBeat.o(34922);
      return paramaf;
    }
    if (i == 3)
    {
      paramaf = bv(parambl);
      AppMethodBeat.o(34922);
      return paramaf;
    }
    if (i == 43)
    {
      paramaf = new WWMediaVideo();
      parambl = com.tencent.mm.modelvideo.u.Ae(parambl.field_imgPath);
      com.tencent.mm.modelvideo.o.aCI();
      paramaf.filePath = t.zQ(parambl.getFileName());
      ad.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramaf.filePath });
      AppMethodBeat.o(34922);
      return paramaf;
    }
    if (i == 48)
    {
      paramaf = new WWMediaLocation();
      parambl = j.x(parambl.field_content, parambl.field_isSend, paramBoolean);
      az.arV();
      parambl = com.tencent.mm.model.c.apO().agD(parambl);
      paramaf.title = parambl.goQ;
      paramaf.hdQ = parambl.label;
      paramaf.longitude = parambl.sOw;
      paramaf.latitude = parambl.sOv;
      paramaf.ILZ = parambl.dpd;
      AppMethodBeat.o(34922);
      return paramaf;
    }
    if ((i == 49) || (i == 268435505))
    {
      paramaf = b(paramaf, parambl, paramBoolean);
      AppMethodBeat.o(34922);
      return paramaf;
    }
    ad.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34922);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(af paramaf, List<bl> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34924);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramaf.field_username;
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
        localObject2 = (bl)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((du)localObject2).field_isSend == 1)
        {
          paramList = com.tencent.mm.model.u.aqG();
          localObject4 = com.tencent.mm.openim.room.a.a.G(((k)com.tencent.mm.kernel.g.ab(k.class)).apM().aHY(paramList));
          ((WWMediaConversation)localObject3).name = (v.sg(paramList) + bt.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.ak.c.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).ILX = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label191:
        ((WWMediaConversation)localObject3).vJM = ((du)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).ILY = a(paramaf, (bl)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label50;
        localObject2 = com.tencent.mm.model.u.aqI();
        localObject3 = v.sg((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(2131758964, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(2131758963, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((du)localObject2).field_talker;
          break label92;
        }
        paramList = bi.uf(((du)localObject2).field_content);
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
  
  public static void a(Context paramContext, af paramaf, List<bl> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(34921);
    IWWAPI localIWWAPI = WWAPIFactory.kS(paramContext);
    try
    {
      if (paramList.size() == 1) {}
      for (paramaf = a(paramaf, (bl)paramList.get(0), paramBoolean);; paramaf = a(paramaf, paramList, paramBoolean))
      {
        localIWWAPI.a(paramaf);
        AppMethodBeat.o(34921);
        return;
      }
      return;
    }
    catch (a paramaf)
    {
      com.tencent.mm.ui.base.h.j(paramContext, 2131763074, 2131755906);
      AppMethodBeat.o(34921);
    }
  }
  
  private static WWMediaMessage.WWMediaObject b(af paramaf, bl parambl, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject2 = parambl.field_content;
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      int i = parambl.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = parambl.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.ar((String)localObject1, parambl.field_reserved);; localObject1 = null)
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
        paramaf = new WWMediaLink();
        paramaf.webpageUrl = ((k.b)localObject1).url;
        paramaf.title = ((k.b)localObject1).title;
        paramaf.description = ((k.b)localObject1).description;
        paramaf.setThumbImage(com.tencent.mm.aw.o.ayF().a(parambl.field_imgPath, com.tencent.mm.cd.a.getDensity(null), false));
      }
      try
      {
        parambl = com.tencent.mm.aw.o.ayF().a(parambl.field_imgPath, com.tencent.mm.cd.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        parambl.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramaf.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paramaf;
        if ((((k.b)localObject1).dbA != null) && (((k.b)localObject1).dbA.length() > 0))
        {
          paramaf = ap.bxS().aAL(((k.b)localObject1).dbA);
          if ((paramaf != null) && (paramaf.cAX()))
          {
            paramaf = paramaf.field_fileFullPath;
            if (!i.eK(paramaf))
            {
              ad.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramaf, Long.valueOf(parambl.field_msgId), Long.valueOf(parambl.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            parambl = new WWMediaImage();
            parambl.filePath = paramaf;
            ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambl.filePath });
            AppMethodBeat.o(34926);
            return parambl;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.aAV(((k.b)localObject1).dbA);
        paramaf = (af)localObject2;
        if (localObject2 == null) {
          paramaf = ap.bxS().vj(parambl.field_msgId);
        }
        if (paramaf.field_totalLen > 104857600L)
        {
          paramaf = new a((byte)0);
          AppMethodBeat.o(34926);
          throw paramaf;
        }
        parambl = new WWMediaFile();
        parambl.fileName = ((k.b)localObject1).title;
        parambl.filePath = paramaf.field_fileFullPath;
        parambl.fqr();
        AppMethodBeat.o(34926);
        return parambl;
        paramaf = a(parambl, paramaf, paramBoolean);
        AppMethodBeat.o(34926);
        return paramaf;
        if (((k.b)localObject1).gJG == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paramaf = new WWMediaMiniProgram();
        paramaf.username = ((k.b)localObject1).gJE;
        paramaf.path = ((k.b)localObject1).gJD;
        paramaf.iconUrl = ((k.b)localObject1).gJS;
        parambl = com.tencent.mm.aw.o.ayF().b(parambl.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.h.a.d.a.eK(parambl)) {}
        for (;;)
        {
          try
          {
            parambl = com.tencent.mm.plugin.gallery.model.n.abB(parambl);
            localObject2 = new ByteArrayOutputStream();
            parambl.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramaf.IMb = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramaf.IMb.length > 1048576)
            {
              ad.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramaf.IMb = new byte[1];
            }
            paramaf.name = ((k.b)localObject1).dxA;
            paramaf.title = ((k.b)localObject1).title;
            paramaf.type = ((k.b)localObject1).gJG;
            ad.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramaf.username, paramaf.path, paramaf.iconUrl, Integer.valueOf(paramaf.IMb.length), paramaf.name, paramaf.title });
            AppMethodBeat.o(34926);
            return paramaf;
          }
          catch (Exception parambl)
          {
            ad.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { parambl.getMessage() });
          }
          paramaf.IMb = new byte[1];
        }
      }
      catch (Exception parambl)
      {
        break label249;
      }
    }
  }
  
  private static WWMediaMessage.WWMediaObject bv(bl parambl)
  {
    AppMethodBeat.i(34925);
    if (parambl.field_msgId > 0L) {}
    for (Object localObject1 = com.tencent.mm.aw.o.ayF().ms(parambl.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.aw.e)localObject1).deI > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambl.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.aw.o.ayF().mr(parambl.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      parambl = com.tencent.mm.aw.o.ayF().p(f.c((com.tencent.mm.aw.e)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = parambl;
      ad.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.am
 * JD-Core Version:    0.7.0.1
 */