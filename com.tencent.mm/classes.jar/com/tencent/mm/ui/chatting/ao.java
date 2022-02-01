package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.av.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.br;
import com.tencent.mm.model.z;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.record.b.p;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.protocal.protobuf.amj;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.protocal.protobuf.ams;
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
  private static String PkD = null;
  
  private static WWMediaMergedConvs a(aml paramaml, ca paramca, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramaml == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramaml = p.aKY(paramaml.Lwx);
    if (paramaml == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramaml.title;
    Iterator localIterator = paramaml.iAd.iterator();
    if (localIterator.hasNext())
    {
      aml localaml = (aml)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramaml = localaml.Lwj;
      if (Util.isNullOrNil(localaml.LwI)) {
        localWWMediaConversation.name = paramaml;
      }
      for (;;)
      {
        try
        {
          paramaml = localaml.Lwh.LwO;
          if (!paramaml.Lxx) {
            continue;
          }
          paramaml = paramaml.dRL;
          paramaml = com.tencent.mm.aj.c.a(paramaml, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramaml.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.Sxt = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramaml)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localaml.Lwl).getTime();
          l1 = l2;
        }
        catch (ParseException paramaml)
        {
          continue;
        }
        localWWMediaConversation.sJT = l1;
        localWWMediaConversation.Sxu = a(paramas, localaml, paramca, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramaml + localaml.LwI);
        continue;
        if (paramaml.LxB) {
          paramaml = paramaml.LxA;
        } else {
          paramaml = "";
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
    if (ab.Eq(paramca.field_talker)) {
      localObject1 = bp.Kt(paramca.field_content);
    }
    localObject1 = k.b.HD((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = p.aKY(((k.b)localObject1).ixl);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).iAd.iterator();
      if (localIterator.hasNext())
      {
        aml localaml = (aml)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localaml.Lwj;
        if (Util.isNullOrNil(localaml.LwI)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localaml.Lwh.LwO;
            if (!((amn)localObject1).Lxx) {
              continue;
            }
            localObject1 = ((amn)localObject1).dRL;
            localObject1 = com.tencent.mm.aj.c.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.Sxt = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localaml.Lwl).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.sJT = l1;
          localWWMediaConversation.Sxu = a(paramas, localaml, paramca, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localaml.LwI);
          continue;
          if (((amn)localObject1).LxB) {
            localObject1 = ((amn)localObject1).LxA;
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
    AppMethodBeat.i(232919);
    int i = paramca.getType();
    if (br.Q(paramca))
    {
      paramContext = new WWMediaText(paramContext.getString(2131755901));
      AppMethodBeat.o(232919);
      return paramContext;
    }
    if (i == 1)
    {
      paramContext = new WWMediaText(k.A(paramca.field_content, paramca.field_isSend, paramBoolean));
      AppMethodBeat.o(232919);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = bP(paramca);
      AppMethodBeat.o(232919);
      return paramContext;
    }
    if (i == 43)
    {
      paramContext = new WWMediaVideo();
      paramas = u.QN(paramca.field_imgPath);
      o.bhj();
      paramContext.filePath = bmB(t.Qw(paramas.getFileName()));
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramContext.filePath });
      AppMethodBeat.o(232919);
      return paramContext;
    }
    if (i == 48)
    {
      paramContext = new WWMediaLocation();
      paramas = k.A(paramca.field_content, paramca.field_isSend, paramBoolean);
      bg.aVF();
      paramas = com.tencent.mm.model.c.aSQ().aEL(paramas);
      paramContext.title = paramas.kHV;
      paramContext.iUO = paramas.label;
      paramContext.longitude = paramas.yFv;
      paramContext.latitude = paramas.yFu;
      paramContext.Sxv = paramas.dRt;
      AppMethodBeat.o(232919);
      return paramContext;
    }
    if ((i == 49) || (i == 268435505))
    {
      paramContext = a(paramas, paramca, paramBoolean);
      AppMethodBeat.o(232919);
      return paramContext;
    }
    Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(232919);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(Context paramContext, as paramas, List<ca> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(232920);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramas.field_username;
    Object localObject1 = MMApplicationContext.getContext();
    if (paramBoolean) {
      localObject1 = ((Context)localObject1).getString(2131764266);
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
        if (((eo)localObject2).field_isSend == 1)
        {
          paramList = z.aTY();
          localObject4 = com.tencent.mm.openim.room.a.a.O(((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(paramList));
          ((WWMediaConversation)localObject3).name = (aa.Ir(paramList) + Util.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.aj.c.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).Sxt = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label198:
        ((WWMediaConversation)localObject3).sJT = ((eo)localObject2).field_createTime;
        ((WWMediaConversation)localObject3).Sxu = a(paramContext, paramas, (ca)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label55;
        localObject2 = z.aUa();
        localObject3 = aa.Ir((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(2131759288, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(2131759287, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((eo)localObject2).field_talker;
          break label99;
        }
        paramList = bp.Ks(((eo)localObject2).field_content);
        break label99;
        AppMethodBeat.o(232920);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramList)
      {
        break label198;
      }
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(as paramas, aml paramaml, ca paramca, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramaml.dataType;
    if (i == 1)
    {
      paramas = new WWMediaText(paramaml.desc);
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 2)
    {
      long l = paramca.field_msgId;
      if (!e.apn()) {
        paramaml = null;
      }
      while (Util.isNullOrNil(paramaml))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        paramca = p.c(paramaml, l);
        paramas = paramca;
        if (Util.isNullOrNil(paramca)) {
          paramas = p.f(paramaml, l);
        }
        if (!Util.isNullOrNil(paramas))
        {
          paramaml = paramas;
          if (com.tencent.mm.vfs.s.YS(paramas)) {}
        }
        else
        {
          Log.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramas });
          paramaml = null;
        }
      }
      paramas = new WWMediaImage();
      paramas.filePath = bmB(paramaml);
      Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramas.filePath });
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 4)
    {
      paramas = p.c(paramaml, paramca.field_msgId);
      if ((Util.isNullOrNil(paramas)) || (!com.tencent.mm.pluginsdk.j.a.d.a.YS(paramas)))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramaml = new WWMediaVideo();
      paramaml.filePath = bmB(paramas);
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramaml.filePath });
      AppMethodBeat.o(34923);
      return paramaml;
    }
    if (i == 6)
    {
      paramas = new WWMediaLocation();
      if (paramaml.Lwh == null)
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramca = paramaml.Lwh.LwQ;
      if (paramca == null)
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramaml.dLl });
        AppMethodBeat.o(34923);
        return null;
      }
      paramas.title = paramca.dWi;
      paramas.iUO = paramca.label;
      paramas.longitude = paramca.lng;
      paramas.latitude = paramca.lat;
      paramas.Sxv = paramca.dRt;
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 8)
    {
      paramas = p.c(paramaml, paramca.field_msgId);
      if (Util.isNullOrNil(paramas))
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramaml.dLl });
        AppMethodBeat.o(34923);
        return null;
      }
      i = com.tencent.mm.n.c.aqr();
      if (com.tencent.mm.pluginsdk.j.a.d.a.hv(paramas) > i)
      {
        paramas = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramas;
      }
      paramca = new WWMediaFile();
      paramca.fileName = paramaml.title;
      paramca.filePath = bmB(paramas);
      paramca.setContentLengthLimit(i);
      AppMethodBeat.o(34923);
      return paramca;
    }
    if (i == 17)
    {
      paramas = a(paramaml, paramca, paramas, paramBoolean);
      AppMethodBeat.o(34923);
      return paramas;
    }
    if (i == 19)
    {
      paramas = paramaml.Lwh.Lxf;
      paramaml = new WWMediaMiniProgram();
      paramaml.username = paramas.username;
      paramaml.path = paramas.dCx;
      paramaml.iconUrl = paramas.iconUrl;
      paramaml.Sxw = new byte[1];
      paramaml.name = paramas.Lve;
      paramaml.title = "";
      paramaml.type = paramas.type;
      Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramaml.username, paramaml.path, paramaml.iconUrl, Integer.valueOf(paramaml.Sxw.length), paramaml.name, paramaml.title });
      AppMethodBeat.o(34923);
      return paramaml;
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
    int i;
    if (paramBoolean)
    {
      i = paramca.field_content.indexOf(':');
      localObject1 = localObject2;
      if (i != -1) {
        localObject1 = paramca.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    for (localObject1 = k.b.aD((String)localObject1, paramca.field_reserved);; localObject1 = null)
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
        paramas.setThumbImage(q.bcR().a(paramca.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false));
      }
      try
      {
        paramca = q.bcR().a(paramca.field_imgPath, com.tencent.mm.cb.a.getDensity(null), false);
        localObject1 = new ByteArrayOutputStream();
        paramca.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
        paramas.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
        ((ByteArrayOutputStream)localObject1).close();
        label249:
        AppMethodBeat.o(34926);
        return paramas;
        if ((((k.b)localObject1).dCK != null) && (((k.b)localObject1).dCK.length() > 0))
        {
          paramas = com.tencent.mm.pluginsdk.model.app.ao.cgO().bdx(((k.b)localObject1).dCK);
          if ((paramas != null) && (paramas.deQ()))
          {
            paramas = paramas.field_fileFullPath;
            if (!com.tencent.mm.vfs.s.YS(paramas))
            {
              Log.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramas, Long.valueOf(paramca.field_msgId), Long.valueOf(paramca.field_msgSvrId) });
              AppMethodBeat.o(34926);
              return null;
            }
            paramca = new WWMediaImage();
            paramca.filePath = bmB(paramas);
            Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramca.filePath });
            AppMethodBeat.o(34926);
            return paramca;
          }
        }
        AppMethodBeat.o(34926);
        return null;
        localObject2 = m.bdJ(((k.b)localObject1).dCK);
        paramas = (as)localObject2;
        if (localObject2 == null) {
          paramas = com.tencent.mm.pluginsdk.model.app.ao.cgO().Mp(paramca.field_msgId);
        }
        i = com.tencent.mm.n.c.aqr();
        if (paramas.field_totalLen > i)
        {
          paramas = new a((byte)0);
          AppMethodBeat.o(34926);
          throw paramas;
        }
        paramca = new WWMediaFile();
        paramca.fileName = ((k.b)localObject1).title;
        paramca.filePath = bmB(paramas.field_fileFullPath);
        paramca.setContentLengthLimit(i);
        AppMethodBeat.o(34926);
        return paramca;
        paramas = a(paramca, paramas, paramBoolean);
        AppMethodBeat.o(34926);
        return paramas;
        if (((k.b)localObject1).izk == 3)
        {
          AppMethodBeat.o(34926);
          return null;
        }
        paramas = new WWMediaMiniProgram();
        paramas.username = ((k.b)localObject1).izi;
        paramas.path = ((k.b)localObject1).izh;
        paramas.iconUrl = ((k.b)localObject1).izB;
        paramca = q.bcR().d(paramca.field_imgPath, false, true);
        if (com.tencent.mm.pluginsdk.j.a.d.a.YS(paramca)) {}
        for (;;)
        {
          try
          {
            paramca = n.ayT(paramca);
            localObject2 = new ByteArrayOutputStream();
            paramca.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject2);
            paramas.Sxw = ((ByteArrayOutputStream)localObject2).toByteArray();
            ((ByteArrayOutputStream)localObject2).close();
            if (paramas.Sxw.length > 1048576)
            {
              Log.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
              paramas.Sxw = new byte[1];
            }
            paramas.name = ((k.b)localObject1).eah;
            paramas.title = ((k.b)localObject1).title;
            paramas.type = ((k.b)localObject1).izk;
            Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramas.username, paramas.path, paramas.iconUrl, Integer.valueOf(paramas.Sxw.length), paramas.name, paramas.title });
            AppMethodBeat.o(34926);
            return paramas;
          }
          catch (Exception paramca)
          {
            Log.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramca.getMessage() });
          }
          paramas.Sxw = new byte[1];
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
    AppMethodBeat.i(232917);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(232917);
      return false;
    }
    if (k.ji(paramList))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131758181), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      }, null);
      AppMethodBeat.o(232917);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!ac.bB((ca)localIterator.next()))
      {
        com.tencent.mm.ui.base.h.a(paramContext, paramContext.getString(2131759141), "", paramContext.getString(2131768713), null);
        AppMethodBeat.o(232917);
        return false;
      }
    }
    if (!k.a(true, paramList, paramas.field_username, null))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      com.tencent.mm.ui.base.h.c(paramContext, paramContext.getString(2131761794), "", paramContext.getString(2131764628), paramContext.getString(2131755761), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
          AppMethodBeat.i(232914);
          com.tencent.mm.plugin.selectrecord.b.b.eSz().eSB();
          AppMethodBeat.o(232914);
        }
      });
      AppMethodBeat.o(232917);
      return true;
    }
    b(paramContext, paramas, paramList, paramBoolean, paramWWAppType);
    AppMethodBeat.o(232917);
    return true;
  }
  
  public static boolean a(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(232915);
    boolean bool = WWAPIFactory.ly(paramContext).a(paramWWAppType);
    AppMethodBeat.o(232915);
    return bool;
  }
  
  public static String b(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(232916);
    IWWAPI localIWWAPI = WWAPIFactory.ly(paramContext);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(2131768704);
      AppMethodBeat.o(232916);
      return paramContext;
    }
    paramContext = localIWWAPI.b(paramWWAppType);
    AppMethodBeat.o(232916);
    return paramContext;
  }
  
  private static void b(Context paramContext, as paramas, List<ca> paramList, boolean paramBoolean, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(232918);
    IWWAPI localIWWAPI = WWAPIFactory.ly(paramContext);
    for (;;)
    {
      try
      {
        if (paramList.size() != 1) {
          continue;
        }
        paramas = a(paramContext, paramas, (ca)paramList.get(0), paramBoolean);
        localIWWAPI.a(paramas, paramWWAppType);
        com.tencent.mm.plugin.selectrecord.b.b.eSz().Xk(1);
      }
      catch (a paramas)
      {
        int i = com.tencent.mm.n.c.aqr() / 1048576;
        com.tencent.mm.ui.base.h.c(paramContext, paramContext.getResources().getString(2131765233, new Object[] { Integer.valueOf(i) }), paramContext.getResources().getString(2131755998), true);
        com.tencent.mm.plugin.selectrecord.b.b.eSz().Xk(2);
        continue;
      }
      com.tencent.mm.plugin.selectrecord.b.b.eSz().bfK();
      AppMethodBeat.o(232918);
      return;
      paramas = a(paramContext, paramas, paramList, paramBoolean);
    }
  }
  
  private static WWMediaMessage.WWMediaObject bP(ca paramca)
  {
    AppMethodBeat.i(34925);
    if (paramca.field_msgId > 0L) {}
    for (Object localObject1 = q.bcR().H(paramca.field_talker, paramca.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.av.g)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramca.field_msgSvrId > 0L) {
          localObject2 = q.bcR().G(paramca.field_talker, paramca.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      paramca = q.bcR().o(com.tencent.mm.av.h.c((com.tencent.mm.av.g)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = bmB(paramca);
      Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      AppMethodBeat.o(34925);
      return localObject1;
    }
  }
  
  private static String bmB(String paramString)
  {
    AppMethodBeat.i(232921);
    if ((!Util.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (PkD == null) {
          PkD = new File(com.tencent.mm.loader.j.b.aKE()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = PkD + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (com.tencent.mm.vfs.s.YS((String)localObject)) {
          com.tencent.mm.vfs.s.deleteFile((String)localObject);
        }
        if (!com.tencent.mm.vfs.s.YS(str)) {
          com.tencent.mm.vfs.s.boN(str);
        }
        FilesCopy.copy(paramString, (String)localObject, false);
        Log.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, Util.getStack().toString() });
        AppMethodBeat.o(232921);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(232921);
    return paramString;
  }
  
  static final class a
    extends Exception
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ao
 * JD-Core Version:    0.7.0.1
 */