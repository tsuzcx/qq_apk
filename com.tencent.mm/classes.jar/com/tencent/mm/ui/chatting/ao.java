package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.ay.g;
import com.tencent.mm.ay.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bq;
import com.tencent.mm.model.bs;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.w;
import com.tencent.mm.modelvideo.x;
import com.tencent.mm.modelvideo.y;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.ank;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.ca.b;
import com.tencent.mm.vfs.u;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
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

public final class ao
{
  private static String WEm = null;
  
  private static WWMediaMergedConvs a(anm paramanm, ca paramca, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramanm == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramanm = p.aVz(paramanm.SyW);
    if (paramanm == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramanm.title;
    Iterator localIterator = paramanm.lpz.iterator();
    if (localIterator.hasNext())
    {
      anm localanm = (anm)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramanm = localanm.SyI;
      if (Util.isNullOrNil(localanm.Szh)) {
        localWWMediaConversation.name = paramanm;
      }
      for (;;)
      {
        try
        {
          paramanm = localanm.SyG.Szn;
          if (!paramanm.SzY) {
            continue;
          }
          paramanm = paramanm.fLi;
          paramanm = com.tencent.mm.am.d.a(paramanm, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramanm.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.ZYt = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramanm)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localanm.SyK).getTime();
          l1 = l2;
        }
        catch (ParseException paramanm)
        {
          continue;
        }
        localWWMediaConversation.wpR = l1;
        localWWMediaConversation.ZYu = a(paramas, localanm, paramca, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramanm + localanm.Szh);
        continue;
        if (paramanm.SAc) {
          paramanm = paramanm.SAb;
        } else {
          paramanm = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(ca paramca, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = paramca.field_content;
    if (ab.Lj(paramca.field_talker)) {
      localObject1 = bq.RM(paramca.field_content);
    }
    localObject1 = k.b.OQ((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = p.aVz(((k.b)localObject1).lmA);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).lpz.iterator();
      if (localIterator.hasNext())
      {
        anm localanm = (anm)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localanm.SyI;
        if (Util.isNullOrNil(localanm.Szh)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localanm.SyG.Szn;
            if (!((ano)localObject1).SzY) {
              continue;
            }
            localObject1 = ((ano)localObject1).fLi;
            localObject1 = com.tencent.mm.am.d.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.ZYt = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localanm.SyK).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.wpR = l1;
          localWWMediaConversation.ZYu = a(paramas, localanm, paramca, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localanm.Szh);
          continue;
          if (((ano)localObject1).SAc) {
            localObject1 = ((ano)localObject1).SAb;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(Context paramContext, as paramas, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(287824);
    int i = paramca.getType();
    if (bs.W(paramca))
    {
      paramContext = new WWMediaText(paramContext.getString(R.l.app_msg));
      AppMethodBeat.o(287824);
      return paramContext;
    }
    if (i == 1)
    {
      paramContext = new WWMediaText(k.E(paramca.field_content, paramca.field_isSend, paramBoolean));
      AppMethodBeat.o(287824);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = cj(paramca);
      AppMethodBeat.o(287824);
      return paramContext;
    }
    if (i == 43)
    {
      paramContext = new WWMediaVideo();
      paramas = y.Yk(paramca.field_imgPath);
      s.bqB();
      paramContext.filePath = bzc(x.XT(paramas.getFileName()));
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramContext.filePath });
      AppMethodBeat.o(287824);
      return paramContext;
    }
    if (i == 48)
    {
      paramContext = new WWMediaLocation();
      paramas = k.E(paramca.field_content, paramca.field_isSend, paramBoolean);
      bh.beI();
      paramas = com.tencent.mm.model.c.bbO().aOV(paramas);
      paramContext.title = paramas.poiName;
      paramContext.lLg = paramas.label;
      paramContext.longitude = paramas.Ejo;
      paramContext.latitude = paramas.Ejn;
      paramContext.ZYv = paramas.fKJ;
      AppMethodBeat.o(287824);
      return paramContext;
    }
    if ((i == 49) || (i == 268435505) || (i == 1090519089))
    {
      paramContext = a(paramas, paramca, paramBoolean);
      AppMethodBeat.o(287824);
      return paramContext;
    }
    Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(287824);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(Context paramContext, as paramas, List<ca> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(287826);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramas.field_username;
    Object localObject1 = MMApplicationContext.getContext();
    if (paramBoolean) {
      localObject1 = ((Context)localObject1).getString(R.l.record_chatroom_title);
    }
    for (;;)
    {
      localWWMediaMergedConvs.title = ((String)localObject1);
      localObject1 = paramList.iterator();
      label55:
      Object localObject2;
      label99:
      Object localObject4;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ca)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((et)localObject2).field_isSend == 1)
        {
          paramList = z.bcZ();
          localObject4 = com.tencent.mm.openim.room.a.a.V(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbL().RG(paramList));
          ((WWMediaConversation)localObject3).name = (aa.PI(paramList) + Util.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.am.d.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).ZYt = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label198:
        ((WWMediaConversation)localObject3).wpR = ((et)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).ZYu = a(paramContext, paramas, (ca)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label55;
        localObject2 = z.bdb();
        localObject3 = aa.PI((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(R.l.favorite_record_chatroom_title, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(R.l.favorite_record_chat_title, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((et)localObject2).field_talker;
          break label99;
        }
        paramList = bq.RL(((et)localObject2).field_content);
        break label99;
        AppMethodBeat.o(287826);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramList)
      {
        break label198;
      }
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(as paramas, anm paramanm, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramanm.dataType;
    if (i == 1)
    {
      paramas = new WWMediaText(paramanm.desc);
      AppMethodBeat.o(34923);
      return paramas;
    }
    long l;
    if (i == 2)
    {
      l = paramca.field_msgId;
      if (!e.avA()) {
        paramanm = null;
      }
      while (Util.isNullOrNil(paramanm))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        paramca = p.c(paramanm, l);
        paramas = paramca;
        if (Util.isNullOrNil(paramca)) {
          paramas = p.f(paramanm, l);
        }
        if (!Util.isNullOrNil(paramas))
        {
          paramanm = paramas;
          if (u.agG(paramas)) {}
        }
        else
        {
          Log.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramas });
          paramanm = null;
        }
      }
      paramas = new WWMediaImage();
      paramas.filePath = bzc(paramanm);
      Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramas.filePath });
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 4)
    {
      paramas = p.c(paramanm, paramca.field_msgId);
      if ((Util.isNullOrNil(paramas)) || (!com.tencent.mm.pluginsdk.k.a.d.a.agG(paramas)))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramanm = new WWMediaVideo();
      paramanm.filePath = bzc(paramas);
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramanm.filePath });
      AppMethodBeat.o(34923);
      return paramanm;
    }
    if (i == 6)
    {
      paramas = new WWMediaLocation();
      if (paramanm.SyG == null)
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramca = paramanm.SyG.Szp;
      if (paramca == null)
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramanm.fEa });
        AppMethodBeat.o(34923);
        return null;
      }
      paramas.title = paramca.fPN;
      paramas.lLg = paramca.label;
      paramas.longitude = paramca.lng;
      paramas.latitude = paramca.lat;
      paramas.ZYv = paramca.fKJ;
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 8)
    {
      paramas = p.c(paramanm, paramca.field_msgId);
      if (Util.isNullOrNil(paramas))
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramanm.fEa });
        AppMethodBeat.o(34923);
        return null;
      }
      l = com.tencent.mm.n.c.awK();
      if (com.tencent.mm.pluginsdk.k.a.d.a.ij(paramas) > l)
      {
        paramas = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramas;
      }
      paramca = new WWMediaFile();
      paramca.fileName = paramanm.title;
      paramca.filePath = bzc(paramas);
      paramca.setContentLengthLimit((int)l);
      AppMethodBeat.o(34923);
      return paramca;
    }
    if (i == 17)
    {
      paramas = a(paramanm, paramca, paramas, paramBoolean);
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 19)
    {
      paramas = paramanm.SyG.SzE;
      paramanm = new WWMediaMiniProgram();
      paramanm.username = paramas.username;
      paramanm.path = paramas.fve;
      paramanm.iconUrl = paramas.iconUrl;
      paramanm.ZYw = new byte[1];
      paramanm.name = paramas.SxE;
      paramanm.title = "";
      paramanm.type = paramas.type;
      Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramanm.username, paramanm.path, paramanm.iconUrl, Integer.valueOf(paramanm.ZYw.length), paramanm.name, paramanm.title });
      AppMethodBeat.o(34923);
      return paramanm;
    }
    Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(as paramas, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject2 = paramca.field_content;
    Object localObject1 = localObject2;
    if (paramBoolean)
    {
      int i = paramca.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramca.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.aG((String)localObject1, paramca.field_reserved);; localObject1 = null)
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
        paramas = new WWMediaLink();
        paramas.webpageUrl = ((k.b)localObject1).url;
        paramas.title = ((k.b)localObject1).title;
        paramas.description = ((k.b)localObject1).description;
        paramas.setThumbImage(q.bmh().a(paramca.field_imgPath, com.tencent.mm.ci.a.getDensity(null), false));
      }
      try
      {
        paramca = q.bmh().a(paramca.field_imgPath, com.tencent.mm.ci.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        paramca.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramas.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paramas;
        if ((((k.b)localObject1).fvr != null) && (((k.b)localObject1).fvr.length() > 0))
        {
          paramas = com.tencent.mm.pluginsdk.model.app.ao.ctZ().bpR(((k.b)localObject1).fvr);
          if ((paramas != null) && (paramas.evg()))
          {
            paramas = paramas.field_fileFullPath;
            if (!u.agG(paramas))
            {
              Log.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramas, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            paramca = new WWMediaImage();
            paramca.filePath = bzc(paramas);
            Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramca.filePath });
            AppMethodBeat.o(34926);
            return paramca;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.bqf(((k.b)localObject1).fvr);
        paramas = (as)localObject2;
        if (localObject2 == null) {
          paramas = com.tencent.mm.pluginsdk.model.app.ao.ctZ().TR(paramca.field_msgId);
        }
        long l = com.tencent.mm.n.c.awK();
        if (paramas.field_totalLen > l)
        {
          paramas = new a((byte)0);
          AppMethodBeat.o(34926);
          throw paramas;
        }
        paramca = new WWMediaFile();
        paramca.fileName = ((k.b)localObject1).title;
        paramca.filePath = bzc(paramas.field_fileFullPath);
        paramca.setContentLengthLimit((int)l);
        AppMethodBeat.o(34926);
        return paramca;
        paramas = a(paramca, paramas, paramBoolean);
        AppMethodBeat.o(34926);
        return paramas;
        if (((k.b)localObject1).loC == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paramas = new WWMediaMiniProgram();
        paramas.username = ((k.b)localObject1).loA;
        paramas.path = ((k.b)localObject1).loz;
        paramas.iconUrl = ((k.b)localObject1).loV;
        paramca = q.bmh().d(paramca.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.k.a.d.a.agG(paramca)) {}
        for (;;)
        {
          try
          {
            paramca = com.tencent.mm.plugin.gallery.model.n.aIt(paramca);
            localObject2 = new ByteArrayOutputStream();
            paramca.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramas.ZYw = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramas.ZYw.length > 1048576)
            {
              Log.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramas.ZYw = new byte[1];
            }
            paramas.name = ((k.b)localObject1).fUe;
            paramas.title = ((k.b)localObject1).title;
            paramas.type = ((k.b)localObject1).loC;
            Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramas.username, paramas.path, paramas.iconUrl, Integer.valueOf(paramas.ZYw.length), paramas.name, paramas.title });
            AppMethodBeat.o(34926);
            return paramas;
          }
          catch (Exception paramca)
          {
            Log.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramca.getMessage() });
          }
          paramas.ZYw = new byte[1];
        }
      }
      catch (Exception paramca)
      {
        break label249;
      }
    }
  }
  
  public static boolean a(Context paramContext, final as paramas, final List<ca> paramList, final boolean paramBoolean, final IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(287821);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(287821);
      return false;
    }
    if (k.ka(paramList))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eAu), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, null);
      AppMethodBeat.o(287821);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!ac.bV((ca)localIterator.next()))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(R.l.eEx), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(287821);
        return false;
      }
    }
    if (!k.a(true, paramList, paramas.field_username, null))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(R.l.eIa), "", paramContext.getString(R.l.retransmit), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34920);
          ao.c(this.val$context, paramas, paramList, paramBoolean, paramWWAppType);
          AppMethodBeat.o(34920);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(280201);
          com.tencent.mm.plugin.selectrecord.b.b.fFC().fFE();
          AppMethodBeat.o(280201);
        }
      });
      AppMethodBeat.o(287821);
      return true;
    }
    b(paramContext, paramas, paramList, paramBoolean, paramWWAppType);
    AppMethodBeat.o(287821);
    return true;
  }
  
  public static boolean a(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(287819);
    boolean bool = WWAPIFactory.mw(paramContext).a(paramWWAppType);
    AppMethodBeat.o(287819);
    return bool;
  }
  
  public static String b(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(287820);
    IWWAPI localIWWAPI = WWAPIFactory.mw(paramContext);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(R.l.wecom_name);
      AppMethodBeat.o(287820);
      return paramContext;
    }
    paramContext = localIWWAPI.b(paramWWAppType);
    AppMethodBeat.o(287820);
    return paramContext;
  }
  
  private static void b(Context paramContext, as paramas, List<ca> paramList, boolean paramBoolean, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(287822);
    IWWAPI localIWWAPI = WWAPIFactory.mw(paramContext);
    for (;;)
    {
      try
      {
        if (paramList.size() != 1) {
          continue;
        }
        paramas = a(paramContext, paramas, (ca)paramList.get(0), paramBoolean);
        localIWWAPI.a(paramas, paramWWAppType);
        com.tencent.mm.plugin.selectrecord.b.b.fFC().aej(1);
      }
      catch (a paramas)
      {
        long l = com.tencent.mm.n.c.awK() / 1048576L;
        com.tencent.mm.ui.base.h.c(paramContext, paramContext.getResources().getString(R.l.eSm, new Object[] { Long.valueOf(l) }), paramContext.getResources().getString(R.l.app_tip), true);
        com.tencent.mm.plugin.selectrecord.b.b.fFC().aej(2);
        continue;
      }
      com.tencent.mm.plugin.selectrecord.b.b.fFC().bpa();
      AppMethodBeat.o(287822);
      return;
      paramas = a(paramContext, paramas, paramList, paramBoolean);
    }
  }
  
  private static String bzc(String paramString)
  {
    AppMethodBeat.i(287827);
    if ((!Util.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (WEm == null) {
          WEm = new File(com.tencent.mm.loader.j.b.aSG()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = WEm + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (u.agG((String)localObject)) {
          u.deleteFile((String)localObject);
        }
        if (!u.agG(str)) {
          u.bBD(str);
        }
        FilesCopy.copy(paramString, (String)localObject, false);
        Log.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, Util.getStack().toString() });
        AppMethodBeat.o(287827);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(287827);
    return paramString;
  }
  
  private static WWMediaMessage.WWMediaObject cj(ca paramca)
  {
    AppMethodBeat.i(34925);
    if (paramca.field_msgId > 0L) {}
    for (Object localObject1 = q.bmh().D(paramca.field_talker, paramca.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((g)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramca.field_msgSvrId > 0L) {
          localObject2 = q.bmh().C(paramca.field_talker, paramca.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      paramca = q.bmh().r(com.tencent.mm.ay.h.c((g)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = bzc(paramca);
      Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */