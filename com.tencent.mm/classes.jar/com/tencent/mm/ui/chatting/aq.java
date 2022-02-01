package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.br;
import com.tencent.mm.model.bt;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.ab;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.gallery.model.p;
import com.tencent.mm.plugin.record.model.q;
import com.tencent.mm.pluginsdk.model.app.as;
import com.tencent.mm.protocal.protobuf.ard;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.sdk.platformtools.FilesCopy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMStack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo;
import com.tencent.mm.sdk.platformtools.WeChatBrands.AppInfo.WhichApp;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cc.c;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;
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

public final class aq
{
  private static String aelM = null;
  
  private static WWMediaMergedConvs a(arf paramarf, cc paramcc, au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(34927);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    if (paramarf == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    paramarf = q.aSH(paramarf.ZzO);
    if (paramarf == null)
    {
      AppMethodBeat.o(34927);
      return localWWMediaMergedConvs;
    }
    localWWMediaMergedConvs.title = paramarf.title;
    Iterator localIterator = paramarf.nUC.iterator();
    if (localIterator.hasNext())
    {
      arf localarf = (arf)localIterator.next();
      WWMediaConversation localWWMediaConversation = new WWMediaConversation();
      paramarf = localarf.ZzA;
      if (Util.isNullOrNil(localarf.ZzZ)) {
        localWWMediaConversation.name = paramarf;
      }
      for (;;)
      {
        try
        {
          paramarf = localarf.Zzy.ZAf;
          if (!paramarf.ZAQ) {
            continue;
          }
          paramarf = paramarf.hQQ;
          paramarf = com.tencent.mm.modelavatar.d.a(paramarf, false, -1, null);
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          paramarf.compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
          localWWMediaConversation.aicW = localByteArrayOutputStream.toByteArray();
          localByteArrayOutputStream.close();
        }
        catch (Exception paramarf)
        {
          long l1;
          continue;
        }
        l1 = 0L;
        try
        {
          long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localarf.ZzC).getTime();
          l1 = l2;
        }
        catch (ParseException paramarf)
        {
          continue;
        }
        localWWMediaConversation.zLU = l1;
        localWWMediaConversation.aicX = a(paramau, localarf, paramcc, paramBoolean);
        localWWMediaMergedConvs.a(localWWMediaConversation);
        break;
        localWWMediaConversation.name = (paramarf + localarf.ZzZ);
        continue;
        if (paramarf.ZAU) {
          paramarf = paramarf.ZAT;
        } else {
          paramarf = "";
        }
      }
    }
    AppMethodBeat.o(34927);
    return localWWMediaMergedConvs;
  }
  
