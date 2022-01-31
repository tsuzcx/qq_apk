package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R.l;
import com.tencent.mm.ae.g.a;
import com.tencent.mm.as.f;
import com.tencent.mm.cb.a;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bi.b;
import com.tencent.mm.ui.base.h;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaConversation;
import com.tencent.wework.api.model.WWMediaFile;
import com.tencent.wework.api.model.WWMediaImage;
import com.tencent.wework.api.model.WWMediaLink;
import com.tencent.wework.api.model.WWMediaLocation;
import com.tencent.wework.api.model.WWMediaMergedConvs;
import com.tencent.wework.api.model.WWMediaMessage;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;
import com.tencent.wework.api.model.WWMediaText;
import com.tencent.wework.api.model.WWMediaVideo;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public final class ap
{
  private static WWMediaMessage.WWMediaObject a(ad paramad, List<bi> paramList, boolean paramBoolean)
  {
    WWMediaMergedConvs localWWMediaMergedConvs = new WWMediaMergedConvs();
    Object localObject2 = paramad.field_username;
    paramad = ae.getContext();
    if (paramBoolean) {
      paramad = paramad.getString(R.l.record_chatroom_title);
    }
    for (;;)
    {
      localWWMediaMergedConvs.title = paramad;
      paramList = paramList.iterator();
      label42:
      Object localObject1;
      if (paramList.hasNext())
      {
        localObject1 = (bi)paramList.next();
        localObject2 = new WWMediaConversation();
        if (((cs)localObject1).field_isSend == 1)
        {
          paramad = q.Gj();
          label84:
          ((WWMediaConversation)localObject2).name = r.gU(paramad);
        }
      }
      try
      {
        paramad = com.tencent.mm.ag.b.a(paramad, false, -1);
        ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
        paramad.compress(Bitmap.CompressFormat.JPEG, 100, localByteArrayOutputStream);
        ((WWMediaConversation)localObject2).xgc = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        label136:
        ((WWMediaConversation)localObject2).nFv = ((cs)localObject1).field_createTime;
        ((WWMediaConversation)localObject2).xgd = c((bi)localObject1, paramBoolean);
        if (!((WWMediaConversation)localObject2).checkArgs()) {
          break label42;
        }
        localWWMediaMergedConvs.xgf.add(localObject2);
        break label42;
        localObject1 = q.Gl();
        localObject2 = r.gU((String)localObject2);
        if (((String)localObject1).equals(localObject2))
        {
          paramad = paramad.getString(R.l.favorite_record_chatroom_title, new Object[] { localObject1 });
          continue;
        }
        paramad = paramad.getString(R.l.favorite_record_chat_title, new Object[] { localObject1, localObject2 });
        continue;
        if (!paramBoolean)
        {
          paramad = ((cs)localObject1).field_talker;
          break label84;
        }
        paramad = bd.iI(((cs)localObject1).field_content);
        break label84;
        return localWWMediaMergedConvs;
      }
      catch (Exception paramad)
      {
        break label136;
      }
    }
  }
  
  public static void a(Context paramContext, ad paramad, List<bi> paramList, boolean paramBoolean)
  {
    IWWAPI localIWWAPI = WWAPIFactory.ik(paramContext);
    try
    {
      if (paramList.size() == 1) {}
      for (paramad = c((bi)paramList.get(0), paramBoolean);; paramad = a(paramad, paramList, paramBoolean))
      {
        localIWWAPI.a(paramad);
        return;
      }
      return;
    }
    catch (ap.a paramad)
    {
      h.h(paramContext, R.l.sending_ww_file_too_large_warning, R.l.app_tip);
    }
  }
  
  private static WWMediaMessage.WWMediaObject c(bi parambi, boolean paramBoolean)
  {
    Object localObject3 = null;
    int i = parambi.getType();
    if (i == 1)
    {
      parambi = new WWMediaText(k.s(parambi.field_content, parambi.field_isSend, paramBoolean));
      return parambi;
    }
    if (i == 3) {
      if (parambi.field_msgId <= 0L) {
        break label345;
      }
    }
    label345:
    for (Object localObject1 = com.tencent.mm.as.o.OJ().bY(parambi.field_msgId);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (((com.tencent.mm.as.e)localObject1).enp > 0L) {}
      }
      else
      {
        localObject2 = localObject1;
        if (parambi.field_msgSvrId > 0L) {
          localObject2 = com.tencent.mm.as.o.OJ().bX(parambi.field_msgSvrId);
        }
      }
      parambi = localObject3;
      if (localObject2 == null) {
        break;
      }
      parambi = com.tencent.mm.as.o.OJ().o(f.c((com.tencent.mm.as.e)localObject2), "", "");
      localObject1 = new WWMediaImage();
      ((WWMediaImage)localObject1).filePath = parambi;
      y.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { ((WWMediaImage)localObject1).filePath });
      return localObject1;
      if (i == 43)
      {
        localObject1 = new WWMediaVideo();
        parambi = u.oe(parambi.field_imgPath);
        com.tencent.mm.modelvideo.o.Sr();
        ((WWMediaVideo)localObject1).filePath = t.nS(parambi.getFileName());
        y.i("MicroMsg.SendToWeWorkHelper", "send video2, path:%s", new Object[] { ((WWMediaVideo)localObject1).filePath });
        return localObject1;
      }
      if (i == 48)
      {
        localObject1 = new WWMediaLocation();
        parambi = k.s(parambi.field_content, parambi.field_isSend, paramBoolean);
        au.Hx();
        parambi = com.tencent.mm.model.c.Fy().HO(parambi);
        ((WWMediaLocation)localObject1).title = parambi.lFn;
        ((WWMediaLocation)localObject1).ekZ = parambi.label;
        ((WWMediaLocation)localObject1).longitude = parambi.lCK;
        ((WWMediaLocation)localObject1).latitude = parambi.lCJ;
        ((WWMediaLocation)localObject1).xge = parambi.bRv;
        return localObject1;
      }
      if ((i == 49) || (i == 268435505)) {
        return d(parambi, paramBoolean);
      }
      y.e("MicroMsg.SendToWeWorkHelper", "unsupport msg type: %d", new Object[] { Integer.valueOf(i) });
      return null;
    }
  }
  
  private static WWMediaMessage.WWMediaObject d(bi parambi, boolean paramBoolean)
  {
    Object localObject3 = parambi.field_content;
    Object localObject1 = localObject3;
    if (paramBoolean)
    {
      int i = parambi.field_content.indexOf(':');
      localObject1 = localObject3;
      if (i != -1) {
        localObject1 = parambi.field_content.substring(i + 1);
      }
    }
    if (localObject1 != null) {}
    label280:
    label328:
    Object localObject2;
    for (localObject1 = g.a.M((String)localObject1, parambi.field_reserved);; localObject2 = null)
    {
      if (localObject1 == null) {}
      do
      {
        do
        {
          return null;
          switch (((g.a)localObject1).type)
          {
          case 3: 
          case 4: 
          default: 
            return null;
          }
        } while ((((g.a)localObject1).bFE == null) || (((g.a)localObject1).bFE.length() <= 0));
        localObject1 = com.tencent.mm.pluginsdk.model.app.ap.avh().VQ(((g.a)localObject1).bFE);
      } while ((localObject1 == null) || (!((com.tencent.mm.pluginsdk.model.app.b)localObject1).aXY()));
      localObject1 = ((com.tencent.mm.pluginsdk.model.app.b)localObject1).field_fileFullPath;
      if (!com.tencent.mm.vfs.e.bK((String)localObject1))
      {
        y.i("MicroMsg.SendToWeWorkHelper", "Img not exist, bigImgPath: %s, msgId: %d, msgSvrId: %d", new Object[] { localObject1, Long.valueOf(parambi.field_msgId), Long.valueOf(parambi.field_msgSvrId) });
        return null;
        localObject3 = new WWMediaLink();
        ((WWMediaLink)localObject3).webpageUrl = ((g.a)localObject1).url;
        ((WWMediaLink)localObject3).title = ((g.a)localObject1).title;
        ((WWMediaLink)localObject3).description = ((g.a)localObject1).description;
        localObject1 = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, a.getDensity(null), false);
      }
      try
      {
        Object localObject4 = new ByteArrayOutputStream();
        ((Bitmap)localObject1).compress(Bitmap.CompressFormat.JPEG, 85, (OutputStream)localObject4);
        ((WWMediaMessage)localObject3).thumbData = ((ByteArrayOutputStream)localObject4).toByteArray();
        ((ByteArrayOutputStream)localObject4).close();
        try
        {
          parambi = com.tencent.mm.as.o.OJ().a(parambi.field_imgPath, a.getDensity(null), false);
          localObject1 = new ByteArrayOutputStream();
          parambi.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject1);
          ((WWMediaLink)localObject3).thumbData = ((ByteArrayOutputStream)localObject1).toByteArray();
          ((ByteArrayOutputStream)localObject1).close();
          return localObject3;
          parambi = new WWMediaImage();
          parambi.filePath = ((String)localObject1);
          y.i("MicroMsg.SendToWeWorkHelper", "send img2, path:%s", new Object[] { parambi.filePath });
          return parambi;
          localObject4 = l.VX(((g.a)localObject1).bFE);
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = com.tencent.mm.pluginsdk.model.app.ap.avh().gY(parambi.field_msgId);
          }
          if (((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_totalLen > 104857600L) {
            throw new ap.a((byte)0);
          }
          parambi = new WWMediaFile();
          parambi.fileName = ((g.a)localObject1).title;
          parambi.filePath = ((com.tencent.mm.pluginsdk.model.app.b)localObject3).field_fileFullPath;
          parambi.contentLengthLimit = 104857600;
          return parambi;
        }
        catch (Exception parambi)
        {
          break label328;
        }
      }
      catch (Exception localException)
      {
        break label280;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ap
 * JD-Core Version:    0.7.0.1
 */