  private static WWMediaMergedConvs a(cc paramcc, au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(34928);
    Object localObject1 = paramcc.field_content;
    if (au.bwE(paramcc.field_talker)) {
      localObject1 = br.JK(paramcc.field_content);
    }
    localObject1 = k.b.Hf((String)localObject1);
    if (localObject1 != null) {}
    Object localObject2;
    for (localObject1 = q.aSH(((k.b)localObject1).nRF);; localObject2 = null)
    {
      WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
      if (localObject1 == null)
      {
        AppMethodBeat.o(34928);
        return localWWMediaMergedConvs;
      }
      localWWMediaMergedConvs.title = ((com.tencent.mm.protocal.b.a.c)localObject1).title;
      Iterator localIterator = ((com.tencent.mm.protocal.b.a.c)localObject1).nUC.iterator();
      if (localIterator.hasNext())
      {
        arf localarf = (arf)localIterator.next();
        WWMediaConversation localWWMediaConversation = new WWMediaConversation();
        localObject1 = localarf.ZzA;
        if (Util.isNullOrNil(localarf.ZzZ)) {
          localWWMediaConversation.name = ((String)localObject1);
        }
        for (;;)
        {
          try
          {
            localObject1 = localarf.Zzy.ZAf;
            if (!((arh)localObject1).ZAQ) {
              continue;
            }
            localObject1 = ((arh)localObject1).hQQ;
            localObject1 = com.tencent.mm.modelavatar.d.a((String)localObject1, false, -1, null);
            ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
            ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 50, localByteArrayOutputStream);
            localWWMediaConversation.aicW = localByteArrayOutputStream.toByteArray();
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
            long l2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(localarf.ZzC).getTime();
            l1 = l2;
          }
          catch (ParseException localParseException)
          {
            continue;
          }
          localWWMediaConversation.zLU = l1;
          localWWMediaConversation.aicX = a(paramau, localarf, paramcc, paramBoolean);
          localWWMediaMergedConvs.a(localWWMediaConversation);
          break;
          localWWMediaConversation.name = ((String)localObject1 + localarf.ZzZ);
          continue;
          if (((arh)localObject1).ZAU) {
            localObject1 = ((arh)localObject1).ZAT;
          } else {
            localObject1 = "";
          }
        }
      }
      AppMethodBeat.o(34928);
      return localWWMediaMergedConvs;
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(Context paramContext, au paramau, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(253772);
    int i = paramcc.getType();
    if (bt.aa(paramcc))
    {
      paramContext = new WWMediaText(paramContext.getString(R.l.app_msg));
      AppMethodBeat.o(253772);
      return paramContext;
    }
    if (i == 1)
    {
      paramContext = new WWMediaText(m.G(paramcc.field_content, paramcc.field_isSend, paramBoolean));
      AppMethodBeat.o(253772);
      return paramContext;
    }
    if (i == 3)
    {
      paramContext = cx(paramcc);
      AppMethodBeat.o(253772);
      return paramContext;
    }
    if (i == 43)
    {
      paramContext = new WWMediaVideo();
      paramau = ab.Qo(paramcc.field_imgPath);
      v.bOh();
      paramContext.filePath = bAG(com.tencent.mm.modelvideo.aa.PX(paramau.getFileName()));
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramContext.filePath });
      AppMethodBeat.o(253772);
      return paramContext;
    }
    if (i == 48)
    {
      paramContext = new WWMediaLocation();
      paramau = m.G(paramcc.field_content, paramcc.field_isSend, paramBoolean);
      bh.bCz();
      paramau = com.tencent.mm.model.c.bzD().aLV(paramau);
      paramContext.title = paramau.poiName;
      paramContext.oDI = paramau.label;
      paramContext.longitude = paramau.KbX;
      paramContext.latitude = paramau.KbW;
      paramContext.aicZ = paramau.hQp;
      AppMethodBeat.o(253772);
      return paramContext;
    }
    if ((i == 49) || (i == 268435505) || (i == 1090519089))
    {
      paramContext = a(paramau, paramcc, paramBoolean);
      AppMethodBeat.o(253772);
      return paramContext;
    }
    Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(253772);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(Context paramContext, au paramau, List<cc> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(253783);
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject3 = paramau.field_username;
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
        localObject2 = (cc)((Iterator)localObject1).next();
        localObject3 = new WWMediaConversation();
        if (((fi)localObject2).field_isSend == 1)
        {
          paramList = com.tencent.mm.model.z.bAM();
          localObject4 = com.tencent.mm.openim.room.a.a.X(((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramList));
          ((WWMediaConversation)localObject3).name = (com.tencent.mm.model.aa.ID(paramList) + Util.nullAsNil((String)localObject4));
        }
      }
      try
      {
        paramList = com.tencent.mm.modelavatar.d.a(paramList, false, -1, null);
        localObject4 = new ByteArrayOutputStream();
        paramList.compress(Bitmap.CompressFormat.JPEG, 50, (OutputStream)localObject4);
        ((WWMediaConversation)localObject3).aicW = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        label198:
        ((WWMediaConversation)localObject3).zLU = ((cc)localObject2).getCreateTime();
        ((WWMediaConversation)localObject3).aicX = a(paramContext, paramau, (cc)localObject2, paramBoolean);
        localWWMediaMergedConvs.a((WWMediaConversation)localObject3);
        break label55;
        localObject2 = com.tencent.mm.model.z.bAO();
        localObject3 = com.tencent.mm.model.aa.ID((String)localObject3);
        if (((String)localObject2).equals(localObject3))
        {
          localObject1 = ((Context)localObject1).getString(R.l.favorite_record_chatroom_title, new Object[] { localObject2 });
          continue;
        }
        localObject1 = ((Context)localObject1).getString(R.l.favorite_record_chat_title, new Object[] { localObject2, localObject3 });
        continue;
        if (!paramBoolean)
        {
          paramList = ((fi)localObject2).field_talker;
          break label99;
        }
        paramList = br.JJ(((fi)localObject2).field_content);
        break label99;
        AppMethodBeat.o(253783);
        return localWWMediaMergedConvs;
      }
      catch (Exception paramList)
      {
        break label198;
      }
    }
  }
  
  private static WWMediaMessage.WWMediaObject a(au paramau, arf paramarf, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(34923);
    int i = paramarf.dataType;
    if (i == 1)
    {
      paramau = new WWMediaText(paramarf.desc);
      AppMethodBeat.o(34923);
      return paramau;
    }
    long l;
    if (i == 2)
    {
      l = paramcc.field_msgId;
      if (!e.aPU()) {
        paramarf = null;
      }
      while (Util.isNullOrNil(paramarf))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_IMG not exist!");
        AppMethodBeat.o(34923);
        return null;
        paramcc = q.c(paramarf, l);
        paramau = paramcc;
        if (Util.isNullOrNil(paramcc)) {
          paramau = q.f(paramarf, l);
        }
        if (!Util.isNullOrNil(paramau))
        {
          paramarf = paramau;
          if (y.ZC(paramau)) {}
        }
        else
        {
          Log.d("MicroMsg.RecordMsgImgService", "getPath file not exist, path[%s]", new Object[] { paramau });
          paramarf = null;
        }
      }
      paramau = new WWMediaImage();
      paramau.filePath = bAG(paramarf);
      Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramau.filePath });
      AppMethodBeat.o(34923);
      return paramau;
    }
    if (i == 4)
    {
      paramau = q.c(paramarf, paramcc.field_msgId);
      if ((Util.isNullOrNil(paramau)) || (!com.tencent.mm.pluginsdk.res.downloader.b.a.ZC(paramau)))
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_VIDEO not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramarf = new WWMediaVideo();
      paramarf.filePath = bAG(paramau);
      Log.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { paramarf.filePath });
      AppMethodBeat.o(34923);
      return paramarf;
    }
    if (i == 6)
    {
      paramau = new WWMediaLocation();
      if (paramarf.Zzy == null)
      {
        Log.i("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_LOC not exist!");
        AppMethodBeat.o(34923);
        return null;
      }
      paramcc = paramarf.Zzy.ZAh;
      if (paramcc == null)
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "location error, locItem null, dataid[%s]", new Object[] { paramarf.hIQ });
        AppMethodBeat.o(34923);
        return null;
      }
      paramau.title = paramcc.hVI;
      paramau.oDI = paramcc.label;
      paramau.longitude = paramcc.lng;
      paramau.latitude = paramcc.lat;
      paramau.aicZ = paramcc.hQp;
      AppMethodBeat.o(34923);
      return paramau;
    }
    if (i == 8)
    {
      paramau = q.c(paramarf, paramcc.field_msgId);
      if (Util.isNullOrNil(paramau))
      {
        Log.w("MicroMsg.SendToWeWorkHelper", "FAV_DATA_TYPE_FILE title == null, dataid[%s]", new Object[] { paramarf.hIQ });
        AppMethodBeat.o(34923);
        return null;
      }
      l = com.tencent.mm.k.c.aRk();
      if (com.tencent.mm.pluginsdk.res.downloader.b.a.jK(paramau) > l)
      {
        paramau = new a((byte)0);
        AppMethodBeat.o(34923);
        throw paramau;
      }
      paramcc = new WWMediaFile();
      paramcc.fileName = paramarf.title;
      paramcc.filePath = bAG(paramau);
      paramcc.contentLengthLimit = ((int)l);
      AppMethodBeat.o(34923);
      return paramcc;
    }
    if (i == 17)
    {
      paramau = a(paramarf, paramcc, paramau, paramBoolean);
      AppMethodBeat.o(34923);
      return paramau;
    }
    if (i == 19)
    {
      paramau = paramarf.Zzy.ZAw;
      paramarf = new WWMediaMiniProgram();
      paramarf.username = paramau.username;
      paramarf.path = paramau.hzy;
      paramarf.iconUrl = paramau.iconUrl;
      paramarf.aida = new byte[1];
      paramarf.name = paramau.Zyw;
      paramarf.title = "";
      paramarf.type = paramau.type;
      Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramarf.username, paramarf.path, paramarf.iconUrl, Integer.valueOf(paramarf.aida.length), paramarf.name, paramarf.title });
      AppMethodBeat.o(34923);
      return paramarf;
    }
    Log.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34923);
    return null;
  }
  
  private static WWMediaMessage.WWMediaObject a(au paramau, cc paramcc, boolean paramBoolean)
  {
    AppMethodBeat.i(34926);
    Object localObject3 = paramcc.field_content;
    Object localObject1 = localObject3;
    if (paramBoolean)
    {
      int i = paramcc.field_content.indexOf(':');
      localObject1 = localObject3;
      if (i != -1) {
        localObject1 = paramcc.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    label232:
    Object localObject2;
    for (localObject1 = k.b.aP((String)localObject1, paramcc.field_reserved);; localObject2 = null)
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
        paramau = new WWMediaLink();
        paramau.webpageUrl = ((k.b)localObject1).url;
        paramau.title = ((k.b)localObject1).title;
        paramau.description = ((k.b)localObject1).description;
        localObject1 = r.bKa().a(paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity(null), false);
      }
      try
      {
        localObject3 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject3);
        paramau.thumbData = ((ByteArrayOutputStream)localObject3).toByteArray();
        ((ByteArrayOutputStream)localObject3).close();
        try
        {
          paramcc = r.bKa().a(paramcc.field_imgPath, com.tencent.mm.cd.a.getDensity(null), false);
          localObject1 = new ByteArrayOutputStream();
          paramcc.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
          paramau.thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
          ((ByteArrayOutputStream)localObject1).close();
          label283:
          AppMethodBeat.o(34926);
          return paramau;
          if ((((k.b)localObject1).hzM != null) && (((k.b)localObject1).hzM.length() > 0))
          {
            paramau = as.cWJ().bpI(((k.b)localObject1).hzM);
            if ((paramau != null) && (paramau.efT()))
            {
              paramau = paramau.field_fileFullPath;
              if (!y.ZC(paramau))
              {
                Log.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { paramau, Long.valueOf(paramcc.field_msgId), Long.valueOf(paramcc.field_msgSvrId) });
                AppMethodBeat.o(34926);
                return null;
              }
              paramcc = new WWMediaImage();
              paramcc.filePath = bAG(paramau);
              Log.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { paramcc.filePath });
              AppMethodBeat.o(34926);
              return paramcc;
            }
          }
          AppMethodBeat.o(34926);
          return null;
          localObject3 = com.tencent.mm.pluginsdk.model.app.n.bpU(((k.b)localObject1).hzM);
          paramau = (au)localObject3;
          if (localObject3 == null) {
            paramau = as.cWJ().yi(paramcc.field_msgId);
          }
          long l = com.tencent.mm.k.c.aRk();
          if (paramau.field_totalLen > l)
          {
            paramau = new a((byte)0);
            AppMethodBeat.o(34926);
            throw paramau;
          }
          paramcc = new WWMediaFile();
          paramcc.fileName = ((k.b)localObject1).title;
          paramcc.filePath = bAG(paramau.field_fileFullPath);
          paramcc.contentLengthLimit = ((int)l);
          AppMethodBeat.o(34926);
          return paramcc;
          paramau = a(paramcc, paramau, paramBoolean);
          AppMethodBeat.o(34926);
          return paramau;
          if (((k.b)localObject1).nTF == 3)
          {
            AppMethodBeat.o(34926);
            return null;
          }
          paramau = new WWMediaMiniProgram();
          paramau.username = ((k.b)localObject1).nTD;
          paramau.path = ((k.b)localObject1).nTC;
          paramau.iconUrl = ((k.b)localObject1).nTY;
          paramcc = r.bKa().d(paramcc.field_imgPath, false, true);
          if (com.tencent.mm.pluginsdk.res.downloader.b.a.ZC(paramcc)) {}
          for (;;)
          {
            try
            {
              paramcc = p.aER(paramcc);
              localObject3 = new ByteArrayOutputStream();
              paramcc.compress(Bitmap.CompressFormat.JPEG, 70, (OutputStream)localObject3);
              paramau.aida = ((ByteArrayOutputStream)localObject3).toByteArray();
              ((ByteArrayOutputStream)localObject3).close();
              if (paramau.aida.length > 1048576)
              {
                Log.i("MicroMsg.SendToWeWorkHelper", "miniProgram.hdImageData.length > 1M");
                paramau.aida = new byte[1];
              }
              paramau.name = ((k.b)localObject1).iab;
              paramau.title = ((k.b)localObject1).title;
              paramau.type = ((k.b)localObject1).nTF;
              Log.d("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram[username:%s path:%s iconUrl:%s hdImageData:%s name:%s title:%s]", new Object[] { paramau.username, paramau.path, paramau.iconUrl, Integer.valueOf(paramau.aida.length), paramau.name, paramau.title });
              AppMethodBeat.o(34926);
              return paramau;
            }
            catch (Exception paramcc)
            {
              Log.i("MicroMsg.SendToWeWorkHelper", "WWMediaMiniProgram.hdImageData Exception:%s", new Object[] { paramcc.getMessage() });
            }
            paramau.aida = new byte[1];
          }
        }
        catch (Exception paramcc)
        {
          break label283;
        }
      }
      catch (Exception localException)
      {
        break label232;
      }
    }
  }
  
  public static boolean a(Context paramContext, final au paramau, final List<cc> paramList, final boolean paramBoolean, final IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(253764);
    if ((paramList == null) || (paramList.size() == 0))
    {
      AppMethodBeat.o(253764);
      return false;
    }
    if (m.nr(paramList))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "isContainPlaceHolderMsg");
      k.a(paramContext, paramContext.getString(R.l.gDj), "", paramContext.getString(R.l.gps), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      AppMethodBeat.o(253764);
      return false;
    }
    if (m.np(paramList))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "isContainUndownloadFile");
      k.a(paramContext, paramContext.getString(R.l.gDn), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(34920);
          AppMethodBeat.o(34920);
        }
      }, null);
      AppMethodBeat.o(253764);
      return false;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      if (!ae.cj((cc)localIterator.next()))
      {
        k.a(paramContext, paramContext.getString(R.l.gHq), "", paramContext.getString(R.l.welcome_i_know), null);
        AppMethodBeat.o(253764);
        return false;
      }
    }
    if (!m.a(true, paramList, paramau.field_username, null))
    {
      Log.w("MicroMsg.SendToWeWorkHelper", "handleInvalidSendToFriendMsg");
      k.b(paramContext, paramContext.getString(R.l.gJH), "", paramContext.getString(R.l.retransmit), paramContext.getString(R.l.app_cancel), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(254269);
          aq.c(aq.this, paramau, paramList, paramBoolean, paramWWAppType);
          AppMethodBeat.o(254269);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(254273);
          com.tencent.mm.plugin.selectrecord.b.d.gUK().gUM();
          AppMethodBeat.o(254273);
        }
      });
      AppMethodBeat.o(253764);
      return true;
    }
    b(paramContext, paramau, paramList, paramBoolean, paramWWAppType);
    AppMethodBeat.o(253764);
    return true;
  }
  
  public static boolean a(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(253754);
    boolean bool = WWAPIFactory.oM(paramContext).a(paramWWAppType);
    AppMethodBeat.o(253754);
    return bool;
  }
  
  public static String b(Context paramContext, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(253758);
    IWWAPI localIWWAPI = WWAPIFactory.oM(paramContext);
    if (!WeChatBrands.AppInfo.current().isMainland())
    {
      paramContext = paramContext.getString(R.l.wecom_name);
      AppMethodBeat.o(253758);
      return paramContext;
    }
    paramContext = localIWWAPI.b(paramWWAppType);
    AppMethodBeat.o(253758);
    return paramContext;
  }
  
  private static void b(Context paramContext, au paramau, List<cc> paramList, boolean paramBoolean, IWWAPI.WWAppType paramWWAppType)
  {
    AppMethodBeat.i(253768);
    IWWAPI localIWWAPI = WWAPIFactory.oM(paramContext);
    for (;;)
    {
      try
      {
        if (paramList.size() != 1) {
          continue;
        }
        paramau = a(paramContext, paramau, (cc)paramList.get(0), paramBoolean);
        localIWWAPI.a(paramau, paramWWAppType);
        com.tencent.mm.plugin.selectrecord.b.d.gUK().aiO(1);
      }
      catch (a paramau)
      {
        long l = com.tencent.mm.k.c.aRk() / 1048576L;
        k.c(paramContext, paramContext.getResources().getString(R.l.gUW, new Object[] { Long.valueOf(l) }), paramContext.getResources().getString(R.l.app_tip), true);
        com.tencent.mm.plugin.selectrecord.b.d.gUK().aiO(2);
        continue;
      }
      com.tencent.mm.plugin.selectrecord.b.d.gUK().bMH();
      AppMethodBeat.o(253768);
      return;
      paramau = a(paramContext, paramau, paramList, paramBoolean);
    }
  }
  
  private static String bAG(String paramString)
  {
    AppMethodBeat.i(253811);
    if ((!Util.isNullOrNil(paramString)) && (paramString.contains("image2"))) {
      try
      {
        Object localObject = new StringBuilder();
        if (aelM == null) {
          aelM = new File(b.bmu()).getPath() + "/Tencent/WeixinWork/share";
        }
        localObject = aelM + paramString.substring(paramString.indexOf("image2") + 6);
        String str = new File((String)localObject).getParentFile().getAbsolutePath();
        if (y.ZC((String)localObject)) {
          y.deleteFile((String)localObject);
        }
        if (!y.ZC(str)) {
          y.bDX(str);
        }
        FilesCopy.copy(paramString, (String)localObject, false);
        Log.i("MicroMsg.SendToWeWorkHelper", "getTempFilePath org:%s new:%s %s", new Object[] { paramString, localObject, Util.getStack().toString() });
        AppMethodBeat.o(253811);
        return localObject;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.SendToWeWorkHelper", "getTempFilePath(%s) Exception:%s %s", new Object[] { paramString, localException.getClass().getSimpleName(), localException.getMessage() });
      }
    }
    AppMethodBeat.o(253811);
    return paramString;
  }
  
  private static WWMediaMessage.WWMediaObject cx(cc paramcc)
  {
    AppMethodBeat.i(34925);
    if (paramcc.field_msgId > 0L) {}
    for (Object localObject1 = r.bKa().H(paramcc.field_talker, paramcc.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.modelimage.h)localObject1).localId > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (paramcc.field_msgSvrId > 0L) {
          localObject2 = r.bKa().G(paramcc.field_talker, paramcc.field_msgSvrId);
        }
      }
      if (localObject2 == null)
      {
        AppMethodBeat.o(34925);
        return null;
      }
      paramcc = r.bKa().v(com.tencent.mm.modelimage.i.c((com.tencent.mm.modelimage.h)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = bAG(paramcc);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.aq
 * JD-Core Version:    0.7.0.1
 */